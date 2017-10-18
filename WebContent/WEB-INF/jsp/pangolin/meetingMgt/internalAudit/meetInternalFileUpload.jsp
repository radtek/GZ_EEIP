<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>内部审核文件上传</title> 
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/ajaxfileupload.js" />"></script>
	
	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" /> 
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/meet/meet.css" />" rel="stylesheet" />
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>会议管理</a><span>></span><a>会议申请</a><span>></span><a>内部审核会议</a><span>></span><a>文件上传</a>
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
				<label class="col-sm-2 control-label">参会人员：</label>
				<div class="col-sm-10">
					<textarea rows="8" cols="" class="form-control" id="participants" readonly></textarea>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">内审组长：</label>
				<div class="col-sm-4">
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
				<label class="col-sm-2 control-label">会议室：</label>
				<div class="col-sm-4" data-bind="with:meetingAppVM">
					<input type="text" class="form-control" data-bind="value:meetingRoomName" name="meetingRoomName" readonly/>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">会议文件：</label>
				<div class="col-sm-4">
                	<input type="text" placeholder="上传会议签到表" class="form-control input-text" />
                </div>
                <div class="col-sm-6 file-btn">
                	<button type="button" class="btn btn-color1 preview"><i class="fa fa-folder-open-o"></i>浏览</button>
                	<button type="button" id="uploadFile" class="btn btn-color2"><i class="fa fa-upload"></i>上传</button>
                	<input type="file" name="file" id="file" class="input-file" />
                </div>
                <div class="signfile">
					<div class="signOkfile"></div>
				</div>
				
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label"></label>
				<div class="col-sm-4">
                	<input type="text" placeholder="上传会议记录表" class="form-control input-text" />
                </div>
                <div class="col-sm-6 file-btn">
                	<button type="button" class="btn btn-color1 preview"><i class="fa fa-folder-open-o"></i>浏览</button>
                	<button type="button" id="upload" class="btn btn-color2"><i class="fa fa-upload"></i>上传</button>
                	<input type="file" name="file" id="recordFile" class="input-file" />
                </div>
            </div>
            <div class="recordfile">
				<div class="recordOkfile"></div>
			</div>
            <div class="form-group">
            	<label class="col-sm-2 control-label"></label>
            	<div class="col-sm-10">
            		<a href="${pageContext.request.contextPath}/meetingMgt/internalAudit/meetInternalReportForm.do?id=${param.id}">内部审核报告.doc</a>
            	</div>
            </div>
            <div class="form-group">
            	<label class="col-sm-2 control-label"></label>
            	<div class="col-sm-10">
            		<a href="${pageContext.request.contextPath}/meetingMgt/internalAudit/inconformityReportList.do?id=${param.id}&status=0">不符合项报告.doc</a>
            	</div>
            </div>
            <div class="form-group">
            	<label class="col-sm-2 control-label"></label>
            	<div class="col-sm-10">
            		<a href="${pageContext.request.contextPath}/meetingMgt/internalAudit/meetInternalInspectList.do?id=${param.id}&status=0">内部审核检查表.doc</a>
				</div>
            </div>
			
			<!-- <div class="form-group">
				<div class="center">
					<button type="submit" data-bind="click: saveData" class="submit-btn">√ 提交</button>
					<button type="submit" data-bind="click: backToList" class="back-btn">< 返回</button>
				</div>
			</div> -->
		</form>
	</div>	
	<div class="btn-content">
       	<button class="btn btn-color2 back-btn" data-bind="click: backToList"><i class="fa fa-chevron-left"></i>返回</button>
       	<button class="btn btn-color1" data-bind="click: saveData"><i class="fa fa-check"></i>提交</button>
   	</div>
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
	<script>
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
      
      var meetingRoomData = loadData("${pageContext.request.contextPath}/meeting/meetingRoom/emptyMeetingRoomData.do",{});
      var meetingRoomDataVM = {
    		  roomList:ko.observableArray(meetingRoomData),
    		  roomId:ko.observable(meetingAppData.meetingRoomId)
      }
      
      var meetingAppDocData = loadData("${pageContext.request.contextPath}/meeting/meetingApp/document/getDocumentListByAppIdData.do",{ "id" : "${param.id}" });
      
      var sign = "";
      var record = "";
	    
      if( meetingAppDocData.length != 0 ){
        for(var i=0;i<meetingAppDocData.length;i++){
        	if( meetingAppDocData[i]['type'] == 0 ){
        		sign += '<div class="ccflie"><div class="col-sm-2"></div>';
        		sign +='<div class="col-sm-10"><a href="${pageContext.request.contextPath}/meeting/meetingApp/document/downloadDocumentData.do?id='+meetingAppDocData[i]['id']+'"><span id="fileNameText">'+meetingAppDocData[i]['name'] +'</span></a></div>';
        		sign +='</div>';
        	}else if( meetingAppDocData[i]['type'] == 1 ){
        		record += '<div class="ccflie"><div class="col-sm-2"></div>';
        		record +='<div class="col-sm-10"><a href="${pageContext.request.contextPath}/meeting/meetingApp/document/downloadDocumentData.do?id='+meetingAppDocData[i]['id']+'"><span id="fileNameText">'+meetingAppDocData[i]['name'] +'</span></a></div>';
        		record +='</div>';
        	}
    	    
    	}
    	    
    	$('.signOkfile').html(sign);
        $('.signfile').show();
        
        $('.recordOkfile').html(record);
        $('.recordfile').show();
     } 
      
      var participants = '';
      var iaParticipants = '';
      
	  for(var i=0;i<meetingAppData.participants.length;i++){
	      participants += meetingAppData.participants[i].userAlias + ",";
	  }
	  
	  for(var i=0;i<meetingAppData.iaParticipants.length;i++){
		  if( meetingAppData.iaParticipants[i].userType == 1 ){
			  iaParticipants += meetingAppData.iaParticipants[i].userAlias + ",";
		  }else if( meetingAppData.iaParticipants[i].userType == 0 ){
  			  $("#auditorLeader").val(meetingAppData.iaParticipants[i].userAlias);
  		  }
	      
	  }
	  
	  $("#participants").val(participants.substring(0,participants.length-1));
	  $("#iaParticipants").val(iaParticipants.substring(0,iaParticipants.length-1));
      
      var vm = {
    		  meetingAppVM : meetingAppDataVM,
    		  meetingRoomVM : meetingRoomDataVM
      }
		
	    vm.saveData = function(){ 
	    	$("button").attr("disabled", true);
	        if ( validateSubmittedData() ) {
	        	meetingAppDataVM.status = 5;
	        	if( saveData("${pageContext.request.contextPath}/meeting/meetingApp/saveMeetingAppData.do",meetingAppDataVM )){
   	    		    saveSuccess("${pageContext.request.contextPath}/meetingMgt/internalAudit/meetInternalAuditList.do");
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
			$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/internalAudit/meetInternalAuditList.do');
		}
		
		ko.applyBindings(vm);
		
		/* var report = loadData("${pageContext.request.contextPath}/meeting/meetingIa/report/loadReportByAppIdData.do", { "id" : "${param.id}"});
		if(report.status == 0 || report.status == 3 || report.status == 1 ){
			$("#reportView").hide();
		}else{
			$("#report").hide();
			
		}
		//内部审核报告
		$("#report").click(function(){
			$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/internalAudit/meetInternalReportForm.do?id=${param.id}'); 
			
		});
		
		//内部审核报告查看
		$("#reportView").click(function(){
			$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/internalAudit/internalReportView.do?id=${param.id}&status=1'); 
			
		});
		
		//不符合项报告
		$("#iiReport").click(function(){
			$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/internalAudit/inconformityReportList.do?id=${param.id}&status=0'); 
			
		});
		
		//内部审核检查表
		$("#inspection").click(function(){
			$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/internalAudit/meetInternalInspectList.do?id=${param.id}&status=0'); 
			
		}); */
		
		/* var signId = ''; //会议签到表ID
		var recordId = ''; // 会议记录表ID
		
		var meetingAppDocData = loadData("${pageContext.request.contextPath}/meeting/meetingApp/document/getDocumentListByAppIdData.do",{ "id" : "${param.id}" });
		for(var i=0;i<meetingAppData.length;i++){
			if( meetingAppData[i].type == 0 ){
				signId = meetingAppData[i]['id'];
			}else if( meetingAppData[i]['type'] == 1 ){
				recordId = meetingAppData[i]['id'];
			}
		}
		 */
		/*文件上传*/
		$(".preview").click(function(){
			$(this).prev().prev().trigger("click");
		})
	    $(".enterFile").click(function(){
	    	$("#file").click();
	    	$('#file').change(function(){
	    	 	if($('#file').val() !=''){
	          		$('.enterFile').val($('#file').val());
	          	}else{
	          		$('.enterFile').val('');
	          	}
		    })
	    });
		
	    $("#enterFile").click(function(){
	    	$(".recordFile").click();
	    	$('.recordFile').change(function(){
	    	 	if($('.recordFile').val() !=''){
	          		$('#enterFile').val($('.recordFile').val());
	          	}else{
	          		$('#enterFile').val('');
	          	}
		    })
	    });
	    
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
 					'type':0
 					},
 				secureuri:false,
 				fileElementId:'file',//file标签的id
 				dataType: 'json',//返回数据的类型
 				success: function (data) {
 					$('.enterFile').val('');//上传成功就清空查看栏
 					var html='';
					html +='<div class="ccflie"><div class="col-sm-2"></div>';
					html +='<div class="col-sm-10"><a href="${pageContext.request.contextPath}/meeting/meetingApp/document/downloadDocumentData.do?id='+data.id+'"><span id="fileNameText">'+data.fileName +'</span></a></div>';
					html +='</div>';
					$('.signOkfile').html(html);
			        $('.signfile').show(); 
 				},
 				error: function (data, status, e) {
 					alert(e);
 				}
 			});  	
      	  }
      })
      
      $('#upload').click(function(){
    	  if($('#recordFile').val() ==''){
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
 					'type':1
 					},
 				secureuri:false,
 				fileElementId:'recordFile',//file标签的id
 				dataType: 'json',//返回数据的类型
 				success: function (data) {
 					$('#enterFile').val('');//上传成功就清空查看栏
 					$('.recordOkfile').html('');
 					var html='';
					html +='<div class="ccflie"><div class="col-sm-2"></div>';
					html +='<div class="col-sm-10"><a href="${pageContext.request.contextPath}/meeting/meetingApp/document/downloadDocumentData.do?id='+data.id+'"><span id="fileNameText">'+data.fileName +'</span></a></div>';
					html +='</div>';
					$('.recordOkfile').html(html);
			        $('.recordfile').show();		 	
 				},
 				error: function (data, status, e) {
 					alert(e);
 				}
 			});  	
      	  }
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
</body>
</html>