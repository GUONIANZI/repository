package arenzhenjava;

import java.util.ArrayList;
import java.util.List;

public class S {
public static void main(String[] args) {
	List<Integer> list=new ArrayList<Integer>();
	int length=6;
	for(int i=0;i<length;i++){
	int qiu=(int)(Math.random()*33+1);//����������������
	//����һ������qiu �����ں���ȥ�ص�ʱ������boolean���ж���ȥ����������
//		System.out.print(" "+hongs[i]);
		//ȥ�ظ�
		boolean flag=true;
	for( int j=0;j<i;j++){
		if(qiu==list.get(j)){
			flag=false;
			i--;
			break;
		}	
	}if(flag==true){
		list.add(qiu);
//		System.out.print(" "+list.get(i));�Ѿ�������������ظ�����
	}
	}
	//�Ѿ�������������ظ�����
	for(int i=0;i<length-1;i++){
		for(int j=0;j<length-i-1;j++){
	if(list.get(j)>list.get(j+1)){
		list.add(j, list.get(j+1));	
	}
	}	
	}
	for(int i=0;i<length;i++){
		System.out.print(" "+list.get(i));
	}
}
}
