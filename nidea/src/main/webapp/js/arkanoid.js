	var canvas = document.getElementById("myCanvas");
	var ctx = canvas.getContext("2d");
	var ballRadius = 10;
	var x = canvas.width / 2;
	var y = canvas.height - 30;
	var dx = 2;
	var dy = -2;
	var paddleHeight = 10;
	var paddleWidth = 75;
	var paddleX = (canvas.width - paddleWidth) / 2;
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
	var max_score = 0;
	var lives = 3;
	var colorBall = aleatorio();
	var colorPaddle = aleatorio();

	var bricks = [];
	var colors = [];
	for (c = 0; c < brickColumnCount; c++) {
		bricks[c] = [];
		colors[c] = [];
		for (r = 0; r < brickRowCount; r++) {
			bricks[c][r] = {
				x: 0,
				y: 0,
				status: 1
			};
			colors[c][r] = aleatorio();
			max_score = max_score +(c+1)*(r+1);
		}
	}

	console.info(max_score);

	document.addEventListener("keydown", keyDownHandler, false);
	document.addEventListener("keyup", keyUpHandler, false);
	document.addEventListener("mousemove", mouseMoveHandler, false);

	function keyDownHandler(e) {
		if (e.keyCode == 39) {
			rightPressed = true;
		} else if (e.keyCode == 37) {
			leftPressed = true;
		}
	}

	function keyUpHandler(e) {
		if (e.keyCode == 39) {
			rightPressed = false;
		} else if (e.keyCode == 37) {
			leftPressed = false;
		}
	}

	function drawBall() {
		ctx.beginPath();
		ctx.arc(x, y, ballRadius, 0, Math.PI * 2);
		ctx.fillStyle = "rgba(" + colorBall + ", 0.5)";
		ctx.fill();
		ctx.closePath();
	}

	function drawPaddle() {
		ctx.beginPath();
		ctx.rect(paddleX, canvas.height - paddleHeight, paddleWidth, paddleHeight);
		ctx.fillStyle = "rgba(" + colorPaddle + ", 0.5)";
		ctx.fill();
		ctx.closePath();
	}

	function drawBricks() {
		for (c = 0; c < brickColumnCount; c++) {
			for (r = 0; r < brickRowCount; r++) {
				if (bricks[c][r].status == 1) {
					var brickX = (c * (brickWidth + brickPadding)) + brickOffsetLeft;
					var brickY = (r * (brickHeight + brickPadding)) + brickOffsetTop;
					bricks[c][r].x = brickX;
					bricks[c][r].y = brickY;
					ctx.beginPath();
					ctx.rect(brickX, brickY, brickWidth, brickHeight);
					ctx.fillStyle = "rgba(" + colors[c][r] + ", 0.5)";
					ctx.fill();
					ctx.closePath();
				}
			}
		}
	} // cierre funcion
	function collisionDetection() {
		for (c = 0; c < brickColumnCount; c++) {
			for (r = 0; r < brickRowCount; r++) {
				var b = bricks[c][r];
				if (b.status == 1) {
					if (x > b.x && x < b.x + brickWidth && y > b.y && y < b.y + brickHeight) {
						dy = -dy;
						b.status = 0;
						// score = score + (c+1)*(r+1);
						score++;
						// if (score == max_score) {
						if (score == brickRowCount * brickColumnCount) {
							alert("YOU WIN, CONGRATULATIONS!");
							document.location.reload();
						}
					}
				}
			}
		}
	}

	function drawScore() {
		ctx.font = "16px Arial";
		ctx.fillStyle = "#0095DD";
		ctx.fillText("Score: " + score, 8, 20);
	}

	function drawLives() {
		ctx.font = "16px Arial";
		ctx.fillStyle = "#0095DD";
		ctx.fillText("Lives: " + lives, canvas.width - 65, 20);
	}

	function mouseMoveHandler(e) {
		var relativeX = e.clientX - canvas.offsetLeft;
		if (relativeX > 0 && relativeX < canvas.width) {
			paddleX = relativeX - paddleWidth / 2;
		}
	}

	function aleatorio() {
		var red = Math.random() * (256 - 0) + 0;
		var green = Math.random() * (256 - 0) + 0;
		var blue = Math.random() * (256 - 0) + 0;

		return red + ',' + green + ',' + blue;
	}

	function draw() {
		ctx.clearRect(0, 0, canvas.width, canvas.height);
		drawBricks();
		drawBall();
		drawPaddle();
		drawScore();
		drawLives();
		collisionDetection();
		if (x + dx > canvas.width - ballRadius || x + dx < ballRadius) {
			dx = -dx;
		}
		if (y + dy < ballRadius) {
			dy = -dy;
		} else if (y + dy > canvas.height - ballRadius) {
			if (x > paddleX && x < paddleX + paddleWidth) {
				if (y = y - paddleHeight) {
					dy = -dy;
				}
			} else {
				lives--;
				if (!lives) {
					alert("GAME OVER");
					document.location.reload();
				} else {
					x = canvas.width / 2;
					y = canvas.height - 30;
					dx = 2;
					dy = -2;
					paddleX = (canvas.width - paddleWidth) / 2;
				}
			}
		}
		if (rightPressed && paddleX < canvas.width - paddleWidth) {

			paddleX += 7;
		} else if (leftPressed && paddleX > 0) {
			paddleX -= 7;

		}

		x = x + dx;
		y = y + dy;
	}

	setInterval(draw, 10);