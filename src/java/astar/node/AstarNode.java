package astar.node;

import worldElement.WorldElement;


/** Reprezentacia uzlu pre algoritmus A*.
 * Obsahuje <code>WorldElement</code>, <code>AstarNode</code>, z ktoreho sme prisli, vzdialenost od zaciatku a celkovu
 * cenu cesty.
 * 
 * @author jakub */
public class AstarNode implements Comparable<AstarNode>{
	private WorldElement element;
	private AstarNode prev;
	private int distance;
	private int cost;
	
	/** @param element
	 *            objekt na mape
	 * @param prev
	 *            uzol, z ktoreho sme prisli
	 * @param distance
	 *            vzdialenost od zaciatku
	 * @param cost
	 *            cena cesty (heuristika) */
	public AstarNode(WorldElement element, AstarNode prev, int distance, int cost){
		super();
		this.element = element;
		this.prev = prev;
		this.distance = distance;
		this.cost = cost;
	}
	
	public int compareTo(AstarNode a){
		return Integer.compare(getCost(), a.getCost());
	}
	
	public WorldElement getElement(){
		return element;
	}
	
	public void setElement(WorldElement element){
		this.element = element;
	}
	
	public AstarNode getPrev(){
		return prev;
	}
	
	public void setPrev(AstarNode prev){
		this.prev = prev;
	}
	
	public int getCost(){
		return cost;
	}
	
	public void setCost(int cost){
		this.cost = cost;
	}
	
	public void setDistance(int distance){
		this.distance = distance;
	}
	
	public int getDistance(){
		return distance;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof AstarNode){
			AstarNode we = (AstarNode)obj;
			return element.equals(we.getElement());
		}
		return false;
	}
}
