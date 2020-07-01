$(function(){
	// $("#logout").click(function(){
	// 	$.ajax({
	// 		type:"post",
	// 		url:"logout",
	// 		data:{},
	// 		dataType:"json",
	// 		success:function(data){
	// 			location.href="login.html";
	// 		}
	// 	});
	// })


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
				url:"/Patient/PatientController/selectByPid",
				data:"pid="+$("#pid").val(),
				success:function (data) {
					if(data.pid==-1){
						alert("没查到！");
						location.reload();
					}else{
						// alert(data.status);
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
						if (data.pstatus=="已挂号"&&data.status==0){
							$("#refund").attr("disabled",false);
							$("#refund").css("color","blue");
							// $("#refund")[0].disabled=false;
							// $("#refund")[0].style.color="blue";
						}else{
							$("#refund").attr("disabled",true);
							$("#refund").css("color","grey");
							// $("#refund")[0].disabled=true;
							// $("#refund")[0].style.color="grey";
						}
					}

				}
			})
		}

	})
});