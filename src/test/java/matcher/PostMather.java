package matcher;


import com.dins.test.model.Comment;
import com.dins.test.model.Post;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hamcrest.Matcher;

import static org.hamcrest.Matchers.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class PostMather {
    public static Matcher<Post> hasAllFieldsNotNull() {
        return allOf(hasProperty("userId", notNullValue()),
                     hasProperty("id", notNullValue()),
                     hasProperty("title", notNullValue()),
                     hasProperty("body", notNullValue()));
    }
}
