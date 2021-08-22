import java.util.Comparator;

public class Process implements Comparable<Process> {
    String name;
    int startTime;
    int memorySize;
    int burstTime;
    int remainingTime;

    public Process(String name, int startTime, int memorySize, int burstTime) {
        this.name = name;
        this.startTime = startTime;
        this.memorySize = memorySize;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
    }


    @Override
    public int compareTo(Process o) {

        return Integer.compare(this.startTime, o.startTime);
    }
}
