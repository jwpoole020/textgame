package textGame;

import java.io.Serializable;

public class Item implements Serializable{

	private String name;
	private String description;
	private boolean heavy;
	private boolean used;
	
	public Item(String n) {
		if(n.contains(" "))
			throw new IllegalArgumentException("name must be one word: "+n);
		name = n;
		heavy = false;
		used = false;
	}
	 
	public boolean isUsed() {
		return used;
	}
	
	public void setUsed(boolean b) {
		used = true;
	}
	
	public String getName() {
		return name;
	}
	
	public void setHeavy(boolean h) {
		heavy = h;
	}
	
	public boolean isHeavy() {
		return heavy;
	}
	
	public void setDesc(String d) {
		description = d;
	}
	
	public void look() {
		System.out.println(description);
	}
	
	public void use() {
		System.out.println("You cant use this item...yet.");
	}
	
	public void take() {
		if(heavy)
			System.out.println("Thats too heavy to carry around.");
		else {
			game.inventory.add(game.getCurrentRoom().removeItem(name));
			System.out.println("You picked up "+ name +"!");
			}
	}
	
	public String toString() {
		return name;
	}
}
