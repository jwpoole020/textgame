package textGame;

public class arm extends Item{

	public arm() {
		super("arm");
	}
	
	@Override
	public void use() {
		if(game.getCurrentRoom().getName().equals("LOBBY")) {
			if(isUsed()) 
				game.print("There is nothing here to grab.");
			else {
				game.print("The zombie arm pulls the wood off the door with ease with its freaky zombie strength.");
				game.getCurrentRoom().removeItem("debris");
				World.rooms.get("EXIT").setLocked(false);
				game.getCurrentRoom().setRoomID("LOBBY_A");
				setUsed(true);
			}
		}
		
	}
}
