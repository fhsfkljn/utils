package com.newcode.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution5 {
	
	public static void swap(char[] arr,int i,int j){
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private ArrayList<ArrayList<Integer>> allList = new ArrayList<>();
	private ArrayList<Integer> list = new ArrayList<>();
	
	 public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
	        if(root == null){
	        	return allList;
	        }
	        
	        list.add(root.val);
	        target -= root.val;
	        if(target == 0 && root.left == null && root.right==null){
	        	allList.add(new ArrayList<Integer>(list));
	        }
	        FindPath(root.left, target);
	        FindPath(root.right, target);
	        list.remove(list.size()-1);
	        return allList;
	        
	 }
	 
	 public ArrayList<String> Permutation(String str){
		 ArrayList<String> res = new ArrayList<>();
		 if(str!=null && str.length()>0){
			 swapChar(str.toCharArray(),0,res);
			 Collections.sort(res);
		 }
		 return res;
	 }

	private void swapChar(char[] charArray, int i, ArrayList<String> res) {
		if(i == charArray.length-1){
			String val = String.valueOf(charArray);
			if(!res.contains(val)){
				res.add(val);
			}
		}else{
			for(int j=i;j<charArray.length;j++){
				swap(charArray, i, j);
				swapChar(charArray, i+1, res);
				swap(charArray, i, j);
			}
		}
		
	}
	
	public int MoreThanHalfNum_Solution(int [] array) {
		Arrays.sort(array);
		int count=0;
		int num = array[(array.length-1)/2];
		for(int i=0;i<array.length;i++){
			if(array[i] == num){
				count++;
			}
		}
		if(count > array.length/2){
			return num;
		}else {
			return 0;
		}
    }
	
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input.length==0 || k>input.length){
        	return list;
        }
        Arrays.sort(input);
        int count = 0;
        for(int i=0;i<input.length;i++){
        	if(k==count){
        		break;
        	}
        	if(!list.contains(input[i])){
        		list.add(input[i]);
        		count++;
        	}
        }
        return list;
    }
	
	public int FindGreatestSumOfSubArray(int[] array){
		int max = array[0];
		int res = array[0];
		for(int i=1;i<array.length;i++){
			max = Math.max(max+array[i], array[i]);
			res = Math.max(max, res);
		}
		return res;
	}
	
	public int NumberOf1Between1AndN_Solution(int n,int x) {
        if(n<0 || x<1||x>9){
        	return 0;
        }
        
        int high=n,temp,curr,low,i=1,total=0;
        while(high!=0){
        	high = n/(int)Math.pow(10, i);
        	temp = n%(int)Math.pow(10, i);
        	curr = temp/(int)Math.pow(10, i-1);
        	low = temp%(int)Math.pow(10, i-1);
        	if(curr==x){
        		total += high*(int)Math.pow(10,i-1)+low + 1;
        	}else if(curr<x){
        		total += high*(int)Math.pow(10,i-1);
        	}else{
        		total += (high+1)*(int)Math.pow(10,i-1);
        	}
        	i++;
        }
        return total;
    }
	
	public String PrintMinNumber(int [] numbers){
		if(numbers.length==0){
			return "";
		}
		
		String [] str = new String[numbers.length];
		for(int i=0;i<numbers.length;i++){
			str[i] = String.valueOf(numbers[i]);
		}
		StringBuffer sb = new StringBuffer();
		Arrays.sort(str,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);
            }
        });
		for(int i =0;i<numbers.length;i++){
			sb.append(str[i]);
		}
		return sb.toString();
	}
	
	public int GetUglyNumber_Solution(int index) {
        if(index<7){
        	return index;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = new int[index];
        arr[0] = 1;
        int t2=0,t3=0,t5=0;
        for(int i=1;i<index;i++){
        	arr[i] = Math.min(arr[t2]*2, Math.min(arr[t3]*3, arr[t5]*5));
        	if(arr[i]==arr[t2]*2){
        		t2++;
        	}
        	if(arr[i]==arr[t3]*3){
        		t3++;
        	}
        	if(arr[i]==arr[t5]*5){
        		t5++;
        	}
        }
        return arr[index];
    }
	
	public int FirstNotRepeatingChar(String str) {
		if(str==null||str.length()==0){
			return -1;
		}
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0;i<str.length();i++){
			if(map.containsKey(str.charAt(i))){
				int num = map.get(str.charAt(i));
				num++;
				map.put(str.charAt(i), num);
			}else{
				map.put(str.charAt(i), 1);
			}
				
		}
		
		for(int i=0;i<str.length();i++){
			if(map.get(str.charAt(i))==1){
				return i;
			}
		}
		return -1;
        
    }
	
	
	
	public static void main(String[] args) {
//		int[] array = {1,-2,3,10,-4,7,2,-5};
//		System.out.println(new Solution5().FindGreatestSumOfSubArray(array));
		System.out.println(new Solution5().NumberOf1Between1AndN_Solution(1, 1));
	}
}
