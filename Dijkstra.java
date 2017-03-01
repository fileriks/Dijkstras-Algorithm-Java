
import java.util.*;

import Lab3Help.Path;

/**
 * Dijkstra class
 * Performs Dijkstras algorithm for finding shortest path from the starting node to another node
 * @author Filip Eriksson and Marcus Holmström
 * 
 */

public class Dijkstra<E> implements Path<E> {
	private int pathLength;
	private Graph<E> graph;
	private ArrayList<E> path;

	/**
	 * Constructor taking a graph and a comparator as argument
	 * Creates a Dijkstra object
	 * Comparator is used to compare the arraylists in the priorityqueue by shortest distance.
	 * @param graph
	 */

	public Dijkstra(Graph<E> graph) {
		this.graph = graph;
	}

	/**
	 * Implemention of Dijkstras algorithm
	 * Computes all paths from the starting node to another node using Dijkstras algorithm
	 */

	public void computePath(E from, E to) {
		E startingNode = from;
		E endNode =  to;
		Set<E> visited = new HashSet<E>();
		Map<E,Integer>distance = new HashMap<E,Integer>();
		Comparator<E> cmp = new Comparator <E>(){

			@Override
			public int compare(E a, E b) {
				int avalue, bvalue;
				avalue = distance.get(a);
				bvalue = distance.get(b);

				if(avalue > bvalue) {
					return 1;
				}
				else if(avalue == bvalue) {
					return 0;
				}
				else {
					return -1;
				}
			}
		};
		Map<E,E> predecessor = new HashMap<E,E>();
		distance.put(startingNode, 0);
		for(E node:graph.getNodes()) {
			if(!startingNode.equals(node)) {
				distance.put(node, Integer.MAX_VALUE);
			}
		}

		PriorityQueue<E> Q = new PriorityQueue<E>(graph.getNodeMap().size(),cmp);
		Q.add(startingNode);
		while (!Q.isEmpty()) {
			E u;
			u = Q.poll();
			if(visited.contains(u)) {
				continue; 
			}
			else {
				visited.add(u);
				for(Edge<E> neighbour : graph.getNodeMap().get(u)) {
					if(!visited.contains(neighbour.getDestination())) {
						int alt;
						alt = distance.get(u)+neighbour.getWeight();
						if(alt < distance.get(neighbour.getDestination())) {
							distance.put(neighbour.getDestination(),alt);
							predecessor.put(neighbour.getDestination(),u);
							E noden = neighbour.getDestination();
							Q.add(noden);
						}
					}
				}
			}
		}
		this.pathLength = distance.get(endNode);
		this.path = new ArrayList<E>();
		E tmp = endNode;
		path.add(tmp);
		while (!tmp.equals(startingNode)) {
			tmp = predecessor.get(tmp);
			path.add(0,tmp);
		}
	}
	/**
	 * Returns the path from the start node to the end node in an iterator.
	 */

	public Iterator<E> getPath() {
		return path.iterator();
	}
	/**
	 * returns distance to the end node
	 */
	public int getPathLength() {
		return pathLength;	
	}

}

