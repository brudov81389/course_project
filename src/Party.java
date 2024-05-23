import java.util.ArrayList;
import java.util.Random;

public class Party {
    private final Log log;
    protected ArrayList<Cook> cookTeam;
    protected ArrayList<Waitress> diningTeam;

    Party(Log _log) {
        log = _log;
        log.write(LOG_CODE.INFO, "Restaurant is getting ready for work...");
    }

    public void startParty() {
        // Create a kitchen team
        cookTeam = kitchenTeam();
        // Create a dining team
        diningTeam = diningTeamWork();
        log.write(LOG_CODE.INFO, "The kitchen is getting ready for the event");
        for (Cook cook : cookTeam) {
            cook.prepareIngredients();
        }
        log.write(LOG_CODE.INFO, "The kitchen serves dishes on plates");
        for (Cook cook : cookTeam) {
            cook.cookDishes("for birthday party");
        }

        Random rand = new Random();
        for (Waitress waitress : diningTeam) {
            int nrTable = rand.nextInt(10);
            waitress.serveTable(nrTable);
            log.write(LOG_CODE.INFO, String.format("The waitress serves dishes to table number %d", nrTable));

            int tipsAmount = rand.nextInt(20);
            waitress.giveTips(tipsAmount);
            log.write(LOG_CODE.INFO, String.format("The waitress receives a %d PLN tip", tipsAmount));
        }
    }

    public void finishParty() {
        log.write(LOG_CODE.INFO, "The cooks are cleaning the kitchen");
        for (Cook cook : cookTeam) {
            System.out.printf("Cook %s: ", cook.getName());
            cook.cleanUp();
        }

        Random rand = new Random();
        log.write(LOG_CODE.INFO, "The waitress are cleaning tables");
        for (Waitress waitress : diningTeam) {
            System.out.printf("Waitress %s : ", waitress.getName());
            waitress.cleanUpTable(rand.nextInt(10));
        }
    }

    public void calculateTips() {
        for (Waitress waitress : diningTeam) {
            waitress.represent();
            log.write(LOG_CODE.INFO, String.format("Waiter Andrzej received a total of %d PLN in tips.", waitress.getSumTips()));
            waitress.cashOutTips();
        }
    }

    public ArrayList<Cook> kitchenTeam() {
        log.write(LOG_CODE.INFO, "Start to creating a kitchen team");
        ArrayList<Cook> kitchenTeam = new ArrayList<>();
        // Create and give params for cook nr.1
        Cook worker1 = new Cook("Sonia", "Brown", 25);
        worker1.setSalary(6000);
        worker1.setSection(SECTION.HOT);
        worker1.setExperience(10);
        // Add to kitchen team
        kitchenTeam.add(worker1);

        // Create and give params for cook nr.2
        Cook worker2 = new Cook("Andrzej", "Hoffman", 21);
        worker2.setSection(SECTION.SUPPORT);
        worker2.setExperience(1);
        // Add kitchen team
        kitchenTeam.add(worker2);

        // Create and give params for cook nr.2
        Cook worker3 = new Cook("Wiktor", "Kowalczyk", 34);
        worker3.setSalary(7500);
        worker3.setSection(SECTION.SERVICE_AREA);
        worker3.setExperience(8);
        // Add kitchen team
        kitchenTeam.add(worker3);
        log.write(LOG_CODE.INFO, "The end of forming the kitchen team");
        return kitchenTeam;
    }

    public ArrayList<Waitress> diningTeamWork() {
        log.write(LOG_CODE.INFO, "Start to creating a dining team");
        ArrayList<Waitress> diningTeam = new ArrayList<>();
        // Create and give params for cook nr.1
        Waitress worker1 = new Waitress("Piotr", "Rudy", 32);
        worker1.setSalary(5000);
        worker1.setExperience(7);
        // Add to kitchen team
        diningTeam.add(worker1);
        // Create and give params for cook nr.2
        Waitress worker2 = new Waitress("Marek", "Sikora", 40);
        worker2.setExperience(1);
        // Add kitchen team
        diningTeam.add(worker2);

        // Create and give params for cook nr.2
        Waitress worker3 = new Waitress("Marzena", "Sapolska", 27);
        worker3.setSalary(7500);
        worker3.setExperience(8);
        // Add kitchen team
        diningTeam.add(worker3);
        log.write(LOG_CODE.INFO, "The end of forming the kitchen team");
        return diningTeam;
    }
}
