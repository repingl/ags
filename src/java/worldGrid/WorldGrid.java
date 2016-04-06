package worldGrid;

import java.util.LinkedList;
import java.util.List;
import worldElement.WorldElement;
import worldObjects.Border;
import worldObjects.Empty;


public class WorldGrid{
	private WorldElement[][] grid;
	
	public WorldGrid(int rows, int columns){
		grid = new WorldElement[rows][columns];
		for(int r = 0; r < rows; r ++){
			for(int c = 0; c < columns; c ++){
				grid[r][c] = new Empty(r, c);
			}
		}
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int r = 0; r < grid.length; r ++){
			for(int c = 0; c < grid[r].length; c ++){
				sb.append(grid[r][c].symbol() + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public void setElement(WorldElement we){
		grid[we.getX()][we.getY()] = we;
	}
	
	public List<WorldElement> getNeighbours(WorldElement e){
		List<WorldElement> result = new LinkedList<WorldElement>();
		if(northOf(e).canMove()){
			result.add(northOf(e));
		}
		if(southOf(e).canMove()){
			result.add(southOf(e));
		}
		if(westOf(e).canMove()){
			result.add(westOf(e));
		}
		if(eastOf(e).canMove()){
			result.add(eastOf(e));
		}
		return result;
	}
	
	/** ^
	 * *|
	 * *E
	 * 
	 * @param e
	 * @return */
	private WorldElement northOf(WorldElement e){
		if(e.getY() > 0){
			return grid[e.getX()][e.getY() - 1];
		}
		return new Border();
	}
	
	/** E
	 * *|
	 * *V
	 * 
	 * @param e
	 * @return */
	private WorldElement southOf(WorldElement e){
		if(e.getY() < grid[e.getX()].length - 1){
			return grid[e.getX()][e.getY() + 1];
		}
		return new Border();
	}
	
	/** <-E
	 * 
	 * @param e
	 * @return */
	private WorldElement westOf(WorldElement e){
		if(e.getX() > 0){
			return grid[e.getX() - 1][e.getY()];
		}
		return new Border();
	}
	
	/** E->
	 * 
	 * @param e
	 * @return */
	private WorldElement eastOf(WorldElement e){
		if(e.getX() < grid.length - 1){
			return grid[e.getX() + 1][e.getY()];
		}
		return new Border();
	}
}
