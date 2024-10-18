package Forest;

import java.util.ArrayList;
import java.util.List;

import Utils.Position;

public class Case {
	
	private int state;
	Position pos;
	
	public Case(int state, Position pos) {
		this.state = state;
		this.pos = pos;
	}
	
	public int getState() {
		return this.state;
	}
	
	public void changeState(int newState) {
		this.state = newState;
	}
	
	public List<Position> getVoisin(Position current, int height, int width) {
	    int x = current.getX();
	    int y = current.getY();

	    // Liste des positions voisines
	    List<Position> voisins = new ArrayList<Position>();

	    if (x - 1 >= 0) {
	        voisins.add(new Position(x - 1, y));
	    }

	    if (x + 1 < height) {
	    	voisins.add( new Position(x + 1, y));
	    }

	    if (y - 1 >= 0) {
	    	voisins.add(new Position(x, y - 1));
	    }

	    if (y + 1 < width) {
	    	voisins.add(new Position(x, y + 1));
	    }

	    return voisins;
	}

	
}
