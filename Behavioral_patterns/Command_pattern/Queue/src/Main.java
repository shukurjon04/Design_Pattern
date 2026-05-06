import Commands.EmailCommand;
import Commands.ReportCommand;
import Queues.JobQueue;
import Queues.Worker;
import Services.EmailService;
import Services.RepostService;

public class Main {

    public static void main(String[] args) {

        EmailService emailService = new EmailService();
        RepostService reportService = new RepostService();

        JobQueue queue = new JobQueue();

        // JOBLAR YARATILDI (COMMANDS)
        queue.addJob(new EmailCommand(emailService, "user@gmail.com"));
        queue.addJob(new ReportCommand(reportService, "Daily Sales"));
        queue.addJob(new EmailCommand(emailService, "admin@gmail.com"));

        // WORKER ishga tushdi
        Worker worker = new Worker(queue);
        worker.start();
    }
}