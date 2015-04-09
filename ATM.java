package com.langxi.util;

import java.util.Scanner;

public class ATM {
	private String accountNumber = "100";
	private String passWord = "11111";
	private String name = "Tom";
	private String accountMoney = "10000";
	

	private void init(){
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入账号：");
		String accountnumner = scan.nextLine();
		System.out.println("请输入密码:");
		String password = scan.nextLine();
		if(accountnumner.equals(this.accountNumber)&&password.equals(this.passWord)){
			System.out.println(this.toString());
		}
	}
	private void function(){
		Scanner scan = new Scanner(System.in);
		System.out.println("包含以下操作：1-存款、2-取款、3-查询、4-修改密码、5-退出");
		String line = scan.nextLine();
		boolean flag = true;
		if(flag){
			if("1".equals(line)){
				System.out.println("请输入存款金额为：");
				String money = scan.nextLine();
				this.accountMoney = String.valueOf(Integer.parseInt(money)+Integer.parseInt(this.accountMoney));
				
			}else if("2".equals(line)){
				System.out.println("请输入取款金额：");
				String money = scan.nextLine();
				this.accountMoney = String.valueOf(Integer.parseInt(accountMoney)-Integer.parseInt(money));
				
			}else if("3".equals(line)){
				System.out.println("账户余额为："+this.accountMoney);
				
				
			}else if("4".equals(line)){
				System.out.println("请输入密码：");
				String password = scan.nextLine();
				this.passWord = password;
				System.out.println("请再输入一遍密码：");
				String password2 = scan.nextLine();
				if(password2.equals(this.passWord)){
					System.out.println("修改密码成功！！");	
					this.init();
				}
				
			}else if("5".equals(line)){
				System.exit(-1);
			}else{
				System.out.println("没有此功能");
				//flag = false;
			}
		}
		System.out.println("您是否继续使用？6-是、7-否");
		String line1 = scan.nextLine();
		if("6".equals(line1)){
			this.function();
		}else if("7".equals(line1)){
			System.exit(-1);
		}
		System.out.println(this.toString());
		
	}
	
	@Override
	public String toString() {
		return "账号："+this.accountNumber+" 姓名："+this.name+" 账户余额："+this.accountMoney;
	}
	public void run(){
		this.init();
		this.function();
	}
	public static void main(String[] args) {
		ATM bank = new ATM();
		
		bank.run();
	}
}
