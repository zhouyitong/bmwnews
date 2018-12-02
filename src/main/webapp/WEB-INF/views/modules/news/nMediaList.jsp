<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>媒体信息管理</title>
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
		<li class="active"><a href="${ctx}/news/nMedia/">媒体信息列表</a></li>
		<shiro:hasPermission name="news:nMedia:edit"><li><a href="${ctx}/news/nMedia/form">媒体信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="nMedia" action="${ctx}/news/nMedia/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>媒体区域：</label>
				<form:input path="mediaRegion" htmlEscape="false" maxlength="40" class="input-medium"/>
			</li>
			<li><label>媒体所属城市：</label>
				<form:input path="mediaCity" htmlEscape="false" maxlength="40" class="input-medium"/>
			</li>
			<li><label>媒体名字：</label>
				<form:input path="mediaName" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>媒体所属城市</th>
				<th>媒体名字</th>
				<th>所属媒体集团</th>
				<shiro:hasPermission name="news:nMedia:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="nMedia">
			<tr>
				<td><a href="${ctx}/news/nMedia/form?id=${nMedia.id}">
					${nMedia.mediaCity}
				</a></td>
				<td>
					${nMedia.mediaName}
				</td>
				<td>
					${nMedia.mediaGroup}
				</td>
				<shiro:hasPermission name="news:nMedia:edit"><td>
    				<a href="${ctx}/news/nMedia/form?id=${nMedia.id}">修改</a>
					<a href="${ctx}/news/nMedia/delete?id=${nMedia.id}" onclick="return confirmx('确认要删除该媒体信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>