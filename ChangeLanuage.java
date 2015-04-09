package com.langxi.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangeLanuage {
	
	private void init(){
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入要输入几行");
		int numLine = scan.nextInt();
		System.out.println("请输入"+numLine+"行你所输入的语言：");
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<numLine;i++){
			String line = sc.nextLine();
			System.out.println(line+"转换成另一种语言为："+this.changeLanuage(line));
		}
	}
	private String changeLanuage(String line){
		List<Character> list = new ArrayList<Character>();
		Pattern patternA = Pattern.compile("[a-z][A-Za-z]+");
		Pattern patternB = Pattern.compile("([a-z]_?)+");
		String newLine = null;
		Matcher m;
		for(int i=0;i<line.length();i++){
			list.add(line.charAt(i));
		}
		if(patternA.matcher(line).matches()){
			for(int i=0;i<list.size();i++){
				if(list.get(i)>='A'&&list.get(i)<='Z'){
					list.add(i, Character.toLowerCase(list.get(i)));
					list.remove(i+1);
					list.add(i, '_');
				}
			}
			newLine = this.changeToLine(list);
		}else if(patternB.matcher(line).matches()){
			for(int i=0;i<list.size();i++){
				if('_'==list.get(i)){
					list.remove(i);
					list.add(i, Character.toUpperCase(list.get(i)));
					list.remove(i+1);
				}
			}
			newLine = changeToLine(list);
		}else{
			System.out.println("输入错误！！！");
		}
		return newLine;
	}
	private String changeToLine(List<Character> list){
		char ch[] = new char[list.size()];
		for(int i=0;i<list.size();i++){
			ch[i] = list.get(i);
		}
		String line = String.valueOf(ch);
		return line ;
	}
	public void run(){
		this.init();
	}
	public static void main(String[] args) {
		new ChangeLanuage().run();
		
	}
}
