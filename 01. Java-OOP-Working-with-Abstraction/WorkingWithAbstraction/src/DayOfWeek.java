public enum DayOfWeek {
    MONDAY (1,"ponedelnik"),
    TUESDAY (2,"vtornik"),
    WEDNESDAY (3,"srqda"),
    THURSDAY (4,"chetvurtuk"),
    FRIDAY (5,"petuk"),
    SATURDAY (6,"shestuk"),
    SUNDAY (7,"sedmak");
    private int dayNumber;
    private String dayName;

    DayOfWeek (int dayNumber,String dayName) {
        this.dayNumber = dayNumber;
        this.dayName = dayName;
    }

    public int getDayNumber () {
        return this.dayNumber;
    }

    public String getDayName () {
        return this.dayName;
    }
   // public void setDayNumber(int num){
   //     this.dayNumber=num;
   // }
}
