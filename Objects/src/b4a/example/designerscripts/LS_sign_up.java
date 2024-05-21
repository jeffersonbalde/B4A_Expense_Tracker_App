package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_sign_up{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("panel1").vw.setWidth((int)((90d / 100 * width)));
views.get("panel1").vw.setLeft((int)((5d / 100 * width)));
views.get("panel1").vw.setTop((int)((50d / 100 * height) - (views.get("panel1").vw.getHeight())));
views.get("panel1").vw.setTop((int)((35d / 100 * width)));
views.get("panel1").vw.setHeight((int)((78d / 100 * height) - ((35d / 100 * width))));
views.get("name").vw.setWidth((int)((70d / 100 * width)));
views.get("name").vw.setHeight((int)((7d / 100 * height)));
views.get("name").vw.setLeft((int)((15d / 100 * width)));
views.get("name").vw.setTop((int)((30d / 100 * height) - (views.get("name").vw.getHeight())));
views.get("email").vw.setWidth((int)((70d / 100 * width)));
views.get("email").vw.setHeight((int)((7d / 100 * height)));
views.get("email").vw.setLeft((int)((10d / 100 * width)));
views.get("email").vw.setTop((int)((21d / 100 * height) - (views.get("email").vw.getHeight())));
views.get("password").vw.setWidth((int)((70d / 100 * width)));
views.get("password").vw.setHeight((int)((7d / 100 * height)));
views.get("password").vw.setLeft((int)((10d / 100 * width)));
views.get("password").vw.setTop((int)((29d / 100 * height) - (views.get("password").vw.getHeight())));
views.get("registerbutton").vw.setWidth((int)((70d / 100 * width)));
views.get("registerbutton").vw.setHeight((int)((7d / 100 * height)));
views.get("registerbutton").vw.setLeft((int)((15d / 100 * width)));
views.get("registerbutton").vw.setTop((int)((64d / 100 * height) - (views.get("registerbutton").vw.getHeight())));
views.get("loginlabel").vw.setWidth((int)((70d / 100 * width)));
views.get("loginlabel").vw.setHeight((int)((7d / 100 * height)));
views.get("loginlabel").vw.setLeft((int)((15d / 100 * width)));
views.get("loginlabel").vw.setTop((int)((73d / 100 * height) - (views.get("loginlabel").vw.getHeight())));
views.get("login").vw.setWidth((int)((70d / 100 * width)));
views.get("login").vw.setHeight((int)((7d / 100 * height)));
views.get("login").vw.setLeft((int)((15d / 100 * width)));
views.get("login").vw.setTop((int)((76d / 100 * height) - (views.get("login").vw.getHeight())));

}
}