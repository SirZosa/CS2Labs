public class Question{
    //atributes for the questions
    private String description;
    private String[] options;
    private int solution;

    Question(){}

    //constructor
    public Question(String description, String[] options, int solution){
        this.description = description;
        this.options = options;
        this.solution = solution;
    }

    //getters and setters
    public String getDescription(){
        return this.description;
    }

    public String[] getOptions(){
        return this.options;
    }

    public int getSolution(){
        return this.solution;
    }

    public boolean isCorrect(int answer){
        return answer == this.solution;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setOptions(String[] options){
        this.options = options;
    }

    public void setSolution(int solution){
        this.solution = solution;
    }

    //display the information
    public void displayInformation(){
        System.out.println(description);
        System.out.println("1: " + options[0]);
        System.out.println("2: " + options[1]);
        System.out.println("3: " + options[2]);
        System.out.println("4: " + options[3]);
    }
}