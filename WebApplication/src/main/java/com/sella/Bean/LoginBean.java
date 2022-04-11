package com.sella.Bean;

public class LoginBean {
   
    private String username;
    private String password;
    private String fname;
    private String lname;
    private String mobileno;
    private String email;
    private String location;
    private String name;
    private long aadharno;
    private String address;
    private int rcapacity;
    private String hostelname;
    private String doj;
    
    public LoginBean(String name, String email, String address, String hostelname, int rcapacity, String doj) {
		super();
		this.name = name;
		this.email=email;
		this.address = address;
		this.rcapacity = rcapacity;
		this.hostelname = hostelname;
		this.doj = doj;
	}
    
     public LoginBean(String name, String address, String doj,int rcapacity)
      {
      this.name=name;
      this.address=address;
      this.doj=doj;
      this.rcapacity=rcapacity;
      
      
     }
     
     
      

	
	
    public LoginBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	public LoginBean(String hostelname) {
		super();
		this.hostelname = hostelname;
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
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public long getAadharno() {
		return aadharno;
	}


	public void setAadharno(long aadharno) {
		this.aadharno = aadharno;
	}


	public int getRcapacity() {
		return rcapacity;
	}


	public void setRcapacity(int rcapacity) {
		this.rcapacity = rcapacity;
	}

	public String getHostelname() {
		return hostelname;
	}

	public void setHostelname(String hostelname) {
		this.hostelname = hostelname;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

/*	public String getHostelName() {
		return hostelname;
	}

	public void setHostelName(String hostelName) {
		this.hostelname = hostelname;
	}*/
	
}