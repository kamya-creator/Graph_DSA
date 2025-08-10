package Graph_Level_2;

import java.util.*;

public class Bus_Routes {
    public static int numBusesToDestination(int[][] routes, int source, int target) {

        if(source == target) return 0;
        HashMap<Integer, ArrayList<Integer>> busStopVsBusId = new HashMap<>();
        int n = routes.length;
        HashSet<Integer> visitedBuses = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i =0;i<n;i++)
        {
            for(int busStop : routes[i])
            {
                ArrayList<Integer> busIndexs = busStopVsBusId.getOrDefault(busStop, new ArrayList<>());
                busIndexs.add(i);
                busStopVsBusId.put(busStop, busIndexs);
                if(busStop == source)
                {
                    queue.add(i);
                    visitedBuses.add(i);
                }
            }
        }
        int level = 1;
        while(queue.size() > 0)
        {
            int size  = queue.size();
            while(size-- > 0)
            {
                int currentBus = queue.poll();
                // ye bus kon konse stops pe jati h vo nikalo
                int[] busRoutes = routes[currentBus];
                for(int route : busRoutes)
                {
                    // agar jis busRoutes ko traverse krte hue esa busStop mil gya jo target h then return level
                    if(route == target) return level;

                    // If still we are not at dest then explore the rest busStops of route,
                    // ye check kr rhe h ki busStop se koi or bus bhi board kr sakte h ya nhi?

                    ArrayList<Integer> busstopsFromRoute = busStopVsBusId.get(route);
                    for(int j : busstopsFromRoute)
                    {
                        if(!visitedBuses.contains(j))
                        {
                            visitedBuses.add(j);
                            queue.add(j);
                        }
                    }

                }
            }
            level++;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] routes = {{1,2,3},{3,4,5},{7,8,5},{1,6,7}};
        int source = 1;
        int target = 8;
        int busesToDestination = numBusesToDestination(routes, source, target);
        System.out.println(busesToDestination);
    }

}
