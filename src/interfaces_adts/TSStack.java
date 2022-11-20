package interfaces_adts;

import java.util.EmptyStackException;

/**
 * Linked stack implementation
 *
 * @author Stewart Millar
 * @since 14/08/2022
 */

public class TSStack<T> implements StackInterface<T>
{
    private TSNode<T> topNode; // Top node of the stack

    // Constructor
    public TSStack() {
        topNode = null;
    }

    /**
     * Insert an element to the stack
     * @param newEntry Element to be inserted into the stack
     */
    public void push(T newEntry) {
        TSNode<T> newNode = new TSNode<T>(newEntry);
        newNode.setNext(topNode);
        topNode = newNode; //
    }

    /**
     * Remove top element from the stack and return its value
     * @return popData of current item at the top of the stack
     */
    public T pop() {
        T popData = peek();
        topNode = topNode.getNext(); // Changes top node from that popped to the next in the chain
        return popData;
    }

    /**
     * Retrieve data from element at the top of the stack and return it
     * @return data from the current item at the top of the stack
     */
    public T peek() {
        if (topNode == null) throw new EmptyStackException();
        else return topNode.getData();
    }

    /**
     * Check if stack is empty
     * @return boolean
     */
    public boolean isEmpty() {
        return topNode == null;
    }

    /**
     * Clear all data from the stack
     */
    public void clear() {
        topNode = null;
    }
} // End class MyStack
