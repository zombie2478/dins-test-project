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

public class GetCommentsPostIdTest extends AbstractTest {
    @Test
    private void testCommentPostId() throws IOException {
        Response<List<Comment>> response = commentService.getComments(1).execute();
        assertThat(response.code(), equalTo(200));

        List<Comment> commentsList = response.body();
        assertThat(commentsList, notNullValue());
        assertThat(commentsList, hasSize(5));
        assertThat(commentsList, everyCommentHasAllFieldsNotNull());
    }

}
