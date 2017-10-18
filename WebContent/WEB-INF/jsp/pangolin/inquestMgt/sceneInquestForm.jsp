<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>现场勘验表单</title>
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
    <script src="<c:url value="/resources/frameworks/pangolin/js/ajaxfileupload.js" />"></script>
	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />	
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>现场勘验</a><span>></span><a>新增</a>
        </p>
    </div>
    <div class="form-content">
	    <form class="form-horizontal">					
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>现场勘验号：</label>
				<div class="col-sm-4" data-bind="with:inquestVM">
					<input type="text" class="form-control illegalCharacter" data-bind="value:sn" required/>
				</div>	
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>勘验日期：</label>
				<div class="col-sm-4" data-bind="with:inquestVM">
					<input class="form-control datetimepicker" data-bind="dateTimePicker:operatedDate" required></input>
				</div>							
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>勘验人：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<select id="userId"
							class="form-control" required
							data-bind="options:userList,optionsValue:'userId',optionsText:'userAlias',value:userId,optionsCaption:'--请选择--',event:{change:changeUser}">
					</select>
				</div>	
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>案件名称：</label>
				<div class="col-sm-4" data-bind="with:inquestVM">
					<input class="form-control" data-bind="value:caseName" required></input>
				</div>							
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">文件上传：</label>
				<div class="col-sm-4">
                	<input type="text" placeholder="" class="form-control" id="enterFile" />
                </div>
                <div class="col-sm-6 file-btn">
                	<button type="button" class="btn btn-color1 file-browse"><i class="fa fa-folder-open-o"></i>浏览</button>
                	<button type="button" class="btn btn-color2" id="uploadFile"><i class="fa fa-upload"></i>上传</button>
                	<input type="file" class="input-file" id="file" name="file" />
                </div>
				<div class="comfile">
					<div class="okfile"></div>
					<div class="clear"></div>
				</div>				
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">区域：</label>
				<!-- <div class="col-sm-2" data-bind="with:provinceVM">
						<select id="province" class="form-control" data-bind="options:provinceList,optionsValue:'provinceId',optionsText:'name',value:provinceId,optionsCaption:'--请选择--', event:{change:changeProvince}" disabled></select>
		        </div>
		        <div class="col-sm-2" data-bind="with:cityVM">
						<select id="city" class="form-control" data-bind="options:cityList,optionsValue:'cityId',optionsText:'name',value:cityId,optionsCaption:'--请选择--' , event:{change:changeCity}" disabled></select>
		        </div>	 -->
		        <div class="col-sm-4" data-bind="with:countyVM">
					<select id="county" class="form-control" data-bind="options:countyList,optionsValue:'countyId',optionsText:'name',value:countyId,optionsCaption:'--请选择--' "></select>
		        </div>									
			</div>
		</form>
	</div>
	<div class="btn-content">
        <button class="btn btn-color2 back-btn" data-bind="click: backToList"><i class="fa fa-chevron-left"></i>返回</button>
        <button class="btn btn-color1" data-bind="click: saveData"><i class="fa fa-check"></i>提交</button>
    </div>
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
	<script>
		// 链接判断
	    var url = window.location.href;
	    if( url.indexOf("id=") != -1 ){
	    	$(".crumbs-text").html("当前位置：<a>现场勘验</a><span>></span><a>修改</a>");
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
		
		var inquestData = loadData("${pageContext.request.contextPath}/inquest/loadInquestData.do",{ "id" : "${param.id}" });
	    var inquestDataVM = ko.mapping.fromJS(inquestData);
	    
	    var inquestDocData = loadData("${pageContext.request.contextPath}/inquest/document/getDocumentsByInquestIdData.do",{ "id" : "${param.id}" });
        var docs = "";
	    
        if( inquestDocData.length != 0 ){
        	for(var i=0;i<inquestDocData.length;i++){
    	    	docs += '<div class="ccflie">';
    	    	docs +='<div class="col-sm-10 col-sm-offset-2">'
    	    	     +'<a href="${pageContext.request.contextPath}/inquest/document/downloadDocumentData.do?id='+inquestDocData[i]['id']+'"><span id="fileNameText">'+inquestDocData[i]['name'] +'</span></a>'
    	    	     +'<button type="button" class="remove" data-id="' + inquestDocData[i].id +'" >×</button></div>';
    	    	docs +='</div>';
    	    }
    	    
    	    $('.okfile').append(docs);
    		$('.comfile').show();
        }
	    
	    var userData = loadData("${pageContext.request.contextPath}/system/user/getAllUserData.do",{});
	    var userDataVM = {
	    		userList : ko.observableArray(userData),
	    		userId : ko.observable(inquestData.operatorId)
	    }
	    
	    //省
	   /*  var provinceData = loadData("${pageContext.request.contextPath}/inquest/province/getOptionsData.do",{});
	    var provinceDataVM = {
	    		provinceList : ko.observableArray(provinceData),
	    		provinceId : ko.observable(440000)
	    }  */
	    
	    //市
	   /*  var cityData = loadData("${pageContext.request.contextPath}/inquest/city/getOptionsData.do",{ "provinceId" : 440000});
	    var cityDataVM = {
	    		cityList : ko.observableArray(cityData),
	    		cityId : ko.observable(440100)
	    } */
	    
	    //区
	    var countyData = loadData("${pageContext.request.contextPath}/inquest/county/getOptionsData.do",{ "cityId" : 440100 });
	    countyData.unshift({'id':'','cityId':440100,'countyId':440100,'name':'直属'});
	   
	    var countyId = ( inquestData.county == null || inquestData.county == '' ) ? 440100 : inquestData.county;
	    var countyDataVM = {
	    		countyList : ko.observableArray(countyData),
	    		countyId : ko.observable(countyId)
	    }
	    
	    // 省，市联动
	    /* function changeProvince(){
			//load room data
			  cityDataVM.cityList.removeAll();
		      cityData = loadData("${pageContext.request.contextPath}/inquest/city/getOptionsData.do",{ "provinceId" : $("#province").val() });
		      if(cityData==undefined || cityData==null)cityData=[];
		      cityDataVM.cityList(cityData);
		} */
	    
	   // 市，区联动
	    /* function changeCity(){
	    	  countyDataVM.countyList.removeAll();
	    	  countyData = loadData("${pageContext.request.contextPath}/inquest/county/getOptionsData.do",{ "cityId" : $("#city").val() });
		      if(countyData==undefined || countyData==null)countyData=[];
		      countyDataVM.countyList(countyData);
	    } */
	    
	    var vm = {
	    		inquestVM : inquestDataVM,
	    		userVM : userDataVM,
	    		//provinceVM : provinceDataVM,
	    		//cityVM : cityDataVM,
	    		countyVM : countyDataVM
	    }
	    
	    vm.saveData = function(){ 
	    	$("button").attr("disabled", true);
	        if ( validateSubmittedData() ) {
	        	bindDataVM();
	        	if (saveData("${pageContext.request.contextPath}/inquest/saveInquestData.do", inquestDataVM)) {
					saveSuccess("${pageContext.request.contextPath}/inquestMgt/sceneInquestList.do");
				} else {
					saveFailure();
				}
	        } else {
	        	saveFailure();
	        }
		}
		
		vm.backToList = function(){//返回
			$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/inquestMgt/sceneInquestList.do');
		}
		
		ko.applyBindings(vm);
		
		function bindDataVM(){
			inquestDataVM.province = 440000;
			inquestDataVM.city = 440100;
			inquestDataVM.county = $("#county").val() == 440100 ? null : $("#county").val();
			inquestDataVM.operatorId = $("#userId").val();
			inquestDataVM.creatorName = "${sessionScope.loginUser.userName}";
			inquestDataVM.creatorId = "${sessionScope.loginUser.userId}";
			inquestDataVM.creatorAlias = "${sessionScope.loginUser.userAlias}";
			inquestDataVM.status = 1;
		}
		
		function changeUser(){
			var index = $('#userId option:selected').index();
			inquestDataVM.operatorName = userData[index-1]['userName'];
			inquestDataVM.operatorAlias = userData[index-1]['userAlias'];
			//$("#operatorName").val(userData[index-1]['userName']);
		}
		
		
		
		
		 /*文件上传*/
		 $(".file-browse").click(function(){
			 $("#enterFile").trigger("click");
		 })
	     $("#enterFile").click(function(){
	    	$("#file").click();
	    	$('#file').change(function(){
	    	 	if($('#file').val() !=''){
	          		$('#enterFile').val($('#file').val());
	          	}else{
	          		$('#enterFile').val('');
	          	}
		    })
	    }); 
	    $('#file').change(function(){
    	 	if($('#file').val() !=''){
          		$('#enterFile').val($('#file').val());
          	}else{
          		$('#enterFile').val('');
          	}
	    	$('#enterFile').val($(this).val());
	    }); 
	    
	    
        $('#uploadFile').click(function(){	   
          if($('#file').val() ==''){
      		  $("html, body").animate({ scrollTop: 0 }, 200);
  				promptContent("没有文件上传！");
  				$(".alert").addClass("alert-danger").removeClass("alert-success");
  				$(".promptDiv").slideDown();
  				return false;
      	  }else{
   			$.ajaxFileUpload({
   				url:'${pageContext.request.contextPath}/inquest/document/uploadDocumentData.do',
   				data:{
   					'id' : inquestData.id,
   					'creatorId' : '${sessionScope.loginUser.userId}',
   					'creatorName' : '${sessionScope.loginUser.userName}',
   					'creatorAlias' : '${sessionScope.loginUser.userAlias}'
   					},
   				secureuri:false,
   				fileElementId:'file',//file标签的id
   				dataType: 'json',//返回数据的类型
   				success: function (data) {
   					$('#enterFile').val('');//上传成功就清空查看栏
					var html='';
					html +='<div class="ccflie">';
					html +='<div class="col-sm-10 col-sm-offset-2">'
					     +'<a href="${pageContext.request.contextPath}/inquest/document/downloadDocumentData.do?id='+data['id']+'"><span id="fileNameText">'+data.fileName +'</span></a>'
					     +'<button type="button" data-id="'+data.id+'" class="remove" aria-hidden="true">×</button></div>';
					html +='</div>';
					$('.okfile').append(html);
					$('.comfile').show();  						
   				},
   				error: function (data, status, e) {
   					alert(e);
   				}
   			});  	
      	  }
        })
        
        
         /*文件删除*/
      $('.okfile').on('click','.remove',function(){
    	  var  fileid = $(this).attr('data-id');
    	  var  filethis = $(this);
    	  $.ajax({
    		  url:'${pageContext.request.contextPath}/inquest/document/removeDocumentData.do',
    		  data:{'id':fileid},
    		  datatype:'json',
    		  type:'post',
    		  success:function(data){
    			  if( data['status'] ){
    				  filethis.closest('.ccflie').remove();
    			  }
    		  },
    		  error:function(){
    			  alert('删除文件失败');
    		  }
    	  })
      })
      /*文件删除结束*/
	
	 	
	
	</script>
</body>
</html>