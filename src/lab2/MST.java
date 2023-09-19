package lab2;

import java.util.*;


public class MST {

	private static final int INFINITY = 1000000;

	/*MINIMUM SPANNING TREE*/
	public void primAlgo(ArrayList<LinkedList<Vertex>> alist, int numOfVertex)
	{
		LinkedList<Integer> mst = new LinkedList<>();//to print the MST: not a part of the base algorithm
		int key[] = new int[numOfVertex]; //stores the cost of the MST
		boolean mstSet[] = new boolean[numOfVertex];//store visited and unvisited vertices in the MST
		for(int i= 0 ; i<numOfVertex ; i++)
		{
			key[i] = INFINITY; //key[i] = infinity, unvisited vertices have an infinite sum at that vertex
			mstSet[i] = false; //assign each vertex as not visited
		}
		
		key[0] = 0; //sum at source =0
		
		/*Iterate through the alist to find a path to the MST*/		
		for(int i = 0;i < numOfVertex ;i++)
		{
        	int min = INFINITY, u = 0; //u = vertex with the minimum weight
        	for(int v = 0; v < numOfVertex; v++) {
        		//the vertex is unvisited AND the sum is less than minimum cost of MST
        		if(mstSet[v] == false && key[v] < min) 
        		{
        			min = key[v]; 
        			u = v; 
        		}
        	}
        	mstSet[u] = true; //visit this node
        	mst.add(u);//create a path to the MST
        	
        	/*iterate over its adjacent vertices and update the key index if
        	* the vertex is unvisited and has minimum weight*/
        	for(Vertex v : alist.get(u))
        	{
        		if(mstSet[v.getVertex()] == false && v.getWeight() < key[v.getVertex()])
        		{
        			key[v.getVertex()] = v.getWeight();
        		}
        	}
        	
        }
		
		System.out.println("MST path:");
		for(int  i= 0; i < numOfVertex  ; i++)
			System.out.print(mst.get(i) + " -> ");
		System.out.println("\n");
		
		//print the weights between the edges and the total cost of the MST
		int sum =0 , next = 1;
		for(int i= 0; (i< numOfVertex) && (next != (numOfVertex)) ; i++)
		{

			LinkedList<Vertex> node = alist.get(mst.get(i)); //get the list of adj nodes of this vertex
			//find the next vertex on the path inside this list
			for(Vertex v : node)
			{
				if(v.getVertex() == mst.get(next))
				{
					System.out.println("Weight between " + mst.get(i) + " and " + mst.get(next) 
										+ " is " + v.getWeight());
					sum = sum +v.getWeight();
				}
			}
			next++;	
		}
		System.out.println("\nMST cost = " + sum);
	}

}

 
 class Vertex{
	 private int vertex;
	 private int weight;
	 
	 public Vertex(int v, int w)
	 {
		 this.vertex = v;
		 this.weight = w;
	 }
	 
	 public int getVertex()
	 {	return this.vertex;}
	 
	 public int getWeight()
	 {	return this.weight;}
	 	
 } 