class AppleStock {
public static void main (String[] args) {
        int[] prices1 = {2,5,7,1,3,2,10,9};
        int[] prices2 = {6,5,4,3,2,1};

        try {
                System.out.println(maxProfit(prices1) + " == " + 9);
                System.out.println(maxProfit(prices2) + " == " + -1);
        } catch (Exception e) {
                e.printStackTrace();
        }

}

public static int maxProfit(int[] prices) throws Exception {
        if (prices.length < 2) throw new Exception("should have more than 1 days");
        int maxProfit = prices[1] - prices[0];
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
                int currentPrice = prices[i];
                maxProfit = Math.max(currentPrice - minPrice, maxProfit);
                minPrice = Math.min(minPrice, currentPrice);
        }
        return maxProfit;
}
}
