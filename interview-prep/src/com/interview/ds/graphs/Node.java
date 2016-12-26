package com.interview.ds.graphs;

import java.util.ArrayList;
import java.util.List;

public class Node {

	public int id;
	public List<Node> neighBours = new ArrayList<Node>();
	public boolean visited;

	public Node(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((neighBours == null) ? 0 : neighBours.hashCode());
		result = prime * result + (visited ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (id != other.id)
			return false;
		if (neighBours == null) {
			if (other.neighBours != null)
				return false;
		} else if (!neighBours.equals(other.neighBours))
			return false;
		if (visited != other.visited)
			return false;
		return true;
	}

}
