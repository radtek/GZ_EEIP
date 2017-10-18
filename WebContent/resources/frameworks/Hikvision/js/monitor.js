/**
JavaScript Document - Video recording of single camera
Author: Oscar Mok
Version: 1.0
Date: Sat 1 Apr 2017
*/

var DRIVE = "Z"; //Network drive

var RECORD_PATH = DRIVE + ":\\record\\"; //Path of record
var DOWNLOAD_PATH = DRIVE + ":\\downloads\\"; //Path of download
var CAPTURE_PATH = DRIVE + ":\\captures\\"; //Path of capture
var PLAYBACK_PIC_PATH = DRIVE + ":\\playback_pics\\"; //Path of playback photos
var PLAYBACK_FILE_PATH = DRIVE + ":\\playback_files\\"; //Path of playback files

var BUFFER_TYPE = "2"; //Type of buffer (0: Minimum delay, 1: Real-time, 2: Balanced, 3: Fluency)
var PACKAGE_SIZE = "2"; //Size of data package (0: 256M, 1: 512M, 2: 1G)
var WND_SIZE = "0"; //Size of image (0: Full, 1: 4:3, 2: 16:9)
var RULE_INFO = "0"; //Information of rule (0: Disabled, 1: Enabled)
var CAPTURE_FILE_FORMAT = "0"; //Format of capture file (0: JPEG, 1: BMP)
var PROTOCOL_TYPE = "0"; //Type of protocol (0: TCP, 2: UDP)
var VIDEO_FILE_FORMAT = ".mp4"; //Format of video file

var CTRL_WIDTH = 500;
var CTRL_HEIGHT = 300;

//Get value of url parameter
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}

//Get date directory
function getDateDir() {
	var date = new Date();
	var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var day = date.getDate();
    return year + "-" + (month < 10 ? "0" + month : "" + month) + "-" + (day < 10 ? "0" + day : "" + day);
}

//Start record
function startRecord() {
	var fileName = "";
	try {
		var g_iWndIndex = 0;
		var oWndInfo = WebVideoCtrl.I_GetWindowStatus(g_iWndIndex);
		
		if (oWndInfo != null) {
			var szFileName = oWndInfo.szIP + "_" + "CAM" + "_" + new Date().getTime();
			var iRet = WebVideoCtrl.I_StartRecord(szFileName);
			
			if (iRet == 0) {
				fileName = RECORD_PATH + getDateDir() + "\\" + szFileName + VIDEO_FILE_FORMAT;
//				alert(fileName);
				alert("Start recording successfully");
//				$("#getVedioPath",window.parent.document).val(fileName);
				window.parent.getVedioPath(fileName);
		    } else {
				alert("Failed to record");
		    }
	    }
	} catch(e) {
		console.log(e);
	}
	return fileName;
}

//Stop record
function stopRecord() {
	try {
		var g_iWndIndex = 0;
		var oWndInfo = WebVideoCtrl.I_GetWindowStatus(g_iWndIndex);

	    if (oWndInfo != null) {
			var iRet = WebVideoCtrl.I_StopRecord();
		    if (iRet == 0) {
				alert("Stop recording successfully");
			} else {
				alert("Failed to stop");
			}
		}
	} catch(e) {
		console.log(e);
	}
}

//Set local configuration
function setLocalCfg() {
	try {
		var arrXml = [];
			
		arrXml.push("<LocalConfigInfo>");
	    arrXml.push("<PackgeSize>" + PACKAGE_SIZE + "</PackgeSize>"); //Size of data package
	    arrXml.push("<PlayWndType>" + WND_SIZE + "</PlayWndType>"); //Size of image
	    arrXml.push("<BuffNumberType>" + BUFFER_TYPE + "</BuffNumberType>"); //Type of buffer
	    arrXml.push("<RecordPath>" + RECORD_PATH + "</RecordPath>"); //Path of record
	    arrXml.push("<CapturePath>" + CAPTURE_PATH + "</CapturePath>"); //Path of capture
	    arrXml.push("<PlaybackFilePath>" + PLAYBACK_FILE_PATH + "</PlaybackFilePath>"); //Path of playback files
	    arrXml.push("<PlaybackPicPath>" + PLAYBACK_PIC_PATH + "</PlaybackPicPath>"); //Path of playback photos
	    arrXml.push("<DownloadPath>" + DOWNLOAD_PATH + "</DownloadPath>"); //Path of download
	    arrXml.push("<IVSMode>" + RULE_INFO + "</IVSMode>"); //Mode of IVS
	    arrXml.push("<CaptureFileFormat>" + CAPTURE_FILE_FORMAT + "</CaptureFileFormat>"); //Format of capture file
        arrXml.push("<ProtocolType>" + PROTOCOL_TYPE + "</ProtocolType>"); //Type of protocol
	    arrXml.push("</LocalConfigInfo>");

	    var iRet = WebVideoCtrl.I_SetLocalCfg(arrXml.join(""));

	    if (iRet == 0) {
			console.log("Configuration of device is applied");
	    } else {
			console.log("Failed to set local settings");
	    }
	} catch(e) {
		console.log(e);
	}
}


$(function () {
	var ipAddr = getUrlParam("ipAddr"); //ip address of device
	var port = getUrlParam("port"); //port of device
	var account = getUrlParam("account"); //account of device
	var pwd = getUrlParam("pwd"); //password of device
	
	//Check if plugin is installed
	var iRet = WebVideoCtrl.I_CheckPluginInstall();
	if (iRet == -2) {
		alert("Chrome does not support NPAPI");
	} else if (iRet == -1) {
		alert("Please install plugins 'WebComponentsKit.exe' first!");
	}
	
	//Initialize plug
	WebVideoCtrl.I_InitPlugin(CTRL_WIDTH, CTRL_HEIGHT, {
		bWndFull: true,
		iWndowType: 1,
		cbSelWnd: function (xmlDoc) {
			//Callback when choosing device is successful
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
		}
	});
	
	setLocalCfg(); //Set local config
	
	//Close browser
	$(window).unload(function () {
		WebVideoCtrl.I_Stop();
	});
});