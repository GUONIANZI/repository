package a;
//�ж�97�ǲ�������
public class Test12 {
	public static void main(String[] args) {
		// ֻ�ܱ�1��������������������
		
		int num = 9;
		boolean flag = true;
		for (int i = 2; i <= num - 1; i++) {
			if (num % i == 0) {
				flag = false;
				break;
			}
		}
	
		if (flag == true) {
			System.out.println("������");
		} else
			System.out.println("��������");

	}
}
