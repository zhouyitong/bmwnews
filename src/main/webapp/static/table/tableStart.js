$(function(){	  
	$(".table").colResizable({
		liveDrag:true,  
		draggingClass:"dragging", 
		resizeMode:'overflow'
	});
});	

/*$(function () {
	var tableCont = $('#table-cont');
	var height = $('#alltable1').find('thead tr th').height();
	tableCont.on('scroll', function(e){
		var scrollTop = $(this).scrollTop() - 1;
		$('#alltable1').find('thead tr th').css({
			height : height + 1,
	        transform : '-webkit-translateY(' + scrollTop + 'px)' ,
	        transform : '-moz-translateY(' + scrollTop + 'px)' ,
	        transform : '-o-translateY(' + scrollTop + 'px)' ,
	        transform : '-ms-translateY(' + scrollTop + 'px)' ,
			transform : 'translateY(' + scrollTop + 'px)' ,
		})  	
	})
})
*/