package be.ugent.elis.recomp.util.logging;

import be.ugent.elis.recomp.mapping.utils.Cone;
import be.ugent.elis.recomp.util.GlobalConstants;

public class ConeFeasibilityStats extends AbstractMessage {
	static int numMessages = 0;
	
	static final int bins[] = new int[]{1,2,4,8,16,32,64,128,200,300};
	static int histFeasible[] = new int[bins.length];
	static int hist[] = new int[bins.length];
	static int numBDDs = 0;
	
	Cone cone;

	private int getBin(int i) {
		int j=0;
		for(int b : bins) {
			if(i<=b)
				return j;
			j++;
		}
		return bins.length-1;
	}

	public ConeFeasibilityStats(Cone cone) {
		super();
		this.cone = cone;
		
		if(cone.isLocalFunctionDefined()) {
			
			if(GlobalConstants.binizeStatsFlag) {
				int bin = getBin(cone.getLocalFunction().nodeCount());
				if(!cone.isUnmapped())
					histFeasible[bin]++;
				hist[bin]++;
			}
			numBDDs++;
		}
		numMessages++;
	}

	@Override
	void doLog() {
		
	}
	
	@SuppressWarnings("unused")
	static void finalLog() {
		if(numBDDs>0 && GlobalConstants.binizeStatsFlag) {
			for(int j = 0; j<bins.length; j++)
				System.out.println("Debug: Bin: "+bins[j]+" Feasibility: "+(histFeasible[j]/(float)hist[j])+" Feasible: "+histFeasible[j]+" Cones: "+hist[j]);
		}
	}
}