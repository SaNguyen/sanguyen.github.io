(function(){
	'use strict';

	class VehiclePrototype {
		constructor() {
			this.speed = 0;
		}
		applyBrake(num){
			this.speed -= num;
		}
		 speedup(num){
			this.speed += num;
		}
	}


	class BicyclePrototype extends VehiclePrototype {
	}

	class MountainBikePrototype extends VehiclePrototype {
		constructor() {
			super();
			this.gear = 1;
		}
		setGear(g){
			this.gear = g;
		};
	}	



	//------------test------------------------//
		let bicycle1 = new BicyclePrototype();

		console.log(bicycle1);
		bicycle1.speedup(50);
		console.log(bicycle1.speed);
		bicycle1.speedup(50);
		console.log(bicycle1.speed);


		let bicycle2 = new MountainBikePrototype();

		console.log(bicycle2);
		bicycle2.setGear(10);
		console.log(bicycle2.gear);
		console.log(bicycle2);
		bicycle2.speedup(100);
		console.log(bicycle2.speed);
		bicycle2.applyBrake(20);
		console.log(bicycle2.speed);

})();

