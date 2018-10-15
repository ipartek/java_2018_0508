var state = 'stop';
var chckRepeat;
var chckRandom;

function buttonPlayPress() { // PLAY - PAUSE BUTTON
	
	var lblPlay = document.getElementById('label_play');

	// console.log("button play pressed, play was " + state);

	if (state == 'stop' || state == 'pause') { // Play video

		player.playVideo();
		state = 'play';

		lblPlay.classList.remove("fa-play");
		lblPlay.classList.add("fa-pause");

		

	} else if (state == 'play') { // Pause video

		player.pauseVideo();
		state = 'pause';

		lblPlay.classList.remove("fa-pause");
		lblPlay.classList.add("fa-play");

	}
}

function buttonMutePress() {
	
	var lblMute = document.getElementById('label_mute');

	// console.log("mute pressed");

	if (player.isMuted()) {	// Have to set mute

		// console.log("muting player");
		player.unMute();
		lblMute.classList.remove("fa-volume-off");
		lblMute.classList.add("fa-volume-up");

	} else {	// Have to quit mute

		// console.log("unmuting player");
		player.mute();
		lblMute.classList.remove("fa-volume-up");
		lblMute.classList.add("fa-volume-off");

	}
}

// FULL SCREEN
function buttonFullScreenPress() {
	
	var btnFullS = document.getElementById('button_fullScreen');
	var lblFullS = document.getElementById('label_fullScreen');
	
	console.log("Solicitando Full Screen")

	$("#video-placeholder").attr('width', $(window).width());
	$("#video-placeholder").attr('height', $(window).height());
}

// TOGLLE BUTTONS
function checkLightsChanged() { // LIGHTS
	
	var lblLights = document.getElementById('lblLights');

	var btns = document.getElementsByTagName('button');
	var btnNext = document.getElementById('button_next'); 
	var btnPrev = document.getElementById('button_prev'); 
	
	var progressBar = document.getElementById('progress-bar');
	
	if (document.getElementById('chckLights').checked == true) {	// Switch off the light

		console.info("Lights Off");
		
		lblLights.title = 'Encender Luces';
		
		document.body.style.backgroundColor = '#202020';
		document.body.style.color = '#FFF';
		
		progressBar.style.backgroundColor = '#202020';
		progressBar.style.color = '#FFF';

		for (i = 0; i < btns.length; i++) {
			btns[i].classList.remove("btn-light");
			btns[i].classList.add("btn-dark");
		}
		
		btnNext.classList.remove("btn-light");
		btnNext.classList.add("btn-dark");
		
		btnPrev.classList.remove("btn-light");
		btnPrev.classList.add("btn-dark");
		

	} else { // Switch on the light

		console.info("Lights On");
		
		lblLights.title = 'Apagar Luces';
		
		document.body.style.backgroundColor = '#FFF';
		document.body.style.color = '#000';
		
		progressBar.style.backgroundColor = '#FFF';
		progressBar.style.color = '#000';	
		
		for (i = 0; i < btns.length; i++) {
			btns[i].classList.remove("btn-dark");
			btns[i].classList.add("btn-light");
		}
		
		btnNext.classList.remove("btn-dark");
		btnNext.classList.add("btn-light");
		
		btnPrev.classList.remove("btn-dark");
		btnPrev.classList.add("btn-light");
	}
}

function checkRepeatChanged() { // REPEAT VIDEO
	
	var lblRepeat = document.getElementById('lblRepeat');

	if (document.getElementById('chckRepeat').checked == true) {

		console.info("Repeat Checked");
		lblRepeat.title=  'No Repetir';

	} else {

		console.info("Repeat Not checked");
		lblRepeat.title=  'Repetir';
		
	}
}

function checkRandomChanged() { // RANDOM VIDEO
	
	var lblRandom = document.getElementById('lblRandom');
	var chckRandom = document.getElementById('chckRandom');

	if (chckRandom.checked == true) {

		console.info("Random Checked");
		lblRandom.title = 'Reproducir Ordenado';

	} else {

		console.info("Random Not checked");	
		lblRandom.title = 'Reproducir Aleatorio';

	}
	
	setCookie("cRandom", chckRandom.checked, 0);
	console.log("Cookie cRandom = " + chckRandom.checked)
	
}

function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}
