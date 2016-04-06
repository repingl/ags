package worldObjects;

import worldElement.WorldElement;


public class Deposit extends WorldElement{
	
	public Deposit(int x, int y){
		super(x, y);
	}
	
	@Override
	public boolean canMove(){
		return true;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Deposit){
			Deposit dep = (Deposit)obj;
			return hashCode() == dep.hashCode();
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
		return "Deposit at " + super.toString() + ".";
	}
	
	@Override
	public String symbol(){
		return "D";
	}
	
}
