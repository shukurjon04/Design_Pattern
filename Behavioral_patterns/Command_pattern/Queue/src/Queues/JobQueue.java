package Queues;

import Interfaced.Command;

import java.util.LinkedList;
import java.util.Queue;

public class JobQueue {
    private Queue<Command> commands = new LinkedList<>();

    public void addJob(Command command){
        commands.add(command);
    }

    public void processJob(){
        while(!commands.isEmpty()){
            Command command = commands.poll();
            command.execute();
        }
    }
}
