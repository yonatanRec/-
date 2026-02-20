package Assignments.Assignment_14;
import Other.Date;
import Other.Helper.ArraysHelper;


public class Program {

    public static void main(String[] args) {
        Q11.Main(args);
    }

    public static class Q6{
        public static class Father
        {

            // טענת כניסה: אין צורך, כי אין פרמטרים
            // טענת יציאה: מופע Father נוצר עם fNum = 0
            public Father()
            {
                System.out.println("Father no num ctor");
            }

            // טענת כניסה: fNum יכול להיות כל מספר שלם
            // טענת יציאה: מופע Father נוצר עם fNum = הערך שהתקבל בפרמטר
            public Father(int fNum)
            {
                System.out.println("Father ctor num: " + fNum);
            }
        }

        public static class Son extends Father
        {
            private int sNum;

            // טענת כניסה: אין צורך, כי אין פרמטרים
            // טענת יציאה: מופע Son נוצר עם sNum = 0, f הוא Father עם fNum = 0
            public Son()
            {
                System.out.println("Son no num ctor");
                Father f = new Father(0);
                this.sNum = 0;
            }

            // טענת כניסה: sNum יכול להיות כל מספר שלם
            // טענת יציאה: מופע Son נוצר עם sNum = הערך שהתקבל בפרמטר, וה-Father העליון (super) נוצר עם fNum = sNum * 2
            public Son(int sNum)
            {
                super(sNum * 2);
                this.sNum = sNum;
                System.out.println("Son ctor num: " + sNum);
            }
        }

    }

    public static class Q7{
        static class MK {
            private String Fname;
            private String Lname;
            private String id;

            // כניסה: fname, lname, id אינם null
            // יציאה: נוצר אובייקט MK עם שם פרטי, שם משפחה ות"ז
            public MK(String fname, String lname, String id) {
                Fname = fname;
                Lname = lname;
                this.id = id;
            }

            // כניסה: האובייקט קיים
            // יציאה: מוחזר השם הפרטי
            public String getFname() {
                return Fname;
            }

            // כניסה: האובייקט קיים
            // יציאה: מוחזר שם המשפחה
            public String getLname() {
                return Lname;
            }

            // כניסה: האובייקט קיים
            // יציאה: מוחזרת תעודת הזהות
            public String getId() {
                return id;
            }

            // כניסה: fname אינו null
            // יציאה: השם הפרטי עודכן
            public void setFname(String fname) {
                Fname = fname;
            }

            // כניסה: lname אינו null
            // יציאה: שם המשפחה עודכן
            public void setLname(String lname) {
                Lname = lname;
            }

            // כניסה: id אינו null
            // יציאה: תעודת הזהות עודכנה
            public void setId(String id) {
                this.id = id;
            }
        }

        static class Party {
            private String name;
            private MK head;
            private MK[] members;

            // כניסה: name, head, members אינם null
            // יציאה: נוצר אובייקט מפלגה עם שם, יו"ר וחברים
            public Party(String name, MK head, MK[] members) {
                this.name = name;
                this.head = head;
                this.members = members;
            }

            // כניסה: האובייקט קיים
            // יציאה: מוחזר שם המפלגה
            public String getName() {
                return name;
            }

            // כניסה: name אינו null
            // יציאה: שם המפלגה עודכן
            public void setName(String name) {
                this.name = name;
            }

            // כניסה: האובייקט קיים
            // יציאה: מוחזר יו"ר המפלגה
            public MK getHead() {
                return head;
            }

            // כניסה: head אינו null
            // יציאה: יו"ר המפלגה עודכן
            public void setHead(MK head) {
                this.head = head;
            }

            // כניסה: האובייקט קיים
            // יציאה: מוחזרת רשימת החברים
            public MK[] getMembers() {
                return members;
            }

            // כניסה: members אינו null
            // יציאה: רשימת החברים עודכנה
            public void setMembers(MK[] members) {
                this.members = members;
            }
        }

        static class knesset {
            private int year;
            private Party[] parties;
            private MK head;

            // כניסה: year > 0, parties ו-head אינם null
            // יציאה: נוצר אובייקט כנסת
            public knesset(int year, Party[] parties, MK head) {
                this.year = year;
                this.parties = parties;
                this.head = head;
            }

            // כניסה: האובייקט קיים
            // יציאה: מוחזרת שנת הכנסת
            public int getYear() {
                return year;
            }

            // כניסה: year > 0
            // יציאה: שנת הכנסת עודכנה
            public void setYear(int year) {
                this.year = year;
            }

            // כניסה: האובייקט קיים
            // יציאה: מוחזרת רשימת המפלגות
            public Party[] getParties() {
                return parties;
            }

            // כניסה: parties אינו null
            // יציאה: רשימת המפלגות עודכנה
            public void setParties(Party[] parties) {
                this.parties = parties;
            }

            // כניסה: האובייקט קיים
            // יציאה: מוחזר יו"ר הכנסת
            public MK getHead() {
                return head;
            }

            // כניסה: head אינו null
            // יציאה: יו"ר הכנסת עודכן
            public void setHead(MK head) {
                this.head = head;
            }
        }

        static class leadParty {
            private int ministers;
            private int viceMinisters;
            private String[] roles;
            private Date startTerm;
            private Date endTerm;

            // כניסה: ministers, viceMinisters >= 0, שאר הפרמטרים אינם null
            // יציאה: נוצר אובייקט מפלגת שלטון
            public leadParty(int ministers, int viceMinisters, String[] roles, Date startTerm, Date endTerm) {
                this.ministers = ministers;
                this.viceMinisters = viceMinisters;
                this.roles = roles;
                this.startTerm = startTerm;
                this.endTerm = endTerm;
            }

            // כניסה: האובייקט קיים
            // יציאה: מוחזר מספר השרים
            public int getMinisters() {
                return ministers;
            }

            // כניסה: ministers >= 0
            // יציאה: מספר השרים עודכן
            public void setMinisters(int ministers) {
                this.ministers = ministers;
            }

            // כניסה: האובייקט קיים
            // יציאה: מוחזר מספר סגני השרים
            public int getViceMinisters() {
                return viceMinisters;
            }

            // כניסה: viceMinisters >= 0
            // יציאה: מספר סגני השרים עודכן
            public void setViceMinisters(int viceMinisters) {
                this.viceMinisters = viceMinisters;
            }

            // כניסה: האובייקט קיים
            // יציאה: מוחזרת רשימת התפקידים
            public String[] getRoles() {
                return roles;
            }

            // כניסה: roles אינו null
            // יציאה: רשימת התפקידים עודכנה
            public void setRoles(String[] roles) {
                this.roles = roles;
            }

            // כניסה: האובייקט קיים
            // יציאה: מוחזר תאריך תחילת הכהונה
            public Date getStartTerm() {
                return startTerm;
            }

            // כניסה: startTerm אינו null
            // יציאה: תאריך תחילת הכהונה עודכן
            public void setStartTerm(Date startTerm) {
                this.startTerm = startTerm;
            }

            // כניסה: האובייקט קיים
            // יציאה: מוחזר תאריך סיום הכהונה
            public Date getEndTerm() {
                return endTerm;
            }

            // כניסה: endTerm אינו null
            // יציאה: תאריך סיום הכהונה עודכן
            public void setEndTerm(Date endTerm) {
                this.endTerm = endTerm;
            }
        }

        static class OppParty {
            private String name;
            private MK head;
            private String[] roles;

            // כניסה: name, head, roles אינם null
            // יציאה: נוצר אובייקט מפלגת אופוזיציה
            public OppParty(String name, MK head, String[] roles) {
                this.name = name;
                this.head = head;
                this.roles = roles;
            }

            // כניסה: האובייקט קיים
            // יציאה: מוחזר שם המפלגה
            public String getName() {
                return name;
            }

            // כניסה: name אינו null
            // יציאה: שם המפלגה עודכן
            public void setName(String name) {
                this.name = name;
            }

            // כניסה: האובייקט קיים
            // יציאה: מוחזר ראש האופוזיציה
            public MK getHead() {
                return head;
            }

            // כניסה: head אינו null
            // יציאה: ראש האופוזיציה עודכן
            public void setHead(MK head) {
                this.head = head;
            }

            // כניסה: האובייקט קיים
            // יציאה: מוחזרת רשימת התפקידים
            public String[] getRoles() {
                return roles;
            }

            // כניסה: roles אינו null
            // יציאה: רשימת התפקידים עודכנה
            public void setRoles(String[] roles) {
                this.roles = roles;
            }
        }

    }

    public static class Q8{

        public static class Animal
        {// Data members
            private String name;
            private int legs;
            private String food;

            //Constructor
            public Animal(String n, int l, String f) {
                this.name = n;
                this.legs = l;
                this.food = f;
            }

            public void setFood(String food) {
                this.food = food;
            }

            public void setName(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return "Name: " + name + ", Legs: " + legs + ", Food: " + food;
            }
        }

        public static class Mammal extends Animal
        {//Data members
            private String cover; //fur, hair
            private String environment; //land, sea

            //constructor
            public Mammal(String n, int l, String f, String c, String en)
            {
                super(n, l, f);
                this.cover = c;
                this.environment = en;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            @Override
            public String toString() {
                return super.toString() + ", Cover: " + cover + ", Environment: " + environment;
            }
        }

        public static class Fish extends Animal
        {//Data members
            private boolean scale; //קשקשים
            private boolean saltyWater;

            //constructor
            public Fish(String n, int l, String f, boolean scale, boolean saltyWater)
            {
                super(n, l, f);
                this.scale = scale;
                this.saltyWater = saltyWater;
            }

            @Override
            public String toString() {
                return super.toString() + ", Scale: " + scale + ", SaltyWater: " + saltyWater;
            }
        }

        public static class Zoo
        {
            private int numOfMammal; //Actual num of mammals in array
            private int numOfFish; //Actual num of fish in array
            private Mammal[] mammals = new Mammal[100];
            private Fish[] fishes =  new Fish[200];

            //constructor
            public Zoo(){
                numOfFish = 0;
                numOfMammal = 0;
            }

            // טענת כניסה:
            // המערכים mammals ו־fishes מאותחלים (לא null)
            // numOfMammal ו־numOfFish מציינים את מספר האיברים התקפים במערכים
            // לכל אובייקט במערכים קיימת פעולה toString תקינה

            // טענת יציאה:
            // כל היונקים במערך mammals וכל הדגים במערך fishes הודפסו למסך לפי הסדר
            // מצב האובייקט והמערכים לא השתנה
            public void print() {
                for (int i = 0; i < numOfMammal; i++) {
                    System.out.println(mammals[i].toString());
                }
                for (int i = 0; i < numOfFish; i++) {
                    System.out.println(fishes[i].toString());
                }
            }


            public void addMammal(Mammal mammal)
            {
                numOfMammal++;
                mammals[numOfMammal] = mammal;
            }
            public void addFish(Fish fish)
            {
                numOfFish++;
                fishes[numOfFish] = fish;
            }
            public void deleteMammal()
            {
                numOfMammal--;
                mammals[numOfMammal] = null;
            }

            public int countMammal()
            {
                return numOfMammal;
            }
            public int countFish()
            {
                return numOfFish;
            }
        }

    }

    public static class Q9{

        public static void MainTax(String[] args) {
            Apartment a1 = new Apartment(80,2,300);
            Apartment a2 = new Apartment(100,3,300);
            Apartment a3 = new Apartment(120,4,300);
            Penthouse p = new Penthouse(170,4,300,100);
            PrivateHome ph = new PrivateHome(220,5,100);

            System.out.println("total cost: " + (a1.price()+a2.price()+a3.price()+p.price()+ph.price()));
        }

        public static class Apartment{
            protected double area;
            protected int people;
            protected double commonArea;

            public Apartment(double area, int people, double commonArea) {
                this.area = area;
                this.people = people;
                this.commonArea = commonArea;
            }

            public double getArea() {
                return area;
            }

            public void setArea(double area) {
                this.area = area;
            }

            public int getPeople() {
                return people;
            }

            public void setPeople(int people) {
                this.people = people;
            }

            public double getCommonArea() {
                return commonArea;
            }

            public void setCommonArea(double commonArea) {
                this.commonArea = commonArea;
            }

            @Override
            public String toString() {
                return "Area: " + area + ", CommonArea: " + commonArea +  ", People: " + people;
            }

            public double price(){
                return area + commonArea/people;
            }
        }

        public static class Penthouse extends Apartment{

            protected double roofArea;

            public Penthouse(double area, int people,  double commonArea, double roofArea) {
                super(area, people, commonArea);
                this.roofArea = roofArea;
            }

            public double getRoofArea() {
                return roofArea;
            }

            public void setRoofArea(double roofArea) {
                this.roofArea = roofArea;
            }

            @Override
            public String toString() {
                return super.toString() + ", RoofArea: " + roofArea;
            }

            public double price(){
                return super.price() + 0.3*roofArea;
            }
        }

        public static class  PrivateHome{
            protected int area;
            protected int people;
            protected int gardenArea;

            public PrivateHome(int area, int people, int gardenArea) {
                this.area = area;
                this.people = people;
                this.gardenArea = gardenArea;
            }

            public int getArea() {
                return area;
            }

            public void setArea(int area) {
                this.area = area;
            }

            public int getPeople() {
                return people;
            }

            public void setPeople(int people) {
                this.people = people;
            }

            public int getGardenArea() {
                return gardenArea;
            }

            public void setGardenArea(int gardenArea) {
                this.gardenArea = gardenArea;
            }

            @Override
            public String toString() {
                return "Area:  " + area + ", People: " + people + ", GardenArea: " + gardenArea;
            }

            public double price(){
                double base = area + 0.6*gardenArea;
                if(area < 200)
                    return base;
                return 1.5*base;
            }
        }
    }

    public static class Q10{
        public static class FairyTale{
            protected String name;
            protected boolean gender;
            protected String nickName;
            public FairyTale(String name, boolean gender, String nickName) {
                this.name = name;
                this.gender = gender;
                this.nickName = nickName;
            }
            public String getName() {
                return name;
            }
            public void setName(String name) {
                this.name = name;
            }
            public boolean isGender() {
                return gender;
            }
            public void setGender(boolean gender) {
                this.gender = gender;
            }
            public String getNickName() {
                return nickName;
            }
            public void setNickName(String nickName) {
                this.nickName = nickName;
            }
            @Override
            public String toString() {
                return "Name: " + name + ", Gender: " + gender + ", NickName: " + nickName;
            }
            public String printMe(){
                return "FairyTale " + nickName;
            }

            public String bottom(){
                return "Archmage";
            }
        }
        public static class Gnome extends FairyTale{
            protected double height;
            protected String color;
            public Gnome(String name, boolean gender, String nickName, double height, String color) {
                super(name, gender, nickName);
                this.height = height;
                this.color = color;
            }
            public double getHeight() {
                return height;
            }
            public void setHeight(double height) {
                this.height = height;
            }
            public String getColor() {
                return color;
            }
            public void setColor(String color) {
                this.color = color;
            }
            @Override
            public String toString() {
                return super.toString() + "Height: " + height + ", Color: " + color;
            }
            @Override
            public String printMe(){
                return "Gnome " + nickName;
            }
            @Override
            public String bottom(){
                return "Gnome";
            }
        }
        public static class Mage extends FairyTale{
            protected int rank;
            protected boolean good;
            public Mage(String name, boolean gender, String nickName, int rank, boolean good) {
                super(name, gender, nickName);
                this.rank = rank;
                this.good = good;
            }
            public int getRank() {
                return rank;
            }
            public void setRank(int rank) {
                this.rank = rank;
            }
            public boolean isGood() {
                return good;
            }
            public void setGood(boolean good) {
                this.good = good;
            }
            @Override
            public String toString() {
                return super.toString() + "Rank: " + rank + ", Good: " + good;
            }
            @Override
            public String printMe(){
                return "Mage " + nickName;
            }
            @Override
            public String bottom(){
                return "ArchMage";
            }
        }
        public static class ArchMage extends Mage{
            protected FairyTale[] characters = new FairyTale[10];
            protected int currentHelpers;
            public ArchMage(String name, boolean gender, String nickName, int rank, boolean good) {
                super(name, gender, nickName, rank, good);
            }
            public FairyTale[] getCharacters() {
                return characters;
            }
            public void setCharacters(FairyTale[] characters) {
                this.characters = characters;
            }
            public int getCurrentHelpers() {
                return currentHelpers;
            }
            public void setCurrentHelpers(int currentHelpers) {
                this.currentHelpers = currentHelpers;
            }
            @Override
            public String toString() {
                return super.toString() + "Characters: " + ArraysHelper.arrString(characters);
            }
            @Override
            public String printMe(){
                StringBuilder sb = new StringBuilder();
                sb.append("ArchMage ");
                sb.append(nickName);
                sb.append(" Helpers: {");
                for (int i = 0; i < currentHelpers; i++) {
                    sb.append(i > 0 ? ", " : "");
                    sb.append(characters[i].nickName);
                }
                sb.append("}");
                return sb.toString();
            }
            @Override
            public String bottom(){
                return super.bottom();
            }
        }
        public static class Fairy{
            protected String color;
            protected double speed;
            protected boolean activeTime;
            public Fairy(String color, double speed, boolean activeTime) {
                this.color = color;
                this.speed = speed;
                this.activeTime = activeTime;
            }
            public String getColor() {
                return color;
            }
            public void setColor(String color) {
                this.color = color;
            }
            public double getSpeed() {
                return speed;
            }
            public void setSpeed(double speed) {
                this.speed = speed;
            }
            public boolean isActiveTime() {
                return activeTime;
            }
            public void setActiveTime(boolean activeTime) {
                this.activeTime = activeTime;
            }
            @Override
            public String toString() {
                return "Speed: " + speed + ", activeTime: " + activeTime;
            }

            public String bottom(){
                return "ToothFairy";
            }
        }
        public static class ToothFairy extends Fairy{
            protected int teethCollected;
            protected String continent;
            public ToothFairy(String color, double speed, boolean activeTime, int teethCollected, String continent) {
                super(color, speed, activeTime);
                this.teethCollected = teethCollected;
                this.continent = continent;
            }
            public int getTeethCollected() {
                return teethCollected;
            }
            public void setTeethCollected(int teethCollected) {
                this.teethCollected = teethCollected;
            }
            public String getContinent() {
                return continent;
            }
            public void setContinent(String continent) {
                this.continent = continent;
            }
            @Override
            public String toString() {
                return super.toString() + "Teeth: " + teethCollected + ", continent: " + continent;
            }

            @Override
            public String bottom(){
                return super.bottom();
            }
        }
    }

    public static class Q11{

        public static void Main(String[] args) {
            Ticket t1 = new Ticket(true, "מופע 1");
            Ticket t2 = new Ticket(true, "מופע 1");

            ETicket t3 = new ETicket("mabat@mabatl.co.il");
            t3.setShowName("מופע 2");
            t3.setDoubleTicket(true);
            ETicket t4 = new ETicket("mabat@mabatl.co.il");
            t4.setShowName("מופע 2");
            t4.setDoubleTicket(true);

            Ticket t5 = new Ticket(false, "מופע 4");
            Ticket t6 = new Ticket(false, "מופע 4");

            ETicket t7 = new ETicket("mabat@mabatl.co.il");
            t7.setDoubleTicket(false);
            t7.setShowName("מופע 4");
            ETicket t8 = new ETicket("mabat@mabatl.co.il");
            t8.setDoubleTicket(false);
            t8.setShowName("מופע 4");

            Reservation r = new Reservation("דן חסכן", 150);
            r.addTicket(t1);
            r.addTicket(t2);
            r.addTicket(t3);
            r.addTicket(t4);
            r.addTicket(t5);
            r.addTicket(t6);
            r.addTicket(t7);
            r.addTicket(t8);

            System.out.println("סך ההזמנה: " + r.discountedPrice() + "₪");
            double discount = r.price() - r.discountedPrice();
            discount = Math.round(discount * 1000.0) / 1000.0; //בלי זה זה היה מדפי 58.275.0000000009
            System.out.println("ההנחה שנתנה: " + discount + "₪");
        }

        public static class Ticket{
            protected boolean isDoubleTicket;
            protected String showName;
            protected Date showDate;

            public Ticket(boolean isDoubleTicket, String showName) {
                this.isDoubleTicket = isDoubleTicket;
                this.showName = showName;
            }

            public String getShowName() {
                return showName;
            }

            public boolean isDoubleTicket() {
                return isDoubleTicket;
            }

            public Ticket() {}

            public void setDoubleTicket(boolean doubleTicket) {
                isDoubleTicket = doubleTicket;
            }

            public void setShowName(String showName) {
                this.showName = showName;
            }

            public Date getShowDate() {
                return showDate;
            }

            public void setShowDate(Date showDate) {
                this.showDate = showDate;
            }
        }

        public static class ETicket extends Ticket{
            protected String emailAddress;
            protected boolean isEmailConfirmed;

            public ETicket(String emailAddress){
                super();
                this.emailAddress = emailAddress;
            }

            public ETicket(boolean isDoubleTicket, String showName) {
                super(isDoubleTicket, showName);
            }

            public String getEmailAddress() {
                return emailAddress;
            }

            public boolean isEmailConfirmed() {
                return isEmailConfirmed;
            }


        }

        public static class Reservation {
            protected String customer;
            protected int baseCost;
            protected Ticket[] tickets = new Ticket[20];
            protected int currentTickets;

            public Reservation(String customer, int baseCost) {
                this.customer = customer;
                this.baseCost = baseCost;
            }

            public void addTicket(Ticket ticket){
                tickets[currentTickets] = ticket;
                currentTickets++;
            }

            public double discountedPrice() {
                if (currentTickets <= 0) {
                    return 0;
                }
                double total = baseCost;
                if (tickets[0].isDoubleTicket) {
                    total *= 0.99;
                }
                for (int i = 1; i < currentTickets; i++) {
                    double ticketPrice = baseCost;
                    if (tickets[i].isDoubleTicket) {
                        ticketPrice *= 0.99;
                    }
                    total += ticketPrice * 0.95;
                }
                return total;
            }

            public double price() {
                return baseCost * currentTickets;
            }

            public boolean collidingDates(){
                for (int i = 0; i < currentTickets; i++) {
                    Date date = tickets[i].showDate;
                    for (int j = 0; j < currentTickets; j++) {
                        if (i != j)
                            if (date.equals(tickets[j].showDate))
                                return false;
                    }
                }
                return true;
            }

        }
    }
}
