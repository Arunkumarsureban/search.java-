
import java.util.*;


import java.io.*;
class dr {
	
	private static ArrayList<Node> Pathqueue = new ArrayList<Node>();
	public static void ucs(Node startingnode,Node endingnode)
	{
		startingnode.pathcost = 0;
        PriorityQueue<Node> queue = new PriorityQueue<Node>(20, 
            new Comparator<Node>()
        		{
                public int compare(Node i, Node j)
                {
                    if(i.pathcost > j.pathcost)
                    {
                        return 1;
                    }

                    else if (i.pathcost < j.pathcost)
                    {
                        return -1;
                    }

                    else{
                        return 0;
                    }
                }
        		}
                );
        queue.add(startingnode);
        Node currentNode = startingnode;
      		
        do{
        	
        	currentNode = queue.poll();
        	currentNode.visited=true;
		if (currentNode.equals(endingnode)) {
			Node A= endingnode;
          	while(A!=null)
          	{
          		Pathqueue.add(A);
          		A=A.parent;
          	}
          	Collections.reverse(Pathqueue);
          	try
          	{
          	PrintWriter writer = new PrintWriter("output.txt");
          	

          			for(int i=0; i<Pathqueue.size();i++)
          			{
          				writer.println((Pathqueue.get(i).id+ " "+ Pathqueue.get(i).pathcost));
          			}
          			writer.close();
          	}
          	
          	catch(Exception e){e.printStackTrace();}
			  return; 
		  }
		for(edgeContents e: currentNode.edges)
		{
		
		 	int cost  = e.cost;
		 	Node child  = e.end;
		    child.pathcost=currentNode.pathcost+cost;   
		    if(!child.visited){
		    	queue.add(child);
		    	child.parent=currentNode;
		    }
		}
        }while(!queue.isEmpty());
        
		}
	public static void A(Node startingnode,Node endingnode){
		 
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>(20,
				new Comparator<Node>()
					{
						public int compare(Node i, Node j)
							{
								if(i.pathcost > j.pathcost)
										{
											return 1;
										}

								else if (i.pathcost < j.pathcost)
								{
									return -1;
								}

								else{
									return 0;
								}
        }
					}
	);
		
		queue.add(startingnode);
		Node currentNode = startingnode;
		 do{
	        	
	        	currentNode = queue.poll();
	        	currentNode.visited=true;
			if (currentNode.equals(endingnode)) {
				Node A= endingnode;
	          	while(A!=null)
	          	{
	          		Pathqueue.add(A);
	          		A=A.parent;
	          	}
	          	Collections.reverse(Pathqueue);
	          	try
	          	{
	          	PrintWriter writer = new PrintWriter("output.txt");
	          	

	          			for(int i=0; i<Pathqueue.size();i++)
	          			{
	          				writer.println((Pathqueue.get(i).id+ " "+ Pathqueue.get(i).pathcost));
	          			}
	          			writer.close();
	          	}
	          	
	          	catch(Exception e){e.printStackTrace();}
				  return; 
			  }
			for(edgeContents e: currentNode.edges)
			{
			
			 	int cost  = e.cost;
			 	Node child  = e.end;
			 	int den= currentNode.hu;
			 	int used=currentNode.pathcost+ den;
			    child.pathcost=used+cost;   
			    if(!child.visited){
			    	queue.add(child);
			    	child.parent=currentNode;
			    }
			}
	        }while(!queue.isEmpty());
	        
			}
	
	
	public static void dfs(Node startingnode, Node endingnode) {
		
		
			Node currentNode = startingnode;
		  currentNode.visited = true;
		 
		  if (currentNode.equals(endingnode)) {
			Node A= endingnode;
          	while(A!=null)
          	{
          		Pathqueue.add(A);
          		A=A.parent;
          	}
          	Collections.reverse(Pathqueue);
          	try
          	{
          	PrintWriter writer = new PrintWriter("output.txt");
          	

          			for(int i=0; i<Pathqueue.size();i++)
          			{
          				writer.println((Pathqueue.get(i).id+ " "+ i));
          			}
          			writer.close();
          	}
          	
          	catch(Exception e){e.printStackTrace();}
			  return; 
		  }
		  
		  for (Node neighbor : currentNode.neighbors) {
		    if (!neighbor.visited) {
		    	neighbor.parent=currentNode;
		      dfs(neighbor,endingnode);
		      
		      
		    }
		  }
		}
	
	
	public void bfs (Node startingnode, Node endingnode){
			Pathqueue = new ArrayList<Node>();
			
	        
	        Queue<Node> queue = new LinkedList<Node>();
	        if(startingnode.equals(endingnode)){
	            System.out.println("Goal Node Found!");
	            System.out.println(startingnode);
	        }
	        queue.add(startingnode);
	        if (queue.isEmpty()) {
	            return;
	          }
	          
	          while (!queue.isEmpty()) {
	            Node currentNode = queue.poll();
	           
	            
	            if (currentNode.equals(endingnode)) {
	            	Node A= endingnode;
	            	while(A!=null)
	            	{
	            		Pathqueue.add(A);
	            		A=A.parent;
	            	}
	            	Collections.reverse(Pathqueue);
	            	try{
	            		PrintWriter writer = new PrintWriter("output.txt");
	            	
	            	for(int i=0; i<Pathqueue.size();i++)
	            	{
	            		writer.println((Pathqueue.get(i).id+ " "+ i));
	            	}
	            	writer.close();
	              	}
	              	
	              	catch(Exception e){e.printStackTrace();}
	    			  return;
	            }
	           
	            for (Node neighbor : currentNode.neighbors) 
	            {
	            	if(!neighbor.visited)
	            	{
	            	queue.add(neighbor);
	            	neighbor.visited=true;
	            	neighbor.parent=currentNode;
	            	}
	            }
	          }
	    }
	
	    
	    
		public static class Node{
			
			 public Node endingnode;
			public double cost;
			public Object value;
			public int pathcost;
			String  id;
			 HashSet<edgeContents> edges;
			 boolean visited;
			 ArrayList<Node> neighbors;
			 Node parent;			 
			 int hu;
		
			 
			 public Node(String name){
				 id = name;
				 edges = new HashSet<dr.edgeContents>();
				 visited=false;
				 neighbors=new ArrayList<dr.Node>();
				 parent=null;
				 hu=0;
			 }	
			 
			 
			 public Collection<String> getChildren() {
				
				return null;
			}


			public Node(Node anotherNode){
				 this.id = anotherNode.id;
				 this.edges = anotherNode.edges;
			 }
		}
		
		
		public static class edgeContents{
			
			int cost;
			public edgeContents( Node start, Node end,int cost){
				this.start = start;
				this.end = end;
				this.cost=cost;
			}
				
			
		    public boolean equals(Object obj) {
		      edgeContents e = (edgeContents)obj;
		      return e.end == end && e.start == start;
		    }

			Node start;
			Node end;
			public Object finishingNode;
			public Object startingNode;
		}
		
		public void addNode(dr g,String nodeId){
			Node nodeToAdd = new Node(nodeId);
			g.nodes.add(nodeToAdd);
			g.nodeMap.put(nodeId, nodeToAdd);
		}
		
				
		public  void addNode(dr g,Node nodeToAdd){

			g.nodes.add(nodeToAdd);
			g.nodeMap.put(nodeToAdd.id, nodeToAdd);
			
		}
		
		public void addEdges(dr g,Node startingNode,Node finishingNode, int cost ){
			edgeContents edge = new edgeContents(startingNode, finishingNode,cost);
			g.edges.add(edge);
			startingNode.edges.add(edge);
			nodes.add(startingNode);
		}
		
		public HashMap<String, Node> getNodeMap(){
			return nodeMap;
		}
		
		public void setNodeMap(HashMap<String, Node> nodeMap){
			
			this.nodeMap = nodeMap;
			
		}
		
		
		public HashSet<Node> getAllNodes(){
			return nodes;
		}
		
		public HashSet<edgeContents> getEdges(){
			return edges;
		}
		public HashSet<Node> nodes = new HashSet<dr.Node>();
		public  HashSet<edgeContents> edges = new HashSet<dr.edgeContents>();
		  HashMap<String, Node> nodeMap = new HashMap<String,dr.Node>();
		public static void A(Node startingnode, Node endingnode, Node node) {
		}
}
		public class homework {
		public static void main(String[] args) {
			
			String fileName = "input.txt";	        
	        try {
	          
	            	FileReader fileReader = new FileReader(fileName);
	            	BufferedReader brread = new BufferedReader(fileReader);
	            	String algo = brread.readLine();
	            	System.out.println(algo);
	            	String start= brread.readLine();
	               String end = brread.readLine();
	              String noedges = brread.readLine();
	              dr graph = new dr();
	              for (int x=0;x<Integer.parseInt(noedges);x++)
	              {
	            	  
	            	  String a = brread.readLine();
	            	  String[] b =a .split(" ");
	            	  dr.Node startingnode ;
	            	  dr.Node endingnode; 
	            	  if (graph.nodeMap.containsKey(b[0]))
	            	  {
	            		  startingnode = graph.nodeMap.get(b[0]);
	            	  
	            	  }
	            	  else 
	            	  {
	            		  graph.addNode(graph,b[0]);
	            		  startingnode = graph.nodeMap.get(b[0]);
	            	  }
	            	  if (graph.nodeMap.containsKey(b[1]))
		              {
		            	  endingnode = graph.nodeMap.get(b[1]);
		            	  
		              }
		              else {
		            	  graph.addNode(graph,b[1]);
		            	  endingnode= graph.nodeMap.get(b[1]);
		              }
                     graph.addEdges(graph, startingnode, endingnode, Integer.parseInt(b[2]));
                     startingnode.neighbors.add(endingnode);
	              }
	              String H = brread.readLine();
	              for (int x=0;x<Integer.parseInt(H);x++){
	            	  String q=brread.readLine();
	            	  	String[] b=q.split(" ");
	            	  	dr.Node den =graph.nodeMap.get(b[0]);
	            	  	den.hu=Integer.parseInt(b[1]);
	              }
	              if(algo.equals("BFS"))
	              {
	            	  graph.bfs(graph.nodeMap.get(start),graph.nodeMap.get(end));
	              }
	              if(algo.equals("DFS"))
	              {
	            	  dr.dfs(graph.nodeMap.get(start),graph.nodeMap.get(end));
	              }
	              if (algo.equals("UCS"))
	              {
	            	  dr.ucs(graph.nodeMap.get(start),graph.nodeMap.get(end));
	              }
	              if(algo.equals("A*"))
	              {
	            	
					dr.A(graph.nodeMap.get(start),graph.nodeMap.get(end));
	              }

	         
	              
	              brread.close();
	        }
	        catch(FileNotFoundException ex) {
	            System.out.println(
	                "Unable to open file '" + 
	                fileName + "'");   
	            ex.printStackTrace();
	        }
	        catch(IOException ex) {
	            System.out.println(
	                "Error reading file '" 
	                + fileName + "'");                  
	         
	        }
	    }
	}
