$(function(){//页面的初始化行为，有三种语法形式：$(document).ready(function(){});      $().ready(function(){});   $(function(){});

	//自动填充角色信息
	//AJAX即asynchronous JavaScript and xml 异步的JavaScript和xml技术，他不是一门新的语言或技术，而是由JavaScript，xml，dom
	//css等多种已有的技术组合而成的一种浏览器端技术，用于实现与服务器进行异步交互的功能。采用按需获取数据的方式。
	$.ajax({
		url:"/UserController/selectRoles",//处理AJAX请求的服务器地址
		success:function (data) {//data表示传递的参数，这里的data是从url获取到的数据，success表示AJAX请求成功时触发的回调函数。
			for(var i=0;i<data.length;i++){
				$("#role").append("<option value='"+data[i]+"'>"+data[i]+"</option>");
			}
		}
	});

	$("#loginBtn").click(function () {
		if($("#username").val()==''){//如果id为username的元素的值为空，发出警告。  if($("#username").val()==''){}
			alert("对不起，用户不能为空！");
			return;
		}
		if($("#password").val()==''){
			alert("对不起，密码不能为空！");
			return;
		}
		$.ajax({
			url:"/UserController/selectUser",
			data:$("#form1").serialize(),//和实体类中的属性一致,这里的data是url对应的服务器地址执行之后的结果，其结果是user.getRole();就是role。
			method:"post",
			success:function (data) {
				// alert(data);
				if (data=="门诊管理员"){
					location.href = "Patient/PatientController/startPatient";//可以调用页面，但是页面不好拦截
				}else if(data=="医生管理员"){
					location.href = "Patient/PatientController/selectPatients";
				}else if(data=="error"){
					alert("对不起，登录信息有误，请重新登录！");
				}
			}
		})
	});
});
