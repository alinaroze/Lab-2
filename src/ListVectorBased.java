/**
 * Array-based implementation of the ADT list.
 */
import java.util.Vector;
import java.util.Iterator;

public class ListVectorBased<E> implements ListInterface<E>, Iterable<E> {


    /** array on which the list is based */
    private Vector<E> items;
    
    /** default Constructor */
    public ListVectorBased()
    {
    	items = new Vector<E> ();
    }
    
    
    /** constructor with the first item: constructs a list with the
     * specified item as single element of this list
     * @param item first element of the list
     */
    
    
	public ListVectorBased(E item)
    {   
    	items = new Vector<E>();
    	items.add(item);
    }
    
    /** copy constructor: create a duplicate of the specified list
     * @param list to be copied
     */
   
    public ListVectorBased(ListVectorBased<E> list)
    {
    	items = new Vector<E>(list.items);
    }
    

     /** Tests if this list has no elements.
     * @return <code>true</code> if this list has no elements;
     * <code>false</code> otherwise.
     */
    public boolean isEmpty() {
	return items.isEmpty();
    } // end isEmpty
    
    
    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list.
     */
    public int size() {
	return items.size();
    }  // end size
    
    /**
     * Remove all the elements in this list.
     */
    public void removeAll() {
	items.removeAllElements();
    } // end removeAll


    /**
     * Inserts the specified element at the specified position in this
     * list. Shifts the element currently at that position (if any)
     * and any subsequent elements to the right (adds one to their
     * indices).
     * @param index index at which the specified element is to be
     * inserted.
     * @param item element to be inserted.
     * @throws IndexOutOfBoundsException - if index is out of range
     * (index < 0 || index > size()).
     */
    public void add(int index, E item) 
	throws  ListIndexOutOfBoundsException {
	if (index >= 1 && index <= items.size()+1) {
	    items.add(index-1,item);
	} 
	else {  // index out of range
	    throw new ListIndexOutOfBoundsException(
						    "ListIndexOutOfBoundsException on add");
	}  // end if
    } //end add
    

    /**
     * appends the specified element to the end of this list.
     * @param elt element to be added at the end of the list
     */
    public void append(E elt) 
    {
        items.add(elt);
    } //end append
    		
    
    /**
     * Returns the element at the specified position in this list.
     * @param index index of element to return.
     * @return the element at the specified position in this list.
     * @throws IndexOutOfBoundsException - if index is out of range
     * (index < 0 || index > size()).
     */
    public E get(int index) 
	throws ListIndexOutOfBoundsException {
	if (index >= 1 && index <= items.size()) {
	    return items.get(index-1);
	}
	else  {  // index out of range
	    throw new ListIndexOutOfBoundsException(
						    "ListIndexOutOfBoundsException on get");
	}  // end if
    } // end get
   

    /**
     * Removes the element at the specified position in this
     * list. Shifts any subsequent elements to the left (subtracts one
     * from their indices).
     * @param index the index of the element to remove
     * @throws IndexOutOfBoundsException - if index is out of range
     * (index < 0 || index > size()).
     */
    public void remove(int index) 
	throws ListIndexOutOfBoundsException {
	if (index >= 1 && index <= items.size()) {
	    // delete item by shifting all items at 
	    // positions > index toward the beginning of the list
	    // (no shift if index == size)
	    items.remove(index-1);
	}
	else {  // index out of range
	    throw new ListIndexOutOfBoundsException(
						    "ListIndexOutOfBoundsException on remove");
	}  // end if
    } //end remove
    

    /**  delete
     * delete the the specified element in this list if exists. Shifts
     * any subsequent elements to the left (subtracts one from their
     * indices).
     * @param elt the element, if it exists, to delete
     */
    public void delete(E elt) 
    {
    	items.remove(elt);
    } //end delete
        
    /** contains
     * Looks for the index of the specified element in this list. If
     * the element is not present, the method returns <code>-1</code>
     * @param elt the element which index is looked for.
     * @return either the index of the location in the list where the
     * argument is present or <code>-1</code> if the argument is not
     * contained in the list.
     */
    public int contains (E elt)
    {
    	return items.lastIndexOf(elt, items.size()-1);
    }

    /** display
     * Prints all the elements in this list on the console in sequence
     */
    public void display()
    {
    	String print = items.toString();
    	System.out.println("The list contains:" + print);
    }


    /** method to make the class iterable */

    public Iterator<E> iterator(){
	return items.iterator();
    }

}  // end ListVectorBased
