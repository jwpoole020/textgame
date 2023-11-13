package textGame;

public class Bottle extends Item{

	public Bottle() {
		super ("bottle");
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
