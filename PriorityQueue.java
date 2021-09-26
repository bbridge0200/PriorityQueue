import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

/**
 * A priority queue class implemented using a min heap. Priorities cannot be
 * negative.
 * 
 * @author Bee Bridge and Eva Shimanski
 * @version September 25, 2020
 *
 */
public class PriorityQueue {

	protected Map<Integer, Integer> location;
	protected List<Pair<Integer, Integer>> heap;

	/**
	 * Constructs an empty priority queue
	 */
	public PriorityQueue() {
		this.heap = new ArrayList<>();
		this.location = new HashMap<>();
	}

	/**
	 * Insert a new element into the queue with the given priority.
	 *
	 * @param priority priority of element to be inserted
	 * @param element  element to be inserted <br>
	 *                 <br>
	 *                 <b>Preconditions:</b>
	 *                 <ul>
	 *                 <li>The element does not already appear in the priority
	 *                 queue.</li>
	 *                 <li>The priority is non-negative.</li>
	 *                 </ul>
	 * 
	 */
	public void push(int priority, int element) {
		if (isPresent(element) && priority >= 0) {
			throw new AssertionError(); // throw error if the element is present in queue or priority is smaller than 0
		} else {
			Pair p1 = new Pair(priority, element);
			this.heap.add(p1);
			this.location.put(element, this.heap.size() - 1);
			percolateUpLeaf(); // determine if the pair needs to be moved in the tree
		}
	}

	/**
	 * Remove the highest priority element <br>
	 * <br>
	 * <b>Preconditions:</b>
	 * <ul>
	 * <li>The priority queue is non-empty.</li>
	 * </ul>
	 * 
	 */
	public void pop() {
		if (isEmpty()) {
			throw new AssertionError();
		} else {
			int posLastLeaf = this.heap.size() - 1; // determine the position of the last leaf
			swap(0, posLastLeaf); // swap the root and last pair
			this.location.remove((this.heap.get(size() - 1)).element); // remove the prior root before moving down the
																		// current root
			this.heap.remove(this.heap.size() - 1);
			pushDownRoot(); // determine the location of the current root and see if it need to be moved
		}

	}

	/**
	 * Returns the highest priority in the queue
	 * 
	 * @return highest priority value <br>
	 *         <br>
	 *         <b>Preconditions:</b>
	 *         <ul>
	 *         <li>The priority queue is non-empty.</li>
	 *         </ul>
	 */
	public int topPriority() {
		if (isEmpty()) {
			throw new AssertionError();
		} else {
			return this.heap.get(0).priority; // determines the priority of the top element (the root)
		}
	}

	/**
	 * Returns the element with the highest priority
	 * 
	 * @return element with highest priority <br>
	 *         <br>
	 *         <b>Preconditions:</b>
	 *         <ul>
	 *         <li>The priority queue is non-empty.</li>
	 *         </ul>
	 */
	public int topElement() {
		if (isEmpty()) {
			throw new AssertionError();
		} else {
			return (this.heap.get(0)).element; // determines the element that is at the root node
		}

	}

	/**
	 * Change the priority of an element already in the priority queue.
	 * 
	 * @param newpriority the new priority
	 * @param element     element whose priority is to be changed <br>
	 *                    <br>
	 *                    <b>Preconditions:</b>
	 *                    <ul>
	 *                    <li>The element exists in the priority queue</li>
	 *                    <li>The new priority is non-negative</li>
	 *                    </ul>
	 */
	public void changePriority(int newpriority, int element) {
		if (isPresent(element) && newPriority >= 0) {
			int index = this.location.get(element); // determine the index of the element
			Pair<Integer, Integer> p1 = new Pair<>(newpriority, element); // create a new pair with the element and the
																			// new priority
			this.heap.set(index, p1); // put the new pair at the index
		} else {
			throw new AssertionError();
		}
	}

	/**
	 * Gets the priority of the element
	 * 
	 * @param element the element whose priority is returned
	 * @return the priority value <br>
	 *         <br>
	 *         <b>Preconditions:</b>
	 *         <ul>
	 *         <li>The element exists in the priority queue</li>
	 *         </ul>
	 */
	public int getPriority(int element) {
		if (isPresent(element)) {
			int index = this.location.get(element); // determine the index of the element
			Pair<Integer, Integer> p1 = this.heap.get(index);
			return p1.priority; // determine the priority from the pair
		} else {
			throw new AssertionError();
		}
	}

	/**
	 * Returns true if the priority queue contains no elements
	 * 
	 * @return true if the queue contains no elements, false otherwise
	 */
	public boolean isEmpty() {
		if (this.heap.size() > 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Returns true if the element exists in the priority queue.
	 * 
	 * @return true if the element exists, false otherwise
	 */
	public boolean isPresent(int element) {
		if (this.location.containsKey(element)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Removes all elements from the priority queue
	 */
	public void clear() {
		this.heap = new ArrayList<>();
		this.location = new HashMap<>();
	}

	/**
	 * Returns the number of elements in the priority queue
	 * 
	 * @return number of elements in the priority queue
	 */
	public int size() {
		return this.heap.size();
	}

	/*********************************************************
	 * Private helper methods
	 *********************************************************/

	/**
	 * Push down the element at the given position in the heap
	 * 
	 * @param start_index the index of the element to be pushed down
	 * @return the index in the list where the element is finally stored
	 */
	private int pushDown(int start_index) {
		int parentPrior = this.heap.get(start_index).priority;
		int lchildPrior = this.heap.get(left(start_index)).priority;
		int rchildPrior = this.heap.get(right(start_index)).priority;
		if (parentPrior > lchildPrior) {
			swap(start_index, left(start_index));
			pushDown(left(start_index)); // recursive call to check the next children node
		} else if (parentPrior > rchildPrior) { // same as above but with the right node
			swap(start_index, right(start_index));
			pushDown(right(start_index));
		}
		return start_index;
	}

	/**
	 * Percolate up the element at the given position in the heap
	 * 
	 * @param start_index the index of the element to be percolated up
	 * @return the index in the list where the element is finally stored
	 */
	private int percolateUp(int start_index) {
		if (start_index > 0) { // ensure that the start index is greater than or equal to 0 to avoid
								// IndexOutOfBound exception
			int childPrior = this.heap.get(start_index).priority;
			int parentPrior = this.heap.get(parent(start_index)).priority;
			if (parentPrior > childPrior) {
				swap(start_index, parent(start_index)); // swap the indicies to percolate up
				percolateUp(parent(start_index)); // call recursivley to determine if the grandparent node needs to be
													// swapped
			}
			return start_index;
		}
		return start_index;
	}

	/**
	 * Swaps two elements in the priority queue by updating BOTH the list
	 * representing the heap AND the map
	 * 
	 * @param i The index of the element to be swapped
	 * @param j The index of the element to be swapped
	 */
	private void swap(int i, int j) {
		Pair<Integer, Integer> p1 = this.heap.get(i);
		Pair<Integer, Integer> p2 = this.heap.get(j);
		this.heap.set(j, p1); // replace in heap spot j with p2 and vice versa
		this.heap.set(i, p2);
		this.location.replace(p1.element, j);// replace (element, new index in map)
		this.location.replace(p2.element, i);
	}

	/**
	 * Computes the index of the element's left child
	 * 
	 * @param parent index of element in list
	 * @return index of element's left child in list
	 */
	private int left(int parent) {
		return ((2 * parent) + 1);
	}

	/**
	 * Computes the index of the element's right child
	 * 
	 * @param parent index of element in list
	 * @return index of element's right child in list
	 */
	private int right(int parent) {
		return ((2 * parent) + 2);
	}

	/**
	 * Computes the index of the element's parent
	 * 
	 * @param child index of element in list
	 * @return index of element's parent in list
	 */

	private int parent(int child) {
		if (child > 0) {
			return ((child - 1) / 2);
		} else {
			return -1;
		}
	}

	/*********************************************************
	 * These are optional private methods that may be useful
	 *********************************************************/

	/**
	 * Push down the root element
	 * 
	 * @return the index in the list where the element is finally stored
	 */
	private int pushDownRoot() {
		return pushDown(0); // pushes down the start index of the root which is 0
	}

	/**
	 * Percolate up the last leaf in the heap, i.e. the most recently added element
	 * which is stored in the last slot in the list
	 * 
	 * @return the index in the list where the element is finally stored
	 */
	public int percolateUpLeaf() {
		return percolateUp(this.heap.size() - 1);

	}

	/**
	 * Returns true if element is a leaf in the heap
	 * 
	 * @param i index of element in heap
	 * @return true if element is a leaf
	 */
	private boolean isLeaf(int i) {
		if (this.location.containsValue(left(i))) { // Only checks the left child as we are filling the map left to
													// right
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Returns true if element has two children in the heap
	 * 
	 * @param i index of element in the heap
	 * @return true if element in heap has two children
	 */
	private boolean hasTwoChildren(int i) {//
		if (this.location.containsValue(left(i)) && this.location.containsValue(right(i))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Print the underlying list representation
	 */
	public void printHeap() { // TODO
		for (int i = 0; i < this.heap.size(); i++) {
			System.out.println(this.heap.get(i).toString());
		}

	}

	/**
	 * Print the entries in the location map
	 */
	public void printMap() {// TODO
		System.out.println(location.toString());
	}

}