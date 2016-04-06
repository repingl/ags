rozhled(3).
start.

+step(X): start <- 
	?grid_size(A,B);?rozhled(R);-start;+go(R,R);+search;+right(A-2*R-1);do(skip).

// Ready on resource position -> done picking or not?
+step(X): free & fetch & ready & savepos(Xp,Yp) <-
	-free;-fetch;-ready[source(aFast)];+go(Xp,Yp);-savepos(Xp,Yp);+search;do(skip).
+step(X): free & fetch <-
	do(skip).
	
// Fetch wood/gold: interrupt search(-search), save pos for continuation,
// disable interrupt(-free)
+step(X): free & wood(Xw,Yw) & pos(Xp,Yp) <- 
	+savepos(Xp,Yp);+fetch;+go(Xw,Yw);-search;-free;
	.send(aFast, tell, go(Xw,Yw));do(skip).
+step(X): free & gold(Xg,Yg) & pos(Xp,Yp) <- 
	+savepos(Xp,Yp);+fetch;+go(Xg,Yg);-search;-free;
	.send(aFast, tell, go(Xg,Yg));do(skip).

// Search right -> down -> left -> down -> again
+step(X): free & search & pos(Xp,Yp) & right(P) & P > 0 <- 
	-right(P);+right(P-1);do(right).
+step(X): free & search & pos(Xp,Yp) & right(P) & P == 0 <- 
	?rozhled(R);-right(P);+down(2*R);do(down).
+step(X): free & search & pos(Xp,Yp) & down(D) & D > 0 <- 
	-down(D);+down(D-1);do(down).
+step(X): free & search & pos(Xp,Yp) & down(D) & D == 0 & 
grid_size(A,B) & rozhled(R) & Xp==R <- 
	-down(D);+right(A-2*R-2);do(right).
+step(X): free & search & pos(Xp,Yp) & down(D) & D == 0 & 
grid_size(A,B) & rozhled(R) & Xp==(A-R-1) <- 
	-down(D);+left(A-2*R-2);do(left).
+step(X): free & search & pos(Xp,Yp) & left(L) & L > 0 <- 
	-left(L);+left(L-1);do(left).
+step(X): free & search & pos(Xp,Yp) & left(L) & L == 0 <- 
	?rozhled(R);-left(P);+down(2*R);do(down).
	
// Navigating through map.
+step(X): go(Xc,Yc) & pos(Xc,Yc) <- 
	-go(Xc,Yc);+free;do(skip).
+step(X): go(Xc,Yc) & pos(Xp,Yp) & Yc>Yp & math.abs(Xc-Xp)<=(Yc-Yp) <- 
	do(down).
+step(X): go(Xc,Yc) & pos(Xp,Yp) & Yc<Yp & math.abs(Xc-Xp)<=(Yp-Yc) <- 
	do(up).
+step(X): go(Xc,Yc) & pos(Xp,Yp) & Xc>Xp & math.abs(Yc-Yp)<=(Xc-Xp) <- 
	do(right).
+step(X): go(Xc,Yc) & pos(Xp,Yp) & Xc<Xp & math.abs(Yc-Yp)<=(Xp-Xc) <- 
	do(left).

// Nothing to do.
+step(X) <- do(skip).
	
