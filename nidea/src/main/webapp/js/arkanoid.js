// JavaScript code goes here
		
		/*
		//Dibujar rectángulo rojo
		ctx.beginPath();
		ctx.rect(20, 40, 50, 50);
		ctx.fillStyle = "#FF0000";
		ctx.fill();
		ctx.closePath();
		
		//Círculo verde
		ctx.beginPath();
		ctx.arc(240, 160, 20, 0, Math.PI*2, false);
		ctx.fillStyle = "green";
		ctx.fill();
		ctx.closePath();
		
		//Redtángulo stroke == border
		ctx.beginPath();
		ctx.rect(160, 10, 100, 40);
		ctx.strokeStyle = "rgba(0, 0, 255, 0.5)";
		ctx.stroke();
		ctx.closePath();
		*/

	/*	DECLARAMOS LAS VARIABLES
	 ***********************************************
	 */
		
		//Variables iniciales de todo canvas
		var canvas = document.getElementById("myCanvas");
		var ctx = canvas.getContext("2d");
		
		//Variables de la pelota
		var ballRadius = 10;
		var x = canvas.width/2;
		var y = canvas.height-30;
		var dx = 2;
		var dy = -2;
		
		//Variables del rectángulo que controla el jugador
		var paddleHeight = 10;
		var paddleWidth = 75;
		var paddleX = (canvas.width-paddleWidth)/2;
		
		//Variables para controlar las teclas pulsadas (izqda. y drcha.)
		var rightPressed = false;
		var leftPressed = false;
		
		//Variables para construir los ladrillos que se deben destruir
		var brickRowCount = 3;
		var brickColumnCount = 5;
		var brickWidth = 75;
		var brickHeight = 20;
		var brickPadding = 10;
		var brickOffsetTop = 30;
		var brickOffsetLeft = 30;
		
		//Variable para controlar la puntuación
		var score = 0;
		
		//Variable para controlar las vidas del jugador
		var lives = 3;
		
		var bricks = [];
		for(c=0; c<brickColumnCount; c++) {
		    bricks[c] = [];
		    for(r=0; r<brickRowCount; r++) {
		    	bricks[c][r] = { x: 0, y: 0, status: 1 };
		    }
		}
		
	/*	REGISTRAR ESCUCHADORES DE EVENTOS
	 **********************************************
	 */
		
		//Esperar a que se cargue todo el DOM == $(document).ready() --> Eso en jQuery
		//También podríamos haberlo hecho desde el HTML con <body onload="miFuncion()">
		window.addEventListener("load", function(event) {
		
			registerEventListener();
		
		});
		
		
	/*	FUNCIONES
	**********************************************
	*/
		
		function registerEventListener(){
			
			//Registrar evento para comenzar partida
			var btnPlay = document.getElementById('btn-play');
			btnPlay.addEventListener("click", draw, false);
			
			//Event listeners asociados a las teclas pulsadas (izqda. y drcha.)
			document.addEventListener("keydown", keyDownHandler, false);
			document.addEventListener("keyup", keyUpHandler, false);
			document.addEventListener("mousemove", mouseMoveHandler, false);
			
		}
		
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
		
		function mouseMoveHandler(e) {
		    var relativeX = e.clientX - canvas.offsetLeft;
		    if(relativeX > 0 && relativeX < canvas.width) {
		        paddleX = relativeX - paddleWidth/2;
		    }
		}

		function collisionDetection() {
		    for(c=0; c<brickColumnCount; c++) {
		        for(r=0; r<brickRowCount; r++) {
		            var b = bricks[c][r];
		            if(b.status == 1) {
		                if(x > b.x && x < b.x+brickWidth && y > b.y && y < b.y+brickHeight) {
		                    dy = -dy;
		                    b.status = 0;
		                    score++;
		                    if(score == brickRowCount*brickColumnCount) {
		                        alert("YOU WIN, CONGRATULATIONS!");
		                        document.location.reload();
		                    }
		                }
		            }
		        }
		    }
		}

		function drawBall() {
		    ctx.beginPath();
		    ctx.arc(x, y, ballRadius, 0, Math.PI*2);
		    ctx.fillStyle = "#0095DD";
		    ctx.fill();
		    ctx.closePath();
		}
		
		function drawPaddle() {
		    ctx.beginPath();
		    ctx.rect(paddleX, canvas.height-paddleHeight, paddleWidth, paddleHeight);
		    ctx.fillStyle = "#0095DD";
		    ctx.fill();
		    ctx.closePath();
		}
		
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
		
		function drawScore() {
		    ctx.font = "16px Arial";
		    ctx.fillStyle = "#0095DD";
		    ctx.fillText("Score: "+score, 8, 20);
		}
		
		function drawLives() {
		    ctx.font = "16px Arial";
		    ctx.fillStyle = "#0095DD";
		    ctx.fillText("Lives: "+lives, canvas.width-65, 20);
		}

		function draw() {
		    ctx.clearRect(0, 0, canvas.width, canvas.height);
		    drawBricks();
		    drawBall();
		    drawPaddle();
		    drawScore();
		    drawLives();
		    collisionDetection();
		    
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
		        	else {
		        	    x = canvas.width/2;
		        	    y = canvas.height-30;
		        	    dx = 2;
		        	    dy = -2;
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

	/*	COMIENZO DEL JUEGO
	 ***********************************
	 */
		
		//draw();	