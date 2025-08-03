package Euler_Path_and_Circuit;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Reconstruct_Itinerary_Leetcode_332 {
    public static void DFSonEdges(String node, HashMap<String, CopyOnWriteArrayList<String>> adj, ArrayList<String> path)
    {
        Stack<String> st = new Stack<>();
        st.push(node);

        while(st.size() > 0)
        {
            String st_top = st.peek();
            System.out.println(st.peek());
            while(adj.containsKey(st_top) && adj.get(st_top).size() > 0)
            {
                String nextEdge = adj.get(st_top).remove(0);
                st.push(nextEdge);

                System.out.println(st.peek());
                st_top = st.peek();
            }
            path.add(st.pop());

        }
    }
    public static void main(String[] args) {
        String[][] tickets  = new String[][]{{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        // Build graph
        HashMap<String, CopyOnWriteArrayList<String>> adj = new HashMap<>();
        HashMap<String, Integer> inOutDegree = new HashMap<>();
        for(String[] edge : tickets)
        {
            String src = edge[0];
            String dest = edge[1];

            adj.putIfAbsent(src, new CopyOnWriteArrayList<>());
            adj.get(src).add(dest);
            inOutDegree.put(src, inOutDegree.getOrDefault(src, 0) + 1);
            inOutDegree.put(dest, inOutDegree.getOrDefault(dest, 0) -1);
        }
        System.out.println(adj);
        System.out.println(inOutDegree);
        String startNode = "";
        for (Map.Entry<String, Integer> entry : inOutDegree.entrySet())
        {
            if(entry.getValue() == 1)
            {
                startNode = entry.getKey();
                break;
            }
        }
        ArrayList<String> path = new ArrayList<>();
        DFSonEdges(startNode,adj, path);
        Collections.reverse(path);
        System.out.println(path);
    }
}
