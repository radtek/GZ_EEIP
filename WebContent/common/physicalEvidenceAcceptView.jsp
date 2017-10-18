<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<!-- 电子物证管理-综合鉴定信息-物证受理 -->
<div class="form-module">
    <div class="form-module-title">
        <p>检材受理</p>
    </div>
    <div class="form-content">
        <form class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label">受理人：</label>
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
                <label class="col-sm-2 control-label">受理时间：</label>
                <div class="col-sm-4">
                    <input type="text" placeholder="" class="form-control" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">受理意见：</label>
                <div class="col-sm-10">
                    <div class="matter-content">
                        <div class="matter-module">
                            <div class="matter-module-title">外观是否完整：</div>
                            <div class="matter-module-option">
                                <div class="col-sm-4">
                                    <div class="rdio rdio-primary">
                            <input type="radio" name="radio1" value="" id="radioYes">
                            <label for="radioYes">是</label>
                        </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="rdio rdio-primary">
                            <input type="radio" name="radio1" value="" id="radioNo">
                            <label for="radioNo">否</label>
                        </div>
                                </div>
                            </div>
                        </div>
                        <div class="matter-module">
                            <div class="matter-module-title">拟同意接收：</div>
                            <div class="matter-module-option">
                                <div class="col-sm-4">
                                    <div class="rdio rdio-primary">
                            <input type="radio" name="radio2" value="" id="radioYes2">
                            <label for="radioYes2">是</label>
                        </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="rdio rdio-primary">
                            <input type="radio" name="radio2" value="" id="radioNo2">
                            <label for="radioNo2">否</label>
                        </div>
                                </div>
                            </div>
                        </div>
                        <div class="matter-module">
                        <div class="matter-module-title">其他：</div>
                            <div class="matter-module-option">
                                <div class="col-sm-12">
                                    <input type="text" value="" class="other-inputs" />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>					
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">受理拍照：</label>
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
<div class="btn-content">
    <button type="button" class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
</div>