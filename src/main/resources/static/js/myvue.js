<script>
	var Vue1 = new Vue({
		el:"@showInfo",
		data:{
			picurl:"",
			filmTitle:"",
			score:"",
			people:"",
		},
		methods:{
			var that = this;
			mounted:function(){
				axios.get("localhost:8080/film").then
				(function(response){
					that.picurl = "/img/pic/"+response.data[0].id
				},function(err){

				})
			}
		}
	})

</script>