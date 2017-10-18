<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>内部审核检查表录入</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/eeip/expert.js" />"></script>
	
	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet"> 
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/expert/expert.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" /> 
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />	
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>会议管理</a><span>></span><a>会议申请</a><span>></span><a>内部审核会议</a>
        </p>
   	</div>
	<div class="form-content">	
		<form class="form-horizontal">														
			<div class="form-group">
				<label class="col-sm-2 control-label">被审岗位：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" data-bind="value:auditedPost"/>
				</div>	
				<label class="col-sm-2 control-label">内审员：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" data-bind="value:auditorAlias"/>
				</div>								
			</div>
			<div class="form-group mag-top">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>审核意见：</label>
				<div class="col-sm-10" >
					<textarea class="form-control" data-bind="value:auditorOpinion" required></textarea>
				</div>						
			</div>		
		</form>
	</div>
	<div class="file-upload">
        <table class="table table-bordered">
			<thead>
				<tr>
					<th><span class="required-fields">*</span>审核设计要素</th>
					<th><span class="required-fields">*</span>审核内容</th>
					<th><span class="required-fields">*</span>审核方法</th>
					<th class="th-border">
						<p><span class="required-fields">*</span>审核结果</p>
						<p class="border-p">
							<span>符合Y</span>
							<span>观察Y’</span>
							<span>不符合N</span>
							<span class="no-border">不适用N/A</span>
						</p>
					</th>
					<th><span class="required-fields">*</span>结果说明</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody class="handleData">
				<!-- <tr>
					<td><input type="text" /></td>
					<td><input type="text" /></td>
					<td><input type="text" /></td>
					<td><input type="text" /></td>
					<td><input type="text" /></td>
					<td class="clearTd">删除</td>						
				</tr> -->
			</tbody>
			<tfoot>
				<tr>
                    <td colspan="6" align="center">
                        <button class="btn add-tr-btn add-record-list"><i class="fa fa-plus"></i>增加</button>
                    </td>
                </tr>
			</tfoot>
		</table>
    </div>
    <div class="btn-content">
       	<button class="btn btn-color2 back-btn" data-bind="click: backToList"><i class="fa fa-chevron-left"></i>返回</button>
       	<button class="btn btn-color1" data-bind="click: saveData"><i class="fa fa-check"></i>提交</button>
   	</div>
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/expert.js" />"></script>
	<script>
		$(function(){
			
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
			var radioRowNum = 0;
			$(".add-record-list").click(function(){
				radioRowNum++;
				var radioName = "result"+radioRowNum;													
				$(".handleData").append('<tr>'
										+'<td><input type="text" data-id="" required /></td>'
										+'<td><input type="text" required /></td>'	
										+'<td><input type="text" required /></td>'											
										+'<td class="td-checks"><span><input type="radio" name='+radioName+' value="0" checked /></span><span><input type="radio" name='+radioName+' value="1" /></span><span><input type="radio" name='+radioName+' value="2" /></span><span class="no-border"><input type="radio" name='+radioName+' value="3" /></span></td>'
										+'<td><input type="text" required /></td>'
										+'<td><span class="singleSubmit"> <i class="fa fa-check" title="提交"></i></span> <span class="singleClear"> <i class="fa fa-trash-o" title="删除"></i></span></td>'	
										+'</tr>'										
				);
			});	
						
			var data = loadData("${pageContext.request.contextPath}/meeting/meetingIa/inspection/loadInspectionData.do",{ "id" : "${param.id}" });
		    var vm = ko.mapping.fromJS(data);
		    vm.saveData = function(){
		    	if ( validateSubmittedData() ) {
		        	bindDataToVM();
		        	if(saveData("${pageContext.request.contextPath}/meeting/meetingIa/inspection/saveInspectionData.do",vm)){
						saveSuccess("${pageContext.request.contextPath}/meetingMgt/internalAudit/meetInternalInspectList.do?id=${param.appId}&status=0");
					}else{
						saveFailure();
					}
		        } else {
		        	saveFailure();
		        }
				
			}
			
			vm.backToList = function(){//返回
				$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/internalAudit/meetInternalInspectList.do?id=${param.appId}&status=0');
			}
			
			ko.applyBindings(vm);
			
			function bindDataToVM(){
				/* vm.auditorName = "${sessionScope.loginUser.userName}";
				vm.auditorId = "${sessionScope.loginUser.userId}";
				vm.auditorAlias = "${sessionScope.loginUser.userAlias}"; */
				vm.status = 1;
			}
			
			var items = loadData("${pageContext.request.contextPath}/meeting/meetingIa/inspection/item/getItemsByInspectionIdData.do",{ "id" : "${param.id}" });
			if(items.length > 0){
				var html = '';
				for(var i=0;i<items.length;i++){
					radioRowNum++;
					var radioName = "result"+radioRowNum;	
					var num0='',num1='',num2 = '',num3 ='';
					if(items[i]['result']=="0"){
						num0 = "checked=true";
					}else if(items[i]['result']=="1"){
						num1 = "checked=true";
					}else if(items[i]['result']=="2"){
						num2 = "checked=true";
					}else{
						num3 = "checked=true";
					}
					html += '<tr>'
						+'<td><input type="text" data-id="'+items[i]['id']+'" value="'+items[i]['element']+'"/></td>'
						+'<td><input type="text" value="'+items[i]['content']+'"/></td>'	
						+'<td><input type="text" value="'+items[i]['method']+'"/></td>'
						+'<td class="td-checks"><span><input type="radio" name='+radioName+' value="0" '+num0+'/></span><span><input type="radio" name='+radioName+' value="1" '+num1+'/></span><span><input type="radio" name='+radioName+' value="2" '+num2+'/></span><span class="no-border"><input type="radio" name='+radioName+' value="3" '+num3+'/></span></td>'	
						+'<td><input type="text" value="'+items[i]['explanation']+'"/></td>'
						+'<td><span class="singleModify"> <i class="fa fa-pencil-square-o" title="修改"></i></span><span class="singleClear" id="'+items[i]['id']+'"><i class="fa fa-trash-o" title="删除"></i></spam></td>'	
						+'</tr>'	
				}
				$(".handleData").append(html);
			}
			
			 //表单提交
			$(".handleData").on("click",".singleSubmit",function(){
				var inputList = $(this).parent().parent().find("input");
				var checkVal = $(this).parent().parent().find("input:checked").val();
				console.log(checkVal);
				var num = 0;
				$(this).parent().parent().find("input").each(function(index,data){
					if(!this["value"]){
						num++;
						$(this).addClass("error");
					}
				})
				
				if ( num == 0 && checkVal ) {
					
					
				    var itemData = loadData("${pageContext.request.contextPath}/meeting/meetingIa/inspection/item/loadItemData.do",{ "id" : inputList[0].dataset.id });			    
					var vm = ko.mapping.fromJS(itemData);
					vm.element=inputList[0]["value"];
					vm.content=inputList[1]["value"];
					vm.method = inputList[2]['value'];
					vm.explanation = inputList[7]['value'];
					vm.result = checkVal;
					/* vm.result = 1; */
					vm.meetingIaInspectionId = data.id;
					vm.meetingAppId = data.meetingAppId;
			    	if (saveData("${pageContext.request.contextPath}/meeting/meetingIa/inspection/item/saveItemData.do", vm)) {
			    		$(this).siblings('span').attr('id',itemData.id);
			    		$(this).parent().parent().children().eq(0).children().attr('data-id',itemData.id);
					} else {
						saveFailure();
					}   
				} else {
					saveFailure();
				}
				
				
			});
			 
			//表单提交删除
			$(".handleData").on("click",".singleClear",function(){
				var id = $(this).attr('id');
				if(id != null && id != "" && id != "undefined"){
					$.ajax({
						url:'${pageContext.request.contextPath}/meeting/meetingIa/inspection/item/removeItemData.do',
						type:'post',
						datatype:'json',
						data:{'id':id},
						success:function(){
							//$(".handleData").remove($(this).parent().parent());
						}
					})
				}
			}) 
					
		})			
		
	</script>
</body>
</html>