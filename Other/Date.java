package Other;

public class Date {
    protected int year;
    protected int month;
    protected int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Date(Date d) {
        this.year = d.year;
        this.month = d.month;
        this.day = d.day;
    }

    public Date(){}

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return year + "/" + month + "/" + day;
    }

    public boolean after(Date d) {
        return this.year > d.year ||
                (this.year == d.year && this.month > d.month) ||
                (this.year == d.year && this.month == d.month && this.day > d.day);
    }

    public boolean before(Date d){
        return this.year < d.year ||
                (this.year == d.year && this.month < d.month) ||
                (this.year ==  d.year && this.month == d.month && this.day < d.day);
    }

    public boolean equals(Date d) {
        return year == d.year && month == d.month && day == d.day;
    }

}
