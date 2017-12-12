package com.training.advanced.annotations;

@PropertyFile("my.properties")
public class MyPropObj {
	@Property(key = "my.port")
	private int port;
	@Property(key = "my.ipadres")
	private String ip;
	@Property(key = "my.timeout")
	private long time;
	@Property(key = "my.bol")
	private double divider;

	public int getPort() {
		return this.port;
	}

	public void setPort(final int port) {
		this.port = port;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(final String ip) {
		this.ip = ip;
	}

	public long getTime() {
		return this.time;
	}

	public void setTime(final long time) {
		this.time = time;
	}

	public double getDivider() {
		return this.divider;
	}

	public void setDivider(final double divider) {
		this.divider = divider;
	}

	@Override
	public String toString() {
		return "MyPropObj [port=" + this.port + ", ip=" + this.ip + ", time=" + this.time + ", divider=" + this.divider
		        + "]";
	}

}
