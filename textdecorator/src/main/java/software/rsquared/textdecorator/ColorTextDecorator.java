package software.rsquared.textdecorator;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

/**
 * @author Rafal Zajfert
 */
class ColorTextDecorator extends SpanTextDecorator {

    @ColorInt
    private final int color;

    /**
     * @see ForegroundColorSpan#ForegroundColorSpan(int)
     */
    ColorTextDecorator(@ColorInt int color) {
        this.color = color;
    }

    /**
     * @see ForegroundColorSpan#ForegroundColorSpan(int)
     */
    ColorTextDecorator(Context context, @ColorRes int color) {
        this.color = ContextCompat.getColor(context, color);
    }

    @Override
    void apply(SpannableStringBuilder builder, int start, int end) {
        apply(builder, start, end, new ForegroundColorSpan(color));
    }
}
