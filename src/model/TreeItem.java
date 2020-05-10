package model;

public class TreeItem {
	
	private long number;
	private TreeItem left;
	private TreeItem right;
	private TreeItem father;
	
	public TreeItem (long n) {
		number = n;
		left = null;
		right = null;
	}

	public long getNumber() {
		return number;
	}

	public TreeItem getLeft() {
		return left;
	}

	public TreeItem getRight() {
		return right;
	}

	public TreeItem getFather() {
		return father;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public void setLeft(TreeItem left) {
		this.left = left;
	}

	public void setRight(TreeItem right) {
		this.right = right;
	}

	public void setFather(TreeItem father) {
		this.father = father;
	}
}
