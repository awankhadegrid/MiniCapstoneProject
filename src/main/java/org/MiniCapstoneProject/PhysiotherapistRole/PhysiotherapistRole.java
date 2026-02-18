package org.MiniCapstoneProject.PhysiotherapistRole;

import java.util.*;

import static org.MiniCapstoneProject.Clinic_ManagerRole.ClinicManagerRole.patientData;

public class PhysiotherapistRole {

    static String userIdDefault="Physio";
    static String passwordDefault="Physio@123";
    static Scanner sc=new Scanner(System.in);


    public static void PhysiotherapistWelcomeMessage(){
        System.out.println("*******--welcome to PhysioTrack--********");
        System.out.println("Role = Physiotherapist");
        System.out.println("Please enter your userId");
        String userId=sc.nextLine();
        System.out.println("Please enter your password");
        String password=sc.nextLine();
        if(userIdDefault.equals(userId) && passwordDefault.equals(password)){
                physioOptions();
        }else {
            System.out.println("UserId and Password wrong try again");

        }


    }



    public static void resetIdPasswordPhysiotherapist(){
        System.out.println("enter updated userId: ");
        String userId=sc.nextLine();
        System.out.println("enter updated password: ");
        String pass=sc.nextLine();
        userIdDefault=userId;
        passwordDefault=pass;

    }

    public static void physioOptions(){
        System.out.println("1. add therapy to patient \t 2. see all patient with there plans \t 3.exit");
        int option=sc.nextInt();
        sc.nextLine();

        switch (option){
            case 1:
                addTherapy();
                break;
            case 2:
                allList(patientData);
                break;
            case 3:
                return;
            default:
                System.out.println("please select correct option");
                physioOptions();
        }


//        showPatientList();
//        System.out.println("select Patient");
//        int patientNo= sc.nextInt();
//        String patientName=getPatientById(patientNo);
//        addTherapy();
    }



    public static String getPatientById(int patientNumber ){
        List<String> patientName=new ArrayList<>(patientData.keySet());
        return patientName.get(patientNumber);
    }


    public static void addTherapy(){
        List<String> patientName=new ArrayList<>(patientData.keySet());

        for(int i=0;i<patientName.size();i++){
            System.out.println(i+1 +"-"+ patientName.get(i));
        }
        System.out.println("select patient ");
        int patientNumber=sc.nextInt();
        sc.nextLine();
        updateTherapy(patientNumber,patientName);



    }

    public static void updateTherapy(int id,List<String> patientName){
        String patientNameId=patientName.get(id-1);
        System.out.println("add how many therapy you want to add :");
        int therapyCount = sc.nextInt();
        sc.nextLine();
        List<String> therapyList = new ArrayList<>();
        System.out.println("add therapy : ");
        for(int i=1;i<=therapyCount;i++){
            System.out.print(i +":");
            String therapy = sc.nextLine();
            therapyList.add(therapy);
        }
        patientData.put(patientNameId,therapyList);
        physioOptions();
    }

    public static void allList(Map<String, List<String>> patientData){
        List<String> patientNames = new ArrayList<>(patientData.keySet());

        for (int i = 0; i < patientNames.size(); i++) {
            String name = patientNames.get(i);
            System.out.print(name +": ");
            List<String> therapies = patientData.get(name);

            for (int j = 0; j < therapies.size(); j++) {
                System.out.print("-" + therapies.get(j));
            }

            System.out.println();
        }
        physioOptions();

    }
}
