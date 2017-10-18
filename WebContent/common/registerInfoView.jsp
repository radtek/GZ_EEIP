<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<!-- 电子物证管理-综合鉴定信息-登记信息 -->
<div class="form-module">
    <div class="form-module-title">
        <p>基本信息</p>
    </div>
    <div class="form-content">
    	<form class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-2 control-label">委托鉴定单位：</label>
				<div class="col-sm-4" data-bind="with: preappraisalVM">
					<input type="text" data-bind="value: orgName" name="orgName" id="orgName" class="form-control" readonly/>
				</div>	
				<label class="col-sm-2 control-label">委托时间：</label>
				<div class="col-sm-4" data-bind="with: preappraisalVM">
					<input id="entrustedDate" name="entrustedDate" class="form-control datetimepicker" data-bind="dateTimePicker:entrustedDate" readonly  />
				</div>			
			</div>			
			<div class="form-group">
				<label class="col-sm-2 control-label">送检人：</label>
				<div class="col-sm-4" >
					<input class="form-control userAlias" readonly/>
				</div>	
				<label class="col-sm-2 control-label">警察证：</label>
				<div class="col-sm-2">
					<input type="text" class="form-control policeId" readonly/>
				</div>
				<div class="col-sm-2" style="display:none;">
					<button type="button" class="btn btn-color1 upload" id="add-person"><i class="fa fa-plus"></i>添加</button>
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
					optionsCaption:'--请选择--' " disabled></select>
			      	</div>
				<div class="col-sm-1 div-label">
					区
				</div>			
			</div>	
			<div class="form-group">
				<label class="col-sm-2 control-label">详细地址：</label>
				<div class="col-sm-10" data-bind="with: preappraisalVM">
					<input type="text" data-bind="value: addr" name="addr" id="addr" class="form-control"  readonly/>
				</div>								
			</div>	
			<div class="form-group">
				<label class="col-sm-2 control-label">邮政编码：</label>
				<div class="col-sm-4" data-bind="with: preappraisalVM">
					<input type="text" data-bind="value: zipCode" name="zipCode" id="zipCode" class="form-control" readonly/>
				</div>
				<label class="col-sm-2 control-label">联系电话：</label>
				<div class="col-sm-4" data-bind="with: preappraisalVM">
					<input type="text" data-bind="value: tel" name="tel" id="tel" class="form-control" readonly/>
				</div>								
			</div>
			<div class="form-group">	
				<label class="col-sm-2 control-label">传真号码：</label>
				<div class="col-sm-4" data-bind="with: preappraisalVM">
					<input type="text" data-bind="value: fax" name="fax" id="fax" class="form-control" readonly/>
				</div>									
			</div>	
			<div class="form-group">
				<label class="col-sm-2 control-label">案件名称：</label>
				<div class="col-sm-4" data-bind="with: preappraisalVM">
					<input type="text" data-bind="value: caseName" name="caseName" id="caseName" class="form-control" readonly/>
				</div>
				<label class="col-sm-2 control-label">案件编号：</label>
				<div class="col-sm-4" data-bind="with: preappraisalVM">
					<input type="text" data-bind="value: caseSn" name="caseSn" id="caseSn" class="form-control" readonly/>
				</div>										
			</div>	
			<div class="form-group">
				<label class="col-sm-2 control-label">简要说明：</label>
				<div class="col-sm-10" data-bind="with: preappraisalVM">
					<textarea data-bind="value: explanation" name="explanation" id="explanation" class="form-control" readonly></textarea>
				</div>								
			</div>		
			<div class="form-group">
				<label class="col-sm-2 control-label">鉴定要求：</label>
				<div class="col-sm-10" data-bind="with: preappraisalVM">
					<textarea data-bind="value: rqmt" name="rqmt" id="rqmt" class="form-control" readonly></textarea>
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
						<input type="text" class="form-control" readonly/>
					</div>
					<label class="col-sm-2 control-label">数量：</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" value="1" readonly  />
					</div>										
				</div>		
				<div class="form-group">
					<label class="col-sm-2 control-label">封存状态：</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" value="物证袋封装" readonly />
					</div>												
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label input-choose" data-name=".check-material-radio">检材种类：</label>
					<div class="col-sm-10 check-material-radio">
						<div class="matter-content">
                            <div class="matter-module">
                                <div class="matter-module-option">
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
                                            <input type="radio" name="" value="其他" id="">
                                            <label for="">其他</label>
                                        </div>
                                        <input type="text" value="" class="other-input" />
                                    </div>
                                </div>
                            </div>
                        </div>
					</div>																	
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">特征描述：</label>
					<div class="col-sm-10">
						<textarea class="form-control" readonly></textarea>
					</div>								
				</div>		
				<div class="form-group">
					<label class="col-sm-2 control-label">备注说明：</label>
					<div class="col-sm-10">
						<textarea  class="form-control" readonly></textarea>
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
	<div class="material-template"></div>
</div>
<div class="upload-module">
    <div class="module-title">
        <p>案情文件</p>
    </div>
    <div class="file-list">
    </div>
</div>
<div class="btn-content">
    <button type="button" class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
</div>
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
		$(function(){
			
			var moduleHtml = $(".module-content").html();
			$(".material-template").html(moduleHtml);
			
			moduleNum();
			
			/* 标签页事件和样式-开始 */
			var clickStatus = 0;	//点击状态
			var dataStatus = 1;		//数据状态
			tabsContent(clickStatus,dataStatus);
			/* 标签页事件和样式-结束  */
			
			$(".add-material-btn").click(function(){
				var template = $(".material-template").html();
				var templateHtml = "";
				templateHtml += '<div class="form-content module-border">';
				templateHtml += template;
				templateHtml += '</div>';
				$(this).parents(".add-material-content").before(templateHtml);
				moduleNum();
			});
			
			
			$("#add-person").click(function(){
				$(this).parent().parent(".form-group").after('<div class="form-group">'
										+'<label class="col-sm-2 control-label">送检人：</label>'
										+'<div class="col-sm-4">'
										+'<input class="form-control userAlias" readonly/>'
										+'</div>'
										+'<label class="col-sm-2 control-label">警察证：</label>'
										+'<div class="col-sm-2">'
										+'<input type="text" class="form-control policeId" readonly/>'
										+'</div>'
										+'</div>'
				);
			});
			
			$(".form-horizontal").on("click", ".delete-personnel-btn", function(){
				$(this).parents(".form-group").remove();
			});
			
			$(".back-btn").click(function(){
		    	var url = "${pageContext.request.contextPath}/evidenceMgt/inTheLibrary/inTheLibraryList.do";
		    	$(".index-iframe", window.parent.document).attr("src",url);
		    });
			
			$.ajax({
				url:'${ pageContext.request.contextPath }/elecEVIDMgt/preappraisalEntruster/loadPreappraisalentrusterList.do',
				type:'post',
				datatype:"json",
				data:{ "PreappraisalId" : appraisalData.preappraisalId },
				success:function(data){
					for(var i = 1 ; i<data.length ; i++){
				        var oBtn = $("#add-person");
			        	oBtn.click();
					}
					for(var i = 0 ; i< data.length ; i++){
		        		$(".userAlias").eq(i).val(data[i].userAlias);
		        		$(".policeId").eq(i).val(data[i].policeId);
					}
				}
			})
			
			$.ajax({
				url:'${ pageContext.request.contextPath }/elecEVIDMgt/preappraisedEvid/preappraisedEvidDataList.do',
				type:'post',
				datatype:"json",
				data:{ "preappraisalId" : appraisalData.preappraisalId },
				success:function(data){
					for(var i = 1 ; i<data.length ; i++){
				        var oBtn = $(".add-material-btn");
			        	oBtn.click();
					}
					for(var i = 0 ; i< data.length ; i++){
		        		$(".module-list input[type='text']").eq(i*4).val(data[i].name); 
		        		$(".module-list textarea").eq(i*2).val(data[i].desc);
		        		$(".module-list textarea").eq(i*2+1).val(data[i].remarks);
		        		var value = data[i].type;
		        		$(".module-list > .form-content").eq(i).find("input[value='"+value+"']").attr("checked","checked");
					}
				}
			})
			
			$.ajax({
				url:'${ pageContext.request.contextPath }/elecEVIDMgt/preappraisalAtt/loadPreappraisalAttData.do',
				type:'post',
				datatype:"json",
				data:{ "id" : appraisalData.preappraisalId },
				success:function(data){
					var data = data.entity;
					for(var j = 0; j < data.length ; j++){
						var data2 = data[j];
						if(data2 != "" && data2 != undefined && data2 != null){
			        		var fileList = $(".file-list");
		   					var listHtml = "";
		   					listHtml += '<div class="list-content">';
		   					listHtml += '<div class="list-name"><a href="${pageContext.request.contextPath}/elecEVIDMgt/preappraisalAtt/downPreappraisalAttData.do?id='+data2.id+'"><p>' + data2.name + '</p></a>';
		   					listHtml += '</div>';
	   	   					fileList.prepend(listHtml);
						}
					}
				}
			})
			
			for(var i = 1 ; i < 15 ; i++){
				var check = $("input[type='radio']")
				$(check).attr("disabled","disabled") //禁用
			}
		}); 
		
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
		
		preappraisalId="${param.commonPreappraisalId}";
	    var id = preappraisalId;
		var appraisalData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/loadDataById.do",{"id":id});
		var preappraisalData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/preappraisal/loadPreappraisalData.do", { "id" : appraisalData.preappraisalId });
        
        var appraisalDataVM = ko.mapping.fromJS(appraisalData);
        var preappraisalDataVM = ko.mapping.fromJS(preappraisalData);

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
        	appraisalVM : appraisalDataVM,
        	preappraisalVM : preappraisalDataVM,
    		provinceVM : provinceDataVM,
    		cityVM : cityDataVM,
    		countyVM : countyDataVM,
        }
        
        ko.applyBindings(vm);
	

	</script>
