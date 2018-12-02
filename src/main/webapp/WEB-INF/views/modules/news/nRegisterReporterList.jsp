<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>媒体记者注册管理</title>
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
		<li class="active"><a href="${ctx}/news/nRegisterReporter/">媒体记者注册列表</a></li>
		<shiro:hasPermission name="news:nRegisterReporter:edit"><li><a href="${ctx}/news/nRegisterReporter/form">媒体记者注册添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="nRegisterReporter" action="${ctx}/news/nRegisterReporter/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>记者名字</th>
				<th>所属媒体</th>
				<th>所属媒体名字</th>
				<th>注册时间</th>
				<th>最后登陆时间</th>
				<shiro:hasPermission name="news:nRegisterReporter:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="nRegisterReporter">
			<tr>
				<td><a href="${ctx}/news/nRegisterReporter/form?id=${nRegisterReporter.id}">
					${nRegisterReporter.reporterName}
				</a></td>
				<td>
					${nRegisterReporter.reporterOwnMedia}
				</td>
				<td>
					${nRegisterReporter.reporterOwnMediaName}
				</td>
				<td>
					<fmt:formatDate value="${nRegisterReporter.reporterRegistryTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${nRegisterReporter.reporterLastLoginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="news:nRegisterReporter:edit"><td>
    				<a href="${ctx}/news/nRegisterReporter/form?id=${nRegisterReporter.id}">修改</a>
					<a href="${ctx}/news/nRegisterReporter/delete?id=${nRegisterReporter.id}" onclick="return confirmx('确认要删除该媒体记者注册吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>