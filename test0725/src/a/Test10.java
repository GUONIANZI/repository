package a;
//输出直角三角形
public class Test10 {
	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();

		}
	}
}
//外层循环循环一次 内层循环循环n次，例如时钟的时针和分钟的关系，内层循环循环完外循环才循环一次。
//println打印的时候自带了换行;
//print不换行;