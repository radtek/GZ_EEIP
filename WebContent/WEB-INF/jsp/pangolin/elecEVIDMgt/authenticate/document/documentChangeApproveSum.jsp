<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>鉴定文书修审批修改</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/zyupload.basic-1.0.0.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/ajaxfileupload.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>电子物证管理</a><span>></span><a>鉴定人员操作台</a><span>></span><a>文书修改</a><span>></span><a>修改</a>
        </p>
    </div>
	<div class="form-module">
        <div class="form-module-title">
            <p>文件信息</p>
        </div>
        <div class="form-content">
            <form class="form-horizontal">
                <div class="form-group">
					<label class="col-sm-2 control-label"><span class="required-fields">*</span>案件编号：</label>
					<div class="col-sm-4" data-bind="with: appraisalVM" >
						<input type="text" data-bind="value: caseSn" name="caseSn" id="caseSn" class="form-control" required readonly/>
					</div>				
					<label class="col-sm-2 control-label"><span class="required-fields">*</span>案件名称：</label>
					<div class="col-sm-4" data-bind="with: appraisalVM">
						<input type="text" data-bind="value: caseName" name="caseName" id="caseName" class="form-control" required readonly/>
					</div>								
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label"><span class="required-fields">*</span>检材编号：</label>
					<div class="col-sm-4" data-bind="with: appraisalVM">
						<input type="text" data-bind="value: evidSn" name="evidSn" id="evidSn" class="form-control" required readonly/>
					</div>							
				</div>
            </form>
        </div>
    </div>
    <div class="form-module">
        <div class="form-module-title">
            <p>文件列表</p>
        </div>
        <div class="file-upload">
	        <table class="table table-bordered file">
	            <thead>
	                <tr>
<!-- 	                    <th>文件名</th> -->
	                    <th>原文件</th>
	                    <th>新文件上传</th>
	                    <th>操作</th>
	                </tr>
	            </thead>
	            <tbody>
					<tr>
<!-- 	                    <td>鉴定委托书</td> -->
	                    <td><a class="downFile" id="0">鉴定委托书</a></td>
	                    <td>
	                    	<input type="text" value="不可操作" readonly/>
<!-- 	                    	<input type="file" id="file0" name="file"/> -->
	                    </td>
	                    <td>
							<input type="text" value="无" readonly/>
<!-- 	                    	<a title="上传" class=""><i class="fa fa-upload"></i></a> -->
<!-- 	                    	<a title="删除"><i class="fa fa-times deleteBtn"></i></a> -->
	                    </td>	
	                </tr>
					<tr>
<!-- 	                    <td>鉴定事项确认书</td> -->
	                    <td><a class="downFile" id="1">鉴定事项确认书</a></td>
	                    <td>
	                    	<input type="text" value="不可操作" readonly/>
<!-- 	                    	<input type="file" id="file1" name="file"/> -->
	                    </td>
	                    <td>
							<input type="text" value="无" readonly/>
<!-- 	                    	<a title="上传" class=""><i class="fa fa-upload"></i></a> -->
<!-- 	                    	<a title="删除"><i class="fa fa-times deleteBtn"></i></a> -->
	                    </td>	
	                </tr>
	                <tr>
<!-- 	                    <td>物证鉴定档案封面</td> -->
	                    <td><a class="downFile" id="2">物证鉴定档案封面</a></td>
	                    <td>
	                    	<input type="text" value="不可操作" readonly/>
<!-- 	                    	<input type="file" id="file0" name="file"/> -->
	                    </td>
	                    <td>
							<input type="text" value="无" readonly/>
<!-- 	                    	<a title="上传" class=""><i class="fa fa-upload"></i></a> -->
<!-- 	                    	<a title="删除"><i class="fa fa-times deleteBtn"></i></a> -->
	                    </td>	
	                </tr>
	                <tr>
<!-- 	                    <td>鉴定文书</td> -->
	                    <td><a class="downFile" id="3">鉴定文书档案目录</a></td>
	                    <td>
	                    	<input type="text" class="file3" readonly/>
	                    	<input type="file" id="file3" name="file"/>
	                    </td>
	                    <td>
	                    	<a title="上传" class="upload-btn3"><i class="fa fa-upload"></i></a>
<!-- 	                    	<a title="删除"><i class="fa fa-times deleteBtn file3Del"></i></a> -->
	                    </td>	
	                </tr>
	                <tr>
<!-- 	                    <td>电子物证检验原始记录</td> -->
	                    <td><a class="downFile" id="4">电子物证检验原始记录</a></td>
	                    <td>
	                    	<input type="text" value="不可操作" readonly/>
<!-- 	                    	<input type="file" id="file0" name="file"/> -->
	                    </td>
	                    <td>
							<input type="text" value="无" readonly/>
<!-- 	                    	<a title="上传" class=""><i class="fa fa-upload"></i></a> -->
<!-- 	                    	<a title="删除"><i class="fa fa-times deleteBtn"></i></a> -->
	                    </td>	
	                </tr>
	                <tr>
<!-- 	                    <td>鉴定文书</td> -->
	                    <td><a class="downFile" id="5">鉴定文书</a></td>
	                    <td>
	                    	<input type="text" class="file5" readonly/>
	                    	<input type="file" id="file5" name="file"/>
	                    </td>
	                    <td>
	                    	<a title="上传" class="upload-btn5"><i class="fa fa-upload"></i></a>
<!-- 	                    	<a title="删除"><i class="fa fa-times file5Del"></i></a> -->
	                    </td>	
	                </tr>
	                <tr>
<!-- 	                    <td>检验鉴定照片记录表</td> -->
	                    <td><a class="downFile" id="6">检验鉴定照片记录表</a></td>
	                    <td>
	                    	<input type="text" value="不可操作" readonly/>
<!-- 	                    	<input type="file" id="file0" name="file"/> -->
	                    </td>
	                    <td>
							<input type="text" value="无" readonly/>
<!-- 	                    	<a title="上传" class=""><i class="fa fa-upload"></i></a> -->
<!-- 	                    	<a title="删除"><i class="fa fa-times deleteBtn"></i></a> -->
	                    </td>	
	                </tr>
	                <tr>
<!-- 	                    <td>提取电子证据清单</td> -->
	                    <td><a class="downFile" id="7">提取电子证据清单</a></td>
	                    <td>
	                    	<input type="text" value="不可操作" readonly/>
<!-- 	                    	<input type="file" id="file0" name="file"/> -->
	                    </td>
	                    <td>
							<input type="text" value="无" readonly/>
<!-- 	                    	<a title="上传" class=""><i class="fa fa-upload"></i></a> -->
<!-- 	                    	<a title="删除"><i class="fa fa-times deleteBtn"></i></a> -->
	                    </td>	
	                </tr>
	                <tr>
<!-- 	                    <td>鉴定文书审批表</td> -->
	                    <td><a class="downFile" id="8">鉴定文书审批表</a></td>
	                    <td>
	                    	<input type="text" value="不可操作" readonly/>
<!-- 	                    	<input type="file" id="file0" name="file"/> -->
	                    </td>
	                    <td>
							<input type="text" value="无" readonly/>
<!-- 	                    	<a title="上传" class=""><i class="fa fa-upload"></i></a> -->
<!-- 	                    	<a title="删除"><i class="fa fa-times deleteBtn"></i></a> -->
	                    </td>	
	                </tr>
	            </tbody>
							
	
	        </table>
	    </div>
    </div>
	<div class="btn-content">
        <button type="button" class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
        <button type="button" class="btn btn-color1"><i class="fa fa-check"></i>提交</button>
        <!-- <button type="button" class="btn btn-color1"><i class="fa fa-times"></i>不同意</button> -->
    </div>
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
	
	<script>
		$(".back-btn").click(function(){
	    	$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/elecEVIDMgt/authenticate/document/documentchange.do');
	    });	
		
		
		
		var appraisalReviseId = "${param.appraisalReviseId}";
        var userId = "${sessionScope.loginUser.userId}";
        var userAlias = "${sessionScope.loginUser.userAlias}";
        var userName = "${sessionScope.loginUser.userName}";
		
		var AppraisalReviseData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/AppraisalRevise/loadAppraisalReviseData.do", { "id": appraisalReviseId });
		var appraisalData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/loadDataById.do",{"id": AppraisalReviseData.appraisalId});
		
		var appraisalDataVM = ko.mapping.fromJS(appraisalData);
        var AppraisalReviseDataVM = ko.mapping.fromJS(AppraisalReviseData);		
		
		var vm = {
			appraisalVM : appraisalDataVM,
			AppraisalReviseVM : AppraisalReviseDataVM,
        }
        
        ko.applyBindings(vm);
        
		$(".btn-color1").click(function(){
			if(validateSubmittedData()){
				if( upFile5 == 1 || upFile3 == 1){
 					saveFile();
				}
				BuildParam();
				if(saveData("${ pageContext.request.contextPath }/elecEVIDMgt/AppraisalRevise/saveAppraisalReviseData.do", AppraisalReviseDataVM)){
					saveSuccess("${ pageContext.request.contextPath }/elecEVIDMgt/authenticate/document/documentchange.do");
				}
			}else{
				saveFailure();
			}
		})
		//初始化内容
		function BuildParam(){
			AppraisalReviseDataVM.modifierId = userId;
			AppraisalReviseDataVM.modifierName = userName;
			AppraisalReviseDataVM.modifierAlias = userAlias;
			AppraisalReviseDataVM.revisedDate = new Date();
			AppraisalReviseDataVM.status = 6;
		}
		
		//文字复现
		$(".file").on("change","input[type='file']",function(){
			var filePath = $(this).val();
			$(this).siblings("input[type='text']").val(filePath);
		})
		//下载原文件
		$(".downFile").click(function(){
			var type = $(this).attr("id");
			window.location.href = "${ pageContext.request.contextPath }/elecEVIDMgt/AppraisalDoc/downAppraisalDocData.do?type="+type+"&appraisalId="+appraisalData.id;
		})
		
		// ===========对上上传文件的页面提示  开始  =====================//
		var upFile5 = 0;
		var upFile3 = 0;
		
		$(".upload-btn5").click(function(){
// 			uploadFile();
			upFile5 = 1;
		})
		$(".upload-btn3").click(function(){
// 			uploadFile();
			upFile3 = 1;
		})
// 		$(".file5Del").click(function(){
// 			$(".file5").val("");
// 			upFile5 = 0;
// 		})
// 		$(".file3Del").click(function(){
// 			$(".file3").val("");
// 			upFile3 = 0;
// 		})
		
		$(".fa-upload").click(function(){
			var fileName = $(this).parent().parent().parent().find("input").eq(0).val();
			if(fileName != null && fileName != "" && fileName != undefined){
				fileName = fileName.substring(fileName.lastIndexOf("\\")+1,fileName.lastIndexOf("."));
				console.log(fileName);
				if(fileName){
					$(this).parent().parent().parent().find("input").eq(0).val(fileName);				
					$(this).parent().addClass("willUpLoad");				
		 			promptContent("上传成功");
		 			$(".alert").removeClass("alert-danger").addClass("alert-success");
		 			$(".promptDiv").slideDown();
		 		    setTimeout(function(){
		 				$(".promptDiv").slideUp();
		 		    },1500);
				}else{					
					promptContent("上传成功");
		 			$(".alert").removeClass("alert-danger").addClass("alert-success");
		 			$(".promptDiv").slideDown();
		 		    setTimeout(function(){
		 				$(".promptDiv").slideUp();
		 		    },1500);
				}
				
			}else{
				promptContent("上传文件为空");
			 	$(".alert").removeClass("alert-success").addClass("alert-danger");
	 			$(".promptDiv").slideDown();
	 		    setTimeout(function(){
	 				$(".promptDiv").slideUp();
	 		    },1500);
			}
		})
// 		function upFile5(){
// 			promptContent("文件删除成功");
// 			$(".alert").removeClass("alert-danger").addClass("alert-success");
// 			$(".promptDiv").slideDown();
// 		    setTimeout(function(){
// 				$(".promptDiv").slideUp();
// 		    },1000);
// 		}
		// ===========对上上传文件的页面提示  结束  =====================//
		// ===========	修改文书上传方法 开始  =====================//
		function saveFile(){
			if(upFile5 == 1){
	        	var file = "file5";
	   			$.ajaxFileUpload({
	   				url:'${ pageContext.request.contextPath }/elecEVIDMgt/AppraisalDoc/saveAppraisalDocData.do',
	   				data:{
	   					'appraisalId' : appraisalData.id,
	   					'appraisalReviseId' : appraisalReviseId,
	   					'type' : file.charAt(4)
					},
	   				secureuri:false,
	   				fileElementId:file,//file标签的id
	   				dataType: 'json',//返回数据的类型
	   				success: function (data) {
	   				}
	   			});
			}
			if(upFile3 == 1){
	        	var file = "file3";
	   			$.ajaxFileUpload({
	   				url:'${ pageContext.request.contextPath }/elecEVIDMgt/AppraisalDoc/saveAppraisalDocData.do',
	   				data:{
	   					'appraisalId' : appraisalData.id,
	   					'appraisalReviseId' : appraisalReviseId,
	   					'type' : file.charAt(4)
					},
	   				secureuri:false,
	   				fileElementId:file,//file标签的id
	   				dataType: 'json',//返回数据的类型
	   				success: function (data) {
	   				}
	   			});
			}
		}
		// ===========	修改文书上传方法 结束  =====================//
	</script>
</body>
</html>