package redhattest.antoniofantini.model;

import java.io.Serializable;
import java.util.Objects;

public class Picture implements Serializable {
	private static final long serialVersionUID = -5817909007611875982L;
	private String large;
	private String medium;
	private String thumbnail;

	public String getLarge() {
		return large;
	}

	public void setLarge(String large) {
		this.large = large;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
        if (!(o instanceof Picture)) {
            return false;
        }
        Picture pic = (Picture) o;
        return this.large.equalsIgnoreCase(pic.getLarge())
        		&& this.medium.equalsIgnoreCase(pic.getMedium())
        		&& this.thumbnail.equalsIgnoreCase(pic.getThumbnail());
        
	}
	@Override
	public int hashCode() {
		return Objects.hash(this.large, this.medium, this.thumbnail);
	}

}
