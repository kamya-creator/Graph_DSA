package FloydWarshal;

public class FloyWarshal {
    static void floydWarshall(double[][] dist) {
        int n = dist.length;
        int m = dist[0].length;


        int nodes = n;
        for (int via = 0; via < nodes; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (dist[i][via] < 1e8 && dist[via][j] < 1e8 && dist[i][j] > dist[i][via] + dist[via][j]) {
                        dist[i][j] = dist[i][via] + dist[via][j];
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        double dist[][] = {{0, 4, 1e8, 5, 1e8}, {1e8, 0, 1, 1e8, 6}, {2, 1e8, 0, 3, 1e8}, {1e8, 1e8, 1, 0, 2}, {1, 1e8, 1e8, 4, 0}};
        floydWarshall(dist);
        int n = dist.length;
        int m = dist[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print((int)dist[i][j] + " ");
            }
            System.out.println();
        }

    }


}
