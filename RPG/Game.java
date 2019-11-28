package RPG;


import java.util.Scanner;

public class Game {

    //méthodes
    public void clrscr(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public void fight(Personnage p, Mob e, Scanner sc) throws InterruptedException{
        System.out.println("Battle Started !\n");

        while(e.getHp() > 0 && p.getHp() > 0) {
            System.out.println("Veuillez entrer une action ( atk | heal):");
            String action = sc.next();

            switch (action){
                case "atk":
                    p.attaque(e);
                    System.out.println(p.getUsername() + " attaque");
                    System.out.println("Hp restants mob: "+ e.getHp() + "\n");
                    Thread.sleep(2000);
                    break;
                case "heal":
                    p.soin(5);
                    System.out.println("player1 se soigne ! Hp "+ p.getUsername() +": "+  p.getHp() + "\n");
                    break;
            }

            if(e.getHp() <= 0) {
                System.out.println("Mob a été vaincu !");
                e=null;
                break;
            }
            else {
                e.attaque(p);
                System.out.println("l'enemmi attaque");
                System.out.println("Hp restants "+ p.getUsername() + " :" + p.getHp() + "\n");
                Thread.sleep(1000);
            }

        }


        if(p.getHp() <= 0) {
            System.out.println("\nYou lost !");
        }
        else {
            e = null; // Mob éliminé
            System.out.println("\nYou won !");
            System.out.println("You gain 60 exp\n");
            p.expUp(60);
            System.out.println("Niveau: "+p.getNiveau()+ ", "+ p.getExp()+"/"+p.getExpLvlUp());
        }
    }

    public static void main(String[] args){

        Game g = new Game();

        Boolean gameOver = false;

        Scanner scan = new Scanner(System.in);
        System.out.println("Quel type de personnage voulez-vous créer? (assassin, mage ou aventurier)");
        String choixPerso = scan.nextLine().toLowerCase();
        while( !"assassin".equals(choixPerso) && !"mage".equals(choixPerso) && !"aventurier".equals(choixPerso) ){
            System.out.println("choix incorrect, choissez parmis assassin, mage ou aventurier");
            choixPerso = scan.nextLine().toLowerCase();
        }

        String choixUserName ="";
        String confirm ="";
        while(!"oui".equals(confirm)) {
            System.out.println("Choisissez un username");
            choixUserName = scan.nextLine();
            System.out.println("Votre username est " + choixUserName + ", Cela vous convient-il?(oui ou non)");
            confirm = scan.nextLine().toLowerCase();
        }

        Personnage playercharacter = new Aventurier("");
        switch (choixPerso){
            case "assassin":
                playercharacter =new Assassin(choixUserName);
                break;
            case "mage":
                playercharacter=new Mage(choixUserName);
                break;
            case"aventurier":
                playercharacter = new Aventurier(choixUserName);
                break;
        }
        g.clrscr();
        Map map = new Map(playercharacter);
        System.out.println("Vous êtes le X l'ennemi est le O");
        map.drawMapConsole();
        while (!gameOver) {
            //déplacement avec zqsd, enter à chaque fois
            String input = scan.nextLine();
            switch (input){
                case "s":
                    playercharacter.move('y', 1);
                    break;
                case"q":
                    playercharacter.move('x',-1);
                    break;
                case "z":
                    playercharacter.move('y',-1);
                    break;
                case "d":
                    playercharacter.move('x', 1);
                    break;
                case"!kill":
                    playercharacter.setHp(0);
                    break;
            }
            if(playercharacter.getPosY() < 0){
                playercharacter.setPosY(0);
            }
            if (playercharacter.getPosX() < 0){
                playercharacter.setPosX(0);
            }
            if(playercharacter.getPosY()>= map.getGround().length){
                playercharacter.setPosY(map.getGround().length-1);
            }
            if (playercharacter.getPosX() >= map.getGround()[0].length){
                playercharacter.setPosX(map.getGround()[0].length-1);
            }
            g.clrscr();
            for (int i = 0; i < map.getMobList().length ; i++) {
                Mob mob = map.getMobList()[i];
                if(mob.getPosX() == playercharacter.getPosX() && mob.getPosY() == playercharacter.getPosY() && mob.getHp() > 0 ){
                    try{g.fight(playercharacter,map.getMobList()[i], scan);}
                    catch(InterruptedException e){
                        System.out.println("Something went wrong!");
                    }
                }
            }
            g.clrscr();
            map.drawMapConsole();
            if(playercharacter.getHp() == 0){
                gameOver = true;
            }
        }
        g.clrscr();
        System.out.println("Game Over");
    }

}
