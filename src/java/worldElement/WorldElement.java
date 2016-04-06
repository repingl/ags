package worldElement;

import java.awt.Point;


public abstract class WorldElement{
	private Point position;
	
	public abstract boolean canMove();
	
	public abstract String symbol();
	
	/** @param x
	 *            is row
	 * @param y
	 *            is column */
	public WorldElement(int x, int y){
		position = new Point(x, y);
	}
	
	public Point getPosition(){
		return position;
	}
	
	public void setPosition(Point p){
		position = p;
	}
	
	public void setPosition(int x, int y){
		position = new Point(x, y);
	}
	
	public int getX(){
		return position.x;
	}
	
	public int getY(){
		return position.y;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof WorldElement){
			WorldElement we = (WorldElement)obj;
			return hashCode() == we.hashCode();
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		int result = position.x;
		result = 31 * result + position.y;
		return result;
	}
	
	@Override
	public String toString(){
		return "position: " + position.x + "," + position.y;
	}
	
}
