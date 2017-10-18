<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>会议室申请表单</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
	
	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" /> 
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>		
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>会议管理</a><span>></span><a>会议室管理</a><span>></span><a>新增</a>
        </p>
   	</div>
   	<div class="form-content">
		<form class="form-horizontal">															
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>会议室名称：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control validation" data-bind="value:name" name="name" required />
				</div>
				<label class="col-sm-2 control-label">会议室编号：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control serialNumber" data-bind = "value:sn" name = "sn"/>
				</div>							
			</div>
		
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>会议室地址：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control validation" data-bind="value:addr" name="addr" required />
				</div>	
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>可容纳人数：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control number" data-bind="value:cap" name="cap" required />
				</div>						
			</div>
		
			<div class="form-group">
				<label class="col-sm-2 control-label">最大容纳人数：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control number" data-bind="value:maxCap" name="maxCap" />
				</div>	
				<!-- <label class="col-sm-2 control-label">会议室状态：</label>
				<div class="col-sm-4">
					<select data-bind= "value:status" name = "status"  class="form-control">
					   <option value="0">占用</option>
					   <option value="1">未占用</option>
					</select>
				</div>	 -->						
			</div>			
			
			<div class="form-group">
				<label class="col-sm-2 control-label">备注：</label>
				<div class="col-sm-10">
					<textarea class="form-control" data-bind="value:remarks" name="remarks"></textarea>
				</div>						
			</div>
		</form>
	</div>	
	<div class="btn-content">
       	<button class="btn btn-color2 back-btn" data-bind="click: backToListData"><i class="fa fa-chevron-left"></i>返回</button>
       	<button class="btn btn-color1" data-bind="click: saveData"><i class="fa fa-check"></i>提交</button>
   	</div> 
   	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
</body>
<script type="text/javascript">
   	$(function(){
		// 链接判断
	   	var url = window.location.href;
	   	if( url.indexOf("id=") != -1 ){
	     	$(".crumbs-text").html("当前位置：<a>会议管理</a><span>></span><a>会议室管理</a><span>></span><a>修改</a>");
	   	}
	   
	    var meetingRoomData = loadData("${pageContext.request.contextPath}/meeting/meetingRoom/loadMeetingRoomData.do", { "id" : "${param.id}"});
	    var vm = ko.mapping.fromJS(meetingRoomData);
	    vm.saveData = function(){
	        if ( validateSubmittedData() ) {
	        	$("button").attr("disabled", true);
	        	var cap = Number($('input[name="cap"]').val());
	        	var maxCap = Number($('input[name="maxCap"]').val());		        	
	        	if( maxCap != "" && cap > maxCap){	    		 
	        		  $("button").attr("disabled", false);
		    		  saveFailure("提交失败！最大容纳人数必须大于可容纳人数。");
		    		  return false;
		    	}else{
		    		bindDataVM();
		        	if (saveData("${pageContext.request.contextPath}/meeting/meetingRoom/saveMeetingRoomData.do", vm)) {
						saveSuccess("${pageContext.request.contextPath}/meetingMgt/meetingRoom/meetingRoomApplyList.do");
					} else {
						$("button").attr("disabled", false);
						saveFailure();
					}
		    	}
	        } else {
	        	saveFailure();
	        } 
	      }
	      
	      vm.backToListData = function(){
	    	  $('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/meetingRoom/meetingRoomApplyList.do');
	      }

	      ko.applyBindings(vm); 
	      
	      function bindDataVM(){
	    	  vm.creatorName = "${sessionScope.loginUser.userName}";
	    	  vm.creatorId = "${sessionScope.loginUser.userId}";
	    	  vm.creatorAlias = "${sessionScope.loginUser.userAlias}";
	      }
   })
  
</script>
</html>