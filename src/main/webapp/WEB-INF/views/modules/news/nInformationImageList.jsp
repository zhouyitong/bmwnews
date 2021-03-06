<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>资讯图片表管理</title>
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
		<li class="active"><a href="${ctx}/news/nInformationImage/">资讯图片表列表</a></li>
		<shiro:hasPermission name="news:nInformationImage:edit"><li><a href="${ctx}/news/nInformationImage/form">资讯图片表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="nInformationImage" action="${ctx}/news/nInformationImage/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>图片文件路径：</label>
				<form:input path="imageFilePath" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>图片文件路径</th>
				<th>资讯正文图片上传时间</th>
				<th>资讯正文图片上传人</th>
				<shiro:hasPermission name="news:nInformationImage:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="nInformationImage">
			<tr>
				<td><a href="${ctx}/news/nInformationImage/form?id=${nInformationImage.id}">
					${nInformationImage.imageFilePath}
				</a></td>
				<td>
					<fmt:formatDate value="${nInformationImage.imageUploadTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${nInformationImage.imageUploadUser}
				</td>
				<shiro:hasPermission name="news:nInformationImage:edit"><td>
    				<a href="${ctx}/news/nInformationImage/form?id=${nInformationImage.id}">修改</a>
					<a href="${ctx}/news/nInformationImage/delete?id=${nInformationImage.id}" onclick="return confirmx('确认要删除该资讯图片表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>