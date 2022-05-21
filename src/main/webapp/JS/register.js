window.onload = function () {

    //  1.获取表单输入框
    var usernameInput = document.getElementById("username");
    //  2.绑定onblur事件
    usernameInput.onblur = checkUsername;

    function checkUsername() {
        //  3.获取输入内容  .trim可以排除空字符串
        var username = usernameInput.value.trim();
        //  4.判断是否符合规则
        // var reg = /^\w{6,12}$/;
        // var flag = reg.test(username);
        var flag = username.length >= 2 && username.length <= 6;
        if (flag) {
            document.getElementById("username_err").style.display = 'none';
        } else {
            //  5.如果不符合规则，则显示错误提示信息
            document.getElementById("username_err").style.display = '';

        }
        return flag;
    }

    //  1.获取表单输入框
    var passwordInput = document.getElementById("password");
    //  2.绑定onblur事件
    passwordInput.onblur = checkPassword;
    function checkPassword() {
        //  3.获取输入内容  .trim可以排除空字符串
        var password = passwordInput.value.trim();
        //  4.判断是否符合规则
        var reg = /^\w{6,12}$/;
        var flag = reg.test(password);
        if (flag) {
            document.getElementById("password_err").style.display = 'none';
        } else {
            //  5.如果不符合规则，则显示错误提示信息
            document.getElementById("password_err").style.display = '';

        }
        return flag;
    }
    // 注意：这里是获取表单对象
    var redForm = document.getElementById("reg-form");
    //    表单对象提交时
    redForm.onsubmit = function () {
        //    同时为true提交
        var flag = checkUsername() && checkPassword();
        return flag;
    }

}