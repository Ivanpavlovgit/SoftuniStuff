public class Main {
    public static void main (String[] args) {
        SingletonPopulationCounter counter = SingletonPopulationCounter.getInstance ();
        counter.increasePopulation ("Sofia",100);
    }
}
