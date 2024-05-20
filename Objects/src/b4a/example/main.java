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

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
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
		return main.class;
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
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
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
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
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
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        b4a.example.dateutils._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (signup.mostCurrent != null);
vis = vis | (dashboard.mostCurrent != null);
vis = vis | (addbalance.mostCurrent != null);
vis = vis | (addexpense.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (signup.previousOne != null) {
				__a = signup.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(signup.mostCurrent == null ? null : signup.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (dashboard.previousOne != null) {
				__a = dashboard.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(dashboard.mostCurrent == null ? null : dashboard.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
 {
            Activity __a = null;
            if (addbalance.previousOne != null) {
				__a = addbalance.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(addbalance.mostCurrent == null ? null : addbalance.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (addexpense.previousOne != null) {
				__a = addexpense.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(addexpense.mostCurrent == null ? null : addexpense.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static anywheresoftware.b4a.sql.SQL _sql = null;
public static anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
public static int _account_id = 0;
public b4a.example.b4xfloattextfield _password = null;
public b4a.example.b4xfloattextfield _email = null;
public static String _username = "";
public b4a.example.dateutils _dateutils = null;
public b4a.example.signup _signup = null;
public b4a.example.dashboard _dashboard = null;
public b4a.example.starter _starter = null;
public b4a.example.addbalance _addbalance = null;
public b4a.example.addexpense _addexpense = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;
public static void  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}); return;}
ResumableSub_Activity_Create rsub = new ResumableSub_Activity_Create(null,_firsttime);
rsub.resume(processBA, null);
}
public static class ResumableSub_Activity_Create extends BA.ResumableSub {
public ResumableSub_Activity_Create(b4a.example.main parent,boolean _firsttime) {
this.parent = parent;
this._firsttime = _firsttime;
}
b4a.example.main parent;
boolean _firsttime;
boolean _success = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="If FirstTime Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_firsttime) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="sql.Initialize(File.DirInternal, \"test.db\", True";
parent._sql.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"test.db",anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 4:
//C
this.state = 5;
;
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="Wait For (createTableAccounts) Complete (Success";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "activity_create"), _createtableaccounts());
this.state = 13;
return;
case 13:
//C
this.state = 5;
_success = (Boolean) result[0];
;
RDebugUtils.currentLine=131083;
 //BA.debugLineNum = 131083;BA.debugLine="If Success Then'";
if (true) break;

case 5:
//if
this.state = 8;
if (_success) { 
this.state = 7;
}if (true) break;

case 7:
//C
this.state = 8;
 if (true) break;

case 8:
//C
this.state = 9;
;
RDebugUtils.currentLine=131098;
 //BA.debugLineNum = 131098;BA.debugLine="Wait For (createTableAccountExpense) Complete (Su";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "activity_create"), _createtableaccountexpense());
this.state = 14;
return;
case 14:
//C
this.state = 9;
_success = (Boolean) result[0];
;
RDebugUtils.currentLine=131099;
 //BA.debugLineNum = 131099;BA.debugLine="If Success Then";
if (true) break;

case 9:
//if
this.state = 12;
if (_success) { 
this.state = 11;
}if (true) break;

case 11:
//C
this.state = 12;
 if (true) break;

case 12:
//C
this.state = -1;
;
RDebugUtils.currentLine=131103;
 //BA.debugLineNum = 131103;BA.debugLine="Activity.LoadLayout(\"Main\")";
parent.mostCurrent._activity.LoadLayout("Main",mostCurrent.activityBA);
RDebugUtils.currentLine=131104;
 //BA.debugLineNum = 131104;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _createtableaccounts() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "createtableaccounts", false))
	 {return ((anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) Debug.delegate(mostCurrent.activityBA, "createtableaccounts", null));}
ResumableSub_createTableAccounts rsub = new ResumableSub_createTableAccounts(null);
rsub.resume(processBA, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_createTableAccounts extends BA.ResumableSub {
public ResumableSub_createTableAccounts(b4a.example.main parent) {
this.parent = parent;
}
b4a.example.main parent;
String _query = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";

    while (true) {
        switch (state) {
            case -1:
{
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = -1;
RDebugUtils.currentLine=27066370;
 //BA.debugLineNum = 27066370;BA.debugLine="Dim query As String = $\" 		CREATE TABLE IF NOT EX";
_query = ("\n"+"		CREATE TABLE IF NOT EXISTS accounts (\n"+"			accountID INTEGER PRIMARY KEY AUTOINCREMENT, \n"+"			name TEXT, \n"+"			email TEXT, \n"+"			password TEXT, \n"+"			balance REAL DEFAULT 0.00\n"+"		)");
RDebugUtils.currentLine=27066379;
 //BA.debugLineNum = 27066379;BA.debugLine="sql.ExecNonQuery(query)";
parent._sql.ExecNonQuery(_query);
RDebugUtils.currentLine=27066381;
 //BA.debugLineNum = 27066381;BA.debugLine="Return True";
if (true) {
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,(Object)(anywheresoftware.b4a.keywords.Common.True));return;};
RDebugUtils.currentLine=27066382;
 //BA.debugLineNum = 27066382;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _createtableaccountexpense() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "createtableaccountexpense", false))
	 {return ((anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) Debug.delegate(mostCurrent.activityBA, "createtableaccountexpense", null));}
ResumableSub_createTableAccountExpense rsub = new ResumableSub_createTableAccountExpense(null);
rsub.resume(processBA, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_createTableAccountExpense extends BA.ResumableSub {
public ResumableSub_createTableAccountExpense(b4a.example.main parent) {
this.parent = parent;
}
b4a.example.main parent;
String _query = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";

    while (true) {
        switch (state) {
            case -1:
{
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = -1;
RDebugUtils.currentLine=32571394;
 //BA.debugLineNum = 32571394;BA.debugLine="Dim query As String = $\" 		CREATE TABLE IF NOT EX";
_query = ("\n"+"		CREATE TABLE IF NOT EXISTS accounts_expense (\n"+"			expenseID INTEGER PRIMARY KEY AUTOINCREMENT, \n"+"			account_id REAL, \n"+"			expense_amount TEXT, \n"+"			purpose TEXT, \n"+"			FOREIGN KEY(account_id) REFERENCES accounts(accountID)\n"+"		)");
RDebugUtils.currentLine=32571403;
 //BA.debugLineNum = 32571403;BA.debugLine="sql.ExecNonQuery(query)";
parent._sql.ExecNonQuery(_query);
RDebugUtils.currentLine=32571405;
 //BA.debugLineNum = 32571405;BA.debugLine="Return True";
if (true) {
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,(Object)(anywheresoftware.b4a.keywords.Common.True));return;};
RDebugUtils.currentLine=32571406;
 //BA.debugLineNum = 32571406;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _droptable() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "droptable", false))
	 {return ((anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) Debug.delegate(mostCurrent.activityBA, "droptable", null));}
ResumableSub_dropTable rsub = new ResumableSub_dropTable(null);
rsub.resume(processBA, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_dropTable extends BA.ResumableSub {
public ResumableSub_dropTable(b4a.example.main parent) {
this.parent = parent;
}
b4a.example.main parent;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";

    while (true) {
        switch (state) {
            case -1:
{
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = -1;
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="sql.ExecNonQuery(\"DROP TABLE accounts\")";
parent._sql.ExecNonQuery("DROP TABLE accounts");
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="Return True";
if (true) {
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,(Object)(anywheresoftware.b4a.keywords.Common.True));return;};
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _login() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "login", false))
	 {return ((anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) Debug.delegate(mostCurrent.activityBA, "login", null));}
ResumableSub_Login rsub = new ResumableSub_Login(null);
rsub.resume(processBA, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_Login extends BA.ResumableSub {
public ResumableSub_Login(b4a.example.main parent) {
this.parent = parent;
}
b4a.example.main parent;
boolean _result = false;
String _query = "";
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _rs = null;
int _i = 0;
int step9;
int limit9;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";

    while (true) {
try {

        switch (state) {
            case -1:
{
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="Dim result As Boolean";
_result = false;
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="Try";
if (true) break;

case 1:
//try
this.state = 16;
this.catchState = 15;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 15;
RDebugUtils.currentLine=589828;
 //BA.debugLineNum = 589828;BA.debugLine="Dim query As String = $\"SELECT * FROM accounts W";
_query = ("SELECT * FROM accounts WHERE email=? AND password=?");
RDebugUtils.currentLine=589829;
 //BA.debugLineNum = 589829;BA.debugLine="Dim rs As ResultSet = sql.ExecQuery2(query, Arra";
_rs = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
_rs = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(parent._sql.ExecQuery2(_query,new String[]{parent.mostCurrent._email._gettext /*String*/ (null),parent.mostCurrent._password._gettext /*String*/ (null)})));
RDebugUtils.currentLine=589831;
 //BA.debugLineNum = 589831;BA.debugLine="If rs.NextRow Then";
if (true) break;

case 4:
//if
this.state = 13;
if (_rs.NextRow()) { 
this.state = 6;
}else {
this.state = 12;
}if (true) break;

case 6:
//C
this.state = 7;
RDebugUtils.currentLine=589832;
 //BA.debugLineNum = 589832;BA.debugLine="Log(\"Email: \" & rs.GetString(\"email\"))";
anywheresoftware.b4a.keywords.Common.LogImpl("4589832","Email: "+_rs.GetString("email"),0);
RDebugUtils.currentLine=589833;
 //BA.debugLineNum = 589833;BA.debugLine="Log(\"Password: \" & rs.GetString(\"password\"))";
anywheresoftware.b4a.keywords.Common.LogImpl("4589833","Password: "+_rs.GetString("password"),0);
RDebugUtils.currentLine=589835;
 //BA.debugLineNum = 589835;BA.debugLine="Cursor = sql.ExecQuery(\"SELECT * FROM accounts\"";
parent._cursor = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(parent._sql.ExecQuery("SELECT * FROM accounts")));
RDebugUtils.currentLine=589836;
 //BA.debugLineNum = 589836;BA.debugLine="For i = 0 To Cursor.RowCount - 1";
if (true) break;

case 7:
//for
this.state = 10;
step9 = 1;
limit9 = (int) (parent._cursor.getRowCount()-1);
_i = (int) (0) ;
this.state = 17;
if (true) break;

case 17:
//C
this.state = 10;
if ((step9 > 0 && _i <= limit9) || (step9 < 0 && _i >= limit9)) this.state = 9;
if (true) break;

case 18:
//C
this.state = 17;
_i = ((int)(0 + _i + step9)) ;
if (true) break;

case 9:
//C
this.state = 18;
RDebugUtils.currentLine=589837;
 //BA.debugLineNum = 589837;BA.debugLine="Cursor.Position = i";
parent._cursor.setPosition(_i);
RDebugUtils.currentLine=589839;
 //BA.debugLineNum = 589839;BA.debugLine="Log($\"name: ${Cursor.GetString(\"name\")} \"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("4589839",("name: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(parent._cursor.GetString("name")))+" "),0);
RDebugUtils.currentLine=589840;
 //BA.debugLineNum = 589840;BA.debugLine="Log($\"emali: ${Cursor.GetString(\"email\")} \"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("4589840",("emali: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(parent._cursor.GetString("email")))+" "),0);
RDebugUtils.currentLine=589841;
 //BA.debugLineNum = 589841;BA.debugLine="Log($\"password: ${Cursor.GetString(\"password\")";
anywheresoftware.b4a.keywords.Common.LogImpl("4589841",("password: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(parent._cursor.GetString("password")))+" "),0);
RDebugUtils.currentLine=589842;
 //BA.debugLineNum = 589842;BA.debugLine="Log($\"accountID: ${Cursor.GetString(\"accountID";
anywheresoftware.b4a.keywords.Common.LogImpl("4589842",("accountID: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(parent._cursor.GetString("accountID")))+" "),0);
RDebugUtils.currentLine=589843;
 //BA.debugLineNum = 589843;BA.debugLine="Log($\"balance: ${Cursor.GetString(\"balance\")}";
anywheresoftware.b4a.keywords.Common.LogImpl("4589843",("balance: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(parent._cursor.GetString("balance")))+" "),0);
 if (true) break;
if (true) break;

case 10:
//C
this.state = 13;
;
RDebugUtils.currentLine=589846;
 //BA.debugLineNum = 589846;BA.debugLine="UserName = rs.GetString(\"name\")";
parent.mostCurrent._username = _rs.GetString("name");
RDebugUtils.currentLine=589847;
 //BA.debugLineNum = 589847;BA.debugLine="Dashboard.ProfileName = UserName";
parent.mostCurrent._dashboard._profilename /*String*/  = parent.mostCurrent._username;
RDebugUtils.currentLine=589848;
 //BA.debugLineNum = 589848;BA.debugLine="account_id = rs.GetString(\"accountID\")";
parent._account_id = (int)(Double.parseDouble(_rs.GetString("accountID")));
RDebugUtils.currentLine=589849;
 //BA.debugLineNum = 589849;BA.debugLine="Dashboard.user_balance = rs.GetString(\"balance\"";
parent.mostCurrent._dashboard._user_balance /*double*/  = (double)(Double.parseDouble(_rs.GetString("balance")));
RDebugUtils.currentLine=589850;
 //BA.debugLineNum = 589850;BA.debugLine="StartActivity(Dashboard)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(parent.mostCurrent._dashboard.getObject()));
RDebugUtils.currentLine=589851;
 //BA.debugLineNum = 589851;BA.debugLine="result = True";
_result = anywheresoftware.b4a.keywords.Common.True;
 if (true) break;

case 12:
//C
this.state = 13;
RDebugUtils.currentLine=589853;
 //BA.debugLineNum = 589853;BA.debugLine="xui.MsgboxAsync(\"Invalid username and password";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("Invalid username and password"),BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=589854;
 //BA.debugLineNum = 589854;BA.debugLine="Email.Text = \"\"";
parent.mostCurrent._email._settext /*String*/ (null,"");
RDebugUtils.currentLine=589855;
 //BA.debugLineNum = 589855;BA.debugLine="Password.Text = \"\"";
parent.mostCurrent._password._settext /*String*/ (null,"");
RDebugUtils.currentLine=589856;
 //BA.debugLineNum = 589856;BA.debugLine="Email.RequestFocusAndShowKeyboard";
parent.mostCurrent._email._requestfocusandshowkeyboard /*String*/ (null);
RDebugUtils.currentLine=589857;
 //BA.debugLineNum = 589857;BA.debugLine="result = False";
_result = anywheresoftware.b4a.keywords.Common.False;
 if (true) break;

case 13:
//C
this.state = 16;
;
 if (true) break;

case 15:
//C
this.state = 16;
this.catchState = 0;
RDebugUtils.currentLine=589860;
 //BA.debugLineNum = 589860;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("4589860",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
RDebugUtils.currentLine=589861;
 //BA.debugLineNum = 589861;BA.debugLine="xui.MsgboxAsync(LastException, \"Error\")";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getObject()),BA.ObjectToCharSequence("Error"));
RDebugUtils.currentLine=589862;
 //BA.debugLineNum = 589862;BA.debugLine="result = False";
_result = anywheresoftware.b4a.keywords.Common.False;
 if (true) break;
if (true) break;

case 16:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=589865;
 //BA.debugLineNum = 589865;BA.debugLine="Return result";
if (true) {
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,(Object)(_result));return;};
RDebugUtils.currentLine=589866;
 //BA.debugLineNum = 589866;BA.debugLine="End Sub";
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
public static void  _loginbutton_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loginbutton_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "loginbutton_click", null); return;}
ResumableSub_LoginButton_Click rsub = new ResumableSub_LoginButton_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_LoginButton_Click extends BA.ResumableSub {
public ResumableSub_LoginButton_Click(b4a.example.main parent) {
this.parent = parent;
}
b4a.example.main parent;
boolean _success = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="If Email.Text = \"\" Then";
if (true) break;

case 1:
//if
this.state = 4;
if ((parent.mostCurrent._email._gettext /*String*/ (null)).equals("")) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="xui.MsgboxAsync(\"Email required\", \"\")";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("Email required"),BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=655364;
 //BA.debugLineNum = 655364;BA.debugLine="Email.RequestFocusAndShowKeyboard";
parent.mostCurrent._email._requestfocusandshowkeyboard /*String*/ (null);
RDebugUtils.currentLine=655365;
 //BA.debugLineNum = 655365;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
RDebugUtils.currentLine=655368;
 //BA.debugLineNum = 655368;BA.debugLine="If Password.Text = \"\" Then";

case 4:
//if
this.state = 7;
if ((parent.mostCurrent._password._gettext /*String*/ (null)).equals("")) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
RDebugUtils.currentLine=655369;
 //BA.debugLineNum = 655369;BA.debugLine="xui.MsgboxAsync(\"Password required\", \"\")";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("Password required"),BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=655370;
 //BA.debugLineNum = 655370;BA.debugLine="Password.RequestFocusAndShowKeyboard";
parent.mostCurrent._password._requestfocusandshowkeyboard /*String*/ (null);
RDebugUtils.currentLine=655371;
 //BA.debugLineNum = 655371;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
RDebugUtils.currentLine=655374;
 //BA.debugLineNum = 655374;BA.debugLine="Try";

case 7:
//try
this.state = 16;
this.catchState = 15;
this.state = 9;
if (true) break;

case 9:
//C
this.state = 10;
this.catchState = 15;
RDebugUtils.currentLine=655375;
 //BA.debugLineNum = 655375;BA.debugLine="Wait For (Login) Complete (Success As Boolean)";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "loginbutton_click"), _login());
this.state = 17;
return;
case 17:
//C
this.state = 10;
_success = (Boolean) result[0];
;
RDebugUtils.currentLine=655376;
 //BA.debugLineNum = 655376;BA.debugLine="If Success Then";
if (true) break;

case 10:
//if
this.state = 13;
if (_success) { 
this.state = 12;
}if (true) break;

case 12:
//C
this.state = 13;
RDebugUtils.currentLine=655377;
 //BA.debugLineNum = 655377;BA.debugLine="xui.MsgboxAsync(\"Login successfully\", \"\")";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("Login successfully"),BA.ObjectToCharSequence(""));
 if (true) break;

case 13:
//C
this.state = 16;
;
 if (true) break;

case 15:
//C
this.state = 16;
this.catchState = 0;
RDebugUtils.currentLine=655380;
 //BA.debugLineNum = 655380;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("4655380",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
RDebugUtils.currentLine=655381;
 //BA.debugLineNum = 655381;BA.debugLine="xui.MsgboxAsync(LastException, \"Error\")";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getObject()),BA.ObjectToCharSequence("Error"));
 if (true) break;
if (true) break;

case 16:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=655383;
 //BA.debugLineNum = 655383;BA.debugLine="End Sub";
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
public static String  _register_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "register_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "register_click", null));}
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Private Sub Register_Click";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="StartActivity(SignUp)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._signup.getObject()));
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=524291;
 //BA.debugLineNum = 524291;BA.debugLine="End Sub";
return "";
}
}