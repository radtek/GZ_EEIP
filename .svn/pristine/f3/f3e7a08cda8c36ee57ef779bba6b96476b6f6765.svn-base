function applyLicense(appUrl, downloadUrl) {
	try {
		var licenseApp = {
			corpName : $("#corpName").val(),
			applicantName : $("#applicantName").val(),
			applicantTel : $("#applicantTel").val(),
			applicantEmail : $("#applicantEmail").val(),
			applicantAddr : $("#applicantAddr").val()
		};

		$.ajax({
			type : "POST",
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			url : appUrl,
			cache : false,
			async : false,
			data : JSON.stringify(licenseApp),
			success : function(data) {
				if (data.key != undefined) {
					download(downloadUrl, {
						"key" : data.key
					});
				}
			}
		});
	} catch (e) {
		console.log(e);
	}
}

function activateLicense(url) {
	var status = false;
	var expDate = "";
	try {
		$.ajax({
			url : url,
			type : "POST",
			cache : false,
			async : false,
			data : {
				"regCode" : $("#regCode").val()
			},
			success : function(data) {
				status = data.status;
				expDate = data.expDate;
			}
		});
	} catch (e) {
		console.log(e);
	}
	return { status : status, expDate : expDate };
}

function clearRegInfo() {
	try {
		$("#corpName,#applicantName,#applicantTel,#applicantEmail,#applicantAddr").val("");
	} catch (e) {
		console.log(e);
	}
}

function clearRegCode() {
	try {
		$("#regCode").val("");
	} catch (e) {
		console.log(e);
	}
}