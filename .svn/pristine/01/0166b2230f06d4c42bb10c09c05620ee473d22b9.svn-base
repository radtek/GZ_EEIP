<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>电子物证管理-受理人员操作台-检材交接-归还</title>
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
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>电子物证管理</a><span>></span><a>受理人员操作台</a><span>></span><a>检材交接</a><span>></span><a>归还</a>
        </p>
    </div>
    <jsp:include page="/common/tabsContent.jsp"></jsp:include>
    <div class="tabs-list" id="register">
    	<iframe class="iframe-page iframe-register" src=""></iframe>
    </div>
    <div class="tabs-list" id="accepted">
    	<iframe class="iframe-page iframe-accepted" src=""></iframe>
    </div> 
    <div class="tabs-list" id="check">
    	<iframe class="iframe-page iframe-check" src=""></iframe>
    </div>  
    <div class="tabs-list" id="warehousing">
    	<iframe class="iframe-page iframe-warehousing" src=""></iframe>
    </div>  
    <div class="tabs-list" id="process">
	    <div class="form-module">
	        <div class="form-module-title">
	            <p>检材归还</p>
	        </div>
	        <div class="form-content">
	            <form class="form-horizontal">
	                <div class="form-group">
	                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>归还人：</label>
	                    <div class="col-sm-4" data-bind="with:evidTransitionVm">
	                       <input type="text" class="form-control" data-bind="value:applicantAlias" readonly required />
	                    </div>
	                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>归还时间：</label>
	                    <div class="col-sm-4" data-bind="with:evidTransitionVm">
	                        <input type="text"  data-bind="value:applicantDate" class="form-control" readonly required />
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>归还拍照：</label>
	                    <div class="col-sm-10">
	                        <div id="zyupload" class="zyupload"></div> 
	                    </div>
	                </div>
	              <!--   <div class="form-group">
						<label class="col-sm-2 control-label">归还视频文件：</label>
						<div class="col-sm-4">
							<input type="text" class="form-control file-name" readonly />
						</div>
						<div class="col-sm-6 file-btn">
							<button type="button" class="btn btn-color1 file-browse"><i class="fa fa-folder-open-o"></i>浏览</button>
							<button type="button" id="itemUploadFile" class="btn btn-color2 file-upload-btn"><i class="fa fa-upload"></i>上传</button>
							<input type="file" name="file" id="itemFile" class="file-input">
						</div>
						<div class="recordfile">
						    <div class="col-sm-2"></div>
							<div class="col-sm-10 recordOkfile" id="signOkFile"></div>
						</div>
					</div> -->
	            </form>
	        </div>
	    </div>
	    <div class="btn-content">
	        <button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
	        <button class="btn btn-color1" data-bind="click: saveData"><i class="fa fa-check"></i>提交</button>
	    </div>
	</div>
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
    <script>
	    $(function(){
	     	evidTransitionData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/evidTransition/loadDataById.do",{ "id" : "${param.id}" });
	     	var applicantDate = evidTransitionData.applicantDate; 
	     	evidTransitionData.applicantDate=  new Date(evidTransitionData.applicantDate).Format("yyyy-MM-dd hh:mm")
		    var evidTransitionDataVm = ko.mapping.fromJS(evidTransitionData);
		  
		    evidOpLogData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/evidOpLog/getDataById.do",{ "id" : "" });
		  	var evidOpLogDataVm = ko.mapping.fromJS(evidOpLogData);
		  	
		    var evidenceData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/evidence/getDataById.do",{ "id" :  evidTransitionData.evidId });
		  	var evidenceDataVm = ko.mapping.fromJS(evidenceData);
		  	
 		  	
		    var vm={
		    		evidTransitionVm : evidTransitionDataVm,
		    		evidOpLogVm:evidOpLogDataVm,
		    		evidenceDataVm : evidenceDataVm
		    };
		    
		    var imgValidate = true;
		    vm.saveData = function(){  	
		    	$("button").attr("disabled", true);		    	
		    	var fileNum = 0;
				$(".upload_append_list").each(function(){	    		
		    		if($(this).css("display")=="block" && $(this).find(".file_success").css("display")=="block" ){
		    			fileNum+=1;
		    		}
		    	});							
		    	if(fileNum==0){		
		    		saveFailure('"归还拍照：" 必须上传，才能提交。');
		    		return false;
		    	}
		        if ( validateSubmittedData() ) {
		        	if( imgValidate ){
		        		bindEvidTransitionDataVM();
			        	if (saveData("${pageContext.request.contextPath}/elecEVIDMgt/evidTransition/saveData.do", evidTransitionDataVm)) {
			        		evidenceDataVm.status = 0;
	 		        		if(saveData("${pageContext.request.contextPath}/elecEVIDMgt/evidence/saveData.do", evidenceDataVm)){
	 		        			//保存日志信息
				        		bindLogDataVM();
				        		if (saveData("${pageContext.request.contextPath}/elecEVIDMgt/evidOpLog/saveData.do", evidOpLogDataVm)) {
				        			saveSuccess("${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/handoverList.do");
								}else{
									saveFailure(" 保存失败！");
								}
	 		        		}else{
	 		        			saveFailure(" 保存失败！");
	 		        		} 
						}
		        	}else {
			        	saveFailure("照片还没上传！");
			        } 
		        } else {
		        	saveFailure();
		        } 
		    }
	    	
		    ko.applyBindings(vm);
		    
		    function bindEvidTransitionDataVM(){
		    	evidTransitionDataVm.operatorId="${sessionScope.loginUser.userId}";
		    	evidTransitionDataVm.operatorName="${sessionScope.loginUser.userName}";
		    	evidTransitionDataVm.operatorAlias="${sessionScope.loginUser.userAlias}";
		    	evidTransitionDataVm.status="1"; 
		    	evidTransitionDataVm.applicantDate=applicantDate; 
		    	evidTransitionDataVm.confirmedDate = new Date();
		    }
		    function bindLogDataVM(){
		    	evidOpLogDataVm.evidName=evidTransitionData.evidName;
		    	evidOpLogDataVm.evidSn = evidTransitionData.evidSn;
		    	evidOpLogDataVm.caseName = evidTransitionData.caseName;
		    	evidOpLogDataVm.caseSn = evidTransitionData.caseSn;
		    	evidOpLogDataVm.evidId=evidTransitionData.evidId;
		    	evidOpLogDataVm.creatorId = "${sessionScope.loginUser.userId}";
		    	evidOpLogDataVm.creatorName = "${sessionScope.loginUser.userName}";
		    	evidOpLogDataVm.creatorAlias = "${sessionScope.loginUser.userAlias}";
		    	evidOpLogDataVm.preappraisalId = evidTransitionData.preappraisalId;
		    	
		    }
		    
		    
		    /* 标签页事件和样式-开始 */
			var clickStatus = 4;	//点击状态
			var dataStatus = 4;		//数据状态
			tabsContent(clickStatus,dataStatus);
			/* 标签页事件和样式-结束  */
	        
			//条形码
			var barCodeid = $("#bcTarget");
			var value = barCodeid.siblings(".bar-code-input").val();
			code(barCodeid, value);
			
	        $(".back-btn").click(function(){
		    	var url = "${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/handoverList.do";
		    	$(".index-iframe", window.parent.document).attr("src",url);
		    });
	         
	     	// 初始化插件
			$("#zyupload").zyUpload({
				width            :   "100%",                 // 宽度
				height           :   "",                 	 // 高度
				itemWidth        :   "140px",                 // 文件项的宽度
				itemHeight       :   "115px",                 // 文件项的高度
				url              :   "${ pageContext.request.contextPath }/elecEVIDMgt/evidOpLogAtt/saveData.do?appraisalId="+evidTransitionData.appraisalId+"&evidId="+evidTransitionData.evidId+"&evidOpLogId="+evidOpLogData.id+"&preappraisalId="+evidTransitionData.preappraisalId+"&evidTransitionId="+evidTransitionData.id,  // 上传文件的路径
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
				onSuccess: function(file, response){          // 文件上传成功的回调方法
				},
				onFailure: function(file, response){          // 文件上传失败的回调方法
					console.info("此文件上传失败："+file.name);
				},
				onComplete: function(response){           	  // 上传完成的回调方法
				}
			});
	    });
    	
	 	//自动生成条形码
		function code(id, value){
			id.empty().barcode(value, "code128",{barWidth:1, barHeight:30,showHRI:false});
			id.siblings(".bar-code-text").html(value);
		}
		$(".tabs-nav li").click(function(){
    		var aClass = $(this).find("a").attr("class");
    		if( aClass == "register" ){
    			if( $(".iframe-"+aClass).attr("src") == "" ){
    				var src = "${pageContext.request.contextPath}/elecEVIDMgt/registerInfoView.do?commonPreappraisalId="+evidTransitionData.preappraisalId;
    				$(".iframe-"+aClass).attr("src", src);
    				$(".iframe-"+aClass).load(function(){
    		            var mainheight = $(this).contents().find("body").height()+30;
    		            $(this).height(mainheight);
    		        });
    			}
    		}else if( aClass == "accepted" ){
    			if( $(".iframe-"+aClass).attr("src") == "" ){
    				var src = "${pageContext.request.contextPath}/elecEVIDMgt/physicalEvidenceAcceptView.do?commonAppraisalId="+evidTransitionData.appraisalId;
    				$(".iframe-"+aClass).attr("src", src);
    				$(".iframe-"+aClass).load(function(){
    		            var mainheight = $(this).contents().find("body").height()+30;
    		            $(this).height(mainheight);
    		        });
    			}
    		}else if( aClass == "check" ){
    			if( $(".iframe-"+aClass).attr("src") == "" ){
    				var src = "${pageContext.request.contextPath}/elecEVIDMgt/checkInfoView.do?commonAppraisalId="+evidTransitionData.appraisalId;
    				$(".iframe-"+aClass).attr("src", src);
    				$(".iframe-"+aClass).load(function(){
    		            var mainheight = $(this).contents().find("body").height()+30;
    		            $(this).height(mainheight);
    		        });
    			}
    		}else if( aClass == "warehousing" ){
    			if( $(".iframe-"+aClass).attr("src") == "" ){
    				var src = "${pageContext.request.contextPath}/elecEVIDMgt/physicalEvidenceStorageView.do?commonAppraisalId="+evidTransitionData.appraisalId;
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
					url:"${ pageContext.request.contextPath }/elecEVIDMgt/evidOpLogAtt/saveData.do?appraisalId="+evidTransitionData.appraisalId+"&evidId="+evidTransitionData.evidId+"&evidOpLogId="+evidOpLogData.id+"&preappraisalId="+evidTransitionData.preappraisalId+"&evidTransitionId="+evidTransitionData.id,  // 上传文件的路径
					data:{'appraisalId' : "${param.id}"},
					secureuri:false,
					fileElementId:type,//file标签的id
					dataType: 'json',//返回数据的类型
					success: function (data) {
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
							html += '</div>';
							$('#signOkFile').append(html);
							$('.recordfile').show();
						}
					},
					error: function (data, status, e) {
					}
				});  		  	   	  
	    });
	    
	    
	    /*文件删除*/
		  $('#signOkFile').on('click','.remove',function(){
			  var  fileid = $(this).attr('data-id');
			  alert(fileid);
		  	  var  filethis = $(this);
		  	  $.ajax({
		  		  url:'${pageContext.request.contextPath}/elecEVIDMgt/evidOpLogAtt/removeDataById.do',
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