import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Set;

public class Graph{

	private String filename;
	private ArrayList<Vertex> vertices;
	private int order;
	private int size;
	private boolean directed;

	public Graph(String filename)throws IOException{
		this.filename = filename;
		File file = new File(filename);
		Scanner reader = new Scanner(file);
		order = reader.nextInt();
		vertices = new ArrayList<Vertex>(order);
		for(int i = 0; i < order; i++){
			vertices.add(i, new Vertex());
		}
		size = reader.nextInt();
		directed = reader.nextLine()=="directed";
		for(int i = 0; i < size; i++){
			int start = reader.nextInt();
			int end = reader.nextInt();
			double weight =  reader.nextDouble();
			vertices.get(start).addEdge(start, end, weight);
			if(!directed)
				vertices.get(end).addEdge(end, start, weight);
			reader.nextLine();
		}
	}

	public String toString(){
		String result = filename + " Order: " + order + " Size: " + size + "\n";
		for(int i = 0; i < order; i++){
			vertices.get(i).getEdges()
			result += i + " = ["
		}
	}

}

class Vertex{

	private Set<Edge> edges;
	private double cost;

	public Vertex(){
		edges = new Set<Edge>();
		cost = Integer.MAX_VALUE;
	}

	public void addEdge(int start, int end, double weight){
		edges.add(new Edge(start, end, weight));
	}

	public Object[] getEdges(){
		return edges.toArray();
	}

}

class Edge{

	private final int start;
	private int end;
	private double weight;

	public Edge(int start, int end, double weight){
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

}
