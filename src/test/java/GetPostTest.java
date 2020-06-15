import com.dins.test.model.Post;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetPostTest extends AbstractTest {


    @Test
    public void testPost() throws IOException {
        int i = 1 + (int) (Math.random() * 100);
        Response<Post> response = postsService.getPost(i).execute();
        assertThat(response.code(), equalTo(200));
        assertThat(response.body(), notNullValue());

        System.out.println(i);
        System.out.println(response.body());

    }

}
