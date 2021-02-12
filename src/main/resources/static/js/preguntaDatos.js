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
		if(response == "true"){
			
		var usuarioProducto;
	
		$.getJSON("/pregunta/buscarUno",function(result){
			alert(preguntaSubir);
		})
		
		pregunta = "<div class='card border-primary m-3'>" + 
			"<div class='card-body'>" +
				"<h4 class='card-title'> ¿<span th:text='${preguntas.textoPregunta}'>" + preguntaSubir + "?</span></h4>" +
				"<h6 class='card-subtitle mb-2 text-muted' th:text='${preguntas.usuarioPregunta}'>Card subtitle</h6> " +
				"<p class='card-text'>Aquí tiene que ir la respuesta de la pregunta.</p>" +
			"</div>" +
		"</div> "
		$('#preguntaAnadida').append(pregunta);
		}
		else{
			location.replace("/usuario/login");
		}
	},
	error: function(xhr,status,error){
		alerta= "<div> No se ha podido realizar la pregunta </div>";
		$('#algo').html(alerta);
	}
	});
}