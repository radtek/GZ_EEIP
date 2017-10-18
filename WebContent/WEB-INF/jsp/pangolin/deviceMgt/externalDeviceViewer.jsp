<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>借用外部设备查看表单</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
	<script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
 	<script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
 	
 	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>设备与环境管理</a><span>></span><a>外部设备借用</a><span>></span><a>查看表单</a>
        </p>
    </div>
    <div class="form-title">借用外部仪器设备审批表</div>
    <div class="form-content">
        <form class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label">申请人：</label>
                <div class="col-sm-4" data-bind="with: devBorrowAppVM">
                    <input type="text" data-bind="value: creatorAlias" name="creatorAlias" id="creatorAlias" class="form-control" readonly />
                </div>
                <label class="col-sm-2 control-label">申请日期：</label>
                <div class="col-sm-4" data-bind="with: devBorrowAppVM">
                	<input id="createdDate" name="createdDate" class="form-control datetimepicker" data-bind="dateTimePicker: createdDate" readonly />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">设备名称：</label>
                <div class="col-sm-4" data-bind="with: devBorrowAppVM">
                    <input type="text" data-bind="value: name" name="name" id="name" class="form-control" readonly />
                </div>
                <label class="col-sm-2 control-label">型号/规格：</label>
                <div class="col-sm-4" data-bind="with: devBorrowAppVM">
                    <input type="text" data-bind="value: identifier" name="identifier" id="identifier" class="form-control" readonly />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">提供单位：</label>
                <div class="col-sm-4" data-bind="with: devBorrowAppVM">
                    <input type="text" data-bind="value: org" name="org" id="org" class="form-control" readonly />
                </div>
                <label class="col-sm-2 control-label">联系人：</label>
                <div class="col-sm-4" data-bind="with: devBorrowAppVM">
                    <input type="text" data-bind="value: contacts" name="contacts" id="contacts" class="form-control" readonly />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">借用理由：</label>
                <div class="col-sm-10" data-bind="with: devBorrowAppVM">
                	<textarea rows="8" data-bind="value: reason" name="reason" id="reason" cols="" class="form-control" readonly></textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">技术负责人意见：</label>
                <div class="col-sm-10" data-bind="with: devBorrowAppVM">
                	<textarea rows="8" data-bind="value: auditorOpinion" name="auditorOpinion" id="auditorOpinion" cols="" class="form-control" readonly></textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">技术负责人：</label>
                <div class="col-sm-4" data-bind="with: devBorrowAppVM">
                    <input type="text" data-bind="value: auditorAlias" name="auditorAlias" id="auditorAlias" class="form-control" readonly/>
                </div>
                <label class="col-sm-2 control-label">审批时间：</label>
                <div class="col-sm-4" data-bind="with: devBorrowAppVM">
                	<input id="auditedDate" name="auditedDate" class="form-control datetimepicker" data-bind="dateTimePicker: auditedDate" readonly/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">实验室主任意见：</label>
                <div class="col-sm-10" data-bind="with: devBorrowAppVM">
                	<textarea rows="8" data-bind="value: approverOpinion" name="approverOpinion" id="approverOpinion" cols="" class="form-control" readonly></textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">实验室主任：</label>
                <div class="col-sm-4" data-bind="with: devBorrowAppVM">
                    <input type="text" data-bind="value: approverAlias" name="approverAlias" id="approverAlias" class="form-control" readonly/>
                </div>
                <label class="col-sm-2 control-label">审批时间：</label>
                <div class="col-sm-4" data-bind="with: devBorrowAppVM">
                	<input id="approvedDate" name="approvedDate" class="form-control datetimepicker" data-bind="dateTimePicker: approvedDate" readonly/>
                </div>
            </div>
        </form>
    </div>
    <div class="btn-content">
        <button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
        <!-- <button class="btn btn-color1"><i class="fa fa-check"></i>同意</button>
        <button class="btn btn-color1"><i class="fa fa-times"></i>不同意</button> -->
    </div>
    <script type="text/javascript">
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
	    $(".back-btn").click(function(){
	    	var url = "${pageContext.request.contextPath}/deviceMgt/externalDeviceMgtList.do";
	    	$(".index-iframe", window.parent.document).attr("src",url);
	    });
	    
        var devBorrowAppData = loadData("${ pageContext.request.contextPath }/deviceMgt/devBorrowApp/loadDevBorrowAppData.do", {"id" : "${param.borId}"});
        var devBorrowAppDataVM = ko.mapping.fromJS(devBorrowAppData);
        var vm = {
			devBorrowAppVM : devBorrowAppDataVM	
        }
        ko.applyBindings(vm);
    </script>
</body>
</html>