package redhattest.antoniofantini.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.codehaus.jackson.annotate.JsonProperty;

import redhattest.antoniofantini.utils.Utils;

public class User implements Serializable {
	private static final long serialVersionUID = 6007263432097924013L;

	private String gender;
	private Name name;
	private Location location;
	private String email;
	private String username;
	private String password;
	private String salt;
	private String md5;
	private String sha1;
	private String sha256;
	private Date registered;
	private Date dob;
	private String phone;
	private String cell;
	@JsonProperty(value = "PPS")
	private String pps;
	private Picture picture;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public String getSha1() {
		return sha1;
	}

	public void setSha1(String sha1) {
		this.sha1 = sha1;
	}

	public String getSha256() {
		return sha256;
	}

	public void setSha256(String sha256) {
		this.sha256 = sha256;
	}

	public Date getRegistered() {
		return registered;
	}

	public void setRegistered(Date registered) {
		this.registered = registered;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getPps() {
		return pps;
	}

	public void setPps(String pps) {
		this.pps = pps;
	}

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
        if (!(o instanceof User)) {
            return false;
        }
        User usr = (User) o;
        return this.gender.equalsIgnoreCase(usr.getGender())
        		&& this.name.equals(usr.getName())
        		&& this.location.equals(usr.getLocation())
        		&& this.email.equalsIgnoreCase(usr.getEmail())
        		&& this.username.equalsIgnoreCase(usr.getUsername())
        		&& this.password.equalsIgnoreCase(usr.getPassword())
        		&& this.salt.equalsIgnoreCase(usr.getSalt())
        		&& this.sha1.equalsIgnoreCase(usr.getSha1())
        		&& this.sha256.equalsIgnoreCase(usr.getSha256())
        		&& Utils.isSameDay(this.registered, usr.getRegistered())
        		&& Utils.isSameDay(this.dob, usr.getDob())
        		&& this.phone.equalsIgnoreCase(usr.getSalt())
        		&& this.cell.equalsIgnoreCase(usr.getCell())
        		&& this.pps.equalsIgnoreCase(usr.getPps())
        		&& this.picture.equals(usr.picture);
        
	}
	@Override
	public int hashCode() {
		return Objects.hash(this.name, 
							this.location, 
							this.email, 
							this.email,
							this.username,
			        		this.password,
			        		this.salt,
			        		this.sha1,
			        		this.sha256,
			        		this.registered,
			        		this.dob, 
			        		this.phone,
			        		this.cell,
			        		this.pps,
			        		this.picture);
	}
}
