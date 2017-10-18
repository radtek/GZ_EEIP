<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>资格证书详情页</title>
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
 	
 	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/expert/expert.css" />" rel="stylesheet" />	
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" /> 
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" /> 
</head>
<body>
	<div class="content">		
		<div class="crumbs-nav">
	        <p class="crumbs-text">
	           	当前位置：<a>人员信息管理</a><span>></span><a>专家库</a><span>></span><a>查看</a><span>></span><a>资格证书</a>
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
            <!-- <div class="upload-content">
                <div class="upload-input">
                    <input type="text" class="file-name" readonly />
                </div>
                <div class="upload-btn">
                    <button type="button" class="btn btn-color1 file-browse"><i class="fa fa-folder-open-o"></i>浏览</button>
                    <button type="button" class="btn btn-color2 file-upload-btn" id="3"><i class="fa fa-upload"></i>上传</button>
                	<input type="file" class="file-input" id="file0" name="file" />
                </div>
            </div> -->
        </div>
        <div class="upload-module">
            <div class="module-title">
                <p>鉴定人资格证书</p>
            </div>
            <div class="file-list file1"></div>
            <!-- <div class="upload-content">
                <div class="upload-input">
                    <input type="text" class="file-name" readonly />
                </div>
                <div class="upload-btn">
                    <button type="button" class="btn btn-color1 file-browse"><i class="fa fa-folder-open-o"></i>浏览</button>
                    <button type="button" class="btn btn-color2 file-upload-btn" id="3"><i class="fa fa-upload"></i>上传</button>
                	<input type="file" class="file-input" id="file1" name="file" />
                </div>
            </div> -->
        </div>
        <div class="upload-module">
            <div class="module-title">
                <p>毕业证</p>
            </div>
            <div class="file-list file2"></div>
            <!-- <div class="upload-content">
                <div class="upload-input">
                    <input type="text" class="file-name" readonly />
                </div>
                <div class="upload-btn">
                    <button type="button" class="btn btn-color1 file-browse"><i class="fa fa-folder-open-o"></i>浏览</button>
                    <button type="button" class="btn btn-color2 file-upload-btn" id="3"><i class="fa fa-upload"></i>上传</button>
                	<input type="file" class="file-input" id="file2" name="file" />
                </div>
            </div> -->
        </div>
        <div class="upload-module">
            <div class="module-title">
                <p>学位证</p>
            </div>
            <div class="file-list file3"></div>
            <!-- <div class="upload-content">
                <div class="upload-input">
                    <input type="text" class="file-name" readonly />
                </div>
                <div class="upload-btn">
                    <button type="button" class="btn btn-color1 file-browse"><i class="fa fa-folder-open-o"></i>浏览</button>
                    <button type="button" class="btn btn-color2 file-upload-btn" id="3"><i class="fa fa-upload"></i>上传</button>
                	<input type="file" class="file-input" id="file3" name="file" />
                </div>
            </div> -->
        </div>
		<!-- <form class="form-horizontal myform">														
			<div class="mid-title"><span>丨</span> 任职资格证书</div>
			<div class="upload-file">
				<div class="file-imgs file0">
					 
				</div>
				
			</div>
			
			<div class="mid-title"><span>丨</span> 鉴定人资格证书</div>
			<div class="upload-file">
				<div class="file-imgs file1">
					 
				</div>
				
			</div>
			
			<div class="mid-title"><span>丨</span> 毕业证</div>
			<div class="upload-file">
				<div class="file-imgs file2">
					 
				</div>
				
			</div>
			
			<div class="mid-title"><span>丨</span> 学位证</div>
			<div class="upload-file">
				<div class="file-imgs file3">
				 
				</div>
				
			</div>
		</form> -->
	</div>	
	<div class="btn-content">
        <button type="button" class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
    </div>
	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/expert.js" />"></script>
	<script>
		$(function(){
			loadCertificate();
			 	
	        /*文件删除*/
		    $('.file-list').on('click', '.remove', function(){
		  	  var  fileid = $(this).attr('data-id');
		  	  var  filethis = $(this);
		  	  $.ajax({
		  		  url:'${pageContext.request.contextPath}/meeting/meetingApp/document/removeDocumentData.do',
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
		
		function downPic(id){
			alert(id);
		}
		
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
					html += '<div class="list-name"  title="'+dataName+'">';
					html += '<p><a href="${pageContext.request.contextPath}/psnlInfo/userCertificate/downUserCertificateImage.do?id='+attData[i].id+'">'+dataName+'</a></p>';
					//html += '<p>'+dataName+'</p>';
					html += '</div>';
					//html += '<button class="remove" title="删除" data-id="'+attData[i].id+'">×</button>';
					html += '</div>';
		    		var className=".file"+attData[i].type;
					$(className).prepend(html);
		    	}
		    }
			
			/* if(attData.length>0){			
		    	for(var i = 0;i<attData.length;i++){		    		
		    		var fileType = attData[i].name.split(".")[1];
					var imgArr = ["jpg", "jpeg", "png", "bmp"];
					var fileArr = ["doc", "docx", "xls", "xlsx", "ppt", "pptx", "pdf", "txt"];
					var html = "";
		    		html += '<div class="list-content">';
					html += '<div class="list-img">';
					if($.inArray(fileType,imgArr)!= -1){						
						html += '<img src="${pageContext.request.contextPath}/psnlInfo/userCertificate/loadUserCertificateImage.do?id='+attData[i].id+'" alt="">';
					}else{						
						html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/'+fileType+'.png">';
					}								
					html += '</div>';
					html += '<div class="list-name" title="'+attData[i].name+'">';
					html += '<p>'+attData[i].name+'</p>';
					html += '</div>';
					 
					html += '</div>';
		    		var className=".file"+attData[i].type;
					$(className).append(html);
						 //console.log(html)
		    	}
		    } */
		}
	    
	    $(".back-btn").click(function(){//返回
			$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/psnlInfo/expert/personnelInfoList.do');
		});
	</script>
</body>
</html>