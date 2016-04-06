package worldObjects;

import worldElement.WorldElement;


public class Border extends WorldElement{
	
	public Border(int x, int y){
		super(x, y);
	}
	
	public Border(){
		super( -1, -1);
	}
	
	@Override
	public boolean canMove(){
		return false;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Border){
			Border bor = (Border)obj;
			return hashCode() == bor.hashCode();
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
		return "Border at " + super.toString() + ".";
	}
	
	@Override
	public String symbol(){
		return "B";
	}
}
