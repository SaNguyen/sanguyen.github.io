window.onload = pageLoad; 


function pageLoad(){
	let goElement = document.getElementById("go");
	goElement.onclick = goClick;
}


function goClick(){
	let timeId = setInterval(() => {
			let minElement = document.getElementById("min");
			let secElement = document.getElementById("sec");
			let totalSec = Number(minElement.value)*60 + Number(secElement.value) - 1;

			minElement.value = parseInt(totalSec/60) === 0 ? "" : parseInt(totalSec/60);
			secElement.value = totalSec%60;

			if(totalSec === 0){
				clearInterval(timeId);
				//document.body.className = "owesome";
				document.body.style.backgroundColor = "red";
			}	
		}, 1000); 
}



