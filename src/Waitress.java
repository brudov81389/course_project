public class Waitress extends Worker implements WaitressInterface{
    private int tips;

    public Waitress() {
        super();
        this.tips = 0;
    }

    public Waitress(String _name, String _surname, int _age) {
        super(_name, _surname, _age);
        this.tips = 0;
    }
    // Getters and setters for tips field
    public int getSumTips()
    {
        return this.tips;
    }

    public void giveTips(int _tips)
    {
        this.tips += _tips;
    }

    public void cashOutTips()
    {
        System.out.println();
        System.out.printf("Amount of cash out tips: %d\n", this.tips);
        System.out.println();
        this.tips = 0;
    }

    @Override
    public void serveTable(int _numTable)
    {
        System.out.println();
        System.out.printf("Prepare table number %d...", _numTable);
        System.out.println();
    }

    @Override
    public void cleanUpTable(int _numTable)
    {
        System.out.println();
        System.out.printf("Clean up table number %d...", _numTable);
        System.out.println();
    }
}