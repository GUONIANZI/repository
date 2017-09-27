package a;
// 输出一个九九乘法表
public class Test11 {
public static void main(String[] args) {
	int a;
	for(int j=1;j<=9;j++){
	for(int i=1;i<=j;i++){
		a=i*j;
	System.out.print(i+"*"+j+"="+a+" ");	
	}
	System.out.println();
	}
}
}
