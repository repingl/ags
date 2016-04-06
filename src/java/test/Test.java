package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.Point;
import worldObjects.Border;
import worldObjects.Deposit;
import worldObjects.Empty;
import worldObjects.Glasses;
import worldObjects.Gold;
import worldObjects.Nothing;
import worldObjects.Wall;
import worldObjects.Wood;


public class Test{
	
	@org.junit.Test
	public void testCanMove(){
		assertFalse((new Border(0, 0).canMove()));
		assertTrue((new Deposit(0, 0).canMove()));
		assertTrue((new Empty(0, 0).canMove()));
		assertTrue((new Glasses(0, 0).canMove()));
		assertTrue((new Gold(0, 0).canMove()));
		assertFalse((new Nothing(0, 0).canMove()));
		assertFalse((new Wall(0, 0).canMove()));
		assertTrue((new Wood(0, 0).canMove()));
	}
	
	@org.junit.Test
	public void testPosition(){
		assertEquals((new Border(0, 0)).getPosition(), new Point(0, 0));
		assertEquals((new Deposit(1, 1)).getPosition(), new Point(1, 1));
		assertEquals((new Empty(2, 2)).getPosition(), new Point(2, 2));
		assertEquals((new Glasses(3, 3)).getPosition(), new Point(3, 3));
		assertEquals((new Gold(4, 4)).getPosition(), new Point(4, 4));
		assertEquals((new Nothing(5, 5)).getPosition(), new Point(5, 5));
		assertEquals((new Wall(6, 6)).getPosition(), new Point(6, 6));
		assertEquals((new Wood(7, 7)).getPosition(), new Point(7, 7));
		
		assertEquals((new Border(0, 0)).getPosition(), new Point(0, 0));
		assertEquals((new Deposit(1, 1)).getPosition(), new Point(1, 1));
		assertEquals((new Empty(2, 2)).getPosition(), new Point(2, 2));
		assertEquals((new Glasses(3, 3)).getPosition(), new Point(3, 3));
		assertEquals((new Gold(4, 4)).getPosition(), new Point(4, 4));
		assertEquals((new Nothing(5, 5)).getPosition(), new Point(5, 5));
		assertEquals((new Wall(6, 6)).getPosition(), new Point(6, 6));
		assertEquals((new Wood(7, 7)).getPosition(), new Point(7, 7));
	}
	
	@org.junit.Test
	public void testEquality(){
		assertEquals(new Border(0, 0), new Border(0, 0));
		assertEquals(new Deposit(0, 0), new Deposit(0, 0));
		assertEquals(new Empty(0, 0), new Empty(0, 0));
		assertEquals(new Glasses(0, 0), new Glasses(0, 0));
		assertEquals(new Gold(0, 0), new Gold(0, 0));
		assertEquals(new Nothing(0, 0), new Nothing(0, 0));
		assertEquals(new Wall(0, 0), new Wall(0, 0));
		assertEquals(new Wood(0, 0), new Wood(0, 0));
		
		assertEquals(new Border(0, 0), new Border(0, 0));
		assertEquals(new Deposit(0, 0), new Deposit(0, 0));
		assertEquals(new Empty(0, 0), new Empty(0, 0));
		assertEquals(new Glasses(0, 0), new Glasses(0, 0));
		assertEquals(new Gold(0, 0), new Gold(0, 0));
		assertEquals(new Nothing(0, 0), new Nothing(0, 0));
		assertEquals(new Wall(0, 0), new Wall(0, 0));
		assertEquals(new Wood(0, 0), new Wood(0, 0));
		assertEquals(new Nothing(), new Nothing());
		assertEquals(new Border(), new Border());
		
		assertFalse((new Border(0, 0)).equals(new Border(1, 1)));
		assertFalse((new Deposit(0, 0)).equals(new Deposit(1, 1)));
		assertFalse((new Empty(0, 0)).equals(new Empty(1, 1)));
		assertFalse((new Glasses(0, 0)).equals(new Glasses(1, 1)));
		assertFalse((new Gold(0, 0)).equals(new Gold(1, 1)));
		assertFalse((new Nothing(0, 0)).equals(new Nothing(1, 1)));
		assertFalse((new Wall(0, 0)).equals(new Wall(1, 1)));
		assertFalse((new Wood(0, 0)).equals(new Wood(1, 1)));
		
		assertFalse((new Border(0, 0)).equals(new Wood(0, 0)));
		assertFalse((new Deposit(0, 0)).equals(new Border(0, 0)));
		assertFalse((new Empty(0, 0)).equals(new Deposit(0, 0)));
		assertFalse((new Glasses(0, 0)).equals(new Empty(0, 0)));
		assertFalse((new Gold(0, 0)).equals(new Glasses(0, 0)));
		assertFalse((new Nothing(0, 0)).equals(new Gold(0, 0)));
		assertFalse((new Wall(0, 0)).equals(new Nothing(0, 0)));
		assertFalse((new Wood(0, 0)).equals(new Wall(0, 0)));
		assertFalse((new Border()).equals(new Nothing()));
	}
}
