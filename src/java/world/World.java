package world;

import java.util.List;
import astar.AstarAlg;
import worldElement.WorldElement;
import worldGrid.WorldGrid;


public class World{
	private static Object lock = new Object();
	private static World instance;
	private WorldGrid grid;
	
	public static World getInstance(){
		if(instance == null){
			synchronized(lock){
				if(instance == null){
					instance = new World();
				}
			}
		}
		return instance;
	}
	
	public void init(int rows, int columns){
		grid = new WorldGrid(rows, columns);
	}
	
	public List<WorldElement> getPath(int x, int y, int xGoal, int yGoal){
		return AstarAlg.findPath(grid.getElement(x, y), grid.getElement(xGoal, yGoal), grid);
	}
	
	public void setElement(WorldElement e){
		grid.setElement(e);
	}
}
