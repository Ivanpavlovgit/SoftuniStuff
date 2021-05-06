package viceCity.repositories.interfaces;

import viceCity.models.guns.Gun;

import java.util.*;


public  class GunRepository implements Repository {
    ArrayDeque<Gun> models;

    @Override
    public Collection getModels () {
        return this.models;
    }

    @Override
    public void add (Object model) {
        if (!models.contains (model)) {
            models.offer ((Gun) model);
        }
    }

    @Override
    public boolean remove (Object model) {
        return true;
    }



        @Override
        public Gun find (String name){
            return null;
        }


    }