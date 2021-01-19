window.onload = pageLoad;
let timerId;

function pageLoad(){

	let animationElement = document.getElementById('animation');

	animationElement.onchange = changeAnimation;

	let startElement = document.getElementById('start');
	startElement.onclick = setTimer;

	let stopElement = document.getElementById('stop');
	stopElement.onclick = clickStop;

	let sizeElement = document.getElementById('size');
	sizeElement.onchange = clickSize;

	let speedElement = document.getElementById('speed');
	speedElement.onchange = clickSpeed;

	animationElement.value = "Blank";
	document.getElementById("mytextarea").value = ANIMATIONS["Blank"];

	startElement.disabled = true;
	stopElement.disabled = true;
}

function clickStop(){
	clearInterval(timerId);
	document.getElementById('stop').disabled = true;
	document.getElementById('start').disabled = false;

	let animationElement = document.getElementById("animation");
	animationElement.disabled = false;

	var animation = animationElement.value;
	document.getElementById("mytextarea").value = ANIMATIONS[animation];
}

function changeAnimation(){
	let animationElement = document.getElementById("animation");
	let animation = animationElement.value;
	document.getElementById("mytextarea").value = ANIMATIONS[animation];

	if(animation !== "Blank"){
		document.getElementById("start").disabled = false;
		document.getElementById("stop").disabled = true;		
	}else{
		document.getElementById("start").disabled = true;
		document.getElementById("stop").disabled = true;			
	}
}

function setTimer(){
	document.getElementById("stop").disabled = false;	
	document.getElementById("start").disabled = true;
	document.getElementById("animation").disabled = true;
	

	let speed = (document.getElementById("speed").checked) ? 50: 250;

	let mytextareaElement = document.getElementById("mytextarea")
	let animationElement = document.getElementById("animation");
	let animation = animationElement.value;

	let arrayFrames = ANIMATIONS[animation].split("=====\n");

	let count = 0;
	let max = arrayFrames.length;


	timerId = setInterval(() => {
		mytextareaElement.value = arrayFrames[count++];

		if(count === (max)){
			count = 0;
		}
	}, speed);

}

function clickSize(){
	let sizeElement = document.getElementById('size');
	let size;

	switch (sizeElement.value) {
		case 'Tiny':
	    	size = "7pt";
	    	break;
		case 'Small':
	    	size = "10pt";
	    	break; 
		case 'Medium':
	    	size = "12pt";
	    	break; 	   
		case 'Large':
	    	size = "16pt";
	    	break; 	    	
		case 'Extra Large':
	    	size = "24pt";
	    	break; 		    	 	   	
		case 'XXL':
	    	size = "34pt";
	    	break; 	
	    default:
	    	size = "12pt";		    	
	}
	document.getElementById('mytextarea').style.fontSize = size;
}

function clickSpeed(){
	clearInterval(timerId);
	setTimer();
}