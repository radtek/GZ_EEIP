<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>Authority Settings</title>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/javascript/jsMap.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/icheck/icheck.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
    <%@ include file = "/common/scripts.jsp"%>
    <link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/default.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/assets.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/formStyle.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/icheck/skins/all.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" /> 
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
	<style>
	    .select_top{position:relative;}
	    .select_content{margin:5px 0; width:100%;min-height:1px;}
	    .quanxiant tr td{text-align:center;}
	    .sure{margin-top:15px;}
	    .huise { background:#a0a0a0; color:#fff; border:0px;}
	    .huise:hover { background:#848484; color:#fff; }
	    .div-spacing { margin-bottom: 10px; }
  	</style>
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>系统管理</a><span>></span><a>角色管理</a><span>></span><a>权限设置</a>
        </p>
    </div>
    <div class="select_content">
	    <table class="table table-bordered ">
	   		<colgroup width="20%"></colgroup>
			<colgroup width="20%"></colgroup>
			<colgroup width="60%"></colgroup>
			<tbody class="quanxiant"></tbody>
	 	</table>
	</div>
	<div class="btn-content">
        <button class="btn btn-color2 fanhui"><i class="fa fa-chevron-left"></i>返回</button>
        <button class="btn btn-color1 baocuo"><i class="fa fa-check"></i>保存</button>
    </div>
    <jsp:include page="/common/alertMessages.jsp"></jsp:include>
	<script type="text/javascript">
	    $(function() {
	    	var parentAuthLabelMap = new Map();
	    	
	    	$('.fanhui').click(function() {
	    		$('.index-iframe', window.parent.document).attr("src", "${pageContext.request.contextPath}/system/role/roleList.do");
	    	});

			loadData(); //load authorities
			
			$('.baocuo').click(function() {
				var yixuan = $('.quanx:checked');
				var xuan = '';
			    var parentAuthLabels = '';
			    for (var i = 0; i < yixuan.length; i++) {
			    	xuan += yixuan[i].id + ",";
					var parentAuthLabel = $(yixuan[i]).parent().parent().children("input.parentAuth").val();
					if (!parentAuthLabelMap.containsKey(parentAuthLabel)) 
						parentAuthLabelMap.put(parentAuthLabel, parentAuthLabel);
				}
			    
			    var parentAuthLabelArray = parentAuthLabelMap.keys();
			    for (var i = 0; i < parentAuthLabelArray.length; i++) {
			    	parentAuthLabels += parentAuthLabelArray[i] + ",";
				}
			    
			    $.ajax({
			    	url : "${pageContext.request.contextPath}/system/auth/saveRoleAuthData.do",
			    	type : "post",
			    	data : {
			    		"roleId" : "${param.roleId}",
			    		"authorityIds" : xuan,
			    		"parentAuthLabels" : parentAuthLabels
					},
					success : function() {
						//$(".index-iframe", window.parent.document).attr("src","${pageContext.request.contextPath}/system/role/roleList.do");
						saveSuccess("${pageContext.request.contextPath}/system/role/roleList.do");
					},
					error : function() {
						console.log("");
					}
				});
			});
		});
	    
	    function loadData() {
	    	$.ajax({
	    		url : "${pageContext.request.contextPath}/system/auth/authGridData.do",
	    		type : "post",
				cache : false,
			    async : false,
				data : {
					"roleId" : "${param.roleId}"
				},
				success : function(data) {
					var datas = data['authList'];
					var html = "";
					
					for (var i = 0; i < datas.length; i++) {
						for (var j = 0; j < datas[i].subTypies.length; j++) {
							var rows = datas[i].subTypies.length;
							var authStr = "";
							var checkedStatus = "";
							html += "<tr>";
							if (j == 0) {
								authStr = getAuthoritiesBySubType(datas[i].subTypies[j].typeId)[0];
								checkedStatus = getAuthoritiesBySubType(datas[i].subTypies[j].typeId)[1];
								
								html += "<td rowspan='" + rows + "'><span>" + datas[i].typeName + "</span></td>";
								html += "<td><span>" + datas[i].subTypies[j].typeName + "</span>&nbsp;&nbsp;<input class='moduleSelecter' type='checkbox' " + getCheckedStatus(checkedStatus) + "/></td>";
								html += "<td>";
								html += authStr;
								html += "</td>";
							} else {
								authStr = getAuthoritiesBySubType(datas[i].subTypies[j].typeId)[0];
								checkedStatus = getAuthoritiesBySubType(datas[i].subTypies[j].typeId)[1];
								
								html += "<td><span>" + datas[i].subTypies[j].typeName + "</span>&nbsp;&nbsp;<input class='moduleSelecter' type='checkbox' " + getCheckedStatus(checkedStatus) + "/></td>";
								html += "<td>";
							    html += authStr;
								html += "</td>";
							}
							html += "</tr>";
						}
					}
					
					function getCheckedStatus(status) {
						if ( status != undefined && status == "1" ) {
							return "checked='checked'";
						}
						return ""
					}

					function getAuthoritiesBySubType(subTypeId) {
						var result = new Array(2); //数组下标为0：HTML组合字符串；数组下标为1：对应功能模块选择状态
						var hw = '';
						var shuju;
						for (var i = 0; i < datas.length; i++) {
							for (var j = 0; j < datas[i].subTypies.length; j++) {
								if (datas[i].subTypies[j].typeId == subTypeId) {
									shuju = datas[i].subTypies[j]['authorities'];
									for (var is = 0; is < shuju.length; is++) {
										for (var is = 0; is < shuju.length; is++) {
											if (shuju[is]["checked"] == false) {
												hw += '<div class="col-sm-4 div-spacing">' + shuju[is]['authorityName']
																	+ '&nbsp;&nbsp;<input class="quanx" id='+ shuju[is]['authorityId'] +' type="checkbox">'
																	+ '<input class="parentAuth" type="hidden" value="'+ shuju[is]['parentAuthorityLabel'] +'"/>'
																	+ '</div>';
												result[1] = "0";
											} else {
												hw += '<div class="col-sm-4 div-spacing">' + shuju[is]['authorityName'] 
												               + '&nbsp;&nbsp;<input class="quanx" id='+ shuju[is]['authorityId'] +' type="checkbox"  checked="checked">'
												               + '<input class="parentAuth" type="hidden" value="'+ shuju[is]['parentAuthorityLabel'] +'"/>'
												               + '</div>';
												result[1] = "1";
											  }
										}
									}
									
									result[0] = hw;
									return result;
								}
							}
						}
						return null;
					}
					
					$('.quanxiant').prepend(html);
					
					//系统权限选择器 - 全选系统内所有功能模块权限（暂不实现）
					$('.systemSelecter').iCheck({
						labelHover : false, 
						cursor : true, 
						checkboxClass : 'icheckbox_square-blue', 
						radioClass : 'iradio_square-blue', 
						increaseArea : '20%'
				    });
					
					//模块权限选择器 - 全选指定系统模块内的所有功能权限
					$('.moduleSelecter').iCheck({
						labelHover : false, 
						cursor : true, 
						checkboxClass : 'icheckbox_square-blue', 
						radioClass : 'iradio_square-blue', 
						increaseArea : '20%'
				    });
					
					$('.moduleSelecter').on('ifChecked', function(event) {
						var itemArray = $(this).parent().parent().parent().find("input");
						for ( var i = 0; i < itemArray.length; i ++ ) {
							if ( $(itemArray[i]).attr("class") == "quanx" ) {
								$(itemArray[i]).iCheck('check');
							}
						}
			        });
					
					$('.moduleSelecter').on('ifUnchecked', function(event) {
						var itemArray = $(this).parent().parent().parent().find("input");
						for ( var i = 0; i < itemArray.length; i ++ ) {
							if ( $(itemArray[i]).attr("class") == "quanx" ) {
								$(itemArray[i]).iCheck('uncheck');
							}
						}
			        });
					
					//功能权限选择器 - 选择指定功能权限
					$('.quanx').iCheck({
						labelHover : false, 
						cursor : true, 
						checkboxClass : 'icheckbox_square-blue', 
						radioClass : 'iradio_square-blue', 
						increaseArea : '20%'
				    });
				}
			});
		}
   	</script>
</body>
</html>