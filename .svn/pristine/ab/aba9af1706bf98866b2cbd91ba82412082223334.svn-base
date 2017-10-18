<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>设备维护-查看-设备核查情况记录</title>
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
           	当前位置：<a>设备与环境管理</a><span>></span><a>设备维护</a><span>></span><a>查看</a><span>></span><a>设备核查情况记录</a>
        </p>
    </div>
    <div class="form-title">设备期间核查情况记录表</div>
    <div class="form-content">
	    <form class="form-horizontal">
	        <div class="form-group">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>设备识别号：</label>
                <div class="col-sm-4" data-bind="with: deviceVM">
                    <input type="text" data-bind="value:identifier" name="identifier" id="identifier" class="form-control" readonly required />
                </div>
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>设备名称：</label>
                <div class="col-sm-4" data-bind="with: deviceVM">
                    <input type="text" data-bind="value:name" name="name" id="name" class="form-control" readonly required/>
                </div>
            </div>
	        <div class="form-group">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>型号/规格：</label>
                <div class="col-sm-4" data-bind="with: deviceVM">
                    <input type="text" data-bind="value:model" name="model" id="model" class="form-control" readonly required/>
                </div>
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>工作状态：</label>
	            <div class="col-sm-4" data-bind="with: devInspectionVM">
                	<select name="maintMethod" id="maintMethod" class="form-control" data-bind="value:status" required>
                        <option value="0">正常</option>
                        <option value="1">异常</option>
                    </select>
	            </div>
            </div>
	        <div class="form-group">
	            <label class="col-sm-2 control-label"><span class="required-fields">*</span>核查日期：</label>
                <div class="col-sm-4" data-bind="with: devInspectionVM">
                	<input id="checkingDate" name="checkingDate" class="form-control datetimepicker datetimepicker-before" data-bind="dateTimePicker:inspectedDate" required />
                </div>
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>核查周期：</label>
	            <div class="col-sm-4" data-bind="with: devInspectionVM">
	                <input type="text" data-bind="value:cycle" name="cycle" id="cycle" class="form-control" required />
	            </div>
	        </div>
	        <div class="form-group">
	            <label class="col-sm-2 control-label"><span class="required-fields">*</span>下周核查日期：</label>
                <div class="col-sm-4" data-bind="with: devInspectionVM">
                	<input id="checkingDate" name="checkingDate" class="form-control datetimepicker datetimepicker-after" data-bind="dateTimePicker:nextInspectedDate" required />
                </div>
                <label class="col-sm-2 control-label input-choose" data-name=".verification-results-radio"><span class="required-fields">*</span>本次核查结果：</label>
	            <div class="col-sm-2 verification-results-radio">
	                <div class="rdio rdio-primary">
	                    <input type="radio" name="radioNum" value="" id="radioNormal">
	                    <label for="radioNormal">正常</label>
	                </div>
	            </div>
	            <div class="col-sm-2 verification-results-radio">
	                <div class="rdio rdio-primary">
	                    <input type="radio" name="radioNum" value="" id="radioUnusual">
	                    <label for="radioUnusual">不正常</label>
	                </div>
	            </div>
	        </div>
	        <div class="form-group">
	            <label class="col-sm-2 control-label"><span class="required-fields">*</span>核查人：</label>
	            <div class="col-sm-4">
	                <input type="text" id="inspectorId" class="form-control" readonly required/>
	            </div>
	        </div>
	        <div class="form-group">
	            <label class="col-sm-2 control-label">备注：</label>
	            <div class="col-sm-10" data-bind="with: devInspectionVM">
	                <textarea data-bind="value:remarks" name="remarks" id="remarks" class="form-control"></textarea>
	            </div>
	        </div>
	    </form>
	</div>
	<div class="table-title">期间核查项目及参数</div>
    <div class="file-upload">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th><span class="required-fields">*</span>核查项目</th>
                    <th><span class="required-fields">*</span>标准参数</th>
                    <th><span class="required-fields">*</span>核查参数</th>
                    <th><span class="required-fields">*</span>单项核查结果</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <!-- <tr>
	                <td><input type="text" value="" /></td>
	                <td><input type="text" value="" /></td>
	                <td><input type="text" value="" /></td>
	                <td>
	                	<div class="col-sm-6">
			                <div class="rdio rdio-primary">
			                    <input type="radio" name="radio0" value="" id="radioNormal0">
			                    <label for="radioNormal0">正常</label>
			                </div>
			            </div>
			            <div class="col-sm-6">
			                <div class="rdio rdio-primary">
			                    <input type="radio" name="radio0" value="" id="radioUnusual0">
			                    <label for="radioUnusual0">不正常</label>
			                </div>
			            </div>
	                </td>
	                <td>
	                	<a title="删除" class="delete-btn"><i class="fa fa-times"></i></a>
	                </td>
                </tr> -->
                
            </tbody>
            <tfoot>
            	<tr>
                    <td colspan="5" align="center">
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
    	$('.datetimepicker').datetimepicker({
	       format: 'YYYY-MM-DD  HH:mm',
	    });
    	$(".datetimepicker-before").on("dp.change",function (e) {
            $('.datetimepicker-after').data("DateTimePicker").minDate(e.date);
        });
        $(".datetimepicker-after").on("dp.change",function (e) {
            $('.datetimepicker-before').data("DateTimePicker").maxDate(e.date);
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
		
	    var i = 1;
	    $(".add-tr-btn").click(function(){
	        var trHtml="";
	        trHtml += '<tr>';
	        trHtml += '<td><input type="text" required /></td>';
	        trHtml += '<td><input type="text" required /></td>';
	        trHtml += '<td><input type="text" required /></td>';
	        
	        trHtml += '<td>';
	        trHtml += '<div class="col-sm-6">';
	        trHtml += '<div class="rdio rdio-primary">';
	        trHtml += '<input type="radio" name="radio' + i + '" value="" id="radioNormal' + i + '" checked />';
	        trHtml += '<label for="radioNormal' + i + '">正常</label>';
	        trHtml += '</div>';
	        trHtml += '</div>';
	        trHtml += '<div class="col-sm-6">';
	        trHtml += '<div class="rdio rdio-primary">';
	        trHtml += '<input type="radio" name="radio' + i + '" value="" id="radioUnusual' + i + '" />';
	        trHtml += '<label for="radioUnusual' + i + '">不正常</label>';
	        trHtml += '</div>';
	        trHtml += '</div>';
	        trHtml += '</td>';
	        
	        trHtml += '<td>';
	        trHtml += '<a title="删除" class="delete-btn"><i class="fa fa-times"></i></a>';
	        trHtml += '</td>';
	        trHtml += '</tr>';
	        $(this).parents("tfoot").siblings("tbody").append(trHtml);
	        i = i + 1;
	    });
		
	    $(".table").on("click", ".delete-btn", function(){
	    	$(this).parent("td").parent("tr").remove();
	    	i = i - 1;
	    });
		
	    $(".back-btn").click(function(){
	    	var url = "${pageContext.request.contextPath}/deviceMgt/deviceMaintainViewer.do?id="+id;
	    	$(".index-iframe", window.parent.document).attr("src",url);
	    });
	    

		var id ="${param.id}";
        var uuid = loadData("${ pageContext.request.contextPath }/deviceMgt/getUUID.do", {});
        var deviceDateSource = loadData("${ pageContext.request.contextPath }/deviceMgt/device/loadDeviceData.do", { "id" : "${param.id}" });
        var devInspectionDate = loadData("${ pageContext.request.contextPath }/deviceMgt/devinspection/loadById.do", {"id" : "${param.id}"});
        var devInspectionParamData = loadData("${ pageContext.request.contextPath }/deviceMgt/devInspectionParam/loadDevInspectionParamData.do", {"id" : " "});

        
        
        var name = "${sessionScope.loginUser.userAlias}";
        $("#inspectorId").val(name);
        
        var devInspectionDateVM = ko.mapping.fromJS(devInspectionDate);
        var deviceDateVM = ko.mapping.fromJS(deviceDateSource);
        var devInspectionParamDataVM = ko.mapping.fromJS(devInspectionParamData);
        
        var vm = {
        	deviceVM : deviceDateVM,
        	devInspectionVM : devInspectionDateVM,
        	devInspectionParamVM : devInspectionParamDataVM
        }
        
        vm.saveData = function(){
        	$("button").attr("disabled", true);
            if(validateSubmittedData()){
            	bindDataToVM();  //如果是新增就增加必要字段
            	if ( saveData("${ pageContext.request.contextPath }/deviceMgt/devinspection/saveDate.do", devInspectionDateVM) ) {
                    var length = i - 1;
                    for(var j = 0; j < length; j++){
            	        var text1 = $(".table tbody tr").eq(j).find("td").eq(0).find("input").val();
            	        var text2 = $(".table tbody tr").eq(j).find("td").eq(1).find("input").val();
            	        var text3 = $(".table tbody tr").eq(j).find("td").eq(2).find("input").val();
            	        var text4 = $(".table tbody tr").eq(j).find("td").eq(3).find(":checked").attr("id");
            	        if(text4 == "" || text4 == undefined || text4 == null){
            	        }else{
                	        if(text4.indexOf("Unusual") > 0 ){ //不正常
                	        	devInspectionParamDataVM.result = 1;
        					} else {
        						devInspectionParamDataVM.result = 0;
        					}
            	        }
            	        devInspectionParamDataVM.item = text1;
            	        devInspectionParamDataVM.standardParam = text2;
            	        devInspectionParamDataVM.inspectingParam = text3;
            	        devInspectionParamDataVM.createdDate = new Date();
            	        devInspectionParamDataVM.creatorId = "${sessionScope.loginUser.userId}";
            	        devInspectionParamDataVM.creatorAlias = "${sessionScope.loginUser.userAlias}";
            	        devInspectionParamDataVM.creatorName = "${sessionScope.loginUser.userName}";
            	        devInspectionParamDataVM.deviceId = id;
            	        devInspectionParamDataVM.devInspectionId = uuid;
            	        saveData("${ pageContext.request.contextPath }/deviceMgt/devInspectionParam/saveDevInspectionParamData.do", devInspectionParamDataVM);
                    }
            		saveSuccess("${pageContext.request.contextPath}/deviceMgt/deviceMaintainViewer.do?id="+id);
    	    	}else{
    	    		
    	    	}
        	}else{
        		saveFailure();
        	}
        }
        
	    function bindDataToVM(){
	    	if(devInspectionDate.id == "" || devInspectionDate.id == undefined || devInspectionDate.id == null){   //没有ID就是新增
	    		devInspectionDateVM.id = uuid;
	    		devInspectionDateVM.creatorName = "${sessionScope.loginUser.userName}";
	    		devInspectionDateVM.creatorId = "${sessionScope.loginUser.userId}";
	    		devInspectionDateVM.creatorAlias = "${sessionScope.loginUser.userAlias}";
	    		devInspectionDateVM.createdDate = new Date();
	    		
	    		devInspectionDateVM.inspectorAlias = "${sessionScope.loginUser.userAlias}";
	    		devInspectionDateVM.inspectorId = "${sessionScope.loginUser.userId}";
	    		devInspectionDateVM.inspectorName = "${sessionScope.loginUser.userName}";
	    		devInspectionDateVM.deviceId = id;
	    	}else{
	    		devInspectionDate.modifiedDate = new Date();
	    	}
	    }
        
        
        ko.applyBindings(vm);
        
	    //维护方式
	    $("#radioNormal").click(function(){
	    	devInspectionDateVM.result = 0;
	    })
	    $("#radioUnusual").click(function(){
	    	devInspectionDateVM.result = 1;
	    })
    </script>
</body>
</html>