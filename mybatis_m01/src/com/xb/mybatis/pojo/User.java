package com.xb.mybatis.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String username;// 用户姓名
	private String sex;// 性别
	//测试#{}和${}数据类型转化：
	// 字符串和整数貌似没什么区别，比如insert into ... '1';insert into ... 1这两个都可以插入成功
	private Date birthday;// 生日
	private String address;// 地址

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", sex='" + sex + '\'' +
				", birthday=" + birthday +
				", address='" + address + '\'' +
				'}';
	}
}
