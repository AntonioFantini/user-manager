package redhattest.antoniofantini.model;

import java.io.Serializable;

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

}
