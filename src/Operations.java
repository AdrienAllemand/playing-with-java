public abstract class Operations {

    public abstract void apply();


    public  void main(String... args){

        // Operations.apply();
        // Addition.apply();

        //Operations o = new Operations();
        Operations a = new Addition();
        Addition aa = new Addition();

        //o.apply();
        a.apply();
        aa.apply();
    }

}


class Addition extends Operations{

    public void apply() {
        System.out.println("Hello from Addition");
    }
}