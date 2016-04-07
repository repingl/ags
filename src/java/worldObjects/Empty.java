package worldObjects;

import worldElement.WorldElement;


/** Prazdne policko na mriezke, agent sa nan moze dostat.
 * Charakterizovane svojou pozicou, riadok a stlpec mriezky.
 * 
 * @author jakub */
public class Empty extends WorldElement{
	
	public Empty(int row, int column){
		super(row, column);
	}
	
	@Override
	public boolean canMove(){
		return true;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Empty){
			Empty emp = (Empty)obj;
			return hashCode() == emp.hashCode();
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		int result = super.hashCode();
		result = 31 * result + "Empty".hashCode();
		return result;
	}
	
	@Override
	public String toString(){
		return "Empty at " + super.toString() + ".";
	}
	
	@Override
	public String symbol(){
		return "O";
	}
}
