<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>电子物证管理-管理人员操作台-鉴定分配-分配</title>
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
  	<script src="<c:url value="/resources/javascript/jsMap.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/base.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/jquery-barcode.js" />"></script>
  	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
  	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/deviceMgt/deviceMgt-form.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>电子物证管理</a><span>></span><a>管理人员操作台</a><span>></span><a>鉴定分配</a><span>></span><a>分配</a>
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
    	<iframe class="iframe-page iframe-check" src=""></iframe>
    </div>  
    <div class="tabs-list" id="warehousing">
    	<iframe class="iframe-page iframe-warehousing" src=""></iframe>
    </div>  
    <div class="tabs-list" id="process">
    	<div class="form-module">
	        <div class="form-module-title">
	            <p>鉴定分配</p>
	        </div>
	        <div class="form-content">
	            <form class="form-horizontal">
	              <!--   <div class="form-group">
	                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>分配时间：</label>
	                    <div class="col-sm-4" data-bind="with:appraisalVm">
	                        <input type="text" class="form-control datetimepicker" data-bind="dateTimePicker:allocationDate" required />
	                    </div>
	                </div> -->
	                <!-- <div class="form-group">
	                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>预计开始时间：</label>
	                    <div class="col-sm-4" data-bind="with:appraisalVm">
	                        <input type="text" class="form-control datetimepicker datetimepicker-before"  data-bind="dateTimePicker:planedStartDate" required />
	                    </div>
	                    <label class="col-sm-2 control-label">截止时间：</label>
	                    <div class="col-sm-4" data-bind="with:appraisalVm">
	                        <input type="text" class="form-control datetimepicker datetimepicker-after" data-bind="dateTimePicker:planedEndDate" />
	                    </div>
	                </div> -->
	                <div class="form-group">
	                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>鉴定事项安排：</label>
	                    <div class="col-sm-10">
	                        <div class="matter-content majorContent">
	                            <div class="matter-module">
	                                <div class="matter-module-title">鉴定专业：</div>
	                                <div class="matter-module-option major">
	                                    <div class="col-sm-3">
	                                        <div class="ckbox ckbox-primary ">
	                                            <input type="checkbox" name="checkboxProfession" value="3" id="profession4">
	                                            <label for="profession4">数据提取固定</label>
	                                        </div>
	                                    </div>
	                                    <div class="col-sm-3">
	                                        <div class="ckbox ckbox-primary">
	                                            <input type="checkbox" name="checkboxProfession" value="0" id="profession1">
	                                            <label for="profession1">数据恢复</label>
	                                        </div>
	                                    </div>
	                                    <div class="col-sm-3">
	                                        <div class="ckbox ckbox-primary">
	                                            <input type="checkbox" name="checkboxProfession" value="1" id="profession2">
	                                            <label for="profession2">数据分析</label>
	                                        </div>
	                                    </div>
	                                    <div class="col-sm-3">
	                                        <div class="ckbox ckbox-primary">
	                                            <input type="checkbox" name="checkboxProfession" value="2" id="profession3">
	                                            <label for="profession3">系统分析</label>
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                            <div class="matter-module">
	                                <div class="matter-module-title">鉴定人员：</div>
	                                <div class="matter-module-option personalOption">
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </form>
	        </div>
	    </div>
	    <div class="btn-content">
	        <button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
	        <button class="btn btn-color1" data-bind="click: saveData" ><i class="fa fa-check"></i>提交</button>
	    </div>
    </div>
    <%-- <div class="tabs-list" id="leave">
    	<jsp:include page="/common/physicalEvidenceOutView.jsp"></jsp:include>
    </div> --%>
    <jsp:include page="/common/alertMessages.jsp"></jsp:include>
    <script>
	    var personMap= new Map();
	    //加入 
	    function addObject(key, value) {  
	 		if ( !doesItExist(key) ) { 
	 			personMap.put(key, value);
	 			return true;
	 		}
	 		return false;
	 	}
	  	
	 	//是否存在 
	 	function doesItExist(key) {
	 		return personMap.containsKey(key);
	 	}
	  	
	 	//删除 
	 	function map(key) {
	 		personMap.remove(key);
	 	}
	 	
	 	//通过key获取
	 	function getObject(key) {
	 		personMap.get(key);
	 	}
	
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
	    	
	    	/* 标签页事件和样式-开始 */
			var clickStatus = 4;	//点击状态
			var dataStatus = 4;		//数据状态
			tabsContent(clickStatus,dataStatus);
			/* 标签页事件和样式-结束  */
			
			//条形码
			var barCodeid = $("#bcTarget");
			var value = barCodeid.siblings(".bar-code-input").val();
			code(barCodeid, value);
	    	
	        $(".back-btn").click(function(){
		    	var url = "${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/identificationAllocationList.do";
		    	$(".index-iframe", window.parent.document).attr("src",url);
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
	    	
	     	loadExpert();
	    	
	    	 appraisalData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/loadDataById.do",{ "id" : "${param.id}" });
		    var appraisalDataVm = ko.mapping.fromJS(appraisalData);
		    appraisalDataVm.allocationDate = new Date();
		    var vm={
		    		appraisalVm:appraisalDataVm 
		    };
		    
		    vm.saveData = function(){  	
		    	$("button").attr("disabled", true);		    	
		        if ( validateSubmittedData() ) {
		        	if(!$(".matter-module .major").find("input:checked").val()){
			    		saveFailure('"鉴定专业：" 不能为空。');
			    		return false;
			    	}
			    	if(!$(".matter-module .personalOption").find("input:checked").val()){
			    		saveFailure('"鉴定人员：" 不能为空。');
			    		return false;
			    	}
		        	bindDataVM();
		        	if (saveData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/saveData.do", appraisalDataVm)) {
		        		var appraiserId = $(".personalOption").find("input[type='radio']:checked").val();
					    var person = personMap.get(appraiserId);
					    var sitn =new Object();
					    sitn.appraiserId = appraiserId;
					    sitn.appraisalId = appraisalData.id;
						if(saveData("${pageContext.request.contextPath}/elecMgt/sppraisalSitn/saveData.do",sitn)){
		        			saveSuccess("${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/identificationAllocationList.do");
						} else {
							saveFailure('保存失败');
						} 
					} else {
						saveFailure('保存失败');
					}
		        } else {
		        	saveFailure('保存失败');
		        } 
		    }
		    
		   
			function bindDataVM(){ 
				//分配人
				appraisalDataVm.assignerId="${sessionScope.loginUser.userId}";
				appraisalDataVm.assignerName="${sessionScope.loginUser.userName}";
				appraisalDataVm.assignerAlias="${sessionScope.loginUser.userAlias}";
				//鉴定师
				appraisalDataVm.major = getMajor();
				var appraiserId = $(".personalOption").find("input[type='radio']:checked").val();
				var person = personMap.get(appraiserId);
				appraisalDataVm.appraiserId = person.userId;
				appraisalDataVm.appraiserAlias = person.userAlias;
				appraisalDataVm.appraiserName = person.userName;
			
				appraisalDataVm.status=6;
			}  
		    ko.applyBindings(vm);
	    });
	    
	    function getMajor(){
	    	var value='';
	    	var inputType = $(".majorContent").find(".major").find("input[type='checkbox']");
	    	for( var i = 0; i < inputType.size(); i++ ){
 	    		if( inputType.eq(i).prop("checked") ){
    				value += inputType.eq(i).val()+",";
    			} 
	    	}
	    	return value; 
	    };
	    
	    function loadExpert(){
	    	var expertData = loadData("${pageContext.request.contextPath}/system/user/getSitnUserData.do",{ roleLabel : "ROLE_APPRAISER" });
	        var html='';
	        if(expertData.length>0){
	        	for(var i = 0;i<expertData.length ;i++){
	        		html+='<div class="col-sm-4"><div class="rdio rdio-primary"><input type="radio" name="radioPersonnel" value="'+expertData[i].userId+'" id="personnel'+i+'"><label for="personnel'+i+'">'+expertData[i].userAlias+'</label></div></div>';
	        		addObject(expertData[i].userId,expertData[i]);
	        	};
	        	$(".personalOption").append(html);
	        }
	    }
    
	  	//自动生成条形码
		function code(id, value){
			id.empty().barcode(value, "code128",{barWidth:1, barHeight:30,showHRI:false});
			id.siblings(".bar-code-text").html(value);
		}
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
    		}else if( aClass == "check" ){
    			if( $(".iframe-"+aClass).attr("src") == "" ){
    				var src = "${pageContext.request.contextPath}/elecEVIDMgt/checkInfoView.do?commonAppraisalId="+"${param.id}";
    				$(".iframe-"+aClass).attr("src", src);
    				$(".iframe-"+aClass).load(function(){
    		            var mainheight = $(this).contents().find("body").height()+30;
    		            $(this).height(mainheight);
    		        });
    			}
    		}else if( aClass == "warehousing" ){
    			if( $(".iframe-"+aClass).attr("src") == "" ){
    				var src = "${pageContext.request.contextPath}/elecEVIDMgt/physicalEvidenceStorageView.do?commonAppraisalId="+"${param.id}";
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