<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<!-- Reccomendation for bootstrap is to put everything in class container -->
<div class="container">
	<h1>Your Lineup Is:</h1>
	<a href = "lineup-pitch-view" class="btn btn-success">View Lineup in Pitch Mode</a>
	<table class="table"> 
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Position</th>
				<th>Number</th>
				<th>Team</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lineup}" var = "player">
				<tr>
					<td>${player.id}</td>
					<td>${player.name}</td>
					<td>${player.position}</td>
					<td>${player.number}</td>
					<td>${player.team}</td>
					<td> <a href="update-player?id=${player.id}" class="btn btn-success">Update</a> </td>
					<td> <a href="delete-player?id=${player.id}" class="btn btn-warning">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href = "add-player" class="btn btn-success">Add Player</a>
</div>

<%@ include file="common/footer.jspf" %>