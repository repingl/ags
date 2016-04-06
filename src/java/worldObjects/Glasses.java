package worldObjects;

import worldElement.WorldElement;


public class Glasses extends WorldElement{
	
	public Glasses(int x, int y){
		super(x, y);
	}
	
	@Override
	public boolean canMove(){
		return true;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Glasses){
			Glasses glas = (Glasses)obj;
			return hashCode() == glas.hashCode();
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public String toString(){
		return "Glasses at " + super.toString() + ".";
	}
	
	@Override
	public String symbol(){
		return "O";
	}
}
