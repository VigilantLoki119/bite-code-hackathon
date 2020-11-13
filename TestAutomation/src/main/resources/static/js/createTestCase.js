$(document).ready(function(){
	$('.add-record').click(function(e) {
     e.preventDefault();    
     var size = $('#tbl_posts >tbody >tr').length + 1 ;
     content = "<tr id='rec-"+size+"'>";
     content+="<th scope='row' class='sn'>"+size+"</th>";
    
     
     content+=	"<td><input class='tNodeName' type='text' name='nodeName"+size+"' id='nodeName"+size+"'/></td>";
     content+=	"<td><input class='tXpathStr' type='text' name='xpathStr"+size+"' id='xpathStr"+size+"'/></td>";
     content+=	"<td><input class='tOperationName' type='text' name='operationName"+size+"' id='operationName"+size+"'/></td>";
     content+=	"<td><input class='tTestData' type='text' name='testData"+size+"' id='testData"+size+"'/></td>";
     content+=	"<td><a class='btn btn-xs delete-record' data-id='"+size+"'><i class='glyphicon glyphicon-trash'></i></a></td>";
     content+="</tr>";

     var content12 = jQuery('#tbl_posts_body');
     content12.append(content);
   });
	
	$(document).delegate('a.delete-record', 'click', function(e) {
     e.preventDefault();    
      var id = $(this).attr('data-id');
      if($('#tbl_posts_body tr').length>1){
    	  $('#rec-' + id).remove(); 
      }else{
    	  return false;
      }
     
      
    //regnerate index number on table
    $('#tbl_posts_body tr').each(function(index){
		$(this).find('th.sn').html(index+1);
	    $(this).attr('id','rec-'+(index+1));
		$(this).find('.tNodeName').attr('name','nodeName'+(index+1));
		$(this).find('.tXpathStr').attr('name','xpathStr'+(index+1));
		$(this).find('.tOperationName').attr('name','operationName'+(index+1));
		$(this).find('.tTestData').attr('name','testData'+(index+1));
		$(this).find('.delete-record').attr('data-id',index+1);
    });
    
});
	
	
	

	   
    $('#submitTestCase').click(function(e) {
    	e.preventDefault();
    	var size = $('#tbl_posts >tbody >tr').length;
    	var request = {};
    	var itemList = [];
    	var j=0;
    	for(i=1 ; i<= size;i++){
    		var item = {};
    		item.nodeName = $("#nodeName"+i).val();
    		item.xpathStr = $("#xpathStr"+i).val();
    		item.operationName = $("#operationName"+i).val();
    		item.testData = $("#testData"+i).val(); 
    		itemList.push(item);
    	}
    	console.log(itemList);
    	request.items = itemList;
    	var productRequest = {}; 
        $.ajax({
            type        : 'POST', 
            url         : '', 
            data        : JSON.stringify(request), 
            contentType	: 'application/json',
            dataType	: 'json',
            success: function(response) {
            	
            },
            error: function(response) {
            	
            }
        });
    });
    
    
    
  });

