package matcher;

import com.dins.test.model.Comment;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hamcrest.Matcher;

import static matcher.CommentMatcher.hasAllFieldsNotNull;
import static org.hamcrest.Matchers.everyItem;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentsListMatcher {

    public static Matcher<Iterable<Comment>> everyCommentHasAllFieldsNotNull() {
        return everyItem(hasAllFieldsNotNull());
    }

}
