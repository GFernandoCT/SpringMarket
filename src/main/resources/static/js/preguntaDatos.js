$("body").on("click", "#botonPregunta", anadirPregunta);

function anadirPregunta() {
	var preguntaSubir = $("#pregunta").val();
	var idProducto = $("#idProducto").text();
	
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});
	
	$.ajax({
		url: "/Producto/preguntas/" + preguntaSubir + "/" + idProducto,
		contentType: "application/json; charset=utf-8",
		data: {"preguntaSubir":preguntaSubir, "idProducto":idProducto},
		type: "POST",
		
	success: function(response) {
		response = "<p>" + response +  "</p>"; 
		$('#algo').html(response);
	},
	error: function(xhr,status,error){
		alerta= "<div> No se ha podido realizar la pregunta </div>";
		$('#algo').html(alerta);
	}
	});
}