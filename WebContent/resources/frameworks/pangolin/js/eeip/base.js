$(function(){		
	/* 标签页事件和样式-开始 */
	$(".tabs-nav li").hover(
        function(){
        	if( !$(this).hasClass("active-no") ){
        		$(this).addClass("active-hover");
        		$(this).next().addClass("active-next");
        	}
        },
        function(){
            if( !$(this).hasClass("active") ){
                $(this).next().removeClass("active-next");
            }
            $(this).removeClass("active-hover");
        }
    );
	$(".tabs-nav li").click(function(){
		if( !$(this).hasClass("active-no") ){
			$(".tabs-nav li").removeClass("active active-next");
    		$(this).addClass("active");
    		$(this).next().addClass("active-next");
    		var id = $(this).find("a").attr("class");
    		$(".tabs-list").removeClass("active");
    		$("#"+id).addClass("active");
		}
	});
	/* 标签页事件和样式-结束  */
	
	
	/*查看图片--开始*/
	$(".img-list").on("click", "img", function(){
        var src = $(this).attr("src");
        $(".modal-bigImg .bigImg").attr("src",src);
        //$(".big-img").html("<img src='"+ src +"' />");
    });
	/*查看图片--结束*/
});

//标签页部分事件
function tabsContent(status1,status2){
	$(".tabs-nav li").eq(status1).addClass("active");
	$(".tabs-nav li").eq(status1+1).addClass("active-next");
	$(".tabs-nav li").eq(status2).nextAll().addClass("active-no");
	var id = $(".tabs-nav li").eq(status1).find("a").attr("class");
	$(".tabs-list").removeClass("active");
	$("#"+id).addClass("active");
}