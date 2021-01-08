package oop.bai_tap;

public class StopWatch {
    private long startTime;
    private long endTime;
    public StopWatch() {
        startTime=System.currentTimeMillis();
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }
    public void startTime(){
        startTime=System.currentTimeMillis();
    }
    public void endTime(){
        endTime=System.currentTimeMillis();
    }
    public long getElapsedTime(){
        return endTime-startTime;
    }
}

