(function(){
	'use strict';

		function createBicyclePrototype(){
			let obj = { speed : 0};
			obj.applyBrake = function(val){
				this.speed -= val; 
			}
			obj.speedup = function(val){
				this.speed += val; 
			}
			return obj;

			// return {
			// 	speed: 0,
			// 	applyBrake : function(decVal){
			// 		if (this.speed > 0) {
			// 			this.speed = this.speed - decVal;
			// 		}
			// 	},
			// 	speedup: function(incVal){
			// 		this.speed = this.speed+incVal;
			// 	}
		// }
		}
		function createMountainBikePrototype(prototype){
			let obj = Object.create(prototype);
			obj.gear = 1;
			obj.setGear = function(g){
				this.gear = g;
			}
			return obj;
		}


	function start(){
		let bicyclePrototype = createBicyclePrototype();
		let mountainBikePrototype = createMountainBikePrototype(bicyclePrototype);

		let bicycle1 = Object.create(bicyclePrototype);

		console.log(bicycle1);
		bicycle1.speedup(50);
		console.log(bicycle1.speed);

		let bicycle2 = Object.create(mountainBikePrototype);

		console.log(bicycle2);
		bicycle2.setGear(10);
		console.log(bicycle2.gear);
		console.log(bicycle2);
		bicycle2.speedup(100);
		console.log(bicycle2.speed);


	}

	start();

})();

