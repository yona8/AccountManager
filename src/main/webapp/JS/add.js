$(function () {
    alert("11111")
axios({
    method:"post",
    url:"http://localhost:8080/Flower/selectAllServlet"
}).then(function(resp){
    if(resp.data){
        alert("添加成功")
 this.$message({
     message:'添加成功',
     type:'success'
 })
    }
})
})