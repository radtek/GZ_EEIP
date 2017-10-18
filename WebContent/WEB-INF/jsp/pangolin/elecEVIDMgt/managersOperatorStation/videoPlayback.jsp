<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>广州市公安局电子数据检验鉴定管理系统</title>
  	<meta charset="utf-8">
  	<meta http-equiv="x-ua-compatible" content="IE=8" >
   	<meta name="renderer" content="ie-stand" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.sparkline.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/toggles.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/custom.js" />"></script>
  	<%@ include file = "/common/scripts.jsp"%>
  	
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bracket-common.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/zyupload.basic-1.0.0.min.js" />"></script>
	<script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
  	<script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/ajaxfileupload.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/jquery-barcode.js" />"></script>
	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/index.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />	
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form2.css" />" rel="stylesheet" />
	<script type="text/javascript">
		function refresh(){
	    	if( location.href.indexOf("?reload=true") < 0 ){
	    		location.href += "?reload=true";
	       	}else{
	       		clearTimeout(time);
	       	}
	    }  
		var time = setTimeout("refresh()",100); 
	</script>
</head>
<body>
	<div class="header-content">
		<div class="header-top">
			<div class="header-main">
				<div class="platform-logo">
					<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/indexLogoImg.png" />
				</div>
				<div class="platform-name">电子数据检验鉴定管理系统</div>
				<div class="header-right">
					<ul class="headermenu">
						<!-- <li>
					  		<div class="btn-group">
				              	<button class="btn btn-default dropdown-toggle tp-icon" data-toggle="dropdown" onclick="find()" >
				                	<i class="fa fa-comment"></i>
				                 	<span class="badge">2</span> 
				              	</button>
				            </div>
					  	</li> -->
						<li>
						    <div class="btn-group">
						      	<button type="button" class="btn btn-default dropdown-toggle blurBtn" data-toggle="dropdown">
						        	<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/userIcon.png" />
						        	<span>${sessionScope.loginUser.userAlias}</span>
						        	<span class="caret"></span>
						      	</button>
						      	<ul class="dropdown-menu dropdown-menu-usermenu pull-right infoContent">
							        <li><a href="#" data-addres="${pageContext.request.contextPath}/system/user/userProfileForm.do" class="personalData"><i class="glyphicon glyphicon-user"></i>${ LANG[sessionScope.loginUser.lang]['USER_PROFILE'] }</a></li>
							        <li><a href="#" data-addres="${pageContext.request.contextPath}/system/user/userPwdForm.do" class="passwordSetting"><i class="glyphicon glyphicon-cog"></i>${ LANG[sessionScope.loginUser.lang]['PWD_SETTING'] }</a></li>
							        <%-- <li><a href="${pageContext.request.contextPath}/resources/documents/operation_manual.pdf" target="help"><i class="glyphicon glyphicon-question-sign"></i>${ LANG[sessionScope.loginUser.lang]['HELP'] }</a></li> --%>
							        <li><a href="#" class="logoutPopup" data-toggle="modal" data-target="#logoutModal"><i class="glyphicon glyphicon-log-out"></i>${ LANG[sessionScope.loginUser.lang]['SIGN_OUT'] }</a></li>
						      	</ul>
						    </div>
					    </li>
					</ul>
				</div>
			</div>
		</div>
		<div class="menu-content">
			<ul class="main-menu">
				<li data-class="firstpage" class="firstpage"><a data-url="${pageContext.request.contextPath}/firstpage.do">首页</a></li>
				<li data-class="elecEVIDMgt" class="elecEVIDMgt active">
					<a>电子物证管理</a>
					<ul>
						<li><a data-url="${pageContext.request.contextPath}/elecEVIDMgt/register/evidenceRegisterList.do">物证预检登记</a></li>
						<li>
							<a>受理人员操作台</a>
							<ul>
								<li><a data-url="${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/acceptedList.do">检材受理</a></li>
								<li><a data-url="${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/warehousingList.do">检材入库</a></li>
								<li><a data-url="${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/handoverList.do">检材交接</a></li>
								<li><a data-url="${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/resultsMgtList.do">结果管理</a></li>
							</ul>
						</li>
						<li>
							<a>管理人员操作台</a>
							<ul>
								<li><a data-url="${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/examinationOfMaterialsList.do">检材审核</a></li>
								<li><a data-url="${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/identificationAllocationList.do">鉴定分配</a></li>
								<li><a data-url="${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/clericalApprovalList.do">文书审批</a></li>
								<li><a data-url="${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/modifyClericalApprovalList.do">修改文书审批</a></li>
							</ul>
						</li>
						<li>
							<a>鉴定人员操作台</a>
							<ul>
								<li><a data-url="${pageContext.request.contextPath}/elecEVIDMgt/authenticate/analysis/appraisalProcessAllot.do">检材鉴定分析</a></li>
								<li><a data-url="${pageContext.request.contextPath}/elecEVIDMgt/authenticate/document/documentList.do">文书修改申请</a></li>
								<li><a data-url="${pageContext.request.contextPath}/elecEVIDMgt/authenticate/document/documentchange.do">文书修改</a></li>
							</ul>
						</li>
						<li><a data-url="${pageContext.request.contextPath}/elecEVIDMgt/generalMessage/generalMessageList.do">综合鉴定信息</a></li>
					</ul>
				</li>
				<li data-class="inquestMgt" class="inquestMgt"><a data-url="${pageContext.request.contextPath}/inquestMgt/sceneInquestList.do">现场勘验</a></li>
				<li data-class="deviceMgt" class="deviceMgt">
					<a>设备与环境管理</a>
					<ul>
						<li><a data-url="${pageContext.request.contextPath}/deviceMgt/deviceMgtList.do">设备管理</a></li>
						<li><a data-url="${pageContext.request.contextPath}/deviceMgt/deviceMaintainList.do">设备维护</a></li>
						<li><a data-url="${pageContext.request.contextPath}/envMgt/environmentalMonitoring.do">环境监控</a></li>
						<li><a data-url="${pageContext.request.contextPath}/deviceMgt/deviceUseSituationList.do">设备使用情况</a></li>
						<li><a data-url="${pageContext.request.contextPath}/deviceMgt/deviceMaintainApprovalList.do">设备维护申请审批</a></li>
						<li><a data-url="${pageContext.request.contextPath}/deviceMgt/externalDeviceMgtList.do">外部设备借用</a></li>
					</ul>
				</li>
				<li data-class="evidenceMgt" class="evidenceMgt">
					<a>取证及流程管理</a>
					<ul>
						<li><a data-url="${pageContext.request.contextPath}/evidenceMgt/inTheLibrary/inTheLibraryList.do">在库检材</a></li>
						<li><a data-url="${pageContext.request.contextPath}/evidenceMgt/handoverRecord/handoverRecordList.do">检材交接记录</a></li>
						<li><a data-url="${pageContext.request.contextPath}/evidenceMgt/outOfTheLibrary/outOfTheLibraryList.do">已出库检材</a></li>
						<li><a>流转管理</a></li>
						<li><a>表单管理</a></li>
					</ul>
				</li>
				<li data-class="psnlInfoMgt" class="psnlInfoMgt">
					<a>人员信息管理</a>
					<ul>
						<li><a data-url="${pageContext.request.contextPath}/psnlInfo/expert/personnelInfoList.do">专家库</a></li>
						<li><a data-url="${pageContext.request.contextPath}/psnlInfo/visitor/visitorInfoList.do">来访人员管理</a></li>
					</ul>
				</li>
				<li data-class="meetingMgt" class="meetingMgt">
					<a>会议管理</a>
					<ul>
						<li>
							<a>会议申请</a>
							<ul>
								<li><a data-url="${pageContext.request.contextPath}/meetingMgt/generalMeet/meetingApplyList.do">普通会议</a></li>
								<li><a data-url="${pageContext.request.contextPath}/meetingMgt/internalAudit/meetInternalAuditList.do">内部审核会议</a></li>
								<li><a data-url="${pageContext.request.contextPath}/meetingMgt/review/meetReviewList.do">管理评审会议</a></li>
							</ul>
						</li>
						<li><a data-url="${pageContext.request.contextPath}/meetingMgt/meetingRoom/meetingRoomApplyList.do">会议室管理</a></li>
						<li>
							<a>计划</a>
							<ul>
								<li><a data-url="${pageContext.request.contextPath}/meetingMgt/annualPlan/annualPlanList.do">内审年度计划</a></li>
								<li><a data-url="${pageContext.request.contextPath}/meetingMgt/annualPlan/realtimePlanList.do">内审实施计划</a></li>
								<li><a data-url="${pageContext.request.contextPath}/meetingMgt/managementReviewPlan/managementReviewPlanList.do">管理评审计划</a></li>
							</ul>
						</li>
					</ul>
				</li>
				<li data-class="knowledgeMgt" class="knowledgeMgt">
					<a>知识管理</a>
					<ul>
						<li><a data-url="${pageContext.request.contextPath}/knowledgeMgt/knowledgeBase/knowledgeBaseViewer.do">知识库</a></li>
						<li><a data-url="${pageContext.request.contextPath}/knowledgeMgt/fileMgt/fileMgtList.do">知识文件管理</a></li>
						<li><a data-url="${pageContext.request.contextPath}/knowledgeMgt/fileMgt/tempFileMgtList.do">知识文件审批</a></li>
					</ul>
				</li>
				<li data-class="statisticalAnalysis" class="statisticalAnalysis"><a>统计分析</a></li>
				<li data-class="systemMgt" class="systemMgt">
					<a>系统管理</a>
					<ul>
						<li><a data-url="${pageContext.request.contextPath}/system/org/orgList.do">组织架构</a></li>
						<li><a data-url="${pageContext.request.contextPath}/system/user/userList.do">用户管理</a></li>
						<li><a data-url="${pageContext.request.contextPath}/system/role/roleList.do">角色管理</a></li>
						<li><a data-url="${pageContext.request.contextPath}/system/notification/notificationList.do">通知公告</a></li>
						<li><a data-url="${pageContext.request.contextPath}/system/log/accessLogList.do">日志管理</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
	<%-- <div class="iframe-content">
		<iframe class="index-iframe" src="${pageContext.request.contextPath}/firstpage.do" ></iframe>
	</div> --%>
	
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>电子物证管理</a><span>></span><a>鉴定人员操作台</a><span>></span><a>检材鉴定分析</a>
        </p>
    </div>
    <div class="tabs-content">
	    <ul class="nav nav-tabs tabs-nav">
	        <li><a class="register">登记信息</a></li>
	        <li><a class="accepted">物证受理</a></li>
	        <li><a class="check">检材审核</a></li>
	        <li><a class="warehousing">物证入库</a></li>
	        <li><a class="process">鉴定过程</a></li>
	        <li><a class="leave">检材出库</a></li>
	    </ul>
	</div>
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
	    <div class="form-module approver">
	        <div class="form-module-title">
	            <p>文书整理</p>
	        </div>
	        <div class="form-content">
	            <form class="form-horizontal">
	                <div class="form-group">
	                    <label class="col-sm-2 control-label">鉴定视频：</label>
	                    <div class="col-sm-10">
	                        <div class="form-control video-content CallBackVedio">
	                        	<!-- <span class="video-btn"><i class="fa fa-play-circle-o"></i></span> -->
<!-- 								<object id="MediaPlayer" 
							            classid="CLSID:22D6F312-B0F6-11D0-94AB-0080C74C7E95"
							            standby="Loading Windows Media Player components..."
							            type="application/x-oleobject" width="500" height="500">
							      <PARAM id="filename" name="filename" value="Z:/record/2017-04-21/192.168.1.248_CAM_1492740889371.mp4">
							    </object> -->
	                        </div>
	                    </div>
	                </div>
	            </form>
	        </div>
	        <div class="file-upload">
		        <table class="table table-bordered file">
		            <thead>
		                <tr>
		                    <th>鉴定文书</th>
		                    <th>新文件上传</th>
		                    <th>操作</th>
		                </tr>
		            </thead>
		            <tbody>
						<tr>
							<td><a class="downFile" id="0">鉴定委托书</a></td>
							<td><input type="text" value="不可修改" id="" readonly/><!-- <input type="file" id="fiel0" name="file"/> --></td>
		                    <td>无</td>
						</tr>
						<tr>
							<td><a class="downFile" id="1">鉴定事项确认书</a></td>
							<td><input type="text" value="不可修改" id="" readonly/><!-- <input type="file" id="fiel1" name="file"/> --></td>
		                    <td>无</td>
						</tr>
						<tr>
							<td><a class="downFile" id="2">物证鉴定档案封面</a></td>
							<td><input type="text" value="不可修改" id="" readonly/><!-- <input type="file" id="fiel2" name="file"/> --></td>
		                    <td>无</td>
						</tr>
						<tr>
							<td><a class="downFile" id="6">检验鉴定照片记录表</a></td>
							<td><input type="text" value="不可修改" id="" readonly/><!-- <input type="file" id="fiel6" name="file"/> --></td>
		                    <td>无</td>	
						</tr>
						<tr>
							<td><a class="downFile" id="3">鉴定文书档案目录</a></td>
							<td><input type="text" id="" class="fiel3" readonly/><input type="file" id="fiel3" name="file"/></td>
		                    <td>
 		                    	<a title="上传" class="upload-btn3"><i class="fa fa-upload"></i></a>
<!-- 		                    	<a title="删除"><i class="fa fa-times file3Del"></i></a> -->
		                    </td>
						</tr>
						<tr>
							<td><a class="downFile" id="4">电子物证检验原始记录</a></td>
							<td><input type="text" class="fiel4" id="" readonly/><input type="file" id="fiel4" name="file"/></td>
		                    <td>
		                    	<a title="上传" class="upload-btn4"><i class="fa fa-upload"></i></a>
		                    	<a title="修改原始记录"><i class="fa fa-pencil-square-o changeFileFour"></i></a>
		                    </td>	
						</tr>
						<tr>
							<td><a class="downFile" id="5">鉴定文书</a></td>
							<td><input type="text" class="fiel5" id="" readonly/><input type="file" id="fiel5" name="file"/></td>
		                    <td>
		                    	<a title="上传" class="upload-btn5"><i class="fa fa-upload"></i></a>
<!-- 		                    	<a title="删除"><i class="fa fa-times file5Del"></i></a> -->
		                    </td>	
						</tr>
						<tr>
							<td><a class="downFile" id="7">提取电子证据清单</a></td>
							<td><input type="text" class="fiel7" id="" readonly/><input type="file" id="fiel7" name="file"/></td>
		                    <td>
								<a title="上传" class="upload-btn7"><i class="fa fa-upload"></i></a>
		                    	<a title="修改电子证据清单"><i class="fa fa-pencil-square-o changeFileSeven"></i></a>
		                    </td>
						</tr>
		            </tbody>
		        </table>
		    </div>
			<div class="btn-content">
				<button type="button" class="btn btn-color1 commit"><i class="fa fa-check"></i>提交</button>
			</div>
	    </div>
    
	    <div class="btn-content stopAndPause">
	        <button class="btn btn-color1 suspend-btn"><i class="fa fa-stop"></i>中止鉴定</button>
	        <button class="btn btn-color1 pause-btn"><i class="fa fa-pause"></i>暂停鉴定</button>
	    </div>
    </div>
    
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
	
	
	<%-- User Password Form Modals --%>
	<div class="lock">
		<div class="password_div">
			<iframe class="iframe2"></iframe>
		</div>
	</div>
	
	<%-- User Profile Form Modals --%>
	<div class="lock2">
		<div class="ziliao_div">
			<iframe class="iframe3"></iframe>
		</div>
	</div>
	
	<%-- Logout Confirm Modals --%>
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog">
      	<div class="modal-dialog" role="document">
	        <div class="modal-content">
	          	<div class="modal-header">
		            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span class="modal-custom-close" aria-hidden="true">&times;</span></button>
		            <h4 class="modal-title modal-custom-title">系统提示</h4>
	          	</div>
	          	<div class="modal-body">
	           		<span>&nbsp;&nbsp;&nbsp;&nbsp;确认是否注销当前帐号返回至系统登录&nbsp;?</span>
	          	</div>
	          	<div class="modal-footer">
		            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		            <button type="button" class="btn btn-primary" id="logoutBtn">注销</button>
	          	</div>
	        </div>
      	</div>
    </div>
    
    <div class="bgDiv hideDiv"></div>
    <div class="textDiv hideDiv">请自行将浏览器浏览模式手动切换成兼容模式，否则无法观看视频。</div>
    <script type="text/javascript">
		$(".file").on("change","input[type='file']",function(){
			var filePath = $(this).val();
			$(this).siblings("input[type='text']").val(filePath);
		})
		
		function saveFile(){
			$(".willUpLoad").each(function(){
				var file = $(this).parent().parent().find("input[type='file']").attr("id");
// 				alert(file);
	   			$.ajaxFileUpload({
	   				url:'${ pageContext.request.contextPath }/elecEVIDMgt/AppraisalDoc/saveAppraisalDocData.do',
	   				data:{
	   					'appraisalId' : appraisalData.id,
	   					'type' : file.charAt(4)
					},
	   				secureuri:false,
	   				fileElementId:file,//file标签的id
	   				dataType: 'json',//返回数据的类型
	   				success: function (data) {
	   				}
	   			})
			})
		}
		
		$(".downFile").click(function(){
			var type = $(this).attr("id");
			if(loadData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/checkAppDocByTypeAndAppraisalId.do", {"type": type,"appraisalId":appraisalData.id } )){
				window.location.href = "${ pageContext.request.contextPath }/elecEVIDMgt/AppraisalDoc/downAppraisalDocData.do?type="+type+"&appraisalId="+appraisalData.id;
			}else{
				promptContent("下载的文件不存在,请联系管理员");
			 	$(".alert").removeClass("alert-success").addClass("alert-danger");
	 			$(".promptDiv").slideDown();
	 		    setTimeout(function(){
	 				$(".promptDiv").slideUp();
	 		    },2000);
			}
		})
		
		$(".fa-upload").click(function(){
			var fileName = $(this).parent().parent().parent().find("input").eq(0).val();
			if(fileName != null && fileName != "" && fileName != undefined){
				fileName = fileName.substring(fileName.lastIndexOf("\\")+1,fileName.lastIndexOf("."));
				$(this).parent().parent().parent().find("input").eq(0).val(fileName);
				
				$(this).parent().addClass("willUpLoad");
				
	 			promptContent("上传成功");
	 			$(".alert").removeClass("alert-danger").addClass("alert-success");
	 			$(".promptDiv").slideDown();
	 		    setTimeout(function(){
	 				$(".promptDiv").slideUp();
	 		    },2000);
			}else{
				promptContent("上传文件为空");
			 	$(".alert").removeClass("alert-success").addClass("alert-danger");
	 			$(".promptDiv").slideDown();
	 		    setTimeout(function(){
	 				$(".promptDiv").slideUp();
	 		    },2000);
			}
		})
		
		//进入修改原始记录页面
		$(".changeFileFour").click(function(){
// 			alert("进入修改原始记录页面");
			window.parent.location.href = "${ pageContext.request.contextPath }/elecEVIDMgt/generalMessage/changeSourceRecord.do"; 
			
// 	    	var url = "${ pageContext.request.contextPath }/elecEVIDMgt/generalMessage/changeSourceRecord.do";
// 	    	$(".index-iframe", window.parent.document).attr("src",url);
	    });
		//进入修改电子证据清单
		$(".changeFileSeven").click(function(){
// 			alert("进入修改电子证据清单");
			window.parent.location.href = "${ pageContext.request.contextPath }/elecEVIDMgt/generalMessage/electronicEvidenceList.do"; 
			
// 	    	var url = "${ pageContext.request.contextPath }/elecEVIDMgt/generalMessage/electronicEvidenceList.do";
// 	    	$(".index-iframe", window.parent.document).attr("src",url);
	    });
		
		var userId = "${sessionScope.loginUser.userId}";
		var userName = "${sessionScope.loginUser.userName}";
		var userAlias = "${sessionScope.loginUser.userAlias}";
		var appraisalData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/loadDataByUserAlias.do", { "userId" : userId });
		var appraisalDataVM = ko.mapping.fromJS(appraisalData);
		var vm = {
           		appraisalVM : appraisalDataVM,
   		}
		ko.applyBindings(vm);
		
		var vedioPath = appraisalData.videoPath;
		if(vedioPath != null && vedioPath != "" && vedioPath != undefined){
			vedioPath = vedioPath.replace(/\\/g,"/");
		}
		var vedioHtml="";
		vedioHtml += "<object id='MediaPlayer'";
		vedioHtml += "classid='CLSID:22D6F312-B0F6-11D0-94AB-0080C74C7E95'";
		vedioHtml += "standby='Loading Windows Media Player components...'";
		vedioHtml += "type='application/x-oleobject' width='500' height='500'>";
// 		vedioHtml += "<PARAM id='filename' name='filename' value='${pageContext.request.contextPath}/elecEVIDMgt/appraisal/showVedio.do?id="+appraisalData.id+"'>";
		vedioHtml += "<PARAM id='filename' name='filename' value='${pageContext.request.contextPath}/video/192.168.1.248_CAM_1492740316050.mp4'>";
		vedioHtml += "</object>";
		$(".CallBackVedio").append(vedioHtml);
		
		$(".commit").click(function(){
			saveFile();
			appraisalDataVM.status = 11;
			if(saveData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/saveData.do", appraisalDataVM)){
				$(".CallBackVedio #MediaPlayer").remove();
				window.parent.location.href = "${pageContext.request.contextPath}/elecEVIDMgt/authenticate/analysis/appraisalProcessAllot.do"; 
				
//        			saveSuccess("${pageContext.request.contextPath}/elecEVIDMgt/authenticate/analysis/appraisalProcessAllot.do");
			}
		})
	</script>
	<script>
		if(window.navigator.userAgent.indexOf('AppleWebKit') != -1) {
			$(".hideDiv").show();
		}else{
			$(".hideDiv").hide();
		}
		
		$(".back-btn").click(function(){
			window.location.href="${pageContext.request.contextPath}/main.do"; 
		});
		
		//显示下级菜单
		$(".main-menu li").hover(
			function(){
				$(this).find("ul").eq(0).show();
			},
			function(){
				$(this).find("ul").eq(0).hide();
			}
		)
		
		//点击跳转页面之后的选中样式及跳转页面
		$(".main-menu li a").click(function(){
			var url = $(this).data("url");
			if( url != undefined && url !="" ){
				$(".main-menu > li").removeClass("active");
				var menuClass = $(this).parents(".main-menu > li").data("class");
				//$(".index-iframe").attr("src",url);
				window.location.href="${pageContext.request.contextPath}/main.do?url="+url+"&menuClass="+menuClass; 
			}
		});
		
		$("#logoutBtn").click(function() {
			window.location.href = "${pageContext.request.contextPath}/signout.action";
		});
		
		$(".personalData").click(function() {
	    	$('.lock2').show();
			$('.iframe3').attr('src',$(this).attr('data-addres'));
			return false;
		});
		    
		$(".passwordSetting").click(function() {
			$('.lock').show();
			$('.iframe2').attr('src',$(this).attr('data-addres'));
			return false;
		});
			
		function notlock() {
			$('.lock').hide();
		}
		function notlock2() {
			$('.lock2').hide();
		}
		
	</script>
	<script>
		
		/* 标签页事件和样式-开始 */
		var clickStatus = 4;	//点击状态
		var dataStatus = 4;		//数据状态
		tabsContent(clickStatus,dataStatus);
    	/* 标签页事件和样式-结束  */
    	
    	/* 标签页事件和样式-开始 */
		$(".tabs-nav li").hover(
	        function(){
	        	if( !$(this).hasClass("active-no") ){
	        		$(this).addClass("active-hover");
	        		$(this).next().addClass("active-next");
	        	}
	        },
	        function(){
	            if( !$(this).hasClass("active") ){
	                $(this).next().removeClass("active-next");
	            }
	            $(this).removeClass("active-hover");
	        }
	    );
		$(".tabs-nav li").click(function(){
			if( !$(this).hasClass("active-no") ){
				$(".tabs-nav li").removeClass("active active-next");
	    		$(this).addClass("active");
	    		$(this).next().addClass("active-next");
	    		var id = $(this).find("a").attr("class");
	    		$(".tabs-list").removeClass("active");
	    		$("#"+id).addClass("active");
			}
		});
		/* 标签页事件和样式-结束  */
		
		
		/*查看图片--开始*/
		$(".img-list").on("click", "img", function(){
	        var src = $(this).attr("src");
	        $(".big-img img").attr("src",src);
	        //$(".big-img").html("<img src='"+ src +"' />");
	    });
		/*查看图片--结束*/
    	
		///头标签
		$(".tabs-nav li").click(function(){
    		var aClass = $(this).find("a").attr("class");
    		if( aClass == "register" ){
    			if( $(".iframe-"+aClass).attr("src") == "" ){
    				var src = "${pageContext.request.contextPath}/elecEVIDMgt/registerInfoView.do?commonPreappraisalId="+appraisalData.preappraisalId;
    				$(".iframe-"+aClass).attr("src", src);
    				$(".iframe-"+aClass).load(function(){
    		            var mainheight = $(".iframe-"+aClass).contents().find("body").height()+100;
    		            $(".iframe-"+aClass).height(mainheight);
    		        });
    			}
    		}else if( aClass == "accepted" ){
    			if( $(".iframe-"+aClass).attr("src") == "" ){
    				var src = "${pageContext.request.contextPath}/elecEVIDMgt/physicalEvidenceAcceptView.do?commonAppraisalId="+appraisalData.id;
    				iframeShow(aClass, src);
    			}
    		}else if( aClass == "check" ){
    			if( $(".iframe-"+aClass).attr("src") == "" ){
    				var src = "${pageContext.request.contextPath}/elecEVIDMgt/checkInfoView.do?commonAppraisalId="+appraisalData.id;
    				iframeShow(aClass, src);
    			}
    		}else if( aClass == "warehousing" ){
    			if( $(".iframe-"+aClass).attr("src") == "" ){
    				var src = "${pageContext.request.contextPath}/elecEVIDMgt/physicalEvidenceStorageView.do?commonAppraisalId="+appraisalData.id;
    				iframeShow(aClass, src);
    			}
    		}
		});
		
		function iframeShow(aClass, src){
			$(".iframe-"+aClass).attr("src", src);
			$(".iframe-"+aClass).load(function(){
	            var mainheight = $(".iframe-"+aClass).contents().find("body").height()+30;
	            $(".iframe-"+aClass).height(mainheight);
	        });
		}
		
		//标签页部分事件
		function tabsContent(status1,status2){
			$(".tabs-nav li").eq(status1).addClass("active");
			$(".tabs-nav li").eq(status1+1).addClass("active-next");
			$(".tabs-nav li").eq(status2).nextAll().addClass("active-no");
			var id = $(".tabs-nav li").eq(status1).find("a").attr("class");
			$(".tabs-list").removeClass("active");
			$("#"+id).addClass("active");
		}
	</script>
</body>
</html>