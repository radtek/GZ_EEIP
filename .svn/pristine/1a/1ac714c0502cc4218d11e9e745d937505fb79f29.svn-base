<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>环境监控-查看</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>  	
	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script> 
	<script src="<c:url value="/resources/frameworks/pangolin/js/bracket-common.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
	<script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/toggles.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/echarts.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
  	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/deviceMgt/style-echarts.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
			当前位置：<a>设备与环境管理</a><span>></span><a>环境监控</a><span>></span><a>环境条件记录</a>
        </p>
    </div>
    <div class="echarts-contents">
        <div class="echarts-table">
            <div class="echarts-title">环境条件记录表</div>
            <div class="form-horizontal dataTimes">
            	<div class="form-group">
	                <label class="col-sm-2 control-label">时间段：</label>
	                <div class="col-sm-4">
	                    <input id="startDate" type="text" class="form-control datetimepicker datetimepicker-before" />
	                </div>
	                <div class="col-sm-4">
	                    <input id="endDate" type="text" class="form-control datetimepicker datetimepicker-after" />
	                </div>
	                <div class="col-sm-2">
	                    <button type="button" class="btn btn-color2 search"><i class="fa fa-search"></i>查询</button>
	                </div>
	            </div>
            </div>
            <table class="table table-bordered" id="table2">
                <thead>
                    <tr>
                        <th>时间</th>
                        <th>温度</th>
                        <th>湿度</th>
                    </tr>
                </thead>
                <tbody>
<!--                     <tr> -->
<!--                         <td>2017-01-04 10:00</td> -->
<!--                         <td>35℃</td> -->
<!--                         <td>50%</td> -->
<!--                     </tr> -->
                </tbody>
            </table>
        </div>
    </div>
    <div class="echarts-contents echarts-overflow">
        <div class="echarts-img">
            <div class="echarts-title">环境温度条件走势图</div>
            <div class="main" id="main1"></div>
        </div>
        <div class="echarts-img">
            <div class="echarts-title">环境湿度条件走势图</div>
            <div class="main" id="main2"></div>
        </div>
    </div>
    <div class="btn-content">
        <button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
    </div>
    <script type="text/javascript">
	    $(".back-btn").click(function(){
	    	var url = "${pageContext.request.contextPath}/envMgt/environmentalMonitoring.do";
	    	$(".index-iframe", window.parent.document).attr("src",url);
	    });
	    
    	$(function(){
    		var location = "${param.location}";
    		var startDate = "";
    		var endDate = "";
    		var DevEvn;
        	$(".search").click(function (){ 
        		startDate = $('#startDate').val().replace(/\s+/g, "");
        		endDate = $('#endDate').val().replace(/\s+/g, "");
        		if(startDate != null && startDate!= "" && startDate != undefined){
        			startDate = startDate.substring(0,10)+" "+startDate.substring(10,14);
        		}
        		if(endDate != null && endDate!= "" && endDate != undefined){
        			endDate = endDate.substring(0,10)+" "+endDate.substring(10,14);
        		}
            	devEvnDate(); 
        		loadGridData();
       	    });
    		
        	devEvnDate();
        	function devEvnDate(){
        		DevEvn = loadData("${pageContext.request.contextPath}/envMgt/DevEvn/loaddevEvnList.do", { "queryParam" : location,"endDate":endDate,"startDate":startDate });
				var collecteds =new Array();
				var temperatures =new Array();
				var humiditys =new Array();
				for(var i = 0 ; i < DevEvn.length ; i++){
					collecteds[i] = new Date(DevEvn[i].collectedDate).Format("MM/dd");
				}
				for(var i = 0 ; i < DevEvn.length ; i++){
					temperatures[i] = DevEvn[i].temperature;
				}
				for(var i = 0 ; i < DevEvn.length ; i++){
					humiditys[i] = DevEvn[i].humidity;
				}
				collecteds = collecteds.reverse()
				temperatures = temperatures.reverse()
				humiditys = humiditys.reverse()
// 				console.log(collecteds)
// 				console.log(temperatures)
// 				console.log(humiditys)
				
				var myChart = echarts.init(document.getElementById('main1'));
		        option = {
		            color:['#64a565'],
		            tooltip : {
		                trigger: 'axis'
		            },
		            grid: {
		                left: '5%',
		                right: '5%',
		                bottom: '0%',
		                top:'7%',
		                containLabel: true
		            },
		            xAxis : [
		                {
		                    type : 'category',
		                    boundaryGap : false,
		                    data : collecteds
		                }
		            ],
		            yAxis : [
		                {
		                    type : 'value'
		                }
		            ],
		            series : [
		                {
		                    name:'温度',
		                    type:'line',
		                    areaStyle: {normal: {}},
		                    data:temperatures
		                }
		            ]
		        };
		        myChart.setOption(option);
		        
		        var myChart2 = echarts.init(document.getElementById('main2'));
		        option2 = {
		            color:['#64a565'],
		            tooltip : {
		                trigger: 'axis'
		            },
		            grid: {
		                left: '5%',
		                right: '5%',
		                bottom: '0%',
		                top:'7%',
		                containLabel: true
		            },
		            xAxis : [
		                {
		                    type : 'category',
		                    boundaryGap : false,
		                    data : collecteds
		                }
		            ],
		            yAxis : [
		                {
		                    type : 'value'
		                }
		            ],
		            series : [
		                {
		                    name:'湿度',
		                    type:'line',
		                    areaStyle: {normal: {}},
		                    data:humiditys
		                }
		            ]
		        };
		        myChart2.setOption(option2);
				
				
				
        	}
        	
    		$('.datetimepicker').datetimepicker({
   		       format: 'YYYY-MM-DD  HH:mm',
   		    });
   	    	$(".datetimepicker-before").on("dp.change",function (e) {
   	            $('.datetimepicker-after').data("DateTimePicker").minDate(e.date);
   	        });
   	        $(".datetimepicker-after").on("dp.change",function (e) {
   	            $('.datetimepicker-before').data("DateTimePicker").maxDate(e.date);
   	        });
    		
    		function getT(data,type,row){
    			return data+"℃";
    		}
    		function getH(data,type,row){
    			return data+"%";
    		}
    	   	
    		loadGridData();
        	
    		//加载列表数据
    		function loadGridData() {
    			//数据列绑定
    			var columns = [
    				{ "mData" : "collectedDate", "bSortable" : false, "mRender": getFormattedDate},
    				{ "mData" : "temperature", "bSortable" : false, "mRender":getT},
    				{ "mData" : "humidity", "bSortable" : false, "mRender":getH},
                ];
          	
    			//排序规则
    			var sorting = [ [ 0 , 'desc' ] ];
        	  
        		//扩展参数
    			var extraParams = [
					{ "name" : "queryParam", "value" : location },
					{ "name" : "startDate", "value" : startDate },
					{ "name" : "endDate", "value" : endDate },
					];
    			
    			//初始化数据表
    			dataTable = new BSDataTable();
    			dataTable.initialize({
    				"tableId" : "table2",
    				"columns" : columns,
    				"sorting" : sorting,
    				"pageSize" : DEFAULT_PAGE_SIZE,
    				"dataSource" : "${pageContext.request.contextPath}/envMgt/DevEvn/DevEvnGirdData.do",
    				"extraParams" : extraParams,
    				"style" : DT_FULL_NUMBERS,
    				"bProcessing" : true,
    				"url" : {
    				}
    			});
                
    			//隐藏列表组件显示条数  --  数量   和 分页
    			$('#table2_length').hide();
    			$('#table2_paginate').hide();
    			$('#table2_info').hide();
             }
        })
    </script>
</body>
</html>