package viceCity.core.interfaces;

import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.repositories.interfaces.GunRepository;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller{
    private static final MainPlayer mainPlayer=new MainPlayer ();
    GangNeighbourhood gangNeighbourhood=new GangNeighbourhood ();
    GunRepository gunRepository;
    @Override
    public String addPlayer (String name) {
        CivilPlayer civilPlayer=new CivilPlayer (name);
        return String.format (PLAYER_ADDED,name);
    }

    @Override
    public String addGun (String type,String name) {
        if(type.equals ("Pistol")){
            Gun gun=new Pistol (name);
            gunRepository.add (gun);
            return String.format (GUN_ADDED,name,type);

        }else if (type.equals ("Rifle")){
            Gun gun=new Rifle (name);
            gunRepository.add (gun);
            return String.format (GUN_ADDED,name,type);
        }else return String.format (GUN_TYPE_INVALID);
    }

    @Override
    public String addGunToPlayer (String name) {
        if(gunRepository.getModels ().isEmpty ()){
            return GUN_QUEUE_IS_EMPTY;
        }if(name.equals ("Vercetti")){
            //mainPlayer.getGunRepository ().add (gunRepository.getModels ().stream().peek ());
            //gunRepository.getModels ()
            return String.format (GUN_ADDED_TO_MAIN_PLAYER,gunRepository.find ("GUn"),"Tommy Vercetti");
        }else if(!gangNeighbourhood.getPlayers ().contains (name)){
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        }else //add civil weapon into repo;
        return String.format ( GUN_ADDED_TO_CIVIL_PLAYER,gunRepository.find ("GUn"),name);
    }

    @Override
    public String fight () {

        return String.format ( "A fight happened:%n"+
        "Tommy live points: %s!%n"+
        "Tommy has killed: {dead civil players} players!%n"+
        "Left Civil Players: {civil players count}!",mainPlayer.getLifePoints ());

    }
}
