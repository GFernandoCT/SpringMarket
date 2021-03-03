$("body").on("click", "#respuestaBoton", abrirPanel);
$("body").on("click", "#respuestaBoton", subirRespuesta);

function abrirPanel(){
	$("#respuesta").hide();
};


function subirRespuesta() {
	
	alert("sadfs");


	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});
	/*)
		$.ajax({
		url: "/pregunta/eliminarPregunta/" + idPregunta,
		contentType: "application/json; charset=utf-8",
		data: { "idPregunta": idPregunta },
		type: "POST",

		success: function(preguntadto) {
			//if(response == "true"){
			alert("fasdfas");
			$(obj).closest("div.card").remove();

			/*}
			else{
				location.replace("/usuario/login");
			}
		},
		error: function(xhr, status, error) {
			alerta = "<div> No se ha podido eliminar la pregunta </div>";
			$('#algo').html(alerta);
		}

	});*/
};