package org.MiniCapstoneProject.AdminRole;

import org.MiniCapstoneProject.Clinic_ManagerRole.ClinicManagerRole;

import java.util.Scanner;

import static org.MiniCapstoneProject.Clinic_ManagerRole.ClinicManagerRole.resetIdPasswordClinicManager;
import static org.MiniCapstoneProject.PatientRole.PatientRole.resetIdPasswordPatient;
import static org.MiniCapstoneProject.PhysiotherapistRole.PhysiotherapistRole.resetIdPasswordPhysiotherapist;

public class AdminRole {

    static  Scanner sc=new Scanner(System.in);
    static String defaultUserIdAdmin="Admin";
    static String defaultPasswordAdmin="Admin@123";


    public static void adminWelcomeMessage(){
        System.out.println("*******--welcome to PhysioTrack--********");
        System.out.println("Role = Admin");


        System.out.println("please enter your userId : ");
        String userId=sc.nextLine();
        System.out.println("please enter your password : ");
        String password=sc.nextLine();

        if(userId.equals(defaultUserIdAdmin) && password.equals(defaultPasswordAdmin)){
            showOption();
        } else {
            System.out.println("userId and Password is wrong");
            adminWelcomeMessage();
        }

    }

    public static void showOption(){
        System.out.println("1. view all patient list \t 2. change user credential   \t 3. exit");
        int option=sc.nextInt();
        sc.nextLine();
                switch (option) {
                    case 1:
                        ClinicManagerRole.showPatientList();
                        showOption();
                        break;
                    case 2:
                        manageUser();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("select correct option");
                        showOption();
                }
    }

    public static void manageUser(){
        System.out.println("please select role to manage ");
        System.out.println("1.Physiotherapist \t 2.Patient \t 3.Clinic_Manager \t 4.exit");
        int option=sc.nextInt();
        sc.nextLine();
        resetIdPassword(option);
    }

    public static void resetIdPassword(int role){

        switch (role){
            case 1:
                resetIdPasswordPhysiotherapist();
                break;
            case 2:
                resetIdPasswordPatient();
                break;
            case 3:
                resetIdPasswordClinicManager();
                break;
            case 4:
                showOption();
                break;
            default:
                System.out.println("select correct option");
                showOption();
        }
    }
}
