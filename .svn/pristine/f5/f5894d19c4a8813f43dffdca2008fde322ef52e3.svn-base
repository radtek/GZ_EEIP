<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>电子物证管理-管理人员操作台-修改文书审批-申请审批</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>    
  	<script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>	 
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script> 
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/zyupload.basic-1.0.0.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/base.js" />"></script>
  	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" /> 	
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>电子物证管理</a><span>></span><a>管理人员操作台</a><span>></span><a>修改文书审批</a><span>></span><a>审批</a>
        </p>
    </div>
    <div class="form-title">鉴定文书修改申请表</div>
    <div class="form-content">
        <form class="form-horizontal ">
	        <div class="auth1">
	            <div class="form-group">
	                <label class="col-sm-2 control-label">委托单位：</label>
	                <div class="col-sm-10" data-bind="with: appraisalReviseVm">
	                    <input type="text" class="form-control" data-bind="value:orgName" readonly />
	                </div>
	            </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label">鉴定文书名称：</label>
	                <div class="col-sm-4" data-bind="with: appraisalReviseVm">
	                    <input type="text" class="form-control"  data-bind="value:reportName" readonly />
	                </div>
	                <label class="col-sm-2 control-label">鉴定文书编号：</label>
	                <div class="col-sm-4" data-bind="with: appraisalReviseVm">
	                    <input type="text" class="form-control" data-bind="value:reportSn" readonly />
	                </div>
	            </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label">委托人：</label>
	                <div class="col-sm-4"  >
	                    <input type="text" class="form-control entrusterUserAlias" readonly />
	                </div>
	                <label class="col-sm-2 control-label">申请日期：</label>
	                <div class="col-sm-4" data-bind="with: appraisalReviseVm">
	                    <input type="text" class="form-control datetimepicker "  data-bind="dateTimePicker: createdDate" readonly />
	                </div>
	            </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label">修改人：</label>
	                <div class="col-sm-4" data-bind="with: appraisalReviseVm">
	                    <input type="text" class="form-control" data-bind="value: modifierAlias" readonly />
	                </div>
	                <label class="col-sm-2 control-label">修改日期：</label>
	                <div class="col-sm-4" data-bind="with: appraisalReviseVm">
	                    <input type="text" class="form-control datetimepicker " data-bind="dateTimePicker: revisedDate" readonly/>
	                </div>
	            </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label">修改内容：</label>
	                <div class="col-sm-10" data-bind="with: appraisalReviseVm">
	                    <textarea class="form-control" data-bind="value: revisedContent" readonly></textarea>
	                </div>
	            </div>
	            <div class="form-group">
					<label class="col-sm-2 control-label" data-name=".modify-the-way-radio">修改方式：</label>
					<div class="col-sm-4" data-bind="with: appraisalReviseVm">
	                    <input type="text" class="form-control method"  readonly />
	                </div>
				</div>
	            <div class="form-group auth authradio">
	                <label class="col-sm-2 control-label auth auth-validation input-choose" data-name=".authorized-signatories-radio"><span class="required-fields">*</span>授权签字人意见：</label>
	                <div class="col-sm-3 authorized-signatories-radio">
	                    <div class="rdio rdio-primary">
	                        <input type="radio" name="radio1" value="0" id="radioAgree1">
	                        <label for="radioAgree1">同意</label>
	                    </div>
	                </div>
	                <div class="col-sm-3 authorized-signatories-radio">
	                    <div class="rdio rdio-primary">
	                        <input type="radio" name="radio1" value="1" id="radioDisagree1">
	                        <label for="radioDisagree1">不同意</label>
	                    </div>
	                </div>
	            </div>
	            <div class="form-group">
	            	<label class="col-sm-2 control-label">授权签字人意见说明：</label>
	            	<div class="col-sm-10" data-bind="with: appraisalReviseVm">
	                    <textarea class="form-control" data-bind="value: authAuditorOpinion"></textarea>
	                </div>
	            </div>
            </div>
            <div class="tech2 form-group-margin">
	            <div class="form-group tech techDiv techradio">
	                <label class="col-sm-2 control-label tech tech-validation" data-name=".technical-director-radio"><span class="required-fields">*</span>技术负责人意见：</label>
	                <div class="col-sm-3 technical-director-radio">
	                    <div class="rdio rdio-primary">
	                        <input type="radio" name="radio2" value="0" id="radioAgree2">
	                        <label for="radioAgree2">同意</label>
	                    </div>
	                </div>
	                <div class="col-sm-3 technical-director-radio">
	                    <div class="rdio rdio-primary">
	                        <input type="radio" name="radio2" value="1" id="radioDisagree2">
	                        <label for="radioDisagree2">不同意</label>
	                    </div>
	                </div>
	            </div>
	            <div class="form-group techDiv">
	            	<label class="col-sm-2 control-label">技术负责人意见说明：</label>
	            	<div class="col-sm-10" data-bind="with: appraisalReviseVm">
	                    <textarea class="form-control" data-bind="value: techAuditorOpinion"></textarea>
	                </div>
	            </div>
	        </div>
            <div class="approver3 form-group-margin">
	            <div class="form-group approver approverDiv">
	                <label class="col-sm-2 control-label approver approver-validation" data-name=".appraisal-institutions-radio"><span class="required-fields">*</span>鉴定机构负责人意见：</label>
	                <div class="col-sm-3 appraisal-institutions-radio">
	                    <div class="rdio rdio-primary">
	                        <input type="radio" name="radio3" value="0" id="radioAgree3">
	                        <label for="radioAgree3">同意</label>
	                    </div>
	                </div>
	                <div class="col-sm-3 appraisal-institutions-radio">
	                    <div class="rdio rdio-primary">
	                        <input type="radio" name="radio3" value="1" id="radioDisagree3">
	                        <label for="radioDisagree3">不同意</label>
	                    </div>
	                </div>
	            </div>
	            <div class="form-group approverDiv">
	            	<label class="col-sm-2 control-label center">鉴定机构负责人<br>意见说明：</label>
	            	<div class="col-sm-10" data-bind="with: appraisalReviseVm">
	                    <textarea class="form-control" data-bind="value: approverOpinion"></textarea>
	                </div>
	            </div>
            </div>
        </form>
    </div>
    <div class="btn-content">
        <button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
        <button class="btn btn-color1 notAppraisement" data-bind ="click : saveData"><i class="fa fa-check"></i>提交</button>
        <button type="button" class="btn btn-primary haveAppraisement" data-toggle="modal" data-target=".bs-example-modal-lg">填写鉴定事项</button>
    </div>
    
	<div class="modal fade bs-example-modal-lg" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  		<div class="modal-dialog modal-lg" role="document">
    		<div class="modal-content">
      			<div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        			<h4 class="modal-title" id="myModalLabel">鉴定事项</h4>
      			</div>
      			<div class="modal-body">
                    <div class="matter-content jiandingshixiang">
                        <div class="matter-module">
                            <div class="matter-module-title">1.委托项目选择：</div>
                            <div class="matter-module-option scope">
                                <div class="col-sm-4">
                                    <div class="ckbox ckbox-primary">
                                        <input type="checkbox" value="0" id="checkbox1" />
                                        <label for="checkbox1">提取固定电子数据</label>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="ckbox ckbox-primary">
                                        <input type="checkbox" value="1" id="checkbox2" />
                                        <label for="checkbox2">恢复电子数据</label>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="ckbox ckbox-primary">
                                        <input type="checkbox" value="2" id="checkbox3" />
                                        <label for="checkbox3">检验程序功能</label>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="ckbox ckbox-primary">
                                        <input type="checkbox" value="3" id="checkbox4" />
                                        <label for="checkbox4">破解电子数据密码</label>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="ckbox ckbox-primary">
                                        <input type="checkbox" value="4" id="checkbox5" />
                                        <label for="checkbox5">分析电子数据</label>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="ckbox ckbox-primary">
                                        <input type="checkbox" value="5" id="checkbox6" />
                                        <label for="checkbox6">销毁电子数据</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="matter-module">
                            <div class="matter-module-title">2.方法选择：</div>
                            <div class="matter-module-option method">
                                <div class="col-sm-12">
                                    <div class="ckbox ckbox-primary">
                                        <input type="checkbox" value="0" id="checkbox7" />
                                        <label for="checkbox7">《数字化设备证据数据发现提取固定方法》GA/T756-2008</label>
                                    </div>
                                </div>
                                <div class="col-sm-12">
                                    <div class="ckbox ckbox-primary">
                                        <input type="checkbox" value="1" id="checkbox8" />
                                        <label for="checkbox8">《电子物证搜索检验技术规范》GB/T29362-2012</label>
                                    </div>
                                </div>
                                <div class="col-sm-12">
                                    <div class="ckbox ckbox-primary">
                                        <input type="checkbox" value="2" id="checkbox9" />
                                        <label for="checkbox9">《电子物证恢复检验技术规范》GB/T29360-2012</label>
                                    </div>
                                </div>
                                <div class="col-sm-12 other-position">
                                    <div class="ckbox ckbox-primary">
                                        <input type="checkbox" value="3" id="checkbox10" />
                                        <label for="checkbox10">其他</label>
                                    </div>
                                    <div data-bind="with:appraisalitemDataVm">
                                        <input type="text" value="" data-bind="value:methodOther" class="other-input" />
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="matter-module ">
                            <div class="matter-module-title">3.结果要求：</div>
                            <div class="matter-module-option rqmt">
                                <div class="col-sm-4">
                                    <div class="ckbox ckbox-primary">
                                        <input type="checkbox" value="0" id="checkbox11" />
                                        <label for="checkbox11">出具检验报告</label>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="ckbox ckbox-primary">
                                        <input type="checkbox" value="1" id="checkbox12" />
                                        <label for="checkbox12">出具鉴定意见书</label>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="ckbox ckbox-primary">
                                        <input type="checkbox" value="2" id="checkbox13" />
                                        <label for="checkbox13">只提取电子数据</label>
                                    </div>
                                </div>
                                <div class="col-sm-12 other-position">
                                    <div class="ckbox ckbox-primary">
                                        <input type="checkbox" value="4" id="checkbox14" />
                                        <label for="checkbox14">其他</label>
                                    </div>
                                    <div data-bind="with:appraisalitemDataVm">
                                         <input type="text" value="" data-bind="value:rqmtOther" class="other-input" />
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
      			</div>
      			<div class="modal-footer">
        			<button type="button" class="btn btn-primary" data-bind ="click : saveData">确定</button>
        			<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
      			</div>
    		</div>
  		</div>
	</div>
    
    <jsp:include page="/common/alertMessages.jsp"></jsp:include>
    <script>
        $(function(){ 
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
			//时间控件数据绑定-----------结束 
        	
        	appraisalReviseData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/AppraisalRevise/loadAppraisalReviseData.do", { "id":"${param.id}" });
			var method = appraisalReviseData.method;
            if(method == '0'){
            	  $(".method").val("原件杠改盖章");
            }else if(method == '1'){
            	  $(".method").val("收回原件，重新出具鉴定文书");
            }
			var appraisalReviseDataVm = ko.mapping.fromJS(appraisalReviseData);
		
            var appraisalitemData =  loadData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisalitem/getDataById.do", { "id":"" });
			appraisalitemDataVm = ko.mapping.fromJS(appraisalitemData);
			
			var reviseEntrusterData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisalReviseEntruster/loadlistByAppraisalReviseAppIdData.do", { "appraisalReviseAppId":appraisalReviseData.id });
			if(reviseEntrusterData.length > 0){
				$(".entrusterUserAlias").val(reviseEntrusterData[0].userAlias);
			}
			
            var appraisalReviseStatus = appraisalReviseData.status;
			if(appraisalReviseStatus == 1){
				//审批人隐藏techDiv
				$(".tech2").hide();
				//实验室负责人隐藏approverDiv 
				$(".approver3").hide();
				$(".haveAppraisement").hide();
			}else if(appraisalReviseStatus == 2){
				$(".auth-validation").removeClass("input-choose");
				$(".tech-validation").addClass("input-choose");
				$(".auth1").find("input[type='text'], textarea").attr("readonly",true); 
		        $(".auth1").find("input[type='radio'], input[type='checkbox'], select").attr("disabled",true); 
		       // $(".authradio").hide();
		       //显示授权签字人的意见
		       $("#radioAgree1").attr("checked", true);
				//实验室负责人隐藏
				$(".approver3").hide();
				if(appraisalReviseData.method == 1){
				  $(".notAppraisement").hide();
				}else if(appraisalReviseData.method == 0){
					$(".haveAppraisement").hide();
				}
			}else if(appraisalReviseStatus == 3){
				//$(".authradio").hide();
				//$(".techradio").hide();
				//显示授权签字人的意见
				$("#radioAgree1").attr("checked", true);
				//显示技术负责人的意见
				$("#radioAgree2").attr("checked", true);
				
				$(".auth-validation").removeClass("input-choose");
				$(".approver-validation").addClass("input-choose");
				$(".auth1").find("input[type='text'], textarea").attr("readonly",true); 
		        $(".auth1").find("input[type='radio'], input[type='checkbox'], select").attr("disabled",true);
		    	$(".tech2").find("input[type='text'], textarea").attr("readonly",true); 
		        $(".tech2").find("input[type='radio'], input[type='checkbox'], select").attr("disabled",true);
				$(".haveAppraisement").hide();
			}
            var vm={
    	    		appraisalReviseVm:appraisalReviseDataVm,
    	    		appraisalitemVm:appraisalitemDataVm
    	    };
    	    
    	    vm.saveData = function(){  	
    	    	$("button").attr("disabled", true);
    	        if ( validateSubmittedData() ) {
    	        	if(appraisalReviseStatus == 1){
    	        		bindAuthDataVM();
    	        	}else if(appraisalReviseStatus == 2){
    	        		bindTechDataVM();
    	        	}else if(appraisalReviseStatus == 3){
    	        		bindApproverDataVM();
    	        	}
     	        	if (saveData("${pageContext.request.contextPath}/elecEVIDMgt/AppraisalRevise/saveAppraisalReviseData.do", appraisalReviseDataVm)) {
     	        		if(appraisalReviseData.method == 1){
     	        			if(saveData("${pageContext.request.contextPath}/elecEVIDMgt/appraisalitem/saveData.do", appraisalitemDataVm)){
         	        			saveSuccess("${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/modifyClericalApprovalList.do");
         	 				}else{
         	 					saveFailure("数据保存失败！");
         	 				}
     	 				}else{
     	 					saveSuccess("${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/modifyClericalApprovalList.do");
     	 				} 
    				}else{
    					saveFailure("数据保存失败！");
    				}
    	        } else {
    	        	saveFailure();
    	        } 
    	    }
        	
    	    function bindAuthDataVM(){
    	    	appraisalReviseDataVm.authAuditorId = "${sessionScope.loginUser.userId}";
    	    	appraisalReviseDataVm.authAuditorName="${sessionScope.loginUser.userName}";
    	    	appraisalReviseDataVm.authAuditorAlias="${sessionScope.loginUser.userAlias}";
    	    	var status = $(".auth").find("input[type='radio']:checked").val();
    	    	if(status == 0){
    	    		appraisalReviseDataVm.status = 2 ;
    	    	}else if(status == 1){
    	    		appraisalReviseDataVm.status = 5 ;
    	    	}
    	    }
    	    
    	    function bindTechDataVM(){
    	    	
    	    	if(appraisalReviseData.method == 1){
    	    		//委托项目
        			appraisalitemDataVm.scope = getScope();
        			//鉴定方法
        			appraisalitemDataVm.method = getMethod()
        			//结果要求
        			appraisalitemDataVm.rqmt = getRqmt();
        			appraisalitemDataVm.appraisalReviseId = appraisalReviseData.id;
        			appraisalitemDataVm.appraisalId = appraisalReviseData.appraisalId;
        			
  				} 
    	    	
    	    	appraisalReviseDataVm.techAuditorId = "${sessionScope.loginUser.userId}";
    	    	appraisalReviseDataVm.techAuditorName="${sessionScope.loginUser.userName}";
    	    	appraisalReviseDataVm.techAuditorAlias="${sessionScope.loginUser.userAlias}";
    	    	var status = $(".tech").find("input[type='radio']:checked").val();
    	    	if(status == 0){
    	    		appraisalReviseDataVm.status = 3 ;
    	    	}else if(status == 1){
    	    		appraisalReviseDataVm.status = 5 ;
    	    	}
    	    }
    	    
    	    function bindApproverDataVM(){
    	    	 
    	      	appraisalReviseDataVm.approverId = "${sessionScope.loginUser.userId}";
    	    	appraisalReviseDataVm.approverName="${sessionScope.loginUser.userName}";
    	    	appraisalReviseDataVm.approverAlias="${sessionScope.loginUser.userAlias}";
    	    	var status = $(".approver").find("input[type='radio']:checked").val();
    	    	if(status == 0){
    	    		if(appraisalReviseData.method == 0){
    	    			appraisalReviseDataVm.status = 4 ;
        	    	}else if(appraisalReviseData.method == 1){
        	    		appraisalReviseDataVm.status = 7 ;
        	    	}
    	    	}else if(status == 1){
    	    		appraisalReviseDataVm.status = 5 ;
    	    	}
    	    	
    	    }
        	
    	    ko.applyBindings(vm);
        });
        
        
        function getScope(){
	    	var value='';
	    	var inputType = $(".jiandingshixiang").find(".scope").find("input[type='checkbox']");
	    	for( var i = 0; i < inputType.size(); i++ ){
 	    		if( inputType.eq(i).prop("checked") ){
    				value += inputType.eq(i).val()+",";
    			} 
	    	}
	    	return value; 
	    }
	    
	    function getMethod(){
	    	var value='';
	    	var inputType = $(".jiandingshixiang").find(".method").find("input[type='checkbox']");
	    	for( var i = 0; i < inputType.size(); i++ ){
 	    		if( inputType.eq(i).prop("checked") ){
    				value += inputType.eq(i).val()+",";
    			} 
	    	}
	    	return value; 
	    };
	    
	    function getRqmt(){
	    	var value='';
	    	var inputType = $(".jiandingshixiang").find(".rqmt").find("input[type='checkbox']");
	    	for( var i = 0; i < inputType.size(); i++ ){
 	    		if( inputType.eq(i).prop("checked") ){
    				value += inputType.eq(i).val()+",";
    			} 
	    	} 
	    	return value; 
	    };
	    
    	$("#radioAgree2").click(function(){
    		if(appraisalReviseData.method == 1){
	    		$(".notAppraisement").hide();
	    		$(".haveAppraisement").show();
    		}
    	});
    	
		$("#radioDisagree2").click(function(){
			$(".haveAppraisement").hide();
    		$(".notAppraisement").show();
    	});
    
        $(".back-btn").click(function(){
	    	var url = "${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/modifyClericalApprovalList.do";
	    	$(".index-iframe", window.parent.document).attr("src",url);
	    }); 
        $(".tabs-nav li").click(function(){
    		var aClass = $(this).find("a").attr("class");
    		if( aClass == "register" ){
    			if( $(".iframe-"+aClass).attr("src") == "" ){
    				var src = "${pageContext.request.contextPath}/elecEVIDMgt/registerInfoView.do?commonPreappraisalId="+appraisalReviseData.preappraisalId;
    				$(".iframe-"+aClass).attr("src", src);
    				$(".iframe-"+aClass).load(function(){
    		            var mainheight = $(this).contents().find("body").height()+30;
    		            $(this).height(mainheight);
    		        });
    			}
    		}else if( aClass == "accepted" ){
    			if( $(".iframe-"+aClass).attr("src") == "" ){
    				var src = "${pageContext.request.contextPath}/elecEVIDMgt/physicalEvidenceAcceptView.do?commonAppraisalId="+appraisalReviseData.appraisalId;
    				$(".iframe-"+aClass).attr("src", src);
    				$(".iframe-"+aClass).load(function(){
    		            var mainheight = $(this).contents().find("body").height()+30;
    		            $(this).height(mainheight);
    		        });
    			}
    		}else if( aClass == "" ){
    			if( $(".iframe-"+aClass).attr("src") == "" ){
    				var src = "${pageContext.request.contextPath}/elecEVIDMgt/InfoView.do?commonAppraisalId="+appraisalReviseData.appraisalId;
    				$(".iframe-"+aClass).attr("src", src);
    				$(".iframe-"+aClass).load(function(){
    		            var mainheight = $(this).contents().find("body").height()+30;
    		            $(this).height(mainheight);
    		        });
    			}
    		}else if( aClass == "warehousing" ){
    			if( $(".iframe-"+aClass).attr("src") == "" ){
    				var src = "${pageContext.request.contextPath}/elecEVIDMgt/physicalEvidenceStorageView.do?commonAppraisalId="+appraisalReviseData.appraisalId;
    				$(".iframe-"+aClass).attr("src", src);
    				$(".iframe-"+aClass).load(function(){
    		            var mainheight = $(this).contents().find("body").height()+30;
    		            $(this).height(mainheight);
    		        });
    			}
    		}
    	});
    </script>
</body>
</html>