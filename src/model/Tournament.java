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
	public void generateRandomNumber (int q) {
		Random r = new Random();
		r.nextLong();
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
