package Assignments.Assignment_15;

public class Q3 {

    public static void main(String[] args) {
        One[] arr = new One[5];
        arr[0] = new Two();
        arr[1] = new One(5);
        arr[2] = arr[0].getSmaller(arr[1]);
        arr[3] = new Two();
        arr[4] = arr[3].getSmaller(arr[2]);
    }

    public static class One{
        protected static int min = 0; // גדול מ-0
        private int num;
        public One(int num){
            this.num = num;
            if(num < min){
                min = num;
            }
        }

        // טענת כניסה:
        // a != null
        // this מאותחל
        // ל-this ול-a יש ערך num חוקי
        //
        // טענת יציאה:
        // מוחזר אובייקט מסוג One
        // מוחזר האובייקט עם הערך num הקטן יותר מבין this ו-a
        // אם this.num < a.num מוחזר this, אחרת מוחזר a
        // לא מתבצע שינוי באובייקטים או ב-min
        public One getSmaller(One a){
            if(this.num < a.num){
                return this;
            }
            return a;
        }

        public int getNum(){
            return num;
        }
    }

    public static class Two extends One{
        public Two(){
            super(One.min + 1);
        }

        // טענת כניסה:
        // a != null
        // this הוא מופע של Two ומאותחל
        // a הוא מופע של One (או תת-מחלקה שלו)
        //
        // טענת יציאה:
        // מוחזר אובייקט מסוג One
        // אם a הוא מופע של Two מוחזר האובייקט עם num הקטן יותר (ע"י One.getSmaller)
        // אם a אינו מופע של Two מוחזר תמיד this
        // לא מתבצע שינוי באובייקטים או ב-min
        @Override
        public One getSmaller(One a){
            if(a instanceof Two){
                return super.getSmaller(a);
            }
            return this;
        }
    }
}
