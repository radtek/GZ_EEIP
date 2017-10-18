var PAGE_CONTEXT;

function initWorkflow(pageContext) {
	PAGE_CONTEXT = pageContext;
}

function createTask(appraisalId) {
	var status = false;
    $.ajax({
      url: PAGE_CONTEXT + "/workflow/createTask.do",
	  data: { "appraisalId" : appraisalId },
	  datatype: "json",
	  type: "post",
	  success: function(data){
		  status = data.status;
	  },
	  error: function(){
		  console.log("Data processing is unsuccessful");
	  }
	});
    return status;
}