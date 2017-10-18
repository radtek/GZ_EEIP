<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>著作报告</title>
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
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
 	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
 	
 	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/expert/expert.css" />" rel="stylesheet" />	
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" /> 
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" /> 
</head>
<body>
	<div class="content">		
		<div class="crumbs-nav">
	        <p class="crumbs-text">
	       		当前位置：<a>人员信息管理</a><span>></span><a>专家库</a><span>></span><a>新增</a><span>></span><a>著作报告</a>
	        </p>
    	</div>
		<jsp:include page="/common/personNav.jsp"></jsp:include>
		<div class="file-upload">																
			<table class="table table-bordered">
				<thead class="col-head">
					<tr>
						<th><span class="required-fields">*</span>发表或出版时间</th>
						<th><span class="required-fields">*</span>论文、著作或专题技术分析报告标题</th>
						<th><span class="required-fields">*</span>作者及名次</th>
						<th>刊物名称及刊号</th>
						<th><span class="required-fields">*</span>刊物（论文交流）主办单位</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody class="handleData">
					
				</tbody>
				<tfoot>
	            	<tr>
	                    <td colspan="6" align="center">
	                        <button class="btn add-tr-btn"><i class="fa fa-plus"></i>增加</button>
	                    </td>
	                </tr>
	            </tfoot>
			</table>					
		</div>
	</div>	
	<div class="btn-content">
        <button type="button" class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
    </div>  
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
	<script>
		$(function(){
			// 链接判断
			var url = window.location.href;
			if( "${param.userBasicInfoId}" ){
			  $(".crumbs-text").html("当前位置：<a>人员信息管理</a><span>></span><a>专家库</a><span>></span><a>修改</a><span>></span><a>著作报告</a>");
			}
			
			$(".add-tr-btn").click(function(){
				$(".handleData").append('<tr>'
					+'<td><input type="text" data-id="" class="datetimepicker11" required /></td>'
					+'<td><input type="text" class="validation" required /></td>'
					+'<td><input type="text" class="validation" required /></td>'
					+'<td><input type="text" class="validation" /></td>'
					+'<td><input type="text" class="validation" required /></td>'
					+'<td><a class="singleSubmit" title="保存"><i class="fa fa-check"></i></a><a class="singleClear" title="删除" id=""> <i class="fa fa-times"></i></a></td>'
					+'</tr>'													
																			
				);
				$(".datetimepicker11").datetimepicker({format: 'YYYY-MM-DD'});
			});						
			
			var data = loadData("${pageContext.request.contextPath}/psnlInfo/userWorks/getUserWorksByUserIdListData.do",{ "userBasicInfoId" : "${param.userBasicInfoId}" }); 
			if(data.length>0){
		    	 var resultHtml='';
		    	 for(var i = 0 ; i<data.length;i++){
		    		 resultHtml+='<tr class="col-read">'						
							+'<td><input type="text" data-id="'+data[i]['id']+'" class="datetimepicker11" readonly="readonly" value="'+new Date(data[i].publishedDate).Format("yyyy-MM-dd")+'" required/></td>'
							+'<td><input type="text" readonly="readonly" value="'+data[i].title+'" class="validation" required /></td>'
							+'<td><input type="text" readonly="readonly" value="'+data[i].authorRank+'" class="validation" required /></td>'
							+'<td><input type="text" readonly="readonly" value="'+data[i].sn+'" class="validation" /></td>'
							+'<td><input type="text" readonly="readonly" value="'+data[i].sponsor+'" class="validation" required /></td>'
							+'<td><a class="singleModify" title="修改"> <i class="fa fa-pencil-square-o"></i></a> <a class="singleClear" id="'+data[i]['id']+'" title="删除"> <i class="fa fa-times"></i></a></td>'
							+'</tr>'
		    	 }
		    	 $(".datetimepicker11").datetimepicker({format: 'YYYY-MM-DD'});
		    	 $(".handleData").append(resultHtml);
		     }
			
		});
		//表单提交
		$(".handleData").on("click",".singleSubmit",function(){
			if(validateSubmittedData()){
				var inputList = $(this).parent().parent().find("input"); 		 	
				var entityData = loadData("${pageContext.request.contextPath}/psnlInfo/userWorks/getUserWorksByIdData.do",{ "id" :  inputList[0].dataset.id });
				
				var vm = ko.mapping.fromJS(entityData);
				vm.publishedDate=inputList[0]["value"];
				vm.title=inputList[1]["value"];
				vm.authorRank=inputList[2]["value"];
				vm.sn=inputList[3]["value"];
				vm.sponsor=inputList[4]["value"];
				
				vm.creatorId="${sessionScope.loginUser.userId}";
		    	vm.creatorName="${sessionScope.loginUser.userName}";
		    	vm.creatorAlias="${sessionScope.loginUser.userAlias}";
		    	vm.userBasicInfoId="${param.userBasicInfoId}";
		    	
		    	if (saveData("${pageContext.request.contextPath}/psnlInfo/userWorks/saveUserWorksData.do", vm)) {
		    		$(this).siblings('span').attr('id',entityData.id);
		    		$(this).parent().parent().children().eq(0).children().attr('data-id',entityData.id);
		    		saveSuccess();
		    		setTimeout("$('.promptDiv').slideUp();",2000);
					/* saveSuccess("${pageContext.request.contextPath}/psnlInfo/expert/personnelInfoList.do"); */
				} else {
					
				}
			}else{
				saveFailure();			
			}				
		});
		
		// 删除
		$(".handleData").on("click",".singleClear",function(){	
			var id = $(this).attr('id'); 
			if(id != null && id != "" && id != "undefined"){
				$.ajax({
					url:'${pageContext.request.contextPath}/psnlInfo/userWorks/removeUserWorksData.do',
					type:'post',
					datatype:'json',
					data:{'id':id},
					success:function(){
						$(this).parent("td").parent("tr").remove();
						//sorting();
					}
				})
			}else{
				$(this).parent("td").parent("tr").remove();
				//sorting();
			} 
		})
		
		$(".back-btn").click(function(){//返回
			$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/psnlInfo/expert/personnelInfoList.do');
		});
	</script>
</body>
</html>