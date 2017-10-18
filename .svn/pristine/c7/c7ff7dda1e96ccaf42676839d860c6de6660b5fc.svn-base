// JavaScript Document
function clearUsernameVal(obj) {
	try {
		var text = "\u7528\u6237\u5e10\u53f7";
		if ( obj.value == text ) obj.value = "";
	} catch(e) {  }
}

function clearUserPwdVal(obj) {
	try {
		var text = "\u7528\u6237\u5bc6\u7801";
		if ( obj.value == text ) {
			obj.type = "password";
			obj.value = "";
		}
	} catch(e) {  }
}

function restoreUsernameVal(obj) {
	try {
		var text = "\u7528\u6237\u5e10\u53f7";
		if ( obj.value == "" ) obj.value = text;
	} catch(e) {  }
}

function restoreUserPwdVal(obj) {
	try {
		var text = "\u7528\u6237\u5bc6\u7801";
		if ( obj.value == "" ) {
			obj.type = "text";
			obj.value = text;
		}
	} catch(e) {  }
}

function signIn() {
	var usernameText = "\u7528\u6237\u5e10\u53f7";
	var userpwdText = "\u7528\u6237\u5bc6\u7801";
	
	if ( document.getElementById('username').value == "" || document.getElementById('username').value == usernameText ) {
		alert("用户账号必须填写");
		return false;
	}
	if ( document.getElementById('password').value == "" || document.getElementById('password').value == userpwdText ) {
		alert("登录密码必须填写");
		return false;
	}
	return true;
}