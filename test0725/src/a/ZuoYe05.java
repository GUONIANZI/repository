package a;
//��Ǯ��ټ� ����5Ԫһֻ��ĸ��3Ԫһֻ��С��һԪ��ֻ ��һ���ж��������
public class ZuoYe05 {
	public static void main(String[] args) {
		for(int a=0;a<=20;a++){
			for(int b=0;b<=33;b++){
				for(int c=0;c<=100;c++){
					if(a+b+c==100&&5*a+3*b+c*1/3==100&&c%3==0){
						System.out.println("����:"+a+"ĸ��:"+b+"С��"+c);
					}
				}
			}
		}
	}

}
