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
function makeAjaxcall(url,data,element,callback){
	element.parent().prepend($("#ajaxSpinnerImage"));
	$.ajax({
		url:url,
		data:data,
		success: function (response) {
			console.log(response);
			callback(response)
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
	makeAjaxcall(url,null,$(this),function(response){
		var parsedResponse = $.parseJSON(response);
		$('#messagePlaceholder').parent().show()
		$('#messagePlaceholder').text(parsedResponse.message)
    })
});
$(document).on('change', ".seriousness", function () {
	console.log($(this).attr('data-url'));
	id=$(this).attr('data-id')
	console.log(id);
	url=$(this).attr('data-url')
	data="id="+id+"&seriousness="+$(this).val()
	console.log(data)
	makeAjaxcall(url,data,$(this),function(response){
		var parsedResponse = $.parseJSON(response);
		$('#messagePlaceholder').parent().show()
		$('#messagePlaceholder').text(parsedResponse.message)
    })
});
$(document).on('change', ".visibility", function () {
	console.log($(this).attr('data-url'));
	id=$(this).attr('data-id')
	console.log(id);
	url=$(this).attr('data-url')
	data="id="+id+"&visibility="+$(this).val()
	console.log(data)
	makeAjaxcall(url,data,$(this),function(response){
		var parsedResponse = $.parseJSON(response);
		$('#messagePlaceholder').parent().show()
		$('#messagePlaceholder').text(parsedResponse.message)
	})
});
$(document).on('click', ".topicDelete", function () {
	console.log($(this).attr('data-url'));
	url=$(this).attr('data-url')
	makeAjaxcall(url,null,$(this),function(){
        location.reload();
    })
});
$(document).on('click', ".markasread", function () {
	console.log($(this).attr('data-url'));
	url=$(this).attr('data-url')
	element=$(this)
	makeAjaxcall(url,null,$(this),function(response){
		var parsedResponse = $.parseJSON(response);
		element.text(parsedResponse.name)
		element.attr('data-url',parsedResponse.url)
	});
});
$(document).on('click', ".buttonSave", function () {
	console.log($(this).attr('data-url'));
	id=$(this).attr('data-id')
	console.log(id);
	url=$(this).attr('data-url')
	topic=$(this).parent().parent().find('input')
	data="id="+id+"&topic="+topic.val();
	console.log(data)
    $(this).find()
	makeAjaxcall(url,data,$(this),function(response){
        var parsedResponse = $.parseJSON(response)
        $('*[data-id="topic-' + id + '"]').each(function() {
            $(this).text(parsedResponse.topic)
        });
        $('div[data-id="editTopic' + id + '"]').each(function() {
            $( this).hide();
        });
	})
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
    console.log(url)
    makeAjaxcall(url,data,$(this),function(response){
        var parsedResponse = $.parseJSON(response)
        $('*[data-id="resource-' + id + '"]').each(function() {
            $(this).text(parsedResponse.description)
        });
        $('div[data-id="editResource' + id + '"]').each(function() {
            $( this).hide();
        });
    })

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
$(document).on('keypress','.search-main',function(e){
    if(e.which == 13) {
        description = $(this).val()
        url= "/search/show/resourceSearch='"+description+"'&topicSearch="+description
        window.location.replace(url)
    }
});

$( document ).ready(function() {

});

