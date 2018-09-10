//@see -> https://developer.mozilla.org/es/docs/Games/Workflows/Famoso_juego_2D_usando_JavaScript_puro
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
		<canvas id="myCanvas" width="500" height="400" style="aling:left"></canvas>
	</div>
	<div class="col">
		<canvas id="myCanvas2" width="500" height="400" style="aling:right">xd</canvas>
	</div>
</div>

<div>
	<a href="../index.jsp">Inicio</a>
</div>



<script>
//guardamos la referencia al objejo camvas por id
var canvas = document.getElementById("myCanvas");
//guardamos el contexto grafico a usar
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
var brickRowCount = 3;
var brickColumnCount = 5;
var brickWidth = 75;
var brickHeight = 20;
var brickPadding = 10;
var brickOffsetTop = 30;
var brickOffsetLeft = 30;
var score = 0;
var lives = 3;

var bricks = [];
for(c=0; c<brickColumnCount; c++) {
    bricks[c] = [];
    for(r=0; r<brickRowCount; r++) {
        bricks[c][r] = { x: 0, y: 0, status: 1 };
    }
}

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
                        alert("YOU WIN, CONGRATS!");
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
    }
    else if(y + dy > canvas.height-ballRadius) {
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

<script>
//guardamos la referencia al objejo camvas por id
var canvas_ = document.getElementById("myCanvas2");
//guardamos el contexto grafico a usar
var ctx_ = canvas_.getContext("2d");
var ballRadius_ = 10;
var x_ = canvas_.width/2;
var y_ = canvas_.height-30;
var dx_ = 2;
var dy_ = -2;
var paddleHeight_ = 10;
var paddleWidth_ = 75;
var paddleX_ = (canvas_.width-paddleWidth_)/2;
var rightPressed_ = false;
var leftPressed_ = false;
var brickRowCount_ = 3;
var brickColumnCount_ = 5;
var brickWidth_ = 75;
var brickHeight_ = 20;
var brickPadding_ = 10;
var brickOffsetTop_ = 30;
var brickOffsetLeft_ = 30;
var score_ = 0;
var lives_ = 3;

var bricks_ = [];
for(c=0; c<brickColumnCount_; c++) {
    bricks_[c] = [];
    for(r=0; r<brickRowCount_; r++) {
        bricks_[c][r] = { x: 0, y: 0, status: 1 };
    }
}


document.addEventListener("mousemove", mouseMoveHandler, false);


function mouseMoveHandler_(e) {
    var relativeX = e.clientX - canvas_.offsetLeft;
    if(relativeX > 0 && relativeX < canvas_.width) {
        paddleX_ = relativeX - paddleWidth_/2;
    }
}
function collisionDetection_() {
    for(c=0; c<brickColumnCount_; c++) {
        for(r=0; r<brickRowCount_; r++) {
            var b = bricks_[c][r];
            if(b.status == 1) {
                if(x > b.x && x < b.x+brickWidth_ && y > b.y && y < b.y+brickHeight_) {
                    dy_ = -dy_;
                    b.status = 0;
                    score++;
                    if(score == brickRowCount_*brickColumnCount_) {
                        alert("YOU WIN, CONGRATS!");
                        document.location.reload();
                    }
                }
            }
        }
    }
}

function drawBall_() {
    ctx.beginPath();
    ctx.arc(x_, y_, ballRadius_, 0, Math.PI*2);
    ctx.fillStyle = "#0095DD";
    ctx.fill();
    ctx.closePath();
}
function drawPaddle_() {
    ctx.beginPath();
    ctx.rect(paddleX_, canvas_.height-paddleHeight, paddleWidth_, paddleHeight_);
    ctx.fillStyle = "#0095DD";
    ctx.fill();
    ctx.closePath();
}
function drawBricks_() {
    for(c=0; c<brickColumnCount_; c++) {
        for(r=0; r<brickRowCount_; r++) {
            if(bricks_[c][r].status == 1) {
                var brickX_ = (r*(brickWidth_+brickPadding_))+brickOffsetLeft;
                var brickY_ = (c*(brickHeigh_t+brickPadding_))+brickOffsetTop;
                bricks_[c][r].x = brickX_;
                bricks_[c][r].y = brickY_;
                ctx.beginPath();
                ctx.rect(brickX_, brickY_, brickWidth_, brickHeight_);
                ctx.fillStyle = "#0095DD";
                ctx.fill();
                ctx.closePath();
            }
        }
    }
}
function drawScore_() {
    ctx.font = "16px Arial";
    ctx.fillStyle = "#0095DD";
    ctx.fillText("Score: "+score, 8, 20);
}
function drawLives_() {
    ctx.font = "16px Arial";
    ctx.fillStyle = "#0095DD";
    ctx.fillText("Lives: "+lives_, canvas_.width-65, 20);
}

function draw_() {
    ctx.clearRect(0, 0, canvas_.width, canvas_.height);
    drawBricks_();
    drawBall_();
    drawPaddle_();
    drawScore_();
    drawLives_();
    collisionDetection_();
    
    if(x_ + dx_ > canvas_.width-ballRadius_ || x_ + dx_ < ballRadius_) {
        dx_ = -dx_;
    }
    if(y_ + dy_ < ballRadius_) {
        dy_ = -dy_;
    }
    else if(y_ + dy_ > canvas_.height-ballRadius_) {
        if(x_ > paddleX_ && x_ < paddleX_ + paddleWidth_) {
            dy_ = -dy_;
        }
        else {
            lives_--;
            if(!lives_) {
                alert("GAME OVER");
                document.location.reload();
            }
            else {
                x_ = canvas_.width_/2;
                y_ = canvas_.height-30;
                dx_ = 3;
                dy_ = -3;
                paddleX_ = (canvas_.width-paddleWidth_)/2;
            }
        }
    }
    
    x += dx;
    y += dy;
    requestAnimationFrame(draw);
}

draw();
</script>
<!-- <script>

var canvas = document.getElementById("myCanvas");
var ctx = canvas.getContext("2d");
var x = canvas.width/2;
var y = canvas.height-30;
//valor con el que se actualziara x
var dx = 2;
//valor con el que se actualziara y
var dy = -2;
//valor del radio del circulo usado
var ballRadius = 10;

//Dibujamos la bola en las cordenadas x,y
function drawBall() {
    ctx.beginPath();
    /* ctx.arc(x, y, 10, 0, Math.PI*2); */
    ctx.arc(x, y, ballRadius, 0, Math.PI*2);//cordenadas x,y valor del radio del circulo
    ctx.fillStyle = "#0095DD";
    ctx.fill();
    ctx.closePath();
}

//limpiamos la imagen mas vieja para crear el efecto de movimiento y se le suma 2 tanto a y como a x
function draw() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    drawBall();
    if(x + dx > canvas.width-ballRadius || x + dx < ballRadius) {
        dx = -dx;
    }
    if(y + dy > canvas.width-ballRadius || y + dy < ballRadius) {
        dy = -dy;
    }
    x += dx;
    y += dy;
}

setInterval(draw, 10); -->
</script>
<!--

//-->
</script>



</body>
</html>