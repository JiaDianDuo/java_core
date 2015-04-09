package com.langxi.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class ShowHand {

	private List<String> pukeList = new ArrayList<String>();
	private List<String> playerList = new ArrayList<String>();
	private Map<String,TreeSet<String>> map = new HashMap<String,TreeSet<String>>();
	private Map<String,Double> sorceMap = new HashMap<String,Double>();
	
	private void initPuKe(){
		String[] type = {"黑桃","红桃","梅花","方块"};
		String[] point = {"7","8","9","10","J","Q","K"};
		for(int i=0;i<type.length;i++){
			for(int j=0;j<point.length;j++){
				this.pukeList.add(type[i]+point[j]);
			}
		}
	}
	
	private void changeIndexPukeList(){
		Random rand = new Random();
		for(int i=0;i<200;i++){
			int index1 = rand.nextInt(this.pukeList.size());
			int index2 = rand.nextInt(this.pukeList.size());
			String puke1 = this.pukeList.get(index1);
			String puke2 = this.pukeList.get(index2);
			this.pukeList.set(index1, puke2);
			this.pukeList.set(index2, puke1);
		}
	}
	
	private boolean initPlayer(){
		boolean flag = false;
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入所有参与游戏的玩家名称（2-5名玩家），中间使用空格隔开：");
		String line = scan.nextLine().trim();
		String[] players = line.split(" ");
		for(int i=0;i<players.length;i++){
			if(!"".equals(players[i])){
				this.playerList.add(players[i]);
			}
		}
		if(this.playerList.size()<2 || this.playerList.size()>5){
			System.out.println("参与游戏的玩家人数不符合要求，程序终止！");
			flag = true;
		}
		return flag;
	}
	
	private void showPuke(){
		for(int i=0;i<this.playerList.size();i++){
			this.map.put(this.playerList.get(i), new TreeSet<String>(new Comparator<String>() {
				@Override
				public int compare(String str1, String str2) {
					int point1 = getPoint(str1.charAt(2));
					int point2 = getPoint(str2.charAt(2));
					if(point1>point2){
						return 1;
					}else if(point1<point2){
						return -1;
					}else{
						int type1 = getType(str1.substring(0, 2));
						int type2 = getType(str2.substring(0, 2));
						if(type1>type2){
							return 1;
						}else{
							return -1;
						}
					}
				}
			}));
		}
		//开始发牌
		for(int i=0;i<5;i++){
			for(int j=0;j<this.playerList.size();j++){
				String name = this.playerList.get(j);
				String puke = this.pukeList.remove(0);
				this.map.get(name).add(puke);
			}
		}
		for(String key : this.map.keySet()){
			System.out.println(this.map.get(key));
		}
	}
	
	private int getPoint(char ch){
		if(ch>='7' && ch<='9'){
			return Integer.parseInt(String.valueOf(ch));
		}else{
			switch (ch) {
			case 'J':
				return 11;
			case 'Q':
				return 12;
			case 'K':
				return 13;
			default:
				return 10;
			}
		}
	}
	
	private int getType(String type){
		if("黑桃".equals(type)){
			return 1;
		}else if("红桃".equals(type)){
			return 2;
		}else if("梅花".equals(type)){
			return 3;
		}else{
			return 4;
		}
	}
	//完成玩家手里的牌的大小的比较
	private void getSorce(){
		for(String name : this.map.keySet()){
			TreeSet<String> set = this.map.get(name);
			String[] pukes = set.toArray(new String[set.size()]);
			double sorce = this.getSorce(pukes);
			this.sorceMap.put(name, sorce);
			System.out.println("玩家的牌为："+this.map.get(name)+"分值为："+sorce);
		}
	}
	
	private double getSorce(String[] pukes){
		double sorce = 0;
		boolean flag = true;
		for(int i=0;i<pukes.length-1;i++){
			int point1 = this.getPoint(pukes[i].charAt(2));
			int point2 = this.getPoint(pukes[i+1].charAt(2));
			if(point1-point2!=-1){
				flag = false;
			}
		}
		if(flag){
			return 5.0+this.getPoint(pukes[4].charAt(2))*0.01;
		}
		//判断是否是4张牌
		char ch1 = pukes[0].charAt(2);
		char ch2 = pukes[1].charAt(2);
		char ch3 = pukes[2].charAt(2);
		char ch4 = pukes[3].charAt(2);
		char ch5 = pukes[4].charAt(2);
		if(ch1==ch4 || ch2==ch5){
			return 4.0 + this.getPoint(ch2);
		}
		if(ch1==ch3 || ch2==ch4 || ch3==ch5){
			return 3.0 + this.getPoint(ch3);
		}
		if(ch1==ch2 && ch3==ch4){
			return 2.0 + this.getPoint(ch3)*0.01 + this.getPoint(ch1)*0.0001+this.getPoint(ch5)*0.000001;
		}
		if(ch1==ch2 && ch4==ch5){
			return 2.0 + this.getPoint(ch4)*0.01 + this.getPoint(ch1)*0.0001+this.getPoint(ch3)*0.000001;
		}
		if(ch2==ch3 && ch4==ch5){
			return 2.0 + this.getPoint(ch4)*0.01 + this.getPoint(ch2)*0.0001+this.getPoint(ch1)*0.000001;
		}
		if(ch1==ch2){
			return 2.0 + this.getPoint(ch1)*0.0001+this.getPoint(ch5)*0.000001;
		}
		if(ch2==ch3){
			return 2.0 + this.getPoint(ch3)*0.0001+this.getPoint(ch5)*0.000001;
		}
		if(ch3==ch4){
			return 2.0 + this.getPoint(ch3)*0.0001+this.getPoint(ch5)*0.000001;
		}
		if(ch4==ch5){
			return 2.0 + this.getPoint(ch5)*0.0001+this.getPoint(ch3)*0.000001;
		}
		sorce = 1.0 + this.getPoint(ch5)*0.01;
		return sorce;
	}
	public void start(){
		this.initPuKe();
		this.changeIndexPukeList();
		boolean flag = this.initPlayer();
		if(flag){
			return;
		}
		this.showPuke();
		this.getSorce();
	}
	
	public static void main(String[] args) {
		new ShowHand().start();
	}
}
