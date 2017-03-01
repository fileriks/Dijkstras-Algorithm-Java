public class Edge<E> {

	/**
	 * Edge class
	 * Represents an edge betwen two nodes.
	 * @author Filip Eriksson and Marcus Holmström
	 * 
	 */

	private E source;
	private E dest;
	private int weight;

	/**
	 * Constructor taking index of source node and destination node and the weight as arguments 
	 */

	public Edge(E source, E dest, int weight) {
		this.source = source;
		this.dest = dest;
		this.weight = weight;
	}

	public E getSource() {
		return source;
	}
	public E getDestination() {
		return dest;
	}
	public int getWeight() {
		return weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dest == null) ? 0 : dest.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge<E> other = (Edge<E>) obj;
		if (dest == null) {
			if (other.dest != null)
				return false;
		} else if (!dest.equals(other.dest))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		return true;
	}
}
