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
	//	location.reload();
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
$(document).on('click', ".buttonSave", function () {
	console.log($(this).attr('data-url'));
	id=$(this).attr('data-id')
	console.log(id);
	url=$(this).attr('data-url')
	topic=$('#topicEditBox'+id).val()
	data="id="+id+"&topic="+topic
	console.log(data)
	makeAjaxcall(url,data,$(this))
});
$(document).on('click', ".buttonCancel", function () {
	id=$(this).attr('data-id')
	$('div[data-id="editTopic' + id + '"]').each(function() {
		$( this).hide();
	});
});
$(document).on('click', ".topicEditIcon", function () {
	id=$(this).attr('data-id')
	$('div[data-id="editTopic' + id + '"]').each(function() {
		$( this).show();
	});
});
$(document).on('click', ".buttonSaveResource", function () {
	console.log($(this).attr('data-url'));
	id=$(this).attr('data-id')
	console.log(id);
	url=$(this).attr('data-url')
	description=$('#resourceEditBox'+id).val()
	data="id="+id+"&description="+description
	console.log(data)
	makeAjaxcall(url,data,$(this))
});
$(document).on('click', ".buttonCancelResource", function () {
	id=$(this).attr('data-id')
	$('div[data-id="editResource' + id + '"]').each(function() {
		$( this).hide();
	});
});
$(document).on('click', ".resourceEditIcon", function () {
	id=$(this).attr('data-id')
	$('div[data-id="editResource' + id + '"]').each(function() {
		$( this).show();
	});
});
$(document).on('click', ".topicInviteIcon", function () {
	id=$(this).attr('data-id')
	console.log(name)
	$('#sendInvitation').modal('show')
	$('#sendInvitation').find('#topicSelect').val(id)
});
$( document ).ready(function() {

});

