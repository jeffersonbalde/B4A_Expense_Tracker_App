package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static void  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,32);
if (RapidSub.canDelegate("activity_create")) { b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime); return;}
ResumableSub_Activity_Create rsub = new ResumableSub_Activity_Create(null,_firsttime);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_Activity_Create extends BA.ResumableSub {
public ResumableSub_Activity_Create(b4a.example.main parent,RemoteObject _firsttime) {
this.parent = parent;
this._firsttime = _firsttime;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.main parent;
RemoteObject _firsttime;
RemoteObject _success = RemoteObject.createImmutable(false);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,32);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 33;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(1);
if (true) break;

case 1:
//if
this.state = 4;
if (_firsttime.<Boolean>get().booleanValue()) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 34;BA.debugLine="sql.Initialize(File.DirInternal, \"test.db\", True";
Debug.ShouldStop(2);
parent._sql.runVoidMethod ("Initialize",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("test.db")),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 if (true) break;

case 4:
//C
this.state = 5;
;
 BA.debugLineNum = 42;BA.debugLine="Wait For (createTableAccounts) Complete (Success";
Debug.ShouldStop(512);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","complete", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "activity_create"), _createtableaccounts());
this.state = 13;
return;
case 13:
//C
this.state = 5;
_success = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Success", _success);
;
 BA.debugLineNum = 43;BA.debugLine="If Success Then'";
Debug.ShouldStop(1024);
if (true) break;

case 5:
//if
this.state = 8;
if (_success.<Boolean>get().booleanValue()) { 
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
 BA.debugLineNum = 58;BA.debugLine="Wait For (createTableAccountExpense) Complete (Su";
Debug.ShouldStop(33554432);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","complete", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "activity_create"), _createtableaccountexpense());
this.state = 14;
return;
case 14:
//C
this.state = 9;
_success = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Success", _success);
;
 BA.debugLineNum = 59;BA.debugLine="If Success Then";
Debug.ShouldStop(67108864);
if (true) break;

case 9:
//if
this.state = 12;
if (_success.<Boolean>get().booleanValue()) { 
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
 BA.debugLineNum = 63;BA.debugLine="Activity.LoadLayout(\"Main\")";
Debug.ShouldStop(1073741824);
parent.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Main")),main.mostCurrent.activityBA);
 BA.debugLineNum = 64;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
if (true) break;

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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,70);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 70;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(32);
 BA.debugLineNum = 72;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,66);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 66;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(2);
 BA.debugLineNum = 68;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _createtableaccountexpense() throws Exception{
try {
		Debug.PushSubsStack("createTableAccountExpense (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,90);
if (RapidSub.canDelegate("createtableaccountexpense")) { return b4a.example.main.remoteMe.runUserSub(false, "main","createtableaccountexpense");}
ResumableSub_createTableAccountExpense rsub = new ResumableSub_createTableAccountExpense(null);
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
public static class ResumableSub_createTableAccountExpense extends BA.ResumableSub {
public ResumableSub_createTableAccountExpense(b4a.example.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.main parent;
RemoteObject _query = RemoteObject.createImmutable("");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("createTableAccountExpense (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,90);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
{
parent.mostCurrent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,RemoteObject.createImmutable(null));return;}
case 0:
//C
this.state = -1;
 BA.debugLineNum = 92;BA.debugLine="Dim query As String = $\" 		CREATE TABLE IF NOT EX";
Debug.ShouldStop(134217728);
_query = (RemoteObject.concat(RemoteObject.createImmutable("\n"),RemoteObject.createImmutable("		CREATE TABLE IF NOT EXISTS accounts_expense (\n"),RemoteObject.createImmutable("			expenseID INTEGER PRIMARY KEY AUTOINCREMENT, \n"),RemoteObject.createImmutable("			account_id REAL, \n"),RemoteObject.createImmutable("			expense_amount TEXT, \n"),RemoteObject.createImmutable("			purpose TEXT, \n"),RemoteObject.createImmutable("			FOREIGN KEY(account_id) REFERENCES accounts(accountID)\n"),RemoteObject.createImmutable("		)")));Debug.locals.put("query", _query);Debug.locals.put("query", _query);
 BA.debugLineNum = 101;BA.debugLine="sql.ExecNonQuery(query)";
Debug.ShouldStop(16);
parent._sql.runVoidMethod ("ExecNonQuery",(Object)(_query));
 BA.debugLineNum = 103;BA.debugLine="Return True";
Debug.ShouldStop(64);
Debug.CheckDeviceExceptions();if (true) {
parent.mostCurrent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,(parent.mostCurrent.__c.getField(true,"True")));return;};
 BA.debugLineNum = 104;BA.debugLine="End Sub";
Debug.ShouldStop(128);
if (true) break;

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
public static RemoteObject  _createtableaccounts() throws Exception{
try {
		Debug.PushSubsStack("createTableAccounts (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,74);
if (RapidSub.canDelegate("createtableaccounts")) { return b4a.example.main.remoteMe.runUserSub(false, "main","createtableaccounts");}
ResumableSub_createTableAccounts rsub = new ResumableSub_createTableAccounts(null);
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
public static class ResumableSub_createTableAccounts extends BA.ResumableSub {
public ResumableSub_createTableAccounts(b4a.example.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.main parent;
RemoteObject _query = RemoteObject.createImmutable("");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("createTableAccounts (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,74);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
{
parent.mostCurrent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,RemoteObject.createImmutable(null));return;}
case 0:
//C
this.state = -1;
 BA.debugLineNum = 76;BA.debugLine="Dim query As String = $\" 		CREATE TABLE IF NOT EX";
Debug.ShouldStop(2048);
_query = (RemoteObject.concat(RemoteObject.createImmutable("\n"),RemoteObject.createImmutable("		CREATE TABLE IF NOT EXISTS accounts (\n"),RemoteObject.createImmutable("			accountID INTEGER PRIMARY KEY AUTOINCREMENT, \n"),RemoteObject.createImmutable("			name TEXT, \n"),RemoteObject.createImmutable("			email TEXT, \n"),RemoteObject.createImmutable("			password TEXT, \n"),RemoteObject.createImmutable("			balance REAL DEFAULT 0.00\n"),RemoteObject.createImmutable("		)")));Debug.locals.put("query", _query);Debug.locals.put("query", _query);
 BA.debugLineNum = 85;BA.debugLine="sql.ExecNonQuery(query)";
Debug.ShouldStop(1048576);
parent._sql.runVoidMethod ("ExecNonQuery",(Object)(_query));
 BA.debugLineNum = 87;BA.debugLine="Return True";
Debug.ShouldStop(4194304);
Debug.CheckDeviceExceptions();if (true) {
parent.mostCurrent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,(parent.mostCurrent.__c.getField(true,"True")));return;};
 BA.debugLineNum = 88;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
if (true) break;

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
public static RemoteObject  _droptable() throws Exception{
try {
		Debug.PushSubsStack("dropTable (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,106);
if (RapidSub.canDelegate("droptable")) { return b4a.example.main.remoteMe.runUserSub(false, "main","droptable");}
ResumableSub_dropTable rsub = new ResumableSub_dropTable(null);
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
public static class ResumableSub_dropTable extends BA.ResumableSub {
public ResumableSub_dropTable(b4a.example.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.main parent;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("dropTable (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,106);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
{
parent.mostCurrent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,RemoteObject.createImmutable(null));return;}
case 0:
//C
this.state = -1;
 BA.debugLineNum = 107;BA.debugLine="sql.ExecNonQuery(\"DROP TABLE accounts\")";
Debug.ShouldStop(1024);
parent._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("DROP TABLE accounts")));
 BA.debugLineNum = 108;BA.debugLine="Return True";
Debug.ShouldStop(2048);
Debug.CheckDeviceExceptions();if (true) {
parent.mostCurrent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,(parent.mostCurrent.__c.getField(true,"True")));return;};
 BA.debugLineNum = 109;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
if (true) break;

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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 24;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 26;BA.debugLine="Private Password As B4XFloatTextField";
main.mostCurrent._password = RemoteObject.createNew ("b4a.example.b4xfloattextfield");
 //BA.debugLineNum = 27;BA.debugLine="Private Email As B4XFloatTextField";
main.mostCurrent._email = RemoteObject.createNew ("b4a.example.b4xfloattextfield");
 //BA.debugLineNum = 29;BA.debugLine="Dim UserName As String";
main.mostCurrent._username = RemoteObject.createImmutable("");
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _login() throws Exception{
try {
		Debug.PushSubsStack("Login (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,116);
if (RapidSub.canDelegate("login")) { return b4a.example.main.remoteMe.runUserSub(false, "main","login");}
ResumableSub_Login rsub = new ResumableSub_Login(null);
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
public static class ResumableSub_Login extends BA.ResumableSub {
public ResumableSub_Login(b4a.example.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.main parent;
RemoteObject _result = RemoteObject.createImmutable(false);
RemoteObject _query = RemoteObject.createImmutable("");
RemoteObject _rs = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
int _i = 0;
int step9;
int limit9;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("Login (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,116);
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
 BA.debugLineNum = 117;BA.debugLine="Dim result As Boolean";
Debug.ShouldStop(1048576);
_result = RemoteObject.createImmutable(false);Debug.locals.put("result", _result);
 BA.debugLineNum = 119;BA.debugLine="Try";
Debug.ShouldStop(4194304);
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
 BA.debugLineNum = 120;BA.debugLine="Dim query As String = $\"SELECT * FROM accounts W";
Debug.ShouldStop(8388608);
_query = (RemoteObject.createImmutable("SELECT * FROM accounts WHERE email=? AND password=?"));Debug.locals.put("query", _query);Debug.locals.put("query", _query);
 BA.debugLineNum = 121;BA.debugLine="Dim rs As ResultSet = sql.ExecQuery2(query, Arra";
Debug.ShouldStop(16777216);
_rs = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
_rs = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), parent._sql.runMethod(false,"ExecQuery2",(Object)(_query),(Object)(RemoteObject.createNewArray("String",new int[] {2},new Object[] {parent.mostCurrent._email.runClassMethod (b4a.example.b4xfloattextfield.class, "_gettext" /*RemoteObject*/ ),parent.mostCurrent._password.runClassMethod (b4a.example.b4xfloattextfield.class, "_gettext" /*RemoteObject*/ )}))));Debug.locals.put("rs", _rs);Debug.locals.put("rs", _rs);
 BA.debugLineNum = 123;BA.debugLine="If rs.NextRow Then";
Debug.ShouldStop(67108864);
if (true) break;

case 4:
//if
this.state = 13;
if (_rs.runMethod(true,"NextRow").<Boolean>get().booleanValue()) { 
this.state = 6;
}else {
this.state = 12;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 124;BA.debugLine="Log(\"Email: \" & rs.GetString(\"email\"))";
Debug.ShouldStop(134217728);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","4589832",RemoteObject.concat(RemoteObject.createImmutable("Email: "),_rs.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("email")))),0);
 BA.debugLineNum = 125;BA.debugLine="Log(\"Password: \" & rs.GetString(\"password\"))";
Debug.ShouldStop(268435456);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","4589833",RemoteObject.concat(RemoteObject.createImmutable("Password: "),_rs.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("password")))),0);
 BA.debugLineNum = 127;BA.debugLine="Cursor = sql.ExecQuery(\"SELECT * FROM accounts\"";
Debug.ShouldStop(1073741824);
parent._cursor = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), parent._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM accounts"))));
 BA.debugLineNum = 128;BA.debugLine="For i = 0 To Cursor.RowCount - 1";
Debug.ShouldStop(-2147483648);
if (true) break;

case 7:
//for
this.state = 10;
step9 = 1;
limit9 = RemoteObject.solve(new RemoteObject[] {parent._cursor.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
Debug.locals.put("i", _i);
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
Debug.locals.put("i", _i);
if (true) break;

case 9:
//C
this.state = 18;
 BA.debugLineNum = 129;BA.debugLine="Cursor.Position = i";
Debug.ShouldStop(1);
parent._cursor.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 131;BA.debugLine="Log($\"name: ${Cursor.GetString(\"name\")} \"$)";
Debug.ShouldStop(4);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","4589839",(RemoteObject.concat(RemoteObject.createImmutable("name: "),parent.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((parent._cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("name")))))),RemoteObject.createImmutable(" "))),0);
 BA.debugLineNum = 132;BA.debugLine="Log($\"emali: ${Cursor.GetString(\"email\")} \"$)";
Debug.ShouldStop(8);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","4589840",(RemoteObject.concat(RemoteObject.createImmutable("emali: "),parent.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((parent._cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("email")))))),RemoteObject.createImmutable(" "))),0);
 BA.debugLineNum = 133;BA.debugLine="Log($\"password: ${Cursor.GetString(\"password\")";
Debug.ShouldStop(16);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","4589841",(RemoteObject.concat(RemoteObject.createImmutable("password: "),parent.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((parent._cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("password")))))),RemoteObject.createImmutable(" "))),0);
 BA.debugLineNum = 134;BA.debugLine="Log($\"accountID: ${Cursor.GetString(\"accountID";
Debug.ShouldStop(32);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","4589842",(RemoteObject.concat(RemoteObject.createImmutable("accountID: "),parent.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((parent._cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("accountID")))))),RemoteObject.createImmutable(" "))),0);
 BA.debugLineNum = 135;BA.debugLine="Log($\"balance: ${Cursor.GetString(\"balance\")}";
Debug.ShouldStop(64);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","4589843",(RemoteObject.concat(RemoteObject.createImmutable("balance: "),parent.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((parent._cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("balance")))))),RemoteObject.createImmutable(" "))),0);
 if (true) break;
if (true) break;

case 10:
//C
this.state = 13;
Debug.locals.put("i", _i);
;
 BA.debugLineNum = 138;BA.debugLine="UserName = rs.GetString(\"name\")";
Debug.ShouldStop(512);
parent.mostCurrent._username = _rs.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("name")));
 BA.debugLineNum = 139;BA.debugLine="Dashboard.ProfileName = UserName";
Debug.ShouldStop(1024);
parent.mostCurrent._dashboard._profilename /*RemoteObject*/  = parent.mostCurrent._username;
 BA.debugLineNum = 140;BA.debugLine="account_id = rs.GetString(\"accountID\")";
Debug.ShouldStop(2048);
parent._account_id = BA.numberCast(int.class, _rs.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("accountID"))));
 BA.debugLineNum = 141;BA.debugLine="Dashboard.user_balance = rs.GetString(\"balance\"";
Debug.ShouldStop(4096);
parent.mostCurrent._dashboard._user_balance /*RemoteObject*/  = BA.numberCast(double.class, _rs.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("balance"))));
 BA.debugLineNum = 142;BA.debugLine="StartActivity(Dashboard)";
Debug.ShouldStop(8192);
parent.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((parent.mostCurrent._dashboard.getObject())));
 BA.debugLineNum = 143;BA.debugLine="result = True";
Debug.ShouldStop(16384);
_result = parent.mostCurrent.__c.getField(true,"True");Debug.locals.put("result", _result);
 if (true) break;

case 12:
//C
this.state = 13;
 BA.debugLineNum = 145;BA.debugLine="xui.MsgboxAsync(\"Invalid username and password";
Debug.ShouldStop(65536);
parent._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence("Invalid username and password")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable(""))));
 BA.debugLineNum = 146;BA.debugLine="Email.Text = \"\"";
Debug.ShouldStop(131072);
parent.mostCurrent._email.runClassMethod (b4a.example.b4xfloattextfield.class, "_settext" /*RemoteObject*/ ,BA.ObjectToString(""));
 BA.debugLineNum = 147;BA.debugLine="Password.Text = \"\"";
Debug.ShouldStop(262144);
parent.mostCurrent._password.runClassMethod (b4a.example.b4xfloattextfield.class, "_settext" /*RemoteObject*/ ,BA.ObjectToString(""));
 BA.debugLineNum = 148;BA.debugLine="Email.RequestFocusAndShowKeyboard";
Debug.ShouldStop(524288);
parent.mostCurrent._email.runClassMethod (b4a.example.b4xfloattextfield.class, "_requestfocusandshowkeyboard" /*RemoteObject*/ );
 BA.debugLineNum = 149;BA.debugLine="result = False";
Debug.ShouldStop(1048576);
_result = parent.mostCurrent.__c.getField(true,"False");Debug.locals.put("result", _result);
 if (true) break;

case 13:
//C
this.state = 16;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 15:
//C
this.state = 16;
this.catchState = 0;
 BA.debugLineNum = 152;BA.debugLine="Log(LastException)";
Debug.ShouldStop(8388608);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","4589860",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 BA.debugLineNum = 153;BA.debugLine="xui.MsgboxAsync(LastException, \"Error\")";
Debug.ShouldStop(16777216);
parent._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).getObject())),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 BA.debugLineNum = 154;BA.debugLine="result = False";
Debug.ShouldStop(33554432);
_result = parent.mostCurrent.__c.getField(true,"False");Debug.locals.put("result", _result);
 if (true) break;
if (true) break;

case 16:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 157;BA.debugLine="Return result";
Debug.ShouldStop(268435456);
Debug.CheckDeviceExceptions();if (true) {
parent.mostCurrent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,(_result));return;};
 BA.debugLineNum = 158;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e0.toString());}
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
public static void  _loginbutton_click() throws Exception{
try {
		Debug.PushSubsStack("LoginButton_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,160);
if (RapidSub.canDelegate("loginbutton_click")) { b4a.example.main.remoteMe.runUserSub(false, "main","loginbutton_click"); return;}
ResumableSub_LoginButton_Click rsub = new ResumableSub_LoginButton_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_LoginButton_Click extends BA.ResumableSub {
public ResumableSub_LoginButton_Click(b4a.example.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.main parent;
RemoteObject _success = RemoteObject.createImmutable(false);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("LoginButton_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,160);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 162;BA.debugLine="If Email.Text = \"\" Then";
Debug.ShouldStop(2);
if (true) break;

case 1:
//if
this.state = 4;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._email.runClassMethod (b4a.example.b4xfloattextfield.class, "_gettext" /*RemoteObject*/ ),BA.ObjectToString(""))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 163;BA.debugLine="xui.MsgboxAsync(\"Email required\", \"\")";
Debug.ShouldStop(4);
parent._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence("Email required")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable(""))));
 BA.debugLineNum = 164;BA.debugLine="Email.RequestFocusAndShowKeyboard";
Debug.ShouldStop(8);
parent.mostCurrent._email.runClassMethod (b4a.example.b4xfloattextfield.class, "_requestfocusandshowkeyboard" /*RemoteObject*/ );
 BA.debugLineNum = 165;BA.debugLine="Return";
Debug.ShouldStop(16);
Debug.CheckDeviceExceptions();if (true) return ;
 if (true) break;
;
 BA.debugLineNum = 168;BA.debugLine="If Password.Text = \"\" Then";
Debug.ShouldStop(128);

case 4:
//if
this.state = 7;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._password.runClassMethod (b4a.example.b4xfloattextfield.class, "_gettext" /*RemoteObject*/ ),BA.ObjectToString(""))) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 169;BA.debugLine="xui.MsgboxAsync(\"Password required\", \"\")";
Debug.ShouldStop(256);
parent._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence("Password required")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable(""))));
 BA.debugLineNum = 170;BA.debugLine="Password.RequestFocusAndShowKeyboard";
Debug.ShouldStop(512);
parent.mostCurrent._password.runClassMethod (b4a.example.b4xfloattextfield.class, "_requestfocusandshowkeyboard" /*RemoteObject*/ );
 BA.debugLineNum = 171;BA.debugLine="Return";
Debug.ShouldStop(1024);
Debug.CheckDeviceExceptions();if (true) return ;
 if (true) break;
;
 BA.debugLineNum = 174;BA.debugLine="Try";
Debug.ShouldStop(8192);

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
 BA.debugLineNum = 175;BA.debugLine="Wait For (Login) Complete (Success As Boolean)";
Debug.ShouldStop(16384);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","complete", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "loginbutton_click"), _login());
this.state = 17;
return;
case 17:
//C
this.state = 10;
_success = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Success", _success);
;
 BA.debugLineNum = 176;BA.debugLine="If Success Then";
Debug.ShouldStop(32768);
if (true) break;

case 10:
//if
this.state = 13;
if (_success.<Boolean>get().booleanValue()) { 
this.state = 12;
}if (true) break;

case 12:
//C
this.state = 13;
 BA.debugLineNum = 177;BA.debugLine="xui.MsgboxAsync(\"Login successfully\", \"\")";
Debug.ShouldStop(65536);
parent._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence("Login successfully")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable(""))));
 if (true) break;

case 13:
//C
this.state = 16;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 15:
//C
this.state = 16;
this.catchState = 0;
 BA.debugLineNum = 180;BA.debugLine="Log(LastException)";
Debug.ShouldStop(524288);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","4655380",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 BA.debugLineNum = 181;BA.debugLine="xui.MsgboxAsync(LastException, \"Error\")";
Debug.ShouldStop(1048576);
parent._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).getObject())),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 if (true) break;
if (true) break;

case 16:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 183;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e0.toString());}
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

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
signup_subs_0._process_globals();
dashboard_subs_0._process_globals();
starter_subs_0._process_globals();
addbalance_subs_0._process_globals();
addexpense_subs_0._process_globals();
xuiviewsutils_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
signup.myClass = BA.getDeviceClass ("b4a.example.signup");
dashboard.myClass = BA.getDeviceClass ("b4a.example.dashboard");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
addbalance.myClass = BA.getDeviceClass ("b4a.example.addbalance");
addexpense.myClass = BA.getDeviceClass ("b4a.example.addexpense");
animatedcounter.myClass = BA.getDeviceClass ("b4a.example.animatedcounter");
anotherprogressbar.myClass = BA.getDeviceClass ("b4a.example.anotherprogressbar");
b4xbreadcrumb.myClass = BA.getDeviceClass ("b4a.example.b4xbreadcrumb");
b4xcolortemplate.myClass = BA.getDeviceClass ("b4a.example.b4xcolortemplate");
b4xcombobox.myClass = BA.getDeviceClass ("b4a.example.b4xcombobox");
b4xdatetemplate.myClass = BA.getDeviceClass ("b4a.example.b4xdatetemplate");
b4xdialog.myClass = BA.getDeviceClass ("b4a.example.b4xdialog");
b4xfloattextfield.myClass = BA.getDeviceClass ("b4a.example.b4xfloattextfield");
b4ximageview.myClass = BA.getDeviceClass ("b4a.example.b4ximageview");
b4xinputtemplate.myClass = BA.getDeviceClass ("b4a.example.b4xinputtemplate");
b4xlisttemplate.myClass = BA.getDeviceClass ("b4a.example.b4xlisttemplate");
b4xloadingindicator.myClass = BA.getDeviceClass ("b4a.example.b4xloadingindicator");
b4xlongtexttemplate.myClass = BA.getDeviceClass ("b4a.example.b4xlongtexttemplate");
b4xplusminus.myClass = BA.getDeviceClass ("b4a.example.b4xplusminus");
b4xradiobutton.myClass = BA.getDeviceClass ("b4a.example.b4xradiobutton");
b4xsearchtemplate.myClass = BA.getDeviceClass ("b4a.example.b4xsearchtemplate");
b4xseekbar.myClass = BA.getDeviceClass ("b4a.example.b4xseekbar");
b4xsignaturetemplate.myClass = BA.getDeviceClass ("b4a.example.b4xsignaturetemplate");
b4xswitch.myClass = BA.getDeviceClass ("b4a.example.b4xswitch");
b4xtimedtemplate.myClass = BA.getDeviceClass ("b4a.example.b4xtimedtemplate");
madewithlove.myClass = BA.getDeviceClass ("b4a.example.madewithlove");
b4xformatter.myClass = BA.getDeviceClass ("b4a.example.b4xformatter");
roundslider.myClass = BA.getDeviceClass ("b4a.example.roundslider");
scrollinglabel.myClass = BA.getDeviceClass ("b4a.example.scrollinglabel");
swiftbutton.myClass = BA.getDeviceClass ("b4a.example.swiftbutton");
xuiviewsutils.myClass = BA.getDeviceClass ("b4a.example.xuiviewsutils");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 19;BA.debugLine="Dim sql As SQL";
main._sql = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 20;BA.debugLine="Dim Cursor As Cursor";
main._cursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Dim account_id As Int";
main._account_id = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _register_click() throws Exception{
try {
		Debug.PushSubsStack("Register_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,111);
if (RapidSub.canDelegate("register_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","register_click");}
 BA.debugLineNum = 111;BA.debugLine="Private Sub Register_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 112;BA.debugLine="StartActivity(SignUp)";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._signup.getObject())));
 BA.debugLineNum = 113;BA.debugLine="Activity.Finish";
Debug.ShouldStop(65536);
main.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 114;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}