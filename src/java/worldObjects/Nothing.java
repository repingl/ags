package worldObjects;

import worldElement.WorldElement;


public class Nothing extends WorldElement{
	
	public Nothing(int x, int y){
		super(x, y);
	}
	
	public Nothing(){
		super( -1, -1);
	}
	
	@Override
	public boolean canMove(){
		return false;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Nothing){
			Nothing not = (Nothing)obj;
			return hashCode() == not.hashCode();
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
		return "Nothing at " + super.toString() + ".";
	}
	
	@Override
	public String symbol(){
		return "N";
	}
}
