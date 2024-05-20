package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class addexpense_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (addexpense) ","addexpense",5,addexpense.mostCurrent.activityBA,addexpense.mostCurrent,24);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.addexpense.remoteMe.runUserSub(false, "addexpense","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 24;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 26;BA.debugLine="Activity.LoadLayout(\"AddExpense\")";
Debug.ShouldStop(33554432);
addexpense.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("AddExpense")),addexpense.mostCurrent.activityBA);
 BA.debugLineNum = 28;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("Activity_Pause (addexpense) ","addexpense",5,addexpense.mostCurrent.activityBA,addexpense.mostCurrent,34);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.addexpense.remoteMe.runUserSub(false, "addexpense","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 34;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(2);
 BA.debugLineNum = 36;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("Activity_Resume (addexpense) ","addexpense",5,addexpense.mostCurrent.activityBA,addexpense.mostCurrent,30);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.addexpense.remoteMe.runUserSub(false, "addexpense","activity_resume");}
 BA.debugLineNum = 30;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 32;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("AddMoney_Click (addexpense) ","addexpense",5,addexpense.mostCurrent.activityBA,addexpense.mostCurrent,65);
if (RapidSub.canDelegate("addmoney_click")) { b4a.example.addexpense.remoteMe.runUserSub(false, "addexpense","addmoney_click"); return;}
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
public ResumableSub_AddMoney_Click(b4a.example.addexpense parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.addexpense parent;
RemoteObject _query = RemoteObject.createImmutable("");
RemoteObject _rs = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
RemoteObject _success = RemoteObject.createImmutable(false);
int _i = 0;
int step19;
int limit19;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("AddMoney_Click (addexpense) ","addexpense",5,addexpense.mostCurrent.activityBA,addexpense.mostCurrent,65);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 67;BA.debugLine="Try";
Debug.ShouldStop(4);
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
 BA.debugLineNum = 68;BA.debugLine="Dim query As String = \"SELECT * FROM accounts WH";
Debug.ShouldStop(8);
_query = BA.ObjectToString("SELECT * FROM accounts WHERE accountID = ?");Debug.locals.put("query", _query);Debug.locals.put("query", _query);
 BA.debugLineNum = 69;BA.debugLine="Dim rs As ResultSet = Main.sql.ExecQuery2(query,";
Debug.ShouldStop(16);
_rs = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
_rs = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), parent.mostCurrent._main._sql /*RemoteObject*/ .runMethod(false,"ExecQuery2",(Object)(_query),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {BA.NumberToString(parent.mostCurrent._main._account_id /*RemoteObject*/ )}))));Debug.locals.put("rs", _rs);Debug.locals.put("rs", _rs);
 BA.debugLineNum = 71;BA.debugLine="If rs.NextRow Then";
Debug.ShouldStop(64);
if (true) break;

case 4:
//if
this.state = 11;
if (_rs.runMethod(true,"NextRow").<Boolean>get().booleanValue()) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 73;BA.debugLine="current_balance = rs.GetString(\"balance\")";
Debug.ShouldStop(256);
parent._current_balance = BA.numberCast(double.class, _rs.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("balance"))));
 BA.debugLineNum = 75;BA.debugLine="If InputMoney.Text > current_balance Then";
Debug.ShouldStop(1024);
if (true) break;

case 7:
//if
this.state = 10;
if (RemoteObject.solveBoolean(">",BA.numberCast(double.class, parent.mostCurrent._inputmoney.runClassMethod (b4a.example.b4xfloattextfield.class, "_gettext" /*RemoteObject*/ )),parent._current_balance)) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 BA.debugLineNum = 76;BA.debugLine="xui.MsgboxAsync(\"The amount exceeds your curre";
Debug.ShouldStop(2048);
parent._xui.runVoidMethod ("MsgboxAsync",addexpense.processBA,(Object)(BA.ObjectToCharSequence("The amount exceeds your current balance. Please review your current balance.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable(""))));
 BA.debugLineNum = 77;BA.debugLine="Return";
Debug.ShouldStop(4096);
Debug.CheckDeviceExceptions();if (true) return ;
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
 BA.debugLineNum = 83;BA.debugLine="Log(LastException)";
Debug.ShouldStop(262144);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","431195154",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",addexpense.mostCurrent.activityBA)),0);
 BA.debugLineNum = 84;BA.debugLine="xui.MsgboxAsync(LastException,\"Error\")";
Debug.ShouldStop(524288);
parent._xui.runVoidMethod ("MsgboxAsync",addexpense.processBA,(Object)(BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(false,"LastException",addexpense.mostCurrent.activityBA).getObject())),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 if (true) break;
if (true) break;
;
 BA.debugLineNum = 87;BA.debugLine="Try";
Debug.ShouldStop(4194304);

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
 BA.debugLineNum = 88;BA.debugLine="Wait For (InsertExpense) Complete (Success As Bo";
Debug.ShouldStop(8388608);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","complete", addexpense.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "addexpense", "addmoney_click"), _insertexpense());
this.state = 36;
return;
case 36:
//C
this.state = 17;
_success = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Success", _success);
;
 BA.debugLineNum = 89;BA.debugLine="If Success Then";
Debug.ShouldStop(16777216);
if (true) break;

case 17:
//if
this.state = 32;
if (_success.<Boolean>get().booleanValue()) { 
this.state = 19;
}if (true) break;

case 19:
//C
this.state = 20;
 BA.debugLineNum = 91;BA.debugLine="Cursor = Main.sql.ExecQuery(\"SELECT * FROM acco";
Debug.ShouldStop(67108864);
parent._cursor = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), parent.mostCurrent._main._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM accounts_expense"))));
 BA.debugLineNum = 92;BA.debugLine="For i = 0 To Cursor.RowCount - 1";
Debug.ShouldStop(134217728);
if (true) break;

case 20:
//for
this.state = 23;
step19 = 1;
limit19 = RemoteObject.solve(new RemoteObject[] {parent._cursor.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
Debug.locals.put("i", _i);
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
Debug.locals.put("i", _i);
if (true) break;

case 22:
//C
this.state = 38;
 BA.debugLineNum = 93;BA.debugLine="Cursor.Position = i";
Debug.ShouldStop(268435456);
parent._cursor.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 95;BA.debugLine="Log($\"expenseID: ${Cursor.GetString(\"expenseID";
Debug.ShouldStop(1073741824);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","431195166",(RemoteObject.concat(RemoteObject.createImmutable("expenseID: "),parent.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((parent._cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("expenseID")))))),RemoteObject.createImmutable(" "))),0);
 BA.debugLineNum = 96;BA.debugLine="Log($\"account_id: ${Cursor.GetString(\"account_";
Debug.ShouldStop(-2147483648);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","431195167",(RemoteObject.concat(RemoteObject.createImmutable("account_id: "),parent.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((parent._cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("account_id")))))),RemoteObject.createImmutable(" "))),0);
 BA.debugLineNum = 97;BA.debugLine="Log($\"expense_amount: ${Cursor.GetString(\"expe";
Debug.ShouldStop(1);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","431195168",(RemoteObject.concat(RemoteObject.createImmutable("expense_amount: "),parent.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((parent._cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("expense_amount")))))),RemoteObject.createImmutable(" "))),0);
 BA.debugLineNum = 98;BA.debugLine="Log($\"purpose: ${Cursor.GetString(\"purpose\")}";
Debug.ShouldStop(2);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","431195169",(RemoteObject.concat(RemoteObject.createImmutable("purpose: "),parent.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((parent._cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("purpose")))))),RemoteObject.createImmutable(" "))),0);
 if (true) break;
if (true) break;

case 23:
//C
this.state = 24;
Debug.locals.put("i", _i);
;
 BA.debugLineNum = 101;BA.debugLine="Wait For (UpdateBalance) Complete (Success As B";
Debug.ShouldStop(16);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","complete", addexpense.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "addexpense", "addmoney_click"), _updatebalance());
this.state = 39;
return;
case 39:
//C
this.state = 24;
_success = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Success", _success);
;
 BA.debugLineNum = 102;BA.debugLine="If Success Then";
Debug.ShouldStop(32);
if (true) break;

case 24:
//if
this.state = 31;
if (_success.<Boolean>get().booleanValue()) { 
this.state = 26;
}if (true) break;

case 26:
//C
this.state = 27;
 BA.debugLineNum = 104;BA.debugLine="Dim query As String = \"SELECT * FROM accounts";
Debug.ShouldStop(128);
_query = BA.ObjectToString("SELECT * FROM accounts WHERE accountID = ?");Debug.locals.put("query", _query);Debug.locals.put("query", _query);
 BA.debugLineNum = 105;BA.debugLine="Dim rs As ResultSet = Main.sql.ExecQuery2(quer";
Debug.ShouldStop(256);
_rs = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
_rs = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), parent.mostCurrent._main._sql /*RemoteObject*/ .runMethod(false,"ExecQuery2",(Object)(_query),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {BA.NumberToString(parent.mostCurrent._main._account_id /*RemoteObject*/ )}))));Debug.locals.put("rs", _rs);Debug.locals.put("rs", _rs);
 BA.debugLineNum = 107;BA.debugLine="If rs.NextRow Then";
Debug.ShouldStop(1024);
if (true) break;

case 27:
//if
this.state = 30;
if (_rs.runMethod(true,"NextRow").<Boolean>get().booleanValue()) { 
this.state = 29;
}if (true) break;

case 29:
//C
this.state = 30;
 BA.debugLineNum = 109;BA.debugLine="Dashboard.user_balance = rs.GetString(\"balanc";
Debug.ShouldStop(4096);
parent.mostCurrent._dashboard._user_balance /*RemoteObject*/  = BA.numberCast(double.class, _rs.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("balance"))));
 BA.debugLineNum = 110;BA.debugLine="xui.MsgboxAsync(\"Expense successfully added.";
Debug.ShouldStop(8192);
parent._xui.runVoidMethod ("MsgboxAsync",addexpense.processBA,(Object)(BA.ObjectToCharSequence("Expense successfully added. Balance updated.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable(""))));
 BA.debugLineNum = 111;BA.debugLine="StartActivity(Dashboard)";
Debug.ShouldStop(16384);
parent.mostCurrent.__c.runVoidMethod ("StartActivity",addexpense.processBA,(Object)((parent.mostCurrent._dashboard.getObject())));
 BA.debugLineNum = 112;BA.debugLine="Activity.Finish";
Debug.ShouldStop(32768);
parent.mostCurrent._activity.runVoidMethod ("Finish");
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
 Debug.CheckDeviceExceptions();
if (true) break;

case 34:
//C
this.state = 35;
this.catchState = 0;
 BA.debugLineNum = 119;BA.debugLine="Log(LastException)";
Debug.ShouldStop(4194304);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","431195190",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",addexpense.mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 35:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 122;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",addexpense.processBA, e0.toString());}
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
 //BA.debugLineNum = 16;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 20;BA.debugLine="Private InputMoney As B4XFloatTextField";
addexpense.mostCurrent._inputmoney = RemoteObject.createNew ("b4a.example.b4xfloattextfield");
 //BA.debugLineNum = 21;BA.debugLine="Private Purpose As B4XFloatTextField";
addexpense.mostCurrent._purpose = RemoteObject.createNew ("b4a.example.b4xfloattextfield");
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _goback_click() throws Exception{
try {
		Debug.PushSubsStack("GoBack_Click (addexpense) ","addexpense",5,addexpense.mostCurrent.activityBA,addexpense.mostCurrent,38);
if (RapidSub.canDelegate("goback_click")) { return b4a.example.addexpense.remoteMe.runUserSub(false, "addexpense","goback_click");}
 BA.debugLineNum = 38;BA.debugLine="Private Sub GoBack_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 39;BA.debugLine="StartActivity(Dashboard)";
Debug.ShouldStop(64);
addexpense.mostCurrent.__c.runVoidMethod ("StartActivity",addexpense.processBA,(Object)((addexpense.mostCurrent._dashboard.getObject())));
 BA.debugLineNum = 40;BA.debugLine="Activity.Finish";
Debug.ShouldStop(128);
addexpense.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 41;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _insertexpense() throws Exception{
try {
		Debug.PushSubsStack("InsertExpense (addexpense) ","addexpense",5,addexpense.mostCurrent.activityBA,addexpense.mostCurrent,43);
if (RapidSub.canDelegate("insertexpense")) { return b4a.example.addexpense.remoteMe.runUserSub(false, "addexpense","insertexpense");}
ResumableSub_InsertExpense rsub = new ResumableSub_InsertExpense(null);
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
public static class ResumableSub_InsertExpense extends BA.ResumableSub {
public ResumableSub_InsertExpense(b4a.example.addexpense parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.addexpense parent;
RemoteObject _result = RemoteObject.createImmutable(false);
RemoteObject _query = RemoteObject.createImmutable("");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("InsertExpense (addexpense) ","addexpense",5,addexpense.mostCurrent.activityBA,addexpense.mostCurrent,43);
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
 BA.debugLineNum = 45;BA.debugLine="Dim result As Boolean";
Debug.ShouldStop(4096);
_result = RemoteObject.createImmutable(false);Debug.locals.put("result", _result);
 BA.debugLineNum = 47;BA.debugLine="If InputMoney.Text = \"\" Or Purpose.Text = \"\" Then";
Debug.ShouldStop(16384);
if (true) break;

case 1:
//if
this.state = 4;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._inputmoney.runClassMethod (b4a.example.b4xfloattextfield.class, "_gettext" /*RemoteObject*/ ),BA.ObjectToString("")) || RemoteObject.solveBoolean("=",parent.mostCurrent._purpose.runClassMethod (b4a.example.b4xfloattextfield.class, "_gettext" /*RemoteObject*/ ),BA.ObjectToString(""))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 48;BA.debugLine="xui.MsgboxAsync(\"Please fill the required fields";
Debug.ShouldStop(32768);
parent._xui.runVoidMethod ("MsgboxAsync",addexpense.processBA,(Object)(BA.ObjectToCharSequence("Please fill the required fields")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable(""))));
 BA.debugLineNum = 49;BA.debugLine="Return";
Debug.ShouldStop(65536);
Debug.CheckDeviceExceptions();if (true) {
parent.mostCurrent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,RemoteObject.createImmutable(null));return;};
 if (true) break;
;
 BA.debugLineNum = 52;BA.debugLine="Try";
Debug.ShouldStop(524288);

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
 BA.debugLineNum = 53;BA.debugLine="Dim query As String = $\"INSERT INTO accounts_exp";
Debug.ShouldStop(1048576);
_query = (RemoteObject.createImmutable("INSERT INTO accounts_expense (account_id, expense_amount, purpose) VALUES (?,?,?)"));Debug.locals.put("query", _query);Debug.locals.put("query", _query);
 BA.debugLineNum = 54;BA.debugLine="Main.sql.ExecNonQuery2(query, Array As Object(Ma";
Debug.ShouldStop(2097152);
parent.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery2",(Object)(_query),(Object)(parent.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {3},new Object[] {(parent.mostCurrent._main._account_id /*RemoteObject*/ ),(parent.mostCurrent._inputmoney.runClassMethod (b4a.example.b4xfloattextfield.class, "_gettext" /*RemoteObject*/ )),(parent.mostCurrent._purpose.runClassMethod (b4a.example.b4xfloattextfield.class, "_gettext" /*RemoteObject*/ ))})))));
 BA.debugLineNum = 55;BA.debugLine="result = True";
Debug.ShouldStop(4194304);
_result = parent.mostCurrent.__c.getField(true,"True");Debug.locals.put("result", _result);
 Debug.CheckDeviceExceptions();
if (true) break;

case 8:
//C
this.state = 9;
this.catchState = 0;
 BA.debugLineNum = 57;BA.debugLine="Log(LastException)";
Debug.ShouldStop(16777216);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","433488910",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",addexpense.mostCurrent.activityBA)),0);
 BA.debugLineNum = 58;BA.debugLine="xui.MsgboxAsync(LastException,\"Error\")";
Debug.ShouldStop(33554432);
parent._xui.runVoidMethod ("MsgboxAsync",addexpense.processBA,(Object)(BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(false,"LastException",addexpense.mostCurrent.activityBA).getObject())),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 BA.debugLineNum = 59;BA.debugLine="result = False";
Debug.ShouldStop(67108864);
_result = parent.mostCurrent.__c.getField(true,"False");Debug.locals.put("result", _result);
 if (true) break;
if (true) break;

case 9:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 62;BA.debugLine="Return result";
Debug.ShouldStop(536870912);
Debug.CheckDeviceExceptions();if (true) {
parent.mostCurrent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,(_result));return;};
 BA.debugLineNum = 63;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",addexpense.processBA, e0.toString());}
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="Private xui As XUI";
addexpense._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 11;BA.debugLine="Private Cursor As Cursor";
addexpense._cursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 //BA.debugLineNum = 12;BA.debugLine="Dim updated_balance As Double";
addexpense._updated_balance = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 13;BA.debugLine="Dim current_balance As Double";
addexpense._current_balance = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _updatebalance() throws Exception{
try {
		Debug.PushSubsStack("UpdateBalance (addexpense) ","addexpense",5,addexpense.mostCurrent.activityBA,addexpense.mostCurrent,124);
if (RapidSub.canDelegate("updatebalance")) { return b4a.example.addexpense.remoteMe.runUserSub(false, "addexpense","updatebalance");}
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
public ResumableSub_UpdateBalance(b4a.example.addexpense parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.addexpense parent;
RemoteObject _result = RemoteObject.createImmutable(false);
RemoteObject _query = RemoteObject.createImmutable("");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("UpdateBalance (addexpense) ","addexpense",5,addexpense.mostCurrent.activityBA,addexpense.mostCurrent,124);
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
 BA.debugLineNum = 126;BA.debugLine="Dim result As Boolean";
Debug.ShouldStop(536870912);
_result = RemoteObject.createImmutable(false);Debug.locals.put("result", _result);
 BA.debugLineNum = 128;BA.debugLine="Try";
Debug.ShouldStop(-2147483648);
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
 BA.debugLineNum = 129;BA.debugLine="Dim query As String = $\"UPDATE accounts SET bala";
Debug.ShouldStop(1);
_query = (RemoteObject.createImmutable("UPDATE accounts SET balance = balance - ? WHERE accountID = ?"));Debug.locals.put("query", _query);Debug.locals.put("query", _query);
 BA.debugLineNum = 130;BA.debugLine="Main.sql.ExecNonQuery2(query, Array As Object(In";
Debug.ShouldStop(2);
parent.mostCurrent._main._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery2",(Object)(_query),(Object)(parent.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(parent.mostCurrent._inputmoney.runClassMethod (b4a.example.b4xfloattextfield.class, "_gettext" /*RemoteObject*/ )),(parent.mostCurrent._main._account_id /*RemoteObject*/ )})))));
 BA.debugLineNum = 131;BA.debugLine="result = True";
Debug.ShouldStop(4);
_result = parent.mostCurrent.__c.getField(true,"True");Debug.locals.put("result", _result);
 Debug.CheckDeviceExceptions();
if (true) break;

case 5:
//C
this.state = 6;
this.catchState = 0;
 BA.debugLineNum = 133;BA.debugLine="Log(LastException)";
Debug.ShouldStop(16);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","432636937",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",addexpense.mostCurrent.activityBA)),0);
 BA.debugLineNum = 134;BA.debugLine="xui.MsgboxAsync(LastException,\"Error\")";
Debug.ShouldStop(32);
parent._xui.runVoidMethod ("MsgboxAsync",addexpense.processBA,(Object)(BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(false,"LastException",addexpense.mostCurrent.activityBA).getObject())),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 BA.debugLineNum = 135;BA.debugLine="result = False";
Debug.ShouldStop(64);
_result = parent.mostCurrent.__c.getField(true,"False");Debug.locals.put("result", _result);
 if (true) break;
if (true) break;

case 6:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 138;BA.debugLine="Return result";
Debug.ShouldStop(512);
Debug.CheckDeviceExceptions();if (true) {
parent.mostCurrent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,(_result));return;};
 BA.debugLineNum = 139;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",addexpense.processBA, e0.toString());}
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