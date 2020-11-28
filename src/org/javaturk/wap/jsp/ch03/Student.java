/*
 * Student.java
 */

package org.javaturk.wap.jsp.ch03;


public class Student {
    private int no;
    private String firstName;
    private String lastName;
    private String department;
    
    public Student(){}
    
    public Student(int no, String firstName, String lastName, String department) {
        this.no = no;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }
    
    public String toString(){
        StringBuffer st = new StringBuffer("Student Information <br>");
        st.append("____________________________________<br>");
        st.append("No: " + no + "<br>");
        st.append("First Name: " + firstName + "<br>");
        st.append("Last Name: " + lastName + "<br>");
        st.append("Department: " + department + "<br>");
        return st.toString();
    }

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}    
	
	
}
