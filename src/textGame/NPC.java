package textGame;

public class NPC {

	private String name;
	private String desc;
	protected int hasTalked;
	private int hp;
	//talk, give, attack, say, getResponce
	
	
	public NPC(String name, String desc) {
		this.name=name;
		this.desc=desc;
		hasTalked=0;
		hp=75;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDesc(String desc) {
		this.desc=desc;
	}
	
	public void look() {
		game.print(desc);
	}
	
	public void talk() {
		game.print("You cant talk to "+name+".");
	}
	
	public void response(int option) {
		//intentionally blank
	}
	
	public void say(String dialog) {
		game.print(name+": "+dialog);
	}
	/**
	 * Display options to player
	 * prompt player to select an option
	 * read player's choice
	 * call response method with players choice as the parameter.
	 */
	public void getResponse(String[] options) {
		for(int i=0; i<options.length; i++) {
			game.print("Option "+(i+1)+": "+options[i]);
		}
		game.print("Enter an option (1-"+options.length+"): ");
		int choice = game.scan.nextInt();
		game.scan.nextLine(); //flush input buffer
		response(choice);
	}
	
	public void give(Item i) {
		game.print("You cant give "+i+" to "+name+".");
	}
	
	public void attack(String weapon) {
		
	}
	
}
