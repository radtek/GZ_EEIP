function createFrame(url, name) {
	try {
		var frameStr = "<div style=\"width:100%; height:100%; overflow-x: hidden; overflow-y: hidden; position:relative; left: -10px; top: -10px;\">";
		frameStr += "<iframe id=\""
				+ name
				+ "\" name=\""
				+ name
				+ "\" frameborder=\"0\" scrolling=\"auto\" width=\"0\" height=\"0\" src=\""
				+ url + "\"></iframe>";
		frameStr += "</div>";
		return frameStr;
	} catch (e) {
	}
	return "";
}

function resizeFrame(name, width, height) {
	$(document.getElementById(name)).css("width", width + "px");
	$(document.getElementById(name)).css("height", height + "px");
	$(document.getElementById(name)).parent().css("width", width + "px");
	$(document.getElementById(name)).parent().css("height", height + "px");
}