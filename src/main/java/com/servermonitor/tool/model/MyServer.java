package com.servermonitor.tool.model;

import java.io.Serializable;

public class MyServer implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long serverid;
	private String serverurl;
	private String servername;
	private String serverauthority;
	private String serverprotocol;
	private int serverportnumber;
	private boolean serverportislistening;
	private String serverurlsearchtext;

	public MyServer(Long serverid, String serverurl, String servername, String serverauthority, String serverprotocol,
			int serverportnumber, boolean serverportislistening, String serverurlsearchtext) {
		super();
		this.serverid = serverid;
		this.serverurl = serverurl;
		this.servername = servername;
		this.serverauthority = serverauthority;
		this.serverprotocol = serverprotocol;
		this.serverportnumber = serverportnumber;
		this.serverportislistening = serverportislistening;
		this.serverurlsearchtext = serverurlsearchtext;
	}

	public MyServer() {
		super();
	}

	public Long getServerid() {
		return serverid;
	}

	public void setServerid(Long serverid) {
		this.serverid = serverid;
	}

	public String getServerurl() {
		return serverurl;
	}

	public void setServerurl(String serverurl) {
		this.serverurl = serverurl;
	}

	public String getServername() {
		return servername;
	}

	public void setServername(String servername) {
		this.servername = servername;
	}

	public String getServerauthority() {
		return serverauthority;
	}

	public void setServerauthority(String serverauthority) {
		this.serverauthority = serverauthority;
	}

	public String getServerprotocol() {
		return serverprotocol;
	}

	public void setServerprotocol(String serverprotocol) {
		this.serverprotocol = serverprotocol;
	}

	public int getServerportnumber() {
		return serverportnumber;
	}

	public void setServerportnumber(int serverportnumber) {
		this.serverportnumber = serverportnumber;
	}

	public boolean isServerportislistening() {
		return serverportislistening;
	}

	public void setServerportislistening(boolean serverportislistening) {
		this.serverportislistening = serverportislistening;
	}

	public String getServerurlsearchtext() {
		return serverurlsearchtext;
	}

	public void setServerurlsearchtext(String serverurlsearchtext) {
		this.serverurlsearchtext = serverurlsearchtext;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((serverauthority == null) ? 0 : serverauthority.hashCode());
		result = prime * result + ((serverid == null) ? 0 : serverid.hashCode());
		result = prime * result + ((servername == null) ? 0 : servername.hashCode());
		result = prime * result + (serverportislistening ? 1231 : 1237);
		result = prime * result + serverportnumber;
		result = prime * result + ((serverprotocol == null) ? 0 : serverprotocol.hashCode());
		result = prime * result + ((serverurl == null) ? 0 : serverurl.hashCode());
		result = prime * result + ((serverurlsearchtext == null) ? 0 : serverurlsearchtext.hashCode());
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
		MyServer other = (MyServer) obj;
		if (serverauthority == null) {
			if (other.serverauthority != null)
				return false;
		} else if (!serverauthority.equals(other.serverauthority))
			return false;
		if (serverid == null) {
			if (other.serverid != null)
				return false;
		} else if (!serverid.equals(other.serverid))
			return false;
		if (servername == null) {
			if (other.servername != null)
				return false;
		} else if (!servername.equals(other.servername))
			return false;
		if (serverportislistening != other.serverportislistening)
			return false;
		if (serverportnumber != other.serverportnumber)
			return false;
		if (serverprotocol == null) {
			if (other.serverprotocol != null)
				return false;
		} else if (!serverprotocol.equals(other.serverprotocol))
			return false;
		if (serverurl == null) {
			if (other.serverurl != null)
				return false;
		} else if (!serverurl.equals(other.serverurl))
			return false;
		if (serverurlsearchtext == null) {
			if (other.serverurlsearchtext != null)
				return false;
		} else if (!serverurlsearchtext.equals(other.serverurlsearchtext))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MyServer [serverid=" + serverid + ", serverurl=" + serverurl + ", servername=" + servername
				+ ", serverauthority=" + serverauthority + ", serverprotocol=" + serverprotocol + ", serverportnumber="
				+ serverportnumber + ", serverportislistening=" + serverportislistening + ", serverurlsearchtext="
				+ serverurlsearchtext + "]";
	}

}
