<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>电子物证管理-受理人员操作台-检材入库-入库</title>
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
  	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/zyupload-1.0.0.min.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>电子物证管理</a><span>></span><a>受理人员操作台</a><span>></span><a>检材入库</a><span>></span><a>入库</a>
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
	    <div class="form-module">
	        <div class="form-module-title">
	            <p>检材入库</p>
	        </div>
	        <div class="form-content">
	            <form class="form-horizontal">
	                <div class="form-group">
	                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>条形码：</label>
	                    <div class="col-sm-4">
	                        <div class="bar-code-content">
						        <div id="bcTarget" class="bcTarget bar-code-img"></div> 
								<div class="bar-code-text" style="font-size: 12px;text-align: center;font-weight: bold;"></div>
		                    </div>
	                    </div>
	                    <div class="col-sm-4">
	                        <button type="button" class="btn btn-color1" data-toggle="modal" data-target="#myModal"><i class="fa fa-print"></i>打印</button>
	                    </div>
	                </div>
	          
	                <div class="form-group">
	                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>存放位置：</label>
	                    <div class="col-sm-10" data-bind="with:evidenceDataVm">
	                        <input type="text" placeholder="" class="form-control location" data-bind="value:location" required/>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>入库拍照：</label>
	                    <div class="col-sm-10">
	                        <div id="zyupload" class="zyupload"></div> 
	                    </div>
	                </div>
	            </form>
	        </div>
	    </div>
	    <div class="btn-content">
	        <button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
	        <button class="btn btn-color1" data-bind="click: saveData" ><i class="fa fa-check"></i>提交</button>
	    </div>
	</div>
	
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  	<div class="modal-dialog" role="document">
	    	<div class="modal-content">
		      	<div class="modal-header">
		        	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        	<h4 class="modal-title" id="myModalLabel">条形码</h4>
		      	</div>
		      	<div class="modal-body">
		       		<iframe class="bar-code-iframe codePrint" src=""></iframe>
		      	</div>
		      	<div class="modal-footer">
		        	<button type="button" class="btn btn-primary print-btn">打印</button>
		        	<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		      	</div>
	    	</div>
	  	</div>
	</div>
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
    <script>
	    $(function(){
	    	var submitStatus = false;
	        var evidenceData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/evidence/getDataByAppraisalId.do",{ "appraisalId" : "${param.id}" });
	        evidenceDataVm = ko.mapping.fromJS(evidenceData);
	    	
	        appraisalData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/loadDataById.do",{ "id" : "${param.id}" });
	        
	    	var evidOpLogData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/evidOpLog/getDataById.do",{ "id" : "" });
	    	evidOpLogDataVm = ko.mapping.fromJS(evidOpLogData);
	    	 
		  	$(".codePrint").attr("src","${pageContext.request.contextPath}/common/barCodePage.jsp?value="+appraisalData.evidSn);
		  	var vm = {
	    		evidenceVm : evidenceDataVm,
	    		evidOpLogVm : evidOpLogDataVm
		    }
		    
		    vm.saveData = function(){  		  		
		  		if( submitStatus ){
		  			var fileNum = 0;
					$(".upload_append_list").each(function(){	    		
			    		if($(this).css("display")=="block" && $(this).find(".file_success").css("display")=="block" ){
			    			fileNum+=1;
			    		}
			    	});							
			    	if(fileNum==0){		
			    		saveFailure('"入库拍照：" 必须上传，才能提交。');
			    		return false;
			    	}
		  			$("button").attr("disabled", true);
			        if ( validateSubmittedData() ) {
			        	bindEvidenceDataVM(); 
			        	//保存电子物证信息
			        	if (saveData("${pageContext.request.contextPath}/elecEVIDMgt/evidence/saveData.do", evidenceDataVm)) {
			        		//保存日志信息
			        		bindLogDataVM();
 			        		if (saveData("${pageContext.request.contextPath}/elecEVIDMgt/evidOpLog/saveData.do", evidOpLogDataVm)) {
			        			saveSuccess("${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/warehousingList.do");
							}
						}
			        }else{
			        	saveFailure();
			        } 
		  		}else{
		  			saveFailure("请先打印条形码！");
		  		}
		    } 
			ko.applyBindings(vm); 
	    	
			/* 标签页事件和样式-开始 */
			var clickStatus = 3;	//点击状态
			var dataStatus = 3;		//数据状态
			tabsContent(clickStatus,dataStatus);
			/* 标签页事件和样式-结束  */
	       
			//条形码
			var barCodeid = $(".bcTarget"); 
			code(barCodeid, appraisalData.evidSn);
			$(".print-btn").click(function(){
				submitStatus = true;
				$(".bar-code-iframe").contents().find(".print-page").click();
			});
			
	        $(".back-btn").click(function(){
	  	    	var url = "${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/warehousingList.do";
	  	    	$(".index-iframe", window.parent.document).attr("src",url);
	  	    });
	          
	        // 初始化插件
			$("#zyupload").zyUpload({
	  			width            :   "100%",                 // 宽度
	  			height           :   "",                 	 // 高度
	  			itemWidth        :   "140px",                 // 文件项的宽度
	  			itemHeight       :   "115px",                 // 文件项的高度
	  			url              :   "${ pageContext.request.contextPath }/elecEVIDMgt/evidOpLogAtt/saveData.do?appraisalId="+"${param.id}&evidId="+evidenceData.id+"&evidOpLogId="+evidOpLogData.id+"&preappraisalId="+appraisalData.preappraisalId,  // 上传文件的路径
	  			fileType         :   ["jpg", "jpeg", "png", "bmp", "JPG", "JPEG", "PNG", "BMP"],// 上传文件的类型
	  			fileSize         :   1073741824,                // 上传文件的大小
	  			multiple         :   true,                    // 是否可以多个文件上传
	  			dragDrop         :   false,                   // 是否可以拖动上传文件
	  			tailor           :   false,                   // 是否可以裁剪图片
	  			del              :   true,                    // 是否可以删除文件
	  			finishDel        :   false,  				  // 是否在上传文件完成后删除预览
	  			 
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
	    function bindEvidenceDataVM(){
			 evidenceDataVm.creatorId = "${sessionScope.loginUser.userId}";
			 evidenceDataVm.creatorName = "${sessionScope.loginUser.userName}";
			 evidenceDataVm.creatorAlias = "${sessionScope.loginUser.userAlias}";
			 evidenceDataVm.appraisalId = "${param.id}";
			 evidenceDataVm.preappraisalId = appraisalData.preappraisalId;
			 evidenceDataVm.name = appraisalData.evidName;
			 evidenceDataVm.sn = appraisalData.evidSn;
			 evidenceDataVm.caseName = appraisalData.caseName;
			 evidenceDataVm.caseSn = appraisalData.caseSn;
			 //evidenceDataVm.location = $(".location").val();
		    }
	    function bindLogDataVM(){
	    	evidOpLogDataVm.evidName=appraisalData.evidName;
	    	evidOpLogDataVm.evidSn = appraisalData.evidSn;
	    	evidOpLogDataVm.caseName = appraisalData.caseName;
	    	evidOpLogDataVm.caseSn = appraisalData.caseSn;
	    	evidOpLogDataVm.evidId=evidenceDataVm.id;
	    	evidOpLogDataVm.creatorId = "${sessionScope.loginUser.userId}";
	    	evidOpLogDataVm.creatorName = "${sessionScope.loginUser.userName}";
	    	evidOpLogDataVm.creatorAlias = "${sessionScope.loginUser.userAlias}";
	    	evidOpLogDataVm.preappraisalId = appraisalData.preappraisalId;
	    	evidOpLogDataVm.spLabel = 0;
	    }
	  	
    
    	//自动生成条形码
		function code(id, value){
			id.empty().barcode(value, "code128",{barWidth:1, barHeight:25,showHRI:false});
			id.siblings(".bar-code-text").html(value);
		}
    	
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
    		}else if( aClass == "accepted" ){
    			if( $(".iframe-"+aClass).attr("src") == "" ){
    				var src = "${pageContext.request.contextPath}/elecEVIDMgt/physicalEvidenceAcceptView.do?commonAppraisalId="+"${param.id}";
    				$(".iframe-"+aClass).attr("src", src);
    				$(".iframe-"+aClass).load(function(){
    		            var mainheight = $(this).contents().find("body").height()+30;
    		            $(this).height(mainheight);
    		        });
    			}
    		}else if( aClass == "check" ){
    			if( $(".iframe-"+aClass).attr("src") == "" ){
    				var src = "${pageContext.request.contextPath}/elecEVIDMgt/checkInfoView.do?commonAppraisalId="+"${param.id}";
    				$(".iframe-"+aClass).attr("src", src);
    				$(".iframe-"+aClass).load(function(){
    		            var mainheight = $(this).contents().find("body").height()+30;
    		            $(this).height(mainheight);
    		        });
    			}
    		}
    	});
    </script>
</body>
</html>