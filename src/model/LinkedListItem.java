package model;

public class LinkedListItem {
	
	private long number;
	private LinkedListItem next;
	private LinkedListItem prev;
	
	public LinkedListItem (long n) {
		number = n;
		next = null;
		prev = null;
	}

	public long getNumber() {
		return number;
	}

	public LinkedListItem getNext() {
		return next;
	}

	public LinkedListItem getPrev() {
		return prev;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public void setNext(LinkedListItem next) {
		this.next = next;
	}

	public void setPrev(LinkedListItem prev) {
		this.prev = prev;
	}
}
