package threads;

import model.AnimationManager;
import model.Tournament;
import ui.TournamentGUI;

public class ThreadManager extends Thread{
	
	private Tournament t;
	
	private TournamentGUI tGUI;
	
	private int category;
	//category: 0 = iterative, 1 = recursive
	private int mode;
	//mode: 0 = add, 1 = search, 2 = remove
	private int elements;
	
	private long seed;
	
	private TreeThread treeThread;
	
	private ListThread listThread;
	
	private ArrayThread arrayThread;
	
	private AnimationManager am;
	
	public ThreadManager(Tournament t, TournamentGUI tGUI, AnimationManager am, int category, 
			int mode, int elements, long seed) {
		this.t = t;
		this.tGUI = tGUI;
		this.am = am;
		this.category = category;
		this.mode = mode;
		this.elements = elements;
		this.seed = seed;
	}
	
	@Override
	public void run () {
		try {
			
			t.reset();
			switch (category) {
			//Iterative
			case 0:
				//Add
				if (mode == 0) {
					initiateAddIterative(true);

				} else if (mode == 1) {
					initiateSearchIterative();
				}else {
					initiateRemoveIterative();
				}
				break;
			//Recursive
			case 1:
				//Add
				if (mode == 0) {
					initiateAddRecursive();

				} else if (mode == 1) {
					initiateSearchRecursive();
				}else {
					initiateRemoveRecursive();
				}
				break;
			}
			
		} catch (InterruptedException ie) {
			
		}
	}
	
	public void initiateAddIterative (boolean protagonist) throws InterruptedException {
    	treeThread = new TreeThread (t, tGUI, 0, 0, elements, seed);
    	listThread = new ListThread (t, tGUI, 0, 0, elements, seed);
    	arrayThread = new ArrayThread (t, tGUI, 0, 0, elements, seed);

    	treeThread.setDaemon(true);
    	listThread.setDaemon(true);
    	arrayThread.setDaemon(true);
    	
    	if (protagonist) {
    		tGUI.getTimerThread().start();
    		tGUI.getCircleThread().start();
    	}
    	treeThread.start();
    	listThread.start();
    	arrayThread.start();
    	
    	treeThread.join();
    	listThread.join();
    	arrayThread.join();
	}
	
	public void initiateAddRecursive () {
    	treeThread = new TreeThread (t, tGUI, 1, 0, elements, seed);
    	listThread = new ListThread (t, tGUI, 1, 0, elements, seed);
    	arrayThread = new ArrayThread (t, tGUI, 1, 0, elements, seed);
    	
    	treeThread.setDaemon(true);
    	listThread.setDaemon(true);
    	arrayThread.setDaemon(true);
    	
		tGUI.getTimerThread().start();
		tGUI.getCircleThread().start();
    	treeThread.start();
    	listThread.start();
    	arrayThread.start();
	}

	public void initiateSearchIterative () throws InterruptedException {
		initiateAddIterative(false);
    	
		treeThread = new TreeThread (t, tGUI, 0, 1, elements, seed);
		listThread = new ListThread (t, tGUI, 0, 1, elements, seed);
		arrayThread = new ArrayThread (t, tGUI, 0, 1, elements, seed);

		treeThread.setDaemon(true);
		listThread.setDaemon(true);
		arrayThread.setDaemon(true);
		
		treeThread.start();
		listThread.start();
		arrayThread.start();	
		tGUI.getTimerThread().start();
		tGUI.getCircleThread().start();
	}
	
	public void initiateSearchRecursive () throws InterruptedException {
		initiateAddIterative(false);

		treeThread = new TreeThread (t, tGUI, 1, 1, elements, seed);
		listThread = new ListThread (t, tGUI, 1, 1, elements, seed);
		arrayThread = new ArrayThread (t, tGUI, 1, 1, elements, seed);

		treeThread.setDaemon(true);
		listThread.setDaemon(true);
		arrayThread.setDaemon(true);

		tGUI.getTimerThread().start();
		tGUI.getCircleThread().start();
		treeThread.start();
		listThread.start();
		arrayThread.start();	
	}
	
	public void initiateRemoveIterative () throws InterruptedException {
		initiateAddIterative(false);

		treeThread = new TreeThread (t, tGUI, 0, 2, elements, seed);
		listThread = new ListThread (t, tGUI, 0, 2, elements, seed);
		arrayThread = new ArrayThread (t, tGUI, 0, 2, elements, seed);

		treeThread.setDaemon(true);
		listThread.setDaemon(true);
		arrayThread.setDaemon(true);

		tGUI.getTimerThread().start();
		tGUI.getCircleThread().start();
		treeThread.start();
		listThread.start();
		arrayThread.start();
	}
	
	public void initiateRemoveRecursive () throws InterruptedException {
		initiateAddIterative(false);

		treeThread = new TreeThread (t, tGUI, 1, 2, elements, seed);
		listThread = new ListThread (t, tGUI, 1, 2, elements, seed);
		arrayThread = new ArrayThread (t, tGUI, 1, 2, elements, seed);

		treeThread.setDaemon(true);
		listThread.setDaemon(true);
		arrayThread.setDaemon(true);

		tGUI.getTimerThread().start();
		tGUI.getCircleThread().start();
		treeThread.start();
		listThread.start();
		arrayThread.start();
	}

	public Tournament getT() {
		return t;
	}

	public TournamentGUI gettGUI() {
		return tGUI;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public int getElements() {
		return elements;
	}

	public void setElements(int elements) {
		this.elements = elements;
	}

	public long getSeed() {
		return seed;
	}

	public void setSeed(long seed) {
		this.seed = seed;
	}

	public TreeThread getTreeThread() {
		return treeThread;
	}

	public ListThread getListThread() {
		return listThread;
	}

	public ArrayThread getArrayThread() {
		return arrayThread;
	}
}
