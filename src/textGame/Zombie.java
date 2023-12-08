package textGame;

public class Zombie extends NPC{

	public Zombie() {
		super("zombie", "A hideous zombie groans at you.  It looks like he's wearing an employee's uniform. His name tag says Gregory.");
	}
	@Override
	public void talk() {
		say("I'm a gross zombie.");
		String[] options = {
				"Yes, you are hideous.",
				"No, you're pretty cute."
		};
		getResponse(options);
	}
	@Override
	public void response(int choice) {
		switch (choice) {
		case 1:
			say("Well you don't have to be a jerk about it.");
			game.print("The zombie bites your arm.");
			hasTalked++;
			break;
		case 2:
			say("Well thanks. I needed to hear that.");
			break;
		}
	}
	@Override
	public void give(Item i) {
		if(i.getName().equals("tickets")) {
			game.inventory.remove(i);
			say("These look like tickets from the arcade machine.  You know I have the high score right?");
			game.print("The zombie takes your tickets and gives you his arm as a reward.");
			Item arm = new arm();
			arm.setDesc("An arm that belonged to a zombie. It still has freaky zombie strength.");
			game.inventory.add(arm);
		} else if(i.getName().equals("bottle")) {
			if(i.isUsed())
				say("You drank it all. What the heck.");
			else
				say("Thanks, I was pretty thirsty.");
		} 
	}
}
