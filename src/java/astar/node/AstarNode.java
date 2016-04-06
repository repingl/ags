package astar.node;

import worldElement.WorldElement;


public class AstarNode implements Comparable<AstarNode>{
	private WorldElement element;
	private AstarNode prev;
	private int distance;
	private int cost;
	
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
