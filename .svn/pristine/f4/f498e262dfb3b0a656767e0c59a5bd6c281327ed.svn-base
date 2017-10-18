$(function(){
	// 必填项加上required类，并做判断
	$(".required").blur(function(){
		if($(this).val()!=""){
			$(this).removeClass("error");
		}else{
			$(this).addClass("error");
		}
	});


	function base(reg){
		if ($(this).hasClass("required")) {
			if ($(this).val()!="") {
				if(reg.test($(this).val())){
					$(this).removeClass("error");
				}else{
					$(this).addClass("error");
				}
			}else{
				$(this).addClass("error");
			}
		}else{
			if ($(this).val()!="") {
				if(reg.test($(this).val())){
					$(this).removeClass("error");
				}else{
					$(this).addClass("error");
				}
			}else{
				$(this).removeClass("error");
			}
		}
	}
	
	// 手机号码验证
	$(".phoneNumber").blur(function(){
		var reg = /^1[3|4|5|7|8]\d{9}$/; 
		base(reg);
	});

	// 办公电话验证
	$(".officePhone").blur(function(){
		var reg = /^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/; 
		if ($(this).hasClass("required")) {
			if ($(this).val()!="") {
				if(reg.test($(this).val())){
					$(this).removeClass("error");
				}else{
					$(this).addClass("error");
				}
			}else{
				$(this).addClass("error");
			}
		}else{
			if ($(this).val()!="") {
				if(reg.test($(this).val())){
					$(this).removeClass("error");
				}else{
					$(this).addClass("error");
				}
			}else{
				$(this).removeClass("error");
			}
		}
	});

	// 传真验证
	$(".fax").blur(function(){
		var reg = /^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/;
		if ($(this).hasClass("required")) {
			if ($(this).val()!="") {
				if(reg.test($(this).val())){
					$(this).removeClass("error");
				}else{
					$(this).addClass("error");
				}
			}else{
				$(this).addClass("error");
			}
		}else{
			if ($(this).val()!="") {
				if(reg.test($(this).val())){
					$(this).removeClass("error");
				}else{
					$(this).addClass("error");
				}
			}else{
				$(this).removeClass("error");
			}
		}
	});

	// 邮箱验证
	$(".mailbox").blur(function(){
		var reg = /\w+[@]{1}\w+[.]\w+/;
		// var reg=/^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
		// var reg=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
		if ($(this).hasClass("required")) {
			if ($(this).val()!="") {
				if(reg.test($(this).val())){
					$(this).removeClass("error");
				}else{
					$(this).addClass("error");
				}
			}else{
				$(this).addClass("error");
			}
		}else{
			if ($(this).val()!="") {
				if(reg.test($(this).val())){
					$(this).removeClass("error");
				}else{
					$(this).addClass("error");
				}
			}else{
				$(this).removeClass("error");
			}
		}
	});

	// 非法字符验证
	$(".illegalCharacter").blur(function(){
		var reg=/[`~@#$^&*_+{},.\/;'[\]]/g;
		if ($(this).hasClass("required")) {
			if ($(this).val()!="") {
				if(reg.test($(this).val())){
			    	$(this).addClass("error");     
			    }else{
					$(this).removeClass("error");
				}
			}else{
				$(this).addClass("error");
			}
		}else{
			if ($(this).val()!="") {
				if(reg.test($(this).val())){
			    	$(this).addClass("error");     
			    }else{
					$(this).removeClass("error");
				}
			}else{
				$(this).removeClass("error");
			}
		}
	});
	
	 // 序列号验证
	$(".productKey").blur(function(){
		//var reg=/^[A-Z0-9]{}$/; 
		var reg=/[`~@#$^&*_+{},.\/;'[\]]/g;
		if ($(this).hasClass("required")) {
			if ($(this).val()!="") {
				if(reg.test($(this).val())){
			    	$(this).addClass("error");     
			    }else{
					$(this).removeClass("error");
				}
			}else{
				$(this).addClass("error");
			}
		}else{
			if ($(this).val()!="") {
				if(reg.test($(this).val())){
			    	$(this).addClass("error");     
			    }else{
					$(this).removeClass("error");
				}
			}else{
				$(this).removeClass("error");
			}
		}
	});
	
	// 禁止使用空格键
	$("input,textarea").keypress(function(){
        return banInputSapce(event);
    });
    function banInputSapce(e){ 
        var keynum; 
        if(window.event){ // IE 
            keynum = e.keyCode 
        }else if(e.which){ // Netscape/Firefox/Opera 
            keynum = e.which 
        } 
        if(keynum == 32){ 
            return false; 
        } 
        return true; 
    }
    
    // 实时验证
    $("input,textarea").blur(function(){
		var text=$(this).parent().prev("label").text();
		//alert(text);
		if($(this).hasClass("error")){
			//alert(123);
			if($(this).hasClass("required")){
				if($(this).hasClass("illegalCharacter")){
					promptContent("系统提示：“"+text+"”是必填项不能为空，或者含有非法字符，请仔细检查。");
				}else
				if($(this).hasClass("phoneNumber")){
					promptContent("系统提示：“"+text+"”是必填项不能为空，或者输入的手机号码有误，请仔细检查。");
				}else
				if($(this).hasClass("officePhone")){
					promptContent("系统提示：“"+text+"”是必填项不能为空，或者输入的办公电话号码有误，请仔细检查。");
				}else
				if($(this).hasClass("mailbox")){
					promptContent("系统提示：“"+text+"”是必填项不能为空，或者格式不对，请仔细检查。");
				}else
				if($(this).hasClass("productKey")){
					promptContent("系统提示：“"+text+"”是必填项不能为空，并且不能包含中文，请仔细检查。");
				}else{
				    promptContent("系统提示：“"+text+"”是必填项不能为空。");
				}
			}else{
				if($(this).hasClass("illegalCharacter")){
					promptContent("系统提示：“"+text+"”含有非法字符，请仔细检查。");
				}
				if($(this).hasClass("phoneNumber")){
					promptContent("系统提示：“"+text+"”输入的手机号码有误，请仔细检查。");
				}
				if($(this).hasClass("officePhone")){
					promptContent("系统提示：“"+text+"”输入的办公电话号码有误，请仔细检查。");
				}
				if($(this).hasClass("mailbox")){
					promptContent("系统提示：“"+text+"”格式不对，请仔细检查。");
				}
			}
			$(".alert").addClass("alert-danger").removeClass("alert-success");
			$(".promptDiv").slideDown();
		}else{
			$(".promptDiv").slideUp();
		}
	});
    
    // 提示框的X
    alertMessagesSlideUp(function() {
		$(".promptDiv").slideUp();
    });
});