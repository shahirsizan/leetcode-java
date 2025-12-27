import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsMST {
	
	// static class for custom type definition
	static class Edge {
		int target, weight;
		
		Edge(int target, int w) {
			this.target = target;
			weight = w;
		}
	}
	
	/**
	 * Prim's Algorithm using a PriorityQueue.
	 * Time Complexity: O(E log V)
	 * Space Complexity: O(V + E)
	 */
	public int minSpanningTree(List<List<Edge>> adjacencyList, Edge startNode) {
		int adjacencyListSize = adjacencyList.size();
		// initial default values are `false`
		boolean[] visited = new boolean[adjacencyListSize];
		
		PriorityQueue<Edge> ourPriorityQueue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
		
		int totalCost = 0;
//		int edgesCount = 0;
		
		// Start from node 0 (or any node)
		// pq.add(new Edge(0, 0));
		ourPriorityQueue.add(startNode);
		
		//while (!ourPriorityQueue.isEmpty() && edgesCount < adjacencyListSize) {
		while (!ourPriorityQueue.isEmpty()) {
			Edge currentEdge = ourPriorityQueue.poll();
			//int u = currentEdge.target;
			
			// Skip if target node is already visited (part of MST)
			if (visited[currentEdge.target]) {
				continue;
			}
			
			// Process the node (Include in MST, mark as visited etc...)
			visited[currentEdge.target] = true;
			totalCost += currentEdge.weight;
			//edgesCount++;
			
			// Add all unvisited neighbouring edges to `ourPriorityQueue`
			for (Edge NeighborEdge : adjacencyList.get(currentEdge.target)) {
				if (!visited[NeighborEdge.target]) {
					ourPriorityQueue.add(NeighborEdge);
				}
			}
		}
		
		// If edgesCount < adjacencyListSize, the graph was not connected
		//return edgesCount == adjacencyListSize ? totalCost : -1;
		return totalCost;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		int n = 4;
		List<List<Edge>> adjacencyList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjacencyList.add(new ArrayList<>());
		}
		
		// Example Graph: 0-1 (cost 10), 0-2 (cost 6), 0-3 (cost 5), 1-3 (cost 15), 2-3 (cost 4)
		// (a, b) -> (dest, cost)
		adjacencyList.get(0).add(new Edge(1, 10));
		adjacencyList.get(1).add(new Edge(0, 10));
		adjacencyList.get(0).add(new Edge(2, 6));
		adjacencyList.get(2).add(new Edge(0, 6));
		adjacencyList.get(0).add(new Edge(3, 5));
		adjacencyList.get(3).add(new Edge(0, 5));
		adjacencyList.get(1).add(new Edge(3, 15));
		adjacencyList.get(3).add(new Edge(1, 15));
		adjacencyList.get(2).add(new Edge(3, 4));
		adjacencyList.get(3).add(new Edge(2, 4));
		
		PrimsMST myObj = new PrimsMST();
		// at the very beginning, we have to start our traversing from a node.
		// We want to start with node `1`. So we write Edge(1,0). This means: target `1`, cost `0`
		// cost `0` because we came from nowhere. We are just beginning.
		Edge startingNode = new Edge(1, 0);
		System.out.println("Minimum Spanning Tree Cost: " + myObj.minSpanningTree(adjacencyList, startingNode));
		// Expected: 19 (Edges: 0-1 (10), 0-3 (5), 3-2 (4))
	}
}