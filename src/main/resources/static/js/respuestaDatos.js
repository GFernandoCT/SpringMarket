$("body").on("click", "#respuestaBoton", abrirPanel);
$("body").on("click", "#mostrarRespuestas", abrirRespuestas);
$("body").on("click", "#botonRespuestaSubir", subirRespuesta);

function abrirPanel(){
	$(this).closest("div").find("#respuestaCaja").removeClass("d-none");
};

function abrirRespuestas(){
	$(this).closest("div#contenido").find("#contenedorRespuestas").removeClass("d-none");
};

function subirRespuesta() {
	
	var obj = $(this);
	var respuestaSubir = $(obj).closest("div").find("#respuesta").val();
	var idPregunta = $(obj).closest("div").find("#botonRespuestaSubir").attr("value");

	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});
	
		$.ajax({
		url: "/pregunta/respuesta/" + respuestaSubir + "/" + idPregunta,
		contentType: "application/json; charset=utf-8",
		data: {"respuestaSubir":respuestaSubir, "idPregunta":idPregunta},
		type: "POST",

		success: function(respuestaDto) {

			if(respuestaDto.idRespuesta != null){
			
			var textoRespuesta = respuestaDto.textoRespuesta;
			var usuarioRespuesta = respuestaDto.usuarioRespuesta;
			var idRespuesta = respuestaDto.idRespuesta;
			
				respuesta =
					"<div class='card-body border border-primary px-5 p-3 my-3'>" +
						"<h4 class='card-title'> <span>" + textoRespuesta + "</span></h4>" +
						"<h6 class='card-subtitle mb-2 text-muted'>" + usuarioRespuesta + "</h6> " +
						"<a id='botonEliminar' value=" + idRespuesta + " type='button' class='btn btn-danger btn-sm borrar'>Borrar Respuesta</a>" +
					"</div>"
		$(obj).closest('#respuestaCaja').append(respuesta);
			}
			else{
				location.replace("/usuario/login");
			}
		},
		
		error: function(xhr, status, error) {
			alerta = "<div> No se ha podido eliminar la pregunta </div>";
			$('#algo').html(alerta);
		}

	});
};