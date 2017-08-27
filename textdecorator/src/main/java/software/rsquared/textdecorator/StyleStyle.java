package software.rsquared.textdecorator;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.StyleRes;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;

/**
 * @author Rafal Zajfert
 */
class StyleStyle extends SpanStyle {

    private Context context;
    private final int appearance;
    private final int colorList;
    private final String family;
    private final int style;
    private final int size;
    private final ColorStateList color;
    private final ColorStateList linkColor;

    /**
     * @see TextAppearanceSpan#TextAppearanceSpan(Context, int)
     */
    StyleStyle(Context context, @StyleRes int appearance) {
        this(context, appearance, -1);
    }

    /**
     * @see TextAppearanceSpan#TextAppearanceSpan(Context, int, int)
     */
    StyleStyle(Context context, @StyleRes int appearance, int colorList) {
        this.context = context;
        this.appearance = appearance;
        this.colorList = colorList;
        this.family = null;
        this.style = -1;
        this.size = -1;
        this.color = null;
        this.linkColor = null;
    }

    /**
     * @see TextAppearanceSpan#TextAppearanceSpan(String, int, int, ColorStateList, ColorStateList)
     */
    StyleStyle(String family, int style, int size, ColorStateList color, ColorStateList linkColor) {
        this.appearance = -1;
        this.colorList = -1;
        this.family = family;
        this.style = style;
        this.size = size;
        this.color = color;
        this.linkColor = linkColor;
    }

    @Override
    void apply(SpannableStringBuilder builder, int start, int end) {
        if (family != null) {
            apply(builder, start, end, new TextAppearanceSpan(family, style, size, color, linkColor));
        } else {
            apply(builder, start, end, new TextAppearanceSpan(context, appearance, colorList));
        }
    }
}
