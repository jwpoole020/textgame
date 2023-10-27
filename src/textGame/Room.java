package textGame;

import java.util.HashMap;

public class Room {

	private String description;
	private Room east;
	private Room west;
	private Room north;
	private Room south;
	private Room up;
	private Room down;
	private boolean locked; //is room locked?
	private String name;
	
	private HashMap<String, Item> roomItems;
	
	public Room(String n, String d) {
		name = n;
		description = d;
		roomItems = new HashMap<String, Item>();
		locked = false;
	}
	
	public String getName() {
		return name;
	}
	 
	public boolean isLocked() {
		return locked;
	}
	
	public void setLocked(boolean b) {
		locked = b;
	}
	
	public Item removeItem(String name) {
		return roomItems.remove(name);
	}
	
	public boolean hasItem(String name) {
		return roomItems.containsKey(name);
	}
	
	public void addItem(Item i) {
		roomItems.put(i.getName(), i);
	}
	
	public Room getExit(String d) {
		
		if(d.equals("n"))
			return north;
		else if(d.equals("s"))
			return south;
		else if(d.equals("e"))
			return east;
		else if(d.equals("w"))
			return west;
		else if(d.equals("u"))
			return up;
		else if(d.equals("d"))
			return down;
		else
			return null;
	}
	
	public void addExit(Room r, char d) {
		switch(d){
		case 'n':
			north=r;
			break;
		case 's':
			south=r;
			break;
		case 'e':
			east=r;
			break;
		case 'w':
			west=r;
			break;
		case 'u':
			up=r;
			break;
		case 'd':
			down=r;
			break;
		}
	}
	
	public Item getItem(String name) {
		return roomItems.get(name);
	}
	
	public String toString() {
		return description;
	}
}