package basetest.datastructure;

public class SearchingTest {

	
	public static void main(String...args) {
		int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int search = 9;
		
		//Linear sort - O (n)
		int i = 0;
		do {
			if(data[i] == search) {
				System.out.println("Match found!");
				break;
			}
			i++;
		} while(i < data.length);
		System.out.println("Linear Search Tries: " + (i + 1));
		
		//Binary search Note: Data must be sorted - O (log(n))
		i = 0;
		int f = 0;
		int l = data.length;
		int m = 0;
		do {
			m = (f + l) /2;
			if(data[m] == search) {
				System.out.println("Match found!");
				break;
			}
			else if(data[m] > search) {
				l = m;
			}
			else if(data[m] < search) {
				f = m;
			}
			i++;
		} while(i < data.length);
		System.out.println("Binary Search Tries: " + (i + 1));
		
		//Jump Search - O(UnderRoot(n))
		i = 0;
		int j = 3;
		int ji = 0;
		int start = 0;
		int end = 0;
		int tries = 0;
		do {
			if(data[ji] == search) {
				System.out.println("Match found!");
				break;
			}
			else if(data[ji] > search) {
				end = ji;
				break;
			}
			else if(data[ji] < search) {
				ji += j;
			}
			tries++;
			i++;
		} while(i < data.length);
		for(int x = start; x < end; x++) {
			if(data[x] == search) {
				System.out.println("Match found!");
				tries++;
				break;
			}
		}
		System.out.println("Jump Search Tries: " + tries);
		
		//Interpolation Search
		i = 0;
		f = 0;
		l = data.length - 1;
		m = 0;
		do {
			m = f + ((search - data[f])*(l-f)/(data[l] - data[f]));
			if(data[m] == search) {
				System.out.println("Match found!");
				break;
			}
			else if(data[m] > search) {
				l = m;
			}
			else if(data[m] < search) {
				f = m;
			}
			i++;
		} while(i < data.length);
		System.out.println("Interpolation Search Tries: " + (i + 1));
		
		
		
		
	}
	
}
