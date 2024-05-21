B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=12.8
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

	Private xui As XUI
	Dim sql As SQL
	Dim Cursor As Cursor
	Dim account_id As Int
	
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private Password As B4XFloatTextField
	Private Email As B4XFloatTextField
	
	Dim UserName As String
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	
	If FirstTime Then
		sql.Initialize(File.DirInternal, "test.db", True)
	End If
	
	Wait For (createTableAccounts) Complete (Success As Boolean)
	If Success Then'
'		Wait For (insertData) Complete (Success As Boolean)
'		If Success Then
'			Dim Cursor As Cursor
'			Cursor = sql.ExecQuery("SELECT * FROM table1")
'			For i = 0 To Cursor.RowCount - 1
'				Cursor.Position = i
		''				Log(Cursor.GetString("col1"))
'				Log($"column1: ${Cursor.GetString("col1")} "$) 
'				Log($"column2: ${Cursor.GetString("col2")} "$)
'				Log($"column3: ${Cursor.GetString("col3")} "$)
'			Next
'		End If
	End If
	
	Wait For (createTableAccountExpense) Complete (Success As Boolean)
	If Success Then
	
	End If
	
	Activity.LoadLayout("Main")

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Public Sub createTableAccounts As ResumableSub
	
	Dim query As String = $"
		CREATE TABLE IF NOT EXISTS accounts (
			accountID INTEGER PRIMARY KEY AUTOINCREMENT, 
			name TEXT, 
			email TEXT, 
			password TEXT, 
			balance REAL DEFAULT 0.00
		)"$
	
	sql.ExecNonQuery(query)
	
	Return True
End Sub

Public Sub createTableAccountExpense As ResumableSub
	
	Dim query As String = $"
		CREATE TABLE IF NOT EXISTS accounts_expense (
			expenseID INTEGER PRIMARY KEY AUTOINCREMENT, 
			account_id REAL, 
			expense_amount TEXT, 
			purpose TEXT, 
			FOREIGN KEY(account_id) REFERENCES accounts(accountID)
		)"$
		
	sql.ExecNonQuery(query)
	
	Return True
End Sub

Public Sub dropTable As ResumableSub
	sql.ExecNonQuery("DROP TABLE accounts")
	Return True
End Sub

'Private Sub Register_Click
'	StartActivity(Sign_up)
'	Activity.Finish
'End Sub

Public Sub AccountLogin As ResumableSub
	Dim result As Boolean
	
	Try
		Dim query As String = $"SELECT * FROM accounts WHERE email=? AND password=?"$
		Dim rs As ResultSet = sql.ExecQuery2(query, Array As String(Email.Text, Password.Text))
		
		If rs.NextRow Then
			Log("Email: " & rs.GetString("email"))
			Log("Password: " & rs.GetString("password"))
			
			Cursor = sql.ExecQuery("SELECT * FROM accounts")
			For i = 0 To Cursor.RowCount - 1
				Cursor.Position = i
				'				Log(Cursor.GetString("col1"))
				Log($"name: ${Cursor.GetString("name")} "$)
				Log($"emali: ${Cursor.GetString("email")} "$)
				Log($"password: ${Cursor.GetString("password")} "$)
				Log($"accountID: ${Cursor.GetString("accountID")} "$)
				Log($"balance: ${Cursor.GetString("balance")} "$)
			Next
			
			UserName = rs.GetString("name")
			Dashboard.ProfileName = UserName
			account_id = rs.GetString("accountID")
			Dashboard.user_balance = rs.GetString("balance")
			StartActivity(Dashboard)
			result = True
		Else
				xui.MsgboxAsync("Invalid username and password", "")
				Email.Text = ""
				Password.Text = ""
				Email.RequestFocusAndShowKeyboard
				result = False
		End If
	Catch
		Log(LastException)
		xui.MsgboxAsync(LastException, "Error")
		result = False
	End Try
	
	Return result
End Sub

Private Sub LoginButton_Click
	
	If Email.Text = "" Then
		xui.MsgboxAsync("Email required", "")
		Email.RequestFocusAndShowKeyboard
		Return
	End If
	
	If Password.Text = "" Then
		xui.MsgboxAsync("Password required", "")
		Password.RequestFocusAndShowKeyboard
		Return
	End If
	
	Try
		Wait For (AccountLogin) Complete (Success As Boolean)
		If Success Then
			xui.MsgboxAsync("Login successfully", "")
		End If
	Catch
		Log(LastException)
		xui.MsgboxAsync(LastException, "Error")
	End Try
End Sub

Private Sub Register_Click
	StartActivity(SignUp)
	Activity.Finish
End Sub