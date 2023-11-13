package textGame;

public class ExitKey extends Item{

	public ExitKey() {
		super("exitKey");
	}
	
	public void use() {
		if(game.getCurrentRoom().getName().equals("LOBBY")) {
			World.rooms.get("EXIT").setLocked(false);
			game.getCurrentRoom().setRoomID("LOBBY_A");
		} else {
			game.print("The key doesn't fit any doors here.");
		}
	}
}
