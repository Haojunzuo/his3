$(function(){
	//点击检查申请进入下一页面
	$("#div1_2").click(function(){
		location.href="/Doctor/CheckItemController/startCheckItem";
	});
	
	//点击检验申请进入下一页面
	$("#div1_3").click(function(){
		location.href="/doctor_inspectitem.html";
	});
	
	//点击确诊进入确诊页面
	$("#div1_4").click(function(){
		location.href="/doctor_result.html";
	});
	$("#goback").click(function () {
		location.href="/login.html";
	});
	$("#regMr").click(function () {

		$.ajax({
			url:"/Doctor/MedicalRecordController/createMedicalRecord",
			data: $(window.frames["f"].document).find("#form1").serialize(),
			success:function (data) {
				if(data=="yes"){
					alert('恭喜,生成病历成功！');
					location.href="/Doctor/MedicalRecordController/startMedicalRecord";
					return;
				}else if(data=="no"){
					alert('对不起,生成病历失败！');
					return;
				}
			}});
	});
});

function myPid(info) {


	//alert($(info).text());

	//$(window.frames["f"].document).find("#pno").val($(info).text());

	if($(info).text()==''){

		alert('您没有填写要查询的病历号');
		location.reload();
	}else if(isNaN($(info).text())==true){

		alert('对不起，病历号必须是数字！');
		location.reload();
	}else{
		$.ajax({
			url:"/Patient/PatientController/selectByPid",
			data:"pid="+$(info).text(),
			success:function (data) {
				if(data.pid==-1){
					alert('对不起，没查到！');
					location.reload();
				}else{
					$(window.frames["f"].document).find("#pno").val(data.pid);
					$(window.frames["f"].document).find("#pname").val(data.pname);
					if (data.sex == '男') {
						$(window.frames["f"].document).find("input[name='sex']:eq(0)").prop("checked", 'checked');
					} else {
						$(window.frames["f"].document).find("input[name='sex']:eq(1)").prop("checked", 'checked');
					}
					$(window.frames["f"].document).find("#idcard").val(data.idcard);
					$(window.frames["f"].document).find("#pstatus").text(data.pstatus);
					$(window.frames["f"].document).find("#createdate").val(data.createDate);
					$(window.frames["f"].document).find("#deptname").val(data.dept.deptname);
					$(window.frames["f"].document).find("#dname").val(data.doc.dname);
					$(window.frames["f"].document).find("#level").val(data.level.levelname);
					if (data.status == 0) {
						$(window.frames["f"].document).find("#status").text("未就诊");
					} else {
						$(window.frames["f"].document).find("#status").text("已就诊");
					}

					if(data.status==0&&data.pstatus=='已挂号'){
						$(window.frames["f"].document).find("#refund").attr("disabled",false);
						$(window.frames["f"].document).find("#refund").css("color","blue");
					}else{
						$(window.frames["f"].document).find("#refund").attr("disabled",true);
						$(window.frames["f"].document).find("#refund").css("color","grey");
					}
					$(window.frames["f"].document).find("#pid2").val(data.pid);
				}}
		});
	}
}
