package RPG;

public class Map {

    private String[][] ground;
    private Mob[] mobList;
    private Personnage perso;


    public void setGround(String[][] ground) {
        this.ground = ground;
    }
    public void setMobList(Mob[] moblist) {
        this.mobList = moblist;
    }
    public void setPerso(Personnage perso) {
        this.perso = perso;
    }


    public String[][] getGround() {
        return ground;
    }
    public Mob[] getMobList() {
        return mobList;
    }
    public Personnage getPerso() {
        return perso;
    }

    public Map(String[][] ground, Mob[] mobList, Personnage perso ){
        this.setGround(ground);
        this.setMobList(mobList);
        this.setPerso(perso);
    }

    public Map(Personnage perso){
        String[][] ground = new String[10][40];
        for (int i = 0; i < ground.length ; i++) {
            for (int j = 0; j < ground[i].length ; j++) {
                ground[i][j] = "sand";
            }
        }
        Mob[] mobs = {new Mob(50,10,"fire",(int) (Math.random() * (ground[0].length-1)), (int)(Math.random()* (ground.length-1)))};
        this.setGround(ground);
        this.setPerso(perso);
        this.setMobList(mobs);
    }

    /**
     * fonction qui affiche la map en console, le personnage est symbolisé par un X et les ennemis par un O
     */
    public void drawMapConsole(){
        boolean mobThere = false;
        for (int i = 0; i < this.getGround().length ; i++) {
            String str = "";
            for (int j = 0; j < this.getGround()[i].length; j++) {
                for (int k = 0; k < this.getMobList().length ; k++) {
                    Mob mob =this.getMobList()[k];
                    if(mob.getPosY() == i && mob.getPosX() == j && mob.getHp()>0){
                        mobThere = true;
                    }
                }
                if (this.getPerso().getPosX()==j && this.getPerso().getPosY() ==i) {
                    str += "X";
                }
                else if(mobThere){
                    str += "O";
                    mobThere = false;
                }
                else {
                    switch (this.getGround()[i][j]) {
                        case "sand":
                            str += "\u2591";
                            break;
                        case "wall":
                            str += "\u2588";
                            break;
                    }
                }
            }
            System.out.println(str);
        }
    }

}
