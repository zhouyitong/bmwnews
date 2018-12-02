<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>活动新闻稿表管理</title>
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
		<li class="active"><a href="${ctx}/news/nActivityNews/">活动新闻稿表列表</a></li>
		<shiro:hasPermission name="news:nActivityNews:edit"><li><a href="${ctx}/news/nActivityNews/form">活动新闻稿表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="nActivityNews" action="${ctx}/news/nActivityNews/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>新闻稿标题：</label>
				<form:input path="newsTitle" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>新闻稿创建用户：</label>
				<form:input path="newsCreateUser" htmlEscape="false" maxlength="40" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>新闻稿标题</th>
				<th>新闻稿创建时间</th>
				<th>新闻稿创建用户</th>
				<shiro:hasPermission name="news:nActivityNews:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="nActivityNews">
			<tr>
				<td><a href="${ctx}/news/nActivityNews/form?id=${nActivityNews.id}">
					${nActivityNews.newsTitle}
				</a></td>
				<td>
					<fmt:formatDate value="${nActivityNews.newsCreateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${nActivityNews.newsCreateUser}
				</td>
				<shiro:hasPermission name="news:nActivityNews:edit"><td>
    				<a href="${ctx}/news/nActivityNews/form?id=${nActivityNews.id}">修改</a>
					<a href="${ctx}/news/nActivityNews/delete?id=${nActivityNews.id}" onclick="return confirmx('确认要删除该活动新闻稿表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>