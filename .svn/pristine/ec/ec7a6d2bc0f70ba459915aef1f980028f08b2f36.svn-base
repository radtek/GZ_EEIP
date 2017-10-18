<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>知识管理-修改表单</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
  	<script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script> 
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>	
    <script src="<c:url value="/resources/frameworks/pangolin/js/ajaxfileupload.js" />"></script>
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/knowledgeMgt/fileMgt-form.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>知识管理</a><span>></span><a>知识文件管理</a><span>></span><a>修改</a>
        </p>
    </div>
    <div class="form-content">
        <form class="form-horizontal">
             <div class="form-group">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>文件编号：</label>
                <div class="col-sm-4">
                    <input type="text" placeholder="" class="form-control" readonly  data-bind="value:sn" required />
                </div>
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>文件名称：</label>
                <div class="col-sm-4">
                    <input type="text" placeholder="" class="form-control" data-bind="value:name" required />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>文件类型：</label>
                <div class="col-sm-4">
                    <select class="form-control dirSelect" data-bind="value:dirId" required disabled>
                        
                    </select>
                </div>
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>年份：</label>
                <div class="col-sm-4">
                    <input type="text" placeholder="" class="form-control datetimepicker" data-bind="value:year" required/>
                </div>
            </div>
            <!-- <div class="form-group">
                <label class="col-sm-2 control-label">原文件编号：</label>
                <div class="col-sm-4">
                    <input type="text" placeholder="" class="form-control" id="orginalSn" readonly/>
                </div>
            </div> -->
             <div class="form-group">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>文件上传：</label>
                <div class="col-sm-4">
                	<input type="text" placeholder="" class="form-control input-text form-input-text" readonly required/>
                </div>
                <div class="col-sm-6 file-btn">
                	<button type="button" class="btn btn-color1 file-browse"><i class="fa fa-folder-open-o"></i>浏览</button>
                	<button type="button" id="uploadFile" class="btn btn-color2"><i class="fa fa-upload"></i>上传</button>
                	<input type="file" name="file" id="file" class="input-file" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">关联文件：</label>
                <div class="col-sm-10">
                    <div class="associated-file-content">
                    	<ul class="associated-file-list list-width-50">
                    		
                    	</ul>
                    	<div class="add-associated-file">
                    		<button type="button" class="btn btn-color1 add-file-btn"><i class="fa fa-plus"></i>添加</button>
                    	</div>
                    </div>
                    <div class="add-content">
                    	<div class="search-content">
			                <div class="form-group">
			                    <label class="col-sm-1 control-label">关键字</label>
			                    <div class="col-sm-3">
			                        <input type="text" placeholder="" class="form-control" id="key"/>
			                    </div>
			                    <label class="col-sm-2 control-label">文件类型</label>
			                    <div class="col-sm-3">
			                        <select class="form-control dirSelect" id="dirSelect">
			                            
			                        </select>
			                    </div>
			                    <div class="col-sm-3">
			                    	<button type="button" class="btn btn-color1 search"><i class="fa fa-search"></i>查询</button>
			                    	<button type="button" class="btn btn-color2 hide-btn"><i class="fa fa-times"></i>收起</button>
			                    </div>
			                </div>
					    </div>
					    <ul class="all-file-list list-width-50">
				       		
				       	</ul>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>修改原因：</label>
                <div class="col-sm-10">
                    <textarea class="form-control" data-bind="value:reason" required></textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>修改内容：</label>
                <div class="col-sm-10">
                    <textarea class="form-control" data-bind="value:content" required></textarea>
                </div>
            </div>
             <div class="form-group opinion">
                <label class="col-sm-2 control-label">审核意见：</label>
                <div class="col-sm-10">
                    <textarea class="form-control" data-bind="value:opinion" readonly></textarea>
                </div>
            </div>
        </form>
        <input type="text" data-bind="value:extensions" style="display:none">
        <input type="text" data-bind="value:path" style="display:none">
    </div>
    <div class="btn-content">
        <button type="button" class="btn btn-color2 back-btn" data-bind="click : backToListData"><i class="fa fa-chevron-left"></i>返回</button>
       	<button type="button" class="btn btn-color1" data-bind="click: saveData"><i class="fa fa-check"></i>提交</button>
    </div>
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
    <script>
    	$('.datetimepicker').datetimepicker({
	       format: 'YYYY',
	    });
    	
	    var docData = loadData("${pageContext.request.contextPath}/tmpDocOperationLog/loadTmpDocOperationLogData.do", { "id" : "${param.id}" });
	    var docRelationships = docData.docRelationships;
	    var documents = docData.documents;
	    var vm = ko.mapping.fromJS(docData);
	    
	    var dirData = loadData("${pageContext.request.contextPath}/directory/directoryGridData.do", {});
	    
	    var dirHtml = '';
	    for(var i=0;i<dirData.length;i++){
	    	dirHtml += '<option value="'+dirData[i]['id']+'">'+dirData[i]['name']+'</option>';
	    }
	    
	    $(".dirSelect").html(dirHtml);
	    
	    /* var uploadHtml = '<div class="ccflie"><div class="col-sm-2"></div><div class="col-sm-10">'
	                    +'<a href="${pageContext.request.contextPath}/tmpDocOperationLog/downloadData.do?id='+docData.id+'"><span id="fileNameText">'+docData.name +'</span></a></div></div>';
		$('.okfile').html(uploadHtml);
		$('.comfile').show();  */
		$(".input-text").val(docData.name);	
	    
	    vm.saveData = function(){
	  	  $("button").attr("disabled", true);
	  	        bindDataToVM();
		        if ( validateSubmittedData() ) {
		        	if (saveData("${pageContext.request.contextPath}/tmpDocOperationLog/saveTmpDocOperationLogData.do", vm)) {
						saveSuccess("${pageContext.request.contextPath}/knowledgeMgt/fileMgt/fileMgtList.do");
					} else {
						saveFailure();
					}
		        } else {
		        	saveFailure();
		        } 
	    }
	    
	    vm.backToListData = function(){
	  	  $('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/knowledgeMgt/fileMgt/fileMgtList.do');
	    }
	
	    ko.applyBindings(vm); 
	    
	    function bindDataToVM(){
	    	vm.docRelationships = docRelationships;
	    	vm.creatorName = "${sessionScope.loginUser.userName}";
			vm.creatorId = "${sessionScope.loginUser.userId}";
			vm.creatorAlias = "${sessionScope.loginUser.userAlias}";
	    	vm.type = 1;
	    	vm.status = 1;
	    	vm.delFlag = 0;
	    	vm.year = $(".datetimepicker").val() ;
	    }
	    
	    var dirId = '';
	    
	    $("#dirSelect").change(function(){
	    	dirId = $(this).val();
	    })
	    
	    $(".search").click(function(){
	    	$.ajax({
	    		url:'${pageContext.request.contextPath}/document/getDocumentByKey.do',
	    		type:'post',
	    		datatype:'json',
	    		data:{'dirId': dirId,'key':$("#key").val().replace(/\s+/g, "")},
	    		success:function(data){
	    			 var docs = data.entity;
	    			 $(".all-file-list").html('');
	    			 var docHtml = '';
	    			 if(docs.length > 0){
	    		        for(var i=0;i<docs.length;i++){
	    		        	if ( docs[i]['id'] != docData.docId ) {
	    	        			docHtml += '<li><p><span id="'+docs[i]['id']+'">'+docs[i]['name']+'</span></p></li>';
	    	        		}
	    		        }
	    		     }
	    		     $(".all-file-list").html(docHtml);
	    		}
	    	})
	    });
    
        var docHtml = '';
        var docs = loadData("${pageContext.request.contextPath}/system/assessibility/document/documentGridCacheData.do", {  });
        if(docs.length > 0){
        	for(var i=0;i<docs.length;i++){
        		if ( docs[i]['id'] != docData.docId ) {
        			docHtml += '<li><p><span id="'+docs[i]['id']+'">'+docs[i]['name']+'</span></p></li>';
        		}
        		
        	}
        }
        $(".all-file-list").html(docHtml);
    
        $(".file-browse").click(function(){
	    	$(".input-file").click();
	    	$('.input-file').change(function(){
	    	 	if($('.input-file').val() !=''){
	          		$('.input-text').val($('.input-file').val());
	          	}else{
	          		$('.input-text').val('');
	          	}
		    })
	    }); 
	    $('.input-file').change(function(){
   	 		if($('.input-file').val() !=''){
         		$('.input-text').val($('.input-file').val());
         	}else{
         		$('.input-text').val('');
         	}
	    	//$('.input-text').val($(this).val());
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
 				url:'${pageContext.request.contextPath}/tmpDocOperationLog/tmpDocOperationLogUploadData.do',
 				data:{
 					'id' : docData.id,
 					'type':1,
 					'creatorId' : '${sessionScope.loginUser.userId}',
 					'creatorName' : '${sessionScope.loginUser.userName}',
 					'creatorAlias' : '${sessionScope.loginUser.userAlias}'
 					},
 				secureuri:false,
 				fileElementId:'file',//file标签的id
 				dataType: 'json',//返回数据的类型
 				success: function (data) {
 					vm.path = data.path;
 					vm.extensions = data.extensions;
					$(".input-text").val(data.fileName);	
					/* var html='';
					html +='<div class="ccflie">';
					html +='<div class="col-sm-10 col-sm-offset-2"><a href="${pageContext.request.contextPath}/tmpDocOperationLog/downloadData.do?id='+docData.id+'"><span id="fileNameText">'+data.fileName +'</span></a></div>';
					html +='</div>';
					$('.okfile').html(html);
					$('.comfile').show();  	 */
 				},
 				error: function (data, status, e) {
 					alert(e);
 				}
 			});  		
      	  }
 			  	   	  
      })
        
        $(".add-file-btn").click(function() {
			$(this).parents(".associated-file-content").siblings(".add-content").show();
		});

		$(".hide-btn").click(function() {
			$(this).parents(".add-content").hide();
		});
		
		//复写
		if( documents.length > 0 ){
			for(var i=0;i<documents.length;i++){
				$(".associated-file-list").prepend("<li><p id='"+ documents[i]['id'] +"'>"+ documents[i]['name'] +"</p><span data-id='"+ documents[i]['id'] +"'><i class='fa fa-times'></i></span></li>");
			}
		}
                
        $(".all-file-list").on("click", "span", function(){
        	var text = $(this).text();
        	var id = $(this).attr("id");
        	if($(this).parents(".add-content").siblings(".associated-file-content").find(".associated-file-list").find("#" + id).text() == "undefined" ||
        	$(this).parents(".add-content").siblings(".associated-file-content").find(".associated-file-list").find("#" + id).text() == "" ){
        		$(this).parents(".add-content").siblings(".associated-file-content").find(".associated-file-list").append(
        				"<li><p id='"+ id +"' >"+ text +"</p><span data-id='"+id+"'><i class='fa fa-times'></i></span></li>");
        		docRelationships.push({'id':null,'srcDocId':'','relevantDocId':id});
        	}
        	
        });
        
        $(".associated-file-list").on("click", "span", function(){
        	var id = $(this).attr('data-id');
        	$(this).parent("li").remove();
        	for(var i=0;i<docRelationships.length;i++){
        		if(docRelationships[i]['relevantDocId'] == id){  
        			docRelationships.splice(i, 1);
					break;
        		}
        	}
        });
        
        
          
    </script>
</body>
</html>