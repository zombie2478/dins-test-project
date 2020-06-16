package matcher;

import com.dins.test.model.Comment;
import com.dins.test.model.Post;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static matcher.PostMather.hasAllFieldsNotNull;
import static org.hamcrest.Matchers.everyItem;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostListMatcher {
    public static Matcher<Iterable<Post>> everyCommentHasAllFieldsNotNull(){
        return everyItem(hasAllFieldsNotNull());
    }
}
