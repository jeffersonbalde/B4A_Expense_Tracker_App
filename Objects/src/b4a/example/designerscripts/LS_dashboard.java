package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_dashboard{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("panel1").vw.setWidth((int)((90d / 100 * width)));
views.get("panel1").vw.setLeft((int)((5d / 100 * width)));
views.get("panel1").vw.setTop((int)((50d / 100 * height) - (views.get("panel1").vw.getHeight())));
views.get("panel1").vw.setTop((int)((9d / 100 * width)));
views.get("panel1").vw.setHeight((int)((80d / 100 * height) - ((9d / 100 * width))));
views.get("panel1").vw.setHeight((int)((92d / 100 * height)));
views.get("nameofuser").vw.setWidth((int)((87d / 100 * width)));
views.get("nameofuser").vw.setHeight((int)((7d / 100 * height)));
views.get("nameofuser").vw.setLeft((int)((8d / 100 * width)));
views.get("nameofuser").vw.setTop((int)((11d / 100 * height) - (views.get("nameofuser").vw.getHeight())));
views.get("currentmoney").vw.setWidth((int)((88d / 100 * width)));
views.get("currentmoney").vw.setHeight((int)((7d / 100 * height)));
views.get("currentmoney").vw.setLeft((int)((7d / 100 * width)));
views.get("currentmoney").vw.setTop((int)((23d / 100 * height) - (views.get("currentmoney").vw.getHeight())));
views.get("currentmoneylabel").vw.setWidth((int)((88d / 100 * width)));
views.get("currentmoneylabel").vw.setHeight((int)((7d / 100 * height)));
views.get("currentmoneylabel").vw.setLeft((int)((7d / 100 * width)));
views.get("currentmoneylabel").vw.setTop((int)((19d / 100 * height) - (views.get("currentmoneylabel").vw.getHeight())));
views.get("addmoney").vw.setWidth((int)((80d / 100 * width)));
views.get("addmoney").vw.setHeight((int)((7d / 100 * height)));
views.get("addmoney").vw.setLeft((int)((10d / 100 * width)));
//BA.debugLineNum = 33;BA.debugLine="AddMoney.Bottom = 79%Y"[Dashboard/General script]
views.get("addmoney").vw.setTop((int)((79d / 100 * height) - (views.get("addmoney").vw.getHeight())));
//BA.debugLineNum = 35;BA.debugLine="AddCash.Width = 80%X"[Dashboard/General script]
views.get("addcash").vw.setWidth((int)((80d / 100 * width)));
//BA.debugLineNum = 36;BA.debugLine="AddCash.Height = 7%Y"[Dashboard/General script]
views.get("addcash").vw.setHeight((int)((7d / 100 * height)));
//BA.debugLineNum = 37;BA.debugLine="AddCash.Left = 10%X"[Dashboard/General script]
views.get("addcash").vw.setLeft((int)((10d / 100 * width)));
//BA.debugLineNum = 38;BA.debugLine="AddCash.Bottom = 71%Y"[Dashboard/General script]
views.get("addcash").vw.setTop((int)((71d / 100 * height) - (views.get("addcash").vw.getHeight())));
//BA.debugLineNum = 40;BA.debugLine="Logout.Width = 80%X"[Dashboard/General script]
views.get("logout").vw.setWidth((int)((80d / 100 * width)));
//BA.debugLineNum = 41;BA.debugLine="Logout.Height = 7%Y"[Dashboard/General script]
views.get("logout").vw.setHeight((int)((7d / 100 * height)));
//BA.debugLineNum = 42;BA.debugLine="Logout.Left = 10%X"[Dashboard/General script]
views.get("logout").vw.setLeft((int)((10d / 100 * width)));
//BA.debugLineNum = 43;BA.debugLine="Logout.Bottom = 95%Y"[Dashboard/General script]
views.get("logout").vw.setTop((int)((95d / 100 * height) - (views.get("logout").vw.getHeight())));
//BA.debugLineNum = 45;BA.debugLine="DeleteAccount.Width = 80%X"[Dashboard/General script]
views.get("deleteaccount").vw.setWidth((int)((80d / 100 * width)));
//BA.debugLineNum = 46;BA.debugLine="DeleteAccount.Height = 7%Y"[Dashboard/General script]
views.get("deleteaccount").vw.setHeight((int)((7d / 100 * height)));
//BA.debugLineNum = 47;BA.debugLine="DeleteAccount.Left = 10%X"[Dashboard/General script]
views.get("deleteaccount").vw.setLeft((int)((10d / 100 * width)));
//BA.debugLineNum = 48;BA.debugLine="DeleteAccount.Bottom = 87%Y"[Dashboard/General script]
views.get("deleteaccount").vw.setTop((int)((87d / 100 * height) - (views.get("deleteaccount").vw.getHeight())));
//BA.debugLineNum = 50;BA.debugLine="ListView1.Width = 80%X"[Dashboard/General script]
views.get("listview1").vw.setWidth((int)((80d / 100 * width)));
//BA.debugLineNum = 51;BA.debugLine="ListView1.Height = 38%Y"[Dashboard/General script]
views.get("listview1").vw.setHeight((int)((38d / 100 * height)));
//BA.debugLineNum = 52;BA.debugLine="ListView1.Left = 10%X"[Dashboard/General script]
views.get("listview1").vw.setLeft((int)((10d / 100 * width)));
//BA.debugLineNum = 53;BA.debugLine="ListView1.Bottom = 62%Y"[Dashboard/General script]
views.get("listview1").vw.setTop((int)((62d / 100 * height) - (views.get("listview1").vw.getHeight())));

}
}