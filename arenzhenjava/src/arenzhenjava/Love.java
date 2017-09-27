package arenzhenjava;
//用星号输出一个爱心

public class Love {
public static void main(String[] args) {
	for(int i=1;i<=5;i++){
		for(int j=1;j<=2*i-1;j++){
          System.out.print(" ");                    //负责输出空格	
         	
		}
		for(int k=0;k<2*i+1;k++){
			System.out.print("*");                   //负责输出星号                 
		}
		System.out.println();                          //负责换行
	}
}
}
