package com.guess;



import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.Random;
import java.util.Vector;


public class Guess {
	static int count=0;
	public Guess(){
	}
	
	public List<Integer> flag_num_correct(){
		List<Integer> number=new Vector<Integer>();
		while(number.size()<4){
			int temp=new Random().nextInt(10);
			if(!number.contains(temp)){
				number.add(temp);
			}
		}
		//String restart;
		/*while(count<20){
		try{
		int[] input_num=new int[4];
		for(int i=0;i<4;i++){
			input_num[i]=Integer.parseInt(str_input_num.substring(i,i+1));
			if(input_num[i]<0 || input_num[i]>9){
				System.out.println("������0----9������");
				i--;
			}
		}
		
		if(Check(number,input_num).equals("4��A   4��B")){
			System.out.println("AAAA");
			System.out.println("��ϲ�㣬�����!");
		}
		else{
			System.out.println(Check(number,input_num));
			System.out.print("�Ƿ��ٴ�һ��:(yes or no)");
			Scanner sc_restart=new Scanner(System.in);
			restart=sc_restart.next();
			restart=restart.toUpperCase();
			if(restart.equals("YES")){
				count++;
				continue;
			}
			else{
				System.out.println("game over");
				System.out.println("�Ƿ�ѡ��鿴��:(yes or no)");
				String look_result;
				Scanner sc_look_result=new Scanner(System.in);
				look_result=sc_look_result.next();
				look_result=look_result.toUpperCase();
				if(look_result.equals("YES")){
					Result(number);
					
				}
				break;
			}
		}
		
	}catch(InputMismatchException e){
		System.out.println("����������");
	}
		}*/
		return number;
	}
	public String Check(List<Integer> number,int[] input_num){
		List<String> result=new LinkedList<String>();
		int a=0;
		int b=0;
		int n=0;
		for(Iterator<Integer> itr=number.iterator();itr.hasNext();){
			int num=itr.next();
		    if(num==input_num[n]){
		    	result.add("A");
		    	a++;
		    	b--;
		    	//System.out.println("���ǵڼ���"+n);
		    }
		    n++;
			for(int i=0;i<4;i++){
				if(num==input_num[i]){
					result.add("B");
					b++;
				}
			}
		}
		//String string_res=result.toString();
		String string_res=String.valueOf(a)+"��A   "+String.valueOf(b)+"��B";
		return string_res;	
	}
	public String Result(List<Integer> number){
		String result = null;
		result=number.toString();
		return result;
	}
}











