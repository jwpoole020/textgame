package textGame;

public class Newspaper extends Item{

	public Newspaper() {
		super("newspaper");
	}
	
	@Override
	public void take() {
		super.take();
		game.getCurrentRoom().setRoomID("BATHROOM_A");
	}
	
	@Override
	public void use() {
		if(isUsed()) {
			game.print("A newpaper that was published in the 80's.");
		} else {
			setUsed(true);
			game.print("You open the newspaper and a greasy key slides out. You read the paper.  It seems to be published back in the 80's with none of the articles having any "
					+ "relavence to you. A greasy keys falls out.");
			Item greasyKey = new greasyKey();
			greasyKey.setDesc("A greasy key that smells like popcorn.");
			game.inventory.add(greasyKey);
		}
	}
}
