/**
 * Defines a singly-linked list class
 * Hamzah Zaza
 */

import java.util.NoSuchElementException;

public class List<T> {
	private class Node {
		private T data;
		private Node next;
		private Node prev;

		public Node(T data) {
		this.data = data;
		this.next = null;
		this.prev = null;
		}
	}
   
    private int length;
    private Node first;
    private Node last;
   
    /****CONSTRUCTOR****/
   
    /**
     * Instantiates a new List with default values
     * @postcondition
     */
    public List() {
 
    }
   
    /****ACCESSORS****/
   
    /**
     * Returns the value stored in the first node
     * @precondition
     * @return the value stored at node first
     * @throws NoSuchElementException when precondition is violated
     */
    public T getFirst() throws NoSuchElementException{
        return null;
    }
   
    /**
     * Returns the value stored in the last node
     * @precondition
     * @return the value stored in the node last
     * @throws NoSuchElementException when precondition is violated
     */
    public T getLast() throws NoSuchElementException{
        return null;
    }
   
    /**
     * Returns the current length of the list
     * @return the length of the list from 0 to n
     */
    public int getLength() {
        return -1;
    }
   
    /**
     * Returns whether the list is currently empty
     * @return whether the list is empty
     */
    public boolean isEmpty() {
        return false;
    }
   
    /****MUTATORS****/
   
    /**
     * Creates a new first element
     * @param data the data to insert at the
     * front of the list
     * @postcondition a new first element
     */
    public void addFirst(T data) {
        if (first == null) {
            first = last = new Node(data);
        } else {
            Node N = new Node(data);
            N.next = first;
            first.prev = N;
            first = N;
        }
        length++;
    }
   
    /**
     * Creates a new last element
     * @param data the data to insert at the
     * end of the list
     * @postcondition
     */
    public void addLast(T data) {
        return;
    }
   
    /**
    * removes the element at the front of the list
    * @precondition
    * @postcondition
    * @throws NoSuchElementException when precondition is violated
    */
    public void removeFirst() throws NoSuchElementException{
        return;
    }
   
    /**
     * removes the element at the end of the list
     * @precondition
     * @postcondition
     * @throws NoSuchElementException when precondition is violated
     */
    public void removeLast() throws NoSuchElementException{
        return;
    }
   
    /****ADDITIONAL OPERATIONS****/
   
    /**
     * List with each value on its own line
     * At the end of the List a new line
     * @return the List as a String for display
     */
    @Override public String toString() {
       return "";
    }
   

}
