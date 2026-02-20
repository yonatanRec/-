package Assignments.Assignment_16;

public class Q5 {


    public static void main(String[] args) {
        Worker w1 = new Worker("1234", "fname", "lname", "address", "1234", "customer service", 170);
        Worker w2 = new Worker("1235", "fname", "lname", "address", "1235", "customer service", 170);

        Salesman s1 = new Salesman("1236", "fname", "lname", "address", "1236", "sales", 100000);
        Salesman s2 = new Salesman("1237", "fname", "lname", "address", "1237", "sales", 120000);

        Manager m1 = new Manager("1238", "fname", "lname", "address", "1238", "management", 30000);

        SeniorManager sm1 = new SeniorManager("1239", "fname", "lname", "address", "1239", "upper management", 40000, 600);

        System.out.println("w1 pay: " + w1.pay());
        System.out.println("w2 pay: " + w2.pay());
        System.out.println("s1 pay: " + s1.pay());
        System.out.println("s2 pay: " + s2.pay());
        System.out.println("m1 pay: " + m1.pay());
        System.out.println("sm1 pay: " + sm1.pay());

        int sales = s1.getTotalSales() + s2.getTotalSales();

        System.out.println("total sales: " + sales);

        double pay = w1.pay() + w2.pay() + s1.pay() + s2.pay() + m1.pay() + sm1.pay();

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

        public Worker(String id, String fname, String lname, String address, String workId, String branch,int workHours) {
            super(id, fname, lname, address, workId, branch);
            this.baseSalary = 30;
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

        public int pay(){
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

        public double pay(){
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

        public int pay(){
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
        public int pay(){
            return monthlySalary + bonus;
        }
    }
}
