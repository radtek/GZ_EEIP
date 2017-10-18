<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>检材审核</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bracket-common.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/toggles.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
	<script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/ajaxfileupload.js" />"></script>
  	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
    <div class="form-module">
	    <div class="form-module-title">
	        <p>检材审核</p>
	    </div>
	    <div class="form-content">
	        <form class="form-horizontal">
	            <div class="form-group">
	                <label class="col-sm-2 control-label">鉴定事项：</label>
	                <div class="col-sm-10">
	                    <div class="matter-content">
	                        <div class="matter-module">
	                            <div class="matter-module-title">1.委托项目选择：</div>
	                            <div class="matter-module-option">
	                                <div class="col-sm-4">
	                                    <div class="ckbox ckbox-primary">
	                                        <input type="checkbox" class="scope0" id="checkbox1" />
	                                        <label for="checkbox1">提取固定电子数据</label>
	                                    </div>
	                                </div>
	                                <div class="col-sm-4">
	                                    <div class="ckbox ckbox-primary">
	                                        <input type="checkbox" class="scope1" id="checkbox2" />
	                                        <label for="checkbox2">恢复电子数据</label>
	                                    </div>
	                                </div>
	                                <div class="col-sm-4">
	                                    <div class="ckbox ckbox-primary">
	                                        <input type="checkbox" class="scope2" id="checkbox3" />
	                                        <label for="checkbox3">检验程序功能</label>
	                                    </div>
	                                </div>
	                                <div class="col-sm-4">
	                                    <div class="ckbox ckbox-primary">
	                                        <input type="checkbox" class="scope3" id="checkbox4" />
	                                        <label for="checkbox4">破解电子数据密码</label>
	                                    </div>
	                                </div>
	                                <div class="col-sm-4">
	                                    <div class="ckbox ckbox-primary">
	                                        <input type="checkbox" class="scope4" id="checkbox5" />
	                                        <label for="checkbox5">分析电子数据</label>
	                                    </div>
	                                </div>
	                                <div class="col-sm-4">
	                                    <div class="ckbox ckbox-primary">
	                                        <input type="checkbox" class="scope5" id="checkbox6" />
	                                        <label for="checkbox6">销毁电子数据</label>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                        <div class="matter-module">
	                            <div class="matter-module-title">2.方法选择选择：</div>
	                            <div class="matter-module-option">
	                                <div class="col-sm-12">
	                                    <div class="ckbox ckbox-primary">
	                                        <input type="checkbox" class="method0" id="checkbox7" />
	                                        <label for="checkbox7">《数字化设备证据数据发现提取固定方法》GA/T756-2008</label>
	                                    </div>
	                                </div>
	                                <div class="col-sm-12">
	                                    <div class="ckbox ckbox-primary">
	                                        <input type="checkbox" class="method1" id="checkbox8" />
	                                        <label for="checkbox8">《电子物证搜索检验技术规范》GB/T29362-2012</label>
	                                    </div>
	                                </div>
	                                <div class="col-sm-12">
	                                    <div class="ckbox ckbox-primary">
	                                        <input type="checkbox" class="method2" id="checkbox9" />
	                                        <label for="checkbox9">《电子物证恢复检验技术规范》GB/T29360-2012</label>
	                                    </div>
	                                </div>
	                                <div class="col-sm-12 other-position">
	                                    <div class="ckbox ckbox-primary">
	                                        <input type="checkbox" class="method3" id="checkbox10" />
	                                        <label for="checkbox10">其他</label>
	                                    </div>
	                                    <span data-bind="with:appraisalVm">
	                                      <input type="text" class="other-input" data-bind="value:methodOther" />  
	                                    </span>
	                                </div>
	                            </div>
	                        </div>
	                        <div class="matter-module">
	                            <div class="matter-module-title">3.结果要求：</div>
	                            <div class="matter-module-option">
	                                <div class="col-sm-4">
	                                    <div class="ckbox ckbox-primary">
	                                        <input type="checkbox" class="rqmt0" id="checkbox11" />
	                                        <label for="checkbox11">出具检验报告</label>
	                                    </div>
	                                </div>
	                                <div class="col-sm-4">
	                                    <div class="ckbox ckbox-primary">
	                                        <input type="checkbox" class="rqmt1" id="checkbox12" />
	                                        <label for="checkbox12">出具鉴定意见书</label>
	                                    </div>
	                                </div>
	                                <div class="col-sm-4">
	                                    <div class="ckbox ckbox-primary">
	                                        <input type="checkbox" class="rqmt2" id="checkbox13" />
	                                        <label for="checkbox13">只提取电子数据</label>
	                                    </div>
	                                </div>
	                                <div class="col-sm-12 other-position">
	                                    <div class="ckbox ckbox-primary">
	                                        <input type="checkbox" class="rqmt3" id="checkbox14" />
	                                        <label for="checkbox14">其他</label>
	                                    </div>
	                                    <span data-bind="with:appraisalVm">
	                                      <input type="text" class="other-input" data-bind="value:rqmtOther" />  
	                                    </span>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label">审核人：</label>
	                <div class="col-sm-4" data-bind="with:appraisalVm">
	                 <input type="text" class="form-control" data-bind="value:auditorAlias" /> 
	                </div>
	                <label class="col-sm-2 control-label">审核时间：</label>
	                <div class="col-sm-4" data-bind="with:appraisalVm">
	                    <input type="text" class="form-control" data-bind="value:auditedDate" />
	                </div>
	            </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label">审核意见：</label>
	                <div class="col-sm-10" data-bind="with:appraisalVm">
	                    <textarea rows="8" cols="" class="form-control"  data-bind="value:auditedOpinion"></textarea>
	                </div>
	            </div>
	        </form>
	    </div>
	</div>
<!-- 	<div class="btn-content">
	    <button type="button" class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
	</div> -->
	<script>
		$("input, textarea, select").attr("disabled",true);
		if(window.navigator.userAgent.indexOf('AppleWebKit') != -1) {
			$(".rdio-primary").addClass("rdio");
			$(".ckbox-primary").addClass("ckbox"); 
		}else{
			$(".rdio-primary").removeClass("rdio");
			$(".ckbox-primary").removeClass("ckbox");
		}
		
		$(function(){
			var commonAppraisalId = "${param.commonAppraisalId}";
			var appraisalData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/loadDataById.do",{ "id" : commonAppraisalId });
			appraisalData.auditedDate=  new Date(appraisalData.auditedDate).Format("yyyy-MM-dd hh:mm")
			var appraisalDataVm = ko.mapping.fromJS(appraisalData);
		  	var vm={
					appraisalVm:appraisalDataVm 
			};
		  	
		
			//项目委托方法的复选
			if(appraisalData.scope != "" && appraisalData.scope != undefined && appraisalData.scope != null){
				var scopeData = appraisalData.scope.split(",");
				for(var i = 0 ; i < scopeData.length ; i++){
					var check = ".scope" +scopeData[i];
					$(check).attr('checked', true)
				}
			}
			//鉴定方法的复选
			if(appraisalData.method != "" && appraisalData.method != undefined && appraisalData.method != null){
				var methodData = appraisalData.method.split(",");
				for(var i = 0 ; i < methodData.length ; i++){
					var check = ".method" + methodData[i];
					$(check).attr('checked', true)
				}
				if(appraisalData.methodOther != null && appraisalData.methodOther != "" && appraisalData.methodOther != undefined){
					$(".method3").attr('checked', true)
				}
			}
			//结果要求的复选
			if(appraisalData.rqmt != "" && appraisalData.rqmt != undefined && appraisalData.rqmt != null){
				var rqmtData = appraisalData.rqmt.split(",");
				for(var i = 0 ; i < rqmtData.length ; i++){
					var check = ".rqmt" +rqmtData[i];
					$(check).attr('checked', true)
				}
				if(appraisalData.rqmtOther != null && appraisalData.rqmtOther != "" && appraisalData.rqmtOther != undefined){
					$(".rqmt3").attr('checked', true)
				}
			}
			
		  	
			ko.applyBindings(vm); 
		});
	</script>
</body>
</html>

