package BasicDataStructure.Graph;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args){
        DeepCopy d = new DeepCopy();
        List<GraphNode> list = new ArrayList<GraphNode>();
        GraphNode n1 = new GraphNode(0);
        GraphNode n2 = new GraphNode(1);
        GraphNode n3 = new GraphNode(2);
        //n1.neighbors.add(n2);
        //n1.neighbors.add(n3);
        n2.neighbors.add(n3);
        //n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        //n3.neighbors.add(n2);

        list.add(n1);
        list.add(n2);
        list.add(n3);
        System.out.println(d.copy3(list));
    }
}
