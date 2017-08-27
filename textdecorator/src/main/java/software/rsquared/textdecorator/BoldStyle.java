package software.rsquared.textdecorator;

import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;

/**
 * @author Rafal Zajfert
 */
class BoldStyle extends SpanStyle {

    /**
     * @see Typeface#BOLD
     */
    public BoldStyle() {
    }

    @Override
    void apply(SpannableStringBuilder builder, int start, int end) {
        apply(builder, start, end, new StyleSpan(Typeface.BOLD));
    }
}
