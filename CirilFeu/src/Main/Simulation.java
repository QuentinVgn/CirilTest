package Main;

import Forest.Forest;

public class Simulation {
	private Forest forest;

    public Simulation(Forest forest) {
        this.forest = forest;
    }

    public void run() {
        while (forest.isBurning()) {
            forest.display();
            forest.step();
        }

        System.out.println("Simulation terminée");
    }
}
