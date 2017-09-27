package a;
//输出1000以内的素数
public class ZuoYe01 {
	public static void main(String[] args) {
	//flag值可以与test0727-ZuoYe02做比较
		boolean flag =true;
		for (int num = 2; num <= 1000; num++) {
			for (int i = 2; i <= num - 1; i++) {
				if (num % i == 0) {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				System.out.println(num + "是素数");
			} 
			}
		}
	}

