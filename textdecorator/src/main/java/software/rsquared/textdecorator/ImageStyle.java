package software.rsquared.textdecorator;

import android.text.SpannableStringBuilder;

/**
 * @author Rafal Zajfert
 */
@Deprecated
class ImageStyle extends SpanStyle {


    @Override
    void apply(SpannableStringBuilder builder, int start, int end) {
//        apply(builder, start, end, new );
    }

//
//    public SpannableImage(Drawable drawable, int verticalAlignment) {
//        appendStyled(" ", new ImageSpan(drawable, verticalAlignment));
//    }
//
//
//    /**
//     * <b>Note:</b> drawable height cannot be greater then line height!
//     */
//    public SpannableImage(Drawable drawable) {
//        appendImage(drawable, DynamicDrawableSpan.ALIGN_BOTTOM);
//    }
//
//    /**
//     * <b>Note:</b> drawable height cannot be greater then line height!
//     */
//    public SpannableImage(@DrawableRes int drawableId) {
//        appendImage(getDrawable(drawableId));
//    }
//
//    /**
//     * <b>Note:</b> height cannot be greater then line height!
//     */
//    public SpannableImage(@DrawableRes int drawableId, int width, int height) {
//        appendImage(getDrawable(drawableId, new Rect(0, 0, width, height)));
//    }
//
//    /**
//     * <b>Note:</b> height cannot be greater then line height!
//     */
//    public SpannableImage(@DrawableRes int drawableId, int width, int height, boolean dp) {
//        float density = dp ? getContext().getResources().getDisplayMetrics().density : 1;
//        appendImage(getDrawable(drawableId, new Rect(0, 0, (int) ((float) width * density), (int) ((float) height * density))));
//    }
//
//    /**
//     * <b>Note:</b> height cannot be greater then line height!
//     *
//     * @param verticalAlignment one of {@link DynamicDrawableSpan#ALIGN_BOTTOM} or
//     *                          {@link DynamicDrawableSpan#ALIGN_BASELINE}.
//     */
//    public SpannableImage(@DrawableRes int drawableId, int width, int height, boolean dp, int verticalAlignment) {
//        float density = dp ? getContext().getResources().getDisplayMetrics().density : 1;
//        appendImage(getDrawable(drawableId, new Rect(0, 0, (int) ((float) width * density), (int) ((float) height * density))), DynamicDrawableSpan.ALIGN_BOTTOM);
//    }
//    //endregion
//
//    //region Append methods
//
//    /**
//     * <b>Note:</b> drawable height cannot be greater then line height!
//     *
//     * @param verticalAlignment one of {@link DynamicDrawableSpan#ALIGN_BOTTOM} or
//     *                          {@link DynamicDrawableSpan#ALIGN_BASELINE}.
//     */
//    public SpannableImage appendImage(Drawable drawable, int verticalAlignment) {
//        appendStyled(" ", new ImageSpan(drawable, verticalAlignment));
//        return this;
//    }
//
//    public SpannableImage appendImage(Drawable drawable) {
//        return appendImage(drawable, DynamicDrawableSpan.ALIGN_BOTTOM);
//    }
//
//    /**
//     * <b>Note:</b> drawable height cannot be greater then line height!
//     */
//    public SpannableImage appendImage(@DrawableRes int drawableId) {
//        return appendImage(getDrawable(drawableId));
//    }
//
//    /**
//     * <b>Note:</b> height cannot be greater then line height!
//     */
//    public SpannableImage appendImage(@DrawableRes int drawableId, int width, int height) {
//        return appendImage(getDrawable(drawableId, new Rect(0, 0, width, height)));
//    }
//
//    /**
//     * <b>Note:</b> height cannot be greater then line height!
//     */
//    public SpannableImage appendImage(@DrawableRes int drawableId, int width, int height, boolean dp) {
//        float density = dp ? getContext().getResources().getDisplayMetrics().density : 1;
//        return appendImage(getDrawable(drawableId, new Rect(0, 0, (int) ((float) width * density), (int) ((float) height * density))));
//    }
//
//    /**
//     * <b>Note:</b> height cannot be greater then line height!
//     *
//     * @param verticalAlignment one of {@link DynamicDrawableSpan#ALIGN_BOTTOM} or
//     *                          {@link DynamicDrawableSpan#ALIGN_BASELINE}.
//     */
//    public SpannableImage appendImage(@DrawableRes int drawableId, int width, int height, boolean dp, int verticalAlignment) {
//        float density = dp ? getContext().getResources().getDisplayMetrics().density : 1;
//        return appendImage(getDrawable(drawableId, new Rect(0, 0, (int) ((float) width * density), (int) ((float) height * density))), DynamicDrawableSpan.ALIGN_BOTTOM);
//    }
//    //endregion
//
//    private Drawable getDrawable(@DrawableRes int drawableId) {
//        return getDrawable(drawableId, getDrawableBounds(drawableId));
//    }
//
//    private Rect getDrawableBounds(@DrawableRes int drawableId) {
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inTargetDensity = DisplayMetrics.DENSITY_DEFAULT;
//        options.inJustDecodeBounds = true;
//        BitmapFactory.decodeResource(getContext().getResources(), drawableId, options);
//        int width = options.outWidth;
//        int height = options.outHeight;
//
//        return new Rect(0, 0, width, height);
//    }
//
//    private Drawable getDrawable(@DrawableRes int drawableId, Rect bounds) {
//        Drawable drawable = ContextCompat.getDrawable(getContext(), drawableId);
//        drawable.setBounds(bounds);
//        return drawable;
//    }
}
