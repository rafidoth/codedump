
public class QuickSort {
	public static void main(String[] args) {
		int[] arr= {4,1, 6, 8, 9, 0, 5, 3, 2, 11, 10, 7};
		quickSorter(arr);
		for(int x: arr) {
			System.out.print(x+" ");
		}
	}
	
	private static void quickSorter(int[] arr) {
		qs(arr, 0, arr.length-1);
	}
	
	private static void qs(int[] arr , int start, int end) {
		if(start<end) {
			int partition = partitionL(arr, start, end);
			qs(arr, start, partition-1);
			qs(arr, partition+1, end);
		}
	}
	private static int partitionL(int[] arr, int start, int end) {
		int pivot = arr[end];
		int i = start -1;
		for(int j = start;j<=end-1;j++) {
			if(arr[j]<pivot) {
				i++;
				
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		int temp = arr[end];
		arr[end] = arr[i+1];
		arr[i+1] = temp;
		
		return i+1;
	}
	
	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[start];
		int i = start;
		int j = end;
		while(i<j) {
			while(arr[i]<= pivot  && i<end){
				i++;
			}
			while(arr[j]>pivot && j > start) {
				j--;
			}
			if(i<j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		int temp = arr[start];
		arr[start] = arr[j];
		arr[j] = temp;
		
		return j;
	}
}
