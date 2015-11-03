import java.util.Date;
public class ScoutingSession {
	
	private boolean event;
	private boolean kamp;
	private String place;
	private Date dateTime;
	private boolean isFinished;
	private QualitativeData qualData;
	private QuantitativeData quanData;
	
	
	public ScoutingSession(Date d, boolean event, boolean kamp, String place){
		this.dateTime = d;
		this.event = event;
		this.kamp = kamp;
		this.place = place;
		this.isFinished = false;
		this.qualData = new QualitativeData();
		this.quanData = new QuantitativeData();
	}
	
	public ScoutingSession(){
		this(new Date(), true, false, "Dueodde");
	}
	
	public String getPlace(){
		return this.place;
	}
	
	public Date getDate(){
		return this.dateTime;
	}
	
	public boolean getState(){
		return this.isFinished;
	}
	
	public QualitativeData getQualData(){
		return this.qualData;
	}
	

}
