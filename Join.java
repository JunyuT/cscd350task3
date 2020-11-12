package cs350f20task3;
//done
public class Join {
	private A_Segment joinedTo;
	private Boolean cTip;	//true is C, false is D.
	
	public Join(A_Segment targetSegment, boolean isTargetSegmentTipCorD) {
		this.joinedTo = targetSegment;
		this.cTip = isTargetSegmentTipCorD;
		
	}

	public A_Segment getTargetSegment() {
		return this.joinedTo;
	}
	
	public boolean isTargetSegmentTipCorD() {
		return this.cTip;
	}
	
	
}
