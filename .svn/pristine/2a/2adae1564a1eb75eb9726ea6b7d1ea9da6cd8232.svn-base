<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>设备使用情况</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
	<script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
	<script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/bracket-common.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/toggles.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
 	
 	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/deviceMgt/deviceMgt-form.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>设备与环境管理</a><span>></span><a>设备管理</a><span>></span><a>查看</a>
        </p>
    </div>
    <div class="main-content" data-num="5">
        <jsp:include page="/common/deviceMgtLeftNav.jsp"></jsp:include>
        <div class="right-form">
            <div class="right-content">
            	<div class="form-title">仪器设备使用情况（2017年）</div>
                <div class="form-content">
                    <form class="form-horizontal">
			            <div class="form-group">
			                <label class="col-sm-2 control-label">设备识别号：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                    <input type="text" data-bind="value:identifier" name="identifier" id="identifier" class="form-control" readonly />
			                </div>
			                <label class="col-sm-2 control-label">设备名称：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                    <input type="text" data-bind="value:name" name="name" id="name" class="form-control" readonly />
			                </div>
			            </div>
                    </form>
                </div>
                <div class="file-upload">
                    <table class="table table-bordered" id="table2">
                        <thead>
                            <tr>
			                    <th class="serial-num">序号</th>
			                    <th>使用开始时间</th>
			                    <th>使用结束时间</th>
			                    <th>检材编号或检测样品批号</th>
			                    <th>设备状况</th>
			                    <th>使用人</th>
			                    <th>备注</th>
			                    <th>创建时间</th>
			                </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                    <div class="explanation-content">
			            <p>说明: 1. 设备运转正常则在设备状况栏中打勾；2. 设备运转不正常则在设备状况栏中打叉，并在备注栏中详细注明出现的问题。</p>
			        </div>
                </div>
                
                <!-- <div class="upload-module">
                    <div class="module-title">
                        <p>设备使用情况记录表-历史</p>
                    </div>
                    <div class="upload-content upload-padding">
                        <div class="upload-input">
                            <span class="upload-file-name">仪器设备使用记录1（2012年度）.doc</span>
                        </div>
                        <div class="upload-btn">
                            <button class="btn btn-color1"><i class="fa fa-download"></i>下载</button>
                            <button class="btn btn-color2"><i class="fa fa-print"></i>打印</button>
                        </div>
                    </div>
                    <div class="upload-content upload-padding">
                        <div class="upload-input">
                            <span class="upload-file-name">仪器设备使用记录2（2012年度）.doc</span>
                        </div>
                        <div class="upload-btn">
                            <button class="btn btn-color1"><i class="fa fa-download"></i>下载</button>
                            <button class="btn btn-color2"><i class="fa fa-print"></i>打印</button>
                        </div>
                    </div>
                    <div class="upload-content upload-padding">
                        <div class="upload-input">
                            <span class="upload-file-name">仪器设备使用记录3（2012年度）.doc</span>
                        </div>
                        <div class="upload-btn">
                            <button class="btn btn-color1"><i class="fa fa-download"></i>下载</button>
                            <button class="btn btn-color2"><i class="fa fa-print"></i>打印</button>
                        </div>
                    </div>
                </div> -->
                <div class="btn-content">
                    <button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
                    <!-- <button class="btn btn-color1"><i class="fa fa-print"></i>打印</button> -->
                </div>
            </div>
        </div>
    </div>
    <script>
    	var id = "${param.id}";
        var num = $(".main-content").data("num");
        $(".left-nav li").eq(num).addClass("action");
        
        $(".left-nav li a").click(function(){
            var url = $(this).data("url");
            $(".index-iframe", window.parent.document).attr("src",url+"?id="+id);
        });
        
        $(".back-btn").click(function(){
	    	var url = "${pageContext.request.contextPath}/deviceMgt/deviceMgtList.do";
	    	$(".index-iframe", window.parent.document).attr("src",url+"?id="+id);
	    });
        
		var deviceDateSource = loadData("${ pageContext.request.contextPath }/deviceMgt/device/loadDeviceData.do", { "id" : "${param.id}" });
        
        var deviceDateVM = ko.mapping.fromJS(deviceDateSource);
        
        var vm = {
        	deviceVM : deviceDateVM
        }
        
        ko.applyBindings(vm);
        
    	$(function(){
    		
    	   	function getDate(data, type, row) {
    	   		return new Date(data).Format("yyyy-MM-dd");
			}
//     	   	function getElecEvidSn(data, type, row) {
// //     	   		return "66666";
//     	   	}
    	   	var number = 0;
    	   	function getNumber(data, type, row){
    	   		number++;
    	   		number2 = number/2;
    	   		return number2;
    	   	}
    	   	function getStatus(data, type, row) {
    	   		if(data == 1 || data == 0){
    	   			return "正常";
    	   		}else if(data == 2){
    	   			return "维修";
    	   		}else{
    	   			return "报废";
    	   		}
    	   	}
    	   	
    		loadGridData();
        	
    		//加载列表数据
    		function loadGridData() {
    			//数据列绑定
    			var columns = [
    				{ "mData" : null , "bSortable" : false, "mRender": getNumber, "sWidth":"6em"},
    				{ "mData" : "startDate" , "bSortable" : false, "mRender": getDate},
    				{ "mData" : "endDate", "bSortable" : false , "mRender": getDate},
    				{ "mData" : "evidSn", "bSortable" : false },
    				{ "mData" : "devStatus", "bSortable" : false , "mRender": getStatus},
    				{ "mData" : "operatorAlias", "bSortable" : false },
    				{ "mData" : "remarks", "bSortable" : false },
    				{ "mData" : "createdDate", "bSortable" : false,"bVisible" : false }
                ];
          	
    			//排序规则
    			var sorting = [ [ 7 , 'desc' ] ];
        	  
    			//扩展参数
    			var extraParams = [ {
    				"name" : "devId",
    				"value" : id
    			} ];
    			//初始化数据表
    			dataTable = new BSDataTable();
    			dataTable.initialize({
    				"tableId" : "table2",
    				"columns" : columns,
    				"sorting" : sorting,
    				"pageSize" : DEFAULT_PAGE_SIZE,
    				"dataSource" : "${pageContext.request.contextPath}/deviceMgt/devUsingSitn/DevUsingSitnGirdData.do",
    				"extraParams" : extraParams,
    				"style" : DT_FULL_NUMBERS,
    				"bProcessing" : true,
    				"url" : {
//     					"addDataUrl" : "/eeip/meetingMgt/generalMeet/meetingApplyForm.do",
//     					"editDataUrl" : "/eeip/meetingMgt/generalMeet/meetingApplyForm.do",
//     					"rmDataUrl" : "/eeip/meeting/meetingApp/removeMeetingAppData.do"
    				}
    			});
                
    			//隐藏列表组件显示条数  --  数量   和 分页
    			$('#table2_length').hide();
    			$('#table2_paginate').hide();
    			$('#table2_info').hide();
             }
    		
    		sorting();
        });
        
        function sorting(){
       	  	$(".table tbody tr").each(function(){
       	    	var index = $(this).index();
       	    	var num = index+1;
       	    	$(this).find("td").eq(0).text(num);
       	  	});
       	}
    </script>
</body>
</html>