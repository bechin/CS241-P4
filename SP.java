//Ben Chin
//CS241
//project4: DijkStra's
import graph.*;
import java.io.*;
import java.util.Stack;

public class SP extends GreedyGraph{

	public SP(String filename)throws IOException{
		super(filename);
	}

	public double newCost(int v, int w){
		return costOf(v) + weightOf(getEdge(v,w));
	}

	public static void main(String[] args)throws IOException{
                if(args.length == 0){
                        System.out.println("You forgot the filename...");
                        System.exit(1);
                }
		String filename = args[0];
		SP graph = new SP(filename);
                System.out.print(graph);
		graph.greedy(0);
//prints cost table
/*		System.out.println("\nCost table\n" +
				   "Vertex\t|\tCost\n" +
				   "---------------------");
		for(int i = 0; i < graph.getOrder(); i++){
			System.out.println(i + "\t|\t" + graph.costOf(i));
		}*/
		System.out.println("\nShortest Path Tree\n" +
				   "Vertex|Vertex|Weight");
		Stack<Edge> stack = new Stack<>();
		int curVertex = graph.getOrder()-1;
		while(curVertex != 0){
			for(int n: graph.getNeighbors(curVertex)){
				Edge curEdge = graph.getEdge(curVertex,n);
				if(graph.costOf(n) + curEdge.getWeight()
				   == graph.costOf(curVertex)){
					stack.push(curEdge);
					curVertex = n;
					break;
				}
			}
		}
		int size = stack.size();
		for(int i = 0; i < size; i++)
			System.out.println(stack.pop());
		double totalCost = graph.costOf(graph.getOrder()-1);
		System.out.printf("Total Distance: %.2f\n", totalCost);
	}

}
