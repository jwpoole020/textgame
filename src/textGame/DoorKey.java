package textGame;

public class DoorKey extends Item {

	public DoorKey() {
		super ("oldkey");
	}
	
	@Override
	public void take() {
		super.take();
		switch(game.getCurrentRoom().getRoomID()) {
		case "THEATER":
			game.getCurrentRoom().setRoomID("THEATER_A");
			break;
		case "THEATER_B":
			game.getCurrentRoom().setRoomID("THEATER_C");
			break;
		case "THEATER_D":
			game.getCurrentRoom().setRoomID("THEATER_E");
		}
	}
	
	@Override
	public void use() {
		if(game.getCurrentRoom().getName().equals("HALLWAY")) {
			game.print("You use the key on the door and it fits perfectly.  The lounge is unlocked.");
			World.rooms.get("LOUNGE").setLocked(false);
		} else {
			game.print("The key doesn't fit any doors here."); 
		}
	}
}
