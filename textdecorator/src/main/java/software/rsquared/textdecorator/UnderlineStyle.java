package software.rsquared.textdecorator;

import android.text.SpannableStringBuilder;
import android.text.style.UnderlineSpan;

/**
 * @author Rafal Zajfert
 */
class UnderlineStyle extends SpanStyle {

    /**
     * @see UnderlineSpan#UnderlineSpan()
     */
    public UnderlineStyle() {
    }

    @Override
    void apply(SpannableStringBuilder builder, int start, int end) {
        apply(builder, start, end, new UnderlineSpan());
    }
}
