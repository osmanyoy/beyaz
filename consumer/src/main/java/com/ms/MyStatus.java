package com.ms;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MyStatus {
	@Size(max = 20)
	@NotEmpty
	private String desc;
	@NotEmpty
	@Pattern(regexp = "[0-9]+")
	private String extra;
	private String mextra;
	@Max(1000)
	@Min(100)
	private int cause;

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getExtra() {
		return this.extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public String getMextra() {
		return this.mextra;
	}

	public void setMextra(String mextra) {
		this.mextra = mextra;
	}

	public int getCause() {
		return this.cause;
	}

	public void setCause(int cause) {
		this.cause = cause;
	}

	@Override
	public String toString() {
		return "MyStatus [desc=" + this.desc + ", extra=" + this.extra + ", mextra=" + this.mextra + ", cause="
		        + this.cause + "]";
	}

}
