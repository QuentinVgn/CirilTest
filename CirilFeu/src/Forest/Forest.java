package Forest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Utils.Config;
import Utils.Position;

public class Forest {
	private Case[][] grid;
	private int height = Config.height;
	private int width = Config.width;
	private double prob = Config.prob;
	private Position burn = Config.burn;
	private Random random;
	
	 public Forest() {
	        this.grid = new Case[height][width];
	        this.random = new Random();
	        initializeForest();
	    }
	 
	    // Enflamme une case
	    public void ignite(int x, int y) {
	        grid[x][y].changeState(1);
	    }
	    
	    //Créé la forêt initiale
	    private void initializeForest() {
	        for (int i = 0; i < height; i++) {
	            for (int j = 0; j < width; j++) {
	                grid[i][j] = new Case(0, new Position(i, j));
	            }
	        }
	        ignite(burn.getX(), burn.getY());
	    }
	    
	    //Avance d'un tour
	    public void step() {
	    	List<Position> willBurn = new ArrayList<Position>();
	        for (int i = 0; i < height; i++) {
	            for (int j = 0; j < width; j++) {
	                Case current = grid[i][j];
	                if (current.getState() == 1) {
	                    // récupère les voisins dans une liste pour les brûler à la fin du tour
	                    willBurn.addAll(current.getVoisin(current.pos, height, width));
	                    
	                    current.changeState(2);
	                }
	            }
	        }
	        spreadFire(willBurn);
	    }

	    
	    // Propage le feu aux voisins
	    private void spreadFire(List<Position> willBurn) {
	        for (Position c : willBurn) {
	            if (c != null && random.nextFloat() < prob && grid[c.getX()][c.getY()].getState()==0) {       
	            	ignite(c.getX(), c.getY());
	            }
	        }
	    }

	    // Affiche la forêt
	    public void display() {
	        for (int i = 0; i < height; i++) {
	            for (int j = 0; j < width; j++) {
	                int state = grid[i][j].getState();
	                if (state == 0) {
	                    System.out.print("0");
	                } else if (state == 1) {
	                    System.out.print("1");
	                } else {
	                    System.out.print("2");
	                }
	            }
	            System.out.println();
	        }
	        System.out.println();
	    }

	    // Vérifie si la forêt brule encore
	    public boolean isBurning() {
	        for (int i = 0; i < height; i++) {
	            for (int j = 0; j < width; j++) {
	                if (grid[i][j].getState() == 1) {
	                    return true;
	                }
	            }
	        }
	        return false;
	    }

}
