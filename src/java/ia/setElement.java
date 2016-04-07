// Internal action code for project agsgit

package ia;

import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;
import world.World;
import worldObjects.Wall;


/** Nastavi element na danu poziciu.
 * Syntax:
 * ia.setElement(type,r,c).
 * type je typ objektu, pre stenu je to wall (term, povinny)
 * r je riadok objektu v mriezke (cislo, povinne)
 * c je stlpec objektu v mriezke (cislo, povinne)
 * 
 * @author jakub */
@SuppressWarnings("serial")
public class setElement extends DefaultInternalAction{
	
	@Override
	public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception{
		try{
			String type = args[0].toString();
			if(type.equals("wall")){
				World	.getInstance()
						.setElement(new Wall(new Integer(args[1].toString()), new Integer(args[2].toString())));
			}else{
				throw new Exception("Wrong item name: " + type);
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.err.println("Term array out of bounds.");
			return false;
		}catch(Exception e){
			System.err.println(e);
			return false;
		}
		
		// everything ok, so returns true
		return true;
	}
}
