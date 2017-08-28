package software.rsquared.textdecorator;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;

/**
 * @author Rafal Zajfert
 */
class BackgroundColorTextDecorator extends SpanTextDecorator {

    @ColorInt
    private final int color;

    /**
     * @see BackgroundColorSpan#BackgroundColorSpan(int)
     */
    BackgroundColorTextDecorator(@ColorInt int color) {
        this.color = color;
    }

    /**
     * @see BackgroundColorSpan#BackgroundColorSpan(int)
     */
    BackgroundColorTextDecorator(Context context, @ColorRes int color) {
        this.color = ContextCompat.getColor(context, color);
    }

    @Override
    void apply(SpannableStringBuilder builder, int start, int end) {
        apply(builder, start, end, new BackgroundColorSpan(color));
    }
}
