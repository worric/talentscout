/**
 * The purpose of the class is to represent the qualitative data that the talent scout enters
 * @author folmer
 *
 */
public class QualitativeData {
	
	private String spilintelligens;
	private String attitude;
	private String teknik;
	private String speed;
	
	public QualitativeData(){
		this.spilintelligens = "";
		this.attitude = "";
		this.teknik = "";
		this.speed = "";
	}
	
	public void setSpilintelligens(String s){
		this.spilintelligens = s;
	}
	
	public String getSpilintelligens(String s){
		return this.spilintelligens;
	}
	
	public void setAttitude(String s){
		this.attitude = s;
	}
	
	public String getAttitude(){
		return this.attitude;
	}
	
	public void setTeknik(String s){
		this.teknik = s;
	}
	
	public String getTeknik(){
		return this.teknik;
	}
	
	public void setSpeed(String s){
		this.speed = s;
	}
	
	public String getSpeed(){
		return this.speed;
	}

}
