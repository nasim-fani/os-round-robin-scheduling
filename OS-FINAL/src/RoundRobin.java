import java.util.ArrayList;
import java.util.List;

// Java program to implement Round Robin 
// Scheduling with different arrival time 
class RoundRobin {
    public void roundRobin(List<Process> processes, int q) {

        // for sequence storage
        String seq = new String();


        List<Process> copyOfProcesses = new ArrayList<>();
        for (Process p :
                processes) {
            copyOfProcesses.add(new Process(p.name, p.startTime, p.memorySize, p.burstTime));
        }
        int t = 0;
        while (true) {
            boolean flag = true;
            for (int i = 0; i < processes.size(); i++) {

                // these condition for if 
                // arrival is not on zero 

                // check that if there come before qtime 
                if (copyOfProcesses.get(i).startTime <= t) {
                    if (copyOfProcesses.get(i).startTime <= q) {
                        if (copyOfProcesses.get(i).burstTime > 0) {
                            flag = false;
                            if (copyOfProcesses.get(i).burstTime > q) {

                                // make decrease the b time 
                                t = t + q;
                                copyOfProcesses.get(i).burstTime -= q;
                                copyOfProcesses.get(i).startTime += q;
                                seq += "->" + copyOfProcesses.get(i).name;
                            } else {

                                // for last time 
                                t +=  copyOfProcesses.get(i).burstTime;

                                copyOfProcesses.get(i).burstTime = 0;

                                // add sequence
                                seq += "->" + copyOfProcesses.get(i).name;
                            }
                        }
                    } else if (copyOfProcesses.get(i).startTime > q) {

                        // is any have less arrival time 
                        // the coming process then execute them 
                        for (int j = 0; j < processes.size(); j++) {

                            // compare 
                            if (copyOfProcesses.get(j).burstTime < copyOfProcesses.get(i).burstTime) {
                                if (copyOfProcesses.get(j).burstTime > 0) {
                                    flag = false;
                                    if (copyOfProcesses.get(j).burstTime > q) {
                                        t = t + q;
                                        copyOfProcesses.get(j).burstTime -= q;
                                        copyOfProcesses.get(j).startTime += q;
                                        seq += "->" + copyOfProcesses.get(j).name;
                                    } else {
                                        t += copyOfProcesses.get(j).burstTime;
                                        copyOfProcesses.get(j).burstTime = 0;
                                        seq += "->" + copyOfProcesses.get(j).name;
                                    }
                                }
                            }
                        }

                        // now the previous porcess according to 
                        // ith is process 
                        if (copyOfProcesses.get(i).burstTime > 0) {
                            flag = false;

                            // Check for greaters 
                            if (copyOfProcesses.get(i).burstTime > q) {
                                t += q;
                                copyOfProcesses.get(i).burstTime -= q;
                                copyOfProcesses.get(i).startTime += q;
                                seq += "->" + copyOfProcesses.get(i).name;
                            } else {
                                t += copyOfProcesses.get(i).burstTime;
                                copyOfProcesses.get(i).burstTime = 0;
                                seq += "->" + copyOfProcesses.get(i).name;
                            }
                        }
                    }
                }

                // if no process is come on thse critical 
                else if (copyOfProcesses.get(i).startTime > t) {
                    t++;
                    i--;
                }
            }
            // for exit the while loop 
            if (flag) {
                break;
            }
        }
        System.out.println("Sequence is like that " + seq);
    }

    // Driver Code
    public static void main(String args[]) {
    }
} 
