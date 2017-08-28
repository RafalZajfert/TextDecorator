package software.rsquared.textdecorator;

import android.text.SpannableStringBuilder;
import android.text.style.UnderlineSpan;

/**
 * @author Rafal Zajfert
 */
class UnderlineTextDecorator extends SpanTextDecorator {

    /**
     * @see UnderlineSpan#UnderlineSpan()
     */
    public UnderlineTextDecorator() {
    }

    @Override
    void apply(SpannableStringBuilder builder, int start, int end) {
        apply(builder, start, end, new UnderlineSpan());
    }
}
