package org.MiniCapstoneProject;


import org.MiniCapstoneProject.AdminRole.AdminRole;
import org.MiniCapstoneProject.Clinic_ManagerRole.ClinicManagerRole;
import org.MiniCapstoneProject.PatientRole.PatientRole;
import org.MiniCapstoneProject.PhysiotherapistRole.PhysiotherapistRole;

import java.util.Scanner;



/**
 * PhysioTrack
 *
 */
public class App 
{

    public static enum Role{
        Admin,
        Physiotherapist,
        Patient,
        Clinic_Manager
    }

    public static void welcomeMessage(){
        System.out.println("*******--welcome to PhysioTrack--********");
        System.out.println("please select your role");
        System.out.println("1.Admin \t 2.Physiotherapist \t 3.Patient \t 4.Clinic_Manager \t 5.exit");

    }

    public static String selectRole(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Number as per your role");
        int roleNum=sc.nextInt();
        sc.nextLine();
        String selectedRole="";
        switch (roleNum){
            case 1:
                 selectedRole= Role.Admin.toString();
                 break;

            case 2:
                  selectedRole=Role.Physiotherapist.toString();
                  break;

            case 3:
                  selectedRole=Role.Patient.toString();
                  break;

            case 4:
                  selectedRole=Role.Clinic_Manager.toString();
                  break;
            case 5:
                return "exit";

            default:
                System.out.println("Please add correct role number");

        }
        return selectedRole;

    }



    public static void main( String[] args )
    {
        while (true) {


            welcomeMessage();
            String role = selectRole();
            switch (role) {
                case "Admin":
                    AdminRole.adminWelcomeMessage();
                    break;
                case "Physiotherapist":
                    PhysiotherapistRole.PhysiotherapistWelcomeMessage();
                    break;
                case "Patient":
                    PatientRole.patientWelcomeMessage();
                    break;
                case "Clinic_Manager":
                    ClinicManagerRole.clinicManagerWelcomeMessage();
                    break;
                case "exit":
                    return;
                default:
                    selectRole();
            }
        }
    }
}
