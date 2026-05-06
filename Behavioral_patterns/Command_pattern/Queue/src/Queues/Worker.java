package Queues;

public class Worker {
    private JobQueue jobQueue;

    public Worker(JobQueue queue){
        this.jobQueue=queue;
    }

    public void start(){
        jobQueue.processJob();
    }
}
