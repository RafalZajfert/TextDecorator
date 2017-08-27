package software.rsquared.textdecorator;

import android.text.SpannableStringBuilder;
import android.text.style.TypefaceSpan;

/**
 * @author Rafal Zajfert
 */
class TypefaceStyle extends SpanStyle {

    private final String typeface;

    /**
     * @see TypefaceSpan#TypefaceSpan(String)
     */
    TypefaceStyle(String typeface) {
        this.typeface = typeface;
    }

    @Override
    void apply(SpannableStringBuilder builder, int start, int end) {
        apply(builder, start, end, new TypefaceSpan(typeface));
    }
}
