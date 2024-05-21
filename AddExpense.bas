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
	Private Cursor As Cursor
	Dim updated_balance As Double
	Dim current_balance As Double
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private InputMoney As B4XFloatTextField
	Private Purpose As B4XFloatTextField
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("AddExpense")

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Private Sub GoBack_Click
	StartActivity(Dashboard)
	Activity.Finish
End Sub

Private Sub InsertExpense As ResumableSub
	
	Dim result As Boolean
	
	If InputMoney.Text = "" Or Purpose.Text = "" Then
		xui.MsgboxAsync("Please fill the required fields","")
		Return
	End If
	
	Try
		Dim query As String = $"INSERT INTO accounts_expense (account_id, expense_amount, purpose) VALUES (?,?,?)"$
		Main.sql.ExecNonQuery2(query, Array As Object(Main.account_id, InputMoney.Text, Purpose.Text))
		result = True
	Catch
		Log(LastException)
'		xui.MsgboxAsync(LastException,"Error")
		result = False
	End Try
	
	Return result
End Sub

Private Sub AddMoney_Click
	
	Try
		Dim query As String = "SELECT * FROM accounts WHERE accountID = ?"
		Dim rs As ResultSet = Main.sql.ExecQuery2(query, Array As String(Main.account_id))
		
		If rs.NextRow Then
			
			current_balance = rs.GetString("balance")
			
			If InputMoney.Text > current_balance Then
				xui.MsgboxAsync("The amount exceeds your current balance. Please review your current balance.","")
				Return
			End If
					
		End If
		
	Catch
		Log(LastException)
		xui.MsgboxAsync(LastException,"Error")
	End Try
	
	Try
		Wait For (InsertExpense) Complete (Success As Boolean)
		If Success Then
				
			Cursor = Main.sql.ExecQuery("SELECT * FROM accounts_expense")
			For i = 0 To Cursor.RowCount - 1
				Cursor.Position = i
				'				Log(Cursor.GetString("col1"))
				Log($"expenseID: ${Cursor.GetString("expenseID")} "$)
				Log($"account_id: ${Cursor.GetString("account_id")} "$)
				Log($"expense_amount: ${Cursor.GetString("expense_amount")} "$)
				Log($"purpose: ${Cursor.GetString("purpose")} "$)
			Next
				
			Wait For (UpdateBalance) Complete (Success As Boolean)
				If Success Then
				
				Dim query As String = "SELECT * FROM accounts WHERE accountID = ?"
				Dim rs As ResultSet = Main.sql.ExecQuery2(query, Array As String(Main.account_id))
				
				If rs.NextRow Then
					
					Dashboard.user_balance = rs.GetString("balance")
					xui.MsgboxAsync("Expense successfully added. Balance updated.", "")
					StartActivity(Dashboard)
					Activity.Finish
					
				End If
			End If
			
		End If
	Catch
		Log(LastException)
'		xui.MsgboxAsync(LastException,"Error")
	End Try
End Sub

Private Sub UpdateBalance As ResumableSub
	
	Dim result As Boolean
	
	Try
		Dim query As String = $"UPDATE accounts SET balance = balance - ? WHERE accountID = ?"$
		Main.sql.ExecNonQuery2(query, Array As Object(InputMoney.Text, Main.account_id))
		result = True
	Catch
		Log(LastException)
		xui.MsgboxAsync(LastException,"Error")
		result = False
	End Try
	
	Return result
End Sub