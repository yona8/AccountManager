var tbody = document.querySelector('tbody');

// 往tbody里面创建行，有几个人（通过数组的长度）我们就创建几行
for(var i = 0;i<datas,length;i++){
    // 创建 tr 行
    var tr = document.createElement('tr');
tbody.appendChild(tr);
// 行里面创建单元格 td 单元格的数量取决于每个对象里面的属性个数， for循环遍历对象
// for(var k in obg){
//     //k 得到的属性名
//     // obj[k]得到的是属性值
// }
for(var k in datas[i]){//里面的for循环管列 td
    var td = document.createElement('td');
    // 把对象里面的属性值给 datas[i][k]给 td
    td.innerHTML = datas[i][k];
    tr.appendChild(td);
}
// 创建最后一列删除
    var td = document.createElement('td');
    td.innerHTML = '<a href ="">删除</a>';
    tr.appendChild(td);
}

//删除操作 开始
var as = document.querySelectorAll('a');
for(var i = 0;i < as.length;i++){
    //点击 a 删除 当前a 所在的行（链接的爸爸的爸爸）node.removeChile(child)
    as[i].onclick = function(){
        tbody.removeChild(this.parentNode,parentNode)
    }
}

var xhr =new XMLHttpRequest();