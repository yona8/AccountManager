$(function () {
   
    

//    $(".add").on({
//        click:function(){
//            var tr = $("<tr><td > <input id='allCkb' type='checkbox'></td><form action='/Flower/AddServlet' method='post'><td contenteditable='true'></td><td contenteditable='true'></td><td contenteditable='true'></td><td contenteditable='true'></td><td contenteditable='true'></td><td contenteditable='true'></td><td ><button class='remove'>删除</button><button>修改</button></td></tr></form>");
//            $("tbody").append(tr);
//        }
//    })
//

    $("#table").on("click",".remove",function(){
        $(this).parent().parent().remove();
    })


})

