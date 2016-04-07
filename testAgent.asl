// Agent testAgent in project agsgit

/* Initial beliefs and rules */

/* Initial goals */

!start.

/* Plans */

+!start : true <- 
	?grid_size(R,C);
	ia.init(R,C);
	ia.getPath(1,1,5,5).
