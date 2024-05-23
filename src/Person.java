abstract public class Person {
    private String m_Name;         // Field for first name
    private String m_SurName;      // Field for second name
    private int m_Age;             // Field for age of worker

    // Constructor
    public Person() {
        this.m_Name = null;
        this.m_SurName = null;
        this.m_Age = 0;
    }

    public Person(String name, String surName, int age) {
        this.m_Name = name;
        this.m_SurName = surName;
        this.m_Age = age;
    }

    // Getter and setters
    // For name
    public String getName(){
        return m_Name;
    }

    public void setName(String name){
        m_Name = name;
    }

    // For surname
    public String getSurName(){
        return m_SurName;
    }

    public void setSurName(String surName){
        m_SurName = surName;
    }

    // For age
    public int getAge(){
        return m_Age;
    }

    public void setAge(int age){
        m_Age = age;
    }
}
