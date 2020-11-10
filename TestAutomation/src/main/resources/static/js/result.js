// Result.js
function showItemData(id){
	$(".row"+id).slideDown();
	$("#btn-show-"+id).addClass('hidden');
	$("#btn-hide-"+id).removeClass('hidden');
}
function hideItemData(id){
	$(".row"+id).slideUp();
	$("#btn-show-"+id).removeClass('hidden');
	$("#btn-hide-"+id).addClass('hidden');
}
