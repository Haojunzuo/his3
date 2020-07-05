// $(function(){
//
// 	//点击病例进入病例页面
// 	$("#div1_1").click(function(){
// 		location.href="/PatientController/selectPatients1";
// 	})
//
// 	//点击检验申请进入下一页面
// 	$("#div1_3").click(function(){
// 		location.href="doctor_inspectitem.html";
// 	})
//
// 	//点击检查申请进入检查申请页面
// 	$("#div1_2").click(function(){
// 		location.href="doctor_checkitem.html";
// 	})
//
// 	$("#search").click(function(){
// 		var pid = $("#pid").val();
// 		if(pid==""){
// 			alert("请输入要查询的病历号");
// 		}else if(isNaN(pid)){
// 			alert("病历号必须为数字");
// 		}else{
// 			$.ajax({
//
// 				type:"post",
// 				url:"selectPatients1/getPatientAndMrData/"+pid,
// 				data:{},
// 				dataType:"json",
// 				success:function(data){
// 					console.log(data);
// 					if(data.pid==0){
// 						alert("系统中不存在该患者");
// 					}else{
// 						$("#pno").val(data.pid);
// 						$("#pname").val(data.pname);
// 						if(data.sex=="男"){
// 							$("#sex1")[0].checked=true;
// 						}else{
// 							$("#sex0")[0].checked=true;
// 						}
// 						$("#createdate").val(data.createDate);
// 						$("#idcard").val(data.idcard);
// 						$("#level").val(data.level.levelname);
// 						if(data.pstatus=="未看诊" || data.pstatus=="已退号"){
// 							$("#pstatus").html("否");
// 						}else{
// 							$("#pstatus").html("是");
// 						}
// 						if(data.pstatus=="已退号"){
// 							$("#status").html("已退号");
// 						}else{
// 							$("#status").html("正常");
// 						}
// 						$("#deptname").val(data.dept.deptname);
// 						$("#dname").val(data.doc.dname);
// 						//显示病例信息
// 						$("#description").html(data.mr.description);
// 						$("#medicalhistory").html(data.mr.medicalhistory);
// 						$("#familyhistory").html(data.mr.familyhistory);
// 						$("#initialresult").html(data.mr.initialresult);
// 						$("#result").html(data.mr.result);
// 						$("#finalresult").html(data.mr.finalresult);
// 						$("#id").val(data.mr.id);
// 					}
// 				}
// 			});
// 		}
// 	});
//
// 	//提交确诊结果
// 	$("#submitItem").click(function(){
// 		if($("#pid").val()==""){
// 			alert("请先选择患者！")
// 		}else{
// 			$.ajax({
// 				type:"post",
// 				url:"updateMedicalRecord",
// 				data:$("#form1").serialize(),
// 				dataType:"json",
// 				success:function(data){
// 					console.log(data);
// 					alert(data.result);
// 					location.href="doctor_medicalrecord.jsp";
// 				}
// 			});
// 		}
// 	})
//
//
//
// })

$(function () {
	//点击病例进入病例页面
	$("#div1_1").click(function(){
		location.href="/Patient/MedicalRecordController/startMedicalRecord";
	});

	//点击检验申请进入下一页面
	$("#div1_3").click(function(){
		location.href="doctor_inspectitem.html";
	});

	//点击检查申请进入检查申请页面
	$("#div1_2").click(function(){
		location.href="doctor_checkitem.html";
	});
	// $("#search").click(function () {
	// 	var pid = $("#pid").val();
	// 	if(pid==""){
	// 		alert("请输入要查询的病历号");
	// 	}else if(isNaN(pid)){
	// 		alert("病历号必须为数字");
	// 	}else {
	// 		$.ajax({
	// 			"url":"/Patient/PatientController/selectPatientById?pid="+pid,
	// 			"success":function (data) {
	// 				if(data.pid==0){
	// 					alert("系统中不存在该患者");
	// 				}else{
	// 					$("#pno").val(data.pid);
	// 					$("#pname").val(data.pname);
	// 					if(data.sex=="男"){
	// 						$("#sex1")[0].checked=true;
	// 					}else{
	// 						$("#sex0")[0].checked=true;
	// 					}
	// 					$("#createdate").val(data.createdate);
	// 					$("#idcard").val(data.idcard);
	// 					if(data.status==0){
	// 						$("#status").text("未诊");//这里使用text和html都可以
	// 					}
	// 					if(data.status==1){
	// 						$("#status").text("已诊");
	// 					}
	// 					if(data.pstatus=="已退号"){
	// 						$("#pstatus").html("已退号");
	// 					}else{
	// 						$("#pstatus").html("正常");
	// 					}
	// 					myLevel(data.levelid);
	// 					myDoctor(data.doctorid);
	// 					myDept(data.deptid);
	// 					myMedicalRecord(data.pid);
	// 				}
	// 			}
	// 		});
	// 	}
	//
	// });
	// function myLevel(levelid) {
	// 	$.ajax({
	// 		"url":"/LevelController/getLevelById?levelid="+levelid,
	// 		// "data":"levelid="+levelid,//也可以用这种方法向后端传输levelid
	// 		"success":function (data) {
	// 			$("#level").val(data.levelname);
	// 		}
	// 	})
	// }
	// function myDoctor(doctorid) {
	// 	$.ajax({
	// 		"url":"/DoctorController/getDoctorById?doctorid="+doctorid,
	// 		"success":function (data) {
	// 			$("#dname").val(data.dname)
	// 		}
	// 	})
	// }
	// function myDept(deptid) {
	// 	$.ajax({
	// 		"url":"/DeptController/getDeptById?deptid="+deptid,
	// 		"success":function (data) {
	// 			$("#deptname").val(data.deptname)
	// 		}
	// 	})
	// }
	$("#search").click(function () {
		var flag=0;
		if($("#pid").val()==''){
			alert("您没有要查找的病历号！");
			location.reload()
		}else if(isNaN($("#pid").val())==true){
			alert("对不起，病历号必须是数字！");
			location.reload();
		}else{
			$.ajax({
				url:"/Doctor/MedicalRecordController/startMedicalRecord",
				data:"pid="+$("#pid").val(),
				success:function (data) {
					if(data.pid==-1){
						alert("没查到！");
						location.reload();
					}else{
						$("#pno").val(data.pid);
						$("#pname").val(data.pname);
						if(data.sex=='男'){
							$("input[name='sex']:eq(0)").prop("checked",true);//也可以用$("#sex0")[0].checked=true;
						}else{
							$("input[name='sex']:eq(1)").prop("checked",true);
						}
						$("#createdate").val(data.createDate);
						$("#idcard").val(data.idcard);
						$("#pstatus").text(data.pstatus);
						if(data.status==0){
							$("#status").text("未就诊");
						}else{
							$("#status").text("已就诊");
						}
						$("#dname").val(data.doc.dname);
						$("#deptname").val(data.dept.deptname);
						$("#level").val(data.level.levelname);
						if(data.medicalRecord!=null){
							$("#description").val(data.medicalRecord.description);
							$("#medicalhistory").val(data.medicalRecord.medicalhistory);
							$("#familyhistory").val(data.medicalRecord.familyhistory);
							$("#initialresult").val(data.medicalRecord.initialresult);
							if(data.medicalRecord.result==null||data.medicalRecord.finalresult==null||data.medicalRecord.result==""||data.medicalRecord.finalresult==""){
								$("#result").val("");
								$("#finalresult").val("");
								$("#result").attr("readonly",false);
								$("#finalresult").attr("readonly",false);
								$("#submitItem").attr("disabled",false);
								$("#submitItem").css("color","green");

							}else if(data.medicalRecord.result!=null&&data.medicalRecord.result!=""&&data.medicalRecord.finalresult!=null&&data.medicalRecord.finalresult!=""){
								$("#result").val(data.medicalRecord.result);
								$("#finalresult").val(data.medicalRecord.finalresult);
								$("#result").attr("readonly",true);
								$("#finalresult").attr("readonly",true);
								$("#submitItem").attr("disabled",true);
								$("#submitItem").css("color","grey");
							}
						}else {
							$("#description").val("");
							$("#medicalhistory").val("");
							$("#familyhistory").val("");
							$("#initialresult").val("");
							$("#result").val("");
							$("#finalresult").val("");
							$("#result").attr("readonly",true);
							$("#finalresult").attr("readonly",true);
							$("#submitItem").attr("disabled",true);
							$("#submitItem").css("color","grey");
						}

						$("#submitItem").click(function () {
							$.ajax({
								url:"/MedicalRecordController/update",
								data:"result="+$("#result").val()+"&finalresult="+$("#finalresult").val()+"&pid="+$("#pno").val(),
								// data:$("#form1").serialize(),
								success:function (data) {
									if(data==1){
										alert("确诊成功");
										$("#submitItem").attr("disabled",true);
										$("#submitItem").css("color","grey");
									}else{
										alert("确诊失败");
									}
								}
							})
						})


						// if (data.pstatus=="已挂号"&&data.status==0){
						// 	$("#refund").attr("disabled",false);
						// 	$("#refund").css("color","blue");
						// 	// $("#refund")[0].disabled=false;
						// 	// $("#refund")[0].style.color="blue";
						// }else{
						// 	$("#refund").attr("disabled",true);
						// 	$("#refund").css("color","grey");
						// 	// $("#refund")[0].disabled=true;
						// 	// $("#refund")[0].style.color="grey";
						// }
					}

				}
			})
		}

	});

});