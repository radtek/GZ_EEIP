<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>人员基本情况查看</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script> 
    <script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>	 
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
 	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
 	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/expert.js" />"></script>
 	
 	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/expert/expert.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" /> 
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
	<div class="content">	
		<div class="crumbs-nav">
	        <p class="crumbs-text">
	           	当前位置：<a>人员信息管理</a><span>></span><a>专家库</a><span>></span><a>查看</a><span>></span><a>基本情况</a>
	        </p>
    	</div>
		<jsp:include page="/common/personNav.jsp"></jsp:include>
		<form class="form-horizontal myform">
			<div class="form-group">
				<label class="col-sm-2 control-label">姓名：</label>
				<div class="col-sm-2" data-bind="with:userVM">
					<input type="text" class="form-control"  data-bind="value:name" readonly/>
				</div>
				<label class="col-sm-2 control-label">性别：</label>
				<div class="col-sm-3" data-bind="with:userVM">
					<select id="sex" class="form-control" data-bind="value:sex" disabled>
						<option value="0">男</option>
						<option value="1">女</option>
					</select>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">出生日期：</label>
				<div class="col-sm-2" data-bind="with:userVM">
					<input type="text" class="form-control datetimepicker2"  data-bind="dateTimePicker:birthday" readonly />
				</div>
				<label class="col-sm-2 control-label">身份证件号码：</label>
				<div class="col-sm-3" data-bind="with:userVM">
					<input type="text" class="form-control" data-bind="value:idCard"  readonly/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">家庭地址：</label>
				<div class="col-sm-7" data-bind="with:userVM">
					<input type="text" class="form-control"  data-bind="value:addr" readonly/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">邮编：</label>
				<div class="col-sm-7" data-bind="with:userVM">
					<input type="text" class="form-control"  data-bind="value:zipCode" readonly/>
				</div>
			</div>
			<div class="img-upload center" data-bind="with:userVM">
				<img  class="photo" src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/expert/header.png" />
 				<input type="hidden" data-bind="value:dept"/>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">籍贯：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<input type="text" class="form-control" data-bind="value:nativePlace" readonly/>
				</div>
				<label class="col-sm-2 control-label">民族：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<input type="text" class="form-control"  data-bind="value:nation" readonly/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">工作部门：</label>
				<div class="col-sm-10" data-bind="with:userVM">
					<input type="text" class="form-control"  data-bind="value:dept" readonly/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">参加工作时间：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<input type="text" class="form-control datetimepicker" data-bind="dateTimePicker:workingDate" readonly/>
				</div>						
				<label class="col-sm-2 control-label">公安工作时间：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<input type="text" class="form-control datetimepicker" data-bind="dateTimePicker:policeDate" readonly/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">政治面貌：</label>
				<div class="col-sm-4" data-bind="with:userVM"> 
				    <select id="politicalStatus" class="form-control" data-bind="value:politicalStatus" disabled>
						<option value="0">中共党员</option>
						<option value="1">中共预备党员</option>
						<option value="2">共青团员</option>
						<option value="3">民革党员</option>
						<option value="4">民盟盟员</option>
						<option value="5">民建会员</option>
						<option value="6">农工党党员</option>
						<option value="7">致公党党员</option>
						<option value="8">九三学社社员</option>
						<option value="9">台盟盟员</option>
						<option value="10">无党派人士</option>
						<option value="11">群众</option>
					</select>
				</div>
				<label class="col-sm-2 control-label">入党时间：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<input type="text" class="form-control datetimepicker"  data-bind="dateTimePicker:joinDate"  readonly/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">行政职务：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<input type="text" class="form-control"  data-bind="value:position" readonly/>
				</div>
				<label class="col-sm-2 control-label">任职时间：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<input type="text" class="form-control datetimepicker" data-bind="dateTimePicker:officeDate" readonly/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">现从事专业：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<input type="text" class="form-control" data-bind="value:major" readonly/>
				</div>
				<label class="col-sm-2 control-label">本专业工作年限：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<input type="text" class="form-control"  data-bind="value:workingSeniority" readonly/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">现任专业技术职务：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<input type="text" class="form-control" data-bind="value:techPost" readonly/>
				</div>
				<label class="col-sm-2 control-label">取得资格时间：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<input type="text" class="form-control datetimepicker" data-bind="dateTimePicker:qualifyingDate" readonly/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">警衔：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<input type="text" class="form-control" data-bind="value:policeRank"  readonly/>
				</div>
			
				<label class="col-sm-2 control-label">警号：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<input type="text" class="form-control" data-bind="value:policeId"  readonly/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">学历：</label>
				<div class="col-sm-4" data-bind="with:userEducationVM">
					<input type="text" class="form-control"  data-bind="value:eduction" readonly/>
				</div>
				<label class="col-sm-2 control-label">学位：</label>
				<div class="col-sm-4" data-bind="with:userEducationVM">
					<input type="text" class="form-control"  data-bind="value:degree" readonly/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">毕业院校：</label>
				<div class="col-sm-4" data-bind="with:userEducationVM">
					<input type="text" class="form-control"  data-bind="value:school" readonly/>
				</div>
				<label class="col-sm-2 control-label">毕业时间：</label>
				<div class="col-sm-4" data-bind="with:userEducationVM">
					<input type="text" class="form-control datetimepicker"  data-bind="dateTimePicker:date"  readonly/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">专业：</label>
				<div class="col-sm-4" data-bind="with:userEducationVM">
					<input type="text" class="form-control"  data-bind="value:major" readonly/>
				</div>
				<label class="col-sm-2 control-label">毕业证书：</label>
				<div class="col-sm-4">
					<!-- <input type="text" class="form-control"  data-bind="value:educationCert" readonly/> -->
					<select class="form-control educationCert" disabled>
						<option value="1">是</option>
						<option value="0">否</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">学位证书：</label>
				<div class="col-sm-4">
					<!-- <input type="text" class="form-control"  data-bind="value:degreeCert" readonly/> -->
					<select class="form-control degreeCert" disabled>
						<option value="1">是</option>
						<option value="0">否</option>
					</select>
				</div>							
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label left">掌握何种外语，程度如何：</label>
				<div class="col-sm-10" data-bind="with:userVM">
					<textarea class="form-control" data-bind="value:foreignLangLvl" readonly></textarea>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label left">参加何种学术团体、任何职、有无社会其他兼职：</label>
				<div class="col-sm-10" data-bind="with:userVM">
					<textarea class="form-control" data-bind="value:socialPost" readonly></textarea>
				</div>						
			</div>
		</form>
	</div>
	<div class="btn-content">
        <button type="button" data-bind="click: backToList"  class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
    </div>	
	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/expert.js" />"></script>
	<script type="text/javascript">
	  $(function() { //时间控件数据绑定-----------开始
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
			$('.datetimepicker').datetimepicker({
	       		format: 'YYYY-MM-DD  ',
	    	});
			$('.datetimepicker2').datetimepicker({
		        format: 'YYYY-MM-DD',
	    	});	
			var userData = loadData("${pageContext.request.contextPath}/psnlInfo/userBasicInfo/getUserBasicInfoByIdData.do",{ "id" : "${param.userBasicInfoId}" });
		    var userDataVM = ko.mapping.fromJS(userData);
		    var userEducationData = loadData("${pageContext.request.contextPath}/psnlInfo/userEducation/getuserEducationByUserIdData.do",{ "userBasicInfoId" : "${param.userBasicInfoId}" });
		    var userEducationDataVM = ko.mapping.fromJS(userEducationData);
		    $('.educationCert').val(userEducationData.educationCert);
		    $('.degreeCert').val(userEducationData.degreeCert);
		    var imgSrc = "${pageContext.request.contextPath}/psnlInfo/userBasicInfo/loadAvatar.do?path="+userData.avatarPath;
			$(".photo").attr("src", imgSrc);
		    
		    var vm={
		    		userVM : userDataVM,
		    		userEducationVM :userEducationDataVM 
		    } 
			
			vm.backToList = function(){//返回
				$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/psnlInfo/expert/personnelInfoList.do');
			}
			
			ko.applyBindings(vm);
			 			
		});
  	</script>
</body>
</html>