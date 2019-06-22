package basetest.datastructure;

public class SortTest {

	public static void main(String...args) {
		int[] data = {9, 8, 6, 1, 0, 5, 2, 4, 3, 7};
		
		//Bubble Sort
		/*
		for(int i = 0; i < data.length; i++) {
			for(int j = i; j < data.length; j++) {
				if(data[i] > data[j]) {
					int temp = data[j];
					data[j] = data[i];
					data[i] = temp;
				}
			}
		}
		*/
		
		//Selection sort
		/*
		for(int i = 0; i < data.length; i++) {
			int min = i;
			for(int j = i + 1; j < data.length; j++) {
				if(data[min] > data[j]) {
					min = j;
				}
			}
			int temp = data[i];
			data[i] = data[min];
			data[min] = temp;
		}
		*/
		
		//Insertion sort
		/*
		for(int i = 1; i < data.length; i++) {
			int key = data[i];
			int j = i - 1;
			while(j >= 0 && data[j] > key) {
				data[j+1] = data[j];
				j = j - 1;
			}
			data[j + 1] = key;
		}
		*/
		
		
		
		
		for(int i:data) {
			System.out.println(i);
		}
	}
}
