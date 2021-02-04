$("body").on("keyup", "#pregunta", anadirPregunta);

function anadirPregunta() {
	var preguntaSubir = $("#pregunta").val();
	
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});
	
	$.ajax({
		url: "/Producto/preguntas/" + preguntaSubir,
		contentType: "application/json; charset=utf-8",
		data: {"question": preguntaSubir},
		type: "POST",
		
	succes: function(response) {
		var preguntaRealizada;
			preguntaRealizada = "<div> " + response + "</div>";
		$('#algo').html(preguntaRealizada);
	},
	error: function(xhr,status,error){
		alerta= "<div> No se ha podido realizar la pregunta </div>";
		$('#algo').html(alerta);
	}
	});
}