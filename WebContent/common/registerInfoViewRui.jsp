<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<!-- 电子物证管理-综合鉴定信息-登记信息 -->
<div class="upload-module">
    <div class="module-title">
        <p>立案材料</p>
    </div>
    <div class="file-list">
    </div>   
</div>
<div class="form-module">
    <div class="form-module-title">
        <p>基本信息</p>
    </div>
    <div class="form-content">
    	<form class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-2 control-label">委托鉴定单位：</label>
				<div class="col-sm-4" data-bind="with: preappraisalVM">
					<input type="text" data-bind="value: orgName" name="orgName" id="orgName" class="form-control" readonly/>
				</div>	
				<label class="col-sm-2 control-label">委托时间：</label>
				<div class="col-sm-4" data-bind="with: preappraisalVM">
					<input id="entrustedDate" name="entrustedDate" class="form-control datetimepicker" data-bind="dateTimePicker:entrustedDate" readonly  />
				</div>			
			</div>			
			<div class="form-group">
				<label class="col-sm-2 control-label">送检人：</label>
				<div class="col-sm-2">
					<input type="text" class="form-control userAlias" readonly/>
				</div>	
				<label class="col-sm-1 control-label">职务：</label>
				<div class="col-sm-2">
					<input type="text" class="form-control userPost" readonly/>
				</div>
				<label class="col-sm-1 control-label">警察证号：</label>
				<div class="col-sm-2">
					<input type="text" class="form-control policeId" readonly/>
				</div>
				<div class="col-sm-2" style="display:none;">
					<button type="button" class="btn btn-color1 upload" id="add-person"><i class="fa fa-plus"></i>添加</button>
				</div>				
			</div>	
			<div class="form-group">
				<label class="col-sm-2 control-label">通讯地址：</label>
				<div class="col-sm-2" data-bind="with: provinceVM">
					<select id="province" class="form-control" 
					data-bind="options: provinceList,
					optionsValue:'provinceId',
					optionsText:'name',
					value:provinceId,
					optionsCaption:'--请选择--', 
					event:{change:changeProvince}" disabled ></select>
			       </div>
				<div class="col-sm-1 div-label">
					省
				</div>
				<div class="col-sm-2" data-bind="with:cityVM">
					<select id="city" class="form-control" 
					data-bind="options:cityList,
					optionsValue:'cityId',
					optionsText:'name',
					value:cityId,
					optionsCaption:'--请选择--', 
					event:{change:changeCity}" disabled ></select>
			      	</div>
				<div class="col-sm-1 div-label">
					市
				</div>	
				<div class="col-sm-2" data-bind="with:countyVM">
					<select id="county" class="form-control" 
					data-bind="options:countyList,
					optionsValue:'countyId',
					optionsText:'name',
					value:countyId,
					optionsCaption:'--请选择--' " disabled></select>
			      	</div>
				<div class="col-sm-1 div-label">
					区
				</div>			
			</div>	
			<div class="form-group">
				<label class="col-sm-2 control-label">详细地址：</label>
				<div class="col-sm-10" data-bind="with: preappraisalVM">
					<input type="text" data-bind="value: addr" name="addr" id="addr" class="form-control"  readonly/>
				</div>								
			</div>	
			<div class="form-group">
				<label class="col-sm-2 control-label">邮政编码：</label>
				<div class="col-sm-4" data-bind="with: preappraisalVM">
					<input type="text" data-bind="value: zipCode" name="zipCode" id="zipCode" class="form-control" readonly/>
				</div>
				<label class="col-sm-2 control-label">联系电话：</label>
				<div class="col-sm-4" data-bind="with: preappraisalVM">
					<input type="text" data-bind="value: tel" name="tel" id="tel" class="form-control" readonly/>
				</div>								
			</div>
			<div class="form-group">	
				<label class="col-sm-2 control-label">传真号码：</label>
				<div class="col-sm-4" data-bind="with: preappraisalVM">
					<input type="text" data-bind="value: fax" name="fax" id="fax" class="form-control" readonly/>
				</div>									
			</div>	
			<div class="form-group">
				<label class="col-sm-2 control-label">案件名称：</label>
				<div class="col-sm-4" data-bind="with: preappraisalVM">
					<input type="text" data-bind="value: caseName" name="caseName" id="caseName" class="form-control" readonly/>
				</div>
				<label class="col-sm-2 control-label">案件编号：</label>
				<div class="col-sm-4" data-bind="with: preappraisalVM">
					<input type="text" data-bind="value: caseSn" name="caseSn" id="caseSn" class="form-control" readonly/>
				</div>										
			</div>	
			<div class="form-group">
				<label class="col-sm-2 control-label">简要说明：</label>
				<div class="col-sm-10" data-bind="with: preappraisalVM">
					<textarea data-bind="value: explanation" name="explanation" id="explanation" class="form-control" readonly></textarea>
				</div>								
			</div>		
			<div class="form-group">
				<label class="col-sm-2 control-label">鉴定要求：</label>
				<div class="col-sm-10" data-bind="with: preappraisalVM">
					<textarea data-bind="value: rqmt" name="rqmt" id="rqmt" class="form-control" readonly></textarea>
				</div>								
			</div>	
    	</form>
    </div>
</div>

<div class="form-module module-list">
	<div class="form-module-title">
        <p>送检检材</p>
    </div>
     <div class="form-content module-content">
     	<form class="form-horizontal">
     		<div class="form-group">
				<label class="col-sm-2 control-label evidName">名称：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" readonly/>
				</div>
				<label class="col-sm-2 control-label">数量：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" value="1" readonly  />
				</div>										
			</div>		
			<div class="form-group">
				<label class="col-sm-2 control-label">封存状态：</label>
				<div class="col-sm-4">
					<select  class="form-control status" disabled>
							<option value="0">物证袋封存</option>
							<option value="1">封条</option>
							<option value="2">未封存</option>
						</select>
				</div>												
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label input-choose" data-name=".check-material-radio">检材种类：</label>
				<div class="col-sm-10 check-material-radio">
					<div class="matter-content">
			            <div class="matter-module">
			                <div class="matter-module-option">
			                    <div class="col-sm-4">
			                        <div class="rdio rdio-primary">
			                            <input type="radio" name="" value="电脑主机" id="">
			                            <label for="">电脑主机</label>
			                        </div>
			                    </div>
			                    <div class="col-sm-4">
			                        <div class="rdio rdio-primary">
			                            <input type="radio" name="" value="笔记本电脑" id="">
			                            <label for="">笔记本电脑</label>
			                        </div>
			                    </div>
			                    <div class="col-sm-4">
			                        <div class="rdio rdio-primary">
			                            <input type="radio" name="" value="移动硬盘" id="">
			                            <label for="">移动硬盘</label>
			                        </div>
			                    </div>
			                    <div class="col-sm-4">
			                        <div class="rdio rdio-primary">
			                            <input type="radio" name="" value="硬盘" id="">
			                            <label for="">硬盘</label>
			                        </div>
			                    </div>
			                    <div class="col-sm-4">
			                        <div class="rdio rdio-primary">
			                            <input type="radio" name="" value="U盘" id="">
			                            <label for="">U盘</label>
			                        </div>
			                    </div>
			                    <div class="col-sm-4">
			                        <div class="rdio rdio-primary">
			                            <input type="radio" name="" value="SD存储卡（闪存）" id="">
			                            <label for="">SD存储卡（闪存）</label>
			                        </div>
			                    </div>
			                    <div class="col-sm-4">
			                        <div class="rdio rdio-primary">
			                            <input type="radio" name="" value="手机" id="">
			                            <label for="">手机</label>
			                        </div>
			                    </div>
			                    <div class="col-sm-4">
			                        <div class="rdio rdio-primary">
			                            <input type="radio" name="" value="平板电脑" id="">
			                            <label for="">平板电脑</label>
			                        </div>
			                    </div>
			                    <div class="col-sm-4">
			                        <div class="rdio rdio-primary">
			                            <input type="radio" name="" value="SIM卡" id="">
			                            <label for="">SIM卡</label>
			                        </div>
			                    </div>
			                    <div class="col-sm-4">
			                        <div class="rdio rdio-primary">
			                            <input type="radio" name="" value="数码设备(录音笔、相机、摄像机等)" id="">
			                            <label for="">数码设备(录音笔、相机、摄像机等)</label>
			                        </div>
			                    </div>
			                    <div class="col-sm-4">
			                        <div class="rdio rdio-primary">
			                            <input type="radio" name="" value="伪基站设备" id="">
			                            <label for="">伪基站设备</label>
			                        </div>
			                    </div>
			                    <div class="col-sm-12 other-position">
			                        <div class="rdio rdio-primary">
			                            <input type="radio" name="" value="其他" id="">
			                            <label for="">其他</label>
			                        </div>
			                        <input type="text" value="" class="other-input" readonly />
			                    </div>
			                </div>
			            </div>
		        	</div>
				</div>																	
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">特征描述：</label>
				<div class="col-sm-10">
					<textarea class="form-control" readonly></textarea>
				</div>								
			</div>		
			<div class="form-group">
				<label class="col-sm-2 control-label">备注说明：</label>
				<div class="col-sm-10">
					<textarea  class="form-control" readonly></textarea>
				</div>								
			</div>	
     	</form>
    </div>
	<div class="add-material-content">
		<label class="col-sm-2 control-label"></label>
		<div class="col-sm-10"  style="display:none;">
			<button type="button" class="btn btn-color1 add-material-btn"><i class="fa fa-plus"></i>新增检材</button>	
		</div>								
	</div>
	<div class="material-template"></div>
</div>
<div class="btn-content">
    <button type="button" class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
</div>