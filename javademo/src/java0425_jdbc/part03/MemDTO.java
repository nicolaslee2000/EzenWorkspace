package java0425_jdbc.part03;

import lombok.Data;

@Data
public class MemDTO {
	private int num;
	private String name;
	private int age;
	private String loc;
<<<<<<< HEAD
	public MemDTO () {
		
	}
	
	public MemDTO(String name, int age, String loc) {
		super();
		this.name = name;
		this.age = age;
		this.loc = loc;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public String toString() {
		return "MemDTO [num=" + num + ", name=" + name + ", age=" + age + ", loc=" + loc + "]";
	}
=======
>>>>>>> a645db5f9da84ae5b56d6824431fadda48f5e28d
	
}
