 abstract class Character {
     private int defense;
     private int attack;
     private int HP;
    
    public abstract boolean attack();
    
    public void receiveDamage(int damage){
        
    }
    
    public void info() throws ClassNotFoundException {
        
    }
    
    public void setDefense(int defense){
        this.defense = defense;
    }
    
    public void setAttack(int attack){
        this.attack = attack;
    }
    
    public void setHP(int HP){
        this.HP = HP;
    }
    
    public int getDefense(){
        return defense;
    }
    
    public int getAttack(){
        return attack;
    }
    
    public int getHP(){
        return HP;
    }
}
