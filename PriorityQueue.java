import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

/**
 * A priority queue class implemented using a min heap.
 * Priorities cannot be negative.
 * 
 * @author Bee Bridge and Eva Shimanski 
 * @version September 25, 2020
 *
 */
public class PriorityQueue {

	protected Map<Integer, Integer> location;
	protected List<Pair<Integer, Integer>> heap;

	/**
	 *  Constructs an empty priority queue
	 */
	public PriorityQueue() {
	this.heap = new ArrayList<>();
	this.location = new HashMap<>();
	}
	public PriorityQueue(ArrayList arr, HashMap map) { //TODO remove test constructor
		this.heap = arr;
		this.location = map;
	}

	/**
	 *  Insert a new element into the queue with the
	 *  given priority.
	 *
	 *	@param priority priority of element to be inserted
	 *	@param element element to be inserted
	 *	<br><br>
	 *	<b>Preconditions:</b>
	 *	<ul>
	 *	<li> The element does not already appear in the priority queue.</li>
	 *	<li> The priority is non-negative.</li>
	 *	</ul>
	 *  
	 */
	public void push(int priority, int element) {
		if(priority>=0){
			
				
			
		}
	}

	/**
	 *  Remove the highest priority element
	 *  <br><br>
	 *	<b>Preconditions:</b>
	 *	<ul>
	 *	<li> The priority queue is non-empty.</li>
	 *	</ul>
	 *  
	 */
	public void pop(){
		// TODO: Fill in
	}


	/**
	 *  Returns the highest priority in the queue
	 *  @return highest priority value
	 *  <br><br>
	 *	<b>Preconditions:</b>
	 *	<ul>
	 *	<li> The priority queue is non-empty.</li>
	 *	</ul>
	 */
	public int topPriority() {	
		int max = 0; 
		for(int i = 0; i< this.heap.size(); i++){
			if(isLeaf(i)){//is leaf takes an index
				if((heap.get(i)).priority > max){
					max = (heap.get(i)).priority;
				}

			}
		}
		return max;
	}


	/**
	 *  Returns the element with the highest priority
	 *  @return element with highest priority
	 *  <br><br>
	 *	<b>Preconditions:</b>
	 *	<ul>
	 *	<li> The priority queue is non-empty.</li>
	 *	</ul>
	 */
	public int topElement() {
		return (this.heap.get(0)).element;
	}


	/**
	 *  Change the priority of an element already in the
	 *  priority queue.
	 *  
	 *  @param newpriority the new priority	  
	 *  @param element element whose priority is to be changed
	 *  <br><br>
	 *	<b>Preconditions:</b>
	 *	<ul>
	 *	<li> The element exists in the priority queue</li>
	 *	<li> The new priority is non-negative </li>
	 *	</ul>
	 */
	public void changePriority(int newpriority, int element) {
		int index = this.location.get(element);
		Pair<Integer,Integer> p1 = new Pair(newpriority, element);
		this.heap.set(index, p1);
	}


	/**
	 *  Gets the priority of the element
	 *  
	 *  @param element the element whose priority is returned
	 *  @return the priority value
	 *  <br><br>
	 *	<b>Preconditions:</b>
	 *	<ul>
	 *	<li> The element exists in the priority queue</li>
	 *	</ul>
	 */
	public int getPriority(int element) {
		int index = this.location.get(element);
		Pair<Integer,Integer> p1 =this.heap.get(index);
		return p1.priority;
	}

	/**
	 *  Returns true if the priority queue contains no elements
	 *  @return true if the queue contains no elements, false otherwise
	 */
	public boolean isEmpty() {
		if (this.heap.size() >0){
			return false;
		}
		else{
		return true;
		}
	}

	/**
	 *  Returns true if the element exists in the priority queue.
	 *  @return true if the element exists, false otherwise
	 */
	public boolean isPresent(int element) {
		
		if (this.location.containsKey(element)){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 *  Removes all elements from the priority queue
	 */
	public void clear() {
		this.heap = new ArrayList<>();
		this.location = new HashMap<>();
	}

	/**
	 *  Returns the number of elements in the priority queue
	 *  @return number of elements in the priority queue
	 */
	public int size() {
		return heap.size(); 
	}


	
	/*********************************************************
	 * 				Private helper methods
	 *********************************************************/
	

	/**
	 * Push down the element at the given position in the heap 
	 * @param start_index the index of the element to be pushed down
	 * @return the index in the list where the element is finally stored
	 */
	private int pushDown(int start_index) {	
		return 0;
		// TODO: Fill in
	}

	/**
	 * Percolate up the element at the given position in the heap 
	 * @param start_index the index of the element to be percolated up
	 * @return the index in the list where the element is finally stored
	 */
	private int percolateUp(int start_index) {
		return 0;
		// TODO: Fill in
	}


	/**
	 * Swaps two elements in the priority queue by updating BOTH
	 * the list representing the heap AND the map
	 * @param i The index of the element to be swapped
	 * @param j The index of the element to be swapped
	 */
	private void swap(int i, int j) {
		Pair<Integer,Integer> p1 = this.heap.get(i); //found (priority,element)
		Pair<Integer,Integer> p2 = this.heap.get(j); 

		this.heap.set(j, p1); //replace in heap spot j with p2 and vice versa
		this.heap.set(i, p2);

		//int key2 = heap[j];
		this.location.replace(p1.element, j);//replace (element, new index in map)
		this.location.replace(p2.element,i);


	}

	/**
	 * Computes the index of the element's left child
	 * @param parent index of element in list
	 * @return index of element's left child in list
	 */
	private int left(int parent) {
	return ((2*parent)+1);
	}

	/**
	 * Computes the index of the element's right child
	 * @param parent index of element in list
	 * @return index of element's right child in list
	 */
	private int right(int parent) {
			return ((2*parent)+2);

	}

	/**
	 * Computes the index of the element's parent
	 * @param child index of element in list
	 * @return index of element's parent in list
	 */

	private int parent(int child) {
		return ((child-1)/2);
	}
	

	/*********************************************************
	 * 	These are optional private methods that may be useful
	 *********************************************************/
	
	
	/**
	 * Push down the root element
	 * @return the index in the list where the element is finally stored
	 */
	private int pushDownRoot() {
		// TODO: A one-line function that calls pushDown()
		return 0;
	}

	/**
	 * Percolate up the last leaf in the heap, i.e. the most recently 
	 * added element which is stored in the last slot in the list
	 * 
	 * @return the index in the list where the element is finally stored
	 */
	private int percolateUpLeaf(){
		// TODO: A one-line function that calls percolateUp()
		return 0;
	}
	
	/**
	 * Returns true if element is a leaf in the heap
	 * @param i index of element in heap
	 * @return true if element is a leaf
	 */
	private boolean isLeaf(int i){
		if(this.location.containsValue(left(i))){ //Only checks the left child because we are filling the map left to right
			return false;
		}
		return true;
	}

	/**
	 * Returns true if element has two children in the heap
	 * @param i index of element in the heap
	 * @return true if element in heap has two children
	 */
	private boolean hasTwoChildren(int i) {
		if(this.location.containsValue(left(i))&&this.location.containsValue(right(i))){ //Checks to see if it has both children
		return true;
		}
		return false;
	}
	
	/**
	 * Print the underlying list representation
	 */
	private void printHeap() {
		
		System.out.println(location.toString());
	}

	/**
	 * Print the entries in the location map
	 */
	private void printMap() {
		for(int i=0; i < location.size();i ++){
			System.out.println(Collections.min(location.values()));
		}
		
	}

	
}
