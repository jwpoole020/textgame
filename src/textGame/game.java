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
import javax.swing.*;		//swing gui package
import java.awt.*; 			//advance window toolkit
import java.awt.event.*;	//awt event package (to program buttons)

public class game extends JFrame implements ActionListener{

	private static Room currentRoom;
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	public static Scanner scan=new Scanner(System.in);
	
	public static Room getCurrentRoom() {
		return currentRoom; 
	}
			
	public static void main(String[] args) {
		
		NPC npc;
		Item i;
		String command="a";
		String itemName;
		currentRoom = World.buildWorld();
		print("You are trapped in an old movie theater.  Try to find a way to escape.");
		do {
			print(currentRoom.getDesc());
			print("What you gonna do: ");
			command=scan.nextLine();
			String[] words = command.split(" ");
			switch(words[0]) {
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
				itemName = words[1];
				if(currentRoom.hasItem(itemName)) {
					inventory.add(currentRoom.removeItem(itemName));
					print("You picked up "+itemName+".");
				} else {
					print("There is no "+itemName+"!");
				}
				break;
			case "i":
				print("Inventory:");
				if(inventory.isEmpty()) {
					print("Nothing");
				} else { 
					for(Item z : inventory)
						System.out.println(z);
					print("");
				}
				break;
			case "look":
				if(currentRoom.getItem(words[1])!=null || inventory.contains(getItem(words[1]))) {
					i = getItem(words[1]);
					if (i == null)
						i = currentRoom.getItem(words[1]);
					if (i == null)
						print("There is no "+words[1]+"!");
					else 
						i.look();
				} else if(currentRoom.getNPC(words[1]) != null) {
					npc = currentRoom.getNPC(words[1]);
					npc.look();
				} else
					print("There is no "+words[1]+"!");
			
				
				break;
			case "use":
				i = getItem(words[1]);
				if (i == null )
					print("You don't have the"+words[1]+".");
				else
					i.use();
				break;
			case "talk":
				npc=currentRoom.getNPC(words[1]);
				npc.talk();
				break;
			case "give":
				npc=currentRoom.getNPC(words[1]);
				i = getItem(words[2]);
				if (i == null )
					print("You don't have "+words[2]+".");
				else
					npc.give(i);
				break;
			case "x":
				print("See ya.");
				break;
			case "save":
				saveGame();
				break;
			case "load":
				loadGame();
				break;
			default:
				print("Error");
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
	
	@SuppressWarnings("unchecked")
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
				print("Thats too heavy to carry around.");
			else {
				inventory.add(currentRoom.removeItem(i));
				print("You picked up "+i+"!");
				}
			} else {
				print("There is no "+i+"!");
			}
	}
	
	public static void removeItem(Item i) {
		inventory.remove(i);
	}
	
	public static void addRooms(String s) {
		try {
			Scanner findRoom = new Scanner(new File(s));
		} catch (FileNotFoundException ex) {
			print("File not found.");
		}
	}
	
	
	public void makeWindow() {
		setTitle("Example");
		setSize(500, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
