package Commands;

import Interfaced.Command;
import Services.RepostService;

public class ReportCommand implements Command {

    private RepostService service;
    private String reportName;

    public ReportCommand(RepostService service,String name){
        this.service=service;
        this.reportName=name;
    }

    @Override
    public void execute() {
        service.generateGenerate(reportName);
    }
}
