/**
 * 
 */

$("body").on("click", "#eliminarRespuesta", eliminarRespuesta);
$("body").on("click", "#cambiarRespuesta", abrirPanel);
$("body").on("click", "#botonRespuestaModificar", cambiarRespuesta);

function abrirPanel(){
	$(this).closest("div").find("#modificarRespuesta").removeClass("d-none");
};

	
	function cambiarRespuesta() {
	
	var obj = $(this);
	var textoCambiar = $(obj).closest("div").find("#respuestaModificar").val();
	var idRespuesta = $(obj).closest("div").find("#botonRespuestaModificar").attr("value");
	var textoRespuesta = $(this).closest("div#preguntasResueltas").find("#texto");
	
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});
	
		$.ajax({
		url: "/pregunta/modificar/" + textoCambiar + "/" + idRespuesta,
		contentType: "application/json; charset=utf-8",
		data: {"textoCambiar":textoCambiar, "idRespuesta":idRespuesta},
		type: "POST",

		success: function(respuestaDto) {

			textoRespuesta.text(respuestaDto.textoRespuesta);
			/*if(respuestaDto.idRespuesta != null){
			
			var textoRespuesta = respuestaDto.textoRespuesta;
			var usuarioRespuesta = respuestaDto.usuarioRespuesta;
			var idRespuesta = respuestaDto.idRespuesta;
			
				respuesta =
					"<div class='card-body border border-primary px-5 p-3 my-3'>" +
						"<h4 class='card-title'> <span>" + textoRespuesta + "</span></h4>" +
						"<h6 class='card-subtitle mb-2 text-muted'>" + usuarioRespuesta + "</h6> " +
						"<a id='eliminarRespuesta' value=" + idRespuesta + " type='button' class='btn btn-danger btn-sm borrar'>Borrar Respuesta</a>" +
					"</div>"
		
			}
			else{
				location.replace("/usuario/login");
			}*/
		},
		error: function(xhr, status, error) {
			alerta = "<div> No se ha podido eliminar la pregunta </div>";
			$('#algo').html(alerta);
		}

	});
}

function eliminarRespuesta() {
		
	var obj = $(this);
	var idRespuesta = $(this).closest("div").find("#eliminarRespuesta").attr("value");

	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});

	$.ajax({
		url: "/pregunta/eliminarRespuesta/" + idRespuesta,
		contentType: "application/json; charset=utf-8",
		data: { "idRespuesta": idRespuesta},
		type: "POST",

		success: function(preguntadto) {
			//if(response == "true"){

			$(obj).closest("div.card-body").remove();

			/*}
			else{
				location.replace("/usuario/login");
			}*/
		},
		error: function(xhr, status, error) {
			alerta = "<div> No se ha podido eliminar la pregunta </div>";
			$('#algo').html(alerta);
		}

	});

}