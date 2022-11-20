package interfaces_adts;

/**
 * Linked List implementation, not currently fully functional
 *
 * @author Stewart Millar
 * @since 17/08/2022
 */

public class TSLinkedList<T> implements ListInterface<T>
{
    private TSNode<T> head; // Head node of the linked list
    private static int nodeCount; // Tracks number of nodes in the chain and hence size of linked list

    // Default constructor
    public TSLinkedList()
    {

    }


    @Override
    public void add(T newEntry)
    {
        // If item is being added to empty Linked List, create head node
        if (head == null) {
            head = new TSNode(newEntry);
        }

        TSNode tempNode = new TSNode(newEntry);
        TSNode currentNode = head;

        // Check for null pointer exception
        if (currentNode != null) {

            // Starting at head node, iterate through list and then add element where no node is present
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            // The last node's 'next' reference set to newly added node
            currentNode.setNext(tempNode);
        }
        // Increment the number of elements to reflect added node
        increaseNodeCount();

    }

    @Override
    public void add(int index, T newEntry)
    {
        TSNode tempNode = new TSNode(newEntry);
        TSNode currentNode = head;

        // Check for null pointer exception
        if (currentNode != null)
        {
            // Iterate through to requested index location, or to the end of the list, whichever is reached first.
            for (int i = 0; i < index && currentNode.getNext() != null; i++) {
                currentNode = currentNode.getNext();
            }
        }
        // New nodes' intended location set in reference to current node/get next from there
        tempNode.setNext(currentNode.getNext());
        // Link is formed by the current node setting its next node as the temp node containing data.
        currentNode.setNext(tempNode);
        // Increment the number of elements to reflect added node
        increaseNodeCount();
    }


    @Override
    // removes the element at the specified position in this list.
    public boolean remove(int index) {

        // if the index is out of range, exit
        if (index < 1 || index > size())
            return false;

        TSNode currentNode = head;
        if (head != null) {
            for (int i = 0; i < index; i++) {
                if (currentNode.getNext() == null)
                    return false;

                currentNode = currentNode.getNext();
            }
            currentNode.setNext(currentNode.getNext().getNext());

            // decrement the number of elements variable
            decreaseNodeCount();
            return true;
        }
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T replace(int position, T newEntry) {
        return null;
    }

    @Override
    public T getEntry(int index) {
        // returns the element at the specified position in this list.
        {
            // index must be 1 or higher
            if (index < 0)
                return null;
            TSNode currentNode = null;
            if (head != null) {
               currentNode = head.getNext();
                for (int i = 0; i < index; i++) {
                    if (currentNode.getNext() == null)
                        return null;

                    currentNode = currentNode.getNext();
                }
                return (T) currentNode.getData();
            }
            return (T) currentNode;

        }
    }


    @Override
    public boolean contains(T anEntry) {
        return false;
    }

    @Override
    public int size() {
        return nodeCount;
    }

    private static void increaseNodeCount() {
        nodeCount++;
    }

    private void decreaseNodeCount() {
        nodeCount--;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

} // End class TSLinkedList
