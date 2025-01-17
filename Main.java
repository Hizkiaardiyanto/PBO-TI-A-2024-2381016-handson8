import Views.TodoListTerminalView;
import Views.TodoListView;
import config.Database;
import repositories.TodoListRepository;
import repositories.TodoListRepositoryDbImpl;
import services.TodoListService;
import services.TodoListServiceImpl;

public class Main {
    public static void main(String[] args) {

        Database database = new Database("my_database", "root", "", "localhost", "3306");
        database.setup();

        TodoListRepository todoListRepository = new TodoListRepositoryDbImpl(database);
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListTerminalView(todoListService);
        todoListView.run();
    }
}
