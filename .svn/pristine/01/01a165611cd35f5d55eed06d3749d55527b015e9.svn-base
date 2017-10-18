<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>取证应用率</title>
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
			当前位置：<a>统计分析</a><span>></span><a>比率分析</a><span>></span><a>取证应用率</a>
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
    var year = null;
    var month = null;
    $(function(){
    	var height = $(window).height();
    	$(".echarts-item").css("height",height-49);
    	$.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/criminalFilingQty/yearRatioData.do",
            data: {},
            dataType: "json",
            success: function(data){
           	  setHistory(data.qty,data.date);
           	  getMonth(null);
           	  getCountry(null);
            },
	    	 error: function(data){
	    		 
	    	 }
   	 }); 
    });
    
    function getMonth(yearv){
    	if(yearv == null){
    		var myDate = new Date();
    		yearv = myDate.getFullYear();; 
    	}
    	var title = yearv+'年广州市取证应用率趋势分析';
    	$.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/criminalFilingQty/monthRatioData.do",
            data: {year : yearv},
            dataType: "json",
            success: function(data){
           	  setMonth(data.qty,data.date,title);
            },
	    	 error: function(data){
	    	 }
   	 }); 
    }
    
   function getCountry(yearv,monthv){
	   if(yearv == null){
   		var myDate = new Date();
   		yearv = myDate.getFullYear();; 
   	}
   	var title = yearv+'年广州市各区取证应用率对比分析';
   	if(monthv != null){
   		var title = yearv+'年'+monthv+'月广州市各区取证应用率对比分析';
   	}
   	
   	$.ajax({
           type: "POST",
           url: "${pageContext.request.contextPath}/criminalFilingQty/countryRatioData.do",
           data: {year : yearv,month:monthv},
           dataType: "json",
           success: function(data){
          	  setCountry(data.qty,data.country,title);
           },
	    	 error: function(data){
	    	 }
  	 }); 
    }
    
    
    
    function setHistory(y,x){
    	var myChart1 = echarts.init(document.getElementById("echarts1"));
        var option1 = {
    	   	    title: {
    	   	        text: '历年广州市取证应用率趋势分析'	,
    	   	     	left: 'center'
    	   	    },
    	   	    tooltip: {
    	   	        trigger: 'axis'
    	   	    },	   	   	   	    
    	   	    xAxis:  {
    	   	        type: 'category',	   	        
    	   	        data:  x,
    	   	    },
    	   	    yAxis: {
    	   	        type: 'value',
    	   	       
    	   	    },
    	   	    series: [
    	   	        {
    	   	            name:'取证应用率',
    	   	            type:'line',
    	   	            data: y,  	            
    	   	        }	        
    	   	    ]
       	};
        myChart1.setOption(option1);
        function updateYear(param) { 
	    	console.log(param);
	    	var years = param["name"];
	    	year = years.substring(0,4);
	    	getYear(year);
	    	getCountry(year,null);
		}
	    myChart1.on("click", updateYear);
    };
    
  function setMonth(y,x,title){

	    var myChart2 = echarts.init(document.getElementById("echarts2"));
	    var option2 = {
		   	    title: {
		   	        text: title,
		   	     	left: 'center'
		   	    },
		   	    tooltip: {
		   	        trigger: 'axis'
		   	    },	   	   	   	    
		   	    xAxis:  {
		   	        type: 'category',	   	       
		   	        data: x,
		   	    },
		   	    yAxis: {
		   	        type: 'value',
		   	       
		   	    },
		   	    series: [
		   	        {
		   	            name:'取证应用率',
		   	            type:'line',
		   	            data: y,  	            
		   	        }	        
		   	    ]
	   	};
	    myChart2.setOption(option2);
	    function updateMonth(param) { 
	    	console.log(param);
	    	var months = param["name"];
	    	month = months.substring(0,1);
	    	getCountry(year,month);
		}
	    myChart2.on("click", updateMonth);
  }
    function setCountry(y,x,title){
    	 var myChart3 = echarts.init(document.getElementById("echarts3"));
    	    var option3 = {
    		   	    title: {
    		   	        text: title,
    		   	     	left: 'center'
    		   	    },
    		   	    tooltip: {
    		   	        trigger: 'axis'
    		   	    },	   	   	   	    
    		   	    xAxis:  {
    		   	        type: 'category',	   	        
    		   	        data: x,
    		   	     	axisTick: {
    		                alignWithLabel: true
    		            }
    		   	    },
    		   	    yAxis: {
    		   	        type: 'value',
    		   	       
    		   	    },
    		   	    series: [
    		   	        {
    		   	            name:'取证应用率',
    		   	            type:'bar',   	         	
    		   	            data: y,  	            
    		   	        }	        
    		   	    ]
    	   	};
    	    myChart3.setOption(option3);    
    }
    
    
     
    </script>
</body>
</html>