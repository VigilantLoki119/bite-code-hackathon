/* Home JS */
$(document).ready(function() {
	  $( "#selectedApp" ).change(function() {
		$("#selectedPage").html("");
	 	var appId = $("#selectedApp").val();
	     $.ajax({
	         type : 'GET', 
	         url  : 'http://localhost:2024/app/conf/page/details/'+appId, 
	         success: function(response) {
	         	if(undefined != response ){
					var i=0;
					var str= "<option value=''>Select Functionality Name</option>";
					for(i; i<response.appPages.length; i++){
						str=str+"<option value='"+response.appPages[i].pageId+"'>"+response.appPages[i].pageName+"</option>";
					}
	         		$("#selectedPage").html(str);
	         	}
	         },
	         error: function(response) {
	         	
	        }
	     });
		});
	  
	  $( "#selectedPage" ).change(function() {
		  $("#selectedTestCaseSite1").html("");
   		  $("#selectedTestCaseSite2").html("");
		 	var appId = $("#selectedApp").val();
		 	var pageId = $("#selectedPage").val();
		     $.ajax({
		         type : 'GET', 
		         url  : 'http://localhost:2024/app/conf/testcase/'+appId+'/'+pageId, 
		         success: function(response) {
		         	if(undefined != response ){
						var i=0;
						var str= "";
						for(i; i<response.testCases.length; i++){
							str=str+"<option value='"+response.testCases[i].testCaseId+"'>"+response.testCases[i].testCaseName+"</option>";
						}
		         		$("#selectedTestCaseSite1").html(str);
		         		$("#selectedTestCaseSite2").html(str);
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
	  
	  
	  $('ul.navbar-nav > li') .click(function (e) { 
			 $('ul.navbar-nav > li') .removeClass('active'); 
			 $(this).addClass('active'); 
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



