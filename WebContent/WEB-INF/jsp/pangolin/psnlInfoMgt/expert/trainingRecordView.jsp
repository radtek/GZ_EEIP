<%@ page language="java" pageEncoding="utf-8"
 contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>人员培训履历表详情页</title>
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
 	
 	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/expert/expert.css" />" rel="stylesheet" />	
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" /> 
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" /> 
</head>
<body>
	<div class="content">		
		<div class="crumbs-nav">
	        <p class="crumbs-text">
	           	当前位置：<a>人员信息管理</a><span>></span><a>专家库</a><span>></span><a>查看</a><span>></span><a>培训履历</a>
	        </p>
    	</div>
		<jsp:include page="/common/personNav.jsp"></jsp:include>
		<form class="form-horizontal myform">									
			<div class="form-group">
				<label class="col-sm-2 control-label">姓名：</label>
				<div class="col-sm-4">
					<input type="text" id="name" class="form-control" data-bind="value:name" readonly/>
				</div>
				<label class="col-sm-2 control-label">性别：</label>
				<div class="col-sm-4">
				<input type="text"  class="form-control" data-bind="value:sex" readonly/>
				</div>								
			</div>							
			<div class="form-group">
				<label class="col-sm-2 control-label">专业：</label>
				<div class="col-sm-4">
					<input type="text"  id="major" class="form-control"  data-bind="value:major" readonly/>
				</div>
				<label class="col-sm-2 control-label">学历：</label>
				<div class="col-sm-4" >
					<input type="text" id="eduction" class="form-control"  data-bind="value:education" readonly/>
				</div>					
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">出生日期：</label>
				<div class="col-sm-4">
					<input type="text" id="birthday" class="form-control" data-bind="value:birthday" readonly/>
				</div>
				 					
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
						<th>培训日期</th>
						<th>培训内容</th>
						<th>培训单位</th>
						<th>考核情况</th>	
						<th>登记人</th>	
					</tr>
				</thead>
				<tbody class="handleData">
					
				</tbody>
			</table>
        </div>
    </div>
	<div class="upload-module">
        <div class="module-title">
            <p>培训资料</p>
        </div>
        <div class="file-list"></div>
        <!-- <div class="upload-content">
            <div class="upload-input">
                <input type="text" class="file-name" readonly />
            </div>
            <div class="upload-btn">
                <button type="button" class="btn btn-color1 file-browse"><i class="fa fa-folder-open-o"></i>浏览</button>
                <button type="button" class="btn btn-color2 file-upload-btn"><i class="fa fa-upload"></i>上传</button>
            	<input type="file" class="file-input" id="file" name="file" />
            </div>
        </div> -->
    </div>	
	<div class="btn-content">
        <button type="button" class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
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
			
			var data = loadData("${pageContext.request.contextPath}/psnlInfo/userTrainingExp/getUserTrainingExpByUserIdListData.do",{ "userBasicInfoId" : "${param.userBasicInfoId}" });
		      
			//用户基本信息
		     
	        if(data.length>0){
		    	 var resultHtml='';
		    	 for(var i = 0 ; i<data.length;i++){
		    		 resultHtml+='<tr class="col-read">'							
						+'<td><input type="text" readonly="readonly" class="datetimepicker11" value="'+new Date(data[i].startDate).Format("yyyy-MM-hh")+'" style="width:100px;"/>至<input type="text" readonly="readonly"  class="datetimepicker11" value="'+new Date(data[i].startDate).Format("yyyy-MM-hh")+'" style="width:100px;"/>'																				
						+'<td><input type="text" readonly="readonly" value="'+data[i].content+'"/></td>'						
						+'<td><input type="text" readonly="readonly" value="'+data[i].trainingAgency+'"/></td>'							
						+'<td><input type="text" readonly="readonly" value="'+data[i].result+'"/></td>'						
						+'<td><input type="text" readonly="readonly" value="'+data[i].registrant+'"/></td>'						
						+'</tr>';  
		    	 }
		    	 $(".datetimepicker11").datetimepicker({viewMode: 'years',format: 'YYYY-MM-DD'});
		    	 $(".handleData").append(resultHtml);
		     }
			
			 var userTrainingData = loadData("${pageContext.request.contextPath}/psnlInfo/userTraining/getUserTrainingByUserIdData.do",{ "userBasicInfoId" : "${param.userBasicInfoId}" });
			 var userEducationData = loadData("${pageContext.request.contextPath}/psnlInfo/userEducation/getuserEducationByUserIdData.do",{ "userBasicInfoId" : "${param.userBasicInfoId}" });
			 var userData = loadData("${pageContext.request.contextPath}/psnlInfo/userBasicInfo/getUserBasicInfoByIdData.do",{ "id" : "${param.userBasicInfoId}" });
			 
			 userTrainingData.name = userData.name;
			 userTrainingData.major = userData.major;
			 userTrainingData.education = userEducationData.eduction;
			 userTrainingData.birthday = new Date(userData.birthday).Format("yyyy-MM-dd");	
			 if(userData.sex == 0){
				 userTrainingData.sex = '男';
			 }else if(userData.sex == 1){
				 userTrainingData.sex = '女';
			 }
			 
			 var vm  = ko.mapping.fromJS(userTrainingData);
			 
			 loadAtt(userTrainingData.id);
			
			ko.applyBindings(vm);
		
			 
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
					html += '<p><a href="${pageContext.request.contextPath}/psnlInfo/userTrainingAtt/downLoadUserTrainingAttData.do?id='+attData[i].id+'">'+dataName+'</a></p>';
					//html += '<p><a href="${pageContext.request.contextPath}/psnlInfo/userTrainingAtt/downLoadUserTrainingAttData.do?id='+attData[i].id+'">'+attData[i].name+'</a></p>';
					html += '</div>';
					//html += '<button title="删除" data-id="'+attData[i].id+'" class="remove" aria-hidden="true">×</button>';
					html += '</div>';
					$(".file-list").prepend(html);
		    	}
		     }
			 
			 /* if(attData.length>0){
	    		 var html='';
		    	 for(var i = 0;i<attData.length;i++){
 		    		html += '<div class="list-content">';
					html += '<div class="list-img">';
					html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/'+attData[i].ext+'.png" alt="">';
					html += '</div>';
					html += '<div class="list-name" title="'+attData[i].name+'">';
					html += '<p><a href="${pageContext.request.contextPath}/psnlInfo/userTrainingAtt/downLoadUserTrainingAttData.do?id='+attData[i].id+'">'+attData[i].name+'</a></p>';
					html += '</div>';
 					html += '</div>';					
		    	 }
		    	 $(".file-list").append(html);
		     } */
		};
		
		$(".back-btn").click(function(){//返回
			$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/psnlInfo/expert/personnelInfoList.do');
		});
		
	</script>
	
</body>
</html>