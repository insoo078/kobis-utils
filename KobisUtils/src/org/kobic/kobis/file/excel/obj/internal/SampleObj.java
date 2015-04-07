package org.kobic.kobis.file.excel.obj.internal;

public class SampleObj {
	private String sampleType;
	private String sampleDetail;
	private String sampleEtc;
	
	public SampleObj() {
		this.sampleDetail= "";
		this.sampleType = "";
		this.sampleEtc = "";
	}

	public String getSampleType() {
		return sampleType;
	}
	public void setSampleType(String sampleType) {
		this.sampleType = sampleType;
	}
	public String getSampleDetail() {
		return sampleDetail;
	}
	public void setSampleDetail(String sampleDetail) {
		this.sampleDetail = sampleDetail;
	}
	public String getSampleEtc() {
		return sampleEtc;
	}
	public void setSampleEtc(String sampleEtc) {
		this.sampleEtc = sampleEtc;
	}
}
