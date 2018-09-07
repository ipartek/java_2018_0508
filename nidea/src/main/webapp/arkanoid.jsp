<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

<main role="main" class="container">
    <canvas id="myCanvas" width="480" height="320"></canvas>

	<script>
	//Crea un lienzo en 2D
	var canvas = document.getElementById("myCanvas");
	var ctx = canvas.getContext("2d");
	
	//Variables de la bola
	var ballRadius = 10;
	var x = canvas.width/2;
	var y = canvas.height-30;
	var dx = 2;
	var dy = -2;
	
	//Variables de la barra
	var paddleHeight = 10;
	var paddleWidth = 75;
	var paddleX = (canvas.width-paddleWidth)/2;
	
	//Permitir que el usuario controle la paleta
	var rightPressed = false;
	var leftPressed = false;

	//Variable de los cuadros
	var brickRowCount = 5;
	var brickColumnCount = 3;
	var brickWidth = 75;
	var brickHeight = 20;
	var brickPadding = 10;
	var brickOffsetTop = 30;
	var brickOffsetLeft = 30;
	
	//Variables para Score y Lives
	var score = 0;
	var lives = 3;

	var bricks = [];
	for(c=0; c<brickColumnCount; c++) {
	    bricks[c] = [];
	    for(r=0; r<brickRowCount; r++) {
	        bricks[c][r] = { x: 0, y: 0, status: 1 };
	    }
	}
	
	//Permitir que el usuario controle la paleta con el teclado o el raton
	document.addEventListener("keydown", keyDownHandler, false);
	document.addEventListener("keyup", keyUpHandler, false);
	document.addEventListener("mousemove", mouseMoveHandler, false);
	
	//Permitir que el usuario controle la paleta con el teclado
	function keyDownHandler(e) {
	    if(e.keyCode == 39) {
	        rightPressed = true;
	    }
	    else if(e.keyCode == 37) {
	        leftPressed = true;
	    }
	}
	function keyUpHandler(e) {
	    if(e.keyCode == 39) {
	        rightPressed = false;
	    }
	    else if(e.keyCode == 37) {
	        leftPressed = false;
	    }
	}
	
	//Asociar el movimiento de la pala con el movimiento del ratón
	function mouseMoveHandler(e) {
	    var relativeX = e.clientX - canvas.offsetLeft;
	    if(relativeX > 0 && relativeX < canvas.width) {
	        paddleX = relativeX - paddleWidth/2;
	    }
	}
	
	//Una función para detectar colisiones
	function collisionDetection() {
		//Hacer que los ladrillos desaparezcan cuando reciben un golpe
	    for(c=0; c<brickColumnCount; c++) {
	        for(r=0; r<brickRowCount; r++) {
	            var b = bricks[c][r];
	            if(b.status == 1) {
	                if(x > b.x && x < b.x+brickWidth && y > b.y && y < b.y+brickHeight) {
	                    dy = -dy;
	                    b.status = 0;
	                    //cada vez que se rompe un ladrillo, añade la línea
	                    score++;
	                    //Mostrar un mensaje de victoria cuando se hayan destruido todos los ladrillos
	                    if(score == brickRowCount*brickColumnCount) {
	                        alert("YOU WIN, CONGRATS!");
	                        document.location.reload();
	                    }
	                }
	            }
	        }
	    }
	}
	
	// código para dibujar
	function drawBall() {
	    ctx.beginPath();
	    ctx.arc(x, y, ballRadius, 0, Math.PI*2);//Rebotando arriba y abajo
	    ctx.fillStyle = "#0095DD";
	    ctx.fill();
	    ctx.closePath();
	}
	
	//funcion que pinta la barra
	function drawPaddle() {
	    ctx.beginPath();
	    ctx.rect(paddleX, canvas.height-paddleHeight, paddleWidth, paddleHeight);
	    ctx.fillStyle = "#0095DD";
	    ctx.fill();
	    ctx.closePath();
	}
	
	//Recorrer todos los bloques de la matriz y dibujarlos en la pantalla
	function drawBricks() {
	    for(c=0; c<brickColumnCount; c++) {
	        for(r=0; r<brickRowCount; r++) {
	            if(bricks[c][r].status == 1) {
	                var brickX = (r*(brickWidth+brickPadding))+brickOffsetLeft;
	                var brickY = (c*(brickHeight+brickPadding))+brickOffsetTop;
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
	
	//Funcion para contar y pintar el Score
	function drawScore() {
	    ctx.font = "16px Arial";
	    ctx.fillStyle = "#0095DD";
	    ctx.fillText("Score: "+score, 8, 20);
	}
	
	//Funcion para contar y pintar el Lives
	function drawLives() {
	    ctx.font = "16px Arial";
	    ctx.fillStyle = "#0095DD";
	    ctx.fillText("Lives: "+lives, canvas.width-65, 20);
	}

	function draw() {
	    ctx.clearRect(0, 0, canvas.width, canvas.height);//Borrar el  lienzo antes de cada fotograma
	    drawBricks();
	    drawBall();
	    drawPaddle();
	    drawScore();
	    drawLives();
	    collisionDetection();
	    
	    //Rebotando en la izquierda y derecha
	    if(x + dx > canvas.width-ballRadius || x + dx < ballRadius) {
	        dx = -dx;
	    }
	    
	    //Rebotando arriba y abajo
	    if(y + dy < ballRadius) {
	        dy = -dy;
	    }
	    //Al alcanzar la pared inferior su pondrá el final del juego.
	    else if(y + dy > canvas.height-ballRadius) {
	    	
	    	//Hacer que la pala golpee la bola
	        if(x > paddleX && x < paddleX + paddleWidth) {
	            dy = -dy;
	        }
	        else {
	        	
	            lives--;
	            
	            
	            if(!lives) {
	                alert("GAME OVER");
	                document.location.reload();
	            }
	            else {
	                x = canvas.width/2;
	                y = canvas.height-30;
	                dx = 3;
	                dy = -3;
	                paddleX = (canvas.width-paddleWidth)/2;
	            }
	        }
	    }
	    
	    if(rightPressed && paddleX < canvas.width-paddleWidth) {
	        paddleX += 7;
	    }
	    else if(leftPressed && paddleX > 0) {
	        paddleX -= 7;
	    }
	    
	    x += dx;
	    y += dy;
	    requestAnimationFrame(draw);
	}

	draw();
	</script>
	
	
	
	
</main> 
    	
<%@include file="includes/footer.jsp" %>