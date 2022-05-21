$(function () {
  
// axios({
//     method:"post",
//     url:"http://localhost:8080/Flower/selectAllServlet"
// }).then(function(resp){
//     if(resp.data){
//         alert("添加成功")
//  this.$message({
//      message:'添加成功',
//      type:'success'
//  })
//     }
// })
var date=document.getElementById("date");
    var itemsName = document.getElementById("itemsName");
    
    function checkItemsName(){
        var flag = itemsName.value !== null && itemsName.value.trim() !== "";
    if (flag) {
        return false;
    }
    return flag;
    }
    
    function checkDate(){
        var flag = date.value !== null && date.value.trim() !== "";
        if (flag) {
        return false;
        } 
        return flag;
    }
    //  1.获取表单输入框
    var quantityInput = document.getElementById("quantity");
    var value = quantityInput.value.trim();//js实现去除首尾空格
    var quantity = Number(value)//将字符串转换为数字

    //  2.绑定onblur事件
    quantityInput.onblur = checkQuantity;

    function checkQuantity() {

        //  4.判断是否符合规则
        if (isNaN(quantity)) {
            // 如果不符合规则，则显示错误提示信息
            document.getElementById("quantity_err").style.display = '';

        } else if (quantity === '' || quantity === null) {  //空字符串和null都会被当做数字
            document.getElementById("quantity_err").style.display = '';
        } else {
            return true
        }
    }
    //  1.获取表单输入框
    var priceInput = document.getElementById("price");
    var value = priceInput.value.trim();//js实现去除首尾空格
    var price = Number(value)//将字符串转换为数字
    //  2.绑定onblur事件
    priceInput.onblur = checkPrice;

    function checkPrice() {

        //  4.判断是否符合规则
        if (isNaN(price)) {
            // 如果不符合规则，则显示错误提示信息
            document.getElementById("price_err").style.display = '';

        } else if (price == '' || price == null) {  //空字符串和null都会被当做数字
            document.getElementById("price_err").style.display = '';
        } else {
            return true
        }
    }
   
    // 注意：这里是获取表单对象
    var addForm = document.getElementById("add-form");
    //    表单对象提交时
    addForm.onsubmit = function () {
        //    同时为true提交
        var flag = checkQuantity() && checkPrice() && checkItemsName() && checkDate();
        return flag;
    }
})