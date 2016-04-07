package worldGrid;

import java.util.LinkedList;
import java.util.List;
import worldElement.WorldElement;
import worldObjects.Empty;
import worldObjects.Wall;


/** Reprezentacia mriezky.
 * Je definovana poctom riadkov a stlpcov.
 * 
 * @author jakub */
public class WorldGrid{
	private WorldElement[][] grid;
	
	/** Konstruktor.
	 * Policka su inicializovane objektom <code>Empty</code>.
	 * 
	 * @param rows
	 *            pocet riadkov
	 * @param columns
	 *            pocet stlpcov */
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
	
	/** Nastavi element v mriezke, poziciu ziska z objektu v parametri.
	 * 
	 * @param we
	 *            objekt, ktory chceme do mriezky vlozit */
	public void setElement(WorldElement we){
		grid[we.getRow()][we.getColumn()] = we;
	}
	
	/** Vrati susedov v stvorokoli okolo objektu v parametri.
	 * Vrati len susedov, na ktorych sa moze agent dostat (napriklad <code>Empty</code>).
	 * 
	 * @param e
	 *            objekt, ktoreho susedov hladame
	 * @return zoznam susedov */
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
	 * vrati objekt severne (hore) od objektu v parametri
	 * ak sme mimo mriezky vrati <code>Wall</code>()
	 * 
	 * @param e
	 * @return */
	private WorldElement northOf(WorldElement e){
		if(e.getColumn() > 0){
			return grid[e.getRow()][e.getColumn() - 1];
		}
		return new Wall();
	}
	
	/** E
	 * *|
	 * *V
	 * vrati objekt juzne (dole) od objektu v parametri
	 * ak sme mimo mriezky vrati <code>Wall</code>()
	 * 
	 * @param e
	 * @return */
	private WorldElement southOf(WorldElement e){
		if(e.getColumn() < grid[e.getRow()].length - 1){
			return grid[e.getRow()][e.getColumn() + 1];
		}
		return new Wall();
	}
	
	/** <-E
	 * vrati objekt zapadne (vlavo) od objektu v parametri
	 * ak sme mimo mriezky vrati <code>Wall</code>()
	 * 
	 * @param e
	 * @return */
	private WorldElement westOf(WorldElement e){
		if(e.getRow() > 0){
			return grid[e.getRow() - 1][e.getColumn()];
		}
		return new Wall();
	}
	
	/** E->
	 * vrati objekt vychodne (vpravo) od objektu v parametri
	 * ak sme mimo mriezky vrati <code>Wall</code>()
	 * 
	 * @param e
	 * @return */
	private WorldElement eastOf(WorldElement e){
		if(e.getRow() < grid.length - 1){
			return grid[e.getRow() + 1][e.getColumn()];
		}
		return new Wall();
	}
	
	/** Vrati element na zadanej pozicii
	 * 
	 * @param row
	 *            riadok
	 * @param column
	 *            stlpec
	 * @return */
	public WorldElement getElement(int row, int column){
		return grid[row][column];
	}
}
