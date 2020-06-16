package api;

import com.dins.test.model.Comment;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

import static matcher.CommentsListMatcher.everyCommentHasAllFieldsNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;

public class GetPostCommentsTest extends AbstractTest {
    @Test
    private void testPostComments() throws IOException {
        Response<List<Comment>> response = postsService.getPostComments(1).execute();
        Response<List<Comment>> response1 = postsService.getPostComments(1).execute();
        assertThat(response.code(), equalTo(200));

        List<Comment> commentsList = response.body();
        assertThat(commentsList, notNullValue());
        assertThat(commentsList, hasSize(5));
        assertThat(commentsList, everyCommentHasAllFieldsNotNull());
        assertThat(commentsList, equalTo(response1.body()));
    }

}
