package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_addexpense{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("panel1").vw.setWidth((int)((90d / 100 * width)));
views.get("panel1").vw.setLeft((int)((5d / 100 * width)));
views.get("panel1").vw.setTop((int)((50d / 100 * height) - (views.get("panel1").vw.getHeight())));
views.get("panel1").vw.setTop((int)((9d / 100 * width)));
views.get("panel1").vw.setHeight((int)((80d / 100 * height) - ((9d / 100 * width))));
views.get("panel1").vw.setHeight((int)((92d / 100 * height)));
views.get("inputmoney").vw.setWidth((int)((70d / 100 * width)));
views.get("inputmoney").vw.setHeight((int)((9d / 100 * height)));
views.get("inputmoney").vw.setLeft((int)((10d / 100 * width)));
views.get("inputmoney").vw.setTop((int)((29d / 100 * height) - (views.get("inputmoney").vw.getHeight())));
views.get("purpose").vw.setWidth((int)((70d / 100 * width)));
views.get("purpose").vw.setHeight((int)((9d / 100 * height)));
views.get("purpose").vw.setLeft((int)((10d / 100 * width)));
views.get("purpose").vw.setTop((int)((38d / 100 * height) - (views.get("purpose").vw.getHeight())));
views.get("addmoney").vw.setWidth((int)((80d / 100 * width)));
views.get("addmoney").vw.setHeight((int)((7d / 100 * height)));
views.get("addmoney").vw.setLeft((int)((10d / 100 * width)));
//BA.debugLineNum = 23;BA.debugLine="AddMoney.Bottom = 62%Y"[AddExpense/General script]
views.get("addmoney").vw.setTop((int)((62d / 100 * height) - (views.get("addmoney").vw.getHeight())));
//BA.debugLineNum = 25;BA.debugLine="GoBack.Width = 80%X"[AddExpense/General script]
views.get("goback").vw.setWidth((int)((80d / 100 * width)));
//BA.debugLineNum = 26;BA.debugLine="GoBack.Height = 7%Y"[AddExpense/General script]
views.get("goback").vw.setHeight((int)((7d / 100 * height)));
//BA.debugLineNum = 27;BA.debugLine="GoBack.Left = 10%X"[AddExpense/General script]
views.get("goback").vw.setLeft((int)((10d / 100 * width)));
//BA.debugLineNum = 28;BA.debugLine="GoBack.Bottom = 70%Y"[AddExpense/General script]
views.get("goback").vw.setTop((int)((70d / 100 * height) - (views.get("goback").vw.getHeight())));

}
}