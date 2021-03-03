$("body").on("click", "#respuestaBoton", abrirPanel);
$("body").on("click", "#botonRespuestaSubir", subirRespuesta);

function abrirPanel(){
	$("#respuestaCaja").removeClass("d-none");
};


function subirRespuesta() {
	
	var respuestaSubir = $("#respuesta").val();
	var obj = $(this);
	var idPregunta = $(this).closest("div").find("#botonRespuestaSubir").attr("value");

	alert(idPregunta);

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
			//if(response == "true"){
			alert("fasdfas");
			//}
			//else{
			//	location.replace("/usuario/login");
			//}
		},
		error: function(xhr, status, error) {
			alerta = "<div> No se ha podido eliminar la pregunta </div>";
			$('#algo').html(alerta);
		}

	});
};