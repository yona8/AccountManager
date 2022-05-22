$(function () {
  
    //  1.获取表单输入框
    var quantityInput = document.getElementById("quantity");
    var value = quantityInput.value.trim();//js实现去除首尾空格
    var quantity = Number(value)//将字符串转换为数字

    //  2.绑定onblur事件
    quantityInput.onblur = checkQuantity;

    function checkQuantity() {
        var flag = quantity !== '' || quantity !== null;
        //  4.判断是否符合规则
        if (isNaN(quantity)) {
            // 如果不符合规则，则显示错误提示信息
            document.getElementById("quantity_err").style.display = '';
           
        } else if (flag) {  //空字符串和null都会被当做数字
            return flag;
        } else {
            document.getElementById("quantity_err").style.display = '';
        }
    }
    //  1.获取表单输入框
    var priceInput = document.getElementById("price");
    var value = priceInput.value.trim();//js实现去除首尾空格
    var price = Number(value)//将字符串转换为数字
    //  2.绑定onblur事件
    priceInput.onblur = checkPrice;

    function checkPrice() {
        var flag = price !== '' || price !== null
        //  4.判断是否符合规则
        if (isNaN(price)) {
            // 如果不符合规则，则显示错误提示信息
            document.getElementById("price_err").style.display = '';

        } else if (flag) {  //空字符串和null都会被当做数字
            return flag;
        } else {
            document.getElementById("price_err").style.display = '';
        }
    }
   
})