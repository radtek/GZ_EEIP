function faultReminder(content){
	$("body").append('<div class="faultReminder" style="display:none;position:fixed;bottom:0;right:0;width:340px;height:220px;font-size:14px;background-color:#333;z-index:9999;border:1px solid rgb(42,144,164);border-radius:2px;color:rgb(184,22,33);">'
			+'<div class="titleContent">'
			+'<div class="title" style="color:rgb(184,22,33);">'
			+'<img src="" height="20px" width="auto" />'
			+' 故障提醒'
			+'</div>'
			+'<div class="titleGradientLine"></div>'
			+'<div class="titlebrightenedDot brightenedDotLeft"></div>'
			+'<div class="titlebrightenedDot brightenedDotRight"></div>'
			+'</div>'
			+'<div class="content" style="margin-top:60px;padding:0 20px;text-indent:2em;letter-spacing:1px;">'
			+content
			+'</div>'
			+'</div>'
	);
	$(".faultReminder").fadeIn("500");
	setTimeout('$(".faultReminder").fadeOut("500");',3000);
}

function abnormalReminder(content){
	$("body").append('<div class="abnormalReminder" style="display:none;position:fixed;bottom:2px;right:2px;width:340px;height:220px;font-size:14px;z-index:9999;border-radius:2px;color:#fff;">'
					+'<div class="title" style="background-color:rgb(28,175,154);height:30px;line-height:30px;">'
					+'<img src="" height="20px" width="auto" />'
					+'故障提醒'
					+'</div>'
					+'<div class="content" style="height:190px;border:2px solid #e5e5e5;background-color:#fff;border-top:none;color:rgb(182,88,97);padding:20px 20px 0 20px;text-indent:2em;letter-spacing:1px;">'
					+content
					+'</div>'
					+'</div>'
			);
	$(".abnormalReminder").fadeIn("500");
	setTimeout('$(".abnormalReminder").fadeOut("500");',3000);
}