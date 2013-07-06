package com.base.gameobject;

import com.base.engine.GameObject;
import com.base.game.Delay;
import com.base.game.Game;
import com.base.game.Time;
import com.base.game.Util;

import java.util.ArrayList;

/**
 * Created by rNdm.
 */
public class Enemy extends StatObject {
    public static final float DAMPING = 0.25f;

    private StatObject target; //Basic AI

    private float sightRange;
    private float attackRange;

    private Delay attackDelay;
    private int attackDamage;


    public Enemy(int level){
        stats = new Stats(level, false);
        target = null;

        sightRange = 128f;
        attackRange = 48;
        attackDamage = 1;

        attackDelay = new Delay(500);
        attackDelay.terminate();
    }

    @Override
    public void update(){
        if(target == null){
            look();
        }
        else{
            if(Util.LineOfSight(this, target) &&
               Util.dist(x, y, getTarget().getX(), getTarget().getY()) <= attackRange){

                if(attackDelay.isOver()) attack();
            }
            else{
                chase();
            }
        }

        if(stats.getCurrentHealth() <= 0){
            death();
        }
    }

    protected void attack(){
        getTarget().damage(getAttackDamage());
        attackDelay.restart();
    }

    protected void death(){
        remove();
    }

    protected void look(){
        ArrayList<GameObject> objects = Game.sphereCollide(x, y, sightRange);

        for(GameObject go: objects){
            if(go.getType() == PLAYER_ID){
                setTarget((StatObject)go);
            }
        }
    }

    protected void chase(){
        float speedX = (getTarget().getX() - x);
        float speedY = (getTarget().getY() - y);

        float maxSpeed = getStats().getSpeed() * DAMPING;

        if(speedX > maxSpeed) speedX = maxSpeed;
        if(speedX < -maxSpeed) speedX = -maxSpeed;

        if(speedY > maxSpeed) speedY = maxSpeed;
        if(speedY < -maxSpeed) speedY = -maxSpeed;

        x += speedX * Time.getDelta();
        y += speedY * Time.getDelta();
    }

    protected void idle(){
    }

    public void setTarget(StatObject object){
        target = object;
    }

    public StatObject getTarget(){
        return target;
    }

    public Stats getStats(){
        return stats;
    }

    public int getAttackDamage(){
        return attackDamage;
    }

    public void setAttackRange(int range){
        attackRange = range;
    }

    public void setSightRange(int range){
        sightRange = range;
    }

    public void setAttackDelay(int time){
        attackDelay = new Delay(time);
        attackDelay.terminate();
    }

    public void setAttackDamage(int amt){
        attackDamage = amt;
    }
}
