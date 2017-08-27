package software.rsquared.textdecorator;

import android.graphics.BlurMaskFilter;
import android.text.SpannableStringBuilder;
import android.text.style.MaskFilterSpan;

/**
 * @author Rafal Zajfert
 */
class BlurStyle extends SpanStyle {

    private final float radius;
    private final BlurMaskFilter.Blur style;

    /**
     * @see BlurMaskFilter#BlurMaskFilter(float, BlurMaskFilter.Blur)
     */
    BlurStyle(float radius, BlurMaskFilter.Blur style) {
        this.radius = radius;
        this.style = style;
    }

    @Override
    void apply(SpannableStringBuilder builder, int start, int end) {
        apply(builder, start, end, new MaskFilterSpan(new BlurMaskFilter(radius, style)));
    }
}
