package model;

import java.util.ArrayList;
import java.util.Random;

public class Tournament {
	
	private ArrayList<Long> arrayList;
	private TreeItem root;
	private LinkedListItem first;
	private boolean z;
	
	public Tournament () {
		arrayList = new ArrayList<Long>();
		root = null;
		first = null;
		z = false;
	}
	
	//The real deal
	public long generateRandomLong (Random r) {
		return r.nextLong();
	}
	
	//ArrayList methods
	public void addArrayList(long n) {
			arrayList.add(new Long(n));
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
		
		else if (index < arrayList.size() - 1) {
			found = searchArrayListRecursive(toSearch, index + 1);
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
		if (index < arrayList.size()) {
			if (arrayList.get(index) == toSearch) {
				arrayList.remove(index);
				removed = true;
			}

			else {
				removed = removeArrayListRecursive(toSearch, index + 1);
			}
		}
		return removed;
	}
	
	//Linked List methods
	public void addLinkedListIterative (long q) {
		LinkedListItem toAdd = new LinkedListItem(q);

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


	public void addLinkedListRecursive (long q, LinkedListItem actual) {
		LinkedListItem toAdd = new LinkedListItem(q);
		if (first == null) {
			first = toAdd;
		}

		else if (actual.getNext() == null){
			toAdd.setPrev(actual);
			actual.setNext(toAdd);

		}
		else {
			addLinkedListRecursive (q, toAdd);
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
					first.setNext(null);
					first = next;
					first.setPrev(null);
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
					first.setNext(null);
					first = next;
					first.setPrev(null);
				}
				removed = true;
			}
			else {
				removed = removeLinkedListRecursive (toRemove, actual.getNext());
			}
		}
		return removed;
	}

	//Binary three methods
	public void addBinaryTreeIterative (long n) {

		TreeItem actual = root;
		if (root == null) {
			root = new TreeItem (n);
		}
		else {
			boolean done = false;
			while (!done) {
				//Left
				if (n <= actual.getNumber()) {
					if (actual.getLeft() == null) {
						actual.setLeft(new TreeItem(n));
						actual.getLeft().setFather(actual);
						done = true;
					}
					else {
						actual = actual.getLeft();
					}
				}
				//Right
				else {
					if (actual.getRight() == null) {
						actual.setRight(new TreeItem(n));
						actual.getRight().setFather(actual);
						done = true;
					}
					else {
						actual = actual.getRight();
					}					
				}
			}
		}

	}

	public void addBinaryTreeRecursive (long n, TreeItem actual) {
		if (root == null) {
			root = new TreeItem (n);
		}
		else {
			//Left
			if (n <= actual.getNumber()) {
				if (actual.getLeft() == null) {
					actual.setLeft(new TreeItem(n));
					actual.getLeft().setFather(actual);
				}
				else {
					addBinaryTreeRecursive (n, actual.getLeft());
				}
			}
			//Right
			else {
				if (actual.getRight() == null) {
					actual.setRight(new TreeItem(n));
					actual.getRight().setFather(actual);
				}
				else {
					addBinaryTreeRecursive (n, actual.getRight());
				}					
			}
		}
	}

	public boolean searchBinaryTreeIterative (long toSearch) {
		boolean found = false;
		TreeItem actual = root;
		while (actual != null && !found) {
			if (toSearch == actual.getNumber()) {
				found = true;
			}
			else if (toSearch < actual.getNumber()) {
				actual = actual.getLeft();
			}
			else {
				actual = actual.getRight();
			}
		}
		return found;
	}

	public boolean searchBinaryTreeRecursive (long toSearch, TreeItem actual) {
		boolean found = false;
		if (actual.getNumber() == toSearch) {
			found = true;
		}
		else if (toSearch < actual.getNumber()) {
			if (actual.getLeft()!=null) {
				found = searchBinaryTreeRecursive (toSearch, actual.getLeft());
			}
		}
		else {
			if (actual.getRight() != null) {
				found = searchBinaryTreeRecursive (toSearch, actual.getRight());
			}
		}
		return found;
	}
	
	public boolean removeBinaryTreeIterative (long toRemove) {
		boolean removed = false;
		TreeItem actual = root;
		while (actual != null && !removed) {
			if (actual.getNumber() == toRemove) {
				//If it has two children
				if (actual.getLeft() != null && actual.getRight() != null) {
					removeBinaryTreeTwoChildren (actual);
				}
				//If it has 1 children
				else if (actual.getLeft() != null || actual.getRight() != null) {
					removeBinaryTreeOneChild (actual);
				}
				//If it doesn't have children
				else if (actual.getLeft() == null && actual.getRight() == null) {
					removeBinaryTreeNoChildren (actual);
				}
				removed = true;
			}
			else if (toRemove < actual.getNumber()) {
				actual = actual.getLeft();
			}
			else {
				actual = actual.getRight();
			}
		}
		return removed;
	}

	public boolean removeBinaryTreeRecursive (long toRemove, TreeItem actual) {
		boolean removed = false;
		if (actual.getNumber() == toRemove) {
			//If it has two children
			if (actual.getLeft() != null && actual.getRight() != null) {
				removeBinaryTreeTwoChildren (actual);
			}
			//If it has 1 children
			else if (actual.getLeft() != null || actual.getRight() != null){
				removeBinaryTreeOneChild (actual);
			}
			//If it doesn't have children
			else if (actual.getLeft() == null && actual.getRight() == null) {
				removeBinaryTreeNoChildren (actual);
			}
			removed = true;
		}
		else if (toRemove < actual.getNumber()) {
			if (actual.getLeft() != null) {
				removed = removeBinaryTreeRecursive (toRemove, actual.getLeft());
			}
		}
		else {
			if (actual.getRight() != null) {
				removed = removeBinaryTreeRecursive (toRemove, actual.getRight());
			}
		}
		return removed;
	}
	
	private void removeBinaryTreeNoChildren (TreeItem goner) {
		if (goner != root) {
			TreeItem father = goner.getFather();

			if (father.getLeft() == goner) {
				father.setLeft(null);
			}
			else {
				father.setRight(null);
			}
		}
		else {
			root = null;
		}
	}
	private void removeBinaryTreeOneChild (TreeItem goner) {
		TreeItem child;
		if (goner.getLeft() != null) {
			child = goner.getLeft();
		}
		else {
			child = goner.getRight();
		}

		if (goner != root) {
			TreeItem father = goner.getFather();
			child.setFather(father);
			
			if (father.getLeft() == goner) {
				father.setLeft(child);
			}
			else {
				father.setRight(child);
			}
		}
		else {
			root = child;
		}
	}
	
	private void removeBinaryTreeTwoChildren (TreeItem goner) {
		TreeItem minor = searchMinor (goner);
		
			//Minor has no child
			if (minor.getRight() == null) {
				removeBinaryTreeNoChildren(minor);
			}
			//Minor has a child
			else {
				removeBinaryTreeOneChild(minor);
			}
			//New references to minor
			TreeItem leftChild = goner.getLeft();
			TreeItem rightChild = goner.getRight();
			TreeItem father = goner.getFather();
			
			minor.setLeft(leftChild);
			minor.setRight(rightChild);
			minor.setFather(father);
			//References around minor 
			if (leftChild != null) {
				leftChild.setFather(minor);
			}
			
			if (rightChild != null) {
				rightChild.setFather(minor);
			}

			if(goner != root && goner == father.getLeft()) {
				father.setLeft(minor);
			}
			else if (goner != root) {
				father.setRight(minor);
			}
			if (goner == root) {
				root = minor;
			}
	}
	
	private TreeItem searchMinor(TreeItem father) {
		TreeItem minor = father.getRight();
		
		while (minor.getLeft() != null) {
			
			minor = minor.getLeft();	
		}
		return minor;
	}
	
	public String toStringBinaryTreePostorder (TreeItem actual, String temp) {
		
        String toString = temp;
        
        if (actual.getLeft() != null) {
        	toString = toStringBinaryTreePostorder(actual.getLeft(), toString);  
        }
        
        if (actual.getRight() != null) {
        	toString = toStringBinaryTreePostorder(actual.getRight(), toString);  
        }
        
        return toString += actual.getNumber() + " ";  
	}
	
	public void reset () {
		root = null;
		first = null; 
		arrayList = new ArrayList<Long>();
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
	
	public String LinkedListToString () {
		LinkedListItem actual = first;
		String toString = "";
		while (actual != null) {
			toString += actual.getNumber() + ";";
			actual = actual.getNext();
		}
		return toString;
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

	public boolean isZ() {
		return z;
	}

	public void setZ(boolean z) {
		this.z = z;
	}
}
