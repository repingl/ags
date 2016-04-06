package worldObjects;

import worldElement.WorldElement;


public class Wall extends WorldElement{
	
	public Wall(int x, int y){
		super(x, y);
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
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public String toString(){
		return "Wall at " + super.toString() + ".";
	}
	
	@Override
	public String symbol(){
		return "W";
	}
}
