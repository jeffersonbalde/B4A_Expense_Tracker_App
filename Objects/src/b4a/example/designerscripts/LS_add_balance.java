package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_add_balance{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[Add_Balance/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 4;BA.debugLine="Panel1.Width = 90%X"[Add_Balance/General script]
views.get("panel1").vw.setWidth((int)((90d / 100 * width)));
//BA.debugLineNum = 5;BA.debugLine="Panel1.Left = 5%X"[Add_Balance/General script]
views.get("panel1").vw.setLeft((int)((5d / 100 * width)));
//BA.debugLineNum = 6;BA.debugLine="Panel1.Bottom = 50%Y"[Add_Balance/General script]
views.get("panel1").vw.setTop((int)((50d / 100 * height) - (views.get("panel1").vw.getHeight())));
//BA.debugLineNum = 7;BA.debugLine="Panel1.SetTopAndBottom(9%x, 80%y)"[Add_Balance/General script]
views.get("panel1").vw.setTop((int)((9d / 100 * width)));
views.get("panel1").vw.setHeight((int)((80d / 100 * height) - ((9d / 100 * width))));
//BA.debugLineNum = 8;BA.debugLine="Panel1.Height = 92%Y"[Add_Balance/General script]
views.get("panel1").vw.setHeight((int)((92d / 100 * height)));
//BA.debugLineNum = 10;BA.debugLine="InputMoney.Width = 70%X"[Add_Balance/General script]
views.get("inputmoney").vw.setWidth((int)((70d / 100 * width)));
//BA.debugLineNum = 11;BA.debugLine="InputMoney.Height = 9%Y"[Add_Balance/General script]
views.get("inputmoney").vw.setHeight((int)((9d / 100 * height)));
//BA.debugLineNum = 12;BA.debugLine="InputMoney.Left = 10%X"[Add_Balance/General script]
views.get("inputmoney").vw.setLeft((int)((10d / 100 * width)));
//BA.debugLineNum = 13;BA.debugLine="InputMoney.Bottom = 29%Y"[Add_Balance/General script]
views.get("inputmoney").vw.setTop((int)((29d / 100 * height) - (views.get("inputmoney").vw.getHeight())));
//BA.debugLineNum = 15;BA.debugLine="AddMoney.Width = 80%X"[Add_Balance/General script]
views.get("addmoney").vw.setWidth((int)((80d / 100 * width)));
//BA.debugLineNum = 16;BA.debugLine="AddMoney.Height = 7%Y"[Add_Balance/General script]
views.get("addmoney").vw.setHeight((int)((7d / 100 * height)));
//BA.debugLineNum = 17;BA.debugLine="AddMoney.Left = 10%X"[Add_Balance/General script]
views.get("addmoney").vw.setLeft((int)((10d / 100 * width)));
//BA.debugLineNum = 18;BA.debugLine="AddMoney.Bottom = 55%Y"[Add_Balance/General script]
views.get("addmoney").vw.setTop((int)((55d / 100 * height) - (views.get("addmoney").vw.getHeight())));
//BA.debugLineNum = 20;BA.debugLine="GoBack.Width = 80%X"[Add_Balance/General script]
views.get("goback").vw.setWidth((int)((80d / 100 * width)));
//BA.debugLineNum = 21;BA.debugLine="GoBack.Height = 7%Y"[Add_Balance/General script]
views.get("goback").vw.setHeight((int)((7d / 100 * height)));
//BA.debugLineNum = 22;BA.debugLine="GoBack.Left = 10%X"[Add_Balance/General script]
views.get("goback").vw.setLeft((int)((10d / 100 * width)));
//BA.debugLineNum = 23;BA.debugLine="GoBack.Bottom = 63%Y"[Add_Balance/General script]
views.get("goback").vw.setTop((int)((63d / 100 * height) - (views.get("goback").vw.getHeight())));

}
}