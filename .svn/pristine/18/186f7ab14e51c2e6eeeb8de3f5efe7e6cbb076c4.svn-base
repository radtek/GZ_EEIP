function createFrame(url, name) {
	return "<div style=\"width:100%; height:100%; overflow-x: hidden; overflow-y: hidden;\"><iframe id=\""
			+ name
			+ "\" name=\""
			+ name
			+ "\" frameborder=\"0\" scrolling=\"auto\" width=\"100%\" height=\"100%\" src=\""
			+ url + "\"></iframe></div>";
}

function resizeFrame(name, width, height) {
	if (document.getElementById(name) != undefined && width != undefined
			&& height != undefined) {
		document.getElementById(name).width = width;
		document.getElementById(name).height = height;
	}
}