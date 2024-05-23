public class Worker extends Person implements WorkerInterface {
    protected int m_Salary = 4342;        // Field for salary for worker
    protected int m_Experience = 0;       // Experience in months

    // Constructors
    public Worker() {
        super();
    }

    public Worker(String _name, String _surname, int _age) {
        super(_name, _surname, _age);
    }

    // For salary
    public int getSalary() {
        return m_Salary;
    }

    public void setSalary(int salary) {
        m_Salary = salary;
    }

    // For experience
    public int getExperience() {
        return m_Experience;
    }

    public void setExperience(int experience) {
        m_Experience = experience;
    }

    @Override
    public String represent() {
        return String.format("""
                %s %s : %d years old.
                Work with us: %d month.
                Salary: %d zł.\s
               \s""", getName().toUpperCase(), getSurName().toUpperCase(),
                getAge(), this.m_Experience, this.m_Salary);
    }
}
