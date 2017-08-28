package software.rsquared.textdecorator;

import android.text.SpannableStringBuilder;
import android.text.style.SubscriptSpan;

/**
 * @author Rafal Zajfert
 */
class SubscriptTextDecorator extends SpanTextDecorator {

    /**
     * @see SubscriptSpan#SubscriptSpan()
     */
    SubscriptTextDecorator() {
    }

    @Override
    void apply(SpannableStringBuilder builder, int start, int end) {
        apply(builder, start, end, new SubscriptSpan());

    }
}
