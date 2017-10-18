 <%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>广州市公安局电子数据检验鉴定管理系统-首页</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script> 
  	<script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/first-page.css" />" rel="stylesheet" />
</head>
<body>
    <div class="row ul-content">
    	<%-- <!-- 原首页--start -->
        <sys:auth grant="EVID_ACCEPTANCE" username="${sessionScope.loginUser.userName}">
	        <div class="col-sm-6 li-content li-border">
	            <div class="li-title">
	                <div class="title-img">
	                    <img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/shouli.png" alt="">
	                </div>
	                <div class="title-name"><span>物证受理</span></div>
	                <div class="title-style">
	                    <div class="left-dot"></div>
	                    <div class="right-btn more-btn" data-class=".elecEVIDMgt" title="更多" data-url="${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/acceptedList.do"><span>...</span></div>
	                </div>
	            </div>
	            <ul class="list-content accepted">
	               
	            </ul>
	        </div>
	    </sys:auth>
	    <sys:auth grant="APPRAISAL_ANALYSIS" username="${sessionScope.loginUser.userName}">
	        <div class="col-sm-6 li-content li-border">
	            <div class="li-title">
	                <div class="title-img">
	                    <img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/jianding.png" alt="">
	                </div>
	                <div class="title-name"><span>物证鉴定</span></div>
	                <div class="title-style">
	                    <div class="left-dot"></div>
	                    <div class="right-btn" data-class=".elecEVIDMgt"><span>...</span></div>
	                </div>
	            </div>
	            <ul class="list-content authenticat">
	               
	            </ul>   
	        </div>
	    </sys:auth>
	    <sys:auth grant="APPRAISAL_FEEDBACK" username="${sessionScope.loginUser.userName}">
	        <div class="col-sm-6 li-content li-border">
	            <div class="li-title">
	                <div class="title-img">
	                    <img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/shenpi.png" alt="">
	                </div>
	                <div class="title-name"><span>结果审批</span></div>
	                <div class="title-style">
	                    <div class="left-dot"></div>
	                    <div class="right-btn more-btn" data-class=".elecEVIDMgt" title="更多" data-url="${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/clericalApprovalList.do"><span>...</span></div>
	                </div>
	            </div>
	            <ul class="list-content audit">
	               
	            </ul>
	        </div>
	    </sys:auth>
	    <sys:auth grant="EVID_EXPORT" username="${sessionScope.loginUser.userName}">
	        <div class="col-sm-6 li-content li-border">
	            <div class="li-title">
	                <div class="title-img">
	                    <img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/chuku.png" alt="">
	                </div>
	                <div class="title-name"><span>检材出库</span></div>
	                <div class="title-style">
	                    <div class="left-dot"></div>
	                    <div class="right-btn more-btn" data-class=".elecEVIDMgt" title="更多" data-url="${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/resultsMgtList.do"><span>...</span></div>
	                </div>
	            </div>
	            <ul class="list-content feedback">
	              
	            </ul>
	        </div>
	    </sys:auth>
	    <!-- 原首页--end --> --%>
	    
	    
	    <!-- 受理员首页--start -->
	     <sys:auth grant="EVID_ACCEPTANCE" username="${sessionScope.loginUser.userName}">
	    <div class="col-sm-6 li-content li-border">
            <div class="li-title">
                <div class="title-img">
                    <img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/shouli.png" alt="">
                </div>
                <div class="title-name"><span>检材受理</span></div>
                <div class="title-style">
                    <div class="left-dot"></div>
                    <div class="right-btn more-btn" data-class=".elecEVIDMgt" title="更多" data-url="${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/acceptedList.do"><span>...</span></div>
                </div>
            </div>
            <ul class="list-content accepted">
               
            </ul>
        </div>
        <div class="col-sm-6 li-content li-border">
            <div class="li-title">
                <div class="title-img">
                    <img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/chuku.png" alt="">
                </div>
                <div class="title-name"><span>检材入库</span></div>
                <div class="title-style">
                    <div class="left-dot"></div>
                    <div class="right-btn more-btn" data-class=".elecEVIDMgt" title="更多" data-url="${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/warehousingList.do"><span>...</span></div>
                </div>
            </div>
            <ul class="list-content warehousing">
               
            </ul>
        </div>
        <div class="col-sm-6 li-content li-border">
            <div class="li-title">
                <div class="title-img">
                    <img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/shenpi.png" alt="">
                </div>
                <div class="title-name"><span>检材交接</span></div>
                <div class="title-style">
                    <div class="left-dot"></div>
                    <div class="right-btn more-btn" data-class=".elecEVIDMgt" title="更多" data-url="${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/handoverList.do"><span>...</span></div>
                </div>
            </div>
            <ul class="list-content transition">
               
            </ul>
        </div>
        <div class="col-sm-6 li-content li-border">
            <div class="li-title">
                <div class="title-img">
                    <img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/shouli.png" alt="">
                </div>
                <div class="title-name"><span>结果管理</span></div>
                <div class="title-style">
                    <div class="left-dot"></div>
                    <div class="right-btn more-btn" data-class=".elecEVIDMgt" title="更多" data-url="${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/resultsMgtList.do"><span>...</span></div>
                </div>
            </div>
            <ul class="list-content feedback">
               
            </ul>
        </div>
        </sys:auth>
        <!-- 受理员首页--end -->
	    
	    
	    
	    <!-- 鉴定人员首页--start -->
	    <sys:auth grant="APPRAISAL_ANALYSIS" username="${sessionScope.loginUser.userName}">
	    <div class="col-sm-6 li-content li-border">
            <div class="li-title">
                <div class="title-img">
                    <img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/jianding.png" alt="">
                </div>
                <div class="title-name"><span>检材鉴定</span></div>
                <div class="title-style">
                    <div class="left-dot"></div>
                    <!-- <div class="right-btn more-btn" data-class=".elecEVIDMgt" title="更多" data-url=""><span>...</span></div> -->
                </div>
            </div>
            <ul class="list-content authenticat">
               
            </ul>
        </div>
        <div class="col-sm-6 li-content li-border">
            <div class="li-title">
                <div class="title-img">
                    <img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/shenpi.png" alt="">
                </div>
                <div class="title-name"><span>文书修改</span></div>
                <div class="title-style">
                    <div class="left-dot"></div>
                    <div class="right-btn more-btn" data-class=".elecEVIDMgt" title="更多" data-url="${pageContext.request.contextPath}/elecEVIDMgt/authenticate/document/documentchange.do"><span>...</span></div>
                </div>
            </div>
            <ul class="list-content docchange">
               
            </ul>
        </div>
         </sys:auth>
        <!-- 鉴定人员首页--end -->
        
        
        
        <!-- 技术负责人首页--start -->
        <sys:auth grant="TECHNICAL_DIRECTOR" username="${sessionScope.loginUser.userName}">
	    <div class="col-sm-6 li-content li-border">
            <div class="li-title">
                <div class="title-img">
                    <img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/shenpi.png" alt="">
                </div>
                <div class="title-name"><span>检材审核</span></div>
                <div class="title-style">
                    <div class="left-dot"></div>
                    <div class="right-btn more-btn" data-class=".elecEVIDMgt" title="更多" data-url="${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/examinationOfMaterialsList.do"><span>...</span></div>
                </div>
            </div>
            <ul class="list-content audit">
               
            </ul>
        </div>
        <div class="col-sm-6 li-content li-border">
            <div class="li-title">
                <div class="title-img">
                    <img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/shouli.png" alt="">
                </div>
                <div class="title-name"><span>修改文书审批</span></div>
                <div class="title-style">
                    <div class="left-dot"></div>
                    <div class="right-btn more-btn" data-class=".elecEVIDMgt" title="更多" data-url="${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/modifyClericalApprovalList.do"><span>...</span></div>
                </div>
            </div>
            <ul class="list-content tAudit">
               
            </ul>
        </div>
        </sys:auth>
        <!-- 技术负责人首页--end -->
	    
	    
	    
	    <!-- 质量负责人首页--start -->
	    <sys:auth grant="QUALITY_DIRECTOR" username="${sessionScope.loginUser.userName}">
	    <div class="col-sm-6 li-content li-border">
            <div class="li-title">
                <div class="title-img">
                    <img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/shouli.png" alt="">
                </div>
                <div class="title-name"><span>鉴定分配</span></div>
                <div class="title-style">
                    <div class="left-dot"></div>
                    <div class="right-btn more-btn" data-class=".elecEVIDMgt" title="更多" data-url="${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/identificationAllocationList.do"><span>...</span></div>
                </div>
            </div>
            <ul class="list-content allot">
               
            </ul>
        </div>
        </sys:auth>
        <!-- 质量负责人首页--end -->
        
        
        
        <!-- 授权签字人首页--start -->
         <sys:auth grant="AUTHORIZATION_DIRECTOR" username="${sessionScope.loginUser.userName}">
        <div class="col-sm-6 li-content li-border">
            <div class="li-title">
                <div class="title-img">
                    <img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/shenpi.png" alt="">
                </div>
                <div class="title-name"><span>文书审批</span></div>
                <div class="title-style">
                    <div class="left-dot"></div>
                    <div class="right-btn more-btn" data-class=".elecEVIDMgt" title="更多" data-url="${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/clericalApprovalList.do"><span>...</span></div>
                </div>
            </div>
            <ul class="list-content oneaudit">
               
            </ul>
        </div>
        <div class="col-sm-6 li-content li-border">
            <div class="li-title">
                <div class="title-img">
                    <img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/shouli.png" alt="">
                </div>
                <div class="title-name"><span>修改文书审批</span></div>
                <div class="title-style">
                    <div class="left-dot"></div>
                    <div class="right-btn more-btn" data-class=".elecEVIDMgt" title="更多" data-url="${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/modifyClericalApprovalList.do"><span>...</span></div>
                </div>
            </div>
            <ul class="list-content oAudit">
               
            </ul>
        </div>
         </sys:auth>
        <!-- 授权签字人首页--end -->
        
        
        
        <!-- 实验室负责人首页--start -->
        <sys:auth grant="ROOT_DIRECTOR" username="${sessionScope.loginUser.userName}">
        <div class="col-sm-6 li-content li-border">
            <div class="li-title">
                <div class="title-img">
                    <img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/shenpi.png" alt="">
                </div>
                <div class="title-name"><span>文书审批</span></div>
                <div class="title-style">
                    <div class="left-dot"></div>
                    <div class="right-btn more-btn" data-class=".elecEVIDMgt" title="更多" data-url="${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/clericalApprovalList.do"><span>...</span></div>
                </div>
            </div>
            <ul class="list-content twoaudit">
               
            </ul>
        </div>
        <div class="col-sm-6 li-content li-border">
            <div class="li-title">
                <div class="title-img">
                    <img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/shouli.png" alt="">
                </div>
                <div class="title-name"><span>修改文书审批</span></div>
                <div class="title-style">
                    <div class="left-dot"></div>
                    <div class="right-btn more-btn" data-class=".elecEVIDMgt" title="更多" data-url="${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/modifyClericalApprovalList.do"><span>...</span></div>
                </div>
            </div>
            <ul class="list-content hAudit">
               
            </ul>
        </div>
        </sys:auth>
        <!-- 实验室负责人首页--end -->
	    
	    
	    
	    <!-- 共同都有的部分--start -->
	    <div class="col-sm-12 li-content li-border">
            <div class="li-title">
                <div class="title-img">
                    <img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/gonggao.png" alt="">
                </div>
                <div class="title-name"><span>通知公告</span></div>
                <div class="title-style">
                    <div class="left-dot"></div>
                    <div class="right-btn " data-class=".systemMgt" title="更多" data-url="${pageContext.request.contextPath}/system/notification/notificationList.do"><span>...</span></div>
                </div>
            </div>
            <ul class="list-content notification">
              
            </ul>
        </div>
        <!-- 共同都有的部分--end -->
    </div>
    <script>
	    $(function(){
	    	/*受理人员  */
	    	//检材受理
	    	var acceptedHtml = '';
	    	var acceptedData =  loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/getIndexListData.do",{ "status" : "0" });
	    	if( acceptedData.length > 0){
	    		for(var i = 0; i < acceptedData.length ;i++){
	    			acceptedHtml += '<li> <span class="li-dot"></span>'+
	    							'<p class="li-text"><a data-href ="${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/acceptedForm.do?id='+acceptedData[i].id+'">'+acceptedData[i].caseName+'('+acceptedData[i].caseSn+')-'+acceptedData[i].evidName+'</a></p>'+
	    							'<span class="time">'+new Date(acceptedData[i].createdDate).Format("yyyy-MM-dd hh:mm")+'</span></li>'
	    		}
	    		$('.accepted').append(acceptedHtml);
	    	}
	    	//检材入库
	    	var warehousingHtml = '';
	    	var warehousingData =  loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/getIndexListData.do",{ "status" : "4" });
	    	if( warehousingData.length > 0){
	    		for(var i = 0; i < warehousingData.length ;i++){
	    			warehousingHtml += '<li> <span class="li-dot"></span>'+
	    							'<p class="li-text"><a data-href ="${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/warehousingForm.do?id='+warehousingData[i].id+'">'+warehousingData[i].caseName+'('+warehousingData[i].caseSn+')-'+warehousingData[i].evidName+'</a></p>'+
	    							'<span class="time">'+new Date(warehousingData[i].createdDate).Format("yyyy-MM-dd hh:mm")+'</span></li>'
	    		}
	    		$('.warehousing').append(warehousingHtml);
	    	} 
	    	//检材交接
	    	var transitionHtml = '';
	    	var transitionData =  loadData("${pageContext.request.contextPath}/elecEVIDMgt/evidTransition/indexListData.do",null);
	    	if( transitionData.length > 0){
	    		for(var i = 0; i < transitionData.length ;i++){
	    			transitionHtml += '<li> <span class="li-dot"></span>';
	    			if(transitionData[i].type == 1){
	    				transitionHtml += '<p class="li-text"><a data-href ="${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/handoverReturnForm.do?id='+transitionData[i].id+'">'+transitionData[i].caseName+'('+transitionData[i].caseSn+')-'+transitionData[i].evidName+'</a></p>';
	    			}else if(transitionData[i].type == 0){
	    				transitionHtml += '<p class="li-text"><a data-href ="${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/handoverCollarForm.do?id='+transitionData[i].id+'">'+transitionData[i].caseName+'('+transitionData[i].caseSn+')-'+transitionData[i].evidName+'</a></p>';
	    			}
	    			transitionHtml += '<span class="time">'+new Date(transitionData[i].createdDate).Format("yyyy-MM-dd hh:mm")+'</span></li>';			
	    		}
	    		$('.transition').append(transitionHtml);
	    	} 
	    	//结果管理
	    	var feedbackHtml = '';
	    	var feedbackData =  loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/getIndexListData.do",{ "status" : "14" });
	    	if( feedbackData.length > 0){
	    		for(var i = 0; i < feedbackData.length ;i++){
	    			feedbackHtml += '<li> <span class="li-dot"></span>'+
	    							'<p class="li-text"><a data-href ="${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/resultsMgtForm.do?id='+feedbackData[i].id+'">'+feedbackData[i].caseName+'('+feedbackData[i].caseSn+')-'+feedbackData[i].evidName+'</a></p>'+
	    							'<span class="time">'+new Date(feedbackData[i].createdDate).Format("yyyy-MM-dd hh:mm")+'</span></li>'
	    		}
	    		$('.feedback').append(feedbackHtml);
	    	} 
	    	
	    	/*鉴定人员 */
	    	//检材鉴定
	    	var authenticatHtml = '';
	    	var authenticatData =  loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/loadDataByUserAlias.do",{ "userId" : "${sessionScope.loginUser.userId}" });
	    	if(authenticatData.appraiserId != null ){
		    	authenticatHtml += '<li> <span class="li-dot"></span>'+
		    						'<p class="li-text"><a data-href ="${pageContext.request.contextPath}/elecEVIDMgt/authenticate/analysis/appraisalProcessAllot.do">'+authenticatData[i].caseName+'('+authenticatData[i].caseSn+')-'+authenticatData.evidName+'</a></p>'+
		    						'<span class="time">'+new Date(authenticatData.createdDate).Format("yyyy-MM-dd hh:mm")+'</span></li>';
	    	}else{
	    		authenticatHtml += '<li> <span class="li-dot"></span>暂无鉴定信息</li>';
	    	}
	   		$('.authenticat').append(authenticatHtml);
	    	//文书修改
	    	var docchangeHtml = '';
	    	var docchangeData =  loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisalRevise/indexData.do",{"name":"userId","value":"${sessionScope.loginUser.userId}"});
	    	if( docchangeData.length > 0){
	    		for(var i = 0; i < docchangeData.length ;i++){
	    			docchangeHtml += '<li> <span class="li-dot"></span>'+
	    							'<p class="li-text"><a data-href ="${pageContext.request.contextPath}/elecEVIDMgt/authenticate/document/documentChangeApproveSum.do?appraisalReviseId='+docchangeData[i].id+'">'+docchangeData[i].reportSn+'-'+docchangeData[i].reportName+'</a></p>'+
	    							'<span class="time">'+new Date(docchangeData[i].revisedDate).Format("yyyy-MM-dd hh:mm")+'</span></li>'
	    		}
	    		$('.docchange').append(docchangeHtml);
	    	} 
	    	
	    	/*技术负责人 */
	    	//检材审核
	    	var auditHtml = '';
	    	var auditData =  loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/getIndexListData.do",{ "status" : "2" });
	    	if( auditData.length > 0){
	    		for(var i = 0; i < auditData.length ;i++){
	    			auditHtml += '<li> <span class="li-dot"></span>'+
	    							'<p class="li-text"><a data-href ="${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/examinationOfMaterialsForm.do?id='+auditData[i].id+'">'+auditData[i].caseName+'('+auditData[i].caseSn+')-'+auditData[i].evidName+'</a></p>'+
	    							'<span class="time">'+new Date(auditData[i].createdDate).Format("yyyy-MM-dd hh:mm")+'</span></li>'
	    		}
	    		$('.audit').append(auditHtml);
	    	}
	    	//修改文书审批（二审）
	    	var tAuditHtml = '';
	    	var tAuditData =  loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisalRevise/indexAuditData.do",{ "status" : "2" });
	    	if( tAuditData.length > 0){
	    		for(var i = 0; i < tAuditData.length ;i++){
	    			var appData =  loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/loadDataById.do",{ "id" : tAuditData[i].appraisalId });
	    			tAuditHtml += '<li> <span class="li-dot"></span>'+
	    							'<p class="li-text"><a data-href ="${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/modifyClericalApplicationForm.do?id='+tAuditData[i].id+'">'+appData[i].caseName+'('+appData[i].caseSn+')-'+tAuditData[i].reportName+'</a></p>'+
	    							'<span class="time">'+new Date(tAuditData[i].revisedDate).Format("yyyy-MM-dd hh:mm")+'</span></li>'
	    		}
	    		$('.tAudit').append(tAuditHtml);
	    	}   

	    	/*质量负责人 */
	    	//鉴定分配  allot
	    	var allotHtml = '';
	    	var allotData =  loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/getIndexListData.do",{ "status" : "5" });
	    	if( allotData.length > 0){
	    		for(var i = 0; i < allotData.length ;i++){
	    			allotHtml += '<li> <span class="li-dot"></span>'+
	    							'<p class="li-text"><a data-href ="${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/identificationAllocationForm.do?id='+allotData[i].id+'">'+allotData[i].caseName+'('+allotData[i].caseSn+')-'+allotData[i].evidName+'</a></p>'+
	    							'<span class="time">'+new Date(allotData[i].createdDate).Format("yyyy-MM-dd hh:mm")+'</span></li>'
	    		}
	    		$('.allot').append(allotHtml);
	    	}
	    	/*授权签字人 */
	    	//文书审批11
	    	var oneauditHtml = '';
	    	var oneauditData =  loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/auditIndexData.do",{ "status" : "11" });
	    	if( oneauditData.length > 0){
	    		for(var i = 0; i < oneauditData.length ;i++){
	    			oneauditHtml += '<li> <span class="li-dot"></span>'+
	    							'<p class="li-text"><a data-href ="${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/clericalApprovalForm.do?id='+oneauditData[i].id+'">'+oneauditData[i].caseName+'('+oneauditData[i].caseSn+')-'+oneauditData[i].evidName+'</a></p>'+
	    							'<span class="time">'+new Date(oneauditData[i].createdDate).Format("yyyy-MM-dd hh:mm")+'</span></li>'
	    		}
	    		$('.oneaudit').append(oneauditHtml);
	    	}
	    	
	    	
	    	//修改文书审批(第一步)
	    	var oAuditHtml = '';
	    	var oAuditData =  loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisalRevise/indexAuditData.do",{ "status" : "1" });
	    	if( oAuditData.length > 0){
	    		for(var i = 0; i < oAuditData.length ;i++){
	    			var appData =  loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/loadDataById.do",{ "id" : oAuditData[i].appraisalId });
	    			oAuditHtml += '<li> <span class="li-dot"></span>'+
	    							'<p class="li-text"><a data-href ="${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/modifyClericalApplicationForm.do?id='+oAuditData[i].id+'">'+appData[i].caseName+'('+appData[i].caseSn+')-'+oAuditData[i].reportName+'</a></p>'+
	    							'<span class="time">'+new Date(oAuditData[i].revisedDate).Format("yyyy-MM-dd hh:mm")+'</span></li>'
	    		}
	    		$('.oAudit').append(oAuditHtml);
	    	} 
	    	
	    	
	    	/*实验室负责人 */
	    	//文书审批（二部）12
	    	var twoauditHtml = '';
	    	var twoauditData =  loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/auditIndexData.do",{ "status" : "12" });
	    	if( twoauditData.length > 0){
	    		for(var i = 0; i < twoauditData.length ;i++){
	    			twoauditHtml += '<li> <span class="li-dot"></span>'+
	    							'<p class="li-text"><a data-href ="${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/clericalApprovalForm.do?id='+twoauditData[i].id+'">'+twoauditData[i].caseName+'('+twoauditData[i].caseSn+')-'+twoauditData[i].evidName+'</a></p>'+
	    							'<span class="time">'+new Date(twoauditData[i].createdDate).Format("yyyy-MM-dd hh:mm")+'</span></li>'
	    		}
	    		$('.twoaudit').append(twoauditHtml);
	    	}
	    	
	    	
	    	//修改文书审批（三步）
	    	var hAuditHtml = '';
	    	var hAuditData =  loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisalRevise/indexAuditData.do",{ "status" : "3" });
	    	if( hAuditData.length > 0){
	    		for(var i = 0; i < hAuditData.length ;i++){
	    			var appData =  loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/loadDataById.do",{ "id" : hAuditData[i].appraisalId });
	    			hAuditHtml += '<li> <span class="li-dot"></span>'+
	    							'<p class="li-text"><a data-href ="${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/modifyClericalApplicationForm.do?id='+hAuditData[i].id+'">'+appData[i].caseName+'('+appData[i].caseSn+')-'+hAuditData[i].reportName+'</a></p>'+
	    							'<span class="time">'+new Date(hAuditData[i].revisedDate).Format("yyyy-MM-dd hh:mm")+'</span></li>'
	    		}
	    	}
	    	var fAuditData =  loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisalRevise/indexAuditData.do",{ "status" : "6" });
		    	if( fAuditData.length > 0){
		    		for(var i = 0; i < fAuditData.length ;i++){
		    			var appData =  loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/loadDataById.do",{ "id" : fAuditData[i].appraisalId });
		    			hAuditHtml += '<li> <span class="li-dot"></span>'+
		    							'<p class="li-text"><a data-href ="${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/modifyClericalModifyForm.do?id='+fAuditData[i].id+'">'+appData[i].caseName+'('+appData[i].caseSn+')-'+fAuditData[i].reportName+'</a></p>'+
		    							'<span class="time">'+new Date(fAuditData[i].revisedDate).Format("yyyy-MM-dd hh:mm")+'</span></li>'
		    		}
		    	}
	    		
	    		$('.hAudit').append(hAuditHtml);
	    	 	 
	    	
	    	
	    	//通知公告
	    	var notificationHtml = '';
	    	var notificationData =  loadData("${pageContext.request.contextPath}/system/notification/loadIndexData.do",{});
	    	if( notificationData.length > 0){
	    		for(var i = 0; i < notificationData.length ;i++){
	    			notificationHtml += '<li> <span class="li-dot"></span>'+
	    							'<p class="li-text"><a data-href ="${pageContext.request.contextPath}/system/notification/notificationView.do?notificationId='+notificationData[i].id+'">'+notificationData[i].title+'</a></p>'+
	    							'<span class="time">'+new Date(notificationData[i].publishedDate).Format("yyyy-MM-dd hh:mm")+'</span></li>'
	    		}
	    		$('.notification').append(notificationHtml);
	    	}
	    });
    		
		$(".more-btn").click(function() {
			var url = $(this).data("url");
	    	$(".index-iframe", window.parent.document).attr("src",url);
	    	var className = $(this).data("class");
	    	$(".main-menu", window.parent.document).find("li").removeClass("active");
	    	$(".main-menu", window.parent.document).find(className).addClass("active");
		});
		
		$(".list-content").on("click",".li-text",function(){
			var className = $(this).parents(".list-content").siblings(".li-title").find(".right-btn").data("class");
	    	$(".main-menu", window.parent.document).find("li").removeClass("active");
	    	$(".main-menu", window.parent.document).find(className).addClass("active");
	    	var url = $(this).find("a").attr("data-href");
			$(".index-iframe",window.parent.document).attr("src",url);
		});
    </script>
</body>
</html>