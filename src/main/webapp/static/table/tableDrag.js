//拖动
Drag("alltable");
function Drag(table){
    var ochek = $('#chenkbox'),
    otable = $('#'+table),
    oth = $('#'+table).find('th'),
    otd = $('#'+table).find('td'),
    box = $('#box'),
    rows=$('#'+table +' tr'),
    arrn = [];
    for (var i = 0; i < otd.length; i++) {
        otd.eq(i).on('mousedown',function(e){
            var  _this=this,
            thW = $(_this).width(),
            maxl=ochek.width()-thW, //#chenkbox与 目标元素的宽度之差
            ckL=ochek.offset().left, //#chenkbox左边与浏览器的距离
            disX=$(_this).offset().left,
            cdisX=e.clientX-ckL-disX;//鼠标横坐标与chenkbox左边+目标元素左边之差
            for (var i = 0; i < rows.length; i++) {
                var op = $('<p></p>')
                op.html(rows.eq(i).children().eq(_this.cellIndex).html()); 
                box.append(op);
            };    
            for (var i = 0; i < oth.length; i++) {
                arrn.push(oth.eq(i).offset().left);      
            }; 
            box.css({
                display:'block',
                width:thW + "px",
                left:disX + "px"
            });
            document.onmousemove=function(e){ //绑定 onmousemove 事件
                var e=e||window.event,
                target = e.target||e.srcElement,
                thW = target.offsetWidth; 
                box.css({
                    top:0,
                    left:e.clientX-ckL-cdisX+"px"
                }); 
                if(box.position().left>maxl){
                    box.position().left=maxl+"px";
                }else if(box.position().left<0){
                    box.position().left=0;
                }   
                //禁止鼠标选中文字 
                document.onselectstart=function(){
                    return false;
                }; 
                //判断浏览器是否包含 getSelection 属性,并清除选中内容
                if('getSelection' in window){//清除选中的内容
                    window.getSelection().removeAllRanges();
                }else{
                    document.selection.empty();//IE
                }
            }
            document.onmouseup=function(e){
            	//绑定鼠标松开事件
                opr=$('#box p'),
                oboxl=box.position().left+cdisX;
                for (var i = 0; i < arrn.length; i++) {
                    if(arrn[i]<oboxl){
                        var index=i;
                    }
                };
                for (var i = 0; i < rows.length; i++) {
                    rows.eq(i).children().eq(_this.cellIndex).html('');
                    rows.eq(i).children().eq(_this.cellIndex).html(rows.eq(i).children().eq(index).html());
                    rows.eq(i).children().eq(index).html('');
                    rows.eq(i).children().eq(index).html(opr.eq(i).html());
                }
                box.html('');
                arrn.splice(0,arrn.length);
                box.css({display:'none'});
                document.onmousemove=null; 
                document.onmouseup=null;
                document.onselectstart=function(){
                    return false;
                };     
            }
        });
    } 
}
