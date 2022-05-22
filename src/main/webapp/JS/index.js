window.onload = function () {
    // 用户名check
    //  1.获取表单输入框
    var userNameInput = document.getElementById("userName");
    //  2.绑定onblur事件
    userNameInput.onblur = checkuserName;

    function checkuserName() {
        //  3.获取输入内容  .trim可以排除空字符串
        var userName = userNameInput.value.trim();
        //  4.判断是否符合规则
        // var reg = /^\w{6,12}$/;
        // var flag = reg.test(userName);
        var flag = userName.length >= 2 && userName.length <= 12;
        if (flag) {
            document.getElementById("username_err").style.display = 'none';
        } else {
            //  5.如果不符合规则，则显示错误提示信息
            document.getElementById("username_err").style.display = '';
            
        }
        return flag;
    }
        
// 密码check 
    //  1.获取表单输入框
    var userPwdInput = document.getElementById("userPwd");
    //  2.绑定onblur事件
    userPwdInput.onblur = checkuserPwd;
    function checkuserPwd() {
        //  3.获取输入内容  .trim可以排除空字符串
        var password = userPwdInput.value.trim();
        //  4.判断是否符合规则
        var reg = /^\w{2,6}$/;
        var flag = reg.test(password);
        // var flag = password.length >= 2 && password.length <= 6;
        if (flag) {
            document.getElementById("password_err").style.display = 'none';
        } else {
            //  5.如果不符合规则，则显示错误提示信息
            document.getElementById("password_err").style.display = '';
          
        }
        return flag;
    }
    // // 注意：这里是获取表单对象
    // var loginForm = document.getElementById("loginForm");
    // //    表单对象提交时
    // loginForm.onsubmit = function () {
    //     //    同时为true提交
    //     var flag = checkuserName() && checkuserPwd();
    //     return flag;
    // }
}
   
