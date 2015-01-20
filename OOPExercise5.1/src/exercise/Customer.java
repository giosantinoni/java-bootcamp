package exercise;

public class Customer {
	private String name;
	private boolean member;
	private String memberType;
	
	public Customer(String name) {
		this.name = name;
		this.member = false;
		this.memberType = "Non Member";
	}
	
	public Customer(String name, String memberType) {
		this.name = name;
		this.member = true;
		this.memberType = memberType;
	}

	public boolean isMember() {
		return member;
	}

	public void setMember(boolean member) {
		this.member = member;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", member=" + member + ", memberType=" + memberType + "]";
	}
}
