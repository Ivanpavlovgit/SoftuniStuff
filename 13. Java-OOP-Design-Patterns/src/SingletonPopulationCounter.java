import java.util.HashMap;
import java.util.Map;

public class SingletonPopulationCounter implements SingletonContainer {
    private static SingletonPopulationCounter instance;
    private Map<String,Integer> populationMap;

    public static SingletonPopulationCounter getInstance () {
       //Lazy Loading
       
        if(instance!=null){
            return instance;
        }
        return instance=new SingletonPopulationCounter ();
    }


    private SingletonPopulationCounter () {
        this.populationMap = new HashMap<> ();
    }
    public void increasePopulation(String city,int increment){
        this.populationMap.putIfAbsent (city,0);
        this.populationMap.put (city,this.populationMap.get (city)+increment);
    }

    @Override
    public int getPopulation (String city) {
        return 0;
    }
}
