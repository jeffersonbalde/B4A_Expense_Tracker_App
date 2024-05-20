package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class addbalance_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (addbalance) ","addbalance",4,addbalance.mostCurrent.activityBA,addbalance.mostCurrent,21);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.addbalance.remoteMe.runUserSub(false, "addbalance","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 21;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 23;BA.debugLine="Activity.LoadLayout(\"Add_Balance\")";
Debug.ShouldStop(4194304);
addbalance.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Add_Balance")),addbalance.mostCurrent.activityBA);
 BA.debugLineNum = 25;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("Activity_Pause (addbalance) ","addbalance",4,addbalance.mostCurrent.activityBA,addbalance.mostCurrent,31);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.addbalance.remoteMe.runUserSub(false, "addbalance","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 31;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 33;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("Activity_Resume (addbalance) ","addbalance",4,addbalance.mostCurrent.activityBA,addbalance.mostCurrent,27);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.addbalance.remoteMe.runUserSub(false, "addbalance","activity_resume");}
 BA.debugLineNum = 27;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 29;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _addmoney_click() throws Exception{
try {
		Debug.PushSubsStack("AddMoney_Click (addbalance) ","addbalance",4,addbalance.mostCurrent.activityBA,addbalance.mostCurrent,64);
if (RapidSub.canDelegate("addmoney_click")) { b4a.example.addbalance.remoteMe.runUserSub(false, "addbalance","addmoney_click"); return;}
ResumableSub_AddMoney_Click rsub = new ResumableSub_AddMoney_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_AddMoney_Click extends BA.ResumableSub {
public ResumableSub_AddMoney_Click(b4a.example.addbalance parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.addbalance parent;
RemoteObject _success = RemoteObject.createImmutable(false);
RemoteObject _query = RemoteObject.createImmutable("");
RemoteObject _rs = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("AddMoney_Click (addbalance) ","addbalance",4,addbalance.mostCurrent.activityBA,addbalance.mostCurrent,64);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 65;BA.debugLine="Try";
Debug.ShouldStop(1);
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
 BA.debugLineNum = 66;BA.debugLine="Wait For (UpdateBalance) Complete (Success As Bo";
Debug.ShouldStop(2);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","complete", addbalance.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "addbalance", "addmoney_click"), _updatebalance());
this.state = 15;
return;
case 15:
//C
this.state = 4;
_success = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Success", _success);
;
 BA.debugLineNum = 67;BA.debugLine="If Success Then";
Debug.ShouldStop(4);
if (true) break;

case 4:
//if
this.state = 11;
if (_success.<Boolean>get().booleanValue()) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 69;BA.debugLine="Dim query As String = \"SELECT * FROM accounts W";
Debug.ShouldStop(16);
_query = BA.ObjectToString("SELECT * FROM accounts WHERE accountID = ?");Debug.locals.put("query", _query);Debug.locals.put("query", _query);
 BA.debugLineNum = 71;BA.debugLine="Dim rs As ResultSet = Main.sql.ExecQuery2(query";
Debug.ShouldStop(64);
_rs = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
_rs = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), parent.mostCurrent._main._sql /*RemoteObject*/ .runMethod(false,"ExecQuery2",(Object)(_query),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {BA.NumberToString(parent.mostCurrent._main._account_id /*RemoteObject*/ )}))));Debug.locals.put("rs", _rs);Debug.locals.put("rs", _rs);
 BA.debugLineNum = 73;BA.debugLine="If rs.NextRow Then";
Debug.ShouldStop(256);
if (true) break;

case 7:
//if
this.state = 10;
if (_rs.runMethod(true,"NextRow").<Boolean>get().booleanValue()) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 BA.debugLineNum = 74;BA.debugLine="xui.MsgboxAsync(\"Balance updated\", \"\")";
Debug.ShouldStop(512);
parent._xui.runVoidMethod ("MsgboxAsync",addbalance.processBA,(Object)(BA.ObjectToCharSequence("Balance updated")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable(""))));
 BA.debugLineNum = 75;BA.debugLine="Dashboard.user_balance = rs.GetString(\"balance";
Debug.ShouldStop(1024);
parent.mostCurrent._dashboard._user_balance /*RemoteObject*/  = BA.numberCast(double.class, _rs.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("balance"))));
 BA.debugLineNum = 76;BA.debugLine="StartActivity(Dashboard)";
Debug.ShouldStop(2048);
parent.mostCurrent.__c.runVoidMethod ("StartActivity",addbalance.processBA,(Object)((parent.mostCurrent._dashboard.getObject())));
 BA.debugLineNum = 77;BA.debugLine="Activity.Finish";
Debug.ShouldStop(4096);
parent.mostCurrent._activity.runVoidMethod ("Finish");
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
 Debug.CheckDeviceExceptions();
if (true) break;

case 13:
//C
this.state = 14;
this.catchState = 0;
 BA.debugLineNum = 82;BA.debugLine="Log(LastException)";
Debug.ShouldStop(131072);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","429949970",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",addbalance.mostCurrent.activityBA)),0);
 BA.debugLineNum = 83;BA.debugLine="xui.MsgboxAsync(LastException,\"Error\")";
Debug.ShouldStop(262144);
parent._xui.runVoidMethod ("MsgboxAsync",addbalance.processBA,(Object)(BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(false,"LastException",addbalance.mostCurrent.activityBA).getObject())),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 if (true) break;
if (true) break;

case 14:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 85;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",addbalance.processBA, e0.toString());}
            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _complete(RemoteObject _success) throws Exception{
}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private InputMoney As B4XFloatTextField";
addbalance.mostCurrent._inputmoney = RemoteObject.createNew ("b4a.example.b4xfloattextfield");
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _goback_click() throws Exception{
try {
		Debug.PushSubsStack("GoBack_Click (addbalance) ","addbalance",4,addbalance.mostCurrent.activityBA,addbalance.mostCurrent,35);
if (RapidSub.canDelegate("goback_click")) { return b4a.example.addbalance.remoteMe.runUserSub(false, "addbalance","goback_click");}
 BA.debugLineNum = 35;BA.debugLine="Private Sub GoBack_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 36;BA.debugLine="StartActivity(Dashboard)";
Debug.ShouldStop(8);
addbalance.mostCurrent.__c.runVoidMethod ("StartActivity",addbalance.processBA,(Object)((addbalance.mostCurrent._dashboard.getObject())));
 BA.debugLineNum = 37;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16);
addbalance.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 38;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
 //BA.debugLineNum = 10;BA.debugLine="Private xui As XUI";
addbalance._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 11;BA.debugLine="Dim Cursor As Cursor";
addbalance._cursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _updatebalance() throws Exception{
try {
		Debug.PushSubsStack("UpdateBalance (addbalance) ","addbalance",4,addbalance.mostCurrent.activityBA,addbalance.mostCurrent,40);
if (RapidSub.canDelegate("updatebalance")) { return b4a.example.addbalance.remoteMe.runUserSub(false, "addbalance","updatebalance");}
ResumableSub_UpdateBalance rsub = new ResumableSub_UpdateBalance(null);
rsub.remoteResumableSub = anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSubForFilter();
rsub.resume(null, null);
return RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.keywords.Common.ResumableSubWrapper"), rsub.remoteResumableSub);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_UpdateBalance extends BA.ResumableSub {
public ResumableSub_UpdateBalance(b4a.example.addbalance parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.addbalance parent;
RemoteObject _result = RemoteObject.createImmutable(false);
RemoteObject _query = RemoteObject.createImmutable("");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("UpdateBalance (addbalance) ","addbalance",4,addbalance.mostCurrent.activityBA,addbalance.mostCurrent,40);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
{
parent.mostCurrent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,RemoteObject.createImmutable(null));return;}
case 0:
//C
this.state = 1;
 BA.debugLineNum = 42;BA.debugLine="Dim result As Boolean";
Debug.ShouldStop(512);
_result = RemoteObject.createImmutable(false);Debug.locals.put("result", _result);
 BA.debugLineNum = 44;BA.debugLine="If InputMoney.Text = \"\" Then";
Debug.ShouldStop(2048);
if (true) break;

case 1:
//if
this.state = 4;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._inputmoney.runClassMethod (b4a.example.b4xfloattextfield.class, "_gettext" /*RemoteObject*/ ),BA.ObjectToString(""))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 45;BA.debugLine="xui.MsgboxAsync(\"Please fill the required field\"";
Debug.ShouldStop(4096);
parent._xui.runVoidMethod ("MsgboxAsync",addbalance.processBA,(Object)(BA.ObjectToCharSequence("Please fill the required field")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable(""))));
 BA.debugLineNum = 46;BA.debugLine="Return";
Debug.ShouldStop(8192);
Debug.CheckDeviceExceptions();if (true) {
parent.mostCurrent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,RemoteObject.createImmutable(null));return;};
 if (true) break;
;
 BA.debugLineNum = 49;BA.debugLine="Try";
Debug.ShouldStop(65536);

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
 BA.debugLineNum = 50;BA.debugLine="Dim query As String = $\"UPDATE accounts SET bala";
Debug.ShouldStop(131072);
_query = (RemoteObject.createImmutable("UPDATE accounts SET balance = balance + ? WHERE accountID = ?"));Debug.locals.put("query", _query);Debug.locals.put("query", _query);
 BA.debugLineNum = 52;BA.debugLine="Main.sql.ExecNonQuery2(query, Array As Object(In";
Debug.ShouldStop(524288);
parent.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery2",(Object)(_query),(Object)(parent.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(parent.mostCurrent._inputmoney.runClassMethod (b4a.example.b4xfloattextfield.class, "_gettext" /*RemoteObject*/ )),(parent.mostCurrent._main._account_id /*RemoteObject*/ )})))));
 BA.debugLineNum = 54;BA.debugLine="result = True";
Debug.ShouldStop(2097152);
_result = parent.mostCurrent.__c.getField(true,"True");Debug.locals.put("result", _result);
 Debug.CheckDeviceExceptions();
if (true) break;

case 8:
//C
this.state = 9;
this.catchState = 0;
 BA.debugLineNum = 56;BA.debugLine="Log(LastException)";
Debug.ShouldStop(8388608);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","429884432",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",addbalance.mostCurrent.activityBA)),0);
 BA.debugLineNum = 57;BA.debugLine="xui.MsgboxAsync(LastException,\"Error\")";
Debug.ShouldStop(16777216);
parent._xui.runVoidMethod ("MsgboxAsync",addbalance.processBA,(Object)(BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(false,"LastException",addbalance.mostCurrent.activityBA).getObject())),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 BA.debugLineNum = 58;BA.debugLine="result = False";
Debug.ShouldStop(33554432);
_result = parent.mostCurrent.__c.getField(true,"False");Debug.locals.put("result", _result);
 if (true) break;
if (true) break;

case 9:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 61;BA.debugLine="Return result";
Debug.ShouldStop(268435456);
Debug.CheckDeviceExceptions();if (true) {
parent.mostCurrent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,(_result));return;};
 BA.debugLineNum = 62;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",addbalance.processBA, e0.toString());}
            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
}