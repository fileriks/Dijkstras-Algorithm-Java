
import java.io.*;
import java.util.*;
import Lab3Help.*;
/**
 * Main class for Lab 3
 * Takes 4 arguments, list of stops, list of lines, starting stop and end stop
 * Creates graph object and calculates shortest path, and prints the time and the stops it goes through
 * @author Filip Eriksson and Marcus Holmström
 * 
 */

public class Lab3   {

	public static void main(String[] args) throws MalformedData, IOException {
		Lab3File fileParser = new Lab3File();
		List<BStop> stops = fileParser.readStops(args[0]);
		List<BLineTable> lines = fileParser.readLines(args[1]);
		BStop stopA = new BStop("Error",0,0);
		BStop stopB = new BStop("Error",0,0);
		for(int i = 0; i<stops.size();i++) {
			if(stops.get(i).toString().equals(args[2])) {
				stopA = stops.get(i);
			}
			if(stops.get(i).toString().equals(args[3])) {
				stopB = stops.get(i);
			}

		}
		Graph<BStop> graph = new Graph<BStop>();
		for(int i = 0; i <stops.size();i++) {
			graph.addNode(stops.get(i));
		}
		int index = 0;

		//add edges to graph by iterating through stops,lines and stops of lines
		for(int k = 0; k<stops.size();k++) {
			for(int i = 0; i<lines.size();i++) {
				for(int j = 0; j<lines.get(i).getStops().length-1;j++) {
					if(stops.get(k).toString().equals(lines.get(i).getStops()[j].getName())){
						for(int h = 0; h<stops.size();h++) {
							if(stops.get(h).toString().equals(lines.get(i).getStops()[j+1].getName())){
								index = h;
								graph.addEdge(stops.get(k), stops.get(index), lines.get(i).getStops()[j+1].getTime());
							}
						}

					}
				}
			}
		}
		DijkstraStringPath dijk = new DijkstraStringPath(stops,lines);
		dijk.computePath(stopA.toString(), stopB.toString());
		System.out.println(""+dijk.getPathLength());
		Iterator<String> path = dijk.getPath();
		while(path.hasNext()) {
			System.out.println(path.next());
		}
	}
}


