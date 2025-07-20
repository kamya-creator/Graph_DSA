package DSU;


import java.util.Arrays;

public class SatisfiabilityofEqualityEquations {

    static int[] parent= new int[26]; static int[] rank = new int[26];

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
        String[] equations =  {"a==b", "c==d", "e==f", "g==h", "a!=c", "b!=d", "a!=b"};

        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        boolean ans = equationsPossible(equations);
        System.out.println(ans);

    }

    private static boolean equationsPossible(String[] equations) {


        for(String str : equations)
        {

            int u = str.charAt(0) - 'a';
            int v = str.charAt(3) - 'a';
            String sym = str.substring(1,3);
            if(sym.equals("=="))
            {
                union(u, v, parent, rank);
            }

        }

        for (String str : equations)
        {
            int u = str.charAt(0) - 'a';
            int v = str.charAt(3) - 'a';
            String sym = str.substring(1,3);
            if(sym.equals("!="))
            {
                int x = find(u, parent);
                int y = find(v, parent);
                if(x == y) return false;
            }
        }
        return true;


    }
}
