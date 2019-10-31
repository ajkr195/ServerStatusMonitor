$(document).ready(function() {
	$('#refreshButton').click(function() {
	    location.reload();
	});
	ajaxGet();
	
	// DO GET
	function ajaxGet(){
		$.ajax({
			type : "GET",
			url : window.location + "api/server/all",
			success: function(result){
				$.each(result, function(i, server){
					
					var serverRow = '<tr>' +
										'<td>' + server.serverid + '</td>' +
										'<td><a href="'+ server.serverurl + '" target="_blank" </a>'+ server.serverurl + '</td>' +
										'<td>' + server.servername + '</td>' +
										'<td>' + server.serverauthority + '</td>' +
										'<td>' + server.serverprotocol + '</td>' +
										'<td>' + server.serverportnumber + '</td>' +
										'<td>' + server.serverportislistening + '</td>' +
										'<td>' + server.serverurlsearchtext + '</td>' +
										
									  '</tr>';
					
					$('#serverTable tbody').append(serverRow);
					
					
		        });
				$('#serverTable').DataTable({"pageLength": 7,"lengthMenu": [ [5, 7, 10, 25, 50, -1], [5, 7, 10, 25, 50, "All"] ]});
			},
			error : function(e) {
				alert("ERROR: ", e);
				console.log("ERROR: ", e);
			}
		});	
	}
})