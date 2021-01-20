(function(){
	"use strict";

	let decorationModule = (function(){
		function pageLoad(){
			let biggerElement = document.getElementById('bigger');
			//biggerElement.onclick = biggerButtonClick;

			biggerElement.onclick = setTimer;

			let boldElement = document.getElementById('bold');
			boldElement.onchange = blingCheckboxClick;
		}

		function setTimer(){
			let timer = setInterval(biggerButtonClick,500);
		}

		function biggerButtonClick(){
			let textElement = document.getElementById("content");
			//textElement.classList.add("bigger");
			let size = getComputedStyle(textElement).fontSize;
			size = parseInt(size) + 2 + "pt";

			textElement.style.fontSize = size;
		}

		function blingCheckboxClick(){
			let blingElement = document.getElementById('bold');
			let textElement = document.getElementById("content");
			if(blingElement.checked){
				textElement.classList.add("bling");
			}
			else{
				textElement.classList.remove("bling");
			}
		}
		return {
			pageLoad:pageLoad
		}
	})();

	window.onload = decorationModule.pageLoad;

})();
