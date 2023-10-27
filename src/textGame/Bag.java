package textGame;

public class Bag extends Item{

	public Bag() {
		super("bag");
	}
	
	public void use() {
		if(game.getCurrentRoom().getName().equals("theatre")) {
			game.print("You sit down and eat your popcorn");
			game.removeItem(game.getItem("bag"));
		}
	}
}
