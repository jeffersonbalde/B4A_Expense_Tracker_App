package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class addexpense extends Activity implements B4AActivity{
	public static addexpense mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.addexpense");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (addexpense).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.addexpense");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.addexpense", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (addexpense) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (addexpense) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return addexpense.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (addexpense) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (addexpense) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            addexpense mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (addexpense) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
public static double _updated_balance = 0;
public static double _current_balance = 0;
public b4a.example.b4xfloattextfield _inputmoney = null;
public b4a.example.b4xfloattextfield _purpose = null;
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.signup _signup = null;
public b4a.example.dashboard _dashboard = null;
public b4a.example.starter _starter = null;
public b4a.example.addbalance _addbalance = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="addexpense";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=30998528;
 //BA.debugLineNum = 30998528;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=30998530;
 //BA.debugLineNum = 30998530;BA.debugLine="Activity.LoadLayout(\"AddExpense\")";
mostCurrent._activity.LoadLayout("AddExpense",mostCurrent.activityBA);
RDebugUtils.currentLine=30998532;
 //BA.debugLineNum = 30998532;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="addexpense";
RDebugUtils.currentLine=31129600;
 //BA.debugLineNum = 31129600;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=31129602;
 //BA.debugLineNum = 31129602;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="addexpense";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=31064064;
 //BA.debugLineNum = 31064064;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=31064066;
 //BA.debugLineNum = 31064066;BA.debugLine="End Sub";
return "";
}
public static void  _addmoney_click() throws Exception{
RDebugUtils.currentModule="addexpense";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addmoney_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "addmoney_click", null); return;}
ResumableSub_AddMoney_Click rsub = new ResumableSub_AddMoney_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_AddMoney_Click extends BA.ResumableSub {
public ResumableSub_AddMoney_Click(b4a.example.addexpense parent) {
this.parent = parent;
}
b4a.example.addexpense parent;
String _query = "";
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _rs = null;
boolean _success = false;
int _i = 0;
int step19;
int limit19;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="addexpense";

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=31195138;
 //BA.debugLineNum = 31195138;BA.debugLine="Try";
if (true) break;

case 1:
//try
this.state = 14;
this.catchState = 13;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 13;
RDebugUtils.currentLine=31195139;
 //BA.debugLineNum = 31195139;BA.debugLine="Dim query As String = \"SELECT * FROM accounts WH";
_query = "SELECT * FROM accounts WHERE accountID = ?";
RDebugUtils.currentLine=31195140;
 //BA.debugLineNum = 31195140;BA.debugLine="Dim rs As ResultSet = Main.sql.ExecQuery2(query,";
_rs = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
_rs = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(parent.mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery2(_query,new String[]{BA.NumberToString(parent.mostCurrent._main._account_id /*int*/ )})));
RDebugUtils.currentLine=31195142;
 //BA.debugLineNum = 31195142;BA.debugLine="If rs.NextRow Then";
if (true) break;

case 4:
//if
this.state = 11;
if (_rs.NextRow()) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
RDebugUtils.currentLine=31195144;
 //BA.debugLineNum = 31195144;BA.debugLine="current_balance = rs.GetString(\"balance\")";
parent._current_balance = (double)(Double.parseDouble(_rs.GetString("balance")));
RDebugUtils.currentLine=31195146;
 //BA.debugLineNum = 31195146;BA.debugLine="If InputMoney.Text > current_balance Then";
if (true) break;

case 7:
//if
this.state = 10;
if ((double)(Double.parseDouble(parent.mostCurrent._inputmoney._gettext /*String*/ (null)))>parent._current_balance) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
RDebugUtils.currentLine=31195147;
 //BA.debugLineNum = 31195147;BA.debugLine="xui.MsgboxAsync(\"The amount exceeds your curre";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("The amount exceeds your current balance. Please review your current balance."),BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=31195148;
 //BA.debugLineNum = 31195148;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 10:
//C
this.state = 11;
;
 if (true) break;

case 11:
//C
this.state = 14;
;
 if (true) break;

case 13:
//C
this.state = 14;
this.catchState = 0;
RDebugUtils.currentLine=31195154;
 //BA.debugLineNum = 31195154;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("431195154",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
RDebugUtils.currentLine=31195155;
 //BA.debugLineNum = 31195155;BA.debugLine="xui.MsgboxAsync(LastException,\"Error\")";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getObject()),BA.ObjectToCharSequence("Error"));
 if (true) break;
if (true) break;
;
RDebugUtils.currentLine=31195158;
 //BA.debugLineNum = 31195158;BA.debugLine="Try";

case 14:
//try
this.state = 35;
this.catchState = 0;
this.catchState = 34;
this.state = 16;
if (true) break;

case 16:
//C
this.state = 17;
this.catchState = 34;
RDebugUtils.currentLine=31195159;
 //BA.debugLineNum = 31195159;BA.debugLine="Wait For (InsertExpense) Complete (Success As Bo";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "addexpense", "addmoney_click"), _insertexpense());
this.state = 36;
return;
case 36:
//C
this.state = 17;
_success = (Boolean) result[0];
;
RDebugUtils.currentLine=31195160;
 //BA.debugLineNum = 31195160;BA.debugLine="If Success Then";
if (true) break;

case 17:
//if
this.state = 32;
if (_success) { 
this.state = 19;
}if (true) break;

case 19:
//C
this.state = 20;
RDebugUtils.currentLine=31195162;
 //BA.debugLineNum = 31195162;BA.debugLine="Cursor = Main.sql.ExecQuery(\"SELECT * FROM acco";
parent._cursor = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(parent.mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM accounts_expense")));
RDebugUtils.currentLine=31195163;
 //BA.debugLineNum = 31195163;BA.debugLine="For i = 0 To Cursor.RowCount - 1";
if (true) break;

case 20:
//for
this.state = 23;
step19 = 1;
limit19 = (int) (parent._cursor.getRowCount()-1);
_i = (int) (0) ;
this.state = 37;
if (true) break;

case 37:
//C
this.state = 23;
if ((step19 > 0 && _i <= limit19) || (step19 < 0 && _i >= limit19)) this.state = 22;
if (true) break;

case 38:
//C
this.state = 37;
_i = ((int)(0 + _i + step19)) ;
if (true) break;

case 22:
//C
this.state = 38;
RDebugUtils.currentLine=31195164;
 //BA.debugLineNum = 31195164;BA.debugLine="Cursor.Position = i";
parent._cursor.setPosition(_i);
RDebugUtils.currentLine=31195166;
 //BA.debugLineNum = 31195166;BA.debugLine="Log($\"expenseID: ${Cursor.GetString(\"expenseID";
anywheresoftware.b4a.keywords.Common.LogImpl("431195166",("expenseID: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(parent._cursor.GetString("expenseID")))+" "),0);
RDebugUtils.currentLine=31195167;
 //BA.debugLineNum = 31195167;BA.debugLine="Log($\"account_id: ${Cursor.GetString(\"account_";
anywheresoftware.b4a.keywords.Common.LogImpl("431195167",("account_id: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(parent._cursor.GetString("account_id")))+" "),0);
RDebugUtils.currentLine=31195168;
 //BA.debugLineNum = 31195168;BA.debugLine="Log($\"expense_amount: ${Cursor.GetString(\"expe";
anywheresoftware.b4a.keywords.Common.LogImpl("431195168",("expense_amount: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(parent._cursor.GetString("expense_amount")))+" "),0);
RDebugUtils.currentLine=31195169;
 //BA.debugLineNum = 31195169;BA.debugLine="Log($\"purpose: ${Cursor.GetString(\"purpose\")}";
anywheresoftware.b4a.keywords.Common.LogImpl("431195169",("purpose: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(parent._cursor.GetString("purpose")))+" "),0);
 if (true) break;
if (true) break;

case 23:
//C
this.state = 24;
;
RDebugUtils.currentLine=31195172;
 //BA.debugLineNum = 31195172;BA.debugLine="Wait For (UpdateBalance) Complete (Success As B";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "addexpense", "addmoney_click"), _updatebalance());
this.state = 39;
return;
case 39:
//C
this.state = 24;
_success = (Boolean) result[0];
;
RDebugUtils.currentLine=31195173;
 //BA.debugLineNum = 31195173;BA.debugLine="If Success Then";
if (true) break;

case 24:
//if
this.state = 31;
if (_success) { 
this.state = 26;
}if (true) break;

case 26:
//C
this.state = 27;
RDebugUtils.currentLine=31195175;
 //BA.debugLineNum = 31195175;BA.debugLine="Dim query As String = \"SELECT * FROM accounts";
_query = "SELECT * FROM accounts WHERE accountID = ?";
RDebugUtils.currentLine=31195176;
 //BA.debugLineNum = 31195176;BA.debugLine="Dim rs As ResultSet = Main.sql.ExecQuery2(quer";
_rs = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
_rs = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(parent.mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery2(_query,new String[]{BA.NumberToString(parent.mostCurrent._main._account_id /*int*/ )})));
RDebugUtils.currentLine=31195178;
 //BA.debugLineNum = 31195178;BA.debugLine="If rs.NextRow Then";
if (true) break;

case 27:
//if
this.state = 30;
if (_rs.NextRow()) { 
this.state = 29;
}if (true) break;

case 29:
//C
this.state = 30;
RDebugUtils.currentLine=31195180;
 //BA.debugLineNum = 31195180;BA.debugLine="Dashboard.user_balance = rs.GetString(\"balanc";
parent.mostCurrent._dashboard._user_balance /*double*/  = (double)(Double.parseDouble(_rs.GetString("balance")));
RDebugUtils.currentLine=31195181;
 //BA.debugLineNum = 31195181;BA.debugLine="xui.MsgboxAsync(\"Expense successfully added.";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("Expense successfully added. Balance updated."),BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=31195182;
 //BA.debugLineNum = 31195182;BA.debugLine="StartActivity(Dashboard)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(parent.mostCurrent._dashboard.getObject()));
RDebugUtils.currentLine=31195183;
 //BA.debugLineNum = 31195183;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
 if (true) break;

case 30:
//C
this.state = 31;
;
 if (true) break;

case 31:
//C
this.state = 32;
;
 if (true) break;

case 32:
//C
this.state = 35;
;
 if (true) break;

case 34:
//C
this.state = 35;
this.catchState = 0;
RDebugUtils.currentLine=31195190;
 //BA.debugLineNum = 31195190;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("431195190",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 35:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=31195193;
 //BA.debugLineNum = 31195193;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
processBA.setLastException(e0);}
            }
        }
    }
}
public static anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _insertexpense() throws Exception{
RDebugUtils.currentModule="addexpense";
if (Debug.shouldDelegate(mostCurrent.activityBA, "insertexpense", false))
	 {return ((anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) Debug.delegate(mostCurrent.activityBA, "insertexpense", null));}
ResumableSub_InsertExpense rsub = new ResumableSub_InsertExpense(null);
rsub.resume(processBA, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_InsertExpense extends BA.ResumableSub {
public ResumableSub_InsertExpense(b4a.example.addexpense parent) {
this.parent = parent;
}
b4a.example.addexpense parent;
boolean _result = false;
String _query = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="addexpense";

    while (true) {
try {

        switch (state) {
            case -1:
{
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
RDebugUtils.currentLine=33488898;
 //BA.debugLineNum = 33488898;BA.debugLine="Dim result As Boolean";
_result = false;
RDebugUtils.currentLine=33488900;
 //BA.debugLineNum = 33488900;BA.debugLine="If InputMoney.Text = \"\" Or Purpose.Text = \"\" Then";
if (true) break;

case 1:
//if
this.state = 4;
if ((parent.mostCurrent._inputmoney._gettext /*String*/ (null)).equals("") || (parent.mostCurrent._purpose._gettext /*String*/ (null)).equals("")) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=33488901;
 //BA.debugLineNum = 33488901;BA.debugLine="xui.MsgboxAsync(\"Please fill the required fields";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("Please fill the required fields"),BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=33488902;
 //BA.debugLineNum = 33488902;BA.debugLine="Return";
if (true) {
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,null);return;};
 if (true) break;
;
RDebugUtils.currentLine=33488905;
 //BA.debugLineNum = 33488905;BA.debugLine="Try";

case 4:
//try
this.state = 9;
this.catchState = 8;
this.state = 6;
if (true) break;

case 6:
//C
this.state = 9;
this.catchState = 8;
RDebugUtils.currentLine=33488906;
 //BA.debugLineNum = 33488906;BA.debugLine="Dim query As String = $\"INSERT INTO accounts_exp";
_query = ("INSERT INTO accounts_expense (account_id, expense_amount, purpose) VALUES (?,?,?)");
RDebugUtils.currentLine=33488907;
 //BA.debugLineNum = 33488907;BA.debugLine="Main.sql.ExecNonQuery2(query, Array As Object(Ma";
parent.mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2(_query,anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(parent.mostCurrent._main._account_id /*int*/ ),(Object)(parent.mostCurrent._inputmoney._gettext /*String*/ (null)),(Object)(parent.mostCurrent._purpose._gettext /*String*/ (null))}));
RDebugUtils.currentLine=33488908;
 //BA.debugLineNum = 33488908;BA.debugLine="result = True";
_result = anywheresoftware.b4a.keywords.Common.True;
 if (true) break;

case 8:
//C
this.state = 9;
this.catchState = 0;
RDebugUtils.currentLine=33488910;
 //BA.debugLineNum = 33488910;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("433488910",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
RDebugUtils.currentLine=33488911;
 //BA.debugLineNum = 33488911;BA.debugLine="xui.MsgboxAsync(LastException,\"Error\")";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getObject()),BA.ObjectToCharSequence("Error"));
RDebugUtils.currentLine=33488912;
 //BA.debugLineNum = 33488912;BA.debugLine="result = False";
_result = anywheresoftware.b4a.keywords.Common.False;
 if (true) break;
if (true) break;

case 9:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=33488915;
 //BA.debugLineNum = 33488915;BA.debugLine="Return result";
if (true) {
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,(Object)(_result));return;};
RDebugUtils.currentLine=33488916;
 //BA.debugLineNum = 33488916;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
processBA.setLastException(e0);}
            }
        }
    }
}
public static anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _updatebalance() throws Exception{
RDebugUtils.currentModule="addexpense";
if (Debug.shouldDelegate(mostCurrent.activityBA, "updatebalance", false))
	 {return ((anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) Debug.delegate(mostCurrent.activityBA, "updatebalance", null));}
ResumableSub_UpdateBalance rsub = new ResumableSub_UpdateBalance(null);
rsub.resume(processBA, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_UpdateBalance extends BA.ResumableSub {
public ResumableSub_UpdateBalance(b4a.example.addexpense parent) {
this.parent = parent;
}
b4a.example.addexpense parent;
boolean _result = false;
String _query = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="addexpense";

    while (true) {
try {

        switch (state) {
            case -1:
{
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
RDebugUtils.currentLine=32636930;
 //BA.debugLineNum = 32636930;BA.debugLine="Dim result As Boolean";
_result = false;
RDebugUtils.currentLine=32636932;
 //BA.debugLineNum = 32636932;BA.debugLine="Try";
if (true) break;

case 1:
//try
this.state = 6;
this.catchState = 5;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 6;
this.catchState = 5;
RDebugUtils.currentLine=32636933;
 //BA.debugLineNum = 32636933;BA.debugLine="Dim query As String = $\"UPDATE accounts SET bala";
_query = ("UPDATE accounts SET balance = balance - ? WHERE accountID = ?");
RDebugUtils.currentLine=32636934;
 //BA.debugLineNum = 32636934;BA.debugLine="Main.sql.ExecNonQuery2(query, Array As Object(In";
parent.mostCurrent._main._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2(_query,anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(parent.mostCurrent._inputmoney._gettext /*String*/ (null)),(Object)(parent.mostCurrent._main._account_id /*int*/ )}));
RDebugUtils.currentLine=32636935;
 //BA.debugLineNum = 32636935;BA.debugLine="result = True";
_result = anywheresoftware.b4a.keywords.Common.True;
 if (true) break;

case 5:
//C
this.state = 6;
this.catchState = 0;
RDebugUtils.currentLine=32636937;
 //BA.debugLineNum = 32636937;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("432636937",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
RDebugUtils.currentLine=32636938;
 //BA.debugLineNum = 32636938;BA.debugLine="xui.MsgboxAsync(LastException,\"Error\")";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getObject()),BA.ObjectToCharSequence("Error"));
RDebugUtils.currentLine=32636939;
 //BA.debugLineNum = 32636939;BA.debugLine="result = False";
_result = anywheresoftware.b4a.keywords.Common.False;
 if (true) break;
if (true) break;

case 6:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=32636942;
 //BA.debugLineNum = 32636942;BA.debugLine="Return result";
if (true) {
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,(Object)(_result));return;};
RDebugUtils.currentLine=32636943;
 //BA.debugLineNum = 32636943;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
processBA.setLastException(e0);}
            }
        }
    }
}
public static String  _goback_click() throws Exception{
RDebugUtils.currentModule="addexpense";
if (Debug.shouldDelegate(mostCurrent.activityBA, "goback_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "goback_click", null));}
RDebugUtils.currentLine=31391744;
 //BA.debugLineNum = 31391744;BA.debugLine="Private Sub GoBack_Click";
RDebugUtils.currentLine=31391745;
 //BA.debugLineNum = 31391745;BA.debugLine="StartActivity(Dashboard)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._dashboard.getObject()));
RDebugUtils.currentLine=31391746;
 //BA.debugLineNum = 31391746;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=31391747;
 //BA.debugLineNum = 31391747;BA.debugLine="End Sub";
return "";
}
}