package test;

import java.util.List;
import astar.AstarAlg;
import worldElement.WorldElement;
import worldGrid.WorldGrid;
import worldObjects.Border;
import worldObjects.Deposit;
import worldObjects.Glasses;
import worldObjects.Gold;
import worldObjects.Nothing;
import worldObjects.Wall;
import worldObjects.Wood;


public class testMain{
	
	public static void main(String[] args){
		testGrid();
	}
	
	private static void testGrid(){
		WorldGrid wg = new WorldGrid(5, 10);
		wg.setElement(new Border(1, 1));
		wg.setElement(new Deposit(1, 2));
		wg.setElement(new Glasses(1, 3));
		wg.setElement(new Gold(1, 4));
		wg.setElement(new Nothing(1, 5));
		wg.setElement(new Wall(1, 6));
		wg.setElement(new Wood(1, 7));
		System.out.println(wg);
		List<WorldElement> path = AstarAlg.findPath(new Deposit(1, 2), new Wood(1, 7), wg);
		for(WorldElement e : path){
			System.out.println(e);
		}
	}
}
