$(document).ready(function(){
	   
    $('#submitTestCase').click(function(e) {
    	e.preventDefault();
    	var request = {};
    	var itemList = [];
    	
    	 $('#accordion .main-record').each(function(index){
    		var item = {};
    		item.name_teststep = $("#name_teststep"+index).val();
    		item.xpathSite1_teststep = $("#xpathSite1_teststep"+index).val();
    		item.operationSite1_teststep = $("#operationSite1_teststep"+index).val();
    		item.testDataSite1_teststep = $("#testDataSite1_teststep"+index).val(); 
    		item.xpathSite2_teststep = $("#xpathSite2_teststep"+index).val();
    		item.operationSite2_teststep = $("#operationSite2_teststep"+index).val();
    		item.testDataSite2_teststep = $("#testDataSite2_teststep"+index).val(); 
    		itemList.push(item);
    	});
    	console.log(itemList);
    	request.testCaseName =  $('#testCaseName').val(); 
    	request.appName = $('#selectedApp').val();
    	request.pageName = $('#selectedPage').val();
    	request.envIdSite1 = $('#selectedEnvSite1').val();
    	request.envIdSite2 = $('#selectedEnvSite2').val();
    	request.testCaseSteps = itemList;
    	
    	var productRequest = {}; 
        $.ajax({
            type        : 'POST', 
            url         : '/app/conf/submit-testcase', 
            data        : JSON.stringify(request), 
            contentType	: 'application/json',
            dataType	: 'json',
            success: function(response) {
            	console.log(response);
            	$("#msg").text(response.msg);
            	$("#row-msg").show();
            },
            error: function(response) {
            	
            }
        });
    }); 
	
    
  });


function collapseTestStep(id){
	var teststepName = $('#name_teststep'+id).val();
	if(undefined == teststepName || '' == teststepName){
		return false;
	}
	$("#clspTestStep"+id).toggle();
	
}

function addTestStep(id){
	var mainId = id;
	//var size = $('#accordion >.main-record').length;
	var content = "";
	 $('#accordion .main-record').each(function(index){
	    if(index<mainId){
	    	 changeAttribute($(this),index);
			 content = content + '<div class="main-record" id="record'+index+'">' + $(this).html() + '</div>';
		 }else if(index>mainId){
			 id=id+1;
			 changeAttribute($(this),id);
			 content = content + '<div class="main-record" id="record'+id+'">' + $(this).html() + '</div>';
		 }else{
			 changeAttribute($(this),index);
			 content = content + '<div class="main-record" id="record'+index+'">' + $(this).html() + '</div>';
			 id=id+1;
			 content = content + '<div class="main-record" id="record'+id+'">' + $('#templateRecord').html() +'</div>';
		 } 
			
	    });
	 
	 $('#accordion').html(content);
	 mainId=mainId+1;
	 changeAttribute($('#record'+mainId),mainId);
	 $('#clspTestStep'+mainId).hide();
	
}

function deleteTestStep(id){
	var size = $('#accordion >.main-record').length;
	if(size==1){
		return false;
	}
	 $('#record'+id).remove(); 
	
	 var content = "";
	 $('#accordion .main-record').each(function(index){
		 changeAttribute($(this),index);
		 $(this).attr('id','record'+index);
	    });
	 
	
	
}

function changeAttribute(element,id){
	var value='';
	
	element.find('.collapse-record').attr('onclick','collapseTestStep('+id+')');
	element.find('.collapse-record span').html('Step'+(id+1));
	
	value = element.find('.teststepName').val();
	element.find('.teststepName').attr('value',value);
	element.find('.teststepName').attr('name','name_teststep'+id);
	element.find('.teststepName').attr('id','name_teststep'+id);
	element.find('.spanName_teststep').attr('id','spanName_teststep'+id);
	element.find('.spanName_teststep').html(value);
	
	element.find('.glyphicon-ok').attr('onclick','saveTestStepName('+id+')');
	element.find('.glyphicon-pencil').attr('onclick','editTestStepName('+id+')');
	element.find('.delete-record').attr('onclick','deleteTestStep('+id+')');
	element.find('.add-record').attr('onclick','addTestStep('+id+')');
	element.find('.collapse-teststep').attr('id','clspTestStep'+id);
	
	value = element.find('.xpathSite1').val();
	element.find('.xpathSite1').attr('value',value);
	element.find('.xpathSite1').attr('name','xpathSite1_teststep'+id);
	element.find('.xpathSite1').attr('id','xpathSite1_teststep'+id);
	
	value = element.find('.operationSite1').val();
	element.find('.operationSite1 option[value='+value+']').attr("selected",true);
	element.find('.operationSite1').attr('name','operationSite1_teststep'+id);
	element.find('.operationSite1').attr('id','operationSite1_teststep'+id);
	
	value = element.find('.testDataSite1').val();
	element.find('.testDataSite1').attr('value',value);
	element.find('.testDataSite1').attr('name','testDataSite1_teststep'+id);
	element.find('.testDataSite1').attr('id','testDataSite1_teststep'+id);
	
	value = element.find('.xpathSite2').val();
	element.find('.xpathSite2').attr('value',value);
	element.find('.xpathSite2').attr('name','xpathSite2_teststep'+id);
	element.find('.xpathSite2').attr('id','xpathSite2_teststep'+id);
	
	value = element.find('.operationSite2').val();
	element.find('.operationSite2 option[value='+value+']').attr("selected",true);
	element.find('.operationSite2').attr('name','operationSite2_teststep'+id);
	element.find('.operationSite2').attr('id','operationSite2_teststep'+id);
	
	value = element.find('.testDataSite2').val();
	element.find('.testDataSite2').attr('value',value);
	element.find('.testDataSite2').attr('name','testDataSite2_teststep'+id);
	element.find('.testDataSite2').attr('id','testDataSite2_teststep'+id);
	
}

function saveTestStepName(id){
	
	var teststepName = $('#name_teststep'+id).val();
	if(undefined == teststepName || '' == teststepName){
		return false;
	}
	$('#spanName_teststep'+id).text(teststepName);
	
	$('#name_teststep'+id).hide();
	$('#spanName_teststep'+id).show();
	$('#clspTestStep'+id).show();
	
	$('#record'+id+ ' .glyphicon-pencil').show();
	$('#record'+id+ ' .glyphicon-ok').hide();
	
}

function editTestStepName(id){
	
	$('#name_teststep'+id).show();
	$('#spanName_teststep'+id).hide();
	
	
	$('#record'+id+ ' .glyphicon-pencil').hide();
	$('#record'+id+ ' .glyphicon-ok').show();
	
}
