<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>年度计划查看</title>
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
	
	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" /> 
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>会议管理</a><span>></span><a>计划</a><span>></span><a>内审年度计划</a><span>></span><a>查看</a>
        </p>
   	</div>
	<div class="form-content">
		<form class="form-horizontal">					
			<div class="form-group">
				<label class="col-sm-2 control-label">年度：</label>
				<div class="col-sm-4" data-bind="with:planAppVM">
					<input type="text" class="form-control" id="year" data-bind="value:year" readonly/>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">备注：</label>
				<div class="col-sm-10" data-bind="with:planAppVM">
					<textarea rows="8" cols="" class="form-control" data-bind="value:remarks" readonly></textarea>
				</div>						
			</div>	
			<div class="form-group mag-top">
				<label class="col-sm-2 control-label">编制人：</label>
				<div class="col-sm-4" data-bind="with:planAppVM">
					<input type="text" class="form-control" data-bind="value:creatorAlias" readonly/>
				</div>	
				<label class="col-sm-2 control-label">编制时间：</label>
				<div class="col-sm-4" data-bind="with:planAppVM">
					<input type="text" class="form-control datetimepicker" data-bind="dateTimePicker:createdDate" readonly/>
				</div>							
			</div>
		</form>
	</div>
	<div class="upload-module upload-margin">
        <div class="module-title">
            <p>内审年度计划文件</p>
        </div>
        <div class="file-list"></div>
    </div>
	<div class="btn-content">
       	<button class="btn btn-color2 back-btn" data-bind="click: backToList"><i class="fa fa-chevron-left"></i>返回</button>
    </div>	
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
	
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
			
			
			
			var planAppData = loadData("${ pageContext.request.contextPath }/meeting/loadAnnualPlanAppData.do",{ "id" : "${param.id}" });
		    var planAppDataVM = ko.mapping.fromJS(planAppData);
		    
		    var planAtt = loadData("${ pageContext.request.contextPath }/annualPlanApp/getAnnualPlanAttListByAppIdData.do",{ "id" : planAppData.id });
		    console.log(planAtt);
	      	if( planAtt.length != 0 ){
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
					html += '<p><a href="${pageContext.request.contextPath}/annualPlanApp/downloadAnnualPlanAttData.do?id='+dataId+'">'+dataName+'</a></p>';
					html += '</div>';
					//html += '<button type="button" title="删除" data-id="'+dataId+'" class="remove">×</button>';
					html += '</div>';
	        		$('.file-list').append(html);
	    		}
	     	}
		    		    
		    var planDataVM = {
		    		plans : ko.observableArray(planAppData.annualPlans)
		    }
		    
		    var vm = {
		    		planAppVM : planAppDataVM,
		    		planVM : planDataVM
		    }
		   
			
			vm.backToList = function(){//返回
				$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/annualPlan/annualPlanList.do');
			}
			
			ko.applyBindings(vm);
			//数据绑定
			function bindDataVM(){}
			
		});
	</script>
</body>
</html>