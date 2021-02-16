//$("body").on("click", "#botonEliminar", eliminarPregunta);


/*function alerta(){
	alert("fhsjdak");
}*/

function eliminarPregunta() {
	
	//var idPregunta = $("#botonEliminar").val();
	var idPregunta = 1;
	//var idProducto = $("#idProducto").text();
	//var idPregunta = $(this).closest()

	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});

	$.ajax({
		url: "/pregunta/eliminarPregunta/" + idPregunta,
		contentType: "application/json; charset=utf-8",
		data: { "idPregunta": idPregunta },
		type: "POST",

		success: function(preguntadto) {
			//if(response == "true"){

			$(obj).closest("div").remove();

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

$(document).ready(function() {
	var boton = document.getElementsByClassName('borrar');
	for (var i = 0; i < boton.length; i++) {
		boton[i].addEventListener('click', eliminarPregunta, false);
	}
	/*});
	
	$(document).ready(function() {
	var boton = document.getElementsByClassName('borrar');
	for (var i = 0; i < boton.length; i++) {
		boton[i].addEventListener('click', alerta, false);
	}*/
	
});	