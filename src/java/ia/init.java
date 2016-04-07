// Internal action code for project agsgit

package ia;

import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;
import world.World;


/** Inicializuje mriezku.
 * Syntax:
 * ia.init(r,c).
 * r je pocet riadkov mriezky (cislo, povinne)
 * c je pocet stlpcov mriezky (cislo, povinne)
 * 
 * @author jakub */
@SuppressWarnings("serial")
public class init extends DefaultInternalAction{
	
	@Override
	public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception{
		try{
			World.getInstance().init(new Integer(args[0].toString()), new Integer(args[1].toString()));
		}catch(ArrayIndexOutOfBoundsException e){
			System.err.println("Term array out of bounds.");
			return false;
		}catch(Exception e){
			return false;
		}
		
		return true;
	}
}
