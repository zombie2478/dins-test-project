import com.dins.test.service.CommentService;
import com.dins.test.service.PostsService;
import org.testng.annotations.BeforeMethod;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public abstract class AbstractTest {

    PostsService postsService;
    private CommentService commentService;

    @BeforeMethod
    public void setUp() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        postsService = retrofit.create(PostsService.class);
        commentService = retrofit.create(CommentService.class);

    }


}
