package viceCity.models.players;

import viceCity.repositories.interfaces.GunRepository;

public class MainPlayer extends BasePlayer {
    private GunRepository gunRepository;
    public MainPlayer () {
        super ("Tommy Vercetti",100);
    }

}
