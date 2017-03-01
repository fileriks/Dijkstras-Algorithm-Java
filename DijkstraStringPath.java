
import java.util.*;
import Lab3Help.*;

/**
 * 
 * @author Filip Eriksson and Marcus Holmström
 * Used only to pass tests.
 *
 */

public class DijkstraStringPath implements Path<String> {
	private Dijkstra<String> dijk;

	public DijkstraStringPath(List<BStop> stops, List<BLineTable> lines) {
		Graph<String> graph = new Graph<String>();
		for(int i = 0; i <stops.size();i++) {
			graph.addNode(stops.get(i).toString());
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
								graph.addEdge(stops.get(k).toString(), stops.get(index).toString(), lines.get(i).getStops()[j+1].getTime());
							}
						}

					}
				}
			}
		}
		Dijkstra<String> dijk = new Dijkstra<String>(graph);
		this.dijk = dijk;
	}
	public void computePath(String from, String to) {
		dijk.computePath(from,to);
	}
	public Iterator<String> getPath(){
		return dijk.getPath();
	}
	public int getPathLength(){
		return dijk.getPathLength();

	}

}
