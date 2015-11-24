import java.util.ArrayList;
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
	private static Player player3;
	
	private static PlayerDB pdb;
	
	public static void main(String[] args){
		//testSessionID();
		//testDisplaySessions();
		//testFindObject();
		//testPlayerRegistration();
		//testProgram();
		testPlayerDB();
		//function func = new function();
		//func.savePlayerDB();
		//func.loadPlayerDB();
		
	}
	
	public static void testPlayerDB(){
		agenda = new Agenda();
		function f = new function();
		DateManager dmgr = new DateManager();
		pdb = new PlayerDB(agenda); // agenda er argument pga. observer interface
		
		String dato = "27-11-2015";
		
		if (dmgr.isValid(dato)){
			session0 = agenda.planSession("Frederikshavn", dmgr.fromStringToDate(dato));
			session1 = agenda.planSession("Fredericia", dmgr.fromStringToDate(dato));
			session2 = agenda.planSession("Skive", dmgr.fromStringToDate(dato));
		}
		
		player0 = new Player("Hej", 21, "Skive");
		player1 = new Player("hejsa", 22, "Skodsborg");
		player2 = new Player("Hejsasa", 23, "Aalborg Chang");
		player3 = new Player("Olf Arne", 24, "Skodsborg");
		
		
		pdb.addPlayer(player0);
		player0.addNote(new Note(session0, player0));
		session0.addPlayer(player0);
		pdb.addPlayer(player1);
		player1.addNote(new Note(session0, player1));
		session0.addPlayer(player1);
		pdb.addPlayer(player2);
		player2.addNote(new Note(session0, player2));
		session0.addPlayer(player2);
		pdb.addPlayer(player3);
		player3.addNote(new Note(session0, player3));
		session0.addPlayer(player3);
		
		ArrayList<ScoutingSession> agendaList = agenda.getList();
		for (int i = 0; i < agendaList.size(); i++){
			System.out.println(agendaList.get(i));
			for(int j = 0; j < agendaList.get(i).getNumberOfPlayers(); j++){
				System.out.println(agendaList.get(i).getPlayer(j));
			}
		}
		
		// save both databases. agenda.getlist is a list of sessions, session0.getlist i a list of players
		f.saveAgenda(agenda.getList());
		f.savePlayerDB(session0.getList());
		

		
		// agenda.displaySessionOverview();
		
		String searchStringName = "";
		String searchStringClub = "skod";
		
		for(int i = 0; i < pdb.getSize(); i++){
			Player p = pdb.getPlayer(i);
			if (p.getName().toLowerCase().matches(".*" + searchStringName.toLowerCase() + ".*") &&
					p.getClub().toLowerCase().matches(".*" + searchStringClub.toLowerCase() + ".*")){
				System.out.println("Name search: " + p.getName() + ", " + p.getAge() + ", " + p.getClub());
			}
		}
		
		
		
	}
	
	public static void testProgram(){
		agenda = new Agenda();
		
		ScoutingSession session0 = agenda.planSession("Randers", new Date());
		ScoutingSession session1 = agenda.planSession("Odense", new Date());
		ScoutingSession session2 = agenda.planSession("Aalborg", new Date());
		
		Player player0 = new Player("Dan Joy", 20, "FC K�benhavn");
		Player player1 = new Player("Morten Fedolin", 30, "Vejle BK");
		Player player2 = new Player("S�ren Fuil", 25, "Horsens");
		
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
		
		Player player0 = new Player("Dan Joy", 20, "FC K�benhavn");
		
		System.out.println(player0.getName());
	}
	
	private static void testSessionID(){
		agenda = new Agenda();
		agenda.planSession("Randers", new Date());
		agenda.planSession("Odense", new Date());
		agenda.planSession("Aalborg", new Date());
		
		System.out.println(agenda.findSession("Session0").getPlace());
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
