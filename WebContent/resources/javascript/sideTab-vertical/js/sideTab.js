// JavaScript Document
function TabInfo() {
	this.tabName = new Array();
	this.tabMap = new Map();
	
	this.init = function(tabName, tabMap) {
		this.tabName = tabName;
		this.tabMap = tabMap;
	}
	
	this.getTabName = function(index) { return this.tabName[index]; }
	this.getTabMap = function() { return this.tabMap; }
}

function getContentWidth() {
  return $(window).width();
}

function getContentHeight() {
  return $(window).height();
}

function getComponentObj(id) {
  return document.getElementById(id);
}

function changeTab(tabObj) {
  try {
    var url = tabMap.get(tabObj.id);
	$(".tabItem_activated").removeClass("tabItem_activated").addClass("tabItem");
	$(".tabText_activated").removeClass("tabText_activated").addClass("tabText");
		
	$(getComponentObj(tabObj.id)).removeClass("tabItem").addClass("tabItem_activated");
	$(getComponentObj(tabObj.id)).find("span.tabText").removeClass("tabText").addClass("tabText_activated");
	
	var num = tabObj.id.substring(3);
	$(".tabFrameClass").hide();
	if ( getComponentObj("tabFrame"+num).src.indexOf("@blankpage") != -1 ) {
	  getComponentObj("tabFrame"+num).src = url;
	}
	$(getComponentObj("tabFrame"+num)).show();
  } catch(e) {}
}

function adjustSize() {
  try {
	$(".tab_container,.tab_content_container").css("height", getContentHeight()+"px");
    $(".tab_content_container").css("width", (getContentWidth()-parseInt($(".tab_container").css("width")))+"px");
	
	$(".tab_content").css("width", (parseInt($(".tab_content_container").css("width"))-10)+"px");
	$(".tab_content").css("height", (parseInt($(".tab_content_container").css("height"))-10)+"px");
	
	$(".tabFrameClass").css("width", $(".tab_content").css("width"));
	$(".tabFrameClass").css("height", $(".tab_content").css("height"));
  } catch(e) {}
}

function initialize(tabInfo, renderObjName) {
  try {
	var tabs = tabInfo.getTabMap();
    if ( tabs != null 
	       && getComponentObj(renderObjName) != undefined 
		   && getComponentObj(renderObjName) != null ) {
		var tabQty = tabs.size();
		var keyArray = tabs.keys();
		
		var tabsDivObj = document.createElement("div");
		$(tabsDivObj).addClass("tab_container");
		$(tabsDivObj).appendTo($(getComponentObj(renderObjName)));
		
		var tabItemObj;
		for ( var i = 1; i <= tabQty; i++ ) {
		  if ( i == 1 ) {
			tabItemObj = document.createElement("div");
			tabItemObj.setAttribute("id", "tab"+i);
			tabItemObj.onclick = function() { changeTab(this); };
		    $(tabItemObj).addClass("tabItem_activated");
		    $(tabItemObj).appendTo($(tabsDivObj));
			
			iconDivObj = document.createElement("div");
			$(iconDivObj).addClass("tabItemIcon");
			$(iconDivObj).appendTo($(tabItemObj));
			
			tabTextObj = document.createElement("span");
			tabTextObj.innerHTML = tabInfo.getTabName(i-1);
			$(tabTextObj).addClass("tabText_activated");
			$(tabTextObj).appendTo($(tabItemObj));
		  } else {
			tabItemObj = document.createElement("div");
			tabItemObj.setAttribute("id", "tab"+i);
			tabItemObj.onclick = function() { changeTab(this); };
		    $(tabItemObj).addClass("tabItem");
		    $(tabItemObj).appendTo($(tabsDivObj));
			
			iconDivObj = document.createElement("div");
			$(iconDivObj).addClass("tabItemIcon");
			$(iconDivObj).appendTo($(tabItemObj));
			
			tabTextObj = document.createElement("span");
			tabTextObj.innerHTML = tabInfo.getTabName(i-1);
			$(tabTextObj).addClass("tabText");
			$(tabTextObj).appendTo($(tabItemObj));
		  }
		}
		
		var tabContentDivObj = document.createElement("div");
		$(tabContentDivObj).addClass("tab_content_container");
		$(tabContentDivObj).appendTo($(getComponentObj(renderObjName)));
		
		var contentDivObj = document.createElement("div");
		$(contentDivObj).addClass("tab_content");
		$(contentDivObj).appendTo($(tabContentDivObj));
		
		for ( var i = 1; i <= tabQty; i++ ) {
		  var frameObj = document.createElement("iframe");
		  frameObj.setAttribute("id", "tabFrame"+i);
		  frameObj.setAttribute("class", "tabFrameClass");
		  frameObj.setAttribute("frameborder", "0");
		  if ( i == 1 ) { 
		    frameObj.setAttribute("style", "display:inline;"); 
			frameObj.setAttribute("src", tabs.get(keyArray[0])); 
	      }
		  else { 
		    frameObj.setAttribute("style", "display:none;");
			frameObj.setAttribute("src", "@blankpage"); 
	      }
		  $(frameObj).appendTo($(contentDivObj));
		}
		
		adjustSize();
	}
  } catch(e) {}
}