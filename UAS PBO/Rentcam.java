

import java.util.ArrayList;

abstract class Rentcam {
    private final ArrayList<Cams> rentedCam = new ArrayList<>();

    public void lease(Cams cams){
        this.rentedCam.add(cams);
    }

    public void completeLease(Cams cams){
        this.rentedCam.remove(cams);
    }

    public Cams[] getRentedList(){
        Cams[] rentArray = new Cams[rentedCam.size()];
        int i = 0;
        for (Cams cams : rentedCam) {
            rentArray[i++] = cams;
        }
        return rentArray;
    }

    public abstract void greets();




}