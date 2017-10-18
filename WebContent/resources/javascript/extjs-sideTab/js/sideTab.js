var sideTabMap = new Map();
var activedTabRender = 1;
var tabTitleId = 1;

function isIE8() {
	try {
		var _IE = (function() {
			var v = 3, div = document.createElement('div'), all = div
					.getElementsByTagName('i');
			while (div.innerHTML = '<!--[if gt IE ' + (++v)
					+ ']><i></i><![endif]-->', all[0])
				;
			return v > 4 ? v : false;
		}());
		if (_IE == 8)
			return true;
	} catch (e) {
		return false;
	}
	return false;
}

function getSideTabTitle(title) {
	try {
		var result = "";
		if (title != "") {
			var rotateTextClass = "rotateText";
			var str = "";
			var count = title.length;
			if (isIE8()) {
				rotateTextClass = "rotateText-ie8-actived";
				if (activedTabRender == 0)
					rotateTextClass = "rotateText-ie8";
				result += "<div id='chn_tab_title" + tabTitleId + "'>";
				while (count != -1) {
					str = title.charAt(count - 1);
					if (str != "")
						result += "<div class='" + rotateTextClass + "'>" + str
								+ "</div>";
					count--;
				}
				result += "</div>";
				sideTabMap.put("chn_tab_title" + tabTitleId, ""
						+ activedTabRender);
				tabTitleId++;
			} else {
				while (count != -1) {
					str = title.charAt(count - 1);
					if (str != "")
						result += "<div class='" + rotateTextClass + "'>" + str
								+ "</div>";
					count--;
				}
			}
			activedTabRender = 0;
			return result;
		}
	} catch (e) {
	}
	return "";
}

function init() {
	try {
		var tabIdArray = sideTabMap.keys(); // get id of tabs
		if (tabIdArray != null) {
			for (var i = 0; i < tabIdArray.length; i++) {
				var textDivArray;
				var length = 0;

				if ($(document.getElementById(tabIdArray[i])).find(
						"div.rotateText-ie8").length > 0) {
					textDivArray = $(document.getElementById(tabIdArray[i]))
							.find("div.rotateText-ie8");
					length = $(document.getElementById(tabIdArray[i])).find(
							"div.rotateText-ie8").length;
				}
				if ($(document.getElementById(tabIdArray[i])).find(
						"div.rotateText-ie8-actived").length > 0) {
					textDivArray = $(document.getElementById(tabIdArray[i]))
							.find("div.rotateText-ie8-actived")
					length = $(document.getElementById(tabIdArray[i])).find(
							"div.rotateText-ie8-actived").length;
				}

				for (var j = 0; j < length; j++) {
					$(textDivArray[j]).removeClass("rotateText-ie8-actived")
							.addClass("rotateText-ie8");
				}
			}
		}
	} catch (e) {
	}
}

function tabClassRender() {
	try {
		if (isIE8()) {
			var tabIdArray = sideTabMap.keys(); // get id of tabs
			if (tabIdArray != null) {
				for (var i = 0; i < tabIdArray.length; i++) {
					$(document.getElementById(tabIdArray[i]))
							.parent()
							.parent()
							.parent()
							.parent()
							.click(
									function() {
										init();
										var textDivArray;
										var length = 0;
										if ($(this).find("div.rotateText-ie8").length > 0) {
											textDivArray = $(this).find(
													"div.rotateText-ie8");
											length = $(this).find(
													"div.rotateText-ie8").length;
										}
										if ($(this).find(
												"div.rotateText-ie8-actived").length > 0) {
											textDivArray = $(this)
													.find(
															"div.rotateText-ie8-actived");
											length = $(this)
													.find(
															"div.rotateText-ie8-actived").length;
										}

										for (var j = 0; j < length; j++) {
											$(textDivArray[j]).removeClass(
													"rotateText-ie8").addClass(
													"rotateText-ie8-actived");
										}
									});
				}
			}
		}
	} catch (e) {
	}
}