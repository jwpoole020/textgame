package textGame;

public class Bag extends Item{

	public Bag() {
		super("bag");
	}
	
	@Override
	public void take() {
		super.take();
		switch(game.getCurrentRoom().getRoomID()) {
		case "KITCHEN":
			game.getCurrentRoom().setRoomID("KITCHEN_B");
			break;
		case "KITCHEN_A":
			game.getCurrentRoom().setRoomID("KITCHEN_C");
			break;
		}
	}
	
	@Override
	public void use() {
		if(game.getCurrentRoom().getName().equals("THEATER")  && World.rooms.get("MAINTENSE").getItem("projector").isUsed()) {			
			game.print("You sit down with your bag of popcorn and watch the movie.  The popcorn is stale and the movie is an old zombie movie, but you still enjoy it.  "
					+ "When the movie is over you hear a click sound from behind the screen.");
			game.removeItem(game.getItem("bag"));
			World.rooms.get("backStage").setLocked(false);
		} else {
			game.print("This bag of popcorn looks delicous but you shouldn't eat it just yet.");
		}
	}
}
