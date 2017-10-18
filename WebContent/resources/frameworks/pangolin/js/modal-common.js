function setSystemNoticeContent(text) {
	$(".modalContent").html("&nbsp;&nbsp;&nbsp;&nbsp;" + text);
}

function initSystemNoticePopup(func) {
	try {
		$(".confirm-btn").click(func);
	} catch (e) {
		console.log(e);
	}
}