<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>预检分析</title>
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
		#echarts1,#echarts2,#echarts3,#echarts4{width:50%;height:100%;float:left;}
	</style>
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
			当前位置：<a>统计分析</a><span>></span><a>预检分析</a>
        </p>
    </div>
    <div class="echarts-item">
		<div class="top">
			<div id="echarts1"></div>
			<div id="echarts2"></div>
		</div>
		<div class="bottom">
			<div id="echarts3"></div>
			<div id="echarts4"></div>
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
             url: "${pageContext.request.contextPath}/elecEVIDMgt/preappraisal/getHistoryData.do",
             data: {},
             dataType: "json",
             success: function(data){
            	 setHistoryYear(data.number,data.date);
            	 getYear(null);
            	 getCountry(null,null);
            	 getCompared(null,null);
             },
	    	 error: function(data){
	    		 setHistoryYear(null , null);
	    		 setYear(null,null);
	    		 setCountry(null,null);
	    	 }
    	 }); 
    });
    
    function setHistoryYear(y,x){
    var myChart1 = echarts.init(document.getElementById("echarts1"));
    var option1 = {
	   	    title: {
	   	        text: '历年广州市鉴定委托数趋势分析'	,
	   	     	left: 'center'
	   	    },
	   	    tooltip: {
	   	        trigger: 'axis'
	   	    },	   	   	   	    
	   	    xAxis:  {
	   	        type: 'category',	   	        
	   	        data: x
	   	    },
	   	    yAxis: {
	   	        type: 'value',
	   	       
	   	    },
	   	    series: [
	   	        {
	   	            name:'委托数量',
	   	            type:'line',
	   	            data:y,  	            
	   	        }	        
	   	    ]
   	};
	    myChart1.setOption(option1);
	    function updateYear(param) { 
	    	console.log(param);
	    	var years = param["name"];
	    	year = years.substring(0,4)
	    	getYear(year);
	    	getCountry(year,null);
	    	getCompared(year,null);
		}
	    myChart1.on("click", updateYear);
    };
   
    function getYear(yearv){
    	if(yearv == null){
    		var myDate = new Date();
    		yearv =  myDate.getFullYear();; 
    	}
    	var title2 = yearv+'年广州市鉴定委托数趋势分析';
    	 $.ajax({
             type: "POST",
             url: "${pageContext.request.contextPath}/elecEVIDMgt/preappraisal/getYearData.do",
             data: {year:yearv},
             dataType: "json",
             success: function(data){
            	 setYear(data.number,data.date,title2);
             },
	    	 error: function(data){
	    		 setYear(data.number,data.date,title2);
	    	 }
    	 });  
    }
    
    function setYear(y,x,title2){
    	
    	 var myChart2 = echarts.init(document.getElementById("echarts2"));
         var option2 = {
     	   	    title: {
     	   	        text: title2	,
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
     	   	            name:'委托数量',
     	   	            type:'line',
     	   	            data:y,  	            
     	   	        }	        
     	   	    ]
        	};
         myChart2.setOption(option2);
         function updateMonth(param) { 
 	    	console.log(param);
 	    	var months = param["name"];
 	    	month = months.substring(0,1)
 	    	getCountry(year,month);
 	    	getCompared(year,month);
 		}
 	    myChart2.on("click", updateMonth);
    }
    
    function getCountry(yearv,monthv){
    	if(yearv == null){
    		var myDate = new Date();
    		yearv = myDate.getFullYear();; 
    	} 
    	var title = yearv+'年广州市各区鉴定委托数对比分析';
    	
    	if(monthv != null){
    	    title = yearv+'年'+monthv+'月广州市各区鉴定委托数对比分析';
    	}
    	
    	 $.ajax({
             type: "POST",
             url: "${pageContext.request.contextPath}/elecEVIDMgt/preappraisal/getCountryData.do",
             data: {year:yearv,month:monthv},
             dataType: "json",
             success: function(data){
            	 setCountry(data.number,data.country,title);
             },
	    	 error: function(data){
	    		 setCountry(null,null,null);
	    	 }
    	 });
    };
    
    function setCountry(y,x,title3){
    	  var myChart3 = echarts.init(document.getElementById("echarts3"));
    	    var option3 = {
    		   	    title: {
    		   	        text: title3	,
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
    		   	            name:'委托数量',
    		   	            type:'bar',   	         	
    		   	            data:y,  	            
    		   	        }	        
    		   	    ]
    	   	};
    	    myChart3.setOption(option3);
    }
    
    function getCompared(yearv,monthv){
    	if(yearv == null){
    		var myDate = new Date();
    		yearv = myDate.getFullYear();; 
    	} 
    	var title = yearv+'年广州市预检结果对比分析';
    	
    	if(monthv != null){
    	    title = yearv+'年'+monthv+'月广州市预检结果对比分析';
    	}
    	
    	 $.ajax({
             type: "POST",
             url: "${pageContext.request.contextPath}/elecEVIDMgt/preappraisal/getAcceptedData.do",
             data: {year:yearv,month:monthv},
             dataType: "json",
             success: function(data){
            	 setCompared(data.entity,title);
             },
	    	 error: function(data){
	    		 setCompared(null,null);
	    	 }
    	 });
    }
    
    function setCompared(data,title){
    	 var myChart4 = echarts.init(document.getElementById("echarts4"));
    	    var option4 = {
    	    	    title : {
    	    	        text: title,   	       
    	    	        x:'center'
    	    	    },
    	    	    tooltip : {
    	    	        trigger: 'item',
    	    	        formatter: "{a} <br/>{b} : {c} ({d}%)"
    	    	    },
    	    	    series : [
    	    	        {
    	    	            name: '访问来源',
    	    	            type: 'pie',
    	    	            radius : '55%',
    	    	            center: ['50%', '60%'],
    	    	            data:data/* [
    	    	                {value:219, name:'通过受理'},
    	    	                {value:5833, name:'未受理或受理失败'},    	               
    	    	            ] */,
    	    	            itemStyle: {
    	    	                emphasis: {
    	    	                    shadowBlur: 10,
    	    	                    shadowOffsetX: 0,
    	    	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
    	    	                }
    	    	            }
    	    	        }
    	    	    ]
    	    	};
    	    myChart4.setOption(option4);
    }; 
   
    </script>
</body>
</html>