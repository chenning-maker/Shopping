package com.youth.banner;


import androidx.viewpager.widget.ViewPager.PageTransformer;

import com.youth.banner.transformer.AccordionTransformer;
import com.youth.banner.transformer.BackgroundToForegroundTransformer;
import com.youth.banner.transformer.CubeInTransformer;
import com.youth.banner.transformer.CubeOutTransformer;
import com.youth.banner.transformer.DefaultTransformer;
import com.youth.banner.transformer.DepthPageTransformer;
import com.youth.banner.transformer.FlipHorizontalTransformer;
import com.youth.banner.transformer.FlipVerticalTransformer;
import com.youth.banner.transformer.ForegroundToBackgroundTransformer;
import com.youth.banner.transformer.RotateDownTransformer;
import com.youth.banner.transformer.RotateUpTransformer;
import com.youth.banner.transformer.ScaleInOutTransformer;
import com.youth.banner.transformer.StackTransformer;
import com.youth.banner.transformer.TabletTransformer;
import com.youth.banner.transformer.ZoomInTransformer;
import com.youth.banner.transformer.ZoomOutSlideTransformer;
import com.youth.banner.transformer.ZoomOutTranformer;



public class Transformer {
    public static Class<? extends PageTransformer> Default = (Class<? extends PageTransformer>) DefaultTransformer.class;
    public static Class<? extends PageTransformer> Accordion = (Class<? extends PageTransformer>) AccordionTransformer.class;
    public static Class<? extends PageTransformer> BackgroundToForeground = (Class<? extends PageTransformer>) BackgroundToForegroundTransformer.class;
    public static Class<? extends PageTransformer> ForegroundToBackground = (Class<? extends PageTransformer>) ForegroundToBackgroundTransformer.class;
    public static Class<? extends PageTransformer> CubeIn = (Class<? extends PageTransformer>) CubeInTransformer.class;
    public static Class<? extends PageTransformer> CubeOut = (Class<? extends PageTransformer>) CubeOutTransformer.class;
    public static Class<? extends PageTransformer> DepthPage = (Class<? extends PageTransformer>) DepthPageTransformer.class;
    public static Class<? extends PageTransformer> FlipHorizontal = (Class<? extends PageTransformer>) FlipHorizontalTransformer.class;
    public static Class<? extends PageTransformer> FlipVertical = (Class<? extends PageTransformer>) FlipVerticalTransformer.class;
    public static Class<? extends PageTransformer> RotateDown = (Class<? extends PageTransformer>) RotateDownTransformer.class;
    public static Class<? extends PageTransformer> RotateUp = (Class<? extends PageTransformer>) RotateUpTransformer.class;
    public static Class<? extends PageTransformer> ScaleInOut = (Class<? extends PageTransformer>) ScaleInOutTransformer.class;
    public static Class<? extends PageTransformer> Stack = (Class<? extends PageTransformer>) StackTransformer.class;
    public static Class<? extends PageTransformer> Tablet = (Class<? extends PageTransformer>) TabletTransformer.class;
    public static Class<? extends PageTransformer> ZoomIn = (Class<? extends PageTransformer>) ZoomInTransformer.class;
    public static Class<? extends PageTransformer> ZoomOut = (Class<? extends PageTransformer>) ZoomOutTranformer.class;
    public static Class<? extends PageTransformer> ZoomOutSlide = (Class<? extends PageTransformer>) ZoomOutSlideTransformer.class;
}
