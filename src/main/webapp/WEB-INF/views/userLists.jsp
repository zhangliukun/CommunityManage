<%@page import="cn.zale.model.User"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>List Of Users</title>

<link rel="stylesheet" href='<c:url value="/css/pure-0.4.2.css"/>'>

<link rel="stylesheet"
	href='<c:url value="/css/font-awesome-4.0.3/css/font-awesome.css"/>'>

<link rel="stylesheet"
	href='<c:url value="/css/jquery-ui-1.10.4.custom.css"/>'>

<style type="text/css">
th {
	text-align: left
}
</style>

<script type="text/javascript">  
function ajaxFileUpload(id){  
	
	alert("方法被调用");
    //开始上传文件时显示一个图片,文件上传完成将图片隐藏  
    //$("#loading").ajaxStart(function(){$(this).show();}).ajaxComplete(function(){$(this).hide();});  
    //执行上传文件操作的函数  
    $.ajaxFileUpload({  
        //处理文件上传操作的服务器端地址(可以传参数,已亲测可用)  
        
        url:'${pageContext.request.contextPath}/user/upload/1',  
        secureuri:false,                           //是否启用安全提交,默认为false   
        fileElementId:'myBlogImage',               //文件选择框的id属性  
        dataType:'text',                           //服务器返回的格式,可以是json或xml等  
        success:function(data, status){            //服务器响应成功时的处理函数  
            data = data.replace(/<pre.*?>/g, '');  //ajaxFileUpload会对服务器响应回来的text内容加上<pre style="....">text</pre>前后缀  
            if(data.substring(0, 1) == 0){         //0表示上传成功(后跟上传后的文件路径),1表示失败(后跟失败描述)  
                $("img[id='uploadImage']").attr("src", data.substring(2));  
                $('#result').html("图片上传成功<br/>");  
            }else{  
                $('#result').html('图片上传失败，请重试！！');  
            }  
        },  
        error:function(data, status, e){ //服务器响应失败时的处理函数  
            $('#result').html('图片上传失败，请重试！！');  
        }  
    });  
}  
</script>

</head>

<body>
	<div style="width: 95%; margin: 0 auto;">

		<h1>List Of users</h1>

		<!-- 		<button class="pure-button pure-button-primary" onclick="addBook()"> -->
		<!-- 			<i class="fa fa-plus"></i> 增加书本 -->
		<!-- 		</button> -->
		<br>
		<table>
			<thead>
				<tr>
					<!-- 					<th width="4%">S.N</th> -->
					<th width="12%">Id</th>
					<th width="12%">Name</th>
					<th width="12%">Password</th>
					<th width="12%">Age</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userList}" var="user" varStatus="loopCounter">
					<tr>
						<%-- 						<td><c:out value="${loopCounter.count}" /></td> --%>
						<td><c:out value="${user.id}" /></td>
						<td><c:out value="${user.name}" /></td>
						<td><c:out value="${user.password}" /></td>
						<td><c:out value="${user.age}" /></td>

						<td><nobr>
								<button class="pure-button pure-button-primary"
									onclick="editBook(${book.id});">
									<i class="fa fa-pencil"></i> 编辑
								</button>

								<a class="pure-button pure-button-primary"
									onclick="return confirm('Are you sure you want to delete this book?');"
									href="delete/${book.id}"> <i class="fa fa-times"></i>删除
								</a>

								<!-- <input id="fileupload" type="file" name="files" data-url="" multiple>   -->
								
								<!-- 判断数据库中是否有图片，考虑写两个类，这样减少数据传输所带来的损耗 -->
<%-- 								<% if(user.hasImage){ %> --%>
								<input type="file" id="myBlogImage" name="myfiles" /> <input
									type="button" value="上传图片" onclick="ajaxFileUpload(${user.id})" />
<%-- 									<%} %> --%>
									
							</nobr></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>

	</div>




	<!--  It is advised to put the <script> tags at the end of the document body so they don't block rendering of the page -->
	<script type="text/javascript"
		src='<c:url value="/js/lib/jquery-1.10.2.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/js/lib/jquery-ui-1.10.4.custom.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/js/lib/jquery.ui.datepicker.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/js/lib/ajaxfileupload.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/js/js-for-listBooks.js"/>'></script>
	<!-- 	<script type="text/javascript" -->
	<%-- 		src='<c:url value="/web-resources/js/uploadfile.js"/>'></script> --%>
</body>
</html>