package api;

import com.dins.test.model.Post;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class GetPostTest extends AbstractTest {
    @Test
    public void testPost() throws IOException {
        int postId = new Random().nextInt(100) + 1;
        Response<Post> response = postsService.getPost(postId).execute();

        assertThat(response.code(), equalTo(200));
        assertThat(response.body(), notNullValue());
    }

}
