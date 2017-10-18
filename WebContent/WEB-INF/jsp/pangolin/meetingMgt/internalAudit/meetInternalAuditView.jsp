<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>内部审核会议查看</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
	
	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet"><%-- 
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/meet/meet.css" />" rel="stylesheet" /> --%>
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" /> 
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>会议管理</a><span>></span><a>会议申请</a><span>></span><a>内部审核会议</a><span>></span><a>查看</a>
        </p>
   	</div>
	<div class="form-content">	
		<form class="form-horizontal">					
			<div class="form-group">
				<label class="col-sm-2 control-label">会议主题：</label>
				<div class="col-sm-4" data-bind="with:meetingAppVM">
					<input type="text" class="form-control" data-bind="value:subject" name="subject" readonly/>
				</div>
				<label class="col-sm-2 control-label">会议目的：</label>
				<div class="col-sm-4" data-bind="with:meetingAppVM">
					<input type="text" class="form-control" data-bind="value:purpose" name="purpose" readonly/>
				</div>				
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">会议室：</label>
				<div class="col-sm-4" data-bind="with:meetingAppVM">
					<input type="text" class="form-control" data-bind="value:meetingRoomName" name="meetingRoomName" readonly/>
				</div>							
			</div>			
			<div class="form-group">
				<label class="col-sm-2 control-label">参与人员：</label>
				<div class="col-sm-10">
					<textarea rows="8" cols="" class="form-control" id="participants" readonly></textarea>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">内审组长：</label>
				<div class="col-sm-10">
					<input class="form-control" readonly id="auditorLeader"></input>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">内审员：</label>
				<div class="col-sm-10">
					<textarea rows="8" cols="" class="form-control" id="iaParticipants" readonly></textarea>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">开始时间：</label>
				<div class="col-sm-4" data-bind="with:meetingAppVM">
					<input type="text" class="form-control datetimepicker" data-bind="dateTimePicker:startDate" name="startDate" readonly/>
				</div>
				<label class="col-sm-2 control-label">结束时间：</label>
				<div class="col-sm-4" data-bind="with:meetingAppVM">
					<input type="text" class="form-control datetimepicker" data-bind="dateTimePicker:endDate" name="endDate" readonly/>
				</div>					
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">会议签到文件：</label>
				<div class="col-sm-10 uploadFile0">
					<!-- <div class="document-content" id="sign"></div> -->
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">会议记录文件：</label>
				<div class="col-sm-10 uploadFile1">
					<!-- <div class="document-content" id="record"></div> -->
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">内部审核报告文件：</label>
				<div class="col-sm-10 uploadFile3">
					<!-- <div class="document-content" id="innerReport"></div> -->
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">不符合项报告文件：</label>
				<div class="col-sm-10 uploadFile4">
					<!-- <div class="document-content" id="report"></div> -->
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">内部审核检查文件：</label>
				<div class="col-sm-10 uploadFile5">
					<!-- <div class="document-content" id="item"></div> -->
				</div>
			</div>
		</form>
	</div>
	<div class="btn-content">
       	<button class="btn btn-color2 back-btn" data-bind="click: backToList"><i class="fa fa-chevron-left"></i>返回</button>
    </div>	
	<script>
		$(function(){	
			$('.datetimepicker').datetimepicker({
			    format: 'YYYY-MM-DD  HH:mm',
			});
			
			//时间控件数据绑定-----------开始
	  		ko.bindingHandlers.dateTimePicker = {
	  			init : function(element, valueAccessor, allBindingsAccessor) {
	  				//initialize datepicker with some optional options
	  				var options = allBindingsAccessor().dateTimePickerOptions || {};
	  				$(element).datetimepicker(options);
	  				
	  				//when a user changes the date, update the view model
	  				ko.utils.registerEventHandler(element, "dp.change",
	  						function(event) {
	  							var value = valueAccessor();
	  							if (ko.isObservable(value)) {
	  								if (event.date != null
	  										&& !(event.date instanceof Date)) {
	  									value(event.date.toDate());
	  								} else {
	  									value(event.date);
	  								}
	  							}
	  						});
	  				
	  				ko.utils.domNodeDisposal.addDisposeCallback(element,
	  						function() {
	  							var picker = $(element).data("DateTimePicker");
	  							if (picker) {
	  								picker.destroy();
	  							}
	  						});
	  			},
	  			update : function(element, valueAccessor, allBindings, viewModel, bindingContext) {
	  				var picker = $(element).data("DateTimePicker");
	  				//when the view model is updated, update the widget
	  				if (picker) {
	  					var koDate = ko.utils.unwrapObservable(valueAccessor());
	  					//in case return from server datetime i am get in this form for example /Date(93989393)/ then fomat this
	  					koDate = (typeof (koDate) !== 'object') ? new Date(
	  							parseFloat(koDate)) : koDate;
	  					picker.date(koDate);
	  				}
	  			}
	  		};
	  		//时间控件数据绑定-----------结束 
			
	  	  var meetingAppData = loadData("${pageContext.request.contextPath}/meeting/meetingApp/loadMeetingAppData.do", { "id" : "${param.id}"});
	  	  var meetingAppDataVM = ko.mapping.fromJS(meetingAppData);
	  	      
	  	  var participants = '';
	      var iaParticipants = '';
	        
	  	  for(var i=0;i<meetingAppData.participants.length;i++){
	  	      participants += meetingAppData.participants[i].userAlias + "，";
	  	  }
	  	  
	  	  for(var i=0;i<meetingAppData.iaParticipants.length;i++){
	  		  if( meetingAppData.iaParticipants[i].userType == 1 ){
	  			  iaParticipants += meetingAppData.iaParticipants[i].userAlias + "，";
	  		  }else if( meetingAppData.iaParticipants[i].userType == 0 ){
	  			  $("#auditorLeader").val(meetingAppData.iaParticipants[i].userAlias);
	  		  }
	  	      
	  	  }
	  	  
	  	var meetingAppDocData = loadData("${pageContext.request.contextPath}/meeting/meetingApp/document/getDocumentListByAppIdData.do",{ "id" : "${param.id}" });
	  	console.log(meetingAppDocData);
      	if( meetingAppDocData.length != 0 ){
        	for(var i=0;i<meetingAppDocData.length;i++){
        		var fileTypeName = meetingAppDocData[i].name.split(".")[meetingAppDocData[i].name.split(".").length-1];
				var fileNameLength = meetingAppDocData[i].name.length-fileTypeName.length-1;
				var dataName = meetingAppDocData[i].name.substring(0,fileNameLength);
				var dataId = meetingAppDocData[i].id;
				var uoloadFfileType = fileTypeName.toLowerCase();
				var imgArr = ["jpg", "jpeg", "png", "bmp"];
				var fileArr = ["doc", "docx", "xls", "xlsx", "ppt", "pptx", "pdf", "txt"];
				var videoArr = ["mov", "avi", "mp4", "wmv"];
	      		var html = '';
				html += '<div class="list-content">';
				html += '<div class="list-img">';	
				if($.inArray(uoloadFfileType,imgArr)!= -1){
					html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/img.png">';
				} else if($.inArray(uoloadFfileType,videoArr)!= -1){
					html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/video.png">';
				} else {
					html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/'+uoloadFfileType+'.png">';
				}
				html += '</div>';
				html += '<div class="list-name" title="'+dataName+'">';
				html += '<p><a href="${pageContext.request.contextPath}/meeting/meetingApp/document/downloadDocumentData.do?id='+dataId+'">'+dataName+'</a></p>';
				html += '</div>';
				//html += '<button type="button" title="删除" data-id="'+dataId+'" class="remove">×</button>';
				html += '</div>';
        		var meetingAppDocDataType = meetingAppDocData[i].type;
        		$('.uploadFile' + meetingAppDocDataType).prepend(html);
    		}
     	} 
	  	 
	  	 
	  	 /* var sign = "";
	  	 var record = "";
	  	 var innerReport = "";
	     var report = "";
	     var item = ""; 
		    
	      if( meetingAppDocData.length != 0 ){
	        for(var i=0;i<meetingAppDocData.length;i++){
	        	if ( meetingAppDocData[i]['type'] == 0 ) {
	        	    sign += '<div class="document-style"><span>  	  <a href="${pageContext.request.contextPath}/meeting/meetingApp/document/downloadDocumentData.do?id='+meetingAppDocData[i].id+'">'+meetingAppDocData[i]['name']+'</a></span></div>';
	        	} else if ( meetingAppDocData[i]['type'] == 1 ) {
	        		record += '<div class="document-style"><span>     <a href="${pageContext.request.contextPath}/meeting/meetingApp/document/downloadDocumentData.do?id='+meetingAppDocData[i].id+'">'+meetingAppDocData[i]['name']+'</a></span></div>';
	        	} else if ( meetingAppDocData[i]['type'] == 3 ) {
	        		innerReport += '<div class="document-style"><span><a href="${pageContext.request.contextPath}/meeting/meetingApp/document/downloadDocumentData.do?id='+meetingAppDocData[i].id+'">'+meetingAppDocData[i]['name']+'</a></span></div>';
	        	} else if ( meetingAppDocData[i]['type'] == 4 ) {
	        		report += '<div class="document-style"><span>     <a href="${pageContext.request.contextPath}/meeting/meetingApp/document/downloadDocumentData.do?id='+meetingAppDocData[i].id+'">'+meetingAppDocData[i]['name']+'</a></span></div>';
	        	} else if ( meetingAppDocData[i]['type'] == 5 ) {
	        		item += '<div class="document-style"><span>       <a href="${pageContext.request.contextPath}/meeting/meetingApp/document/downloadDocumentData.do?id='+meetingAppDocData[i].id+'">'+meetingAppDocData[i]['name']+'</a></span></div>';
	        	}
	        	
	    	}
	        
	        $("#sign").html(sign);
	        $("#record").html(record);
	        $("#innerReport").html(innerReport);
	        $("#report").html(report);
	        $("#item").html(item);
	      } */
	  	 
	  	  
	  	  $("#participants").val(participants.substring(0,participants.length-1));
	  	  $("#iaParticipants").val(iaParticipants.substring(0,iaParticipants.length-1));
	  	      
	  	      var vm = {
	  	    		  meetingAppVM : meetingAppDataVM
	  	      }
	  	      
	  	      vm.backToList = function(){
	  	    	  $('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/internalAudit/meetInternalAuditList.do');
	  	      }
	
	  	      ko.applyBindings(vm);
		});
	</script>
</body>
</html>