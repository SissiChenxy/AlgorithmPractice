package BFS.BFS1;

import BasicDataStructure.Graph.GraphNode;

import java.util.*;

public class Bipartite {
    /*
    BFS1
    Data Structure: FIFO queue
    Algorithm:
        1. initial state: Q = {Node 1}
        2. Expand/Generate Rule:
            assign group while generating
            if visited, check whether the group is same or not
                a. same ---- conflict
                b. different ---- good
            if not visited, assign the node with different group from current node, and offer in queue
        3. termination condition:
            a. Q is empty ----- true
            b. conflict ------ false
        4. dedup: map --- record each node's group(empty, u, v)
     */
    public boolean isBopartite(List<GraphNode> graph){
        if(graph.size() <= 1){
            return false;
        }

        Map<GraphNode, Integer> visited = new HashMap<>();
        for(GraphNode node : graph){
            Queue<GraphNode> queue = new LinkedList<>();

            if(visited.containsKey(node)){
                continue;
            }

            queue.offer(node);
            visited.put(node, 0);
            while(!queue.isEmpty()){
                GraphNode current = queue.poll();

                int curGroup = visited.get(current);
                int otherGroup = curGroup == 0 ? 1 : 0;

                for(GraphNode nei : current.neighbors){
                    if (!visited.containsKey(nei)){
                        visited.put(nei, otherGroup);
                        queue.offer(nei);
                    }else if (visited.get(nei) != otherGroup){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void test1(){
        List<GraphNode> graph = new ArrayList<>();
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);
        n1.neighbors.add(n2);
        n1.neighbors.add(n3);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n2.neighbors.add(n4);
        n3.neighbors.add(n1);
        n3.neighbors.add(n2);
        n4.neighbors.add(n2);
        graph.add(n1);
        graph.add(n2);
        graph.add(n3);
        graph.add(n4);
        System.out.println(isBopartite(graph));
    }
}
