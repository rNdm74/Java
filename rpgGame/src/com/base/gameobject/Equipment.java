package com.base.gameobject;

import com.base.gameobject.item.EquippableItems;

/**
 * Created by rNdm.
 */
public class Equipment {
    private EquippableItems[] items;
    private Inventory inventory;

    public Equipment(Inventory inventory){
        this.inventory = inventory;

        items = new EquippableItems[EquippableItems.NUM_SLOTS];
    }

    public boolean equip(EquippableItems item){
        int index = item.getSlot();

        if(items[index] == null){
            if(unEquip(index)){
                return false;
            }
        }

        items[index] = item;
        return true;
    }

    public boolean unEquip(int index){
        // Take current index and send to inventory
        if(inventory.add(items[index])){
            items[index] = null;
            return true;
        }

        return false;
    }
}
