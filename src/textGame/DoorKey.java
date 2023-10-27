package textGame;

public class DoorKey extends Item {

	public DoorKey() {
		super ("doorkey");
	}
	
	public void use() {
		if(game.getCurrentRoom().getName().equals("lobby")) {
			System.out.println("You use the key on the door and it fits perfectly.  The kitchen is unlocked.");
			Room kitchen= game.getCurrentRoom().getExit("e");
			kitchen.setLocked(false);
		} else {
			System.out.println("The key doesn't fit any doors here."); 
		}
	}
}
