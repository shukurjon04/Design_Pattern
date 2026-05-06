package Commands;

import Interfaced.Command;
import Services.EmailService;

public class EmailCommand implements Command {

    private EmailService emailService;
    private String to;

    public EmailCommand(EmailService service,String to) {
         this.emailService=service;
         this.to=to;
    }

    @Override
    public void execute() {
        emailService.sendEmail(to);
    }
}
