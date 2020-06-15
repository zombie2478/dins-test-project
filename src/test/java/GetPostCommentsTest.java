import com.dins.test.model.Comment;
import com.dins.test.model.Post;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetPostCommentsTest extends AbstractTest {
    @Test
    private void testPostComments() throws IOException {
        Response<List<Comment>> response = postsService.getPostComments(1).execute();
        assertThat(response.code(), equalTo(200));

        List<Comment> commentsList = response.body();
        assertThat(commentsList, notNullValue());
        assertThat(commentsList, hasSize(5));
        assertThat(commentsList, everyItem(allOf(hasProperty("postId", notNullValue()),
                hasProperty("id", notNullValue()),
                hasProperty("name", notNullValue()),
                hasProperty("email", notNullValue()),
                hasProperty("body", notNullValue())
        )));
        //System.out.println(response.body());
    }
}
