package MilitaryEllite.impl;

import MilitaryEllite.Interfaces.LieutenantGeneral;
import MilitaryEllite.Interfaces.Private;

import java.util.ArrayList;
import java.util.Collection;

public class LieutenantGeneralImpl implements LieutenantGeneral {
    private Collection<Private> privates;

    public LieutenantGeneralImpl () {
        this.privates = new ArrayList<> ();
    }

    @Override
    public void addPrivate (Private priv) {
        this.privates.add (priv);
    }
}
