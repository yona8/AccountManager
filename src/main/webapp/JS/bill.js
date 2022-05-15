$(function () {
   
    

//    $(".add").on({
//        click:function(){
//            var tr = $("<tr><td > <input id='allCkb' type='checkbox'></td><form action='/Flower/AddServlet' method='post'><td contenteditable='true'></td><td contenteditable='true'></td><td contenteditable='true'></td><td contenteditable='true'></td><td contenteditable='true'></td><td contenteditable='true'></td><td ><button class='remove'>删除</button><button>修改</button></td></tr></form>");
//            $("tbody").append(tr);
//        }
//    })
//
    $("#add").on({
       click:function(){
       location.href="add.html";
       }
     });
    $("#table").on("click",".remove",function(){
        $(this).parent().parent().remove();
    })


})
//当页面加载完成后，发送ajax请求
     window.onload = function(){
     alert("11111")
        axios({
        method:"get",
        url:"http://localhost:8080/Flower/selectAllServlet"
     }).then(function(resp){
         //从后台获取数据
     let bills = resp.data;
         let tableDate = "<tr>< th > select</> <><th>id</th><th>data</th><th>itemsName</th><th>quantity</th><th>price</th><th>remarks</th></> </tr >";
        // 遍历数据
         for(let i = 0;i <bills.length; i++){
         let bill = bills[i];
          tableDate += "\n"+
                 " <tr class='addtr'>\n"+
              " <td><input id='allCkb' type='checkbox'></td>\n"+
              " <td contenteditable='true'>" + bill.id + "</td>\n" +
              "<td contenteditable='true'>" + bill.data + "</td>\n"+
              " <td contenteditable='true'>" + bill.itemsName + "</td>\n"+
              "<td contenteditable='true'>" + bill.quantity + "</td>\n" +
              " <td contenteditable='true'>" + bill.price + "</td>\n"+
              "<td><button class='remove'>删除</button><button>修改</button></td>\n"+
           "</tr >"
     }
     document.getElementById("#table").innerHTML=tableDate;
 })
}
