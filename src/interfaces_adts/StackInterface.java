package interfaces_adts;

/**
 * Basic stack interface
 *
 * @author Stewart Millar
 * @since 10/08/2022
 */
public interface StackInterface<T>
{
    public void push(T newEntry);
        /* Add a new item to the top of the stack
           @param (T) newEntry - the generic to be added
         */

    public T pop();
        /* Remove the item at the top of the stack
           throw EmptyStackException to prevent being called on a stack that's already empty
           @return (T) - the item that was at the top of the stack
        */

    public T peek();
        /* Return without removing the item at the top of the stack
           throw EmptyStackException to prevent being called on a stack that's already empty
           @return (T) - the item that was at the top of the stack
        */

    public boolean isEmpty();
        /* Returns true if the stack is empty, if populated, returns false
        */

    public void clear();
        /* Wipes the stack of entries
        */
}
