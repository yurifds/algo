package ds.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class TreeHeight {
   static class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}

public class ComputeTreeHeight {
    int n;
    int parent[];

    void read() throws IOException {
        TreeHeight.FastScanner in = new TreeHeight.FastScanner();
        n = in.nextInt();
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = in.nextInt();
        }
    }

    int computeHeight() {
        //System.out.println(build());
        Map<Integer, List<Integer>> nodes = build();
        int rootKey = getRootKey();
        return calculateHeight(nodes, rootKey);
    }

    int calculateHeight(Map<Integer, List<Integer>> nodes, int rootKey) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(rootKey);
        int nodeCount = 0;
        int height = 0;
        while (true) {
            //System.out.println(queue);
            nodeCount = queue.size();

            if (nodeCount == 0) {
                return height;
            }

            height++;

            while (nodeCount > 0) {
                int nodeKey = queue.poll();
                if (nodes.get(nodeKey) != null) {
                    for (int i = 0; i < nodes.get(nodeKey).size(); i++) {
                        queue.offer(nodes.get(nodeKey).get(i));
                    }
                }
                nodeCount--;
            }
        }
    }

    int getRootKey() {
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                return i;
            }
        }
        return 0;
    }

    Map<Integer, List<Integer>> build() {
        Map<Integer, List<Integer>> nodes = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                continue;
            } else {
                if (!nodes.containsKey(parent[i])) {
                    List<Integer> nodeChildren = new ArrayList<>();
                    nodeChildren.add(i);
                    nodes.put(parent[i], nodeChildren);
                } else {
                    nodes.get(parent[i]).add(i);
                }
            }
        }

        return nodes;
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new ComputeTreeHeight().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }

    public void run() throws IOException {
        ComputeTreeHeight tree = new ComputeTreeHeight();
        tree.read();
        System.out.println(tree.computeHeight());
    }
}


