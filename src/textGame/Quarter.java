package textGame;

public class Quarter extends Item{

	public Quarter() {
		super("quarter");
	}
	@Override
	public void take() {
		super.take();
		game.getCurrentRoom().setRoomID("LOUNGE_A");
	}
	
	@Override
	public void use() {
		if(game.getCurrentRoom().getName().equals("ARCADE")) {
			game.print("You stick you quarter in the machine and start to play an old top down shooter game. "
					+ "You make it pretty far but are just shy of first place, being beaten by someone call GGY. Some tickets dispense from the machine." );
			game.removeItem(game.getItem("quarter"));
			Item tickets = new Item("tickets");
			game.getCurrentRoom().addItem(tickets);
			game.getCurrentRoom().getItem("arcadeMachine").setUsed(true);
		}
	}
}
