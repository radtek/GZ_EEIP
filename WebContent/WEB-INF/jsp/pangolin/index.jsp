<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>广州市公安局电子数据检验鉴定管理系统</title>
  	<meta charset="utf-8" />
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  	<meta name="renderer" content="webkit" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.sparkline.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/toggles.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/custom.js" />"></script>
  	<%@ include file = "/common/scripts.jsp"%>
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/index.css" />" rel="stylesheet" />
  	<!-- <script type="text/javascript">
		function refresh(){
	    	if( location.href.indexOf("?reload=true") < 0 ){
	    		location.href += "?reload=true";
	       	}else{
	       		clearTimeout(time);
	       	}
	    }  
		var time = setTimeout("refresh()",100);
	</script> -->
  </head>
  <body>
    <div class="header-content">
      <%-- HEADER --%>
      <div class="header-top">
	    <div class="header-main">
		  <div class="platform-logo">
		    <img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/indexLogoImg.png" />
		  </div>
		  <div class="platform-name">电子数据检验鉴定管理系统</div>
		  <div class="header-right">
		    <ul class="headermenu">
			  <%-- 
			  <li>
			    <div class="btn-group">
			      <button class="btn btn-default dropdown-toggle tp-icon" data-toggle="dropdown" onclick="find()" >
				    <i class="fa fa-comment"></i>
				    <span class="badge">2</span> 
				  </button>
				</div>
			  </li>
			  --%>
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
      
      <%-- MENU --%>
	  <div class="menu-content">
	    <ul class="main-menu">
		  <li class="firstpage active"><a data-url="${pageContext.request.contextPath}/firstpage.do">首页</a></li>
		  
		  <sys:auth grant="EVID_MGT_ACCESS" username="${sessionScope.loginUser.userName}">
		    <li class="elecEVIDMgt">
		      <a>电子物证管理</a>
			  <ul>
		        <sys:auth grant="PREAPPRAISAL_REG" username="${sessionScope.loginUser.userName}">
			      <li><a data-url="${pageContext.request.contextPath}/elecEVIDMgt/register/evidenceRegisterList.do">物证预检登记</a></li>
			    </sys:auth>
			    
			    <sys:auth grant="ACCEPTOR_CTRL_PANEL_ACCESS" username="${sessionScope.loginUser.userName}">
			      <li>
			        <a>受理人员操作台</a>
				    <ul>
				      <sys:auth grant="EVID_ACCEPTANCE" username="${sessionScope.loginUser.userName}">
				        <li><a data-url="${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/acceptedList.do">检材受理</a></li>
				      </sys:auth>
				  
				      <sys:auth grant="EVID_IMPORT" username="${sessionScope.loginUser.userName}">
				        <li><a data-url="${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/warehousingList.do">检材入库</a></li>
				      </sys:auth>
				  
				      <sys:auth grant="EVID_HANDOVER" username="${sessionScope.loginUser.userName}">
				        <li><a data-url="${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/handoverList.do">检材交接</a></li>
				      </sys:auth>
				  
				      <sys:auth grant="APPRAISAL_FEEDBACK" username="${sessionScope.loginUser.userName}"> 
				        <li><a data-url="${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/resultsMgtList.do">结果管理</a></li>
				      </sys:auth>
				    </ul>
			      </li>
			    </sys:auth>
			    
			    <sys:auth grant="MANAGER_CTRL_PANEL_ACCESS" username="${sessionScope.loginUser.userName}">
			      <li>
			        <a>管理人员操作台</a>
			        <ul>
				      <sys:auth grant="EVID_AUDIT" username="${sessionScope.loginUser.userName}">
				        <li><a data-url="${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/examinationOfMaterialsList.do">检材审核</a></li>
				      </sys:auth>
				  
				      <sys:auth grant="APPRAISAL_ALLOCATION" username="${sessionScope.loginUser.userName}">
				        <li><a data-url="${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/identificationAllocationList.do">鉴定分配</a></li>
				      </sys:auth>
				  
				      <sys:auth grant="APPRAISAL_APPROVAL" username="${sessionScope.loginUser.userName}">
				        <li><a data-url="${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/clericalApprovalList.do">文书审批</a></li>
				      </sys:auth>
								
				      <sys:auth grant="APPRAISAL_ADJ_APPROVAL" username="${sessionScope.loginUser.userName}">
				        <li><a data-url="${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/modifyClericalApprovalList.do">修改文书审批</a></li>
				      </sys:auth> 
				    </ul>
			      </li>
			    </sys:auth>
			    
			    <sys:auth grant="APPRAISER_CTRL_PANEL_ACCESS" username="${sessionScope.loginUser.userName}">
			      <li>
			        <a>鉴定人员操作台</a>
				    <ul>
				      <sys:auth grant="APPRAISAL_ANALYSIS" username="${sessionScope.loginUser.userName}">
			            <li><a data-url="${pageContext.request.contextPath}/elecEVIDMgt/authenticate/analysis/appraisalProcessAllot.do">检材鉴定分析</a></li>
				      </sys:auth>
								
				      <sys:auth grant="APPRAISAL_ADJUSTMENT" username="${sessionScope.loginUser.userName}">
				        <li><a data-url="${pageContext.request.contextPath}/elecEVIDMgt/authenticate/document/documentList.do">文书修改申请</a></li>
				      </sys:auth>
								
				      <sys:auth grant="APPRAISAL_ADJUSTMENT" username="${sessionScope.loginUser.userName}">
				        <li><a data-url="${pageContext.request.contextPath}/elecEVIDMgt/authenticate/document/documentchange.do">文书修改</a></li>
				      </sys:auth>
				    </ul>
		          </li>
		        </sys:auth>
			    
			    <sys:auth grant="APPRAISAL_QUERY" username="${sessionScope.loginUser.userName}">
			      <li><a data-url="${pageContext.request.contextPath}/elecEVIDMgt/generalMessage/generalMessageList.do">综合鉴定信息</a></li>
			    </sys:auth> 
			  </ul>
	        </li>
	      </sys:auth>
		  
		  <sys:auth grant="INQUEST_MGT_ACCESS" username="${sessionScope.loginUser.userName}">
		    <li class="inquestMgt"><a data-url="${pageContext.request.contextPath}/inquestMgt/sceneInquestList.do">现场勘验</a></li>
		  </sys:auth>
		  
		  <sys:auth grant="EQPT_MGT_ACCESS" username="${sessionScope.loginUser.userName}">
		    <li class="deviceMgt">
	          <a>设备与环境管理</a>
			    <ul>
			      <sys:auth grant="EQPT_INFO_MGT_ACCESS" username="${sessionScope.loginUser.userName}">
				    <li><a data-url="${pageContext.request.contextPath}/deviceMgt/deviceMgtList.do">设备管理</a></li>
				  </sys:auth>
						
				  <sys:auth grant="EQPT_MAINTENANCE_ACCESS" username="${sessionScope.loginUser.userName}">
				    <li><a data-url="${pageContext.request.contextPath}/deviceMgt/deviceMaintainList.do">设备维护</a></li>
			      </sys:auth>
						
				  <sys:auth grant="TH_MONITORING" username="${sessionScope.loginUser.userName}">
				    <li><a data-url="${pageContext.request.contextPath}/envMgt/environmentalMonitoring.do">环境监控</a></li>
				  </sys:auth>
				
				  <sys:auth grant="EQPT_USING_SITN" username="${sessionScope.loginUser.userName}">
				    <li><a data-url="${pageContext.request.contextPath}/deviceMgt/deviceUseSituationList.do">设备使用情况</a></li>
				  </sys:auth>
				
				  <sys:auth grant="DEV_MAINTENANCE_APPROVAL" username="${sessionScope.loginUser.userName}">
				    <li><a data-url="${pageContext.request.contextPath}/deviceMgt/deviceMaintainApprovalList.do">设备维护申请审批</a></li>
				  </sys:auth>
				
				  <sys:auth grant="EXTERNAL_DEV_BORROWING" username="${sessionScope.loginUser.userName}">
				    <li><a data-url="${pageContext.request.contextPath}/deviceMgt/externalDeviceMgtList.do">外部设备借用</a></li>
				  </sys:auth>
			    </ul>
			  </li>
			</sys:auth>
						
			<sys:auth grant="FLOW_MGT_ACCESS|EVID_INVENTORY|EVID_HANDOVER_SITN" username="${sessionScope.loginUser.userName}">
			  <li class="evidenceMgt">
			    <a>取证及流程管理</a>
			    <ul>
			      <sys:auth grant="EVID_INVENTORY" username="${sessionScope.loginUser.userName}">
			        <li><a data-url="${pageContext.request.contextPath}/evidenceMgt/inTheLibrary/inTheLibraryList.do">在库检材</a></li>
				  </sys:auth>
				
				  <sys:auth grant="EVID_HANDOVER_SITN" username="${sessionScope.loginUser.userName}">
			        <li><a data-url="${pageContext.request.contextPath}/evidenceMgt/handoverRecord/handoverRecordList.do">检材交接记录</a></li>
			      </sys:auth>
			      
				  <sys:auth grant="EVID_INVENTORY" username="${sessionScope.loginUser.userName}">
				    <li><a data-url="${pageContext.request.contextPath}/evidenceMgt/outOfTheLibrary/outOfTheLibraryList.do">已出库检材</a></li>
				  </sys:auth>
				  
				  <sys:auth grant="PROCESS_MGT_ACCESS" username="${sessionScope.loginUser.userName}">
			        <li><a data-url="${ SYS_PATH["FM"] }/workflow/edit/workFlowDetail.do?flowId=402881045af9c88c015af9c98dae0001">流转管理</a></li>
				  </sys:auth>
				
				  <sys:auth grant="FORM_MGT_ACCESS" username="${sessionScope.loginUser.userName}">
				    <li><a data-url="${ SYS_PATH["FM"] }/form/edit/getFormDetailById.do?formId=402881045af9c88c015af9c9397d0000">表单管理</a></li>
				  </sys:auth>
			    </ul>
			  </li>
			</sys:auth>
			
			<sys:auth grant="PSNL_INFO_MGT_ACCESS" username="${sessionScope.loginUser.userName}">
			  <li class="psnlInfoMgt">
			    <a>人员信息管理</a>
			    <ul>
			      <sys:auth grant="APPRAISER_LIB_ACCESS" username="${sessionScope.loginUser.userName}">
				    <li><a data-url="${pageContext.request.contextPath}/psnlInfo/expert/personnelInfoList.do">专家库</a></li>
				  </sys:auth>
				
				  <sys:auth grant="VISITOR_MGT_ACCESS" username="${sessionScope.loginUser.userName}">
			        <li><a data-url="${pageContext.request.contextPath}/psnlInfo/visitor/visitorInfoList.do">来访人员管理</a></li>
				  </sys:auth>
				
				  <sys:auth grant="TRAINING_PLAN_MGT_ACCESS" username="${sessionScope.loginUser.userName}">
				    <li><a data-url="${pageContext.request.contextPath}/psnlInfo/trainingPlan/trainingPlanInfoList.do">培训计划</a></li>
				  </sys:auth> 
			    </ul>
			  </li>
			</sys:auth>
			
			<sys:auth grant="MEETING_MGT_ACCESS" username="${sessionScope.loginUser.userName}">
			  <li class="meetingMgt">
			    <a>会议管理</a>
			    <ul>
			      <sys:auth grant="MEETING_APP_ACCESS" username="${sessionScope.loginUser.userName}">
				    <li>
				      <a>会议申请</a>
					  <ul>
					    <sys:auth grant="GENERAL_MEETING_APP" username="${sessionScope.loginUser.userName}">
						  <li><a data-url="${pageContext.request.contextPath}/meetingMgt/generalMeet/meetingApplyList.do">普通会议</a></li>
						</sys:auth>
						
						<sys:auth grant="INTR_RVW_MEETING_APP" username="${sessionScope.loginUser.userName}">
						  <li><a data-url="${pageContext.request.contextPath}/meetingMgt/internalAudit/meetInternalAuditList.do">内部审核会议</a></li>
						</sys:auth>
									
						<sys:auth grant="MGT_RVW_MEETING_APP" username="${sessionScope.loginUser.userName}">
						  <li><a data-url="${pageContext.request.contextPath}/meetingMgt/review/meetReviewList.do">管理评审会议</a></li>
						</sys:auth>
					  </ul>
					</li>
			      </sys:auth>
				  
				  <sys:auth grant="MEETING_ROOM_MGT_ACCESS" username="${sessionScope.loginUser.userName}">
				    <li><a data-url="${pageContext.request.contextPath}/meetingMgt/meetingRoom/meetingRoomApplyList.do">会议室管理</a></li>
				  </sys:auth>
				  
				  <sys:auth grant="PLAN_APP_ACCESS" username="${sessionScope.loginUser.userName}">
				    <li>
					  <a>计划</a>
					  <ul>
					    <sys:auth grant="ANNUAL_PLAN_APP" username="${sessionScope.loginUser.userName}">
						  <li><a data-url="${pageContext.request.contextPath}/meetingMgt/annualPlan/annualPlanList.do">内审年度计划</a></li>
					    </sys:auth>
									
						<sys:auth grant="IMPL_PLAN_APP" username="${sessionScope.loginUser.userName}">
						  <li><a data-url="${pageContext.request.contextPath}/meetingMgt/annualPlan/realtimePlanList.do">内审实施计划</a></li>
						</sys:auth>
					    
					    <sys:auth grant="REVIEW_PLAN_APP" username="${sessionScope.loginUser.userName}">
						  <li><a data-url="${pageContext.request.contextPath}/meetingMgt/managementReviewPlan/managementReviewPlanList.do">管理评审计划</a></li>
						</sys:auth>
					  </ul>
					</li>
				  </sys:auth> 
				</ul>
			  </li>
			</sys:auth>
			  
			<sys:auth grant="KNOWLEDGE_MGT_ACCESS" username="${sessionScope.loginUser.userName}">
			  <li class="knowledgeMgt">
			  <a>知识管理</a>
				<ul>
			      <sys:auth grant="KNOWLEDGE_LIB_ACCESS" username="${sessionScope.loginUser.userName}">
				    <li><a data-url="${pageContext.request.contextPath}/knowledgeMgt/knowledgeBase/knowledgeBaseViewer.do">知识库</a></li>
				  </sys:auth>
					
				  <sys:auth grant="DOC_EDIT" username="${sessionScope.loginUser.userName}">
				    <li><a data-url="${pageContext.request.contextPath}/knowledgeMgt/fileMgt/fileMgtList.do">知识文件管理</a></li>
				  </sys:auth>
					
				  <sys:auth grant="DOC_APPROVAL" username="${sessionScope.loginUser.userName}">
				    <li><a data-url="${pageContext.request.contextPath}/knowledgeMgt/fileMgt/tempFileMgtList.do">知识文件审批</a></li>
				  </sys:auth>
				</ul>
			  </li>
			</sys:auth>
		    
		      <sys:auth grant="ANALYSIS_USER" username="${sessionScope.loginUser.userName}">  
			  <!-- <li class="statisticalAnalysis"><a>统计分析</a></li> -->
			  <li class="analysisMgt">
				<a>统计分析</a>
				<ul>
					<li><a data-url="${pageContext.request.contextPath}/analysisMgt/precheck.do">预检分析</a></li>
					<li><a data-url="${pageContext.request.contextPath}/analysisMgt/checkMaterial.do">检材分析</a></li>
					<li><a data-url="${pageContext.request.contextPath}/analysisMgt/authenticate.do">鉴定分析</a></li>
					<li>
						<a>比率分析</a>
						<ul>
						<sys:auth grant="ANALYSIS_ADD" username="${sessionScope.loginUser.userName}"> 
							<li><a data-url="${pageContext.request.contextPath}/analysisMgt/ratio/ratioForm.do">数据录入</a></li>
						</sys:auth> 
							<li><a data-url="${pageContext.request.contextPath}/analysisMgt/ratio/forensics.do">取证应用率</a></li>
							<li><a data-url="${pageContext.request.contextPath}/analysisMgt/ratio/inquest.do">现场勘验率</a></li>
							<li><a data-url="${pageContext.request.contextPath}/analysisMgt/ratio/ratioViewer.do">比率统计表</a></li>
						</ul>
					</li>
				</ul>
			</li>
			 </sys:auth>  
			  
			<sys:auth grant="PLATFORM_MGT_ACCESS" username="${sessionScope.loginUser.userName}">
			  <li class="systemMgt">
			    <a>系统管理</a>
			    <ul>
			      <sys:auth grant="ORG_ACCESS" username="${sessionScope.loginUser.userName}">
				    <li><a data-url="${pageContext.request.contextPath}/system/org/orgList.do">组织架构</a></li>
				  </sys:auth>
						
				  <sys:auth grant="USER_ACCESS" username="${sessionScope.loginUser.userName}">
				    <li><a data-url="${pageContext.request.contextPath}/system/user/userList.do">用户管理</a></li>
				  </sys:auth>
				  
				  <sys:auth grant="ROLE_ACCESS" username="${sessionScope.loginUser.userName}">
				    <li><a data-url="${pageContext.request.contextPath}/system/role/roleList.do">角色管理</a></li>
				  </sys:auth>
				  
				  <sys:auth grant="NOTE_ACCESS" username="${sessionScope.loginUser.userName}">
				    <li><a data-url="${pageContext.request.contextPath}/system/notification/notificationList.do">通知公告</a></li>
				  </sys:auth>
				  
				  <sys:auth grant="LOG_ACCESS" username="${sessionScope.loginUser.userName}">
				    <li><a data-url="${pageContext.request.contextPath}/system/log/accessLogList.do">日志管理</a></li>
				  </sys:auth>
				</ul>
			  </li>
			</sys:auth>
		  </ul>
		</div>
	  </div>
	    
	  <%-- CONTENT --%>
	  <div class="iframe-content">
	    <iframe class="index-iframe" src="${pageContext.request.contextPath}/firstpage.do" ></iframe>
	  </div>
	
	  <%-- USER PASSWORD FORM MODALS --%>
	  <div class="lock">
        <div class="password_div">
		  <iframe class="iframe2"></iframe>
		</div>
	  </div>
	
	  <%-- USER PROFILE FORM MODALS --%>
	  <div class="lock2">
	    <div class="ziliao_div">
		  <iframe class="iframe3"></iframe>
		</div>
	  </div>
	
	  <%-- LOGOUT CONFIRM MODALS --%>
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
      <div class="textDiv hideDiv">请自行将浏览器浏览模式手动切换成极速模式，否则无法对页面进行任何操作。</div>
	    
	  <script type="text/javascript">
		//浏览器浏览模式判断
		if(window.navigator.userAgent.indexOf('AppleWebKit') != -1) {
			$(".hideDiv").hide();
		}else{
			$(".hideDiv").show();
		}
	
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
				$(this).parents(".main-menu > li").addClass("active");
				$(".index-iframe").attr("src",url);
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
  </body>
</html>