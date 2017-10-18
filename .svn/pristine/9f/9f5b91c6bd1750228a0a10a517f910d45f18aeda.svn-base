 <%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>管理评审会议查看</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>
	<script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
	
	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" /> 
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />	
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>会议管理</a><span>></span><a>会议申请</a><span>></span><a>管理评审会议</a><span>></span><a>查看</a>
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
					<input type="text" class="form-control" data-bind="value:meetingRoomName" readonly/>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">参与人员：</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="participants" readonly/>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">开始时间：</label>
				<div class="col-sm-4" data-bind="with:meetingAppVM">
					<input type="text" id="startDate" class="form-control datetimepicker" data-bind="dateTimePicker:startDate" readonly/>
				</div>
				<label class="col-sm-2 control-label">结束时间：</label>
				<div class="col-sm-4" data-bind="with:meetingAppVM">
					<input type="text" id="endDate" class="form-control datetimepicker"  data-bind="dateTimePicker:endDate" readonly/>
				</div>					
			</div>
			 <div class="form-group">
				<label class="col-sm-2 control-label">编制人：</label>
				<div class="col-sm-4" data-bind="with:meetingAppVM">
					<input type="text" class="form-control" data-bind="value:creatorAlias" readonly/>
				</div>
				<label class="col-sm-2 control-label">编制日期：</label>
				<div class="col-sm-4" data-bind="with:meetingAppVM">
					<input type="text" class="form-control datetimepicker"  data-bind="dateTimePicker:createdDate" readonly/>
				</div>					
			</div> 
			
			<div class="form-group">
				<label class="col-sm-2 control-label">管理评审报告：</label>
				<div class="col-sm-10 uploadFile6">
					<!-- <div class="document-content" id="report">
                    </div> -->
				</div>
			</div> 
			<div class="form-group">
				<label class="col-sm-2 control-label">质量体系文件修改表：</label>
				<div class="col-sm-10 uploadFile7">
					<!-- <div class="document-content" id="item">
                    </div> -->
				</div>
			</div> 
			<div class="form-group">
				<label class="col-sm-2 control-label">其他文件：</label>
				<div class="col-sm-10 uploadFile2">
					<!-- <div class="document-content" id="docs">
                    </div> -->
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
		     
		     
		     /* var meetingAppDocDataVM = {
		    	docs : ko.observableArray(meetingAppDocData)
		     } 
		     var docs= "";
		     var reportDocs = "";
		     var itemDocs = "";
		      if( meetingAppDocData.length != 0 ){
		        for(var i=0;i<meetingAppDocData.length;i++){
		        	if ( meetingAppDocData[i]['type'] == 2 ) {
		        	    docs += '<div class="document-style"><span><a href="${pageContext.request.contextPath}/meeting/meetingApp/document/downloadDocumentData.do?id='+meetingAppDocData[i].id+'">'+meetingAppDocData[i]['name']+'</a></span></div>';
		        	} else if ( meetingAppDocData[i]['type'] == 6 ) {
		        		reportDocs += '<div class="document-style"><span><a href="${pageContext.request.contextPath}/meeting/meetingApp/document/downloadDocumentData.do?id='+meetingAppDocData[i].id+'">'+meetingAppDocData[i]['name']+'</a></span></div>';
		        	} else if ( meetingAppDocData[i]['type'] == 7 ) {
		        		itemDocs += '<div class="document-style"><span><a href="${pageContext.request.contextPath}/meeting/meetingApp/document/downloadDocumentData.do?id='+meetingAppDocData[i].id+'">'+meetingAppDocData[i]['name']+'</a></span></div>';
		        	}
		    	}
		        $("#docs").html(docs);
		        $("#report").html(reportDocs);
		        $("#item").html(itemDocs);
		      } */
		     
		     /***********************参与人开始*******************************/
		      var participants = '';
		      
		      for(var i=0;i<meetingAppData.participants.length;i++){
		    	  participants += meetingAppData.participants[i].userAlias + "，";
		      }
		      
		      $("#participants").val(participants.substring(0,participants.length-1));
		      /***********************参与人结束*******************************/
		      
		     var vm = {
		    		 meetingAppVM : meetingAppDataVM,
		    		 /* meetingAppDocVM : meetingAppDocDataVM */
		     }
			
			 vm.backToList = function(){//返回
				 $('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/review/meetReviewList.do');
			 }
			
			 ko.applyBindings(vm);
			
		});
	</script>
</body>
</html>