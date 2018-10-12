function cambiarLogo(){
	var fecha = new Date();
	var hora = fecha.getHours();
	console.log(hora);
	var logo = document.getElementById("logo");
	if(hora>=21 || hora<9){
		logo.src = "images/logo_noche.png"; 
	}
	
}