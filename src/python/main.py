# coding=utf-8
import findspark
findspark.init()
import time
from pyspark.sql import  SparkSession
from pyspark.mllib.recommendation import ALS
def alsrecommend(n):
    # spark 初始化
    spark = SparkSession.Builder().appName('sql').master('local').getOrCreate()
    # mysql 配置(需要修改)
    prop = {'user': 'root',
            'password': '123456',
            'driver': 'com.mysql.jdbc.Driver'}
    # database 地址(需要修改)
    url = 'jdbc:mysql://192.168.222.3:3306/laoba'
    # 读取表
    data = spark.read.jdbc(url=url, table='score', properties=prop)
    scoreData = data.createOrReplaceTempView("scoredata")
    result = spark.sql("select user_id,film_id,score from scoredata")
    users = spark.sql("select user_id from scoredata")
    users = [int(row.user_id)for row in users.distinct().collect()]
    #print(users)
    score = result.rdd.map(lambda x :(x[0],x[1],x[2]))
    #score.take(10)
    model = ALS.train(score,20,25,0.01)

    recresult = []
    for i in users:
        recresult.extend(model.recommendProducts(i,10))
    #print(recresult)
    a =1
    resultdata =[]
    for row in recresult:
        resultdata.append((a,row.user,row.product,round(row.rating,2)))
        a+=1

    #resultdata = [(row.index,row.user,row.product,round(row.rating, 2)) for row in recresult]
    #print(resultdata)
    #print(len(resultdata))
    result_df = spark.createDataFrame(resultdata,schema=["id","user_id","movie_id","rating"])
    #result_df.show()
    result_df.write.jdbc(url=url,table="recommend",mode="overwrite",properties=prop)
    spark.stop()
    print("Already running...........%d"%n)
    time.sleep(10)

for i in range(1,99):
    alsrecommend(i)
