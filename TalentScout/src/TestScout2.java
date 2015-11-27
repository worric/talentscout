
public class TestScout2 {
	
	static Agenda a;
	
	static Search s;
	
	static PlayerDB pdb;
	
	static DateManager dmgr;
	
	static ScoutingSession session1;
	static ScoutingSession session2;
	static ScoutingSession session3;
	
	static Player player1;
	static Player player2;
	static Player player3;
	
	static Note note1;
	static Note note2;
	static Note note3;
	
	static String dato;

	/**
	 * Run either "initializeDB" together with "saveDB" - OR - "testRestoredDB" by itself
	 * @param args
	 */
	public static void main(String[] args) {
		// Run these 2 together
		//initializeDB();
		//saveDB();
		
		// or run this by itself
		testRestoredDB();

	}

	private static void testRestoredDB() {
		pdb = new PlayerDB();
		a = new Agenda(pdb);
		s = new Search(pdb);
		
		System.out.println("Test if equal...");
		System.out.println(pdb.getPlayerByIndex(0).getName()+" (index 0 in pdb) and "+a.getSessionByIndex(0).getPlayer(0).getName()+" (index 0 in session 0) are equal? "+pdb.getPlayerByIndex(0).equals(a.getSessionByIndex(0).getPlayer(0)));
		System.out.println(pdb.getPlayerByIndex(0).getName()+"'s object ID: "+pdb.getPlayerByIndex(0)+"\n"+
				a.getSessionByIndex(0).getPlayer(0).getName()+"'s object ID: "+a.getSessionByIndex(0).getPlayer(0));
		System.out.println("----------------");
		System.out.println("changing player "+pdb.getPlayerByIndex(0).getName()+"'s name to Frands (index 0 in pdb)...");
		pdb.getPlayerByIndex(0).setName("Frands");
		System.out.println("Is it changed for both objects?");
		System.out.println(pdb.getPlayerByIndex(0).getName()+" (index 0 in pdb)"+"\n"
				+a.getSessionByIndex(0).getPlayer(0).getName()+" (index 0 in session 0)");
		System.out.println("----------------");
		System.out.println("changing player "+a.getSessionByIndex(0).getPlayer(0).getName()+"'s name to Karl (index 0 in session 0)...");
		pdb.getPlayerByIndex(0).setName("Karl");
		System.out.println("Is it changed for both objects?");
		System.out.println(pdb.getPlayerByIndex(0).getName()+" (index 0 in pdb)"+"\n"
				+a.getSessionByIndex(0).getPlayer(0).getName()+" (index 0 in session 0)");
		
		System.out.println("----------------");
		for(int i = 0; i < a.getSize(); i++){
			System.out.println("--------------- 1st...");
			for(int j = 0; j < a.getSessionByIndex(i).getNumberOfPlayers(); j++){
				System.out.println("--------------- 2nd...");
				for(int k = 0; k < a.getSessionByIndex(i).getPlayer(j).getNumberOfNotes(); k++){
					System.out.println("--------------- 3rd...");
					a.getSessionByIndex(i).getPlayer(j).getNote(k).printNote();
				}
			}
			
		}		
	}

	private static void saveDB() {
		pdb.savePlayerDB();
		a.saveAgenda();	
	}

	private static void initializeDB() {
		pdb = new PlayerDB();
		a = new Agenda(pdb);
		s = new Search(pdb);
		// new UserInterface(s) skal indsættes her.
		dmgr = new DateManager();
			
		dato = "27-11-2015";
		
		// 3 sessions initialiseres hvis deres dato er valid
		if (dmgr.isValid(dato)){
			System.out.println("Adding all 3 sessions...");
			session1 = a.planSession("Fredericia", dmgr.fromStringToDate(dato));
			System.out.println(a.getSessionByIndex(0).getSessionID());
			session2 = a.planSession("Skive", dmgr.fromStringToDate(dato));
			System.out.println(a.getSessionByIndex(1).getSessionID());
			session3 = a.planSession("Elling", dmgr.fromStringToDate(dato));
			System.out.println(a.getSessionByIndex(2).getSessionID());
			
		}
		
		// Spillere initialiseres
		System.out.println("Adding players...");
		player1 = pdb.register("Kaj", 12, "Støvring FC");
		player2 = pdb.register("Haakon", 14, "FC Understed");
		player3 = pdb.register("Søren Jensen", 15, "Sæby IK");
		
		
		// Player 1 får note, bliver added til spillerdatabasen og bliver added til en session
		System.out.println("Adding player1 to session1...");
		session1.addPlayer(player1);
		System.out.println("And adding notes to player1...");
		note1 = player1.addNote(session1,"Løber hurtigt", 5,
				"En god taber", 5,
				"Langsom på bolden", 2,
				"Står rimelig godt på banen", 1);
		player1.addNote(session1,"Var noget langsom i dag", 2,
				"Opmuntrer sine kammerater", 5,
				"Kommer godt med frem", 4,
				"Får ofte modspillerne i offside", 1);
		player1.addNote(session2,"Han løb godt med", 4,
				"Var tydeligt sur på alt og alle", 2,
				"Gode driblinger", 4,
				"Stod altid klar til at løbe frem", 3);

		// Player 2 får note, bliver added til spillerdatabasen og bliver added til en session
		System.out.println("Adding player2 to session1...");
		session1.addPlayer(player2);
		System.out.println("And adding notes to player2...");
		note2 = player2.addNote(session1,"Løber langsomt", 1,
				"En virkelig god taber", 6,
				"Middel på bolden", 3,
				"Står rimelig godt på banen", 3);
		
		// Player 3 får note, bliver added til spillerdatabasen og bliver added til en session
		System.out.println("Adding player3 to playerdb and session1...");
		session1.addPlayer(player3);
		System.out.println("And adding notes to player3...");
		note3 = player3.addNote(session1,"Løber pisse stærkt", 6,
				"Mega skod", 0,
				"Ret dårlig", 1,
				"Faktisk elendig", 1);
		
		System.out.println("Test if equal...");
		System.out.println(pdb.getPlayerByIndex(0).getName()+" (index 0 in pdb) and "+a.getSessionByIndex(0).getPlayer(0).getName()+" (index 0 in session 0) are equal? "+pdb.getPlayerByIndex(0).equals(a.getSessionByIndex(0).getPlayer(0)));
		System.out.println(pdb.getPlayerByIndex(0).getName()+"'s object ID: "+pdb.getPlayerByIndex(0)+"\n"+
				a.getSessionByIndex(0).getPlayer(0).getName()+"'s object ID: "+a.getSessionByIndex(0).getPlayer(0));
		System.out.println("----------------");
		for(int i = 0; i < a.getSize(); i++){
			System.out.println("--------------- 1st...");
			for(int j = 0; j < a.getSessionByIndex(i).getNumberOfPlayers(); j++){
				System.out.println("--------------- 2nd...");
				for(int k = 0; k < a.getSessionByIndex(i).getPlayer(j).getNumberOfNotes(); k++){
					System.out.println("--------------- 3rd...");
					a.getSessionByIndex(i).getPlayer(j).getNote(k).printNote();
				}
			}
			
		}
	}
}