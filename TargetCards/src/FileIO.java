import java.io.*;
import java.lang.ClassNotFoundException;
import java.lang.ClassCastException;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * Class containing methods to read and write .Player objects to file.
 * Includes objects within linked lists for other classes to use and manipulate.
 *
 * @author Stewart Millar
 * @version 1.0
 * @since 07/08/2022
 */
public class FileIO extends Player
{
    /**
     * Method that goes through file using a combination of the ObjectInputStream
     * and FileInputStream objects to read file, read as object of type Player
     * via the ObjectInputStream's readObject method,add each Player object to a
     * linked list of that type and return that linked list to where method was called.
     *
     * @param gameMode Which makes up via string concatenation what mode and thus file is to be read from
     * @return highScores Linked List where further manipulation can occur if required
     */
    public LinkedList<Player> fileRead (int gameMode) throws IOException, ClassNotFoundException, ClassCastException {
        String file = "HighScores"+gameMode+".txt.";
        FileInputStream fileInput = new FileInputStream(file);
        ObjectInputStream objectIn = new ObjectInputStream(fileInput);
        LinkedList<Player> highScores = new LinkedList<>();

        try {
            while (highScores.size() < 10)// We only want to read the existing 10 top scores
            {
                Player p = (Player)objectIn.readObject();
                highScores.add(p);
            }
        } catch (EOFException ex){
            System.out.println("End of File...");
        }
        catch (FileNotFoundException exF){
            System.out.println(exF + "File Not Found");
        }
        catch (ClassCastException exC){
            System.out.println(exC);
        }
        fileInput.close();
        objectIn.close();
        System.out.println("High Score Read Complete!\n");

        return highScores;
    }// End method fileRead

    /**
     * Method that iterates through Linked List of Player objects that is passed to it and writes them to file
     * as objects of that type.
     * It does this via usage of the FileOutPutStream class and the ObjectOutputStream's writeObject method.
     *
     * @param highScores Linked List of relevant high scores to be written to file.
     * @param gameMode Particular game mode which high scores are to be written for.
     */
    public void fileWrite (LinkedList<Player> highScores, int gameMode) throws IOException {
        String fileString = "HighScores"+gameMode+".txt.";
        File file = new File(fileString);
        FileOutputStream fileOutput = new FileOutputStream(file);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOutput);

        for (Player p: highScores) {
            objectOut.writeObject(p);
        }
        fileOutput.close();
        objectOut.close();
        System.out.print("High Score File Write Complete.\n");
    }// End method fileWrite

    /**
     * Method retrieves player high scores from file and displays them to the user.
     *
     * @param gameMode Particular game mode which high scores are to be displayed.
     */

    public void displayHighScores(int gameMode) throws IOException, ClassNotFoundException, InterruptedException, FileNotFoundException {

        try {
            LinkedList<Player> output = fileRead(gameMode);
            System.out.println("\n" +"\u2665 \u2664 \u2666 \u2667" + " " + "\u2665 \u2664 \u2666 \u2667" + " ");
            System.out.println("\u2666 HALL OF FAME \u2667");
            System.out.println("\u2665 \u2664 \u2666 \u2667" + " " + "\u2665 \u2664 \u2666 \u2667" + "\n ");
            if(gameMode == 1){
                System.out.println("     Aces High\n---------------------------");
            }
            if(gameMode == 2){
                System.out.println("     Aces Low\n---------------------------");
            }
            if(gameMode == 3){
                System.out.println("     Aces High (and Low!)\n---------------------------");
            }
            int i = 1;
            for (Player player : output)
            {
                System.out.println(i + ". " + player.getName() + "");
                System.out.println("   " + player.getPlayerHighScore() + "\n");
                i++;
                TimeUnit.MILLISECONDS.sleep(600);
            }
        }
        catch (FileNotFoundException exF) {
            System.out.println(exF);
        }
        catch (ClassNotFoundException noF) {
            System.out.println("Error" + noF);
        }
    }// End method displayHighScores

}// End class FileIO
