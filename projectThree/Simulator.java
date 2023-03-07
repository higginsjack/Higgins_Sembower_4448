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
        FNCD fncd = new FNCD();
        for (int day = 1; day <= numDays; ++day) {
            out(">>> Start Simulation Day "+day+" "+dayOfWeek);
            if (dayOfWeek == Enums.daysOfTheWeek.Sun) fncd.closedDay(dayOfWeek);  // no work on Sunday
            else fncd.normalDay(dayOfWeek);  // normal stuff on other days
            out(">>> End Simulation Day "+day+" "+dayOfWeek+"\n");
            dayOfWeek = getNextDay(dayOfWeek);  // increment to the next day
        }
    }
}
