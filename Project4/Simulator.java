// Simulator to cycle for select number of days
public class Simulator implements SysOut {
    final int numDays;
    Enums.daysOfTheWeek dayOfWeek;
    Simulator() {
        numDays = 30;  // magic number for days to run here CHANGE
        dayOfWeek = Utility.randomEnum(Enums.daysOfTheWeek.class);  // we'll start on a random day (for fun)
    }

    // cycling endlessly through enum values
    // https://stackoverflow.com/questions/34159413/java-get-next-enum-value-or-start-from-first
    public Enums.daysOfTheWeek getNextDay(Enums.daysOfTheWeek e)
    {
        int index = e.ordinal();
        int nextIndex = index + 1;
        Enums.daysOfTheWeek[] days = Enums.daysOfTheWeek.values();
        nextIndex %= days.length;
        return days[nextIndex];
    }

    void run() {
        FNCD fncd = new FNCD("North");
        FNCD fncd2 = new FNCD("South");
        for (int day = 1; day <= numDays; ++day) {
            out(">>> Start Simulation Day "+day+" "+dayOfWeek);
            if (dayOfWeek == Enums.daysOfTheWeek.Sun || dayOfWeek == Enums.daysOfTheWeek.Wed){
                fncd.raceDay(dayOfWeek);
                fncd2.raceDay(dayOfWeek);
            }

            else {// normal stuff on other days
                fncd.opening(dayOfWeek);
                System.out.println();
                fncd2.opening(dayOfWeek);
                System.out.println();
                fncd.washing(dayOfWeek);
                System.out.println();
                fncd2.washing(dayOfWeek);
                System.out.println();
                fncd.repairing(dayOfWeek);
                System.out.println();
                fncd2.repairing(dayOfWeek);
                System.out.println();
                fncd.selling(dayOfWeek);
                System.out.println();
                fncd2.selling(dayOfWeek);
                System.out.println();
                fncd.ending(dayOfWeek);
                System.out.println();
                fncd2.ending(dayOfWeek);
                System.out.println();
            }
            out(">>> End Simulation Day "+day+" "+dayOfWeek+"\n");
            dayOfWeek = getNextDay(dayOfWeek);  // increment to the next day
        }
        Client c = new Client(fncd, fncd2);
        c.runSim();
    }
}
