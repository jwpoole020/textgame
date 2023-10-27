package textGame;

public class LargeKey extends Item {

	public LargeKey() {
		super("largekey");
	}
	
	public void use() {
		if(game.getCurrentRoom().getName().equals("lobby")) {
			if(isUsed()) 
				System.out.println("The chest is already open"); 
			else {
				System.out.println("You use the key on the large chest. It opens up and you find a diamond.");
				Item diamond = new Item("diamond");
				diamond.setDesc("Sparkly.");
				game.getCurrentRoom().addItem(diamond);
				setUsed(true);
				}
		} else {
			System.out.println("The key serves no purpose here.");
		}
	}
}
