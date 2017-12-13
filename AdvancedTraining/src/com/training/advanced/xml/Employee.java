package com.training.advanced.xml;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "Employee", propOrder = { "name",
                                          "surname",
                                          "coins",
                                          "date",
                                          "phone" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
	@XmlElement(name = "isim", nillable = true, namespace = "http://employee.adenon.com", defaultValue = "test")
	private String name;
	private String surname;
	private String phone;
	private Date date;
	// @XmlTransient
	private int coins;

	public Employee() {

	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(final String phone) {
		this.phone = phone;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}

	public int getCoins() {
		return this.coins;
	}

	public void setCoins(final int coins) {
		this.coins = coins;
	}

	public static EmployeeBuilder getBuilder() {
		return new EmployeeBuilder();
	}

	@Override
	public String toString() {
		return "Employee [name=" + this.name + ", surname=" + this.surname + ", phone=" + this.phone + ", date="
		        + this.date + ", coins=" + this.coins + "]";
	}

	public static class EmployeeBuilder {
		private String name;
		private String surname;
		private String phone;
		private Date date;
		private int coins;

		private EmployeeBuilder() {

		}

		public Employee build() {
			Employee employee = new Employee();
			employee.name = this.name;
			employee.surname = this.surname;
			employee.phone = this.phone;
			employee.date = this.date;
			employee.coins = this.coins;

			return employee;
		}

		public String getName() {
			return this.name;
		}

		public EmployeeBuilder setName(final String name) {
			this.name = name;
			return this;
		}

		public String getSurname() {
			return this.surname;
		}

		public EmployeeBuilder setSurname(final String surname) {
			this.surname = surname;
			return this;
		}

		public String getPhone() {
			return this.phone;
		}

		public EmployeeBuilder setPhone(final String phone) {
			this.phone = phone;
			return this;
		}

		public Date getDate() {
			return this.date;
		}

		public EmployeeBuilder setDate(final Date date) {
			this.date = date;
			return this;
		}

		public int getCoins() {
			return this.coins;
		}

		public EmployeeBuilder setCoins(final int coins) {
			this.coins = coins;
			return this;
		}

	}
}
