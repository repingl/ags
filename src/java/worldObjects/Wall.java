package worldObjects;

import worldElement.WorldElement;


/** Prekazka na mriezke, agent sa na nu nemoze dostat.
 * Charakterizovane svojou pozicou, riadok a stlpec mriezky.
 * 
 * @author jakub */
public class Wall extends WorldElement{
	
	public Wall(int row, int column){
		super(row, column);
	}
	
	public Wall(){
		super( -1, -1);
	}
	
	@Override
	public boolean canMove(){
		return false;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Wall){
			Wall wall = (Wall)obj;
			return hashCode() == wall.hashCode();
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		int result = super.hashCode();
		result = 31 * result + "Wall".hashCode();
		return result;
	}
	
	@Override
	public String toString(){
		return "Wall at " + super.toString() + ".";
	}
	
	@Override
	public String symbol(){
		return "X";
	}
}
