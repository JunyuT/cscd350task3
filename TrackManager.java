package cs350f20task3;
import java.util.ArrayList;
import java.util.List;

public class TrackManager {
private List<A_Segment>segList = new ArrayList<A_Segment>();
	public TrackManager() {
	}
	
	public void addSegments(A_Segment... segments) {
		for(A_Segment seg : segments) {
			segList.add(seg);
		}
	}
	
	public void compile() throws RuntimeException{
		//1) for each segment, check if there are other segments with the same coordinates?
		//2) for each segment, are both C and D joined? otherwise, throw exception
		//3) if join exists, throw error?
		
		List<A_Segment>segCopy = segList;
		
		if(segCopy.size() < 2) {
			throw new RuntimeException("Need at least 2 segments!");
		}
		for(A_Segment seg: segCopy) {
			Coordinates cCor = seg.getTipCCoordinates();
			Coordinates dCor = seg.getTipDCoordinates();
			for(int i = 0; i < segCopy.size(); i++) {
				A_Segment nextSeg = segList.get(i);		
				if(seg == nextSeg){
					//nothing if same node
				}else if(nextSeg.getTipCCoordinates().isNear(cCor) && seg.getTipCJoin() == null && nextSeg.getTipCJoin() == null) {
					seg.joinTipC(new Join(nextSeg,true));
					nextSeg.joinTipC(new Join(seg, true));
				}else if(nextSeg.getTipCCoordinates().isNear(dCor) && seg.getTipDJoin() == null && nextSeg.getTipCJoin() == null) {
					nextSeg.joinTipC(new Join(seg,false));
					seg.joinTipD(new Join(nextSeg,true));
				}else if(nextSeg.getTipDCoordinates().isNear(cCor) && seg.getTipCJoin() == null && nextSeg.getTipDJoin() == null) {
					nextSeg.joinTipD(new Join(seg,true));
					seg.joinTipC(new Join(nextSeg,false));
				}else if(nextSeg.getTipDCoordinates().isNear(dCor) && seg.getTipDJoin() == null && nextSeg.getTipDJoin() == null) {
					nextSeg.joinTipD(new Join(seg,false));
					seg.joinTipD(new Join(nextSeg,false));
				}

			}
		}
		for(A_Segment seg: segCopy) {	//verification that all nodes have been joined on both C and D tips
			if(seg.getTipCJoin() == null || seg.getTipDJoin() == null) {
				throw new RuntimeException("Orphaned tip found!");
			}
		}
	}
	
	public List<A_Segment> getSegments(){
		return segList;
	}
}
