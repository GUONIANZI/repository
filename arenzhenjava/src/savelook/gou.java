package savelook;

//1、 考试成绩已保存在数组 scores 中，数组元素依次为 89 , -23 , 64 , 91 , 119 , 52 , 73
//2、 要求通过自定义方法来实现成绩排名并输出操作，将成绩数组作为参数传入
//3、 要求判断成绩的有效性（ 0—100 ），如果成绩无效，则忽略此成绩
public class gou {
//	考虑去重复的问题一般要定义一个存放的变量，这样才能判断
	public static void main(String[] args) {
		int[] score = { 89, -23, 64, 91, 119, 52, 73 };
		int[] cf = new int[score.length];
		for (int i = 0; i < score.length; i++) {
//			boolean flag = true;
			if (score[i] > 100 || score[i] < 0) {
//				flag = false;
				continue; // 其实用if else也行 不用非得用boolean ，但是嵌套循环的时候一般得用boolean例如
							// 双色球
			}// 这里有一个关键思想就是你得到的值必须让他存在下来，score[i]在下面不能继续使用
			 //给命令才往下走的语言 所以你得给他一个命令让他写到cf[i]中 不然他判断完了就行了for循环之间是隔开的
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
