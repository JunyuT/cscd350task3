package cs350f20task3;
//done
public abstract class A_Segment {
	private String id;
	private Coordinates cCor;
	private Coordinates dCor;
	private Join cJoin = null;
	private Join dJoin = null;
	
 public A_Segment(String id, Coordinates tipCCoordinates, Coordinates tipDCoordinates) {
	this.id = id;	//segment identifier
	this.cCor = tipCCoordinates;	//coordinates of c tip
	this.dCor = tipDCoordinates;	//coordinates of d tip
 }
 
 public abstract Coordinates calculatePosition(boolean isFromTipCorD, double distance);
 public abstract double getLength();
 
 public Coordinates getTipCCoordinates() {
	 return this.cCor;
 }
 
 
 public Coordinates getTipDCoordinates() {
	 return this.dCor;
 }
 
 public Join getTipCJoin() {
	 return this.cJoin;
 }
 
 public Join getTipDJoin() {
	 return this.dJoin;
 }
 
 public void joinTipC(Join join) {
	 if(this.getTipCJoin()!=null) {
		 throw new RuntimeException("No multiple joins!");
	 }
	 if(join !=null && join.getTargetSegment() !=null ) {
		 this.cJoin = join;
	 }
 }
 
 public void joinTipD(Join join) {
	 if(this.getTipDJoin()!=null) {
		 throw new RuntimeException("No multiple joins!");
	 }
	 if(join !=null && join.getTargetSegment() !=null ) {
		 this.dJoin = join;
	 }
 }
 
 public String getID() {
	 return this.id;
 }
}
