package BasicDataStructure.Graph;

import java.util.*;

public class DeepCopy {
    //dfs
    public List<GraphNode> copy(List<GraphNode> graph) {
        // Write your solution here.
        Map<GraphNode, GraphNode> map = new HashMap<>();
        for (GraphNode node : graph){
            if (!map.containsKey(node)){
                map.put(node, new GraphNode(node.key));
            }
            dfs(node, map);
        }
        return new ArrayList<GraphNode>(map.values());
    }

    //无返回值
    private void dfs(GraphNode node, Map<GraphNode, GraphNode> map){
        for (GraphNode neighbor : node.neighbors){
            if (!map.containsKey(neighbor)){
                map.put(neighbor, new GraphNode(neighbor.key));
                dfs(neighbor, map);
            }
            map.get(node).neighbors.add(map.get(neighbor));
        }
    }

    //dfs
    public List<GraphNode> copy2(List<GraphNode> graph) {
        // Write your solution here.
        Map<GraphNode, GraphNode> map = new HashMap<>();
        for (GraphNode node : graph){
            dfs2(node, map);
        }
        return new ArrayList<GraphNode>(map.values());
    }

    //有返回值,返回N'
    private GraphNode dfs2(GraphNode node, Map<GraphNode, GraphNode> map){
        if (node == null){
            return null;
        }
        if (map.containsKey(node)){
            return map.get(node);
        }
        //不contains
        GraphNode copyNode = new GraphNode(node.key);
        map.put(node, copyNode);
        for (GraphNode neighbor : node.neighbors){
            copyNode.neighbors.add(dfs2(neighbor,map));
        }
        return copyNode;
    }

    //bfs1
    public List<GraphNode> copy3(List<GraphNode> graph) {
        // Write your solution here.
        Queue<GraphNode> queue = new ArrayDeque<>();
        Map<GraphNode, GraphNode> map = new HashMap<>();

        for(GraphNode graphNode : graph){
            if(!map.containsKey(graphNode)){
                map.put(graphNode, new GraphNode(graphNode.key));
                queue.offer(graphNode);
            }
            while (!queue.isEmpty()){
                //expanding
                GraphNode node = queue.poll();
                GraphNode copyNode = map.get(node);

                for (GraphNode neighbor : node.neighbors){
                    //generating
                    if(!map.containsKey(neighbor)){
                        map.put(neighbor, new GraphNode(neighbor.key));
                        queue.offer(neighbor);
                    }
                    //mapping
                    copyNode.neighbors.add(map.get(neighbor));
                }
            }
        }
        return new ArrayList<>(map.values());
    }
}
