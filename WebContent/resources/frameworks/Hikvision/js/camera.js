/**
JavaScript Document - Preview of single camera
Author: Oscar Mok
Version: 1.0
Date: Fri 31 Mar 2017
*/

//Get value of url parameter
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}

$(function () {
	
	var ipAddr = getUrlParam("ipAddr"); //ip address of device
	var port = "80"; //port of device
	var account = "admin"; //account of device
	var pwd = "sjy123456"; //password of device
	var init = 0;
	
	//Check if plugin is installed
	var iRet = WebVideoCtrl.I_CheckPluginInstall();
	if (iRet == -2) {
		alert("Chrome does not support NPAPI");
	} else if (iRet == -1) {
		alert("Please install plugins 'WebComponentsKit.exe' first!");
	}
	
	//Initialize plug
	WebVideoCtrl.I_InitPlugin(430, 200, {
		bWndFull: true,
		iWndowType: 1,
		cbSelWnd: function (xmlDoc) {
			//Callback when choosing device is successful
			if (init == 1){
				$("#getBackIp",window.parent.document).val(ipAddr);	
				window.parent.getBackIp();
			} 
        }
	});
	
	WebVideoCtrl.I_InsertOBJECTPlugin("divPlugin");
	
	//Parameters of camera
	var oLiveView = {
		iProtocol: 1,			// protocol 1：http, 2:https
		szIP: ipAddr,	// protocol ip
		szPort: port,			// protocol port
		szUsername: account,	// device username
		szPassword: pwd,	// device password
		iStreamType: 1,			// stream 1：main stream  2：sub-stream  3：third stream  4：transcode stream
		iChannelID: 1,			// channel no
		bZeroChannel: false		// zero channel
	};

	//Login camera
	WebVideoCtrl.I_Login(oLiveView.szIP, oLiveView.iProtocol, oLiveView.szPort, oLiveView.szUsername, oLiveView.szPassword, {
		success: function (xmlDoc) {
			//Callback when device login is successful
			WebVideoCtrl.I_StartRealPlay(oLiveView.szIP, {
				iStreamType: oLiveView.iStreamType,
				iChannelID: oLiveView.iChannelID,
				bZeroChannel: oLiveView.bZeroChannel
			});
			init = 1;
		}
	});
	
	//Close browser
	$(window).unload(function () {
		WebVideoCtrl.I_Stop();
	});
});