package com.dp.canSum;

import java.util.ArrayList;
import java.util.HashMap;

public class CanSum {

    public boolean canSumHelper(int targetSum, int[] numbers, HashMap<Integer, Boolean> memoMap){

        if(targetSum == 0){ return true; }
        if(targetSum < 0){ return false; }
        if(memoMap.containsKey(targetSum)){ return memoMap.get(targetSum);}
        for(int i = 0; i< numbers.length; i++){
            int remainder = targetSum - numbers[i];
            boolean returnValue = canSumHelper(remainder, numbers, memoMap);
            memoMap.put(targetSum, returnValue);
            if(returnValue) { return true;}
        }
        return false;
    }

    public static void main(String args[]){
     CanSum canSum = new CanSum();
     int[] numbers = new int[]{ 2, 3, 5 };
     HashMap<Integer, Boolean> memoMap = new HashMap<>();
     System.out.println(canSum.canSumHelper(8, numbers, memoMap));
    }
}
