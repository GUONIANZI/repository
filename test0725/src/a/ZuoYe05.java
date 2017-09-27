package a;
//百钱买百鸡 公鸡5元一只，母鸡3元一只，小鸡一元三只 问一共有多少种情况
public class ZuoYe05 {
	public static void main(String[] args) {
		for(int a=0;a<=20;a++){
			for(int b=0;b<=33;b++){
				for(int c=0;c<=100;c++){
					if(a+b+c==100&&5*a+3*b+c*1/3==100&&c%3==0){
						System.out.println("公鸡:"+a+"母鸡:"+b+"小鸡"+c);
					}
				}
			}
		}
	}

}
