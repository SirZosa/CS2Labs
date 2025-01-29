import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class QuestionLoader {

    public static Question[] getQuestions(String filePath){
        //read file
        File data = new File(filePath);

        //get number of questions on file
        int numOfQuestions = numOfLines(data);

        //initialize an array of questions
        Question[] questionsArray = new Question[numOfQuestions];
        
        try{
            for(int i = 0; i< questionsArray.length; i++){

                //new question object for the index
                questionsArray[i] = new Question();
                Scanner myScanner = new Scanner(data);
                
                //Skip the number of lines already readed starting with the first question data
                for(int j = 0; j< i; j++){
                    if(myScanner.hasNextLine()){
                        myScanner.nextLine();
                    }
                }

                //Separate each atribute and store them into an array
                String[] atributeArr = myScanner.nextLine().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                //assigning values
                //atribute[0] = question
                //atribute[1-4] = options
                //atribute[5] = correct answer
                questionsArray[i].setDescription(atributeArr[0]);
                String[] options = {atributeArr[1],atributeArr[2],atributeArr[3], atributeArr[4]};
                questionsArray[i].setOptions(options);
                questionsArray[i].setSolution(Integer.parseInt(atributeArr[5]));
                myScanner.close();
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }
        return questionsArray;
    }

    private static int numOfLines(File arr){
        //count the number of lines on the txt file
        try{
            Scanner lineScanner = new Scanner(arr);
            int lines = 0;
            while (lineScanner.hasNextLine()) {
                lineScanner.nextLine();
                lines++;
            }
            lineScanner.close();
            return lines;
        } catch(FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
            return 0;
        }
    }
}
