<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>鉴定过程待分配，已分配</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Cache-Control" content="no-cache, must-revalidate" />
	<meta http-equiv="Expires" content="0" />
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
    <link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />	
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>电子物证管理</a><span>></span><a>鉴定人员操作台</a><span>></span><a>检材鉴定分析</a>
        </p>
    </div>
    <jsp:include page="/common/tabsContent.jsp"></jsp:include>
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
    	<div class="form-module styleHint">
	        <div class="form-module-title">
	            <p>系统提示</p>
	        </div>
	        <div class="system-hint">暂无鉴定任务！</div>
	    </div>
	    
	    <div class="form-module collector">
	        <div class="form-module-title">
	            <p>检材领用</p>
	        </div>
	        <div class="form-content">
	            <form class="form-horizontal">
	                <div class="form-group">
	                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>领用人：</label>
	                    <div class="col-sm-4" data-bind="with: appraisalVM">
	                        <input type="text" data-bind="value: collectorAlias" name="collectorAlias" id="collectorAlias" class="form-control" readonly required />
	                    </div>
	                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>领用时间：</label>
						<div class="col-sm-4" data-bind="with: appraisalVM">
		                	<input id="entrustedDate" name="entrustedDate" class="form-control datetimepicker"
									data-bind="dateTimePicker: collectedDate" readonly required />
						</div>	
	                </div>
	            </form>
	        </div>
			<div class="btn-content">
		        <button type="button" class="btn btn-color1" data-bind ="click: saveData"><i class="fa fa-check"></i>申领检材</button>
	    	</div>
	    </div>
	    
	    <div class="form-module userSituation">
	        <div class="form-module-title">
	            <p>设备使用情况</p>
	        </div>
	        <div class="form-content">
	            <form class="form-horizontal">
	                <div class="form-group">
	                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>检材编号：</label>
	                    <div class="col-sm-4" data-bind="with: devUsingSitnVM">
	                        <input type="text" data-bind="value: evidSn" name="evidSn" id="evidSn" class="form-control" readonly required />
	                    </div>
	                </div>
	                <div class="form-group">
	               	    <label class="col-sm-2 control-label"><span class="required-fields">*</span>设备名称：</label>
	               	    <div class="col-sm-4" >
							<select class="form-control deviceName changeDevice" required></select>
	                    </div> 
	                	<label class="col-sm-2 control-label"><span class="required-fields">*</span>设备识别号：</label>
	                	<div class="col-sm-4">
							<select  class="form-control device deviceSelect identify" required></select>
	                    </div> 
                   	    <input type="hidden" value="" id="getVedioPath"/>
	                </div>
	                <div class="form-group">
	                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>设备状况：</label>
	                    <div class="col-sm-4">
	                        <select class="form-control deviceStatus" required disabled>
	                        	<option value="0">正常</option>
	                        	<option value="2">维修</option>
	                        	<option value="3">报废</option>
	                        </select>
	                    </div>
	                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>开始时间：</label>
						<div class="col-sm-4" data-bind="with: devUsingSitnVM">
		                	<input id="startDate" name="startDate" class="form-control startDate datetimepicker "
									data-bind="dateTimePicker:startDate" required />
						</div>
	                </div>
	                <!-- <div class="form-group">
	                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>开始时间：</label>
						<div class="col-sm-4" data-bind="with: devUsingSitnVM">
		                	<input id="startDate" name="startDate" class="form-control startDate datetimepicker datetimepicker-before"
									data-bind="dateTimePicker:startDate" required />
						</div>
	                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>结束时间：</label>
						<div class="col-sm-4" data-bind="with: devUsingSitnVM">
		                	<input id="endDate" name="endDate" class="form-control endDate datetimepicker datetimepicker-after"
									data-bind="dateTimePicker:endDate" required />
						</div> 
	                </div>-->
	                <div class="form-group">
	                    <label class="col-sm-2 control-label">备注：</label>
	                    <div class="col-sm-10" data-bind="with: devUsingSitnVM">
	                        <textarea data-bind="value: remarks" name="remarks" id="remarks" class="form-control deviceRemarks"></textarea>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="col-sm-2 control-label"></label>
	                    <div class="col-sm-10">
	                        <button type="button" class="btn btn-color1 add-device-btn"><i class="fa fa-plus"></i>添加设备</button>
	                    </div>
	                </div>
					<div class="btn-content">
				        <button type="button" class="btn btn-color1" data-bind ="click: saveData"><i class="fa fa-check"></i>提交</button>
			    	</div>
	            </form>
	        </div>
	    </div>
	    <div class="form-module appraising">
	        <div class="form-module-title">
	            <p>鉴定原始记录</p>
	        </div>
	        <div class="form-content">
	            <form class="form-horizontal">
	            	<div class="form-group">
	                    <label class="col-sm-2 control-label">鉴定要求：</label>
	                    <div class="col-sm-10" data-bind="with: preappraisalVM">
	                        <textarea data-bind="value: rqmt" name="rqmt" id="rqmt" class="form-control" readonly></textarea>
	                    </div>
	                </div>
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
	                                <div class="matter-module-title">2.方法选择：</div>
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
	                                    <div class="col-sm-12 other-position" data-bind="with: appraisalVM">
	                                        <div class="ckbox ckbox-primary">
	                                            <input type="checkbox" class="method3" id="checkbox10" />
	                                            <label for="checkbox10">其他</label>
	                                        </div>
	                                        <input type="text" data-bind="value: methodOther" name="methodOther" id="methodOther" value="" class="other-input" readonly/>
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
	                                    <div class="col-sm-12 other-position" data-bind="with: appraisalVM">
	                                        <div class="ckbox ckbox-primary">
	                                            <input type="checkbox" class="rqmt3" id="checkbox14" />
	                                            <label for="checkbox14">其他</label>
	                                        </div>
	                                        <input type="text" data-bind="value: rqmtOther" name="rqmtOther" id="rqmtOther" value="" class="other-input" readonly/>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="col-sm-2 control-label">鉴定视频：</label>
	                    <div class="col-sm-10" data-bind="with:videoVM">
	                        <select id="video" class="form-control" 
							data-bind="options: videoList,
							optionsValue:'name',
							optionsText:'name',
							optionsCaption:'--请选择--', 
							event:{change:changeVideo}"></select>
	                        <div class="form-control video-content2 video-review " style="display:none">
 	                        	<%-- <iframe src='${pageContext.request.contextPath}/elecEVIDMgt/appraisal/transcribeVideo.do?ipAddr=192.168.1.248&port=80&account=admin&pwd=sjy123456' style='width:100%; height:100%; border:0px; overflow:hidden;' ></iframe> --%> 
	                        </div>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="col-sm-2 control-label">案件编号：</label>
	                    <div class="col-sm-4" data-bind="with: appraisalVM">
	                        <input type="text" data-bind="value: caseSn" name="caseSn" id="caseSn" class="form-control" readonly/>
	                    </div>
	                    <label class="col-sm-2 control-label">检材编号：</label>
	                    <div class="col-sm-4" data-bind="with: appraisalVM">
	                        <input type="text" data-bind="value: evidSn" name="evidSn" id="evidSn" class="form-control" readonly/>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="col-sm-2 control-label">检验地点：</label>
	                    <div class="col-sm-10" data-bind="with: appraisalVM">
	                        <input type="text" data-bind="value: location" name="location" id="location" class="form-control" readonly/>
	                    </div>
	                </div>
	                <!-- <div class="form-group">
	                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>开始时间：</label>
						<div class="col-sm-4" data-bind="with: appraisalVM">
		                	<input id="appraisedStartDate" name="appraisedStartDate" class="form-control startDate datetimepicker datetimepicker-before-start"
									data-bind="dateTimePicker:appraisedStartDate" required />
						</div>
	                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>结束时间：</label>
						<div class="col-sm-4" data-bind="with: appraisalVM">
		                	<input id="appraisedEndDate" name="appraisedEndDate" class="form-control endDate datetimepicker datetimepicker-after-end"
									data-bind="dateTimePicker:appraisedEndDate" required />
						</div>
	                </div> -->
	                <div class="form-group">
	                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>检验过程：</label>
	                    <div class="col-sm-10" data-bind="with: appraisalVM">
	                        <textarea data-bind="value: process" name="process" id="process" class="form-control" required></textarea>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>杀毒结果：</label>
	                    <div class="col-sm-10" data-bind="with: appraisalVM">
	                        <textarea data-bind="value: antivirusResult" name="antivirusResult" id="antivirusResult" class="form-control" required></textarea>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>检验结果：</label>
	                    <div class="col-sm-10" data-bind="with: appraisalVM">
	                        <textarea data-bind="value: appraisalResult" name="appraisalResult" id="appraisalResult" class="form-control" required></textarea>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="col-sm-2 control-label">备注：</label>
	                    <div class="col-sm-10" data-bind="with: appraisalVM">
	                        <textarea data-bind="value: remarks" name="remarks" id="remarks" rows="8" cols="" class="form-control"></textarea>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="col-sm-2 control-label">附件：</label>
	                    <div class="col-sm-10">
	                    	<div class="document-content">
	                            <div class="document-style downUpPic"><span>《检验鉴定照片记录表》</span></div>
	                            <div class="document-style"><span class="inventory-btn" data-toggle="modal" data-target="#myModal">《提取电子证据清单》</span></div>
	                        </div>
	                    </div>
	                </div>
	                <!-- <div class="form-group">
	                    <label class="col-sm-2 control-label">案由：</label>
	                    <div class="col-sm-10">
	                        <input type="text" id="case" class="form-control" readonly/>
	                    </div>
                    </div>
                    <div class="form-group">
	                    <label class="col-sm-2 control-label">提取时间：</label>
	                    <div class="col-sm-10">
	                        <input type="text" id="extractedDate" class="form-control datetimepicker" readonly/>
	                    </div>
	                </div> -->
	            </form>
	            <!-- <div class="file-upload extractedDataItem">
			        <table class="table table-bordered table-sorting">
			            <thead>
			                <tr>
			                    <th>序号</th>
			                    <th><span class="required-fields">*</span>数据</th>
			                    <th><span class="required-fields">*</span>来源</th>
			                    <th><span class="required-fields">*</span>说明</th>
			                    <th>操作</th>
			                </tr>
			            </thead>
			            <tbody>
							<tr class="required-tr">
								<td></td>
								<td><input type="text" /></td>
								<td><input type="text" /></td>
								<td><input type="text" /></td>
								<td><a class="delete-btn"><i class="fa fa-times"></i></a></td>
							</tr>
			            </tbody>
			            <tfoot>
			            	<tr>
			                    <td colspan="5" align="center">
			                        <button class="btn add-tr-btn"><i class="fa fa-plus"></i>增加</button>
			                    </td>
			                </tr>
			            </tfoot>
			        </table>
			    </div> -->
	            <div class="btn-content">
			        <button type="button" class="btn btn-color1" data-bind ="click: saveData"><i class="fa fa-check"></i>提交</button>
		    	</div>
	        </div>
	    </div>
	    
	    <div class="form-module returner">
	        <div class="form-module-title">
	            <p>检材归还</p>
	        </div>
	        <div class="form-content">
	            <form class="form-horizontal">
	                <div class="form-group">
						<label class="col-sm-2 control-label"><span class="required-fields">*</span>归还人：</label>
	                    <div class="col-sm-4" data-bind="with: appraisalVM">
	                        <input type="text" data-bind="value: returnerAlias" name="returnerAlias" id="returnerAlias" class="form-control" readonly required />
	                    </div>
	                    <label class="col-sm-2 control-label"><span class="required-fields">*</span>归还时间：</label>
						<div class="col-sm-4" data-bind="with: appraisalVM">
		                	<input id="entrustedDate" name="entrustedDate" class="form-control datetimepicker"
									data-bind="dateTimePicker: returnedDate" readonly required />
						</div>	
	                </div>
	            </form>
	        </div>
			<div class="btn-content">
		        <button type="button" class="btn btn-color1" data-bind ="click: saveData"><i class="fa fa-check"></i>检材归还</button>
	    	</div>
	    </div>
	    
		<!-- <div class="btn-content evicTransitionSix">
			<label class="col-sm-2 control-label">已经申请了领取检材！快去领取</label>
	    </div>
	    
		<div class="btn-content evicTransitionNine">
			<label class="col-sm-2 control-label">已经申请了归还检材！请返还检材</label>
	    </div> -->
	    
	    <div class="form-module evicTransitionSix">
	        <div class="form-module-title">
	            <p>系统提示</p>
	        </div>
	        <div class="system-hint">已经申请了领取检材！快去领取</div>
	    </div>
	    
	    <div class="form-module evicTransitionNine">
	        <div class="form-module-title">
	            <p>系统提示</p>
	        </div>
	        <div class="system-hint">已经申请了归还检材！请返还检材</div>
	    </div>
	    
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
	                        	<a class="video-btn video-view" href="${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/videoPlaybackPage.do" target="_blank"><i class="fa fa-play-circle-o"></i></a>
<!-- 								<object id="MediaPlayer"  -->
<!-- 							            classid="CLSID:22D6F312-B0F6-11D0-94AB-0080C74C7E95" -->
<!-- 							            standby="Loading Windows Media Player components..." -->
<!-- 							            type="application/x-oleobject" width="500" height="500"> -->
<!-- 							      <PARAM id="filename" name="filename" value="Z:/record/2017-04-21/192.168.1.248_CAM_1492740889371.mp4"> -->
<!-- 							    </object> -->
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
				<button type="button" class="btn btn-color1" data-bind ="click: saveData"><i class="fa fa-check"></i>提交</button>
			</div>
	    </div>
    
    <!-- 文书下载  start-->
     <div class="form-module docLoad">
	    <div class="form-module-title">
	        <p>物证文书列表</p>
	    </div>
	    <div class="form-content">
	        <form class="form-horizontal">
	            <div class="form-group">
	                <label class="col-sm-2 control-label">文书列表：</label>
	                <div class="col-sm-10">
	                    <div class="document-content">
	                        <div class="document-style document0" style="display:none"><span><a class="downFileAll" id="0">鉴定委托书</a></span></div>
	                        <div class="document-style document1" style="display:none"><span><a class="downFileAll" id="1">鉴定事项确认书</a></span></div>
	                        <div class="document-style document2" style="display:none"><span><a class="downFileAll" id="2">物证鉴定档案封面</a></span></div>
	                        <div class="document-style document3" style="display:none"><span><a class="downFileAll" id="3">鉴定文书档案目录</a></span></div>
	                        <div class="document-style document4" style="display:none"><span><a class="downFileAll" id="4">电子物证检验原始记录</a></span></div>
	                        <div class="document-style document5" style="display:none"><span><a class="downFileAll" id="5">鉴定文书</a></span></div>
	                        <div class="document-style document6" style="display:none"><span><a class="downFileAll" id="6">检验鉴定照片记录表</a></span></div>
	                        <div class="document-style document7" style="display:none"><span><a class="downFileAll" id="7">提取电子证据清单</a></span></div>
	                        <div class="document-style document8" style="display:none"><span><a class="downFileAll" id="8">鉴定文书审批表</a></span></div>
	                        <div class="document-style document9" style="display:none"><span><a class="downFileAll" id="9">不受理鉴定委托告知书</a></span></div>
	                        <div class="document-style document10" style="display:none"><span><a class="downFileAll" id="10">中止鉴定告知书</a></span></div>
	                        <div class="document-style document11" style="display:none"><span><a class="downFileAll" id="11">鉴定文书修改审批表</a></span></div>
	                        <div class="document-style document12" style="display:none"><span><a class="downFileAll" id="12">检材流转记录表</a></span></div>
	                    </div>
	                </div>
	            </div>
	            <div class="btn-content">
				        <button type="button" class="btn btn-color1" data-bind ="click: saveData"><i class="fa fa-check"></i>已完成打印</button>
			    </div>
	        </form>
	    </div>
	</div>
    
    <!-- 文书下载   end-->
    
    
    
    
	    <div class="btn-content stopAndPause">
	        <button class="btn btn-color1 suspend-btn"><i class="fa fa-stop"></i>中止鉴定</button>
	        <button class="btn btn-color1 pause-btn"><i class="fa fa-pause"></i>暂停鉴定</button>
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
				                    <div class="col-sm-10">
				                        <input type="text" id="case" class="form-control" readonly/>
				                    </div>
			                    </div>
			                    <div class="form-group">
				                    <label class="col-sm-2 control-label">提取时间：</label>
				                    <div class="col-sm-10">
				                        <input type="text" id="extractedDate" class="form-control datetimepicker" readonly/>
				                    </div>
				                </div> 
				            </form>
				        </div>
				        <div class="file-upload extractedDataItem">
					        <table class="table table-bordered table-sorting">
					            <thead>
					                <tr>
					                    <th>序号</th>
					                    <th><span class="required-fields">*</span>数据</th>
					                    <th><span class="required-fields">*</span>来源</th>
					                    <th><span class="required-fields">*</span>说明</th>
					                    <th>操作</th>
					                </tr>
					            </thead>
					            <tbody>
									<tr class="required-tr">
										<td></td>
										<td><input type="text" /></td>
										<td><input type="text" /></td>
										<td><input type="text" /></td>
										<td><a class="delete-btn"><i class="fa fa-times"></i></a></td>
									</tr>
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
			      	</div>
			      	<div class="modal-footer">
			      		<button type="button" class="btn btn-primary" onclick="saveExtractedData()">提交</button>
				        <button type="button" class="btn btn-default closeModal" data-dismiss="modal">取消</button>
			      	</div>
			    </div>
		  	</div>
		</div>
	    
    </div>
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
	<jsp:include page="/common/commonModal.jsp"></jsp:include>
	<script>
		$('.datetimepicker').datetimepicker({
	       format: 'YYYY-MM-DD  HH:mm',
	    });
		$(".datetimepicker-before").on("dp.change",function (e) {
		    $('.datetimepicker-after').data("DateTimePicker").minDate(e.date);
		});
		$(".datetimepicker-after").on("dp.change",function (e) {
		    $('.datetimepicker-before').data("DateTimePicker").maxDate(e.date);
		});
		$(".datetimepicker-before-start").on("dp.change",function (e) {
		    $('.datetimepicker-after-end').data("DateTimePicker").minDate(e.date);
		});
		$(".datetimepicker-after-end").on("dp.change",function (e) {
		    $('.datetimepicker-before-start').data("DateTimePicker").maxDate(e.date);
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

		/* 标签页事件和样式-开始 */
		var clickStatus = 4;	//点击状态
		var dataStatus = 4;		//数据状态
		tabsContent(clickStatus,dataStatus);
    	/* 标签页事件和样式-结束  */
    	
    	//条形码
		var barCodeid = $("#bcTarget");
		var value = barCodeid.siblings(".bar-code-input").val();
		code(barCodeid, value);
		
		var useNum = 3;
		$(".add-device-btn").click(function(){
			var deviceHtml = "";
			deviceHtml += '<div class="add-device-content">';
			deviceHtml += '<div class="remove-btn"><i class="fa fa-times"></i></div>';
			deviceHtml += '<div class="form-group">';
			deviceHtml += '<label class="col-sm-2 control-label"><span class="required-fields">*</span>设备名称：</label>';
			deviceHtml += '<div class="col-sm-4"><select  class="form-control deviceName changeDevice" required>'+deviceNameHtml+'</select></div>';
			deviceHtml += '<label class="col-sm-2 control-label"><span class="required-fields">*</span>设备识别号</label>';
			deviceHtml += '<div class="col-sm-4"><select  class="form-control device deviceSelect identify" required></select></div>';
			deviceHtml += '</div>';
			deviceHtml += '<div class="form-group">';
			deviceHtml += '<label class="col-sm-2 control-label"><span class="required-fields">*</span>设备状况：</label>';
			deviceHtml += '<div class="col-sm-4"><select class="form-control deviceStatus" required disabled readonly ><option value="0">正常</option><option value="2">维修</option><option value="3">报废</option></select></div>';
			deviceHtml += '<label class="col-sm-2 control-label"><span class="required-fields">*</span>开始时间：</label>';
			deviceHtml += '<div class="col-sm-4" ><input class="form-control datetimepicker11 startDate " required /></div>';
			deviceHtml += '</div>';
			deviceHtml += '<div class="form-group">';
			deviceHtml += '<label class="col-sm-2 control-label">备注：</label>';
			deviceHtml += '<div class="col-sm-10"><textarea class="form-control deviceRemarks"></textarea></div>';
			deviceHtml += '</div>';
			deviceHtml += '</div>';
			$(this).parents(".form-group").before(deviceHtml);
			$(".datetimepicker11").datetimepicker({format: 'YYYY-MM-DD HH:mm'});
			useNum++;
			
		});
		
	 	$("body").on({
	 		focus:function(){
                //$(this).find("option").attr("disabled",false);
                $(this).find("option").css("display","block");
                $(this).removeClass("identify");
                var valArr = [];
                var size = $(".identify").size();
                for( var i=0; i<size; i++ ){
                	var value = $(".identify").eq(i).val();
                	if( value != null && value != "0" ){
                		valArr.push(value);
                	}
                }
                $(this).find("option").each(function(){
                	var optionVal = $(this).val();
                	if( $.inArray(optionVal,valArr) != -1 ){
                		//$(this).attr("disabled",true);
                		$(this).css("display","none");
                	}
                });
                
            },
            blur:function(){
            	$(this).addClass("identify");
            },
        },".deviceSelect"); 
		
		$(".userSituation").on("change", ".changeDevice",function(){
			deviceHtml='';
			deviceHtml='<option value="0">-- 请选择 --</option>';
			var deviceId =  $(this).find("option:checked").val();
			var deviceData = loadData("${ pageContext.request.contextPath }/deviceMgt/device/getByNameList.do", { "id" : deviceId });
		    if (deviceData == undefined || deviceData == null){
				   deviceData = [];
			 }else{
				for(var i = 0 ; i < deviceData.length ; i++){
					deviceHtml += '<option value="'+deviceData[i].id+'">'+deviceData[i].identifier+'</option>'
				}
			}
		    $(this).parents(".form-group").find(".device").html(deviceHtml);
		})
		$(".form-horizontal").on("click", ".remove-btn", function(){
			var deleteVal = $(this).parent(".add-device-content").find(".deviceSelect").find("option:checked").val();  
            $(".deviceSelect").find("option[value='"+ deleteVal +"']").show();
			$(this).parent(".add-device-content").remove();
		});
		
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
		
		$(".table-sorting").on("click", ".delete-btn", function(){
			$(this).parent("td").parent("tr").remove();
			sorting();
		});
		
		sorting();
		
		function sorting(){
			$(".table-sorting tbody tr").each(function(){
				var index = $(this).index();
				var num = index+1;
				$(this).find("td").eq(0).text(num);
			});
		}
		//=====================以上内容属于前段控制
		//公用数据
		var userId = "${sessionScope.loginUser.userId}";
		var userName = "${sessionScope.loginUser.userName}";
		var userAlias = "${sessionScope.loginUser.userAlias}";
		var appraisalData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/loadDataByUserAlias.do", { "userId" : userId });
	 
        var preappraisalData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/preappraisal/loadPreappraisalData.do", { "id" : appraisalData.preappraisalId });
        var evidTransitionData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/evidTransition/loadDataById.do", { "id" : "" });  //电子物证交接申请空对象
		
        
        var deviceNameData = loadData("${ pageContext.request.contextPath }/deviceMgt/device/getUseSituationList.do", {});  //所有设备
        var deviceNameHtml = '<option value="0">-- 请选择 --</option>';
        if (deviceNameData == undefined || deviceNameData == null){
			deviceNameData = [];
		}else{
			for(var i = 0 ; i < deviceNameData.length ; i++){
				deviceNameHtml += '<option value="'+deviceNameData[i].id+'">'+deviceNameData[i].name+'</option>';
			}
		}
        var deviceHtml='<option value="0">-- 请选择 --</option>';
        $(".deviceName").append(deviceNameHtml);
        $(".device").append(deviceHtml);
        
		var deviceAppraisalData = loadData("${ pageContext.request.contextPath }/deviceMgt/device/getByNameList.do", {});  //所有设备
		
		var devUsingSitnData = loadData("${ pageContext.request.contextPath }/deviceMgt/devUsingSitn/loadDevUsingSitnData.do", {"id":""});  //电子物证交接申请空对象
		if(appraisalData.status == 7){
			devUsingSitnData.startDate = new Date();
		}
		
		var appraisedDevData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisedDev/loadappraisedDevData.do", {"id":""});  //电子物证（检材）鉴定设备
		var extractedData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/ExtractedData/loadExtractedData.do", {"id":""});  //提取证据清单
		var extractedDataItemData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/ExtractedDataItem/loadExtractedDataItem.do", {"id":""});  //提取证据清单
		var appraisalHistoryData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisalHistory/loadAppraisalHistoryData.do", { "id" : "" });
		var videoData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/loadVideoList.do",{});//摄像头参数
		
		var videoSrc = '${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/videoPlaybackPage.do?id='+appraisalData.id;
	    $(".video-view").attr("href", videoSrc); 
	    
		var preappraisalDataVM = ko.mapping.fromJS(preappraisalData);
		var appraisalDataVM = ko.mapping.fromJS(appraisalData);
		var evidTransitionDataVM = ko.mapping.fromJS(evidTransitionData);
		var devUsingSitnDataVM = ko.mapping.fromJS(devUsingSitnData);
		var appraisedDevDataVM = ko.mapping.fromJS(appraisedDevData);
		var extractedDataVM = ko.mapping.fromJS(extractedData);
		var extractedDataItemDataVM = ko.mapping.fromJS(extractedDataItemData);
		var appraisalHistoryDataVM = ko.mapping.fromJS(appraisalHistoryData);
		devUsingSitnInit();  //初始化
	    var videoDataVM = {
    		videoList : ko.observableArray(videoData)
	    }
		
		//************ 模块需要用到的参数 初始化  开始 ******************//
		var devHtml = "";
		var videoVS = "";
		//************ 模块需要用到的参数 初始化  结束 ******************//
		
		//分模块显示
		checkStatus();
		function checkStatus(){
			$(".collector").hide();  //6
			$(".userSituation").hide();  //7
			$(".appraising").hide();  //8
			$(".returner").hide();   //9
			$(".approver").hide(); //10
			$(".docLoad").hide(); //14
			$(".evicTransitionSix").hide();  //领取
			$(".evicTransitionNine").hide();  //归还
			if(appraisalData.status == 6){				
				$(".userSituation").remove();  //7
				$(".appraising").remove();  //8
				$(".returner").remove();   //9
				$(".approver").remove(); //10
				$(".docLoad").remove(); //14
			}else if(appraisalData.status == 7){
				$(".collector").remove();  //6				
				$(".appraising").remove();  //8
				$(".returner").remove();   //9
				$(".approver").remove(); //10
				$(".docLoad").remove(); //14
			}else if(appraisalData.status == 8){
				$(".required-tr input").attr("required", true);
				$(".video-review").show();
				$(".collector").remove();  //6
				$(".userSituation").remove();  //7				
				$(".returner").remove();   //9
				$(".approver").remove(); //10
				$(".docLoad").remove(); //14
			}else if(appraisalData.status == 9){
				$(".collector").remove();  //6
				$(".userSituation").remove();  //7
				$(".appraising").remove();  //8				
				$(".approver").remove(); //10
				$(".docLoad").remove(); //14
			}else if(appraisalData.status == 10){
				$(".collector").remove();  //6
				$(".userSituation").remove();  //7
				$(".appraising").remove();  //8
				$(".returner").remove();   //9
				$(".docLoad").remove(); //14
			} else if(appraisalData.status == 13){
				$(".collector").remove();  //6
				$(".userSituation").remove();  //7
				$(".appraising").remove();  //8
				$(".returner").remove();   //9
				$(".approver").remove(); //10
			}
 			if(appraisalData.status == 6){
				var isExite = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/evidTransition/loadDataByAppraisalId.do", { "appraisalId" : appraisalData.id , "status" : 0 });  //电子物证交接申请空对象
				if(isExite){
					$(".styleHint").hide();
					$(".evicTransitionSix").show();
				}else{
					$(".styleHint").hide();
					$(".collector").show();
					appraisalDataVM.collectedDate = new Date();
					appraisalDataVM.collectorAlias = userAlias;
					appraisalDataVM.collectorName = userName;
					appraisalDataVM.collectorId = userId;
				}
			}else if(appraisalData.status == 7){
				$(".styleHint").hide();
				$(".userSituation").show();
				/* 
				devHtml += '<option class="" value="">--请选择--</option>';
				for(var i = 0 ; i < deviceData.length ; i++){
					devHtml += '<option class="" value="'+deviceData[i].id+'">'+deviceData[i].identifier+'</option>';
				} */
			}else if(appraisalData.status == 8){
				$(".appraising").show();
				$(".styleHint").hide();
				appraisalDataVM.location = "广州市公安局电子数据检验鉴定实验室";
				
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
				for(var i = 1 ; i < 15 ; i++){
					var check = "#checkbox" + i;
					$(check).attr("disabled","disabled") //禁用
				}
				$("#case").val(appraisalData.orgName + appraisalData.caseName);
				$("#extractedDate").val(new Date().Format("yyyy-MM-dd hh:mm"));
			}else if(appraisalData.status == 9){
				$(".video-review").html("");
				var isExite = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/evidTransition/loadDataByAppraisalId.do", { "appraisalId" : appraisalData.id , "status" : 0 });  //电子物证交接申请空对象
				if(isExite){
					$(".styleHint").hide();
					$(".evicTransitionNine").show();
				}else{
					$(".styleHint").hide();
					$(".returner").show();
					appraisalDataVM.returnedDate = new Date();
					appraisalDataVM.returnerAlias = userAlias;
					appraisalDataVM.returnerName = userName;
					appraisalDataVM.returnerId = userId;
				}
			}else if(appraisalData.status == 10){
				$(".video-review").html("");
				$(".styleHint").hide();
				$(".approver").show();
// 				window.parent.location.href = "${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/videoPlayback.do"; 
			}else if(appraisalData.status == 13){
				$(".styleHint").hide();
				$(".docLoad").show();
				var docData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/AppraisalDoc/getListData.do",{ "appraisalId" : appraisalData.id });
				if(docData.length > 0){
					for(var i = 0 ; i < docData.length ; i++){
						$('.document'+docData[i].type+'').show();
					}
				}
				$(".downFileAll").click(function(){
					var type = $(this).attr("id");
					window.location.href = "${ pageContext.request.contextPath }/elecEVIDMgt/AppraisalDoc/downAppraisalDocData.do?type="+type+"&appraisalId="+appraisalData.id;
				})
// 				window.parent.location.href = "${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/videoPlayback.do"; 
			}else{
				$(".stopAndPause").hide();
			}					
			
		}
		//====================	检材领用开始  ====================  //
		function evidTransitionDataInit(){ //交接申请赋值
			evidTransitionDataVM.evidName = appraisalData.evidName;
			evidTransitionDataVM.evidSn = appraisalData.evidSn;
			evidTransitionDataVM.caseName = appraisalData.caseName;
			evidTransitionDataVM.caseSn = appraisalData.caseSn;
			evidTransitionDataVM.type = 0;
			evidTransitionDataVM.status = 0;
			evidTransitionDataVM.applicantId = userId;
			evidTransitionDataVM.applicantName = userName;
			evidTransitionDataVM.applicantAlias = userAlias;
			evidTransitionDataVM.evidId = appraisalData.evidId;
			evidTransitionDataVM.createdDate = new Date();
			evidTransitionDataVM.preappraisalId = appraisalData.preappraisalId;
			evidTransitionDataVM.appraisalId = appraisalData.id;
		}
		//====================	检材领用结束  ====================  //
		
		
		
		//====================	设备使用情况登记开始  ====================  //
		function devUsingSitnInit(){
			devUsingSitnDataVM.evidSn = appraisalData.evidSn;
			devUsingSitnDataVM.evidId = appraisalData.evidId;
			devUsingSitnDataVM.operatorId = userId;
			devUsingSitnDataVM.operatorName = userName;
			devUsingSitnDataVM.operatorAlias = userAlias;
		}
		function saveUseStin(){
			devUsingSitnDataVM.deviceId = $(".device").eq(0).val();
			devUsingSitnDataVM.devStatus = $(".deviceStatus").eq(0).val();
			saveData("${ pageContext.request.contextPath }/deviceMgt/devUsingSitn/saveDevUsingSitnData.do", devUsingSitnDataVM);
			for(var i = 1 ; i < $(".device").length ; i++){
				devUsingSitnDataVM.remarks = $(".deviceRemarks").eq(i).val();
				devUsingSitnDataVM.startDate = $(".startDate").eq(i).val();
				devUsingSitnDataVM.endDate = $(".endDate").eq(i).val();
				devUsingSitnDataVM.devStatus = $(".deviceStatus").eq(i).val();
				devUsingSitnDataVM.deviceId = $(".device").eq(i).val();
				saveData("${ pageContext.request.contextPath }/deviceMgt/devUsingSitn/saveDevUsingSitnData.do", devUsingSitnDataVM);
			}
		}
		function saveAppraisedDev(){
			var d = new Date();
			for(var i = 0 ; i < $(".device").length ; i++){
				appraisedDevData.remarks = $(".deviceRemarks").eq(i).val();
				appraisedDevData.startDate = new Date($(".startDate").eq(i).val());
				//appraisedDevData.endDate = new Date($(".endDate").eq(i).val());
				appraisedDevData.appraiserId = userId;
				appraisedDevData.deviceId = $(".device").eq(i).val();
				appraisedDevData.appraisalId = appraisalDataVM.id;
				saveData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisedDev/saveappraisedDevData.do", appraisedDevData);
			}
		}
		//====================	设备使用情况登记结束  ====================  //
		
		
		
		
		//====================	鉴定原始记录  开始  ====================  //
		$(".downUpPic").click(function(){
			//生成照片电子文档
			if(loadData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/checkAppDocByTypeAndAppraisalId.do", {"type": 6,"appraisalId":appraisalData.id } )){
				window.location.href = "${ pageContext.request.contextPath }/elecEVIDMgt/AppraisalDoc/downAppraisalDocData.do?type=6&appraisalId="+appraisalData.id;
			}else{
				promptContent("下载的文件不存在,请联系管理员");
			 	$(".alert").removeClass("alert-success").addClass("alert-danger");
	 			$(".promptDiv").slideDown();
	 		    setTimeout(function(){
	 				$(".promptDiv").slideUp();
	 		    },1500);
			}
		})
		
		function saveExtractedData(){
			if ( validateSubmittedData() ) {
				var extractedDataId = loadData("${ pageContext.request.contextPath }/deviceMgt/getUUID.do", {});
				extractedDataVM.id = extractedDataId;
				extractedDataVM.preappraisalId = preappraisalDataVM.id;
				extractedDataVM.appraisalId = appraisalDataVM.id;
				extractedDataVM.extractedDate = new Date();
				extractedDataVM.cause = appraisalData.orgName + appraisalData.caseName;
				
				for(var i = 0 ; i < $(".extractedDataItem tbody tr").length ; i++){
					var text1 = $(".extractedDataItem tbody tr").eq(i).find("td").eq(1).find("input").val();
					var text2 = $(".extractedDataItem tbody tr").eq(i).find("td").eq(2).find("input").val();
					var text3 = $(".extractedDataItem tbody tr").eq(i).find("td").eq(3).find("input").val();
					extractedDataItemDataVM.data = text1;
					extractedDataItemDataVM.src = text2;
					extractedDataItemDataVM.explanation = text3;
					extractedDataItemDataVM.extractedDataId = extractedDataId;
					saveData("${ pageContext.request.contextPath }/elecEVIDMgt/ExtractedDataItem/saveExtractedDataItem.do", extractedDataItemDataVM)
				}
				if(saveData("${ pageContext.request.contextPath }/elecEVIDMgt/ExtractedData/saveExtractedData.do", extractedDataVM)){
					//保存提取电子清单列表
	   				saveData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/saveExtractListWord.do", extractedDataVM)
					
					saveSuccess();
					$(".closeModal").click();
				}
			}else{
				saveFailure();
			}
		}
		//====================	鉴定原始记录  结束  ====================  //
		
		
		//====================	检材归还 开始  ====================  //
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
			evidTransitionDataVM.createdDate = new Date();
			evidTransitionDataVM.evidId = appraisalData.evidId;
			evidTransitionDataVM.preappraisalId = appraisalData.preappraisalId;
			evidTransitionDataVM.appraisalId = appraisalData.id;
		}
		//====================	检材归还 结束  ====================  //
		
		
		//====================	文书整理 开始  ====================  //
		$(".file").on("change","input[type='file']",function(){
			var filePath = $(this).val();
			$(this).siblings("input[type='text']").val(filePath);
		})
		
		function saveFile(){
// 			alert("进去文件上传");
			console.log("1111111");
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
	   				},
	   			});
			})
		}
		$(".fa-upload").click(function(){
			var fileName = $(this).parent().parent().parent().find("input").eq(0).val();
			if(fileName != null && fileName != "" && fileName != undefined){
				fileName = fileName.substring(fileName.lastIndexOf("\\")+1,fileName.lastIndexOf("."));
				console.log(fileName);
				if(fileName){
					$(this).parent().parent().parent().find("input").eq(0).val(fileName);				
					$(this).parent().addClass("willUpLoad");				
		 			promptContent("上传成功");
		 			$(".alert").removeClass("alert-danger").addClass("alert-success");
		 			$(".promptDiv").slideDown();
		 		    setTimeout(function(){
		 				$(".promptDiv").slideUp();
		 		    },1500);
				}else{					
					promptContent("上传成功");
		 			$(".alert").removeClass("alert-danger").addClass("alert-success");
		 			$(".promptDiv").slideDown();
		 		    setTimeout(function(){
		 				$(".promptDiv").slideUp();
		 		    },1500);
				}
			}else{
				promptContent("上传文件为空");
			 	$(".alert").removeClass("alert-success").addClass("alert-danger");
	 			$(".promptDiv").slideDown();
	 		    setTimeout(function(){
	 				$(".promptDiv").slideUp();
	 		    },1500);
			}
		})
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
	 		    },1500);
			}
		})
		//进入修改原始记录页面
		$(".changeFileFour").click(function(){
	    	var url = "${ pageContext.request.contextPath }/elecEVIDMgt/generalMessage/changeSourceRecord.do";
	    	$(".index-iframe", window.parent.document).attr("src",url);
	    });
		//进入修改电子证据清单
		$(".changeFileSeven").click(function(){
	    	var url = "${ pageContext.request.contextPath }/elecEVIDMgt/generalMessage/electronicEvidenceList.do";
	    	$(".index-iframe", window.parent.document).attr("src",url);
	    });
		//====================	文书整理 结束  ====================  //
		
		
		
		
		
		
        var vm = {
       		appraisalVM : appraisalDataVM,
       		evidTransitionVM : evidTransitionDataVM, 
       		devUsingSitnVM : devUsingSitnDataVM,
       		preappraisalVM : preappraisalDataVM,
       		appraisedDevVM : appraisedDevDataVM,
       		extractedVM : extractedDataVM,
       		extractedDataItemVM : extractedDataItemDataVM,
       		appraisalHistoryVM : appraisalHistoryDataVM,
       		videoVM : videoDataVM,
		}
		
		
		//保存方法
        vm.saveData = function(){
			$("button").attr("disabled",true);
			if ( validateSubmittedData() ) {
				if(appraisalData.status == 6){  //检材申领
					evidTransitionDataInit();
					if(saveData("${ pageContext.request.contextPath }/elecEVIDMgt/evidTransition/saveData.do", evidTransitionDataVM)){
						if(saveData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/saveData.do", appraisalDataVM)){
		        			saveSuccess("${pageContext.request.contextPath}/elecEVIDMgt/authenticate/analysis/appraisalProcessAllot.do");
						}
					}
				}else if(appraisalData.status == 7){  //设备过程
					var commit = true;
					for(var i = 0 ; i < $(".startDate").length ; i++){
						if($(".startDate").eq(i).val() > $(".endDate").eq(i).val()){
							promptContent("结束时间必须大于开始时间");
						 	$(".alert").removeClass("alert-success").addClass("alert-danger");
				 			$(".promptDiv").slideDown();
				 		    setTimeout(function(){
				 				$(".promptDiv").slideUp();
				 		    },1500);
				 		   commit = false;
							$(".btn-color1").attr( { "disabled" : false });
						}
					}
					if(commit){
		 				saveUseStin();
		 				saveAppraisedDev();
		 				appraisalDataVM.status = 8;
		 				appraisalDataVM.appraisedStartDate = new Date($(".startDate").eq(0).val());
		 				if(saveData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/saveData.do", appraisalDataVM)){
		         			saveSuccess("${pageContext.request.contextPath}/elecEVIDMgt/authenticate/analysis/appraisalProcessAllot.do");
		 				}
					}
				}else if(appraisalData.status == 8){  //
					$(".video-review").html("");
					appraisalDataVM.status = 9;
					if(saveData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/saveData.do", appraisalDataVM)){
						//saveData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/saveRecordWord.do",appraisalDataVM);//需要生成原始记录表单
	        			saveSuccess("${pageContext.request.contextPath}/elecEVIDMgt/authenticate/analysis/appraisalProcessAllot.do");
					}
				}else if(appraisalData.status == 9){
					returnerTransitionDataInit();
					if(saveData("${ pageContext.request.contextPath }/elecEVIDMgt/evidTransition/saveData.do", evidTransitionDataVM)){
						//鉴定解释时间
						appraisalDataVM.appraisedEndDate = new Date();
						if(saveData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/saveData.do", appraisalDataVM)){
							saveData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/saveRecordWord.do",appraisalDataVM);//需要生成原始记录表单
							saveData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/saveReportWord.do",appraisalDataVM);//需要生成鉴定文书副本
		        			saveSuccess("${pageContext.request.contextPath}/elecEVIDMgt/authenticate/analysis/appraisalProcessAllot.do");
						}
					}
				}else if(appraisalData.status == 10){
					saveFile();
					appraisalDataVM.status = 11;
					if(saveData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/saveData.do", appraisalDataVM)){
	// 					$(".CallBackVedio #MediaPlayer").remove();
	// 					window.parent.location.href = "${pageContext.request.contextPath}/elecEVIDMgt/authenticate/analysis/appraisalProcessAllot.do"; 
		        			saveSuccess("${pageContext.request.contextPath}/elecEVIDMgt/authenticate/analysis/appraisalProcessAllot.do");
					}
				}else if(appraisalData.status == 13){
					appraisalDataVM.status = 14;
					if(saveData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/saveData.do", appraisalDataVM)){
		        			saveSuccess("${pageContext.request.contextPath}/elecEVIDMgt/authenticate/analysis/appraisalProcessAllot.do");
					}
				}
			}else{
				saveFailure();
			}
		}
		
		ko.applyBindings(vm);
		
		//自动生成条形码
		function code(id, value){
			id.empty().barcode(value, "code128",{barWidth:1, barHeight:30,showHRI:false});
			id.siblings(".bar-code-text").html(value);
		}
		
		
		$(".suspend-btn").click(function(){
	    	var url = "${ pageContext.request.contextPath }/elecEVIDMgt/generalMessage/suspendForm.do?preappraisalId="+preappraisalData.id+"&appraisalId="+appraisalData.id;
	    	$(".index-iframe", window.parent.document).attr("src",url);
	    });
		
		$(".pause-btn").click(function(){
			$(".btn-color1").attr({"disabled":"disabled"});
			$(".modalContent").text("确定要暂停鉴定吗？");
			$("#sysNoticePopup").modal("show");						
			$(".btn-color1").attr({"disabled":false});
	    });
		
		$(".confirm-btn").click(function(){
			//取消所有未完成的交接申请
			saveData("${pageContext.request.contextPath}/elecEVIDMgt/evidTransition/cancelDataByAppraisalId.do?appraisalId="+appraisalData.id,{} );

			//状态是6或则10 就清除数据  然后复制内容
			if(appraisalData.status == 6 || appraisalData.status == 10  ){
				appraisalHistoryDataVM.preappraisalId = appraisalDataVM.preappraisalId;
				appraisalHistoryDataVM.evidId = appraisalDataVM.evidId;
				appraisalHistoryDataVM.returnTransitionId = appraisalDataVM.returnTransitionId;
				appraisalHistoryDataVM.collTransitionId = appraisalDataVM.collTransitionId;
				if(saveData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisalHistory/saveAppraisalHistoryData.do?appraisalId="+appraisalData.id, appraisalHistoryDataVM)){
        			saveSuccess("${pageContext.request.contextPath}/elecEVIDMgt/authenticate/analysis/appraisalProcessAllot.do");
				}
			}else if(appraisalData.status == 7 || appraisalData.status == 8 || appraisalData.status == 9){
				returnerTransitionDataInit();
				appraisalDataVM.status = 16;
				if(saveData("${ pageContext.request.contextPath }/elecEVIDMgt/evidTransition/saveData.do", evidTransitionDataVM)){
					if(saveData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/saveData.do", appraisalDataVM)){
						//需要生成原始记录表单
	        			saveSuccess("${pageContext.request.contextPath}/elecEVIDMgt/authenticate/analysis/appraisalProcessAllot.do");
					}
				}
			}
		});

		function changeVideo(){
			var NumVideo = $("#video").val()
			for(var i=0;i<videoData.length;i++){
				if(videoData[i].name == NumVideo){
					videoVS = videoData[i].videoSource;
// 					console.log("选中的摄像头的名字为"+videoData[i].name + ":" + videoData[i].account + ":" + videoData[i].password + ":" + videoData[i].port);
// 					console.log("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/transcribeVideo.do?ipAddr="+videoData[i].ip+"&port="+videoData[i].port+"&account="+videoData[i].account+"&pwd="+videoData[i].password);
					$(".video-review").html("");
					var vedioHtml = "<iframe src='${pageContext.request.contextPath}/elecEVIDMgt/appraisal/transcribeVideo.do?ipAddr="+videoData[i].ip+"&port="+videoData[i].port+"&account="+videoData[i].account+"&pwd="+videoData[i].password+"' style='width:100%; height:100%; border:0px; overflow:hidden;' ></iframe>";
					$(".video-review").html(vedioHtml);
				}
			}
		}
		function getVedioPath(fileName){
			thisPath = fileName.replace(/\\/g,"/");
			if(videoVS != null && videoVS != ""){
				thisPath = thisPath.substring(3);
// 				console.log(thisPath);
				thisPath = videoVS + thisPath
// 				console.log(thisPath);
			}
			appraisalDataVM.videoPath = thisPath;
		}
		
		///头标签
		$(".tabs-nav li").click(function(){
    		var aClass = $(this).find("a").attr("class");
    		if( aClass == "register" ){
    			if( $(".iframe-"+aClass).attr("src") == "" ){
    				var src = "${pageContext.request.contextPath}/elecEVIDMgt/registerInfoView.do?commonPreappraisalId="+appraisalData.preappraisalId;
    				$(".iframe-"+aClass).attr("src", src);
    				$(".iframe-"+aClass).load(function(){
    		            var mainheight = $(this).contents().find("body").height()+30;
    		            $(this).height(mainheight);
    		        });
    			}
    		}else if( aClass == "accepted" ){
    			if( $(".iframe-"+aClass).attr("src") == "" ){
    				var src = "${pageContext.request.contextPath}/elecEVIDMgt/physicalEvidenceAcceptView.do?commonAppraisalId="+appraisalData.id;
    				$(".iframe-"+aClass).attr("src", src);
    				$(".iframe-"+aClass).load(function(){
    		            var mainheight = $(this).contents().find("body").height()+30;
    		            $(this).height(mainheight);
    		        });
    			}
    		}else if( aClass == "check" ){
    			if( $(".iframe-"+aClass).attr("src") == "" ){
    				var src = "${pageContext.request.contextPath}/elecEVIDMgt/checkInfoView.do?commonAppraisalId="+appraisalData.id;
    				$(".iframe-"+aClass).attr("src", src);
    				$(".iframe-"+aClass).load(function(){
    		            var mainheight = $(this).contents().find("body").height()+30;
    		            $(this).height(mainheight);
    		        });
    			}
    		}else if( aClass == "warehousing" ){
    			if( $(".iframe-"+aClass).attr("src") == "" ){
    				var src = "${pageContext.request.contextPath}/elecEVIDMgt/physicalEvidenceStorageView.do?commonAppraisalId="+appraisalData.id;
    				$(".iframe-"+aClass).attr("src", src);
    				$(".iframe-"+aClass).load(function(){
    		            var mainheight = $(this).contents().find("body").height()+30;
    		            $(this).height(mainheight);
    		        });
    			}
    		}
		})
	</script>
</body>
</html>