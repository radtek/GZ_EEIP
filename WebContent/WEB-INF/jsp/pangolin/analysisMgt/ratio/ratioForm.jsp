<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>数据录入</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script> 
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/zyupload.basic-1.0.0.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/base.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/jquery-barcode.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/ajaxfileupload.js" />"></script>
  	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/zyupload-1.0.0.min.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
  	<style>
  		.table thead tr th,.table tbody tr td{border:1px solid #aaa;}
  		.table tbody tr td input{text-align:center;}
  	</style>
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>统计分析</a><span>></span><a>比率分析</a><span>></span><a>数据录入</a>
        </p>
    </div>
    <div class="form-content">
	 	<div class="form-group">
	 		<div class="col-sm-6">                       
                 <select class="form-control year">
                 	<option value="2017">2017年</option>
                 	<option value="2016">2016年</option>
                 	<option value="2015">2015年</option>
                 	<option value="2014">2014年</option>
                 	<option value="2013">2013年</option>
                 	<option value="2012">2012年</option>
                 	<option value="2011">2011年</option>
                 	<option value="2010">2010年</option>
                 </select>             
             </div>
             <div class="col-sm-6">                       
                 <select class="form-control month">
                 	<option value="1">1月</option>
                 	<option value="2">2月</option>
                 	<option value="3">3月</option>
                 	<option value="4">4月</option>
                 	<option value="5">5月</option>
                 	<option value="6">6月</option>
                 	<option value="7">7月</option>
                 	<option value="8">8月</option>
                 	<option value="9">9月</option>
                 	<option value="10">10月</option>
                 	<option value="11">11月</option>
                 	<option value="12">12月</option>
                 </select>             
             </div>
	 	</div>
	 	<div class="form-title">请在下面表格中录入刑事立案数</div>
	 	<table class="table">
	 		<thead>
	 			<tr>
	 				<th>全市</th>
	 				<th>越秀区</th>
	 				<th>荔湾区</th>
	 				<th>天河区</th>
	 				<th>海珠区</th>
	 				<th>黄浦区</th>	 				
	 			</tr>
	 		</thead>
	 		<tbody>
	 			<tr>
	 				<td><input class="all" type="number" readonly /></td>
	 				<td><input class="valueAdd yuexiu" type="number" /></td>
	 				<td><input class="valueAdd liwan" type="number" /></td>
	 				<td><input class="valueAdd tianhe" type="number" /></td>
	 				<td><input class="valueAdd haizhu" type="number" /></td>
	 				<td><input class="valueAdd huangpu" type="number" /></td>
	 			</tr>
	 		</tbody>	 			 		
	 	</table>
	 	<table class="table">
	 		<thead>
	 			<tr>
	 				<th>白云区</th>
	 				<th>番禺区</th>
	 				<th>南沙区</th>
	 				<th>花都区</th>
	 				<th>增城区</th>
	 				<th>从化区</th>	 				
	 			</tr>
	 		</thead>
	 		<tbody>
	 			<tr>
	 				<td><input class="valueAdd baiyun" type="number" /></td>
	 				<td><input class="valueAdd panyu" type="number" /></td>
	 				<td><input class="valueAdd nansha" type="number" /></td>
	 				<td><input class="valueAdd huadu" type="number" /></td>
	 				<td><input class="valueAdd zengcheng" type="number" /></td>
	 				<td><input class="valueAdd conghua" type="number" /></td>
	 			</tr>
	 		</tbody>
	 	</table>
	 	
	    <div class="btn-content">
	         <input class="creatorId" style="display: none" />
	         <input class="creatorAlias" style="display: none"/>
	    
	        <button class="btn btn-color1 saveData"><i class="fa fa-check"></i>提交</button>
	    </div>
	</div>
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
    <script>
	    $(function(){
	    	setValue();
	    	$(".month").change(function(){
	    		setValue();
	    	});
	    	
	    	$(".valueAdd").blur(function(){
	    		var val = 0;
	    		$(".valueAdd").each(function(){
	    			var value = Number( $(this).val() );
	    			val = val + value;
	    		});
	    		$(".all").val(val);
	    	});
	    	
	    	$(".saveData").click(function(){ 
	    		var obj = new Object();
	    		obj.year =  $('.year option:selected').val();
	    		obj.month = $('.month option:selected').val();
	    		obj.all = $(".all").val();
	    		obj.yuexiu = $(".yuexiu").val();
	    		obj.liwan = $(".liwan").val();
	    		obj.tianhe = $(".tianhe").val();
	    		obj.haizhu = $(".haizhu").val();
	    		obj.huangpu = $(".huangpu").val();
	    		obj.baiyun = $(".baiyun").val();
	    		obj.panyu = $(".panyu").val();
	    		obj.nansha = $(".nansha").val();
	    		obj.huadu = $(".huadu").val();
	    		obj.zengcheng = $(".zengcheng").val();
	    		obj.conghua = $(".conghua").val();
	    		obj.creatorAlias =  "${sessionScope.loginUser.userAlias}";
	    		obj.creatorId =  "${sessionScope.loginUser.userId}";
	    		
	    		
	    		$.ajax({
	    			type : "POST",
	    			dataType : "json",
	    			contentType : "application/json;charset=UTF-8",
	    			url: "${pageContext.request.contextPath}/criminalFilingQty/saveData.do",
	    			cache : false,
	    			async : false,
	    			data : JSON.stringify(obj),
		             success: function(data){ 
		            	 saveSuccess();
		            	 $('.all').val('');
		            	 $('.yuexiu').val('');
		            	 $('.liwan').val('');
		            	 $('.tianhe').val('');
		            	 $('.haizhu').val('');
		            	 $('.huangpu').val('');
		            	 $('.baiyun').val('');
		            	 $('.panyu').val('');
		            	 $('.nansha').val('');
		            	 $('.zengcheng').val('');
		            	 $('.conghua').val('');
		            	 $('.huadu').val('');
		             },
			    	 error: function(data){ 
			    		 console.log(data);
			    	 }
		    	 });   
	    	}); 
	    });
	    
	    function setValue(){
	    	var year = $('.year option:selected').val();
	    	var month = $('.month option:selected').val();
	    	$.ajax({
	             type: "GET",
	             url: "${pageContext.request.contextPath}/criminalFilingQty/getListData.do",
	             data: {"year" : year , "month" : month},
	             dataType: "json",
	             success: function(data){ 
	            	 $('.year').val(year);
	            	 $('.month').val(month);
	            	 $('.all').val(data.entity.all);
	            	 $('.yuexiu').val(data.entity.yuexiu);
	            	 $('.liwan').val(data.entity.liwan);
	            	 $('.tianhe').val(data.entity.tianhe);
	            	 $('.haizhu').val(data.entity.haizhu);
	            	 $('.huangpu').val(data.entity.huangpu);
	            	 $('.baiyun').val(data.entity.baiyun);
	            	 $('.panyu').val(data.entity.panyu);
	            	 $('.nansha').val(data.entity.nansha);
	            	 $('.zengcheng').val(data.entity.zengcheng);
	            	 $('.conghua').val(data.entity.conghua);
	            	 $('.huadu').val(data.entity.huadu);
	             },
		    	 error: function(data){ 
		    		 console.log(data);
		    	 }
	    	 }); 
	    }
	    
    </script>
</body>
</html>