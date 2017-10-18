<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>管理评审会议文件审批状态查看</title>
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
    <script src="<c:url value="/resources/frameworks/pangolin/js/ajaxfileupload.js" />"></script>
	
	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/meet/meet.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" /> 
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
	<div class="content">
		<div class="crumbs-nav">
	        <p class="crumbs-text">
	           	当前位置：<a>会议管理</a><span>></span><a>会议申请</a><span>></span><a>管理评审会议</a>
	        </p>
    	</div>
		
		<form class="form-horizontal myform">	
			<div class="mid-title"><span>丨</span> 管理评审会议申请</div>														
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
				<label class="col-sm-2 control-label">参会人：</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="participants" readonly/>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">开始时间：</label>
				<div class="col-sm-4" data-bind="with:meetingAppVM">
					<input type="text" id="startDate" class="form-control" data-bind="dateTimePicker:startDate" readonly/>
				</div>
				<label class="col-sm-2 control-label">结束时间：</label>
				<div class="col-sm-4" data-bind="with:meetingAppVM">
					<input type="text" id="endDate" class="form-control"  data-bind="dateTimePicker:endDate" readonly/>
				</div>					
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">会议室：</label>
				<div class="col-sm-10" data-bind="with:meetingAppVM">
					<input type="text" class="form-control" data-bind="value:meetingRoomName" readonly/>
				</div>						
			</div>
		    <div class="form-group">
				<label class="col-sm-2 control-label">编制人：</label>
				<div class="col-sm-4" data-bind="with:meetingAppVM">
					<input type="text" class="form-control" data-bind="value:creatorAlias" readonly/>
				</div>
				<label class="col-sm-2 control-label">编制日期：</label>
				<div class="col-sm-4" data-bind="with:meetingAppVM">
					<input type="text" class="form-control"  data-bind="dateTimePicker:createdDate" readonly/>
				</div>					
			</div> 
			<!-- <div class="form-group">
				<label class="col-sm-2 control-label">批准人：</label>
				<div class="col-sm-4" data-bind="with:meetingAppVM">
					<input type="text" class="form-control" data-bind="value:approverAlias" readonly/>
				</div>
				<label class="col-sm-2 control-label">批准日期：</label>
				<div class="col-sm-4" data-bind="with:meetingAppVM">
					<input type="text" class="form-control"  data-bind="dateTimePicker:approvedDate" readonly/>
				</div>					
			</div>  -->
			<div class="form-group">
					<label class="col-sm-2 control-label">文件上传：</label>
					<div class="col-sm-4">
	                	<input type="text" placeholder="" class="form-control input-text" id="enterFile">
	                </div>
	                <div class="col-sm-6 file-btn">
	                	<button type="button" class="btn btn-color1"><i class="fa fa-folder-open-o"></i>浏览</button>
	                	<button type="button" id="uploadFile" class="btn btn-color2"><i class="fa fa-upload"></i>上传</button>
	                	<input type="file" name="file" id="file" class="input-file">
	                </div>	
			</div>
            <div class="recordfile">
				<div class="recordOkfile"></div>
			</div>
            <div class="form-group">
            	<label class="col-sm-2 control-label"></label>
            	<div class="col-sm-10">
            		<a href="${pageContext.request.contextPath }/meetingMgt/review/reviewReportForm.do?id=${param.id}">管理评审报告.doc</a>
            	</div>
            </div>
             <div class="form-group">
            	<label class="col-sm-2 control-label"></label>
            	<div class="col-sm-10">
            		<a href="${pageContext.request.contextPath }/meetingMgt/review/alterOpinionForm.do?id=${param.id}">质量体系文件修改意见表.doc</a>
            	</div>
            </div>
			
			<div class="form-group">
				<div class="center">	
				    <button type="submit" data-bind="click: saveData" class="submit-btn">√ 提交</button>			
					<button class="back-btn"  data-bind="click: backToList">< 返回</button>
				</div>
			</div>
		</form>
	</div>	
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
	<script>
			
	$(function(){
		
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
	     var meetingAppDocDataVM = {
	    		  docs : ko.observableArray(meetingAppDocData)
	     }
	     
	      var docs = "";
		    
	     if( meetingAppDocData.length != 0 ){
		       for(var i=0;i<meetingAppDocData.length;i++){
		    	    docs += '<div class="ccflie"><div class="col-sm-2"></div>';
		    	    docs +='<div class="col-sm-10"><a href="${pageContext.request.contextPath}/meeting/meetingApp/document/downloadDocumentData.do?id='+meetingAppDocData[i].id+'"><span id="fileNameText">'+meetingAppDocData[i]['name'] +'</span></a>'
		    	    		+'<button type="button" class="remove" data-id="' + meetingAppDocData[i].id +'" >×</button></div>';
		    	    docs +='</div>';
		       }
		    	    
		    	$('.recordOkfile').append(docs);
		        $('.recordfile').show();
		 }
	     
	     /***********************参与人开始*******************************/
	      var participants = '';
	      
	      for(var i=0;i<meetingAppData.participants.length;i++){
	    	  participants += meetingAppData.participants[i].userAlias + ",";
	      }
	      
	      $("#participants").val(participants.substring(0,participants.length-1));
	      /***********************参与人结束*******************************/
	      
	     var vm = {
	    	  meetingAppVM : meetingAppDataVM,
	    	  meetingAppDocVM : meetingAppDocDataVM
	     }
	      
	     vm.saveData = function(){
	    	 $("button").attr("disabled", true);
		        if ( validateSubmittedData() ) {
		        	meetingAppDataVM.status = 5;
		        	if( saveData("${pageContext.request.contextPath}/meeting/meetingApp/saveMeetingAppData.do",meetingAppDataVM )){
	   	    		    saveSuccess("${pageContext.request.contextPath}/meetingMgt/review/meetReviewList.do");
	   	    	    }else{
	   	    	    	$("button").attr("disabled", false);
	   	    		    saveFailure();
	   	    	    }
		        } else {
		        	$("button").attr("disabled", false);
		        	saveFailure();
		        }
	      }
		
		 vm.backToList = function(){//返回
			 $('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/review/meetReviewList.do');
		 }
		
		 ko.applyBindings(vm);
		
		
		 
		 /*文件上传*/
			$(".preview").click(function(){
			    $(this).prev().prev().trigger("click");
		    })
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
		    	if($('#file').val() ==''){
		    		  $("html, body").animate({ scrollTop: 0 }, 200);
						promptContent("没有文件上传！");
						$(".alert").addClass("alert-danger").removeClass("alert-success");
						$(".promptDiv").slideDown();
						return false;
		    	  }else{
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
		  					     +'<button type="button"  data-id="'+data.id+'" class="remove">×</button></div>';
		  					html +='</div>';
		  					
		  					$('.recordOkfile').append(html);
		  					$('.recordfile').show();  						
		   				},
		   				error: function (data, status, e) {
		   					alert(e);
		   				}
		   			});  		
		    	  }
				  	   	  
		 })
		    
		     /*文件删除*/
		  $('.recordOkfile').on('click','.remove',function(){
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
		 
	});
	

	 	
	
	</script>
</body>
</html>