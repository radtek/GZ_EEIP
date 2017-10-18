<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>物证预检登记列表</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/bracket-common.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/toggles.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/zyupload.basic-1.0.0.min.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/modal-common.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-list.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
			当前位置：<a>电子物证管理</a><span>></span><a>物证预检登记</a>
        </p>      
    </div>
	<div class="operating-area">
    	<div class="text-content">关键字：</div>
    	<div class="input-content btn-2">
    		<input type="text" id="key"/>
    	</div>
    	<div class="button-content">
    		<button type="button" class="btn btn-color2 search"><i class="fa fa-search"></i>查询</button>
    	</div>
    	<div class="button-content">
    		<button type="button" class="btn btn-color1 add-form-btn"><i class="fa fa-plus"></i>新增</button>
    	</div>
    </div>
    <div class="table-content">
        <table class="table table-striped table-hover" id="table2">
            <thead>
                <tr>
                    <th>案件编号</th>
                    <th>案件名称</th>
                    <th>委托单位</th>
                    <th>委托时间</th>
                    <th>联系电话</th>
                    <th>状态</th>
                    <th>操作</th>
<!--                     <th>创建时间</th> -->
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
    
    
	<!-- <button type="button" data-toggle="modal" data-target=".listModal"></button> -->
	
	<div class="modal fade listModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  	<div class="modal-dialog" role="document">
	    	<div class="modal-content">
	      		<div class="modal-header">
	        		<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        		<h4 class="modal-title" id="myModalLabel">送检检材</h4>
	      		</div>
	      		<div class="modal-body">
	       			<ul class="check-material-list app">
	       				<!-- <li>检材001<i class="fa fa-search" title="查看"></i></li>
	       				<li>检材001<i class="fa fa-search" title="查看"></i></li>
	       				<li>检材001<i class="fa fa-search" title="查看"></i></li>
	       				<li>检材001<i class="fa fa-search" title="查看"></i></li>
	       				<li>检材001<i class="fa fa-search" title="查看"></i></li> -->
	       			</ul>
	      		</div>
	      		<!-- <div class="modal-footer">
	        		<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        		<button type="button" class="btn btn-primary">Save changes</button>
	      		</div> -->
	    	</div>
	  	</div>
	</div>
    
    <input type="hidden" id="rmId" />
    <input type="hidden" id="rmName"/>
    <input type="hidden" id="rmType"/>
    
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
    <script>
    
    
    $(".add-form-btn").click(function(){
    	$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/elecEVIDMgt/register/evidenceRegisterForm.do');
    });

    function toView(id){
    	$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/elecEVIDMgt/generalMessage/timelineViewer.do?id='+id+'&userrole=1');
    }
    function constructHtml(id){
    	//获取列表数据源
    	var appData = null;
    	var appHtml='';
    	 $.ajax({
             type: "POST",
             url: "${pageContext.request.contextPath}/elecEVIDMgt/appraised/getAppraisedByPreidListData.do",
             data: { "id" : id},
             dataType: "json",
             success: function(data){
            	 appData = data.entity;
            	 if(appData != null){
             		for(var i =0; i < appData.length; i++){
             			appHtml += " <li>"+appData[i].evidName+"<i class=\"fa fa-search\" onclick=\"toView('" + appData[i].id + "');\" title=\"查看\"></i></li>  ";
             		}
             	}else{
             		appHtml += '暂无鉴定检材信息！';
             	}
             	$(".app").html(appHtml);
             },
	    	 error: function(data){
	    		 console.log(data);
	    	 }
    	 });  
    };
    
	$(function(){	
		var searchValue = '';
		
    	$(".search").click(function (){ 
    		searchValue = $('#key').val().replace(/\s+/g, "");
    		loadGridData(); 
   	    });
    	
		loadGridData();
	   	function getDate(data, type, row) {
	   		return new Date(data).Format("yyyy-MM-dd  hh:mm");
		}
	   	
	   	function getStatus(data, type, row) {
	   		if(data == 0){
	   			return "草稿";
	   		}else{
	   			return "已提交";
	   		}
	   	}
	    
	   	function getOperation(data, type, row) {
	   		var html = "";
	   		//onclick=\"toView('" + row.id + "');\"
	   		html+="<a class=\"viewer-btn\" onclick=\"constructHtml('" + row.id + "');\" title=\"检材列表\" data-toggle='modal' data-target='.listModal'><i class=\"fa fa-bars\"></i></a>";
	   		if(data == 0){
				html += "<a class=\"modify-btn\" onclick=\"changeData('" + row.id + "');\" title=\"修改\"><i class=\"fa fa-pencil-square-o\"></i></a>"; //修改
     			html += "<a title='删除' data-toggle=\"modal\" data-target=\"#sysNoticePopup\" onclick=\"setRemovedFileParam('" + row.id + "', '" + row.caseName +"');\"><i class='fa fa-times'></i></a>";
				return html;
	   		}else{
				html += "<a class=\"modify-btn\" onclick=\"view('" + row.id + "');\" title=\"下载\"><i class=\"fa fa-download\"></i></a>"; //打印
				return html;
	   		}
	   	}
	   	
    	
		//加载列表数据
		function loadGridData() {
			//数据列绑定
			var columns = [
				{ "mData" : "caseSn" , "bSortable" : true},
				{ "mData" : "caseName", "bSortable" : true},
				{ "mData" : "orgName", "bSortable" : true},
				{ "mData" : "entrustedDate", "bSortable" : true,"mRender": getDate},
				{ "mData" : "tel", "bSortable" : true },
				{ "mData" : "status", "bSortable" : true,"mRender": getStatus},
				{ "mData" : "status", "bSortable" : true,"mRender": getOperation, "sWidth":"8em"},
            ];
			
			
      	
			//排序规则
			var sorting = [ [ 3 , 'desc' ] ];

   			//扩展参数
   			var extraParams =  [{ "name" : "queryParam", "value" : searchValue },{ "name" : "creatorId", "value" : "${sessionScope.loginUser.userId}"}];
   			
			//初始化数据表
			dataTable = new BSDataTable();
			dataTable.initialize({
				"tableId" : "table2",
				"columns" : columns,
				"sorting" : sorting,
				"pageSize" : DEFAULT_PAGE_SIZE,
				"dataSource" : "${pageContext.request.contextPath}/elecEVIDMgt/preappraisal/PreappraisalGirdData.do",
				"extraParams" : extraParams,
				"style" : DT_FULL_NUMBERS,
				"bProcessing" : true,
				"url" : {
      		      	"rmDataUrl" : "${ pageContext.request.contextPath }/elecEVIDMgt/preappraisal/delePreappraisalData.do"
				}
			});
            
			//隐藏列表组件显示条数  --  数量   和 分页
			$('#table2_length').hide();
         }
	})
	
	function view(preappraisalId){
		//打印委托书
		if(loadData("${ pageContext.request.contextPath }/elecEVIDMgt/preappraisal/savePreappraisalWord.do", {"preappraisalId":preappraisalId})){
			console.log("下载成功！");
			var appraisalData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisalData/loadAppraisalDataByPreappraisalId.do", {"preappraisalId":preappraisalId})
// 			if(false){
			if(loadData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/checkAppDocByTypeAndAppraisalId.do", {"type": 0,"appraisalId":appraisalData.id } )){
				window.location.href = "${ pageContext.request.contextPath }/elecEVIDMgt/AppraisalDoc/downAppraisalDocData.do?type=0&appraisalId="+appraisalData.id;
			}else{
				promptContent("下载的文件不存在,请联系管理员");
			 	$(".alert").removeClass("alert-success").addClass("alert-danger");
	 			$(".promptDiv").slideDown();
	 		    setTimeout(function(){
	 				$(".promptDiv").slideUp();
	 		    },1500);
			}
		}
		
		
	}
	
    function setRemovedFileParam(id, caseName) {
    	  $("#rmId").val(id);
	      $("#rmName").val(caseName);
	      setSystemNoticeContent("是否确认删除预检登记信息&nbsp;"+$("#rmName").val()+"&nbsp;?");
   	}
		   	
    initSystemNoticePopup(function() {
		dataTable.rmData({ 'id' : $("#rmId").val() }, function() { dataTable.reloadData(); }, function() { dataTable.reloadData(); });
    });
    
    function changeData(data){
    	var url = "${pageContext.request.contextPath}/elecEVIDMgt/register/evidenceRegisterForm.do?id="+data;
    	$(".index-iframe", window.parent.document).attr("src",url);
	}
    </script>
</body>
</html>