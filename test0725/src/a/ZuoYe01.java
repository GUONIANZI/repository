package a;
//���1000���ڵ�����
public class ZuoYe01 {
	public static void main(String[] args) {
	//flagֵ������test0727-ZuoYe02���Ƚ�
		boolean flag =true;
		for (int num = 2; num <= 1000; num++) {
			for (int i = 2; i <= num - 1; i++) {
				if (num % i == 0) {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				System.out.println(num + "������");
			} 
			}
		}
	}

