package textGame;

public class Newspaper extends Item{

	public Newspaper() {
		super("newspaper");
	}
	
	public void use() {
		if(isUsed()) {
			game.print("A newpaper that was published in the 80's.");
		} else {
			setUsed(true);
			game.print("You open the newspaper and a greasy key slides out. You read the paper.  It seems to be published back in the 80's with none of the articles having any "
					+ "relavence to you.");
			Item greasyKey = new greasyKey();
			greasyKey.setDesc("A greasy key that smells like popcorn.");
			game.getCurrentRoom().addItem(greasyKey);
		}
	}
}
