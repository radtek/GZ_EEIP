function getAppGridTools(moreUrl) {
	return [ {
		xtype : 'tool',
		type : 'refresh',
		handler : function(e, target, header, tool) {
			applicationGrid.getStore().load();
		}
	}, {
		xtype : 'tool',
		type : 'right',
		handler : function(e, target, header, tool) {
			window.location = moreUrl;
		}
	} ];
}

function getMeetingGridTools(moreUrl) {
	return [ {
		xtype : 'tool',
		type : 'refresh',
		handler : function(e, target, header, tool) {
			meetingGrid.getStore().load();
		}
	}, {
		xtype : 'tool',
		type : 'right',
		handler : function(e, target, header, tool) {
			window.location = moreUrl;
		}
	} ];
}

function getApprovalGridTools(moreUrl) {
	return [ {
		xtype : 'tool',
		type : 'refresh',
		handler : function(e, target, header, tool) {
			approvalGrid.getStore().load();
		}
	}, {
		xtype : 'tool',
		type : 'right',
		handler : function(e, target, header, tool) {
			window.location = moreUrl;
		}
	} ];
}

//Initialize Data Model
function initDataModel() {
	try {
		Ext.define('applicationDataModel', {
      	  extend: 'Ext.data.Model',
      	  fields: [ 
      	      { name: 'applicationId', mapping: 'applicationId', type: 'string' },
              { name: 'meetingTopic', mapping: 'meetingTopic', type: 'string' },
              { name: 'createdDate', mapping: 'createdDate', type: 'string',type: 'date',dateFormat: 'time' },
              { name: 'applicationStatus', mapping: 'applicationStatus', type: 'int' }
            ],
            idProperty: 'applicationId'
        });
      
        Ext.define('meetingDataModel', {
      	  extend: 'Ext.data.Model',
            fields: [ 
                { name: 'scheduleId', mapping: 'scheduleId', type: 'string' },
                { name: 'meetingStartDate', mapping: 'meetingStartDate',type: 'date',dateFormat: 'time' },
                { name: 'meetingEndDate', mapping: 'meetingEndDate',type: 'date',dateFormat: 'time' },
                { name: 'meetingId', mapping: 'meetingId', type: 'string' },
                { name: 'roomName', mapping: 'roomName', type: 'string' },
                { name: 'meetingTopic', mapping: 'meetingTopic', type: 'string' }
            ],
            idProperty: 'scheduleId'
        });
        
        Ext.define('approvalDataModel', {
      	  extend: 'Ext.data.Model',
            fields: [
                { name: 'applicationId', mapping: 'applicationId', type: 'string' },
	        	{ name: 'meetingId', mapping: 'meetingId', type: 'string'},
	            { name: 'meetingTopic', mapping: 'meetingTopic', type: 'string' },
	            { name: 'applicantName', mapping: 'applicantName', type: 'string' },
	            { name: 'createdDate', mapping: 'createdDate',type: 'date', dateFormat: 'time' },
	            { name: 'modifiedDate', mapping: 'modifiedDate',type: 'date', dateFormat: 'time' },
	            { name: 'applicationStatus', mapping: 'applicationStatus', type: 'int' },
	            { name: 'applicationTypeId', mapping: 'applicationTypeId', type: 'string' },
	            { name: 'startDate', mapping: 'startDate',type: 'date', dateFormat: 'time' },
	            { name: 'endDate', mapping: 'endDate',type: 'date', dateFormat: 'time' }
            ],
            idProperty: 'applicationId'
        });
	} catch(e) { console.log (e); }
}

//Data Store
function getApplicationStore(url) {
	return Ext.create('Ext.data.Store', {
  	  model: 'applicationDataModel',
	  remoteSort: true,
	  proxy: {
		  type: 'ajax',
		  url: url,
		  reader: {
			  type: 'json',
			  root: 'entities',
			  totalProperty: 'totalCount'
		  },
		  simpleSortMode: true
	  },
	  sorters: [{
		  property: 'createdDate',
		  direction: 'DESC'
      }]
  });
}

function getMeetingStore(url) {
	return Ext.create('Ext.data.Store', {
  	  model: 'meetingDataModel',
	  remoteSort: true,
	  proxy: {
		  type: 'ajax',
		  url: url,
		  reader: {
			  type: 'json',
			  root: 'entities',
			  totalProperty: 'totalCount'
		  },
		  simpleSortMode: true
	  },
	  sorters: [{
		  property: 'meetingStartDate',
		  direction: 'DESC'
      }]
  });
}

function getApprovalStore(url) {
	return Ext.create('Ext.data.Store', {
  	  model: 'approvalDataModel',
	  remoteSort: true,
	  proxy: {
		  type: 'ajax',
		  url: url,
		  reader: {
			  type: 'json',
			  root: 'entities',
			  totalProperty: 'totalCount'
		  },
		  simpleSortMode: true
	  },
	  sorters: [{
		  property: 'createdDate',
		  direction: 'DESC'
      }]
  });
}

//Data Grid
function getApplicationGrid(applicationStore, url) {
	return Ext.create('Ext.grid.Panel', {
  	  width: '100%',
	  height: '100%',
      store: applicationStore,
      listeners: {
    	  itemclick: function( cmp, record, item, index, e, eOpts ) {
    		  window.location = url + "?applicationId=" + record.get("applicationId");
    	  }
      },
      columns: [
          { text: "id", dataIndex: 'applicationId', width: 200, align: 'left', hidden: true, sortable: false },
          { text: "会议主题", dataIndex: 'meetingTopic', width: 260, align: 'left', hidden: false, sortable: true, renderer: function(value, meta, record) { meta.style = "cursor: pointer"; return value; } },
          { text: "申请时间", dataIndex: 'createdDate', width: 130, align: 'left', hidden: false, sortable: true, renderer: renderDate },
          { text: "审核状态", dataIndex: 'applicationStatus', width: 80, align: 'left', hidden: false, sortable: true, renderer: renderApprovalStatus }
      ]
  });
}

function getMeetingGrid(meetingStore, url) {
	return Ext.create('Ext.grid.Panel', {
  	  width: '100%',
	  height: '100%',
      store: meetingStore,
      listeners: {
    	  itemclick: function( cmp, record, item, index, e, eOpts ) {
    		  window.location = url + "?meetingId=" + record.get("meetingId");
    	  }
      },
      columns: [
          { text: "id", dataIndex: 'scheduleId', width: 200, align: 'left', hidden: true, sortable: false },
          { text: "meetingId", dataIndex: 'meetingId', width: 200, align: 'left', hidden: true, sortable: false },
          { text: "会议主题", dataIndex: 'meetingTopic', width: 250, align: 'left', hidden: false, sortable: true, renderer: function(value, meta, record) { meta.style = "cursor: pointer"; return value; } },
          { text: "会议室", dataIndex: 'roomName', width: 150, align: 'left', hidden: false, sortable: true },
          { text: "会议时间", dataIndex: 'meetingStartDate', width: 130, align: 'left', hidden: false, sortable: true, renderer: renderDate }
      ]
  });
}

function getApprovalGrid(approvalStore, url) {
	return Ext.create('Ext.grid.Panel', {
  	  width: '100%',
	  height: '100%',
      store: approvalStore,
      listeners: {
    	  itemclick: function( cmp, record, item, index, e, eOpts ) {
    		  window.location = url + "?applicationId=" + record.get("applicationId");
    	  }
      },
      columns: [
          { text: "id", dataIndex: 'applicationId', width: 200, align: 'left', hidden: true, sortable: false },
          { text: "会议主题", dataIndex: 'meetingTopic', width: 210, align: 'left', hidden: false, sortable: true, renderer: function(value, meta, record) { meta.style = "cursor: pointer"; return value; } },
          { text: "申请人", dataIndex: 'applicantName', width: 60, align: 'left', hidden: false, sortable: true },
          { text: "申请时间", dataIndex: 'createdDate', width: 130, align: 'left', hidden: false, sortable: true, renderer: renderDate },
          { text: "会议时间", dataIndex: 'startDate', width: 130, align: 'left', hidden: false, sortable: true, renderer: renderDate }
      ]
  });
}

function loadGridsData() {
	try {
		applicationGrid.getStore().load();
		meetingGrid.getStore().load();
		approvalGrid.getStore().load();
	} catch(e) { console.log (e); }
}

function renderApprovalStatus(value, p, r) {
	var status = "";
	if( value == 1 ) { status = "待审批";  }
	if( value == 2 ) { status = "已通过";  }
	if( value == 3 ) { status = "未通过";  }
    return status;
}