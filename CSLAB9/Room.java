public class Room {
    //Atributes for a room
    String description;
    Question question;
    int deepLevel;
    Room left;
    Room right;

    Room(){}

    //constructor
    public Room(String description, Question question){
        this.description = description;
        this.question = question;
    }
}
