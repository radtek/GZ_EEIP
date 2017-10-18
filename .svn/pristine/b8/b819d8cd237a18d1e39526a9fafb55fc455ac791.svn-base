var systemPromptText="系统提示：";
var nonemptyErrorText = "不能为空。";
var illegalCharErrorText = "存在非法字符。";
var selectErrorText = "选择其他有效选项。";

var accountErrorText = "用户帐号格式有误。";
var pwdErrorText = "用户密码格式有误。";
var idCardErrorText = "身份证格式有误。";
var cellphoneErrorText = "手机号码格式有误。";
var officePhoneErrorText = "办公电话格式有误。";
var faxErrorText = "传真号码格式有误。";
var emailErrorText = "电子邮箱格式有误。";

var successText = "保存成功！";
var failureText = "保存失败！必填项或者信息填写有误 (带*为必填项 )。";

var spaceErrorText = "不能全为空格符。";
var alarmErrorText = "警察证号格式有误，格式是6位数字。";

var nameErrorText = "格式有误，只能是中文或英文。";		//姓名
var numberErrorText = "格式有误，只能是数字，两位数以上不可以“0”开头。";		//数量
var moneyErrorText = "金额格式有误，最多有两位小数。";		//价格、金额
var serialNumberErrorText = "格式有误，由英文、数字、-、_、（） 自由组合。";		//编号、识别号
var validationErrorText = "格式有误，由中文、英文、数字、-、_、（）、[]、{}、【】 自由组合。";		//标题、单位、地址、名称
var zipCodeErrorText = "邮编格式有误，只能为6位数字。";		//邮政编码
var roleIdentificationErrorText = "格式有误，由英文、_、- 自由组合。";		//角色标识
var uncertainItemErrorText = "不能为空，最起码要有一个。";		//人员、文件选择验证
var specificationsErrorText = "格式有误，由中文、英文、数字、-、_、（） 自由组合。";		//规格/型号
var chineseErrorText = "格式有误，只能是中文。";		//纯中文
var chineseNumErrorText = "格式有误，只能是中文或数字。";		//中文加数字

/**
 * 初始化警告语句
 * */
function initErrorText(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, 
		               arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, 
		               arg21, arg22, arg23, arg24, arg25 ) {
	systemPromptText = arg0;
	nonemptyErrorText = arg1;
	illegalCharErrorText = arg2;
	selectErrorText = arg3;
	
	accountErrorText = arg4;
	pwdErrorText = arg5;
	idCardErrorText = arg6;
	cellphoneErrorText = arg7;
	officePhoneErrorText = arg8;
	faxErrorText = arg9;
	emailErrorText = arg10;
	
	successText = arg11;
	failureText = arg12;
	
	spaceErrorText = arg13;
	alarmErrorText = arg14;
	
	nameErrorText = arg15;
	numberErrorText = arg16;
	moneyErrorText = arg17;
	serialNumberErrorText = arg18;
	validationErrorText = arg19;
	zipCodeErrorText = arg20;
	roleIdentificationErrorText = arg21;
	uncertainItemErrorText = arg22;
	specificationsErrorText = arg23;
	chineseErrorText = arg24;
	chineseNumErrorText = arg25;
}

$(function(){
	// 失去焦点时验证
	$("body").on("blur", "input,textarea", function(){
		var text = removeAsterisk($(this).parent().prev("label").text());
		var th = $(this);
		//space(th);
		var oldValue = th.val();
	    newValue = $.trim(oldValue);
		if ($(this).attr("required") != undefined){
			if ($(this).val() != "") {
				if (newValue == '') {
			    	th.addClass("error");
					var text = removeAsterisk(th.parent().prev("label").text());
					promptContent(systemPromptText +'“'+ text +'”'+ spaceErrorText);
					$(".alert").removeClass("alert-success").addClass("alert-danger");
				 	$(".promptDiv").slideDown();
				 	setTimeout(function(){$(".promptDiv").slideUp();},2000);
			    }else if ($(this).hasClass("cellphone")) {
					cellphoneVerification(th);
				} else if ($(this).hasClass("officePhone")) {
					fixedTelephoneVerification(th);
				} else if ($(this).hasClass("fax")) {
					fixedTelephoneVerification(th);
				} else if ($(this).hasClass("email")) {
					emailVerification(th);
				} else if ($(this).hasClass("idCard")) {
					idCardVerification(th);
				} else if ($(this).hasClass("illegalCharacter")) {
					illegalCharacterVerification(th);
				} else if ($(this).hasClass("userName")) {
					accountVerification(th);
				} else if ($(this).hasClass("password")) {
					passwordVerification(th);
				} else if ($(this).hasClass("alarm")) {
					alarmVerification(th);
				} else if ($(this).hasClass("name")) {
					nameVerification(th);
				} else if ($(this).hasClass("number")) {
					numberVerification(th);
				} else if ($(this).hasClass("money")) {
					moneyVerification(th);
				} else if ($(this).hasClass("serialNumber")) {
					serialNumberVerification(th);
				} else if ($(this).hasClass("validation")) {
					validationVerification(th);
				} else if ($(this).hasClass("zipCode")) {
					zipCodeVerification(th);
				} else if ($(this).hasClass("roleIdentification")) {
					roleIdentificationVerification(th);
				} else if ($(this).hasClass("specifications")) {
					specificationsVerification(th);
				} else if ($(this).hasClass("chinese")) {
					chineseVerification(th);
				} else if ($(this).hasClass("chineseNum")) {
					chineseNumVerification(th);
				} else {
					$(this).removeClass("error");
					promptContent("");
					$(".alert").removeClass("alert-danger").addClass("alert-success");
				 	$(".promptDiv").slideUp();
				}
			} else {
				$(this).addClass("error");
				promptContent(systemPromptText +'“'+ text +'”'+ nonemptyErrorText);
			 	$(".alert").removeClass("alert-success").addClass("alert-danger");
			 	$(".promptDiv").slideDown();
			 	setTimeout(function(){$(".promptDiv").slideUp();},2000);
			}
		}else{
			if ($(this).val() != ""){
				if (newValue == '') {
			    	th.addClass("error");
					var text = removeAsterisk(th.parent().prev("label").text());
					promptContent(systemPromptText +'“'+ text +'”'+ spaceErrorText);
					$(".alert").removeClass("alert-success").addClass("alert-danger");
				 	$(".promptDiv").slideDown();
				 	setTimeout(function(){$(".promptDiv").slideUp();},2000);
			    }else if ($(this).hasClass("cellphone")) {
					cellphoneVerification(th);
				} else if ($(this).hasClass("officePhone")) {
					fixedTelephoneVerification(th);
				} else if ($(this).hasClass("fax")) {
					fixedTelephoneVerification(th);
				} else if ($(this).hasClass("email")) {
					emailVerification(th);
				} else if ($(this).hasClass("idCard")) {
					idCardVerification(th);
				} else if ($(this).hasClass("illegalCharacter")) {
					illegalCharacterVerification(th);
				} else if ($(this).hasClass("userName")) {
					accountVerification(th);
				} else if ($(this).hasClass("password")) {
					passwordVerification(th);
				} else if ($(this).hasClass("alarm")) {
					alarmVerification(th);
				} else if ($(this).hasClass("name")) {
					nameVerification(th);
				} else if ($(this).hasClass("number")) {
					numberVerification(th);
				} else if ($(this).hasClass("money")) {
					moneyVerification(th);
				} else if ($(this).hasClass("serialNumber")) {
					serialNumberVerification(th);
				} else if ($(this).hasClass("validation")) {
					validationVerification(th);
				} else if ($(this).hasClass("zipCode")) {
					zipCodeVerification(th);
				} else if ($(this).hasClass("roleIdentification")) {
					roleIdentificationVerification(th);
				} else if ($(this).hasClass("specifications")) {
					specificationsVerification(th);
				} else if ($(this).hasClass("chinese")) {
					chineseVerification(th);
				} else if ($(this).hasClass("chineseNum")) {
					chineseNumVerification(th);
				} 
			} else {
				$(this).removeClass("error");
				promptContent("");
				$(".alert").removeClass("alert-danger").addClass("alert-success");
			 	$(".promptDiv").slideUp();
			}
		}	
	});

	// 选择另外选项时验证
	$("body").on("change", "select", function(){
		var text=$(this).parent().prev("label").text();
		var optionSelected=$(this).find("option:selected").val();
		if ($(this).attr("required") != undefined) {
			if (optionSelected!=""){
				$(this).removeClass("error");
				promptContent("");
			 	$(".alert").removeClass("alert-danger").addClass("alert-success");
			 	$(".promptDiv").slideUp();
			}else{
				$(this).addClass("error");
				promptContent(systemPromptText +'“'+ text +'”'+ selectErrorText);
			 	$(".alert").removeClass("alert-success").addClass("alert-danger");
			 	$(".promptDiv").slideDown();
			 	setTimeout(function(){$(".promptDiv").slideUp();},2000);
			}
		}
	});

	// 禁止使用空格键
	/*$("input,textarea").keypress(function(){
	    return banInputSapce(event);
	});*/

	//时间插件禁止键盘输入
	/*$(".inputVerification").keypress(function(){
		return false;
	});*/
	
	// 提示框的X
	alertMessagesSlideUp(function() {
		$(".promptDiv").slideUp();
	});
});

/**
 * 验证提交数据合法性
 * */
function validateSubmittedData() {
	var status = true;
	var valueNum = 0;
	var optionNum = 0;
	var checkNum = 0;
	$("input,textarea").each(function() {
		if ($(this).attr("required") != undefined) {
			if ($(this).val() == "") {
				valueNum++;
				$(this).addClass("error");
			}else{
				if ($(this).hasClass("error")) {
					valueNum++;
				}else{
					$(this).removeClass("error");
				}
			}
		}else{
			if ($(this).val() != "" && $(this).hasClass("error")){
				valueNum++;
			}
		}
	});

	$("select").each(function(){
		if ($(this).attr("required") != undefined){
			if ($(this).find("option:selected").val()=="") {
				$(this).addClass("error");
				optionNum++;
			}
		}
	});
	
    $(".input-choose").each(function(){
        var checkedNum = 0;
        var nextClass = $(this).data("name");
        var size = $(this).nextAll(nextClass).size();
        for( var i = 0; i < size; i++ ){
        	var nextInput = $(this).nextAll(nextClass).eq(i).find("input");
        	var inputNum = nextInput.size();
        	for( var j = 0; j < inputNum; j++ ){
        		if( $(this).nextAll(nextClass).eq(i).find("input").eq(j).prop("checked") ){
                	checkedNum++;
                }
        	}
        }
        if (checkedNum > 0) {
            $(this).removeClass("checkValidation");
        }else{
            $(this).addClass("checkValidation");
        }

        if( $(this).hasClass("checkValidation") ){
        	checkNum++;
        }
    });
	
	if (valueNum > 0 || optionNum > 0 || checkNum > 0 ){
		status = false;
		$("button").attr("disabled",false);
	}	
	return status;
}


/**
 * 保存数据成功
 * */
function saveSuccess(url){
	promptContent(systemPromptText + successText);
	$(".alert").removeClass("alert-danger").addClass("alert-success");
	$(".promptDiv").slideDown();
	if ( url != undefined ){ 
		setTimeout(function(){
	    	$(".index-iframe", window.parent.document).attr("src", url);
	    },2000);
	}else{
		$("button").attr("disabled",false);
		setTimeout(function(){$(".promptDiv").slideUp();},2000);
	}
}


/**
 * 保存数据失败
 * @param failureText 报错信息
 * */
function saveFailure(text) {
	$("html, body").animate({ scrollTop: 0 }, 200);
	if ( text != undefined ){ 
		promptContent(systemPromptText + text);
	} else {
		promptContent(systemPromptText + failureText);
	}
 	$(".alert").removeClass("alert-success").addClass("alert-danger");
 	$(".promptDiv").slideDown();
 	$("button").attr("disabled", false);
 	setTimeout(function(){$(".promptDiv").slideUp();},2000);
}


/**
 * 禁用空格键
 * */
function banInputSapce(e) {
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


/**
 * 移除字符中的星号
 * */
function removeAsterisk(str) {
	return str.replace(/\*/g, "");
}


/**
 * 构建验证警告语句
 * */
function buildWarnings(th, reg) {
	if( reg.test( th.val() ) ) {
		th.removeClass("error");
		promptContent("");
		$(".alert").removeClass("alert-danger").addClass("alert-success");
	 	$(".promptDiv").slideUp();
	} else {
		th.addClass("error");
		var text = removeAsterisk(th.parent().prev("label").text());
		if (th.hasClass("cellphone")) {
			promptContent(systemPromptText +'“'+ text +'”'+ cellphoneErrorText);
		}else if (th.hasClass("officePhone")) {
			promptContent(systemPromptText +'“'+ text +'”'+ officePhoneErrorText);
		}else if (th.hasClass("fax")) {
			promptContent(systemPromptText +'“'+ text +'”'+ faxErrorText);
		}else if (th.hasClass("email")) {
			promptContent(systemPromptText +'“'+ text +'”'+ emailErrorText);
		}else if (th.hasClass("idCard")) {
			promptContent(systemPromptText +'“'+ text +'”'+ idCardErrorText);
		}else if (th.hasClass("userName")) {
			promptContent(systemPromptText +'“'+ text +'”'+ accountErrorText);
		}else if (th.hasClass("password")) {
			promptContent(systemPromptText +'“'+ text +'”'+ pwdErrorText);
		}else if (th.hasClass("alarm")) {
			promptContent(systemPromptText +'“'+ text +'”'+ alarmErrorText);
		}else if (th.hasClass("name")) {
			promptContent(systemPromptText +'“'+ text +'”'+ nameErrorText);
		}else if (th.hasClass("number")) {
			promptContent(systemPromptText +'“'+ text +'”'+ numberErrorText);
		}else if (th.hasClass("money")) {
			promptContent(systemPromptText +'“'+ text +'”'+ moneyErrorText);
		}else if (th.hasClass("serialNumber")) {
			promptContent(systemPromptText +'“'+ text +'”'+ serialNumberErrorText);
		}else if (th.hasClass("validation")) {
			promptContent(systemPromptText +'“'+ text +'”'+ validationErrorText);
		}else if (th.hasClass("zipCode")) {
			promptContent(systemPromptText +'“'+ text +'”'+ zipCodeErrorText);
		}else if (th.hasClass("roleIdentification")) {
			promptContent(systemPromptText +'“'+ text +'”'+ roleIdentificationErrorText);
		}else if (th.hasClass("specifications")) {
			promptContent(systemPromptText +'“'+ text +'”'+ specificationsErrorText);
		}else if (th.hasClass("chinese")) {
			promptContent(systemPromptText +'“'+ text +'”'+ chineseErrorText);
		}else if (th.hasClass("chineseNum")) {
			promptContent(systemPromptText +'“'+ text +'”'+ chineseNumErrorText);
		}
		$(".alert").removeClass("alert-success").addClass("alert-danger");
	 	$(".promptDiv").slideDown();
	 	setTimeout(function(){$(".promptDiv").slideUp();},2000);
	}
}


/**
 * 手机号码验证（包含130-139,150-159,180-189号码段的手机号码）
 * */
function cellphoneVerification(th) {
	var reg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
	buildWarnings(th, reg);
}


/**
 * 座机验证（包含办公电话及传真，验证格式符合区号+座机号+分机号）
 * */
function fixedTelephoneVerification(th) {
	var reg = /^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$/;
	buildWarnings(th, reg);
}


/**
 * 电子邮箱验证
 * */
function emailVerification(th) {
	var reg = /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g;
	buildWarnings(th, reg);
}


/**
 * 居民身份证验证（中华人民共和国）
 * */
function idCardVerification(th) {
	var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
	buildWarnings(th, reg);
}


/**
 * 用户帐号验证
 * */
function accountVerification(th) {
	var reg = /^[a-zA-z][a-zA-Z0-9_]{1,15}$/;
	buildWarnings(th, reg);
}


/**
 * 用户密码验证
 * */
function passwordVerification(th) {
	var reg = /^[0-9a-zA-Z]{6,20}$/;
	buildWarnings(th, reg);
}


/**
 * 警号验证
 * */
function alarmVerification(th) {
	var reg = /^[0-9]{6,6}$/;
	buildWarnings(th, reg);
}


/**
 * 姓名验证
 * */
function nameVerification(th) {
	var reg = /^[\u4e00-\u9fa5a-zA-Z]+$/;
	buildWarnings(th, reg);
}


/**
 * 数量验证
 * */
function numberVerification(th) {
	var reg = /^(0|[1-9][0-9]*)$/;
	buildWarnings(th, reg);
}


/**
 * 价格、金额验证
 * */
function moneyVerification(th) {
	var reg = /^(0|[1-9][0-9]{0,9})(\.[0-9]{1,2})?$/;
	buildWarnings(th, reg);
}


/**
 * 编号、识别号验证
 * */
function serialNumberVerification(th) {
	var reg = /^([a-z_A-Z-()0-9]+)$/;
	buildWarnings(th, reg);
}


/**
 * 规格/型号验证
 * */
function specificationsVerification(th) {
	var reg = /^[\u4e00-\u9fa5a-zA-Z_0-9-()（）]+$/;
	buildWarnings(th, reg);
}


/**
 * 标题、单位、地址验证
 * */
function validationVerification(th) {
	var reg = /^[\u4e00-\u9fa5a-zA-Z_0-9-()（）[\]{}【】]+$/;
	buildWarnings(th, reg);
}


/**
 * 邮政编码验证
 * */
function zipCodeVerification(th) {
	var reg = /^[1-9]\d{5}$/;
	buildWarnings(th, reg);
}


/**
 * 角色标识验证
 * */
function roleIdentificationVerification(th) {
	var reg = /^[a-zA-Z_-]+$/;
	buildWarnings(th, reg);
}


/**
 * 纯中文验证
 * */
function chineseVerification(th) {
	var reg = /^[\u4e00-\u9fa5]+$/;
	buildWarnings(th, reg);
}


/**
 * 中文+数字验证
 * */
function chineseNumVerification(th) {
	var reg = /^[\u4e00-\u9fa50-9]+$/;
	buildWarnings(th, reg);
}


/**
 * 非法字符验证
 * */
function illegalCharacterVerification(th){
	var reg=/[`~!@#$%^&*()_+<>?:"{},.\/;'[\]]/;
	if(reg.test(th.val())){
    	th.addClass("error");
    	var text=th.parent().prev("label").text();
    	promptContent(systemPromptText +'“'+ text +'”'+ illegalCharErrorText);
		$(".alert").removeClass("alert-success").addClass("alert-danger");
	 	$(".promptDiv").slideDown();
	 	setTimeout(function(){$(".promptDiv").slideUp();},2000);
    } else {
		th.removeClass("error");
		promptContent("");
		$(".alert").removeClass("alert-danger").addClass("alert-success");
	 	$(".promptDiv").slideUp();
	}
}


function promptContent(text) {
	$(".promptContent").html(text);
}


function alertMessagesSlideUp(func) {
	try {
		$(".promptCloseBtn").click(func);
	} catch (e) {
		console.log(e);
	}
}


//验证是否为全空格
/*function space(th) {
	var oldValue = th.val();
    newValue = $.trim(oldValue);
    if (newValue == '') {
    	th.addClass("error");
		var text = removeAsterisk(th.parent().prev("label").text());
		promptContent(systemPromptText +'“'+ text +'”'+ spaceErrorText);
		$(".alert").removeClass("alert-success").addClass("alert-danger");
	 	$(".promptDiv").slideDown();
    }else{
    	th.removeClass("error");
		promptContent("");
		$(".alert").removeClass("alert-danger").addClass("alert-success");
	 	$(".promptDiv").slideUp();
    }
}*/