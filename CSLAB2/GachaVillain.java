public class GachaVillain {
    private String Name;
    private String Rarity;
    private int Hp;
    private int Attack;
    private int Defense;
    private int Speed;

    GachaVillain(){}

    GachaVillain(String Name, String Rarity, int Hp, int Attack, int Defense, int Speed){
        this.Name = Name;
        this.Rarity = Rarity;
        this.Hp = Hp;
        this.Attack = Attack;
        this.Defense = Defense;
        this.Speed = Speed;
    }

    String getName(){
        return Name;
    }

    void setName(String arg){
        Name = arg;
    }

    String getRarity(){
        return Rarity;
    }

    void setRarity(String arg){
        Rarity = arg;
    }

    int getHp(){
        return Hp;
    }

    void setHp(int arg){
        Hp = arg;
    }

    int getAttack(){
        return Attack;
    }

    void setAttack(int arg){
        Attack = arg;
    }

    int getDefense(){
        return Defense;
    }

    void setDefense(int arg){
        Defense = arg;
    }

    int getSpeed(){
        return Speed;
    }

    void setSpeed(int arg){
        Speed = arg;
    }

    void printGachaVillain(){
        System.out.println(Name + " " + Rarity + " " + Hp + " " + Attack + " " + Defense + " " + Speed);
    }
}
