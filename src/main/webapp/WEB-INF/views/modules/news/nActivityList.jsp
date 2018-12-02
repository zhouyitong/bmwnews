<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>活动表管理</title>
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
		<li class="active"><a href="${ctx}/news/nActivity/">活动表列表</a></li>
		<shiro:hasPermission name="news:nActivity:edit"><li><a href="${ctx}/news/nActivity/form">活动表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="nActivity" action="${ctx}/news/nActivity/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>活动名称：</label>
				<form:input path="activityName" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>活动名称</th>
				<th>活动创建时间</th>
				<th>活动创建人</th>
				<shiro:hasPermission name="news:nActivity:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="nActivity">
			<tr>
				<td><a href="${ctx}/news/nActivity/form?id=${nActivity.id}">
					${nActivity.activityName}
				</a></td>
				<td>
					<fmt:formatDate value="${nActivity.activityCreateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${nActivity.activityCreateUser}
				</td>
				<shiro:hasPermission name="news:nActivity:edit"><td>
    				<a href="${ctx}/news/nActivity/form?id=${nActivity.id}">修改</a>
					<a href="${ctx}/news/nActivity/delete?id=${nActivity.id}" onclick="return confirmx('确认要删除该活动表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>