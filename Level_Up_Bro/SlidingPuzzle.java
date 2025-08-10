package Graph_Level_2;

import java.util.*;

public class SlidingPuzzle {
    public  static int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<2;i++)
        {
            for(int j =0;j<3;j++)
            {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();
        String target = "123450";
        HashSet<String> visited = new HashSet<>();
        visited.add(start);
        Integer[][] pos = {{1,3},{0,2,4},{1,5},{0,4},{3,1,5},{4,2}};
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0 ;i<6;i++)
        {
            List<Integer> list = Arrays.asList(pos[i]);
            map.put(i, list);
        }
        int level = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        while(queue.size() > 0)
        {
            int size = queue.size();
            while(size-- > 0)
            {
                String curr = queue.poll();
                if(curr.equals(target)) return level;

                int indexOfZero = curr.indexOf('0');

                List<Integer> posPos = map.get(indexOfZero);
                // swapping
                for(int poss : posPos)
                {
                    StringBuilder temp = new StringBuilder(curr);
                    char ch1           = temp.charAt(poss);
                    temp.setCharAt(poss, '0');
                    temp.setCharAt(indexOfZero, ch1);


                    if(!visited.contains(temp.toString()))
                    {
                        visited.add(temp.toString());
                        queue.add(temp.toString());
                    }

                }

            }
            level++;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] board = {{4,1,2},{5,0,3}};
        int ans = slidingPuzzle(board);
        System.out.println(ans);
    }
}
