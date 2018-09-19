function visibleTextArea(){
	var textArea = document.getElementById("comentarios");
	console.log("*********************************************************")
	console.log(textArea.style.display);

	if(textArea.style.display =="none"){
		textArea.style.display = "block";
		console.log(textArea.style.display);
	}else if(textArea.style.display =="block"){
		textArea.style.display = "none";
		console.log(textArea.style.display);
	}
	
	
	
}