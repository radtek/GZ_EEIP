function renderDate(value, p, r) {
	if (value != null) {
		return Ext.Date.dateFormat(value, 'Y-m-d G:i');
	}
	return "";
}

function loadData(dataForm, url) {
	var params = dataForm.getForm().getValues();
	dataForm.getForm().load({
		waitMsg : 'Loading',
		waitTitle : 'Information',
		params : params,
		url : url,
		method : 'GET',
		success : function(form, action) {
			// nothing to do
		},
		failure : function(form, action) {
			Ext.Msg.alert("System Information", action.result.errorMessage);
		}
	});
}

function loadGrid(grid, selectedCount) {
	if ((grid.getStore().getCount() == selectedCount) && grid.getStore().currentPage > 1) {
		grid.getStore().loadPage(grid.getStore().currentPage - 1);
	} else {
		grid.getStore().load();
	}
}

//Parent Node Verification - Start
function isValidParentNode(currentId, chosenId, map) {
	try {
		if ( currentId == chosenId ) return false;
		var status = true;
		var parentId = "";
		while(true) {
			if ( map.get(chosenId) != undefined ) {
				parentId = map.get(chosenId);
				if ( currentId == parentId ) { status = false; break; }
			}
			else if ( map.get(chosenId) == undefined ) break;

			if ( parentId != "" ) {
				if ( map.get(parentId) != undefined ) {
					parentId = map.get(parentId);
					if ( currentId == parentId ) { status = false; break; }
    			}
				else if ( map.get(parentId) == undefined ) break;
			}
			else if ( parentId == "" ) break;
		}
		return status;
	} catch(e) {  }
	return true;
}

function loadNodeCache(node, map) {
	try {
		if ( node.childNodes != null && node.childNodes.length > 0 ) {
			for ( var i = 0; i < node.childNodes.length; i++ ) {
				if ( !map.containsKey(node.childNodes[i].get("id")) ) {
					map.put(node.childNodes[i].get("id"), node.childNodes[i].get("parentId"));
				}
			}
		}
	} catch(e) {  }
}

function clearNodeCache(map) {
	try {
		map.clear();
	} catch(e) {  }
}
//Parent Node Verification - End