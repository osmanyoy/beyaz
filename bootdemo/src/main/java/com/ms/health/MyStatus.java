package com.ms.health;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "MyStatus desc", value = "test mest")
public class MyStatus {
	@Size(max = 20)
	@NotEmpty
	@ApiModelProperty(required = false)
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

}
