package textGame;

public class Puppy extends NPC{

	public Puppy() {
		super("puppy", "A hideous puppy wags his tail.");
	}
	@Override
	public void talk() {

		String[] options = {
				"Yes you are! Who's a good boy?",
				"Ew, no. You're actually kinda hideous."
		};
		if(hasTalked==0) {
			say("Hi! I'm an adorable puppy!");
			getResponse(options);
		}
		
		else if(hasTalked==1) {
			say("Hey! Wanna play fetch?");
			options[0]="Yes! I love fetch!";
			options[1]="No. I am a horrible person and don't like playing with puppies.";
			getResponse(options);
		}else {
			say("\"Yip!\" The puppy wags his tail.");
			inConvo=false;
		}
		
		
		
	}
	@Override
	public void response(int option) {
		if(hasTalked==0) {
			switch(option) {
				case 1:
					say("I am! I'm a good boy!");
					hasTalked++;
					break;
				case 2:
					say("I am to adorable! Why are you so mean?");
					game.print("The puppy bites you. You deserve it.");
					hasTalked++;
					break;
				default:
					game.print("Error");
			}
		}else if(hasTalked==1) {
			switch(option) {
			case 1:
				say("\"Yay! Fetch!\" (The puppy runs off and returns with a ball. "
						+ "The player receives the ball.");
				hasTalked++;
				break;
			case 2:
				say("\"You're a bad person! I don't like you!\" ");
				
				hasTalked++;
				break;
			default:
				game.print("Error");
			}
		} 
		inConvo=false;
	}
	
}