package textGame;

public class LargeKey extends Item {

	public LargeKey() {
		super("largekey");
	}
	
	@Override
	public void take() {
		super.take();
		switch(game.getCurrentRoom().getRoomID()) {
		case "KITCHEN":
			game.getCurrentRoom().setRoomID("KITCHEN_A");
			break;
		case "KITCHEN_B":
			game.getCurrentRoom().setRoomID("KITCHEN_C");
			break;
		}
	}
	
	@Override
	public void use() {
		if(game.getCurrentRoom().getName().equals("BACKSTAGE")) {
			if(isUsed()) 
				game.print("The chest is already open"); 
			else {
				game.print("You use the key on the large chest. It opens up and you find an axe.");
				Item axe = new Axe();
				axe.setDesc("An axe with significant importance to your journey.");
				game.getCurrentRoom().addItem(axe);
				setUsed(true);

				}
		} else {
			game.print("The key serves no purpose here.");
		}
	}
}
