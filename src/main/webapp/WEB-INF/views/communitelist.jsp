<%@page import="cn.zale.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>小区列表</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<!-- <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen"> -->
<link rel="stylesheet" href='<c:url value="/css/bootstrap.min.css"/>'>
<!-- DataTables CSS -->
<link rel="stylesheet" type="text/css"
	href="//cdn.datatables.net/1.10.4/css/jquery.dataTables.css">
</head>

<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<div class="navbar">
					<div class="navbar-inner">
						<div class="container-fluid">
							<a class="btn btn-navbar"
								data-target=".navbar-responsive-collapse" data-toggle="collapse"></a>
							<a class="brand" href="#">zalezone</a>
							<div class="nav-collapse collapse navbar-responsive-collapse">
								<ul class="nav">
									<li class="active"><a href="/tableupload/user/commlist">小区列表</a></li>
								</ul>
								<ul class="nav pull-right">
									<li class="divider-vertical"></li>
									<li class="dropdown"><a class="dropdown-toggle"
										data-toggle="dropdown" href="#">添加</a>
										<ul class="dropdown-menu">
											<li><a href="addCommunite">小区</a></li>
										</ul></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<table id="example" class="table table-striped table-bordered compact"
		cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>小区编号</th>
				<th>小区代号</th>
				<th>小区名字</th>
				<th>操作</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${community_arrays}" var="array"
				varStatus="loopCounter">
				<tr>
					<td><a href="buildinglist/${array.areaId}">${array.areaId}</a></td>
					<td><c:out value="${array.areaName}" /></td>
					<td><c:out value="${array.areaChinese}" /></td>
					<td><a href="editCommunite/${array.areaId}">编辑</a>&nbsp;&nbsp;&nbsp;<a
						href="showImage/${array.areaId}">图片</a></td>
				</tr>

			</c:forEach>
		</tbody>

	</table>
	<script type="text/javascript"
		src='<c:url value="/js/lib/jquery-1.10.2.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/js/bootstrap.min.js"/>'></script>
	<!-- 	<script src="/js/lib/jquery-1.10.2.js"></script> -->
	<!-- 	<script src="/js/bootstrap.min.js"></script> -->



	<!-- DataTables -->
	<script type="text/javascript" charset="utf8"
		src="//cdn.datatables.net/1.10.4/js/jquery.dataTables.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#example').dataTable({});
		});
	</script>

</body>
</html>

