package a;

public class Test05 {
	public static void main(String[] args) {
		int a = 5;
		int b = 6;
		int c = 4;
		int d = 8;
		boolean f = a < b && c < d;
		System.out.println(f);
		f = a < b || c < d;
		System.out.println(f);
		f = !(a < b);
		System.out.println(f);
	}
}
