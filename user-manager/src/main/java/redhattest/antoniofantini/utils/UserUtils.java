package redhattest.antoniofantini.utils;

import redhattest.antoniofantini.model.Location;
import redhattest.antoniofantini.model.Name;
import redhattest.antoniofantini.model.Picture;
import redhattest.antoniofantini.model.User;

public class UserUtils {

	public static User cloneUser(User usr) {
		User clone = new User();

		clone.setGender(usr.getGender());
		clone.setName(cloneName(usr.getName()));
		clone.setLocation(cloneLocation(usr.getLocation()));
		clone.setEmail(usr.getEmail());
		clone.setUsername(usr.getUsername());
		clone.setPassword(usr.getPassword());
		clone.setSalt(usr.getSalt());
		clone.setMd5(usr.getMd5());
		clone.setSha1(usr.getSha1());
		clone.setSha256(usr.getSha256());
		clone.setRegistered(usr.getRegistered());
		clone.setDob(usr.getDob());
		clone.setPhone(usr.getPhone());
		clone.setCell(usr.getCell());
		clone.setPps(usr.getPps());
		clone.setPicture(clonePicture(usr.getPicture()));
		return clone;
	}

	private static Name cloneName(Name name) {
		Name clone = new Name();
		clone.setTitle(name.getTitle());
		clone.setFirst(name.getFirst());
		clone.setLast(name.getLast());
		return clone;
	}

	private static Location cloneLocation(Location loc) {
		Location clone = new Location();
		clone.setStreet(loc.getStreet());
		clone.setCity(loc.getCity());
		clone.setState(loc.getState());
		clone.setZip(loc.getZip());
		return clone;
	}

	private static Picture clonePicture(Picture pic) {
		Picture clone = new Picture();
		clone.setLarge(pic.getLarge());
		clone.setMedium(pic.getMedium());
		clone.setThumbnail(pic.getThumbnail());
		return clone;

	}
}
