// Agent testAgent in project agsgit

/* Initial beliefs and rules */
/* Initial goals */

!start.

/* Plans */

+!start : true <- 
	?grid_size(R,C);
	ia.init(R,C);
	?depot(X,Y);
	ia.setElement(depot,X,Y);
	ia.setElement(wall,1,2);
	ia.getPath(1,1,X,Y,Path);
	+path(Path).
