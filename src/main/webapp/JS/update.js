$(function () {
    var bill = JSON.parse(sessionStorage.getItem("bills"));
    console.log(bill);
   
    // // 遍历数据
    for (let i = 0; i < bill.length; i++) {
        let bills = bill[i];
        $("#data").val($("#data").val() + bills.data);
        $("#itemsName").val($("#itemsName").val() + bills.itemsName);
        $("#quantity").val($("#quantity").val() + bills.quantity);
        $("#price").val($("#price").val() + bills.price);

    }



})
