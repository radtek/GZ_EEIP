<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>设备管理新增表单</title>
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
  	<link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/zyupload-1.0.0.min.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>设备与环境管理</a><span>></span><a>设备管理</a><span>></span><a>新增</a>
        </p>
    </div>
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
                	<input id="receivingDate" name="receivingDate" class="form-control datetimepicker" data-bind="dateTimePicker:receivingDate" required/>
                </div>
                <label class="col-sm-2 control-label">启用日期：</label>
                <div class="col-sm-4" data-bind="with: deviceVM">
                	<input  id="usingDate" name="usingDate" class="form-control datetimepicker" data-bind="dateTimePicker:usingDate" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>存放地点：</label>
                <div class="col-sm-4" data-bind="with: deviceVM">
                    <input type="text" data-bind="value:location" name="location" id="location" class="form-control validation" required/>
                </div>
                <label class="col-sm-2 control-label">初次检定时间：</label>
                <div class="col-sm-4" data-bind="with: deviceVM">
                	<input  id="checkingDate" name="checkingDate" class="form-control datetimepicker" data-bind="dateTimePicker:checkingDate"/>
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
					<select id="manager" class="form-control" data-bind="options:users, optionsValue:'userId', optionsText:'userAlias', value:userId, optionsCaption:'--请选择--',event:{change:changManager}" required >
					</select>
				</div>
                <label class="col-sm-2 control-label" data-name=".maintenance-mode-radio">维护方式：</label>
                <div class="col-sm-2 maintenance-mode-radio">
                    <div class="rdio rdio-primary">
                        <input type="radio" name="radio1" value="" id="radio1">
                        <label for="radio1">合同维护保养</label>
                    </div>
                </div>
                <div class="col-sm-2 maintenance-mode-radio">
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
                <label class="col-sm-2 control-label" data-name=".verification-mode-radio">验证方式：</label>
                <div class="col-sm-2 verification-mode-radio">
                    <div class="rdio rdio-primary">
                        <input type="radio" name="radio2" value="" id="radio3">
                        <label for="radio3">合同校准/检定</label>
                    </div>
                </div>
                <div class="col-sm-2 verification-mode-radio">
                    <div class="rdio rdio-primary">
                        <input type="radio" name="radio2" value="" id="radio4">
                        <label for="radio4">自行校准/检定</label>
                    </div>
                </div>
            </div>
            <div class="form-group" >
                <label class="col-sm-2 control-label">设备外观照片：</label>
                <div class="col-sm-10">
                    <div id="zyupload" class="zyupload"></div>  
                </div>
            </div>
        </form>
    </div>
    <div class="file-upload">
        <table class="table table-bordered devTelFile">
            <thead>
                <tr>
                    <th>随机技术文件</th>
                    <th>存放使用地点</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
            </tbody>
            <tfoot>
            	<tr>
                    <td colspan="3" align="center">
                        <button class="btn add-tr-btn addFileOne"><i class="fa fa-plus"></i>增加</button>
                    </td>
                </tr>
            </tfoot>
        </table>
        <table class="table table-bordered devAttFile">
            <thead>
                <tr>
                    <th>附件</th>
                    <th>存放使用地点</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
            </tbody>
            <tfoot>
            	<tr>
                    <td colspan="3" align="center">
                        <button class="btn add-tr-btn addFileTwo"><i class="fa fa-plus"></i>增加</button>
                    </td>
                </tr>
            </tfoot>
        </table>
    </div>
    <div class="btn-content">
        <button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
        <button class="btn btn-color1" data-bind ="click : saveData"><i class="fa fa-check"></i>提交</button>
        <!-- <button class="btn btn-color1 tiaoye-btn"><i class="fa fa-check"></i>跳页</button> -->
    </div>
    <jsp:include page="/common/alertMessages.jsp"></jsp:include>
    <script>
    	$(".tiaoye-btn").click(function(){
    		var url = "${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/videoPlayback.do";
	    	//$(".index-iframe", window.parent.document).attr("src",url);
    		window.parent.location.href="${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/videoPlayback.do"; 
    	});
    
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
		
        var uuid = loadData("${ pageContext.request.contextPath }/deviceMgt/getUUID.do", {});
		var userName = "${sessionScope.loginUser.userName}";
		var userId = "${sessionScope.loginUser.userId}";
		var userAlias = "${sessionScope.loginUser.userAlias}";
	 	// 初始化插件
		$("#zyupload").zyUpload({
			width            :   "100%",                 // 宽度
			height           :   "",                 // 高度
			itemWidth        :   "140px",                 // 文件项的宽度
			itemHeight       :   "115px",                 // 文件项的高度
			url              :   "${ pageContext.request.contextPath }/deviceMgt/devattachment/saveDevattachment.do?id="+uuid+"&location=1&type=1",  // 上传文件的路径
			fileType         :   ["jpg", "jpeg", "png", "bmp", "JPG", "JPEG", "PNG", "BMP"],// 上传文件的类型
			fileSize         :   1073741824,                // 上传文件的大小
			multiple         :   true,                    // 是否可以多个文件上传
			dragDrop         :   false,                   // 是否可以拖动上传文件
			tailor           :   false,                   // 是否可以裁剪图片
			del              :   true,                    // 是否可以删除文件
			finishDel        :   false,  				  // 是否在上传文件完成后删除预览
			/* 外部获得的回调接口 */
			onSelect: function(selectFiles, allFiles){    // 选择文件的回调方法  selectFile:当前选中的文件  allFiles:还没上传的全部文件
				console.info("当前选择了以下文件：");
				console.info(selectFiles);
			},
			onDelete: function(file, files){              // 删除一个文件的回调方法 file:当前删除的文件  files:删除之后的文件
				console.info("当前删除了此文件：");
				console.info(file.name);
			},
			onSuccess: function(file, response){          // 文件上传成功的回调方法
				console.info("此文件上传成功：");
				console.info(file.name);
				console.info("此文件上传到服务器地址：");
				console.info(response);
				$("#uploadInf").append("<p>上传成功，文件地址是：" + response + "</p>");
			},
			onFailure: function(file, response){          // 文件上传失败的回调方法
				console.info("此文件上传失败：");
				console.info(file.name);
			},
			onComplete: function(response){           	  // 上传完成的回调方法
				console.info("文件上传完成");
				console.info(response);
			}
		});
	 	//$(".upload_preview").html("");
	 	$(".zyupload").on("click", ".file_del", function(){
	 		$(this).parents(".upload_append_list").addClass("removeClass");
	 	});
    
		var nb1 = 0;
		var nb2 = 0;
        $(".addFileOne").click(function(){
            var trHtml="";
            trHtml += '<tr>';
            trHtml += '<td><input type="text" class="validation" /></td>';
            trHtml += '<td><input type="text" class="validation" /></td>';
            trHtml += '<td><a class="delete-btnOne" title="删除"><i class="fa fa-times"></i></a></td>';
            trHtml += '</tr>';
            $(this).parents("tfoot").siblings("tbody").append(trHtml);
            nb1++;
        });
        $(".addFileTwo").click(function(){
            var trHtml="";
            trHtml += '<tr>';
            trHtml += '<td><input type="text" class="validation" /></td>';
            trHtml += '<td><input type="text" class="validation" /></td>';
            trHtml += '<td><a class="delete-btnTwo" title="删除"><i class="fa fa-times"></i></a></td>';
            trHtml += '</tr>';
            $(this).parents("tfoot").siblings("tbody").append(trHtml);
            nb2++;
        });
        
        $(".table").on("click", ".delete-btnOne", function(){
            $(this).parent("td").parent("tr").remove();
            nb1--;
        });
        $(".table").on("click", ".delete-btnTwo", function(){
            $(this).parent("td").parent("tr").remove();
            nb2--;
        });
        
        $(".back-btn").click(function(){
	    	var url = "${pageContext.request.contextPath}/deviceMgt/deviceMgtList.do";
	    	$(".index-iframe", window.parent.document).attr("src",url);
	    });
        
        var deviceDateSource = loadData("${ pageContext.request.contextPath }/deviceMgt/device/loadDeviceData.do", { "id" : "${param.id}" });
        var devattachment = loadData("${ pageContext.request.contextPath }/deviceMgt/devattachment/loadDevattachment.do", { "id" : " " });
		var AllUserData = loadData("${ pageContext.request.contextPath }/system/user/getAllUserData.do",{});
		var userData = loadData("${ pageContext.request.contextPath }/system/user/loadUserData.do",{"id":deviceDateSource.managerId});
		
		var userDataVM = {
			users : ko.observableArray(AllUserData),
			userId : ko.mapping.fromJS(userData),
		}

        
        var deviceDateVM = ko.mapping.fromJS(deviceDateSource);
        var devattachmentDateVM = ko.mapping.fromJS(devattachment);
        
        var vm = {
        	deviceVM : deviceDateVM,
        	devattachmentVM : devattachmentDateVM,
			userVM : userDataVM
        }
        
        ko.applyBindings(vm);
        
        $("#receivingDate").on("dp.change", function(e) {
			var date = new Date(e.date);//将时间戳转换为Date
			date.setMinutes(date.getMinutes() + 1);//给Date的小时数加1
			e.date._d = date;//将加1后的Date重新赋给e.date中的_d属性
			$('#usingDate').data("DateTimePicker").minDate(e.date);
			$('#receivingDate').data("DateTimePicker").minDate(new Date());
		});
        
        vm.saveData = function(){
	    	$("button").attr("disabled", true);
	    	if(validateSubmittedData()){
	    		bindDataToVM();		    	
				//var flag = saveData("${pageContext.request.contextPath}/psnlInfo/userBasicInfo/saveUserBasicInfoData.do",userDataVM);
				if( saveData("${ pageContext.request.contextPath }/deviceMgt/device/saveDeviceData.do", deviceDateVM) ){
					//保存两个附件
	                for(var i = 0; i < nb1; i++){
	        	        var text1 = $(".devTelFile tbody tr").eq(i).find("td").eq(0).find("input").val();
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
	        	        devattachmentDateVM.deviceId = uuid;
	       	        	saveData("${ pageContext.request.contextPath }/deviceMgt/devattachment/saveAttachmentFile.do", devattachmentDateVM)
	                }
	                for(var i = 0; i < nb2; i++){
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
	        	        devattachmentDateVM.deviceId = uuid;
	           	     	saveData("${ pageContext.request.contextPath }/deviceMgt/devattachment/saveAttachmentFile.do", devattachmentDateVM)
					}
					saveSuccess("${pageContext.request.contextPath}/deviceMgt/deviceMgtList.do");
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
        
        //保存基本信息
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