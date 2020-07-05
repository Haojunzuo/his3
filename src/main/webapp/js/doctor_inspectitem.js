$(function () {

	initInspectItem();
	function initInspectItem(){
		$.ajax({
			url:"/Doctor/InspectItemController/selectAll",
			success:function (data) {
				if(data!=null){
					$("#inspectitem").append("<option value=''></option>");
					for(var i=0; i<data.length; i++){
						$("#inspectitem").append("<option value='"+data[i].id+"' data-price='"+data[i].price +"'>"+data[i].inspectname+"</option>");
					}
				}
			}
		})
	}

	$("#inspectitem").change(function () {
		var flag = false;
		if($("#status").text()=='已就诊'&&$("#pstatus").text()=='已挂号'){
			flag = true;
		}else{
			flag = false;
		}
		if(flag==true){
			if($("#inspectitem option:selected").text()!=''){
				$("#item_data").append("<tr><td>"+"<input type='hidden' value='"+$("#inspectitem option:selected").val()+"'>"+$("#inspectitem option:selected").text()+ "</td><td>1</td><td><span>"+$("#inspectitem option:selected").attr("data-price")+"</span></td><td><input type='button' value='删除' class='del'></td></tr>")
			}
		}else{
			alert("对不起，您不符合检验的条件");
		}
	});

	$(document).on("click",".del",function () {
		$(this).parent().parent().remove();
	});

	$("#submitItem").click(function () {
		if($("#item_data tr").length<=1){
			alert("对不起，申请提交检验失败");
		}else{
			var i = -1;
			$("#info").html("");
			$("#item_data tr:gt(0)").each(function () {
				i++;
				var inspectid=$(this).find(":first :hidden").val();
				var pid=$("#pid").val();
				var amount=$(this).find("td span").text();
				$("#info").html($("#info").html()+"<input type='hidden' value='"+inspectid+"' name='iirList["+i+"].inspectid'>"+"<input type='hidden' value='"+pid+"' name='iirList["+i+"].pid'>"+"<input type='hidden' value='"+amount+"' name='iirList["+i+"].amount'>")
			});
			$.ajax({
				url:"/Doctor/InspectItemController/createInspectItemRecord",
				data:$("#form1").serialize(),
				success:function (data) {
					if(data=='yes'){
						alert("恭喜，提交检验成功");
					}else{
						alert("对不起，提交检验失败");
					}

				}
			})
		}

	})




	$("#div1_1").click(function(){
		// location.href="doctor_medicalrecord.jsp";
		location.href ="/Doctor/MedicalRecordController/startMedicalRecord";
	});

	//点击检查申请进入下一页面
	$("#div1_2").click(function(){
		location.href="/Doctor/CheckItemController/startCheckItem";
	});

	//点击确诊进入确诊页面
	$("#div1_4").click(function(){
		location.href="doctor_result.html";
	})
})


// $(function(){
// 	//初始化查询系统中所有检验项目
// 	$.ajax({
// 		type:"post",
// 		url:"getAllInspectItem",
// 		data:{},
// 		dataType:"json",
// 		success:function(data){
// 			console.log(data);
// 			for(var i=0;i<data.length;i++){
// 				$("#inspectitem").append("<option value='"+data[i].id+"'  data-price='"+data[i].price+"'   >"+data[i].inspectname+"</option>");
// 			}
// 		}
// 	});
//
// 	//根据病历号查询患者
// 	$("#search").click(function(){
// 		var pid = $("#pid").val();
// 		if(pid==""){
// 			alert("请输入要查询的病历号");
// 		}else if(isNaN(pid)){
// 			alert("病历号必须为数字");
// 		}else{
// 			$.ajax({
// 				type:"post",
// 				url:"getPatientByNo/"+pid,
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
// 					}
// 				}
// 			});
// 		}
// 	})
//
// 	var num=0;
//
// 	//选择菜单中的检查项目，变更页面表格数据
// 	$("#inspectitem").change(function(){
// 		var selectedOption = $("#inspectitem option:selected");
//
// 		//如果选择的是请选择，则方法执行结束
// 		if(selectedOption[0].value!=-1){
// 			//如果表格中已经有该检查项目，则不进行追加
// 			var tds = $("#item_data tr").find("td:eq(0)");
// 			//默认该选项没被选择过
// 			var flag=false;
// 			for(var k=0;k<tds.length;k++){
// 				if($(tds[k]).html()==selectedOption[0].text){
// 					flag = true;
// 					break;
// 				}
// 			}
// 			//表格追加tr
// 			if(flag==false){
// 				$("#item_data").append("<tr><td>"+selectedOption[0].text+"</td><td><input type='hidden' name='iirList["+num+"].inspectid'   value='"+selectedOption[0].value+"' ><input type='text' name='iirList["+num+"].amount'   class='amount'   value='1' ><input type='hidden' value='"+selectedOption.attr("data-price")+"'>" +
// 						"</td><td>"+selectedOption.attr("data-price")+"</td>" +
// 								"<td><img src='img/rubbish.png' class='rubbish'    ></td></tr>");
// 				num++;
// 			}
// 		}
//
// 	})
//
// 	//点击垃圾桶，删除所在行
// 	$(document).on("click",".rubbish",function(){
// 		$(this).parent().parent().remove();
// 	})
//
// 	//变更数量，计算总金额
// 	$(document).on("blur",".amount",function(){
// 		var amount = $(this).val();
// 		if(parseInt(amount)==0 || isNaN(amount)){
// 			alert("请输入正确的数量");
// 		}else{
// 			var price = $(this).next().val();
// 			$(this).parent().next().html(parseFloat(parseFloat(price)*parseInt(amount)).toFixed(1));
// 		}
// 	})
//
// 	//提交检查申请
// 	$("#submitItem").click(function(){
// 		if($("#pid").val()==""){
// 			alert("请先选择患者！")
// 		}else{
// 			$.ajax({
// 				type:"post",
// 				url:"saveInspectItemRecord/"+$("#pid").val()+"/"+$("#dname").val(),
// 				data:$("#form1").serialize(),
// 				dataType:"json",
// 				success:function(data){
// 					console.log(data);
// 					if(data.result=="提交检验申请成功"){
// 						alert(data.result);
// 						location.href="doctor_medicalrecord.html";
// 					}else{
// 						alert(data.result);
// 					}
// 				}
// 			});
// 		}
//
// 	})
//
// 	//点击病例进入病例页面
// 	$("#div1_1").click(function(){
// 		location.href="/Doctor/MedicalRecordController/startMedicalRecord";
// 	});
//
// 	//点击检查申请进入检查申请页面
// 	$("#div1_2").click(function(){
// 		location.href="doctor_checkitem.html";
// 	});
//
// 	//点击确诊进入确诊页面
// 	$("#div1_4").click(function(){
// 		location.href="doctor_result.html";
// 	});
//
// })
//
