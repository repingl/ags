free.

// Request for help.
+step(X): go(Xc,Yc) & free <- 
	-free;+gonow(Xc,Yc);-go(Xc,Yc)[source(aSlow)];do(skip);do(skip);do(skip).
+step(X): go(Xc,Yc) <- 
	+gonext(Xc,Yc);-go(Xc,Yc)[source(aSlow)];do(skip);do(skip);do(skip).

// Another request when done with the last one.
+step(X): gonext(Xc,Yc) & free <- 
	-free;-gonext(Xc,Yc);+gonow(Xc,Yc);do(skip);do(skip);do(skip).

// Ready on position - drop if depot | pick if resource
+step(X): gonow(Xs,Ys) & pos(Xs,Ys) & depot(Xs, Ys) <- 
	-gonow(Xd,Yd);+free;do(drop).
+step(X): gonow(Xc,Yc) & pos(Xp,Yp) & depot(Xd, Yd) & (Xc\==Xd | Yc\==Yd) &
Xp==Xc & Yp==Yc <- 
	do(pick);.send(aSlow, tell, ready);-gonow(Xc,Yc);+ready.
+step(X): ready & carrying_wood(W) & carrying_gold(G) & depot(Xd, Yd) &
(W\==0 | G\==0) <- 
	+gonow(Xd,Yd);-ready;do(skip);do(skip);do(skip).
+step(X): ready & depot(Xd, Yd) <- 
	do(pick).

// Navigating through map.
+step(X): gonow(Xc,Yc) & pos(Xp,Yp) & Yc>Yp & math.abs(Xc-Xp)<=(Yc-Yp) <- 
	do(down);do(skip);do(skip).
+step(X): gonow(Xc,Yc) & pos(Xp,Yp) & Yc<Yp & math.abs(Xc-Xp)<=(Yp-Yc) <- 
	do(up);do(skip);do(skip).
+step(X): gonow(Xc,Yc) & pos(Xp,Yp) & Xc>Xp & math.abs(Yc-Yp)<=(Xc-Xp) <- 
	do(right);do(skip);do(skip).
+step(X): gonow(Xc,Yc) & pos(Xp,Yp) & Xc<Xp & math.abs(Yc-Yp)<=(Xp-Xc) <- 
	do(left);do(skip);do(skip).

// Nothing to do.
+step(X) <- do(skip);do(skip);do(skip).



