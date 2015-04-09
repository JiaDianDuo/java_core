package git.jiadianduo.test;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test1 {
	public void changeSort(){
		Scanner scan  = new Scanner(System.in);
		System.out.println("ÇëÊäÈëÒ»¾äÓ¢ÎÄ£º");
		String line = scan.nextLine();
		String[] word = line.split(" ");
		for(int i=word.length-1;i>=0;i--){
			System.out.print(word[i]+" ");
		}
		System.out.println();
	}
	public Object getMaxArray(){
		Set<Integer> set = new TreeSet<Integer>();
		
		int[] nums = {1,-2,3,5,-1};
		for(int i=0;i<nums.length-1;i++){
			set.add(nums[i]+nums[i+1]);
		}
		for(int i=0;i<nums.length-2;i++){
			set.add(nums[i]+nums[i+1]+nums[i+2]);
		}
		for(int i=0;i<nums.length-3;i++){
			set.add(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]);
		}
		for(int i=0;i<nums.length-4;i++){
			set.add(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]+nums[i+4]);
		}
		Object[] total = set.toArray();
		return total[total.length-1];
	}
	public static void main(String[] args) {
		Test1 t1 = new Test1();
		//t1.changeSort();
		System.out.println(t1.getMaxArray());
	}
}
