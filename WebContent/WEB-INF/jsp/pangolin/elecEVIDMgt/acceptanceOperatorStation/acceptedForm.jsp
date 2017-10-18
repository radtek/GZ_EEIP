<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>电子物证管理-受理人员操作台-检材受理-受理</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script> 
    <script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
  	<script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script> 
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>	 
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/zyupload.basic-1.0.0.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/base.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/ajaxfileupload.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/workflow/workflow.js" />"></script>
  	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/zyupload-1.0.0.min.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
  	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>电子物证管理</a><span>></span><a>受理人员操作台</a><span>></span><a>检材受理</a><span>></span><a>受理</a>
        </p>
    </div>
    <jsp:include page="/common/tabsContent.jsp"></jsp:include>
     <div class="tabs-list" id="register">
    	<iframe class="iframe-page iframe-register" src=""></iframe>
    </div>   
    <div class="tabs-list" id="accepted">
    	<div class="form-module">
	        <div class="form-module-title">
	            <p>检材受理</p>
	        </div>
	        <div class="form-content">
	            <form class="form-horizontal">
	                <div class="form-group">
	                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>受理意见：</label>
	                    <div class="col-sm-10">
	                        <div class="matter-content">
	                            <div class="matter-module">
	                                <div class="matter-module-title">外观是否完整：</div>
	                                <div class="matter-module-option  appearanceSitn">
	                                    <div class="col-sm-4">
	                                        <div class="rdio rdio-primary">
					                            <input type="radio" name="radio1" value="1" id="radioYes">
					                            <label for="radioYes">是</label>
					                        </div>
	                                    </div>
	                                    <div class="col-sm-4">
	                                        <div class="rdio rdio-primary">
					                            <input type="radio" name="radio1" value="0" id="radioNo">
					                            <label for="radioNo">否</label>
					                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                            <div class="matter-module">
	                                <div class="matter-module-title">拟同意接收：</div>
	                                <div class="matter-module-option  receptionSitn">
	                                    <div class="col-sm-4">
	                                        <div class="rdio rdio-primary">
					                            <input type="radio" name="radio2" value="1" id="radioYes2">
					                            <label for="radioYes2">是</label>
					                        </div>
	                                    </div>
	                                    <div class="col-sm-4">
	                                        <div class="rdio rdio-primary">
					                            <input type="radio" name="radio2" value="0" id="radioNo2">
					                            <label for="radioNo2">否</label>
					                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                            <div class="matter-module">
	                            <div class="matter-module-title">其他（可为空）：</div>
	                                <div class="matter-module-option">
	                                    <div class="col-sm-12" data-bind="with:appraisalVm">
	                                        <input type="text" value="" class="other-inputs" data-bind="value :other" />
	                                    </div>
	                                   
	                                </div>
	                            </div>
	                        </div>
	                    </div>					
	                </div>
	                <!-- <div class="form-group">
		                 <label class="col-sm-2 control-label">受理时间：</label>
		                 <div class="col-sm-4" data-bind="with:appraisalVm">
		                     <input type="text" data-bind="dateTimePicker:acceptedDate"  class="form-control datetimepicker" />
		                 </div>
	                </div> -->
	                <div class="form-group">
	                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>受理拍照：</label>
	                    <div class="col-sm-10">
	                        <div id="zyupload" class="zyupload"></div>  
	                    </div>
	                </div>

					<!--  <div class="form-group">
						<label class="col-sm-2 control-label">受理视频文件：</label>
						<div class="col-sm-10">
						<div class="file-list"></div>
						<div class="upload-content">
							<div class="upload-input">
								<input type="text" class="file-name" readonly />
							</div>
							<div class="upload-btn">
								<button type="button" class="btn btn-color1 file-browse">
									<i class="fa fa-folder-open-o"></i>浏览
								</button>
								<button type="button" class="btn btn-color2 file-upload-btn"
									id="2">
									<i class="fa fa-upload"></i>上传
								</button>
								<input type="file" class="file-input" id="file2" name="file" />
							</div>
						</div>
					  </div>
					</div>  -->
					
					 <div class="form-group">
						<label class="col-sm-2 control-label">受理视频文件：</label>
						<div class="col-sm-4">
							<input type="text" class="form-control file-name" readonly />
						</div>
						<div class="col-sm-6 file-btn">
							<button type="button" class="btn btn-color1 file-browse"><i class="fa fa-folder-open-o"></i>浏览</button>
							<button type="button" id="itemUploadFile" class="btn btn-color2 file-upload-btn"><i class="fa fa-upload"></i>上传</button>
							<input type="file" name="file" id="itemFile" class="file-input">
						</div>
						<div class="recordfile col-sm-12">
							<div class="col-sm-2"></div>
							<div class="col-sm-10 recordOkfile" id="signOkFile"></div>
						</div>
					</div> 

				</form>
	        </div>
	    </div>
	    <div class="btn-content">
	        <button type="button" data-bind="click: backToList"  class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
	        <button type="button" data-bind="click: passData"  class="btn btn-color1 ok"><i class="fa fa-check"></i>通过</button>
	        <button type="button" data-bind="click: refuseData"  class="btn btn-color1"><i class="fa fa-times"></i>拒绝</button>
	    </div>
    </div>
    <jsp:include page="/common/alertMessages.jsp"></jsp:include>
    <script>
    initWorkflow("${pageContext.request.contextPath}"); //初始化工作流
    
	    /* 标签页事件和样式-开始 */
		var clickStatus = 1;	//点击状态
		var dataStatus = 1;		//数据状态
		tabsContent(clickStatus,dataStatus);
		/* 标签页事件和样式-结束  */
	    
	    $(".back-btn").click(function(){
	    	var url = "${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/acceptedList.do";
	    	$(".index-iframe", window.parent.document).attr("src",url);
	    });
		
	    $('.datetimepicker').datetimepicker({
	       format: 'YYYY-MM-DD  HH:mm',
	    });
	    
	 	// 初始化插件
		$("#zyupload").zyUpload({
			width            :   "100%",                 // 宽度
			height           :   "",                 	 // 高度
			itemWidth        :   "140px",                 // 文件项的宽度
			itemHeight       :   "115px",                 // 文件项的高度
			url              :   "${ pageContext.request.contextPath }/elecEVIDMgt/appraisalAcptAtt/saveData.do?appraisalId="+"${param.id}",  // 上传文件的路径
			fileType         :   ["jpg", "jpeg", "png", "bmp", "JPG", "JPEG", "PNG", "BMP"],// 上传文件的类型
			fileSize         :   1073741824,                // 上传文件的大小
			multiple         :   true,                    // 是否可以多个文件上传
			dragDrop         :   false,                   // 是否可以拖动上传文件
			tailor           :   false,                   // 是否可以裁剪图片
			del              :   true,                    // 是否可以删除文件
			finishDel        :   false,  				  // 是否在上传文件完成后删除预览
			/* 外部获得的回调接口 */
			onSelect: function(selectFiles, allFiles){    // 选择文件的回调方法  selectFile:当前选中的文件  allFiles:还没上传的全部文件
			},
			onDelete: function(file, files){              // 删除一个文件的回调方法 file:当前删除的文件  files:删除之后的文件
			},
			onSuccess: function(file, response){  
			},
			onFailure: function(file, response){          // 文件上传失败的回调方法
				console.info("此文件上传失败："+file.name);
			},
			onComplete: function(response){           	  // 上传完成的回调方法
				 
			}
		});
    
	$(function(){	
		$(".tabs-nav li").click(function(){
			var aClass = $(this).find("a").attr("class");
			if( aClass == "register" ){
				if( $(".iframe-"+aClass).attr("src") == "" ){
					var src = "${pageContext.request.contextPath}/common/registerInfoView.jsp";
					$(".iframe-"+aClass).attr("src", src);
					$(".iframe-"+aClass).load(function(){
			            var mainheight = $(this).contents().find("body").height()+30;
			            $(this).height(mainheight);
			        });
				}
			}
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
	   	appraisalData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/loadDataById.do",{ "id" : "${param.id}" });
	    var appraisalDataVm = ko.mapping.fromJS(appraisalData);
	    var vm={
	    		appraisalVm:appraisalDataVm 
	    };
	    
	    appraisalDataVm.acceptedDate = new Date();
	    vm.passData = function(){ 
	    	var fileNum = 0;
	    	if(!$(".appearanceSitn").find("input[name='radio1']:checked").val()){
	    		saveFailure('"外观是否完整：" 不能为空。');
	    		return false;
	    	}
	    	if(!$(".receptionSitn").find("input[name='radio2']:checked").val()){
	    		saveFailure('"拟同意接收：" 不能为空。');
	    		return false;
	    	}
	    	$(".upload_append_list").each(function(){	    		
	    		if($(this).css("display")=="block" && $(this).find(".file_success").css("display")=="block" ){
	    			fileNum+=1;
	    		}
	    	});		    	
	    	if(fileNum==0){		
	    		saveFailure('"受理拍照：" 必须上传，才能提交。');
	    		return false;
	    	}
	    	
	    	var sitn = $(".receptionSitn").find("input[type='radio']:checked").val();
	    	if( sitn == 0){
	    		saveFailure('拟办不同意，不能通过受理');
	    	}else{
	    		$("button").attr("disabled", true);
		        if ( validateSubmittedData() ) {
		        	bindPassDataVM();
		        	if (saveData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/saveData.do", appraisalDataVm)) {
		        		//获取文号
		        	    var date = new Date();
		        		var year = date.getFullYear();
		        		var archiveCodeData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/archiveCode/getDataByAgecyAndYear.do",{ "appraisalId": appraisalData.id ,"agency" : "1" , "year" : year });
		        		
		        		appraisalDataVm.agency = archiveCodeData.agency;
		        		appraisalDataVm.year = archiveCodeData.year;
		        		appraisalDataVm.sn = archiveCodeData.sn;
		        		if (saveData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/saveData.do", appraisalDataVm)) {
		        			createTask(appraisalDataVm.id); //构建工作项
		        			saveSuccess("${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/acceptedList.do");
		        		}else{
		        			saveFailure("保存失败！");
		        		}
					} else {
						saveFailure("保存失败！");
					}
		        } else {
		        	saveFailure();
		        } 
	    	}
	    }
	    
	    vm.refuseData = function(){ 
	    	var sitn = $(".receptionSitn").find("input[type='radio']:checked").val();
	    	if( sitn == 1){
	    		saveFailure('拟办同意，不能拒绝受理');
	    	}else{
		    	$("button").attr("disabled", true);
		        if ( validateSubmittedData() ) {
		        	bindRefuseDataVM();
		        	if (saveData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/saveData.do", appraisalDataVm)) {
	        			createTask(appraisalDataVm.id); //构建工作项
						saveSuccess("${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/acceptedList.do");
					} else {
						
					}
		        } else {
		        	saveFailure();
		        } 
	    	}
	    }
	    
	     
		vm.backToList = function(){//返回
				$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/acceptedList.do');
			}  
			ko.applyBindings(vm);
			
			function bindPassDataVM(){ 
				appraisalDataVm.acceptorId="${sessionScope.loginUser.userId}";
				appraisalDataVm.acceptorName="${sessionScope.loginUser.userName}";
				appraisalDataVm.acceptorAlias="${sessionScope.loginUser.userAlias}";
				appraisalDataVm.appearanceSitn = $(".appearanceSitn").find("input[type='radio']:checked").val();
				appraisalDataVm.receptionSitn = $(".receptionSitn").find("input[type='radio']:checked").val();
				appraisalDataVm.status=2;
			} 
			function bindRefuseDataVM(){ 
				appraisalDataVm.acceptorId="${sessionScope.loginUser.userId}";
				appraisalDataVm.acceptorName="${sessionScope.loginUser.userName}";
				appraisalDataVm.acceptorAlias="${sessionScope.loginUser.userAlias}";
				appraisalDataVm.appearanceSitn = $(".appearanceSitn").find("input[type='radio']:checked").val();
				appraisalDataVm.receptionSitn = $(".receptionSitn").find("input[type='radio']:checked").val();
				appraisalDataVm.status=1;
			} 
	    });
	
	$(".tabs-nav li").click(function(){
		var aClass = $(this).find("a").attr("class");
		if( aClass == "register" ){
			if( $(".iframe-"+aClass).attr("src") == "" ){
				var src = "${pageContext.request.contextPath}/elecEVIDMgt/registerInfoView.do?commonPreappraisalId="+appraisalData.preappraisalId;
				$(".iframe-"+aClass).attr("src", src);
				$(".iframe-"+aClass).load(function(){
		            var mainheight = $(this).contents().find("body").height()+30;
		            $(this).height(mainheight);
		        });
			}
		}
	});		
	
	//浏览按钮
    $(".file-browse").click(function(){
    	$(".file-input").click();
    	$('.file-input').change(function(){
    	 	if($('.file-input').val() !=''){
          		$('.file-name').val($('.file-input').val());
          	}else{
          		$('.file-name').val('');
          	}
	    })
    });
    $('.file-input').change(function(){
	 	if($('.file-input').val() !=''){
      		$('.file-name').val($('.file-input').val());
      	}else{
      		$('.file-name').val('');
      	}
    })
    
    //上传按钮
    $(".file-upload-btn").click(function(){
    	var type = $(this).siblings("input").attr("id");
    	var fileList = $(this).parents(".upload-content").prev(".file-list");
    	var fileName = $(this).parent().prev().find(".file-name");       	
    	var fileType = fileName.val().split(".")[fileName.val().split(".").length-1];
    	var typeArr = ["mov", "avi", "mp4", "wmv"];       	       	
    	if($.inArray(fileType,typeArr)== -1){
    		promptContent("不能上传该类型文件！");
    		$(".alert").removeClass("alert-success").addClass("alert-danger");
 			$(".promptDiv").slideDown();
 		    setTimeout(function(){
 				$(".promptDiv").slideUp();
 		    },2000);
    		return false;
    	}
			$.ajaxFileUpload({
				url:'${ pageContext.request.contextPath }/elecEVIDMgt/appraisalAcptAtt/saveData.do',
				data:{'appraisalId' : "${param.id}"},
				secureuri:false,
				fileElementId:type,//file标签的id
				dataType: 'json',//返回数据的类型
				success: function (data) {
					console.log(data);
					var name = data.name;
					if(name == "" || name == undefined || name == null){
						saveFailure("文件上传失败,请重新上传");
					}else{
						var html='';
						html += '<div class="list-content">';
						html += '<div class="list-img">';
						html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/video.png" />';
						html += '</div>';
						html += '<div class="ccflie list-name"><p><span id="fileNameText">'+data.name +'</span></p>';
	  					html += '<button type="button"  data-id="'+data.id+'" class="remove">×</button></div>';
	  					
						html += '</div>';
						$('.recordOkfile').append(html);
						$('.recordfile').show();
					}
				},
				error: function (data, status, e) {
				}
			});  		  	   	  
    });
    
    
    /*文件删除*/
	  $('#signOkFile').on('click','.remove',function(){
		  //alert('dd');
		  var  fileid = $(this).attr('data-id');
	  	  var  filethis = $(this);
	  	  $.ajax({
	  		  url:'${pageContext.request.contextPath}/elecMgt/appraisalAcptAtt/removeAttById.do',
	  		  data:{'id':fileid},
	  		  datatype:'json',
	  		  type:'post',
	  		  success:function(data){
	  			//filethis.parent(".list-content").remove();
	  			  if( data['status'] ){
	  				  //remonve删除
	  				filethis.parents(".list-content").remove();
	  			  }
	  		  },
	  		  error:function(){
	  			saveFailure('浏览器缓存，上传失败，请刷新浏览器');
	  		  }
	  	  })
	    })    	 
    /*文件删除结束*/
    </script>
</body>
</html>