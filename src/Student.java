public class Student {
 

String first, last, major, NetID, gender;
Double GPA;
int UIN, age;
 

Student(String first, String last, String major, Double GPA, int UIN, String NetID, int age, String gender) {
this.first = first;
this.last = last;
this.major = major;
this.NetID = NetID;
this.GPA = GPA;
this.UIN = UIN;
this.age = age;
this.gender = gender;
}
 

public String getFirst() {
return first;
}
 

public void setFirst(String first) {
this.first = first;
}
 

public String getLast() {
return last;
}
 

public void setLast(String last) {
this.last = last;
}
 

public String getMajor() {
return major;
}
 

public void setMajor(String major) {
this.major = major;
}
 

public String getNetID() {
return NetID;
}
 

public void setNetID(String netID) {
NetID = netID;
}
 

public String getGender() {
return gender;
}
 

public void setGender(String gender) {
this.gender = gender;
}
 

public Double getGPA() {
return GPA;
}
 

public void setGPA(Double gPA) {
GPA = gPA;
}
 

public int getUIN() {
return UIN;
}
 

public void setUIN(int uIN) {
UIN = uIN;
}
 

public int getAge() {
return age;
}
 

public void setAge(int age) {
this.age = age;
}
 

public String toString() {
return first + " " + last + " | Major: " + major + " | GPA: " + GPA + " | UIN: " + UIN + " | Age: " + age + " | NetID: " + NetID + " | Gender: " + gender;
}
}