class Solution {
   
    public int coinChange(int[] coins, int amount) {
        Integer dp[][]=new Integer[coins.length+1][amount+1];
        int ans = solve(coins,0,amount,0,dp);
        return ans==Integer.MAX_VALUE?-1:ans;
        
    }
    public int solve(int [] coins , int s , int amt , int sum,Integer[][]dp){
        if(amt-sum==0) return 0;
        if(s==coins.length ) return Integer.MAX_VALUE;
        if(dp[s][sum]!=null) return dp[s][sum];
        int take =Integer.MAX_VALUE;

        if(coins[s]<=amt-sum){
            int r =  solve(coins,s,amt,sum+coins[s],dp);
            if(r!=Integer.MAX_VALUE) take = r+1;
        }
        int ntake = solve(coins,s+1,amt,sum,dp);
        return dp[s][sum]=Math.min(take,ntake);
    }
}