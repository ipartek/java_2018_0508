function initialize() {

	// Update the controls on load
	updateTimerDisplay();
	updateProgressBar();
	
	var time_update_interval;
	
	// Clear any old interval.
	clearInterval(time_update_interval);

	// Start interval to update elapsed time display and
	// the elapsed part of the progress bar every second.
	time_update_interval = setInterval(function() {
		updateTimerDisplay();
		updateProgressBar();
		nextVideo();
	}, 1000)

	buttonPlayPress();
	iframe = $('#video-placeholder');	// FOR THE FULL SCREEN
}

// This function is called by initialize()
function updateTimerDisplay() {
	// Update current time text display.
	$('#current-time').text(formatTime(player.getCurrentTime()));
	$('#duration').text(formatTime(player.getDuration()));
}

//This function is called by initialize()
function updateProgressBar(){
	// Update progress-bar text value
    $('#progress-bar').val((player.getCurrentTime() / player.getDuration()) * 100);
}

function formatTime(time) {
	time = Math.round(time);

	var minutes = Math.floor(time / 60), seconds = time - minutes * 60;

	seconds = seconds < 10 ? '0' + seconds : seconds;

	return minutes + ":" + (seconds-1);
}

function nextVideo() {
	
	if (player.getDuration() === player.getCurrentTime()) {	// Video finalizado
		
		if (document.getElementById('chckRepeat').checked == true) {
			
			player.seekTo(0);
			console.log("Reproducir misma canción");
		
		} else {
			
			document.getElementById('button_next').click();
			console.log("Reproducir siguiente");
		}	
	}
}


$('#progress-bar').on('mouseup touchend', function (e) {
	 
    //calculamos el nuevo tiempo del video.
    //nuevo tiempo en segundos = total de duracion en segundos * ( valor de range input / 100 )
    var newTime = player.getDuration() * (e.target.value / 100);
 
    //Avanzamos el video al nuevo tiempo.
    player.seekTo(newTime);
 
});



