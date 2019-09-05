package BFS.BFS2;

public class ShortestPathInGraph {
    /*
    BFS2 - dijkstra
    data structure: priority queue --- minheap (sort according to the distance from start node to current node)
    algorithm:
        1. initial state: PQ = {start node, distance(0)}
        2. expand/generate rule:
            expand: top of the PQ (node, distance)
            generate:  all neighbors
                if not visited, offer in PQ
                if visited and become shorter distance, update/offer in PQ
        3. termination condition:
            pop the target goal node/ traverse all nodes
            return distance
     */
}
