<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>人员培训履历表</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script> 
    <script src="<c:url value="/resources/frameworks/pangolin/js/eeip/expert.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>	 
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
 	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
 	<script src="<c:url value="/resources/frameworks/pangolin/js/ajaxfileupload.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/alertMessages.js" />"></script>
 	
 	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/expert/expert.css" />" rel="stylesheet" />	
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" /> 
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" /> 
  </head>
<body>
	<div class="content">		
		<div class="crumbs-nav">
	        <p class="crumbs-text">
	        	当前位置：<a>人员信息管理</a><span>></span><a>专家库</a><span>></span><a>新增</a><span>></span><a>培训履历</a>
	        </p>
    	</div>
		<jsp:include page="/common/personNav.jsp"></jsp:include>
		<form class="form-horizontal myform">									
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>姓名：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<input type="text" id="name" class="form-control name" data-bind="value:name" readonly required />
				</div>
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>性别：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<select id="sex" class="form-control" data-bind="value:sex" disabled required>
						<option value="0">男</option>
						<option value="1">女</option>
					</select>
				</div>								
			</div>							
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>专业：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<input type="text" id="major" class="form-control validation"  data-bind="value:major" readonly required />
				</div>
				
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>学历：</label>
				<div class="col-sm-4" data-bind="with:userEducationVM">
					<input type="text" id="eduction" class="form-control"  data-bind="value:eduction" readonly required />
				</div>					
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>出生日期：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<input type="text" id="birthday" class="form-control datetimepicker2" data-bind="dateTimePicker:birthday" readonly required />
				</div>	
				<!-- <label class="col-sm-2 control-label"><span class="required-fields">*</span>编号：</label>
				<div class="col-sm-4" data-bind="with:userTrainingVM">
					<input type="text" class="form-control" data-bind="value:sn" required/>
				</div> -->						
			</div>
		</form>
	</div>
	<div class="upload-module">
        <div class="module-title">
            <p>培训履历</p>
        </div>
        <div class="file-upload">
        	<table class="table table-bordered mag-top">
				<thead class="col-head">
					<tr>
						<th><span class="required-fields">*</span>培训日期</th>
						<th><span class="required-fields">*</span>培训内容</th>
						<th><span class="required-fields">*</span>培训单位</th>
						<th><span class="required-fields">*</span>考核情况</th>	
						<th><span class="required-fields">*</span>登记人</th>					
						<th>操作</th>
					</tr>
				</thead>
				<tbody class="handleData">
				</tbody>
				<tfoot>
	            	<tr>
	                    <td colspan="6" align="center">
	                        <button class="btn add-tr-btn"><i class="fa fa-plus"></i>增加</button>
	                    </td>
	                </tr>
	            </tfoot>
			</table>
        </div>
    </div>
	<div class="upload-module">
        <div class="module-title">
            <p>培训资料</p>
        </div>
        <div class="file-list file"></div>
		<div class="upload-content">
            <div class="upload-input">
                <input type="text" class="file-name" readonly />
            </div>
            <div class="upload-btn">
                <button type="button" class="btn btn-color1"><i class="fa fa-folder-open-o"></i>浏览</button>
                <button type="button" class="btn btn-color2 uploading"><i class="fa fa-upload"></i>上传</button>
            	<input type="file" class="file-input preview" id="file" name="file" />
            </div>
        </div>
    </div>	
	<div class="btn-content">
        <button type="button" class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
        <!-- <button type="button" data-bind="click: saveData" class="btn btn-color1"><i class="fa fa-check"></i>提交</button> -->
    </div>  
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
	<script>
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
		$('.datetimepicker2').datetimepicker({
		       format: 'YYYY-MM-DD',
	    });
		
	    var userTrainingId;
		$(function(){
			// 链接判断
			var url = window.location.href;
			if( "${param.userBasicInfoId}" ){
			  $(".crumbs-text").html("当前位置：<a>人员信息管理</a><span>></span><a>专家库</a><span>></span><a>修改</a><span>></span><a>培训履历</a>");
			}
			
			/*文件上传*/
			$("body").on("change", ".preview", function(){
			 	$(this).parent().prev().find("input[type='text']").val($(this).val());
		    });
	        $('.uploading').click(function(){
	        	var userBasicInfoId="${param.userBasicInfoId}"; 
	        	//$(this).siblings(".enterFile").val("");
	        	var fileName = $(this).parent().prev().find(".file-name");
	        	var fileId = $(this).siblings(".file-input").attr("id"); 
	        	var userBasicInfoId="${param.userBasicInfoId}";
	        	var type=fileId.substring(fileId.length-1,fileId.length);
	        	var fileType1 = fileName.val().split(".")[fileName.val().split(".").length-1];
	        	var fileType = fileType1.toLowerCase();
	        	var typeArr = ["doc", "docx", "xls", "xlsx", "ppt", "pptx", "pdf", "txt", "jpg", "jpeg", "png", "bmp", "mov", "avi", "mp4", "wmv"];       	       	
	        	if($.inArray(fileType,typeArr)== -1){
	        		promptContent("不能上传该类型文件！");
	        		$(".alert").removeClass("alert-success").addClass("alert-danger");
		 			$(".promptDiv").slideDown();
		 		    setTimeout(function(){
		 				$(".promptDiv").slideUp();
		 		    },2000);
	        		return false;
	        	}
	        	$.ajaxFileUpload({
	        		url:"${pageContext.request.contextPath}/psnlInfo/userTrainingAtt/uploadUserTrainingAttData.do?userBasicInfoId="+userBasicInfoId+"&userTrainingId="+userTrainingData.id,
	  				secureuri:false,
	  				fileElementId:fileId,//file标签的name
	  				dataType: 'json',//返回数据的类型
	  				success: function (data) { 
	  					console.log(data);
						if(data.status){ 							
							var fileType1 = data.name.split(".")[data.name.split(".").length-1];
							var allLength = data.name.length;
							var length = fileType1.length+1;
							var dataName = data.name.substring(0,allLength-length);
							var fileType = fileType1.toLowerCase();
							var imgArr = ["jpg", "jpeg", "png", "bmp"];
							var fileArr = ["doc", "docx", "xls", "xlsx", "ppt", "pptx", "pdf", "txt"];
							var videoArr = ["mov", "avi", "mp4", "wmv"];
							var html='';
							//html += '<div class="img"><img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/'+type+'.png"><p>'+data.name+'</p><button type="button" data-id="'+data.id+'" class="removeImg">×</button></div>';  							 
							html += '<div class="list-content">';
							html += '<div class="list-img">';
							if($.inArray(fileType,imgArr)!= -1){
								html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/img.png">';
							} else if($.inArray(fileType,videoArr)!= -1){
								html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/video.png">';
							} else {
								html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/'+fileType+'.png">';
							}							
							html += '</div>';
							html += '<div class="list-name" title="'+dataName+'">';
							html += '<p>'+dataName+'</p>';
							html += '</div>';
							html += '<button class="remove" title="删除" data-id="'+data.id+'">×</button>';
							html += '</div>';
						}
	  					$("."+fileId+"").append(html);
	  					fileName.val('');
	  				},
	  				error: function (data, status, e) {
	  					alert(e);
	  				}
	  			});  	   	  
	        });
			
			
		    /* $(".file-browse").click(function(){
		    	$(".file-input").click();
		    	$(".file-input").change(function(){
		    	 	if($(this).val() !=''){
		          		$('.file-name').val($(this).val());
		          	}else{
		          		$('.file-name').val('');
		          	}
			    })
		    });
		    $('.file-input').change(function(){
	    	 	if($(this).val() !=''){
	          		$('.file-name').val($(this).val());
	          	}else{
	          		$('.file-name').val('');
	          	}
		    });
	        $('.file-upload-btn').click(function(){
	        	var userBasicInfoId="${param.userBasicInfoId}"; 
	        	var fileName = $(".file-name").val();
	        	var fileType1 = fileName.split(".")[fileName.split(".").length-1];
	        	var fileType = fileType1.toLowerCase();
	        	var typeArr = ["doc", "docx", "xls", "xlsx", "ppt", "pptx", "pdf", "txt", "jpg", "jpge", "png", "bmp", "mov", "avi", "mp4", "wmv"];  
	        	if($.inArray(fileType,typeArr)== -1){
	        		promptContent("不能上传该类型文件！");
	        		$(".alert").removeClass("alert-success").addClass("alert-danger");
		 			$(".promptDiv").slideDown();
		 		    setTimeout(function(){
		 				$(".promptDiv").slideUp();
		 		    },2000);
	        		return false;
	        	}
	        	$.ajaxFileUpload({
      				url:"${pageContext.request.contextPath}/psnlInfo/userTrainingAtt/uploadUserTrainingAttData.do?userBasicInfoId="+userBasicInfoId+"&userTrainingId="+userTrainingData.id,
      				secureuri:false,
      				fileElementId:'file',//file标签的id
      				dataType: 'json',//返回数据的类型
      				success: function (data) { 
      					console.log(data);
  						if(data.status){  		
  							var fileType1 = data.name.split(".")[data.name.split(".").length-1];
							var allLength = data.name.length;
							var length = fileType1.length+1;
							var dataName = data.name.substring(0,allLength-length);
							var fileType = fileType1.toLowerCase();
							var imgArr = ["jpg", "jpeg", "png", "bmp"];
							var fileArr = ["doc", "docx", "xls", "xlsx", "ppt", "pptx", "pdf", "txt"];
							var videoArr = ["mov", "avi", "mp4", "wmv"];					
  							var html='';
  							html += '<div class="list-content">';
  							html += '<div class="list-img">';	
  							if($.inArray(fileType,imgArr)!= -1){
								html += '<img src="${pageContext.request.contextPath}/psnlInfo/userCertificate/loadUserCertificateImage.do?id='+data.id+'" alt="">';
							} else if($.inArray(fileType,videoArr)!= -1){
								html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/video.png">';
							} else {
								html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/'+fileType+'.png">';
							}
							//html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/'+fileType+'.png">';											
  							html += '</div>';
  							html += '<div class="list-name" title="'+dataName+'">';
  							html += '<p>'+dataName+'</p>';
  							//html += '<p><a href="${pageContext.request.contextPath}/psnlInfo/userTrainingAtt/downLoadUserTrainingAttData.do?id='+data.id+'">'+dataName+'</a></p>';
  							html += '</div>';
  							html += '<button title="删除" data-id="'+data.id+'" class="remove" aria-hidden="true">×</button>';
  							html += '</div>';
  						}
  						$(".file-list").append(html);
      					$('.file-name').val('');
      				},
      				error: function (data, status, e) {
      					//alert(e);
      				}
      			});
	          		  	   	  
	        }); */
	        /*文件上传end*/
			
			
		     /*文件删除*/
		    $('.file-list').on('click','.remove',function(){
		  	  var  fileid = $(this).attr('data-id');
		  	  var  filethis = $(this);
 		  	  $.ajax({
		  		  url:'${pageContext.request.contextPath}/psnlInfo/userTrainingAtt/removeUserTrainingAttData.do',
		  		  data:{'id':fileid},
		  		  datatype:'json',
		  		  type:'post',
		  		  success:function(data){
		  			  if( data['status'] ){
		  				  filethis.parent('.list-content').remove();
		  			  }
		  		  },
		  		  error:function(){
		  			  alert('删除文件失败');
		  		  }
		  	  })
		    })
		    /*文件删除结束*/

	        
			$(".add-tr-btn").click(function(){
				$(".handleData").append('<tr>'
					+'<td><input type="text" data-id="" class="datetimepicker11" style="width:100px;" required />至<input type="text"  class="datetimepicker11" style="width:100px;" required /></td>'
					+'<td><input type="text" required /></td>'
					+'<td><input type="text" class="validation" required /></td>'
					+'<td><input type="text" required /></td>'
					+'<td><input type="text" class="name" required /></td>'
					+'<td><a class="singleSubmit" title="保存"> <i class="fa fa-check"></i></a> <a class="singleClear" id="" title="删除"> <i class="fa fa-times"></i></a></td>'
					+'</tr>'													
				);
				 $(".datetimepicker11").datetimepicker({format: 'YYYY-MM-DD'});
			});	
			
			var data = loadData("${pageContext.request.contextPath}/psnlInfo/userTrainingExp/getUserTrainingExpByUserIdListData.do",{ "userBasicInfoId" : "${param.userBasicInfoId}" });
			if(data.length>0){
		    	 var resultHtml='';
		    	 for(var i = 0 ; i<data.length;i++){
		    		 resultHtml+='<tr class="col-read">'							
						+'<td><input type="text" data-id="'+data[i]['id']+'" readonly="readonly" class="datetimepicker11" value="'+new Date(data[i].startDate).Format("yyyy-MM-dd")+'" style="width:100px;" required />至<input type="text" readonly="readonly"  class="datetimepicker11" value="'+new Date(data[i].startDate).Format("yyyy-MM-dd")+'" style="width:100px;" required />'																				
						+'<td><input type="text" readonly="readonly" value="'+data[i].content+'" required /></td>'						
						+'<td><input type="text" readonly="readonly" value="'+data[i].trainingAgency+'" required /></td>'							
						+'<td><input type="text" readonly="readonly" value="'+data[i].result+'" required /></td>'						
						+'<td><input type="text" readonly="readonly" value="'+data[i].registrant+'" required /></td>'						
						+'<td><a class="singleModify" title="修改"> <i class="fa fa-pencil-square-o"></i></a> <a class="singleClear" id="'+data[i]['id']+'" title="删除"> <i class="fa fa-times"></i></a></td>'
						+'</tr>';  
		    	 }
		    	 $(".datetimepicker11").datetimepicker({format: 'YYYY-MM-DD'});
		    	 $(".handleData").append(resultHtml);
		     }
			//用户基本信息
		     var userData = loadData("${pageContext.request.contextPath}/psnlInfo/userBasicInfo/getUserBasicInfoByIdData.do",{ "id" : "${param.userBasicInfoId}" });
			 var sex=userData.sex; 
			 userDataVM = ko.mapping.fromJS(userData);
		    
			 var userEducationData = loadData("${pageContext.request.contextPath}/psnlInfo/userEducation/getuserEducationByUserIdData.do",{ "userBasicInfoId" : "${param.userBasicInfoId}" });
			 userEducationDataVM = ko.mapping.fromJS(userEducationData); 
			
 			 userTrainingData = loadData("${pageContext.request.contextPath}/psnlInfo/userTraining/getUserTrainingByUserIdData.do",{ "userBasicInfoId" : "${param.userBasicInfoId}" });
			 userTrainingDataVM = ko.mapping.fromJS(userTrainingData);
			 userTrainingId = userTrainingData.id;
			 var vm = {
					 userVM:userDataVM,
					 userTrainingVM:userTrainingDataVM,
					 userEducationVM:userEducationDataVM
			 }; 
				
			 loadAtt(userTrainingData.id);
			
			ko.applyBindings(vm);
		});
		
		//表单提交
		$(".handleData").on("click",".singleSubmit",function(){
			var inputList = $(this).parent().parent().find("input"); 
			if ( validateSubmittedData() ) {
				//保存人员培训履历数据
				userTrainingDataVM.name=userDataVM.name;
				userTrainingDataVM.sex=userDataVM.sex;
				userTrainingDataVM.birthday=userDataVM.birthday;
				userTrainingDataVM.major=userDataVM.major;
				userTrainingDataVM.education=userEducationDataVM.eduction;
				userTrainingDataVM.creatorId="${sessionScope.loginUser.userId}";
		    	userTrainingDataVM.creatorName="${sessionScope.loginUser.userName}";
		    	userTrainingDataVM.creatorAlias="${sessionScope.loginUser.userAlias}";
		    	userTrainingDataVM.userBasicInfoId="${param.userBasicInfoId}";
		    	if (saveData("${pageContext.request.contextPath}/psnlInfo/userTraining/saveUserTrainingData.do", userTrainingDataVM)) {
		    		//保存培训过履历数据
					var entityData = loadData("${pageContext.request.contextPath}/psnlInfo/userTrainingExp/loadUserTrainingExpData.do",{ "id" :  inputList[0].dataset.id });
					var entityVM = ko.mapping.fromJS(entityData);
					entityVM.startDate=inputList[0]["value"];
					entityVM.endDate=inputList[1]["value"];
					entityVM.content=inputList[2]["value"];
					entityVM.trainingAgency=inputList[3]["value"];
					entityVM.result=inputList[4]["value"];
					entityVM.registrant=inputList[5]["value"];
					entityVM.creatorId="${sessionScope.loginUser.userId}";
					entityVM.creatorName="${sessionScope.loginUser.userName}";
					entityVM.creatorAlias="${sessionScope.loginUser.userAlias}";
					entityVM.userBasicInfoId="${param.userBasicInfoId}";
					entityVM.userTrainingId=userTrainingId;
	 		    	if (saveData("${pageContext.request.contextPath}/psnlInfo/userTrainingExp/saveUserTrainingExpData.do", entityVM)) {
			    		$(this).siblings('a').attr('id',entityData.id);
			    		$(this).parent().parent().children().eq(0).children().attr('data-id',entityData.id);
			    		saveSuccess();
					} 
				}
			} else {
				saveFailure();
			}
			
		});
		
		// 删除
		$(".handleData").on("click",".singleClear",function(){	
			var id = $(this).attr('id');
			if(id != null && id != "" && id != "undefined"){
				$.ajax({
					url:'${pageContext.request.contextPath}/psnlInfo/userTrainingExp/removeUserTrainingExpData.do',
					type:'post',
					datatype:'json',
					data:{'id':id},
					success:function(){
						$(this).parent("td").parent("tr").remove(); 
					}
				})
			}else{
				$(this).parent("td").parent("tr").remove();
			} 
		});
			 
		//加载附件
		function loadAtt(id){ 
			var attData = loadData("${pageContext.request.contextPath}/psnlInfo/userTrainingAtt/getUserTrainingAttByTraIdListData.do",{ "userTrainingId" : id });
			if(attData.length>0){
		    	for(var i=0; i<attData.length; i++){
		    		var html='';
					var fileType1 = attData[i].name.split(".")[attData[i].name.split(".").length-1];
					var allLength = attData[i].name.length;
					var length = fileType1.length+1;
					var dataName = attData[i].name.substring(0,allLength-length);
					var fileType = fileType1.toLowerCase();
					var imgArr = ["jpg", "jpeg", "png", "bmp"];
					var fileArr = ["doc", "docx", "xls", "xlsx", "ppt", "pptx", "pdf", "txt"];
					var videoArr = ["mov", "avi", "mp4", "wmv"];
					html += '<div class="list-content">';
					html += '<div class="list-img">';
					if($.inArray(fileType,imgArr)!= -1){
						html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/img.png">';
					} else if($.inArray(fileType,videoArr)!= -1){
						html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/video.png">';
					} else {
						html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/'+fileType+'.png">';
					}
					//html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/'+type+'.png" alt="">';
					html += '</div>';
					html += '<div class="list-name" title="'+dataName+'">';
					html += '<p>'+dataName+'</p>';
					//html += '<p><a href="${pageContext.request.contextPath}/psnlInfo/userTrainingAtt/downLoadUserTrainingAttData.do?id='+attData[i].id+'">'+attData[i].name+'</a></p>';
					html += '</div>';
					html += '<button title="删除" data-id="'+attData[i].id+'" class="remove" aria-hidden="true">×</button>';
					html += '</div>';
					$(".file-list").prepend(html);
		    	}
		     }
		};
		
		
		$(".back-btn").click(function(){//返回
			$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/psnlInfo/expert/personnelInfoList.do');
		});
		
	</script>
</body>
</html>