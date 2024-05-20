package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class dashboard_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (dashboard) ","dashboard",2,dashboard.mostCurrent.activityBA,dashboard.mostCurrent,26);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.dashboard.remoteMe.runUserSub(false, "dashboard","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 26;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 28;BA.debugLine="Activity.LoadLayout(\"Dashboard\")";
Debug.ShouldStop(134217728);
dashboard.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Dashboard")),dashboard.mostCurrent.activityBA);
 BA.debugLineNum = 30;BA.debugLine="NameOfUser.Text = ProfileName";
Debug.ShouldStop(536870912);
dashboard.mostCurrent._nameofuser.runMethod(true,"setText",BA.ObjectToCharSequence(dashboard._profilename));
 BA.debugLineNum = 31;BA.debugLine="CurrentMoney.Text = user_balance";
Debug.ShouldStop(1073741824);
dashboard.mostCurrent._currentmoney.runMethod(true,"setText",BA.ObjectToCharSequence(dashboard._user_balance));
 BA.debugLineNum = 33;BA.debugLine="ListView1.TwoLinesLayout.Label.TextColor = Colors";
Debug.ShouldStop(1);
dashboard.mostCurrent._listview1.runMethod(false,"getTwoLinesLayout").getField(false,"Label").runMethod(true,"setTextColor",dashboard.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 34;BA.debugLine="ListView1.TwoLinesLayout.Label.TextSize = 30";
Debug.ShouldStop(2);
dashboard.mostCurrent._listview1.runMethod(false,"getTwoLinesLayout").getField(false,"Label").runMethod(true,"setTextSize",BA.numberCast(float.class, 30));
 BA.debugLineNum = 35;BA.debugLine="ListView1.TwoLinesLayout.SecondLabel.TextColor =";
Debug.ShouldStop(4);
dashboard.mostCurrent._listview1.runMethod(false,"getTwoLinesLayout").getField(false,"SecondLabel").runMethod(true,"setTextColor",dashboard.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 36;BA.debugLine="ListView1.TwoLinesLayout.Label.TextSize = 30";
Debug.ShouldStop(8);
dashboard.mostCurrent._listview1.runMethod(false,"getTwoLinesLayout").getField(false,"Label").runMethod(true,"setTextSize",BA.numberCast(float.class, 30));
 BA.debugLineNum = 38;BA.debugLine="ShowExpense";
Debug.ShouldStop(32);
_showexpense();
 BA.debugLineNum = 56;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (dashboard) ","dashboard",2,dashboard.mostCurrent.activityBA,dashboard.mostCurrent,62);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.dashboard.remoteMe.runUserSub(false, "dashboard","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 62;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 64;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (dashboard) ","dashboard",2,dashboard.mostCurrent.activityBA,dashboard.mostCurrent,58);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.dashboard.remoteMe.runUserSub(false, "dashboard","activity_resume");}
 BA.debugLineNum = 58;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 60;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addcash_click() throws Exception{
try {
		Debug.PushSubsStack("AddCash_Click (dashboard) ","dashboard",2,dashboard.mostCurrent.activityBA,dashboard.mostCurrent,66);
if (RapidSub.canDelegate("addcash_click")) { return b4a.example.dashboard.remoteMe.runUserSub(false, "dashboard","addcash_click");}
 BA.debugLineNum = 66;BA.debugLine="Private Sub AddCash_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 67;BA.debugLine="StartActivity(AddBalance)";
Debug.ShouldStop(4);
dashboard.mostCurrent.__c.runVoidMethod ("StartActivity",dashboard.processBA,(Object)((dashboard.mostCurrent._addbalance.getObject())));
 BA.debugLineNum = 68;BA.debugLine="Activity.Finish";
Debug.ShouldStop(8);
dashboard.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 69;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addmoney_click() throws Exception{
try {
		Debug.PushSubsStack("AddMoney_Click (dashboard) ","dashboard",2,dashboard.mostCurrent.activityBA,dashboard.mostCurrent,76);
if (RapidSub.canDelegate("addmoney_click")) { return b4a.example.dashboard.remoteMe.runUserSub(false, "dashboard","addmoney_click");}
 BA.debugLineNum = 76;BA.debugLine="Private Sub AddMoney_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 77;BA.debugLine="StartActivity(AddExpense)";
Debug.ShouldStop(4096);
dashboard.mostCurrent.__c.runVoidMethod ("StartActivity",dashboard.processBA,(Object)((dashboard.mostCurrent._addexpense.getObject())));
 BA.debugLineNum = 78;BA.debugLine="Activity.Finish";
Debug.ShouldStop(8192);
dashboard.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 79;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 18;BA.debugLine="Dim result As Boolean";
dashboard._result = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 20;BA.debugLine="Dim Cursor As Cursor";
dashboard._cursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private NameOfUser As Label";
dashboard.mostCurrent._nameofuser = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private CurrentMoney As Label";
dashboard.mostCurrent._currentmoney = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private ListView1 As ListView";
dashboard.mostCurrent._listview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _logout_click() throws Exception{
try {
		Debug.PushSubsStack("Logout_Click (dashboard) ","dashboard",2,dashboard.mostCurrent.activityBA,dashboard.mostCurrent,71);
if (RapidSub.canDelegate("logout_click")) { return b4a.example.dashboard.remoteMe.runUserSub(false, "dashboard","logout_click");}
 BA.debugLineNum = 71;BA.debugLine="Private Sub Logout_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 72;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(128);
dashboard.mostCurrent.__c.runVoidMethod ("StartActivity",dashboard.processBA,(Object)((dashboard.mostCurrent._main.getObject())));
 BA.debugLineNum = 73;BA.debugLine="Activity.Finish";
Debug.ShouldStop(256);
dashboard.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 74;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim ProfileName As String";
dashboard._profilename = RemoteObject.createImmutable("");
 //BA.debugLineNum = 10;BA.debugLine="Dim user_balance As Double";
dashboard._user_balance = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 12;BA.debugLine="Private Cursor As Cursor";
dashboard._cursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _showexpense() throws Exception{
try {
		Debug.PushSubsStack("ShowExpense (dashboard) ","dashboard",2,dashboard.mostCurrent.activityBA,dashboard.mostCurrent,81);
if (RapidSub.canDelegate("showexpense")) { return b4a.example.dashboard.remoteMe.runUserSub(false, "dashboard","showexpense");}
int _i = 0;
 BA.debugLineNum = 81;BA.debugLine="Private Sub ShowExpense";
Debug.ShouldStop(65536);
 BA.debugLineNum = 83;BA.debugLine="ListView1.Clear";
Debug.ShouldStop(262144);
dashboard.mostCurrent._listview1.runVoidMethod ("Clear");
 BA.debugLineNum = 84;BA.debugLine="Cursor = Main.sql.ExecQuery(\"SELECT * FROM accoun";
Debug.ShouldStop(524288);
dashboard._cursor = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), dashboard.mostCurrent._main._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM accounts_expense"))));
 BA.debugLineNum = 85;BA.debugLine="For i = 0 To Cursor.RowCount - 1";
Debug.ShouldStop(1048576);
{
final int step3 = 1;
final int limit3 = RemoteObject.solve(new RemoteObject[] {dashboard._cursor.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3) ;_i = ((int)(0 + _i + step3))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 86;BA.debugLine="Cursor.Position = i";
Debug.ShouldStop(2097152);
dashboard._cursor.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 87;BA.debugLine="ListView1.AddTwoLines(Cursor.GetString(\"expense_";
Debug.ShouldStop(4194304);
dashboard.mostCurrent._listview1.runVoidMethod ("AddTwoLines",(Object)(BA.ObjectToCharSequence(dashboard._cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("expense_amount"))))),(Object)(BA.ObjectToCharSequence(dashboard._cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("purpose"))))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 97;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}