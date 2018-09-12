/*
	Rota las imagenes de la Home cada vez que hacemos click sobre una
*/
window.$j = window.$ = jQuery;
	$.browser.old_ie = $.browser.msie && $.browser.version < 8;
	var od = 'semantics';

	function describe(nd) {
		if (nd != od) {
			$j("#" + nd + "-icon").addClass("active");
			$j("#" + od + "-icon").removeClass("active");
			$j("#" + od + "-desc, #" + od + "-header").hide();
			if (!$j.browser.old_ie){
				$j("#" + nd + "-desc, #" + nd + "-header").fadeIn();
			}
			od = nd;
		}
	return false;
	}
	var rotationDelay = 4000;
	var rotationList = new Array();
	var rotationIndex = 0;
	var rotationIntervalId = null;

	function rotate() {
		++rotationIndex;
		rotationIndex %= rotationList.length;
		describe(rotationList[rotationIndex]);
	}

	function stopRotation() {
		if (rotationIntervalId != null) {
			clearInterval(rotationIntervalId);
			rotationIntervalId = null;
		}
	}



$j(document).ready(function() {

	

	$j('#the-classes a').click(function() {
			describe(this.id.replace('-icon', ''));
			stopRotation();
			return false;
	});

	$j('#the-classes a').each(function(){
		rotationList.push($j(this).attr("id").replace('-icon',''));
	});


	// rotationIntervalId = setInterval(rotate, rotationDelay);
	var imgs = $j('#the-current-class img').slice(1);
	$j('.class-description > div').slice(1).add(imgs).hide().css('opacity', '');
	// jQuery SmoothScroll | Version 10-04-30
	$('a[href*=#top], a[href*=#the-logo], a[href*=#the-technology], a[href*=#badge-builder], a[href*=#the-movement], a[href*=#downloads], a[href*=#swag], a[href*=#in-action], a[href*=#the-gallery]').click(function() {
	// duration in ms
	var duration=1000;
	// easing values: swing | linear
	var easing='swing';
	// get / set parameters
	var newHash=this.hash;
	var target=$(this.hash).offset().top;
	var oldLocation=window.location.href.replace(window.location.hash, '');
	var newLocation=this;
	// make sure it's the same location
	if(oldLocation+newHash==newLocation)
	{
		// set selector
		if($.browser.safari) var animationSelector='body:not(:animated)';
		else var animationSelector='html:not(:animated)';
		// animate to target and set the hash to the window.location after the animation
		$(animationSelector).animate({ scrollTop: target }, duration, easing, function() {
		// add new hash to the browser location
		window.location.href=newLocation;
		});
		// cancel default click action
		return false;
	}
	
});

	
});