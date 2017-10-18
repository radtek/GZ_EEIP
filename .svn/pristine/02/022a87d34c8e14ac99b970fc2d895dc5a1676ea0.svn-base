<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>取证及流程管理-已出库检材-查看</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/base.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bracket-common.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/toggles.min.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/zyupload.basic-1.0.0.min.js" />"></script>
	<script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/ajaxfileupload.js" />"></script>
  	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>取证及流程管理</a><span>></span><a>已出库检材</a><span>></span><a>查看</a>
        </p>
    </div>
    <div class="tabs-content">
	    <ul class="nav nav-tabs nav-justified tabs-nav">
	        <li><a class="register">登记信息</a></li>
	        <li><a class="warehousing">物证入库</a></li>
	        <li><a class="handover">交接记录</a></li>
	    </ul>
	</div>
    <div class="tabs-list" id="register">
    	<jsp:include page="/common/registerInfoViewRui.jsp"></jsp:include>
    </div>
    <div class="tabs-list" id="warehousing">
    	<jsp:include page="/common/physicalEvidenceStorageViewRui.jsp"></jsp:include>
    </div>
    <div class="tabs-list" id="handover">
    	<jsp:include page="/common/handoverRecordViewRui.jsp"></jsp:include>
    </div>
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
		$(function(){
			var moduleHtml = $(".module-content").html();
			$(".material-template").html(moduleHtml);
			
			moduleNum();
			
			/* 标签页事件和样式-开始 */
			var clickStatus = 0;	//点击状态
			var dataStatus = 2;		//数据状态
			tabsContent(clickStatus,dataStatus);
			/* 标签页事件和样式-结束  */
			
			$(".add-material-btn").click(function(){
				var template = $(".material-template").html();
				var templateHtml = "";
				templateHtml += '<div class="form-content module-border">';
				templateHtml += template;
				templateHtml += '</div>';
				$(this).parents(".add-material-content").before(templateHtml);
				moduleNum();
			});
			
			
			$("#add-person").click(function(){
				$(this).parent().parent(".form-group").after('<div class="form-group">'
					+'<label class="col-sm-2 control-label">送检人：</label>'
					+'<div class="col-sm-2">'
					+'<input type="text" class="form-control userAlias" readonly />'
					+'</div>'
					+'<label class="col-sm-1 control-label">职务：</label>'
					+'<div class="col-sm-2">'
					+'<input type="text" class="form-control userPost" readonly />'
					+'</div>'
					+'<label class="col-sm-1 control-label">警察证号：</label>'
					+'<div class="col-sm-2">'
					+'<input type="text" class="form-control policeId" readonly />'
					+'</div>'
					+'</div>'
				);
			});
			
			$(".form-horizontal").on("click", ".delete-personnel-btn", function(){
				$(this).parents(".form-group").remove();
			});
			
			$(".back-btn").click(function(){
		    	var url = "${pageContext.request.contextPath}/evidenceMgt/outOfTheLibrary/outOfTheLibraryList.do";
		    	$(".index-iframe", window.parent.document).attr("src",url);
		    });
			
			$.ajax({
				url:'${ pageContext.request.contextPath }/elecEVIDMgt/preappraisalEntruster/loadPreappraisalentrusterList.do',
				type:'post',
				datatype:"json",
				data:{ "PreappraisalId" : appraisalData.preappraisalId },
				success:function(data){
					for(var i = 1 ; i<data.length ; i++){
				        var oBtn = $("#add-person");
			        	oBtn.click();
					}
					for(var i = 0 ; i< data.length ; i++){
		        		$(".userAlias").eq(i).val(data[i].userAlias);
		        		$(".userPost").eq(i).val(data[i].userPost);
		        		$(".policeId").eq(i).val(data[i].policeId);
					}
				}
			})
			
			$.ajax({
				url:'${ pageContext.request.contextPath }/elecEVIDMgt/preappraisedEvid/preappraisedEvidDataList.do',
				type:'post',
				datatype:"json",
				data:{ "preappraisalId" : appraisalData.preappraisalId },
				success:function(data){
					for(var i = 1 ; i<data.length ; i++){
				        var oBtn = $(".add-material-btn");
			        	oBtn.click();
					}
					for(var i = 0 ; i< data.length ; i++){
		        		$(".module-list input[type='text']").eq(i*3).val(data[i].name); 
		        		$(".module-list textarea").eq(i*2).val(data[i].desc);
		        		$(".module-list textarea").eq(i*2+1).val(data[i].remarks);
		        		var value = data[i].type;
		        		$(".module-list > .form-content").eq(i).find("input[value='"+value+"']").attr("checked","checked");
		        		$(".module-list > .form-content").eq(i).find(".status").val(data[i].status);
					}
				}
			})

						
			$.ajax({
				url:'${ pageContext.request.contextPath }/elecEVIDMgt/preappraisalAtt/loadPreappraisalAttData.do',
				type:'post',
				datatype:"json",
				data:{ "id" : appraisalData.preappraisalId },
				success:function(data){
					var data = data.entity;
					for(var j = 0; j < data.length ; j++){
						var data2 = data[j];
						if(data2 != "" && data2 != undefined && data2 != null){
							var fileList = $(".file-list");
		   	   				var fileType1 = data2.name.split(".")[data2.name.split(".").length-1];
							var allLength = data2.name.length;
							var length = fileType1.length+1;
							var dataName = data2.name.substring(0,allLength-length);
							var fileType = fileType1.toLowerCase();
							var dataId = data2.id;
							var imgArr = ["jpg", "jpeg", "png", "bmp"];
							var fileArr = ["doc", "docx", "xls", "xlsx", "ppt", "pptx", "pdf", "txt"];
							var videoArr = ["mov", "avi", "mp4", "wmv"];
							var html='';
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
							html += '<p><a href="${pageContext.request.contextPath}/elecEVIDMgt/preappraisalAtt/downPreappraisalAttData.do?id='+dataId+'">'+dataName+'</a></p>';
							html += '</div>';
							html += '</div>';
	   	   					fileList.prepend(html);
						}
					}
				}
			})
			
			for(var i = 1 ; i < 15 ; i++){
				var check = $("input[type='radio']")
				$(check).attr("disabled","disabled") //禁用
			}
			
    	   	function getOperationCol(data, type, row) {
				var html = "";
				html += "<a class=\"viewer-btn\" onclick=\"view('" + row.id + "');\" title=\"查看\"><i class=\"fa fa-search\"></i></a> "; //查看
				return html;
			}
    	   	
    	   	function getType(data, type, row){
    	   		if(data == 0){
    	   			return "领用";
    	   		}else{
    	   			return "归还";
    	   		}
    	   	}
        	
    		loadGridData();
        	
    		//加载列表数据
    		function loadGridData() {
				//数据列绑定
				var columns = [
					{ "mData" : "createdDate" , "bSortable" : false ,"mRender": getFormattedDate},
					{ "mData" : "applicantAlias" , "bSortable" : false },
					{ "mData" : "operatorAlias" , "bSortable" : false },
					{ "mData" : "type" , "bSortable" : false , "mRender" : getType},
	            ];
          	
    			//排序规则
    			var sorting = [ [ 0 , 'desc' ] ];
        	  
    			//扩展参数
    			var extraParams = [
					{	"name" : "appraisalId",
						"value" : "${param.id}" } 
				];
            
    			//初始化数据表
    			dataTable = new BSDataTable();
    			dataTable.initialize({
    				"tableId" : "table2",
    				"columns" : columns,
    				"sorting" : sorting,
    				"pageSize" : 50,
    				"dataSource" : "${ pageContext.request.contextPath }/elecEVIDMgt/evidTransition/evidTransitionGirdData.do",
    				"extraParams" : extraParams,
    				"style" : DT_FULL_NUMBERS,
    				"bProcessing" : true,
    				"url" : {
    				}
    			});
                
    			//隐藏列表组件显示条数
    			$('#table2_length, #table2_paginate,#table2_info').hide();
             }
		});
		
		function moduleNum(){
			var formContent = $(".module-list > .form-content");
			var formSize = formContent.size();
			for( var i = 0; i < formSize; i++){
				formContent.eq(i).find("input[type='radio']").attr("name", "radio"+i);
				var inputContent = formContent.eq(i).find("input[type='radio']");
				var inputSize = inputContent.size();
				for( var j = 0; j < inputSize; j++ ){
					inputContent.eq(j).attr("id", "radioMaterial"+i+j);
					inputContent.eq(j).next("label").attr("for", "radioMaterial"+i+j);
				}
			}
		}
		
	    var id = "${param.id}";
		var appraisalData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/loadDataById.do",{"id":id});
        var preappraisalData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/preappraisal/loadPreappraisalData.do", { "id" : appraisalData.preappraisalId });
		var evidenceData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/evidence/getDataByAppraisalId.do", { "appraisalId" : id });
		var evidenceLog = loadData("${pageContext.request.contextPath}/elecEVIDMgt/evidOpLog/getDataByEvidIdAndSpLabel.do",{ "evidId" : evidenceData.id , "spLabel" : 1 });
	    var evidOpLogAtt = loadData("${pageContext.request.contextPath}/elecEVIDMgt/evidOpLogAtt/loadDataByEvidOpLogId.do",{ "evidOpLogId" : evidenceLog.id  });
		if(evidOpLogAtt.length > 0){
			var html = '';
			for( var i = 0; i < evidOpLogAtt.length; i++ ){
				html += '<li><span><img data-toggle="modal" data-target=".modal-bigImg" src="${pageContext.request.contextPath}/elecEVIDMgt/evidOpLogAtt/loadImageData.do?id='+evidOpLogAtt[i].id+'"/></span></li>';
			}
	    	$(".img-list").append(html);
	    	
	    	/* var html2 = '<img src="${pageContext.request.contextPath}/elecEVIDMgt/evidOpLogAtt/loadImageData.do?id='+evidOpLogAtt[0].id+'"/>';
	    	$(".big-img").append(html2); */
	    }  
		
		var evidenceDataVM = ko.mapping.fromJS(evidenceData);
        var appraisalDataVM = ko.mapping.fromJS(appraisalData);
        var preappraisalDataVM = ko.mapping.fromJS(preappraisalData);

		//省
	    var provinceData = loadData("${ pageContext.request.contextPath }/inquest/province/getOptionsData.do",{});
	    var provinceDataVM = {
	    		provinceList : ko.observableArray(provinceData),
	    		provinceId : ko.observable(440000)
	    }
	    
	    //市
	    var cityData = loadData("${ pageContext.request.contextPath }/inquest/city/getOptionsData.do",{ "provinceId" : 440000 });
	    var cityDataVM = {
	    		cityList : ko.observableArray(cityData),
	    		cityId : ko.observable(440100)
	    }
    
	    //区
	    var countyData = loadData("${ pageContext.request.contextPath }/inquest/county/getOptionsData.do",{ "cityId" : 440100 });
	    var countyDataVM = {
	    		countyList : ko.observableArray(countyData),
	    		countyId : ko.observable(preappraisalData.country)
	    }
	    
	    // 省，市联动changeProvince
	    function changeProvince(){
			//load room data
			  cityDataVM.cityList.removeAll();
		      cityData = loadData("${pageContext.request.contextPath}/inquest/city/getOptionsData.do",{ "provinceId" : $("#province").val() });
		      if(cityData==undefined || cityData==null)cityData=[];
		      cityDataVM.cityList(cityData);
		}
	    
	   // 市，区联动
	    function changeCity(){
	    	  countyDataVM.countyList.removeAll();
	    	  countyData = loadData("${pageContext.request.contextPath}/inquest/county/getOptionsData.do",{ "cityId" : $("#city").val() });
		      if(countyData==undefined || countyData==null)countyData=[];
		      countyDataVM.countyList(countyData);
	    }
	    
	    //获取空对象保存使用
        var vm = {
        	evidenceVM : evidenceDataVM,
        	appraisalVM : appraisalDataVM,
        	preappraisalVM : preappraisalDataVM,
    		provinceVM : provinceDataVM,
    		cityVM : cityDataVM,
    		countyVM : countyDataVM,
        }
        
        ko.applyBindings(vm);
	</script>
</body>
</html>