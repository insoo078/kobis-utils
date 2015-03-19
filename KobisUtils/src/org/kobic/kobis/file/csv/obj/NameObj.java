package org.kobic.kobis.file.csv.obj;
	
public class NameObj{
	String eng;
	String kor;
	
	public NameObj(String eng, String kor) {
		this.eng = eng;
		this.kor = kor;
	}
	
	public String getKor() {
		return this.kor;
	}
	
	public String getEng() {
		return this.eng;
	}
}