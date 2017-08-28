package software.rsquared.textdecorator;

import android.text.Spannable;
import android.text.SpannableStringBuilder;

/**
 * @author Rafal Zajfert
 */
abstract class SpanTextDecorator extends TextDecorator {

    void apply(SpannableStringBuilder builder, int start, int end, Object style) {
        if (style != null) {
            builder.setSpan(style, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

}
