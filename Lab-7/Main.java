class Main {
  public static void main(String[] args) {
    String[] vertices = {
  "Liberal Arts",                // 0
  "Student Services",            // 1
  "Health Careers & Sciences",   // 2
  "Health Technologies Center",  // 3
  "Recreation Center",           // 4
  "Technology Learning Center",  // 5
  "Business & Technology",       // 6
  "Theatre"                      // 7
};

    // 2-Define Edges
    int[][] edges = {
      {0, 1}, {1, 0}, // Liberal Arts <-> Student Services
      {0, 7}, {7, 0}, // Liberal Arts <-> Theatre
      {1, 2}, {2, 1}, // Student Services <-> Health Careers & Sciences
      {1, 5}, {5, 1}, // Student Services <-> Technology Learning Center
      {1, 7}, {7, 1}, // Student Services <-> Theatre
      {2, 3}, {3, 2}, // Health Careers & Sciences <-> Health Technologies Center
      {2, 4}, {4, 2}, // Health Careers & Sciences <-> Recreation Center
      {4, 5}, {5, 4}, // Recreation Center <-> Technology Learning Center
      {5, 6}, {6, 5}, // Technology Learning Center <-> Business & Technology
      {6, 7}, {7, 6}  // Business & Technology <-> Theatre
    };

    // 3. Create the graph (name "graph") using the vertices and edges
    UnweightedGraph<String> graph = new UnweightedGraph<>(vertices, edges);
    
    // 4. Perform a depth-first search (name "dfs")(DFS) starting from the "Business & Technology" building
    UnweightedGraph<String>.SearchTree dfs = graph.dfs(6);
    
    // 5. Retrieve and print the search order of the DFS traversal
    System.out.println("DFS Search Order:");
    for (int index : dfs.getSearchOrder()) {
      System.out.println(graph.getVertex(index));
    }
    
    // 6. Print the parent-child relationships for each vertex during the DFS traversal
    System.out.println("\nParent-Child Relationships:");
    for (int i = 0; i < graph.getSize(); i++) {
      if (dfs.getParent(i) != -1) {
        System.out.println(graph.getVertex(dfs.getParent(i)) + " -> " + graph.getVertex(i));
      }
    }    
      
    // 7. Call the printPath method (assuming this method exists in the UnweightedGraph class)
    System.out.println("\nPaths from Business & Technology:");
    dfs.printPath(3);
    System.out.println();

    dfs.printPath(1);
    System.out.println();

    dfs.printPath(4);
    System.out.println();
  
    // 8. Call printTree() to print the entire DFS tree (assuming this method exists in the UnweightedGraph class)
    System.out.println("\nDFS Tree:");
    dfs.printTree(); 
  }
}