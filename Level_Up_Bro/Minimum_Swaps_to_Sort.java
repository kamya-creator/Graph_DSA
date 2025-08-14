package Graph_Level_2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class Pair1 implements Comparable<Pair1>
{
    int val;
    int index;
    Pair1(int val, int index)
    {
        this.val = val;
        this.index = index;
    }
    @Override
    public int compareTo(Pair1 o2)
    {
        return this.val  - o2.val;
    }
}

public class Minimum_Swaps_to_Sort {
    public  static int minSwaps(int arr[]) {
        int n = arr.length;
        ArrayList<Pair1> list = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            list.add(new Pair1(arr[i], i));
        }
        Collections.sort(list);
        int ans = 0;
        for(int i = 0 ; i < n ; i ++)
        {
            Pair curr = list.get(i);
            int index_ = curr.index;
            if(index_ == i || visited[index_] == true) continue;
            
            int count = 0;
            while(visited[index_] == false)
            {
                
                visited[index_] = true;
                index_          = list.get(index_).index;
                count++;
            }
            
            ans = ans + (count - 1);
            
        }
        return ans;
        
    }
    public static void main(String[] args) {
        int arr[] = {10, 19, 6, 3, 5};
        int swaps = minSwaps(arr);
        System.out.println(swaps);
    }
}

