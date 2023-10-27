package textGame;

public class Shower extends Item {
	
	public Shower() {
		super("shower");
	}
	
	public void use() {
		if(game.getCurrentRoom().getName().equals("kitchen")) {
			if(game.getItem("goo")!=null);{
				game.print("You turn on the shower and wash the goo off.");
				game.removeItem(game.getItem("goo"));
			}
			
		}
	}
}
