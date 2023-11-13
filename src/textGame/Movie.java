package textGame;

public class Movie extends Item{

	public Movie() {
		super("movie");
	}
	
	public void use() {
		if(game.getCurrentRoom().getName().equals("MAINTENCE")) {
			game.print("You put the movie reel in the project. An old movie starts playing on the screen.");
			game.removeItem(game.getItem("movie"));
			game.getCurrentRoom().getItem("projector").setUsed(true);
		}
	}
}
