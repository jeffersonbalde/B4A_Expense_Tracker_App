
package b4a.example;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class dashboard implements IRemote{
	public static dashboard mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public dashboard() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("dashboard"), "b4a.example.dashboard");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, dashboard.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _profilename = RemoteObject.createImmutable("");
public static RemoteObject _user_balance = RemoteObject.createImmutable(0);
public static RemoteObject _cursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
public static RemoteObject _result = RemoteObject.createImmutable(false);
public static RemoteObject _nameofuser = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _currentmoney = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _listview1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _dateutils = RemoteObject.declareNull("b4a.example.dateutils");
public static b4a.example.main _main = null;
public static b4a.example.signup _signup = null;
public static b4a.example.starter _starter = null;
public static b4a.example.addbalance _addbalance = null;
public static b4a.example.addexpense _addexpense = null;
public static b4a.example.xuiviewsutils _xuiviewsutils = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",dashboard.mostCurrent._activity,"AddBalance",Debug.moduleToString(b4a.example.addbalance.class),"AddExpense",Debug.moduleToString(b4a.example.addexpense.class),"CurrentMoney",dashboard.mostCurrent._currentmoney,"Cursor",dashboard._cursor,"DateUtils",dashboard.mostCurrent._dateutils,"ListView1",dashboard.mostCurrent._listview1,"Main",Debug.moduleToString(b4a.example.main.class),"NameOfUser",dashboard.mostCurrent._nameofuser,"ProfileName",dashboard._profilename,"result",dashboard._result,"SignUp",Debug.moduleToString(b4a.example.signup.class),"Starter",Debug.moduleToString(b4a.example.starter.class),"user_balance",dashboard._user_balance,"XUIViewsUtils",Debug.moduleToString(b4a.example.xuiviewsutils.class)};
}
}