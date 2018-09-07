
	var canvas = document.getElementById("myCanvas");
	var ctx = canvas.getContext("2d");
	
	// VARIABLES PARA CONSTRUIR EL MURO DE LADRILLOS
	//	-------------------
	var brickRowCount = 3;
	var brickColumnCount = 5;
	var brickWidth = 75;
	var brickHeight = 20;
	var brickPadding = 10;
	var brickOffsetTop = 30;
	var brickOffsetLeft = 30;
	
	// INICIALIZAR ARRAY BIDIMENSIONAL PARA LOS LADRILLOS
	//	-------------------
	var bricks = [];
	for(c=0; c<brickColumnCount; c++) {
	    bricks[c] = [];
	    for(r=0; r<brickRowCount; r++) {
	        bricks[c][r] = { x: 0, y: 0 };
	    }
	}
	
	
	// VARIABLES DE LA PELOTA 
	//	-------------------
	var ballRadius = 10;
	var x = canvas.width/2;
	var y = canvas.height-30;
	var dx = 2;
	var dy = -2;
	
	// VARIABLES DE LA PALA
	//	-------------------
	var paddleHeight = 10;
	var paddleWidth = 75;
	var paddleX = (canvas.width-paddleWidth)/2;
	
	// TECLA PULSADA
	//	-------------------
	var rightPressed = false;
	var leftPressed = false;
	
	// EVENT-LISTENERS
	//	-------------------
	document.addEventListener("keydown", keyDownHandler, false);
	document.addEventListener("keyup", keyUpHandler, false);
	
	//	FUNCIONES TECLADO
	//	-------------------
	function keyDownHandler(e) {	// TECLA-PULSADA	
	    if(e.keyCode == 39) {
	        rightPressed = true;
	    }
	    else if(e.keyCode == 37) {
	        leftPressed = true;
	    }
	}

	function keyUpHandler(e) {		// TECLA-LEVANTADA
	    if(e.keyCode == 39) {
	        rightPressed = false;
	    }
	    else if(e.keyCode == 37) {
	        leftPressed = false;
	    }
	}
	
	// 	FUNCIONES DIBUJANTES
	//	-------------------
	function drawBricks() {
	    for(c=0; c<brickColumnCount; c++) {
	        for(r=0; r<brickRowCount; r++) {
	            if(bricks[c][r].status == 1) {
	                var brickX = (c*(brickWidth+brickPadding))+brickOffsetLeft;
	                var brickY = (r*(brickHeight+brickPadding))+brickOffsetTop;
	                bricks[c][r].x = brickX;
	                bricks[c][r].y = brickY;
	                ctx.beginPath();
	                ctx.rect(brickX, brickY, brickWidth, brickHeight);
	                ctx.fillStyle = "#0095DD";
	                ctx.fill();
	                ctx.closePath();
	            }
	        }
	    }
	}

	function drawBall() {	// 	Dibujar PELOTA
	    ctx.beginPath();
	    ctx.arc(x, y, ballRadius, 0, Math.PI*2);
	    ctx.fillStyle = "#0095DD";
	    ctx.fill();
	    ctx.closePath();
	}
	
	function drawPaddle() {	// Dibujar PALA
	    ctx.beginPath();
	    ctx.rect(paddleX, canvas.height-paddleHeight, paddleWidth, paddleHeight);
	    ctx.fillStyle = "#0095DD";
	    ctx.fill();
	    ctx.closePath();
	}

	function draw() {	// Dibujar CAMPO 
		
	    ctx.clearRect(0, 0, canvas.width, canvas.height); // Borramos la pantalla anterior
	    
	    drawBricks();	// Dibujamos el MURO DE LADRILLOS
	    drawBall();		// Dibujamos la PELOTA
	    drawPaddle();	// Dibujamos la PALA
	    
	    collisionDetection(); // Comprobar colisión después de mover la PALA
	    
	    if(x + dx > canvas.width-ballRadius || x + dx < ballRadius) { // Mover pelota en eje X
	        dx = -dx;
	    }
	    if(y + dy < ballRadius) {
	        dy = -dy;
	    }
	    else if(y + dy > canvas.height-ballRadius) { // Mover pelota en eje Y
	    	
	        if(x > paddleX && x < paddleX + paddleWidth) { // Colisión PALA - PELOTA
	            dy = -dy;
	        } else {					// La pelota ha rebotado en la pared inferior
	            alert("GAME OVER");	
	            document.location.reload();
	        }
	    }
	    
	    if(rightPressed && paddleX < canvas.width-paddleWidth) { // Tecla derecha pulsada
	        paddleX += 7;
	    }	
	    else if(leftPressed && paddleX > 0) {	// Tecla izquierda pulsada
	        paddleX -= 7;
	    }
	    
	    x += dx;	// Mover la pelota eje X
	    y += dy;	// Mover la pelota eje Y
	}
	
	setInterval(draw, 10);	// Actualizar CAMPO cada 10seg
	
	
	function collisionDetection() {
	    for(c=0; c<brickColumnCount; c++) {
	        for(r=0; r<brickRowCount; r++) {
	            var b = bricks[c][r];
	            if(b.status == 1) {
	                if(x > b.x && x < b.x+brickWidth && y > b.y && y < b.y+brickHeight) {
	                    dy = -dy;
	                    b.status = 0;
	                }
	            }
	        }
	    }
	}
	
