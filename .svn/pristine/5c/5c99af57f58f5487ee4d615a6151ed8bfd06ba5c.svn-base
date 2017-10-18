<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>人员基本情况登记</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script> 
    <script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>	 
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
 	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
 	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/expert.js" />"></script>
 	<script src="<c:url value="/resources/frameworks/pangolin/js/ajaxfileupload.js" />"></script>
 	
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
	           	当前位置：<a>人员信息管理</a><span>></span><a>专家库</a><span>></span><a>新增</a><span>></span><a>基本情况</a>
	        </p>
    	</div>
		<jsp:include page="/common/personNav.jsp"></jsp:include>
		<form class="form-horizontal myform">					
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>姓名：</label>
				<div class="col-sm-2" data-bind="with:userVM">
					<input type="text" class="form-control name"  data-bind="value:name" required/>
				</div>
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>性别：</label>
				<div class="col-sm-3"  data-bind="with:userVM">
					<select id="sex" class="form-control" data-bind="value:sex" required>
						<option value="0">男</option>
						<option value="1">女</option>
					</select>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>出生日期：</label>
				<div class="col-sm-2" data-bind="with:userVM">
					<input type="text" class="form-control datetimepicker2"  data-bind="dateTimePicker:birthday"  required/>
				</div>
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>身份证件号码：</label>
				<div class="col-sm-3" data-bind="with:userVM">
					<input type="text" class="form-control idCard" data-bind="value:idCard"  required/>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>家庭地址：</label>
				<div class="col-sm-7" data-bind="with:userVM">
					<input type="text" class="form-control validation"  data-bind="value:addr" required/>
				</div>
			</div>
																			
			<div class="img-upload center" data-bind="with:userVM">
				<img class="photo" src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/expert/header.png" />
				<button type="button" class="submit-btn">照片上传</button>
				<span class="delete-img-btn" title="删除"><i class="fa fa-times"></i></span>
				<input class="uploadImg input-hide" type="file" id="file" name="file" />
			</div>					
			
			<div class="form-group">
				<label class="col-sm-2 control-label">邮政编码：</label>
				<div class="col-sm-7" data-bind="with:userVM">
					<input type="text" class="form-control zipCode"  data-bind="value:zipCode" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>籍贯：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<input type="text" class="form-control chinese" data-bind="value:nativePlace" required/>
				</div>
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>民族：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<input type="text" class="form-control chinese" data-bind="value:nation" required/>
				</div>				
			</div>	
				
			<div class="form-group">										
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>工作部门：</label>
				<div class="col-sm-10" data-bind="with:userVM">
					<input type="text" class="form-control validation" data-bind="value:dept" required/>
				</div>
			</div>									
																	
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>参加工作时间：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<input type="text" class="form-control datetimepicker" data-bind="dateTimePicker:workingDate" required/>
				</div>
											
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>公安工作时间：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<input type="text" class="form-control datetimepicker" data-bind="dateTimePicker:policeDate" required/>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>政治面貌：</label>
				<div class="col-sm-4" > 
				    <select id="politicalStatus" class="form-control" required>
						<option value="0">中共党员</option>
						<option value="1">中共预备党员</option>
						<option value="2">共青团员</option>
						<option value="3">民革党员</option>
						<option value="4">民盟盟员</option>
						<option value="5">民建会员</option>
						<option value="6">农工党党员</option>
						<option value="7">致公党党员</option>
						<option value="8">九三学社社员</option>
						<option value="9">台盟盟员</option>
						<option value="10">无党派人士</option>
						<option value="11">群众</option>
					</select>
				</div>
			
				<label class="col-sm-2 control-label">入党时间：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<input type="text" class="form-control datetimepicker"  data-bind="dateTimePicker:joinDate"  />
				</div>
			</div>				
			
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>行政职务：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<input type="text" class="form-control validation" data-bind="value:position" required/>
				</div>
			
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>任职时间：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<input type="text" class="form-control datetimepicker" data-bind="dateTimePicker:officeDate" required />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>现从事专业：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<input type="text" class="form-control validation" data-bind="value:major" required/>
				</div>
			
				<label class="col-sm-2 control-label">本专业工作年限：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<input type="text" class="form-control chineseNum" data-bind="value:workingSeniority" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">现任专业技术职务：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<input type="text" class="form-control validation" data-bind="value:techPost" />
				</div>
			
				<label class="col-sm-2 control-label">取得资格时间：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<input type="text" class="form-control datetimepicker" data-bind="dateTimePicker:qualifyingDate" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>警衔：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<input type="text" class="form-control chineseNum" data-bind="value:policeRank" required/>
				</div>
			
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>警察证号：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<input type="text" class="form-control alarm" data-bind="value:policeId" placeholder="6位数字"  required/>
				</div>
			</div>
												
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>学历：</label>
				<div class="col-sm-4" data-bind="with:userEducationVM">
					<input type="text" class="form-control" data-bind="value:eduction" required/>
				</div>
			
				<label class="col-sm-2 control-label">学位：</label>
				<div class="col-sm-4" data-bind="with:userEducationVM">
					<input type="text" class="form-control name"  data-bind="value:degree" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>毕业院校：</label>
				<div class="col-sm-4" data-bind="with:userEducationVM">
					<input type="text" class="form-control validation" data-bind="value:school" required/>
				</div>
			
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>毕业时间：</label>
				<div class="col-sm-4" data-bind="with:userEducationVM">
					<input type="text" class="form-control datetimepicker" data-bind="dateTimePicker:date" required />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>专业：</label>
				<div class="col-sm-4" data-bind="with:userEducationVM">
					<input type="text" class="form-control validation" data-bind="value:major" required/>
				</div>
			
				<label class="col-sm-2 control-label">毕业证书：</label>
				<div class="col-sm-4" >
					<!-- <input type="text" class="form-control"  data-bind="value:educationCert" /> -->
					<select class="form-control educationCert">
						<option value="1">是</option>
						<option value="0">否</option>
					</select>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">学位证书：</label>
				<div class="col-sm-4">
					<!-- <input type="text" class="form-control"  data-bind="value:degreeCert" /> -->
					<select class="form-control degreeCert">
						<option value="1">是</option>
						<option value="0">否</option>
					</select>
				</div>							
			</div>
						
			<div class="form-group">
				<label class="col-sm-2 control-label left">掌握何种外语，程度如何：</label>
				<div class="col-sm-10" data-bind="with:userVM">
					<textarea class="form-control" data-bind="value:foreignLangLvl"></textarea>
				</div>						
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label left">参加何种学术团体、任何职、有无社会其他兼职：</label>
				<div class="col-sm-10" data-bind="with:userVM">
					<textarea class="form-control" data-bind="value:socialPost"></textarea>
				</div>						
			</div>			
		</form>
	</div>	
	<div class="btn-content">
        <button type="button" data-bind="click: backToList"  class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
        <button type="button" data-bind="click: saveData"  class="btn btn-color1"><i class="fa fa-check"></i>提交</button>
    </div>  
    <jsp:include page="/common/alertMessages.jsp"></jsp:include>
	<script>
		$(function(){
			//照片上传-----开始	
			$(".submit-btn").click(function(){
		    	$(this).siblings(".uploadImg").click();
		    	$(this).siblings(".uploadImg").change(function(){ 
			    	 	if($(this).val() !=''){
			    	 		uploadImg();
			          	}else{
			          		//$(this).parent().prev().find(".file-name").val('');
			          	}
				    });
		    });
		    $('.uploadImg').change(function(){ 
	    	 	if($(this).val() !=''){
	    	 		uploadImg();
	          	}else{
	          		//$(this).parent().prev().find(".file-name").val('');
	          	}
		    });
		    
		    function uploadImg(){
		    	$.ajaxFileUpload({
	  				url:"${pageContext.request.contextPath}/psnlInfo/userBasicInfo/upLoadAvatar.do?id=1",
	  				secureuri:false,
	  				fileElementId:'file',//file标签的id
	  				dataType: 'json',//返回数据的类型
	  				success: function (data) { 
	  					userDataVM.avatarPath = data.path;
	  					var imgSrc = "${pageContext.request.contextPath}/psnlInfo/userBasicInfo/loadAvatar.do?path="+data.path;
	  					$(".photo").attr("src", imgSrc);
	  					$(".delete-img-btn").show();
	  				},
	  				error: function (data, status, e) {
	  					//alert(e);
	  					var imgSrc = "${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/img.png";
	  					$(".photo").attr("src", imgSrc); 
	  					$(".delete-img-btn").show();
	  				}
	  			});
		    }
		    //照片上传-----结束
		    
		    /*文件删除*/
			$('.img-upload').on('click', '.delete-img-btn', function(){
				userDataVM.avatarPath = '';
				var imgSrc = "${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/expert/header.png";
				$(".photo").attr("src", imgSrc); 
				$(".delete-img-btn").css("display","none");
		  	  	 
		    });
		    /*文件删除结束*/
			
			// 链接判断
			var url = window.location.href;
			if( "${param.userBasicInfoId}" ){
			  $(".crumbs-text").html("当前位置：<a>人员信息管理</a><span>></span><a>专家库</a><span>></span><a>修改</a><span>></span><a>基本情况</a>");
			}
			
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
				},		
			};
			//时间控件数据绑定-----------结束 
			$('.datetimepicker').datetimepicker({
		       format: 'YYYY-MM-DD',
		    });
			$('.datetimepicker2').datetimepicker({
			       format: 'YYYY-MM-DD',
		    });
			var userData = loadData("${pageContext.request.contextPath}/psnlInfo/userBasicInfo/getUserBasicInfoByIdData.do",{ "id" : "${param.userBasicInfoId}" });
			
			userIdBoot = userData.id;
			
			userDataVM = ko.mapping.fromJS(userData);
		    var userEducationData = loadData("${pageContext.request.contextPath}/psnlInfo/userEducation/getuserEducationByUserIdData.do",{ "userBasicInfoId" : "${param.userBasicInfoId}" });
		    var userEducationDataVM = ko.mapping.fromJS(userEducationData);
		    
		    var avatarPath = userData.avatarPath;
		    if(avatarPath != "" && avatarPath != undefined && avatarPath != null){
		    	var imgSrc = "${pageContext.request.contextPath}/psnlInfo/userBasicInfo/loadAvatar.do?path="+avatarPath;
				$(".photo").attr("src", imgSrc);
				$(".delete-img-btn").show();
		    }
		    
		    $('.educationCert').val(userEducationData.educationCert);
		    $('.degreeCert').val(userEducationData.degreeCert);
		    var vm={
		    		userVM : userDataVM,
		    		userEducationVM :userEducationDataVM 
		    }
		     
		    vm.saveData = function(){
		    	$("button").attr("disabled", true);
		    	if(validateSubmittedData()){
		    		bindDataVM();		    	
					var flag = saveData("${pageContext.request.contextPath}/psnlInfo/userBasicInfo/saveUserBasicInfoData.do",userDataVM);
					if(flag){
						if(saveData("${pageContext.request.contextPath}/psnlInfo/userEducation/saveUserEducationData.do",userEducationDataVM)){ 
							saveSuccess("${pageContext.request.contextPath}/psnlInfo/expert/personnelInfoList.do");
						}
					}
		    	}else{
		    		saveFailure();
		    	}    	
			} 
			
			vm.backToList = function(){//返回
				$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/psnlInfo/expert/personnelInfoList.do');
			}
			
			ko.applyBindings(vm);
		
			function bindDataVM(){ 
				userDataVM.creatorId="${sessionScope.loginUser.userId}";
				userDataVM.creatorName="${sessionScope.loginUser.userName}";
				userDataVM.creatorAlias="${sessionScope.loginUser.userAlias}";
				userDataVM.sex=$('#sex option:selected').val();
				userDataVM.politicalStatus=$('#politicalStatus option:selected').val();
				userEducationDataVM.creatorId="${sessionScope.loginUser.userId}";
				userEducationDataVM.creatorName="${sessionScope.loginUser.userName}";
				userEducationDataVM.creatorAlias="${sessionScope.loginUser.userAlias}";
				userEducationDataVM.userBasicInfoId=userData.id; 
				userEducationDataVM.educationCert = $('.educationCert option:selected').val();
				userEducationDataVM.degreeCert = $('.degreeCert option:selected').val();
	 		} 
		});	
	</script>
</body>
</html>