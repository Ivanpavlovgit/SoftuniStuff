package viceCity.models.neighbourhood;

import viceCity.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GangNeighbourhood implements Neighbourhood{
    private List<Player> players;

    @Override
    public void action (Player mainPlayer,Collection<Player> civilPlayers) {
    }

    public List<Player> getPlayers () {
        return this.players;
    }
}
