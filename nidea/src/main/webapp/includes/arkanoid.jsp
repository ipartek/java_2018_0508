	<%@ include file="header.jsp" %>
	<%@ include file="navbar.jsp" %>

<style>
canvas {
 background: #eee;
 display: block;
 margin: 0 auto;

  }
</style>
<div class="row">
	<div class="col">
		<canvas id="myCanvas" width="300" height="200" style="aling:right"></canvas>
	</div>
	<div class="col">
		<canvas id="myCanvas2" width="300" height="200" style="aling:right"></canvas>
	</div>
</div>



<script>

var canvas = document.getElementById("myCanvas");
var ctx = canvas.getContext("2d");
var ballRadius = 10;
var x = canvas.width/2;
var y = canvas.height-30;
var dx = 2;
var dy = -2;
var paddleHeight = 10;
var paddleWidth = 75;
var paddleX = (canvas.width-paddleWidth)/2;
var rightPressed = false;
var leftPressed = false;

document.addEventListener("keydown", keyDownHandler, false);
document.addEventListener("keyup", keyUpHandler, false);


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


function draw() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    drawBall();
    drawPaddle();
    
    if(x + dx > canvas.width-ballRadius || x + dx < ballRadius) {
        dx = -dx;
    }
    if(y + dy > canvas.height-ballRadius || y + dy < ballRadius) {
        dy = -dy;
    }
    
    if(rightPressed && paddleX < canvas.width-paddleWidth) {
        paddleX += 7;
    }
    else if(leftPressed && paddleX > 0) {
        paddleX -= 7;
    }
    
    x += dx;
    y += dy;
}


setInterval(draw, 10);
</script>
<script>
var canvas2 = document.getElementById("myCanvas2");
var ctx2 = canvas2.getContext("2d");
var ballRadius2 = 10;
var x2 = canvas2.width/2;
var y2 = canvas2.height-30;
var dx2 = 2;
var dy2 = -2;
var paddleHeight2 = 10;
var paddleWidth2 = 75;
var paddleX2 = (canvas2.width-paddleWidth2)/2;
var rightPressed2 = false;
var leftPressed2 = false;
document.addEventListener("keydown", keyDownHandler2, false);
document.addEventListener("keyup", keyUpHandler2, false);


function keyDownHandler2(e) {
    if(e.keyCode == 39) {
        rightPressed2 = true;
    }
    else if(e.keyCode == 37) {
        leftPressed2 = true;
    }
}
function keyUpHandler2(e) {
    if(e.keyCode == 39) {
        rightPressed2 = false;
    }
    else if(e.keyCode == 37) {
        leftPressed2 = false;
    }
}

function drawBall2() {
    ctx2.beginPath();
    ctx2.arc(x2, y2, ballRadius2, 0, Math.PI*2);
    ctx2.fillStyle = "#0095DD";
    ctx2.fill();
    ctx2.closePath();
}

function drawPaddle2() {
    ctx2.beginPath();
    ctx2.rect(paddleX2, canvas2.height-paddleHeight2, paddleWidth2, paddleHeight2);
    ctx2.fillStyle = "#0095DD";
    ctx2.fill();
    ctx2.closePath();
}


function draw2() {
    ctx2.clearRect(0, 0, canvas2.width, canvas2.height);
    drawBall2();
    drawPaddle2();
    
    if(x2 + dx2 > canvas2.width-ballRadius2 || x2 + dx2 < ballRadius2) {
        dx2 = -dx2;
    }
    if(y2 + dy2 > canvas2.height-ballRadius2 || y2 + dy2 < ballRadius2) {
        dy = -dy;
    }
    
    if(rightPressed2 && paddleX2 < canvas2.width-paddleWidth2) {
        paddleX += 7;
    }
    else if(leftPressed2 && paddleX2 > 0) {
        paddleX2 -= 7;
    }
    
    x2 += dx2;
    y2 += dy2;
}


setInterval(draw, 10);
</script>

</body>
</html>