package a;

public class Test07 {
public static void main(String[] args) {
	int year=2016;//�����������1���ܱ�4�����Ҳ��ܱ�100��2���ܱ�400����
	if(year%4==0&&year%100!=0||year%400==0){
		System.out.println(year+"������");
	}else{
		System.out.println(year+"��ƽ��");
	}
}
}
