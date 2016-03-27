package munchkin.cards.treasures.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SamPastoriza on 3/26/16.
 */
public class ArmorSet {

    private int footgear;
    private int headgear;
    private int armor;
    private int hands;

    private Map<Armor, Integer> armourToInteger;

    public ArmorSet() {
        this.footgear = 0;
        this.headgear = 0;
        this.armor = 0;
        this.hands = 0;
        this.armourToInteger = new HashMap<>();
        initializeConversion();
    }

    private void initializeConversion() {

    }
}
