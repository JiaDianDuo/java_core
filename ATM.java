package com.langxi.util;

import java.util.Scanner;

public class ATM {
	private String accountNumber = "100";
	private String passWord = "11111";
	private String name = "Tom";
	private String accountMoney = "10000";
	

	private void init(){
		Scanner scan = new Scanner(System.in);
		System.out.println("�������˺ţ�");
		String accountnumner = scan.nextLine();
		System.out.println("����������:");
		String password = scan.nextLine();
		if(accountnumner.equals(this.accountNumber)&&password.equals(this.passWord)){
			System.out.println(this.toString());
		}
	}
	private void function(){
		Scanner scan = new Scanner(System.in);
		System.out.println("�������²�����1-��2-ȡ�3-��ѯ��4-�޸����롢5-�˳�");
		String line = scan.nextLine();
		boolean flag = true;
		if(flag){
			if("1".equals(line)){
				System.out.println("����������Ϊ��");
				String money = scan.nextLine();
				this.accountMoney = String.valueOf(Integer.parseInt(money)+Integer.parseInt(this.accountMoney));
				
			}else if("2".equals(line)){
				System.out.println("������ȡ���");
				String money = scan.nextLine();
				this.accountMoney = String.valueOf(Integer.parseInt(accountMoney)-Integer.parseInt(money));
				
			}else if("3".equals(line)){
				System.out.println("�˻����Ϊ��"+this.accountMoney);
				
				
			}else if("4".equals(line)){
				System.out.println("���������룺");
				String password = scan.nextLine();
				this.passWord = password;
				System.out.println("��������һ�����룺");
				String password2 = scan.nextLine();
				if(password2.equals(this.passWord)){
					System.out.println("�޸�����ɹ�����");	
					this.init();
				}
				
			}else if("5".equals(line)){
				System.exit(-1);
			}else{
				System.out.println("û�д˹���");
				//flag = false;
			}
		}
		System.out.println("���Ƿ����ʹ�ã�6-�ǡ�7-��");
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
		return "�˺ţ�"+this.accountNumber+" ������"+this.name+" �˻���"+this.accountMoney;
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
