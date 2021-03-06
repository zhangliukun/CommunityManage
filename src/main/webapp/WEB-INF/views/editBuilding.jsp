<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="cn.zale.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>修改楼宇信息</title>
<link rel="stylesheet" href='<c:url value="/css/bootstrap.min.css"/>'>

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
											<li><a href="/tableupload/user/addCommunite">小区</a></li>
										</ul></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<form
					action="/tableupload/user/editBuildingFinished/${building.buildingId}"
					enctype="multipart/form-data" method="post">
					<fieldset>
						<legend> 小区编号 ${building.areaId} </legend>
						<label>楼宇号码</label><input type="text" name="buildingNumber"
							value="${building.buildingNumber}" /> <label>楼宇X轴</label><input
							type="text" name="buildingX" value="${building.buildingX}" /> <label>楼宇Y轴</label><input
							type="text" name="buildingY" value="${building.buildingY}" /> <label>楼宇图片</label><input
							type="file" id="myBlogImage" name="myfiles" /> <br>
						<button type="submit" class="btn">提交</button>
					</fieldset>
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src='<c:url value="/js/lib/jquery-1.10.2.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/js/bootstrap.min.js"/>'></script>

</body>
</html>