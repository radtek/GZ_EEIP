<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>仪器设备登记表</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/bracket-common.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/toggles.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/base.js" />"></script>
  	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/deviceMgt/deviceMgt-form.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>设备与环境管理</a><span>></span><a>设备管理</a><span>></span><a>查看</a>
        </p>
    </div>
    <div class="main-content" data-num="0">
        <jsp:include page="/common/deviceMgtLeftNav.jsp"></jsp:include>
        <div class="right-form">
            <div class="right-content">
                <div class="form-content">
                    <form class="form-horizontal">
						<div class="form-group">
			                <label class="col-sm-2 control-label"><span class="required-fields">*</span>设备识别号：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                    <input type="text" data-bind="value:identifier" name="identifier" id="identifier" class="form-control serialNumber" required />
			                </div>
			                <label class="col-sm-2 control-label"><span class="required-fields">*</span>设备名称：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                    <input type="text" data-bind="value:name" name="name" id="name" class="form-control validation" required />
			                </div>
			            </div>
			            <div class="form-group">
			                <label class="col-sm-2 control-label"><span class="required-fields">*</span>生产厂商：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                    <input type="text" data-bind="value:mfrName" name="mfrName" id="mfrName" class="form-control validation" required />
			                </div>
			                <label class="col-sm-2 control-label"><span class="required-fields">*</span>型号/规格：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                    <input type="text" data-bind="value:model" name="model" id="model" class="form-control specifications" required />
			                </div>
			            </div>
			            <div class="form-group">
			                <label class="col-sm-2 control-label">出厂编号：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                    <input type="text" data-bind="value:sn" name="sn" id="sn" class="form-control serialNumber" />
			                </div>
			                <label class="col-sm-2 control-label"><span class="required-fields">*</span>接收时状态：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                    <select name="receivingStatus" id="receivingStatus" class="form-control" data-bind="value:receivingStatus" required>
			                        <option value="0" >全新</option>
			                        <option value="1" >成旧</option>
			                        <option value="2" >经过改装</option>
			                    </select>
			                </div>
			            </div>
			            <div class="form-group">
			                <label class="col-sm-2 control-label"><span class="required-fields">*</span>接收日期：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                	<input id="receivingDate" name="receivingDate" class="form-control datetimepicker" data-bind="dateTimePicker:receivingDate" required />
			                </div>
			                <label class="col-sm-2 control-label">启用日期：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                	<input id="usingDate" name="usingDate" class="form-control datetimepicker" data-bind="dateTimePicker:usingDate"/>
			                </div>
			            </div>
			            <div class="form-group">
			                <label class="col-sm-2 control-label"><span class="required-fields">*</span>存放地点：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                    <input type="text" data-bind="value:location" name="location" id="location" class="form-control validation" required />
			                </div>
			                <label class="col-sm-2 control-label">初次检定时间：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                	<input id="checkingDate" name="checkingDate" class="form-control datetimepicker" data-bind="dateTimePicker:checkingDate"/>
			                </div>
			            </div>
			            <div class="form-group">
			                <label class="col-sm-2 control-label">检定周期：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                    <input type="text" data-bind="value:checkingCycle" name="checkingCycle" id="checkingCycle" class="form-control chineseNum" />
			                </div>
			                <label class="col-sm-2 control-label">使用技术组：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                    <input type="text" data-bind="value:techGroup" name="techGroup" id="techGroup" class="form-control specifications" />
			                </div>
			            </div>
			            <div class="form-group">
			                <label class="col-sm-2 control-label"><span class="required-fields">*</span>管理人：</label>
			                <div class="col-sm-4" data-bind="with: userVM">
								<select id="manager" class="form-control" data-bind="options:users, optionsValue:'userId', optionsText:'userAlias', value:userId, optionsCaption:'--请选择--', event:{change:changManager}" required>
								</select>
							</div>
			                <label class="col-sm-2 control-label">维护方式：</label>
			                <div class="col-sm-2">
			                    <div class="rdio rdio-primary">
			                        <input type="radio" name="radio1" value="" id="radio1">
			                        <label for="radio1">合同维护保养</label>
			                    </div>
			                </div>
			                <div class="col-sm-2">
			                    <div class="rdio rdio-primary">
			                        <input type="radio" name="radio1" value="" id="radio2">
			                        <label for="radio2">自行维护保养</label>
			                    </div>
			                </div>
			            </div>
			            <div class="form-group">
			                <label class="col-sm-2 control-label"><span class="required-fields">*</span>当前状态：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                	<select name="maintMethod" id="maintMethod" class="form-control" data-bind="value:status" required>
			                        <option value="0">正常</option>
			                        <option value="2">维修</option>
			                        <option value="3">报废</option>
			                    </select>
			                </div>
			                <label class="col-sm-2 control-label">验证方式：</label>
			                <div class="col-sm-2">
			                    <div class="rdio rdio-primary">
			                        <input type="radio" name="radio2" value="" id="radio3">
			                        <label for="radio3">合同校准/检定</label>
			                    </div>
			                </div>
			                <div class="col-sm-2">
			                    <div class="rdio rdio-primary">
			                        <input type="radio" name="radio2" value="" id="radio4">
			                        <label for="radio4">自行校准/检定</label>
			                    </div>
			                </div>
			            </div>
			            <div class="form-group">
			            	<label class="col-sm-2 control-label">设备外观照片：</label>
                            <div class="col-sm-10">
                                <div class="img-upload">
                                	<%-- <div class="big-img file">
                                		<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/deviceMgt/111.png" />
                                	</div> --%>
                                	<ul class="img-list">
                                	<%-- 	<li><span><img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/deviceMgt/111.png" /></span></li>
                                		<li><span><img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/deviceMgt/222.png" /></span></li>
                                	 --%></ul>
                                </div>
                            </div>
			            </div>
                    </form>
                </div>
                <div class="file-upload">
			        <table class="table table-bordered devTelFile" id="table2">
			            <thead>
			                <tr>
			                    <th>随机技术文件</th>
			                    <th>存放使用地点</th>
			                    <th>操作</th>
			                    <th>创建时间</th>
			                </tr>
			            </thead>
			            <tbody>
			            </tbody>
			            <tfoot>
							<tr>
			                    <td colspan="4" align="center">
			                        <button class="btn add-tr-btn addFileOne"><i class="fa fa-plus"></i>增加</button>
			                    </td>
			                </tr>
			            </tfoot>
			        </table>
		        	<table class="table table-bordered devAttFile" id="table3">
			            <thead>
			                <tr>
			                    <th>附件</th>
			                    <th>存放使用地点</th>
			                    <th>操作</th>
			                    <th>创建时间</th>
			                </tr>
			            </thead>
			            <tbody>
			            </tbody>
			            <tfoot>
							<tr>
			                    <td colspan="4" align="center">
			                        <button class="btn add-tr-btn addFileTwo"><i class="fa fa-plus"></i>增加</button>
			                    </td>
			                </tr>
			            </tfoot>
       				</table>
                </div>
                <div class="btn-content">
        			<button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
        			<button class="btn btn-color1 " data-bind ="click : saveData"><i class="fa fa-check"></i>提交</button>
                </div>
            </div>
        </div>
    </div>
    
    <!-- <button data-toggle="modal" data-target=".modal-bigImg"></button> -->
	<div class="modal fade modal-bigImg" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  	<div class="modal-dialog modal-lg" role="document">
		    <div class="modal-content">
		      	<div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="myModalLabel">查看大图</h4>
		      	</div>
		      	<div class="modal-body">
		       	 	<img src="" class="bigImg" />
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
		$("#receivingDate").on("dp.change", function(e) {
			var date = new Date(e.date);//将时间戳转换为Date
			date.setMinutes(date.getMinutes() + 1);//给Date的小时数加1
			e.date._d = date;//将加1后的Date重新赋给e.date中的_d属性
			$('#usingDate').data("DateTimePicker").minDate(e.date);
			$('#receivingDate').data("DateTimePicker").minDate(new Date());
		});
    	var id = "${param.id}";
    	
        var num = $(".main-content").data("num");
        
        $(".left-nav li").eq(num).addClass("action");
        
        $(".left-nav li a").click(function(){
            var url = $(this).data("url");
            $(".index-iframe", window.parent.document).attr("src",url+"?id="+id);
        });
        
        $(".back-btn").click(function(){
	    	var url = "${pageContext.request.contextPath}/deviceMgt/deviceMgtList.do";
            $(".index-iframe", window.parent.document).attr("src",url+"?id="+id);
	    });
        
        $(".img-list img").click(function(){
        	var src = $(this).attr("src");
        	$(".modal-bigImg .bigImg").attr("src",src);
        });
        
        var nb3 = 0;
        var nb4 = 0;
        $(".addFileOne").click(function(){
            var trHtml="";
            trHtml += '<tr>';
            trHtml += '<td><input type="text" class="validation" /></td>';
            trHtml += '<td><input type="text" class="validation" /></td>';
            trHtml += '<td><a class="delete-btnOne" title="删除"><i class="fa fa-times"></i></a></td>';
            trHtml += '</tr>';
            $(this).parents("tfoot").siblings("tbody").append(trHtml);
            nb3++;
        });
        $(".addFileTwo").click(function(){
            var trHtml="";
            trHtml += '<tr>';
            trHtml += '<td><input type="text" class="validation" /></td>';
            trHtml += '<td><input type="text" class="validation" /></td>';
            trHtml += '<td><a class="delete-btnTwo" title="删除"><i class="fa fa-times"></i></a></td>';
            trHtml += '</tr>';
            $(this).parents("tfoot").siblings("tbody").append(trHtml);
            nb4++;
        });
        $(".table").on("click", ".delete-btnOne", function(){
            $(this).parent("td").parent("tr").remove();
            nb3--;
        });
        $(".table").on("click", ".delete-btnTwo", function(){
            $(this).parent("td").parent("tr").remove();
            nb4--;
        });
        
        var id = "${param.id}"; 
		var userName = "${sessionScope.loginUser.userName}";
		var userId = "${sessionScope.loginUser.userId}";
		var userAlias = "${sessionScope.loginUser.userAlias}";

		var deviceDateSource = loadData("${ pageContext.request.contextPath }/deviceMgt/device/loadDeviceData.do", { "id" : id });
		var devattachment = loadData("${ pageContext.request.contextPath }/deviceMgt/devattachment/loadDevattachment.do", { "id" : " " });
        
		if(deviceDateSource.maintMethod == 0){
			$("#radio1").attr("checked","checked");
		}else if(deviceDateSource.maintMethod == 1){
			$("#radio2").attr("checked","checked");
		}
		if(deviceDateSource.verificationMethod == 0){
			$("#radio3").attr("checked","checked");
		}else if(deviceDateSource.maintMethod == 1){
			$("#radio4").attr("checked","checked");
		}
		
        var deviceDateVM = ko.mapping.fromJS(deviceDateSource);
        var devattachmentDateVM = ko.mapping.fromJS(devattachment);
        var AllUserData = loadData("${ pageContext.request.contextPath }/system/user/getAllUserData.do",{});
		
		var userDataVM = {
			users : ko.observableArray(AllUserData),
			userId : ko.observable(deviceDateSource.managerId)
		}
		
        var vm = {
        	devattachmentVM : devattachmentDateVM,
            deviceVM : deviceDateVM,
			userVM : userDataVM
        }
		
        vm.saveData = function(){
			$("button").attr("disabled", true);
	        if(validateSubmittedData()){
	        	bindDataToVM();  //如果是新增就增加必要字段
	        	if ( saveData("${ pageContext.request.contextPath }/deviceMgt/device/saveDeviceData.do", deviceDateVM) ) {
// 	        			alert(nb3);
	        		for(var i = 0 ; i < nb3 ; i++){
	        	        var text1 = $(".devTelFile tbody tr").eq(i).find("td").eq(0).find("input").val();
// 	        			alert(text1);
	        	        var text2 = $(".devTelFile tbody tr").eq(i).find("td").eq(1).find("input").val();
	        	        if(text1 == "" || text1 == undefined || text1 == null){
	        	        	continue;
	        	        }
	        	        if(text2 == "" || text2 == undefined || text2 == null){
	        	        	continue;
	        	        }
	        	        devattachmentDateVM.creatorName = userName;
	        	        devattachmentDateVM.creatorAlias = userAlias;
	        	        devattachmentDateVM.createdDate = new Date();
	        	        devattachmentDateVM.creatorId = userId;
	        	        devattachmentDateVM.name = text1;
	        	        devattachmentDateVM.path = "无";
	        	        devattachmentDateVM.ext = "无";
	        	        devattachmentDateVM.location = text2;
	        	        devattachmentDateVM.type = 8
	        	        devattachmentDateVM.deviceId = id;
	       	        	saveData("${ pageContext.request.contextPath }/deviceMgt/devattachment/saveAttachmentFile.do", devattachmentDateVM)
	                }
	        		for(var i = 0; i < nb4 ; i++){
	        	        var text3 = $(".devAttFile tbody tr").eq(i).find("td").eq(0).find("input").val();
	        	        var text4 = $(".devAttFile tbody tr").eq(i).find("td").eq(1).find("input").val();
	        	        if(text3 == "" || text3 == undefined || text3 == null){
	        	        	continue;
	        	        }
	        	        if(text4 == "" || text4 == undefined || text4 == null){
	        	        	continue;
	        	        }
	        	        devattachmentDateVM.creatorName = userName;
	        	        devattachmentDateVM.creatorAlias = userAlias;
	        	        devattachmentDateVM.createdDate = new Date();
	        	        devattachmentDateVM.creatorId = userId;
	        	        devattachmentDateVM.name = text3;
	        	        devattachmentDateVM.path = "无";
	        	        devattachmentDateVM.ext = "无";
	        	        devattachmentDateVM.location = text4;
	        	        devattachmentDateVM.type = 0
	        	        devattachmentDateVM.deviceId = id;
	           	     	saveData("${ pageContext.request.contextPath }/deviceMgt/devattachment/saveAttachmentFile.do", devattachmentDateVM)
					}
	        		saveSuccess("${pageContext.request.contextPath}/deviceMgt/deviceRegisterViewer.do?id="+id);
		    	}else{
		    		
		    	}
	    	}else{
	    		saveFailure();
	    	}
        }
		
        //管理人
	    function changManager(){
			var userInfo = loadData("${ pageContext.request.contextPath }/system/user/loadUserData.do",{"userId": $("#manager").val()});
			deviceDateVM.managerId = userInfo.userId;
			deviceDateVM.managerName = userInfo.userName;
			deviceDateVM.managerAlias = userInfo.userAlias;
	    }
        
	    function bindDataToVM(){
	    	if(deviceDateSource.id == "" || deviceDateSource.id == undefined || deviceDateSource.id == null){   //没有ID就是新增
				deviceDateVM.id = uuid;
				deviceDateVM.creatorName = "${sessionScope.loginUser.userName}";
				deviceDateVM.creatorId = "${sessionScope.loginUser.userId}";
				deviceDateVM.creatorAlias = "${sessionScope.loginUser.userAlias}";
				deviceDateVM.createdDate = new Date();
				deviceDateVM.source = "0";
	    	}else{
	    		deviceDateVM.modifiedDate = new Date();
	    	}
	    }
        

		ko.applyBindings(vm);
		attrOne();
		attrTwo();
   	 	$(".promptDiv").slideUp();
        
        
        function attrOne(){
        		function getOperationCol(data,type,row){
    				var html = "";
    				html += "<a class=\"delete-btnTwo\" onclick=\"remove('" + row.id + "');\" title=\"删除\"><i class=\"fa fa-times\"></i></a> "; //查看
    				return html;
        		}
        		
        		loadGridData();
            	
        		//加载列表数据
        		function loadGridData() {
        			//数据列绑定
        			var columns = [
        				{ "mData" : "name", "bSortable" : false },
        				{ "mData" : "location", "bSortable" : false },
        				{ "mData" : null , "bSortable" : false,  "mRender": getOperationCol, "sWidth": "150px" },
        				{ "mData" : "createdDate", "bSortable" : false,"bVisible" : false }
                    ];
              	
        			//排序规则
        			var sorting = [ [ 3 , 'desc' ] ];
            	  
        			//扩展参数
        			var extraParams = [ {
        				"name" : "deviceId",
        				"value" : "${param.id}"
        			}, {
        				"name" : "type",
        				"value" : 8
        			} ];
        			//初始化数据表
        			dataTable = new BSDataTable();
        			dataTable.initialize({
        				"tableId" : "table2",
        				"columns" : columns,
        				"sorting" : sorting,
        				"pageSize" : DEFAULT_PAGE_SIZE,
        				"dataSource" : "${pageContext.request.contextPath}/deviceMgt/devattachment/DevattachmentGirdData.do",
        				"extraParams" : extraParams,
        				"style" : DT_FULL_NUMBERS,
        				"bProcessing" : true,
        				"url" : {
//         					"addDataUrl" : "/eeip/meetingMgt/generalMeet/meetingApplyForm.do",
//         					"editDataUrl" : "/eeip/meetingMgt/generalMeet/meetingApplyForm.do",
//         					"rmDataUrl" : "/eeip/meeting/meetingApp/removeMeetingAppData.do"
        				}
        			});
                    
        			//隐藏列表组件显示条数  --  数量   和 分页
        			$('#table2_length').hide();
        			$('#table2_paginate').hide();
        			$('#table2_info').hide();
                 }
        }
    	function attrTwo(){
    		function getOperationCol(data,type,row){
				var html = "";
				html += "<a class=\"delete-btnTwo\" onclick=\"remove('" + row.id + "');\" title=\"删除\"><i class=\"fa fa-times\"></i></a> "; //查看
				return html;
    		}
    		
    		loadGridData();
        	
    		//加载列表数据
    		function loadGridData() {
    			//数据列绑定
    			var columns = [
    				{ "mData" : "name", "bSortable" : false },
    				{ "mData" : "location", "bSortable" : false },
    				{ "mData" :  null , "bSortable" : false ,"mRender": getOperationCol},
    				{ "mData" : "createdDate", "bSortable" : false,"bVisible" : false }
                ];
          	
    			//排序规则
    			var sorting = [ [ 3 , 'desc' ] ];
        	  
    			//扩展参数
    			var extraParams = [ {
    				"name" : "deviceId",
    				"value" : "${param.id}"
    			}, {
    				"name" : "type",
    				"value" : 0
    			} ];
    			//初始化数据表
    			dataTable = new BSDataTable();
    			dataTable.initialize({
    				"tableId" : "table3",
    				"columns" : columns,
    				"sorting" : sorting,
    				"pageSize" : DEFAULT_PAGE_SIZE,
    				"dataSource" : "${pageContext.request.contextPath}/deviceMgt/devattachment/DevattachmentGirdData.do",
    				"extraParams" : extraParams,
    				"style" : DT_FULL_NUMBERS,
    				"bProcessing" : true,
    				"url" : {
//     					"addDataUrl" : "/eeip/meetingMgt/generalMeet/meetingApplyForm.do",
//     					"editDataUrl" : "/eeip/meetingMgt/generalMeet/meetingApplyForm.do",
//     					"rmDataUrl" : "/eeip/meeting/meetingApp/removeMeetingAppData.do"
    				}
    			});
                
    			//隐藏列表组件显示条数  --  数量   和 分页
    			$('#table3_length').hide();
    			$('#table3_paginate').hide();
    			$('#table3_info').hide();
             }
    	}
        
		loadCertificate();
    	
	    function loadCertificate (){
			var attData = loadData("${pageContext.request.contextPath}/deviceMgt/devattachment/getAttachmentPictureNum.do",{ "id" : "${param.id}" });
			if(attData.length>0){
				var html = "";
				for( var i = 0; i < attData.length; i++ ){
		    		/* var html= '<img src="${pageContext.request.contextPath}/deviceMgt/devattachment/showAttachmentPicture.do?id='+attData[i].id+'"/>';
					var className=".file";
					$(className).append(html);
					console.log(html) */
					html += '<li><span><img data-toggle="modal" data-target=".modal-bigImg" src="${pageContext.request.contextPath}/deviceMgt/devattachment/showAttachmentPicture.do?id='+attData[i].id+'"/></span></li>';
				}
		    	$(".img-list").append(html);
		    	
		    	/* var html2 = '<img src="${pageContext.request.contextPath}/deviceMgt/devattachment/showAttachmentPicture.do?id='+attData[0].id+'"/>';
		    	$(".big-img").append(html2); */
		    }
		}        
        
	    function remove(attrId){
	    	$.ajax({
				url:'${ pageContext.request.contextPath }/deviceMgt/devattachment/deleteAttachmentFalseData.do',
		        type:"post",
		        data:{"attrId":attrId},
	            traditional: true,//属性在这里设置
				success:function(data){
			        attrOne();
			        attrTwo();
				}
	    	})
	    }
        
      	//维护方式
	    $("#radio1").click(function(){
	    	deviceDateVM.maintMethod = 0;
	    })
	    $("#radio2").click(function(){
	    	deviceDateVM.maintMethod = 1;
	    })
	    //校准/检定/验证方式
	    $("#radio3").click(function(){
	    	deviceDateVM.verificationMethod = 0;
	    })
	    $("#radio4").click(function(){
	    	deviceDateVM.verificationMethod = 1;
	    })
    </script>
</body>
</html>