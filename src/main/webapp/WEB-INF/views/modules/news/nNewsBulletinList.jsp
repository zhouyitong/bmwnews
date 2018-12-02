<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>新闻简报表管理</title>
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
		<li class="active"><a href="${ctx}/news/nNewsBulletin/">新闻简报表列表</a></li>
		<shiro:hasPermission name="news:nNewsBulletin:edit"><li><a href="${ctx}/news/nNewsBulletin/form">新闻简报表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="nNewsBulletin" action="${ctx}/news/nNewsBulletin/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>简报媒体名字：</label>
				<form:input path="bulletinMediaName" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>简报作者：</label>
				<form:input path="bulletinReporterId" htmlEscape="false" maxlength="40" class="input-medium"/>
			</li>
			<li><label>简报发布时间：</label>
				<input name="bulletinPublishTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${nNewsBulletin.bulletinPublishTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
				<th>简报媒体名字</th>
				<th>简报作者</th>
				<th>简报发布时间</th>
				<shiro:hasPermission name="news:nNewsBulletin:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="nNewsBulletin">
			<tr>
				<td><a href="${ctx}/news/nNewsBulletin/form?id=${nNewsBulletin.id}">
					${nNewsBulletin.bulletinMediaName}
				</a></td>
				<td>
					${nNewsBulletin.bulletinReporterId}
				</td>
				<td>
					<fmt:formatDate value="${nNewsBulletin.bulletinPublishTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="news:nNewsBulletin:edit"><td>
    				<a href="${ctx}/news/nNewsBulletin/form?id=${nNewsBulletin.id}">修改</a>
					<a href="${ctx}/news/nNewsBulletin/delete?id=${nNewsBulletin.id}" onclick="return confirmx('确认要删除该新闻简报表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>