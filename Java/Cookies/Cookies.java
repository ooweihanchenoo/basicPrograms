    /**
     * Created by WEI on 3/14/2016.
     */
    public class Cookies {
        private double radius;
        private String [] flavors;
        private boolean nuts;
        private Filling filling;

    //DEFAULT CONSTRUCTOR
    public Cookies(){
        flavors = new String[1];
        this.flavors[0]="vanilla";
        this.radius=20;
        this.nuts=false;
        this.filling=null;
    }
    public Cookies (double radius, String[] flavors, boolean nuts, Filling filling){
        this.radius=radius;
        this.flavors=flavors;
        this.nuts=nuts;
        this.filling=filling;
    }
    public Cookies (double radius,String[] flavors, boolean nuts){
        this.radius = radius;
        this.flavors = flavors;
        this.nuts=nuts;
    }
    public Cookies (double radius, String[] flavors){
        this.radius = radius;
        this.flavors = flavors;
    }
    public Cookies (double radius){
        this.radius = radius;
    }


        //SET METHOD MUTATORS
        public void setFilling(Filling filling) {
            this.filling = filling;
        }
        public void setFlavors(String[] flavors) {
            this.flavors = flavors;
        }
        public void setNuts(boolean nuts) {
            this.nuts = nuts;
        }
        public void setRadius(double radius) {
            this.radius = radius;
        }

        //GET METHOD ACCESSOR
        public double getRadius() {
            return radius;
        }
        public Filling getFilling() {
            return filling;
        }
        public String[] getFlavors() {
            return flavors;
        }

        public String toString(){
            String str = "Flavors: "+flavors[0]+"\nRadius: "+radius
                    +"\nNuts: "+nuts+"\nFilling: "+filling;
            return str;
        }
    }

