import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class RecommendBook {
    //private List<Book> vertexList;
    private Book[] books;
    private List<List<Edge>> edges;
    private int noOfEdges;
    private boolean[] isVisited;
    
    public RecommendBook () {
        books = Library.books;
        int size = books.length;
        edges = new ArrayList<>(size);
        for (Book book: books) {
            edges.add(new ArrayList<Edge>());
        }
        noOfEdges = 0;
        isVisited = new boolean[size];
        generateGraph();
    }
    
    private void generateGraph() {
        //generating labels available
        ArrayList<String> categoriesLabel = new ArrayList<String>();
        for (Book book: books) {
            String temp[] = book.getCategories();
            for (String label: temp) {
                if (categoriesLabel.indexOf(label) == -1) {
                    categoriesLabel.add(label);
                }
            }
        }
        //adding edges
        for (String label : categoriesLabel) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int idx = 0; idx < books.length;idx++) {
                Book book = books[idx];
                List<String> category = Arrays.asList(book.getCategories());
                if (category.indexOf(label) != -1) {
                    list.add(idx);
                }
            }
            for (int x : list) {
                for (int y : list) {
                    if (x == y)
                        continue;
                    insertEdge(x, y);
                }
            }
        }
    }
    
    //utilizing bfs for calculating the cost
    public int calculateCost(int srcBookID, int destBookID) {
        int src = getBookIndex(srcBookID);
        int dest = getBookIndex(destBookID);
        System.out.println(src + "," + dest);
        Integer prev[] = new Integer[books.length];
        isVisited[src] = true;
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.offer(src);

        while(!queue.isEmpty()) {
            int current = queue.poll();
            List<Edge> neighbours = edges.get(current);
            for (Edge edge: neighbours){
                if(!isVisited[edge.to]) {
                    isVisited[edge.to] = true;
                    prev[edge.to] = current;
                    queue.offer(edge.to);
                    
                }
            }
        }
        System.out.println(Arrays.toString(prev));
        List<Integer> cost = reconstructGraph(src, dest, prev);
        System.out.println(Arrays.toString(cost.toArray()));
        return cost.size() - 1;
    }
    
    public List<Integer> reconstructGraph(int start, int end, Integer prev[]) {
        List<Integer> path = new ArrayList<>();
        for (Integer at = end; at != null; at = prev[at]) path.add(at);
        Collections.reverse(path);
        if (path.get(0) == start) return path;
        path.clear();
        return path;
        
    }
    
    public void showGraph() {
        for(List link : edges) {
            System.err.println(link.toString());
        }
    }
    
    public int getBookIndex (int id) {
        for (int idx = 0;idx < books.length;idx++) {
            System.out.println(books[idx].getID());
            System.out.println(idx);
            if (books[idx].getID() == id) {
                System.out.println("test");
                return idx;
            }
        }
        return -1;
    }
    
    public void insertEdge(int v1, int v2) {
        edges.get(v1).add(new Edge(v1, v2));
        noOfEdges++;
    }
}

class Edge {
    int from, to;

    public Edge(int from, int to) {
      this.from = from;
      this.to = to;
    }
}

