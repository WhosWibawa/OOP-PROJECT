public class Cams {
    private int id;
    private String camName;
    private int camPrice;

    public Cams(int id, String camName, int camPrice){
        this.id = id;
        this.camName = camName;
        this.camPrice = camPrice;
    }

    public void setID(int id){
        this.id = id;
    }

    public void setcamName(String camName){
        this.camName = camName;
    }

    public void setCamPrice(int camPrice){
        this.camPrice = camPrice;
    }

    public int getId(){
        return id;
    }

    public String getcamName(){
        return this.camName;
    }

    public int getCamPrice(){
        return this.camPrice;
    }

    public void setCamName(String camName2) {
    }

}