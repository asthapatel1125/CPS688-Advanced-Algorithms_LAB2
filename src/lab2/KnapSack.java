package lab2;


public class KnapSack {

	public static int knapSack(int N,int candyVal[], int weight[],int capacity )
	{
		int i=0, w =0;
		int KS[][] = new int[N + 1][capacity + 1];
		
		// Build table K[][] in bottom up manner
        for (i = 0; i <= N; i++) {
            for (w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {//initialize the base case: zero capacity, it'll be compared to the first element in the weight array
                    KS[i][w] = 0;
                } else if (weight[i - 1] <= w) {
                    KS[i][w] = max(candyVal[i - 1] + KS[i - 1][w - weight[i - 1]], KS[i - 1][w]);
                } else {
                    KS[i][w] = KS[i - 1][w];
                }
            }
        }

        return KS[N][capacity];
	}

	private static int max(int a, int b) {
		return (a > b) ? a : b;
	}
	
		
}
