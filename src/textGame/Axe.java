package textGame;

public class Axe extends Item{

	public Axe() {
		super("axe");
	}
	
	@Override
	public void use() {
		if(game.getCurrentRoom().getName().equals("LOBBY")) {
			if(isUsed()) 
				game.print("There is nothing here that needs chopping.");
			else {
				game.print("You swing the axe and chop down the boards blocking your exit. You're free!");
				game.getCurrentRoom().removeItem("debris");
				World.rooms.get("EXIT").setLocked(false);
				game.getCurrentRoom().setRoomID("LOBBY_A");
				setUsed(true);
			}
		}
		
	}
}
