<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>现场勘验审批</title>
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
	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>现场勘验</a><span>></span><a>审批</a>
        </p>
    </div>
    <div class="form-content">
    	<form class="form-horizontal">						
			<div class="form-group">
				<label class="col-sm-2 control-label">现场勘验号：</label>
				<div class="col-sm-4" data-bind="with:inquestVM">
					<input type="text" class="form-control" data-bind="value:sn" readonly/>
				</div>	
				<label class="col-sm-2 control-label">勘验日期：</label>
				<div class="col-sm-4" data-bind="with:inquestVM">
					<input class="form-control" data-bind="dateTimePicker:operatedDate" readonly></input>
				</div>							
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">勘验人：</label>
				<div class="col-sm-4" data-bind="with:inquestVM">
					<input type="text" class="form-control" data-bind="value:operatorAlias" readonly/>
				</div>	
				<label class="col-sm-2 control-label">案件名称：</label>
				<div class="col-sm-4" data-bind="with:inquestVM">
					<input class="form-control" data-bind="value:caseName" readonly></input>
				</div>							
			</div>
			<div class="form-group" >
				<label class="col-sm-2 control-label">文件：</label>
				<div class="col-sm-10">
					<div class="upload-file">
						<div class="item">
						</div>
					</div>
				</div>			
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">区域：</label>
				<!-- <div class="col-sm-2" data-bind="with:provinceVM">
						<select id="province" class="form-control" data-bind="options:provinceList,optionsValue:'provinceId',optionsText:'name',value:provinceId,optionsCaption:'--请选择--'" disabled></select>
		        </div>
		        <div class="col-sm-2" data-bind="with:cityVM">
						<select id="city" class="form-control" data-bind="options:cityList,optionsValue:'cityId',optionsText:'name',value:cityId,optionsCaption:'--请选择--' " disabled></select>
		        </div>	 -->
		        <div class="col-sm-4" data-bind="with:countyVM">
					<select id="county" class="form-control" data-bind="options:countyList,optionsValue:'countyId',optionsText:'name',value:countyId,optionsCaption:'--请选择--' " disabled></select>
		        </div>											
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">审核意见：</label>
				<div class="col-sm-10" data-bind="with:inquestVM">
					<textarea rows="8" cols="" class="form-control" data-bind="value:opinion"></textarea>
				</div>										
			</div>
		</form>
    </div>
	<div class="btn-content">
        <button class="btn btn-color2 back-btn" data-bind="click: backToList"><i class="fa fa-chevron-left"></i>返回</button>
        <button class="btn btn-color1" data-bind="click: saveData"><i class="fa fa-check"></i>同意</button>
        <button class="btn btn-color1" data-bind="click: refuseData"><i class="fa fa-times"></i>不同意</button>
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
		
		var inquestData = loadData("${pageContext.request.contextPath}/inquest/loadInquestData.do",{ "id" : "${param.id}" });
	    var inquestDataVM = ko.mapping.fromJS(inquestData);
	    
	    var inquestDocData = loadData("${pageContext.request.contextPath}/inquest/document/getDocumentsByInquestIdData.do",{ "id" : "${param.id}" });
	    var inqusetDocDataVM = {
	    		docs : ko.observableArray(inquestDocData)
	    }
	    
	    var docs = "";
	    
	    for(var i=0;i<inquestDocData.length;i++){
	    	/* docs += '<p><a href="###">'+inquestDocData[i]['name']+'</a>'+
				    '<button type="button" class="btn btn-color1"><i class="fa fa-download"></i>下载</button></p>' */
			docs += '<p><a href="${pageContext.request.contextPath}/inquest/document/downloadDocumentData.do?id='+inquestDocData[i]['id']+'">'+inquestDocData[i]['name']+'</a></p>'	
	    }
	    
	    $(".item").html(docs);
	    
	    //省
	   /*  var provinceData = loadData("${pageContext.request.contextPath}/inquest/province/getOptionsData.do",{});
	    var provinceDataVM = {
	    		provinceList : ko.observableArray(provinceData),
	    		provinceId : ko.observable(inquestData.province)
	    } */
	    
	    //市
	   /*  var cityData = loadData("${pageContext.request.contextPath}/inquest/city/getOptionsData.do",{ "provinceId" : inquestData.province });
	    var cityDataVM = {
	    		cityList : ko.observableArray(cityData),
	    		cityId : ko.observable(inquestData.city)
	    } */
	    
	    //区
	    var countyData = loadData("${pageContext.request.contextPath}/inquest/county/getOptionsData.do",{ "cityId" : inquestData.city });
	    countyData.unshift({'id':'','cityId':440100,'countyId':440100,'name':'直属'});
	    var countyId = ( inquestData.county == null || inquestData.county == '' ) ? 440100 : inquestData.county;
	    var countyDataVM = {
	    		countyList : ko.observableArray(countyData),
	    		countyId : ko.observable(countyId)
	    }
	    
	    var vm = {
	    		inquestVM : inquestDataVM,
	    		/* provinceVM : provinceDataVM,
	    		cityVM : cityDataVM, */
	    		countyVM : countyDataVM,
	    		inquestDocVM : inqusetDocDataVM
	    }
	    
	    vm.saveData = function(){ 
	    	$("button").attr("disabled", true);
	        if ( validateSubmittedData() ) {
	        	bindDataVM();
	        	inquestDataVM.status = 2;
	        	if (saveData("${pageContext.request.contextPath}/inquest/saveInquestData.do", inquestDataVM)) {
					saveSuccess("${pageContext.request.contextPath}/inquestMgt/sceneInquestList.do");
				} else {
					saveFailure();
				}
	        } else {
	        	saveFailure();
	        }
		}
	    
	    vm.refuseData = function(){ 
	    	$("button").attr("disabled", true);
	        if ( validateSubmittedData() ) {
	        	bindDataVM();
	        	inquestDataVM.status = 3;
	        	if (saveData("${pageContext.request.contextPath}/inquest/saveInquestData.do", inquestDataVM)) {
					saveSuccess("${pageContext.request.contextPath}/inquestMgt/sceneInquestList.do");
				} else {
					saveFailure();
				}
	        } else {
	        	saveFailure();
	        }
		}
		
		vm.backToList = function(){//返回
			$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/inquestMgt/sceneInquestList.do');
		}
		
		ko.applyBindings(vm);
		
		function bindDataVM(){
			inquestDataVM.approverName = "${sessionScope.loginUser.userName}";
			inquestDataVM.approverId = "${sessionScope.loginUser.userId}";
			inquestDataVM.approverAlias = "${sessionScope.loginUser.userAlias}";
			inquestDataVM.approvedDate = new Date();
		}
		
	});
	 	
	
	</script>
</body>
</html>