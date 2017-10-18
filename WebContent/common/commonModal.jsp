<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<div class="modal fade" id="sysNoticePopup" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		  <span class="notice-modal-close" aria-hidden="true">&times;</span>
		</button>
		<h4 class="modal-title notice-modal-title">${ LANG[sessionScope.loginUser.lang]['SYSTEM_NOTICE_TITLE'] }</h4>
	  </div>
	  <div class="modal-body">
	    <span class="modalContent"></span>
	  </div>
	  <div class="modal-footer">
	    <button type="button" class="btn btn-default" data-dismiss="modal">${ LANG[sessionScope.loginUser.lang]['BTN_CANCEL'] }</button>
		<button type="button" class="btn btn-primary confirm-btn" data-dismiss="modal">${ LANG[sessionScope.loginUser.lang]['BTN_CONFIRM'] }</button>
	  </div>
	</div>
  </div>
</div>