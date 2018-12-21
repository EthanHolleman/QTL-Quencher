
public class QTL {
	private int startQTL;
	private int endQTL;
	private String chrNumber;
	private String QTLname;
	
	public QTL(int start, int end, String chrNumber) {
		
		this.chrNumber = chrNumber;
		this.endQTL = end;
		this.startQTL = start;
		this.QTLname = "";
			
	}
	
	
	public QTL(int start, int end, String chrNumber, String QTLname){
		
		this.chrNumber = chrNumber;
		this.endQTL = end;
		this.startQTL = start;
		this.QTLname = QTLname;
		
	}
	
	
	public int getStart() {
		return this.startQTL;
	}
	
	public int getEnd() {
		return this.endQTL;
	}
	
	public String getChrNumber() {
		return this.chrNumber;
	}
	
	public String getQTLName() {
		return this.QTLname;
	}
}
