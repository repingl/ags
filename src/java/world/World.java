package world;

import java.util.LinkedList;
import java.util.List;
import astar.AstarAlg;
import worldElement.WorldElement;
import worldGrid.WorldGrid;


/** Reprezentacia sveta (mriezka).
 * Implementovane ako Singleton.
 * Pristupny zo vsetkych casti programu.
 * Pred pouzitim je treba zavolat metodu <code>init(int rows, int columns)</code>, aby sa inicializovala mriezka.
 * 
 * @author jakub */
public class World{
	private static Object lock = new Object();
	private static World instance;
	private WorldGrid grid;
	
	/** @return Vrati instanciu sveta <code>World</code>. */
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
	
	/** Inicializuje mriezku s rozmermy zadanymi v parametroch.
	 * 
	 * @param rows
	 *            pocet riadkov
	 * @param columns
	 *            pocet stlpcov */
	public void init(int rows, int columns){
		grid = new WorldGrid(rows, columns);
	}
	
	/** Vrati cestu medzi poziciu [x,y] a cielovou poziciou [xGoal,yGoal].
	 * 
	 * @param x
	 *            startovacia pozicia x
	 * @param y
	 *            startovacia pozicia y
	 * @param xGoal
	 *            cielova pozicia x
	 * @param yGoal
	 *            cielova pozicia y
	 * @return postupnost objektov po ceste alebo prazdny zoznam, ak taka cesta neexistuje */
	public List<WorldElement> getPath(int x, int y, int xGoal, int yGoal){
		try{
			return AstarAlg.findPath(grid.getElement(x, y), grid.getElement(xGoal, yGoal), grid);
		}catch(IndexOutOfBoundsException e){
			return new LinkedList<WorldElement>();
		}
	}
	
	/** Nastavi objekt do mriezky.
	 * 
	 * @param e */
	public void setElement(WorldElement e){
		grid.setElement(e);
	}
}
