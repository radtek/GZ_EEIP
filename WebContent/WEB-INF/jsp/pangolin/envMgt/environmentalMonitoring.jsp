<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>环境监控</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/echarts.js" />"></script>
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/deviceMgt/style-echarts.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
			当前位置：<a>设备与环境管理</a><span>></span><a>环境监控</a>
        </p>
    </div>
    <div class="echarts-content border-top">
        <div class="echarts-img">
            <div class="echarts-title">温度</div>
            <div class="main" id="main1"></div>
            <div class="tooltip-content temperatures">35</div>
        </div>
        <div class="echarts-img">
            <div class="echarts-title">湿度</div>
            <div class="main" id="main2"></div>
            <div class="tooltip-content humiditys">50%</div>
        </div>
        <div class="echarts-btn">
	        <button class="btn btn-color1 recording-btn" id="OFFICE_ROOM"><i class="fa fa-file-text-o"></i>环境条件记录</button>
	    </div>
    </div>
    <div class="echarts-content">
        <div class="echarts-img">
            <div class="echarts-title">温度</div>
            <div class="main" id="main3"></div>
            <div class="tooltip-content temperature">35</div>
        </div>
        <div class="echarts-img">
            <div class="echarts-title">湿度</div>
            <div class="main" id="main4"></div>
            <div class="tooltip-content humidity">50%</div>
        </div>
        <div class="echarts-btn">
	        <button class="btn btn-color1 recording-btn" id="SERVER_ROOM"><i class="fa fa-file-text-o"></i>环境条件记录</button>
	    </div>
    </div>
    
    <script type="text/javascript">
	    $(".recording-btn").click(function(){
	    	var location = $(this).attr("id");
	    	var url = "${pageContext.request.contextPath}/envMgt/environmentalMonitoringViewer.do?location="+location;
	    	$(".index-iframe", window.parent.document).attr("src",url);
	    });
	    
	    $(".refresh-btn").click(function(){
	    	window.location.reload();
	    });
	    
	    var temperature = 0;//温度
	    var humidity = 0;//湿度
		$.ajax({
			url:'${ pageContext.request.contextPath }/envMgt/DevEvn/loadDevEvnDate.do',
			type:'post',
			data : { "location" : "OFFICE_ROOM" },
			success : function(data){
				data = data.entity;
				temperature = data.temperature;
				humidity = data.humidity;
				$(".temperatures").html(temperature+"℃");
				$(".humiditys").html(humidity+"%");
				var totalTemperature = 100-temperature;
				if(temperature >= 100){
					totalTemperature = parseInt((temperature/100)+1)*100;
					totalTemperature = totalTemperature - temperature;
				}
				//温度
		        var myChart = echarts.init(document.getElementById('main1'));
		        option = {
		            color:['#64a565','#282e50'],
		            series: [
		                {
		                    type:'pie',
		                    hoverAnimation:false,
		                    radius: ['80%', '90%'],
		                    label: {
		                        normal: {
		                            show: false,
		                        }
		                    },
		                    data:[
		                        {value:temperature},
		                        {value:totalTemperature},
		                    ]
		                }
		            ]
		        };
				myChart.setOption(option);

		        
		      //湿度
		        var myChart2 = echarts.init(document.getElementById('main2'));
		        option2 = {
		            color:['#64a565','#282e50'],
		            series: [
		                {
		                    type:'pie',
		                    hoverAnimation:false,
		                    radius: ['80%', '90%'],
		                    label: {
		                        normal: {
		                            show: false,
		                        }
		                    },
		                    data:[
		                        {value:humidity,},
		                        {value:100-humidity,},
		                    ]
		                }
		            ]
		        };
		        myChart2.setOption(option2);
			}
		})
		
		$.ajax({
			url:'${ pageContext.request.contextPath }/envMgt/DevEvn/loadDevEvnDate.do',
			type:'post',
			data : { "location" : "SERVER_ROOM" },
			success : function(data){
				data = data.entity;
				temperature = data.temperature;
				humidity = data.humidity;
				$(".temperature").html(temperature+"℃");
				$(".humidity").html(humidity+"%");
				var totalTemperature = 100-temperature;
				if(temperature >= 100){
					totalTemperature = parseInt((temperature/100)+1)*100;
					totalTemperature = totalTemperature - temperature;
				}
				//温度
			    var myChart3 = echarts.init(document.getElementById('main3'));
		        option3 = {
		            color:['#64a565','#282e50'],
		            series: [
		                {
		                    type:'pie',
		                    hoverAnimation:false,
		                    radius: ['80%', '90%'],
		                    label: {
		                        normal: {
		                            show: false,
		                        }
		                    },
		                    data:[
		                        {value:temperature},
		                        {value:totalTemperature},
		                    ]
		                }
		            ]
		        };
				myChart3.setOption(option3);

		        
		      //湿度
				var myChart4 = echarts.init(document.getElementById('main4'));
		        option4 = {
		            color:['#64a565','#282e50'],
		            series: [
		                {
		                    type:'pie',
		                    hoverAnimation:false,
		                    radius: ['80%', '90%'],
		                    label: {
		                        normal: {
		                            show: false,
		                        }
		                    },
		                    data:[
		                        {value:humidity,},
		                        {value:100-humidity,},
		                    ]
		                }
		            ]
		        };
				myChart4.setOption(option4);
			}
		})
    </script>
</body>
</html>