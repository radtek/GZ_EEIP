<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>其他档案信息</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/ajaxfileupload.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
  	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/deviceMgt/deviceMgt-form.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>设备与环境管理</a><span>></span><a>设备管理</a><span>></span><a>查看</a>
        </p>
    </div>
    <div class="main-content" data-num="1">
        <jsp:include page="/common/deviceMgtLeftNav.jsp"></jsp:include>
        <div class="right-form">
            <div class="right-content right-padding">
                <div class="upload-module">
                    <div class="module-title">
                        <p>设备档案封面及目录</p>
                    </div>
                    <div class="file-list">
                        <%-- <div class="list-content">
                            <div class="list-img">
                                <img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/deviceMgt/file.png" alt="" />
                            </div>
                            <div class="list-name">
                                <p>某某文件.doc</p>
                            </div>
                        </div> --%>
                    </div>
                    <div class="upload-content">
                        <div class="upload-input">
                            <input type="text" class="file-name" readonly />
                        </div>
                        <div class="upload-btn">
                            <button type="button" class="btn btn-color1"><i class="fa fa-folder-open-o"></i>浏览</button>
                            <button type="button" class="btn btn-color2 uploading" id="2"><i class="fa fa-upload"></i>上传</button>
                        	<input type="file" class="file-input preview" id="file2" name="file" data-num="2" />
                        </div>
                    </div>
                </div>
                <div class="upload-module">
                    <div class="module-title">
                        <p>设备使用说明书</p>
                    </div>
                    <div class="file-list"></div>
                    <div class="upload-content">
                        <div class="upload-input">
                            <input type="text" class="file-name" readonly />
                        </div>
                        <div class="upload-btn">
                            <button type="button" class="btn btn-color1"><i class="fa fa-folder-open-o"></i>浏览</button>
                            <button type="button" class="btn btn-color2 uploading" id="3"><i class="fa fa-upload"></i>上传</button>
                        	<input type="file" class="file-input preview" id="file3" name="file" data-num="3" />
                        </div>
                    </div>
                </div>
                <div class="upload-module">
                    <div class="module-title">
                        <p>设备检定校准证书复印件</p>
                    </div>
                    <div class="file-list"></div>
                    <div class="upload-content">
                        <div class="upload-input">
                            <input type="text" class="file-name" readonly />
                        </div>
                        <div class="upload-btn">
                            <button type="button" class="btn btn-color1"><i class="fa fa-folder-open-o"></i>浏览</button>
                            <button type="button" class="btn btn-color2 uploading" id="4"><i class="fa fa-upload"></i>上传</button>
                        	<input type="file" class="file-input preview" id="file4" name="file" data-num="4" />
                        </div>
                    </div>
                </div>
                <div class="upload-module">
                    <div class="module-title">
                        <p>设备验收单</p>
                    </div>
                    <div class="file-list"></div>
                    <div class="upload-content">
                        <div class="upload-input">
                            <input type="text" class="file-name" readonly />
                        </div>
                        <div class="upload-btn">
                            <button type="button" class="btn btn-color1"><i class="fa fa-folder-open-o"></i>浏览</button>
                            <button type="button" class="btn btn-color2 uploading" id="5"><i class="fa fa-upload"></i>上传</button>
                        	<input type="file" class="file-input preview" id="file5" name="file" data-num="5" />
                        </div>
                    </div>
                </div>
                <div class="upload-module">
                    <div class="module-title">
                        <p>设备购置合同</p>
                    </div>
                    <div class="file-list"></div>
                    <div class="upload-content">
                        <div class="upload-input">
                            <input type="text" class="file-name" readonly />
                        </div>
                        <div class="upload-btn">
                            <button type="button" class="btn btn-color1"><i class="fa fa-folder-open-o"></i>浏览</button>
                            <button type="button" class="btn btn-color2 uploading"><i class="fa fa-upload"></i>上传</button>
                        	<input type="file" class="file-input preview" id="file6" name="file" data-num="6" />
                        </div>
                    </div>
                </div>
                <div class="upload-module">
                    <div class="module-title">
                        <p>设备技术服务协议</p>
                    </div>
                    <div class="file-list"></div>
                    <div class="upload-content">
                        <div class="upload-input">
                            <input type="text" class="file-name" readonly />
                        </div>
                        <div class="upload-btn">
                            <button type="button" class="btn btn-color1"><i class="fa fa-folder-open-o"></i>浏览</button>
                            <button type="button" class="btn btn-color2 uploading"><i class="fa fa-upload"></i>上传</button>
                        	<input type="file" class="file-input preview" id="file7" name="file" data-num="7" />
                        </div>
                    </div>
                </div>
                <div class="btn-content">
                    <button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
                    <!-- <button class="btn btn-color1"><i class="fa fa-check"></i>提交</button> -->
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="/common/alertMessages.jsp"></jsp:include>
    <script>
		var id = "${param.id}";
    
        var num = $(".main-content").data("num");
        $(".left-nav li").eq(num).addClass("action");

        $(".left-nav li a").click(function(){
            var url = $(this).data("url");
            $(".index-iframe", window.parent.document).attr("src",url+"?id="+id);
        });
        
        $(".back-btn").click(function(){
	    	var url = "${pageContext.request.contextPath}/deviceMgt/deviceMgtList.do";
	    	$(".index-iframe", window.parent.document).attr("src",url);
	    });
        
        /* $(".file-input").change(function(){
            var value = $(this).val();
            $(this).parent().prev().find(".file-name").val(value);
        }); */
        
        /*文件上传*/
	    $("body").on("change", ".preview", function(){
		 	$(this).parent().prev().find("input[type='text']").val($(this).val());
	    });
	    $(".uploading").click(function(){
	    	var fileDom = $(this).siblings("input[type='file']");
	    	var fileId = fileDom.attr("id");
	    	var fileName = $(this).parent().prev().find("input[type='text']");
	    	var fileNameVal = fileName.val();
	    	var labelName = $(this).parent().parent().siblings(".module-title").find("p").text();
	    	var recordfiles = $(this).parent().parent().siblings(".file-list");
	    	var typeNum = $(this).siblings("input[type='file']").data("num");
	    	if( fileNameVal == ""){
				saveFailure("“"+ labelName +"”没有选择文件上传！");
	  	    }else{
	  	    	var fileType = fileNameVal.split(".")[fileNameVal.split(".").length-1].toLowerCase();
	        	var allFileArr = ["jpg", "jpeg", "png", "bmp", "mov", "avi", "mp4", "wmv", "doc", "docx", "xls", "xlsx", "ppt", "pptx", "pdf", "txt"];
				if( $.inArray(fileType,allFileArr)== -1 ){
	        		saveFailure("系统提示：不能上传“"+ fileType +"”这类型文件！");
	        	} else {
		  	      	$.ajaxFileUpload({
				 		url:'${ pageContext.request.contextPath }/deviceMgt/devattachment/saveDevattachment.do',
		   				data:{
		   					'id' : "${param.id}",
		   					'location' : "无" ,
		   					"type" :typeNum
						},
						secureuri:false,
						fileElementId: fileId,//file标签的id
						dataType: 'json',//返回数据的类型
						success: function (data) {
							console.log(data);
							fileName.val("");
							fileDom.val("");
							//addIds.push(data.id);
		  					var fileTypeName = data.name.split(".")[data.name.split(".").length-1];
							var fileNameLength = data.name.length-fileTypeName.length-1;
							var dataName = data.name.substring(0,fileNameLength);
							var dataId = data.fileId;
							var uoloadFfileType = fileTypeName.toLowerCase();
							var imgArr = ["jpg", "jpeg", "png", "bmp"];
							var fileArr = ["doc", "docx", "xls", "xlsx", "ppt", "pptx", "pdf", "txt"];
							var videoArr = ["mov", "avi", "mp4", "wmv"];					
							var html='';
							html += '<div class="list-content">';
							html += '<div class="list-img">';	
							if($.inArray(uoloadFfileType,imgArr)!= -1){
								html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/img.png">';
							} else if($.inArray(uoloadFfileType,videoArr)!= -1){
								html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/video.png">';
							} else {
								html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/'+uoloadFfileType+'.png">';
							}
							html += '</div>';
							html += '<div class="list-name" title="'+dataName+'">';
							html += '<p>'+dataName+'</p>';
							html += '</div>';
							html += '<button type="button" title="删除" data-id="'+dataId+'" class="remove">×</button>';
							html += '</div>';
		  					recordfiles.html(html);
						},
						error: function (data, status, e) {
							alert(e);
						}
					});
	  	    	} 	
	  	  	}
	    });
        
        /* $(".file-browse").click(function(){
	    	$(this).siblings(".file-input").click();
	    	$(this).siblings(".file-input").change(function(){
	    	 	if($(this).val() !=''){
	    	 		$(this).parent().prev().find('.file-name').val($(this).val());
	          	}else{
	          		$(this).parent().prev().find('.file-name').val('');
	          	}
		    })
	    }); 
	            
        
        $(".file-upload-btn").click(function(){	   
        	var type = $(this).siblings("input").attr("id");
        	var fileList = $(this).parents(".upload-content").prev(".file-list");
        	var fileName = $(this).parent().prev().find(".file-name");
   			$.ajaxFileUpload({
   				url:'${ pageContext.request.contextPath }/deviceMgt/devattachment/saveDevattachment.do',
   				data:{
   					'id' : "${param.id}",
   					'location' : "无" ,
   					"type" : type.charAt(4)
				},
   				secureuri:false,
   				fileElementId:type,//file标签的id
   				dataType: 'json',//返回数据的类型
   				success: function (data) {
   					var name = data.name;
   					if(!name){
   						saveFailure("上传文件为空！");
   						return false;
   					}
   					fileList.html("");  					
   					var listHtml = "";
   					listHtml += '<div class="list-content">';
   					listHtml += '<div class="list-name"><a href="${pageContext.request.contextPath}/deviceMgt/devattachment/downAttachmentFile.do?id='+data.fileId+'"><p>' + data.name + '</p></a></div><button type="button"  data-id="'+data.fileId+'" class="remove" aria-hidden="true">×</button></div>';
   					listHtml += '</div>';
   					fileList.prepend(listHtml);
   					fileName.val("");
   				},
   				error: function (data, status, e) {
   				}
   			});  		  	   	  
        }); */
        
        $(function(){
			$.ajax({
				url:'${ pageContext.request.contextPath }/deviceMgt/devattachment/loadList.do',
				type:'post',
				datatype:"json",
				data:id,
    		    contentType : 'application/json;charset=utf-8', //设置请求头信息
				success:function(data){
					for(var j = 2; j < 8 ; j++){
						otherData = data[j];
						if(otherData == "" || otherData == undefined || otherData == null){
							
						}else{
			        		var fileList = $("#file"+j).parents(".upload-content").prev(".file-list");
			        		var fileTypeName = otherData.name.split(".")[otherData.name.split(".").length-1];
							var fileNameLength = otherData.name.length-fileTypeName.length-1;
							var dataName = otherData.name.substring(0,fileNameLength);
							var dataId = otherData.fileId;
							var uoloadFfileType = fileTypeName.toLowerCase();
							var imgArr = ["jpg", "jpeg", "png", "bmp"];
							var fileArr = ["doc", "docx", "xls", "xlsx", "ppt", "pptx", "pdf", "txt"];
							var videoArr = ["mov", "avi", "mp4", "wmv"];					
							var html='';
							html += '<div class="list-content">';
							html += '<div class="list-img">';	
							if($.inArray(uoloadFfileType,imgArr)!= -1){
								html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/img.png">';
							} else if($.inArray(uoloadFfileType,videoArr)!= -1){
								html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/video.png">';
							} else {
								html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/'+uoloadFfileType+'.png">';
							}
							html += '</div>';
							html += '<div class="list-name" title="'+dataName+'">';
							html += '<p>'+dataName+'</p>';
							html += '</div>';
							html += '<button type="button" title="删除" data-id="'+dataId+'" class="remove">×</button>';
							html += '</div>';
							fileList.append(html);
		   					/* var listHtml = "";
		   					listHtml += '<div class="list-content">';
		   					listHtml += '<div class="list-name"><a href="${pageContext.request.contextPath}/deviceMgt/devattachment/downAttachmentFile.do?id='+otherData.id+'"><p>' + otherData.name + '</p></a></div><button type="button"  data-id="'+otherData.id+'" class="remove" aria-hidden="true">×</button></div>';
		   					listHtml += '</div>';
		   					fileList.prepend(listHtml); */
						}
					}
				}
			})
       	}); 
        
        /*文件删除*/
		$('.file-list').on('click','.remove',function(){
			var devAttrId = $(this).attr('data-id');
			var filethis = $(this);
			$.ajax({
				url:'${pageContext.request.contextPath}/deviceMgt/devattachment/removeAttrById.do',
				data:{'id':devAttrId},
				datatype:'json',
				type:'post',
				success:function(data){
					filethis.parent(".list-content").remove();
				}
			})
		}) 
        
        
        
        
    </script>
</body>
</html>