package a;
//判断97是不是素数
public class Test12 {
	public static void main(String[] args) {
		// 只能被1和自身整除的数是素数
		
		int num = 9;
		boolean flag = true;
		for (int i = 2; i <= num - 1; i++) {
			if (num % i == 0) {
				flag = false;
				break;
			}
		}
	
		if (flag == true) {
			System.out.println("是素数");
		} else
			System.out.println("不是素数");

	}
}
