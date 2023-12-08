package textGame;

public class arcadeMachine extends Item{

	public arcadeMachine() {
		super("arcadeMachine");
	}
	
	public void use() {
		if(game.getItem("quarter")!=null) {
			if(isUsed()) {
				game.print("You already played this game. You are in second place, with first place being set by someone called GGY.");
			}else {
				game.print("You stick you quarter in the machine and start to play an old top down shooter game. "
						+ "You make it pretty far but are just shy of first place, being beaten by someone called GGY. "
						+ "Some tickets dispense from the machine." );
				game.removeItem(game.getItem("quarter"));
				Item tickets = new Item("tickets");
				game.getCurrentRoom().addItem(tickets);
				setUsed(true);
			}
		}
	}
}
