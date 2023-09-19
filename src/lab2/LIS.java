package lab2;

import java.util.Arrays;

public class LIS {

		public void lis(int arr[], int size)
		{
			//this array keeps a track of the LIS and at which indices these values occur
			int lisArr[] = new int[size];
			int i,j, max =0 ;
			
			//initialize the LIS array
			for(int v = 0 ;v<size; v++)
				lisArr[v] = 1; //assuming the LIS is 1
			
			//compute LIS using dynamic programming
			for(i =1 ; i <size ; i++)
			{
				for(j =0 ; j <i ; j++)
				{
					/* if the value of the next arr index is greater than the previous indices 
					 * AND
					 * if the LIS value of the next index is less than the prev indices to indicate that it's a new increasing value
					 * then it's an increasing sequence
					 * */
					if((arr[i] > arr[j]) && (lisArr[i]< lisArr[j]+1))
						lisArr[i] = lisArr[j]+1;
				}
			}
				
			//Declare the max LIS value and the sequence
			for(i =0 ;i <size; i++)
			{
				if(max < lisArr[i])
					max = lisArr[i];
			}
			System.out.println("Longest Increasing Sequence is " + max);
			
			int lis[] = new int[max];
			int m =1,n = 0;
			for( i =0 ; i < size ; i++)
			{
				if(lisArr[i] == m)
				{
					lis[n] = arr[i];
					n++; m++;
				}
			}
			System.out.println("LIS: " + Arrays.toString(lis));
				
			
		
		}
}
