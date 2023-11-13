package textGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class World {

	public static HashMap<String, Room> rooms = new HashMap<String, Room>();
	public static HashMap<String, String> desc = new HashMap<String, String>();
	
	// Builds the game world.
	// Returns the room the player starts in.
	public static Room buildWorld() {
		Room lobby = new Room("LOBBY");
		Room theatre = new Room("THEATER");
		Room hallway = new Room("HALLWAY");
		Room bathroom = new Room("BATHROOM");
		Room alleyway = new Room("ALLEYWAY");
		Room kitchen = new Room("KITCHEN");
		Room maintence = new Room("MAINTENCE");
		Room backStage = new Room("BACKSTAGE");
		Room lounge = new Room("LOUNGE");
		Room arcade = new Room("ARCADE");
		
		populateMap("rooms.txt");
		
		lobby.addExit(theatre, 'n');
		lobby.addExit(hallway, 'w');
		lobby.addExit(kitchen, 'e');
		Item bottle = new Bottle();
		lobby.addItem(bottle );
		bottle.setDesc("A bottle of Dr. Pepper soda.");
		
		theatre.addExit(lobby, 's');
		theatre.addExit(alleyway, 'w');
		theatre.addExit(backStage, 'n');
		Item doorkey = new DoorKey();
		theatre.addItem(doorkey);
		doorkey.setDesc("An old, greasy key.");
		
		hallway.addExit(lobby, 'e');
		hallway.addExit(alleyway, 'w');
		hallway.addExit(bathroom, 'n');
		hallway.addExit(lounge, 's');
		hallway.addExit(maintence, 'u');
		
		maintence.addExit(hallway, 'd');
		Item projector = new Projector();
		projector.setDesc("An old movie projector.");
		projector.setHeavy(true);
		maintence.addItem(projector);
		
		kitchen.addExit(lobby, 'w');
		Item bag = new Bag();
		kitchen.addItem(bag);
		bag.setDesc("A bag full of popcorn.");
		Item largekey = new LargeKey();
		kitchen.addItem(largekey);
		largekey.setDesc("A large silver key.");
		
		bathroom.addExit(hallway, 's');
		Item newspaper = new Item("newspaper");
		bathroom.addItem(newspaper);
		newspaper.setDesc("A crumpled up newspaper from last week.");
		
		alleyway.addExit(theatre, 'n');
		alleyway.addExit(hallway, 'e');
		Item movie = new Item("movie");
		alleyway.addItem(movie);
		movie.setDesc("An old movie reel.");
		alleyway.setLocked(true);
		
		lounge.addExit(arcade, 'w');
		lounge.addExit(hallway,'n');
		Item quarter = new Item("quarter");
		quarter.setDesc("A shiny quarter worth $0.25");
		lounge.addItem(quarter);
		lounge.setLocked(true);
		
		
		arcade.addExit(lounge, 'e');
		Item arcadeMachine = new arcadeMachine();
		arcadeMachine.setDesc("A large and old aracade machine");
		arcadeMachine.setHeavy(true);
		arcade.addItem(arcadeMachine);
		
		backStage.addExit(theatre, 's');
		backStage.setLocked(true);
		Item chest = new Item("chest");
		chest.setDesc("A large and heavy chest");
		chest.setHeavy(true);
		backStage.addItem(chest);
		
		return lobby;
	}
	
	public static void populateMap(String fileName) {

		try {
			Scanner scan = new Scanner (new File(fileName));
			while(scan.hasNextLine()) {
				String line = scan.nextLine(); 
				String des = scan.nextLine();
				desc.put(line, des);
				scan.nextLine();
			
			}
		} catch (FileNotFoundException e) {
			game.print("File not found");
		}
		
	}
}
