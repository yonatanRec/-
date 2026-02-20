package Lessons.Lesson_18;

public class Q8 {
    public static class Cake{
        protected boolean gluten;
        protected int eggs;
        protected int sugar;
        protected String toppings;

        public Cake(boolean gluten, int eggs, int sugar, String toppings) {
            this.gluten = gluten;
            this.eggs = eggs;
            this.sugar = sugar;
            this.toppings = toppings;
        }

        public boolean isGluten() {
            return gluten;
        }

        public void setGluten(boolean gluten) {
            this.gluten = gluten;
        }

        public int getEggs() {
            return eggs;
        }

        public void setEggs(int eggs) {
            this.eggs = eggs;
        }

        public int getSugar() {
            return sugar;
        }

        public void setSugar(int sugar) {
            this.sugar = sugar;
        }

        public String getToppings() {
            return toppings;
        }

        public void setToppings(String toppings) {
            this.toppings = toppings;
        }

        @Override
        public String toString() {
            return "Cake{" +
                    "gluten=" + gluten +
                    ", eggs=" + eggs +
                    ", sugar=" + sugar +
                    ", additives='" + toppings + '\'' +
                    '}';
        }
    }

    public static class Danish extends Cake{
        protected double yeast;
        protected int baking;

        public Danish(boolean gluten, int eggs, int sugar, String toppings, double yeast, int baking) {
            super(gluten, eggs, sugar, toppings);
            this.yeast = yeast;
            this.baking = baking;
        }

        public double getYeast() {
            return yeast;
        }

        public void setYeast(double yeast) {
            this.yeast = yeast;
        }

        public int getBaking() {
            return baking;
        }

        public void setBaking(int baking) {
            this.baking = baking;
        }

        @Override
        public String toString() {
            return "Danish{" +
                    "yeast=" + yeast +
                    ", baking=" + baking +
                    ", gluten=" + gluten +
                    ", eggs=" + eggs +
                    ", sugar=" + sugar +
                    ", toppings='" + toppings + '\'' +
                    '}';
        }

        public void doubleBake(){
            baking *= 2;
        }
    }

    public static class FrostedCake extends Cake{
        protected String type;
        protected boolean candy;

        public FrostedCake(boolean gluten, int eggs, int sugar, String toppings, String type, boolean candy) {
            super(gluten, eggs, sugar, toppings);
            this.type = type;
            this.candy = candy;
        }

        public FrostedCake(FrostedCake other){
            super(other.gluten, other.eggs, other.eggs, other.toppings);
            this.type = other.type;
            this.candy = other.candy;
        }

        public String getType() {
            return type;
        }

        public boolean isCandy() {
            return candy;
        }

        @Override
        public String toString() {
            return "FrostedCake{" +
                    "candy=" + candy +
                    ", gluten=" + gluten +
                    ", eggs=" + eggs +
                    ", sugar=" + sugar +
                    ", toppings='" + toppings + '\'' +
                    ", type='" + type + '\'' +
                    '}';
        }
    }

}
