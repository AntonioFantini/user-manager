package redhattest.antoniofantini.model;

import java.io.Serializable;
import java.util.Objects;

public class Name implements Serializable{
	private static final long serialVersionUID = -3252096881746074936L;
	private String title;
	private String first;
	private String last;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
        if (!(o instanceof Name)) {
            return false;
        }
        Name name = (Name) o;
        return this.title.equalsIgnoreCase(name.getTitle())
        		&& this.first.equalsIgnoreCase(name.getFirst())
        		&& this.last.equalsIgnoreCase(name.getLast());
        
	}
	@Override
	public int hashCode() {
		return Objects.hash(this.title, this.first, this.last);
	}
}
