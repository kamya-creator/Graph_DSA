package Euler_Path_and_Circuit;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Valid_Arrangement_of_Pairs {
    public static void DFSonEdges(int j, HashMap<Integer, CopyOnWriteArrayList<Integer>> adj, ArrayList<Integer> path)
    {
        Stack<Integer> st = new Stack<>();
        st.push(j);
        while(st.size() > 0)
        {
            int st_top = st.peek();
            while(adj.containsKey(st_top)  && adj.get(st_top).size() > 0)
            {
                int next = adj.get(st_top).remove(0);
                st.push(next);
                st_top = st.peek();

            }
            int last = st.pop();
            path.add(last);

        }
    }
    public static int[][] validArrangement(int[][] pairs) {
        HashMap<Integer, CopyOnWriteArrayList<Integer>> map = new HashMap<>();
        HashMap<Integer,Integer> inOutDegree = new HashMap<>();
        for(int[] edge : pairs)
        {
            int u = edge[0];
            int v = edge[1];
            if(!map.containsKey(u))
            {
                CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
                list.add(v);
                map.put(u, list);

            }
            else{
                CopyOnWriteArrayList<Integer> list = map.get(u);
                list.add(v);
                map.put(u, list);
            }
            inOutDegree.put(u, inOutDegree.getOrDefault(u, 0) + 1);
            inOutDegree.put(v, inOutDegree.getOrDefault(v, 0) -1);
        }
        int startNode = pairs[0][0];
        for(Map.Entry<Integer, Integer> entry : inOutDegree.entrySet())
        {
            if((entry.getValue() ) == 1)
            {
                startNode = entry.getKey();
                break;
            }
        }
        ArrayList<Integer> path = new ArrayList<>();

        DFSonEdges(startNode, map, path);
        Collections.reverse(path);

        int[][] ans = new int[pairs.length][2];
        for(int i =0;i<path.size()-1;i++)
        {
            int[] curr = new int[2];
            curr[0] = path.get(i);
            curr[1]  = path.get(i +1);
            ans[i] = curr;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] pairs = {{5,1},{4,5},{11,9},{9,4}};
        int[][] arrangement = validArrangement(pairs);
        for(int[] arr : arrangement)
            System.out.println(Arrays.toString(arr));
    }
}
