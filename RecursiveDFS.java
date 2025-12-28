import java.util.ArrayList;
import java.util.List;

public class RecursiveDFS {
	private int vertices;
	private List<List<Integer>> adjList;
	
	public RecursiveDFS(int v) {
		this.vertices = v;
		this.adjList = new ArrayList<>(v);
		for (int i = 0; i < v; i++) {
			adjList.add(new ArrayList<>());
		}
	}
	
	public void addEdge(int src, int dest) {
		adjList.get(src).add(dest);
		adjList.get(dest).add(src);
	}
	
	/**
	 * Main DFS function that handles disconnected components.
	 */
	public void performDFS() {
		boolean[] visited = new boolean[vertices];
		
		System.out.print("Recursive DFS Traversal: ");
		for (int i = 0; i < vertices; i++) {
			if (!visited[i]) {
				recursiveDfsHelper(i, visited);
			}
		}
		System.out.println();
	}
	
	/**
	 * Helper function that performs the actual recursion.
	 */
	private void recursiveDfsHelper(int currentNode, boolean[] visited) {
		// Step 1: Mark current node as visited
		visited[currentNode] = true;
		System.out.print(currentNode + " ");
		
		// Step 2: Recur for all adjacent neighbors
		for (int neighbor : adjList.get(currentNode)) {
			if (!visited[neighbor]) {
				recursiveDfsHelper(neighbor, visited);
			}
		}
	}
	
	// ✅ main() method ✅
	public static void main(String[] args) {
		TopologicalDFS graph = new TopologicalDFS(6);
		
		// Building a sample graph
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 5);

        /*
           Structure:
              0
             / \
            1   2
           / \   \
          3   4   5
        */
		
		graph.performDFS();
		// Expected Output: 0 1 3 4 2 5 (or similar depending on neighbor order)
	}
}