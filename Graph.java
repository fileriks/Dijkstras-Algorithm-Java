import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Generic Graphs class
 * Represents graphs with an adjacency list.
 * Maps Object E to an index
 * @author Filip Eriksson and Marcus Holmström
 * 
 */

public class Graph<E> {

	private Map<E,ArrayList<Edge<E>>> nodeMap;
	private ArrayList<Edge<E>> arrList;
	private ArrayList<E> nodez; 

	/**
	 * Constructor, creating a graphs object. Takes no parameters
	 */

	public Graph() {
		this.nodeMap = new HashMap<E,ArrayList<Edge<E>>>();
		this.nodez = new ArrayList<E>();
	}

	/**
	 * Adds node to the graph
	 */
	public void addNode(E node) {
		nodez.add(node);
		Edge<E> selfEdge = new Edge<E>(node, node, 0);
		this.arrList = new ArrayList<Edge<E>>();
		arrList.add(selfEdge);
		nodeMap.put(node, arrList);
	}

	/**
	 * Adds edge to the graph. If more than one edge between two nodes it only stores 
	 * the one with the lowest weight
	 */
	public void addEdge(E from, E to, int weight) {
		Edge<E> edge = new Edge<E>(from,to,weight);
		if(nodeMap.get(from).contains(edge)) {
			Edge<E> oldEdge = nodeMap.get(from).get(nodeMap.get(from).indexOf(edge));
			if(oldEdge.getWeight()>edge.getWeight()) {
				nodeMap.get(from).set(nodeMap.get(from).indexOf(edge), edge);
			}
		}
		else {
			nodeMap.get(from).add(edge);
		}
	}

	public ArrayList<E> getNodes() {
		return nodez;
	}
	public Map<E,ArrayList<Edge<E>>> getNodeMap () {
		return nodeMap;
	}
}