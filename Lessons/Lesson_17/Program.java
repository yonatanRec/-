package Lessons.Lesson_17;

import java.util.Date;


public class Program {

}

class Q5 {
    public static void Main(String[] args) {
        AAA c1 = new AAA(-1);
        AAA c2 = new AAA(2);
        BBB d1 = new BBB();
        BBB d2 = new BBB(3);
    }
    static class AAA {
        public AAA() {
            System.out.println("AAA ctor!");
        }

        public AAA(int num) {
            if (num > 0) {
                new AAA(num - 1);
            } else {
                new AAA();
            }
            System.out.println("AAA ctor" + num);
        }
    }

    static class BBB extends AAA {
        public BBB() {
            super();
            System.out.println("BBB ctor!");
        }

        public BBB(int num) {
            super(num);
            new AAA(num / 2);
            new BBB();
            System.out.println("BBB ctor" + num);
        }
    }
}

class Q7{
    static class MK{
        private String Fname;
        private String Lname;
        private String id;

        public MK(String fname, String lname, String id) {
            Fname = fname;
            Lname = lname;
            this.id = id;
        }

        public String getFname() {
            return Fname;
        }

        public String getLname() {
            return Lname;
        }

        public String getId() {
            return id;
        }

        public void setFname(String fname) {
            Fname = fname;
        }

        public void setLname(String lname) {
            Lname = lname;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    static class Party{
        private String name;
        private MK head;
        private MK[] members;

        public Party(String name, MK head, MK[] members) {
            this.name = name;
            this.head = head;
            this.members = members;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public MK getHead() {
            return head;
        }

        public void setHead(MK head) {
            this.head = head;
        }

        public MK[] getMembers() {
            return members;
        }

        public void setMembers(MK[] members) {
            this.members = members;
        }
    }

    static class knesset{
        private int year;
        private Party[] parties;
        private MK head;

        public knesset(int year, Party[] parties, MK head) {
            this.year = year;
            this.parties = parties;
            this.head = head;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public Party[] getParties() {
            return parties;
        }

        public void setParties(Party[] parties) {
            this.parties = parties;
        }

        public MK getHead() {
            return head;
        }

        public void setHead(MK head) {
            this.head = head;
        }
    }

    static class leadParty{
        private int ministers;
        private int viceMinisters;
        private String[] roles;
        private Date startTerm;
        private Date endTerm;

        public leadParty(int ministers, int viceMinisters, String[] roles, Date startTerm, Date endTerm) {
            this.ministers = ministers;
            this.viceMinisters = viceMinisters;
            this.roles = roles;
            this.startTerm = startTerm;
            this.endTerm = endTerm;
        }

        public int getMinisters() {
            return ministers;
        }

        public void setMinisters(int ministers) {
            this.ministers = ministers;
        }

        public int getViceMinisters() {
            return viceMinisters;
        }

        public void setViceMinisters(int viceMinisters) {
            this.viceMinisters = viceMinisters;
        }

        public String[] getRoles() {
            return roles;
        }

        public void setRoles(String[] roles) {
            this.roles = roles;
        }

        public Date getStartTerm() {
            return startTerm;
        }

        public void setStartTerm(Date startTerm) {
            this.startTerm = startTerm;
        }

        public Date getEndTerm() {
            return endTerm;
        }

        public void setEndTerm(Date endTerm) {
            this.endTerm = endTerm;
        }
    }

    static class OppParty{
        private String name;
        private MK head;
        private String[] roles;

        public OppParty(String name, MK head, String[] roles) {
            this.name = name;
            this.head = head;
            this.roles = roles;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public MK getHead() {
            return head;
        }

        public void setHead(MK head) {
            this.head = head;
        }

        public String[] getRoles() {
            return roles;
        }

        public void setRoles(String[] roles) {
            this.roles = roles;
        }
    }
}