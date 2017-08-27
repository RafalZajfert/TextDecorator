package software.rsquared.textdecorator;

import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;

/**
 * @author Rafal Zajfert
 */
class ItalicStyle extends SpanStyle {


    /**
     * @see Typeface#ITALIC
     */
    ItalicStyle() {
    }

    @Override
    void apply(SpannableStringBuilder builder, int start, int end) {
        apply(builder, start, end, new StyleSpan(Typeface.ITALIC));
    }
}
