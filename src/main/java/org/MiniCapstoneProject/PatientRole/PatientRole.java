package org.MiniCapstoneProject.PatientRole;

import java.util.List;
import java.util.Scanner;

import static org.MiniCapstoneProject.Clinic_ManagerRole.ClinicManagerRole.patientData;

public class PatientRole {
    static Scanner sc=new Scanner(System.in);
    static String userIdDefault="Patient";
    static String passwordDefault="Patient@123";

    public static void patientWelcomeMessage(){
        System.out.println("*******--welcome to PhysioTrack--********");
        System.out.println("Role = Patient");
        System.out.println("Please enter your userId");
        String userId=sc.nextLine();
        System.out.println("Please enter your password");
        String password=sc.nextLine();

        if(userId.equals(userIdDefault) && password.equals(passwordDefault)){
            viewTherapy();
        }else {
            System.out.println("your userId and PassWord is wrong try again");
            patientWelcomeMessage();
        }
    }

    public static void viewTherapy(){
        System.out.println("1. view your therapy \t 2. exit");
        int option = sc.nextInt();
        sc.nextLine();
        switch (option){
            case 1:
                viewYourTherapy();
                break;
            case 2:
                patientWelcomeMessage();
            default:
                System.out.println("please select correct option");
                viewTherapy();

        }
    }

    public static void viewYourTherapy(){
        System.out.println("enter your name : ");
        String name = sc.nextLine();
        List<String> therapy = patientData.get(name);

        System.out.print("Patient Name : "+name);
        for(int i=0;i<therapy.size();i++){
            System.out.println(therapy.get(i)+" , ");
        }
        viewTherapy();

    }

    public static void resetIdPasswordPatient(){
        System.out.println("enter updated userId: ");
        String userId=sc.nextLine();
        System.out.println("enter updated password: ");
        String pass=sc.nextLine();
        userIdDefault=userId;
        passwordDefault=pass;
        System.out.println("credential is updated for the patient role");

    }




}
