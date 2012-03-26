package dk.itu.kf04.g4tw.RoadKill;

/**
 * An array that can be resized depending on the input.
 * @param <Item>  The type of the elements to store.
 */
public class DynamicArray<Item> {

	private Item[] a = (Item[]) new Object[1];
	private int N = 0;
	
    /**
     * Adds an element to the array.
     * @param item  The item to add.
     */
	public void add(Item item)
	{
		if(N == a.length)
			resize(a.length*2);
		
		a[N++] = item;
	}
	
    /**
     * Removes an element from its index.
     * @param index  The index of the element to remove.
     */
	public void remove(int index)
	{
		if(isEmpty())
			throw new RuntimeException("The array is empty! FFS... -.-''");
		
		a[index] = a[N];
		a[N] = null;
		N--;
		
		if(N > 0 && N == a.length/4)
			resize(a.length/2);
	}
	
	/**
	 * Replaces an item with a new one.
	 * @param oldItem  The item to replace
	 * @param newItem  The item to insert
     * @return a boolean value to indicate success or failure.
	 */
	public boolean replace(Item oldItem, Item newItem) {
        for (int i = 0; i < a.length; i++) {
            if (a[i].equals(oldItem)) { // equals because the Integer type is a moron and can not understand ==
                a[i] = newItem;
                return true;
            }
        }
        return false;
	}
	
    /**
     * Is the array empty?!
     */
	public boolean isEmpty()
	{
		return N == 0;
	}
	
    /**
     * Take a wild guess.
     */
	public int length()
	{
		return N;
	}
	
    /**
     * Retrieves the element from the given index.
     * @param index  The index of the element to remove.
     */
	public Item get(int index)
	{
		return a[index];
	}
	
    /**
     * Resizes the array (hence the "dynamic" in DynamicArray).
     */
	private void resize(int length)
	{
		Item[] temp = (Item[]) new Object[length];
		
		for(int i = 0; i < N; i++)
			temp[i] = a[i];
		
		a = temp;
	}
}
