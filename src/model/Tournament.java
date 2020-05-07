package model;

import java.util.ArrayList;
import java.util.Random;

public class Tournament {
	
	private ArrayList<Long> arrayList;
	private TreeItem root;
	private LinkedListItem first;
	
	public Tournament () {
		arrayList = new ArrayList<Long>();
		root = null;
		first = null;
	}
	
	//The real deal
	public long[] generateRandomNumbers (int q) {
		Random r = new Random();
		long seed = r.nextLong();
		r.setSeed(seed);
		
		long[] numbers = new long[q];
		for (int i = 0; i < q; i++) {
			numbers[i] = r.nextLong();
		}
		return numbers;
	}
	
	//ArrayList methods
	public void addArrayList(long[] n) {
		for (int i = 0; i < n.length; i++) {
			arrayList.add(new Long(n[i]));
		}
	}
	
	public boolean searchArrayListIterative(long toSearch) {
		boolean found = false;
		for (int i = 0; i < arrayList.size() && !found; i++) {
			if (arrayList.get(i) == toSearch) {
				found = true;
			}
		}
		return found;
	}
	
	public boolean searchArrayListRecursive(long toSearch, int index) {
		boolean found = false;
		if (arrayList.get(index) == toSearch) {
			found = true;
		}
		
		else if (index != 0) {
			found = searchArrayListRecursive(toSearch, index - 1);
		}
		return found;
	}
	
	public boolean removeArrayListIterative(long toRemove) {
		boolean removed = false;
		for (int i = 0; i < arrayList.size() && !removed; i++) {
			if (arrayList.get(i) == toRemove) {
				arrayList.remove(i);
				removed = true;
			}
		}
		return removed;
	}
	
	public boolean removeArrayListRecursive(long toSearch, int index) {
		boolean removed = false;
		if (arrayList.get(index) == toSearch) {
			arrayList.remove(index);
			removed = true;
		}
		
		else if (index != 0) {
			removed = searchArrayListRecursive(toSearch, index - 1);
		}
		return removed;
	}
	
	//Linked List methods
	public void addLinkedListIterative (long[] q) {
		for (int i = 0; i < q.length; i++) {
			LinkedListItem toAdd = new LinkedListItem(q[i]);
			
			if (first == null) {
				first = toAdd;
			}
			else {
				LinkedListItem actual = first;
				//Goes to the last item
				while (actual.getNext() != null) {
					actual = actual.getNext();
				}
				if (actual == first.getNext()) {
					toAdd.setPrev(first);
					first.setNext(toAdd);
				}
				else {
					toAdd.setPrev(actual);
					actual.setNext(toAdd);
				}
			}
		}
	}
	
	
	//Get Methods
	public ArrayList<Long> getArrayList() {
		return arrayList;
	}

	public TreeItem getRoot() {
		return root;
	}

	public LinkedListItem getFirst() {
		return first;
	}

	//Set Methods
	public void setArrayList(ArrayList<Long> arrayList) {
		this.arrayList = arrayList;
	}

	public void setRoot(TreeItem root) {
		this.root = root;
	}

	public void setFirst(LinkedListItem first) {
		this.first = first;
	}
}
