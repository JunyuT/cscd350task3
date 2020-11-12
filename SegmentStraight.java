package cs350f20task3;

public class SegmentStraight extends A_Segment{

	public SegmentStraight(String id, Coordinates tipCCoordinates, Coordinates tipDCoordinates) {
		super(id, tipCCoordinates, tipDCoordinates);
	}
	
	public Coordinates calculatePosition(boolean isFromTipCorD, double distance) {
		
		if(distance > this.getLength()) {
			Join joinobj;
			if(isFromTipCorD) {
				joinobj = this.getTipDJoin();
			}else {
				joinobj = this.getTipCJoin();
			}
			return joinobj.getTargetSegment().calculatePosition(joinobj.isTargetSegmentTipCorD(), distance-this.getLength());
		}else {

			double xa,xb,xc,ya,yb,yc;
			if(isFromTipCorD) {
				xa = this.getTipCCoordinates().getX();
				ya = this.getTipCCoordinates().getY();
				xb = this.getTipDCoordinates().getX();
				yb = this.getTipDCoordinates().getY();
				xc = xa - (distance * (xa - xb)/this.getLength());
				yc = ya - (distance * (ya - yb)/this.getLength());
				
			}else {
				xa = this.getTipDCoordinates().getX();
				ya = this.getTipDCoordinates().getY();
				xb = this.getTipCCoordinates().getX();
				yb = this.getTipCCoordinates().getY();
				xc = xa - (distance * (xa - xb)/this.getLength());
				yc = ya - (distance * (ya - yb)/this.getLength());
			}
			return new Coordinates(xc,yc);
		}
	}

	public double getLength() {
		Coordinates coorC = this.getTipCCoordinates();
		Coordinates coorD = this.getTipDCoordinates();
		return Math.sqrt((Math.pow((coorC.getX() - coorD.getX()), 2) + Math.pow((coorC.getY() - coorD.getY()), 2)));
	}
	
}
