package com.practice.chin.atla;

public class Even {

	public static void main(String[] args) {
		String str="aaaa";
		System.out.println(solution(str));

	}
	
	public static int solution(String S) {
        String temp="";
        int remove=0;
        int i=0;
        while(i<S.length()){
            if(temp.contains(S.charAt(i)+"")){
                i++;
                continue;
            }else{
                int j=0;
                int curr=S.indexOf(S.charAt(i),i);
                while(curr>=0){
                    j++;
                    curr=S.indexOf(S.charAt(i),curr+1);
                }
                if(j%2!=0){
                    remove++;
                }
                temp+=S.charAt(i);
                i++;
            }
        }
        return remove;
    }

}
