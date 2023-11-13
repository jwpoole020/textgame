package textGame;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;
public class game {

	private static Room currentRoom;
	public static ArrayList<Item> inventory = new ArrayList<Item>();

	
	public static Room getCurrentRoom() {
		return currentRoom; 
	}
			
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		String command;
		
		currentRoom = World.buildWorld();
		
		game.print("You are trapped in an old movie theater.  Try to find a way to escape.");
		do {
			String itemName="";
			String[] words;
			print(currentRoom.getDesc());
			String input=scan.nextLine();
			if(input.contains(" ")) {
				words= input.split(" ");
				command= words[0];
				itemName= words[1];
			} else
				command=input;
			
			switch(command) {
			case "e":
			case "w":
			case "n":
			case "s":
			case "u":
			case "d":
				Room nextRoom =currentRoom.getExit(command);
				if(nextRoom!=null) {
					if(nextRoom.isLocked()) {
						System.out.println("That room is locked");
					} else {
						currentRoom = nextRoom;
					}
				} else {
					print("Can't go that way.");
				}
				break;
			case "take":
				if(!itemName.equals("")) {
					if(currentRoom.hasItem(itemName)) {
						Item item = currentRoom.getItem(itemName);
						item.take();
					} else {
						System.out.println("There is no "+itemName+"!");
					}
				}
				
				break;
			case "i":
				print("Inventory:");
				if(inventory.isEmpty()) {
					print("Nothing");
				} else { 
					for(Item i : inventory)
						System.out.println(i);
					print("");
				}
				break;
			case "look":
				if(currentRoom.hasItem(itemName) ) {
					currentRoom.getItem(itemName).look();
				} else if(getItem(itemName)!=null) {
					getItem(itemName).look();
				}
				break; 
			case "use":
				if(getItem(itemName)!=null){
					getItem(itemName).use();
					
				} else if(currentRoom.hasItem(itemName)) {
					currentRoom.getItem(itemName).use();
				} 
				break;
			case "x":
				System.out.println("See ya.");
				break;
			case "save":
				saveGame();
				break;
			case "load":
				loadGame();
				break;
			default:
				System.out.println("Error");
			}
		} while(!command.equals("x"));
		scan.close();
	}
	
	public static Item getItem(String name) {
		for(Item i : inventory) {
			if(i.getName().equals(name)) {
				return i;
			}
		}
		return null;
	}
	
	public static void print(String message) {
		System.out.println(message+"\n");
	}
	

	public static void saveGame() {
		File saveFile = new File("save");
		try {
			saveFile.createNewFile();
			ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(saveFile));
			stream.writeObject(currentRoom);
			stream.writeObject(inventory);
			stream.writeObject(World.rooms);
			stream.close();
		} catch (IOException e) {
			print("error: cannot save file!");
		}
	}
	
	public static void loadGame() {
		try {
			ObjectInputStream stream = new ObjectInputStream(new FileInputStream(new File("save")));
			try {
				currentRoom = (Room) stream.readObject();
				inventory = (ArrayList<Item>) stream.readObject();
				World.rooms = (HashMap<String, Room>) stream.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void take(String i) {
		if(currentRoom.hasItem(i)) {
			Item item = currentRoom.getItem(i);
			if(item.isHeavy())
				System.out.println("Thats too heavy to carry around.");
			else {
				inventory.add(currentRoom.removeItem(i));
				System.out.println("You picked up "+i+"!");
				}
			} else {
				System.out.println("There is no "+i+"!");
			}
	}
	
	public static void removeItem(Item i) {
		inventory.remove(i);
	}
	
	public static void addRooms(String s) {
		try {
			Scanner findRoom = new Scanner(new File(s));
		} catch (FileNotFoundException ex) {
			System.out.println("File not found.");
		}
	}
	
}
