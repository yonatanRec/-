package Lessons.Lesson_7;
import Other.queue.*;
import Other.stack.*;
import java.util.Scanner;


public class Program {
    static Scanner reader = new Scanner(System.in);
    public static void main(String[] args){
        Queue<Integer> q = new Queue<>();
        Integer[] arr = {6,5,4,3,2,1,0};
        q.Helper.insert(arr);
        System.out.println(Q7.queueToSortedStack(q));
    }





    public static String goodEngine(Queue<DeliveryWorker> q, int engineSize){
        Queue<DeliveryWorker> temp = new Queue<>();
        String id = "";
        boolean found = false;
        while(!q.isEmpty()){
            DeliveryWorker worker = q.remove();
            if(worker.getEngineVolume() >= engineSize && !found) {
                id = worker.getId();
                found = true;
            }
            else
                temp.insert(worker);
        }
        while(!temp.isEmpty())
            q.insert(temp.remove());
        return id;
    }

    public static void addCust(DoubleQueue qq){
        System.out.println("enter choice for system, 1 for new customer, 2 for customer service and 3 for leaving system");
        int choice = reader.nextInt();
        while(choice != 3){
            System.out.println("enter choice for system, 1 for new customer, 2 for customer service and 3 for leaving system");
            choice = reader.nextInt();
        }
    }
}



class DeliveryWorker{
    private String id;
    private int engineVolume;

    public DeliveryWorker(String id, int engineVolume) {
        this.id = id;
        this.engineVolume = engineVolume;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(int engineVolume) {
        this.engineVolume = engineVolume;
    }
}

class DoubleQueue{
    private Queue<Integer> fast;
    private Queue<Integer> slow;
    private int index;

    public DoubleQueue(Queue<Integer> fast, Queue<Integer> slow) {
        this.fast = fast;
        this.slow = slow;
    }

    public Queue<Integer> getFast() {
        return fast;
    }

    public void setFast(Queue<Integer> fast) {
        this.fast = fast;
    }

    public Queue<Integer> getSlow() {
        return slow;
    }

    public void setSlow(Queue<Integer> slow) {
        this.slow = slow;
    }

    public Queue<Integer> getQueue(int act) {
        return act == 0 ? fast : slow;
    }

    public void addCustomer(int num, int act){
        getQueue((act+1)%2).insert(num);
    }

    public int getNext(){
        index++;
        return index == 0 || index%5 > 0 ? fast.remove() : slow.remove();
    }
}


class Q4{
    public static class TimeFunc{
        public static int diff(Queue<Time> times){
            Time first = times.remove();
            Time last =  times.remove();
            while(!times.isEmpty()){
                last = times.remove();
            }
            return calcDiff(first,last);
        }

        public static void smallestDiff(Queue<Time> times){
            Time curr =  times.remove();
            int pos = 0;
            int smallestPos = 0;
            int smallestDiff = Integer.MAX_VALUE;
            while(!times.isEmpty()){
                Time next = times.remove();
                if(calcDiff(curr,next) < smallestDiff){
                    smallestDiff = calcDiff(curr,next);
                    smallestPos = pos;
                }
                curr = next;
                pos++;
            }
            System.out.println(smallestPos + "\t" + smallestPos+1);

        }

        public static int calcDiff(Time time1, Time time2){
            int total1 = time1.getSeconds() + time1.getMinutes()*60 + time1.getHours()*3600;
            int total2 = time2.getSeconds() + time2.getMinutes()*60 + time2.getHours()*3600;
            return total1 - total2;
        }
    }
    static class Time{
        private int seconds;
        private int minutes;
        private int hours;

        public Time(int seconds, int minutes, int hours) {
            this.seconds = seconds;
            this.minutes = minutes;
            this.hours = hours;
        }

        public int getSeconds() {
            return seconds;
        }

        public int getMinutes() {
            return minutes;
        }

        public int getHours() {
            return hours;
        }

        public void setSeconds(int seconds) {
            this.seconds = seconds;
        }

        public void setMinutes(int minutes) {
            this.minutes = minutes;
        }

        public void setHours(int hours) {
            this.hours = hours;
        }
    }
}

class Q5{
    public static boolean appearsGoodTimes(Queue<Integer> q, int n){
        for(int i = 1; i <= n; i++){
            Queue<Integer> temp = new Queue<>();
            int count = 0;
            while(!q.isEmpty()){
                int curr = q.remove();
                if(curr == i)
                    count++;
                temp.insert(curr);
            }
            if(count != i)
                return false;
            while(!temp.isEmpty())
                q.insert(temp.remove());
        }
        return true;
    }
}

class Q6{
    public static boolean guessedRight(Queue<String> q, int n){
        for(int i = 1; i <= n; i++){
            String curr =  q.remove();
            q.insert(curr);
        }
        return q.head().equals("gold");
    }
}

class Q7{
    public static Stack<Integer> queueToSortedStack(Queue<Integer> q){
        Stack<Integer> sortedStack = new Stack<>();
        Queue<Integer> temp = new Queue<>();
        while(!q.isEmpty()){
            int smallest = Integer.MAX_VALUE;
            while(!q.isEmpty()) {
                int curr = q.remove();
                if (curr <= smallest)
                    smallest = curr;
                temp.insert(curr);
            }
            boolean found = false;
            while(!temp.isEmpty()){
                if(temp.head() == smallest && !found) {
                    temp.remove();
                    found = true;
                }
                else
                    q.insert(temp.remove());
            }
            sortedStack.push(smallest);
        }
        return sortedStack;
    }
}

class Q8{
    static class Job{
        private int time;
        private String code;

        public Job(int time, String code) {
            this.time = time;
            this.code = code;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
    public static void enoughWork(Queue<Job> q, int time){
        while (!q.isEmpty()){
            Job job = q.remove();
            if(job.getTime() <= time)
                System.out.println(job.getCode());
        }
    }

}

class Q9{
    static Scanner reader = new Scanner(System.in);
    public static void mergeLines(Queue<String> active, Queue<String> shutDown){
        Queue<String> temp = new Queue<>();
        while (!shutDown.isEmpty() && !active.isEmpty()){
            temp.insert(active.remove());
            temp.insert(shutDown.remove());
        }
        while(!active.isEmpty())
            temp.insert(active.remove());
        while(!shutDown.isEmpty())
            temp.insert(shutDown.remove());
        while (!temp.isEmpty())
            active.insert(temp.remove());
    }
    public static void main(String[] args) {
        Queue<String> active = new Queue<>();
        System.out.println("enter person for active line");
        String activeCode = reader.nextLine();
        while (!activeCode.equals("exit")){
            active.insert(activeCode);
            activeCode = reader.nextLine();
        }
        Queue<String> shutDown = new Queue<>();
        System.out.println("enter person for shutDown line");
        String shutDownCode = reader.nextLine();
        while (!shutDownCode.equals("exit")){
            shutDown.insert(shutDownCode);
            shutDownCode = reader.nextLine();
        }
    }
}

class Q10{
    public static void merge(Queue<Integer> a, Queue<Integer> b){
        Queue<Integer> merge = new Queue<>();
        while (!a.isEmpty() &&  !b.isEmpty()){
            if (a.head() >= b.head())
                merge.insert(a.remove());
            else
                merge.insert(b.remove());
        }
        while (!a.isEmpty())
            merge.insert(a.remove());
        while (!b.isEmpty())
            merge.insert(b.remove());
        while (!merge.isEmpty())
            a.insert(merge.remove());
    }
}