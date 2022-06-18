import java.util.*;

public class Titan extends Character {
    
    double random;
    double min = 1;
    double max = 10 - min;
    
    Titan(int HP, int attack, int defense){
        setHP(HP);
        setAttack(attack);
        setDefense(defense);
    }
    
    @Override
    public boolean attack() {
        
        random = ((Math.random()* max) + min);
        if(random < 4.0 && random >= 1.0){
            return true;
        }
        return false;
    }
    
    @Override
    public void receiveDamage(int damage) {

        if(damage > getDefense()){
            damage = damage - getDefense();
            setHP((getHP() - damage));
            if(getHP() < 0){
                setHP(getAttack() + (-(getAttack())));
            }
        }
    }
    
    public void info() throws ClassNotFoundException
    {
        Class myClass = Class.forName("Titan");
        System.out.println("============ MUSUH ============");
        System.out.println("------------ STATUS -----------");
        System.out.println("Role\t\t: " + myClass.getSimpleName());
        System.out.println("HP\t\t\t: " + getHP());
        System.out.println("Attack\t\t: " + getAttack());
        System.out.println("Defense\t\t: " + getDefense());
    }
}
