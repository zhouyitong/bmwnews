<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>资讯发布者表管理</title>
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
		<li class="active"><a href="${ctx}/news/nInformationPublisher/">资讯发布者表列表</a></li>
		<shiro:hasPermission name="news:nInformationPublisher:edit"><li><a href="${ctx}/news/nInformationPublisher/form">资讯发布者表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="nInformationPublisher" action="${ctx}/news/nInformationPublisher/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>发布者名字：</label>
				<form:input path="publisherName" htmlEscape="false" maxlength="40" class="input-medium"/>
			</li>
			<li><label>发布者创建人：</label>
				<form:input path="publisherCreateUser" htmlEscape="false" maxlength="40" class="input-medium"/>
			</li>
			<li><label>发布者更新时间：</label>
				<input name="publishUpdateTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${nInformationPublisher.publishUpdateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>发布者名字</th>
				<th>发布者创建时间</th>
				<th>发布者创建人</th>
				<th>发布者更新时间</th>
				<shiro:hasPermission name="news:nInformationPublisher:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="nInformationPublisher">
			<tr>
				<td><a href="${ctx}/news/nInformationPublisher/form?id=${nInformationPublisher.id}">
					${nInformationPublisher.publisherName}
				</a></td>
				<td>
					<fmt:formatDate value="${nInformationPublisher.publisherCreateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${nInformationPublisher.publisherCreateUser}
				</td>
				<td>
					<fmt:formatDate value="${nInformationPublisher.publishUpdateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="news:nInformationPublisher:edit"><td>
    				<a href="${ctx}/news/nInformationPublisher/form?id=${nInformationPublisher.id}">修改</a>
					<a href="${ctx}/news/nInformationPublisher/delete?id=${nInformationPublisher.id}" onclick="return confirmx('确认要删除该资讯发布者表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>