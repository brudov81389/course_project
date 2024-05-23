enum SECTION {
    COLD, HOT, PASTRY, SERVICE_AREA, SUPPORT
}

public class Cook extends Worker implements CookInterface {
    private SECTION section;

    // Constructors default and with values
    public Cook() {
        super();
        this.section = null;
    }

    public Cook(String _name, String _surname, int _age) {
        super(_name, _surname, _age);
        this.section = null;
    }

    // Getters and setters methods
    public SECTION getSection() {
        return this.section;
    }

    public void setSection(SECTION _section) {
        if (_section != null) {
            this.section = _section;
        }
    }

    // Override methods
    @Override
    public String represent()
    {
        String infoWorker = super.represent();
        return infoWorker + String.format("""
                Working place: %s""", this.section);
    }

    @Override
    public void prepareIngredients() {
        System.out.printf("%s section start to preparing ingredients...\n", section);
        for (int i = 3; i > 0; --i)
        {
            try {
                Thread.sleep(700);
            } catch (InterruptedException ie) {

                Thread.currentThread().interrupt();
            }
            System.out.printf("%d%n", i);
        }
        System.out.println("Finish preparing ingredients...");
        System.out.println();

    }

    @Override
    public void cookDishes(String dish)
    {
        System.out.printf("\nI`m staying on %s and cook %s", this.section, dish);
        System.out.println();
    }

    @Override
    public  void cleanUp()
    {
        System.out.printf("\nCleaning up my %s section...", this.section);
    }
}
