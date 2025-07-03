package com.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[] A = {4,3,2,1,1,0};
        int[] B = {0,0,0,1,0,0};

        System.out.println(fish2(A,B));

    }
    public static int fish2(int[] A, int[] B){
        ArrayDeque<Integer> downstreams = new ArrayDeque<>();
        int alive = 0;
        for (int i = 0; i < A.length; i++) {
            int currFish = A[i] * (B[i] == 1 ? -1 : 1);
            if (currFish < 0) {
                downstreams.push(currFish);
                alive++;
            } else {
                Iterator it = downstreams.iterator();
                boolean eaten = false;
                while (it.hasNext()) {
                    int down = (int) it.next();
                    if (Math.abs(currFish) > Math.abs(down)) {
                        it.remove();
                        alive--;
                        eaten = false;
                    } else {
                        eaten = true;
                        break;
                    }
                }
                if (!eaten) {
                    alive++;
                }
            }
        }
        return alive;
    }

    public static int fish(int[] A, int[] B) {
        // Implement your solution here
        Stack<Integer> pool = new Stack<Integer>();
        pool.push(0);
        for(int i=1; i<A.length; i++){
            int index = pool.peek();

            if(B[index]==1 && B[index]!=B[i]){
                if(A[index]>A[i]){
                    continue;
                }else{
                    pool.pop();
                    pool.push(i);
                }
            }else{
                pool.push(i);
            }
        }
        return pool.size();
    }


    public static int solution(int[] A) {
        // Implement your solution here
        if(A.length==0){return 0;}
        if(A.length==1){return Math.abs(A[0]);}
        List<Integer> difference = new ArrayList();
        for(int i=0; i<A.length; i++){
            int[] left = Arrays.copyOfRange(A, 0, i);
            int[] right = Arrays.copyOfRange(A, i, A.length);
            int diff = Math.abs(sum(left)-sum(right));
            difference.add(diff);
        }
        return Collections.min(difference);

    }
    public static int sum(int[] arrays){
        if(arrays.length==0){return 0;}
        int sum = 0;
        for(int i=0; i<arrays.length; i++){
            sum += arrays[i];
        }
        return sum;
    }
}