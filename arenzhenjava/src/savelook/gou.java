package savelook;

//1�� ���Գɼ��ѱ��������� scores �У�����Ԫ������Ϊ 89 , -23 , 64 , 91 , 119 , 52 , 73
//2�� Ҫ��ͨ���Զ��巽����ʵ�ֳɼ�������������������ɼ�������Ϊ��������
//3�� Ҫ���жϳɼ�����Ч�ԣ� 0��100 ��������ɼ���Ч������Դ˳ɼ�
public class gou {
//	����ȥ�ظ�������һ��Ҫ����һ����ŵı��������������ж�
	public static void main(String[] args) {
		int[] score = { 89, -23, 64, 91, 119, 52, 73 };
		int[] cf = new int[score.length];
		for (int i = 0; i < score.length; i++) {
//			boolean flag = true;
			if (score[i] > 100 || score[i] < 0) {
//				flag = false;
				continue; // ��ʵ��if elseҲ�� ���÷ǵ���boolean ������Ƕ��ѭ����ʱ��һ�����boolean����
							// ˫ɫ��
			}// ������һ���ؼ�˼�������õ���ֵ������������������score[i]�����治�ܼ���ʹ��
			 //������������ߵ����� ������ø���һ����������д��cf[i]�� ��Ȼ���ж����˾�����forѭ��֮���Ǹ�����
//			if (flag == true) {
			else{
				cf[i] = score[i];
			}
		}

		for (int i = 0; i < cf.length; i++) {
			for (int j = 0; j < cf.length - i - 1; j++) {
				if (cf[j] > cf[j + 1]) {
					int temp = cf[j];
					cf[j] = cf[j + 1];
					cf[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < cf.length; i++) {
			if (cf[i] == 0) {
				continue;
			} else {
				System.out.print(" " + cf[i]);
			}
		}
	}
}
