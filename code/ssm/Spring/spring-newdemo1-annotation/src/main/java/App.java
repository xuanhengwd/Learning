import com.example.config.SpringConfig;
import com.example.dao.BookDao;
import com.example.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);


        BookDao bookDao = ctx.getBean(BookDao.class);
        bookDao.save();

        BookService bookService = ctx.getBean(BookService.class);
        bookService.save();
    }

}
