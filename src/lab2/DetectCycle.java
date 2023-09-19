package lab2;
import java.util.*;

public class DetectCycle {

    private int numOfVertices;
 
    // Adjacency List rep
    private ArrayList<LinkedList<Integer>> alist;
 

    DetectCycle(int v)
    {
    	numOfVertices = v;
        alist = new ArrayList<>();
        for (int i = 0; i < v; ++i)
        	alist.add(new LinkedList());
    }
 
	//source(a), destination(b)
    void addEdge(int a, int b)
    {
        alist.get(a).add(b);
        alist.get(b).add(a);
    }
 
    // A recursive function that
    // uses visited[] and parent to detect
    // cycle in subgraph reachable
    // from vertex v.
    Boolean isCyclicHelper(int v, Boolean visited[], int parent)
    {
        // Mark the current vertex as visited
        visited[v] = true;
        Integer i;
 
       //use recursion to visit all vertices adjacent to this vertex
        Iterator<Integer> it = alist.get(v).iterator();
        while (it.hasNext()) {
            i = it.next();
 
            //if an adjacent vertex is not visited, then use recursion to iterate through the adjacent vertex
            if (!visited[i]) {
                if (isCyclicHelper(i, visited, v))
                    return true;
            }
 
            //if the adjacent vertex is visited and not the parent vertex of the current vertex, then there is a cycle
            else if (i != parent)//not a parent, 
                return true;
        }
        return false;
    }
 
    // Returns true if the graph contains a cycle, else false.
    Boolean isCyclic()
    {

        Boolean visited[] = new Boolean[numOfVertices];
        for (int i = 0; i < numOfVertices; i++)
            visited[i] = false;//initialize the array with all vertices marked as unvisited
 
      //call the dfsHelper function to detect a cycle
        for (int u = 0; u < numOfVertices; u++) {
 
            // Don't recur for u if already visited
            if (!visited[u])
                if (isCyclicHelper(u, visited, -1))
                    return true;
        }
 
        return false;
    }
}
 

