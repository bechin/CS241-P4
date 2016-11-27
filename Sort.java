import java.util.Random;

public class Sort{

	public static void main(String[] args){
		Random random = new Random();
//		int size = 10;
		int[] array  = {3,2,1,4,4,4,4};
//		for(int i = 0; i < array.length; i++)
//			array[i] = random.nextInt(100);
		System.out.print("[");
		for(int e: array){
			System.out.print(e + ",");
		}
		System.out.println("]\n" +
				   "----------------------------------------");
		quickSort(array, 0 , array.length-1);
                System.out.print("[");
		for(int e: array){
                        System.out.print(e + ",");
                }
                System.out.println("]");
		System.out.println(verify(array));
	}

	public static void quickSort(int[] a, int p, int q){
		if(p<q){
			int pivotIndex = (p+q)/2;
			int pos = partition(a , p, q, pivotIndex);
			quickSort(a, p, pos);
			quickSort(a, pos+1, q);
		}
	}

	private static int partition(int[] a, int p, int q, int pivotIndex){
		swap(a,pivotIndex,q);
		int pos = p;
		for(int i = p; i < q-1; i++){
			if(a[i]<=a[q])
				swap(a,i,pos++);
		}
		swap(a,pos,q);
		return pos;
	}

	public static void sSort(int[] array){
		for(int i = 0; i < array.length-1; i++){
			int minIndex = i;
			for(int j = i+1; j < array.length; j++){
				if(array[j] < array[minIndex])
					minIndex = j;
			}
		//	System.out.println(array[minIndex]);
			swap(array, i , minIndex);
		//	for(int e: array){
		//		System.out.print(e + ",");
		//	}
		//	System.out.println();
		}
	}

	private static void swap(int[] array, int i, int minIndex){
		int temp = array[i];
		array[i] = array[minIndex];
		array[minIndex] = temp;
	}

	public static boolean verify(int[] array){
		for(int i = 0; i < array.length-1; i++){
			if(array[i]>array[i+1])
				return false;
		}
		return true;
	}

}
