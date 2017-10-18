<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<div class="title-list">
	<div class="pub base">
		<div>基本情况</div>
	</div>
	<div class="pub work">
		<div>工作经历</div>
	</div>
	<div class="pub winning">
		<div>获奖情况</div>
	</div>
	<div class="pub report">
		<div>著作报告</div>
	</div>
	<div class="pub certificate">
		<div>资格证书</div>
	</div>
	<div class="pub examine">
		<div>业务考核</div>
	</div>
	<div class="pub authorization" style="width:240px;">
		<div>业务能力确认及授权</div>
	</div>
	<div class="pub record">
		<div>培训履历</div>
	</div>
</div>			
<script>	
	$(function(){
			var typeNav = "${param.type}";
			if(typeNav == "certificate"){
				$(".title-list .pub").removeClass("active");
				$(".title-list .certificate").addClass("active");
			}else if(typeNav == "work"){
				$(".title-list .pub").removeClass("active");
				$(".title-list .work").addClass("active");
			}else if(typeNav == "winning"){
				$(".title-list .pub").removeClass("active");
				$(".title-list .winning").addClass("active");
			}else if(typeNav == "report"){
				$(".title-list .pub").removeClass("active");
				$(".title-list .report").addClass("active");
			}else if(typeNav == "record"){
				$(".title-list .pub").removeClass("active");
				$(".title-list .record").addClass("active");
			}else if(typeNav == "examine"){
				$(".title-list .pub").removeClass("active");
				$(".title-list .examine").addClass("active");
			}else if(typeNav == "authorization"){
				$(".title-list .pub").removeClass("active");
				$(".title-list .authorization").addClass("active");
			}else{
				$(".title-list .pub").removeClass("active");
				$(".title-list .base").addClass("active");
			}
			//专家导航跳转页面
			$(".title-list .pub").click(function(){
				var userId = "${param.userBasicInfoId}";
				/* if(userId == '' && userId == null && userId == undefined){
					userId = userIdBoot;
				}
				//alert(userId); */
				if( "${param.status}" == 0 ){
					if($(this).hasClass("base")){
						$(".index-iframe", window.parent.document).attr("src","${pageContext.request.contextPath}/psnlInfo/expert/personnelRegisterForm.do?userBasicInfoId="+userId+"&type=base&status=0");					
					}else if($(this).hasClass("work")){
						$(".index-iframe", window.parent.document).attr("src","${pageContext.request.contextPath}/psnlInfo/expert/workExperience.do?userBasicInfoId="+userId+"&type=work&status=0");			
					}else if($(this).hasClass("winning")){
						$(".index-iframe", window.parent.document).attr("src","${pageContext.request.contextPath}/psnlInfo/expert/winningSituation.do?userBasicInfoId="+userId+"&type=winning&status=0");		
					}else if($(this).hasClass("report")){
						$(".index-iframe", window.parent.document).attr("src","${pageContext.request.contextPath}/psnlInfo/expert/writingsReport.do?userBasicInfoId="+userId+"&type=report&status=0");			
					}else if($(this).hasClass("record")){
						$(".index-iframe", window.parent.document).attr("src","${pageContext.request.contextPath}/psnlInfo/expert/trainingRecord.do?userBasicInfoId="+userId+"&type=record&status=0");	
					}else if($(this).hasClass("examine")){
						$(".index-iframe", window.parent.document).attr("src","${pageContext.request.contextPath}/psnlInfo/expert/businessAssessmentList.do?userBasicInfoId="+userId+"&type=examine&status=0");		
					}else if($(this).hasClass("authorization")){
						$(".index-iframe", window.parent.document).attr("src","${pageContext.request.contextPath}/psnlInfo/expert/authorize.do?userBasicInfoId="+userId+"&type=authorization&status=0");			
					}else{
						$(".index-iframe", window.parent.document).attr("src","${pageContext.request.contextPath}/psnlInfo/expert/qualification.do?userBasicInfoId="+userId+"&type=certificate&status=0");			
					}		
				}else if( "${param.status}" == 1 ){
					if($(this).hasClass("base")){
						$(".index-iframe", window.parent.document).attr("src","${pageContext.request.contextPath}/psnlInfo/expert/personnelInfoView.do?userBasicInfoId="+userId+"&type=base&status=1");					
					}else if($(this).hasClass("work")){
						$(".index-iframe", window.parent.document).attr("src","${pageContext.request.contextPath}/psnlInfo/expert/workExperienceView.do?userBasicInfoId="+userId+"&type=work&status=1");			
					}else if($(this).hasClass("winning")){
						$(".index-iframe", window.parent.document).attr("src","${pageContext.request.contextPath}/psnlInfo/expert/winningSituationView.do?userBasicInfoId="+userId+"&type=winning&status=1");		
					}else if($(this).hasClass("report")){
						$(".index-iframe", window.parent.document).attr("src","${pageContext.request.contextPath}/psnlInfo/expert/writingsReportView.do?userBasicInfoId="+userId+"&type=report&status=1");			
					}else if($(this).hasClass("record")){
						$(".index-iframe", window.parent.document).attr("src","${pageContext.request.contextPath}/psnlInfo/expert/trainingRecordView.do?userBasicInfoId="+userId+"&type=record&status=1");	
					}else if($(this).hasClass("examine")){
						$(".index-iframe", window.parent.document).attr("src","${pageContext.request.contextPath}/psnlInfo/expert/businessAssessmentList.do?userBasicInfoId="+userId+"&type=examine&status=1");		
					}else if($(this).hasClass("authorization")){
						$(".index-iframe", window.parent.document).attr("src","${pageContext.request.contextPath}/psnlInfo/expert/authorizeView.do?userBasicInfoId="+userId+"&type=authorization&status=1");			
					}else{
						$(".index-iframe", window.parent.document).attr("src","${pageContext.request.contextPath}/psnlInfo/expert/qualificationView.do?userBasicInfoId="+userId+"&type=certificate&status=1");			
					}		
				}
				
			});
	}); 
</script>
