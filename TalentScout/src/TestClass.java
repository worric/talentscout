
public class TestClass {

	public static void main(String[] args) {
		Player p = new Player("hakon","tom",new ScoutingSession());
		
		p.setNote("og n jadjsf klæjasdbfj\n asdh jhai ehviuhv akl joisadfk\n IALF WOEIH FAVKJDHASDKFH KJ VHAOIAOIH KJH AISDF HASDHF IUAKJSDH IAKJSDHVAIUSKJDHOADSLGHOASIDFJ9Uoi sdahf aogh hasdkj fhkjvchasudh asdhæoaie aoihfaofhaodshfawohds");
		p.addScoutingSession(new ScoutingSession());
		
		// System.out.println(p.getScoutingSession(0).getPlace());
		
		System.out.println(p.getNote());
		System.out.println(p.getId());
		
		Player o = new Player();
		
		System.out.println(o.getId());

	}

}
