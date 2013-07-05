package com.base.gameobject;

import com.base.engine.GameObject;
import com.base.game.Util;

/**
 * Created by rNdm.
 */
public class Enemy extends GameObject {
    protected Stats stats;
    protected GameObject target; //Basic AI

    public Enemy(int level){
        stats = new Stats(level, false);
        target = null;
    }

    @Override
    public void update(){
        if(target == null){
            look();
        }
        else{
            chase();

            if(Util.LineOfSight(this, target)) attack();
        }

        if(stats.getCurrentHealth() <= 0){
            die();
        }
    }

    protected void attack(){

    }

    protected void look(){

    }

    protected void chase(){

    }

    protected void idle(){

    }

    protected void die(){

    }

    public void setTarget(GameObject object){
        target = object;
    }

    public GameObject getTarget(){
        return target;
    }

    public Stats getStats(){
        return stats;
    }
}
