package graph;

import java.util.*;

public class KahnsTopologicalSort {
	
	public List<Integer> getTopologicalSort(int V, int[][] edges) {
		// Build Adjacency List and In-degree Array
		Map<Integer, List<Integer>> adj = new HashMap<>();
		int[] inDegree = new int[V];
		
		// time complexity: We iterate over every edge once to count in-degrees. This takes O(E).
		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
			inDegree[v]++;
		}
		
		// time complexity: We check every vertex once to see if its in-degree is zero. This takes O(V).
		// Initialize Queue with 0-in-degree nodes
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < V; i++) {
			if (inDegree[i] == 0) queue.add(i);
		}
		
		List<Integer> result = new ArrayList<>();
		// O(V+E)
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			result.add(curr);
			
			if (adj.containsKey(curr)) {
				for (int neighbor : adj.get(curr)) {
					inDegree[neighbor]--;
					if (inDegree[neighbor] == 0) {
						queue.add(neighbor);
					}
				}
			}
		}
		
		// If result size != V, a cycle exists
		if (result.size() != V) return new ArrayList<>();
		return result;
		
		// Total T.C: O(E)+O(V)+O(V+E)≈O(V+E)
	}
	
	// ✅ main() method ✅
	public static void main(String[] args) {
		KahnsTopologicalSort solver = new KahnsTopologicalSort();
		
		// Example: Directed edges [[5,2], [5,0], [4,0], [4,1], [2,3], [3,1]]
		int V = 6;
		int[][] edges = {{5, 2}, {5, 0}, {4, 0}, {4, 1}, {2, 3}, {3, 1}};
		
		List<Integer> sortedOrder = solver.getTopologicalSort(V, edges);
		
		if (sortedOrder.isEmpty()) {
			System.out.println("Cycle detected! No Topological Sort possible.");
		} else {
			System.out.println("Topological Sort (Kahn's): " + sortedOrder);
		}
	}
}