<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>${fns:getConfig('productName')}</title>
    <%--<script src="${ctxStatic1}/js/box.js"></script>--%>
    <meta name="decorator" content="blank"/>
    <link rel="stylesheet" href="${StaticNews}/core/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${StaticNews}/core/bootstrap-3.3.7-dist/css/bootstrap.css">
    <link rel="stylesheet" href="${StaticNews}/core/bootstrap-table/bootstrap-table.css">
    <link rel="stylesheet" href="${StaticNews}/core/bootstrap-validator/css/bootstrapValidator.min.css">
	<link rel="stylesheet" href="${StaticNews}/font/font.css" />
    <link rel="stylesheet" href="${StaticNews}/css/reset.css">
    <link rel="stylesheet" href="${StaticNews}/css/index.css">

    <script src="${StaticNews}/core/jquery/jquery-3.2.0.min.js"></script>
    <script src="${StaticNews}/core/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <script src="${StaticNews}/core/bootstrap-table/bootstrap-table.js"></script>
    <script src="${StaticNews}/core/bootstrap-table/bootstrap-table-zh-CN.js"></script>
    <script src="${StaticNews}/core/bootstrap-validator/js/bootstrapValidator.js"></script>
    <c:set var="tabmode" value="${empty cookie.tabmode.value ? '0' : cookie.tabmode.value}"/>
    <c:if test="${tabmode eq '1'}">
        <link rel="Stylesheet" href="${ctxStatic}/jerichotab/css/jquery.jerichotab.css"/>
        <script type="text/javascript" src="${ctxStatic}/jerichotab/js/jquery.jerichotab.js"></script>
    </c:if>
    <style type="text/css">
        #main {
            padding: 0;
            margin: 0;
        }

        #main .container-fluid {
            padding: 0 4px 0 0;
        }

        #header {
            margin: 0;
            position: static;
        }

        #header li {
            font-size: 14px;
            _font-size: 12px;
        }

        #header .brand {
            font-family: Helvetica, Georgia, Arial, sans-serif, 黑体;
            font-size: 26px;
            padding-left: 33px;
        }

        #left {
            overflow-x: hidden;
            overflow-y: auto;
        }

        #left .collapse {
            position: static;
        }

        #userControl > li > a { /*color:#fff;*/
            text-shadow: none;
        }

        /*#userControl>li>a:hover, #user #userControl>li.open>a{background:transparent;}*/
    </style>
    <link rel="stylesheet" type="text/css" href="${ctxStatic1}/css/common.css"/>
    <script type="text/javascript">
        var type = 0;
        var yj = false;
        var sj = false;
        var rx = false;
        var wr = false;
        $(document).ready(function () {

            // <c:if test="${tabmode eq '1'}"> 初始化页签
            $.fn.initJerichoTab({
                renderTo: '#right', uniqueId: 'jerichotab',
                contentCss: {'height': $('#right').height() - tabTitleHeight},
                tabs: [], loadOnce: true, tabWidth: 110, titleHeight: tabTitleHeight
            });//</c:if>
            // 绑定菜单单击事件
            $("#menu a.menu").click(function () {
                // 一级菜单焦点
                $("#menu li.menu").removeClass("active");
                $(this).parent().addClass("active");
                // 左侧区域隐藏
                if ($(this).attr("target") == "mainFrame") {
                    $("#left,#openClose").hide();
                    wSizeWidth();
                    // <c:if test="${tabmode eq '1'}"> 隐藏页签
                    $(".jericho_tab").hide();
                    $("#mainFrame").show();//</c:if>
                    return true;
                }
                // 左侧区域显示
                $("#left,#openClose").show();
                if (!$("#openClose").hasClass("close")) {
                    $("#openClose").click();
                }
                // 显示二级菜单
                var menuId = "#menu-" + $(this).attr("data-id");
                if ($(menuId).length > 0) {
                    $("#left .accordion").hide();
                    $(menuId).show();

                    if (type == 1) {
//                            // 二级内容
                        $(menuId + " .accordion-body a").click(function () {
                            $(menuId + " li").removeClass("active");
                            $(menuId + " li i").removeClass("icon-white");
                            $(this).parent().addClass("active");
                            $(this).children("i").addClass("icon-white");
                        });
//                        $(menuId + " .accordion-toggle:eq(1)").click();
//                        $(menuId + " .accordion-body:eq(1) a:first i").click();
//                        $(menuId + " .accordion-body:eq(1) li:first li:first a:first i").click();
                        // 初始化点击第一个二级菜单
                        if (yj) {
                            $(menuId + " .accordion-toggle:eq(1)").click();
                            yj = false;
                            sj = true;
                            rx = true;
                            wr = true;
                        }
                        $(menuId + " .accordion-body:eq(1) a:first i").click();
                        $(menuId + " .accordion-body:eq(1) li:first li:first a:first i").click();
                        type = 0;
                    }else if (type == 2) {
                        // 初始化点击第一个二级菜单
                        if (sj) {
                            $(menuId + " .accordion-toggle:eq(3)").click();
                            sj = false;
                            yj = true;
                            rx = true;
                            wr = true;
                        }
//                            // 二级内容
                        $(menuId + " .accordion-body a").click(function () {
                            $(menuId + " li").removeClass("active");
                            $(menuId + " li i").removeClass("icon-white");
                            $(this).parent().addClass("active");
                            $(this).children("i").addClass("icon-white");
                        });
                        $(menuId + " .accordion-body:eq(3) a:first i").click();
                        $(menuId + " .accordion-body:eq(3) li:first li:first a:first i").click();
                        type = 0;
                    } else if (type == 3) {
                        // 初始化点击第一个二级菜单
                        if (rx) {
                            $(menuId + " .accordion-toggle:eq(2)").click();
                            rx = false;
                            yj = true;
                            sj = true;
                            wr = true;
                        }
//                            // 二级内容
                        $(menuId + " .accordion-body a").click(function () {
                            $(menuId + " li").removeClass("active");
                            $(menuId + " li i").removeClass("icon-white");
                            $(this).parent().addClass("active");
                            $(this).children("i").addClass("icon-white");
                        });
                        $(menuId + " .accordion-body:eq(2) a:first i").click();
                        $(menuId + " .accordion-body:eq(2) li:first li:first a:first i").click();
                        type = 0;
                    } else if (type == 4) {
                        // 初始化点击第一个二级菜单
                        if (wr) {
                            $(menuId + " .accordion-toggle:eq(4)").click();
                            wr = false;
                            rx = true;
                            yj = true;
                            sj = true;
                        }
//                            // 二级内容
                        $(menuId + " .accordion-body a").click(function () {
                            $(menuId + " li").removeClass("active");
                            $(menuId + " li i").removeClass("icon-white");
                            $(this).parent().addClass("active");
                            $(this).children("i").addClass("icon-white");
                        });
                        $(menuId + " .accordion-body:eq(4) a:first i").click();
                        $(menuId + " .accordion-body:eq(4) li:first li:first a:first i").click();
                        type = 0;
                    }  else if(type == 0){

                        // 初始化点击第一个二级菜单
                        if (!$(menuId + " .accordion-body:first").hasClass('in')) {
                            $(menuId + " .accordion-heading:first a").click();
                        }
                        if (!$(menuId + " .accordion-body li:first ul:first").is(":visible")) {
                            $(menuId + " .accordion-body a:first i").click();
                        }
                        // 初始化点击第一个三级菜单
                        $(menuId + " .accordion-body li:first li:first a:first i").click();
                    } else if(type == 5){
                        // 初始化点击第一个二级菜单
                        if (!$(menuId + " .accordion-body:first").hasClass('in')) {
                            $(menuId + " .accordion-heading:first a").click();
                        }
                        if (!$(menuId + " .accordion-body li:eq(3) ul:first").is(":visible")) {
                            $(menuId + " .accordion-body a:eq(3) i").click();
                        }
                        // 初始化点击第一个三级菜单
//                        $(menuId + " .accordion-body li:eq(3) li::first a::first i").click();
                        type = 0;
                    }

                } else {
                    // 获取二级菜单数据
                    $.get($(this).attr("data-href"), function (data) {
                        if (data.indexOf("id=\"loginForm\"") != -1) {
                            alert('未登录或登录超时。请重新登录，谢谢！');
                            top.location = "${ctx}";
                            return false;
                        }
                        $("#left .accordion").hide();
                        $("#left").append(data);
                        // 链接去掉虚框
                        $(menuId + " a").bind("focus", function () {
                            if (this.blur) {
                                this.blur()
                            }
                            ;
                        });
                        // 一级标题
                        $(menuId + " .accordion-heading a").click(function () {
                            $(menuId + " .accordion-heading a").removeClass("active");
                            $(this).addClass("active");
                        });
                        if (type == 1) {
                            // 默认选中第一个菜单
                            $(menuId + " li").removeClass("active");
                            $(menuId + " li i").removeClass("icon-white");
//                            // 二级内容
                            $(menuId + " .accordion-body a").click(function () {
                                $(menuId + " li").removeClass("active");
                                $(menuId + " li i").removeClass("icon-white");
                                $(this).parent().addClass("active");
                                $(this).children("i").addClass("icon-white");
                            });
                            $(menuId + " .accordion-toggle:eq(1)").click();
                            $(menuId + " .accordion-body:eq(1) a:first i").click();
                            $(menuId + " .accordion-body:eq(1) li:first li:first a:first i").click();
                            type = 0;
                            yj = false;
                            sj = true;
                            rx = true;
                            wr = true;
                        }else if (type == 2) {
                            // 默认选中第一个菜单
                            $(menuId + " li").removeClass("active");
                            $(menuId + " li i").removeClass("icon-white");
//                            // 二级内容
                            $(menuId + " .accordion-body a").click(function () {
                                $(menuId + " li").removeClass("active");
                                $(menuId + " li i").removeClass("icon-white");
                                $(this).parent().addClass("active");
                                $(this).children("i").addClass("icon-white");
                            });
                            $(menuId + " .accordion-toggle:eq(3)").click();
                            $(menuId + " .accordion-body:eq(3) a:first i").click();
                            $(menuId + " .accordion-body:eq(3) li:first li:first a:first i").click();
                            type = 0;
                            sj = false;
                            yj = true;
                            rx = true;
                            wr = true;
                        } else if (type == 3) {
                            // 默认选中第一个菜单
                            $(menuId + " li").removeClass("active");
                            $(menuId + " li i").removeClass("icon-white");
//                            // 二级内容
                            $(menuId + " .accordion-body a").click(function () {
                                $(menuId + " li").removeClass("active");
                                $(menuId + " li i").removeClass("icon-white");
                                $(this).parent().addClass("active");
                                $(this).children("i").addClass("icon-white");
                            });
                            $(menuId + " .accordion-toggle:eq(2)").click();
                            $(menuId + " .accordion-body:eq(2) a:first i").click();
                            $(menuId + " .accordion-body:eq(2) li:first li:first a:first i").click();
                            type = 0;
                            rx = false;
                            yj = true;
                            sj = true;
                            wr = true;
                        } else if (type == 4) {
                            // 默认选中第一个菜单
                            $(menuId + " li").removeClass("active");
                            $(menuId + " li i").removeClass("icon-white");
//                            // 二级内容
                            $(menuId + " .accordion-body a").click(function () {
                                $(menuId + " li").removeClass("active");
                                $(menuId + " li i").removeClass("icon-white");
                                $(this).parent().addClass("active");
                                $(this).children("i").addClass("icon-white");
                            });
                            $(menuId + " .accordion-toggle:eq(4)").click();
                            $(menuId + " .accordion-body:eq(4) a:first i").click();
                            $(menuId + " .accordion-body:eq(4) li:first li:first a:first i").click();
                            type = 0;
                            wr = false;
                            rx = true;
                            yj = true;
                            sj = true;
                        }  else if(type == 0){
                            // 二级内容
                            $(menuId + " .accordion-body a").click(function () {
                                $(menuId + " li").removeClass("active");
                                $(menuId + " li i").removeClass("icon-white");
                                $(this).parent().addClass("active");
                                $(this).children("i").addClass("icon-white");
                            });

                            // 展现三级
                            $(menuId + " .accordion-inner a").click(function () {
                                var href = $(this).attr("data-href");
                                if ($(href).length > 0) {
                                    $(href).toggle().parent().toggle();
                                    return false;
                                }
                                // <c:if test="${tabmode eq '1'}"> 打开显示页签
                                return addTab($(this)); // </c:if>
                            });
                            // 默认选中第一个菜单
                            $(menuId + " .accordion-body a:first i").click();
                            $(menuId + " .accordion-body li:first li:first a:first i").click();
                            yj = true;
                            sj = true;
                            rx = true;
                            wr = true;
                        }else if (type == 5) {
                            // 默认选中第一个菜单
                            $(menuId + " li").removeClass("active");
                            $(menuId + " li i").removeClass("icon-white");
//                            // 二级内容
                            $(menuId + " .accordion-body a").click(function () {
                                $(menuId + " li").removeClass("active");
                                $(menuId + " li i").removeClass("icon-white");
                                $(this).parent().addClass("active");
                                $(this).children("i").addClass("icon-white");
                            });
//                            $(menuId + " .accordion-toggle:eq(4)").click();
                            $(menuId + " .accordion-body a:eq(3) i").click();
                            $(menuId + " .accordion-body li:eq(3) li:first a:first i").click();
                            type = 0;
                            yj = true;
                            sj = true;
                            rx = true;
                            wr = true;
                        }
                    });
                }
                // 大小宽度调整
                wSizeWidth();
                return false;
            });
            // 初始化点击第一个一级菜单
            $("#menu a.menu:first span").click();
            // <c:if test="${tabmode eq '1'}"> 下拉菜单以选项卡方式打开
            $("#userInfo .dropdown-menu a").mouseup(function () {
                return addTab($(this), true);
            });// </c:if>
            // 鼠标移动到边界自动弹出左侧菜单
            $("#openClose").mouseover(function () {
                if ($(this).hasClass("open")) {
                    $(this).click();
                }
            });
            // 获取通知数目  <c:set var="oaNotifyRemindInterval" value="${fns:getConfig('oa.notify.remind.interval')}"/>
            function getNotifyNum() {
                $.get("${ctx}/oa/oaNotify/self/count?updateSession=0&t=" + new Date().getTime(), function (data) {
                    var num = parseFloat(data);
                    if (num > 0) {
                        $("#notifyNum,#notifyNum2").show().html("(" + num + ")");
                    } else {
                        $("#notifyNum,#notifyNum2").hide()
                    }
                });
            }

            <%--getNotifyNum(); //<c:if test="${oaNotifyRemindInterval ne '' && oaNotifyRemindInterval ne '0'}">--%>
            <%--setInterval(getNotifyNum, ${oaNotifyRemindInterval}); //</c:if>--%>
        });
        // <c:if test="${tabmode eq '1'}"> 添加一个页签
        function addTab($this, refresh) {
            $(".jericho_tab").show();
            $("#mainFrame").hide();
            $.fn.jerichoTab.addTab({
                tabFirer: $this,
                title: $this.text(),
                closeable: true,
                data: {
                    dataType: 'iframe',
                    dataLink: $this.attr('href')
                }
            }).loadData(refresh);
            return false;
        }// </c:if>

    </script>
</head>
<body>

<div id="main">
    <div id="header" class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="brand"><span id="productName">${fns:getConfig('productName')}</span>
            </div>
            <ul id="userControl" class="nav pull-right">
                <li id="themeSwitch" class="dropdown">
                    <!-- 						<a class="dropdown-toggle" data-toggle="dropdown" href="#" title="主题切换"><i class="icon-uniF009"></i></a>
                     -->
                    <ul class="dropdown-menu">
                        <c:forEach items="${fns:getDictList('theme')}" var="dict">
                            <li><a href="#"
                                   onclick="location='${pageContext.request.contextPath}/theme/${dict.value}?url='+location.href">${dict.label}</a>
                            </li>
                        </c:forEach>
                        <li>
                            <a href="javascript:cookie('tabmode','${tabmode eq '1' ? '0' : '1'}');location=location.href">${tabmode eq '1' ? '关闭' : '开启'}页签模式</a>
                        </li>
                    </ul>
                    <!--[if lte IE 6]>
                    <script type="text/javascript">$('#themeSwitch').hide();</script><![endif]-->
                </li>
                <li id="userInfo" class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" title="个人信息">您好, ${fns:getUser().name}&nbsp;<span
                            id="notifyNum" class="label label-info hide"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${ctx}/sys/user/info" target="mainFrame"><i class="icon-user"></i>&nbsp; 个人信息</a>
                        </li>
                        <li><a href="${ctx}/sys/user/modifyPwd" target="mainFrame"><i class="icon-lock"></i>&nbsp; 修改密码</a>
                        </li>
                        <li><a href="${ctx}/oa/oaNotify/self" target="mainFrame"><i class="icon-bell"></i>&nbsp; 我的通知
                            <span id="notifyNum2" class="label label-info hide"></span></a></li>
                    </ul>
                </li>
                <li><a href="${ctx}/logout" title="退出登录">退出</a></li>
                <li>&nbsp;</li>
            </ul>
            <%-- <c:if test="${cookie.theme.value eq 'cerulean'}">
                <div id="user" style="position:absolute;top:0;right:0;"></div>
                <div id="logo" style="background:url(${ctxStatic}/images/logo_bg.jpg) right repeat-x;width:100%;">
                    <div style="background:url(${ctxStatic}/images/logo.jpg) left no-repeat;width:100%;height:70px;"></div>
                </div>
                <script type="text/javascript">
                    $("#productName").hide();$("#user").html($("#userControl"));$("#header").prepend($("#user, #logo"));
                </script>
            </c:if> --%>
            <div class="nav-collapse">
                <ul id="menu" class="nav" style="*white-space:nowrap;float:none;">
                    <c:set var="firstMenu" value="true"/>
                    <c:forEach items="${fns:getMenuList()}" var="menu" varStatus="idxStatus">
                        <c:if test="${menu.parent.id eq '1'&&menu.isShow eq '1'}">
                            <li class="menu ${not empty firstMenu && firstMenu ? ' active' : ''}">
                                <c:if test="${empty menu.href}">
                                    <a class="menu" href="javascript:" data-href="${ctx}/sys/menu/tree?parentId
										=${menu.id}" data-id="${menu.id}" id="${menu.id}"><span>${menu.name}</span></a>
                                </c:if>
                                <c:if test="${not empty menu.href}">
                                    <a class="menu" href="${fn:indexOf(menu.href, '://') eq -1 ? ctx : ''}${menu.href}"
                                       data-id="${menu.id}" target="mainFrame"><span>${menu.name}</span></a>
                                </c:if>
                            </li>
                            <c:if test="${firstMenu}">
                                <c:set var="firstMenuId" value="${menu.id}"/>
                            </c:if>
                            <c:set var="firstMenu" value="false"/>
                        </c:if>
                    </c:forEach><%--
						<shiro:hasPermission name="cms:site:select">
						<li class="dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown" href="#">${fnc:getSite(fnc:getCurrentSiteId()).name}<b class="caret"></b></a>
							<ul class="dropdown-menu">
								<c:forEach items="${fnc:getSiteList()}" var="site"><li><a href="${ctx}/cms/site/select?id=${site.id}&flag=1">${site.name}</a></li></c:forEach>
							</ul>
						</li>
						</shiro:hasPermission> --%>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </div>
    <div class="container-fluid">
        <div id="content" class="row-fluid">
            <div id="left" class="left-nav"><%--
					<iframe id="menuFrame" name="menuFrame" src="" style="overflow:visible;" scrolling="yes" frameborder="no" width="100%" height="650"></iframe> --%>
            </div>
            <div id="openClose" class="close">&nbsp;</div>
            <div id="right">
                <iframe id="mainFrame" name="mainFrame" src="" style="overflow:visible;" scrolling="yes"
                        frameborder="no" width="100%" height="650">
                </iframe>
            </div>
        </div>
        <audio id="audio">
            <source src="${ctxStatic1}/mp3/alarm.mp3">
        </audio>
        <audio id="audio2">
            <source src="${ctxStatic1}/mp3/aid.mp3">
        </audio>
        <audio id="audio3">
            <source src="${ctxStatic1}/mp3/aid.mp3">
        </audio>
        <audio id="audio4">
            <source src="${ctxStatic1}/mp3/aid.mp3">
        </audio>
        <%-- <div id="footer" class="text-center row-fluid">
            Copyright &copy; 2012-${fns:getConfig('copyrightYear')} ${fns:getConfig('productName')} - Powered By <a href="http://jeesite.com" target="_blank">JeeSite</a> ${fns:getConfig('version')}
           Copyright &copy; 2017-2020 ${fns:getConfig('productName')} - Powered By 彼 ${fns:getConfig('version')}
        </div> --%>
    </div>
</div>
<script type="text/javascript">
    var leftWidth = 170; // 左侧窗口大小
    var tabTitleHeight = 33; // 页签的高度
    var htmlObj = $("html"), mainObj = $("#main");
    var headerObj = $("#header"), footerObj = $("#footer");
    var frameObj = $("#left, #openClose, #right, #right iframe");
    function wSize() {
        var minHeight = 500, minWidth = 980;
        var strs = getWindowSize().toString().split(",");
        htmlObj.css({
            "overflow-x": strs[1] < minWidth ? "auto" : "hidden",
            "overflow-y": strs[0] < minHeight ? "auto" : "hidden"
        });
        mainObj.css("width", strs[1] < minWidth ? minWidth - 10 : "auto");
        /* frameObj.height((strs[0] < minHeight ? minHeight : strs[0]) - headerObj.height() - footerObj.height() - (strs[1] < minWidth ? 42 : 28)); */
        frameObj.height((strs[0] < minHeight ? minHeight : strs[0]) - headerObj.height() - footerObj.height() - 10);
        $("#left").height((strs[0] < minHeight ? minHeight : strs[0]) - headerObj.height() - footerObj.height() + 8)
        $("#openClose").height($("#openClose").height() - 5);// <c:if test="${tabmode eq '1'}">
        $(".jericho_tab iframe").height($("#right").height() - tabTitleHeight); // </c:if>
        wSizeWidth();
    }
    function wSizeWidth() {
        if (!$("#openClose").is(":hidden")) {
            var leftWidth = ($("#left").width() < 0 ? 0 : $("#left").width());
            $("#right").width($("#content").width() - leftWidth - $("#openClose").width() - 5);
        } else {
            $("#right").width("100%");
        }
    }// <c:if test="${tabmode eq '1'}">
    function openCloseClickCallBack(b) {
        $.fn.jerichoTab.resize();
    } // </c:if>

</script>
<script src="${ctxStatic}/common/wsize.min.js" type="text/javascript"></script>
</body>
</html>