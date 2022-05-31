$(function () {
    //点击添加按钮跳转至添加页面
    $("#add").on({
        click: function () {
            location.href = "add.html";
        }
    });
    // 删除数据
    $("#delectByIds").on({
        click: function () {
            // 定义一个数组来存放IDS
            var ids = [];
            //    获取所有选中的checkedbox
            var checkedBox = $("#table").find("input:checked");
            if (checkedBox.length == 0) {
                alert("请至少选中一行");
                return false;
            }
            // 遍历选中的checkedbox
            $(checkedBox).each(function () {
                if ($(this).prop("checked")) {//获取每个选中的checkedbox
                    // 先找到选中的checkedbox的行再找到每一个小块再找到列再打印内容
                    // .eq是找到需要的哪一列数据 .eq(1)是除去checkedbox以外的第一列。.text是内容
                    var id = $(this).closest('tr').find('td').eq(1).text();

                }
                // 把获得的ID数据添加到数组ids
                ids.push(id);

            })
            axios({
                method: "post",
                url: "http://localhost:8080/Flower/deleteServlet",
                data: ids
            }).then(function () {
                axios({
                    method: "get",
                    url: "http://localhost:8080/Flower/selectAllServlet"
                }).then(function (resp) {
                    //从后台获取数据
                    let bills = resp.data;
                    console.log(bills);
                    let tableDate = "<tr><th>select</th><th>id</th><th>type</th><th>data</th><th>itemsName</th><th>quantity</th><th>price</th><th>remarks</th></tr>";
                    // 遍历数据
                    for (let i = 0; i < bills.length; i++) {
                        let bill = bills[i];
                        tableDate += "\n" +
                            " <tr class='addtr'>\n" +
                            " <td><input id='allCkb' type='checkbox'></td>\n" +
                            " <td>" + bill.id + "</td>\n" +
                            " <td>" + bill.type + "</td>\n" +
                            " <td>" + bill.data + "</td>\n" +
                            " <td>" + bill.itemsName + "</td>\n" +
                            " <td>" + bill.quantity + "</td>\n" +
                            " <td>" + bill.price.toFixed(2) + "</td>\n" +
                            "<td><button id='update'>修改</button></td>\n" +
                            "</tr >"
                    }
                    document.getElementById("table").innerHTML = tableDate;
                })

                axios({
                    method: "get",
                    url: "http://localhost:8080/Flower/selectBalanceServlet"
                }).then(function (resp) {
                    //从后台获取余额数据
                    let jsonbalance = resp.data;
                    // let balance = JSON.stringify(jsonbalance);
                    console.log(jsonbalance);
                    //替换之前的数据
                    $("#balance").val($("#balance").val()).replaceWith(jsonbalance);


                })
            })
        }
    })



})
//添加数据
//当页面加载完成后，发送ajax请求
window.onload = function () {

    axios({
        method: "get",
        url: "http://localhost:8080/Flower/selectAllServlet"
    }).then(function (resp) {
        //从后台获取数据
        let bills = resp.data;
console.log(bills);
        let tableDate = "<tr><th>select</th><th>id</th><th>type</th><th>data</th><th>itemsName</th><th>quantity</th><th>price</th><th>remarks</th></tr>";
        // 遍历数据
        for (let i = 0; i < bills.length; i++) {
            let bill = bills[i];
            tableDate += "\n" +
                " <tr class='addtr'>\n" +
                " <td><input id='allCkb' type='checkbox'></td>\n" +
                " <td>" + bill.id + "</td>\n" +
                " <td>" + bill.type + "</td>\n" +
                " <td>" + bill.data + "</td>\n" +
                " <td>" + bill.itemsName + "</td>\n" +
                " <td>" + bill.quantity + "</td>\n" +
                " <td>" + bill.price.toFixed(2) + "</td>\n" +
                "<td><button id='update'>修改</button></td>\n" +
                "</tr >"
        }
        document.getElementById("table").innerHTML = tableDate;
    })

    axios({
        method: "get",
        url: "http://localhost:8080/Flower/selectBalanceServlet"
    }).then(function (resp) {
        //从后台获取余额
        let balance = resp.data;
        $("#balance").val($("#balance").val()).replaceWith(balance);

    })


    //修改数据

    $("#table").on("click", "#update", function () {

        var id = $(this).closest('tr').find('td').eq(1).text();
        axios({
            method: "post",
            url: "http://localhost:8080/Flower/selectByIdServlet",
            data: id
        }).then(function (resp) {
            let bill = resp.data;
            console.log(bill);
            //创建session存储后台得到的数据发送到updateBill页面
            sessionStorage.setItem("bills", JSON.stringify(bill));

            location.href = "updateBill.html"

        });

    })


}
