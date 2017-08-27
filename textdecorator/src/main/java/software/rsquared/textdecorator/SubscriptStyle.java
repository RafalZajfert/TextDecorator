package software.rsquared.textdecorator;

import android.text.SpannableStringBuilder;
import android.text.style.SubscriptSpan;

/**
 * @author Rafal Zajfert
 */
class SubscriptStyle extends SpanStyle {

    /**
     * @see SubscriptSpan#SubscriptSpan()
     */
    SubscriptStyle() {
    }

    @Override
    void apply(SpannableStringBuilder builder, int start, int end) {
        apply(builder, start, end, new SubscriptSpan());

    }
}
