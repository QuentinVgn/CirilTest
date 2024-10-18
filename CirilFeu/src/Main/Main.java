package Main;

import Forest.Forest;

public class Main {
    public static void main(String[] args) {
        // Crée la forêt
        Forest forest = new Forest();

        // Lance la simulation
        Simulation simulator = new Simulation(forest);
        simulator.run();
    }
}
