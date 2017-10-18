<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>设备维护列表-查看</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
  	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/deviceMgt/timeline.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
			当前位置：<a>设备与环境管理</a><span>></span><a>设备维护</a><span>></span><a>查看</a>
        </p>
    </div>
    <div class="timeline-content">
		<div class="timeline-header">
            <p class="header-icon"><i class="glyphicon glyphicon-map-marker" title="最新信息"></i></p>
            <p class="header-time"></p>
            <div class="list-btn">+</div>
            <sys:auth grant="EQPT_MAINTENANCE_ADD" username="${sessionScope.loginUser.userName}">
            <div class="header-add-content">
                <a data-url="${pageContext.request.contextPath}/deviceMgt/softwareUpgradeForm.do?id=${param.id}">软件升级</a>
                <a data-url="${pageContext.request.contextPath}/deviceMgt/maintenanceForm.do?id=${param.id}">维护保养</a>
                <a data-url="${pageContext.request.contextPath}/deviceMgt/deviceVerificationRecordForm.do?id=${param.id}">设备核查情况记录</a>
            </div>
            </sys:auth>
        </div>
        <!-- <div class="timeline-list list-right status-use">
            <div class="time-point">
                <div class="vertical-line"></div>
                <div class="point-content"><span></span></div>
            </div>
            <div class="status-name">设备使用情况</div>
            <div class="status-time">2017-02-06  13:00</div>
            <div class="horizontal-line"></div>
            <div class="status-details">
                <div class="corner-content"><span class="top-dot"></span><span class="bottom-dot"></span></div>
                <p>开始使用时间：2016-12-12 14:00</p>
                <p>结束使用时间：2016-12-12 16:00</p>
                <p>使用人：张三</p>
                <p>检材编号：23423423423</p>
            </div>
        </div>
        <div class="timeline-list list-left status-upgrade">
            <div class="time-point">
                <div class="vertical-line"></div>
                <div class="point-content"><span></span></div>
            </div>
            <div class="status-name">软件升级</div>
            <div class="status-time">2017-02-06  13:00</div>
            <div class="horizontal-line"></div>
            <div class="status-details">
                <div class="corner-content"><span class="top-dot"></span><span class="bottom-dot"></span></div>
                <p>软件名称：软件</p>
                <p>操作人：张三</p>
                <p>备注：23423423423</p>
            </div>
        </div>
        <div class="timeline-list list-right status-maintain">
            <div class="time-point">
                <div class="vertical-line"></div>
                <div class="point-content"><span></span></div>
            </div>
            <div class="status-name">维护保养</div>
            <div class="status-time">2017-02-06  13:00</div>
            <div class="horizontal-line"></div>
            <div class="status-details">
                <div class="corner-content"><span class="top-dot"></span><span class="bottom-dot"></span></div>
                <p>维护人：张三</p>
                <p>维护时间：2016-12-12 12:12</p>
                <p>维护内容：</p>
                <p>备注：</p>
            </div>
        </div>
        <div class="timeline-list list-left status-inspect">
            <div class="time-point">
                <div class="vertical-line"></div>
                <div class="point-content"><span></span></div>
            </div>
            <div class="status-name">设备核查情况</div>
            <div class="status-time">2017-02-06  13:00</div>
            <div class="horizontal-line"></div>
            <div class="status-details">
                <div class="corner-content"><span class="top-dot"></span><span class="bottom-dot"></span></div>
                <p>核查人：张三</p>
                <p>核查时间：2016-12-12 12:12</p>
                <p>核查结果：正常/不正常</p>
            </div>
        </div>
        <div class="timeline-list list-right status-use">
            <div class="time-point">
                <div class="vertical-line"></div>
                <div class="point-content"><span></span></div>
            </div>
            <div class="status-name">设备使用</div>
            <div class="status-time">2017-02-06  13:00</div>
            <div class="horizontal-line"></div>
            <div class="status-details">
                <div class="corner-content"><span class="top-dot"></span><span class="bottom-dot"></span></div>
                <p>开始使用时间：2016-12-12 14:00</p>
                <p>结束使用时间：2016-12-12 16:00</p>
                <p>使用人：张三</p>
                <p>检材编号：23423423423</p>
                <p>案件编号：123211241212</p>
            </div>
        </div> -->
        <div id="situationAll">
        </div>           
        <div class="timeline-list status-inspect">
            <div class="time-point page-point">
                <div class="vertical-line"></div>
                <div class="point-content">
                	<button type="button" class="btn point-btn point-up" title="之前的信息"><i class="fa fa-angle-up"></i></button>
                	<button type="button" class="btn point-btn point-down" title="之后的信息"><i class="fa fa-angle-down"></i></button>
                </div>
            </div>
        </div>
        <div class="timeline-footer" title="最原始信息">
            <p class="footer-icon"><i class="fa fa-calendar-o"></i><span>始</span></p>
            <p class="footer-time"></p>
        </div>
    </div>
    <div class="btn-content">
        <button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
    </div>
    <script>
    	var id = "${param.id}";
        $(".list-btn").click(function(event){
            event.stopPropagation();
            $(".header-add-content").toggle();  
            return false;
        });
        $(document).click(function(event){
            var _con = $(".header-add-content");
            if(!_con.is(event.target) && _con.has(event.target).length === 0){
                $(".header-add-content").hide();
            }
        });
        
        $(".back-btn").click(function(){
        	var url = "${pageContext.request.contextPath}/deviceMgt/deviceMaintainList.do";
        	$(".index-iframe", window.parent.document).attr("src",url+"?id="+id);
        });
        
        $(".header-add-content a").click(function(){
        	var url = $(this).data("url");
        	$(".index-iframe", window.parent.document).attr("src",url);
        });
        
        var lifeCycleList = loadData("${ pageContext.request.contextPath }/deviceMgt/device/getLifeCycleListData.do", { "id" : id });
        console.log(lifeCycleList);
        var listLength = lifeCycleList.length; 
        var numList = 0;
        if(listLength>5){
        	createList(5);
        }else{
        	createList(listLength);
        }
        $(".point-down").click(function(){         
        	if(listLength>(numList+5)){
        		numList = numList + 5;
        		createList(numList+5);
        		
        	}else if(listLength<=(numList+10)&&listLength>(numList+5)){   
        		numList = numList + 5;
        		createList(listLength);
        	}       	        	
        })
        $(".point-up").click(function(){
        	if(numList>=5){
        		numList = numList - 5;
        		createList(numList+5);
        	}
        });
        function createList(len){
        	var headerTime = new Date(lifeCycleList[numList].createDate).Format("yyyy-MM-dd");
        	var footTime = len - 1;
        	if(footTime >= listLength){
        		footTime = listLength - 1;
        	}
        	var footerTime = new Date(lifeCycleList[footTime].createDate).Format("yyyy-MM-dd");
        	$(".header-time").text(headerTime);
        	$(".footer-time").text(footerTime);
        	$("#situationAll").html("");
        	for(i = numList ; i < len ; i++){
            	var listSite;
            	if((i+1)%2){
            		listSite = "list-left";
            	}else{
            		listSite = "list-right";
            	}
            	var type = lifeCycleList[i].type;
            	if(type=="0"){
            		$("#situationAll").append('<div class="timeline-list '+listSite+' status-maintain">'
    						 +'<div class="time-point">'
    						 +'<div class="vertical-line"></div>'
    						 +'<div class="point-content"><span></span></div>'
    						 +'</div>'
    						 +' <div class="status-name">维护保养</div>'
    						 +'<div class="status-time">'+new Date(lifeCycleList[i].createDate).Format("yyyy-MM-dd")+'</div>'
    						 +'<div class="horizontal-line"></div>'
    						 +'<div class="status-details">'
    						 +'<div class="corner-content"><span class="top-dot"></span><span class="bottom-dot"></span></div>'
    						 +'<p>维护人：'+lifeCycleList[i].userAlias+'</p>'
    						 +'<p>维护时间：'+new Date(lifeCycleList[i].startDate).Format("yyyy-MM-dd")+'</p>'
    						 +'<p>维护内容：'+lifeCycleList[i].content+'</p>'
    						 +'<p>备注：'+lifeCycleList[i].remarks+'</p>'
    						 +'</div>'
    						 +'</div>'      								
    				);    		
            		
       
            	}else if(type=="1"){
            		$("#situationAll").append('<div class="timeline-list '+listSite+' status-upgrade">'
    						 +'<div class="time-point">'
    						 +'<div class="vertical-line"></div>'					
    						 +'<div class="point-content"><span></span></div>'
    						 +' </div>'
    						 +' <div class="status-name">软件升级</div>'
    						 +'<div class="status-time">'+new Date(lifeCycleList[i].createDate).Format("yyyy-MM-dd")+'</div>'
    						 +'<div class="horizontal-line"></div>'
    						 +'<div class="status-details">'
    						 +'<div class="corner-content"><span class="top-dot"></span><span class="bottom-dot"></span></div>'
    						 +'<p>软件名称：'+lifeCycleList[i].softName+'</p>'
    						 +'<p>操作人：'+lifeCycleList[i].userAlias+'</p>'
    						 +'<p>备注：'+lifeCycleList[i].remarks+'</p>'
    						 +'</div>'
    						 +'</div>'      								
    				);	
            	}else if(type=="2"){
            		$("#situationAll").append('<div class="timeline-list '+listSite+' status-use">'
    						 +'<div class="time-point">'
    						 +'<div class="vertical-line"></div>'
    						 +'<div class="point-content"><span></span></div>'
    						 +' </div>'
    						 +' <div class="status-name">设备使用情况</div>'
    						 +'<div class="status-time">'+new Date(lifeCycleList[i].createDate).Format("yyyy-MM-dd")+'</div>'
    						 +'<div class="horizontal-line"></div>'
    						 +'<div class="status-details">'
    						 +'<div class="corner-content"><span class="top-dot"></span><span class="bottom-dot"></span></div>'
    						 +'<p>开始使用时间：'+new Date(lifeCycleList[i].startDate).Format("yyyy-MM-dd")+'</p>'
    						 +'<p>结束使用时间：'+new Date(lifeCycleList[i].endDate).Format("yyyy-MM-dd")+'</p>'
    						 +'<p>使用人：'+lifeCycleList[i].userAlias+'</p>'
    						 +' <p>检材编号：'+lifeCycleList[i].evidSn+'</p>'
    						 +'</div>'
    						 +'</div>'      								
    				);
            	}else{
            		$("#situationAll").append('<div class="timeline-list '+listSite+' status-inspect">'
    						 +'<div class="time-point">'
    						 +'<div class="vertical-line"></div>'
    						 +'<div class="point-content"><span></span></div>'
    						 +' </div>'
    						 +' <div class="status-name">设备核查情况</div>'
    						 +'<div class="status-time">'+new Date(lifeCycleList[i].createDate).Format("yyyy-MM-dd")+'</div>'
    						 +'<div class="horizontal-line"></div>'
    						 +'<div class="status-details">'
    						 +'<div class="corner-content"><span class="top-dot"></span><span class="bottom-dot"></span></div>'
    						 +'<p>核查人：'+lifeCycleList[i].userAlias+'</p>'
    						 +'<p>核查时间：'+new Date(lifeCycleList[i].startDate).Format("yyyy-MM-dd")+'</p>'
    						 +'<p>核查结果：'+lifeCycleList[i].result+'</p>'
    						 +'</div>'
    						 +'</div>'      								
    				);
            	}
            }
        }
        
		
        
    </script>
</body>
</html>