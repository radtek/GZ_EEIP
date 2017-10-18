<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>会议文件上传</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" /> <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/ajaxfileupload.js" />"></script>
	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/meet/meet.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" /> 
</head>
<body>
	<div class="content">
		<div class="crumbs-nav">
	        <p class="crumbs-text">
	           	当前位置：<a>会议管理</a><span>></span><a>会议申请</a><span>></span><a>普通会议</a>
	        </p>
    	</div>
		
		<form class="form-horizontal myform">
															
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
				<label class="col-sm-2 control-label">参会人：</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="participants" readonly/>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">开始时间：</label>
				<div class="col-sm-4" data-bind="with:meetingAppVM">
					<input type="text" class="form-control" data-bind="dateTimePicker:startDate" name="startDate" readonly/>
				</div>
				<label class="col-sm-2 control-label">结束时间：</label>
				<div class="col-sm-4" data-bind="with:meetingAppVM">
					<input type="text" class="form-control" data-bind="dateTimePicker:endDate" name="endDate" readonly/>
				</div>					
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">备注：</label>
				<div class="col-sm-10" data-bind="with:meetingAppVM">
					<textarea rows="8" cols="" class="form-control" data-bind="value:remarks" name="remarks" readonly></textarea>
				</div>						
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">文件上传：</label>
				<div class="upload-file">
					<div class="item">
						<input type="text" id="enterFile"/>
					    <input type="file" id="file" name="file" style="display:none;"/>
						<button type="button" class="preview"><img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/expert/preview.png"> 浏览</button>
						<button type="button" class="upload" id="uploadFile"><img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/expert/upload.png"> 上传</button>
					</div>
				</div>	
				<div class="comfile">
					<div class="okfile"></div>
					<div class="clear"></div>
				</div>				
			</div>
				
			<div class="form-group">
				<div class="center">
					<button class="submit-btn" data-bind="click: agree">√ 提交</button>
					<button class="back-btn" data-bind="click: backToList">< 返回</button>
				</div>
			</div>
		</form>
	</div>	
	
</body>
<script type="text/javascript">

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
      
      /***********************参与人开始*******************************/
      var participants = '';
      
      for(var i=0;i<meetingAppData.participants.length;i++){
    	  participants += meetingAppData.participants[i].userAlias + ",";
      }
      
      $("#participants").val(participants.substring(0,participants.length-1));
      /***********************参与人结束*******************************/
      
      var meetingAppDocData = loadData("${pageContext.request.contextPath}/meeting/meetingApp/document/getDocumentListByAppIdData.do",{ "id" : "${param.id}" });
      var docs = "";
	    
      if( meetingAppDocData.length != 0 ){
        for(var i=0;i<meetingAppDocData.length;i++){
    	    docs += '<div class="ccflie"><div class="col-sm-2"></div>';
    	    docs +='<div class="col-sm-10"><a href="${pageContext.request.contextPath}/meeting/meetingApp/document/downloadDocumentData.do?id='+meetingAppDocData[i]['id']+'"><span id="fileNameText">'+meetingAppDocData[i]['name'] +'</span></a>'
    	    +'<button type="button" class="remove" data-id="' + meetingAppDocData[i].id +'" >×</button></div>';
    	    docs +='</div>';
    	}
    	    
    	$('.okfile').append(docs);
        $('.comfile').show();
     }
      
      var vm = {
    		  meetingAppVM : meetingAppDataVM
      }
      
      vm.agree = function(){
    	  meetingAppDataVM.status = 6;
    	  if( saveData("${pageContext.request.contextPath}/meeting/meetingApp/saveMeetingAppData.do",meetingAppDataVM )){
    		  $('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/generalMeet/meetingApplyList.do');
    	  }
      }
      
      
      vm.backToList = function(){
    	  $('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/generalMeet/meetingApplyList.do');
      }

      ko.applyBindings(vm);
      
      /*文件上传*/
	    $("#enterFile").click(function(){
	    	$("#file").click();
	    	$('#file').change(function(){
	    	 	if($('#file').val() !=''){
	          		$('#enterFile').val($('#file').val());
	          	}else{
	          		$('#enterFile').val('');
	          	}
		    })
	    });
	    $('#file').change(function(){
  	 	if($('#file').val() !=''){
        		$('#enterFile').val($('#file').val());
        	}else{
        		$('#enterFile').val('');
        	}
	    })
      $('#uploadFile').click(function(){	    	 		  	
 			$.ajaxFileUpload({
 				url:'${pageContext.request.contextPath}/meeting/meetingApp/document/upoadDocumentData.do',
 				data:{
 					'id' : meetingAppData.id,
 					'creatorId' : '${sessionScope.loginUser.userId}',
 					'creatorName' : '${sessionScope.loginUser.userName}',
 					'creatorAlias' : '${sessionScope.loginUser.userAlias}',
 					'type':2
 					},
 				secureuri:false,
 				fileElementId:'file',//file标签的name
 				dataType: 'json',//返回数据的类型
 				success: function (data) {
 					$('#enterFile').val('');//上传成功就清空查看栏
					var html='';
					html +='<div class="ccflie"><div class="col-sm-2"></div>';
					html +='<div class="col-sm-10"><a href="${pageContext.request.contextPath}/meeting/meetingApp/document/downloadDocumentData.do?id='+data.id+'"><span id="fileNameText">'+data.fileName +'</span></a>'
					      +'<button type="button"  data-id="'+data.id+'" class="remove" aria-hidden="true">×</button></div>';
					html +='</div>';
					$('.okfile').append(html);
					$('.comfile').show();  						
 				},
 				error: function (data, status, e) {
 					alert(e);
 				}
 			});  		  	   	  
      })
      
       /*文件删除*/
    $('.okfile').on('click','.remove',function(){
  	  var  fileid = $(this).attr('data-id');
  	  var  filethis = $(this);
  	  $.ajax({
  		  url:'${pageContext.request.contextPath}/meeting/meetingApp/document/removeDocumentData.do',
  		  data:{'id':fileid},
  		  datatype:'json',
  		  type:'post',
  		  success:function(data){
  			  if( data['status'] ){
  				  filethis.closest('.ccflie').remove();
  			  }
  		  },
  		  error:function(){
  			  alert('删除文件失败');
  		  }
  	  })
    })
    /*文件删除结束*/
      
</script>
</html>