package textGame;

public class Bottle extends Item{

	public Bottle() {
		super ("bottle");
	}
	
	public void take() {
		super.take();
		switch(game.getCurrentRoom().getRoomID()) {
		case "LOBBY":
			game.getCurrentRoom().setRoomID("LOBBY_A");
			break;
		case "LOBBY_B":
			game.getCurrentRoom().setRoomID("LOBBY_C");
			break;
		}
	}
	
	public void use() {
		if(isUsed()) {
			game.print("An empty bottle that used to be full of soda.");
		} else {
			game.print("You chug the bottle of room temperature soda. You feel no effect besides your thirst being quenched.");
			setUsed(true);
			
		}
	}
}
