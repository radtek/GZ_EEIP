<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>中止鉴定</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>  	
	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
	<script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
  	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>电子物证管理</a><span>></span><a>鉴定人员操作台</a><span>></span><a>检材分析</a><span>></span><a>中止鉴定</a>
        </p>
    </div>
    
	<div class="form-title">中止鉴定告知书（存根）</div>
    <div class="form-content">
        <form class="form-horizontal">
   			<div class="form-group">
		    	<label class="col-sm-2 control-label">委托单位：</label>
		       	<div class="col-sm-4" data-bind="with: preappraisalVM">
		           	<input type="text" class="form-control" data-bind="value: orgName" name="orgName" id="orgName" readonly/>
		       	</div>
		       	<label class="col-sm-2 control-label">送检人：</label>
		       	<div class="col-sm-4" data-bind="with: entrusterVM">
		        	<input type="text" class="form-control" data-bind="value: userAlias" name="userAlias" id="userAlias" readonly/>
		       	</div>
   			</div>
		   	<div class="form-group">
		    	<label class="col-sm-2 control-label">证件名称：</label>
		       	<div class="col-sm-4">
		           	<input type="text" class="form-control" value="警察证" readonly/>
		       	</div>
		       	<label class="col-sm-2 control-label">证件号码：</label>
		       	<div class="col-sm-4" data-bind="with: entrusterVM">
		        	<input type="text" class="form-control" data-bind="value: policeId" name="policeId" id="policeId" readonly/>
		       	</div>
   			</div>
   			<div class="form-group">
		    	<label class="col-sm-2 control-label">案件名称：</label>
		       	<div class="col-sm-4" data-bind="with: preappraisalVM">
		           	<input type="text" class="form-control" data-bind="value: caseName" name="caseName" id="caseName" readonly/>
		       	</div>
		       	<label class="col-sm-2 control-label">案件编号：</label>
		       	<div class="col-sm-4" data-bind="with: preappraisalVM">
		        	<input type="text" class="form-control" data-bind="value: caseSn" name="caseSn" id="caseSn" readonly/>
		       	</div>
   			</div>
   			<div class="form-group">
		    	<label class="col-sm-2 control-label"><span class="required-fields">*</span>中止理由：</label>
		       	<div class="col-sm-10" data-bind="with:terminationNoticeVM">
		       		<div class="suspension-reason">
		       			<div>根据《公安机关鉴定规则》第<input type="text" data-bind="value: article" name="article" id="article"  class="reason-input input-short-width" required />条<input data-bind="value: paragraph" name="paragraph" id="paragraph" type="text" class="reason-input input-short-width" required />款之规定，因</div>
		       			<div><input type="text" data-bind="value: reason" name="reason" id="reason" class="reason-input input-long-width" required />，故不予受理。</div>
		       		</div>
		       	</div>
   			</div>
   			<div class="form-group">
		    	<label class="col-sm-2 control-label">填表人：</label>
		       	<div class="col-sm-4" data-bind="with: terminationNoticeVM">
		           	<input type="text" data-bind="value: creatorAlias" name="creatorAlias" id="creatorAlias" class="form-control" readonly/>
		       	</div>
   			</div>
        </form>
    </div>
    <div class="btn-content">
        <button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
        <button class="btn btn-color1 commit"><i class="fa fa-check"></i>提交</button>
    </div>
    <jsp:include page="/common/alertMessages.jsp"></jsp:include>
    <script>
        $(".back-btn").click(function(){
	    	var url = "${pageContext.request.contextPath}/elecEVIDMgt/authenticate/analysis/appraisalProcessAllot.do";
	    	$(".index-iframe", window.parent.document).attr("src",url);
	    });
        
        var appraisalId = "${param.appraisalId}";
        var preappraisalId = "${param.preappraisalId}";
		var userId = "${sessionScope.loginUser.userId}";
		var userName = "${sessionScope.loginUser.userName}";
		var userAlias = "${sessionScope.loginUser.userAlias}";
		var appraisalData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/loadDataById.do", { "id" : appraisalId });
        var preappraisalData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/preappraisal/loadPreappraisalData.do", { "id" : preappraisalId });
		var terminationNoticeData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/terminationNotice/loadTerminationNoticeData.do", { "id" : ""});
		var entrusterData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/preappraisalEntruster/getPreappraisalEntrusterBypreappraisalId.do",{ "preappraisalDataId" : preappraisalData.id});
		var evidTransitionData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/evidTransition/loadDataById.do", { "id" : "" });  //电子物证交接申请空对象
		var preappraisalDataVM = ko.mapping.fromJS(preappraisalData);
		var evidTransitionDataVM = ko.mapping.fromJS(evidTransitionData);
		var terminationNoticeDataVM = ko.mapping.fromJS(terminationNoticeData);
		var entrusterDataVM = ko.mapping.fromJS(entrusterData);
		var appraisalDataVM = ko.mapping.fromJS(appraisalData);
		
		terminationNoticeDataVM.creatorId = userId;
		terminationNoticeDataVM.creatorName = userName;
		terminationNoticeDataVM.creatorAlias = userAlias;
		terminationNoticeDataVM.appraisalId = appraisalId;
		terminationNoticeDataVM.preappraisalId = preappraisalId;
		
        var vm = {
        	appraisalVM : appraisalDataVM,
        	preappraisalVM : preappraisalDataVM,
       		terminationNoticeVM : terminationNoticeDataVM,
       		entrusterVM : entrusterDataVM,
       		evidTransitionVM : evidTransitionDataVM,
		}
        
		ko.applyBindings(vm);
        
        $(".commit").click(function(){
        	$("button").attr("disabled", true);
        	if(validateSubmittedData()){
        		//取消所有未完成的交接申请
    			saveData("${pageContext.request.contextPath}/elecEVIDMgt/evidTransition/cancelDataByAppraisalId.do?appraisalId="+appraisalData.id,{} );
    			
    			//判断检材状态是否未在库
    			var evidenceData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/evidence/getDataByAppraisalId.do", { "appraisalId" : appraisalData.id });  //电子物证交接申请空对象
    			if(evidenceData.status == 1 ){ //出库  就发起申请
    				evidTransitionDataVM.evidName = appraisalData.evidName;
    				evidTransitionDataVM.evidSn = appraisalData.evidSn;
    				evidTransitionDataVM.caseName = appraisalData.caseName;
    				evidTransitionDataVM.caseSn = appraisalData.caseSn;
    				evidTransitionDataVM.type = 1;
    				evidTransitionDataVM.status = 0;
    				evidTransitionDataVM.applicantId = userId;
    				evidTransitionDataVM.applicantName = userName;
    				evidTransitionDataVM.applicantAlias = userAlias;
    				evidTransitionDataVM.createdDate = new Date();
    				evidTransitionDataVM.evidId = appraisalData.evidId;
    				evidTransitionDataVM.preappraisalId = appraisalData.preappraisalId;
    				evidTransitionDataVM.appraisalId = appraisalData.id;
    				saveData("${ pageContext.request.contextPath }/elecEVIDMgt/evidTransition/saveData.do", evidTransitionDataVM);
    			}
    			
    			if(saveData("${ pageContext.request.contextPath }/elecEVIDMgt/terminationNotice/saveTerminationNoticeData.do", terminationNoticeDataVM)){
    				if(appraisalData.status == 6 || appraisalData.status == 10 || appraisalData.status == 11 || appraisalData.status == 12 || appraisalData.status == 13){
    					appraisalDataVM.status = 13;
    				}else{
    					appraisalDataVM.status = 15;
    				}
    				saveData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/saveData.do", appraisalDataVM)
    				saveData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/saveTerminationWord.do", appraisalDataVM)
    				
        			saveSuccess("${pageContext.request.contextPath}/elecEVIDMgt/authenticate/analysis/appraisalProcessAllot.do");
    			}
        	}else{
        		saveFailure();
        	}
        });
    </script>
</body>
</html>