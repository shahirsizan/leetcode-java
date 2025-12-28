import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopologicalDFS {
	private int vertices;
	private List<List<Integer>> adjList;
	
	public TopologicalDFS(int v) {
		this.vertices = v;
		this.adjList = new ArrayList<>(v);
		for (int i = 0; i < v; i++) {
			adjList.add(new ArrayList<>());
		}
	}
	
	public void addEdge(int src, int dest) {
		// CHANGE 1: Made it DIRECTED. Topological sort only works on DAGs.
		adjList.get(src).add(dest);
	}
	
	public void performDFS() {
		boolean[] visited = new boolean[vertices];
		// List to store the finished nodes
		List<Integer> result = new ArrayList<>();
		
		for (int i = 0; i < vertices; i++) {
			if (!visited[i]) {
				recursiveDfsHelper(i, visited, result);
			}
		}
		
		// CHANGE 2: Reverse the post-order list to get the Topological Order
		Collections.reverse(result);
		
		System.out.print("Topological Order: ");
		for (int node : result) {
			System.out.print(node + " ");
		}
		System.out.println();
	}
	
	private void recursiveDfsHelper(int currentNode, boolean[] visited, List<Integer> result) {
		visited[currentNode] = true;
		
		for (int neighbor : adjList.get(currentNode)) {
			if (!visited[neighbor]) {
				recursiveDfsHelper(neighbor, visited, result);
			}
		}
		
		// CHANGE 3: Add to result AFTER the loop (Post-Order)
		// This ensures all dependencies are processed before the node itself is "finished"
		result.add(currentNode);
	}
	
	public static void main(String[] args) {
		TopologicalDFS graph = new TopologicalDFS(6);
		
		// Input remains the same, but edges are now interpreted as directed (0 -> 1)
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 5);

        /*
           Directed Structure:
              0
             / \
            v   v
            1   2
           / \   \
          v   v   v
          3   4   5
        */
		
		graph.performDFS();
		// Expected Output: 0 2 5 1 4 3 (One of many valid topological orders)
	}
}