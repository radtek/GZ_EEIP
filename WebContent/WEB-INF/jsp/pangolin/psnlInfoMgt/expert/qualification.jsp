<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>资格证书</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script> 
    <script src="<c:url value="/resources/frameworks/pangolin/js/eeip/expert.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>	 
 	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
 	<script src="<c:url value="/resources/frameworks/pangolin/js/ajaxfileupload.js" />"></script>
 	<script src="<c:url value="/resources/frameworks/pangolin/js/alertMessages.js" />"></script>
 	
 	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/expert/expert.css" />" rel="stylesheet" />	
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />  
  </head>
<body>
	<div class="content">		
		<div class="crumbs-nav">
	        <p class="crumbs-text">
	        	当前位置：<a>人员信息管理</a><span>></span><a>专家库</a><span>></span><a>新增</a><span>></span><a>资格证书</a>
	        </p>
    	</div>
		<jsp:include page="/common/personNav.jsp"></jsp:include>
		<div class="upload-module margin-top">
            <div class="module-title">
                <p>任职资格证书</p>
            </div>
            <div class="file-list file0">
            	<!-- <div class="list-content">
            		<div class="list-img">
            			<img src="/eeip/resources/frameworks/pangolin/images/eeip/uploadImg/txt.png" alt="">
           			</div>
           			<div class="list-name" title="QQ截图20170329154227.png">
           				<p>QQ截图20170329154227.png</p>
         			</div>
         			<button class="remove" title="删除" data-id="402881f05b45ef15015b46084ac0001c">×</button>
        		</div> -->
            </div>
            <div class="upload-content">
                <div class="upload-input">
                    <input type="text" class="file-name" readonly />
                </div>
                <div class="upload-btn">
                    <button type="button" class="btn btn-color1"><i class="fa fa-folder-open-o"></i>浏览</button>
                    <button type="button" class="btn btn-color2 uploading" id="3"><i class="fa fa-upload"></i>上传</button>
                	<input type="file" class="file-input preview" id="file0" name="file" />
                </div>
            </div>
        </div>
        <div class="upload-module">
            <div class="module-title">
                <p>鉴定人资格证书</p>
            </div>
            <div class="file-list file1"></div>
            <div class="upload-content">
                <div class="upload-input">
                    <input type="text" class="file-name" readonly />
                </div>
                <div class="upload-btn">
                    <button type="button" class="btn btn-color1"><i class="fa fa-folder-open-o"></i>浏览</button>
                    <button type="button" class="btn btn-color2 uploading" id="3"><i class="fa fa-upload"></i>上传</button>
                	<input type="file" class="file-input preview" id="file1" name="file" />
                </div>
            </div>
        </div>
        <div class="upload-module">
            <div class="module-title">
                <p>毕业证</p>
            </div>
            <div class="file-list file2"></div>
            <div class="upload-content">
                <div class="upload-input">
                    <input type="text" class="file-name" readonly />
                </div>
                <div class="upload-btn">
                    <button type="button" class="btn btn-color1"><i class="fa fa-folder-open-o"></i>浏览</button>
                    <button type="button" class="btn btn-color2 uploading" id="3"><i class="fa fa-upload"></i>上传</button>
                	<input type="file" class="file-input preview" id="file2" name="file" />
                </div>
            </div>
        </div>
        <div class="upload-module">
            <div class="module-title">
                <p>学位证</p>
            </div>
            <div class="file-list file3"></div>
            <div class="upload-content">
                <div class="upload-input">
                    <input type="text" class="file-name" readonly />
                </div>
                <div class="upload-btn">
                    <button type="button" class="btn btn-color1"><i class="fa fa-folder-open-o"></i>浏览</button>
                    <button type="button" class="btn btn-color2 uploading" id="3"><i class="fa fa-upload"></i>上传</button>
                	<input type="file" class="file-input preview" id="file3" name="file" />
                </div>
            </div>
        </div>
	</div>	
	<div class="btn-content">
        <button type="button" class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
    </div>  
    <jsp:include page="/common/alertMessages.jsp"></jsp:include>
	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/expert.js" />"></script>
	<script>
		$(function(){
			// 链接判断
			var url = window.location.href;
			if( "${param.userBasicInfoId}" ){
			  $(".crumbs-text").html("当前位置：<a>人员信息管理</a><span>></span><a>专家库</a><span>></span><a>修改</a><span>></span><a>资格证书</a>");
			}
			
			loadCertificate();
			
			/*文件上传*/
		    $("body").on("change", ".preview", function(){
			 	$(this).parent().prev().find("input[type='text']").val($(this).val());
		    });
	        $('.uploading').click(function(){
	        	//$(this).siblings(".enterFile").val("");
	        	var fileName = $(this).parent().prev().find(".file-name");
	        	var fileId = $(this).siblings(".file-input").attr("id"); 
	        	var userBasicInfoId="${param.userBasicInfoId}";
	        	var type=fileId.substring(fileId.length-1,fileId.length);
	        	var fileType1 = fileName.val().split(".")[fileName.val().split(".").length-1];
	        	var fileType = fileType1.toLowerCase();
	        	var typeArr = ["doc", "docx", "xls", "xlsx", "ppt", "pptx", "pdf", "txt", "jpg", "jpeg", "png", "bmp", "mov", "avi", "mp4", "wmv"];       	       	
	        	if($.inArray(fileType,typeArr)== -1){
	        		promptContent("不能上传该类型文件！");
	        		$(".alert").removeClass("alert-success").addClass("alert-danger");
		 			$(".promptDiv").slideDown();
		 		    setTimeout(function(){
		 				$(".promptDiv").slideUp();
		 		    },2000);
	        		return false;
	        	}
	        	$.ajaxFileUpload({
	  				url:"${pageContext.request.contextPath}/psnlInfo/userCertificate/saveUserCertificateData.do?userBasicInfoId="+userBasicInfoId+"&type="+type,
	  				secureuri:false,
	  				fileElementId:fileId,//file标签的name
	  				dataType: 'json',//返回数据的类型
	  				success: function (data) { 
	  					console.log(data);
						if(data.status){ 							
							var fileType1 = data.name.split(".")[data.name.split(".").length-1];
							var allLength = data.name.length;
							var length = fileType1.length+1;
							var dataName = data.name.substring(0,allLength-length);
							var fileType = fileType1.toLowerCase();
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
							html += '<p>'+dataName+'</p>';
							html += '</div>';
							html += '<button class="remove" title="删除" data-id="'+data.id+'">×</button>';
							html += '</div>';
						}
	  					$("."+fileId+"").append(html);
	  					fileName.val('');
	  				},
	  				error: function (data, status, e) {
	  					alert(e);
	  				}
	  			});  	   	  
	        });
	        /*文件上传end*/	
	       
	        /*文件删除*/
		    $('.file-list').on('click', '.remove', function(){
		  	  	var  fileid = $(this).attr('data-id');
		  	  	var  filethis = $(this);
		  	  	$.ajax({
		  		  	url:'${pageContext.request.contextPath}/psnlInfo/userCertificate/removeUserCertificateData.do',
		  		  	data:{'id':fileid},
		  		  	datatype:'json',
		  		  	type:'post',
		  		  	success:function(data){
		  			  	if( data['status'] ){
		  				  	filethis.parent('.list-content').remove();
		  			  	}
		  		  	},
		  		  	error:function(){
		  			  	alert('删除文件失败');
		  		  	}
		  	  	})
		    })
		    /*文件删除结束*/
		});
		
	    function loadCertificate (){
			var attData = loadData("${pageContext.request.contextPath}/psnlInfo/userCertificate/getUserCertificateByUserIdListData.do",{ "userBasicInfoId" : "${param.userBasicInfoId}" });
 			if(attData.length>0){
		    	for(var i = 0;i<attData.length;i++){
		    		var fileType1 = attData[i].name.split(".")[attData[i].name.split(".").length-1];
					var allLength = attData[i].name.length;
					var length = fileType1.length+1;
					var dataName = attData[i].name.substring(0,allLength-length);
					var fileType = fileType1.toLowerCase();
					var imgArr = ["jpg", "jpeg", "png", "bmp"];
					var fileArr = ["doc", "docx", "xls", "xlsx", "ppt", "pptx", "pdf", "txt"];
					var videoArr = ["mov", "avi", "mp4", "wmv"];
		    		var html = "";
		    		html += '<div class="list-content">';
					html += '<div class="list-img">';
					if($.inArray(fileType,imgArr)!= -1){
						html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/img.png">';
					} else if($.inArray(fileType,videoArr)!= -1){
						html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/video.png">';
					} else {
						html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/'+fileType+'.png">';
					}
					//html += '<img src="${pageContext.request.contextPath}/psnlInfo/userCertificate/loadUserCertificateImage.do?id='+attData[i].id+'" alt="">';
					html += '</div>';
					html += '<div class="list-name" title="'+dataName+'">';
					html += '<p>'+dataName+'</p>';
					html += '</div>';
					html += '<button class="remove" title="删除" data-id="'+attData[i].id+'">×</button>';
					html += '</div>';
		    		var className=".file"+attData[i].type;
					$(className).prepend(html);
		    	}
		    }
		}
	    
	    $(".back-btn").click(function(){//返回
			$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/psnlInfo/expert/personnelInfoList.do');
		});
	</script>
</body>
</html>