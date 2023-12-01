package textGame;

public class greasyKey extends Item{

	public greasyKey() {
		super("greasyKey");
	}
	
	
	@Override
	public void use() {
		if(game.getCurrentRoom().getName().equals("LOBBY")) {
			World.rooms.get("KITCHEN").setLocked(false);
		} else {
			game.print("The key doesnt seem to fit in any doors here.");
		}
	}
}
