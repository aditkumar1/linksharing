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
function makeAjaxcall(url,element){
	element.prepend($("#ajaxSpinnerImage"));
	$.ajax({
		url:url,
		success: function (data) {
			console.log(data);
		}
	});
}
$(document)
	.ajaxStart(function(){
		$("#ajaxSpinnerImage").show();
	})
	.ajaxStop(function(){
		$("#ajaxSpinnerImage").hide();
		location.reload();
	});
$(document).on('click', ".subscription", function () {
	console.log($(this).attr('data-url'));
	url=$(this).attr('data-url')
	makeAjaxcall(url,$(this))
});
$( document ).ready(function() {

});

