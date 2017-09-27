package a;
//穷举法。一个一个试
//鸡兔同笼，上有35头，下有94足，问鸡兔各有多少 
public class ZuoYe04 {
	public static void main(String[] args) {
		for (int a = 0; a <= 35; a++) {
			for (int b = 0; b <= 35; b++) {
				if (a + b == 35 && 2 * a + 4 * b == 94) {
					System.out.println("鸡:" + a + "兔:" + b);
				}
			}
		}
	}
}
