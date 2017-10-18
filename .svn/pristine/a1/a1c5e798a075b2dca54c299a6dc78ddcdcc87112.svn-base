var highlightedMenu = null;

function highlightCurrentMenu(menu) {
	try {
		if ( highlightedMenu != null ) highlightedMenu.removeCls("menu-text-highlight");
    	highlightedMenu = menu;
    	highlightedMenu.addCls("menu-text-highlight");
	} catch(e) { console.log (e); }
}

function initUserProfileFormRules() {
	Ext.apply(Ext.form.field.VTypes, {
		userPwdValidity: function(val, field) {
			if (val != "" && userInfoForm.getForm().findField("newPwd") != undefined) {
				if ( val != userInfoForm.getForm().findField("newPwd").value ) { return false; }
				else { return true; }
			}
    },
    userPwdValidityText: "用户密码输入前后不一致"
  });
}

function getUserProfileWindow(form) {
	return Ext.create('widget.window', {
		title: "个人信息设置",
		closable: true,
		closeAction: "hide",
		width: 600,
		minWidth: 600,
		maxWidth: 600,
		height: 380,
		maxHeight: 380,
		minHeight: 380,
		border: 0,
		layout: 'border',
		items: [{
			region: 'center',
			width: 380,
			split: false,
			collapsible: false,
			floatable: false,
			border: 0,
			items: [ form ]
		}]
    });
}

function getUserProfileForm(url, userId) {
	return Ext.create('Ext.form.Panel', {
		url: url,
        frame: false,
        bodyStyle: 'padding:5px 5px 0',
        width: '100%',
        height: 335,
        fieldDefaults: {
          labelWidth: 70,
          labelAlign: 'right'
        },
        items: [
          { xtype:'fieldset', title: '密码信息', collapsible: false, collapsed: false, defaultType: 'textfield', checkboxToggle: false, height: 120,
        	items: [
              { xtype: 'textfield', fieldLabel: '用户原密码', name: 'originalPwd', allowBlank: true, inputType: 'password', width: 250 },
              { xtype: 'textfield', fieldLabel: '用户新密码', name: 'newPwd', allowBlank: true, inputType: 'password', width: 250 },
              { xtype: 'textfield', fieldLabel: '确认新密码', name: 'confirmNewPwd', allowBlank: true, inputType: 'password', width: 250, vtype: 'userPwdValidity' }
            ]
          },
          { xtype:'fieldset', title: '用户信息', collapsible: false, collapsed: false, defaultType: 'textfield', checkboxToggle: false, height: 130,
              items: [
                  { xtype: 'container', anchor: '100%', layout: 'column', 
                    items: [
                        { xtype: 'container', layout: 'anchor', items: [{ xtype: 'textfield', fieldLabel: '电子邮件', name: 'userEmail', allowBlank: true, width: 250 }] },
                        { xtype: 'container', layout: 'anchor', items: [{ xtype: 'textfield', fieldLabel: '办公电话', name: 'userTelephone', allowBlank: true, width: 250 }] }
                    ]
                  }, { xtype: 'container', anchor: '100%', layout: 'column',
                	  items: [
                        { xtype: 'container', layout: 'anchor', items: [{ xtype: 'textfield', fieldLabel: '传真电话', name: 'userFax', allowBlank: true, width: 250 }] },
                        { xtype: 'container', layout: 'anchor', items: [{ xtype: 'textfield', fieldLabel: '移动电话', name: 'userCellphone', allowBlank: true, width: 250 }] }
                      ]
                  },
                  { xtype: 'textfield', fieldLabel: '联系地址', name: 'userAddress', allowBlank: true, width: 500 }
              ]
          },
          { xtype: 'textfield', fieldLabel: 'userId', name: 'userId', allowBlank: true, hidden: true, value: userId }
        ],
        buttons: [{
        	itemId: 'saveBtn',
        	text: '保存',
        	handler: function() {
        		var form = userInfoForm.form;
        		if (form.isValid()) {
        			userInfoForm.down("#saveBtn").setDisabled(true);
        			form.submit({
        				success: function(form, action) {
        					userInfoForm.down("#saveBtn").setDisabled(false);
        					Ext.Msg.alert("系统信息", action.result.msg, function(btn) {
        						userInfoWindow.close(); //close window
                            });
                        },
                        failure: function(form, action) {
                        	userInfoForm.down("#saveBtn").setDisabled(true);
                        	Ext.Msg.alert("系统信息", action.result.errors.msg);
                        }
                    });
        		}
        	}
        },{
        	text: '取消',
        	handler: function() {
        		userInfoWindow.close();
        	}
        }]
     });
}

function signout(url) {
    try {
    	Ext.MessageBox.confirm("系统信息", "确认是否登出系统", function(btn) {
    		if ( btn == "yes" ) { window.location = url; }
    		else { cmp.collapse(); }
        });
    } catch(e) { console.log (e); }
}

function getBanner(userAlias, contextPath, event0, event1, event2) {
	var banner = "";
    banner += "<div style=\"width: 100%; height: 55px; background-image:url(" + contextPath + "/resources/images/foreground/portal/banner_bg.jpg);\">";
    banner += "<table style=\"width: 100%; height: 55px;\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tr>";
    banner += "<td align=\"left\"><img src=\"" + contextPath + "/resources/images/foreground/portal/banner_logo.jpg\"/></td>";
    banner += "<td align=\"right\"><div id='bannerBtns' style=\"width:235px; heigh: 55px; position: relative; top: 10px;\">";
    banner += "<div style=\"float: left; margin: 0px 0px 0px 12px; color: #157FCC;\"><span class='fa fa-user fa-lg'></span><span id='user_alias' class='banner-btn-font'>&nbsp;" + userAlias + "</span></div>";
    banner += "<div style=\"float: left; cursor: pointer; margin: 0px 0px 0px 12px;\" onclick=\"" + event0 + "\"><span class='fa fa-home fa-lg'></span><span class='banner-btn-font'>&nbsp;首页</span></div>";
    banner += "<div style=\"float: left; cursor: pointer; margin: 0px 0px 0px 12px;\" onclick=\""+ event1 +"\"><span class='fa fa-gear fa-lg'></span><span class='banner-btn-font'>&nbsp;个人资料</span></div>";
    banner += "<div style=\"float: left; cursor: pointer; margin: 0px 0px 0px 12px;\" onclick=\""+ event2 +"\"><span class='fa fa-sign-out fa-lg'></span><span class='banner-btn-font'>&nbsp;登出</span></div>";
    banner += "</div></td>";
    banner += "</tr></table>";
    banner += "</div>";
    return banner;
}

function getUserProfileSettingBtn(url) {
	return Ext.create("Ext.Button", {
		text: "userSettingBtn",
		listeners: {
			click: function( obj, e, eOpts ) {
				try {
        			loadData(userInfoForm, url);
        			userInfoWindow.show(this, function() { 
        				try {
        					userInfoForm.getForm().findField("originalPwd").setValue("");
	        				userInfoForm.getForm().findField("newPwd").setValue("");
	        				userInfoForm.getForm().findField("confirmNewPwd").setValue("");
        				} catch(e) { console.log (e); }
        			});
    	        } catch(e) { console.log (e); }
            }
        }
    });
}

function getSignOutBtn(url) {
	return Ext.create("Ext.Button", {
		text: "signoutBtn",
		listeners: {
			click: function( obj, e, eOpts ) {
				signout(url);
            }
        }
    });
}

function pageRedirect(frameName, url) {
	try {
		var frame = document.getElementById(frameName);
		if ( frame != undefined ) frame.src = url;
	} catch(e) { console.log (e); }
}