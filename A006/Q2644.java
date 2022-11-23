package A006;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Q2644 {

    public static void main(String[]args) {
        int n = 9;
        int input[] = {3,7};
        int m = 7;
        Graph graph = new Graph(n+1);
        graph.put(1,2);
        graph.put(1,3);
        graph.put(2,7);
        graph.put(2,8);
        graph.put(2,9);
        graph.put(4,5);
        graph.put(4,6);

        graph.printGraph();
        graph.test();


    }
}

class Graph {
    private ArrayList<ArrayList<Integer>> graph;

    public Graph(int size) {
        this.graph = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i<size+1; i++) {
            graph.add(new ArrayList<Integer>());
        }
    }

    public ArrayList<ArrayList<Integer>> getGraph() {
        return this.graph;
    }

    public ArrayList<Integer> getNode(int num) {
        return this.graph.get(num);
    }

    public void put(int x, int y) {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }
    //그래프 추가 (단방향)
    public void putSingle(int x, int y) {
        graph.get(x).add(y);
    }

    public void printGraph() {
        for(int i = 1; i < graph.size(); i++) {
            if(graph.get(i).size() == 0) {
                continue;
            }
            System.out.print("정점 " + i + "의 인접리스트");
            for(int j = 0; j<graph.get(i).size(); j++) {
                System.out.print(" -> " + graph.get(i).get(j));
            }
            System.out.println();
        }
    }

    public void test() {
        int[] input = {3,7};
        int count = 0;
        int result = dfs(graph.get(input[0]), count, input[1]);
    }
    public int dfs(ArrayList<Integer> inside, int count, int second) {

        for(int i = 0; i < inside.size(); i++) {
//            dfs(graph.get(input[i]), count);
            count++;
            if(inside.get(i) == second) {
                return count;
            }
            dfs(graph.get(inside.get(i)), count, second);
        }
        return -1;
    }
}
