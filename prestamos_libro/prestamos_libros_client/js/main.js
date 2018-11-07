window.addEventListener("load",function(event) {
    console.log("Todos los recursos trerminaron de cargar, comenzamos a jugar");
    
    const ENDPOINT="http://localhost:8080/PrestamosAPI/";
    
    var ulEditoriales=document.getElementById('ulEditoriales');
    var mensaje=document.getElementById('mensaje');
    var editoriales=[];

    //vaciar lista .
    ulEditoriales.innerHTML="<li>Elemento<li>";


    //LLamada AJAX para obtener editoriales
    var request = new XMLHttpRequest();


    request.onreadystatechange = function() {
        if(request.readyState==4){
            if(request.status==200){
                console.log('response 200'+request.responseText);
                editoriales=JSON.parse(request.responseText);
                console.log('editoriales %o',editoriales);

                var lis="";
                editoriales.forEach(editorial => {
                    lis+="<li>"+ editorial.id +" - "+ editorial.nombre + "<li>";
                    
                    //console.log(editorial);
                });

                ulEditoriales.innerHTML=lis;
                mensaje.textContent='';
            }
        }
        
    };

    //pasamos el metodo y la url 
    request.open('Get', ENDPOINT+'editoriales');
    request.send();
});