package arenzhenjava;

public class Q {
	public static String str( ){
		String a="������";
		String b="��ѧ��";
		String c="��";
		String d=a.concat(b);//�ַ�����ƴ��
		String sum=d.concat(c);
     return sum;
	}
	public static int str1( ){
		int a =20142806;
		int b=1;
		int sum=a+b;
		String c="af";
		return sum; //����ֵ�����Ƿ�������ķ���ֵ
		            //int���͵ķ���ֻ�ܷ���int��return c���Ͳ�����
	}
	public static void main(String[] args) {
		str();
		str1();
		System.out.println(str()+str1());
	}
}

