package software.rsquared.textdecorator;

import android.graphics.EmbossMaskFilter;
import android.text.SpannableStringBuilder;
import android.text.style.MaskFilterSpan;

/**
 * @author Rafal Zajfert
 */
class EmbossStyle extends SpanStyle {

    private final float[] direction;
    private final float ambient;
    private final float specular;
    private final float blurRadius;

    /**
     * @see EmbossMaskFilter#EmbossMaskFilter(float[], float, float, float)
     */
    EmbossStyle(float[] direction, float ambient, float specular, float blurRadius) {
        this.direction = direction;
        this.ambient = ambient;
        this.specular = specular;
        this.blurRadius = blurRadius;
    }

    @Override
    void apply(SpannableStringBuilder builder, int start, int end) {
        apply(builder, start, end, new MaskFilterSpan(new EmbossMaskFilter(direction, ambient, specular, blurRadius)));
    }
}
