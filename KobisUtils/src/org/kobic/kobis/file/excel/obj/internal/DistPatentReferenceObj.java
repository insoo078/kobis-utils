package org.kobic.kobis.file.excel.obj.internal;

public class DistPatentReferenceObj {
	private DistributionObj dist;
	private PatentObj patent;
	private ReferenceObj ref;
	
	public DistPatentReferenceObj() {
		this.dist = new DistributionObj();
		this.patent = new PatentObj();
		this.ref = new ReferenceObj();
	}

	public DistributionObj getDist() {
		return dist;
	}
	public void setDist(DistributionObj dist) {
		this.dist = dist;
	}
	public PatentObj getPatent() {
		return patent;
	}
	public void setPatent(PatentObj patent) {
		this.patent = patent;
	}
	public ReferenceObj getRef() {
		return ref;
	}
	public void setRef(ReferenceObj ref) {
		this.ref = ref;
	}
}
