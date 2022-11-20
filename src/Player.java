/**
 * Class defining player attributes, behaviours and default values as well as accessor/mutator
 * methods, for future use by other classes
 *
 * Had to be moved into default package as was causing continuous crashes/exceptions caused by ClassNotFoundException
 * when I tried to implement it as part of the FileIO class methods. Despite it working correctly in other applications
 * such as in the Game class.
 *
 * @author Stewart Millar
 * @version 1.0
 * @since 12/07/2022
 */
public class Player implements java.io.Serializable
{
    // Initialise private variables
    private String playerName = "Unknown";
    private int playerBet = 0;
    private int playerScore = 0;
    private int playerWins = 0;
    private int playerHighScore = 1337;
    private int playerMode = 1;

    // Default constructor
    public Player()
    {

    }

    // Full 5 parameter Constructor - Not generally utilised outside of testing
    public Player(String playerName, int playerBet, int playerScore, int playerWins, int playerHighScore, int playerMode)
    {
        this.playerName = playerName;
        this.playerBet = playerBet;
        this.playerScore = playerScore;
        this.playerWins = playerWins;
        this.playerHighScore = playerHighScore;
        this.playerMode = playerMode;
    }

    // Respective Getter and Setter Methods
    public String getName()
    {
        return playerName;
    }

    public void setName(String name)
    {
        this.playerName = name;
    }

    public int getPlayerBet()
    {
        return playerBet;
    }

    public void setPlayerBet(int num)
    {
        this.playerBet = num;
    }

    public int getPlayerScore()
    {
        return playerScore;
    }

    public void setPlayerScore(int num)
    {
        this.playerScore = num;
    }

    public int getPlayerWins()
    {
        return playerWins;
    }

    public void setPlayerWins(int num)
    {
        this.playerWins = num;
    }

    public int getPlayerMode()
    {
        return playerMode;
    }

    public void setPlayerMode(int num)
    {
        this.playerMode = num;
    }

    public int getPlayerHighScore()
    {
        return playerHighScore;
    }

    public void setPlayerHighScore(int num)
    {
        this.playerHighScore = num;
    }

    public void showDetails()
    {
        System.out.println(getName());
        System.out.println(getPlayerBet());
        System.out.println(getPlayerScore());
        System.out.println(getPlayerWins());
        System.out.println(getPlayerHighScore());
        System.out.println(getPlayerMode());
    }

} // End class Player
