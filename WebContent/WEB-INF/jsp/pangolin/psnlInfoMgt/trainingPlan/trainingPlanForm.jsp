<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>培训计划新增、修改表单</title>
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
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />	
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" /> 
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
</head>
<body>		
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>人员信息管理</a><span>></span><a>培训计划</a><span>></span><a>新增</a>
        </p>
   	</div>
   	<div class="form-content">
		<form class="form-horizontal">		
		    <div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>年度：</label>
				<div class="col-sm-4" data-bind="with:trainingPlanVM">
					<input type="text" class="form-control datetimepicker"  data-bind="value:trainingPlanApp.year" id="year" required />
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">评审目的：</label>
				<div class="col-sm-10" data-bind="with:trainingPlanVM">
					<textarea class="form-control" data-bind="value:trainingPlanApp.purpose"></textarea>
				</div>						
			</div>			
			<!-- <div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>编号：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" required />
				</div>
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>上传时间：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" required />
				</div>					
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">编制人：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" />
				</div>
				<label class="col-sm-2 control-label">编制时间：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" />
				</div>					
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">批准人：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" />
				</div>
				<label class="col-sm-2 control-label">批准时间：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" />
				</div>					
			</div> -->
		</form>
	</div>	
	<div class="upload-module upload-margin">
        <div class="module-title">
            <p>培训计划文件</p>
        </div>
        <div class="file-list uploadFile2"></div>
        <div class="upload-content">
            <div class="upload-input">
                <input type="text" class="file-name" readonly />
            </div>
            <div class="upload-btn">
                <button type="button" class="btn btn-color1"><i class="fa fa-folder-open-o"></i>浏览</button>
                <button type="button" class="btn btn-color2 uploading"><i class="fa fa-upload"></i>上传</button>
            	<input type="file" class="file-input preview" id="file" name="file" data-num="2" />
            </div>
        </div>
    </div>
	<div class="btn-content">
       	<button class="btn btn-color2 back-btn" data-bind="click: backToList"><i class="fa fa-chevron-left"></i>返回</button>
       	<button class="btn btn-color1" data-bind="click: saveData"><i class="fa fa-check"></i>提交</button>
   	</div>
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
	<script>
		$(function(){
			$('.datetimepicker').datetimepicker({
			    format: 'YYYY',
			});
			
			if ( "${param.id}" ) {
				$(".crumbs-text").html("当前位置：<a>人员信息管理</a><span>></span><a>培训计划</a><span>></span><a>修改</a");
			}

				
			var trainingPlanData = loadData("${pageContext.request.contextPath}/psnlInfo/loadTrainingPlanAppData.do",{ "id" : "${param.id}" });
			console.log(trainingPlanData);
		    var trainingPlanDataVM = ko.mapping.fromJS(trainingPlanData);
		    
		    var addIds = [];
		    var removeIds = [];
		    
		    var planAtt = loadData("${ pageContext.request.contextPath }/trainingPlanApp/getTrainingPlanAttListByAppIdData.do",{ "id" : trainingPlanData.trainingPlanApp.id });
		    console.log(planAtt);
	      	if( planAtt.length > 0 ){
	        	for(var i=0;i<planAtt.length;i++){
	        		var fileTypeName = planAtt[i].name.split(".")[planAtt[i].name.split(".").length-1];
					var fileNameLength = planAtt[i].name.length-fileTypeName.length-1;
					var dataName = planAtt[i].name.substring(0,fileNameLength);
					var dataId = planAtt[i].id;
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
	        		//var meetingAppDocDataType = planAtt[i].type;
	        		$('.uploadFile2').prepend(html);
	    		}
	     	} 
		    
		    
		    /* var attachment = '';
		    if ( planAtt.length > 0 ) {
		    	for ( var i=0;i<planAtt.length;i++ ) {
				    attachment += '<div class="list-content">';
				    attachment += '<div class="list-img">';
				    attachment += '<img src="${ pageContext.request.contextPath }/resources/frameworks/pangolin/images/eeip/uploadImg/'+planAtt[i]['ext']+'.png" alt="">';
				    attachment += '</div>';
				    attachment += '<div class="list-name" title="'+planAtt[i].name+'">';
				    attachment += '<p><a href="${pageContext.request.contextPath}/trainingPlanApp/downloadTrainingPlanAttData.do?id='+planAtt[i].id+'">'+planAtt[i].name+'</a></p>';
				    attachment += '</div>';
				    attachment += '<button class="remove" title="删除" data-id="'+planAtt[i].id+'">×</button>';
				    attachment += '</div>';
		    	}
		    	$(".file-list").prepend(attachment); 
		    } */
		    
		    var vm = {
		    		trainingPlanVM : trainingPlanDataVM
		    		//userVM : userDataVM
		    }
		    
		   
		    vm.saveData = function(){
		    	$("button").attr("disabled", true);
		    	if ( validateSubmittedData() ) {
		        	bindDataVM();
		        	if (saveData("${pageContext.request.contextPath}/psnlInfo/saveTrainingPlanAppData.do",trainingPlanDataVM)) {
						saveSuccess("${pageContext.request.contextPath}/psnlInfo/trainingPlan/trainingPlanInfoList.do");
					} 
		        } else {
		        	saveFailure();
		        }
			}
			
			vm.backToList = function(){//返回
				 $.ajax({
			  		  url:'${pageContext.request.contextPath}/trainingPlanApp/updateTrainingPlanAttStatusData.do',
			  		  traditional: true,
			  		  data:{'ids':removeIds},
			  		  datatype:'json',
			  		  type:'post',
			  		  success:function(data){
			  			$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/psnlInfo/trainingPlan/trainingPlanInfoList.do');
			  		  }
			  	  })
				
			}
			
			ko.applyBindings(vm);
		
			function bindDataVM(){
				trainingPlanDataVM.trainingPlanApp.title = $("#year").val() + "年度培训计划";
				trainingPlanDataVM.trainingPlanApp.year = $("#year").val(); 
				trainingPlanDataVM.trainingPlanApp.creatorName = "${sessionScope.loginUser.userName}";
				trainingPlanDataVM.trainingPlanApp.creatorId = "${sessionScope.loginUser.userId}";
				trainingPlanDataVM.trainingPlanApp.creatorAlias = "${sessionScope.loginUser.userAlias}";
				trainingPlanDataVM.addAtt = addIds;
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
		    	var labelName = $(this).parent().parent().siblings(".module-title").find("p").text();
		    	var recordfiles = $(this).parent().parent().siblings(".file-list");
		    	var typeNum = $(this).siblings("input[type='file']").data("num");
		    	if( fileNameVal == ""){
					saveFailure("“"+ labelName +"”没有选择文件上传！");
		  	    }else{
		  	    	var fileType = fileNameVal.split(".")[fileNameVal.split(".").length-1].toLowerCase();
		        	var allFileArr = ["jpg", "jpeg", "png", "bmp", "mov", "avi", "mp4", "wmv", "doc", "docx", "xls", "xlsx", "ppt", "pptx", "pdf", "txt"];
					if( $.inArray(fileType,allFileArr)== -1 ){
		        		saveFailure("系统提示：不能上传“"+ fileType +"”这类型文件！");
		        	} else {
			  	      	$.ajaxFileUpload({
							url:'${pageContext.request.contextPath}/trainingPlanApp/uploadTrainingPlanAttData.do',
							data:{
								'id' : trainingPlanData.trainingPlanApp.id,
								'creatorId' : '${sessionScope.loginUser.userId}',
								'creatorName' : '${sessionScope.loginUser.userName}',
								'creatorAlias' : '${sessionScope.loginUser.userAlias}',
								'type':typeNum
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
			
			
		    /* $(".file-browse").click(function(){
		    	$(this).siblings(".file-input").click();
		    	$(this).siblings(".file-input").change(function(){
		    	 	if($(this).val() !=''){
		          		$(this).parent().prev().find(".file-name").val($(this).val());
		          	}else{
		          		$(this).parent().prev().find(".file-name").val('');
		          	}
			    })
		    });
		    $('.file-input').change(function(){
	    	 	if($(this).val() !=''){
	    	 		$(this).parent().prev().find(".file-name").val($(this).val());
	          	}else{
	          		$(this).parent().prev().find(".file-name").val('');
	          	}
		    });
		    $('.file-upload-btn').click(function(){
		    	 if($('.file-name').val() ==''){
			  		  $("html, body").animate({ scrollTop: 0 }, 200);
					  promptContent("没有文件上传！");
					  $(".alert").addClass("alert-danger").removeClass("alert-success");
					  $(".promptDiv").slideDown();
					  return false;
			  	  }else{
						$.ajaxFileUpload({
							url:'${pageContext.request.contextPath}/trainingPlanApp/uploadTrainingPlanAttData.do',
							data:{
								'id' : trainingPlanData.trainingPlanApp.id,
								'creatorId' : '${sessionScope.loginUser.userId}',
								'creatorName' : '${sessionScope.loginUser.userName}',
								'creatorAlias' : '${sessionScope.loginUser.userAlias}',
								'type':2
								},
							secureuri:false,
							fileElementId:'file',//file标签的name
							dataType: 'json',//返回数据的类型
							success: function (data) {
								$('.file-name').val('');//上传成功就清空查看栏
								addIds.push(data.id);
								var html='';
								html += '<div class="list-content">';
								html += '<div class="list-img">';
								html += '<img src="${ pageContext.request.contextPath }/resources/frameworks/pangolin/images/eeip/uploadImg/'+data.ext+'.png" alt="">';
								html += '</div>';
								html += '<div class="list-name" title="'+data.fileName+'">';
								html += '<p><a href="${pageContext.request.contextPath}/trainingPlanApp/downloadTrainingPlanAttData.do?id='+data.id+'">'+data.fileName+'</a></p>';
								html += '</div>';
								html += '<button class="remove" title="删除" data-id="'+data.id+'">×</button>';
								html += '</div>';
								$(".file-list").append(html);		
							  						
							},
							error: function (data, status, e) {
								alert(e);
							}
						});  	
				  	  }
	        }); */
	        /*文件上传end*/	
	        /*文件删除-开始*/
		    $('.file-list').on('click', '.remove', function(){
		  	  var  fileid = $(this).attr('data-id');
		  	  var  filethis = $(this);
		  	  $.ajax({
		  		  url:'${pageContext.request.contextPath}/trainingPlanApp/removeTrainingPlanAttData.do',
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
		  			  //alert('删除文件失败');
		  		  }
		  	  })
		    })
		    /*文件删除-结束*/
		});
	</script>
</body>
</html>