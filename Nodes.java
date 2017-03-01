
public class Nodes {
	private String name;
	private int index;
	public Nodes(String name, int index) {
		this.name = name;
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public int getIndex() {
		return index; 
	}
	@Override
	public String toString () {
		return name;
	}
	@Override
    public boolean equals(Object obj) {
            if (this == obj)
                    return true;
            if (obj == null)
                    return false;
            if (getClass() != obj.getClass())
                    return false;
            Nodes other = (Nodes) obj;
            if (!(index==other.index))
                    return false;
            else{return true;}
	}
}
