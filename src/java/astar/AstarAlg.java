package astar;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import astar.node.AstarNode;
import worldElement.WorldElement;
import worldGrid.WorldGrid;


/** Implementacia algoritmu A*.
 * 
 * @author jakub */
public abstract class AstarAlg{
	/** Najde cestu medzi zaciatocnym a cielovym uzlom.
	 * 
	 * @param start
	 *            element, z ktoreho zaciname
	 * @param goal
	 *            cielovy element
	 * @param world
	 *            svet, v ktorom hladame cestu
	 * @return Vrati zoznam uzlov po ceste, ak cestu najde, ak ju nenajde alebo neexistuje vrati prazdny zoznam. */
	public static List<WorldElement> findPath(WorldElement start, WorldElement goal, WorldGrid world){
		PriorityQueue<AstarNode> open = new PriorityQueue<AstarNode>();
		List<AstarNode> closed = new LinkedList<AstarNode>();
		open.add(new AstarNode(start, null, 0, distance(start, goal)));
		AstarNode current = null;
		while( !open.isEmpty()){
			current = open.poll();
			if(current.getElement().equals(goal)){
				break;
			}
			closed.add(current);
			for(AstarNode neigh : getNeighbours(current, goal, world)){
				if(open.contains(neigh)){
					boolean remove = false;
					for(AstarNode an : open){
						if(an.equals(neigh) && neigh.getDistance() < an.getDistance()){
							remove = true;
							break;
						}
					}
					if(remove){
						open.remove(neigh);
					}
				}
				if(closed.contains(neigh) && neigh.getDistance() < closed.get(closed.indexOf(neigh)).getDistance()){
					closed.remove(neigh);
				}
				if( !open.contains(neigh) && !closed.contains(neigh)){
					open.add(neigh);
				}
			}
		}
		if(current.getElement().equals(goal)){
			return constructPath(current);
		}else{
			return new LinkedList<WorldElement>();
		}
	}
	
	/** Zrekonstruuje cestu do pola <code>WorldElement</code>ov.
	 * 
	 * @param last
	 * @return */
	private static List<WorldElement> constructPath(AstarNode last){
		LinkedList<WorldElement> result = new LinkedList<WorldElement>();
		for(AstarNode n = last; n != null; n = n.getPrev()){
			result.addFirst(n.getElement());
		}
		return result;
	}
	
	/** Najde susedov k zanademu uzlu. Musi byt mozne sa na nich dostat.
	 * Zavola metodu <code>WorldGrid.getNeighbours(WorldElement e)</code> a vysledok obali do triedy
	 * <code>AstarNode</code>.
	 * 
	 * @param current
	 *            uzol, ktoreho susedov chceme
	 * @param goal
	 *            ciel, kde sa chceme dostat, je ho potreba pre heuristiku
	 * @param grid
	 *            reprezentacia prostredia
	 * @return zoznam susedov, na ktorych sa mozeme z daneho uzlu dostat */
	private static List<AstarNode> getNeighbours(AstarNode current, WorldElement goal, WorldGrid grid){
		List<AstarNode> result = new LinkedList<AstarNode>();
		for(WorldElement e : grid.getNeighbours(current.getElement())){
			result.add(new AstarNode(	e, current, current.getDistance() + 1,
										current.getDistance() + 1 + distance(e, goal)));
		}
		return result;
	}
	
	/** Manhatan vzdialenost pre dva body na mriezke.
	 * 
	 * @param node
	 * @param goal
	 * @return */
	private static int distance(WorldElement node, WorldElement goal){
		int dx = Math.abs(node.getRow() - goal.getRow());
		int dy = Math.abs(node.getColumn() - goal.getColumn());
		return dx + dy;
	}
}
