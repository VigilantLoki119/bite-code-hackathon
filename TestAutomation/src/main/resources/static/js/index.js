/* Home JS */
$(document).ready(function() {
	  $( "#selectedApp" ).change(function() {
		$("#selectedPage").html("");
	 	var appkey = $("#selectedApp").val();
	     $.ajax({
	         type : 'GET', 
	         url  : 'http://localhost:2024/app/conf/page/details/'+appkey, 
	         success: function(response) {
	         	if(undefined != response ){
					var i=0;
					var str= "<option value=''>Select Functionality Name</option>";
					for(i; i<response.appPages.length; i++){
						str=str+"<option value='"+response.appPages[i].pageId+"___"+response.appPages[i].pageName+"'>"+response.appPages[i].pageName+"</option>";
					}
	         		$("#selectedPage").html(str);
	         	}
	         },
	         error: function(response) {
	         	
	        }
	     });
		});
	  
	  $( "#selectedPage" ).change(function() {
		  $("#selectedTestCaseName").html("");
   		
		 	var appkey = $("#selectedApp").val();
		 	var pagekey = $("#selectedPage").val();
		     $.ajax({
		         type : 'GET', 
		         url  : 'http://localhost:2024/app/conf/testcase/'+appkey+'/'+pagekey, 
		         success: function(response) {
		         	if(undefined != response ){
						var i=0;
						var str= "";
						for(i; i<response.testCases.length; i++){
							str=str+"<option value='"+response.testCases[i].testCaseId+"___"+response.testCases[i].testCaseName+"'>"+response.testCases[i].testCaseName+"</option>";
						}
		         		$("#selectedTestCaseName").html(str);
		         		
		         	}
		         },
		         error: function(response) {
		         	
		        }
		     });
			});
	
	  
	  $( "#loginCredRequired" ).click(function() {
		  
		  if ($("#loginCredRequired").prop("checked") == true){
		    $("#loginCred").show();
		  } else {
			  $("#loginCred").hide();
		  }
		  
			});
	  

	  
	});



function getUrlValue(id){
	  

			$("#selectedUrlSite"+id).html("");
		 	var envId = $("#selectedEnvSite"+id).val();
		     $.ajax({
		         type : 'GET', 
		         url  : 'http://localhost:2024/app/conf/env/url/'+envId, 
		         success: function(response) {
		         	if(undefined != response ){
		         		$("#selectedUrlSite"+id).val(response);
		         	}
		         },
		         error: function(response) {
		         	
		        }
		     });
			
	
}



