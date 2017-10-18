var tabMap = new Map();
var tabNameArray = new Array();

function randomChar(length) {
	var x = "0123456789qwertyuioplkjhgfdsazxcvbnm";
	var tmp = "";
	for (var i = 0; i < length; i++) {
		tmp += x.charAt(Math.ceil(Math.random() * 100000000) % x.length);
	}
	return tmp;
}

function isAddedTab(tabName) {
	if (tabNameArray != null) {
		for (var i = 0; i < tabNameArray.length; i++) {
			if (tabNameArray[i] == tabName)
				return true;
		}
	}
	return false;
}

function removeTabName(tabName) {
	if (tabNameArray != null) {
		for (var i = 0; i < tabNameArray.length; i++) {
			if (tabNameArray[i] == tabName) {
				tabNameArray.splice(i, 1);
			}
		}
	}
	if ( tabMap != null ) {
		if ( tabMap.containsKey(tabName) ) {
			tabMap.remove(tabName);
		}
	}
}

function addTabPage(tabs, tabName, tabGlyph, url) {
	if (!isAddedTab(tabName)) {
		var randomId = randomChar(10);
		tabs.add({
			id : randomId,
			title : tabName,
			glyph : tabGlyph,
			autoScroll : false,
			html : createFrame(url, "contentFrame"),
			closable : true,
			listeners : {
				'resize' : function(c, width, height, obj) {
					resizeFrame("contentFrame", width, height);
				},
				'destroy' : function(component, obj) {
					removeTabName(tabName);
				}
			}
		}).show();
		tabNameArray.push(tabName);
		tabMap.put(tabName, randomId);
	} else {
		var randomId = tabMap.get(tabName);
		if (randomId != null && randomId != "") {
			var openedPanel = Ext.getCmp(randomId);
			if (openedPanel != undefined && openedPanel != null)
				openedPanel.show();
		}
	}
}

function closeTabPage(tabs, tabName) {
	var randomId = tabMap.get(tabName);
	var tab = Ext.getCmp(randomId);
	if ( tab != null && tab != undefined ) {
		removeTabName(tabName);
		tab.close();
	}
}

function initializeTab(tabs, cmp0, cmp1) {
	try {
		tabs.add({
			title : "首页",
			glyph : "xf015@FontAwesome",
			closable : false,
			layout: "vbox",
			items:[cmp0, cmp1]
		}).show();
		tabs.setActiveTab(0);
	} catch (e) {
	}
}

function tabSizeSetting(parentCmp, tabs) {
	if (parentCmp != undefined && tabs != undefined && tabs != null) {
		var contentRegionHeight = parentCmp.getHeight();
		tabs.setHeight(contentRegionHeight);
	}
}

function getContentTab() {
	var tabs = Ext.createWidget('tabpanel', {
		id : "contentTabs",
		width : '100%',
		activeTab : 0,
		resizeTabs : true,
		enableTabScroll : true,
		defaults : {
			autoScroll : true,
			bodyPadding : 0
		},
		items : []
	});
	return tabs;
}