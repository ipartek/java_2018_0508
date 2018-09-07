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
    initValues();
    main();
   
    
});

$(document).keydown(function(e) {
	bar.move(e);
    
});

function main(){
	
	movement();
	draw();
	setInterval( main, 10 );
}

function movement(){
	
	console.log("movement");
	
}

function draw(){
	
	console.log("Draw");
	ctx.clearRect(0, 0, canvas.width, canvas.height);	
	bar.draw();
	createBall();
	createBrick();	
	
}

function initValues(){
	console.log( "init!!!!" );

	bar.draw();
	createBall();
	createBrick();	
	 
	
}


function createBall(){
	
	ctx.beginPath();
	ctx.arc(240, 160, 20, 0, Math.PI*2, false);
	ctx.fillStyle = "green";
	ctx.fill();
	ctx.closePath();
	
}


function createBrick(){
	
	ctx.beginPath();
	ctx.rect(160, 10, 100, 40);
	ctx.strokeStyle = "rgba(0, 0, 255, 0.5)";
	ctx.stroke();
	ctx.closePath();
	
}




