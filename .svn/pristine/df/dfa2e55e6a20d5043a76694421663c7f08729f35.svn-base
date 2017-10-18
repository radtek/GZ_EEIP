<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>现场勘验率</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>	
  	<script src="<c:url value="/resources/frameworks/echarts2/echarts.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/echarts2/macarons.js" />"></script>
  	 	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" /> 
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />	
  	<style>
  		.echarts-item{width:100%;}
		.echarts-item .top,.echarts-item .bottom{width:100%;height:50%;}
		#echarts1,#echarts2{width:50%;height:100%;float:left;}
		#echarts3{width:100%;height:100%;}
	</style>
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
			当前位置：<a>统计分析</a><span>></span><a>比率分析</a><span>></span><a>现场勘验率</a>
        </p>
    </div>
    <div class="echarts-item">
		<div class="top">
			<div id="echarts1"></div>
			<div id="echarts2"></div>
		</div>
		<div class="bottom">
			<div id="echarts3"></div>			
		</div>
    </div>
    <script>
    var height = $(window).height();
    $(".echarts-item").css("height",height-49);
    var myChart1 = echarts.init(document.getElementById("echarts1"));
    var option1 = {
	   	    title: {
	   	        text: '历年广州市现场勘验率趋势分析'	,
	   	     	left: 'center'
	   	    },
	   	    tooltip: {
	   	        trigger: 'axis'
	   	    },	   	   	   	    
	   	    xAxis:  {
	   	        type: 'category',	   	        
	   	        data: ['2008年','2009年','2010年','2011年','2012年','2013年','2014年','2015年','2016年','2017年']
	   	    },
	   	    yAxis: {
	   	        type: 'value',
	   	       
	   	    },
	   	    series: [
	   	        {
	   	            name:'最高气温',
	   	            type:'line',
	   	         	
	   	            data:[3601, 3412, 3845, 4113, 4866, 5337, 5981, 6479, 7132, 8332],  	            
	   	        }	        
	   	    ]
   	};
    myChart1.setOption(option1);
    
    var myChart2 = echarts.init(document.getElementById("echarts2"));
    var option2 = {
	   	    title: {
	   	        text: '2016年广州市现场勘验率趋势分析',
	   	     	left: 'center'
	   	    },
	   	    tooltip: {
	   	        trigger: 'axis'
	   	    },	   	   	   	    
	   	    xAxis:  {
	   	        type: 'category',	   	       
	   	        data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
	   	    },
	   	    yAxis: {
	   	        type: 'value',
	   	       
	   	    },
	   	    series: [
	   	        {
	   	            name:'最高气温',
	   	            type:'line',
	   	         	
	   	            data:[517, 234, 413, 678, 767, 1087, 1192, 1333, 1432, 321, 255, 123],  	            
	   	        }	        
	   	    ]
   	};
    myChart2.setOption(option2);
    
    var myChart3 = echarts.init(document.getElementById("echarts3"));
    var option3 = {
	   	    title: {
	   	        text: '2016年广州市各区现场勘验率对比',
	   	     	left: 'center'
	   	    },
	   	    tooltip: {
	   	        trigger: 'axis'
	   	    },	   	   	   	    
	   	    xAxis:  {
	   	        type: 'category',	   	        
	   	        data: ['荔湾区','越秀区','海珠区','天河区','白云区','黄浦区','番禺区','花都区','南沙区','从化区','增城区'],
	   	     	axisTick: {
	                alignWithLabel: true
	            }
	   	    },
	   	    yAxis: {
	   	        type: 'value',
	   	       
	   	    },
	   	    series: [
	   	        {
	   	            name:'最高气温',
	   	            type:'bar',   	         	
	   	            data:[517, 234, 413, 678, 767, 1087, 1192, 1333, 1432, 321, 498],  	            
	   	        }	        
	   	    ]
   	};
    myChart3.setOption(option3);      
    </script>
</body>
</html>