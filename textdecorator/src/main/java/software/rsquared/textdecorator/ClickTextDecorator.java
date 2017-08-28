package software.rsquared.textdecorator;

import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

/**
 * @author Rafal Zajfert
 */
class ClickTextDecorator extends SpanTextDecorator {

    private final View.OnClickListener listener;

    /**
     * NOTE: Movement method is needed: {@link TextView#setMovementMethod(MovementMethod) TextView.setMovementMethod(LinkMovementMethod.getInstance())}
     *
     * @see ClickableSpan#ClickableSpan()
     */
    ClickTextDecorator(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    void apply(SpannableStringBuilder builder, int start, int end) {
        apply(builder, start, end, new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                listener.onClick(widget);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
            }
        });
    }
}
