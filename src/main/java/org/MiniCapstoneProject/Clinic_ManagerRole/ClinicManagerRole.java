package org.MiniCapstoneProject.Clinic_ManagerRole;

import org.MiniCapstoneProject.App;

import java.util.*;

public class ClinicManagerRole {

    static Scanner sc=new Scanner(System.in);

    static String userIdDefault="Clinic";
    static String passwordDefault="Clinic@123";

    public static void clinicManagerWelcomeMessage(){
        System.out.println("*******--welcome to PhysioTrack--********");
        System.out.println("Role = ClinicManager");
        System.out.println("Please enter your userId");
        String userId=sc.nextLine();
        System.out.println("Please enter your password");
        String password=sc.nextLine();
        if(userIdDefault.equals(userId)){
            if(passwordDefault.equals(password)){
                showOption();
            }
        }
    }


    public static void showOption(){
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register Patient \t 2. View all patient \t 3. exit");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option){
                case 1:
                    patientRegistration();
                    break;

                case 2:
                    showPatientList();
                    break;

                case 3:
                    return;

                default:
                    System.out.println("select correct option");
            }
        }
    }


    public static Map<String,List<String>> patientData=new HashMap<>();

    public static void patientRegistration(){
        System.out.println("enter full name of patient: ");
        Scanner sc=new Scanner(System.in);
        String name = sc.nextLine();

        patientData.put(name,new ArrayList<>());

    }

    public static void showPatientList(){
        List<String> patientName=new ArrayList<>(patientData.keySet());
        for(int i=0;i<patientName.size();i++){
            System.out.println(i+1+"-"+patientName.get(i));
        }
    }


    public static void resetIdPasswordClinicManager(){
        System.out.println("enter updated userId: ");
        String userId=sc.nextLine();
        System.out.println("enter updated password: ");
        String pass=sc.nextLine();
        userIdDefault=userId;
        passwordDefault=pass;
        System.out.println("credential is updated for the Clinic Manager");

    }

}
