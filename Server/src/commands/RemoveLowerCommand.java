package commands;



import app.collection.City;
import collectionManager.Invoker;
import collectionManager.Receiver;
import collectionManager.RepositoryOfCity;
import exceptions.ArgumentException;

import java.util.TreeMap;

public class RemoveLowerCommand extends Command {


    private Receiver receiver;


    public RemoveLowerCommand(Receiver receiver) {
        setName("remove_lower");
        setDescription("удалить из коллекции элементы, меньшие, чем заданный");
        this.receiver = receiver;
    }


    @Override
    public void execute(TreeMap<String, Command> commandTreeMap, RepositoryOfCity repositoryOfCity,
                        Invoker commandManager, City city) {
            receiver.removeLower(repositoryOfCity,city);

    }
}
