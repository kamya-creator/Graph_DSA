package Graph_Level_2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {
    public static String alienDictionary(String[] words)
    {
        HashMap<Character, HashSet<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();
        for(String word : words)
        {
            for(char c : word.toCharArray())
            {
                indegree.put(c, 0);
            }
        }
        // Build Graph
        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i+1];

            if(curr.startsWith(next) && curr.length() > next.length()) return "";
            int len = Math.min(curr.length(), next.length());
            for (int j = 0; j < len; j++) {
                char c1 = curr.charAt(j);
                char c2 = next.charAt(j);

                if(c1 != c2)
                {
                    if(!graph.containsKey(c1))
                    {
                        HashSet<Character> edge = new HashSet<>();
                        edge.add(c2);
                        indegree.put(c2, indegree.get(c2) + 1);
                        graph.put(c1, edge);
                    }
                    else{
                        HashSet<Character> edge = graph.get(c1);
                        if(edge.contains(c2) == false)
                        {
                            indegree.put(c2, indegree.get(c2) + 1);
                        }
                        edge.add(c2);
                    }
                    break;
                }
            }
        }
        System.out.println(indegree );
        // Indegree jinki 0  usse queue m add krenge
        Queue<Character> queue = new LinkedList<>();
        for(char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.add(c);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(queue.size() > 0)
        {
            char curr = queue.poll();
            ans.append(curr);

            if(graph.containsKey(curr))
            {
                for(char nbr : graph.get(curr))
                {
                    indegree.put(nbr, indegree.get(nbr) - 1);
                    if(indegree.get(nbr) == 0)
                    {
                        queue.add(nbr);
                    }
                }
            }

        }

        return ans.length() == indegree.size() ? ans.toString() : "";
    }
    public static void main(String[] args) {
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
        String topoSort = alienDictionary(words);
        System.out.println(topoSort);
    }
}
