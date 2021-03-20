# laobamovie
final design

采用springboot做后端 渲染thymeleaf 在html中引用vue,axios,构建前后端分离的电影系统.
通过收集用户对电影的评分(user_id,movie_id,score) 进行协同过滤推荐,采用spark mil中的als算法.
hadoop2.7(伪分布式),spark2.3,python3.6.5, mysql5.17
