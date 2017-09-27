package arenzhenjava;

public class chengji {
int[] score;
public void haha(int[] score){
	
	for(int i=0;i<score.length;i++){
		int qiu=score[i];
		if(score[i]>100&&score[i]<0){
			System.out.println(qiu);
		}
	}
	for(int i=0;i<score.length;i++){
		for(int j=0;j<score.length-i-1;j++){
			if(score[j]>score[j+1]){
				int temp=score[j];
				score[j]=score[j+1];
				score[j+1]=temp;
			}
		}
	}
	for(int i=0;i<score.length;i++){
		System.out.print(" "+score[i]);
	}
}
}
