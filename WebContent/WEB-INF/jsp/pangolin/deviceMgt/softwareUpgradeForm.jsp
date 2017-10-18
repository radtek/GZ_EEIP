<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>设备维护-查看-软件升级</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bracket-common.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/toggles.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/zyupload.basic-1.0.0.min.js" />"></script>
	<script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
  	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>设备与环境管理</a><span>></span><a>设备维护</a><span>></span><a>查看</a><span>></span><a>软件升级</a>
        </p>
    </div>
    <div class="form-title">软件升级表</div>
    <div class="form-content">
        <form class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>设备识别号：</label>
                <div class="col-sm-4" data-bind="with: deviceVM">
                    <input type="text" data-bind="value:identifier" name="identifier" id="identifier" class="form-control space" readonly required />
                </div>
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>设备名称：</label>
                <div class="col-sm-4" data-bind="with: deviceVM">
                    <input type="text" data-bind="value:name" name="name" id="name" class="form-control space" readonly required />
                </div>
            </div>
        </form>
    </div>
    <div class="file-upload">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th class="serial-num">序号</th>
                    <th><span class="required-fields">*</span>软件名称</th>
                    <th><span class="required-fields">*</span>原版本号</th>
                    <th><span class="required-fields">*</span>升级版本号</th>
                    <th><span class="required-fields">*</span>升级完成时间</th>
                    <th><span class="required-fields">*</span>操作人</th>
                    <th>备注</th>
                    <th class="icons-btn-2">操作</th>
                </tr>
            </thead>
            <tbody>
            </tbody>
            <tfoot>
            	<tr>
                    <td colspan="8" align="center">
                        <button class="btn add-tr-btn"><i class="fa fa-plus"></i>增加</button>
                    </td>
                </tr>
            </tfoot>
        </table>
    </div>
    <div class="btn-content">
        <button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
        <button class="btn btn-color1" data-bind ="click : saveData"><i class="fa fa-check"></i>提交</button>
    </div>
    <jsp:include page="/common/alertMessages.jsp"></jsp:include>
    <script>
		var id = "${param.id}";
        var userId = "${sessionScope.loginUser.userId}";
        var userAlias = "${sessionScope.loginUser.userAlias}";
        var userName = "${sessionScope.loginUser.userName}";
    	var sn = 1;    	
	    $(".add-tr-btn").click(function(){
	        var trHtml="";
	        trHtml += '<tr>';
	        trHtml += '<td></td>';
	        trHtml += '<td><input type="text" required /></td>';
	        trHtml += '<td><input type="text" required /></td>';
	        trHtml += '<td><input type="text" required /></td>';
	        trHtml += '<td><input type="text" class="datetimepicker11" required /></td>';
	        trHtml += '<td><input type="text" value="'+userAlias+'" readonly/></td>';
	        trHtml += '<td><input type="text" /></td>';
	        trHtml += '<td>';
	        trHtml += '<a title="删除" class="delete-btn"><i class="fa fa-times"></i></a>';
	        trHtml += '</td>';
	        trHtml += '</tr>';
	        $(this).parents("tfoot").siblings("tbody").append(trHtml);
			$(".datetimepicker11").datetimepicker({format: 'YYYY-MM-DD'});
			sn = sn+1;
			sorting();
	    });
	    
	    $(".table").on("click", ".delete-btn", function(){
	    	$(this).parent("td").parent("tr").remove();
	    	sn = sn-1;
	    	sorting();
	    });
	    
	    $(".back-btn").click(function(){
	    	var url = "${pageContext.request.contextPath}/deviceMgt/deviceMaintainViewer.do";
	    	$(".index-iframe", window.parent.document).attr("src",url+"?id="+id);
	    });
	    
		var deviceDateSource = loadData("${ pageContext.request.contextPath }/deviceMgt/device/loadDeviceData.do", { "id" : "${param.id}" });
		var devSwUpgradeData = loadData("${ pageContext.request.contextPath }/deviceMgt/devSwUpgrade/loadDevSwUpgradeData.do", { "id" : " " });
        
        var deviceDateVM = ko.mapping.fromJS(deviceDateSource);
        var devSwUpgradeDataVM = ko.mapping.fromJS(devSwUpgradeData);
        
        var vm = {
        	deviceVM : deviceDateVM,
        	devSwUpgradeVM : devSwUpgradeDataVM
        }
        
        ko.applyBindings(vm);
	    
        vm.saveData = function(){
        	if( $(".table tbody tr").size() > 0 ){
        		$("button").attr("disabled", true);
                if(validateSubmittedData()){
                	var length = sn-1;
                    for(var i = 0; i < length; i++){
            	        var text1 = $(".table tbody tr").eq(i).find("td").eq(1).find("input").val();
            	        var text2 = $(".table tbody tr").eq(i).find("td").eq(2).find("input").val();
            	        var text3 = $(".table tbody tr").eq(i).find("td").eq(3).find("input").val();
            	        var text4 = $(".table tbody tr").eq(i).find("td").eq(4).find("input").val();
            	        var text5 = $(".table tbody tr").eq(i).find("td").eq(5).find("input").val();
            	        var text6 = $(".table tbody tr").eq(i).find("td").eq(6).find("input").val();
            	        devSwUpgradeDataVM.deviceId = id;
            	        devSwUpgradeDataVM.softwareName = text1;
            	        devSwUpgradeDataVM.originalVer = text2;
            	        devSwUpgradeDataVM.newVer = text3;
            	        devSwUpgradeDataVM.finishedDate = text4;
            	        devSwUpgradeDataVM.operatorId = userId;
            	        devSwUpgradeDataVM.operatorName = userName;
            	        devSwUpgradeDataVM.operatorAlias = userAlias;
            	        devSwUpgradeDataVM.remarks = text6;
            	        devSwUpgradeDataVM.createdDate = new Date();
            	        devSwUpgradeDataVM.creatorId = userId;
            	        devSwUpgradeDataVM.creatorAlias = userAlias;
            	        devSwUpgradeDataVM.creatorName = userName;
            	        saveData("${ pageContext.request.contextPath }/deviceMgt/devSwUpgrade/saveDevSwUpgradeData.do", devSwUpgradeDataVM)
                    }
                    saveSuccess("${pageContext.request.contextPath}/deviceMgt/deviceMaintainViewer.do?id="+id);
            	}else{
            		saveFailure();
            	}
        	}else{
        		saveFailure("没新增内容无法提交！");
        	}
        }
        
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