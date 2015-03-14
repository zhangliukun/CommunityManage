<%@page import="cn.zale.model.*"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>报警器列表</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<!-- <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen"> -->
<link rel="stylesheet" href='<c:url value="/css/bootstrap.min.css"/>'>

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
									<li><a href="/tableupload/user/commlist">小区列表</a></li>
								</ul>
								<ul class="nav pull-right">
									<li class="divider-vertical"></li>
									<li class="dropdown"><a class="dropdown-toggle"
										data-toggle="dropdown" href="#">添加</a>
										<ul class="dropdown-menu">
											<li><a href="/tableupload/user/addAlarm/${buildingId}">报警器</a></li>
										</ul></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<c:out value="楼宇编号：${buildingId}" />



	<table id="example" class="table table-striped table-bordered compact"
		cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>报警器ID</th>
				<th>报警器编号</th>
				<th>报警器x</th>
				<th>报警器y</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${alarm_arrays}" var="array"
				varStatus="loopCounter">
				<tr>
					<td><c:out value="${array.alarmId}" /></td>
					<td><c:out value="${array.alarmFont}" /></td>
					<td><c:out value="${array.alarmX}" /></td>
					<td><c:out value="${array.alarmY}" /></td>
					<td><a href="/tableupload/user/editAlarm/${array.alarmId}">编辑</a>
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

