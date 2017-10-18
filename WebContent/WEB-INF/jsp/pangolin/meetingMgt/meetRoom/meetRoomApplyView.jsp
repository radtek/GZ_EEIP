<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>会议室查看</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
	
	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" /> 
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />	
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>会议管理</a><span>></span><a>会议室管理</a><span>></span><a>查看</a>
        </p>
   	</div>
	<div class="form-content">	
		<form class="form-horizontal">														
			<div class="form-group">
				<label class="col-sm-2 control-label">会议室名称：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" data-bind = "value:name" name="name" readonly/>
				</div>	
				<label class="col-sm-2 control-label">会议室编号：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" data-bind="value:sn" name="sn" readonly/>
				</div>						
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">会议室地址：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" data-bind="value:addr" name="addr" readonly/>
				</div>
				<label class="col-sm-2 control-label">可容纳人数：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" data-bind="value:cap" name="cap" readonly/>
				</div>							
			</div>
		
			<div class="form-group">
				<label class="col-sm-2 control-label">最大容纳人数：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" data-bind="value:maxCap" name="maxCap" readonly/>
				</div>	
				<!-- <label class="col-sm-2 control-label">会议室状态：</label>
				<div class="col-sm-4">
					<select data-bind= "value:status" name = "status"  class="form-control" disabled>
					   <option value="0">占用</option>
					   <option value="1">未占用</option>
					</select>
				</div>		 -->						
			</div>		
			
			<div class="form-group">
				<label class="col-sm-2 control-label">备注：</label>
				<div class="col-sm-10">
					<textarea class="form-control" data-bind="value:remarks" name="remarks" readonly></textarea>
				</div>						
			</div>
		</form>
	</div>	
	<div class="btn-content">
       	<button class="btn btn-color2 back-btn" data-bind="click: backToListData"><i class="fa fa-chevron-left"></i>返回</button>
    </div>
</body>
<script type="text/javascript">
   
      var meetingRoomData = loadData("${pageContext.request.contextPath}/meeting/meetingRoom/loadMeetingRoomData.do", { "id" : "${param.id}"});
      var vm = ko.mapping.fromJS(meetingRoomData);
     
      vm.backToListData = function(){
    	  $('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/meetingRoom/meetingRoomApplyList.do');
      }

      ko.applyBindings(vm);
</script>
</html>