$(function(){
	$(".tree").on("click",".tree-closed1 .toggler1",function(){
		$(this).parent().removeClass("tree-closed1").addClass("tree-opened1");
		$(this).siblings("ul").slideDown();
	});
	$(".tree").on("click",".tree-opened1 .toggler1",function(){
		$(this).parent().removeClass("tree-opened1").addClass("tree-closed1");
		$(this).siblings("ul").slideUp();
	});
	$(".tree").on("click",".tree-closed2 .toggler2",function(){
		$(this).parent().removeClass("tree-closed2").addClass("tree-opened2");
		$(this).siblings("ul").slideDown();
	});
	$(".tree").on("click",".tree-opened2 .toggler2",function(){
		$(this).parent().removeClass("tree-opened2").addClass("tree-closed2");
		$(this).siblings("ul").slideUp();
	});
	$(".tree").on("click",".view .toggler2,.viewHist .toggler3",function(){
		$(".view .toggler2,.viewHist .toggler3").removeClass("active");
		$(this).addClass("active");
	})
})
