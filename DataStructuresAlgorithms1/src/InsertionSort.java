
public class InsertionSort {
	public static void main(String[] args) {
		int[] arr= {76,225,149,73,75,85};
//		insertSort(arr);
//		for(int x: arr) {
//			System.out.print(x+" ");
//		}
//		System.out.println();
		insertSortDesc(arr);
		for(int x: arr) {
			System.out.print(x+" ");
		}
	}

	private static void insertSort(int[] arr) {
		int n = arr.length;
		for(int i =1;i<n;i++) {
			int key = arr[i];
			int j = i-1;
			while(j>=0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}
	
	private static void insertSortDesc(int[] arr) {
		int n = arr.length;
		for(int i =1;i<n;i++) {
			int key = arr[i];
			int j = i-1;
			while(j>=0 && arr[j] < key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
			for(int x: arr) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
		
		System.out.println();
	}
	
}
