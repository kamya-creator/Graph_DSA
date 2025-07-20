package DSU;

public class NumberofOperationstoMakeNetworkConnected {
    public static int find(int x, int[] parent)
    {
        if(x == parent[x])
            return x;

        return parent[x] = find(parent[x], parent);
    }
    public static void union(int x, int y, int[] parent, int[] rank)
    {
        int x_ult_parent = find(x, parent);
        int y_ult_parent = find(y, parent);

        if(x_ult_parent == y_ult_parent) return;

        if(rank[x_ult_parent] > rank[y_ult_parent])
        {
            parent[y_ult_parent] = x_ult_parent;
        }
        else if(rank[y_ult_parent] > rank[x_ult_parent])
        {
            parent[x_ult_parent] = y_ult_parent;
        }
        else if(rank[x_ult_parent] == rank[y_ult_parent])
        {
            parent[x_ult_parent] = y_ult_parent;
            rank[y_ult_parent]++;
        }
    }
    public static void main(String[] args) {
       /*int n = 6;
       int[][] connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};

        */
        int n = 6;
        int[][] connections = {{0,1},{0,2},{0,3},{1,2}};

       int ans = makeConnected(n, connections);
        System.out.println(ans);
    }

    private static int makeConnected(int n, int[][] connections) {

        int req  = n -1;
        int len = connections.length;
        if(len < req) return  -1;

        int[] parent = new int[n];
        int[] rank = new int[n];
        int comp = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int [] edge : connections)
        {
            int u = edge[0];
            int v = edge[1];

            int x = find(u, parent);
            int y = find(v, parent);

            if(x != y)
            {
                union(u, v, parent, rank);
                comp--;
            }
        }
        return  comp -1;
    }
}
