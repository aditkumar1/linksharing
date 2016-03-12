// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better 
// to create separate JavaScript files as needed.
//
//= require jquery
//= require_tree .
//= require_self
function makeAjaxcall(url,data,element){
	element.parent().prepend($("#ajaxSpinnerImage"));
	$.ajax({
		url:url,
		data:data,
		success: function (response) {
			console.log(response);
		}
	});
}
$(document)
	.ajaxStart(function(){
		$("#ajaxSpinnerImage").show();
	})
	.ajaxStop(function(){
		$("#ajaxSpinnerImage").hide();
		//location.reload();
	});
$(document).on('click', ".subscription", function () {
	console.log($(this).attr('data-url'));
	url=$(this).attr('data-url')
	makeAjaxcall(url,null,$(this))
});
$(document).on('change', ".seriousness", function () {
	console.log($(this).attr('data-url'));
	id=$(this).attr('data-id')
	console.log(id);
	url=$(this).attr('data-url')
	data="id="+id+"&seriousness="+$(this).val()
	console.log(data)
	makeAjaxcall(url,data,$(this))
});
$(document).on('change', ".visibility", function () {
	console.log($(this).attr('data-url'));
	id=$(this).attr('data-id')
	console.log(id);
	url=$(this).attr('data-url')
	data="id="+id+"&visibility="+$(this).val()
	console.log(data)
	makeAjaxcall(url,data,$(this))
});
$(document).on('click', ".topicDelete", function () {
	console.log($(this).attr('data-url'));
	url=$(this).attr('data-url')
	makeAjaxcall(url,null,$(this))
});
$(document).on('click', ".markasread", function () {
	console.log($(this).attr('data-url'));
	url=$(this).attr('data-url')
	makeAjaxcall(url,null,$(this))
});
$( document ).ready(function() {

});

