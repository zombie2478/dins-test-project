package matcher;

import com.dins.test.model.Comment;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hamcrest.Matcher;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.notNullValue;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentMatcher {

    public static Matcher<Comment> hasAllFieldsNotNull() {
        return allOf(hasProperty("postId", notNullValue()),
                     hasProperty("id", notNullValue()),
                     hasProperty("name", notNullValue()),
                     hasProperty("email", notNullValue()),
                     hasProperty("body", notNullValue()));
    }

}
