package software.rsquared.textdecorator;

import android.text.SpannableStringBuilder;
import android.text.style.SuperscriptSpan;

/**
 * @author Rafal Zajfert
 */
class SuperscriptStyle extends SpanStyle {

    /**
     * @see SuperscriptSpan#SuperscriptSpan()
     */
    SuperscriptStyle() {
    }

    @Override
    void apply(SpannableStringBuilder builder, int start, int end) {
        apply(builder, start, end, new SuperscriptSpan());
    }
}
