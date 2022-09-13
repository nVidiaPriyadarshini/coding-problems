package com.dp.gridTraveller;

import java.util.HashMap;

public class GridTraveller {
    public int uniquePaths(int m, int n) {
        HashMap<String, Integer> memoMap = new HashMap<String, Integer>();

        return memoHelper(m, n, memoMap);
    }
    private int memoHelper(int m, int n, HashMap<String, Integer> memoMap){
        if(m == 1 && n == 1){
            return 1;
        }
        if(m == 0 || n == 0){
            return 0;
        }

        String key = m + "," + n;
        if(memoMap.containsKey(key)){
            return memoMap.get(key);
        }
        memoMap.put(key, (memoHelper(m-1, n, memoMap) + memoHelper(m, n-1, memoMap)));
        return memoMap.get(key);
    }

    public static void main(String[] args){
        GridTraveller traveller = new GridTraveller();
        System.out.println(traveller.uniquePaths(2,3));
    }
}
