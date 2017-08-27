package software.rsquared.textdecorator;

import android.support.annotation.NonNull;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.widget.TextView;


/**
 * @author Rafal Zajfert
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public abstract class Text implements Spannable {

    public static Text create() {
        return create("");
    }

    public static Text create(CharSequence text) {
        return create(text, new Style[]{});
    }

    public static Text create(CharSequence text, Style... styles) {
        return new DecoratedText(text, styles);
    }

    public abstract Text append(CharSequence text);

    public abstract Text append(CharSequence text, Style... styles);

    private static class DecoratedText extends Text {

        SpannableStringBuilder builder = new SpannableStringBuilder();

        private DecoratedText(CharSequence text, Style[] styles) {
            append(text, styles);
        }

        @Override
        public Text append(CharSequence text) {
            return append(text, new Style[]{});
        }

        @Override
        public Text append(CharSequence text, Style... styles) {
            int start = builder.length();
            builder.append(text);
            for (Style style : styles) {
                style.apply(builder, start, start + text.length());
            }
            return this;
        }

        @Override
        public int length() {
            return builder.length();
        }

        @Override
        public char charAt(int index) {
            return builder.charAt(index);
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            return builder.subSequence(start, end);
        }

        @Override
        public void setSpan(Object what, int start, int end, int flags) {
            builder.setSpan(what, start, end, flags);
        }

        @Override
        public void removeSpan(Object what) {
            builder.removeSpan(what);
        }

        @Override
        public <T> T[] getSpans(int start, int end, Class<T> type) {
            return builder.getSpans(start, end, type);
        }

        @Override
        public int getSpanStart(Object tag) {
            return builder.getSpanStart(tag);
        }

        @Override
        public int getSpanEnd(Object tag) {
            return builder.getSpanEnd(tag);
        }

        @Override
        public int getSpanFlags(Object tag) {
            return builder.getSpanFlags(tag);
        }

        @Override
        public int nextSpanTransition(int start, int limit, Class type) {
            return builder.nextSpanTransition(start, limit, type);
        }

        @NonNull
        @Override
        public String toString() {
            return builder.toString();
        }
    }


//    Text.apply("asd").apply(Text.apply("asd", TextStyle.bold(), TextStyle.italic()), TextStyle.color(R.color.red_300))


}
