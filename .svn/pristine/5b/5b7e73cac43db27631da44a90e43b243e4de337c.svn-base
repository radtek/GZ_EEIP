<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>管理评审报告表单</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>
	<script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/meet/meet.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/knowledgeMgt/fileMgt-form.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" /> 
</head>
<body>
	<div class="content">
		<div class="crumbs-nav">
	        <p class="crumbs-text">
	           	当前位置：<a>会议管理</a><span>></span><a>会议申请</a><span>></span><a>管理评审会议</a>
	        </p>
    	</div>
		
		<form class="form-horizontal myform">
															
			<div class="form-group">
				<label class="col-sm-2 control-label">编号：</label>
				<div class="col-sm-4" data-bind="with:reportVM">
					<input type="text" class="form-control" data-bind="value:meetingMaReport.sn" required/>
				</div>
				<label class="col-sm-2 control-label">计划表编号：</label>
				<div class="col-sm-4" data-bind="with:reportVM">
					<input type="text" class="form-control" data-bind="value:meetingMaReport.planSn" required/>
				</div>								
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">主持人：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<select id="userId"
							class="form-control" required
							data-bind="options:userList,optionsValue:'userId',optionsText:'userAlias',value:userId,optionsCaption:'--请选择--',event:{change:changeUser}">
					</select>
				</div>
				<label class="col-sm-2 control-label">评审日期：</label>
				<div class="col-sm-4" data-bind="with:reportVM">
					<input type="text" class="form-control" data-bind="dateTimePicker:meetingMaReport.auditedDate"/>
				</div>								
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">评审地点：</label>
				<div class="col-sm-10" data-bind="with:reportVM">
					<input type="text" class="form-control" data-bind="value:meetingMaReport.location"/>
				</div>						
			</div>					
			<div class="form-group">
				<label class="col-sm-2 control-label">评审目的：</label>
				<div class="col-sm-10" data-bind="with:reportVM">
					<input type="text" class="form-control" data-bind="value:meetingMaReport.purpose"/>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">评审依据：</label>
				<div class="col-sm-10" data-bind="with:reportVM">
					<input type="text" class="form-control" data-bind="value:meetingMaReport.gist"/>
				</div>						
			</div>
			<div class="form-group">
                <label class="col-sm-2 control-label">参与人员：</label>
                <div class="col-sm-10">
                    <!-- <textarea rows="8" cols="" class="form-control"></textarea> -->
                    <div class="associated-file-content">
                    	<div class="associated-file-list">
                    	</div>
                    	<div class="add-associated-file">
                    		<button type="button" class="btn btn-color1 add-file-btn"><i class="fa fa-plus"></i>添加</button>
                    	</div>
                    </div>
                    <div class="add-content">
                    	<div class="search-content">
                    		<div class="col-sm-10 add-content-title">姓名</div>
					        <div class="col-sm-2 search-right" >
					        	<button type="button" class="btn btn-color2 hide-btn"><i class="fa fa-times"></i>收起</button>
					        </div>
					    </div>
					    <ul class="file-list">
					    </ul>
                    </div>
                </div>
            </div>
			<div class="form-group">
				<label class="col-sm-2 control-label">评审结论及相关意见：</label>
				<div class="col-sm-10" data-bind="with:reportVM">
					<textarea class="form-control" data-bind="value:meetingMaReport.conclusion"></textarea>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">备注：</label>
				<div class="col-sm-10" data-bind="with:reportVM">
					<textarea class="form-control" data-bind="value:meetingMaReport.remarks"></textarea>
				</div>						
			</div>	
			<div class="form-group">
				<label class="col-sm-2 control-label">审核意见：</label>
				<div class="col-sm-10" data-bind="with:reportVM">
					<textarea class="form-control" data-bind="value:meetingMaReport.opinion" ></textarea>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">批准人：</label>
				<div class="col-sm-4" data-bind="with:reportVM">
					<input type="text" class="form-control" data-bind="value:meetingMaReport.approverAlias"/>
				</div>	
				<label class="col-sm-2 control-label">日期：</label>
				<div class="col-sm-4" data-bind="with:reportVM">
					<input type="text" class="form-control" data-bind="dateTimePicker:meetingMaReport.approvedDate" />
				</div>						
			</div>		
			<div class="form-group">
				<div class="center">
					<button type="submit" data-bind="click: saveData" class="submit-btn">√ 提交</button>
					<button type="submit" data-bind="click: backToList" class="back-btn">< 返回</button>
				</div>
			</div>
		</form>
	</div>	
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
	
	<script>
	
		
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
		
	 	var reportData = loadData("${pageContext.request.contextPath}/meeting/meetingMa/report/loadReportByAppIdData.do",{ "id" : "${param.id}" });
	    var reportDataVM = ko.mapping.fromJS(reportData);
	    
	    var userData = loadData("${pageContext.request.contextPath}/system/user/getAllUserData.do",{});
	    var userDataVM = {
	    		userList : ko.observableArray(userData),
	    		userId : ko.observable(reportData.meetingMaReport.emceeId)
	    }
	    
	    var participant = reportData.participants;
	    
	    var vm = {
	    		reportVM : reportDataVM,
	    		userVM : userDataVM
	    }
	    
	    vm.saveData = function(){
	    	$("button").attr("disabled", true);
	        if ( validateSubmittedData() ) {
	        	bindDataVM();
	        	if (saveData("${pageContext.request.contextPath}/meeting/meetingMa/report/saveReportData.do", reportDataVM)) {
					saveSuccess("${pageContext.request.contextPath}/meetingMgt/review/meetReviewFileView.do?id=${param.id}");
				} else {
					saveFailure();
				}
	        } else {
	        	saveFailure();
	        }
		}
		
		vm.backToList = function(){//返回
			$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/review/meetReviewFileView.do?id=${param.id}');
		}
		
		ko.applyBindings(vm);
		//数据绑定
		function bindDataVM(){
			reportDataVM.meetingMaReport.status = 1;
			reportDataVM.meetingMaReport.meetingAppId = "${param.id}";
			reportDataVM.meetingMaReport.creatorName = "${sessionScope.loginUser.userName}";
			reportDataVM.meetingMaReport.creatorId = "${sessionScope.loginUser.userId}";
	    	reportDataVM.meetingMaReport.creatorAlias = "${sessionScope.loginUser.userAlias}";
	    	reportDataVM.meetingMaReport.emceeId = $("#userId").val();
	    	reportDataVM.participants = participant;
		}
		
		function changeUser(){
			var index = $('#userId option:selected').index();
			reportDataVM.meetingMaReport.emceeName = userData[index-1]['userName'];
			reportDataVM.meetingMaReport.emceeAlias = userData[index-1]['userAlias'];
			//$("#operatorName").val(userData[index-1]['userName']);
		}
		
		//组装参与人员
		var userHtml = '';
        for(var i=0;i<userData.length;i++){
			userHtml += '<li class="add" data-id = "'+userData[i]['userId']+'" data-name = "'+userData[i]['userName']+'">'+userData[i]['userAlias']+'</li>';
		}
		
		
		
		
        $(".file-list").html(userHtml);
		
		$(".add-file-btn").click(function() {
			$(".add-content").show();
		});

		$(".hide-btn").click(function() {
			$(".add-content").hide();
		});

		$(".file-list").on("click",".add",function() {
			var alias = $(this).text();
			var id = $(this).attr('data-id');
			var name = $(this).attr('data-name');
			if( $(".associated-file-list").find("#" + id).text() == "undefined" || $(".associated-file-list").find("#" + id).text() == ""){
				$(".associated-file-list").prepend('<p id="' + id + '"> '+ alias
						                   +'<button type="button" data-id="'+ id+'" class="remove" aria-hidden="true">×</button>'
						                   +'</p>');
				participant.push({'id':null,'userId':id,'userName':name,'userAlias':alias,'userMp':''});
				
			}
			
		});

		// 删除参与人员
		$(".associated-file-list").on('click','.remove',function(){
			var id = $(this).attr('data-id');
			$(".associated-file-list").find("#" + id).remove();
			for(var i=0;i<participant.length;i++){
				if(participant[i].userId == id){
					if(participant[i]['id'] != "" ){
						$.ajax({
							url:'${pageContext.request.contextPath}/meeting/meetingMa/participant/removeParticipantData.do',
							type:'post',
							datatype:'json',
							data:{'id':participant[i]['id']},
							success:function(data){
								participant.splice(i, 1);
							},
							error:function(){
								
							}
						})
					}else{
						participant.splice(i, 1);
					}  
					break;
				}
			}
		})
	
		//参与人员复写
		if( participant.length > 0 ){
			for(var i=0;i<participant.length;i++){
				$(".associated-file-list").prepend('<p id="' + participant[i]['userId'] + '"> '+ participant[i]['userAlias'] + 
				                '<button type="button" data-id="'+ participant[i]['userId']+'" class="remove" aria-hidden="true">×</button></p>');
			}
		}
	
	</script>
</body>
</html>