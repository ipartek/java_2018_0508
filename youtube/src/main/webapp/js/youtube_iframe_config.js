function initialize(){

		    // Update the controls on load
		    updateTimerDisplay();
		    updateProgressBar();

		    // Clear any old interval.
		    clearInterval(time_update_interval);

		    // Start interval to update elapsed time display and
		    // the elapsed part of the progress bar every second.
		    time_update_interval = setInterval(function () {
		        updateTimerDisplay();
		        updateProgressBar();
		    }, 1000)

		}
		
		// This function is called by initialize()
		function updateTimerDisplay(){
		    // Update current time text display.
		    $('#current-time').text(formatTime( player.getCurrentTime() ));
		    $('#duration').text(formatTime( player.getDuration() ));
		}

		function formatTime(time){
		    time = Math.round(time);

		    var minutes = Math.floor(time / 60),
		    seconds = time - minutes * 60;

		    seconds = seconds < 10 ? '0' + seconds : seconds;

		    return minutes + ":" + seconds;
		}
		
		$('#progress-bar').on('mouseup touchend', function (e) {

		    // Calculate the new time for the video.
		    // new time in seconds = total duration in seconds * ( value of range input / 100 )
		    var newTime = player.getDuration() * (e.target.value / 100);

		    // Skip video to new time.
		    player.seekTo(newTime);

		});
		
		// This function is called by initialize()
		function updateProgressBar(){
		    // Update the value of our progress bar accordingly.
		    $('#progress-bar').val((player.getCurrentTime() / player.getDuration()) * 100);
		}
		
		
		$('#play').on('click', function () {
		    player.playVideo();
		});

		$('#pause').on('click', function () {
		    player.pauseVideo();
		});
		
		$('#mute-toggle').on('click', function() {
		    var mute_toggle = $(this);

		    if(player.isMuted()){
		        player.unMute();
		        mute_toggle.text('volume_up');
		    }
		    else{
		        player.mute();
		        mute_toggle.text('volume_off');
		    }
		});
		
		$('#volume-input').on('change', function () {
		    player.setVolume($(this).val());
		});
		
		$('#next').on('click', function () {
		    player.nextVideo()
		});

		$('#prev').on('click', function () {
		    player.previousVideo()
		});