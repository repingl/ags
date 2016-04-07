package worldElement;

import java.awt.Point;


/** Zakladny element mapy.
 * Je charakterizovany svojou poziciou, riadok a stlpec v mriezke.
 * 
 * @author jakub */
public abstract class WorldElement{
	private Point position;
	
	/** @return True ak sa agent moze na tento element pohnut, inak False. */
	public abstract boolean canMove();
	
	/** @return Vrati znak charakterizujuci objekt. */
	public abstract String symbol();
	
	/** Zakladny konstruktor, parametre udavaju poziciu objektu.
	 * 
	 * @param row
	 *            riadok
	 * @param column
	 *            stlpec */
	public WorldElement(int row, int column){
		position = new Point(row, column);
	}
	
	public Point getPosition(){
		return position;
	}
	
	public void setPosition(Point p){
		position = p;
	}
	
	public void setPosition(int row, int column){
		position = new Point(row, column);
	}
	
	public int getRow(){
		return position.x;
	}
	
	public int getColumn(){
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
