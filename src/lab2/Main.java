package lab2;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		/*perform the N Queens problem*/
			System.out.println("\n** N QUEENS PROBLEM **");
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter the size of the board: \n");
			int size = scan.nextInt(); //find the size of the matrix. ex: size  =5, the matrix of dimensions 5x5 is created
			NQueens queens = new NQueens(size);
			System.out.println("Solution to the board of size " + size);
			queens.printSol();
			
			
		/*Acyclic graph*/
			System.out.println("\n\n** ACYCLIC GRAPH **");
			DetectCycle graphA = new DetectCycle(6);	
			//add edges
			graphA.addEdge(0, 1);
			graphA.addEdge(0, 3);
			graphA.addEdge(1, 2);
			graphA.addEdge(2, 4);
			graphA.addEdge(3, 4);
			graphA.addEdge(3, 5);
			
			if(graphA.isCyclic())
	            System.out.println("\nGraph A contains cycle");
	        else
	            System.out.println("\nGraph A doesn't contain cycle");
			
			
			DetectCycle graphB = new DetectCycle(3);		
			graphB.addEdge(0, 1);
			graphB.addEdge(1, 2);

			if(graphB.isCyclic())
	            System.out.println("\nGraph B contains cycle");
	        else
	            System.out.println("\nGraph B doesn't contain cycle");
			
			
		/*Perform Minimum Spanning Tree(MST)*/
			System.out.println("\n\n** MINIMUM SPANNING TREE (MST)**");

			int numOfVertex = 7;//num of vertices
				
			//adjacency list
			ArrayList<LinkedList<Vertex>> alist = new ArrayList<LinkedList<Vertex>>();
				
				
			//add these vertices to the graph
			for(int i =0 ; i<numOfVertex ; i++)
			{
				//add a linked list to store all adjacent vertices within each vertex index
				alist.add(new LinkedList<Vertex>());
			}
			

			/*CREATE GRAPH*/
			alist.get(0).add(new Vertex(1, 28));
			alist.get(0).add(new Vertex(5, 10));
			
			alist.get(1).add(new Vertex(0, 28));
			alist.get(1).add(new Vertex(2, 16));
			alist.get(1).add(new Vertex(6, 14));
				
			alist.get(2).add(new Vertex(1, 16));
			alist.get(2).add(new Vertex(3, 12));
				
			alist.get(3).add(new Vertex(2, 12));
			alist.get(3).add(new Vertex(4, 22));
			alist.get(3).add(new Vertex(6, 18));
				
			alist.get(4).add(new Vertex(3, 22));
			alist.get(4).add(new Vertex(5, 25));
			alist.get(4).add(new Vertex(6, 24));
				
			alist.get(5).add(new Vertex(0, 10));
			alist.get(5).add(new Vertex(4, 25));
			
			alist.get(6).add(new Vertex(1, 14));
			alist.get(6).add(new Vertex(3, 18));
			alist.get(6).add(new Vertex(4, 24));
							
		MST mst = new MST();
		mst.primAlgo(alist, numOfVertex); //inputs: graph,size of the graph	
	
	/*KNAPSACK PROBLEM: John at a Candy Shop*/
		int N = 3; //num of candies at the candy shop
		int capacity = 5; //max weight the bad can hold before it tears
		int candyVal[] = {6, 10,12};  //sentimental value of each candy
		int candyWeight[] = {1, 2,3 }; //the weight of each candy
		
		System.out.println("\n\n** KNAPSACK PROBLEM: John's at Candy Shop **");
		System.out.println(KnapSack.knapSack(N, candyVal, candyWeight, capacity));
		
		
	/*LONGEST INCREASING SEQUENCE*/
		System.out.println("\n\n** LONGEST INCREASING SEQUENCE **");
		int[] arrLIS = {10, 22, 9, 33, 21, 50, 41, 60};
		int arrSize = arrLIS.length;
		LIS lis = new LIS();
		lis.lis(arrLIS, arrSize);

	}
}
