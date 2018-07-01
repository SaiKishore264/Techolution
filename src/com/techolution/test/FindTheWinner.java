package com.techolution.test;


public class FindTheWinner {

	static String winner(int[] andrea,int[] maria,String s){
		int andreaPts=0;
		int mariaPts=0;
		for(int i=0;i<andrea.length;i++){
			if(s.equals("Odd")&& i%2==1){
				andreaPts=andreaPts+andrea[i]-maria[i];
				mariaPts=mariaPts+maria[i]-andrea[i];
			}
			else if(s.equals("Even")&& i%2==0){
				andreaPts=andreaPts+andrea[i]-maria[i];
				mariaPts=mariaPts+maria[i]-andrea[i];
			}
		}
		if(andreaPts==mariaPts){
			return "Tie";
		}
		return andreaPts>mariaPts?"Andrea":"Maria";
	}

	public static void main(String[] args) {
		int[] andrea ={2,4,6};
		int[] maria ={1,3,5};
		String s ="Even";
		System.out.println(winner(andrea,maria,s));
	}
}
