package DijkstraAlgo;

class Pair implements Comparable<Pair>
{
    int dest;
    int weight;

    Pair(int dest, int weight)
    {
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Pair o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Pair{" +
                dest +
                ", " + weight +
                '}';
    }
}
