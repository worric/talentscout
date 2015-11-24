import java.util.Date;

public class testScout {
	
	private static ScoutingSession session0;
	private static ScoutingSession session1;
	private static ScoutingSession session2;
	private static Agenda agenda;
	private static Player player;
	private static Player player0;
	private static Player player1;
	private static Player player2;
	
	public static void main(String[] args){
		testSessionID();
		//testDisplaySessions();
		//testFindObject();
		//testPlayerRegistration();
		//testProgram();
	}
	
	public static void testProgram(){
		agenda = new Agenda();
		
		ScoutingSession session0 = agenda.planSession("Randers", new Date());
		ScoutingSession session1 = agenda.planSession("Odense", new Date());
		ScoutingSession session2 = agenda.planSession("Aalborg", new Date());
		
		Player player0 = new Player("Dan Joy", 20, "FC København");
		Player player1 = new Player("Morten Fedolin", 30, "Vejle BK");
		Player player2 = new Player("Søren Fuil", 25, "Horsens");
		
		session1.addPlayer(player0);
		session1.addPlayer(player1);
		
		Note report0 = session1.makeNote(player0);
		
		report0.setSpeedText("poor acceleration, but decent on a distance");
		report0.setSpeedScore(4);
		report0.setAttitudeText("Strong presence on field");
		report0.setAttitudeScore(5);
		report0.setTechniqueText("can use both feet though his passing lacks precision");
		report0.setTechniqueScore(3);
		report0.setGameSenseText("Has a very good understanding of the game. Sees the right opportunities");
		report0.setGameSenseScore(6);
		
		Note report1 = session1.makeNote(player0);
		
		report1.setAttitudeScore(2);
		report1.setGameSenseScore(2);
		report1.setSpeedScore(2);
		report1.setTechniqueScore(2);
		
		
		System.out.println(player0.displayAverageScore());
		
		agenda.cancelSession(session1);
		
		System.out.println(report0.getAttitudeText());
		System.out.println(report0.getSession());
		
	}
	
	private static void testPlayerRegistration(){
		agenda = new Agenda();
		
		ScoutingSession session0 = agenda.planSession("Randers", new Date());
		ScoutingSession session1 = agenda.planSession("Odense", new Date());
		ScoutingSession session2 = agenda.planSession("Aalborg", new Date());
		
		Player player0 = new Player("Dan Joy", 20, "FC København");
		
		System.out.println(player0.getName());
	}
	
	private static void testSessionID(){
		agenda = new Agenda();
		ScoutingSession session0 = agenda.planSession("Randers", new Date());
		ScoutingSession session1 = agenda.planSession("Odense", new Date());
		ScoutingSession session2 = agenda.planSession("Aalborg", new Date());
		
		System.out.println(session0.getSessionID());
		
		agenda.cancelSession(session0);
		
		agenda.getSession(10);
		
		agenda.displaySession(0);
		agenda.displaySessionOverview();
		
	}
	
	private static void testDisplaySessions(){
		agenda = new Agenda();
		agenda.planSession("Randers", new Date());
		agenda.displaySessionOverview();
	}
	
	private static void testFindObject(){
		agenda = new Agenda();
		session0 = new ScoutingSession("12", new Date(), "Session01");
		player0 = new Player("Samson", 25, "FCK");
		player1 = new Player("Sally", 24, "AAB");
		player2 = new Player("Frede", 27, "AAB");
		
		session0.addPlayer(player0);
		session0.addPlayer(player1);
		session0.addPlayer(player2);
		session0.displayPlayerOverview();
		session0.removePlayer(player0);
		session0.displayPlayerOverview();
	}

}
