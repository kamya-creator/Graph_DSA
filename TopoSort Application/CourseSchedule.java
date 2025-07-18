package TopoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {
       /* int numCourses = 8;
        int[][] prerequisites = {
                {1, 0},
                {2, 1},
                {3, 2},
                {4, 1},
                {5, 0},
                {5, 4},
                {6, 3},
                {6, 5},
                {7, 6}
        };*/
        int numCourses = 2;
        int[][] prerequisites = {{1,0},{0,1}};
        ArrayList<Integer>[] adjList = new ArrayList[numCourses];
        ArrayList<Integer> list = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }
        for(int [] edge : prerequisites)
        {
            int src = edge[1];
            int dest = edge[0];

            adjList[src].add(dest);
            indegree[dest]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0)
            {
                queue.add(i);
            }
        }

        while(queue.size() > 0)
        {

            int curr = queue.poll();
            list.add(curr);

            for (int nbr : adjList[curr])
            {
                indegree[nbr]--;
                if(indegree[nbr] == 0)
                {
                    queue.add(nbr);
                }
            }
        }

        System.out.println(list);
        System.out.println(list.size() == numCourses ? "Yes All courses can be completed " : "No All courses can't be completed");
    }
}
