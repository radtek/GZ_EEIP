<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>内部审核会议表单</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/ajaxfileupload.js" />"></script>
	
	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />  
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" /> 
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/knowledgeMgt/fileMgt-form.css" />" rel="stylesheet" />
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>会议管理</a><span>></span><a>会议申请</a><span>></span><a>内部审核会议</a><span>></span><a>新增</a>
        </p>
   	</div>
	<div class="form-content">
		<form class="form-horizontal">					
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>会议主题：</label>
				<div class="col-sm-4" data-bind="with:meetingAppVM">
					<input type="text" class="form-control validation" data-bind="value:subject" name="subject" required/>
				</div>	
				<label class="col-sm-2 control-label">会议目的：</label>
				<div class="col-sm-4" data-bind="with:meetingAppVM">
					<input type="text" class="form-control validation" data-bind="value:purpose" name="purpose" />
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>会议室：</label>
				<div class="col-sm-4" data-bind="with:meetingRoomVM">
					<select id="roomId" class="form-control" data-bind="options:roomList,optionsValue:'id',optionsText:'name',value:roomId,optionsCaption:'--请选择--'" required>
					</select>
				</div>						
			</div>
			<div class="form-group">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>参与人员：</label>
                <div class="col-sm-10">
                    <div class="associated-file-content joins">
                    	<ul class="associated-file-list list-width-name" id="joins">
                    	</ul>
                    	<div class="add-associated-file">
                    		<button type="button" class="btn btn-color1 add-file-btn"><i class="fa fa-plus"></i>添加</button>
                    	</div>
                    </div>
                    <div class="add-content">
                    	<div class="search-content">
                    		<div class="col-sm-10 add-content-title">人员选择：</div>
					        <div class="col-sm-2 search-right" >
					        	<button type="button" class="btn btn-color2 hide-btn"><i class="fa fa-times"></i>收起</button>
					        </div>
					    </div>
					    <ul class="file-list" id="join">
					    </ul>
                    </div>
                </div>
            </div>	
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>内审组长：</label>
				<div class="col-sm-4">
					<select class="form-control" id="auditorLeader" required></select>
				</div>						
			</div>		
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>内审员：</label>
				<div class="col-sm-10">
                    <div class="associated-file-content auditors">
                    	<ul class="associated-file-list list-width-name" id="auditors">
                    	</ul>
                    	<div class="add-associated-file">
                    		<button type="button" class="btn btn-color1 add-file-btn"><i class="fa fa-plus"></i>添加</button>
                    	</div>
                    </div>
                    <div class="add-content">
                    	<div class="search-content">
                    		<div class="col-sm-10 add-content-title">人员选择：</div>
					        <div class="col-sm-2 search-right" >
					        	<button type="button" class="btn btn-color2 hide-btn"><i class="fa fa-times"></i>收起</button>
					        </div>
					    </div>
					    <ul class="file-list" id="auditor">
					    </ul>
                    </div>
                </div>						
			</div>				
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>开始时间：</label>
				<div class="col-sm-4" data-bind="with:meetingAppVM">
					<input type="text" id="startDate" class="form-control datetimepicker" data-bind="dateTimePicker:startDate" required/>
				</div>
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>结束时间：</label>
				<div class="col-sm-4" data-bind="with:meetingAppVM">
					<input type="text" id="endDate" class="form-control datetimepicker"  data-bind="dateTimePicker:endDate" required/>
				</div>					
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">会议签到文件：</label>
				<div class="col-sm-4">
                	<input type="text" placeholder="" class="form-control readonly-bg-color" readonly />
                </div>
                <div class="col-sm-6 file-btn">
                	<button type="button" class="btn btn-color1"><i class="fa fa-folder-open-o"></i>浏览</button>
                	<button type="button" class="btn btn-color2 uploading"><i class="fa fa-upload"></i>上传</button>
                	<input type="file" name="file" id="file" class="input-file preview" data-num="0" />
                </div>
                <div class="col-sm-10 col-sm-offset-2 recordfile uploadFile0"></div>	
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">会议记录文件：</label>
				<div class="col-sm-4">
                	<input type="text" placeholder="" class="form-control readonly-bg-color" readonly />
                </div>
                <div class="col-sm-6 file-btn">
                	<button type="button" class="btn btn-color1"><i class="fa fa-folder-open-o"></i>浏览</button>
                	<button type="button" class="btn btn-color2 uploading"><i class="fa fa-upload"></i>上传</button>
                	<input type="file" name="file" id="recordFile" class="input-file preview" data-num="1" />
                </div>
                <div class="col-sm-10 col-sm-offset-2 recordfile uploadFile1"></div>
            </div>
			<div class="form-group">
				<label class="col-sm-2 control-label">内部审核报告文件：</label>
				<div class="col-sm-4">
					<input type="text" placeholder="" class="form-control readonly-bg-color" readonly />
				</div>
				<div class="col-sm-6 file-btn">
					<button type="button" class="btn btn-color1"><i class="fa fa-folder-open-o"></i>浏览</button>
					<button type="button" class="btn btn-color2 uploading"><i class="fa fa-upload"></i>上传</button>
					<input type="file" name="file" id="innerReportFile" class="input-file preview" data-num="3" />
				</div>
				<div class="col-sm-10 col-sm-offset-2 recordfile uploadFile3"></div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">不符合项报告文件：</label>
				<div class="col-sm-4">
					<input type="text" placeholder="" class="form-control readonly-bg-color" readonly />
				</div>
				<div class="col-sm-6 file-btn">
					<button type="button" class="btn btn-color1"><i class="fa fa-folder-open-o"></i>浏览</button>
					<button type="button" class="btn btn-color2 uploading"><i class="fa fa-upload"></i>上传</button>
					<input type="file" name="file" id="reportFile" class="input-file preview" data-num="4" />
				</div>
				<div class="col-sm-10 col-sm-offset-2 recordfile uploadFile4"></div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">内部审核检查文件：</label>
				<div class="col-sm-4">
					<input type="text" placeholder="" class="form-control readonly-bg-color" readonly />
				</div>
				<div class="col-sm-6 file-btn">
					<button type="button" class="btn btn-color1"><i class="fa fa-folder-open-o"></i>浏览</button>
					<button type="button" class="btn btn-color2 uploading"><i class="fa fa-upload"></i>上传</button>
					<input type="file" name="file" id="itemFile" class="input-file preview" data-num="5" />
				</div>
				<div class="col-sm-10 col-sm-offset-2 recordfile uploadFile5"></div>
			</div>
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
		
		if ( "${param.id}" ) {
			$(".crumbs-text").html("当前位置：<a>会议管理</a><span>></span><a>会议申请</a><span>></span><a>内部审核会议</a><span>></span><a>修改</a>");
		}
		
		//时间控件数据绑定-----------开始
		ko.bindingHandlers.dateTimePicker = {
			init : function(element, valueAccessor, allBindingsAccessor) {
				//initialize datepicker with some optional options
				var options = allBindingsAccessor().dateTimePickerOptions || {};
				$(element).datetimepicker(options);
				
				//when a user changes the date, update the view model
				ko.utils.registerEventHandler(element, "dp.change", function(event) {
					var value = valueAccessor();
					if (ko.isObservable(value)) {
						if (event.date != null && !(event.date instanceof Date)) {
							value(event.date.toDate());
						} else {
							value(event.date);
						}
					}
				});
				
				ko.utils.domNodeDisposal.addDisposeCallback(element, function() {
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
					koDate = (typeof (koDate) !== 'object') ? new Date( parseFloat(koDate) ) : koDate;
					picker.date(koDate);
				}
			}
		};
		//时间控件数据绑定-----------结束 
		
		var meetingAppData = loadData("${pageContext.request.contextPath}/meeting/meetingApp/loadMeetingAppData.do", { "id" : "${param.id}"});
      	var meetingAppDataVM = ko.mapping.fromJS(meetingAppData);
      	var addIds = [];
      	var removeIds = [];
      
      	var meetingRoomData = loadData("${pageContext.request.contextPath}/meeting/meetingRoom/emptyMeetingRoomData.do",{});
      	var meetingRoomDataVM = {
   			roomList:ko.observableArray(meetingRoomData),
   		  	roomId:ko.observable(meetingAppData.meetingRoomId)
      	}
      	var userData = loadData("${pageContext.request.contextPath}/system/user/getAllUserData.do",{});
      
      	var participant = meetingAppData.participants;
      
      	var leaderId = '';
      
      	var iaParticipant = meetingAppData.iaParticipants;
      	var auditors = [];
      	if( iaParticipant.length > 0 ){
	    	for(var i=0;i< iaParticipant.length;i++){
	    		if( iaParticipant[i].userType == 0 ){
	    			leaderId = iaParticipant[i]['userId'];
	    		}else if(iaParticipant[i].userType == 1){
	    		    auditors.push(iaParticipant[i]);
	    		}
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
				html += '<p>'+dataName+'</p>';
				html += '</div>';
				html += '<button type="button" title="删除" data-id="'+dataId+'" class="remove">×</button>';
				html += '</div>';
        		var meetingAppDocDataType = meetingAppDocData[i].type;
        		$('.uploadFile' + meetingAppDocDataType).prepend(html);
    		}
     	} 
      	
	    /*文件上传*/
	    $("body").on("change", ".preview", function(){
		 	$(this).parent().prev().find("input[type='text']").val($(this).val());
	    });
	    $(".uploading").click(function(){
	    	var fileDom = $(this).siblings("input[type='file']");
	    	var fileId = fileDom.attr("id");
	    	var fileName = $(this).parent().prev().find("input[type='text']");
	    	var fileNameVal = fileName.val();
	    	var labelName = $(this).parent().siblings("label").text().replace("：","");
	    	var recordfiles = $(this).parent().next(".recordfile");
	    	var typeNum = $(this).siblings("input[type='file']").data("num");
	    	if( fileNameVal == ""){
				saveFailure("系统提示：“"+ labelName +"”没有选择文件上传！");
	  	    }else{
	  	    	var fileType = fileNameVal.split(".")[fileNameVal.split(".").length-1].toLowerCase();
	        	var allFileArr = ["jpg", "jpeg", "png", "bmp", "mov", "avi", "mp4", "wmv", "doc", "docx", "xls", "xlsx", "ppt", "pptx", "pdf", "txt"];
				if( $.inArray(fileType,allFileArr)== -1 ){
	        		saveFailure("系统提示：不能上传“"+ fileType +"”这类型文件！");
	        	} else {
		  	      	$.ajaxFileUpload({
				 		url: "${pageContext.request.contextPath}/meeting/meetingApp/document/upoadDocumentData.do",
						data:{
							'id' : meetingAppData.id,
							'creatorId' : '${sessionScope.loginUser.userId}',
							'creatorName' : '${sessionScope.loginUser.userName}',
							'creatorAlias' : '${sessionScope.loginUser.userAlias}',
							'type':typeNum,
						},
						secureuri:false,
						fileElementId: fileId,//file标签的id
						dataType: 'json',//返回数据的类型
						success: function (data) {
							console.log(data);
							fileName.val("");
							fileDom.val("");
							addIds.push(data.id);
		  					var fileTypeName = data.fileName.split(".")[data.fileName.split(".").length-1];
							var fileNameLength = data.fileName.length-fileTypeName.length-1;
							var dataName = data.fileName.substring(0,fileNameLength);
							var dataId = data.id;
							var uoloadFfileType = fileTypeName.toLowerCase();
							var imgArr = ["jpg", "jpeg", "png", "bmp"];
							var fileArr = ["doc", "docx", "xls", "xlsx", "ppt", "pptx", "pdf", "txt"];
							var videoArr = ["mov", "avi", "mp4", "wmv"];					
							var html='';
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
							html += '<p>'+dataName+'</p>';
							html += '</div>';
							html += '<button type="button" title="删除" data-id="'+dataId+'" class="remove">×</button>';
							html += '</div>';
		  					recordfiles.append(html);
						},
						error: function (data, status, e) {
							alert(e);
						}
					});
	  	    	} 	
	  	  	}
	    });
    
     	/*文件删除*/
  		$('.recordfile').on('click','.remove',function(){
	  		var  fileid = $(this).attr('data-id');
	  		var  filethis = $(this);
	  		$.ajax({
			  	url:'${pageContext.request.contextPath}/meeting/meetingApp/document/removeDocumentData.do',
			  	data:{'id':fileid},
			  	datatype:'json',
			  	type:'post',
			  	success:function(data){
				  	if( data['status'] ){
					  	filethis.parent('.list-content').remove();
					  	removeIds.push(fileid);
				  	}
		  		},
			  	error:function(){
				  	alert('删除文件失败');
			  	}
	  		})
  		})
  		/*文件删除结束*/
      
      var vm = {
    		  meetingAppVM : meetingAppDataVM,
    		  meetingRoomVM : meetingRoomDataVM
      }
		
	    vm.saveData = function(){ 
	        $("button").attr("disabled", true);
	        if(compareDate($("#startDate").val(),$("#endDate").val())){
				$("button").attr("disabled", false);
	  			promptContent("系统提示：结束时间需大于开始时间");
	  			$("#endDate").addClass("error");
	  			$(".alert").addClass("alert-danger").removeClass("alert-success");
	  			$(".promptDiv").slideDown();
	  		}else if ( validateSubmittedData() ) {
	  			var length1 = $("#joins > li").length;
	  			var length2 = $("#auditors > li").length;
	  			if( length1 == 0 ){
	  				$(".joins ").addClass("divError");
	  				saveFailure("“参与人员：”不能为空。");
	  			}else if( length2 == 0 ){
	  				$(".auditors").addClass("divError");
	  				saveFailure("“内审员：”不能为空。");
	  			}else{
	  				bindDataToVM();
		        	if( saveData("${pageContext.request.contextPath}/meeting/meetingApp/saveMeetingAppData.do",meetingAppDataVM )){
	   	    		    saveSuccess("${pageContext.request.contextPath}/meetingMgt/internalAudit/meetInternalAuditList.do");
	   	    	    }else{
	   	    		    saveFailure("提交失败。");
	   	    	    }
	  			}
	        } else {
	        	var length1 = $(".joins > li").length;
	  			var length2 = $(".auditors > li").length;
	  			if( length1 == 0 ){
	  				$(".joins").addClass("divError");
	  			}
	  			if( length2 == 0 ){
	  				$(".auditors").addClass("divError");
	  			}
	        	saveFailure();
	        } 
		}
		
		vm.backToList = function(){//返回
			$.ajax({
		  		  url:'${pageContext.request.contextPath}/meeting/meetingApp/document/updateDocumentData.do',
		  		  traditional: true,
		  		  data:{'ids':removeIds},
		  		  datatype:'json',
		  		  type:'post',
		  		  success:function(data){
		  			 $('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/internalAudit/meetInternalAuditList.do');
		  		  }
		  	  })
			
		}
		
		ko.applyBindings(vm);
		
		 $("#startDate").on("dp.change", function (e) {
		     $('#endDate').data("DateTimePicker").minDate(e.date);
		     $('#startDate').data("DateTimePicker").minDate(new Date());
		 }); 
		
		
		 
		//比较两个时间的大小，当date1>=date2时，返回ture
			function compareDate(obj1, obj2) {
				var date1 = new Date(obj1);
				var date2 = new Date(obj2);
				if (date1.getTime() >= date2.getTime()) {
					return true;
				} else {
					return false;
				}
			}
		
		function bindDataToVM(){
			  meetingAppDataVM.participants = participant;
			  meetingAppDataVM.iaParticipants = iaParticipant;
	    	  meetingAppDataVM.creatorName = "${sessionScope.loginUser.userName}";
	    	  meetingAppDataVM.creatorId = "${sessionScope.loginUser.userId}";
	    	  meetingAppDataVM.creatorAlias = "${sessionScope.loginUser.userAlias}";
	    	  meetingAppDataVM.type = 1;
	    	  meetingAppDataVM.status = 1;
	    	  meetingAppDataVM.meetingRoomId = $("#roomId").val();
	    	  meetingAppDataVM.meetingRoomName = $("#roomId").find("option:selected").text();
	    	  meetingAppDataVM.add = addIds;
	      }
	
		
      
      //组装参与人员
	var userHtml = '';
    var auditorLeader = '<option id="" value="">--请选择--</option>'; //内审组长
    for(var i=0;i<userData.length;i++){
		userHtml += '<li><span class="add" id = "'+userData[i]['userId']+'" data-name = "'+userData[i]['userName']+'">'+userData[i]['userAlias']+'</span></li>';
		if( userData[i].userId == leaderId ){
			auditorLeader += '<option id="'+userData[i]['userId']+'" selected value="'+userData[i]['userId']+'" data-name="'+userData[i]['userName']+'">'+userData[i]['userAlias']+'</option>';
		}else{
			auditorLeader += '<option id="'+userData[i]['userId']+'" value="'+userData[i]['userId']+'" data-name="'+userData[i]['userName']+'">'+userData[i]['userAlias']+'</option>'
		}
		
	}
	
    $(".file-list").html(userHtml);
   
    if( leaderId != ''){
    	 $(".file-list").find("#" + leaderId).hide();
    }
    $("#auditorLeader").html(auditorLeader);
      
    $("#auditorLeader").change(function(){
       if(leaderId != ""){
    	   $(".file-list").find("#" + leaderId).show();
       } 
       remove(leaderId);
       if( $(this).val() != ""){
    	   leaderId = $(this).val();
           var alias = $(this).children('option:selected').text();
           var name = $(this).children('option:selected').attr('data-name');
           iaParticipant.push({'id':null,'userId':leaderId,'userName':name,'userAlias':alias,'userType':0});  
           $(".file-list").find("#" + leaderId).hide();
       }
      
    })
      
    $(".add-file-btn").click(function() {
		$(this).parents(".associated-file-content").siblings(".add-content").show();
	});

	$(".hide-btn").click(function() {
		$(this).parents(".add-content").hide();
	});

	  // 添加参与人员
	 $("#join").on("click",".add",function() {
		var alias = $(this).text();
		var id = $(this).attr('id');
		var name = $(this).attr('data-name');
		if( $("#joins").find("#" + id).text() == "undefined" || $("#joins").find("#" + id).text() == ""){
			$("#joins").append('<li><p id="' + id + '"> '+ alias
                  +'</p><span class="remove" aria-hidden="true" data-id="'+ id+'"><i class="fa fa-times"></i></span>'
                  +'</li>');
			participant.push({'id':null,'userId':id,'userName':name,'userAlias':alias,'userMp':''});
			$(".file-list").find("#" + id).parent("li").hide();
			$("#auditorLeader").find("#" + id).parent("li").hide();
		}
		$(".joins").removeClass("divError");	
	});

    // 删除参与人员
	$("#joins").on('click','.remove',function(){
		var parents = $(this).parents(".joins");
		var size = $(this).parents(".associated-file-list").find("li").length;
		if( size === 1 ){
			parents.addClass("divError");
		}else{
			parents.removeClass("divError");
		}
		
		var id = $(this).attr('data-id');
		$(this).parent("li").remove();
		$(".file-list").find("#" + id).parent("li").show();
		$("#auditorLeader").find("#" + id).parent("li").show();
		for(var i=0;i<participant.length;i++){
			if(participant[i].userId == id){
				participant.splice(i, 1);
				/* if(participant[i]['id'] != "" ){
					$.ajax({
						url:'${pageContext.request.contextPath}/meeting/meetingApp/participant/removeParticipantData.do',
						type:'post',
						datatype:'json',
						data:{'id':participant[i]['id']},
						success:function(data){
							participant.splice(i, 1);
						},
						error:function(){
							
						}
					})
				}else{
					
				}   */
				break;
			}
		}
		
	})

	//参与人员复写
	if( participant.length > 0 ){
		for(var i=0;i<participant.length;i++){
			$("#joins").prepend('<li><p id="' + participant[i]['userId'] + '"> '+ participant[i]['userAlias'] + 
			                '</p><span class="remove" aria-hidden="true" data-id="'+ participant[i]['userId']+'"><i class="fa fa-times"></i></span></li>');
			$(".file-list").find("#" + participant[i]['userId']).parent("li").hide();
			$("#auditorLeader").find("#" + participant[i]['userId']).parent("li").hide();
		}
	}
	
		// 添加审核员
		 $("#auditor").on("click",".add",function() {
			var alias = $(this).text();
			var id = $(this).attr('id');
			var name = $(this).attr('data-name');
			if( $("#auditors").find("#" + id).text() == "undefined" || $("#auditors").find("#" + id).text() == ""){
				$("#auditors").append('<li><p id="' + id + '"> '+ alias
	                   +'</p><span class="remove" aria-hidden="true" data-id="'+ id+'"><i class="fa fa-times"></i></span>'
	                   +'</li>');
				iaParticipant.push({'id':null,'userId':id,'userName':name,'userAlias':alias,'userType':1});
				$(".file-list").find("#" + id).parent("li").hide();
				$("#auditorLeader").find("#" + id).parent("li").hide();
			}
			$(".auditors").removeClass("divError");	
		});

		// 删除审核员
			$("#auditors").on('click','.remove',function(){
				var parents = $(this).parents(".auditors");
				var size = $(this).parents(".associated-file-list").find("li").length;
				if( size === 1 ){
					parents.addClass("divError");
				}else{
					parents.removeClass("divError");
				}
				var id = $(this).attr('data-id');
				$(this).parent("li").remove();
				$(".file-list").find("#" + id).parent("li").show();
				$("#auditorLeader").find("#" + id).parent("li").show();
				remove(id);
				
			})

		//审核员复写
		if(auditors.length > 0 ){
			for(var i=0;i<auditors.length;i++){
				$("#auditors").prepend('<li><p id="' +auditors[i]['userId'] + '"> '+auditors[i]['userAlias'] + 
				                '</p><span class="remove" aria-hidden="true" data-id="'+auditors[i]['userId']+'"><i class="fa fa-times"></i></span></li>');
				$(".file-list").find("#" + auditors[i]['userId']).parent("li").hide();
			}
		}
	 	
		// 删除审核员
		function remove(id){
			for(var i=0;i<iaParticipant.length;i++){
				if(iaParticipant[i].userId == id){
					iaParticipant.splice(i, 1);
					/* if(iaParticipant[i]['id'] != "" ){
						$.ajax({
							url:'${pageContext.request.contextPath}/meeting/meetingIa/removeMeetingIaParticipantData.do',
							type:'post',
							datatype:'json',
							data:{'id':iaParticipant[i]['id']},
							success:function(data){
								iaParticipant.splice(i, 1);
							},
							error:function(){
								
							}
						})
					}else{
						
					}   */
					break;
				}
			}
			console.log(iaParticipant);
		}
	
	</script>
</body>
</html>