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