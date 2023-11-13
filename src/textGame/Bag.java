package textGame;

public class Bag extends Item{

	public Bag() {
		super("bag");
	}
	
	public void use() {
		if(game.getCurrentRoom().getName().equals("THEATER")  && World.rooms.get("MAINTENSE").getItem("projector").isUsed()) {			
			game.print("You sit down with your bag of popcorn and watch the movie.  The popcorn is stale and the movie is an old zombie movie, but you still enjoy it.  "
					+ "When the movie is over you hear a click sound from behind the screen.");
			game.removeItem(game.getItem("bag"));
			World.rooms.get("backStage").setLocked(false);
		}
	}
}
