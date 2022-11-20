package interfaces_adts;

/**
 * Bare-bones List interface, pared down to intended application
 *
 * @author Stewart Millar
 * @since 10/08/2022
 */
public interface ListInterface<T>
{
    public void add (T newEntry);
        /* Adds a new entry to the list, at the end of the list
           Doesn't affect items already existent in the list.
           List's size increases by one to accommodate new item.

           @param newEntry The object being added to the list
         */

    public void add(int newPosition, T newEntry);
        /* Adds a new entry to the list, at a specified index location.
           Anything located at or above the location of the inserted item
           have their position shifted up by 1. List size is increased by
           1 to accommodate new item.

           @param newPosition Integer value specifying the desired index position of the new entry
        */

    public boolean remove(int position);
        /* Removes the entry at the specified index location.
           Anything located at or above the location of the inserted item
           have their position shifted down by 1. List size is increased by
           1 to reflect removal of item

           @param position Integer value specifying the desired index position of the new entry
        */

    public void clear();
        /* Removes everything from the list
        */

    public T replace(int position, T newEntry);
        /* Replaces the entry at the specified index location.
           Anything located at or above the location of the inserted item
           have their position shifted down by 1. List size is increased by
           1 to reflect removal of item

           @param position Integer value specifying the desired position of object to be removed
           @param newEntry The object to replace what was previously in the target location
        */

    public T getEntry(int position);
        /* Retrieves the entry at the specified index location.
           Anything located at or above the location of the inserted item
           have their position shifted down by 1. List size is increased by
           1 to reflect removal of item

           @param position Integer value specifying the desired index position of entry to be returned
        */



    public boolean contains(T anEntry);
        /* Check whether list contains a particular object

           @param anEntry The item whose existence in the list is being queried
           @return true if the list contains the item being searched for, false otherwise
        */

    public int size();
        /* Gets the length of the list

           @return The integer number of entries contained in the list
        */

    public boolean isEmpty();
        /* Check if the list is empty or not

           @return True if getLength() returns 0, false otherwise.
        */
}
