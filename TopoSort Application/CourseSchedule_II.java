package TopoSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule_II {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};

        ArrayList<Integer> [] adjList = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int[] list = new int[numCourses];
        int index = 0;


        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : prerequisites)
        {
            int src = edge[1];
            int dest = edge[0];

            adjList[src].add(dest);
            indegree[dest]++;

        }

        for (int i = 0; i < numCourses ; i++) {
            if(indegree[i] == 0)
            {
                queue.add(i);
            }
        }

        while (queue.size() > 0)
        {
            int curr = queue.poll();
            list[index++] = curr;

            for (int nbr : adjList[curr])
            {
                indegree[nbr]--;
                if(indegree[nbr] == 0)
                {
                    queue.add(nbr);
                }
            }
        }

        if(index == numCourses)
        {
            System.out.println(Arrays.toString(list));
        }
        else{
            System.out.println("No it cannot be completed");
        }
    }
}
