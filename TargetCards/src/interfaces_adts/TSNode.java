package interfaces_adts;

/**
 * Node class for use by my Stack and Linked List ADTs
 *
 * @author Stewart Millar
 * @since 12/08/2022
 */

public class TSNode<T>
{
    // Instance variables
    private T data;
    private TSNode<T> next;

    // Constructor
    public TSNode(T dataValue) {
        data = dataValue;
        next = null;
    }

    // Getter and setter methods
    public T getData(){
        return data;
    }

    public void setData (T dataValue) {
        data = dataValue;
    }

    public TSNode<T> getNext() {
        return next;
    }

    public void setNext (TSNode<T> nextNode) {
        next = nextNode;
    }


}
