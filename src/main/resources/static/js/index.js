var differUrl = {
	// 污染源分布情况
    pollutionDistribution:{
        id:"pollutionDistribution",
        src:"panel/pollutionDistribution/pollutionDistribution.html"
    },
	// 生产活动水平情况
	productionActivity:{
		id:"productionActivity",
		src:"panel/productionActivity/productionActivity.html"
	},
	// 污染物产排情况
	productionSewage:{
		id:"productionSewage",
	    src:"panel/productionSewage/productionSewage.html"

	},
	// 其他专题->移动源->机动车专题
	JDCZT:{
		id:"JDCZT",
		src:"panel/JDCZT/default.html"
	},
	// 其他专题->移动源->油品储存销污染物排放情况
	transportation:{
		id:"transportation",
		src:"panel/transportation/transportation.html"
	},
    //其他专题/移动源/农用机械污染排放情况
	NYJXZT: {
	    id: "NYJXZT",
	    src: "panel/NYJXZT/default.html"
	},
	// 其他专题->生活源->生活污染源基本情况
	sourceLifeMess:{
		id:"sourceLifeMess",
		src:"panel/sourceLifeMess/sourceLifeMess.html"
	},

    //其他专题/农业源/农作物秸秆利用情况
	CropStraw: {
	    id: "CropStraw",
	    src: "panel/CropStraw/CropStraw.html"
	},
	// 其他专题->农业源->种植业基本情况
	agricultureInfomation:{
	    id:"agricultureInfomation",
	    src:"panel/agricultureInfomation/agricultureInfomation.html"
	},
};
$(function(){
	// 一级菜单的点击事件
	$(".list li").click(function(){
		$(this).addClass("selectActive").siblings().removeClass("selectActive");
		$(".level3 li").removeClass("active");
		$(".qt").attr("src","img/menu/4.png");
		
	})
	// $("body").height($(window).height());
	$(".leftCont").height($(window).height());
	// 一级菜单的其他专题点击事件
	var fa = true;
	$("#QiTa .level1>div").click(function(){
		$(".qt").attr("src","img/menu/qt.png");
		$(".fb").attr("src","img/menu/1.png");
		$(".sp").attr("src","img/menu/2.png");
		$(".cp").attr("src","img/menu/3.png");
		if(fa){
			$(this).find("i").addClass("down").parent().next().slideDown('slow') //下一个元素显示
			fa = false;
		} else {
			$(this).next().slideUp("slow");
			$(".level3").slideUp("slow");
			fa = true;
		}
	});
	// 二级菜单的点击事件
	$(".level2 li>div").click(function(){
		if($(this).hasClass("selectmenu")){
			$(this).removeClass("selectmenu").next().slideUp("slow");
		} else {
			$(this).addClass("selectmenu").find("i").addClass("down").parent().next().slideDown('slow').parent().siblings().children('div').find('i').removeClass('down').parent().next().slideUp('slow'); //隐藏 //下一个元素显示
		}




	});
	// 三级菜单的点击事件
	$(".level3 li").click(function(){
		$(".list li").removeClass("selectActive")
		$(this).addClass("active").siblings().removeClass("active");
	});
})


// 菜单点击
function Panpel(type){
	if(type == "pollutionDistribution"){
		$(".fb").attr("src","img/menu/fb.png");
		$(".sp").attr("src","img/menu/2.png");
		$(".cp").attr("src","img/menu/3.png");
		// 地图事件
		$("#mumap")[0].contentWindow.pollutionDistribute('000000000000','pollution_all');
	}
	if(type == "productionActivity"){
		$(".fb").attr("src","img/menu/1.png");
		$(".sp").attr("src","img/menu/sp.png");
		$(".cp").attr("src","img/menu/3.png");

	}
	if(type == "productionSewage"){
		$(".fb").attr("src","img/menu/1.png");
		$(".sp").attr("src","img/menu/2.png");
		$(".cp").attr("src","img/menu/cp.png");
	}
    var height = $(window).height();
	$("#mumap")[0].contentWindow.document.getElementById("menuJump").style.height = height+"px";
	// $("#mumap")[0].contentWindow.document.getElementById("menuJump").style.display = "block";
	$("#mumap").contents().find("#menuJump").animate({
		"left":"0"
	})
	list = differUrl[type];
	// console.log(list);
	var html = "<iframe frameborder='0' scrolling='no' id='layerIframe' src='" + list.src + "' style='width:100%;height:100%;'></iframe>";
	$("#mumap")[0].contentWindow.document.getElementById("menuJump").innerHTML=html;
	// 右侧地图右移
	$("#mumap")[0].contentWindow.document.getElementById("navlist").style.width  = "calc(100% - 486px)";
	$("#mumap")[0].contentWindow.document.getElementById("map").style.width  = "calc(100% - 486px)";
	$("#mumap").contents().find("#map").animate({
		"left":"486px",
		"width":"calc(100% - 486px)"
	});
	$("#mumap").contents().find("#navlist").animate({
		"left":"486px",
		"width":"calc(100% - 486px)"
	});
	$("#mumap").contents().find("#fbqk").animate({
		"left":"486px"
	});
	
	

}


// // 关闭弹窗
// function closeChange(){
// 	$("#zhezhao").css("display","none");
// }
// 显示图表
function showchartline(datatype){
	$("#mumap")[0].contentWindow.showChartsMap(datatype);
}






