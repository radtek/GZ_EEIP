<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>电子物证管理-管理人员操作台-文书审批-审批</title>
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
   	<script src="<c:url value="/resources/javascript/jsMap.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/base.js" />"></script>
  	
    <link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>电子物证管理</a><span>></span><a>管理人员操作台</a><span>></span><a>文书审批</a><span>></span><a>审批</a>
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
	            <p>文书整理</p>
	        </div>
	        <div class="form-content">
	            <form class="form-horizontal">
	            	<div class="form-group">
	                    <label class="col-sm-2 control-label">鉴定视频：</label>
	                    <div class="col-sm-10">
	                         <div class="form-control video-content">
	                        	<a class="video-btn video-view" href="${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/videoPlaybackPage.do" target="_blank"><i class="fa fa-play-circle-o"></i></a>
	                        </div>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="col-sm-2 control-label">文书列表：</label>
	                    <div class="col-sm-10">
	                        <div class="document-content docDiv">
	                           <!--   <div class="document-style"><span>物证鉴定档案</span></div>
	                            <div class="document-style"><span>鉴定文书档案目录</span></div>
	                            <div class="document-style"><span>鉴定文书副本</span></div>
	                            <div class="document-style"><span>鉴定文书审批表</span></div>
	                            <div class="document-style"><span>鉴定委托书</span></div>
	                            <div class="document-style"><span>鉴定事项确认书</span></div>
	                            <div class="document-style"><span>电子物证检验原始记录</span></div> --> 
	                        </div>
	                    </div>
	                </div>
	            </form>
	        </div>
	    </div>
	    <div class="form-module">
	        <div class="form-module-title">
	            <p>文书审批</p>
	        </div>
	        <div class="form-title">鉴定文书审批表</div>
	        <div class="form-content">
		        <form class="form-horizontal">
			        <div class="verifier">
			            <div class="form-group">
			                <label class="col-sm-2 control-label"><span class="required-fields">*</span>委托单位：</label>
			                <div class="col-sm-10" data-bind="with:appraisalVm">
			                    <input type="text" class="form-control" data-bind="value:orgName" readonly required/>
			                </div>
			            </div>
			            <div class="form-group">
			                <label class="col-sm-2 control-label"><span class="required-fields">*</span>鉴定文书编号：</label>
			                <div class="col-sm-4">
			                    <input type="text" class="form-control reportSn" readonly required />
			                </div>
			                <label class="col-sm-2 control-label"><span class="required-fields">*</span>主办人：</label>
			                <div class="col-sm-4" data-bind="with:appraisalVm">
			                    <input type="text" class="form-control" data-bind="value:appraiserAlias" readonly required/>
			                </div>
			            </div>
			            <div class="form-group">
			                <label class="col-sm-2 control-label">复核人：</label>
			                <div class="col-sm-4" data-bind="with:appraisalVm">
			                    <input type="text" class="form-control" data-bind="value:reviewer" />
			                </div>
			                <label class="col-sm-2 control-label">复核时间：</label>
			                <div class="col-sm-4" data-bind="with:appraisalVm">
			                    <input type="text" class="form-control datetimepicker" data-bind="dateTimePicker:reviewerdDate" />
			                </div>
			            </div>
			            <div class="form-group issuedForm">
			                <label class="col-sm-2 control-label input-choose" data-name=".dispatch-form-radio"><span class="required-fields">*</span>发文形式：</label>
			                <!-- <span class="issuedForm"> -->
				                <div class="col-sm-3 dispatch-form-radio">
				                    <div class="rdio rdio-primary">
				                        <input type="radio" name="radioProfession" value="0" id="profession1">
				                        <label for="profession1">鉴定书</label>
				                    </div>
				                </div>
				                <div class="col-sm-3 dispatch-form-radio">
				                    <div class="rdio rdio-primary">
				                        <input type="radio" name="radioProfession" value="1" id="profession2">
				                        <label for="profession2">检验报告</label>
				                    </div>
				                </div>
				                <div class="col-sm-3 dispatch-form-radio">
				                    <div class="rdio rdio-primary">
				                        <input type="radio" name="radioProfession" value="2" id="profession3">
				                        <label for="profession3">检验意见书</label>
				                    </div>
				                </div>
			                <!-- </span> -->
			            </div>
			            <div class="form-group">
			            	<label class="col-sm-2 control-label"><span class="required-fields">*</span>数量(份)：</label>
			                <div class="col-sm-4" >
			                    <input type="number"  class="form-control issuedFormNum" required />
			                </div>
			            </div>
			            <div class="form-group">
			                <label class="col-sm-2 control-label input-choose" data-name=".attachment-checkbox"><span class="required-fields">*</span>附件：</label>
			                <div class="col-sm-10 attachment-checkbox">
			                    <div class="matter-content">
			                        <div class="matter-module">
			                            <div class="matter-module-option att">
			                                <div class="col-sm-4">
			                                    <div class="ckbox ckbox-primary">
			                                        <input type="checkbox" value="0" id="checkbox17" class="att0" />
			                                        <label for="checkbox17">鉴定委托书</label>
			                                    </div>
			                                </div>
			                                <div class="col-sm-4">
			                                    <div class="ckbox ckbox-primary">
			                                        <input type="checkbox" value="1" id="checkbox18" class="att1"/>
			                                        <label for="checkbox18">鉴定事项确认书</label>
			                                    </div>
			                                </div>
			                                <div class="col-sm-4">
			                                    <div class="ckbox ckbox-primary">
			                                        <input type="checkbox" value="2" id="checkbox19" class="att2"/>
			                                        <label for="checkbox19">检验记录</label>
			                                    </div>
			                                </div>
			                                <div class="col-sm-4">
			                                    <div class="ckbox ckbox-primary">
			                                        <input type="checkbox" value="3" id="checkbox20" class="att3"/>
			                                        <label for="checkbox20">检材照片</label>
			                                    </div>
			                                </div>
			                                <div class="col-sm-4">
			                                    <div class="ckbox ckbox-primary">
			                                        <input type="checkbox" value="4" id="checkbox15" class="att4"/>
			                                        <label for="checkbox15">提取数据</label>
			                                    </div>
			                                </div>
			                                <div class="col-sm-12 other-position">
			                                    <div class="ckbox ckbox-primary">
			                                        <input type="checkbox"  id="checkbox16" class="att5"/>
			                                        <label for="checkbox16">其他</label>
			                                    </div>
			                                    <span data-bind="with:appraisalVm">
			                                       <input type="text" value="" class="other-input" data-bind="value:attOther" />
			                                    </span>
			                                </div>
			                            </div>
			                        </div>
			                    </div>
			                </div>
			            </div>
			            <div class="form-group">
			                <label class="col-sm-2 control-label input-choose" data-name=".authorized-signatories-radio"><span class="required-fields">*</span>授权签字人意见：</label>
			                <div class="col-sm-3 sitnJudgement authorized-signatories-radio">
				                <div class="rdio rdio-primary">
				                    <input type="radio" name="radioProfession2" value="0" id="profession4">
				                    <label for="profession4">认可项目</label>
				                </div>
				            </div>
				            <div class="col-sm-3 sitnJudgement authorized-signatories-radio">
				                <div class="rdio rdio-primary">
				                    <input type="radio" name="radioProfession2" value="1" id="profession5">
				                    <label for="profession5">非认可项目</label>
				                </div>
				            </div>
				            <div class="col-sm-3 sitnJudgement authorized-signatories-radio">
				                <div class="rdio rdio-primary">
				                    <input type="radio" name="radioProfession2" value="2" id="profession6">
				                    <label for="profession6">符合委托方要求</label>
				                </div>
				            </div>
			            </div>
			            <div class="form-group">
			                <label class="col-sm-2 control-label"><span class="required-fields">*</span>授权签字人意见：</label>
			                <div class="col-sm-10" data-bind="with:appraisalVm">
			                    <textarea class="form-control" data-bind="value:verifierOpinion" required></textarea>
			                </div>
			            </div>
			             
		            </div>
		            <div class="approver form-group-margin">
			            <div class="form-group">
			                <label class="col-sm-2 control-label"><span class="required-fields">*</span>实验室负责人意见：</label>
			                <div class="col-sm-10" data-bind="with:appraisalVm">
			                    <textarea class="form-control approverOpinion" data-bind="value:approverOpinion"  ></textarea>
			                </div>
			            </div>
		            </div>
		            <div class="form-group form-group-margin">
		                <label class="col-sm-2 control-label">备注：</label>
		                <div class="col-sm-10" data-bind="with:appraisalVm">
		                    <textarea class="form-control" data-bind="value:comments"></textarea>
		                </div>
		            </div>
		        </form>
		    </div>
	    </div>
	    <div class="btn-content">
	        <button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
	        <button class="btn btn-color1 refer" data-bind="click: saveData" ><i class="fa fa-check"></i>提交</button>
	        <button class="btn btn-color1 pass" data-bind="click: saveData" ><i class="fa fa-check"></i>通过</button>
	        <button class="btn btn-color1 refuse" data-bind="click: refuseData" ><i class="fa fa-times"></i>拒绝</button>  
	     </div>
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
			//时间控件数据绑定-----------结束 
	        
	    	
	    	appraisalData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/loadDataById.do",{ "id" : "${param.id}" });
	    	 var appraisalStatus = appraisalData.status;
	    	 if(appraisalStatus == 11){
	    	    appraisalData.reviewer = '';
		    	appraisalData.reviewerdDate = null;
		    	appraisalData.verifierOpinion = '';
		    	appraisalData.comments = '';
	    	 }
	    	 
	    	 if(appraisalStatus == 12){
	    		 appraisalData.approverId = '';
			     appraisalData.approvedDate = null;
			     appraisalData.approverName = '';
			     appraisalData.approverAlias = '';
			     appraisalData.approverOpinion = '';
			     
				 setAtt(appraisalData.att);//鉴定文书审批表附件
				 setIssuedForm(appraisalData.issuedForm);//发文形式和数量
				 setSitnJudgement(appraisalData.sitnJudgement);//授权签字人意见
			    }
			
		    var appraisalDataVm = ko.mapping.fromJS(appraisalData);
		    
		    var videoSrc = '${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/videoPlaybackPage.do?id='+appraisalData.id;
		    $(".video-view").attr("href", videoSrc); 
		    
		   
		   
		    $(".reportSn").val(appraisalData.agency+'['+appraisalData.year+']'+appraisalData.sn);
		    
  		    //文书列表
		    var appraisalDocData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/AppraisalDoc/getListData.do",{ "appraisalId" : "${param.id}" });
		    var appraisalDocDataVm = ko.mapping.fromJS(appraisalDocData);
		    
 		    //绑定 文书
		    if(appraisalDocData.length>0){
		    	var html = '';
		    	for(var i = 0; i < appraisalDocData.length; i++ ){
		    		var type = appraisalDocData[i].type;
		    		switch(type)
		    		{
		    		case 2:
		    		   html+='<div class="document-style"><span data-type="2">物证鉴定档案封面</span></div>';
		    		  break;
		    		case 3:
		    		   html+='<div class="document-style"><span data-type="3">鉴定文书档案目录</span></div>';
		    		  break;
		    		case 5:
		    			html+='<div class="document-style"><span data-type="5">鉴定文书副本</span></div>'
			    	  break;
		    		case 8:
		    		   html+='<div class="document-style"><span data-type="8">鉴定文书审批表</span></div>'
			    	  break;
		    		case 0:
		    			html+='<div class="document-style"><span data-type="0">鉴定委托书</span></div>'
			    	  break;
		    		case 1:
		    			html+='<div class="document-style"><span data-type="1">鉴定事项确认书</span></div>'
			    	  break;
		    		case 4:
		    			html+='<div class="document-style"><span data-type="4">电子物证检验原始记录</span></div>'
			    	  break;
		    		case 7:
		    			html+='<div class="document-style"><span data-type="7">提取电子证据清单</span></div>'
			    	  break;
		    		case 6:
		    			html+='<div class="document-style"><span data-type="6">检验鉴定照片记录表</span></div>'
			    	  break;
		    		default:
		    		  //
		    		}
		    	}
 		    	$(".docDiv").append(html);
		    }
		    
		    
		    if(appraisalStatus == 11){
		    	//清空数据
		    	$(".approver").hide();
		    	$(".pass,.refuse").hide();
		    }else if(appraisalStatus == 12){
		    	//清空数据
		    	
		    	$(".issuedFormNum").attr("readonly", true);
		    	$('.approverOpinion').attr("required", true);
		    	$(".verifier").find("input[type='text'], textarea").attr("readonly",true); 
		        $(".verifier").find("input[type='radio'], input[type='checkbox'], select").attr("disabled",true); 
		    	$(".refer").hide();
		    }  
		    
		    var vm={
		    		appraisalVm:appraisalDataVm,
		    		appraisalDocVm:appraisalDocDataVm 
		    };
	    	
		    vm.saveData = function(){ 
 		    	$("button").attr("disabled", true); 
		        if ( validateSubmittedData() ) {
		         	if(appraisalData.status=='11'){
		        		//授权签字人保存
		        		bindVerifiedDataVM();
		        		 
		     		    
		        	}else if(appraisalData.status=='12'){
		        		//审批人保存
		        		/* var date = new Date();
		        		var year = date.getFullYear();
		        		var archiveCodeData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/archiveCode/getDataByAgecyAndYear.do",{ "appraisalId": appraisalData.id ,"agency" : "1" , "year" : year });
		        		 */
		        		
		        		 bindApproverDataVM();
		        	} 
		         	if (saveData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/saveData.do", appraisalDataVm)) {
        				saveSuccess("${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/clericalApprovalList.do");
					}
		        } else {
		        	saveFailure();
		        } 
		    }
		    
		     vm.refuseData = function(){ 
 		    	$("button").attr("disabled", true);
		        if ( validateSubmittedData() ) { 
		        	if(appraisalData.status=='11'){
		        		//授权签字人保存
		        		bindRefuseVerifiedDataVM();
		        	}else if(appraisalData.status=='12'){
		        		//审批人保存
		        		bindRefuseApproverDataVM();
		        	} 
		        	if (saveData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/saveData.do", appraisalDataVm)) {
						saveSuccess("${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/clericalApprovalList.do");
					}
		        } else {
		        	saveFailure();
		        } 
		    } 
	    	
		    ko.applyBindings(vm);
		    
	    	/* 标签页事件和样式-开始 */
			var clickStatus = 4;	//点击状态
			var dataStatus = 4;		//数据状态
			tabsContent(clickStatus,dataStatus);
			/* 标签页事件和样式-结束  */
			
			//文书审批表数据构建
			function bindVerifiedDataVM(){ 
				//授权签字人数据
				appraisalDataVm.verifierId="${sessionScope.loginUser.userId}";
				appraisalDataVm.verifierName="${sessionScope.loginUser.userName}";
				appraisalDataVm.verifierAlias="${sessionScope.loginUser.userAlias}";
				//发文形式及数量
				var issuedForm =  $(".issuedForm").find("input[type='radio']:checked").val();
				 
				
				var issuedFormNum = $(".issuedFormNum").val();
				appraisalDataVm.issuedForm='[{"name":"'+issuedForm+'","qty":'+issuedFormNum+'}]';
				//附件
				appraisalDataVm.att=getAtt();
				//鉴定情况判定
				appraisalDataVm.sitnJudgement = $(".sitnJudgement").find("input[type='radio']:checked").val();
				appraisalDataVm.verifiedDate=new Date();
				appraisalDataVm.status = 12;
			}
			
			function bindApproverDataVM(){
				//实验室负责人
				appraisalDataVm.approverId="${sessionScope.loginUser.userId}";
				appraisalDataVm.approverName="${sessionScope.loginUser.userName}";
				appraisalDataVm.approverAlias="${sessionScope.loginUser.userAlias}";
				appraisalDataVm.approvedDate=new Date();
				appraisalDataVm.status = 13; 
			}
			
			//拒绝数据绑定
			function bindRefuseVerifiedDataVM(){ 
				//授权签字人数据
				appraisalDataVm.approverId="${sessionScope.loginUser.userId}";
				appraisalDataVm.approverName="${sessionScope.loginUser.userName}";
				appraisalDataVm.approverAlias="${sessionScope.loginUser.userAlias}";
				appraisalDataVm.verifiedDate=new Date();
				appraisalDataVm.status = 10;
			}
			
			//拒绝数据绑定
			function bindRefuseApproverDataVM(){
				//实验室负责人
				appraisalDataVm.approverId="${sessionScope.loginUser.userId}";
				appraisalDataVm.approverName="${sessionScope.loginUser.userName}";
				appraisalDataVm.approverAlias="${sessionScope.loginUser.userAlias}";
				appraisalDataVm.approvedDate=new Date();
				appraisalDataVm.status = 10;
			}
			
			function getAtt(){
				 var value='';
				 var inputType = $(".att").find("input[type='checkbox']");
				 for( var i = 0; i < inputType.size(); i++ ){
				   if( inputType.eq(i).prop("checked") ){
				      value += inputType.eq(i).val()+",";
				     } 
				  } 
				 return value; 
			};
			
			//鉴定文书审批表附件
			function setAtt(att){
				if(att != "" && att != undefined && att != null){
					var scopeData = att.split(",");
					for(var i = 0 ; i < scopeData.length ; i++){
						var check = ".att" +scopeData[i];
						$(check).attr('checked', true)
					}
				}
			}
			//发文形式和数量
		    function setIssuedForm(issuedForm){
				 
				if(issuedForm != '' && issuedForm != null && issuedForm != undefined){
			    	//josn解析
			    	var iss = JSON.parse(issuedForm)
			    	$(".issuedFormNum").val(iss[0].qty);
			    	var name  = iss[0].name;
			    	if(name != '' && name != null && name != undefined){
			    	 $('input[name="radioProfession"][value='+iss[0].name+']').attr("checked",true); 
			    	}
				}
		    }
		    //授权签字人意见
		    function setSitnJudgement(sitnJudgement){
		    	if(sitnJudgement != '' && sitnJudgement != null && sitnJudgement != undefined){
		    		$('input[name="radioProfession2"][value='+sitnJudgement+']').attr("checked",true);
		    	}
		    } 
				
			$(".docDiv").on("click",".document-style span",function(){
				var typeValue = $(this).attr("data-type");
				window.location.href="${pageContext.request.contextPath}/elecEVIDMgt/AppraisalDoc/downAppraisalDocData.do?type="+typeValue+"&appraisalId="+"${param.id}";
			})
							
			
	    	
	        $(".back-btn").click(function(){
		    	var url = "${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/clericalApprovalList.do";
		    	$(".index-iframe", window.parent.document).attr("src",url);
		    });
	        
	        $(".write-btn").click(function(){
		    	var url = "${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/identificationDocumentApprovalForm.do";
		    	$(".index-iframe", window.parent.document).attr("src",url);
		    });

	        $(".tabs-nav li").click(function(){
	    		var aClass = $(this).find("a").attr("class");
	    		if( aClass == "register" ){
	    			if( $(".iframe-"+aClass).attr("src") == "" ){
	    				var src = "${pageContext.request.contextPath}/elecEVIDMgt/registerInfoView.do?commonPreappraisalId="+appraisalData.preappraisalId;
	    				iframeHeight(aClass, src);
	    			}
	    		}else if( aClass == "accepted" ){
	    			if( $(".iframe-"+aClass).attr("src") == "" ){
	    				var src = "${pageContext.request.contextPath}/elecEVIDMgt/physicalEvidenceAcceptView.do?commonAppraisalId="+"${param.id}";
	    				iframeHeight(aClass, src);
	    			}
	    		}else if( aClass == "check" ){
	    			if( $(".iframe-"+aClass).attr("src") == "" ){
	    				var src = "${pageContext.request.contextPath}/elecEVIDMgt/checkInfoView.do?commonAppraisalId="+"${param.id}";
	    				iframeHeight(aClass, src);
	    			}
	    		}else if( aClass == "warehousing" ){
	    			if( $(".iframe-"+aClass).attr("src") == "" ){
	    				var src = "${pageContext.request.contextPath}/elecEVIDMgt/physicalEvidenceStorageView.do?commonAppraisalId="+"${param.id}";
	    				iframeHeight(aClass, src);
	    			}
	    		}
	    	});
	    });
	    
	    function iframeHeight(aClass, src){
	    	$(".iframe-"+aClass).attr("src", src);
			$(".iframe-"+aClass).load(function(){
	            var mainheight = $(".iframe-"+aClass).contents().find("body").height()+30;
	            $(".iframe-"+aClass).height(mainheight);
	        });
	    }
    </script>
</body>
</html>