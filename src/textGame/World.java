package textGame;

public class World {

	// Builds the game world.
	// Returns the room the player starts in.
	public static Room buildWorld() {
		Room lobby = new Room("lobby", "You are in the lobby. You spot an empty bottle in the corner.");
		Room theatre = new Room("theatre", "You are in the theatre room. You see a key at the other side of the room.");
		Room hallway = new Room("hallway", "You are in the hallway. You notice a flash of light from a magic wand.");
		Room bathroom = new Room("bathroom", "You are in the bathroom. An old newspapper sits on the sink.");
		Room alleyway = new Room("alleyway", "You are in the alleyway. You notice an old movie reel.");
		Room kitchen = new Room("kitchen", "You are in the kitchen. You see a bag.");
		Room maintence = new Room("maintence", "You are in the maintence room. There is a movie projector.");
		
		lobby.addExit(theatre, 'n');
		lobby.addExit(hallway, 'w');
		lobby.addExit(kitchen, 'e');
		Item bottle = new Item("bottle");
		lobby.addItem(bottle );
		bottle.setDesc("A half filled bottle of soda.");
		Item chest = new Item("chest");
		chest.setDesc("A large and heavy chest");
		chest.setHeavy(true);
		lobby.addItem(chest);
		
		theatre.addExit(lobby, 's');
		theatre.addExit(alleyway, 'w');
		Item doorkey = new Item("doorkey");
		theatre.addItem(doorkey);
		doorkey.setDesc("An old, greasy key.");
		
		hallway.addExit(lobby, 'e');
		hallway.addExit(alleyway, 'w');
		hallway.addExit(bathroom, 'n');
		hallway.addExit(maintence, 'u');
		Item wand = new Wand();
		wand.setDesc("A magical wand that flickers with light.");
		hallway.addItem(wand);
		
		maintence.addExit(hallway, 'd');
		Item projector = new Projector();
		projector.setDesc("An old movie projector.");
		projector.setHeavy(true);
		maintence.addItem(projector);
		
		kitchen.addExit(lobby, 'w');
		Item bag = new Bag();
		kitchen.addItem(bag);
		bag.setDesc("A bag full of popcorn.");
		//kitchen.setLocked(true); 
		Item largekey = new Item("largekey");
		kitchen.addItem(largekey);
		largekey.setDesc("A large silver key.");
		
		Item chain = new Chain();
		kitchen.addItem(chain);
		chain.setDesc("A rusty chain hangs from the ceiling.");
		chain.setHeavy(true);
		
		
		
		bathroom.addExit(hallway, 's');
		Item newspaper = new Item("newspaper");
		bathroom.addItem(newspaper);
		newspaper.setDesc("A crumpled up newspaper from last week.");
		Item shower = new Shower();
		shower.setDesc("An old shower that seems functional.");
		bathroom.addItem(shower);
		
		alleyway.addExit(theatre, 'n');
		alleyway.addExit(hallway, 'e');
		Item movie = new Item("movie");
		alleyway.addItem(movie);
		movie.setDesc("An old horror movie reel.");
		alleyway.setLocked(true);
		
		return lobby;
	}
}
