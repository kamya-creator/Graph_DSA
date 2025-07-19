package UnionFind_DSU;

public class Intro {
    public static int find(int x, int[] parent)
    {
        if(x == parent[x])
            return x;

        return parent[x] = find(parent[x], parent);
    }

    public static void union(int x, int y, int[] parent, int [] rank)
    {
        int x_ult_parent = find(x, parent);
        int y_ult_parent = find(y, parent);

        if(x_ult_parent == y_ult_parent)
                return;

        if(rank[x_ult_parent] > rank[y_ult_parent])
        {
            parent[y_ult_parent] = x_ult_parent;
        }
        else if(parent[y_ult_parent] > parent[x_ult_parent])
        {
            parent[x_ult_parent] = y_ult_parent;
        }
        else if(rank[x_ult_parent] == rank[y_ult_parent])
        {
            parent[x_ult_parent] = y_ult_parent;
            rank[x_ult_parent]++;
        }
    }
    public static void main(String[] args) {
        int v = 7;

        int[] parent = new int[v];
        int[] rank = new int[v];

        for (int i = 0; i < v; i++) {

            parent[i] = i;
            rank[i] = 0;
        }

        /*
        Dynamically constructing the graph
        Not the actual graph but the grouping the connecting components together with the help of DSU
         */
        union(0,1, parent, rank);
        System.out.println((((find(0, parent) == find(1, parent))) ? "Yes x : 0 and y : 1 are in same component" : "No x : 0 and y : 1 are not in same component ") ) ;

        union(0,2, parent, rank);
        System.out.println((((find(0, parent) == find(2, parent))) ? "Yes x : 0 and y : 2 are in same component" : "No x : 0 and y : 2 are not in same component ") ) ;

        union(3,4, parent, rank);
        System.out.println((((find(3, parent) == find(4, parent))) ? "Yes x : 3 and y : 4 are in same component" : "No x : 3 and y : 4 are not in same component ") ) ;

        union(5,6, parent, rank);
        System.out.println((((find(0, parent) == find(1, parent))) ? "Yes x : 5 and y : 6 are in same component" : "No x : 5 and y : 6 are not in same component ") ) ;


        System.out.println((((find(0, parent) == find(6, parent))) ? "Yes x : 0 and y : 6 are in same component" : "No x : 0 and y : 6 are not in same component ") ) ;

    }
}
