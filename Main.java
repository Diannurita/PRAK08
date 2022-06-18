
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws ClassNotFoundException{
        
        Titan newTitan = new Titan(200, 45, 0);
        Magician newMagician = new Magician(100, 60, 10);
        Warrior newWarrior = new Warrior(80, 25, 30);
        Healer newHealer = new Healer(70, 10, 10);
        String nama;
        int pilRole;
        System.out.println("Selamat datang di game Defend FILKOM !");
        System.out.print("Silahkan masukkan nama player : ");
        nama = sc.nextLine();
        pilRole = getKarakter(nama);
        System.out.println("Selamat datang, "+ nama +" !");
        getTurn(pilRole, nama, newTitan, newMagician, newWarrior, newHealer);
    }
    public static int getKarakter(String nama){
        int pilRole = 0;
        do {
            try {
                   System.out.println("Silahkan pilih karakter yang anda inginkan :");
                   System.out.println("1. Magician");
                   System.out.println("2. Healer");
                   System.out.println("3. Warrior");
                   pilRole = sc.nextInt();
                   if(pilRole <=0 || pilRole > 3){
                        throw new Exception("Nomor pilihan tidak ada !");
                   }
               } catch (InputMismatchException e) {
                     System.out.println("Tolong masukkan angka !");
               } catch (Exception e) {
                      System.out.println(e.getMessage());
             }
             sc.nextLine();
        } while (pilRole <=0 || pilRole > 3);
        return pilRole;
    }
    public static void getTurn (int pilRole, String nama, Titan newTitan, Magician newMagician, Warrior newWarrior, Healer newHealer)throws ClassNotFoundException{
        int i = 1;
        if(pilRole == 1){
            while(newMagician.getHP() > 0 && newTitan.getHP() > 0){
                System.out.println("============ TURN "+ (i++) +" ============");
                if(newTitan.attack() == true){
                    newTitan.receiveDamage(newMagician.getAttack());
                }
                if(newMagician.attack() == true){
                    newMagician.receiveDamage(newTitan.getAttack());
                }
                System.out.println("Enemy's HP : "+ newTitan.getHP());
                System.out.println(nama + "'s HP : "+ newMagician.getHP());
            }
            if(newMagician.getHP() > newTitan.getHP()){
                System.out.println(nama + " menang");
            }else{
                System.out.println("Enemy's menang");
            }
            newMagician.info();
            newTitan.info();
        }else if(pilRole == 2){
            while(newHealer.getHP() > 0 && newTitan.getHP() > 0){
                System.out.println("============ TURN "+ (i++) +" ============");
                if(newTitan.attack() == true){
                    newTitan.receiveDamage(newHealer.getAttack());
                }
                if(newHealer.attack() == true){
                    newHealer.receiveDamage(newTitan.getAttack());
                }
                System.out.println("Enemy's HP : "+ newTitan.getHP());
                System.out.println(nama + "'s HP : "+ newHealer.getHP());
            }
            if(newHealer.getHP() > newTitan.getHP()){
                System.out.println(nama + " menang");
            }else{
                System.out.println("Enemy's menang");
            }
            newHealer.info();
            newTitan.info();
        }else if(pilRole == 3){
            while(newWarrior.getHP() > 0 && newTitan.getHP() > 0){
                System.out.println("============ TURN "+ (i++) +" ============");
                if(newTitan.attack() == true){
                    newTitan.receiveDamage(newWarrior.getAttack());
                }
                if(newWarrior.attack() == true){
                    newWarrior.receiveDamage(newTitan.getAttack());
                }
                System.out.println("Enemy's HP : "+ newTitan.getHP());
                System.out.println(nama + "'s HP : "+ newWarrior.getHP());
            }
            if(newWarrior.getHP() > newTitan.getHP()){
                System.out.println(nama + " menang");
            }else{
                System.out.println("Enemy's menang");
            }
            newWarrior.info();
            newTitan.info();
        }
    }
}
