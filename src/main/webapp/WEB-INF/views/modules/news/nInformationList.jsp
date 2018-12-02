<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>资讯表管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/news/nInformation/">资讯表列表</a></li>
		<shiro:hasPermission name="news:nInformation:edit"><li><a href="${ctx}/news/nInformation/form">资讯表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="nInformation" action="${ctx}/news/nInformation/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>资讯标题：</label>
				<form:input path="infoTitle" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>资讯发布者：</label>
				<form:input path="infoPublisher" htmlEscape="false" maxlength="40" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>资讯标题</th>
				<th>资讯展示风格0大图1右侧小图2图集</th>
				<th>资讯发布者</th>
				<shiro:hasPermission name="news:nInformation:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="nInformation">
			<tr>
				<td><a href="${ctx}/news/nInformation/form?id=${nInformation.id}">
					${nInformation.infoTitle}
				</a></td>
				<td>
					${nInformation.infoShowStyle}
				</td>
				<td>
					${nInformation.infoPublisher}
				</td>
				<shiro:hasPermission name="news:nInformation:edit"><td>
    				<a href="${ctx}/news/nInformation/form?id=${nInformation.id}">修改</a>
					<a href="${ctx}/news/nInformation/delete?id=${nInformation.id}" onclick="return confirmx('确认要删除该资讯表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>