<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>活动图片表管理</title>
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
		<li class="active"><a href="${ctx}/news/nActivityIamge/">活动图片表列表</a></li>
		<shiro:hasPermission name="news:nActivityIamge:edit"><li><a href="${ctx}/news/nActivityIamge/form">活动图片表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="nActivityIamge" action="${ctx}/news/nActivityIamge/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>活动主键：</label>
				<form:input path="activityId" htmlEscape="false" maxlength="40" class="input-medium"/>
			</li>
			<li><label>图片上传时间：</label>
				<input name="imageUploadTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${nActivityIamge.imageUploadTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>图片上传人：</label>
				<form:input path="imageUploadUser" htmlEscape="false" maxlength="40" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>活动主键</th>
				<th>图片上传时间</th>
				<th>图片上传人</th>
				<shiro:hasPermission name="news:nActivityIamge:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="nActivityIamge">
			<tr>
				<td><a href="${ctx}/news/nActivityIamge/form?id=${nActivityIamge.id}">
					${nActivityIamge.activityId}
				</a></td>
				<td>
					<fmt:formatDate value="${nActivityIamge.imageUploadTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${nActivityIamge.imageUploadUser}
				</td>
				<shiro:hasPermission name="news:nActivityIamge:edit"><td>
    				<a href="${ctx}/news/nActivityIamge/form?id=${nActivityIamge.id}">修改</a>
					<a href="${ctx}/news/nActivityIamge/delete?id=${nActivityIamge.id}" onclick="return confirmx('确认要删除该活动图片表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>