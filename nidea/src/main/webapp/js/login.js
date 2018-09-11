function compruebaPassword (){
	var pass1 = document.getElementById('pass1');
	var pass2 = document.getElementById('pass2');
	console.log(pass1);
	console.log(pass2);
	console.log("><");
	if(pass1 == pass2){
		console.log("Los password son iguales");
		alert("Los password son iguales");
		continue;
	}else{
		console.log("Los passwrod no son iguales");
		alert("Los password no son iguales");
		document.getElementById('pass1').innerHTML="";
		document.getElementById('pass2').innerHTML="";
	}
}