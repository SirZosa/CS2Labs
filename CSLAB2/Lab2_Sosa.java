import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Lab2_Sosa {
    public static GachaHero currentGachaHero;
    public static GachaVillain currentGachaVillain;

    // Here Students will have to Scan the Heros csv file 
    // and assign the information into a 1D array of Objects called herosArray
    // Then return that heroArray 
    public static GachaHero[] scanHero(String filename){
        //Read file
        File data = new File(filename);
        //Count number of lines in file
        int numOfHeros = numOfLines(data);
        //create an array of heroes to store hero's data
        GachaHero[] herosData= new GachaHero[numOfHeros -1];

        try{
            for(int i = 0; i< herosData.length; i++){
                //Initialize the hero object using the constructor.
                herosData[i] = new GachaHero();
                //Start scanner
                Scanner myReader = new Scanner(data);

                //Skip the number of lines already readed starting with the first hero's data
                for(int j = 0; j< i+1; j++){
                    if(myReader.hasNextLine()){
                        myReader.nextLine();
                    }
                }
                //Separate each atribute and store them into an array
                String[] atributeArr = myReader.nextLine().split(",");

                //Setting values into the hero object
                herosData[i].setName(atributeArr[0]);
                herosData[i].setRarity(atributeArr[1]);
                //stat atributes stores as integes.
                herosData[i].setHp(Integer.parseInt(atributeArr[2]));
                herosData[i].setAttack(Integer.parseInt(atributeArr[3]));
                herosData[i].setDefense(Integer.parseInt(atributeArr[4]));
                herosData[i].setSpeed(Integer.parseInt(atributeArr[5]));
                herosData[i].setMP(Integer.parseInt(atributeArr[6]));
                herosData[i].setLuck(Integer.parseInt(atributeArr[7]));
                myReader.close();
            }
        } catch(FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }
        return herosData;
    }

    // Here Students will have to Scan the Villains csv file 
    // and assign the information into a 1D array of Objects called villainsArray
    // Then return that villainarray
    public static GachaVillain[] scanVillain(String filename){
        //read file
        File data = new File(filename);
        //count numbers of lines in file
        int numOfVillains = numOfLines(data);
        //create an array of villains to store villain's data
        GachaVillain[] villainsData= new GachaVillain[numOfVillains -1];

        try{
            for(int i = 0; i< villainsData.length; i++){
                //Initialize the villain object using the constructor.
                villainsData[i] = new GachaVillain();
                //Start scanner
                Scanner myReader = new Scanner(data);

                //Skip the number of lines already readed starting with the first hero's data
                for(int j = 0; j< i+1; j++){
                    if(myReader.hasNextLine()){
                        myReader.nextLine();
                    }
                }
                //Separate each atribute and store them into an array
                String[] atributeArr = myReader.nextLine().split(",");

                //Setting values into the villain object
                villainsData[i].setName(atributeArr[0]);
                villainsData[i].setRarity(atributeArr[1]);
                villainsData[i].setHp(Integer.parseInt(atributeArr[2]));
                villainsData[i].setAttack(Integer.parseInt(atributeArr[3]));
                villainsData[i].setDefense(Integer.parseInt(atributeArr[4]));
                villainsData[i].setSpeed(Integer.parseInt(atributeArr[5]));
                myReader.close();
            }
        } catch(FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }
        return villainsData;
    }

    public static int numOfLines(File arr){
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

    // This method will simulate a battle sequence 
    // between the current hero and the current villain
    // a boolean array representing their lives is created at the start 
    // [herosLife, VillainsLife] at the start both should be alive
    // true mean they are alive
    // false means they are dead
    public static boolean[] attackSequence(){ 
        //array that contains live states
        boolean[] alive = {true, true};
        //hero attacks first if it has greater speed
        if(currentGachaHero.getSpeed() > currentGachaVillain.getSpeed()){
            heroAttack();
            //if villain still alive after the hero's attack
            if(currentGachaVillain.getHp() >= 0){
                villainAttack();
                //if hero is dead after villain attack return hero dead
                if(currentGachaHero.getHp()<=0){
                    alive[0] = false;
                    return alive;
                }
            }
            //if hero killed villain return villain dead
            else {
                alive[1] = false;
                return alive;
            }
        }
        //if villain's speed is greater
        else {
            villainAttack();
            //if hero survived attack
            if(currentGachaHero.getHp() >= 0){
                heroAttack();
                //if villain killed
                if(currentGachaVillain.getHp() < 0 ){
                    alive[1] = false;
                    return alive;
                }
            }
            //if hero didn't survive
            else{
                alive[0] = false;
                return alive;
            }
        }
        //if both survive
        return alive;
    }

    public static void heroAttack(){
        //get rarity integer from string
        int rarity = Integer.parseInt(currentGachaHero.getRarity().split("")[0]);

        int critical = getRandomInteger(1, 2);
        //random number from 0 to 100 to simulate 0%-100%
        int percent = getRandomInteger(0, 100);
        //Ternary notation: if percentaje is 5 or less random is 0, else if percent is between 6 and 70 random is 1, else the remaining 30% random is 2;
        int random = percent <= 5 ? 0 : percent > 5 && percent <= 70 ? 1 : 2;
        int attack = currentGachaHero.getAttack();
        double luck = currentGachaHero.getLuck();
        int speed = currentGachaHero.getSpeed();
        int defense = currentGachaVillain.getDefense();
        //calculating the damage in double type
        double dmgPart1 = ((2.0*rarity*critical)/5.0)+(0.25);
        double dmgPart2 = (luck*speed)/defense;
        double dmgDouble = dmgPart1*attack*dmgPart2*1.05*random;
        //converting damage to int
        int damageInt = (int) Math.floor(dmgDouble);
        //setting enemy health after the attack
        int villainHealth = currentGachaVillain.getHp();
        currentGachaVillain.setHp(villainHealth-damageInt);
    }

    public static void villainAttack(){
        int rarity = Integer.parseInt(currentGachaVillain.getRarity().split("")[0]);
        int critical = getRandomInteger(1, 2);
        int percent = getRandomInteger(0, 100);
        int random = percent <= 5 ? 0 : percent > 5 && percent <= 70 ? 1 : 2;
        //Villain attack is halved
        int attack = currentGachaVillain.getAttack()/2;
        //Villain luck is 3 for all of them
        int speed = currentGachaVillain.getSpeed();
        int defense = currentGachaHero.getDefense();
        double dmgPart1 = ((2.0*rarity*critical)/5.0)+(0.25);
        double dmgPart2 = (3.0*speed)/defense;
        double dmgDouble = dmgPart1*attack*dmgPart2*1.05*random;
        int damageInt = (int) Math.floor(dmgDouble);
        int heroHealth = currentGachaHero.getHp();
        currentGachaHero.setHp(heroHealth-damageInt);
    }

    public static int getRandomInteger(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
/**
*---------------------DO NOT TOUCH CODE----------------------------------------
*/
    public static void makeGame(GachaHero[] gachaHeroArray, GachaVillain[] gachaVillainArray, GachaGame gachaPoolHero, GachaGame gachaPoolVillain) {
        JFrame frame = new JFrame("CS2 Gacha Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        JPanel startScreen = new JPanel();
        startScreen.setLayout(new GridBagLayout());

        JButton buttonDrawHero = new JButton("Draw Hero");
        startScreen.add(buttonDrawHero);

        mainPanel.add(startScreen, "startScreen");

        buttonDrawHero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeButtonBehaviorDrawHero(gachaHeroArray, gachaPoolHero);

                JPanel imageTextScreen = createImageTextScreen(cardLayout, mainPanel, gachaPoolVillain, gachaVillainArray);
                mainPanel.add(imageTextScreen, "imageTextScreen");

                cardLayout.show(mainPanel, "imageTextScreen");
            }
        });

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public static JPanel createImageTextScreen(CardLayout cardLayout, JPanel mainPanel, GachaGame gachaPoolVillain, GachaVillain[] gachaVillainArray) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        ImageIcon image = new ImageIcon("hero-sprite.png");
        JLabel imageLabel = new JLabel(image);

        JLabel textLabel = new JLabel("<html>YOU HAVE DRAWN " + currentGachaHero.getName() + " He is a " + currentGachaHero.getRarity() +
            " Hero with the following stats " +
            " HP: " + currentGachaHero.getHp() + " ATTACK: " + currentGachaHero.getAttack() + " DEFENSE: " + currentGachaHero.getDefense() +
            " SPEED: " + currentGachaHero.getSpeed() + " LUCK: " + currentGachaHero.getLuck() + "</html>", SwingConstants.CENTER);
        textLabel.setFont(new Font("Serif", Font.BOLD, 24));

        JButton battleButton = new JButton("BATTLE");
        battleButton.setFont(new Font("Serif", Font.BOLD, 20));

        battleButton.addActionListener(e -> {
            JPanel battleMenu = createBattleMenu(gachaPoolVillain, gachaVillainArray);
            mainPanel.add(battleMenu, "battleMenu");
            cardLayout.show(mainPanel, "battleMenu");
        });

        panel.add(imageLabel, BorderLayout.CENTER);
        panel.add(textLabel, BorderLayout.NORTH);
        panel.add(battleButton, BorderLayout.SOUTH);

        return panel;
    }

    public static void executeButtonBehaviorDrawHero(GachaHero[] gachaHeroArray, GachaGame gachaPool) {
        System.out.println("Button was clicked! - Drawing hero");
        currentGachaHero = gachaHeroArray[gachaPool.singleDraw()];
        currentGachaHero.printGachaHero();
    }

    public static JPanel createBattleMenu(GachaGame gachaPoolVillain, GachaVillain[] gachaVillainArray) {
        if (currentGachaVillain == null || currentGachaVillain.getHp() <= 0) {
            System.out.println("Battle was clicked! - Drawing Villain");
            currentGachaVillain = gachaVillainArray[gachaPoolVillain.singleDraw()];
            currentGachaVillain.printGachaVillain();
        }

        JPanel battleMenu = new JPanel();
        battleMenu.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2, 10, 10));

        JButton attackButton = new JButton("Attack");
        JButton defendButton = new JButton("Defend");
        JButton itemButton = new JButton("Use Draw");
        JButton runButton = new JButton("Run");

        attackButton.addActionListener(e -> {
            boolean[] outcome = attackSequence();
            if (!outcome[0]) {
                System.err.println("The hero is dead");
                JPanel endingScreen = createEndingScreen();
                JPanel parentPanel = (JPanel) battleMenu.getParent();
                parentPanel.add(endingScreen, "endingScreen");
                ((CardLayout) parentPanel.getLayout()).show(parentPanel, "endingScreen");
            } else {
                System.err.println("Refresh the page");
                refreshBattleMenu((CardLayout) battleMenu.getParent().getLayout(), (JPanel) battleMenu.getParent(), gachaPoolVillain, gachaVillainArray);
            }
        });

        defendButton.addActionListener(e -> System.out.println("You chose to defend!"));
        itemButton.addActionListener(e -> System.out.println("You used an Draw!"));
        runButton.addActionListener(e -> System.out.println("You ran away!"));

        buttonPanel.add(attackButton);
        buttonPanel.add(defendButton);
        buttonPanel.add(itemButton);
        buttonPanel.add(runButton);

        battleMenu.add(buttonPanel, BorderLayout.SOUTH);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());

        ImageIcon heroImage = new ImageIcon("hero-sprite.png");
        JLabel heroImageLabel = new JLabel(heroImage);

        JLabel heroHPLabel = new JLabel(currentGachaHero.getName() + " HP: " + currentGachaHero.getHp());
        heroHPLabel.setFont(new Font("Serif", Font.BOLD, 18));

        leftPanel.add(heroImageLabel, BorderLayout.CENTER);
        leftPanel.add(heroHPLabel, BorderLayout.SOUTH);

        battleMenu.add(leftPanel, BorderLayout.WEST);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());

        ImageIcon villainImage = new ImageIcon("villain-sprite.png");
        JLabel villainImageLabel = new JLabel(villainImage);

        JLabel villainHPLabel = new JLabel(currentGachaVillain.getName() + " HP: " + currentGachaVillain.getHp());
        villainHPLabel.setFont(new Font("Serif", Font.BOLD, 18));

        rightPanel.add(villainImageLabel, BorderLayout.CENTER);
        rightPanel.add(villainHPLabel, BorderLayout.SOUTH);

        battleMenu.add(rightPanel, BorderLayout.EAST);

        return battleMenu;
    }

    // Method to refresh the battle menu
    public static void refreshBattleMenu(CardLayout cardLayout, JPanel mainPanel, GachaGame gachaPoolVillain, GachaVillain[] gachaVillainArray) {
        JPanel battleMenu = createBattleMenu(gachaPoolVillain, gachaVillainArray);
        Component[] components = mainPanel.getComponents(); 
        for (Component component : components) {
            if (component instanceof JPanel && ((JPanel) component).getName() != null && ((JPanel) component).getName().equals("battleMenu")) { 
                mainPanel.remove(component); break; 
            } 
        }
        mainPanel.add(battleMenu, "battleMenu");
        cardLayout.show(mainPanel, "battleMenu");
    }
    

    // Method to create the ending screen
    public static JPanel createEndingScreen() {
        JPanel endingScreen = new JPanel();
        endingScreen.add(new JLabel("The hero is dead. Game Over."));
        return endingScreen;
    }

    
    /**
    *---- END OF DO NOT TOUCH CODE -------------------------------------------------------------------------------
    */

    public static void main(String[] args) {
        //Get the files name Here
        String heroFileName = "lab2-herodataset - Sheet1.csv";
        String villianFileName = "lab2-villaindataset - Sheet1.csv";
        // GachaHero and GachaVillain arrays (Task 3 - 4) will be declared here
        GachaHero[] gachaHeroArray = scanHero(heroFileName);
        GachaVillain[] gachaVillainArray = scanVillain(villianFileName);

        //Print each hero and villain
        // for(GachaHero hero : gachaHeroArray){
        //     hero.printGachaHero();
        // }
        // System.out.println("----------------------");
        // for(GachaVillain villain : gachaVillainArray){
        //     villain.printGachaVillain();
        // }
        
            GachaGame gachaPoolHero = new GachaGame();
            GachaGame gachaPoolVillain = new GachaGame();
            makeGame(gachaHeroArray, gachaVillainArray, gachaPoolHero, gachaPoolVillain);
         


    }
}
