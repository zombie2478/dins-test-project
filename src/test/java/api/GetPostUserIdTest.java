package api;

import com.dins.test.model.Post;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.notNullValue;

public class GetPostUserIdTest extends AbstractTest {
    @Test
    private void testPostUserId() throws IOException {
        Response<List<Post>> response = postsService.getPosts(1).execute();
        assertThat(response.code(), equalTo(200));
        List<Post> postList = response.body();

        assertThat(postList, notNullValue());
        assertThat(postList, everyItem(allOf(hasProperty("userId", notNullValue()),
                                             hasProperty("id", notNullValue()),
                                             hasProperty("title", notNullValue()),
                                             hasProperty("body", notNullValue())
        )));
    }

}
