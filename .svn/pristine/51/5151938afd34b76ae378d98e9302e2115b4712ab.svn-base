<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>鉴定文书修改申请表</title>
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
	<script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
	
	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>电子物证管理</a><span>></span><a>鉴定人员操作台</a><span>></span><a>文书修改申请</a><span>></span><a>申请</a>
        </p>
    </div>
	<div class="form-title">鉴定文书修改申请表</div>
	<div class="form-content">
        <form class="form-horizontal">
        	<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>委托单位：</label>
				<div class="col-sm-10" data-bind="with: AppraisalReviseVM" >
					<input type="text" data-bind="value: orgName" name="orgName" id="orgName" class="form-control" required readonly/>
				</div>							
			</div>
			<div class="form-group">				
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>鉴定文书名称：</label>
				<div class="col-sm-4" data-bind="with: AppraisalReviseVM" >
					<input type="text" data-bind="value: reportName" name="reportName" id="reportName" class="form-control" readonly required/>
				</div>	
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>鉴定文书编号：</label>
				<div class="col-sm-4" data-bind="with: AppraisalReviseVM" >
					<input type="text" data-bind="value: reportSn" name="reportSn" id="reportSn" class="form-control" readonly required/>
				</div>														
			</div> 
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>修改内容：</label>
				<div class="col-sm-10" data-bind="with: AppraisalReviseVM">
					<textarea data-bind="value: revisedContent" name="revisedContent" id="revisedContent" class="form-control" required></textarea>
				</div>														
			</div>
		    <div class="form-group">
				<label class="col-sm-2 control-label input-choose" data-name=".modify-the-way-radio"><span class="required-fields">*</span>修改方式：</label>
				<div class="col-sm-3 modify-the-way-radio">
                    <div class="rdio rdio-primary">
                        <input type="radio" name="radio1" value="" id="radioPrimary1">
                        <label for="radioPrimary1">原件杠改盖章</label>
                    </div>
                </div>
                <div class="col-sm-3 modify-the-way-radio">
                    <div class="rdio rdio-primary">
                        <input type="radio" name="radio1" value="" id="radioPrimary2">
                        <label for="radioPrimary2">收回原件，重新出具鉴定文书</label>
                    </div>
                </div>												
			</div>
        </form>
    </div>
    <div class="btn-content">
        <button type="button" class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
        <button type="button" class="btn btn-color1 submit-btn"><i class="fa fa-check"></i>提交</button>
    </div>
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
	<script>
		$(".back-btn").click(function(){
	    	$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/elecEVIDMgt/authenticate/document/documentList.do');
	    });	
		
		var appraisalId = "${param.appraisalId}";
        var userId = "${sessionScope.loginUser.userId}";
        var userAlias = "${sessionScope.loginUser.userAlias}";
        var userName = "${sessionScope.loginUser.userName}";
		
		var appraisalData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/loadDataById.do",{"id":appraisalId});
		var AppraisalReviseData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/AppraisalRevise/loadAppraisalReviseData.do", { "id":" " });							   
		var preappraisalEntruster = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/preappraisalEntruster/getPreappraisalEntrusterListBypreappraisalId.do", { "preappraisalId":appraisalData.preappraisalId });
		var appraisalReviseEntruster = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/AppraisalReviseEntruster/loadAppraisalReviseEntrusterData.do", { "id":"" });
		AppraisalReviseData.revisedDate=new Date();
		 
// 	    var preappraisalEntrusterDataVM = {
// 	    		entrusterList : ko.observableArray(preappraisalEntruster),
// 	    }
		var appraisalDataVM = ko.mapping.fromJS(appraisalData);
        var AppraisalReviseDataVM = ko.mapping.fromJS(AppraisalReviseData);
        var appraisalReviseEntrusterDataVM = ko.mapping.fromJS(appraisalReviseEntruster);
        
        AppraisalReviseDataVM.orgId = appraisalData.orgId;
        AppraisalReviseDataVM.orgName = appraisalData.orgName;  //委托单位
        AppraisalReviseDataVM.reportName = "电子物证检验报告";
        AppraisalReviseDataVM.reportSn = appraisalData.agency+" ["+appraisalData.year+"] "+appraisalData.sn
        AppraisalReviseDataVM.appraisalId = appraisalData.id;
        AppraisalReviseDataVM.preappraisalId = appraisalData.preappraisalId;
        AppraisalReviseDataVM.status = 1 ;
        AppraisalReviseDataVM.createdDate = new Date();
		AppraisalReviseDataVM.creatorId = appraisalData.appraiserId;
		AppraisalReviseDataVM.creatorName = appraisalData.appraiserName;
		AppraisalReviseDataVM.creatorAlias = appraisalData.appraiserAlias;
		AppraisalReviseDataVM.modifierId = "${sessionScope.loginUser.userId}";
		AppraisalReviseDataVM.modifierName = "${sessionScope.loginUser.userName}";
		AppraisalReviseDataVM.modifierAlias = "${sessionScope.loginUser.userAlias}";
        
		var vm = {
			appraisalVM : appraisalDataVM,
			AppraisalReviseVM : AppraisalReviseDataVM,
			appraisalReviseEntrusterVM : appraisalReviseEntrusterDataVM,
        }
        
        ko.applyBindings(vm);
		
    	$(".submit-btn").click(function(){
    		$("button").attr("disabled", true);
			if(validateSubmittedData()){
	        	if ( saveData("${ pageContext.request.contextPath }/elecEVIDMgt/AppraisalRevise/saveAppraisalReviseData.do", AppraisalReviseDataVM) ) {
	 				 appraisalDataVM.status = 13;
	 				if(saveData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/saveData.do", appraisalDataVM)){ 
	 					saveAppraisalReviseEntruster();
	 					saveSuccess("${pageContext.request.contextPath}/elecEVIDMgt/authenticate/document/documentList.do");
	 				 } 
		    	}
			}else{
				saveFailure();
			}
		})
		
		function saveAppraisalReviseEntruster(){
    		for(var i = 0 ; i < preappraisalEntruster.length ; i++){
    			appraisalReviseEntruster.userId = preappraisalEntruster[i].userId; 
    			appraisalReviseEntruster.userName = preappraisalEntruster[i].userName; 
    			appraisalReviseEntruster.userAlias = preappraisalEntruster[i].userAlias; 
    			appraisalReviseEntruster.userPost = preappraisalEntruster[i].userPost; 
    			appraisalReviseEntruster.userMp = preappraisalEntruster[i].userMp; 
    			appraisalReviseEntruster.policeId = preappraisalEntruster[i].policeId; 
    			appraisalReviseEntruster.appraisalReviseAppId = AppraisalReviseData.id; 
    			appraisalReviseEntruster.appraisalId  = appraisalData.id; 
    			saveData("${ pageContext.request.contextPath }/elecEVIDMgt/AppraisalReviseEntruster/saveAppraisalReviseEntrusterData.do", appraisalReviseEntruster)
    		}
    	}
		
		$("#radioPrimary1").click(function(){
			AppraisalReviseDataVM.method = 0;
		})
		$("#radioPrimary2").click(function(){
			AppraisalReviseDataVM.method = 1;
		})
	</script>
</body>
</html>