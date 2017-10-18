<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>鉴定过程修改原始记录</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bracket-common.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/toggles.min.js" />"></script>
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
	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/base.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/jquery-barcode.js" />"></script>
	<link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap.min.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />	
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>电子物证管理</a><span>></span><a>鉴定人员操作台</a><span>></span><a>修改电子证据清单</a>
        </p>
    </div>
    <div class="form-module-title">
        <p>修改电子证据清单</p>
    </div>
    <div class="form-content">
       	<div class="form-content">
            <form class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-2 control-label">案由：</label>
                    <div class="col-sm-10" data-bind="with: extractedVM">
                        <input type="text" data-bind="value: cause" id="cause" class="form-control" readonly/>
                    </div>
                   </div>
                   <div class="form-group">
                    <label class="col-sm-2 control-label">提取时间：</label>
                    <div class="col-sm-10" data-bind="with: extractedVM">
                    	<input type="text" id="entrustedDate" name="entrustedDate" class="form-control datetimepicker" data-bind="dateTimePicker: extractedDate" readonly/>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="file-upload extractedDataItem">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>序号</th>
                    <th><span class="required-fields">*</span>数据</th>
                    <th><span class="required-fields">*</span>来源</th>
                    <th><span class="required-fields">*</span>说明</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody class="table-sorting">
            </tbody>
            <tfoot>
            	<tr>
                    <td colspan="5" align="center">
                        <button class="btn add-tr-btn"><i class="fa fa-plus"></i>增加</button>
                    </td>
                </tr>
            </tfoot>
        </table>
    </div>
    <div class="btn-content">
     	<button type="button" class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
        <button type="button" class="btn btn-color1" data-bind ="click: saveData"><i class="fa fa-check"></i>确定修改</button>
   	</div>
    <jsp:include page="/common/alertMessages.jsp"></jsp:include>
	<script>
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
		
		//公用数据
		var userId = "${sessionScope.loginUser.userId}";
		var userName = "${sessionScope.loginUser.userName}";
		var userAlias = "${sessionScope.loginUser.userAlias}";
		var appraisalData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/loadDataByUserAlias.do", { "userId" : userId });
		var extractedData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/ExtractedData/loadExtractedDataByappraisalId.do", { "id" : appraisalData.id });
		var extractedDataItemList = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/ExtractedDataItem/loadExtractedDataItemList.do", {"id":extractedData.id});  //提取证据清单
		var extractedDataItemData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/ExtractedDataItem/loadExtractedDataItem.do", {"id":""});  //提取证据清单
		var appraisalDataVM = ko.mapping.fromJS(appraisalData);
		var extractedDataVM = ko.mapping.fromJS(extractedData);
		var extractedDataItemDataVM = ko.mapping.fromJS(extractedDataItemData);
		
		//初始化对象
		checkBox();
	    function checkBox(){
	    	if(extractedData.cause == null || extractedData.cause == "" || extractedData.cause == undefined){
	    		extractedDataVM.cause = appraisalData.orgName + appraisalData.caseName;
	    		extractedDataVM.extractedDate = new Date();
	    	}
	    }
		
	    //初始化
	    for(var i = 0 ; i < extractedDataItemList.length ; i++){
			var trHtml="";
            trHtml += '<tr>';
            trHtml += '<td></td>';
            trHtml += '<td><input type="text" value="'+extractedDataItemList[i].data+'" required /></td>';
            trHtml += '<td><input type="text" value="'+extractedDataItemList[i].src+'" required /></td>';
            trHtml += '<td><input type="text" value="'+extractedDataItemList[i].explanation+'" required /></td>';
            trHtml += '<td><a class="delete-btn" title="删除"><i class="fa fa-times"></i></a></td>';
            trHtml += '</tr>';
            $(".add-tr-btn").parents("tfoot").siblings("tbody").append(trHtml);
            sorting();
	    }
		
	    //新增
		$(".add-tr-btn").click(function(){
			var trHtml="";
            trHtml += '<tr>';
            trHtml += '<td></td>';
            trHtml += '<td><input type="text" required /></td>';
            trHtml += '<td><input type="text" required /></td>';
            trHtml += '<td><input type="text" required /></td>';
            trHtml += '<td><a class="delete-btn" title="删除"><i class="fa fa-times"></i></a></td>';
            trHtml += '</tr>';
            $(this).parents("tfoot").siblings("tbody").append(trHtml);
            
            sorting();
		});
		
		//排序
		$(".table-sorting").on("click", ".delete-btn", function(){
			$(this).parent("td").parent("tr").remove();
			sorting();
		});
		//排序
		function sorting(){
			$(".table tbody tr").each(function(){
				var index = $(this).index();
				var num = index+1;
				$(this).find("td").eq(0).text(num);
			});
		}
		
        var vm = {
       		appraisalVM : appraisalDataVM,
       		extractedVM : extractedDataVM,
       		extractedDataItemVM : extractedDataItemDataVM,
		}
		
		
        vm.saveData = function(){
        	if( $(".table tbody tr").size() > 0 ){
        		$("button").attr("disabled", true);
    			if(validateSubmittedData()){
    				extractedDataVM.preappraisalId = appraisalDataVM.preappraisalId;
        			extractedDataVM.appraisalId = appraisalDataVM.id;
        			extractedDataVM.extractedDate = new Date();
        			extractedDataVM.cause = appraisalData.orgName + appraisalData.caseName;
        			if(saveData("${ pageContext.request.contextPath }/elecEVIDMgt/ExtractedData/saveExtractedData.do", extractedDataVM)){
	        			for(var i = 0 ; i < $(".extractedDataItem tbody tr").length ; i++){
	        				var text1 = $(".extractedDataItem tbody tr").eq(i).find("td").eq(1).find("input").val();
	        				var text2 = $(".extractedDataItem tbody tr").eq(i).find("td").eq(2).find("input").val();
	        				var text3 = $(".extractedDataItem tbody tr").eq(i).find("td").eq(3).find("input").val();
	        				extractedDataItemDataVM.data = text1;
	        				extractedDataItemDataVM.src = text2;
	        				extractedDataItemDataVM.explanation = text3;
	        				extractedDataItemDataVM.extractedDataId = extractedDataVM.id;
	        				saveData("${ pageContext.request.contextPath }/elecEVIDMgt/ExtractedDataItem/saveExtractedDataItem.do", extractedDataItemDataVM)
	        			}
         				//保存电子证据清单Word文档
	    				saveData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/saveExtractListWord.do", extractedDataVM)
        			}
        			saveSuccess("${pageContext.request.contextPath}/elecEVIDMgt/authenticate/analysis/appraisalProcessAllot.do");
//         			window.parent.location.href = "${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/videoPlayback.do"; 
    			}else{
    				saveFailure();
    			}
        	}else{
        		saveFailure("没新增内容无法提交！");
        	}
		}
		
		ko.applyBindings(vm);
		
		
		
		
		//返回按钮
		$(".back-btn").click(function(){
			//window.parent.location.href = "${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/videoPlayback.do"; 
			
			var url = "${ pageContext.request.contextPath }/elecEVIDMgt/authenticate/analysis/appraisalProcessAllot.do";
			$(".index-iframe", window.parent.document).attr("src",url);
		})
		
	
	</script>
</body>
</html>