var $idown;

function download(url, params) {
	try {
		var paramStr = "";
		if ( params != undefined 
				&& params != null ) {
			var count = 0;
			for ( var item in params ) {
				if ( count == 0 ) { paramStr += "?" + item + "=" +params[item]; }
				else { paramStr += "&" + item + "=" +params[item]; }
				count ++;
		    }
		}
		
		if ($idown) {
			$idown.attr('src', url + paramStr);
		} else {
			$idown = $('<iframe>', {
				id : 'idown',
				src : url + paramStr
			}).hide().appendTo('body');
		}
	} catch(e) { console.log(e); }
}