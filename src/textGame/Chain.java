package textGame;

public class Chain extends Item{
	
	public Chain() {
		super("chain");
	}
	
	public void use() {
		if(game.getCurrentRoom().getName().equals("kitchen")) {
			game.print("You pull the chain and goo falls from the ceiling. You are covered in goo.");
			
			Item goo = new Item("goo");
			game.getCurrentRoom().addItem(goo);
			game.take("goo");
		} 
	}

}
