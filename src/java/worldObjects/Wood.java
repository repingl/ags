package worldObjects;

import worldElement.WorldElement;


public class Wood extends WorldElement{
	
	public Wood(int x, int y){
		super(x, y);
	}
	
	@Override
	public boolean canMove(){
		return true;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Wood){
			Wood wood = (Wood)obj;
			return hashCode() == wood.hashCode();
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
		return "Wood at " + super.toString() + ".";
	}
	
	@Override
	public String symbol(){
		return "L";
	}
}
