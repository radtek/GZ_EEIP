Date.prototype.Format = function(fmt) {
	var o = {
		"M+" : this.getMonth() + 1, //month
		"d+" : this.getDate(), //day
		"h+" : this.getHours(), //hour
		"m+" : this.getMinutes(), //minute
		"s+" : this.getSeconds(), //second
		"q+" : Math.floor((this.getMonth() + 3) / 3), //quarter
		"S" : this.getMilliseconds() //millisecond
	};
	if (/(y+)/.test(fmt))
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	for ( var k in o)
		if (new RegExp("(" + k + ")").test(fmt))
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
					: (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt;
}

function getFormattedDate(data, type, row) {
	return data ? new Date(data).Format("yyyy-MM-dd hh:mm") : data;
}

Date.prototype.FormatToHours = function(fmt) { 
	 
	return this.getHours();
}

function getFormattedDateOnHours(data, type, row) {
	return data ? new Date(data).FormatToHours("yyyy-MM-dd hh:mm") : data;
}
