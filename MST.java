//Ben Chin
//CS241
//project4: DijkStra's
import graph.*;
import java.io.*;

public class MST extends GreedyGraph{

	public MST(String filename)throws IOException{
		super(filename);
	}

	public double newCost(int v, int w){
		return weightOf(getEdge(v,w));
	}

	public static void main(String[] args)throws IOException{
		if(args.length == 0){
			System.out.println("You forgot the filename...");
			System.exit(1);
		}
		String filename = args[0];
		MST thisGraph = new MST(filename);
                System.out.print(thisGraph);
		thisGraph.greedy(0);
//print cost table
/*		System.out.println("\nCost table\n" +
				   "Vertex\t|\tCost\n" +
				   "---------------------");
		for(int i = 0; i < thisGraph.getOrder(); i++){
			System.out.println(i + "\t|\t" + thisGraph.costOf(i));
		}*/
		System.out.println("\nMin Spanning Tree\n" +
				   "Vertex|Vertex|Weight");
		double totalCost = 0.0;
//print tree using Selected
		for(Edge e: thisGraph.getEdges()){
			if(e.isSelected()){
				System.out.println(e);
				totalCost += e.getWeight();
			}
		}
/*		System.out.printf("Total Cost: %.2f\n", totalCost);
		System.out.println("--------------");
//print tree using cost table
		totalCost = 0.0;
		for(int i = 0; i < thisGraph.getOrder(); i++){
			for(int j: thisGraph.getNeighbors(i)){
				double currWeight = thisGraph.getEdge(i,j).getWeight();
				if(currWeight == thisGraph.costOf(i)){
				totalCost += currWeight;
				System.out.println(thisGraph.getEdge(i,j));
				break;
				}
			}
		}*/
		System.out.printf("Total Cost: %.2f\n", totalCost);
	}

}
