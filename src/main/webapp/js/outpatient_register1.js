$(function(){
	var cost;
	//点击退号管理进入退号页面
	$("#refund").click(function(){
		location.href="/outpatient_refund.html";
	});
	
	//点击门诊收费管理进入收费页面
	$("#div1_2").click(function(){
		location.href="/outpatient_pay.html";
	});

	$("#levelid").change(function () {
		cost = $("#levelid option:selected").attr("data-cost");
		$("#cost").val(cost);
		if(form1.flag.value=='1'){
			$("#cost").val(parseInt(cost)+1);
		}
	});
	$("#yes").click(function(){
        if(parseInt(cost)==$("#cost").val()){
			$("#cost").val(parseInt(cost)+1);
		}
	});
	$("#no").click(function(){
		$("#cost").val(cost);
	});
	//初始化级别
	initLevel();
	function initLevel(){
        $. ajax({
			url:"/LevelController/selectAll",
			success:function (data) {
				$("#levelid").append("<option value='' data-cost=''>"+""+"</option>");
				for(var i=0;i<data.length;i++){
                    $("#levelid").append("<option value='"+data[i].id+"' data-cost='"+data[i].cost+"'>"+data[i].levelname+"</option>");
				}

			}
		});
	}
})












