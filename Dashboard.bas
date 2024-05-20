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
	Dim ProfileName As String
	Dim user_balance As Double
	
	Private Cursor As Cursor
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Dim result As Boolean
	
	Dim Cursor As Cursor
	Private NameOfUser As Label
	Private CurrentMoney As Label
	Private ListView1 As ListView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("Dashboard")
	
	NameOfUser.Text = ProfileName
	CurrentMoney.Text = user_balance
	
	ListView1.TwoLinesLayout.Label.TextColor = Colors.Black
	ListView1.TwoLinesLayout.Label.TextSize = 30
	ListView1.TwoLinesLayout.SecondLabel.TextColor = Colors.Black
	ListView1.TwoLinesLayout.Label.TextSize = 28
	
	ShowExpense
		
'	Try
'		
'		Cursor = Main.sql.ExecQuery("SELECT * FROM accounts")
'		For i = 0 To Cursor.RowCount - 1
'			Cursor.Position = i
''           Log(Cursor.GetString("col1"))
''			Log($"name: ${Cursor.GetString("name")} "$)
''			Log($"emali: ${Cursor.GetString("email")} "$)
''			Log($"password: ${Cursor.GetString("password")} "$)
''			Label2.Text = Label2.Text & CRLF & Cursor.GetString("name")
'		Next
'		
'	Catch
'		Log(LastException)
'	End Try
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Private Sub AddCash_Click
	StartActivity(AddBalance)
	Activity.Finish
End Sub

Private Sub Logout_Click
	StartActivity(Main)
	Activity.Finish
End Sub

Private Sub AddMoney_Click
	StartActivity(AddExpense)
	Activity.Finish
End Sub

Private Sub ShowExpense
	
	ListView1.Clear
	Cursor = Main.sql.ExecQuery("SELECT * FROM accounts_expense")
	For i = 0 To Cursor.RowCount - 1
		Cursor.Position = i
		ListView1.AddTwoLines(Cursor.GetString("expense_amount"), Cursor.GetString("purpose"))
	Next
	
'	Dim Cursor As Cursor
'	Cursor = SQL1.ExecQuery("SELECT col1, col2 FROM table1")
'	For i = 0 To Cursor.RowCount - 1
'		Cursor.Position = i
'		Log(Cursor.GetString("col1"))
'		Log(Cursor.GetInt("col2"))
'	Next
End Sub