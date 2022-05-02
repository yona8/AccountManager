window.onload=function(){
    // // 用户登录表单校验
    function checkLogin() {
        // 1.获取用户名称和密码
        var userName = $("#userName").val();
        var userPwd = $("#userPwd").val();
    //     // 2.判断用户名或密码是否为空
        if (isEmpty(userName)) {
            $("#msg").html("用户名称不能为空");
            return;
        }
        if (isEmpty(userPwd)) {
            $("#msg").html("用户密码不能为空");
            return;
        }
    //     // 3.如果不为空，提交表单
        $("#loginForm").submit();

    }

    //当输入框失去焦点时，验证输入内容是否符合要求

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
        var flag = username.length >= 6 && username.length <= 12;
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

//    //  1.获取表单输入框
//    var telInput = document.getElementById("tel");
//    //  2.绑定onblur事件
//    telInput.onblur = checkTel;
//    function checkTel() {
//        //  3.获取输入内容  .trim可以排除空字符串
//        var tel = telInput.value.trim();
//        //  4.判断手机号是否符合规则：长度为11，数字组成，第一位是1
//        var reg = /^[1]\d{10}$/;
//        var flag = reg.test(tel);
//
//        if (flag) {
//            document.getElementById("tel_err").style.display = 'none';
//        } else {
//            //  5.如果不符合规则，则显示错误提示信息
//            document.getElementById("tel_err").style.display = '';
//        }
//        return flag;
//    }



    //点击注册按钮时，判断所有输入框的内容是否都符合要求，如果不符合则阻止表单提交
    //1.获取表单对象
    var refForm = document.getElementById("reg_btn");
    // 2.为表单对象绑定onsubmit
    refForm.onsubmit = function () {
        //挨个判断每一个表单项是否都符合要求，如果有一个不符合，则返回false 
//        checkUsername() && checkPassword() && checkTel();
checkUsername() && checkPassword();
    }
}