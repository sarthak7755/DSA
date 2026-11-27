class Solution {
     List<List<Integer>> factors ;
     Integer[][][] memo;
    public int maximumSaleItems(int[][] items, int budget) {
        factors = new ArrayList<>();
        int n = items.length;

        for(int i =0 ;i<n;i++){
            factors.add(new ArrayList<>());
        }
        for(int i =0;i<n;i++){
            int[] curr = items[i];
            int factor = curr[0];

            for(int j = 0;j<n;j++){
                if(i == j) continue;
                int[] neigh = items[j];
                int neigFactor = neigh[0];
                
                if(neigFactor  % factor ==0){
                    factors.get(i).add(j);
                }                
            }
        }
        memo = new Integer[n][budget+1][2];
    
        return solve(0 , items , budget , false);
    }

    public int solve(int index , int[][] items , int budget , boolean bought){
        
        
           if(index>=items.length) return 0;
    int state = bought ? 1 : 0;
          if(memo[index][budget][state] != null )return memo[index][budget][state];

          int notTake =0;
          
          notTake  =solve(index +1 , items, budget,false);
          
          int take1 = 0;
        int takeM = 0;

        if(items[index][1] <= budget){
            if(!bought){
                take1 = 1 + factors.get(index).size() + solve(index , items , budget - items[index][1] , true);
            }else{
                takeM = 1 + solve(index , items , budget - items[index][1] , true);
            }
        }
          return memo[index][budget][state] =  Math.max(take1 ,Math.max(takeM , notTake));

    }
}