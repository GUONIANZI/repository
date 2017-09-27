package d;
//1、 考试成绩已保存在数组 scores 中，数组元素依次为 89 , -23 , 64 , 91 , 119 , 52 , 73
//2、 要求通过自定义方法来实现成绩排名并输出操作，将成绩数组作为参数传入
//3、 要求判断成绩的有效性（ 0—100 ），如果成绩无效，则忽略此成绩
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
