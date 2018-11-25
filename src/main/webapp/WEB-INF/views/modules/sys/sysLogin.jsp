<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
		<meta charset="utf-8" />
		<title>${fns:getConfig('productName')} 登录</title>
		<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
		<%-- <link rel="stylesheet" type="text/css" href="${ctxStatic1}/css/initialize.css"/>
		<!--<link rel="stylesheet" type="text/css" href="css/common.css"/>-->
		<link rel="stylesheet" type="text/css" href="${ctxStatic1}/css/login.css"/>
		<script type="text/javascript" src="${ctxStatic1}/js/jquery.js"></script>
		<script type="text/javascript" src="${ctxStatic1}/js/login.js"></script> --%>
		<link rel="stylesheet" href="${StaticNews}/font/font.css" />
	    <link rel="stylesheet" href="${StaticNews}/core/bootstrap-3.3.7-dist/css/bootstrap.css">
		<link rel="stylesheet" href="${StaticNews}/font/font.css" />
	    <link rel="stylesheet" href="${StaticNews}/cssv1.0/reset.css">
	    <link rel="stylesheet" href="${StaticNews}/cssv1.0/login.css">
	    <link rel="stylesheet" href="${StaticNews}/core/bootstrap-validator/css/bootstrapValidator.min.css">
	    <script src="${StaticNews}/core/jquery/jquery-3.2.0.min.js"></script>
	    <script src="${StaticNews}/core/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
	    <script src="${StaticNews}/core/bootstrap-validator/js/bootstrapValidator.js"></script>
	</head>
	<body>
		<div class="wrapper">
	
	<div class="sks">
		 <div class="header">
	        <div class="header_wrap ">
	            <div class="header_main">
	                <p class="platform">宝马新闻APP后台管理系统</p>
	            </div>
	        </div>
	    </div>
	    <section class="login_main">
	        <form class="form-signin" id="loginForm" class="form-signin" action="${ctx}/login" method="post">
	            <div class="user_item form-group form-item form-group-lg">
	            	<div class="input-group">
	            		<span class="input-group-addon glyphicon glyphicon-user"></span>
	                	<input type="text" class="form-control" placeholder="请输入您的用户名" name="username" />
					 </div>
	            </div>
	            <div class="user_item form-group form-item form-group-lg">
	            	<div class="input-group">
	            		<span class="input-group-addon glyphicon glyphicon-lock"></span>
	                	<input type="password" class="form-control" placeholder="请输入您的密码" name="password" />
					 </div>
	            </div>
	            <div class="user_item form-group form-item form-group-lg">
	            	<div class="input-group">
	                	<input type="text" class="form-control"name="validateCode" id="validateCode"  placeholder="请输入验证码" />
	                	<span class="input-group-addon"><sys:validateCode name="validateCode" inputCssStyle="display:none" buttonCssStyle="display:none"/></span>
					 </div>
	            </div>
	
	            <div class="submit_item">
	                <button type="submit" class="submit">登 录</button>
	            </div>
	        </form>
	    </section>
	</div>
   
	<div class="bottoms"></div>
    <script>
        $(function(){
            $('form').bootstrapValidator({
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    username: {
                        message: '用户名验证失败',
                        validators: {
                            notEmpty: {
                                message: '用户名能为空'
                            },
                            stringLength: {
                                min: 6,
                                max: 30,
                                message: '6-30个字节'
                            },
                            regexp: {
                                regexp: /^[a-zA-Z0-9_]+$/,
                                message: '只能输入数字英文字母'
                            }
                        }
                    },
                    password: {
                        validators: {
                            notEmpty: {
                                message: '密码不能为空'
                            }
                        }
                    },
                    verification: {
                        validators: {
                            notEmpty: {
                                message: 'verification不能为空'
                            }
                        }
                    }
                }
            }).on('success.form.bv', function(e) {
                //alert(1);
                // 阻止默认事件提交
                //e.preventDefault();
            });
        });
    </script>
</div>
	</body>
</html>