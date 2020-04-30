package code;

public class User1 {
    private String name;
    // 性别
    private String gender;
    // 地址
    private String address;
    // 年龄
    private String age;

    public User1() {
    }

    public User1(String name, String gender, String address, String age) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User1{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
