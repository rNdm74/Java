package com.base.item;

/**
 * Created by rNdm.
 */
public class PoopOfGrandur extends EquippableItems{
    public static final float SIZE = 8f;

    private int damage;

    public PoopOfGrandur(float x, float y){
        init(x, y, 1.0f, 0.5f, 0.0f, SIZE, SIZE, "The Legendary Poop Of Grandeur", WEAPON_SLOT);
        damage = 3;
    }
}
