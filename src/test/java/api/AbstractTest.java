package api;

import com.dins.test.service.CommentService;
import com.dins.test.service.PostsService;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.testng.annotations.BeforeMethod;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.time.Duration;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;

@Slf4j
public abstract class AbstractTest {

    PostsService postsService;
    CommentService commentService;

    @BeforeMethod
    public void setUp() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(new OkHttpClient.Builder()
                                .addInterceptor(new HttpLoggingInterceptor(log::info).setLevel(BODY))
                                .callTimeout(Duration.ofSeconds(30))
                                .connectTimeout(Duration.ofSeconds(30))
                                .readTimeout(Duration.ofSeconds(30))
                                .build())
                .build();
        postsService = retrofit.create(PostsService.class);
        commentService = retrofit.create(CommentService.class);

    }


}
