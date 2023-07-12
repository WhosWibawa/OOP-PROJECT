

import java.util.ArrayList;

public class Camera {
    private final ArrayList<Cams> cameralist = new ArrayList<>();
    private final ArrayList<Member> memberList = new ArrayList<>();

    public Cams[] getCameraList(){
        Cams[] camsArray = new Cams[this.cameralist.size()];
        int i = 0;
        for (Cams cams : this.cameralist) {
            camsArray[i++] = cams;
        }
        return camsArray;
    }


    public void showCams(){
        for (Cams cams : getCameraList()) {
            if (cams == null) {
                continue;
            }
            System.out.printf("List Kamera Ke %s\n", cams.getId());
            System.out.printf("Tipe Kamera  : %s \nHarga : Rp%d/Hari \n \n", cams.getcamName(), cams.getCamPrice());

        }
    }

    public void showCamsByID(int camID){
         Cams cams = this.cameralist.get(camID -1);

            System.out.printf("List Kamera Ke %s\n", cams.getId());
            System.out.printf("Tipe Kamera  : %s \nHarga : Rp%d/Hari \n \n", cams.getcamName(), cams.getCamPrice());
    }

    public Member[] getMemberList(){
        Member[] MemArray = new Member[this.memberList.size()];
        int i = 0;
        for (Member member : this.memberList) {
            MemArray[i++] = member;
        }
        return MemArray;
    }

    public void showMember(){
        for (Member member : getMemberList()) {
            if (member == null) {
                continue;
            }
            System.out.printf(" ID member : %s \n", member.getId());
            System.out.printf("%s \n", member.getUsername());
            
        }
    }

    public void showMemberByID(int memberID){
        Member member = this.memberList.get(memberID -1);

            System.out.printf(" ID member : %s\n", member.getId());
            System.out.printf("%s \n", member.getUsername());
    }

    public void showRentedCamera(int memberID) {
        Member member = getMemberByID(memberID);
        if (member == null) {
            return;
        }
        
        Cams[] rentedList = member.getRentedList();
        if (rentedList == null) {
            System.out.println("Rented list is null");
            return;
        }
    
        for (Cams cams : rentedList) {
            System.out.printf("Id Kamera %s\n", cams.getId());
            System.out.printf("Tipe Kamera : %s \n \n", cams.getcamName());
        }
    }

    public void addCam(Cams cams, boolean duplicateCheck) throws ThrowtheException{
        if (duplicateCheck){
            isIdCamsExist(cams.getId());
        }

        this.cameralist.add(cams);
    }


    private void isIdCamsExist(int id) {
    }

    public void isIdCamExist(int id) throws ThrowtheException {
        for (Cams cams : this.cameralist) {
            if (cams.getId() == id) {
                throw new ThrowtheException();
            }

        }
    }

    public void addMember(Member member, boolean duplicateCheck) throws ThrowtheException{
        // try {
            if (duplicateCheck) {
                isIdMembExist(member.getId());
            }
            this.memberList.add(member);

        // }catch (LibraryException e){
        //     System.out.println("This Member ID Already Exist");
        // }

    }

    public void remMember(int memberID){
            Member member = this.getMemberByID(memberID);
            if (member == null) {
                System.out.println("This User ID Not Available");
                return;
            }
            System.out.println("Berhasil Menghapus User");
            this.memberList.remove(member);
    }

    public void remCam(int camID){
        Cams cams = this.getCamsID(camID);
        if (cams == null) {
            System.out.println("This User ID Not Available");
            return;
        }
        System.out.println("Berhasil Menghapus Kamera");
        this.cameralist.remove(cams);
    }


    public void isIdMembExist(int id) throws ThrowtheException {
        for (Member member : this.memberList) {
            if (member.getId() == id) {
                throw new ThrowtheException();
            }
        }
    }

    private Cams getCamByID(int id, Cams[] cameraList){
        for (Cams cams : cameraList) {
            if (cams != null && cams.getId() == id) {
            return cams;
            }
        }
        return null;
    }

    private Cams getCamsID(int id){
        for (Cams cams : this.cameralist){
            if (cams.getId() == id) {
                return cams;
            }
        }
        return null;
    }

    private Member getMemberByID(int id){
        for (Member member : this.memberList) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    private int getMemberIndex(Member member){
        return this.memberList.indexOf(member);
    }

    public void rentCam(int camID, int memberID){
        Cams cams = this.getCamByID(camID, getCameraList());
        this.cameralist.remove(cams);

        Member member = this.getMemberByID(memberID);
        int memberIndex = this.getMemberIndex(member);
        this.memberList.get(memberIndex).lease(cams);
    }

    public void endCamRent(int camID, int memberID){
        Member member = this.getMemberByID(memberID);
        int memberIndex = this.getMemberIndex(member);

        if (member == null) {
            return;
        }

        Cams cams = this.getCamByID(camID, member.getRentedList());
        this.cameralist.add(cams);
        this.memberList.get(memberIndex).completeLease(cams);
    }


    public void orderInvoice(int memberID, int camID, long noTelp) {
        Member member = this.memberList.get(memberID - 1);
        Cams cams = this.cameralist.get(camID - 1);
        Member member2 = new Member(noTelp);
    
        System.out.println("\n Rent Status - Pending - Waiting for Payment");
        System.out.printf("Nama User  : %s \n", member.getUsername());
        System.out.printf("No Telf  : %d \n", member2.getNoTelp());
        System.out.printf("Tipe kamera  : %s \n", cams.getcamName());
        System.out.printf("Nominal Yang Harus Dibayarkan  : %d \n", cams.getCamPrice());
        System.out.println("SIlahkan lakukan Down Payment 50 persen dari total sewa untuk keep invoice permanen, payment bisa ditransfer ke rekening 123456 a/n wibaw");
        member.greets();
    }
    

    public void editCam(int camID, int newID, String camName, int camPrice){
        Cams cams = cameralist.get(camID -1);
        cams.setID(newID);
        cams.setCamName(camName);
        cams.setCamPrice(camPrice);
        cameralist.set(camID-1, cams);
    }

    public void editMember(int memberID, int newID, String userName){
        Member member = memberList.get(memberID-1);
        member.setId(newID);
        member.setUsername(userName);
        memberList.set(memberID-1, member);
    }


	// public void showRentedCamera(int memberID) {
	// }
}