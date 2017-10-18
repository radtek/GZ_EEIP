<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>鉴定过程修改原始记录</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bracket-common.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/toggles.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/zyupload.basic-1.0.0.min.js" />"></script>
	<script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
  	<script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/ajaxfileupload.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/base.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/jquery-barcode.js" />"></script>
	
	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />	
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>电子物证管理</a><span>></span><a>鉴定人员操作台</a><span>></span><a>修改原始记录</a>
        </p>
    </div>
        <div class="form-module-title">
            <p>修改鉴定原始记录</p>
        </div>
        <div class="form-content">
            <form class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>案件编号：</label>
                    <div class="col-sm-4" data-bind="with: appraisalVM">
                        <input type="text" data-bind="value: caseSn" name="caseSn" id="caseSn" class="form-control" readonly required/>
                    </div>
                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>检材编号：</label>
                    <div class="col-sm-4" data-bind="with: appraisalVM">
                        <input type="text" data-bind="value: evidSn" name="evidSn" id="evidSn" class="form-control" readonly required/>
                    </div>
                </div>
				<div class="form-group">
                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>鉴定事项：</label>
                    <div class="col-sm-10">
                        <div class="matter-content">
                            <div class="matter-module">
                                <div class="matter-module-title">1.委托项目选择：</div>
                                <div class="matter-module-option">
                                    <div class="col-sm-4">
                                        <div class="ckbox ckbox-primary">
                                            <input type="checkbox" class="scope0" id="checkbox1" />
                                            <label for="checkbox1">提取固定电子数据</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="ckbox ckbox-primary">
                                            <input type="checkbox" class="scope1" id="checkbox2" />
                                            <label for="checkbox2">恢复电子数据</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="ckbox ckbox-primary">
                                            <input type="checkbox" class="scope2" id="checkbox3" />
                                            <label for="checkbox3">检验程序功能</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="ckbox ckbox-primary">
                                            <input type="checkbox" class="scope3" id="checkbox4" />
                                            <label for="checkbox4">破解电子数据密码</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="ckbox ckbox-primary">
                                            <input type="checkbox" class="scope4" id="checkbox5" />
                                            <label for="checkbox5">分析电子数据</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="ckbox ckbox-primary">
                                            <input type="checkbox" class="scope5" id="checkbox6" />
                                            <label for="checkbox6">销毁电子数据</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="matter-module">
                                <div class="matter-module-title">2.方法选择选择：</div>
                                <div class="matter-module-option">
                                    <div class="col-sm-12">
                                        <div class="ckbox ckbox-primary">
                                            <input type="checkbox" class="method0" id="checkbox7" />
                                            <label for="checkbox7">《数字化设备证据数据发现提取固定方法》GA/T756-2008</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-12">
                                        <div class="ckbox ckbox-primary">
                                            <input type="checkbox" class="method1" id="checkbox8" />
                                            <label for="checkbox8">《电子物证搜索检验技术规范》GB/T29362-2012</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-12">
                                        <div class="ckbox ckbox-primary">
                                            <input type="checkbox" class="method2" id="checkbox9" />
                                            <label for="checkbox9">《电子物证恢复检验技术规范》GB/T29360-2012</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-12 other-position" data-bind="with: appraisalVM">
                                        <div class="ckbox ckbox-primary">
                                            <input type="checkbox" class="method3" id="checkbox10" />
                                            <label for="checkbox10">其他</label>
                                        </div>
                                        <input type="text" data-bind="value: methodOther" name="methodOther" id="methodOther" value="" class="other-input" readonly/>
                                    </div>
                                </div>
                            </div>
                            <div class="matter-module">
                                <div class="matter-module-title">3.结果要求：</div>
                                <div class="matter-module-option">
                                    <div class="col-sm-4">
                                        <div class="ckbox ckbox-primary">
                                            <input type="checkbox" class="rqmt0" id="checkbox11" />
                                            <label for="checkbox11">出具检验报告</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="ckbox ckbox-primary">
                                            <input type="checkbox" class="rqmt1" id="checkbox12" />
                                            <label for="checkbox12">出具鉴定意见书</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="ckbox ckbox-primary">
                                            <input type="checkbox" class="rqmt2" id="checkbox13" />
                                            <label for="checkbox13">只提取电子数据</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-12 other-position" data-bind="with: appraisalVM">
                                        <div class="ckbox ckbox-primary">
                                            <input type="checkbox" class="rqmt3" id="checkbox14" />
                                            <label for="checkbox14">其他</label>
                                        </div>
                                        <input type="text" data-bind="value: rqmtOther" name="rqmtOther" id="rqmtOther" value="" class="other-input" readonly/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>检验地点：</label>
                    <div class="col-sm-10" data-bind="with: appraisalVM">
                        <input type="text" data-bind="value: location" name="location" id="location" class="form-control" readonly required/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>开始时间：</label>
					<div class="col-sm-4" data-bind="with: appraisalVM">
	                	<input id="appraisedStartDate" name="appraisedStartDate" class="form-control startDate datetimepicker datetimepicker-before"
								data-bind="dateTimePicker:appraisedStartDate" readonly required/>
					</div>
                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>结束时间：</label>
					<div class="col-sm-4" data-bind="with: appraisalVM">
	                	<input id="appraisedEndDate" name="appraisedEndDate" class="form-control startDate datetimepicker datetimepicker-after"
								data-bind="dateTimePicker:appraisedEndDate" readonly required />
					</div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>检验过程：</label>
                    <div class="col-sm-10" data-bind="with: appraisalVM">
                        <textarea data-bind="value: process" name="process" id="process" class="form-control" required></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>杀毒结果：</label>
                    <div class="col-sm-10" data-bind="with: appraisalVM">
                        <textarea data-bind="value: antivirusResult" name="antivirusResult" id="antivirusResult" class="form-control" required></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>检验结果：</label>
                    <div class="col-sm-10" data-bind="with: appraisalVM">
                        <textarea data-bind="value: appraisalResult" name="appraisalResult" id="appraisalResult" class="form-control" required></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">备注：</label>
                    <div class="col-sm-10" data-bind="with: appraisalVM">
                        <textarea data-bind="value: remarks" name="remarks" id="remarks" class="form-control"></textarea>
                    </div>
                </div>
            </form>
        </div>
        <div class="btn-content">
      		<button type="button" class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
	        <button type="button" class="btn btn-color1" data-bind ="click: saveData"><i class="fa fa-check"></i>确定修改</button>
    	</div>
    <jsp:include page="/common/alertMessages.jsp"></jsp:include>
	<script>
		$('.datetimepicker').datetimepicker({
		    format: 'YYYY-MM-DD  HH:mm',
		});
		$(".datetimepicker-before").on("dp.change",function (e) {
		    $('.datetimepicker-after').data("DateTimePicker").minDate(e.date);
		});
		$(".datetimepicker-after").on("dp.change",function (e) {
		    $('.datetimepicker-before').data("DateTimePicker").maxDate(e.date);
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
		//=====================以上内容属于前段控制
		//公用数据
		var userId = "${sessionScope.loginUser.userId}";
		var userName = "${sessionScope.loginUser.userName}";
		var userAlias = "${sessionScope.loginUser.userAlias}";
		var appraisalData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/loadDataByUserAlias.do", { "userId" : userId });
		var appraisalDataVM = ko.mapping.fromJS(appraisalData);
		
				
		checkBox();
	    function checkBox(){
			//项目委托方法的复选
			if(appraisalData.scope != "" && appraisalData.scope != undefined && appraisalData.scope != null){
				var scopeData = appraisalData.scope.split(",");
				for(var i = 0 ; i < scopeData.length ; i++){
					var check = ".scope" +scopeData[i];
					$(check).attr('checked', true)
				}
			}
			//鉴定方法的复选
			if(appraisalData.method != "" && appraisalData.method != undefined && appraisalData.method != null){
				var methodData = appraisalData.method.split(",");
				for(var i = 0 ; i < methodData.length ; i++){
					var check = ".method" + methodData[i];
					$(check).attr('checked', true)
				}
				if(appraisalData.methodOther != null && appraisalData.methodOther != "" && appraisalData.methodOther != undefined){
					$(".method3").attr('checked', true)
				}
			}
			//结果要求的复选
			if(appraisalData.rqmt != "" && appraisalData.rqmt != undefined && appraisalData.rqmt != null){
				var rqmtData = appraisalData.rqmt.split(",");
				for(var i = 0 ; i < rqmtData.length ; i++){
					var check = ".rqmt" +rqmtData[i];
					$(check).attr('checked', true)
				}
				if(appraisalData.rqmtOther != null && appraisalData.rqmtOther != "" && appraisalData.rqmtOther != undefined){
					$(".rqmt3").attr('checked', true)
				}
			}
			for(var i = 1 ; i < 15 ; i++){
				var check = "#checkbox" + i;
				$(check).attr("disabled","disabled") //禁用
			}
	    }
		
        var vm = {
       		appraisalVM : appraisalDataVM,
		}
		
		
        vm.saveData = function(){
        	$("button").attr("disabled", true);
        	if( validateSubmittedData() ){
        		if(saveData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/saveData.do", appraisalDataVM)){
    				//需要生成原始记录表单
					saveData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/saveRecordWord.do",appraisalDataVM);//需要生成原始记录表单
					saveData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/saveReportWord.do",appraisalDataVM);//需要生成鉴定文书副本
           			saveSuccess("${pageContext.request.contextPath}/elecEVIDMgt/authenticate/analysis/appraisalProcessAllot.do");
// 					window.parent.location.href = "${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/videoPlayback.do"; 
					
    			}
        	}else{
        		saveFailure();
        	}
		}
		
		ko.applyBindings(vm);
		
		$(".back-btn").click(function(){
			//window.parent.location.href = "${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/videoPlayback.do"; 
			
			var url = "${ pageContext.request.contextPath }/elecEVIDMgt/authenticate/analysis/appraisalProcessAllot.do";
			$(".index-iframe", window.parent.document).attr("src",url);
		})
		
	
	</script>
</body>
</html>