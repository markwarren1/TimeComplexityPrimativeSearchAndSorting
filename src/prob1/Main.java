package prob1;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		arraySearchBuilder();
		//arraySortBuilder();
	}
	//TESTS
	
	//see if values were generated correctly
	public static void printArray(int[] a) {
		System.out.print("---Printing (first few elements) of array with size: " + a.length +  "---\n");
		//print values
		for(int i = 0; i < a.length; i ++) {
			System.out.print(i + ": " + a[i] + "\n");
		}
	}
	
	//MAIN
	
	public static void arraySearchBuilder() {
		for(int i = 10; i <= 100000;) {
			System.out.print("----T(n) for ARRAY SIZE SEARCH " + i + " ----\n");
			int[] arr = new int[i];
			generateNums(arr);
			int target = generateTargetNumber();
			
			//linear
			double linearT1 = System.nanoTime();
			boolean isFoundLinear = linearSearch(arr, target);
			double linearT2 = System.nanoTime();
			
			Arrays.sort(arr); //sorts array for binary search (N log N)
			
			//binary
			double binaryT1 = System.nanoTime();
			boolean isFoundBinary = binarySearch(arr, target, 0, arr.length);
			double binaryT2 = System.nanoTime();
			
			//Results
			String l = String.format("\nThe target number was: %d", target);
			l += String.format("\n\nLinear--\n");
			l += String.format("Total time taken %.2f\n", linearT2 - linearT1);
			l += String.format("Element found: %b\n\n", isFoundLinear);
			l += String.format("Binary--\n");
			l += String.format("Total time taken %.2f\n", binaryT2 - binaryT1);
			l += String.format("Element found: %b\n\n", isFoundBinary);
			System.out.println(l);
			
			//increment array
			i = i * 10;
		}
	}
	
	//GENERATE ARRAYS FOR SORTING
	public static void arraySortBuilder() {
		for(int i = 10; i <= 100000;) {
			System.out.print("----T(n) for ARRAY SIZE SORT" + i + " ----\n");
			int[] arr = new int[i];
			generateNums(arr);
//			int target = generateTargetNumber();
			
			//bubble
			//selection
			//insertion
			//REMEMBER EXCEL SHEET
			
			//Results
//			String l = String.format("\nThe target number was: %d", target);
//			l += String.format("\n\nLinear--\n");
//			l += String.format("Total time taken %.2f\n", linearT2 - linearT1);
//			l += String.format("Element found: %b\n\n", isFoundLinear);
//			l += String.format("Binary--\n");
//			l += String.format("Total time taken %.2f\n", binaryT2 - binaryT1);
//			l += String.format("Element found: %b\n\n", isFoundBinary);
//			System.out.println(l);
			
			//increment array
			i = i * 10;
		}
	}
	
	
	//SEARCHES
	
	//linear search
	public static boolean linearSearch(int[] a, int t) {
		for(int num : a) {
			if (num == t){
				return true;
			}
		}
		return false;
	}
	
	//binary search
	public static boolean binarySearch(int[] a, int t, int low, int high) {
		while(low <= high) {
			int mid = (high + low)/2;
			if (t == a[mid]) {
				return true;
			}
			else if (t > a[mid]) {
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
		}
		return false;
	}
	
	//HELPER Methods
	
	//generate target number
	public static int generateTargetNumber() {
		return (int)(Math.random() * 100001);
	}
	//generate values 1-100000 in array
	public static void generateNums(int[] a) {
		for(int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random() * 100001);
		}
	}

}
