<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>核查校准计划-申请表单</title>
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
  	<script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
  	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/deviceMgt/deviceMgt-form.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>设备与环境管理</a><span>></span><a>设备管理</a><span>></span><a>查看</a>
        </p>
    </div>
    <div class="main-content" data-num="7">
        <jsp:include page="/common/deviceMgtLeftNav.jsp"></jsp:include>
        <div class="right-form">
            <div class="right-content">
            	<div class="form-title title-year"></div>
                <div class="form-content">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-2 control-label"><span class="required-fields">*</span>填表人：</label>
                            <div class="col-sm-4" data-bind="with: DevAdjPlanVM">
                                <input type="text" data-bind="value: creatorAlias" name="creatorAlias" id="creatorAlias" class="form-control name" readonly required />
                            </div>
                            <label class="col-sm-2 control-label"><span class="required-fields">*</span>填表时间：</label>
                            <div class="col-sm-4" data-bind="with: DevAdjPlanVM">
			                	<input id="createdDate" name="createdDate" class="form-control datetimepicker" data-bind="dateTimePicker:createdDate" readonly required />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">技术负责人：</label>
                            <div class="col-sm-4" data-bind="with: DevAdjPlanVM">
                                <input type="text" data-bind="value: approverAlias" name="approverAlias" id="approverAlias" class="form-control name" readonly/>
                            </div>
                            <label class="col-sm-2 control-label">审批时间：</label>
                            <div class="col-sm-4" data-bind="with: DevAdjPlanVM">
			                	<input id="approvedDate" name="approvedDate" class="form-control datetimepicker" data-bind="dateTimePicker:approvedDate" readonly/>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="file-upload">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th class="serial-num">序号</th>
                                <th><span class="required-fields">*</span>设备名称</th>
                                <th><span class="required-fields">*</span>型号/规格</th>
                                <th><span class="required-fields">*</span>设备识别号</th>
                                <th><span class="required-fields">*</span>核查/校准方式</th>
                                <th><span class="required-fields">*</span>核查时间</th>
                                <th>责任人</th>
                                <th class="icons-btn-1">操作</th>
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
            </div>
        </div>
    </div>
    <jsp:include page="/common/alertMessages.jsp"></jsp:include>
    <script>
    	$('.datetimepicker').datetimepicker({
	       format: 'YYYY-MM-DD  HH:mm',
	    });
    
		//时间控件数据绑定-----------开始
		ko.bindingHandlers.dateTimePicker = {
			init : function(element, valueAccessor, allBindingsAccessor) {
				//initialize datepicker with some optional options
				var options = allBindingsAccessor().dateTimePickerOptions || {};
				$(element).datetimepicker(options);
				
				//when a user changes the date, update the view model
				ko.utils.registerEventHandler(element, "dp.change",
						function(event) {
							var value = valueAccessor();
							if (ko.isObservable(value)) {
								if (event.date != null
										&& !(event.date instanceof Date)) {
									value(event.date.toDate());
								} else {
									value(event.date);
								}
							}
						});
				
				ko.utils.domNodeDisposal.addDisposeCallback(element,
						function() {
							var picker = $(element).data("DateTimePicker");
							if (picker) {
								picker.destroy();
							}
						});
			},
			update : function(element, valueAccessor, allBindings, viewModel, bindingContext) {
				var picker = $(element).data("DateTimePicker");
				//when the view model is updated, update the widget
				if (picker) {
					var koDate = ko.utils.unwrapObservable(valueAccessor());
					//in case return from server datetime i am get in this form for example /Date(93989393)/ then fomat this
					koDate = (typeof (koDate) !== 'object') ? new Date(
							parseFloat(koDate)) : koDate;
					picker.date(koDate);
				}
			}
		};
		//时间控件数据绑定-----------结束

		var id ="${param.id}";
		var userName = "${sessionScope.loginUser.userName}";
		var userId = "${sessionScope.loginUser.userId}";
		var userAlias = "${sessionScope.loginUser.userAlias}";
		var sn = 1; 
		var deviceDateSource = loadData("${ pageContext.request.contextPath }/deviceMgt/device/loadDeviceData.do", { "id" : id });
		
        var num = $(".main-content").data("num");
        $(".left-nav li").eq(num).addClass("action");
        
        $(".left-nav li a").click(function(){
            var url = $(this).data("url");
            $(".index-iframe", window.parent.document).attr("src",url+"?id="+id);
        });
        
        $(".back-btn").click(function(){
	    	var url = "${pageContext.request.contextPath}/deviceMgt/calibrationPlanViewer.do";
	    	$(".index-iframe", window.parent.document).attr("src",url+"?id="+id);
	    });
        
        $(".add-tr-btn").click(function(){
            var trHtml="";
            trHtml += '<tr>';
            trHtml += '<td></td>';
            trHtml += '<td><input type="text" class="validation" value="'+deviceDateSource.name+'" readonly required /></td>';
            trHtml += '<td><input type="text" class="specifications" value="'+deviceDateSource.model+'" readonly required /></td>';
            trHtml += '<td><input type="text" class="serialNumber" value="'+deviceDateSource.identifier+'" readonly required /></td>';
            trHtml += '<td><input type="text" class="" required /></td>';
            trHtml += '<td><input type="text" class="datetimepicker11" required /></td>';
            trHtml += '<td><input type="text" class="name" value="" /></td>';
            trHtml += '<td>';
            trHtml += '<a title="删除" class="delete-btn"><i class="fa fa-times"></i></a>';
            trHtml += '</td>';
            trHtml += '</tr>';
            $(this).parents("tfoot").siblings("tbody").append(trHtml);
			$(".datetimepicker11").datetimepicker({format: 'YYYY-MM-DD'});
            sn = sn + 1;
            sorting();
        });
        
	    $(".table").on("click", ".delete-btn", function(){
	    	$(this).parent("td").parent("tr").remove();
	    	sn = sn-1;
	    	sorting();
	    });
        
		var year = new Date().Format("yyyy");
        var title = "仪器设备的期间核查/校准计划（"+year+"年度）";
        $(".title-year").text(title);
        var uuid = loadData("${ pageContext.request.contextPath }/deviceMgt/getUUID.do", {});
		var DevAdjPlanData = loadData("${ pageContext.request.contextPath }/deviceMgt/devAdjPlan/loadDevAdjPlanData.do", { "id" : " " });
		var loadDevAdjPlanItemData = loadData("${ pageContext.request.contextPath }/deviceMgt/devAdjPlanItem/loadDevAdjPlanItemData.do", { "id" : " " });
		
        var DevAdjPlanDataVM = ko.mapping.fromJS(DevAdjPlanData);
        var loadDevAdjPlanItemDataVM = ko.mapping.fromJS(loadDevAdjPlanItemData);
        DevAdjPlanDataVM.creatorAlias = userAlias;
        DevAdjPlanDataVM.createdDate = new Date();
        
        var vm = {
			DevAdjPlanVM : DevAdjPlanDataVM,
			loadDevAdjPlanItemVM : loadDevAdjPlanItemDataVM
        }
        
        vm.saveData = function(){
        	if( $(".table tbody tr").size() > 0 ){
        		$("button").attr("disabled", true);
    			if(validateSubmittedData()){
    				bindDataToVM();	
    				if ( saveData("${ pageContext.request.contextPath }/deviceMgt/devAdjPlan/saveDevAdjPlanData.do", DevAdjPlanDataVM) ) {  //主表保存成功
    	                var length = sn-1;
    	                for(var i = 0; i < length; i++){
    	        	        var text1 = $(".table tbody tr").eq(i).find("td").eq(4).find("input").val(); //校准方式
    	        	        var text2 = $(".table tbody tr").eq(i).find("td").eq(5).find("input").val(); //时间
    	        	        var text3 = $(".table tbody tr").eq(i).find("td").eq(6).find("input").val(); //责任人
    	        	        loadDevAdjPlanItemDataVM.creatorName = userName;
    	        	        loadDevAdjPlanItemDataVM.creatorAlias = userAlias;
    	        	        loadDevAdjPlanItemDataVM.createdDate = new Date();
    	        	        loadDevAdjPlanItemDataVM.creatorId = userId;
    	        	        loadDevAdjPlanItemDataVM.method = text1;
    	        	        loadDevAdjPlanItemDataVM.inspectedDate = text2;
    	        	        loadDevAdjPlanItemDataVM.principalId = userId;
    	        	        loadDevAdjPlanItemDataVM.principalName = userName;
    	        	        loadDevAdjPlanItemDataVM.principalAlias = text3;
    	        	        loadDevAdjPlanItemDataVM.devAdjPlanId = uuid;
    	        	        loadDevAdjPlanItemDataVM.deviceId = id;
    	        	        saveData("${ pageContext.request.contextPath }/deviceMgt/devAdjPlanItem/saveDevAdjPlanItemData.do", loadDevAdjPlanItemDataVM)
    	                }
    	        		saveSuccess("${pageContext.request.contextPath}/deviceMgt/calibrationPlanViewer.do?id="+id);
    		    	}else{
    		    		
    		    	}
    	    	}else{
    	    		saveFailure();
    	    	}
        	}else{
        		saveFailure("没新增内容无法提交！");
        	}
        }
        
	    function bindDataToVM(){
	    	if(DevAdjPlanData.id == "" || DevAdjPlanData.id == undefined || DevAdjPlanData.id == null){   //没有ID就是新增
	    		DevAdjPlanDataVM.id = uuid;
	    		DevAdjPlanDataVM.creatorName = "${sessionScope.loginUser.userName}";
	    		DevAdjPlanDataVM.creatorId = "${sessionScope.loginUser.userId}";
	    		DevAdjPlanDataVM.creatorAlias = "${sessionScope.loginUser.userAlias}";
	    		DevAdjPlanDataVM.createdDate = new Date();
	    		DevAdjPlanDataVM.title = "标题无敌";
	    		DevAdjPlanDataVM.year = "2017";
	    		DevAdjPlanDataVM.status = 1;
	    		DevAdjPlanDataVM.deviceId = id;
	    	}else{
	    		deviceDateVM.modifiedDate = new Date();
	    	}
	    }

        ko.applyBindings(vm);
        
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