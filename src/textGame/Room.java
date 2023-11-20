package textGame;

import java.io.Serializable;
import java.util.HashMap;

public class Room implements Serializable{

	private String description;
	private Room east;
	private Room west;
	private Room north;
	private Room south;
	private Room up;
	private Room down;
	private boolean locked; //is room locked?
	private String name;
	private String roomID;
	
	private HashMap<String, Item> roomItems;
	private HashMap<String, NPC> roomNPCs;
	
	public Room(String n) {
		name = n;
		roomID = n;
		roomItems = new HashMap<String, Item>();
		roomNPCs = new HashMap<String, NPC>();
		locked = false;
		World.rooms.put(name, this);
	}
	
	public void addNPC(NPC npc) {
		roomNPCs.put(npc.getName(), npc);
	}
	
	public NPC getNPC(String name) {
		return roomNPCs.get(name);
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
	
	public String getDesc() {
		return World.desc.get(roomID);
	}
	
	public void setRoomID(String id) {
		roomID = id;
	}
	
	public String getRoomID() {
		return roomID;
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
