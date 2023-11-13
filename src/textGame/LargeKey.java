package textGame;

public class LargeKey extends Item {

	public LargeKey() {
		super("largekey");
	}
	
	public void use() {
		if(game.getCurrentRoom().getName().equals("BACKSTAGE")) {
			if(isUsed()) 
				game.print("The chest is already open"); 
			else {
				game.print("You use the key on the large chest. It opens up and you find a diamond.");
				Item exitKey = new Item("exitKey");
				exitKey.setDesc("A key with significant importance to your journey.");
				game.getCurrentRoom().addItem(exitKey);
				setUsed(true);

				}
		} else {
			game.print("The key serves no purpose here.");
		}
	}
}
