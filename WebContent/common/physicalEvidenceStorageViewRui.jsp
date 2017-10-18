<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<!-- 电子物证管理-综合鉴定信息-物证入库 -->
<div class="form-module">
    <div class="form-module-title">
        <p>检材入库</p>
    </div>
    <div class="form-content">
        <form class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label">条形码：</label>
                <div class="col-sm-4" data-bind="with:evidenceVM">
                	<input type="text" data-bind="value:sn" class="form-control" readonly/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">登记人：</label>
                <div class="col-sm-4 " data-bind="with:evidenceVM">
                    <input type="text" data-bind="value:creatorAlias" class="form-control" readonly/>
                </div>
                <label class="col-sm-2 control-label">入库时间：</label>
                <div class="col-sm-4" data-bind="with:evidenceVM">
                    <input type="text" data-bind="dateTimePicker: createdDate" class="form-control datetimepicker" readonly/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">存放位置：</label>
                <div class="col-sm-10" data-bind="with:evidenceVM">
                    <input type="text" data-bind="value:location" class="form-control" readonly/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">入库拍照：</label>
                <div class="col-sm-10">
                    <div class="img-upload">
                        <%-- <div class="big-img">
                            <img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/deviceMgt/111.png" />
                        </div> --%>
                        <ul class="img-list">
                            <%-- <li><span><img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/deviceMgt/111.png" /></span></li>
                            <li><span><img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/deviceMgt/222.png" /></span></li> --%>
                        </ul>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<div class="btn-content">
    <button type="button" class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
</div>

<!-- <button data-toggle="modal" data-target=".modal-bigImg"></button> -->
<div class="modal fade modal-bigImg" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  	<div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	      	<div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">查看大图</h4>
	      	</div>
	      	<div class="modal-body">
	       	 	<img src="" class="bigImg" />
	      	</div>
	    </div>
  	</div>
</div>