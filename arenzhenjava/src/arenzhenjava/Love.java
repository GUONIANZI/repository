package arenzhenjava;
//���Ǻ����һ������

public class Love {
public static void main(String[] args) {
	for(int i=1;i<=5;i++){
		for(int j=1;j<=2*i-1;j++){
          System.out.print(" ");                    //��������ո�	
         	
		}
		for(int k=0;k<2*i+1;k++){
			System.out.print("*");                   //��������Ǻ�                 
		}
		System.out.println();                          //������
	}
}
}
