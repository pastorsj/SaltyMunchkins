import java.util.HashMap;

public class Card {
	public int num;
	public String name;
	
	public Card(int num, String name) {
		this.num = num;
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getNumber(){
		return this.num;
	}

}
