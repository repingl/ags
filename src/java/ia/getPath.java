package ia;

import java.util.List;
import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.ListTermImpl;
import jason.asSyntax.NumberTermImpl;
import jason.asSyntax.Term;
import world.World;
import worldElement.WorldElement;


/** Interna akcia, ktora najde cestu pre agenta.
 * Syntax:
 * ia.getPath(x,y,xGoal,yGoal,Path).
 * x je startovacia suradnica x (cislo, povinne)
 * y je startovacia suradnica y (cislo, povinne)
 * xGoal je cielova suradnica x (cislo, povinne)
 * yGoal je cielova suradnica y (cislo, povinne)
 * Path je premenna, ktora bude unifikovana so zoznamom objektov po ceste. Ma tvar [x1,y1,x2,y2,...,xGoal,yGoal].
 * (premenna, povinna)
 * 
 * @author jakub */
@SuppressWarnings("serial")
public class getPath extends DefaultInternalAction{
	
	@Override
	public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception{
		try{
			int x = new Integer(args[0].toString());
			int y = new Integer(args[1].toString());
			int xGoal = new Integer(args[2].toString());
			int yGoal = new Integer(args[3].toString());
			
			World world = World.getInstance();
			List<WorldElement> path = world.getPath(x, y, xGoal, yGoal);
			ListTermImpl result = new ListTermImpl();
			for(WorldElement e : path){
				System.out.println(e);
				result.add(new NumberTermImpl(e.getRow()));
				result.add(new NumberTermImpl(e.getColumn()));
			}
			un.unifies(result, args[4]);
		}catch(ArrayIndexOutOfBoundsException e){
			System.err.println("Term array out of bounds.");
			return false;
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
}
