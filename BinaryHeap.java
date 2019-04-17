// This is a minimum heap class, the int in the root is always the smallest
public class BinaryHeap
{
	int size;
	int[] data;

	// the constuctor, start the array of size 10 and size(number of its contain) to be 0
	BinaryHeap()
	{
		data = new int[10];
		size = 0;
	}

	// add a value to the array. Firstly add to the end and compare it with its parents, if it is smaller, then swap
	public void add(int value)
	{
		if(size == data.length)
		{
			grow_array();
		}
		data[size] = value;
		size++;
		int cur = size-1;
		int parent = (cur-1)/2;
		while (parent >= 0 && data[cur] < data[parent])
		{
			swap(data,cur,parent);
			cur = parent;
			parent = (cur-1)/2;
		}
	}

	// double the length of the array
	public void grow_array()
	{
		int newArr[] = new int[data.length*2];
		for(int i = 0; i < data.length; i++)
		{
			newArr[i] = data[i];
		}
		data = newArr;
	}

	// swap the root and the end of the array, remove the end, let the root compare with its children, if it is bigger, swap
	public int remove()
	{
		if(size == 0)
		{
			throw new Exception("Error!");
		}
		swap(data,0,size-1);
		size--;
		if(size != 0)
		{
			shiftDown(0);
		}
		return data[size];
	}

	// the function to make the parent compare with its children, if the parent is bigger, then move down
	public void shiftDown(int rootpos)
	{
		while((2*rootpos+1 < size && data[rootpos] > data[2*rootpos+1]) || (2*rootpos+2 < size && data[rootpos] > data[2*rootpos+2]))
		{
			if((2*rootpos+1 < size && data[rootpos] > data[2*rootpos+1]) && (2*rootpos+2 < size && data[rootpos] > data[2*rootpos+2]))
			{
				if(data[2*rootpos+1] <= data[2*rootpos+2])
				{
					swap(data,rootpos,2*rootpos+1);
					rootpos = 2*rootpos+1;
				}
				else
				{
					swap(data, rootpos, 2*rootpos+2);
					rootpos = 2*rootpos+2;
				}
			}
			else
			{
				if (2*rootpos+1 < size && data[rootpos] > data[2*rootpos+1])
				{
					swap(data,rootpos,2*rootpos+1);
					rootpos = 2*rootpos+1;
				}
				else if (2*rootpos+2 < size && data[rootpos] > data[2*rootpos+2])
				{
					swap(data, rootpos, 2*rootpos+2);
					rootpos = 2*rootpos+2;
				}
			}
		}
	}

	// the swap function, exchange the values in two positions in the array
	public void swap(int[] arr, int pos1, int pos2)
	{
		int temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}
}



