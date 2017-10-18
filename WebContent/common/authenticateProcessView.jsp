<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<!-- 电子物证管理-综合鉴定信息-鉴定过程 -->
<div class="form-module">
    <div class="form-module-title">
        <p>鉴定分配</p>
    </div>
    <div class="form-content">
        <form class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label">分配人：</label>
                <div class="col-sm-4">
                    <input type="text" placeholder="" class="form-control" />
                </div>
                <label class="col-sm-2 control-label">分配时间：</label>
                <div class="col-sm-4">
                    <input type="text" placeholder="" class="form-control" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">鉴定师：</label>
                <div class="col-sm-4">
                    <input type="text" placeholder="" class="form-control" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">预计开始时间：</label>
                <div class="col-sm-4">
                    <input type="text" placeholder="" class="form-control" />
                </div>
                <label class="col-sm-2 control-label">截至时间：</label>
                <div class="col-sm-4">
                    <input type="text" placeholder="" class="form-control" />
                </div>
            </div>
        </form>
    </div>
</div>
<div class="form-module">
    <div class="form-module-title">
        <p>检材领用</p>
    </div>
    <div class="form-content">
        <form class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label">领用人：</label>
                <div class="col-sm-2">
                    <select name="" id="" class="form-control">
                        <option value="">111</option>
                        <option value="">222</option>
                        <option value="">333</option>
                    </select>
                </div>
                <div class="col-sm-2">
                    <select name="" id="" class="form-control">
                        <option value="">111</option>
                        <option value="">222</option>
                        <option value="">333</option>
                    </select>
                </div>
                <label class="col-sm-2 control-label">领用时间：</label>
                <div class="col-sm-4">
                    <input type="text" placeholder="" class="form-control" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">领材拍照：</label>
                <div class="col-sm-10">
                    <div class="img-upload">
                        <div class="big-img">
                            <img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/deviceMgt/111.png" />
                        </div>
                        <ul class="img-list">
                            <li><span><img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/deviceMgt/111.png" /></span></li>
                            <li><span><img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/deviceMgt/222.png" /></span></li>
                        </ul>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<div class="form-module">
    <div class="form-module-title">
        <p>设备使用情况</p>
    </div>
    <div class="form-content">
        <form class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label">检材编号：</label>
                <div class="col-sm-4">
                    <input type="text" placeholder="" class="form-control" />
                </div>
            </div>
            <div class="form-group">
            	<label class="col-sm-2 control-label">设备识别号：</label>
                <div class="col-sm-4">
                    <select name="" id="" class="form-control">
                        <option value="">111</option>
                        <option value="">222</option>
                        <option value="">333</option>
                    </select>
                </div>
                <label class="col-sm-2 control-label">设备名称：</label>
                <div class="col-sm-4">
                    <select name="" id="" class="form-control">
                        <option value="">111</option>
                        <option value="">222</option>
                        <option value="">333</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">设备状况：</label>
                <div class="col-sm-4">
                    <input type="text" placeholder="" class="form-control" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">开始时间：</label>
                <div class="col-sm-4">
                    <input type="text" placeholder="" class="form-control" />
                </div>
                <label class="col-sm-2 control-label">结束时间：</label>
                <div class="col-sm-4">
                    <input type="text" placeholder="" class="form-control" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">备注：</label>
                <div class="col-sm-10">
                    <textarea rows="8" cols="" class="form-control"></textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label"></label>
                <div class="col-sm-10">
                    <button type="button" class="btn btn-color1 add-device-btn"><i class="fa fa-plus"></i>添加设备</button>
                </div>
            </div>
        </form>
    </div>
</div>
<div class="form-module">
    <div class="form-module-title">
        <p>鉴定原始记录</p>
    </div>
    <div class="form-content">
        <form class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label">鉴定视频：</label>
                <div class="col-sm-10">
                    <div class="form-control video-content"></div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">案件编号：</label>
                <div class="col-sm-4">
                    <input type="text" placeholder="" class="form-control" />
                </div>
                <label class="col-sm-2 control-label">检材编号：</label>
                <div class="col-sm-4">
                    <input type="text" placeholder="" class="form-control" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">鉴定方法：</label>
                <div class="col-sm-10">
                    <div class="ckbox ckbox-primary">
                        <input type="checkbox" value="1" id="checkboxPrimary" checked="checked">
                        <label for="checkboxPrimary">《数字化设备证据数据发现提取固定方法》GA/T756-2008</label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">检验地点：</label>
                <div class="col-sm-10">
                    <input type="text" placeholder="" class="form-control" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">开始时间：</label>
                <div class="col-sm-4">
                    <input type="text" placeholder="" class="form-control" />
                </div>
                <label class="col-sm-2 control-label">结束时间：</label>
                <div class="col-sm-4">
                    <input type="text" placeholder="" class="form-control" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">检验过程：</label>
                <div class="col-sm-10">
                    <textarea rows="8" cols="" class="form-control"></textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">杀毒结果：</label>
                <div class="col-sm-10">
                    <textarea rows="8" cols="" class="form-control"></textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">检验结果：</label>
                <div class="col-sm-10">
                    <textarea rows="8" cols="" class="form-control"></textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">备注：</label>
                <div class="col-sm-10">
                    <textarea rows="8" cols="" class="form-control"></textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">附件：</label>
                <div class="col-sm-10">
                	<div class="document-content">
                        <div class="document-style"><span>《检验鉴定照片记录表》</span></div>
                        <div class="document-style"><span>《提取电子证据清单》</span></div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<div class="form-module">
    <div class="form-module-title">
        <p>检材归还</p>
    </div>
    <div class="form-content">
        <form class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label">归还人：</label>
                <div class="col-sm-2">
                    <select name="" id="" class="form-control">
                        <option value="">111</option>
                        <option value="">222</option>
                        <option value="">333</option>
                    </select>
                </div>
                <div class="col-sm-2">
                    <select name="" id="" class="form-control">
                        <option value="">111</option>
                        <option value="">222</option>
                        <option value="">333</option>
                    </select>
                </div>
                <label class="col-sm-2 control-label">归还时间：</label>
                <div class="col-sm-4">
                    <input type="text" placeholder="" class="form-control" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">归还拍照：</label>
                <div class="col-sm-10">
                    <div class="img-upload">
                        <div class="big-img">
                            <img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/deviceMgt/111.png" />
                        </div>
                        <ul class="img-list">
                            <li><span><img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/deviceMgt/111.png" /></span></li>
                            <li><span><img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/deviceMgt/222.png" /></span></li>
                        </ul>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<div class="form-module">
    <div class="form-module-title">
        <p>文书整理</p>
    </div>
    <div class="form-content">
        <form class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label">文书列表：</label>
                <div class="col-sm-10">
                    <div class="document-content">
                        <div class="document-style"><span>物证鉴定档案</span></div>
                        <div class="document-style"><span>鉴定文书档案目录</span></div>
                        <div class="document-style"><span>鉴定文书副本</span></div>
                        <div class="document-style"><span>鉴定文书审批表</span></div>
                        <div class="document-style"><span>鉴定委托书</span></div>
                        <div class="document-style"><span>鉴定事项确认书</span></div>
                        <div class="document-style"><span>电子物证检验原始记录</span></div>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">审批意见：</label>
                <div class="col-sm-10">
                    <textarea rows="8" cols="" class="form-control"></textarea>
                </div>
            </div>
        </form>
    </div>
</div>
<div class="btn-content">
    <button type="button" class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
    <button type="button" class="btn btn-color1 btn-hide suspend-btn"><i class="fa fa-stop"></i>中止鉴定</button>
    <button type="button" class="btn btn-color1 btn-hide"><i class="fa fa-pause"></i>暂停鉴定</button>
</div>