package software.rsquared.textdecorator;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;

/**
 * @author Rafal Zajfert
 */
class SizeTextDecorator extends SpanTextDecorator {

    private final Integer size;
    private final boolean dip;
    private final Float proportion;


    /**
     * @see AbsoluteSizeSpan#AbsoluteSizeSpan(int)
     */
    SizeTextDecorator(int size) {
        this(size, true);
    }

    /**
     * @see AbsoluteSizeSpan#AbsoluteSizeSpan(int, boolean)
     */
    SizeTextDecorator(int size, boolean dip) {
        this.size = size;
        this.dip = dip;
        this.proportion = null;
    }

    /**
     * @see RelativeSizeSpan#RelativeSizeSpan(float)
     */
    SizeTextDecorator(float proportion) {
        this.size = null;
        this.dip = false;
        this.proportion = proportion;
    }

    @Override
    void apply(SpannableStringBuilder builder, int start, int end) {
        if (proportion != null) {
            apply(builder, start, end, new RelativeSizeSpan(proportion));
        } else if (size != null) {
            apply(builder, start, end, new AbsoluteSizeSpan(size, dip));
        }
    }
}
