package a;
//��ٷ���һ��һ����
//����ͬ��������35ͷ������94�㣬�ʼ��ø��ж��� 
public class ZuoYe04 {
	public static void main(String[] args) {
		for (int a = 0; a <= 35; a++) {
			for (int b = 0; b <= 35; b++) {
				if (a + b == 35 && 2 * a + 4 * b == 94) {
					System.out.println("��:" + a + "��:" + b);
				}
			}
		}
	}
}
