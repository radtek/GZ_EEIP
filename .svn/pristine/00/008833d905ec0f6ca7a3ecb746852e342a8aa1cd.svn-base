<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>登记信息</title>
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
	<div class="upload-module">
        <div class="module-title">
            <p>立案材料</p>
        </div>
        <div class="file-list">
        </div>
        <!-- <div class="upload-content">
            <div class="upload-input">
                <input type="text" class="file-name" readonly/>
            </div>
            <div class="upload-btn">
                <button type="button" class="btn btn-color1 file-browse"><i class="fa fa-folder-open-o"></i>浏览</button>
                <button type="button" class="btn btn-color2 file-upload-btn" id="2"><i class="fa fa-upload"></i>上传</button>
            	<input type="file" class="file-input" id="file2" name="file" />
            </div>
        </div> -->
    </div>
    <div class="form-module">
        <div class="form-module-title">
            <p>基本信息</p>
        </div>
        <div class="form-content">
        	<form class="form-horizontal">
        		<div class="form-group">
					<label class="col-sm-2 control-label">委托鉴定单位：</label>
					<div class="col-sm-4" data-bind="with: preappraisalVM">
						<input type="text" data-bind="value: orgName" name="orgName" id="orgName" class="form-control" readonly  />
					</div>	
					<label class="col-sm-2 control-label">委托时间：</label>
					<div class="col-sm-4" data-bind="with: preappraisalVM">
	                	<input type="text" id="entrustedDate" name="entrustedDate" class="form-control datetimepicker" data-bind="dateTimePicker:entrustedDate" readonly  />
					</div>			
				</div>			
				<div class="form-group">
					<label class="col-sm-2 control-label">送检人：</label>
					<div class="col-sm-2" >
	                	<input type="text" class="form-control userAlias" required />
					</div>	
					<label class="col-sm-2 control-label">职务：</label>
					<div class="col-sm-2">
	                	<input type="text" class="form-control userPost" required/>
					</div>
					<label class="col-sm-2 control-label">警察证号：</label>
					<div class="col-sm-2">
						<input type="text" class="form-control policeId alarm" required />
					</div>	
					<!-- <div class="col-sm-1" style="display:none;">
						<button type="button" class="btn btn-color1 upload" id="add-person"><i class="fa fa-plus"></i>添加</button>
				    </div> -->		
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">送检人：</label>
					<div class="col-sm-2" >
	                	<input type="text" class="form-control userAlias" required />
					</div>	
					<label class="col-sm-2 control-label">职务：</label>
					<div class="col-sm-2">
	                	<input type="text" class="form-control userPost" required/>
					</div>
					<label class="col-sm-2 control-label">警察证号：</label>
					<div class="col-sm-2">
						<input type="text" class="form-control policeId alarm" required />
					</div>	
				</div>		
				<div class="form-group">
					<label class="col-sm-2 control-label">通讯地址：</label>
					<div class="col-sm-2" data-bind="with: provinceVM">
						<select id="province" class="form-control" 
						data-bind="options: provinceList,
						optionsValue:'provinceId',
						optionsText:'name',
						value:provinceId,
						optionsCaption:'--请选择--', 
						event:{change:changeProvince}" disabled ></select>
			        </div>
					<div class="col-sm-1 div-label">
						省
					</div>
					<div class="col-sm-2" data-bind="with:cityVM">
						<select id="city" class="form-control" 
						data-bind="options:cityList,
						optionsValue:'cityId',
						optionsText:'name',
						value:cityId,
						optionsCaption:'--请选择--', 
						event:{change:changeCity}" disabled ></select>
		        	</div>
					<div class="col-sm-1 div-label">
						市
					</div>	
					<div class="col-sm-2" data-bind="with:countyVM">
						<select id="county" class="form-control" 
						data-bind="options:countyList,
						optionsValue:'countyId',
						optionsText:'name',
						value:countyId,
						optionsCaption:'--请选择--' " ></select>
		        	</div>
					<div class="col-sm-1 div-label">
						区
					</div>			
				</div>	
				<div class="form-group">
					<label class="col-sm-2 control-label">详细地址：</label>
					<div class="col-sm-10" data-bind="with: preappraisalVM">
						<input type="text" data-bind="value: addr" name="addr" id="addr" class="form-control" />
					</div>								
				</div>	
				<div class="form-group">
					<label class="col-sm-2 control-label">邮政编码：</label>
					<div class="col-sm-4" data-bind="with: preappraisalVM">
						<input type="text" data-bind="value: zipCode" name="zipCode" id="zipCode" class="form-control" />
					</div>
					<label class="col-sm-2 control-label">联系电话：</label>
					<div class="col-sm-4" data-bind="with: preappraisalVM">
						<input type="text" data-bind="value: tel" name="tel" id="tel" class="form-control cellphone" />
					</div>								
				</div>
				<div class="form-group">	
					<label class="col-sm-2 control-label">传真号码：</label>
					<div class="col-sm-4" data-bind="with: preappraisalVM">
						<input type="text" data-bind="value: fax" name="fax" id="fax" class="form-control fax" />
					</div>									
				</div>	
				<div class="form-group">
					<label class="col-sm-2 control-label">案件名称：</label>
					<div class="col-sm-4" data-bind="with: preappraisalVM">
						<input type="text" data-bind="value: caseName" name="caseName" id="caseName" class="form-control" />
					</div>
					<label class="col-sm-2 control-label">案件编号：</label>
					<div class="col-sm-4" data-bind="with: preappraisalVM">
						<input type="text" data-bind="value: caseSn" name="caseSn" id="caseSn" class="form-control" />
					</div>										
				</div>	
				<div class="form-group">
					<label class="col-sm-2 control-label">案情简要说明：</label>
					<div class="col-sm-10" data-bind="with: preappraisalVM">
						<textarea data-bind="value: explanation" name="explanation" id="explanation" class="form-control" ></textarea>
					</div>								
				</div>		
				<div class="form-group">
					<label class="col-sm-2 control-label">鉴定要求：</label>
					<div class="col-sm-10" data-bind="with: preappraisalVM">
						<textarea data-bind="value: rqmt" name="rqmt" id="rqmt" class="form-control" ></textarea>
					</div>								
				</div>	
        	</form>
        </div>
    </div>
    <div class="form-module module-list">
        <div class="form-module-title">
            <p>送检检材</p>
        </div>
        <div class="form-content module-content">
        	<form class="form-horizontal">
        		<div class="form-group">
					<label class="col-sm-2 control-label evidName">名称：</label>
					<div class="col-sm-4">
						<input type="text" class="form-control evidenceName" />
					</div>
					<label class="col-sm-2 control-label">封存状态：</label>
					<div class="col-sm-4">
						<select  class="form-control status" required>
							<option value="0">物证袋封存</option>
							<option value="1">封条</option>
							<option value="2">未封存</option>
						</select>
					</div>	
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">数量：</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" value="1" readonly />
					</div>										
				</div>		
				<div class="form-group">
					<label class="col-sm-2 control-label input-choose" data-name=".check-material-radio">检材种类：</label>
					<div class="col-sm-10 check-material-radio">
						<div class="matter-content">
                            <div class="matter-module">
                                <div class="matter-module-option check-material">
                                    <div class="col-sm-4">
                                        <div class="rdio rdio-primary">
                                            <input type="radio" name="" value="电脑主机" id="">
                                            <label for="">电脑主机</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="rdio rdio-primary">
                                            <input type="radio" name="" value="笔记本电脑" id="">
                                            <label for="">笔记本电脑</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="rdio rdio-primary">
                                            <input type="radio" name="" value="移动硬盘" id="">
                                            <label for="">移动硬盘</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="rdio rdio-primary">
                                            <input type="radio" name="" value="硬盘" id="">
                                            <label for="">硬盘</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="rdio rdio-primary">
                                            <input type="radio" name="" value="U盘" id="">
                                            <label for="">U盘</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="rdio rdio-primary">
                                            <input type="radio" name="" value="SD存储卡（闪存）" id="">
                                            <label for="">SD存储卡（闪存）</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="rdio rdio-primary">
                                            <input type="radio" name="" value="手机" id="">
                                            <label for="">手机</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="rdio rdio-primary">
                                            <input type="radio" name="" value="平板电脑" id="">
                                            <label for="">平板电脑</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="rdio rdio-primary">
                                            <input type="radio" name="" value="SIM卡" id="">
                                            <label for="">SIM卡</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="rdio rdio-primary">
                                            <input type="radio" name="" value="数码设备(录音笔、相机、摄像机等)" id="">
                                            <label for="">数码设备(录音笔、相机、摄像机等)</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="rdio rdio-primary">
                                            <input type="radio" name="" value="伪基站设备" id="">
                                            <label for="">伪基站设备</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-12 other-position">
                                        <div class="rdio rdio-primary">
                                            <input type="radio" name="" value="其他" id="" class="other-position-radio" />
                                            <label for="">其他</label>
                                        </div>
                                        <input type="text" value="" class="other-input" readonly />
                                    </div>
                                </div>
                            </div>
                        </div>
					</div>																	
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">特征描述：</label>
					<div class="col-sm-10">
						<textarea class="form-control evidenceCharacteristic"></textarea>
					</div>								
				</div>		
				<div class="form-group">
					<label class="col-sm-2 control-label">备注说明：</label>
					<div class="col-sm-10">
						<textarea class="form-control evidenceRemark"></textarea>
					</div>								
				</div>	
        	</form>
        </div>
         <div class="add-material-content">
			<label class="col-sm-2 control-label"></label>
			<div class="col-sm-10"  style="display:none;">
				<button type="button" class="btn btn-color1 add-material-btn"><i class="fa fa-plus"></i>新增检材</button>	
			</div>								
		</div>
		<!-- <div class="material-template"></div> -->
    </div>
    <!-- <div class="btn-content">
        <button type="button" class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
        <button type="button" class="btn btn-color1" data-bind ="click:saveData"><i class="fa fa-check"></i>提交</button>
        <button type="button" class="btn btn-color1 saveDraft" ><i class="fa fa-check"></i>保存草稿</button>
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
	    	var url = "${pageContext.request.contextPath}/elecEVIDMgt/register/evidenceRegisterList.do";
	    	$(".index-iframe", window.parent.document).attr("src",url);
	    });
		
		//“其他”选项
		$(".module-list").on("click", ".check-material input[type='radio']", function(){
			if( $(this).hasClass("other-position-radio") ){
				$(this).parents(".module-list").find(".other-input").attr("readonly", false);
			}else{
				$(this).parents(".module-list").find(".other-input").attr("readonly", true);
			}
		});
		
		// 链接判断
	    var url = window.location.href;
	    if( url.indexOf("id=") != -1 ){
	    	$(".crumbs-text").html("当前位置：<a>电子物证管理</a><span>></span><a>物证预检登记</a><span>></span><a>修改</a>");
	    }
	
		function moduleNum(){
			var formContent = $(".module-list > .form-content");
			var formSize = formContent.size();
			for( var i = 0; i < formSize; i++){
				formContent.eq(i).find("input[type='radio']").attr("name", "radio"+i);
				var inputContent = formContent.eq(i).find("input[type='radio']");
				var inputSize = inputContent.size();
				for( var j = 0; j < inputSize; j++ ){
					inputContent.eq(j).attr("id", "radioMaterial"+i+j);
					inputContent.eq(j).next("label").attr("for", "radioMaterial"+i+j);
				}
			}
		}
		
		function bodyHeight(){
			var main = $(window.parent.document).find(".iframe-register");
			var mainheight = $("body").height()+100;
			main.height( mainheight );
		}

		$(function(){
			var moduleHtml = $(".module-content").html();
			//$(".material-template").html(moduleHtml);
			
			moduleNum();
			
			$(".add-material-btn").click(function(){
				var template = moduleHtml;
				var templateHtml = "";
				templateHtml += '<div class="form-content module-border">';
				templateHtml += '<div class="remove-btn"><i class="fa fa-times"></i></div>';
				templateHtml += template;
				templateHtml += '</div>';
				$(this).parents(".add-material-content").before(templateHtml);
				moduleNum();
				bodyHeight();
			});
			
			$(".module-list").on("click", ".remove-btn", function(){
				$(this).parent(".form-content").remove();
				bodyHeight();
			});
			
			$("#add-person").click(function(){
				$(this).parent().parent(".form-group").after('<div class="form-group">'
					+'<label class="col-sm-2 control-label">送检人：</label>'
					+'<div class="col-sm-2">'
					+'<input type="text" class="form-control userAlias" readonly required />'
					+'</div>'
					+'<label class="col-sm-1 control-label">职务：</label>'
					+'<div class="col-sm-2">'
					+'<input type="text" class="form-control userPost"  readonly required/>'
					+'</div>'
					+'<label class="col-sm-1 control-label">警察证号：</label>'
					+'<div class="col-sm-2">'
					+'<input type="text" class="form-control policeId"  readonly required />'
					+'</div>'
					+'</div>'
				);
				bodyHeight();
			});
			
			$(".form-horizontal").on("click", ".delete-personnel-btn", function(){
				$(this).parents(".form-group").remove();
				bodyHeight();
			});
			
			
			$.ajax({
				url:'${ pageContext.request.contextPath }/elecEVIDMgt/preappraisedEvid/preappraisedEvidDataList.do',
				type:'post',
				datatype:"json",
				data:{ "preappraisalId" : id },
				success:function(data){
					for(var i = 1 ; i<data.length ; i++){
				        var oBtn = $(".add-material-btn");
			        	oBtn.click();
					}
					console.log(data);
					for(var i = 0 ; i< data.length ; i++){
		        		 $(".module-list input[type='text']").eq(i*3).val(data[i].name);  
		        		$(".module-list textarea").eq(i*2).val(data[i].desc);
		        		$(".module-list textarea").eq(i*2+1).val(data[i].remarks);
		        		var value = data[i].type;
		        		$(".module-list > .form-content").eq(i).find("input[value='"+value+"']").attr("checked","checked");
		        		$(".module-list > .form-content").eq(i).find(".status").val(data[i].status);
					}
				}
			})
				
			
			$.ajax({
				url:'${ pageContext.request.contextPath }/elecEVIDMgt/preappraisalEntruster/loadPreappraisalentrusterList.do',
				type:'post',
				datatype:"json",
				data:{ "PreappraisalId" : id },
				success:function(data){
					for(var i = 1 ; i<data.length ; i++){
				        var oBtn = $("#add-person");
			        	oBtn.click();
					}
					for(var i = 0 ; i< data.length ; i++){
		        		$(".userAlias").eq(i).val(data[i].userAlias);
		        		$(".userPost").eq(i).val(data[i].userPost);
		        		$(".policeId").eq(i).val(data[i].policeId);
					}
				}
			})
			
			$.ajax({
				url:'${ pageContext.request.contextPath }/elecEVIDMgt/preappraisalAtt/loadPreappraisalAttData.do',
				type:'post',
				datatype:"json",
				data:{ "id" : id },
				success:function(data){
					var data = data.entity;
					for(var j = 0; j < data.length ; j++){
						var data2 = data[j];
						if(data2 == "" || data2 == undefined || data2 == null){
						}else{
			        		var fileList = $(".file-list");
		   	   				var fileType1 = data2.name.split(".")[data2.name.split(".").length-1];
							var allLength = data2.name.length;
							var length = fileType1.length+1;
							var dataName = data2.name.substring(0,allLength-length);
							var fileType = fileType1.toLowerCase();
							var dataId = data2.id;
							var imgArr = ["jpg", "jpeg", "png", "bmp"];
							var fileArr = ["doc", "docx", "xls", "xlsx", "ppt", "pptx", "pdf", "txt"];
							var videoArr = ["mov", "avi", "mp4", "wmv"];
							var html='';
							html += '<div class="list-content">';
							html += '<div class="list-img">';
							if($.inArray(fileType,imgArr)!= -1){
								html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/img.png">';
							} else if($.inArray(fileType,videoArr)!= -1){
								html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/video.png">';
							} else {
								html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/'+fileType+'.png">';
							}							
							html += '</div>';
							html += '<div class="list-name" title="'+dataName+'">';
							html += '<p><a href="${pageContext.request.contextPath}/elecEVIDMgt/preappraisalAtt/downPreappraisalAttData.do?id='+dataId+'">'+dataName+'</a></p>';
							html += '</div>';
							html += '</div>';
	   	   					fileList.prepend(html);
						}
					}
				}
			})
			
			$("#province").attr("disabled",true);
			$("#city").attr("disabled",true);
			
			//bodyHeight();
		}); 
		
	    var id = "${param.commonPreappraisalId}";
	    if(id == "" || id == undefined || id == null){
        	id = loadData("${ pageContext.request.contextPath }/deviceMgt/getUUID.do", {});
	    } 
        var preappraisalData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/preappraisal/loadPreappraisalData.do", { "id" : id });
        var preappraisalDataVM = ko.mapping.fromJS(preappraisalData);
		preappraisalDataVM.orgName = preappraisalData.orgName;
        preappraisalDataVM.entrustedDate = new Date();

		//省
	    var provinceData = loadData("${ pageContext.request.contextPath }/inquest/province/getOptionsData.do",{});
	    var provinceDataVM = {
	    		provinceList : ko.observableArray(provinceData),
	    		provinceId : ko.observable(440000)
	    }
	    
	    //市
	    var cityData = loadData("${ pageContext.request.contextPath }/inquest/city/getOptionsData.do",{ "provinceId" : 440000 });
	    var cityDataVM = {
	    		cityList : ko.observableArray(cityData),
	    		cityId : ko.observable(440100)
	    }
    
	    //区
	    var countyData = loadData("${ pageContext.request.contextPath }/inquest/county/getOptionsData.do",{ "cityId" : 440100 });
	    var countyDataVM = {
	    		countyList : ko.observableArray(countyData),
	    		countyId : ko.observable(preappraisalData.country)
	    }
	    
	    // 省，市联动changeProvince
	    function changeProvince(){
			//load room data
			  cityDataVM.cityList.removeAll();
		      cityData = loadData("${pageContext.request.contextPath}/inquest/city/getOptionsData.do",{ "provinceId" : $("#province").val() });
		      if(cityData==undefined || cityData==null)cityData=[];
		      cityDataVM.cityList(cityData);
		}
	    
	   // 市，区联动
	    function changeCity(){
	    	  countyDataVM.countyList.removeAll();
	    	  countyData = loadData("${pageContext.request.contextPath}/inquest/county/getOptionsData.do",{ "cityId" : $("#city").val() });
		      if(countyData==undefined || countyData==null)countyData=[];
		      countyDataVM.countyList(countyData);
	    }
		
	    
	    //获取空对象保存使用
        var vm = {
        	preappraisalVM : preappraisalDataVM,
    		provinceVM : provinceDataVM,
    		cityVM : cityDataVM,
    		countyVM : countyDataVM,
        }
        
        ko.applyBindings(vm);
	
		var save = 1;
		$(".saveDraft").click(function(){
			save = 0;
			vm.saveData();
		})
		
        vm.saveData = function(){
			$("button").attr("disabled", true);
			if(validateSubmittedData()){
				if(checkPolice()){
					bindDataVM();
		        	if ( saveData("${ pageContext.request.contextPath }/elecEVIDMgt/preappraisal/savePreappraisalData.do", preappraisalDataVM) ) {
			        	savePreappraisedEvid();
						//遍历建材
		    	    	saveEntrusterData();
		        		saveSuccess("${pageContext.request.contextPath}/elecEVIDMgt/register/evidenceRegisterList.do");
		        		//TODO  需要创建一个  电子物证（检材）鉴定    t_appraisal （仅对应单一检材）表单
		        	}
				}
			}else{
				saveFailure();
			}
        }
        
        //***********保存  送检检材信息 ***************//
        function savePreappraisedEvid(){
			var appraisalData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/loadDataById.do",{"id":""});
        	var arrList = new Array();
    		var radioNum = $(".module-list > .form-content").length;
        	for(var i = 0 ; i < radioNum ; i++){
        		var nowDate = new Date();
				var preappraisedEvidData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/preappraisedEvid/loadpreappraisedEvidData.do",{"id":""});
        		preappraisedEvidData.name = $(".module-list > .form-content").eq(i).find(".evidenceName").val();  //名称
        		preappraisedEvidData.desc = $(".module-list > .form-content").eq(i).find(".evidenceCharacteristic").val();   //描述
        		preappraisedEvidData.remarks = $(".module-list > .form-content").eq(i).find(".evidenceRemark").val();  //备注
        		preappraisedEvidData.preappraisalId = id;
        		preappraisedEvidData.type = $(".module-list > .form-content").eq(i).find(".check-material").find("input[type='radio']:checked").val();
        		
        		/* $(".module-list > .form-content").eq(i).each(function(){   //类型
        			var value = $(this).find("input[type='radio']:checked").val();
        			if(value != "" && value != undefined && value != null){
        				preappraisedEvidData.type = value;
        			}
        		}); */
        		arrList[i] = preappraisedEvidData;
        		if(save == 1){
					appraisalData.preappraisalId = id;  //记得赋值
					appraisalData.entrustedDate = nowDate;  //记得赋值
					appraisalData.tel = preappraisalDataVM.tel;
					appraisalData.orgId = preappraisalDataVM.orgId;
					appraisalData.caseSn = preappraisalDataVM.caseSn;
					appraisalData.orgName = preappraisalDataVM.orgName;
					appraisalData.caseName = preappraisalDataVM.caseName;
					appraisalData.evidName = preappraisedEvidData.name;  //记得赋值
					appraisalData.evidSn = "JC" + nowDate.Format("yyyy") + $("#caseSn").val().substr($("#caseSn").val().length-4) + survery(i+1);
					saveData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/saveData.do", appraisalData);
        		}
        		
        	}

			$.ajax({
				url:'${ pageContext.request.contextPath }/elecEVIDMgt/preappraisedEvid/savepreappraisedEvidData.do',
		        type:"post",
		        data:{"arrList":JSON.stringify(arrList)},
	            traditional: true,//属性在这里设置
				success:function(data){
				}
			})
        	
        }
        //***********保存  送检检材信息 ***************//
        
        
        //返回 后三位勘察号
        function survery(data){
        	if(data < 10){
        		data = "00" + data;
        		return data;
        	}
        	if(data < 100){
        		data = "0" + data;
        		return data;
        	}
        	return data;
        }
        
        
        
        
        
        
    	//***********保存  送检人信息*****************//
        function saveEntrusterData(){
        	var userAliasNum = $(".userAlias").length;
        	var arrList = new Array();
        	for( var i = 0; i < userAliasNum; i++){
        		var entrusterData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/preappraisalEntruster/loadPreappraisalEntrusterData.do",{ "id" :""});
        		entrusterData.userAlias = $(".userAlias").eq(i).val();
        		entrusterData.policeId = $(".policeId").eq(i).val();
        		entrusterData.preappraisalId = id;
        		arrList[i] = entrusterData;
        	}
			$.ajax({
				url:'${ pageContext.request.contextPath }/elecEVIDMgt/preappraisalEntruster/savePreappraisalEntrusterData.do',
		        type:"post",
		        data:{"arrList":JSON.stringify(arrList)},
	            traditional: true,//属性在这里设置
				success:function(data){
				}
			})
        }
    	function checkPolice(){
        	var userAliasNum = $(".userAlias").length;
        	for( var i = 0; i < userAliasNum; i++){
				for(var j = 0; j < userAliasNum; j++ ){
					if(i != j){
						if($(".policeId").eq(j).val() == $(".policeId").eq(i).val()){
							chekcPoliceFaile();
							return false;
						}
					}
				}
        	}
        	return true;
    	}
		function chekcPoliceFaile() {
			$("html, body").animate({ scrollTop: 0 }, 200);
			promptContent("警号重复,每个人所对应的警察证号码是不一样的");
		 	$(".alert").removeClass("alert-success").addClass("alert-danger");
		 	$(".promptDiv").slideDown();
		    setTimeout(function(){
			 	$(".promptDiv").slideUp();
		    },1500);

		}
    	//***********上传  送检人信息*****************//
        
    	
    	//***********赋值初始化*****************//
		function bindDataVM(){
			preappraisalDataVM.id = id;
			preappraisalDataVM.orgId = "${sessionScope.loginUser.orgId}";
			preappraisalDataVM.orgName = "${sessionScope.loginUser.orgName}";
			preappraisalDataVM.province = $("#province").val();
			preappraisalDataVM.city = $("#city").val();
			preappraisalDataVM.country = $("#county").val();
			preappraisalDataVM.status = save;
			preappraisalDataVM.creatorName = "${sessionScope.loginUser.userName}";
			preappraisalDataVM.creatorId = "${sessionScope.loginUser.userId}";
			preappraisalDataVM.creatorAlias = "${sessionScope.loginUser.userAlias}";
			preappraisalDataVM.createdDate = new Date();
		}
    	//***********赋值初始化*****************//
        
        /*文件删除*/
      $('.file-list').on('click','.remove',function(){
		  var  fileid = $(this).attr('data-id');
	  	  var  filethis = $(this);
	  	  console.log(fileid);
	  	  $.ajax({
	  		  url:'${pageContext.request.contextPath}/elecEVIDMgt/preappraisalAtt/deletePreappraisalAttData.do',
	  		  data:{'id':fileid},
	  		  datatype:'json',
	  		  type:'post',
	  		  success:function(data){
	  			  console.log(data);
	  			  if( data['status'] ){
	  				  //remonve删除
					filethis.parent(".list-content").remove();
	  			  }
					bodyHeight();
	  		  },
	  		  error:function(){
	  			  alert('浏览器缓存，上传失败，请刷新浏览器');
	  		  }
	  	  })
        })    	 
        /*文件删除结束*/
	</script>
</body>
</html>