<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>鉴定过程</title>
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
 	
 	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
    <div class="form-module">
	    <div class="form-module-title">
	        <p>鉴定分配</p>
	    </div>
	    <div class="form-content">
	        <form class="form-horizontal">
	            <div class="form-group">
	                <label class="col-sm-2 control-label">分配人：</label>
	                <div class="col-sm-4" data-bind="with: appraisalVM">
	                    <input type="text" data-bind = "value:assignerAlias" class="form-control" />
	                </div>
	                <label class="col-sm-2 control-label">分配时间：</label>
	                <div class="col-sm-4"  data-bind="with: appraisalVM">
	                    <input type="text" data-bind = "value:allocationDate" class="form-control" />
	                </div>
	            </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label">鉴定师：</label>
	                <div class="col-sm-4" data-bind="with: appraisalVM">
	                    <input type="text" data-bind = "value:appraiserAlias" class="form-control" />
	                </div>
	            </div>
	            <!-- <div class="form-group">
	                <label class="col-sm-2 control-label">预计开始时间：</label>
	                <div class="col-sm-4" data-bind="with: appraisalVM">
	                    <input type="text" data-bind = "value:planedStartDate" class="form-control" />
	                </div>
	                <label class="col-sm-2 control-label">截至时间：</label>
	                <div class="col-sm-4" data-bind="with: appraisalVM">
	                    <input type="text" data-bind = "value:planedEndDate" class="form-control" />
	                </div>
	            </div> -->
	        </form>
	    </div>
	</div>
	<div class="form-module">
	    <div class="form-module-title">
	        <p>检材领用</p>
	    </div>
	    <div class="form-content">
	        <form class="form-horizontal">
	            <div class="form-group">
	                <label class="col-sm-2 control-label">领用人：</label>
	                <div class="col-sm-4" data-bind="with: appraisalVM">
	                    <input type="text" data-bind = "value:collectorAlias" class="form-control" />
	                </div>
	                
	                <label class="col-sm-2 control-label">领用时间：</label>
	                <div class="col-sm-4" data-bind="with: intoWarehouseVM">
	                    <input type="text" data-bind = "value:createdDate"  class="form-control" />
	                </div>
	            </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label">领材拍照：</label>
	                <div class="col-sm-10">
	                    <div class="img-upload">
	                        <%-- <div class="big-img into-big-img">
	                            <img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/deviceMgt/111.png" />
	                        </div> --%>
	                        <ul class="img-list into-img-list">
	                            <%-- <li><span><img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/deviceMgt/111.png" /></span></li>
	                            <li><span><img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/deviceMgt/222.png" /></span></li> --%>
	                        </ul>
	                    </div>
	                </div>
	            </div>
	            <!--  <div class="form-group">
	                <label class="col-sm-2 control-label">领材视频文件：</label>
	                <div class="col-sm-10">
	                    <div class="document-content into-video-list">
	                    </div>
	                </div>
	            </div> -->
	        </form>
	    </div>
	</div>
	<div class="form-module">
	    <div class="form-module-title">
	        <p>设备使用情况</p>
	    </div>
	    <div class="form-content">
	            <form class="form-horizontal">
	                <div class="form-group">
	                    <label class="col-sm-2 control-label">检材编号：</label>
	                    <div class="col-sm-4" data-bind="with: appraisalVM">
	                        <input type="text" data-bind="value: evidSn" name="evidSn" id="evidSn" placeholder="" class="form-control" readonly/>
	                    </div>
	                </div>
	                <div class="form-group" style="display:none;">
	                    <label class="col-sm-2 control-label"></label>
	                    <div class="col-sm-10">
	                        <button type="button" class="btn btn-color1 add-device-btn"><i class="fa fa-plus"></i>添加设备</button>
	                    </div>
	                </div>

	            </form>
	        </div>
	</div>
	<div class="form-module">
	    <div class="form-module-title">
	        <p>鉴定原始记录</p>
	    </div>
	    <div class="form-content">
	        <form class="form-horizontal">
	            <div class="form-group">
	                <label class="col-sm-2 control-label">鉴定视频：</label>
	                <div class="col-sm-10">
	                    <div class="form-control video-content">
	                    	<a class="video-btn video-view" href="${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/videoPlaybackPage.do" target="_blank"><i class="fa fa-play-circle-o"></i></a>
	                    </div>
	                </div>
	            </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">案件编号：</label>
                    <div class="col-sm-4" data-bind="with: appraisalVM">
                        <input type="text" data-bind="value: caseSn" name="caseSn" id="caseSn" placeholder="" class="form-control" readonly/>
                    </div>
                    <label class="col-sm-2 control-label">检材编号：</label>
                    <div class="col-sm-4" data-bind="with: appraisalVM">
                        <input type="text" data-bind="value: evidSn" name="evidSn" id="evidSn" placeholder="" class="form-control" readonly/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">检验地点：</label>
                    <div class="col-sm-10" data-bind="with: appraisalVM">
                        <input type="text" data-bind="value: location" name="location" id="location" placeholder="" class="form-control" readonly/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">开始时间：</label>
					<div class="col-sm-4" data-bind="with: appraisalVM">
	                	<input  id="appraisedStartDate"
	                			name="appraisedStartDate"
								class="form-control startDate"
								data-bind="dateTimePicker:appraisedStartDate" readonly/>
					</div>
                    <label class="col-sm-2 control-label">结束时间：</label>
					<div class="col-sm-4" data-bind="with: appraisalVM">
	                	<input  id="appraisedEndDate"
	                			name="appraisedEndDate"
								class="form-control startDate"
								data-bind="dateTimePicker:appraisedEndDate" readonly/>
					</div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">检验过程：</label>
                    <div class="col-sm-10" data-bind="with: appraisalVM">
                        <textarea rows="8" data-bind="value: process" name="process" id="process" cols="" class="form-control" readonly></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">杀毒结果：</label>
                    <div class="col-sm-10" data-bind="with: appraisalVM">
                        <textarea rows="8" data-bind="value: antivirusResult" name="antivirusResult" id="antivirusResult" cols="" class="form-control" readonly></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">检验结果：</label>
                    <div class="col-sm-10" data-bind="with: appraisalVM">
                        <textarea data-bind="value: appraisalResult" name="appraisalResult" id="appraisalResult" rows="8" cols="" class="form-control" readonly></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">备注：</label>
                    <div class="col-sm-10" data-bind="with: appraisalVM">
                        <textarea data-bind="value: remarks" name="remarks" id="remarks" rows="8" cols="" class="form-control" readonly></textarea>
                    </div>
                </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label">附件：</label>
	                <div class="col-sm-10">
	                	<div class="document-content">
	                        <div class="document-style pic-record"><span>《检验鉴定照片记录表》</span></div>
	                        <div class="document-style extract-list"> <span>《提取电子证据清单》</span></div>
	                    </div>
	                </div>
	            </div>
	        </form>
	    </div>
	</div>
	<div class="form-module">
	    <div class="form-module-title">
	        <p>检材归还</p>
	    </div>
	    <div class="form-content">
	        <form class="form-horizontal">
	            <div class="form-group">
	                <label class="col-sm-2 control-label">归还人：</label>
	                <div class="col-sm-4" data-bind="with: appraisalVM">
	                    <input type="text" data-bind = "value:returnerAlias" class="form-control" />
	                </div>
	                <label class="col-sm-2 control-label">归还时间：</label>
	                <div class="col-sm-4"  data-bind="with: outWarehouseVM">
	                    <input type="text" data-bind = "value:createdDate" class="form-control" />
	                </div>
	            </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label">归还拍照：</label>
	                <div class="col-sm-10">
	                    <div class="img-upload">
	                        <%-- <div class="big-img out-big-img">
	                            <img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/deviceMgt/111.png" />
	                        </div> --%>
	                        <ul class="img-list out-img-list">
	                          <%--   <li><span><img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/deviceMgt/111.png" /></span></li>
	                            <li><span><img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/deviceMgt/222.png" /></span></li> --%>
	                        </ul>
	                    </div>
	                </div>
	            </div>
	           <!--  <div class="form-group">
	                <label class="col-sm-2 control-label">归还视频文件：</label>
	                <div class="col-sm-10">
	                    <div class="document-content out-video-list">
	                    </div>
	                </div>
	            </div> -->
	        </form>
	    </div>
	</div>
	<div class="form-module">
	    <div class="form-module-title">
	        <p>文书整理</p>
	    </div>
	    <div class="form-content">
	        <form class="form-horizontal">
	            <div class="form-group">
	                <label class="col-sm-2 control-label">文书列表：</label>
	                <div class="col-sm-10">
	                    <div class="document-content">
	                        <div class="document-style document0" style="display:none"><span><a class="downFile" id="0">鉴定委托书</a></span></div>
	                        <div class="document-style document1" style="display:none"><span><a class="downFile" id="1">鉴定事项确认书</a></span></div>
	                        <div class="document-style document2" style="display:none"><span><a class="downFile" id="2">物证鉴定档案封面</a></span></div>
	                        <div class="document-style document3" style="display:none"><span><a class="downFile" id="3">鉴定文书档案目录</a></span></div>
	                        <div class="document-style document4" style="display:none"><span><a class="downFile" id="4">电子物证检验原始记录</a></span></div>
	                        <div class="document-style document5" style="display:none"><span><a class="downFile" id="5">鉴定文书</a></span></div>
	                        <div class="document-style document6" style="display:none"><span><a class="downFile" id="6">检验鉴定照片记录表</a></span></div>
	                        <div class="document-style document7" style="display:none"><span><a class="downFile" id="7">提取电子证据清单</a></span></div>
	                        <div class="document-style document8" style="display:none"><span><a class="downFile" id="8">鉴定文书审批表</a></span></div>
	                        <div class="document-style document9" style="display:none"><span><a class="downFile" id="9">不受理鉴定委托告知书</a></span></div>
	                        <div class="document-style document10" style="display:none"><span><a class="downFile" id="10">中止鉴定告知书</a></span></div>
	                        <div class="document-style document11" style="display:none"><span><a class="downFile" id="11">鉴定文书修改审批表</a></span></div>
	                        <div class="document-style document12" style="display:none"><span><a class="downFile" id="12">检材流转记录表</a></span></div>
	                    </div>
	                </div>
	            </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label">审批意见：</label>
	                <div class="col-sm-10" data-bind="with: appraisalVM">
	                    <textarea rows="8" cols="" class="form-control" data-bind="value: approverOpinion"></textarea>
	                </div>
	            </div>
	        </form>
	    </div>
	</div>
	<div class="modal bs-example-modal-lg" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  	<div class="modal-dialog modal-lg" role="document">
		    <div class="modal-content">
		      	<div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="myModalLabel">提取电子证据清单</h4>
		      	</div>
		      	<div class="modal-body">
		        	<div class="form-content">
			            <form class="form-horizontal">
			                <div class="form-group">
			                    <label class="col-sm-2 control-label">案由：</label>
			                    <div class="col-sm-10" data-bind="with: extractedVM">
			                        <input type="text" id="case" data-bind="value: cause" class="form-control" readonly/>
			                    </div>
		                    </div>
		                    <div class="form-group">
			                    <label class="col-sm-2 control-label">提取时间：</label>
			                    <div class="col-sm-10" data-bind="with: extractedVM">
			                        <input id="extractedDate" data-bind="dateTimePicker:extractedDate" class="form-control" readonly/>
			                    </div>
			                </div>
			            </form>
			        </div>
			        <div class="file-upload extractedDataItem">
				        <table class="table table-bordered table-sorting">
				            <thead>
				                <tr>
				                    <th>序号</th>
				                    <th>数据</th>
				                    <th>来源</th>
				                    <th>说明</th>
				                </tr>
				            </thead>
				            <tbody>
				            </tbody>
				            <tfoot style="display:none;">
				            	<tr>
				                    <td colspan="5" align="center">
				                        <button class="btn add-tr-btn"><i class="fa fa-plus"></i>增加</button>
				                    </td>
				                </tr>
				            </tfoot>
				        </table>
				    </div>
		      	</div>
		    </div>
	  	</div>
	</div>
	<div class="btn-content recall">
	    <!-- <button type="button" class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button> -->
		<button class="btn btn-color1 suspend-btn"><i class="fa fa-stop"></i>中止鉴定</button>
        <button class="btn btn-color1 pause-btn"><i class="fa fa-pause"></i>暂停鉴定</button>
	</div>
	
	<!-- <button data-toggle="modal" data-target=".modal-bigImg"></button> -->
	<div class="modal fade modal-bigImg" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  	<div class="modal-dialog modal-lg" role="document">
		    <div class="modal-content">
		      	<div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="myModalLabel">查看大图</h4>
		      	</div>
		      	<div class="modal-body">
		       	 	<img src="" class="bigImg" />
		      	</div>
		    </div>
	  	</div>
	</div>
	
	<script>
		$("input, textarea, select").attr("disabled",true);
		if(window.navigator.userAgent.indexOf('AppleWebKit') != -1) {
			$(".rdio-primary").addClass("rdio");
			$(".ckbox-primary").addClass("ckbox"); 
		}else{
			$(".rdio-primary").removeClass("rdio");
			$(".ckbox-primary").removeClass("ckbox");
		}
		
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
		//=====================以上内容属于前段控制
		var a = "${param.userrole}";
		if(  a != ''){
			$(".suspend-btn").hide();
			$(".pause-btn").hide();
		}
			
		
		var commonAppraisalId = "${param.commonAppraisalId}";
		var appraisalData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/loadDataById.do",{ "id" : commonAppraisalId });
		
		var videoSrc = '${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/videoPlaybackPage.do?id='+appraisalData.id;
	    $(".video-view").attr("href", videoSrc); 
	    var allocationDate = appraisalData.allocationDate;
	    var planedStartDate = appraisalData.planedStartDate;
	    var planedEndDate = appraisalData.planedEndDate;
	    var collectedDate = appraisalData.collectedDate;
	    var returnedDate = appraisalData.returnedDate;
	    
		appraisalData.allocationDate=  new Date(appraisalData.allocationDate).Format("yyyy-MM-dd hh:mm");
		appraisalData.planedStartDate=  new Date(appraisalData.planedStartDate).Format("yyyy-MM-dd hh:mm");
		appraisalData.planedEndDate=  new Date(appraisalData.planedEndDate).Format("yyyy-MM-dd hh:mm");
		appraisalData.collectedDate=  new Date(appraisalData.collectedDate).Format("yyyy-MM-dd hh:mm");
		appraisalData.returnedDate=  new Date(appraisalData.returnedDate).Format("yyyy-MM-dd hh:mm");
         
		if(appraisalData.status == 14 || appraisalData.status == 15 || appraisalData.status == 16){
			$(".recall").hide();
		}
		//鉴定文书显示
		var docData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/AppraisalDoc/getListData.do",{ "appraisalId" : appraisalData.id });
		if(docData.length > 0){
			for(var i = 0 ; i < docData.length ; i++){
				$('.document'+docData[i].type+'').show();
			}
		}
		
		
		var appraisalDataVM = ko.mapping.fromJS(appraisalData);
	
		var appraisedDevData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisedDev/loadappraisedByappraisalId.do", {"id": commonAppraisalId});  //电子物证（检材）鉴定设备
		var appraisedDevDataVM = ko.mapping.fromJS(appraisedDevData);
		
		for(var i = 0 ; i < appraisedDevData.length ; i++){
			var deviceDateSource = loadData("${ pageContext.request.contextPath }/deviceMgt/device/loadDeviceData.do", { "id" : appraisedDevData[i].deviceId });
			var deviceHtml = "";
			deviceHtml += '<div class="add-device-content">';
			deviceHtml += '<div class="form-group">';
			deviceHtml += '<label class="col-sm-2 control-label">设备识别号：</label>';
			deviceHtml += '<div class="col-sm-4"><input class="form-control" value="'+deviceDateSource.identifier+'" readonly/></div>';
			deviceHtml += '<label class="col-sm-2 control-label">设备名称：</label>';
			deviceHtml += '<div class="col-sm-4"><input type="text" placeholder="请选择设备" class="form-control" value="'+deviceDateSource.name+'" readonly/></div>';
			deviceHtml += '</div>';
			deviceHtml += '<div class="form-group">';
			deviceHtml += '<label class="col-sm-2 control-label">设备状况：</label>';
			deviceHtml += '<div class="col-sm-4"><select class="form-control" disabled><option value="0">正常</option><option value="2">维修</option><option value="3">报废</option></select></div>';
			deviceHtml += '<label class="col-sm-2 control-label">开始时间：</label>';
			deviceHtml += '<div class="col-sm-4" ><input class="form-control" value="'+new Date(appraisedDevData[i].startDate).Format("yyyy-MM-dd hh:mm")+'" readonly/></div>';
			deviceHtml += '</div>';
			deviceHtml += '<div class="form-group">';
			deviceHtml += '<label class="col-sm-2 control-label">备注：</label>';
			deviceHtml += '<div class="col-sm-10"><textarea rows="8" cols="" class="form-control " readonly>'+appraisedDevData[i].remarks+'</textarea></div>';
			deviceHtml += '</div>';
			deviceHtml += '</div>';
			$(".add-device-btn").parents(".form-group").before(deviceHtml);
		}
		var extractedData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/ExtractedData/loadExtractedDataByappraisalId.do", {"id":commonAppraisalId});  //提取证据清单
		var extractedDataItemData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/ExtractedDataItem/loadExtractedDataItemList.do", {"id":extractedData.id});  //提取证据清单
		
		var extractedDataVM = ko.mapping.fromJS(extractedData);
		var extractedDataItemDataVM = ko.mapping.fromJS(extractedDataItemData);
		
		var appraisalHistoryData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisalHistory/loadAppraisalHistoryData.do", { "id" : "" });
		var appraisalHistoryDataVM = ko.mapping.fromJS(appraisalHistoryData);
		
		var evidTransitionData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/evidTransition/loadDataById.do", { "id" : "" });  //电子物证交接申请空对象
		var evidTransitionDataVM = ko.mapping.fromJS(evidTransitionData);
		 
		var intoWarehouseData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/evidOpLog/getDataByEvidIdAndType.do", { "evidId" : appraisalData.evidId,"type":"1" });
		intoWarehouseData.createdDate = new Date(intoWarehouseData.createdDate).Format("yyyy-MM-dd hh:mm")
		var intoWarehouseDataVM = ko.mapping.fromJS(intoWarehouseData);
		var intoEvidOpLogAttData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/evidOpLogAtt/loadDataByEvidOpLogId.do", { "evidOpLogId" : intoWarehouseData.id });
		setIntoWarehouseImage(intoEvidOpLogAttData);
		
		var outWarehouseData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/evidOpLog/getDataByEvidIdAndType.do", { "evidId" : appraisalData.evidId,"type":"0" });
		outWarehouseData.createdDate = new Date(outWarehouseData.createdDate).Format("yyyy-MM-dd hh:mm");
		var outWarehouseDataVM = ko.mapping.fromJS(outWarehouseData);
		var outEvidOpLogAttData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/evidOpLogAtt/loadDataByEvidOpLogId.do", { "evidOpLogId" : outWarehouseData.id });
		setOutWarehouseImage(outEvidOpLogAttData);
		
		
		$(".downFile").click(function(){
			var type = $(this).attr("id");
			window.location.href = "${ pageContext.request.contextPath }/elecEVIDMgt/AppraisalDoc/downAppraisalDocData.do?type="+type+"&appraisalId="+appraisalData.id;
		})

		$(".pic-record").click(function(){
			window.location.href = "${ pageContext.request.contextPath }/elecEVIDMgt/AppraisalDoc/downAppraisalDocData.do?type=6&appraisalId="+appraisalData.id;
		})
		
		$(".extract-list").click(function(){
			window.location.href = "${ pageContext.request.contextPath }/elecEVIDMgt/AppraisalDoc/downAppraisalDocData.do?type=7&appraisalId="+appraisalData.id;
		})
		
		
		for(var i = 0 ; i < extractedDataItemData.length ; i++){
			var trHtml="";
            trHtml += '<tr>';
            trHtml += '<td></td>';
            trHtml += '<td><input type="text" /></td>';
            trHtml += '<td><input type="text" value="'+extractedDataItemData[i].data+'"/></td>';
            trHtml += '<td><input type="text" value="'+extractedDataItemData[i].src+'"/></td>';
            trHtml += '</tr>';
            $(".table-sorting .add-tr-btn").parents("tfoot").siblings("tbody").append(trHtml);
            sorting();	
		}

		
		function sorting(){
			$(".table-sorting tbody tr").each(function(){
				var index = $(this).index();
				var num = index+1;
				$(this).find("td").eq(0).text(num);
			});
		}
        var vm = {
       		appraisalVM : appraisalDataVM,
   			appraisedDevVM : appraisedDevDataVM,
       		extractedVM : extractedDataVM,
       		extractedDataItemVM : extractedDataItemDataVM,
       		appraisalHistoryVM  : appraisalHistoryDataVM,
       		evidTransitionVM : evidTransitionDataVM,
       		intoWarehouseVM : intoWarehouseDataVM,
       		outWarehouseVM : outWarehouseDataVM
		}

		ko.applyBindings(vm);
        
        //中止按钮
    	$(".suspend-btn").click(function(){
	    	var url = "${pageContext.request.contextPath}/elecEVIDMgt/generalMessage/suspendForm.do?preappraisalId="+appraisalData.preappraisalId+"&appraisalId="+appraisalData.id;
	    	$(".index-iframe", window.parent.parent.document).attr("src",url);
	    });
        
        //暂停按钮
        $(".pause-btn").click(function(){
			$(".btn-color1").attr({"disabled":"disabled"});
			var del = confirm("确定要暂停鉴定吗？");
			if(del){
				//取消所有未完成的交接申请
				saveData("${pageContext.request.contextPath}/elecEVIDMgt/evidTransition/cancelDataByAppraisalId.do?appraisalId="+appraisalData.id,{} );

				//状态是6或则10 就清除数据  然后复制内容
				if(appraisalData.status == 6 || appraisalData.status == 10 || appraisalData.status == 11 || appraisalData.status == 12 || appraisalData.status == 13){
					appraisalHistoryDataVM.preappraisalId = appraisalDataVM.preappraisalId;
					appraisalHistoryDataVM.evidId = appraisalDataVM.evidId;
					appraisalHistoryDataVM.returnTransitionId = appraisalDataVM.returnTransitionId;
					appraisalHistoryDataVM.collTransitionId = appraisalDataVM.collTransitionId;
					if(saveData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisalHistory/saveAppraisalHistoryData.do?appraisalId="+appraisalData.id, appraisalHistoryDataVM)){
	        			saveSuccess("${pageContext.request.contextPath}/elecEVIDMgt/authenticate/analysis/appraisalProcessAllot.do");
					}
				}else if(appraisalData.status == 7 || appraisalData.status == 8 || appraisalData.status == 9){
					returnerTransitionDataInit();
					
					appraisalDataVM.allocationDate= allocationDate;
					appraisalDataVM.planedStartDate=  planedStartDate;
					appraisalDataVM.planedEndDate=  planedEndDate;
					appraisalDataVM.collectedDate=  collectedDate;
					appraisalDataVM.returnedDate= returnedDate;
					
					appraisalDataVM.status = 16;
					if(saveData("${ pageContext.request.contextPath }/elecEVIDMgt/evidTransition/saveData.do", evidTransitionDataVM)){
						if(saveData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/saveData.do", appraisalDataVM)){
							//需要生成原始记录表单
		        			saveSuccess("${pageContext.request.contextPath}/elecEVIDMgt/authenticate/analysis/appraisalProcessAllot.do");
						}
					}
				}
				
			}
			$(".btn-color1").attr({"disabled":false});
	    });
        
        
      //====================	检材归还 开始  ====================  //
        var userId = "${sessionScope.loginUser.userId}";
        var userName = "${sessionScope.loginUser.userName}";
        var userAlias = "${sessionScope.loginUser.userAlias}";
		function returnerTransitionDataInit(){ //交接申请赋值
			evidTransitionDataVM.evidName = appraisalData.evidName;
			evidTransitionDataVM.evidSn = appraisalData.evidSn;
			evidTransitionDataVM.caseName = appraisalData.caseName;
			evidTransitionDataVM.caseSn = appraisalData.caseSn;
			evidTransitionDataVM.type = 1;
			evidTransitionDataVM.status = 0;
			evidTransitionDataVM.applicantId = userId;
			evidTransitionDataVM.applicantName = userName;
			evidTransitionDataVM.applicantAlias = userAlias;
			evidTransitionDataVM.evidId = appraisalData.evidId;
			evidTransitionDataVM.preappraisalId = appraisalData.preappraisalId;
			evidTransitionDataVM.appraisalId = appraisalData.id;
		}
		//====================	检材归还 结束  ====================  //
		
		
	   function setIntoWarehouseImage(attData){
		   var imageExt = ["jpg", "jpeg", "png", "bmp"];
			var videoExt = ["mov", "avi", "mp4", "wmv"];
			if( attData.length > 0){
 				var imageHtml='';
				var vodeoHtml = '';
				var imageNum = null;
				for( var i=0 ; i < attData.length ; i++){
					if($.inArray(attData[i].ext,imageExt)== -1){
						// 视频
 						vodeoHtml += '<div class="document-style"><span><a href="${pageContext.request.contextPath}/elecMgt/evidOpLogAtt/downLoadAttById.do?id='+attData[i].id+'">'+attData[i].name+'</a></span></div>';
					}
					if($.inArray(attData[i].ext,videoExt)== -1){
						if(imageNum == null){
							imageNum = i;
						}
						// 图片
						imageHtml += '<li><span><img data-toggle="modal" data-target=".modal-bigImg" src="${pageContext.request.contextPath}/elecEVIDMgt/evidOpLogAtt/loadImageData.do?id='+attData[i].id+'" /></span></li>';
					}
				}
				$(".into-img-list").append(imageHtml);
				$(".into-video-list").append(vodeoHtml);
				/* if(imageNum != null){
				 $(".into-big-img").append('<li><span><img src="${pageContext.request.contextPath}/elecEVIDMgt/evidOpLogAtt/loadImageData.do?id='+attData[0].id+'" /></span></li>');
				} */
			}
		}
		
		function setOutWarehouseImage(attData){
			var imageExt = ["jpg", "jpeg", "png", "bmp"];
			var videoExt = ["mov", "avi", "mp4", "wmv"];
			if( attData.length > 0){
				var imageHtml='';
				var vodeoHtml = '';
				var imageNum = null;
				for( var i=0 ; i < attData.length ; i++){
					if($.inArray(attData[i].ext,imageExt)== -1){
						// 视频
							vodeoHtml += '<div class="document-style"><span><a href="${pageContext.request.contextPath}/elecMgt/evidOpLogAtt/downLoadAttById.do?id='+attData[i].id+'">'+attData[i].name+'</a></span></div>';
					}
					if($.inArray(attData[i].ext,videoExt)== -1){
						if(imageNum == null){
							imageNum = i;
						}
						// 图片
						imageHtml += '<li><span><img data-toggle="modal" data-target=".modal-bigImg" src="${pageContext.request.contextPath}/elecEVIDMgt/evidOpLogAtt/loadImageData.do?id='+attData[i].id+'" /></span></li>';
					}
				}
				$(".out-img-list").append(imageHtml);
				$(".out-video-list").append(vodeoHtml);
				/* if(imageNum != null){
				  $(".out-big-img").append('<li><span><img src="${pageContext.request.contextPath}/elecEVIDMgt/evidOpLogAtt/loadImageData.do?id='+attData[0].id+'" /></span></li>');
				} */
			}
		} 
		
		/*查看图片--开始*/
		$(".img-list").on("click", "img", function(){
	        var src = $(this).attr("src");
	        $(".modal-bigImg .bigImg").attr("src",src);
	        //$(".big-img").html("<img src='"+ src +"' />");
	        var bodyHeight = $("body").height()+30;
	        console.log(bodyHeight);
	        $(".iframe-accepted", window.parent.document).height(bodyHeight);
	    });
		/*查看图片--结束*/
	</script>
</body>
</html>