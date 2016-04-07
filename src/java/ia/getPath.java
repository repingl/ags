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
				result.add(new NumberTermImpl(e.getX()));
				result.add(new NumberTermImpl(e.getY()));
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
