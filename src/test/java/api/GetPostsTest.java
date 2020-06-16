package api;

import com.dins.test.model.Post;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

import static matcher.PostListMatcher.everyCommentHasAllFieldsNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;

public class GetPostsTest extends AbstractTest {
    @Test
    public void testPosts() throws IOException {
        Response<List<Post>> response = postsService.getPosts().execute();
        Response<List<Post>> response1 = postsService.getPosts().execute();
        assertThat(response.code(), equalTo(200));

        List<Post> postList = response.body();

        assertThat(postList, notNullValue());
        assertThat(postList, hasSize(100));
        assertThat(postList, everyCommentHasAllFieldsNotNull());

        assertThat(postList, equalTo(response1.body()));
    }


}
