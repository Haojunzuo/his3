<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<title>东软云医院登录页面</title>
		<base href="${pageContext.request.contextPath}">
		<link rel="stylesheet" href="css/login.css" />
		<link rel="stylesheet" href="css/common.css" />
		<script type="text/javascript" src="js/jquery-3.2.1.min.js"  ></script>
		<script type="text/javascript" src="js/login.js"  ></script>
	</head>
	<body>
		<div id="div1" >
			<div  id="div1_1" >
				东软云医院管理系统
			</div>
			<form action=""  id="form1"  >
			<div class="div1_data"  >
				<div class="data_name"  >
					用户名：
				</div>
				<div>
					<input  class="form_control"  name="username"  id="username"  type="text" />
				</div>
			</div>
			<div class="div1_data" >
				<div class="data_name"  >
					密&nbsp;&nbsp;&nbsp;&nbsp;码：
				</div>
				<div>
					<input type="password"  name="password" id="password" class="form_control"   />
				</div>
			</div>
			<div class="div1_data" >
				<div  class="data_name"  >
					角&nbsp;&nbsp;&nbsp;&nbsp;色：
				</div>
				<div>
					<select  id="role" name="role"   >
						<option value="-1"  >------请选择------</option>
<%--						<option value="门诊管理员" >门诊管理员</option>--%>
<%--						<option value="医生管理员" >医生管理员</option>--%>
					</select>
				</div>
			</div>
			</form>
			<div  id="div1_2"  >
				<button type="button" id="loginBtn"   >登&nbsp;&nbsp;&nbsp;&nbsp;录</button>
			</div>
		</div>
	</body>
</html>
