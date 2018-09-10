/*
var canvas = document.getElementById("myCanvas");
var ctx = canvas.getContext("2d");
var move_distance = 10;


var bar = {
		x:$("#myCanvas").width()/3,
		y:$("#myCanvas").height()-20,
		w:$("#myCanvas").width()/4,
		h:20,
		draw:function(){
			ctx.beginPath();
			ctx.rect(bar.x, bar.y, bar.w, bar.h); // x, y , width y height
			ctx.fillStyle = "#FF0000";
			ctx.fill();
			ctx.closePath();
		},
		move:function(e){
			console.log("eventos");
			console.log(e.which);
			switch(e.which) {
		        case 37: // left
		        	console.log("left");
		        	if(this.x > 0 ){      		
		        		this.x-=move_distance;	
		        		console.log(this.x);
		        	}
		        	break;
		        	
		        case 39: // right
		        	if(this.x < $("#myCanvas").width()){
		        		this.x+=move_distance;			        	
		        	}
		        	break;

	        default: return; // exit this handler for other keys
	    }
	    e.preventDefault(); // prevent the default action (scroll / move caret)
			
			
		}
}
	
$( document ).ready(function() {
    console.log( "ready!!" );
    
    $("#play").on("click",function(){
    	 initValues();
    });
    
});*/


var brick ={
		brickRowCount : 5,
		brickColumnCount : 3,
		brickWidth : 75,
		brickHeight : 20,
		brickPadding : 10,
		brickOffsetTop : 30,
		brickOffsetLeft : 30
		
};

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
/*
var brickRowCount = 5;
var brickColumnCount = 3;
var brickWidth = 75;
var brickHeight = 20;
var brickPadding = 10;
var brickOffsetTop = 30;
var brickOffsetLeft = 30;
*/
var score = 0;
var lives = 3;

var bricks = [];



function initValues(){
	
	loadEvents();
	loadBricks();
	draw();
}

 function loadEvents(){
	 document.addEventListener("keydown", keyDownHandler, false);
	 document.addEventListener("keyup", keyUpHandler, false);
	 document.addEventListener("mousemove", mouseMoveHandler, false);
	 
 }

 function loadBricks(){
	for(c=0; c<brick.brickColumnCount; c++) {
	    bricks[c] = [];
	    for(r=0; r<brick.brickRowCount; r++) {
	        bricks[c][r] = { x: 0, y: 0, status: 1 };
	    }
	}
}

var btnPlay = document.getElementById("btnPlay");
btnPlay.addEventListener("click", initValues, false);

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
    for(c=0; c<brick.brickColumnCount; c++) {
        for(r=0; r<brick.brickRowCount; r++) {
            var b = bricks[c][r];
            if(b.status == 1) {
                if(x > b.x && x < b.x+brick.brickWidth && y > b.y && y < b.y+brick.brickHeight) {
                    dy = -dy;
                    b.status = 0;
                    score++;
                    if(score == brick.brickRowCount*brick.brickColumnCount) {
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
    for(c=0; c<brick.brickColumnCount; c++) {
        for(r=0; r<brick.brickRowCount; r++) {
            if(bricks[c][r].status == 1) {
                var brickX = (r*(brick.brickWidth+brick.brickPadding))+brick.brickOffsetLeft;
                var brickY = (c*(brick.brickHeight+brick.brickPadding))+brick.brickOffsetTop;
                bricks[c][r].x = brickX;
                bricks[c][r].y = brickY;
                ctx.beginPath();
                ctx.rect(brickX, brickY, brick.brickWidth, brick.brickHeight);
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


