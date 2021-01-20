(function(){
	"use strict";


	let bankAccountFactory = (function(){
		let accountInfoList=[];
		function createAccount(accName, deposit){
			let acc = {
				accountName : accName,
				deposit : deposit
			};
			accountInfoList.push(acc);
		}
		function retrieveAccounts(){
			let accounsStr = "";
			for(let acc of accountInfoList){
				accounsStr = accounsStr + "Account name:" + acc.accountName + "\t Balance:" + acc.deposit + "\n";
			}
			return accounsStr;
		}
		return {createAccount: createAccount,
				retrieveAccounts: retrieveAccounts};
	})();


	window.onload = function(){
		document.getElementById("newAccount").onclick = createNewAccount;
	}

	function createNewAccount(){
		let accName = document.getElementById("accountName").value;
		let deposit = document.getElementById("deposit").value;
		let acc = bankAccountFactory.createAccount(accName,deposit);
		document.getElementById("acccountList").value = bankAccountFactory.retrieveAccounts();
	}
})();