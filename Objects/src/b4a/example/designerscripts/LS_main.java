package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_main{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("panel1").vw.setWidth((int)((90d / 100 * width)));
views.get("panel1").vw.setLeft((int)((5d / 100 * width)));
views.get("panel1").vw.setTop((int)((50d / 100 * height) - (views.get("panel1").vw.getHeight())));
views.get("panel1").vw.setTop((int)((30d / 100 * width)));
views.get("panel1").vw.setHeight((int)((80d / 100 * height) - ((30d / 100 * width))));
views.get("panel1").vw.setHeight((int)((65d / 100 * height)));
views.get("logo").vw.setWidth((int)((71d / 100 * width)));
views.get("logo").vw.setHeight((int)((7d / 100 * height)));
views.get("logo").vw.setLeft((int)((14d / 100 * width)));
views.get("logo").vw.setTop((int)((27d / 100 * height) - (views.get("logo").vw.getHeight())));
views.get("email").vw.setWidth((int)((70d / 100 * width)));
views.get("email").vw.setHeight((int)((7d / 100 * height)));
views.get("email").vw.setLeft((int)((10d / 100 * width)));
views.get("email").vw.setTop((int)((26d / 100 * height) - (views.get("email").vw.getHeight())));
views.get("password").vw.setWidth((int)((70d / 100 * width)));
views.get("password").vw.setHeight((int)((7d / 100 * height)));
views.get("password").vw.setLeft((int)((10d / 100 * width)));
views.get("password").vw.setTop((int)((33d / 100 * height) - (views.get("password").vw.getHeight())));
views.get("loginbutton").vw.setWidth((int)((70d / 100 * width)));
views.get("loginbutton").vw.setHeight((int)((7d / 100 * height)));
views.get("loginbutton").vw.setLeft((int)((10d / 100 * width)));
views.get("loginbutton").vw.setTop((int)((50d / 100 * height) - (views.get("loginbutton").vw.getHeight())));
views.get("register").vw.setWidth((int)((70d / 100 * width)));
views.get("register").vw.setHeight((int)((7d / 100 * height)));
views.get("register").vw.setLeft((int)((10d / 100 * width)));
views.get("register").vw.setTop((int)((63d / 100 * height) - (views.get("register").vw.getHeight())));
views.get("registerlabel").vw.setWidth((int)((70d / 100 * width)));
views.get("registerlabel").vw.setHeight((int)((7d / 100 * height)));
views.get("registerlabel").vw.setLeft((int)((10d / 100 * width)));
views.get("registerlabel").vw.setTop((int)((60d / 100 * height) - (views.get("registerlabel").vw.getHeight())));
views.get("imageview1").vw.setWidth((int)((15d / 100 * width)));
views.get("imageview1").vw.setHeight((int)((10d / 100 * height)));
views.get("imageview1").vw.setLeft((int)((22d / 100 * width)));
views.get("imageview1").vw.setTop((int)((12d / 100 * height) - (views.get("imageview1").vw.getHeight())));
views.get("imageview2").vw.setWidth((int)((15d / 100 * width)));
views.get("imageview2").vw.setHeight((int)((10d / 100 * height)));
views.get("imageview2").vw.setLeft((int)((42d / 100 * width)));
//BA.debugLineNum = 53;BA.debugLine="ImageView2.Bottom = 12%Y"[Main/General script]
views.get("imageview2").vw.setTop((int)((12d / 100 * height) - (views.get("imageview2").vw.getHeight())));
//BA.debugLineNum = 55;BA.debugLine="ImageView3.Width = 15%X"[Main/General script]
views.get("imageview3").vw.setWidth((int)((15d / 100 * width)));
//BA.debugLineNum = 56;BA.debugLine="ImageView3.Height = 10%Y"[Main/General script]
views.get("imageview3").vw.setHeight((int)((10d / 100 * height)));
//BA.debugLineNum = 57;BA.debugLine="ImageView3.Left = 62%X"[Main/General script]
views.get("imageview3").vw.setLeft((int)((62d / 100 * width)));
//BA.debugLineNum = 58;BA.debugLine="ImageView3.Bottom = 12%Y"[Main/General script]
views.get("imageview3").vw.setTop((int)((12d / 100 * height) - (views.get("imageview3").vw.getHeight())));

}
}