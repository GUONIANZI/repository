package a;
//输出等腰三角形
public class ZuoYE03 {
	public static void main(String[] args) {
		int a, b, c;
		for (a = 1; a <= 5; a++) {
			for (b = 4; b >= a; b--) {
				System.out.print(" ");
			}
			for (c = 1; c <= a * 2 - 1; c++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
