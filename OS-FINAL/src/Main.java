import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        int quantum  = 3;
        int passedTime=0;

        Process p1 = new Process("p1",0,0,2);
        Process p2 = new Process("p2",3,0,4);
        Process p3 = new Process("p3",4,0,5);
        Process p4 = new Process("p4",5,0,3);
        ArrayList<Process> processes = new ArrayList<>();
        processes.add(p2);
        processes.add(p1);
        processes.add(p3);
        processes.add(p4);

        Collections.sort(processes);

        RoundRobin rr = new RoundRobin();
        // cal the function for output
        rr.roundRobin(processes, quantum);









//        while (checkDone(processes)){
////            List<Process> arrivedProcesses= new ArrayList<>();
////            List<Process> toRemove= new ArrayList<>();
////            for (Process ap :
////                    processes) {
////
////
////            }
//            for (Process p :
//                    processes) {
//
//                if (p.remainingTime!=0){
//                    if (p.startTime>=passedTime){
//
//                    System.out.println(p.name + " " + passedTime);
//                        if (p.remainingTime > quantum) {
//                            p.remainingTime -= quantum;
//                            passedTime += quantum;
//                        } else {
//                            passedTime += p.remainingTime;
//                            p.remainingTime = 0;
//                        }
//                    }
//                    else {
//                        passedTime = p.startTime-passedTime;
//                    }
//                }
//
//                else continue;
//
//            }
//        }
//
//
//
//
//
//
//    }
//
//    static boolean checkDone(List<Process> processes){
//        for (Process p :
//                processes) {
//            if (p.remainingTime!=0){
//                return false;
//            }
//
//        }
//        return true;
    }

}


