package viceCity.models.players;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.Repository;

import static viceCity.common.ExceptionMessages.PLAYER_LIFE_POINTS_LESS_THAN_ZERO;
import static viceCity.common.ExceptionMessages.PLAYER_NULL_USERNAME;

public abstract class BasePlayer implements Player {
    private String name;
    private int lifePoints;
    private Repository<Gun> gunRepository;

    protected BasePlayer (String name,int lifePoints) {
        this.setName (name);
        this.setLifePoints (lifePoints);
    }

    private  void setLifePoints (int lifePoints){
        if(lifePoints<0){
            throw new IllegalArgumentException (PLAYER_LIFE_POINTS_LESS_THAN_ZERO);
        }else this.lifePoints=lifePoints;
    }

    private void setName (String name) {
        if (name == null || name.trim ().isEmpty ()) {
            throw new NullPointerException (PLAYER_NULL_USERNAME);
        }
        this.name = name;
    }

    @Override
    public String getName () {
        return this.name;
    }

    @Override
    public int getLifePoints () {
        return this.lifePoints;
    }

    @Override
    public boolean isAlive () {
        return this.getLifePoints () > 0;
    }

    @Override
    public Repository<Gun> getGunRepository () {
        return this.gunRepository;
    }

    @Override
    public void takeLifePoints (int points) {
        if (this.lifePoints < points) {
            this.lifePoints -= points;
        } else {
            this.isAlive ();
        }
    }
}
