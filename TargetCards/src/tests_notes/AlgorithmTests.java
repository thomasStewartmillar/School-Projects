package tests_notes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

/**
 * Various tests, some now deleted to quickly test functionality and viability prior to application
 */
public class AlgorithmTests
{

    static int[] shuffle(int[] array, int arraySize)
    {
        // Creating object for Random class
        Random rand = new Random();

        // Starting from the last element and swapping one by one.
        for (int i = arraySize-1; i > 0; i--) {

            // Pick a random index from 0 to i
            int j = rand.nextInt(i+1);

            // Swap array[i] with the element at random index
            int temp = array[i]; // get objectclasses.objectclasses.Card
            array[i] = array[j]; // choose location
            array[j] = temp; // set objectclasses.objectclasses.Card
        }
        // Printing the random generated array
        System.out.println(Arrays.toString(array));

        return array;
    }

    static int swapPos (int candidate, int[] array) {
        int pos = -1; // Sentinel value
        boolean swapValid = false;

        for(int i = 0; i < array.length; i++)
            {
                if (candidate < array[i])
                {
                    pos = i;
                    return pos;
                }
            }
        return pos;
    }

    static int swapPos2 (int candidate, int[] array, int swapPos) {
        int pos = -1; // Sentinel value
        boolean swapValid = false;

        for(int i = swapPos; i < array.length + 1; i++)
        {
            if (candidate < array[i])
            {
                pos = i;
                return pos;
            }
        }
        return pos;
    }

//    public static void main(String[] args)
//    {
//        int[] sourceArray = {2, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
//        27, 28, 29, 30, 31, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52};
//        int targetArray = sourceArray.length;
//        //shuffle (sourceArray, targetArray);
//        //System.out.println(swapPos(35, shuffle (sourceArray, targetArray)));
//        System.out.println(swapPos2(25, sourceArray, swapPos(5, sourceArray)));
//
//
//    }

}
