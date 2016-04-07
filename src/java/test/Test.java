package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import astar.AstarAlg;
import astar.node.AstarNode;
import worldElement.WorldElement;
import worldGrid.WorldGrid;
import worldObjects.Empty;
import worldObjects.Wall;


public class Test{
	
	@org.junit.Test
	public void testCanMove(){
		assertFalse((new Wall(0, 0).canMove()));
		assertTrue((new Empty(0, 0).canMove()));
	}
	
	@org.junit.Test
	public void testPosition(){
		assertEquals((new Empty(0, 0)).getPosition(), new Point(0, 0));
		assertEquals((new Empty(1, 1)).getPosition(), new Point(1, 1));
		assertEquals((new Empty(2, 2)).getPosition(), new Point(2, 2));
		assertEquals((new Wall(3, 2)).getPosition(), new Point(3, 2));
		assertEquals((new Wall(4, 1)).getPosition(), new Point(4, 1));
		assertEquals((new Wall(5, 5)).getPosition(), new Point(5, 5));
		assertEquals((new Empty(2, 2)).getRow(), 2);
		assertEquals((new Empty(3, 3)).getColumn(), 3);
		assertEquals((new Wall(2, 2)).getRow(), 2);
		assertEquals((new Wall(3, 3)).getColumn(), 3);
	}
	
	@org.junit.Test
	public void testEquality(){
		assertEquals(new Empty(0, 0), new Empty(0, 0));
		assertEquals(new Wall(0, 0), new Wall(0, 0));
		assertEquals(new Wall(), new Wall());
		assertFalse((new Empty(0, 0)).equals(new Empty(1, 1)));
		assertFalse((new Wall(0, 0)).equals(new Wall(1, 1)));
		assertFalse((new Empty(0, 0)).equals(new Wall(0, 0)));
		assertFalse((new Wall(0, 0)).equals(new Empty(0, 0)));
	}
	
	@org.junit.Test
	public void testWorldGrid(){
		WorldGrid grid = new WorldGrid(3, 3);
		
		assertEquals(grid.getElement(0, 0), new Empty(0, 0));
		assertEquals(grid.getElement(0, 1), new Empty(0, 1));
		assertEquals(grid.getElement(0, 2), new Empty(0, 2));
		
		assertEquals(grid.getElement(1, 0), new Empty(1, 0));
		assertEquals(grid.getElement(1, 1), new Empty(1, 1));
		assertEquals(grid.getElement(1, 2), new Empty(1, 2));
		
		assertEquals(grid.getElement(2, 0), new Empty(2, 0));
		assertEquals(grid.getElement(2, 1), new Empty(2, 1));
		assertEquals(grid.getElement(2, 2), new Empty(2, 2));
		
		grid.setElement(new Wall(0, 1));
		grid.setElement(new Wall(1, 1));
		grid.setElement(new Wall(2, 1));
		
		assertEquals(grid.getElement(0, 0), new Empty(0, 0));
		assertEquals(grid.getElement(0, 1), new Wall(0, 1));
		assertEquals(grid.getElement(0, 2), new Empty(0, 2));
		
		assertEquals(grid.getElement(1, 0), new Empty(1, 0));
		assertEquals(grid.getElement(1, 1), new Wall(1, 1));
		assertEquals(grid.getElement(1, 2), new Empty(1, 2));
		
		assertEquals(grid.getElement(2, 0), new Empty(2, 0));
		assertEquals(grid.getElement(2, 1), new Wall(2, 1));
		assertEquals(grid.getElement(2, 2), new Empty(2, 2));
		
		assertFalse(grid.getElement(0, 1).equals(new Empty(0, 1)));
		assertFalse(grid.getElement(1, 1).equals(new Empty(1, 1)));
		assertFalse(grid.getElement(2, 1).equals(new Empty(2, 1)));
		
		List<WorldElement> neigh = grid.getNeighbours(grid.getElement(1, 1));
		assertEquals(neigh.get(0), new Empty(1, 0));
		assertEquals(neigh.get(1), new Empty(1, 2));
	}
	
	@org.junit.Test
	public void testAstarNode(){
		AstarNode nodeEmp = new AstarNode(new Empty(0, 0), null, 10, 20);
		AstarNode nodeWall = new AstarNode(new Wall(0, 0), null, 10, 20);
		assertEquals(nodeEmp.getElement(), new Empty(0, 0));
		assertEquals(nodeEmp.getPrev(), null);
		assertEquals(nodeEmp.getDistance(), 10);
		assertEquals(nodeEmp.getCost(), 20);
		assertEquals(nodeEmp.compareTo(new AstarNode(new Wall(0, 0), null, 10, 20)), 0);
		assertTrue(nodeEmp.compareTo(new AstarNode(new Wall(0, 0), null, 10, 21)) < 0);
		assertTrue(nodeEmp.compareTo(new AstarNode(new Wall(0, 0), null, 10, 19)) > 0);
		assertEquals(nodeEmp.getElement(), new Empty(0, 0));
		assertEquals(nodeWall.getElement(), new Wall(0, 0));
		assertEquals((new AstarNode(new Empty(1, 1), nodeWall, 1, 2)).getPrev(), nodeWall);
		nodeWall.setPrev(nodeEmp);
		assertEquals(nodeWall.getPrev(), nodeEmp);
	}
	
	@org.junit.Test
	public void testAstarAlg(){
		WorldGrid grid = new WorldGrid(3, 3);
		List<WorldElement> path = AstarAlg.findPath(new Empty(0, 0), new Empty(2, 2), grid);
		List<WorldElement> checkpath = new LinkedList<WorldElement>();
		checkpath.add(new Empty(0, 0));
		checkpath.add(new Empty(0, 1));
		checkpath.add(new Empty(0, 2));
		checkpath.add(new Empty(1, 2));
		checkpath.add(new Empty(2, 2));
		assertEquals(path, checkpath);
		
		grid.setElement(new Wall(0, 1));
		grid.setElement(new Wall(1, 1));
		grid.setElement(new Wall(2, 1));
		
		path = AstarAlg.findPath(new Empty(0, 0), new Empty(2, 2), grid);
		checkpath = new LinkedList<WorldElement>();
		assertEquals(path, checkpath);
		
		path = AstarAlg.findPath(new Empty(0, 0), new Empty(3, 3), grid);
		checkpath = new LinkedList<WorldElement>();
	}
}
