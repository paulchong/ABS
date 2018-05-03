public class Company {
    private String name;

    public final void issueApology(String name){
        System.out.println(name + " apologises for your poor customer experience.  We endeavor to improve next time.");
    }

    public String getName(){
        return "Company: "+name;
    }
}
