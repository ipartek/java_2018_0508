<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>

<div class="container">
	<h1 class="text-center">ARKANOID</h1>
	
	<canvas id="myCanvas" width="480" height="320"></canvas>
</div>

<script>
	// JavaScript code goes here
	var canvas = document.getElementById("myCanvas");
	var ctx = canvas.getContext("2d");
	
	//Ball positions
	var ballX = canvas.width/2;
	var ballY = canvas.height-30;
	
	//How much is going to move the ball in each interval
	var dx = 2;
	var dy = -2;
	
	//Ball radius
	var ballRadius = 10;
	
	//Paddle dimensions
	var paddleHeight = 10;
	var paddleWidth = 75;
	//Paddle initial position
	var paddleX = (canvas.width-paddleWidth)/2;
	
	//Left and Right keys initial value
	var rightPressed = false;
	var leftPressed = false;
	
	//Number of rows, columns, the bricks width and height, and their margin to the canvas
	var brickRowCount = 3;
	var brickColumnCount = 5;
	var brickWidth = 75;
	var brickHeight = 20;
	var brickPadding = 10;
	var brickOffsetTop = 30;
	var brickOffsetLeft = 30;
	
	//Score gained
	var score = 0;
	
	//
	var lives = 3;
	
	//Adds an event when a key is pressed and when its not anymore
	document.addEventListener("keydown", keyDownHandler, false);
	document.addEventListener("keyup", keyUpHandler, false);
	//Adds an event when detects that the mouse is moving
	document.addEventListener("mousemove", mouseMoveHandler, false);
	
	//Brick initialization
	var bricks = [];
	for(c=0; c<brickColumnCount; c++) {
	    bricks[c] = [];
	    //To detect if it has been collided or not and draw it or not
	    for(r=0; r<brickRowCount; r++) {
	        bricks[c][r] = { ballX: 0, ballY: 0, status: 1 };
	    }
	}
	
	//Ball draw function
	function drawBall() {
	    ctx.beginPath();
	    ctx.arc(ballX, ballY, ballRadius, 0, Math.PI*2);
	    ctx.fillStyle = "#0095DD";
	    ctx.fill();
	    ctx.closePath();
	}
	
	//Paddle draw function
	function drawPaddle() {
	    ctx.beginPath();
	    ctx.rect(paddleX, canvas.height-paddleHeight, paddleWidth, paddleHeight);
	    ctx.fillStyle = "#0095DD";
	    ctx.fill();
	    ctx.closePath();
	}
	
	//Brick draw function
	function drawBricks() {
    for(c=0; c<brickColumnCount; c++) {
        for(r=0; r<brickRowCount; r++) {
            if(bricks[c][r].status == 1) {
                var brickX = (c*(brickWidth+brickPadding))+brickOffsetLeft;
                var brickY = (r*(brickHeight+brickPadding))+brickOffsetTop;
                bricks[c][r].ballX = brickX;
                bricks[c][r].ballY = brickY;
                ctx.beginPath();
                ctx.rect(brickX, brickY, brickWidth, brickHeight);
                ctx.fillStyle = "#0095DD";
                ctx.fill();
                ctx.closePath();
	            }
	        }
	    }
	}
	
	//Draws in the canvas the actual score
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

	//Function called in each interval to draw in the canvas
	function draw() {
	    ctx.clearRect(0, 0, canvas.width, canvas.height);
	    
	    drawBricks();
	    drawBall();
	    drawPaddle();
	    drawScore();
	    drawLives();
	    collisionDetection();
	    
	    //When the ball position Y is smaller than its radius, changes direction
	    if(ballY + dy < ballRadius) {
	        dy = -dy;
	    //When the ball position Y is higher than the canvas height 
	    }else if(ballY + dy > canvas.height-ballRadius){
	    	//
	    	if(ballX > paddleX && ballX < paddleX + paddleWidth) {
	            dy = -dy;
	        }
	        else {
	        	lives--;
	        	if(!lives) {
	        	    alert("GAME OVER");
	        	    document.location.reload();
	        	}
	        	else {
	        	    ballX = canvas.width/2;
	        	    ballY = canvas.height-30;
	        	    dx = 2;
	        	    dy = -2;
	        	    paddleX = (canvas.width-paddleWidth)/2;
	        	}
	        }
	    }
	    
	    //If balls position is higher or smaller than the canvas width, it changes direction
	    if(ballX + dx > canvas.width-ballRadius || ballX + dx < ballRadius) {
	        dx = -dx;
	    }
	    
	    //Ball movement
	    ballX += dx;
	    ballY += dy;
	    
	    //When right key is pressed and the paddle position X is smaller than
	    //the canvas width - the paddle width it can continue moving right, if not it stops
	    if(rightPressed && paddleX < canvas.width-paddleWidth) {
	        paddleX += 7;
	    }
	    //When left key is pressed and the paddle position X is higher than 0
	    //It can continue moving left, if not it stops
	    else if(leftPressed && paddleX > 0) {
	        paddleX -= 7;
	    }
	}
	
	//When the left or right key is pressed, the pressed var changes to true
	function keyDownHandler(e) {
	    if(e.keyCode == 39) {
	        rightPressed = true;
	    }
	    else if(e.keyCode == 37) {
	        leftPressed = true;
	    }
	}

	//When the left or right key are up, the pressed var changes to false
	function keyUpHandler(e) {
	    if(e.keyCode == 39) {
	        rightPressed = false;
	    }
	    else if(e.keyCode == 37) {
	        leftPressed = false;
	    }
	}
	
	//
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
	                if(ballX > b.ballX && ballX < b.ballX+brickWidth && ballY > b.ballY && ballY < b.ballY+brickHeight) {
	                    dy = -dy;
	                    b.status = 0;
	                    score++;
	                    if(score == brickRowCount*brickColumnCount) {
	                        alert("YOU WIN, CONGRATS!");
	                        document.location.reload();
	                    }
	                }
	            }
	        }
	    }
	}
	
	//the function draw gets call in an interval of 10 in a loop
	setInterval(draw, 10);
	//draw();
	//requestAnimationFrame(draw);
	
</script>

<%@include file="includes/footer.jsp"%>