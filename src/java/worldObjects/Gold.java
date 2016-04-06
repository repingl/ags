package worldObjects;

import worldElement.WorldElement;


public class Gold extends WorldElement{
	
	public Gold(int x, int y){
		super(x, y);
	}
	
	@Override
	public boolean canMove(){
		return true;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Gold){
			Gold gold = (Gold)obj;
			return hashCode() == gold.hashCode();
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
		return "Gold at " + super.toString() + ".";
	}
	
	@Override
	public String symbol(){
		return "G";
	}
	
}
