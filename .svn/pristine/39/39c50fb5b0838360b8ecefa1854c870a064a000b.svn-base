<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>电子物证管理-管理人员操作台-检材审核-审核</title>
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
  	<script src="<c:url value="/resources/frameworks/pangolin/js/workflow/workflow.js" />"></script>
  	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
  	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>电子物证管理</a><span>></span><a>管理人员操作台</a><span>></span><a>检材审核</a><span>></span><a>审核</a>
        </p>
    </div>
    <jsp:include page="/common/tabsContent.jsp"></jsp:include>
     <div class="tabs-list" id="register">
    	<iframe class="iframe-page iframe-register" src=""></iframe>
    </div>
    <div class="tabs-list" id="accepted">
    	<iframe class="iframe-page iframe-accepted" src=""></iframe>
    </div>  
    <div class="tabs-list" id="check">
    	<div class="form-module">
	        <div class="form-module-title">
	            <p>检材审核</p>
	        </div>
	        <div class="form-content">
	            <form class="form-horizontal">
	                <div class="form-group">
	                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>鉴定事项：</label>
	                    <div class="col-sm-10">
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
	                                        <div data-bind="with:appraisalVm">
	                                            <input type="text" value="" data-bind="value:methodOther" class="other-input" />
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                            <div class="matter-module">
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
	                                        <div data-bind="with:appraisalVm">
	                                             <input type="text" value="" data-bind="value:rqmtOther" class="other-input" />
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	              <!--   <div class="form-group" >
	                    <label class="col-sm-2 control-label">审核时间：</label>
	                    <div class="col-sm-4" data-bind="with:appraisalVm">
	                        <input type="text" data-bind="dateTimePicker:auditedDate" class="form-control datetimepicker" />
	                    </div>
	                </div> -->
	                <div class="form-group">
	                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>审核意见：</label>
	                    <div class="col-sm-10" data-bind="with:appraisalVm">
	                        <textarea class="form-control" data-bind="value:auditedOpinion" required></textarea>
	                    </div>
	                </div>
	            </form>
	        </div>
	    </div>
	    <div class="btn-content">
	        <button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
	        <button class="btn btn-color1" data-bind="click: passData"><i class="fa fa-check"></i>通过</button>
	        <button class="btn btn-color1" data-toggle="modal" data-target=".bs-example-modal-lg"><i class="fa fa-times"></i>拒绝</button>
	        <!-- data-bind="click: refuseData" -->
	    </div>
    </div>

	<div class="modal fade bs-example-modal-lg" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  	<div class="modal-dialog modal-lg" role="document">
		    <div class="modal-content">
		      	<div class="modal-header">
		        	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        	<h4 class="modal-title" id="myModalLabel">拒绝情况</h4>
		      	</div>
		      	<div class="modal-body">
		        	<div class="form-content">
				        <form class="form-horizontal">
				   			<div class="form-group">
						    	<label class="col-sm-2 control-label">委托单位：</label>
						       	<div class="col-sm-4" data-bind="with:appraisalVm" >
						           	<input type="text" class="form-control" data-bind="value:orgName"  name="orgName" id="orgName" readonly/>
						       	</div>
						       	<label class="col-sm-2 control-label">送检人：</label>
						       	<div class="col-sm-4"  >
						        	<input type="text" class="form-control"  name="userAlias" id="userAlias" readonly/>
						       	</div>
				   			</div>
						   	<div class="form-group">
						    	<label class="col-sm-2 control-label">证件名称：</label>
						       	<div class="col-sm-4">
						           	<input type="text" class="form-control" value="警察证" readonly/>
						       	</div>
						       	<label class="col-sm-2 control-label">证件号码：</label>
						       	<div class="col-sm-4" >
						        	<input type="text" class="form-control" name="policeId" id="policeId" readonly/>
						       	</div>
				   			</div>
				   			<div class="form-group">
						    	<label class="col-sm-2 control-label">案件名称：</label>
						       	<div class="col-sm-4" data-bind="with:appraisalVm">
						           	<input type="text" class="form-control"  data-bind="value:caseName" name="caseName" id="caseName" readonly/>
						       	</div>
						       	<label class="col-sm-2 control-label">案件编号：</label>
						       	<div class="col-sm-4" data-bind="with:appraisalVm">
						        	<input type="text" class="form-control" data-bind="value:caseSn" name="caseSn" id="caseSn" readonly/>
						       	</div>
				   			</div>
				   			<div class="form-group">
						    	<label class="col-sm-2 control-label"><span class="required-fields">*</span>不予受理理由：</label>
						       	<div class="col-sm-10" >
						       		<div class="suspension-reason" data-bind="with:dismissalNoticeVm" >
						       			<div>根据《公安机关鉴定规则》第<input type="text"  name="article" id="article" data-bind="value:article" class="reason-input input-short-width" />条
						       			<input name="paragraph" id="paragraph" data-bind="value:paragraph" type="text" class="reason-input input-short-width" />款之规定，</div>
						       			<div>因<input type="text" name="reason" id="reason" data-bind="value:reason" class="reason-input input-long-width" />，故不予受理。</div>
						       		</div>
						       	</div>
				   			</div>
				   			<div class="form-group">
						    	<label class="col-sm-2 control-label">填表人：</label>
						       	<div class="col-sm-4" data-bind="with:dismissalNoticeVm" >
						           	<input type="text"  name="creatorAlias" id="creatorAlias" data-bind="value:creatorAlias" class="form-control" readonly/>
						       	</div>
				   			</div>
				        </form>
				    </div>
		      	</div>
		      	<div class="modal-footer">
		        	<button type="button" class="btn btn-primary" data-bind="click: refuseData">确定</button>
		        	<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		      	</div>
		    </div>
	  	</div>
	</div>
    
    <jsp:include page="/common/alertMessages.jsp"></jsp:include>
    <script>
    initWorkflow("${pageContext.request.contextPath}"); //初始化工作流
    
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
		//时间控件数据绑定-----------结束 
    	
    	 appraisalData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/loadDataById.do",{ "id" : "${param.id}" });
	    var appraisalDataVm = ko.mapping.fromJS(appraisalData);
	    
	    var preappraisalEntrusterData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/preappraisalEntruster/getPreappraisalEntrusterListBypreappraisalId.do",{ "preappraisalId" : appraisalData.preappraisalId });
	   
	    if(preappraisalEntrusterData.length > 0){
	    	var entruster = preappraisalEntrusterData[0];
	    	$("#userAlias").val(entruster.userAlias);
	    	$("#policeId").val(entruster.policeId);
	    }
	     
	    
	    appraisalDataVm.auditedDate = new Date();
	    var dismissalNoticeData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/dismissalNotice/getDataById.do",{ "id" : "" });
 	    dismissalNoticeData.creatorId = "${sessionScope.loginUser.userId}";
	    dismissalNoticeData.creatorName = "${sessionScope.loginUser.userName}";
	    dismissalNoticeData.creatorAlias = "${sessionScope.loginUser.userAlias}";
	    var dismissalNoticeDataVm = ko.mapping.fromJS(dismissalNoticeData);
	    
	    
	    var vm={
	    		appraisalVm : appraisalDataVm,
	    		dismissalNoticeVm : dismissalNoticeDataVm
	    };
	    
	    vm.passData = function(){
	    	$("button").attr("disabled", true);	    		    	
	    	if(!$(".matter-module .scope").find("input:checked").val()){
	    		saveFailure('"委托项目选择：" 不能为空。');
	    		return false;
	    	}
	    	if(!$(".matter-module .method").find("input:checked").val()){
	    		saveFailure('"方法选择：" 不能为空。');
	    		return false;
	    	}
	    	if(!$(".matter-module .rqmt").find("input:checked").val()){
	    		saveFailure('"结果要求：" 不能为空。');
	    		return false;
	    	}
	        if ( validateSubmittedData() ) {
	        	bindPassDataVM();
	        	if (saveData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/saveData.do", appraisalDataVm)) {
	        		createTask(appraisalDataVm.id); //构建工作项
					saveSuccess("${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/examinationOfMaterialsList.do");
				} else {
					saveFailure("保存失败！");
				}
	        } else {
	        	saveFailure();
	        } 
	    }
	    
	    vm.refuseData = function(){ 
	    	$("button").attr("disabled", true);
	    	var num = 0;
	    	$(".suspension-reason input").each(function(){
	    		if( $(this).val() == "" ){
	    			num++;
	    		}
	    	});
	    	
	        if ( num == 0 ) {
	        	bindRefuseDataVM();
	        	if (saveData("${pageContext.request.contextPath}/elecEVIDMgt/dismissalNotice/saveData.do", dismissalNoticeDataVm)) {
	        		if(saveData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/saveData.do", appraisalDataVm)){
	        			createTask(appraisalDataVm.id); //构建工作项
	        			saveSuccess("${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/examinationOfMaterialsList.do");
	        		}else{
	        			saveFailure("保存失败！");
	        		}
				} else {
					saveFailure("保存失败！");
				}
	        } else {
	        	saveFailure("“不予受理理由：”不能漏填或不填。");
	        	
	        } 
	    }
	    
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
	    
	    
		function bindPassDataVM(){ 
			appraisalDataVm.auditorId = "${sessionScope.loginUser.userId}";
			appraisalDataVm.auditorName = "${sessionScope.loginUser.userName}";
			appraisalDataVm.auditorAlias = "${sessionScope.loginUser.userAlias}";
			//委托项目
			appraisalDataVm.scope = getScope();
			//鉴定方法
			appraisalDataVm.method = getMethod()
			//结果要求
			appraisalDataVm.rqmt = getRqmt();
			appraisalDataVm.status=4;
		} 
		function bindRefuseDataVM(){ 
			appraisalDataVm.auditorId="${sessionScope.loginUser.userId}";
			appraisalDataVm.auditorName="${sessionScope.loginUser.userName}";
			appraisalDataVm.auditorAlias="${sessionScope.loginUser.userAlias}";
			appraisalDataVm.status=3;
			dismissalNoticeDataVm.appraisalId = appraisalData.id;
			dismissalNoticeDataVm.preappraisalId = appraisalData.preappraisalId;
		} 
	    ko.applyBindings(vm);
    })
     
	    /* 标签页事件和样式-开始 */
		var clickStatus = 2;	//点击状态
		var dataStatus = 2;		//数据状态
		tabsContent(clickStatus,dataStatus);
		/* 标签页事件和样式-结束  */
        
        $(".back-btn").click(function(){
	    	var url = "${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/examinationOfMaterialsList.do";
	    	$(".index-iframe", window.parent.document).attr("src",url);
	    });
		
        $(".tabs-nav li").click(function(){
    		var aClass = $(this).find("a").attr("class");
    		if( aClass == "register" ){
    			if( $(".iframe-"+aClass).attr("src") == "" ){
    				var src = "${pageContext.request.contextPath}/elecEVIDMgt/registerInfoView.do?commonPreappraisalId="+appraisalData.preappraisalId;
    				$(".iframe-"+aClass).attr("src", src);
    				$(".iframe-"+aClass).load(function(){
    		            var mainheight = $(this).contents().find("body").height()+30;
    		            $(this).height(mainheight);
    		        });
    			}
    		}else if( aClass == "accepted" ){
    			if( $(".iframe-"+aClass).attr("src") == "" ){
    				var src = "${pageContext.request.contextPath}/elecEVIDMgt/physicalEvidenceAcceptView.do?commonAppraisalId="+"${param.id}";
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