//     import Camera;
// import Member;
// import Rooms;

import java.util.Scanner;

public class Main {

    public static Scanner scan = new Scanner(System.in);
    static Camera libs = new Camera();

    public static void main(String[] args) throws ThrowtheException {
        String goBack = "y";
        initCamData();

        while (goBack.equalsIgnoreCase("y")) {
            showMenu();
            int sel = chooseMenu();

            switch (sel) {
                case 1 -> OrderCam();
                case 2 -> EndCamRent();
                case 3 -> showCam();
                case 4 -> showMember();
                case 5 -> showRentedCam();
                case 6 -> addCam();
                case 7 -> addUser();
                case 8 -> remMembers();
                case 9 -> dCam();
                case 10 -> eCam();
                case 11 -> editMember();
                case 12 -> {
                    return;
                }

                default -> System.out.println("Opsi Tidak Tersedia");
            }
            System.out.println("Continue? (y/n)");
            System.out.print("Your Input >> ");
            goBack = scan.next();
        }
    }

    // private static void initCamData() {
    // }

    public static void initCamData() throws ThrowtheException {
        // Room List
        libs.addCam(new Cams(1, "Sony a7", 300000), true);
        libs.addCam(new Cams(2, "Sony a7c", 320000), true);
        libs.addCam(new Cams(3, "Sony a7s", 350000), true);
        libs.addCam(new Cams(4, "Sony a7iii", 360000), true);
        libs.addCam(new Cams(5, "lumix", 400000), true);
        libs.addCam(new Cams(6, "EOS R5", 425000), true);
        libs.addCam(new Cams(7, "Sony FX6", 6000003), true);

        // User List
        libs.addMember(new Member(1, "wibawa", 123), true);
        libs.addMember(new Member(2, "wibawa1", 456), true);
        libs.addMember(new Member(3, "wibawa2", 789), true);

    }

    public static int chooseMenu() {
        System.out.print(" >> ");
        int select = scan.nextInt();
        scan.nextLine();
        return select;
    }

    public static void showMenu() {
        System.out.println("""
                SEWA KAMERA BALI

                 1   Rent Camera
                 2   Checkout
                 3   Show Camera
                 4   Show user
                 5   Rented Camera
                 6   Add Camera
                 7   Add user
                 8   Delete User
                 9   Delete camera
                 10  Edit Camera
                 11  Edit User
                 12  Exit


                """);
    }

    public static void showCam() {
        libs.showCams();
    }

    public static void showMember() {
        libs.showMember();
    }

    public static void showRentedCam() {
        System.out.println("Masukan ID User : ");
        int memberID = scan.nextInt();

        libs.showRentedCamera(memberID);
    }

    public static void OrderCam() {
        String goBack;
        System.out.println("Masukan ID User");
        int memberID = scan.nextInt();

        showCam();

        System.out.println("Pilih tipe kamera");
        int camID = scan.nextInt();

        System.out.println("Masukan No Telp");
        int noTelp = scan.nextInt();

        scan.nextLine();

        System.out.println("+==========CEK==========+");
        libs.showMemberByID(memberID);
        libs.showCamsByID(camID);
        System.out.println("+==================================+");

        System.out.println("lanjutkan? (y/n)");
        System.out.print(" >> ");
        goBack = scan.next();

        if (goBack.equalsIgnoreCase("y")) {
            libs.orderInvoice(memberID, camID, noTelp);
            libs.rentCam(camID, memberID);

        } else if (goBack.equalsIgnoreCase("n")) {
            OrderCam();

        } else {
            System.out.println("(y/n)");
        }
    }

    public static void EndCamRent() {
        String goBack;
        System.out.println("Masukan ID User");
        int memberID = scan.nextInt();

        System.out.println("Masukan tipe kamera");
        int camID = scan.nextInt();

        System.out.println("+==========CEK==========+");
        libs.showMemberByID(memberID);
        libs.showRentedCamera(memberID);

        System.out.println("Lanjutkan? (y/n)");
        System.out.print(" >> ");
        goBack = scan.next();

        if (goBack.equalsIgnoreCase("y")) {
            libs.endCamRent(camID, memberID);

        } else if (goBack.equalsIgnoreCase("n")) {
            showMenu();

        } else {
            System.out.println("(y/n)");
        }

    }

    public static void addCam() throws ThrowtheException {
        String goBack;
        System.out.println("Masukan tipe kamera");
        int camID = scan.nextInt();

        scan.nextLine();

        System.out.println("Masukan Tipe kamera");
        String camName = scan.nextLine();

        System.out.println("Masukan Harga Kamera");
        int camPrice = scan.nextInt();

        System.out.printf("ID Kamera %s \n", camID);
        System.out.printf("Tipe Kamera %s \n", camName);
        System.out.printf("Harga Kamera %s \n", camPrice);
        System.out.println("+==================================+");
        System.out.println("lanjutkan? (y/n)");
        System.out.print(" >> ");
        goBack = scan.next();

        if (goBack.equalsIgnoreCase("y")) {
            System.out.println("Berhasil Menambahkan Kamera");
            libs.addCam(new Cams(camID, camName, camPrice), true);

        } else if (goBack.equalsIgnoreCase("n")) {
            addCam();

        } else {
            System.out.println("(y/n)");
        }
    }

    public static void addUser() throws ThrowtheException {
        String goBack;
        System.out.println("Masukan Nomer User");
        int userID = scan.nextInt();

        System.out.println("Masukan Nama Calon User");
        String userName = scan.next();

        System.out.println("nomer tlp");
        int notlp = scan.nextInt();

        System.out.println("+==========CEK==========+");
        System.out.printf("Nomer User %s \n", userID);
        System.out.printf("Nama User %s \n", userName);
        System.out.println("+==================================+");
        System.out.println("Lanjutkan? (y/n)");
        System.out.print(" >> ");
        goBack = scan.next();

        if (goBack.equalsIgnoreCase("y")) {
            libs.addMember(new Member(userID, userName, notlp), true);
            System.out.println("Berhasil Menambahkan User");

        } else if (goBack.equalsIgnoreCase("n")) {
            addUser();

        } else {
            System.out.println("(y/n)");
        }
    }

    public static void remMembers() {
        try {
            String goBack;
            showMember();
            System.out.println();
            System.out.println("Masukan ID Member Yang Ingin DiHapus");
            int memberID = scan.nextInt();

            System.out.printf("Anda Yakin Menghapus User Ke %s ? ", memberID);
            System.out.println("(y/n)");
            System.out.print(" >> ");
            goBack = scan.next();

            if (goBack.equalsIgnoreCase("y")) {
                libs.remMember(memberID);

            } else if (goBack.equalsIgnoreCase("n")) {
                showMenu();

            } else {
                System.out.println("Input Salah dan Akan Kembali ke Menu");
                showMenu();
            }

        } catch (Exception e) {
            System.out.println("ID Member Not Valid");
        }
    }

    public static void dCam() {
        try {
            String goBack;
            showCam();
            System.out.println();
            System.out.println("Masukan ID Kamera Yang Ingin DiHapus");
            int camID = scan.nextInt();

            System.out.printf("Anda Yakin Menghapus Kamera Ke %s ? ", camID);
            System.out.println("(y/n)");
            System.out.print("Your Input >> ");
            goBack = scan.next();

            if (goBack.equalsIgnoreCase("y")) {
                libs.remCam(camID);

            } else if (goBack.equalsIgnoreCase("n")) {
                showMenu();

            } else {
                System.out.println("Input Salah dan Akan Kembali ke Menu");
                showMenu();
            }

        } catch (Exception e) {
            System.out.println("ID Member Not Valid");
        }
    }

    public static void eCam() {
        String goBack;
        showCam();
        System.out.println("Masukan ID Yang Ingin Di Edit");
        int camID = scan.nextInt();

        System.out.println("Masukan ID Baru/ID Yang Sama");
        int newID = scan.nextInt();

        scan.nextLine();

        System.out.println("Masukan tipe Kamera");
        String camName = scan.nextLine();

        System.out.println("Masukan Harga Kamera");
        int camPrice = scan.nextInt();

        System.out.println("+==========[Confirmation]==========+");
        System.out.println("Sebelum");
        libs.showCamsByID(camID);
        System.out.println();

        System.out.println("Sesudah");
        System.out.printf("List Kamera Ke %s\n", newID);
        System.out.printf("Tipe Kamera  : %s \nHarga : Rp%d/Hari \n", camName, camPrice);
        System.out.println("+=====================================+");

        System.out.println("Lanjutkan? (y/n)");
        System.out.print(" >> ");
        goBack = scan.next();

        if (goBack.equalsIgnoreCase("y")) {
            libs.editCam(camID, newID, camName, camPrice);

        } else if (goBack.equalsIgnoreCase("n")) {
            eCam();

        } else {
            System.out.println("(y/n)");
        }
    }

    public static void editMember() {
        String goBack;
        showMember();
        System.out.println("Masukan ID Yang Ingin Di Edit");
        int camID = scan.nextInt();

        System.out.println("Masukan ID Baru/ID Yang Sama");
        int newID = scan.nextInt();

        scan.nextLine();

        System.out.println("Masukan Nama Member");
        String userName = scan.nextLine();

        System.out.println("+==========CEK==========+");
        System.out.println("Sebelum");
        libs.showMemberByID(camID);
        System.out.println("+======================================+");
        System.out.println();
        System.out.println("Sesudah");
        System.out.printf("+==========User Member Ke %s==========+\n", newID);
        System.out.printf("|%s |\n", userName);
        System.out.println("+======================================+");

        System.out.println("Lanjutkan? (y/n)");
        System.out.print(" >> ");
        goBack = scan.next();

        if (goBack.equalsIgnoreCase("y")) {
            libs.editMember(camID, newID, userName);

        } else if (goBack.equalsIgnoreCase("n")) {
            editMember();

        } else {
            System.out.println("(y/n)");
        }
    }
}