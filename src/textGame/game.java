package textGame;
import java.util.ArrayList;
import java.util.Scanner;
public class game {

	private static Room currentRoom;
	private static ArrayList<Item> inventory = new ArrayList<Item>();
	
	public static Room getCurrentRoom() {
		return currentRoom; 
	}
			
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		String command;
		
		currentRoom = World.buildWorld();
		
		do {
			String itemName="";
			String[] words;
			System.out.print("You are in the " + currentRoom.getName()+". What do you wish to do? ");
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
						System.out.println(currentRoom);
					}
				} else {
					System.out.println("Can't go that way.");
				}
				break;
			case "take":
				if(!itemName.equals("")) {
					if(currentRoom.hasItem(itemName)) {
						Item item = currentRoom.getItem(itemName);
						if(item.isHeavy())
							System.out.println("Thats too heavy to carry around.");
						else {
							inventory.add(currentRoom.removeItem(itemName));
							System.out.println("You picked up "+itemName+"!");
							}
						} else {
							System.out.println("There is no "+itemName+"!");
						}
					}
				
				break;
			case "i":
				if(inventory.isEmpty()) {
					System.out.println("Nothing");
				} else { 
					for(Item i : inventory)
						System.out.println(i);
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
}
