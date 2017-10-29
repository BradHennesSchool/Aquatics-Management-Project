package model;

public class Position {

		String name;
		Guard CurrentGuard;
		
		//
		//init
		//
		public Position(String name) {
			this.name = name;
		}
		
		//
		//set current guard
		//
		public void SetGuard(Guard guard) {
			CurrentGuard = guard;
		}
		
		//
		//get current guard
		//
		public Guard GetCurrentGuard() {
			return CurrentGuard;
		}
}
