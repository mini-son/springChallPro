package com.mycom.chall.domain;

//로그인한 user의 정보를 관리용도의 클래스이다.
public class User {

	private String  id; //회원id
	private String  mem_name; //회원명
	private String  nickname; //회원별칭
	
	public User() {
	}

	public User(String id, String mem_name, String nickname) {
		this.id = id;
		this.mem_name = mem_name;
		this.nickname = nickname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", mem_name=" + mem_name + ", nickname=" + nickname;
	}
	
	
	
}
