package textGame;

public class Wand extends Item {
	
	public Wand() {
		super("wand");
	}
 
	public void use() {
		if(game.getCurrentRoom().getName().equals("hallway") || game.getCurrentRoom().getName().equals("theatre")){
			System.out.println("You wave the wand around and the alley magically unlocks");
			Room alleyWay= game.getCurrentRoom().getExit("w");
			alleyWay.setLocked(false);
		} else {
			System.out.println("You wave the wand around.");
		}
	}
	
}
