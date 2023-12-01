package textGame;

public class Projector extends Item{

	public Projector() {
		super("projector");
	}
	
	
	@Override
	public void use() {
		if(game.getCurrentRoom().getName().equals("MAINTENCE")) {
			if(game.getItem("movie")!=null) {
				if(isUsed()) {
					game.print("A movie is already playing.");
				}else {
					game.print("You put the movie reel in the project. An old movie starts playing on the screen.");
					game.removeItem(game.getItem("movie"));
					game.getCurrentRoom().setRoomID("MAINTENSE_A");
					setUsed(true);
				}
			}
		}
	}
	
}
