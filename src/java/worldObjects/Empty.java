package worldObjects;

import worldElement.WorldElement;


public class Empty extends WorldElement{
	
	public Empty(int x, int y){
		super(x, y);
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
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public String toString(){
		return "Empty at " + super.toString() + ".";
	}
	
	@Override
	public String symbol(){
		return "E";
	}
}
