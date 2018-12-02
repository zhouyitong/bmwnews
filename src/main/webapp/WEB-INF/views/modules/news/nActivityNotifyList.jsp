<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>活动通知表管理</title>
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
		<li class="active"><a href="${ctx}/news/nActivityNotify/">活动通知表列表</a></li>
		<shiro:hasPermission name="news:nActivityNotify:edit"><li><a href="${ctx}/news/nActivityNotify/form">活动通知表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="nActivityNotify" action="${ctx}/news/nActivityNotify/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>通知发送对象0所有参加活动的记者1某个记者分组2单个记者：</label>
				<form:input path="notifySendObject" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>活动通知创建人：</label>
				<form:input path="notifyCreateUser" htmlEscape="false" maxlength="40" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>通知发送对象0所有参加活动的记者1某个记者分组2单个记者</th>
				<th>发送时间</th>
				<th>活动通知创建时间</th>
				<th>活动通知创建人</th>
				<shiro:hasPermission name="news:nActivityNotify:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="nActivityNotify">
			<tr>
				<td><a href="${ctx}/news/nActivityNotify/form?id=${nActivityNotify.id}">
					${nActivityNotify.notifySendObject}
				</a></td>
				<td>
					<fmt:formatDate value="${nActivityNotify.notifySendTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${nActivityNotify.notifyCreateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${nActivityNotify.notifyCreateUser}
				</td>
				<shiro:hasPermission name="news:nActivityNotify:edit"><td>
    				<a href="${ctx}/news/nActivityNotify/form?id=${nActivityNotify.id}">修改</a>
					<a href="${ctx}/news/nActivityNotify/delete?id=${nActivityNotify.id}" onclick="return confirmx('确认要删除该活动通知表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>