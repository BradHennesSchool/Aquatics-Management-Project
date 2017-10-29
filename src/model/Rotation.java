package model;

public class Rotation {

		String name;
		int ageReq;
		
		Position[] Positions;
		
		public Rotation(String name, int ageReq, Position[] PositionList, Guard[] InitGuardList){
			this.name = name;
			this.ageReq = ageReq;
			this.Positions = new Position[PositionList.length];
			SetPositions(PositionList, InitGuardList);
		}
		
		private void SetPositions(Position[] PositionList, Guard[] InitGuardList) {
			for(int i = 0; i < PositionList.length; ++i){
				Positions[i] = PositionList[i];
				Positions[i].SetGuard(InitGuardList[i]);
			}
		}
		
		public Position[] Positions() {
			return Positions;
		}
}
