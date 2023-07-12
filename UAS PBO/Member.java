
public class Member extends Rentcam {

    private int id;
    private String username;
    private long noTelp;


    public Member(int id, String username){
        this.id = id;
        this.username = username;

    }
    // Constructor Overloading!
    public Member(long noTelp){
        this.noTelp = noTelp;

    }

    public void setId(int id){
        this.id = id;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public int getId(){
        return id;
    }

    public String getUsername(){
        return username;
    }

    public long getNoTelp(){
        return noTelp;
    }
    @Override
    public void greets(){
        System.out.println(" \n Harap konfirmasi dengan mengirimkan bukti transfer ke nomor berikut 081123456789 ");
    }
    public Cams[] getRentedList() {
        return null;
    }
}