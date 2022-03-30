class Student{
	public int roll_no;
	public String name;
	Student(int roll_no, String name){
		this.roll_no = roll_no;
		this.name = name;
	}
}

public class Array {
	public static void main(String[] args) {
		
		// cloning of one-dimensional arrays
//		int intarr[] = {1,2,3};
//		
//		int clonearr[] = intarr.clone();
//		
//		// Will print false as deep copy is created
//      // for one-dimensional array
//		System.out.println(intarr == clonearr);
//		
//		for (int i = 0; i < clonearr.length; i++) {
//            System.out.print(clonearr[i]+" ");
//        }
		
		// Cloning of multi-dimensional array.
		// A clone of a multi-dimensional array (like Object[][]) is a “shallow copy” however, 
		// which is to say that it creates only a single new array with each element array a
		// reference to an original element array, but subarrays are shared.
		
		int intarr[][] = {{1,2,3}, {4,5,6}, {7,8,9}};
		
		int clonearr[][] = intarr.clone();
		
		// will print false
		System.out.println(intarr == clonearr);
		
		// will print true as shallow copy is created
        // i.e. sub-arrays are shared
		System.out.println(intarr[0] == clonearr[0]);
		System.out.println(intarr[1] == clonearr[1]);
		
		
//		// Class Objects for Arrays
//		int intarr[] = new int[5];
//		byte bytearr[] = new byte[5];
//		short shortarr[] = new short[5];
//		String strarr[] = new String[5];
//		
//		System.out.println("intarr class " + intarr.getClass());
//		System.out.println("intarr superclass "+ intarr.getClass().getSuperclass());
//		System.out.println("bytearr class "+ bytearr.getClass());
//		System.out.println("shortarr class "+ shortarr.getClass());
//		System.out.println("strarr class "+ strarr.getClass());
//		
		
		
		// return of array from method m1
//		int arr[] = m1();
//		
//		for(int i=0; i<arr.length; i++) {
//			System.out.println("Element at " + i + ": " + arr[i]);
//		}
		
		
		
		//Populating the array of objects of class Student
//		Student[] arr;
//		
//		arr = new Student[5];
//		
//		arr[0] = new Student(1, "Aman");
//		arr[1] = new Student(2, "Bansal");
//		arr[2] = new Student(3, "Tyagi");
//		arr[3] = new Student(4, "Sharma");
//		arr[4] = new Student(5, "Gupta");
//		
//		for(int i=0; i<arr.length; i++) {
//			System.out.println("Element at " + i + ": " + arr[i].roll_no + " "+ arr[i].name);
//		}
			
		
		
		//Populating the array
		
//		int[] intarr = new int[5];
//		for(int i=0; i<intarr.length; i++) {
//			intarr[i] = i*10 + 10;
//		}
		
		
		
		//Sum of array of elements
		
//		int sum = 0;
//		for(int i=0; i<intarr.length; i++) {
//			sum += intarr[i];
//		}
//		System.out.println("Sum of array of elements is: " + sum);
		
		
		
		// Printing elements of array
		
//		for(int i=0; i<intarr.length; i++) {
//			System.out.println("ELement at position "+ (i+1) + "  is: " + intarr[i]);
//		}		
	}
	public static int[] m1() {
		//returning array
		return new int[] {10,20,30};
	}

}
