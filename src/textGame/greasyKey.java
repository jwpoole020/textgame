package textGame;

public class greasyKey extends Item{

	public greasyKey() {
		super("greasykey");
	}
	
	
	@Override
	public void use() {
		if(game.getCurrentRoom().getName().equals("LOBBY")) {
			game.print("The greasy key fits the greasy lock on the greasy door to the greasy kitchen. Gross");
			World.rooms.get("KITCHEN").setLocked(false);
		} else {
			game.print("The key doesnt seem to fit in any doors here.");
		}
	}
}
