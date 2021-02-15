$("body").on("click", "#botonEliminar", eliminarPregunta);


function eliminarPregunta() {
	var idPregunta = $("#botonEliminar").val();
	//var idProducto = $("#idProducto").text();
	
	
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
		if(response == "true"){
			
		var textoPregunta = preguntadto.textoPregunta;
		var usuarioPregunta = preguntadto.usuarioPregunta;
	
		$.getJSON("/pregunta/buscarUno",function(result){
			alert("hola");
		})
		
		pregunta = "<div class='card border-primary m-3'>" + 
			"<div class='card-body'>" +
				"<h4 class='card-title'> <span>" + textoPregunta + "</span></h4>" +
				"<h6 class='card-subtitle mb-2 text-muted'>" + usuarioPregunta + "</h6> " +
				"<p class='card-text'>Aquí tiene que ir la respuesta de la pregunta.</p>" +
			"</div>" +
		"</div> "
		$('#preguntas').append(pregunta);
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
		