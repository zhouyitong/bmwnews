$(function(){
	$(".selected").siblings().show();
	$(".main-title a").eq(1).addClass('active');
	var sechart = echarts.init(document.getElementById('second'));
	sechart.setOption({
	     	tooltip:{
					trigger:'axis',
			        formatter:'{b}点 : {c}步'
				},
				toolbox:{
					orient:'vertical',
					show:true,
					feature:{
						dataZoom:{
							yAxisIndex:'none'
						},
						dataView:{readOnly:false},
						magicType:{type:['line','bar']},
						restore:{},
						saveAsImage:{}
					},
					left:'right',
					top:'center'
				},
				legend:{
					data:[
					  {
					  	name:'运动步数'
					  }
					],
					left:'right'
				},
				xAxis:{
					type:"category",
					boundaryGap:false,
					axisLine:{
						lineStyle:{
//							color:'#ccc'
						}
					},
					data:[]
				},
				yAxis:{
					splitLine:{
						lineStyle:{
							type:'dashed'
						}
					},
					axisLine:{
						lineStyle:{
//							color:'#ccc'
						}
					}
				},
				series:[
				   {
				   	name:'运动步数',
				   	type:'line',
					   silent:true,
				   	smooth:true,
				   	showAllSymbol:'emptyCircle',
				   	symbolSize:15,
				   	data:[],
				   	itemStyle:{
				   		"normal":{
				   			color:'rgba(151,187,205,1)'				
				   		}
				   	},
				   	markPoint:{
				   		data:[
				   		  {type:'max',name:'最大值'},
				   		  {type:'min',name:'最小值'}
				   		]
				   	},
				   	markLine:{
				   		data:[
				   		   {type:'average',name:'平均值'}
				   		]
				   	},
				   	areaStyle:{
				   		normal:{
				   			color:new echarts.graphic.LinearGradient(0,0,0,1,[{
				   				offset:0,
				   				color:'rgba(151,187,205,0.5)'
				   			},{
				   				offset:1,
				   				color:'rgba(151,187,205,0.2)'
				   			}],false)
				   		}
				   	}
				   }
				]
	});
	sechart.showLoading();
			var week = [];
			var maxtemp = [];
			var url = urljs;
			var movementDate = null;
			var stop = false;
			function getData1(url){
				var movementUserid = $("#movementUserid").val();
				var type = $("#type").val();
				$.ajax({
					type:"post",
					url:url+"xywy/xmovement/xMovement/userSportAjax",
					async:true,
					data:{movementUserid: movementUserid, type: type, movementDate: movementDate},
					dataType:'json',
					success:function(result){
						if(result.status == "1"){
							week.splice(0,week.length);
							maxtemp.splice(0,maxtemp.length);
							//填充四个数据
							var info = result.data;
							var obj = $('.section dl');
							if(info[0].date!=null){
								var xMovement = result.xMovement;
								var completion =  Math.round(parseInt(xMovement.movementSteps)/parseInt(xMovement.movementStepsTarget)*100);
								obj.find('h3').eq(0).html(xMovement.movementSteps+'步');
								obj.find('h3').eq(1).html(completion+'%');
								obj.find('h3').eq(2).html(xMovement.movementCalorie+'kcal');
								obj.find('h3').eq(3).html(xMovement.movementDistance+'km');
								for(var i = 0;i < info.length;i ++){
									week.push(info[i].date);
									maxtemp.push(info[i].movementSteps);
								}
							}else{
								week.push("没有数据!");
								obj.find('h3').eq(0).html(0+'步');
								obj.find('h3').eq(1).html(0+'%');
								obj.find('h3').eq(2).html(0+'kcal');
								obj.find('h3').eq(3).html(0+'km');
								//maxtemp.push("没有数据!");
							}


							sechart.hideLoading();
							sechart.setOption({
								xAxis:{
									data:week
								},
								series:[
								   {
								   	data:maxtemp
								   }
								]
							});
							week.splice(0,week.length);
							maxtemp.splice(0,maxtemp.length);
						}
						stop  = true;
					},
					error:function(errorMsg){
						alert('图表请求失败');
						mychart.hideLoading();
					}
				});
			};
	getData1(url);
	$("#yesterday").click(function(){
		$('input[name="searchDate"]').val('');
		$(this).parent('div').find('a').removeClass('active');
		$(this).addClass("active");
			$("#type").val("1");
			getData1(url);
		sechart.setOption({
			tooltip:{
				formatter:'{b}点 : {c}步'
			}
		});
	});
	$("#today").click(function(){
		$('input[name="searchDate"]').val('');
		$(this).parent('div').find('a').removeClass('active');
		$(this).addClass("active");
			$("#type").val("0");
			getData1(url);
		sechart.setOption({
			tooltip:{
				formatter:'{b}点 : {c}步'
			}
		});
	});
	$("#week").click(function(){
		$('input[name="searchDate"]').val('');
		$(this).parent('div').find('a').removeClass('active');
		$(this).addClass("active");
			$("#type").val("2");
			getData1(url);
		sechart.setOption({
			tooltip:{
				formatter:'{b} : {c}步'
			}
		});
	});

	$("#searchDate").click(function(){
		$('input[name="searchDate"]').val('');
		$(this).parent('div').find('a').removeClass('active');
		$(this).addClass("active");
			$("#type").val("3");
			movementDate = $("#movementDate").val();
			getData1(url);
	});
})
