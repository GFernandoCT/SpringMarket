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
		url: "/pregunta/preguntas/" + preguntaSubir + "/" + idProducto,
		contentType: "application/json; charset=utf-8",
		data: {"preguntaSubir":preguntaSubir, "idProducto":idProducto},
		type: "POST",
		
	success: function(preguntadto) {
		if(preguntadto.idPregunta == null)
			location.replace("/usuario/login");
		else{
		var textoPregunta = preguntadto.textoPregunta;
		var usuarioPregunta = preguntadto.usuarioPregunta;
		var idPregunta = preguntadto.idPregunta;
		
		pregunta = "<div class='card border-primary m-3'>" + 
			"<div class='card-body'>" +
				"<h4 class='card-title'> <span>" + textoPregunta + "</span></h4>" +
				"<h6 class='card-subtitle mb-2 text-muted'>" + usuarioPregunta + "</h6> " +
				"<p class='card-text'>Aquí tiene que ir la respuesta de la pregunta.</p>" +
				"<a id='botonEliminar' value="+ idPregunta +" type='button' class='btn btn-danger btn-sm float-right borrar'>Borrar Pregunta</a>" +
				"<button class='btn btn-primary my-2 mr-1' id='respuestaBoton'>Añadir respuesta</button>" + 
				"<button class='btn btn-primary my-2' id='mostrarRespuestas'>Mostrar Respuestas</button>" +
				"<div class='d-none' id='respuestaCaja'>" +
					"<input type='text' class='form-control mr-1 w-50 bg-primary float-left' id='respuesta' " + 
						"placeholder='¿Tienes alguna pregunta sobre el vehiculo?'" +
						" name='respuestaSubir'> " +
				"<button class='btn btn-primary float-left' id='botonRespuestaSubir' value=" + idPregunta + ">Subir respuesta</button>" +	
				"<div id='respuestasPregunta' class='card-body'>" +
				"</div>" +
			"</div>" +
		"</div> "
		$('#preguntas').append(pregunta);
		}
	},
	error: function(xhr,status,error){
		alerta= "<div> No se ha podido realizar la pregunta </div>";
		$('#algo').html(alerta);
	}
	});
}