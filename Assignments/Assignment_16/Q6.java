package Assignments.Assignment_16;

public class Q6 {

    public static void main(String[] args) {

        Worker w1 = new Worker("1", "1", "1", "1", "1", "1", 34, 170);
        Worker w2 = new Worker("2", "2", "2", "2", "2", "2", 34, 170);

        Salesman s1 = new Salesman("3", "3", "3", "3", "3", "3", 100000);
        Salesman s2 = new Salesman("4", "4", "4", "4", "4", "4", 120000);

        Manager m1 = new Manager("5", "5", "5", "5", "5", "5", 30000);

        SeniorManager sm1 = new SeniorManager("6", "6", "6", "6", "6", "6", 40000, 600);

        System.out.println("w1 pay: " + w1.calcSalary());
        System.out.println("w2 pay: " + w2.calcSalary());
        System.out.println("s1 pay: " + s1.calcSalary());
        System.out.println("s2 pay: " + s2.calcSalary());
        System.out.println("m1 pay: " + m1.calcSalary());
        System.out.println("sm1 pay: " + sm1.calcSalary());

        int sales = s1.getTotalSales() + s2.getTotalSales();

        System.out.println("total sales: " + sales);

        double pay = w1.calcSalary() + w2.calcSalary() + s1.calcSalary() + s2.calcSalary() + m1.calcSalary() + sm1.calcSalary();

        System.out.println("total pay: " + pay);

        System.out.println("made a profit: " + (sales > pay));
    }

    public static class Person{
        protected String id;
        protected String fname;
        protected String lname;
        protected String address;

        public Person(String id, String fname, String lname, String address) {
            this.id = id;
            this.fname = fname;
            this.lname = lname;
            this.address = address;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getLname() {
            return lname;
        }

        public void setLname(String lname) {
            this.lname = lname;
        }

        public String getFname() {
            return fname;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id='" + id + '\'' +
                    ", fname='" + fname + '\'' +
                    ", lname='" + lname + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }

        public double calcSalary(){return 5300;}
    }

    public static class Employee extends Person {
        protected String workId;
        protected String branch;

        public Employee(String id, String fname, String lname, String address, String workId, String branch) {
            super(id, fname, lname, address);
            this.workId = workId;
            this.branch = branch;
        }

        public String getWorkId() {
            return workId;
        }

        public void setWorkId(String workId) {
            this.workId = workId;
        }

        public String getBranch() {
            return branch;
        }

        public void setBranch(String branch) {
            this.branch = branch;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "workId='" + workId + '\'' +
                    ", branch='" + branch + '\'' +
                    ", id='" + id + '\'' +
                    ", fname='" + fname + '\'' +
                    ", lname='" + lname + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
    }

    public static class Worker extends Employee {
        protected int baseSalary;
        protected int workHours;

        public Worker(String id, String fname, String lname, String address, String workId, String branch, int baseSalary, int workHours) {
            super(id, fname, lname, address, workId, branch);
            this.baseSalary = baseSalary;
            this.workHours = workHours;
        }

        public int getBaseSalary() {
            return baseSalary;
        }

        public void setBaseSalary(int baseSalary) {
            this.baseSalary = baseSalary;
        }

        public int getWorkHours() {
            return workHours;
        }

        public void setWorkHours(int workHours) {
            this.workHours = workHours;
        }

        @Override
        public String toString() {
            return "Worker{" +
                    "baseSalary=" + baseSalary +
                    ", workHours=" + workHours +
                    ", workId='" + workId + '\'' +
                    ", branch='" + branch + '\'' +
                    ", id='" + id + '\'' +
                    ", fname='" + fname + '\'' +
                    ", lname='" + lname + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
        @Override
        public double calcSalary(){
            return baseSalary *  workHours;
        }
    }

    public static class Salesman extends Employee {
        protected int totalSales;

        public Salesman(String id, String fname, String lname, String address, String workId, String branch, int totalSales) {
            super(id, fname, lname, address, workId, branch);
            this.totalSales = totalSales;
        }

        public int getTotalSales() {
            return totalSales;
        }

        public void setTotalSales(int totalSales) {
            this.totalSales = totalSales;
        }

        @Override
        public String toString() {
            return "Salesman{" +
                    "totalSales=" + totalSales +
                    ", workId='" + workId + '\'' +
                    ", branch='" + branch + '\'' +
                    ", id='" + id + '\'' +
                    ", fname='" + fname + '\'' +
                    ", lname='" + lname + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }

        @Override
        public double calcSalary(){
            return 0.06*totalSales;
        }
    }

    public static class Manager extends Employee {
        protected int monthlySalary;

        public Manager(String id, String fname, String lname, String address, String workId, String branch, int monthlySalary) {
            super(id, fname, lname, address, workId, branch);
            this.monthlySalary = monthlySalary;
        }

        public int getMonthlySalary() {
            return monthlySalary;
        }

        public void setMonthlySalary(int monthlySalary) {
            this.monthlySalary = monthlySalary;
        }

        @Override
        public String toString() {
            return "Manager{" +
                    "monthlySalary=" + monthlySalary +
                    ", workId='" + workId + '\'' +
                    ", branch='" + branch + '\'' +
                    ", id='" + id + '\'' +
                    ", fname='" + fname + '\'' +
                    ", lname='" + lname + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
        @Override
        public double calcSalary(){
            return monthlySalary;
        }
    }

    public static class SeniorManager extends Manager {
        protected int bonus;

        public SeniorManager(String id, String fname, String lname, String address, String workId, String branch, int monthlySalary, int bonus) {
            super(id, fname, lname, address, workId, branch, monthlySalary);
            this.bonus = bonus;
        }

        public int getBonus() {
            return bonus;
        }

        public void setBonus(int bonus) {
            this.bonus = bonus;
        }

        @Override
        public String toString() {
            return "SeniorManager{" +
                    "bonus=" + bonus +
                    ", monthlySalary=" + monthlySalary +
                    ", workId='" + workId + '\'' +
                    ", branch='" + branch + '\'' +
                    ", id='" + id + '\'' +
                    ", fname='" + fname + '\'' +
                    ", lname='" + lname + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }

        @Override
        public double calcSalary(){
            return monthlySalary + bonus;
        }
    }
}
