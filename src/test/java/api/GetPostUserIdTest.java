package api;

import com.dins.test.model.Post;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

import static matcher.PostListMatcher.everyCommentHasAllFieldsNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetPostUserIdTest extends AbstractTest {
    @Test
    private void testPostUserId() throws IOException {
        Response<List<Post>> response = postsService.getPosts(1).execute();
        Response<List<Post>> response1 = postsService.getPosts(1).execute();
        assertThat(response.code(), equalTo(200));
        List<Post> postList = response.body();

        assertThat(postList, notNullValue());
        assertThat(postList, everyCommentHasAllFieldsNotNull());

        assertThat(postList, equalTo(response1.body()));

    }

}
