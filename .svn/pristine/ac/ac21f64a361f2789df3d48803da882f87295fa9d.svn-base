<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>时间轴查看</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script> 
    <script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
  	<script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script> 
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>	 
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/zyupload.basic-1.0.0.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/base.js" />"></script>
  	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/elecEVIDMgt/timeline.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
			当前位置：<a>电子物证管理</a><span>></span><a>综合鉴定信息</a><span>></span><a>查看</a>
        </p>
    </div>
    <div class="timeline-content">
        <div class="timeline-list list-left status-1" id="register">           
            <a class="left-name" data-num="0">登记</a>          
            <span class="appraisal">
            <!-- <div class="horizontal-line"></div>
            <div class="status-details">
                <div class="corner-content"><span class="top-dot"></span><span class="bottom-dot"></span></div>
	                <p>登记人：张三</p>
	                <p>案件编号：J12345</p>
	                <p>案件名称：非法持有枪支</p>
	                <p>委托单位：广州市公安局</p>
	                <p>委托时间：2016-12-18</p>
	                <p>检材名称：电脑磁盘</p>
            </div> -->
            </span>
        </div>
        <div class="timeline-list list-right status-2" id="accept">                       
            <a class="right-name" data-num="1">受理</a>   
             <span class="acceptance">       
	            <!-- <div class="horizontal-line acceptance"></div>
	            <div class="status-details">
	                <div class="corner-content"><span class="top-dot"></span><span class="bottom-dot"></span></div>
		                <p>受理人：张三</p>
		                <p>受理时间：2016-12-12</p>
		                <p>受理意见：同意</p>
	            </div> -->
              </span>
        </div>
        <div class="timeline-list list-left status-3" id="audit">          
            <a class="left-name" data-num="2">审核</a>
            <span class="audit">         
	         <!--    <div class="horizontal-line"></div>
	            <div class="status-details">
	                <div class="corner-content"><span class="top-dot"></span><span class="bottom-dot"></span></div>
	                 <p>操作人：张三</p>
	                 <p>操作时间：2016-12-12</p>
	                 <p>审核意见：同意</p>
	            </div> -->
          </span>
        </div>
        <div class="timeline-list list-right status-4" id="storage">                     
            <a class="right-name" data-num="3">入库</a>   
            <span class="warehousing">       
	           <!--  <div class="horizontal-line"></div>
	            <div class="status-details">
	                <div class="corner-content"><span class="top-dot"></span><span class="bottom-dot"></span></div>
	                 <p>操作人：张三</p>
	                 <p>入库时间：2016-12-12</p>
	            </div> -->
            </span>
        </div>   
        <div class="timeline-list list-left status-5" id="receive">          
            <a class="left-name" data-num="4">检材领用</a> 
            <span class="receive">        
	            <!-- <div class="horizontal-line"></div>
	            <div class="status-details">
	                <div class="corner-content"><span class="top-dot"></span><span class="bottom-dot"></span></div>
		                <p>鉴定人：李四</p>
		                <p>受理人：张三</p>
		                <p>领取时间：2016-12-12</p>
	            </div> -->
            </span>
        </div>
        <div class="timeline-list list-right status-6" id="authenticate">                     
            <a class="right-name" data-num="4">鉴定</a>
             <span class="authenticate">          
	            <!-- <div class="horizontal-line"></div>
	            <div class="status-details">
	                <div class="corner-content"><span class="top-dot"></span><span class="bottom-dot"></span></div>
	                <p>鉴定人：李四</p>
	                <p>鉴定时间：2016-12-12</p>
	                <p>鉴定设备数量：2</p>
	                <p>电子物证原始记录填写情况：已完成</p>
	            </div> -->
            </span>
        </div>  
        <div class="timeline-list list-left status-1" id="giveBack">          
            <a class="left-name" data-num="4">检材归还</a>    
            <span class="giveBack">     
	           <!--  <div class="horizontal-line"></div>
	            <div class="status-details">
	                <div class="corner-content"><span class="top-dot"></span><span class="bottom-dot"></span></div>
	                <p>鉴定人：李四</p>
	                <p>受理人：张三</p>
	                <p>归还时间：2016-12-12</p>
	            </div> -->
            </span>
        </div>
        <div class="timeline-list list-right status-2" id="document">                     
            <a class="right-name" data-num="4">文书</a>  
            <span class="document">        
	          <!--   <div class="horizontal-line document"></div>
	            <div class="status-details">
	                <div class="corner-content"><span class="top-dot"></span><span class="bottom-dot"></span></div>
		                <p>原始记录是否已审批：是</p>
		                <p>所需文书总数：7</p>
		                <p>是否已经全部打印：否</p>
	            </div> -->
            </span>
        </div> 
        <div class="timeline-list list-left status-3" id="outbound">          
            <a class="left-name" data-num="5">检材出库</a>   
            <span class="outbound">     
            <!-- <div class="horizontal-line"></div>
            <div class="status-details">
                <div class="corner-content"><span class="top-dot"></span><span class="bottom-dot"></span></div>
                
                <p>已通知委托人：是</p>
                <p>检材已出库：是</p>
                <p>委托人已确定：是</p>
                <p>受理人：张三</p>
                <p>委托人：王五</p>
                <p>出库时间：2016-12-12</p>
            </div> -->
            </span>
        </div>
        <div class="timeline-list list-right status-4" id="finish">                     
            <a class="right-name" data-num="5">完成</a>    
            <span class="finish">      
            <!-- <div class="horizontal-line"></div>
            <div class="status-details">
                <div class="corner-content"><span class="top-dot"></span><span class="bottom-dot"></span></div>
                <p>开始使用时间：2016-12-12 14:00</p>
                <p>结束使用时间：2016-12-12 16:00</p>
                <p>使用人：张三</p>
                <p>检材编号：23423423423</p>
                <p>案件编号：123211241212</p>
            </div> -->
            </span>
        </div>      
    </div>
    <div class="btn-content">
        <button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
    </div>
    <script>
    var goUrl='';
    $(function(){
    	var userrole ="${param.userrole}";
	    if( userrole != undefined && userrole != null && userrole != ''){
	    	$(".crumbs-text").html('当前位置：<a>电子物证管理</a><span>></span><a>物证预检登记</a><span>></span><a>查看</a>');
	    	//goUrl = "${pageContext.request.contextPath}/elecEVIDMgt/generalMessage/registerInfoView.do?commonAppraisalId="+"${param.id}&commonPreappraisalId="+appraisalData.preappraisalId+"&num="+num+'&userrole=1';
	    } 
	    
      	appraisalData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/loadDataById.do",{ "id" : "${param.id}" });
      	evidenceData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/evidence/getDataByAppraisalId.do",{ "appraisalId" : appraisalData.id });
      	inEvidenceLog = loadData("${pageContext.request.contextPath}/elecEVIDMgt/evidOpLog/getDataByEvidIdAndSpLabel.do",{ "evidId" : evidenceData.id , "spLabel" : 0 });
     	outEvidenceLog = loadData("${pageContext.request.contextPath}/elecEVIDMgt/evidOpLog/getDataByEvidIdAndSpLabel.do",{ "evidId" : evidenceData.id , "spLabel" : 1 });
     	preappraisalData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/preappraisal/loadPreappraisalData.do",{ "id" : appraisalData.preappraisalId });
    	finishData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/evidence/getDataByAppraisalId.do",{ "appraisalId" : appraisalData.id });
     	
     	appraisalData.entrustedDate=  new Date(appraisalData.entrustedDate).Format("yyyy-MM-dd hh:mm");
     	appraisalData.acceptedDate=  new Date(appraisalData.acceptedDate).Format("yyyy-MM-dd hh:mm");
     	appraisalData.auditedDate=  new Date(appraisalData.auditedDate).Format("yyyy-MM-dd hh:mm");
     	appraisalData.returnedDate=  new Date(appraisalData.returnedDate).Format("yyyy-MM-dd hh:mm");
     	inEvidenceLog.createdDate=  new Date(inEvidenceLog.createdDate).Format("yyyy-MM-dd hh:mm");
     	appraisalData.createdDate=  new Date(appraisalData.createdDate).Format("yyyy-MM-dd hh:mm");
     	outEvidenceLog.createdDate=  new Date(outEvidenceLog.createdDate).Format("yyyy-MM-dd hh:mm");
     	appraisalData.collectedDate=  new Date(appraisalData.collectedDate).Format("yyyy-MM-dd hh:mm");
     	appraisalData.appraisedStartDate=  new Date(appraisalData.appraisedStartDate).Format("yyyy-MM-dd hh:mm");
      	appraisalData.approvedDate=  new Date(appraisalData.approvedDate).Format("yyyy-MM-dd hh:mm");
      	finishData.createdDate = new Date(finishData.createdDate).Format("yyyy-MM-dd hh:mm");
     	 
         var appraisalHtml = '';
	    
        if(appraisalData.caseSn!=null&&appraisalData.caseSn!=''){
	    	appraisalHtml+='<div class="horizontal-line"></div> <div class="status-details"><div class="corner-content"><span class="top-dot"></span><span class="bottom-dot"></span></div>'
	    	+'<p>登记人：'+preappraisalData.creatorAlias+'</p><p>案件编号：'+appraisalData.caseSn+'</p><p>案件名称：'+appraisalData.caseName+'</p><p>委托单位：'+appraisalData.orgName+'</p>'
	    	+'<p>委托时间：'+appraisalData.entrustedDate+'</p><p>检材名称：'+appraisalData.evidName+'</p></div>'
	    }
	    
	   
        var acceptanceHtml='';
	    if(appraisalData.acceptorId!=null&&appraisalData.acceptorId!=''){
	    	acceptanceHtml+='<div class="horizontal-line "></div><div class="status-details"><div class="corner-content"><span class="top-dot"></span><span class="bottom-dot"></span></div>'
	    	+'<p>受理人：'+appraisalData.acceptorAlias+'</p><p>受理时间：'+appraisalData.acceptedDate+'</p>';
	    	if(appraisalData.status==1){
	    		acceptanceHtml+='<p>受理意见：不同意</p></div>';
	    	}else {
	    		acceptanceHtml+='<p>受理意见：同意</p></div>';
	    	}
	    }
	    
	    var auditHtml='';
	    if(appraisalData.auditorId!=null&&appraisalData.auditorId!=''){
	    	auditHtml+='<div class="horizontal-line "></div><div class="status-details"><div class="corner-content"><span class="top-dot"></span><span class="bottom-dot"></span></div>'
	    	+'<p>审核人：'+appraisalData.auditorAlias+'</p><p>审核时间：'+appraisalData.auditedDate+'</p>';
	    	if(appraisalData.status==3){
	    		auditHtml+='<p>审核意见：拒绝</p></div>';
	    	}else {
	    		auditHtml+='<p>审核意见：通过</p></div>';
	    	}
	    }
	    
	    
        
        var warehousingHtml='';
 	    if(inEvidenceLog.creatorId!=null&&inEvidenceLog.creatorId!=''){
	    	warehousingHtml+='<div class="horizontal-line "></div><div class="status-details"><div class="corner-content"><span class="top-dot"></span><span class="bottom-dot"></span></div>'
	    	         		+'<p>操作人：'+inEvidenceLog.creatorAlias+'</p><p>入库时间：'+inEvidenceLog.createdDate+'</p></div>';
	    }
	   
        var receiveHtml='';
        if(appraisalData.collectorId!=null&&appraisalData.collectorId!=''){
        	receiveHtml+='<div class="horizontal-line "></div><div class="status-details"><div class="corner-content"><span class="top-dot"></span><span class="bottom-dot"></span></div>'
    	    			+'<p>确认人：'+appraisalData.collectorAlias+'</p><p>领用时间：'+appraisalData.collectedDate+'</p></div>';
        }
        
        
        
        var authenticateHtml='';
        if(appraisalData.collectorId!=null&&appraisalData.collectorId!=''){
        	authenticateHtml+='<div class="horizontal-line "></div><div class="status-details"><div class="corner-content"><span class="top-dot"></span><span class="bottom-dot"></span></div>'
    	    			+'<p>鉴定人：'+appraisalData.collectorAlias+'</p><p>鉴定时间：'+appraisalData.appraisedStartDate+'</p>';
    	     if(appraisalData.status > 8){
    	    	 authenticateHtml+='<p>电子物证原始记录填写情况：已完成</p></div>';
    	     }else{
    	    	 authenticateHtml+='<p>电子物证原始记录填写情况： 未完成</p></div>';
    	     }
        }
	    
        //检材归还
        var giveBackHtml='';
	    if(appraisalData.returnerId!=null&&appraisalData.returnerId!=''){
	    	giveBackHtml+='<div class="horizontal-line "></div><div class="status-details"><div class="corner-content"><span class="top-dot"></span><span class="bottom-dot"></span></div>'
    			+'<p>确认人：'+appraisalData.returnerAlias+'</p><p>归还时间：'+appraisalData.returnedDate+'</p></div>';
	    }
	    
	   
        //到ingID是-----------------------------------------
        var outboundHtml='';
        if(outEvidenceLog.creatorId!=null&&outEvidenceLog.creatorId!=''){
        	outboundHtml+='<div class="horizontal-line "></div><div class="status-details"><div class="corner-content"><span class="top-dot"></span><span class="bottom-dot"></span></div>'
        		+'<p>操作人：'+outEvidenceLog.creatorAlias+'</p><p>出库时间：'+outEvidenceLog.createdDate+'</p></div>';
	    }
      	//到ingID是-----------------------------------------
        var documentHtml=''
        if(appraisalData.approverId!=null&&appraisalData.approverId!=''){
        	documentHtml+='<div class="horizontal-line "></div><div class="status-details"><div class="corner-content"><span class="top-dot"></span><span class="bottom-dot"></span></div>'
    			+'<p>操作人：'+appraisalData.approverAlias+'</p><p>审批时间：'+appraisalData.approvedDate+'</p></div>';
        }
      	
      	//完成(出库)
        var finishHtml='';
      
        if(appraisalData.approverId != null && appraisalData.approverId != ''){
        	finishHtml+='<div class="horizontal-line "></div><div class="status-details"><div class="corner-content"><span class="top-dot"></span><span class="bottom-dot"></span></div>'
    			+'<p>操作人：'+finishData.creatorAlias+'</p><p>操作时间：'+finishData.createdDate+'</p><p>文书存放位置：'+finishData.docLocation+'</p></div>';
        }
        
        
	    //登记
	    $(".appraisal").append(appraisalHtml);
	    //受理
	    $(".acceptance").append(acceptanceHtml);
	    //审核
	    $(".audit").append(auditHtml);
	    //入库
	    $(".warehousing").append(warehousingHtml);
	    //检材领用
	    $(".receive").append(receiveHtml);
	    //鉴定
	    $(".authenticate").append(authenticateHtml);
	    //检材归还
	    $(".giveBack").append(giveBackHtml);
	    //文书
	    $(".document").append(documentHtml);
	    //检材出库
	    $(".outbound").append(outboundHtml);
	  	//完成
	    $(".finish").append(finishHtml);
	    
	    
    })
    
	    $(".back-btn").click(function(){
	    	var userrole ="${param.userrole}";
	    	if( userrole != undefined && userrole != null && userrole != ''){
	    		$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/elecEVIDMgt/register/evidenceRegisterList.do');
	    	}else{
	    	  $('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/elecEVIDMgt/generalMessage/generalMessageList.do');
		    }
	    });
	    
	    $(".timeline-list > a").click(function(){
	    	var num = $(this).data("num");
	    	//var url = "${pageContext.request.contextPath}/elecEVIDMgt/generalMessage/registerInfoView.do?commonAppraisalId="+"${param.id}&commonPreappraisalId="+appraisalData.preappraisalId+"&num="+num;
	    	var a ="${param.userrole}";
		    if(  a != ''){
		    	goUrl = "${pageContext.request.contextPath}/elecEVIDMgt/generalMessage/registerInfoView.do?commonAppraisalId="+"${param.id}&commonPreappraisalId="+appraisalData.preappraisalId+"&num="+num+'&userrole=1';
		    }else{
		    	goUrl = "${pageContext.request.contextPath}/elecEVIDMgt/generalMessage/registerInfoView.do?commonAppraisalId="+"${param.id}&commonPreappraisalId="+appraisalData.preappraisalId+"&num="+num;
		    }
	    	$('.index-iframe' , window.parent.document ).attr('src',goUrl);
	    });
    </script>
</body>
</html>