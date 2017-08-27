package software.rsquared.textdecorator;

import android.text.SpannableStringBuilder;
import android.text.style.ScaleXSpan;

/**
 * @author Rafal Zajfert
 */
class ScaleXStyle extends SpanStyle {

    private final float proportion;

    /**
     * @see ScaleXSpan#ScaleXSpan(float)
     */
    ScaleXStyle(float proportion) {
        this.proportion = proportion;
    }

    @Override
    void apply(SpannableStringBuilder builder, int start, int end) {
        apply(builder, start, end, new ScaleXSpan(proportion));
    }
}
