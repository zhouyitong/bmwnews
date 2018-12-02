<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>活动邀请媒体表管理</title>
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
		<li class="active"><a href="${ctx}/news/nActivityMedia/">活动邀请媒体表列表</a></li>
		<shiro:hasPermission name="news:nActivityMedia:edit"><li><a href="${ctx}/news/nActivityMedia/form">活动邀请媒体表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="nActivityMedia" action="${ctx}/news/nActivityMedia/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>活动受邀记者ID：</label>
				<form:input path="reporterId" htmlEscape="false" maxlength="40" class="input-medium"/>
			</li>
			<li><label>媒体名称：</label>
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
				<th>活动受邀记者ID</th>
				<th>活动受邀记者名称</th>
				<th>媒体名称</th>
				<th>发送邀请时间</th>
				<shiro:hasPermission name="news:nActivityMedia:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="nActivityMedia">
			<tr>
				<td><a href="${ctx}/news/nActivityMedia/form?id=${nActivityMedia.id}">
					${nActivityMedia.reporterId}
				</a></td>
				<td>
					${nActivityMedia.reporterName}
				</td>
				<td>
					${nActivityMedia.mediaName}
				</td>
				<td>
					<fmt:formatDate value="${nActivityMedia.reporterInvitationTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="news:nActivityMedia:edit"><td>
    				<a href="${ctx}/news/nActivityMedia/form?id=${nActivityMedia.id}">修改</a>
					<a href="${ctx}/news/nActivityMedia/delete?id=${nActivityMedia.id}" onclick="return confirmx('确认要删除该活动邀请媒体表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>