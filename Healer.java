
public class Healer extends Character{
    double random;
    double min = 1;
    double max = 10 - min;
    int a = 0;
    
    Healer(int HP, int attack, int defense){
        setHP(HP);
        setAttack(attack);
        setDefense(defense);
    }
    
    @Override
    public boolean attack() {
        a++;
        if(a == 2){
            a = 0;
            heal();
        }
        random = ((Math.random()* max) + min);
        if(random < 8.5 && random >= 1.0){
            return true;
        }
        return false;
    }
    
    public void receiveDamage(int damage){
        if(damage > getDefense()){
            damage = damage - getDefense();
            setHP((getHP() - damage));
            if(getHP() < 0){
                setHP(getAttack() + (-(getAttack())));
            }
        }
    }
    
    public void heal(){
        setHP(getHP() + 25);
    }
    
    public void info() throws ClassNotFoundException
    {
        Class myClass = Class.forName("Healer");
        System.out.println("============ PLAYER ============");
        System.out.println("------------ STATUS -----------");
        System.out.println("Role\t\t: " + myClass.getSimpleName());
        System.out.println("HP\t\t\t: " + getHP());
        System.out.println("Attack\t\t: " + getAttack());
        System.out.println("Defense\t\t: " + getDefense());
    }
}
