package com.test;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {         //用数组来存成对的位置和关系
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int a[][] = new int[26][26];
		int n = in.nextInt();
		String s1 = in.next();
		String s2 = in.next();
		int result = 0, k=0, x1=-1, y1=-1;
		int vis[] = new int[26];
		for(int t=0; t<n; ++t){
			if(s1.charAt(t)!=s2.charAt(t)){
				result++;
				int x = s1.charAt(t)-'a';
				int y = s2.charAt(t)-'a';
				vis[x]=t+1;
				if(a[y][x]!=0&&k<2){
					x1=t+1;
					y1=a[y][x];
					k=2;
				}
				a[x][y]=t+1;
			}
		}
		if(k==2){
			System.out.println(result-2);
			System.out.println(x1+" "+y1);
			return ;
		}
		for(int t=0; t<n; ++t){
			if(s1.charAt(t)!=s2.charAt(t)){
				int x= s2.charAt(t)-'a';
				if(vis[x]!=0){
					System.out.println(result-1);
					System.out.println(vis[x]+" "+(t+1));
					return ;
				}
			}
		}
		System.out.println(result);
		System.out.println("-1 -1");
	}

}
