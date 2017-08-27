package software.rsquared.textdecorator;

import android.text.SpannableStringBuilder;
import android.text.style.StrikethroughSpan;

/**
 * @author Rafal Zajfert
 */
class StrikethroughStyle extends SpanStyle {

    /**
     * @see StrikethroughSpan#StrikethroughSpan()
     */
    public StrikethroughStyle() {
    }

    @Override
    void apply(SpannableStringBuilder builder, int start, int end) {
        apply(builder, start, end, new StrikethroughSpan());
    }
}
