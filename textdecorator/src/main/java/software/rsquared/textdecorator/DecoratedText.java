package software.rsquared.textdecorator;

import android.support.annotation.NonNull;
import android.text.Spannable;
import android.text.SpannableStringBuilder;

/**
 * @author Rafal Zajfert
 */
public class DecoratedText extends Text {

    SpannableStringBuilder builder = new SpannableStringBuilder();

    DecoratedText(CharSequence text, TextDecoratorBuilder builder) {
        append(text, builder);
    }


}
