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
				toAdd.setPrev(actual);
				actual.setNext(toAdd);

			}
		}
	}

	public void addLinkedListRecursive (long[] q, int index, LinkedListItem actual) {
		if (index < q.length) {
			LinkedListItem toAdd = new LinkedListItem(q[index]);
			if (first == null) {
				first = toAdd;
			}
			
			else {
				toAdd.setPrev(actual);
				actual.setNext(toAdd);
			}
			addLinkedListRecursive (q, index + 1, toAdd);
		}
	}
	
	public boolean searchLinkedListIterative (long toSearch) {
		boolean found = false;
		LinkedListItem actual = first;
		while (actual != null && !found) {
			if (actual.getNumber() == toSearch) {
				found = true;
			}
			else {
				actual = actual.getNext();
			}
		}
		return found;
	}
	
	public boolean searchLinkedListRecursive (long toSearch, LinkedListItem actual) {
		boolean found = false;
		if (actual != null) {
			if (actual.getNumber() == toSearch) {
				found = true;
			}
			else {
				found = searchLinkedListRecursive (toSearch, actual.getNext());
			}
		}
		return found;
	}
	
	public boolean removeLinkedListIterative (long toRemove) {
		boolean removed = false;
		LinkedListItem actual = first;
		
		while (actual != null && !removed) {
			if (actual.getNumber() == toRemove) {
				LinkedListItem prev = actual.getPrev();
				LinkedListItem next = actual.getNext();
				
				//Preventing a nullPointer in first item
				if (prev != null) {
					prev.setNext(next);
				}
				//Preventing a nullPointer in last item
				if (next != null) {
					next.setPrev(prev);
				}
				//Setting new first
				if (actual == first) {
					first = actual.getNext();
				}
				removed = true;
			}
			else {
				actual = actual.getNext();
			}
		}
		return removed;
	}
	
	public boolean removeLinkedListRecursive (long toRemove, LinkedListItem actual) {
		boolean removed = false;
		if (actual != null) {
			if (actual.getNumber() == toRemove) {
				LinkedListItem prev = actual.getPrev();
				LinkedListItem next = actual.getNext();

				//Preventing a nullPointer in first item
				if (prev != null) {
					prev.setNext(next);
				}
				//Preventing a nullPointer in last item
				if (next != null) {
					next.setPrev(prev);		
				}
				//Setting new first
				if (actual == first) {
					first = next;
					first.setPrev(null);
				}
				removed = true;
			}
			else {
				removed = searchLinkedListRecursive (toRemove, actual.getNext());
			}
		}
		return removed;
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
