<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

	<style>
    	* { padding: 0; margin: 0; }
    	canvas { background: #eee; display: block; margin: 0 auto; }
    </style>

	<main role="main" class="container">
    	<h1>Arkanoid</h1>
    	
    	<form>
    		<div class="form-group">
    			<input type="text" class="form-control-sm" id="nombre" aria-describedby="nombreHelp" placeholder="Escribe tu nombre">
    		</div>
    		<button type="submit" class="btn btn-primary" onclick="draw()">Comenzar</button>
    	</form>
    	
    	<canvas id="myCanvas" width="480" height="320"></canvas>

		<script>
			var canvas = document.getElementById("myCanvas");
			var ctx = canvas.getContext("2d");
			
			var x = canvas.width/2; //Punto de inicio en X
			var y = canvas.height-30; //Punto de inicio en Y
			var dx = 2; //Valor pequeño que cambia posicion en X
			var dy = -2; //Valor pequeño que cambia posicion en Y
			
			var ballRadius = 10; //Radio de la bola
			
			// Paleta para golpear con la bola
			var paddleHeight = 10;
			var paddleWidth = 75;
			var paddleX = (canvas.width-paddleWidth)/2;
			
			// Variables que nos dicen si se ha pulsado un boton
			var rightPressed = false;
			var leftPressed = false;
			
			// Variables con información de los ladrillos
			var brickRowCount = 3;
			var brickColumnCount = 5;
			var brickWidth = 75;
			var brickHeight = 20;
			var brickPadding = 10;
			var brickOffsetTop = 30;
			var brickOffsetLeft = 30;
			
			// Guardaremos nuestros ladrillos en una matriz bidimensional
			var bricks = [];
			for(c=0; c<brickColumnCount; c++) {
			    bricks[c] = [];
			    for(r=0; r<brickRowCount; r++) {
			        bricks[c][r] = { x: 0, y: 0, status: 1 };
			    }
			}
			
			// Calcular en qué posición "x" e "y" se tiene que dibujar cada ladrillo
			var brickX = (c*(brickWidth+brickPadding))+brickOffsetLeft;
			var brickY = (r*(brickHeight+brickPadding))+brickOffsetTop;
			
			// Variable contador de puntos
			var score = 0;
			
			// Variable contador de vidas
			var lives = 3;
			
			// Funcion que dibuja la bola
			function drawBall() {
			    ctx.beginPath();
			    ctx.arc(x, y, ballRadius, 0, Math.PI*2);
			    ctx.fillStyle = "#0095DD";
			    ctx.fill();
			    ctx.closePath();
			}
			
			// Funcion que dibuja la paleta
			function drawPaddle() {
			    ctx.beginPath();
			    ctx.rect(paddleX, canvas.height-paddleHeight, paddleWidth, paddleHeight);
			    ctx.fillStyle = "#0095DD";
			    ctx.fill();
			    ctx.closePath();
			}
			
			// Función para recorrer todos los bloques de la matriz y dibujarlos en la pantalla
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

			//Funcion que dibuja
			function draw() {
			    ctx.clearRect(0, 0, canvas.width, canvas.height);
			    collisionDetection();
			    drawPaddle();
			    drawScore();
			    drawLives();
			    drawBricks();
			    drawBall();
			    x += dx;
			    y += dy;
			    
			    // Comprobar si la bola colisiona con las paredes o tabla y comprueba el GameOver si golpea en la de abajo
			    if(x + dx > canvas.width-ballRadius || x + dx < ballRadius) {
			        dx = -dx;
			    }
			    if(y + dy < ballRadius) {
			        dy = -dy;
			    } else if(y + dy > canvas.height-ballRadius) {
			        if(x > paddleX && x < paddleX + paddleWidth) {
			            dy = -dy;
			        }
			        else {
			        	lives--;
			        	if(!lives) {
			        	    alert("GAME OVER");
			        	    document.location.reload();
			        	}
			        	else { // Resta una vida y coloca la paleta en posicion inicial
			        	    x = canvas.width/2;
			        	    y = canvas.height-30;
			        	    dx = 2;
			        	    dy = -2;
			        	    paddleX = (canvas.width-paddleWidth)/2;
			        	}
			        }
			    }
			    
			    // Comprobaremos si está pulsada la flecha izquierda o la derecha cada vez que se dibuje un fotograma
			    if(rightPressed && paddleX < canvas.width-paddleWidth) {
				    paddleX += 7;
				}
				else if(leftPressed && paddleX > 0) {
				    paddleX -= 7;
				}
			}
			
			// Escuchadores de eventos para escuchar las pulsaciones de las teclas
			document.addEventListener("keydown", keyDownHandler, false);
			document.addEventListener("keyup", keyUpHandler, false);
			// Escuchador de evento para escuchar el movimiento del raton
			document.addEventListener("mousemove", mouseMoveHandler, false);
			
			// Cambiar posicion de la pala segun la localizacion del puntero
			function mouseMoveHandler(e) {
			    var relativeX = e.clientX - canvas.offsetLeft;
			    if(relativeX > 0 && relativeX < canvas.width) {
			        paddleX = relativeX - paddleWidth/2;
			    }
			}
			
			// Funcion que comprueba si la tecla pulsada es la flecha izq o drcha
			function keyDownHandler(e) {
			    if(e.keyCode == 39) {
			        rightPressed = true;
			    }
			    else if(e.keyCode == 37) {
			        leftPressed = true;
			    }
			}

			// Funcion que comprueba si la tecla levantada es la flecha izq o drcha
			function keyUpHandler(e) {
			    if(e.keyCode == 39) {
			        rightPressed = false;
			    }
			    else if(e.keyCode == 37) {
			        leftPressed = false;
			    }
			}
			
			// Función que, con un bucle, recorrerá todos los ladrillos y comparará la 
			// posición de cada uno con la posición de la bola, cada vez que se dibuje 
			// un fotograma
			function collisionDetection() {
			    for(c=0; c<brickColumnCount; c++) {
			        for(r=0; r<brickRowCount; r++) {
			            var b = bricks[c][r];
			            if(b.status == 1) {
			                if(x > b.x && x < b.x+brickWidth && y > b.y && y < b.y+brickHeight) {
			                    dy = -dy;
			                    b.status = 0;
			                    score++; // Suma un punto si el ladrillo se rompe
			                    // Si se rompen todos los ladrillos se muestra mensaje de victoria
			                    if(score == brickRowCount*brickColumnCount) {
			                        alert("YOU WIN, CONGRATULATIONS!");
			                        document.location.reload();
			                    }
			                }
			            }
			        }
			    }
			}
			
			// Funcion que dibuja la puntuacion
			function drawScore() {
			    ctx.font = "16px Arial";
			    ctx.fillStyle = "#0095DD";
			    ctx.fillText("Score: "+score, 8, 20);
			}
			
			// Funcion que dibuja las vidas del jugador
			function drawLives() {
			    ctx.font = "16px Arial";
			    ctx.fillStyle = "#0095DD";
			    ctx.fillText("Lives: "+lives, canvas.width-65, 20);
			}
			
			setInterval(draw, 10);
			
		</script>
    </main>
<%@include file="includes/footer.jsp" %>