package textGame;

public class Zombie extends NPC{

	public Zombie() {
		super("zombie", "A hideous zombie groans at you.  It looks like he's wearing an employee's uniform.");
	}
	
	public void talk() {
		say("I'm a gross zombie.");
		String[] options = {
				"Yes, you are hideous.",
				"No, you're pretty cute."
		};
		getResponse(options);
	}
	
	public void response(int choice) {
		switch (choice) {
		case 1:
			say("Well you don't have to be a jerk about it.");
			game.print("The zombie bites your arm.");
			break;
		case 2:
			say("Well thanks. I needed to hear that.");
			break;
		}
	}
	
	public void give(Item i) {
		say("Thanks for the "+i+".");
		game.inventory.remove(i);
	}
}
