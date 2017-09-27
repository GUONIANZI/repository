package a;

public class Test09 {
//1000之内能被7和13同时整除的数
	public static void main(String[] args) {
		for(int i=1;i<=1000;i++){
			if(i%7==0&&i%13==0){
				System.out.println(i);
			}
		}
	}
}
