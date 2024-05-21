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
	Dim Cursor As Cursor
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private InputMoney As B4XFloatTextField
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("Add_Balance")

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Private Sub GoBack_Click
	StartActivity(Dashboard)
	Activity.Finish
End Sub

Private Sub UpdateBalance As ResumableSub
	
	Dim result As Boolean
	
	If InputMoney.Text = "" Then
		xui.MsgboxAsync("Please fill the required field","")
		Return
	End If
	
	Try
		Dim query As String = $"UPDATE accounts SET balance = balance + ? WHERE accountID = ?"$
		
		Main.sql.ExecNonQuery2(query, Array As Object(InputMoney.Text, Main.account_id))
		
		result = True
	Catch
		Log(LastException)
		xui.MsgboxAsync(LastException,"Error")
		result = False
	End Try
	
	Return result
End Sub

Private Sub AddMoney_Click
	Try
		Wait For (UpdateBalance) Complete (Success As Boolean)
		If Success Then
			
			Dim query As String = "SELECT * FROM accounts WHERE accountID = ?"
			
			Dim rs As ResultSet = Main.sql.ExecQuery2(query, Array As String(Main.account_id))
		
			If rs.NextRow Then
				xui.MsgboxAsync("Balance updated", "")
				Dashboard.user_balance = rs.GetString("balance")
				StartActivity(Dashboard)
				Activity.Finish
			End If
			
		End If
	Catch
		Log(LastException)
'		xui.MsgboxAsync(LastException,"Error")
	End Try
End Sub