// $(function(){
//
// 	//生成病历号
// 	$.ajax({
// 		type:"post",
// 		url:"getPatientNo",
// 		data:{},
// 		dataType:"json",
// 		success:function(data){
// 			console.log(data);
// 			$("#pid").val(data.pno);
// 		}
// 	});
//
// 	//查询挂号级别
// 	$.ajax({
// 		type:"post",
// 		url:"getLevelData",
// 		data:{},
// 		dataType:"json",
// 		success:function(data){
// 			console.log(data);
// 			for(var i=0;i<data.length;i++){
// 				$("#level").append("<option data-cost='"+data[i].cost+"'   value='"+data[i].id+"' >"+data[i].levelname+"</option>")
// 			}
// 		}
// 	});
//
// 	//查询所有科室信息
// 	$.ajax({
// 		type:"post",
// 		url:"getDeptData",
// 		data:{},
// 		dataType:"json",
// 		success:function(data){
// 			console.log(data);
// 			for(var i=0;i<data.length;i++){
// 				$("#dept").append("<option value='"+data[i].id+"' >"+data[i].deptname+"</option>")
// 			}
// 		}
// 	});
//
// 	//查询患者信息，每页显示2条，显示第一页的数据
// 	var pagesize=2;
// 	var pagenum=1;
// 	getPageData();
//
// 	//刷新
// 	$("#div4_1").click(function(){
// 		pagenum=1;
// 		getPageData();
// 		$("#pnum").html(1);
// 	})
//
// 	//上一页
// 	$("#last").click(function(){
// 		if(pagenum-1==0){
// 			alert("没有上一页数据");
// 		}else{
// 			pagenum=pagenum-1;
// 			getPageData();
// 			$("#pnum").html(parseInt($("#pnum").html())-1);
// 		}
// 	})
// 	//下一页
// 	$("#next").click(function(){
// 		pagenum=pagenum+1;
// 		getPageData();
// 		//$("#pnum").html(parseInt($("#pnum").html())+1);
// 	})
//
// 	function  getPageData(){
// 		$.ajax({
// 			type:"post",
// 			url:"getPatientData/"+pagesize+"/"+pagenum,
// 			data:{},
// 			dataType:"json",
// 			success:function(data){
// 				console.log(data);
// 				//如果不是第一页，没有查询到数据
// 				if(pagenum>1 && data.length>0){
// 					$("#pnum").html(parseInt($("#pnum").html())+1);
// 				}
// 				if(pagenum>1 && data.length==0){
// 					alert("没有更多数据了");
// 				}else{
// 					$("#data_table tr:not(:first)").empty();
// 					for(var i=0;i<data.length;i++){
// 						var status="";
// 						if(data[i].pstatus=="已退号"){
// 							status = "已退号";
// 						}else{
// 							status = "正常";
// 						}
// 						$("#data_table").append("<tr><td>"+data[i].pid+"</td><td>"+data[i].pname+"</td><td>"+data[i].sex+"</td>" +
// 								"<td>"+data[i].idcard+"</td><td>"+data[i].createDate+"</td><td>"+data[i].level.levelname+"</td>" +
// 								"<td>"+data[i].pstatus+"</td><td>"+status+"</td><td>"+data[i].dept.deptname+"</td><td>"+data[i].doc.dname+"</td></tr>")
// 					}
// 				}
// 			}
// 		});
//
// 	}
//
//
// 	$("#age").blur(function(){
// 		var age = $("#age").val();
// 		var day = new Date();
// 		var currentYear = day.getFullYear();
// 		var year = currentYear - age;
// 		$("#year").val(year);
// 	})
//
// 	$("#year").blur(function(){
// 		var year = $("#year").val();
// 		var day = new Date();
// 		var currentYear = day.getFullYear();
// 		var age = currentYear - year;
// 		$("#age").val(age);
// 	})
//
// 	//选择科室去变更医生列表
// 	$("#dept").change(function(){
// 		$.ajax({
// 			type:"post",
// 			url:"getDoctorByDept/"+$("#dept").val(),
// 			data:{},
// 			dataType:"json",
// 			success:function(data){
// 				console.log(data);
// 				$("#doctor").empty();
// 				$("#doctor").append("<option value='-1' >------请选择------</option>");
// 				for(var i=0;i<data.length;i++){
// 					$("#doctor").append("<option value='"+data[i].id+"' >"+data[i].dname+"</option>");
// 				}
// 			}
// 		});
// 	})
//
// 	//选择挂号级别得到应收金额
// 	$("#level").change(function(){
// 		var cost = $("#level option:selected").attr("data-cost");
// 		$("#cost").val("0");
// 		var flag = $("#yes");
// 		if(flag[0].checked){
// 			$("#cost").val(parseInt(cost)+1);
// 		}else{
// 			$("#cost").val(parseInt(cost));
// 		}
// 	})
//
// 	//切换是否需要病历本，变更应收金额
// 	$("#yes").click(function(){
// 		var cost = $("#level option:selected").attr("data-cost");
// 		$("#cost").val("0");
// 		$("#cost").val(parseInt(cost)+1);
// 	})
//
// 	$("#no").click(function(){
// 		var cost = $("#level option:selected").attr("data-cost");
// 		$("#cost").val("0");
// 		$("#cost").val(parseInt(cost));
// 	})
//
// 	//挂号
// 	$("#regBtn").click(function(){
// 		$.ajax({
// 			type:"post",
// 			url:"savePatient",
// 			data:$("#form1").serialize(),
// 			dataType:"json",
// 			success:function(data){
// 				console.log(data);
// 				alert("挂号成功");
// 				location.reload();
// 			}
// 		});
//
// 	})
//
// 	//点击退号管理进入退号页面
// 	$("#refund").click(function(){
// 		location.href="outpatient_refund.html";
// 	});
//
// 	//点击门诊收费管理进入收费页面
// 	$("#div1_2").click(function(){
// 		location.href="outpatient_pay.html";
// 	})
//
// })
//
//
//
//
//
//
//
//
//
//
//
//

//这段代码是迄今为止2020年6月28日21:29:39   这个项目最为优秀的地方。
$(function () {
	var cost;//定义一个全局变量cost，记录总价钱
	//进入挂号页面
	$("#div1_1").click(function(){
		location.href="/Patient/PatientController/startPatient";
	});


	//点击门诊收费管理进入收费页面
	$("#div1_2").click(function(){
		location.href="/outpatient_pay.html";
	});

	//点击退号管理进入退号页面
	$("#refund").click(function(){
		location.href="/Patient/PatientController/startRefundPatient";
	});

	$("#levelid").change(function () {//这里的levelid对应的是select标签，即下拉标签，这个标签可以在显示值改变时执行js操作，因此使用.change(function(){})
		cost = $("#levelid option:selected").attr("data-cost");//将选中的select元素的属性data-cost的值赋给cost
		$("#cost").val(cost);//为id为cost的元素赋值，值为cost。
		if(form1.flag.value=='1'){//如果选择的是需要病历本，则总价钱为cost+1
			$("#cost").val(parseInt(cost)+1);
		}
	});
	$("#yes").click(function () {//当“是”被选中时，如果当前的总价钱和挂号费用相等，则需要加上病历本的价钱；否则不执行操作。
		if(parseInt(cost)==$("#cost").val()){
			$("#cost").val(parseInt(cost)+1);
		}
	});

	$("#no").click(function () {//当“否”被选中时，直接将挂号的费用赋给总价钱。
		$("#cost").val(cost);
	});
	//初始化级别
	initLevel();//页面加载将会先执行这个函数。
	function initLevel() {
		$.ajax({//使用ajax请求，查询所有的挂号级别
			url:"/LevelController/selectAll",//ajax请求的路径
			success:function (data) {//ajax请求成功之后执行的回调函数
				// $("#levelid").append("<option value='' data-cost=''>"+""+"</option>");//为id号为levelid的元素，也就是select元素增加一个子元素：<option value='' data-cost=''></option>
			for(var i=0;i<data.length;i++){
				//对获取到的每一个level都生成一个     <option value='id' data-cost='cost'>levelname</option>      操作
				$("#levelid").append("<option value='"+data[i].id+"' data-cost='"+data[i].cost+"'>"+data[i].levelname+"</option>");
			}
			}
		});
	}
	$("#doctor").change(function () {
		var id = $("#doctor option:selected").attr("value");

	});
	$("#dept").change(function () {
		var deptid = $("#dept option:selected").attr("value");
		$.ajax({
			url:"/Doctor/DoctorController/selectByDeptId",
			data:"deptid="+$("#dept").val(),
			success:function (data) {
				$("#doctor").empty();
				$("#doctor").append("<option value=''data-cost=''>"+""+"</option>");
				for(var i=0; i<data.length; i++){
					$("#doctor").append("<option value=" + data[i].id + ">" + data[i].dname + "</option>");
				}
			}
		})
	});

	initDept();
	function initDept() {
		$.ajax({
			url:"/DeptController/selectAll",
			success:function (data) {
				// $("#dept").append("<option value=''>"+""+"</option>")
				for(var i=0; i<data.length;i++){
					$("#dept").append("<option value='"+data[i].id+"'>" + data[i].deptname +"</option>")
				}
			}
		})
	}
	$("#regBtn").click(function () {
		$.ajax({
			url:"/Patient/PatientController/insert",
			data:$("#form1").serialize(),
			method:"post",
			success:function (data) {
				if(data=='yes'){
					alert("恭喜，挂号成功");
					location.href = "/Patient/PatientController/startPatient";
				}else if(data=='no'){
					alert("对不起，挂号失败");
				}
			}
		})
	});
	$("#refresh").click(function () {
		location.reload();
	});




	//查询患者信息，每页显示2条，显示第一页的数据
	var pagesize=2;
	var pagenum=1;
	getPageData();

	//刷新
	$("#div4_1").click(function(){
		pagenum=1;
		getPageData();
		$("#pnum").html(1);
	})

	//上一页
	$("#last").click(function(){
		if(pagenum-1==0){
			alert("没有上一页数据");
		}else{
			pagenum=pagenum-1;
			getPageData();
			if(pagenum==1){
				$("#pnum").html(parseInt($("#pnum").html())-1);
			}else{
				$("#pnum").html(parseInt($("#pnum").html())-2);
			}

		}
	})
	//下一页
	$("#next").click(function(){
		pagenum=pagenum+1;
		getPageData();
		//$("#pnum").html(parseInt($("#pnum").html())+1);
	})

	function  getPageData(){
		$.ajax({
			type:"post",
			url:"/Patient/PatientController/getPatientData",
			data:"pagenum="+pagenum+"&pagesize="+pagesize,
			dataType:"json",
			success:function(data){
				console.log(data);
				//如果不是第一页，没有查询到数据
				if(pagenum>1 && data.length>0){
					$("#pnum").html(parseInt($("#pnum").html())+1);
				}
				if(pagenum>1 && data.length==0){
					pagenum=pagenum-1;
					alert("没有更多数据了");
				}else{
					$("#data_table tr:not(:first)").empty();
					for(var i=0;i<data.length;i++){
						var status="";
						if(data[i].status==0){
							status = "未就诊";
						}else{
							status = "已就诊";
						}

						$("#data_table").append("<tr><td>"+data[i].pid+"</td><td>"+data[i].pname+"</td><td>"+data[i].sex+"</td>" +
							"<td>"+data[i].idcard+"</td><td>"+data[i].createDate+"</td><td>"+data[i].level.levelname+"</td>" +
							"<td>"+status+"</td><td>"+data[i].pstatus+"</td><td>"+data[i].dept.deptname+"</td><td>"+data[i].doc.dname+"</td></tr>")
					}
				}
			}
		});

	}




});