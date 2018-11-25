<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>图标选择</title>
	<meta name="decorator" content="blank"/>
    <style type="text/css">
    	.page-header {clear:both;margin:0 20px;padding-top:20px;}
		.the-icons {padding:25px 10px 15px;list-style:none;}
		.the-icons li {float:left;width:22%;line-height:25px;margin:2px 5px;cursor:pointer;}
		.the-icons i {margin:1px 5px;font-size:16px;} .the-icons li:hover {background-color:#efefef;}
        .the-icons li.active {background-color:#0088CC;color:#ffffff;}
        .the-icons li:hover i{font-size:20px;}
    </style>
    <script type="text/javascript">
	    $(document).ready(function(){
	    	$("#icons li").click(function(){
	    		$("#icons li").removeClass("active");
	    		$("#icons li i").removeClass("icon-white");
	    		$(this).addClass("active");
	    		$(this).children("i").addClass("icon-white");
	    		$("#icon").val($(this).text());
	    	});
	    	$("#icons li").each(function(){
	    		if ($(this).text()=="${value}"){
	    			$(this).click();
	    		}
	    	});
	    	$("#icons li").dblclick(function(){
	    		top.$.jBox.getBox().find("button[value='ok']").trigger("click");
	    	});
	    });
    </script>
</head>
<body>
<input type="hidden" id="icon" value="${value}" />
<div id="icons">
<h2 class="page-header"> 自定义一级菜单图标</h2>
  		<ul class="the-icons clearfix">
  			<li><i class="icon-uniE0001"></i> icon-uniE0001 </li> 
  			<li><i class="icon-uniE0007"></i> icon-uniE0007 </li> 
  			<li><i class="icon-uniE0009"></i> icon-uniE0009 </li> 
  			<li><i class="icon-uniE00015"></i> icon-uniE00015 </li> 
  			<li><i class="icon-uniE00020"></i> icon-uniE00020 </li> 
  			<li><i class="icon-uniE00026"></i> icon-uniE00026 </li> 
  			<li><i class="icon-uniE00027"></i> icon-uniE00027 </li> 
  		</ul>
  		<h2 class="page-header"> 自定义二级菜单图标</h2>
  		<ul class="the-icons clearfix">
  			<li><i class="icon-uniE0002"></i> icon-uniE0002 </li> 
  			<li><i class="icon-uniE0003"></i> icon-uniE0003 </li> 
  			<li><i class="icon-uniE0004"></i> icon-uniE0004 </li> 
  			<li><i class="icon-uniE0005"></i> icon-uniE0005 </li> 
  			<li><i class="icon-uniE0006"></i> icon-uniE0006 </li> 
  			<li><i class="icon-uniE0008"></i> icon-uniE0008 </li> 		
  			<li><i class="icon-uniE00010"></i> icon-uniE00010 </li> 
  			<li><i class="icon-uniE00011"></i> icon-uniE00011 </li> 
  			<li><i class="icon-uniE00012"></i>icon-uniE00012 </li> 
  			<li><i class="icon-uniE00013"></i> icon-uniE00013</li> 
  			<li><i class="icon-uniE00014"></i> icon-uniE00014 </li> 
  			<li><i class="icon-uniE00016"></i> icon-uniE00016 </li> 
  			<li><i class="icon-uniE00017"></i> icon-uniE00017 </li> 
  			<li><i class="icon-uniE00018"></i> icon-uniE00018 </li> 
  			<li><i class="icon-uniE00019"></i> icon-uniE00019 </li> 
  			<li><i class="icon-uniE00021"></i> icon-uniE00021 </li> 
  			<li><i class="icon-uniE00022"></i> icon-uniE00022 </li> 
  			<li><i class="icon-uniE00023"></i> icon-uniE00023 </li> 
  			<li><i class="icon-uniE00024"></i> icon-uniE00024 </li> 
  			<li><i class="icon-uniE00025"></i> icon-uniE00025 </li> 
  			<li><i class="icon-uniE00028"></i> icon-uniE00028 </li> 
  			<li><i class="icon-uniE00029">
  					<span class="path1"></span><span class="path2"></span><span class="path3"></span><span class="path4"></span><span class="path5"></span><span class="path6"></span><span class="path7"></span><span class="path8"></span>
  				</i> icon-uniE00029 
  			</li>
  			<li><i class="icon-uniE00030"></i> icon-uniE00030 </li> 
  			<li><i class="icon-uniE00031"></i> icon-uniE00031 </li> 
  			<li><i class="icon-uniE00032"></i> icon-uniE00032 </li> 
  			<li><i class="icon-uniE00033"></i> icon-uniE00033 </li> 
  			<li><i class="icon-uniE00034"></i> icon-uniE00034 </li> 
  			<li><i class="icon-uniE00035"></i> icon-uniE00035 </li>
  		</ul>
  		<h2 class="page-header"> 系统默认菜单图标</h2>
  		<ul class="the-icons clearfix">
	     	<li><i class="icon-uniF000"></i> icon-uniF000 </li>
            <li><i class="icon-uniF001"></i> icon-uniF001 </li> 
            <li><i class="icon-uniF002"></i> icon-uniF002 </li>
			<li><i class="icon-uniF003"></i> icon-uniF003 </li>
            <li><i class="icon-uniF004"></i> icon-uniF004 </li>
			<li><i class="icon-uniF005"></i> icon-uniF005 </li>
            <li><i class="icon-uniF006"></i> icon-uniF006 </li>
           	<li><i class="icon-uniF007"></i> icon-uniF007 </li>
           	<li><i class="icon-uniF0E8"></i> icon-uniF0E8 </li>
        	<li><i class="icon-uniF008"></i> icon-uniF008 </li>
            <li><i class="icon-uniF009"></i> icon-uniF009 </li>
            <li><i class="icon-uniF00A"></i> icon-uniF00A </li>
            <li><i class="icon-uniF00B"></i> icon-uniF00B </li>
            <li><i class="icon-uniF00C"></i> icon-uniF00C </li>
            <li><i class="icon-uniF00D"></i> icon-uniF00D </li>
            <li><i class="icon-uniF00E"></i> icon-uniF00E </li>
            <li><i class="icon-uniF010"></i> icon-uniF010 </li>
            <li><i class="icon-uniF011"></i> icon-uniF011 </li>
            <li><i class="icon-uniF012"></i> icon-uniF012 </li>
            <li><i class="icon-uniF013"></i> icon-uniF013 </li>
            <li><i class="icon-uniF014"></i> icon-uniF014 </li>
            <li><i class="icon-uniF015"></i> icon-uniF015 </li>
            <li><i class="icon-uniF016"></i> icon-uniF016 </li>
            <li><i class="icon-uniF017"></i> icon-uniF017 </li>
            <li><i class="icon-uniF018"></i> icon-uniF018 </li>
            <li><i class="icon-uniF019"></i> icon-uniF019 </li>
            <li><i class="icon-uniF01A"></i> icon-uniF01A </li>
            <li><i class="icon-uniF01B"></i> icon-uniF01B </li>
            <li><i class="icon-uniF01C"></i> icon-uniF01C </li>
            <li><i class="icon-uniF01D"></i> icon-uniF01D </li>
            <li><i class="icon-uniF01E"></i> icon-uniF01E </li>
            <li><i class="icon-uniF021"></i> icon-uniF021 </li>
            <li><i class="icon-uniF022"></i> icon-uniF022 </li>
            <li><i class="icon-uniF023"></i> icon-uniF023 </li>
            <li><i class="icon-uniF024"></i> icon-uniF024 </li>
            <li><i class="icon-uniF025"></i> icon-uniF025 </li>
            <li><i class="icon-uniF026"></i> icon-uniF026 </li>
            <li><i class="icon-uniF027"></i> icon-uniF027 </li>
            <li><i class="icon-uniF028"></i> icon-uniF028 </li>
            <li><i class="icon-uniF029"></i> icon-uniF029 </li>
            <li><i class="icon-uniF02A"></i> icon-uniF02A </li>
            <li><i class="icon-uniF02B"></i> icon-uniF02B </li>
            <li><i class="icon-uniF02C"></i> icon-uniF02C </li>
            <li><i class="icon-uniF02D"></i> icon-uniF02D </li>
            <li><i class="icon-uniF02E"></i> icon-uniF02E </li>
            <li><i class="icon-uniF02F"></i> icon-uniF02F </li>
            <li><i class="icon-uniF030"></i> icon-uniF030 </li>
            <li><i class="icon-uniF031"></i> icon-uniF031 </li>
            <li><i class="icon-uniF032"></i> icon-uniF032 </li>
            <li><i class="icon-uniF033"></i> icon-uniF033 </li>
            <li><i class="icon-uniF034"></i> icon-uniF034 </li>
            <li><i class="icon-uniF035"></i> icon-uniF035 </li>
            <li><i class="icon-uniF036"></i> icon-uniF036 </li>
            <li><i class="icon-uniF037"></i> icon-uniF037 </li>
            <li><i class="icon-uniF038"></i> icon-uniF038 </li>
            <li><i class="icon-uniF039"></i> icon-uniF039 </li>
            <li><i class="icon-uniF03A"></i> icon-uniF03A </li>
            <li><i class="icon-uniF03B"></i> icon-uniF03B </li>
            <li><i class="icon-uniF03C"></i> icon-uniF03C </li>
            <li><i class="icon-uniF03D"></i> icon-uniF03D </li>
            <li><i class="icon-uniF03E"></i> icon-uniF03E </li>
            <li><i class="icon-uniF040"></i> icon-uniF040 </li>
            <li><i class="icon-uniF041"></i> icon-uniF041 </li>
            <li><i class="icon-uniF042"></i> icon-uniF042 </li>
            <li><i class="icon-uniF043"></i> icon-uniF043 </li>
            <li><i class="icon-uniF044"></i> icon-uniF044 </li>
            <li><i class="icon-uniF045"></i> icon-uniF045 </li>
            <li><i class="icon-uniF046"></i> icon-uniF046 </li>
            <li><i class="icon-uniF047"></i> icon-uniF047 </li>
            <li><i class="icon-uniF048"></i> icon-uniF048 </li>
            <li><i class="icon-uniF049"></i> icon-uniF049 </li>
            <li><i class="icon-uniF04A"></i> icon-uniF04A </li>
            <li><i class="icon-uniF04B"></i> icon-uniF04B </li>
            <li><i class="icon-uniF04C"></i> icon-uniF04C </li>
            <li><i class="icon-uniF04D"></i> icon-uniF04D </li>
            <li><i class="icon-uniF04E"></i> icon-uniF04E </li>
            <li><i class="icon-uniF050"></i> icon-uniF050 </li>
            <li><i class="icon-uniF051"></i> icon-uniF051 </li>
            <li><i class="icon-uniF052"></i> icon-uniF052 </li>
            <li><i class="icon-uniF053"></i> icon-uniF053 </li>
            <li><i class="icon-uniF054"></i> icon-uniF054 </li>
            <li><i class="icon-uniF055"></i> icon-uniF055 </li>
            <li><i class="icon-uniF056"></i> icon-uniF056 </li>
            <li><i class="icon-uniF057"></i> icon-uniF057 </li>
            <li><i class="icon-uniF058"></i> icon-uniF058 </li>
            <li><i class="icon-uniF059"></i> icon-uniF059 </li>
            <li><i class="icon-uniF05A"></i> icon-uniF05A </li>
            <li><i class="icon-uniF05B"></i> icon-uniF05B </li>
            <li><i class="icon-uniF05C"></i> icon-uniF05C </li>
            <li><i class="icon-uniF05D"></i> icon-uniF05D </li>
            <li><i class="icon-uniF05E"></i> icon-uniF05E </li>
            <li><i class="icon-uniF060"></i> icon-uniF060 </li>
            <li><i class="icon-uniF061"></i> icon-uniF061 </li>
            <li><i class="icon-uniF062"></i> icon-uniF062 </li>
            <li><i class="icon-uniF063"></i> icon-uniF063 </li>
            <li><i class="icon-uniF064"></i> icon-uniF064 </li>
            <li><i class="icon-uniF065"></i> icon-uniF065 </li>
            <li><i class="icon-uniF066"></i> icon-uniF066 </li>
            <li><i class="icon-uniF067"></i> icon-uniF067 </li>
            <li><i class="icon-uniF068"></i> icon-uniF068 </li>
            <li><i class="icon-uniF069"></i> icon-uniF069 </li>
            <li><i class="icon-uniF06A"></i> icon-uniF06A </li>
            <li><i class="icon-uniF06B"></i> icon-uniF06B </li>
            <li><i class="icon-uniF06C"></i> icon-uniF06C </li>
            <li><i class="icon-uniF06D"></i> icon-uniF06D </li>
            <li><i class="icon-uniF06E"></i> icon-uniF06E </li>
            <li><i class="icon-uniF070"></i> icon-uniF070 </li>
            <li><i class="icon-uniF071"></i> icon-uniF071 </li>
            <li><i class="icon-uniF072"></i> icon-uniF072 </li>
            <li><i class="icon-uniF073"></i> icon-uniF073 </li>
            <li><i class="icon-uniF074"></i> icon-uniF074 </li>
            <li><i class="icon-uniF075"></i> icon-uniF075 </li>
            <li><i class="icon-uniF076"></i> icon-uniF076 </li>
            <li><i class="icon-uniF077"></i> icon-uniF077 </li>
            <li><i class="icon-uniF078"></i> icon-uniF078 </li>
            <li><i class="icon-uniF079"></i> icon-uniF079 </li>
            <li><i class="icon-uniF07A"></i> icon-uniF07A </li>
            <li><i class="icon-uniF07B"></i> icon-uniF07B </li>
            <li><i class="icon-uniF07C"></i> icon-uniF07C </li>
            <li><i class="icon-uniF07D"></i> icon-uniF07D </li>
            <li><i class="icon-uniF07E"></i> icon-uniF07E </li>
            <li><i class="icon-uniF080"></i> icon-uniF080 </li>
            <li><i class="icon-uniF081"></i> icon-uniF081 </li>
            <li><i class="icon-uniF082"></i> icon-uniF082 </li>
            <li><i class="icon-uniF083"></i> icon-uniF083 </li>
            <li><i class="icon-uniF084"></i> icon-uniF084 </li>
            <li><i class="icon-uniF085"></i> icon-uniF085 </li>
            <li><i class="icon-uniF086"></i> icon-uniF086 </li>
            <li><i class="icon-uniF087"></i> icon-uniF087 </li>
            <li><i class="icon-uniF088"></i> icon-uniF088 </li>
            <li><i class="icon-uniF089"></i> icon-uniF089 </li>
            <li><i class="icon-uniF08A"></i> icon-uniF08A </li>
            <li><i class="icon-uniF08B"></i> icon-uniF08B </li>
            <li><i class="icon-uniF08C"></i> icon-uniF08C </li>
            <li><i class="icon-uniF08D"></i> icon-uniF08D </li>
            <li><i class="icon-uniF08E"></i> icon-uniF08E </li>
            <li><i class="icon-uniF090"></i> icon-uniF090 </li>
            <li><i class="icon-uniF091"></i> icon-uniF091 </li>
            <li><i class="icon-uniF092"></i> icon-uniF092 </li>
            <li><i class="icon-uniF093"></i> icon-uniF093 </li>
            <li><i class="icon-uniF094"></i> icon-uniF094 </li>
            <li><i class="icon-uniF095"></i> icon-uniF095 </li>
            <li><i class="icon-uniF096"></i> icon-uniF096 </li>
            <li><i class="icon-uniF097"></i> icon-uniF097 </li>
            <li><i class="icon-uniF098"></i> icon-uniF098 </li>
            <li><i class="icon-uniF099"></i> icon-uniF099 </li>
         	<li><i class="icon-uniF09A"></i> icon-uniF09A </li>
            <li><i class="icon-uniF09B"></i> icon-uniF09B </li>
            <li><i class="icon-uniF09C"></i> icon-uniF09C </li>
            <li><i class="icon-uniF09D"></i> icon-uniF09D </li>
            <li><i class="icon-uniF09E"></i> icon-uniF09E </li>
            <li><i class="icon-uniF0A0"></i> icon-uniF0A0 </li>
            <li><i class="icon-uniF0A1"></i> icon-uniF0A1 </li>
            <li><i class="icon-uniF0A2"></i> icon-uniF0A2 </li>
            <li><i class="icon-uniF0A3"></i> icon-uniF0A3 </li>
            <li><i class="icon-uniF0A4"></i> icon-uniF0A4 </li>
            <li><i class="icon-uniF0A5"></i> icon-uniF0A5 </li>
            <li><i class="icon-uniF0A6"></i> icon-uniF0A6 </li>
            <li><i class="icon-uniF0A7"></i> icon-uniF0A7 </li>
            <li><i class="icon-uniF0A8"></i> icon-uniF0A8 </li>
            <li><i class="icon-uniF0A9"></i> icon-uniF0A9 </li>
            <li><i class="icon-uniF0AA"></i> icon-uniF0AA </li>
            <li><i class="icon-uniF0AB"></i> icon-uniF0AB </li>
            <li><i class="icon-uniF0AC"></i> icon-uniF0AC </li>
            <li><i class="icon-uniF0AD"></i> icon-uniF0AD </li>
            <li><i class="icon-uniF0AE"></i> icon-uniF0AE </li>
            <li><i class="icon-uniF0B0"></i> icon-uniF0B0 </li>
            <li><i class="icon-uniF0B1"></i> icon-uniF0B1 </li>
            <li><i class="icon-uniF0B2"></i> icon-uniF0B2 </li>
            <li><i class="icon-uniF0C0"></i> icon-uniF0C0 </li>
            <li><i class="icon-uniF0C1"></i> icon-uniF0C1 </li>
            <li><i class="icon-uniF0C2"></i> icon-uniF0C2 </li>
            <li><i class="icon-uniF0C3"></i> icon-uniF0C3 </li>
            <li><i class="icon-uniF0C4"></i> icon-uniF0C4 </li>
            <li><i class="icon-uniF0C5"></i> icon-uniF0C5 </li>
            <li><i class="icon-uniF0C6"></i> icon-uniF0C6 </li>
            <li><i class="icon-uniF0C7"></i> icon-uniF0C7 </li>
            <li><i class="icon-uniF0C8"></i> icon-uniF0C8 </li>
            <li><i class="icon-uniF0C9"></i> icon-uniF0C9 </li>
            <li><i class="icon-uniF0CA"></i> icon-uniF0CA </li>
            <li><i class="icon-uniF0CB"></i> icon-uniF0CB </li>
            <li><i class="icon-uniF0CC"></i> icon-uniF0CC </li>
            <li><i class="icon-uniF0CD"></i> icon-uniF0CD </li>
            <li><i class="icon-uniF0CE"></i> icon-uniF0CE </li>
            <li><i class="icon-uniF0D0"></i> icon-uniF0D0 </li>
            <li><i class="icon-uniF0D1"></i> icon-uniF0D1 </li>
            <li><i class="icon-uniF0D2"></i> icon-uniF0D2 </li>
            <li><i class="icon-uniF0D3"></i> icon-uniF0D3 </li>
            <li><i class="icon-uniF0D4"></i> icon-uniF0D4 </li>
            <li><i class="icon-uniF0D5"></i> icon-uniF0D5 </li>
            <li><i class="icon-uniF0D6"></i> icon-uniF0D6 </li>
            <li><i class="icon-uniF0D7"></i> icon-uniF0D7 </li>
            <li><i class="icon-uniF0D8"></i> icon-uniF0D8 </li>
            <li><i class="icon-uniF0D9"></i> icon-uniF0D9 </li>
            <li><i class="icon-uniF0DA"></i> icon-uniF0DA </li>
            <li><i class="icon-uniF0DB"></i> icon-uniF0DB </li>
            <li><i class="icon-uniF0DC"></i> icon-uniF0DC </li>
            <li><i class="icon-uniF0DD"></i> icon-uniF0DD </li>
            <li><i class="icon-uniF0DE"></i> icon-uniF0DE </li>
            <li><i class="icon-uniF0E0"></i> icon-uniF0E0 </li>
            <li><i class="icon-uniF0E1"></i> icon-uniF0E1 </li>
            <li><i class="icon-uniF0E2"></i> icon-uniF0E2 </li>
            <li><i class="icon-uniF0E3"></i> icon-uniF0E3 </li>
            <li><i class="icon-uniF0E4"></i> icon-uniF0E4 </li>
            <li><i class="icon-uniF0E5"></i> icon-uniF0E5 </li>
            <li><i class="icon-uniF0E6"></i> icon-uniF0E6 </li>
            <li><i class="icon-uniF0E7"></i> icon-uniF0E7 </li>
          
            <li><i class="icon-uniF0E9"></i> icon-uniF0E9 </li>
            <li><i class="icon-uniF0EA"></i> icon-uniF0EA </li>
            <li><i class="icon-uniF0EB"></i> icon-uniF0EB </li>
            <li><i class="icon-uniF0EC"></i> icon-uniF0EC </li>
            <li><i class="icon-uniF0ED"></i> icon-uniF0ED </li>
            <li><i class="icon-uniF0EE"></i> icon-uniF0EE </li>
            <li><i class="icon-uniF0F0"></i> icon-uniF0F0 </li>
            <li><i class="icon-uniF0F1"></i> icon-uniF0F1 </li>
            <li><i class="icon-uniF0F2"></i> icon-uniF0F2 </li>
            <li><i class="icon-uniF0F3"></i> icon-uniF0F3 </li>
            <li><i class="icon-uniF0F4"></i> icon-uniF0F4 </li>
            <li><i class="icon-uniF0F5"></i> icon-uniF0F5 </li>
            <li><i class="icon-uniF0F6"></i> icon-uniF0F6 </li>
            <li><i class="icon-uniF0F7"></i> icon-uniF0F7 </li>
            <li><i class="icon-uniF0F8"></i> icon-uniF0F8 </li>
            <li><i class="icon-uniF0F9"></i> icon-uniF0F9 </li>
            <li><i class="icon-uniF0FA"></i> icon-uniF0FA </li>
            <li><i class="icon-uniF0FB"></i> icon-uniF0FB </li>
            <li><i class="icon-uniF0FC"></i> icon-uniF0FC </li>
            <li><i class="icon-uniF0FD"></i> icon-uniF0FD </li>
            <li><i class="icon-uniF0FE"></i> icon-uniF0FE </li>
            <li><i class="icon-uniF100"></i> icon-uniF100 </li>
            <li><i class="icon-uniF101"></i> icon-uniF101 </li>
            <li><i class="icon-uniF102"></i> icon-uniF102 </li>
            <li><i class="icon-uniF103"></i> icon-uniF103 </li>
            <li><i class="icon-uniF104"></i> icon-uniF104 </li>
            <li><i class="icon-uniF105"></i> icon-uniF105 </li>
            <li><i class="icon-uniF106"></i> icon-uniF106 </li>
            <li><i class="icon-uniF107"></i> icon-uniF107 </li>
            <li><i class="icon-uniF108"></i> icon-uniF108 </li>
            <li><i class="icon-uniF109"></i> icon-uniF109 </li>
            <li><i class="icon-uniF10A"></i> icon-uniF10A </li>
            <li><i class="icon-uniF10B"></i> icon-uniF10B </li>
            <li><i class="icon-uniF10C"></i> icon-uniF10C </li>
            <li><i class="icon-uniF10D"></i> icon-uniF10D </li>
            <li><i class="icon-uniF10E"></i> icon-uniF10E </li>
            <li><i class="icon-uniF110"></i> icon-uniF110 </li>
            <li><i class="icon-uniF111"></i> icon-uniF111 </li>
            <li><i class="icon-uniF112"></i> icon-uniF112 </li>
            <li><i class="icon-uniF113"></i> icon-uniF113 </li>
            <li><i class="icon-uniF114"></i> icon-uniF114 </li>
            <li><i class="icon-uniF115"></i> icon-uniF115 </li>
            <li><i class="icon-uniF116"></i> icon-uniF116 </li>
            <li><i class="icon-uniF117"></i> icon-uniF117 </li>
            <li><i class="icon-uniF118"></i> icon-uniF118 </li>
            <li><i class="icon-uniF119"></i> icon-uniF119 </li>
            <li><i class="icon-uniF11A"></i> icon-uniF11A </li>
            <li><i class="icon-uniF11B"></i> icon-uniF11B </li>
            <li><i class="icon-uniF11C"></i> icon-uniF11C </li>
            <li><i class="icon-uniF11D"></i> icon-uniF11D </li>
            <li><i class="icon-uniF11E"></i> icon-uniF11E </li>
            <li><i class="icon-uniF120"></i> icon-uniF120 </li>
            <li><i class="icon-uniF121"></i> icon-uniF121 </li>
            <li><i class="icon-uniF122"></i> icon-uniF122 </li>
            <li><i class="icon-uniF123"></i> icon-uniF123 </li>
            <li><i class="icon-uniF124"></i> icon-uniF124 </li>
            <li><i class="icon-uniF125"></i> icon-uniF125 </li>
            <li><i class="icon-uniF126"></i> icon-uniF126 </li>
            <li><i class="icon-uniF127"></i> icon-uniF127 </li>
            <li><i class="icon-uniF128"></i> icon-uniF128 </li>
            <li><i class="icon-uniF129"></i> icon-uniF129 </li>
            <li><i class="icon-uniF12A"></i> icon-uniF12A </li>
            <li><i class="icon-uniF12B"></i> icon-uniF12B </li>
            <li><i class="icon-uniF12C"></i> icon-uniF12C </li>
            <li><i class="icon-uniF12D"></i> icon-uniF12D </li>
            <li><i class="icon-uniF12E"></i> icon-uniF12E </li>
            <li><i class="icon-uniF130"></i> icon-uniF130 </li>
            <li><i class="icon-uniF131"></i> icon-uniF131 </li>
            <li><i class="icon-uniF132"></i> icon-uniF132 </li>
            <li><i class="icon-uniF133"></i> icon-uniF133 </li>
            <li><i class="icon-uniF134"></i> icon-uniF134 </li>
            <li><i class="icon-uniF135"></i> icon-uniF135 </li>
            <li><i class="icon-uniF136"></i> icon-uniF136 </li>
            <li><i class="icon-uniF137"></i> icon-uniF137 </li>
            <li><i class="icon-uniF138"></i> icon-uniF138 </li>
            <li><i class="icon-uniF139"></i> icon-uniF139 </li>
            <li><i class="icon-uniF13A"></i> icon-uniF13A </li>
            <li><i class="icon-uniF13B"></i> icon-uniF13B </li>
            <li><i class="icon-uniF13C"></i> icon-uniF13C </li>
            <li><i class="icon-uniF13D"></i> icon-uniF13D </li>
            <li><i class="icon-uniF13E"></i> icon-uniF13E </li>
            <li><i class="icon-uniF140"></i> icon-uniF140 </li>
            <li><i class="icon-uniF141"></i> icon-uniF141 </li>
            <li><i class="icon-uniF142"></i> icon-uniF142 </li>
            <li><i class="icon-uniF143"></i> icon-uniF143 </li>
            <li><i class="icon-uniF144"></i> icon-uniF144 </li>
            <li><i class="icon-uniF145"></i> icon-uniF145 </li>
            <li><i class="icon-uniF146"></i> icon-uniF146 </li>
            <li><i class="icon-uniF147"></i> icon-uniF147 </li>
            <li><i class="icon-uniF148"></i> icon-uniF148 </li>
            <li><i class="icon-uniF149"></i> icon-uniF149 </li>
            <li><i class="icon-uniF14A"></i> icon-uniF14A </li>
            <li><i class="icon-uniF14B"></i> icon-uniF14B </li>
            <li><i class="icon-uniF14C"></i> icon-uniF14C </li>
            <li><i class="icon-uniF14D"></i> icon-uniF14D </li>
            <li><i class="icon-uniF14E"></i> icon-uniF14E </li>
            <li><i class="icon-uniF150"></i> icon-uniF150 </li>
            <li><i class="icon-uniF151"></i> icon-uniF151 </li>
            <li><i class="icon-uniF152"></i> icon-uniF152 </li>
            <li><i class="icon-uniF153"></i> icon-uniF153 </li>
            <li><i class="icon-uniF154"></i> icon-uniF154 </li>
            <li><i class="icon-uniF155"></i> icon-uniF155 </li>
            <li><i class="icon-uniF156"></i> icon-uniF156 </li>
            <li><i class="icon-uniF157"></i> icon-uniF157 </li>
            <li><i class="icon-uniF158"></i> icon-uniF158 </li>
            <li><i class="icon-uniF159"></i> icon-uniF159 </li>
            <li><i class="icon-uniF15A"></i> icon-uniF15A </li>
            <li><i class="icon-uniF15B"></i> icon-uniF15B </li>
            <li><i class="icon-uniF15C"></i> icon-uniF15C </li>
            <li><i class="icon-uniF15D"></i> icon-uniF15D </li>
            <li><i class="icon-uniF15E"></i> icon-uniF15E </li>
            <li><i class="icon-uniF160"></i> icon-uniF160 </li>
            <li><i class="icon-uniF161"></i> icon-uniF161 </li>
            <li><i class="icon-uniF162"></i> icon-uniF162 </li>
            <li><i class="icon-uniF163"></i> icon-uniF163 </li>
            <li><i class="icon-uniF164"></i> icon-uniF164 </li>
            <li><i class="icon-uniF165"></i> icon-uniF165 </li>
            <li><i class="icon-uniF166"></i> icon-uniF166 </li>
            <li><i class="icon-uniF167"></i> icon-uniF167 </li>
            <li><i class="icon-uniF168"></i> icon-uniF168 </li>
            <li><i class="icon-uniF169"></i> icon-uniF169 </li>
            <li><i class="icon-uniF16A"></i> icon-uniF16A </li>
            <li><i class="icon-uniF16B"></i> icon-uniF16B </li>
            <li><i class="icon-uniF16C"></i> icon-uniF16C </li>
            <li><i class="icon-uniF16D"></i> icon-uniF16D </li>
            <li><i class="icon-uniF16E"></i> icon-uniF16E </li>
            <li><i class="icon-uniF170"></i> icon-uniF170 </li>
            <li><i class="icon-uniF171"></i> icon-uniF171 </li>
            <li><i class="icon-uniF172"></i> icon-uniF172 </li>
            <li><i class="icon-uniF173"></i> icon-uniF173 </li>
            <li><i class="icon-uniF174"></i> icon-uniF174 </li>
            <li><i class="icon-uniF175"></i> icon-uniF175 </li>
            <li><i class="icon-uniF176"></i> icon-uniF176 </li>
            <li><i class="icon-uniF177"></i> icon-uniF177 </li>
            <li><i class="icon-uniF178"></i> icon-uniF178 </li>
            <li><i class="icon-uniF179"></i> icon-uniF179 </li>
            <li><i class="icon-uniF17A"></i> icon-uniF17A </li>
            <li><i class="icon-uniF17B"></i> icon-uniF17B </li>
            <li><i class="icon-uniF17C"></i> icon-uniF17C </li>
            <li><i class="icon-uniF17D"></i> icon-uniF17D </li>
            <li><i class="icon-uniF17E"></i> icon-uniF17E </li>
            <li><i class="icon-uniF180"></i> icon-uniF180 </li>
            <li><i class="icon-uniF181"></i> icon-uniF181 </li>
            <li><i class="icon-uniF182"></i> icon-uniF182 </li>
            <li><i class="icon-uniF183"></i> icon-uniF183 </li>
            <li><i class="icon-uniF184"></i> icon-uniF184 </li>
            <li><i class="icon-uniF185"></i> icon-uniF185 </li>
            <li><i class="icon-uniF186"></i> icon-uniF186 </li>
            <li><i class="icon-uniF187"></i> icon-uniF187 </li>
            <li><i class="icon-uniF188"></i> icon-uniF188 </li>
            <li><i class="icon-uniF189"></i> icon-uniF189 </li>
            <li><i class="icon-uniF18A"></i> icon-uniF18A </li>
            <li><i class="icon-uniF18B"></i> icon-uniF18B </li>
	    </ul>
	    
		
	   <!--  <h2 class="page-header"> Web 应用的图标</h2>
	    
	    <ul class="the-icons">
	      <li><i class="icon-adjust"></i> icon-adjust</li>
	      <li><i class="icon-asterisk"></i> icon-asterisk</li>
	      <li><i class="icon-ban-circle"></i> icon-ban-circle</li>
	      <li><i class="icon-bar-chart"></i> icon-bar-chart</li>
	      <li><i class="icon-barcode"></i> icon-barcode</li>
	      <li><i class="icon-beaker"></i> icon-beaker</li>
	      <li><i class="icon-beer"></i> icon-beer</li>
	      <li><i class="icon-bell"></i> icon-bell</li>
	      <li><i class="icon-bell-alt"></i> icon-bell-alt</li>
	      <li><i class="icon-bolt"></i> icon-bolt</li>
	      <li><i class="icon-book"></i> icon-book</li>
	      <li><i class="icon-bookmark"></i> icon-bookmark</li>
	      <li><i class="icon-bookmark-empty"></i> icon-bookmark-empty</li>
	      <li><i class="icon-briefcase"></i> icon-briefcase</li>
	      <li><i class="icon-bullhorn"></i> icon-bullhorn</li>
	      <li><i class="icon-calendar"></i> icon-calendar</li>
	      <li><i class="icon-camera"></i> icon-camera</li>
	      <li><i class="icon-camera-retro"></i> icon-camera-retro</li>
	      <li><i class="icon-certificate"></i> icon-certificate</li>
	      <li><i class="icon-check"></i> icon-check</li>
	      <li><i class="icon-check-empty"></i> icon-check-empty</li>
	      <li><i class="icon-circle"></i> icon-circle</li>
	      <li><i class="icon-circle-blank"></i> icon-circle-blank</li>
	      <li><i class="icon-cloud"></i> icon-cloud</li>
	      <li><i class="icon-cloud-download"></i> icon-cloud-download</li>
	      <li><i class="icon-cloud-upload"></i> icon-cloud-upload</li>
	      <li><i class="icon-coffee"></i> icon-coffee</li>
	      <li><i class="icon-cog"></i> icon-cog</li>
	      <li><i class="icon-cogs"></i> icon-cogs</li>
	      <li><i class="icon-comment"></i> icon-comment</li>
	      <li><i class="icon-comment-alt"></i> icon-comment-alt</li>
	      <li><i class="icon-comments"></i> icon-comments</li>
	      <li><i class="icon-comments-alt"></i> icon-comments-alt</li>
	      <li><i class="icon-credit-card"></i> icon-credit-card</li>
	      <li><i class="icon-dashboard"></i> icon-dashboard</li>
	      <li><i class="icon-desktop"></i> icon-desktop</li>
	      <li><i class="icon-download"></i> icon-download</li>
	      <li><i class="icon-download-alt"></i> icon-download-alt</li>
	    

	      <li><i class="icon-edit"></i> icon-edit</li>
	      <li><i class="icon-envelope"></i> icon-envelope</li>
	      <li><i class="icon-envelope-alt"></i> icon-envelope-alt</li>
	      <li><i class="icon-exchange"></i> icon-exchange</li>
	      <li><i class="icon-exclamation-sign"></i> icon-exclamation-sign</li>
	      <li><i class="icon-external-link"></i> icon-external-link</li>
	      <li><i class="icon-eye-close"></i> icon-eye-close</li>
	      <li><i class="icon-eye-open"></i> icon-eye-open</li>
	      <li><i class="icon-facetime-video"></i> icon-facetime-video</li>
	      <li><i class="icon-fighter-jet"></i> icon-fighter-jet</li>
	      <li><i class="icon-film"></i> icon-film</li>
	      <li><i class="icon-filter"></i> icon-filter</li>
	      <li><i class="icon-fire"></i> icon-fire</li>
	      <li><i class="icon-flag"></i> icon-flag</li>
	      <li><i class="icon-folder-close"></i> icon-folder-close</li>
	      <li><i class="icon-folder-open"></i> icon-folder-open</li>
	      <li><i class="icon-folder-close-alt"></i> icon-folder-close-alt</li>
	      <li><i class="icon-folder-open-alt"></i> icon-folder-open-alt</li>
	      <li><i class="icon-food"></i> icon-food</li>
	      <li><i class="icon-gift"></i> icon-gift</li>
	      <li><i class="icon-glass"></i> icon-glass</li>
	      <li><i class="icon-globe"></i> icon-globe</li>
	      <li><i class="icon-group"></i> icon-group</li>
	      <li><i class="icon-hdd"></i> icon-hdd</li>
	      <li><i class="icon-headphones"></i> icon-headphones</li>
	      <li><i class="icon-heart"></i> icon-heart</li>
	      <li><i class="icon-heart-empty"></i> icon-heart-empty</li>
	      <li><i class="icon-home"></i> icon-home</li>
	      <li><i class="icon-inbox"></i> icon-inbox</li>
	      <li><i class="icon-info-sign"></i> icon-info-sign</li>
	      <li><i class="icon-key"></i> icon-key</li>
	      <li><i class="icon-leaf"></i> icon-leaf</li>
	      <li><i class="icon-laptop"></i> icon-laptop</li>
	      <li><i class="icon-legal"></i> icon-legal</li>
	      <li><i class="icon-lemon"></i> icon-lemon</li>
	      <li><i class="icon-lightbulb"></i> icon-lightbulb</li>
	      <li><i class="icon-lock"></i> icon-lock</li>
	      <li><i class="icon-unlock"></i> icon-unlock</li>
	    

	      <li><i class="icon-magic"></i> icon-magic</li>
	      <li><i class="icon-magnet"></i> icon-magnet</li>
	      <li><i class="icon-map-marker"></i> icon-map-marker</li>
	      <li><i class="icon-minus"></i> icon-minus</li>
	      <li><i class="icon-minus-sign"></i> icon-minus-sign</li>
	      <li><i class="icon-mobile-phone"></i> icon-mobile-phone</li>
	      <li><i class="icon-money"></i> icon-money</li>
	      <li><i class="icon-move"></i> icon-move</li>
	      <li><i class="icon-music"></i> icon-music</li>
	      <li><i class="icon-off"></i> icon-off</li>
	      <li><i class="icon-ok"></i> icon-ok</li>
	      <li><i class="icon-ok-circle"></i> icon-ok-circle</li>
	      <li><i class="icon-ok-sign"></i> icon-ok-sign</li>
	      <li><i class="icon-pencil"></i> icon-pencil</li>
	      <li><i class="icon-picture"></i> icon-picture</li>
	      <li><i class="icon-plane"></i> icon-plane</li>
	      <li><i class="icon-plus"></i> icon-plus</li>
	      <li><i class="icon-plus-sign"></i> icon-plus-sign</li>
	      <li><i class="icon-print"></i> icon-print</li>
	      <li><i class="icon-pushpin"></i> icon-pushpin</li>
	      <li><i class="icon-qrcode"></i> icon-qrcode</li>
	      <li><i class="icon-question-sign"></i> icon-question-sign</li>
	      <li><i class="icon-quote-left"></i> icon-quote-left</li>
	      <li><i class="icon-quote-right"></i> icon-quote-right</li>
	      <li><i class="icon-random"></i> icon-random</li>
	      <li><i class="icon-refresh"></i> icon-refresh</li>
	      <li><i class="icon-remove"></i> icon-remove</li>
	      <li><i class="icon-remove-circle"></i> icon-remove-circle</li>
	      <li><i class="icon-remove-sign"></i> icon-remove-sign</li>
	      <li><i class="icon-reorder"></i> icon-reorder</li>
	      <li><i class="icon-reply"></i> icon-reply</li>
	      <li><i class="icon-resize-horizontal"></i> icon-resize-horizontal</li>
	      <li><i class="icon-resize-vertical"></i> icon-resize-vertical</li>
	      <li><i class="icon-retweet"></i> icon-retweet</li>
	      <li><i class="icon-road"></i> icon-road</li>
	      <li><i class="icon-rss"></i> icon-rss</li>
	      <li><i class="icon-screenshot"></i> icon-screenshot</li>
	      <li><i class="icon-search"></i> icon-search</li>
	    

	      <li><i class="icon-share"></i> icon-share</li>
	      <li><i class="icon-share-alt"></i> icon-share-alt</li>
	      <li><i class="icon-shopping-cart"></i> icon-shopping-cart</li>
	      <li><i class="icon-signal"></i> icon-signal</li>
	      <li><i class="icon-signin"></i> icon-signin</li>
	      <li><i class="icon-signout"></i> icon-signout</li>
	      <li><i class="icon-sitemap"></i> icon-sitemap</li>
	      <li><i class="icon-sort"></i> icon-sort</li>
	      <li><i class="icon-sort-down"></i> icon-sort-down</li>
	      <li><i class="icon-sort-up"></i> icon-sort-up</li>
	      <li><i class="icon-spinner"></i> icon-spinner</li>
	      <li><i class="icon-star"></i> icon-star</li>
	      <li><i class="icon-star-empty"></i> icon-star-empty</li>
	      <li><i class="icon-star-half"></i> icon-star-half</li>
	      <li><i class="icon-tablet"></i> icon-tablet</li>
	      <li><i class="icon-tag"></i> icon-tag</li>
	      <li><i class="icon-tags"></i> icon-tags</li>
	      <li><i class="icon-tasks"></i> icon-tasks</li>
	      <li><i class="icon-thumbs-down"></i> icon-thumbs-down</li>
	      <li><i class="icon-thumbs-up"></i> icon-thumbs-up</li>
	      <li><i class="icon-time"></i> icon-time</li>
	      <li><i class="icon-tint"></i> icon-tint</li>
	      <li><i class="icon-trash"></i> icon-trash</li>
	      <li><i class="icon-trophy"></i> icon-trophy</li>
	      <li><i class="icon-truck"></i> icon-truck</li>
	      <li><i class="icon-umbrella"></i> icon-umbrella</li>
	      <li><i class="icon-upload"></i> icon-upload</li>
	      <li><i class="icon-upload-alt"></i> icon-upload-alt</li>
	      <li><i class="icon-user"></i> icon-user</li>
	      <li><i class="icon-user-md"></i> icon-user-md</li>
	      <li><i class="icon-volume-off"></i> icon-volume-off</li>
	      <li><i class="icon-volume-down"></i> icon-volume-down</li>
	      <li><i class="icon-volume-up"></i> icon-volume-up</li>
	      <li><i class="icon-warning-sign"></i> icon-warning-sign</li>
	      <li><i class="icon-wrench"></i> icon-wrench</li>
	      <li><i class="icon-zoom-in"></i> icon-zoom-in</li>
	      <li><i class="icon-zoom-out"></i> icon-zoom-out</li>
	    </ul>
	
	  
	    <h2 class="page-header">文本编辑器图标</h2>
	  
	    <ul class="the-icons">
	      <li><i class="icon-file"></i> icon-file</li>
	      <li><i class="icon-file-alt"></i> icon-file-alt</li>
	      <li><i class="icon-cut"></i> icon-cut</li>
	      <li><i class="icon-copy"></i> icon-copy</li>
	      <li><i class="icon-paste"></i> icon-paste</li>
	      <li><i class="icon-save"></i> icon-save</li>
	      <li><i class="icon-undo"></i> icon-undo</li>
	      <li><i class="icon-repeat"></i> icon-repeat</li>
	    

	      <li><i class="icon-text-height"></i> icon-text-height</li>
	      <li><i class="icon-text-width"></i> icon-text-width</li>
	      <li><i class="icon-align-left"></i> icon-align-left</li>
	      <li><i class="icon-align-center"></i> icon-align-center</li>
	      <li><i class="icon-align-right"></i> icon-align-right</li>
	      <li><i class="icon-align-justify"></i> icon-align-justify</li>
	      <li><i class="icon-indent-left"></i> icon-indent-left</li>
	      <li><i class="icon-indent-right"></i> icon-indent-right</li>
	    

	      <li><i class="icon-font"></i> icon-font</li>
	      <li><i class="icon-bold"></i> icon-bold</li>
	      <li><i class="icon-italic"></i> icon-italic</li>
	      <li><i class="icon-strikethrough"></i> icon-strikethrough</li>
	      <li><i class="icon-underline"></i> icon-underline</li>
	      <li><i class="icon-link"></i> icon-link</li>
	      <li><i class="icon-paper-clip"></i> icon-paper-clip</li>
	      <li><i class="icon-columns"></i> icon-columns</li>
	    

	      <li><i class="icon-table"></i> icon-table</li>
	      <li><i class="icon-th-large"></i> icon-th-large</li>
	      <li><i class="icon-th"></i> icon-th</li>
	      <li><i class="icon-th-list"></i> icon-th-list</li>
	      <li><i class="icon-list"></i> icon-list</li>
	      <li><i class="icon-list-ol"></i> icon-list-ol</li>
	      <li><i class="icon-list-ul"></i> icon-list-ul</li>
	      <li><i class="icon-list-alt"></i> icon-list-alt</li>
	    </ul>
	
	    <h2 class="page-header">指示方向的图标</h2>
	  
	    <ul class="the-icons">
	      <li><i class="icon-angle-left"></i> icon-angle-left</li>
	      <li><i class="icon-angle-right"></i> icon-angle-right</li>
	      <li><i class="icon-angle-up"></i> icon-angle-up</li>
	      <li><i class="icon-angle-down"></i> icon-angle-down</li>
	      <li><i class="icon-arrow-down"></i> icon-arrow-down</li>
	      <li><i class="icon-arrow-left"></i> icon-arrow-left</li>
	      <li><i class="icon-arrow-right"></i> icon-arrow-right</li>
	      <li><i class="icon-arrow-up"></i> icon-arrow-up</li>
	    

	      <li><i class="icon-caret-down"></i> icon-caret-down</li>
	      <li><i class="icon-caret-left"></i> icon-caret-left</li>
	      <li><i class="icon-caret-right"></i> icon-caret-right</li>
	      <li><i class="icon-caret-up"></i> icon-caret-up</li>
	      <li><i class="icon-chevron-down"></i> icon-chevron-down</li>
	      <li><i class="icon-chevron-left"></i> icon-chevron-left</li>
	      <li><i class="icon-chevron-right"></i> icon-chevron-right</li>
	      <li><i class="icon-chevron-up"></i> icon-chevron-up</li>
	    

	      <li><i class="icon-circle-arrow-down"></i> icon-circle-arrow-down</li>
	      <li><i class="icon-circle-arrow-left"></i> icon-circle-arrow-left</li>
	      <li><i class="icon-circle-arrow-right"></i> icon-circle-arrow-right</li>
	      <li><i class="icon-circle-arrow-up"></i> icon-circle-arrow-up</li>
	      <li><i class="icon-double-angle-left"></i> icon-double-angle-left</li>
	      <li><i class="icon-double-angle-right"></i> icon-double-angle-right</li>
	      <li><i class="icon-double-angle-up"></i> icon-double-angle-up</li>
	      <li><i class="icon-double-angle-down"></i> icon-double-angle-down</li>
	    

	      <li><i class="icon-hand-down"></i> icon-hand-down</li>
	      <li><i class="icon-hand-left"></i> icon-hand-left</li>
	      <li><i class="icon-hand-right"></i> icon-hand-right</li>
	      <li><i class="icon-hand-up"></i> icon-hand-up</li>
	      <li><i class="icon-circle"></i> icon-circle</li>
	      <li><i class="icon-circle-blank"></i> icon-circle-blank</li>
	    </ul>
	  
	
	    <h2 class="page-header">视频播放器图标</h2>
	  
	    <ul class="the-icons">
	      <li><i class="icon-play-circle"></i> icon-play-circle</li>
	      <li><i class="icon-play"></i> icon-play</li>
	      <li><i class="icon-pause"></i> icon-pause</li>
	      <li><i class="icon-stop"></i> icon-stop</li>
	    

	      <li><i class="icon-step-backward"></i> icon-step-backward</li>
	      <li><i class="icon-fast-backward"></i> icon-fast-backward</li>
	      <li><i class="icon-backward"></i> icon-backward</li>
	      <li><i class="icon-forward"></i> icon-forward</li>
	    

	      <li><i class="icon-fast-forward"></i> icon-fast-forward</li>
	      <li><i class="icon-step-forward"></i> icon-step-forward</li>
	      <li><i class="icon-eject"></i> icon-eject</li>
	    

	      <li><i class="icon-fullscreen"></i> icon-fullscreen</li>
	      <li><i class="icon-resize-full"></i> icon-resize-full</li>
	      <li><i class="icon-resize-small"></i> icon-resize-small</li>
	    </ul>
	
	
	    <h2 class="page-header">SNS图标</h2>
	  
	    <ul class="the-icons">
	      <li><i class="icon-phone"></i> icon-phone</li>
	      <li><i class="icon-phone-sign"></i> icon-phone-sign</li>
	      <li><i class="icon-facebook"></i> icon-facebook</li>
	      <li><i class="icon-facebook-sign"></i> icon-facebook-sign</li>
	    

	      <li><i class="icon-twitter"></i> icon-twitter</li>
	      <li><i class="icon-twitter-sign"></i> icon-twitter-sign</li>
	      <li><i class="icon-github"></i> icon-github</li>
	      <li><i class="icon-github-alt"></i> icon-github-alt</li>
	    

	      <li><i class="icon-github-sign"></i> icon-github-sign</li>
	      <li><i class="icon-linkedin"></i> icon-linkedin</li>
	      <li><i class="icon-linkedin-sign"></i> icon-linkedin-sign</li>
	      <li><i class="icon-pinterest"></i> icon-pinterest</li>
	    

	      <li><i class="icon-pinterest-sign"></i> icon-pinterest-sign</li>
	      <li><i class="icon-google-plus"></i> icon-google-plus</li>
	      <li><i class="icon-google-plus-sign"></i> icon-google-plus-sign</li>
	      <li><i class="icon-sign-blank"></i> icon-sign-blank</li>
	    </ul>
	  
	  
	    <h2 class="page-header">医疗图标</h2>
	  
	    <ul class="the-icons">
	      <li><i class="icon-ambulance"></i> icon-ambulance</li>
	      <li><i class="icon-beaker"></i> icon-beaker</li>
	    

	      <li><i class="icon-h-sign"></i> icon-h-sign</li>
	      <li><i class="icon-hospital"></i> icon-hospital</li>
	    

	      <li><i class="icon-medkit"></i> icon-medkit</li>
	      <li><i class="icon-plus-sign-alt"></i> icon-plus-sign-alt</li>
	    

	      <li><i class="icon-stethoscope"></i> icon-stethoscope</li>
	      <li><i class="icon-user-md"></i> icon-user-md</li>
	    </ul>
	<br/><br/> -->
</div>
</body>