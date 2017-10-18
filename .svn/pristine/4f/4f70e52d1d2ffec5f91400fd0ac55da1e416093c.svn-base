<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<!-- 电子物证管理-综合鉴定信息-登记信息 -->
<div class="form-title">检材流转记录表</div>
<div class="form-content">
   	<form class="form-horizontal">
   		<div class="form-group">
			<label class="col-sm-2 control-label">检材名称：</label>
			<div class="col-sm-4" data-bind="with: appraisalVM">
				<input type="text" data-bind="value: evidName" name="evidName" id="evidName" class="form-control" readonly/>
			</div>	
			<label class="col-sm-2 control-label">唯一性编号：</label>
			<div class="col-sm-4" data-bind="with: appraisalVM">
				<input type="text" data-bind="value: evidSn" name="evidSn" id="evidSn" class="form-control" readonly/>
			</div>				
		</div>			
		<div class="form-group">
			<label class="col-sm-2 control-label">接收人：</label>
			<div class="col-sm-4" data-bind="with: evidenceVM">
				<input type="text" data-bind="value: creatorAlias" name="creatorAlias" id="creatorAlias" class="form-control" readonly/>
			</div>	
			<label class="col-sm-2 control-label">接收时间：</label>
			<div class="col-sm-4" data-bind="with: evidenceVM">
               	<input id="createdDate" name="createdDate" class="form-control datetimepicker" data-bind="dateTimePicker: createdDate" readonly/>
               </div>		
		</div>	
		<div class="form-group">
			<label class="col-sm-2 control-label">存放地点：</label>
			<div class="col-sm-10" data-bind="with: evidenceVM">
				<input type="text" data-bind="value: location" name="location" id="location" class="form-control" readonly/>
			</div>	
		</div>		
   	</form>
</div>
<div class="file-upload">
    <table class="table table-bordered devTelFile" id="table2">
        <thead>
            <tr>
                <th>时间</th>
                <th>交接人1</th>
                <th>交接人2</th>
                <th>备注(检验/发还)</th>
            </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</div>
<div class="btn-content">
    <button type="button" class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
</div>