package d;
//1�� ���Գɼ��ѱ��������� scores �У�����Ԫ������Ϊ 89 , -23 , 64 , 91 , 119 , 52 , 73
//2�� Ҫ��ͨ���Զ��巽����ʵ�ֳɼ�������������������ɼ�������Ϊ��������
//3�� Ҫ���жϳɼ�����Ч�ԣ� 0��100 ��������ɼ���Ч������Դ˳ɼ�
public class Score {
	int[] score={89,-23,64,92,119,52,73};
	public void paichu(int[] score){
		int[] cf = new int[score.length];
		int i;
		for (i = 0; i < score.length; i++) {
			boolean flag = true;
			if (score[i] > 100 || score[i] < 0) {
				flag = false;
				continue; 
			}
			if (flag == true) {
				cf[i] = score[i];
			}
		}
		
	}
	public void paixu(int[] cf){
		int i;
		for( i=0;i<cf.length;i++){
		 for(int j=0;j<cf.length-i-1;j++){
			 if(cf[j]>cf[j+1]){
				 int temp=cf[j];
				 cf[j]=cf[j+1];
				 cf[j+1]=temp;
			 }
		 }
		}
		for( i=0;i<cf.length;i++){
			System.out.println(cf[i]);
		}
		
	}
	
	public void show(int[] cf){
		int i;
		for( i=0;i<cf.length;i++){
			System.out.println(cf[i]);
		}
		
	}
public static void main(String[] args) {
	Score sc=new Score();
	sc.paichu();
	sc.paixu();
	sc.show();
}
}
