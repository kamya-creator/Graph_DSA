package Euler_Path_and_Circuit;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Euler_Path_FindingAlgo_HierholzersAlgorithm {
    public static void DFSonEdges(int node, CopyOnWriteArrayList<Integer>[] adj, ArrayList<Integer> path)
    {
        Stack<Integer> st = new Stack<>();
        st.add(node);
        while(st.size() > 0)
        {
            int st_top = st.peek();
            while(adj[st_top].size() > 0)
            {
                int nbr = adj[st_top].remove(0);
                st.push(nbr);
                st_top = st.peek();
            }
            path.add(st.pop());
        }
    }
    public static void main(String[] args) {
        int[][] edgesOfDirectedGraph = {{0,2},{2,0},{1,0},{1,2},{2,1}};
        HashMap<Integer, Integer> inOutDegree = new HashMap<>();
        int V = 3;
        CopyOnWriteArrayList<Integer>[] adjList = new CopyOnWriteArrayList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new CopyOnWriteArrayList<>();
        }
        for(int[] edge : edgesOfDirectedGraph)
        {
            int src = edge[0]; int dest =  edge[1];
            adjList[src].add(dest);
            inOutDegree.put(src, inOutDegree.getOrDefault(src, 0) + 1);
            inOutDegree.put(dest, inOutDegree.getOrDefault(dest, 0) -1);
        }
        for (int i = 0; i < V; i++) {
            Collections.sort(adjList[i]);

        }
        System.out.println(Arrays.toString(adjList));
        System.out.println(inOutDegree);
        int startNode = 0;
        for(Map.Entry<Integer, Integer> entry : inOutDegree.entrySet())
        {
            if(entry.getValue() == 1)
            {
                startNode = entry.getKey();
                break;
            }
        }
        ArrayList<Integer> path = new ArrayList<>();
        DFSonEdges(startNode, adjList, path);
        Collections.reverse(path);
        System.out.println(path);
        /*
        This algo is to find the euler path in directed graph
        Condition is graph must have euler path
        for euler path check in directed graph there must be exactly one node which have out-degree - indegree = 1 (StartNode)
        and exactly one node with in-degree - outdegree = 1 (EndNode)

        else rest nodes indegree and outdegree must be same
        in = [1, 2, 3, 3, 2]
        out = [2, 2, 3, 3, 1]
        yaha sirf ek he esa node h jiski outdegree - indegree = 1 (start node hoga ye) at index 0

        StartNode se stack ke sath DFSonEdges apply krna h

         */

    }
}
