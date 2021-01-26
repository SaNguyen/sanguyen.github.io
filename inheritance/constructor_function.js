(function(){
	'use strict';

		function VehiclePrototype(){
			this.speed = 0;
		}
		VehiclePrototype.prototype.applyBrake = function(num){
			this.speed -= num;
		};
		VehiclePrototype.prototype.speedup = function(num){
			this.speed += num;
		};


		var bicyclePrototype = new VehiclePrototype();

		var mountainBikePrototype = new VehiclePrototype();
		mountainBikePrototype.gear = 1;
		mountainBikePrototype.setGear = function(g){
			this.gear = g;
		};


		//------------test------------------------//
		let bicycle1 = Object.create(bicyclePrototype);

		console.log(bicycle1);
		bicycle1.speedup(50);
		console.log(bicycle1.speed);
		bicycle1.speedup(50);
		console.log(bicycle1.speed);


		let bicycle2 = Object.create(mountainBikePrototype);

		console.log(bicycle2);
		bicycle2.setGear(10);
		console.log(bicycle2.gear);
		console.log(bicycle2);
		bicycle2.speedup(100);
		console.log(bicycle2.speed);
		bicycle2.applyBrake(20);
		console.log(bicycle2.speed);



})();

